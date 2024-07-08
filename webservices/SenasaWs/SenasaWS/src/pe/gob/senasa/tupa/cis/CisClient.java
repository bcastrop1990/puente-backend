package pe.gob.senasa.tupa.cis;


import com.stellent.cis.ICISApplication;
import com.stellent.cis.client.api.scs.ISCSContent;
import com.stellent.cis.client.api.scs.ISCSContentID;
import com.stellent.cis.client.api.scs.ISCSDocumentID;
import com.stellent.cis.client.api.scs.context.ISCSContext;
import com.stellent.cis.client.api.scs.document.checkin.ISCSDocumentCheckinAPI;
import com.stellent.cis.client.api.scs.document.checkin.ISCSDocumentCheckinResponse;
import com.stellent.cis.client.api.scs.document.information.ISCSDocumentInformationAPI;
import com.stellent.cis.client.api.scs.document.information.ISCSDocumentInformationResponse;
import com.stellent.cis.client.api.scs.document.information.ISCSInfoContent;
import com.stellent.cis.client.api.scs.file.ISCSFileAPI;
import com.stellent.cis.client.api.scs.search.ISCSSearchQuery;
import com.stellent.cis.client.api.scs.search.ISCSSearchResponse;
import com.stellent.cis.client.api.scs.search.ISCSSearchResult;
import com.stellent.cis.client.command.CommandException;
import com.stellent.cis.client.io.ICISTransferStream;
import com.stellent.cis.impl.CISApplicationFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;

import java.util.Properties;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.Propiedad;


public class CisClient {
    
  protected static Logger logger = Logger.getLogger(CisClient.class);
  private static ICISApplication aplicacion;
    
    public CisClient() {
        super();
    }

/*
    public static void main(String[] args) throws MalformedURLException,
                                                  CommandException,
                                                  FileNotFoundException,
                                                  IOException {

        CisClient cliente = new CisClient();
       ICISApplication ica= cliente.incializarAplicacion();
      
        cliente.obtenerPlantilla("PLANTILLA_SPGO-RECP",ica);
        
        String establecerIngreso = cliente.establecerIngreso("C:/temporal/" +"Prueba_Reciboooo.docx", "C:/temporal/" +"Plantilla_Recibo-Pago_Ticketera.docx",null,"","","",ica);
        
        String obtednerUrl = cliente.obtenerUrl("pruebaRecibo",aplicacion);

    }
*/

    public ICISApplication incializarAplicacion() {
        try {
            //logger.info("Verificando si exist conección a ICISApplication");
            if(aplicacion!=null){                  
              //logger.info("Realizando la conección a ICISApplication existente");
              return aplicacion;
            }
            logger.info("Realizando la conección a ICISApplication");
            //URL xmlRes;

            //le decimos cual es el xml de propiedades adapterconfig.xml

            //Establecemos las propiedades para la sesion actual e inicializamos
            //xmlRes = new File("adapterconfig.xml").toURL();
            Properties propiedades = new Properties();
            propiedades.setProperty(ICISApplication.PROPERTY_CONFIG_TYPE,
                                    "server");
            propiedades.setProperty(ICISApplication.PROPERTY_CONFIG_SERVER_TYPE,
                                    "standalone");
            propiedades.setProperty(ICISApplication.PROPERTY_CONFIG_SERVER_TEMP_DIRECTORY,
                                    "C:/temporal/");
            propiedades.setProperty(ICISApplication.PROPERTY_CONFIG_SERVER_ADAPTER_CONFIG,
                                    "adapterconfig.xml");
            aplicacion = CISApplicationFactory.initialize(propiedades);
            return aplicacion;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
   /* -public void obtenerFirmasSellos(String[][] lista,ICISApplication aplicacion)
    {
        if(lista==null || lista.length==0) return;
        
        for(int i=0 ;i<lista.length;i++)
        {
            lista[i][2]=obtenerFirmaArchivo(lista[i][0]+"-"+lista[i][1], aplicacion);
        }
               
    } */
    

    public String obtenerPlantilla(String dDocname,
                                   ICISApplication aplicacion) {
      
      Log("dDocname recibido:"+dDocname);

        try {
            //Declaramos las variable que vamos a utilizar en el método
            File archivo;
            FileOutputStream stream;

            
            //creamos la clase para el identificador de contenido o dDocName y su Metodo de seleccion de revision (indispensable si no se tiene el dID)
            ISCSContentID contentId =
                (ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
            contentId.setContentID(dDocname);
            contentId.setRevisionSelectionMethod("Latest");

            //Establecemos el contexto para la sesion actual, con el nombre de usuario
            ISCSContext contexto =
                aplicacion.getUCPMAPI().getActiveAPI()._createSCSContext();
            contexto.setIdcUser("sysadmin");

            //creamos la clase para obtener el archivo del documento de ucm
            ISCSFileAPI fileAPI;
            fileAPI = aplicacion.getUCPMAPI().getActiveAPI().getFileAPI();
            ICISTransferStream transferStream;

            //Obtenemos la plantilla desde ucm
            transferStream = fileAPI.getFile(contexto, contentId);
            InputStream inputStream = transferStream.getInputStream();

            //vemos la longitud de bytes del archivo
            Long longitud = transferStream.getContentLength();

            //instanciamos un nuevo archivo donde guardar la informacion
            archivo = new File("C:/temporal/" + transferStream.getFileName());

            //instanciamos un flujo de escritura en el archivo
            stream = new FileOutputStream(archivo);

            //instanciamos un arreglo de bytes para la escritura
            byte[] arreglo = new byte[longitud.intValue()];

            //leemos el stream de ucm y almacenamos en el arreglo de bytes
            inputStream.read(arreglo);

            //conel flujo de escritura escribimos en el archivo
            stream.write(arreglo);
            stream.flush();
            stream.close();
            inputStream.close();
            //retornamos el nombre del archivo para los otros metodos a utilizar

            return transferStream.getFileName();
        } catch (CommandException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally
        {
            
        }

    }

    public String establecerIngreso(String nombreArchivo,
                                    String nombrePlantilla,
                                    Documento documento, String profileTrigger,
                                    String tipoDocumento,
                                    String subTipoDocumento,
                                    ICISApplication aplicacion) throws MalformedURLException,
                                                                       CommandException,
                                                                       IOException {

        // verificamos que los metadatos estes llenos o que la cantidad de metadatos sean mayores a 3
        
        logger.debug("documento.getMetadatos(): "+documento.getMetadatos().size());
        
        if(documento.getMetadatos()==null || documento.getMetadatos().size()<3 ) return null;


        //Declaramos las variable que vamos a utilizar en el método
        File archivo;
        File archivo2;

        //System.out.println(nombreArchivo);
        //System.out.println(nombrePlantilla);


        //Instanciamos los dos archivos y renombramos la plantilla por el nombre que va a ser ingresado en ucm
        logger.debug("nombrePlantilla:"+nombrePlantilla);
        
        logger.debug("nombreArchivo:"+nombreArchivo);
        
        archivo = new File(nombrePlantilla);
        archivo2 = new File(nombreArchivo);
        boolean b;
        
        b = archivo.renameTo(archivo2);

        //Establecemos el contexto para la sesion actual, con el nombre de usuario
        ISCSContext contexto =
            aplicacion.getUCPMAPI().getActiveAPI()._createSCSContext();
        contexto.setIdcUser("sysadmin");

        //Creamos el objeto de ContentID y establecemos los metadatos de ingreso del documento
        ISCSContentID contentId =
            (ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
        ISCSDocumentCheckinAPI checkin =
            aplicacion.getUCPMAPI().getActiveAPI().getDocumentCheckinAPI();
        ISCSDocumentCheckinResponse response =
            (ISCSDocumentCheckinResponse)aplicacion.getUCPMAPI().createObject(ISCSDocumentCheckinResponse.class);
        ISCSContent contenido =
            (ISCSContent)aplicacion.getUCPMAPI().createObject(ISCSContent.class);
        
        //contentId.setContentID("pruebaRecibo");
        //contenido.setContentID(contentId);
        
        
        contenido.setAuthor(contexto.getIdcUser());
        contenido.setSecurityGroup("Interno");
        contenido.setTitle("()");
        //contenido.setType("");
        contenido.setSecurityAccount("TUPA");
        //contenido.setProperty("xProfileTrigger", profileTrigger);
       // contenido.setProperty("xSubTipo", subTipoDocumento);
        
        String nNombreMetadato = null;
        
        String valorMetadato = null;
        
        Propiedad dato =  null;  
                    
        for(int i =0;i<documento.getMetadatos().size();i++)
        {
            logger.debug("Entra e ciclo");
            
            dato  = documento.getMetadatos().get(i);
            
            nNombreMetadato = dato.getXPropiedad();
            
            valorMetadato = dato.getXValor();
            
            logger.debug("nNombreMetadato:"+nNombreMetadato+",valorMetadato:"+valorMetadato);
            
            contenido.setProperty(nNombreMetadato, valorMetadato);
        }

        //Realizamos el checkin del documento en ucm
        ICISTransferStream transferStream;
        transferStream = aplicacion.getUCPMAPI().createTransferStream();
        transferStream.setFile(archivo);
        response = checkin.checkinFileStream(contexto, contenido, transferStream);
        //String mensaje = response.getMessage();
        String dDocname = response.getContent().getContentID().getContentID();
        //Borramos el archivo de la carpeta temporal
        
        archivo.delete();
        archivo2.delete();

        //se retorna el dDocName para el metodo de obtener url
        Log("dDocname:"+dDocname);
        
        return dDocname;
    }
    

    public String obtenerUrl(String dDocName, ICISApplication aplicacion) {
        try {
            //Declaramos las variable que vamos a utilizar en el método
            String urlArchivo;

            //creamos el objeto para obtener la informacion del documento de ucm
            ISCSDocumentInformationAPI documentInfoAPI;

            //creamos el objeto que sera con el que vamos a averiguar la url
            documentInfoAPI =
                    aplicacion.getUCPMAPI().getActiveAPI().getDocumentInformationAPI();
            ISCSDocumentID docId =
                (ISCSDocumentID)aplicacion.getUCPMAPI().createObject(ISCSDocumentID.class);
            ISCSContentID contentId =
                (ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
            contentId.setContentID(dDocName);
            contentId.setRevisionSelectionMethod("Latest");

            //creamos el contexto
            ISCSContext contexto =
                aplicacion.getUCPMAPI().getActiveAPI()._createSCSContext();
            contexto.setUser("sysadmin");

            //hacemos la consulta y la almacenamos en un response
            ISCSDocumentInformationResponse docResponse =
                documentInfoAPI.getDocumentInformationByName(contexto,
                                                             contentId);

            //almacenamos el resultado
            ISCSInfoContent contenido = docResponse.getDocNode();

            //obtenemos la info de la url del documento buscado
            urlArchivo = docResponse.getDocumentURL();

            //retornamos la url
            logger.info("urlArchivo:"+urlArchivo + " para dDocName: "+dDocName);
            
            return urlArchivo;
        } catch (CommandException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
              e.printStackTrace();
              return null;
        }
    }
    
    

  public byte[] obtenerFirma(String parametroBusqueda, ICISApplication aplicacion) throws CommandException {
    
    Log("parametroBusqueda recibido:"+parametroBusqueda);

      try {
          //Declaramos las variable que vamos a utilizar en el método
          File archivo;
          FileOutputStream stream;

          
          //creamos la clase para el identificador de contenido o dDocName y su Metodo de seleccion de revision (indispensable si no se tiene el dID)
          /*ISCSContentID contentId =
              (ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
          contentId.setContentID(dDocname);
          contentId.setContentID();*/
              
        // create an simple query
        ISCSSearchQuery query =
        (ISCSSearchQuery)aplicacion.getUCPMAPI().createObject (ISCSSearchQuery.class);
        query.setQueryText ("xNombreRemitenteInterno <matches> `"+parametroBusqueda+"`");
        
        ISCSContext contexto = aplicacion.getUCPMAPI().getActiveAPI()._createSCSContext();
        contexto.setUser("sysadmin");
         
          
        // execute a search
          ISCSSearchResponse response;
          response = aplicacion.getUCPMAPI ().getActiveAPI ().getSearchAPI ().search (contexto, query);
          // search results come back as a result set of ISCSSearchResult items
          ISCSSearchResult result = null;
       
            if(response.getResults().size() == 0){
                Log("No hay documentos con los criterios de busqueda definidos");
                return null;
            }
          
            ISCSContentID contentId =
            (ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
            contentId.setContentID( result.getContentID().toString());
            contentId.setRevisionSelectionMethod("Latest");
            Log("Este es el contentID "+contentId.toString());
        
        //contentId.setRevisionSelectionMethod("Latest");

        
        
        //creamos la clase para obtener el archivo del documento de ucm
        ISCSFileAPI fileAPI;
        fileAPI = aplicacion.getUCPMAPI().getActiveAPI().getFileAPI();
        ICISTransferStream transferStream;

        //Obtenemos la firma desde ucm
        transferStream = fileAPI.getFile(contexto, contentId);
        InputStream inputStream = transferStream.getInputStream();
        Long longitud = transferStream.getContentLength();
        
        byte[] arreglo = new byte[longitud.intValue()];
        inputStream.read(arreglo);
        return arreglo;
        
          
      } catch (CommandException e) {
          e.printStackTrace();
          //return null;
      } catch (IOException e) {
      } // catch (IOException e) {
         // e.printStackTrace();
          return null;
      //}
  }
  
  
  public String  obtenerFirmaArchivo(String parametroBusqueda, ICISApplication aplicacion)
  {
    
    Log("dDocname recibido:"+parametroBusqueda);

      try {
          //Declaramos las variable que vamos a utilizar en el método
          File archivo;
          FileOutputStream stream;

          
          //creamos la clase para el identificador de contenido o dDocName y su Metodo de seleccion de revision (indispensable si no se tiene el dID)
          ISCSContentID contentId =(ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
          contentId.setContentID(parametroBusqueda);
          contentId.setRevisionSelectionMethod("Latest");

          //Establecemos el contexto para la sesion actual, con el nombre de usuario
          ISCSContext contexto =
              aplicacion.getUCPMAPI().getActiveAPI()._createSCSContext();
          contexto.setIdcUser("sysadmin");

          //creamos la clase para obtener el archivo del documento de ucm
          ISCSFileAPI fileAPI;
          fileAPI = aplicacion.getUCPMAPI().getActiveAPI().getFileAPI();
          ICISTransferStream transferStream;

          //Obtenemos la plantilla desde ucm
          transferStream = fileAPI.getFile(contexto, contentId);
          InputStream inputStream = transferStream.getInputStream();

          //vemos la longitud de bytes del archivo
          Long longitud = transferStream.getContentLength();

          //instanciamos un nuevo archivo donde guardar la informacion
          archivo = new File("C:/temporal/" + transferStream.getFileName());

          //instanciamos un flujo de escritura en el archivo
          stream = new FileOutputStream(archivo);

          //instanciamos un arreglo de bytes para la escritura
          byte[] arreglo = new byte[longitud.intValue()];

          //leemos el stream de ucm y almacenamos en el arreglo de bytes
          inputStream.read(arreglo);

          //conel flujo de escritura escribimos en el archivo
          stream.write(arreglo);
          stream.flush();
          stream.close();
          inputStream.close();
          //retornamos el nombre del archivo para los otros metodos a utilizar

          return "C:/temporal/" +transferStream.getFileName();
      } catch (CommandException e) {
          e.printStackTrace();
          return null;
      } catch (IOException e) {
          e.printStackTrace();
          return null;
      }finally
      {
          
      }
  }
    
     private void Log(String s){
          logger.debug(s);
    }
     
     
     
  // Para prueba 
  public static void main(String[] args) 
  {
      CisClient ccl= new CisClient();
      
      ccl.obtenerFirmaArchivo("ECELIS-FDSE", ccl.incializarAplicacion());
   
  }
    
}