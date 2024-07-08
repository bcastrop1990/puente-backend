package pe.gob.senasa.tupa.cis;


import com.stellent.cis.ICISApplication;
import com.stellent.cis.client.api.scs.ISCSContent;
import com.stellent.cis.client.api.scs.ISCSContentID;
import com.stellent.cis.client.api.scs.context.ISCSContext;
import com.stellent.cis.client.api.scs.document.ISCSDocumentActionResponse;
import com.stellent.cis.client.api.scs.document.checkin.ISCSDocumentCheckinAPI;
import com.stellent.cis.client.api.scs.document.checkin.ISCSDocumentCheckinResponse;
import com.stellent.cis.client.api.scs.document.checkout.ISCSDocumentCheckoutAPI;
import com.stellent.cis.client.api.scs.document.information.ISCSDocumentInformationAPI;
import com.stellent.cis.client.api.scs.document.information.ISCSDocumentInformationResponse;
import com.stellent.cis.client.api.scs.file.ISCSFileAPI;
import com.stellent.cis.client.api.scs.search.ISCSSearchAPI;
import com.stellent.cis.client.api.scs.search.ISCSSearchResponse;
import com.stellent.cis.client.api.scs.search.ISCSSearchResult;
import com.stellent.cis.client.command.CommandException;
import com.stellent.cis.client.io.ICISTransferStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.Propiedad;


public class UCMClient {
    
  protected static Logger logger               = Logger.getLogger(UCMClient.class);
  public static ICISApplication aplicacion;
  public String PATH_FILES           = System.getProperty("java.io.tmpdir");
  private static String USER_NAME_UCM        = "sysadmin";
  
  public  static ICISApplication initAppliaction()  {
        CisClient cisClient= new CisClient();      
        aplicacion = cisClient.incializarAplicacion();          
        return aplicacion;
  }
    
    
  public UCMClient() {
        super();
        
  }
  
  
  public String generarNombreArchivo(String nombreArchivo)
  {
    String temp=null;    
    int indice3 = nombreArchivo.lastIndexOf(".");
    //long valor = System.currentTimeMillis();    
   // UUID     
    UUID idOne = UUID.randomUUID();    
   // System.out.println(idOne.toString());
    
    temp=nombreArchivo.substring(0, indice3)+"_"+idOne.getMostSignificantBits()+nombreArchivo.substring(indice3);    
   // System.out.println("temp--->"+temp);        
    return temp;
  }
  
 /* public static void obtenerFirmasSellos(String[][] lista)
  {
      if(lista==null || lista.length==0) return;
      
      for(int i=0 ;i<lista.length;i++){
          lista[i][2]=obtenerPlantilla(lista[i][0]+"-"+lista[i][1]);
      }             
  } */
  
 public String testAppUCMCLIENT(String nombreplantilla)
 {    
     logger.debug("nombreplantilla: "+nombreplantilla);     
     aplicacion= initAppliaction();
   logger.debug("nombreplantilla: "+nombreplantilla);  
    String nombreArchivo = PATH_FILES + obtenerPlantilla("","nombreplantilla");
   logger.debug("nombreArchivo: "+nombreArchivo);  
   return nombreArchivo;
     
 }
 
 public String obtenerDocumentoIDPorTitulo(String txId, String titulo) {
   logger.debug(txId+" obtenerDocumentoIDPorTitulo nombre recibido:"+titulo);
   aplicacion = initAppliaction();
   String dDocName="";
   
     try {
        
       logger.info(txId+"obtenerPlantilla - Estableciendo el contexto");
        ISCSContext contexto = aplicacion.getUCPMAPI().getActiveAPI()._createSCSContext();
        contexto.setUser(USER_NAME_UCM);

       logger.info(txId+"obtenerPlantilla - instanciando API para el documento ucm");
       ISCSSearchAPI searchAPI = aplicacion.getUCPMAPI().getActiveAPI().getSearchAPI();
       ISCSSearchResponse searchResponse = searchAPI.search(contexto, "dDocTitle <matches> `" + titulo + "`", 25);
         
       Iterator it = searchResponse.getResults ().iterator ();
       List<ISCSSearchResult> results = null;
       if(!searchResponse.getResults().isEmpty()) {
         logger.info(txId+"encontro documento - ISCSSearch API");
         results = searchResponse.getResults();
         ISCSSearchResult searchResult = results.get(0);
         dDocName = searchResult.getContentID().getContentID();
         System.out.println(searchResult.getTitle());
         System.out.println(dDocName);
         return dDocName;
       }       
     } catch (CommandException e) {
       e.printStackTrace();
     }
    return dDocName;
 }
 
  public String obtenerPlantilla(String txId ,String dDocname)
  {    
      logger.debug(txId+" ObtenerPlantilla nombre recibido:"+dDocname);
      
      aplicacion= initAppliaction();
      
      //Declaramos las variable que vamos a utilizar en el m�todo
      
      File archivo             = null;
      FileOutputStream  stream = null;
      String   nombreArchivo   = null;
      InputStream inputStream  = null;

      try {
  
          //creamos la clase para el identificador de contenido o dDocName y su Metodo de seleccion de revision (indispensable si no se tiene el dID)
          logger.info(txId+"obtenerPlantilla - Creando la clase para el identificador del contenido");
          ISCSContentID contentId =(ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
          contentId.setContentID(dDocname);
          contentId.setRevisionSelectionMethod("Latest");//

          //Establecemos el contexto para la sesion actual, con el nombre de usuario
          logger.info(txId+"obtenerPlantilla - Estableciendo el contexto");
          ISCSContext contexto =aplicacion.getUCPMAPI().getActiveAPI()._createSCSContext();
          contexto.setIdcUser(USER_NAME_UCM);

          //creamos la clase para obtener el archivo del documento de ucm
          logger.info(txId+"obtenerPlantilla - instanciando API para el documento ucm");
          ISCSFileAPI fileAPI;
          fileAPI = aplicacion.getUCPMAPI().getActiveAPI().getFileAPI();
          ICISTransferStream transferStream;

          //Obtenemos la plantilla desde ucm
          logger.info(txId+"obtenerPlantilla - getFile API");
          transferStream = fileAPI.getFile(contexto, contentId);
          logger.info(txId+"obtenerPlantilla - API obtenida");
          inputStream = transferStream.getInputStream();

          //vemos la longitud de bytes del archivo
          Long longitud = transferStream.getContentLength();

          //instanciamos un nuevo archivo donde guardar la informacion
          logger.info(txId+"generar el nombre del archivo");
          int indiceExt = transferStream.getFileName().lastIndexOf(".");
          String tempFileName = dDocname + transferStream.getFileName().substring(indiceExt);
          archivo = new File(PATH_FILES + generarNombreArchivo(tempFileName));
          
          logger.info(txId+"obtenerPlantilla - archivo.getName() temporal de ejecucion:"+archivo.getName());
  
          //instanciamos un flujo de escritura en el archivo
          stream = new FileOutputStream(archivo);
          logger.info(txId+"obtenerPlantilla - longitud.intValue() "+longitud.intValue());
          //instanciamos un arreglo de bytes para la escritura
          byte[] arreglo = new byte[longitud.intValue()];

          logger.info(txId+"obtenerPlantilla - leemos el stream de ucm y almacenamos en el arreglo de bytes ");
          //leemos el stream de ucm y almacenamos en el arreglo de bytes
          inputStream.read(arreglo);

          //conel flujo de escritura escribimos en el archivo
          logger.info(txId+"obtenerPlantilla - escribimos en el archivo");
          stream.write(arreglo);
         
          //retornamos el nombre del archivo para los otros metodos a utilizar
          nombreArchivo = archivo.getName().replace(' ', '_');
          logger.info(txId+"obtenerPlantilla , se bajo la plantilla de UCM con �xito- nombreArchivo==>"+nombreArchivo);
      } catch (CommandException e){
          logger.error(txId+"Error CommandException:"+e.getMessage());
          e.printStackTrace(); 
          nombreArchivo = null;
      }catch (IOException e) {
          logger.error(txId+"Error IOException:"+e.getMessage());
          e.printStackTrace();
          nombreArchivo = null;
      }finally {
          if(stream!=null){
            try{
              stream.flush();
              stream.close();
            }catch(Exception e){
                e.printStackTrace();
            }
          }
          try{
            if(inputStream!=null)
            {
              inputStream.close();    
            }
          }catch(Exception e)
          {
            e.printStackTrace();
          }
      }
      
      return nombreArchivo;  
  }  
  
  
    public String establecerIngresoUCM(String txId,String nombreArchivo,Hashtable propiedades,boolean borrarArchivo, String ucmid) throws MalformedURLException,CommandException,IOException {

      // verificamos que los metadatos estes llenos o que la cantidad de metadatos sean mayores a 3
      
      if(propiedades==null || propiedades.size()<3 ) return null;
      
      aplicacion= initAppliaction();
      ////
      ISCSContentID contentId = null;
      if(ucmid != null ){
      
        contentId = (ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
        contentId.setContentID(ucmid);
        contentId.setRevisionSelectionMethod(ISCSContentID.REVISION_LATEST);
      
      }
      ///

      //Declaramos las variable que vamos a utilizar en el m�todo
      File archivo = new File(nombreArchivo);      
      logger.info(txId+"nombreArchivo:"+archivo.getName());      
      if(archivo.exists()==false){
        logger.fatal(txId+"El archivo "+archivo.getName()+" no existe verifi que la ruta y ubicacion del mismo");
        return null;
      }

      //Establecemos el contexto para la sesion actual, con el nombre de usuario
      ISCSContext contexto =aplicacion.getUCPMAPI().getActiveAPI()._createSCSContext();     
      contexto.setIdcUser(USER_NAME_UCM);

//////
      
      ISCSContentID ax = null;
      if(ucmid != null && !ucmid.trim().isEmpty()){
      	ISCSDocumentCheckoutAPI checkout = aplicacion.getUCPMAPI().getActiveAPI().getDocumentCheckoutAPI();
        try {
            ISCSDocumentActionResponse docResponse = checkout.checkoutFileByName(contexto, contentId);
            ax = docResponse.getContent().getContentID();
        } catch (CommandException e) {
            e.printStackTrace();
            checkout.undoCheckoutFileByName(contexto, contentId);
            throw e;
        }
      }
      
//////


      //Creamos el objeto de ContentID y establecemos los metadatos de ingreso del documento
     // ISCSContentID contentId              = (ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
      ISCSDocumentCheckinAPI checkin       = aplicacion.getUCPMAPI().getActiveAPI().getDocumentCheckinAPI();
      ISCSDocumentCheckinResponse response = (ISCSDocumentCheckinResponse)aplicacion.getUCPMAPI().createObject(ISCSDocumentCheckinResponse.class);
      ISCSContent contenido                = (ISCSContent)aplicacion.getUCPMAPI().createObject(ISCSContent.class);
      if(ax != null ) contenido.setContentID(ax);
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
      Enumeration e= propiedades.keys();  
      
      while(e.hasMoreElements()){
          nNombreMetadato = (String) e.nextElement();
          valorMetadato   = (String) propiedades.get(nNombreMetadato);             
          
          logger.info(txId+"nNombreMetadato:"+nNombreMetadato+", valorMetadato:" + valorMetadato);
          if(nNombreMetadato.equals("xPlazo") || nNombreMetadato.equals("xDerivados") || nNombreMetadato.equals("xProveido")) {
            valorMetadato = valorMetadato.substring(1,1000);
            logger.info(txId+"nNombreMetadato:"+nNombreMetadato+", nuevoValorMetadato:" + valorMetadato);
          }
          contenido.setProperty(nNombreMetadato, valorMetadato);
          if (nNombreMetadato.equals("xAuthor"))
              contenido.setAuthor(valorMetadato);
          if (nNombreMetadato.equals("xSecurityAccount"))
              contenido.setSecurityAccount(valorMetadato);
      }

      //Realizamos el checkin del documento en ucm
      ICISTransferStream transferStream = aplicacion.getUCPMAPI().createTransferStream();      
      transferStream.setFile(archivo);
      logger.info(txId+"CHECK IN - INICIO: " + archivo.getName());
      response = checkin.checkinFileStream(contexto, contenido, transferStream);
      String dDocname = response.getContent().getContentID().getContentID();      
      logger.info(txId+"CHECK IN - EJECUTADO: DDOCNAME=" + dDocname);
      try {
        if(borrarArchivo==true) archivo.delete();
      } catch (Exception ex) {
        logger.error(txId + "eliminar archivo  :" + nombreArchivo );
      }
      return dDocname;
  }  
    
  public void eliminarArchivo(String fileName) {
      File file= new File(fileName);      
      if(file.exists()) file.delete();      
  }
  
  public String ingresarDocumento(String txId, byte[] archivoBytes, Documento documento, String nombreBase){
    return ingresarDocumento(txId, archivoBytes, documento, nombreBase, null);
  }
  
    public String ingresarDocumento(String txId, byte[] archivoBytes, Documento documento, String nombreBase, String ucmid)  {
        logger.debug(txId+" ingresarDocumento inicio : ");
        File archivo             = null;
        FileOutputStream  stream = null;
        String   nombreArchivo   = null;
        String dDocname = null;
        try {
            logger.info(txId+" ingresarDocumento: generar el nombre del archivo");
            nombreArchivo = PATH_FILES + generarNombreArchivo(nombreBase);
            archivo = new File(nombreArchivo );
            logger.info(txId+" ingresarDocumento: archivo.getName() temporal de ejecucion:"+archivo.getName());
            stream = new FileOutputStream(archivo);
            logger.info(txId+" ingresarDocumento: escribimos en el archivo temporal");
            stream.write(archivoBytes);
            logger.info(txId+" ingresarDocumento: nombreArchivo guardado==>"+nombreArchivo);
        } catch (IOException e) {
            logger.error(txId+"Error IOException:"+e.getMessage());
            e.printStackTrace();
            nombreArchivo = null;
        }finally {
            if(stream!=null){
              try{
                stream.flush();
                stream.close();
              }catch(Exception e){
                  e.printStackTrace();
              }
            }
        }
        logger.info(txId+" ingresarDocumento: documento a cargar en UCM ==>"+nombreArchivo);
        if (nombreArchivo!= null && !nombreArchivo.isEmpty()) {
            dDocname = ingresarDocumento(txId,nombreArchivo,documento, ucmid);
            eliminarArchivo(nombreArchivo);
        }
        return dDocname;
    }
    
  public String ingresarDocumento(String txId,String archivoWord,Documento documento){
    return ingresarDocumento(txId,archivoWord,documento,null);     
  }
  
  public String ingresarDocumento(String txId,String archivoWord,Documento documento, String ucmid)  {
      //pendiente
    if(documento==null) return null;   
    if(documento.getMetadatos()!=null && documento.getMetadatos().size()<3){ return null;}
    
    String dDocname =null;    
    Hashtable metadatos = new Hashtable();      
    String nNombreMetadato = null;    
    String valorMetadato = null;    
    Propiedad dato =  null; 
        
    try{
        
      logger.info(txId+"Setear metadata para el Ingreso a UCM");           
      for(int i =0;i<documento.getMetadatos().size();i++) {
          dato  = documento.getMetadatos().get(i);          
          nNombreMetadato = dato.getXPropiedad();          
          valorMetadato = dato.getXValor();          
          logger.info(txId+"nNombreMetadato:"+nNombreMetadato+",valorMetadato:"+valorMetadato);          
          metadatos.put(nNombreMetadato, valorMetadato);
      }
    
      //dDocname = UCMClient.establecerIngresoUCM(archivoWord, metadatos, true);        
      dDocname = this.establecerIngresoUCM(txId,archivoWord, metadatos, true, ucmid);        
      logger.info(txId+"Nombre del dDocname :"+dDocname);
        
    }catch(Exception e)    {
      logger.error(txId+"Error en la funcion ingresarDocumento :"+e.getMessage());
      e.printStackTrace();
    }
    finally{
        
    }
    
    return dDocname;
  }
  
  public String obtenerUrl(String txId,String dDocName) {
    aplicacion= initAppliaction();
      try {
          
          logger.info(txId+"obtenerUrl - dDocName==>"+dDocName);
          //Declaramos las variable que vamos a utilizar en el m�todo
          String urlArchivo;
          //creamos el objeto para obtener la informacion del documento de ucm
          ISCSDocumentInformationAPI documentInfoAPI;
          //creamos el objeto que sera con el que vamos a averiguar la url
          documentInfoAPI =aplicacion.getUCPMAPI().getActiveAPI().getDocumentInformationAPI();
          //ISCSDocumentID docId =(ISCSDocumentID)aplicacion.getUCPMAPI().createObject(ISCSDocumentID.class);
          ISCSContentID contentId =(ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
          contentId.setContentID(dDocName);
          contentId.setRevisionSelectionMethod("Latest");
          //creamos el contexto
          ISCSContext contexto =aplicacion.getUCPMAPI().getActiveAPI()._createSCSContext();
          contexto.setUser("sysadmin");
          //hacemos la consulta y la almacenamos en un response
          ISCSDocumentInformationResponse docResponse =
              documentInfoAPI.getDocumentInformationByName(contexto,contentId);
          
        logger.info(txId+" leyendo docResponse");
          //obtenemos la info de la url del documento buscado
          urlArchivo = docResponse.getDocumentURL();
          //retornamos la url
          logger.info(txId+" urlArchivo==>"+urlArchivo);
          
          return urlArchivo;
      } catch (CommandException e) {
          logger.error(txId+"Error en la funcion obtenerUrl CommandException:"+e.getMessage());
          return null;
      } catch (Exception e) {
            logger.error(txId+"Error en la funcion obtenerUrl Exception:"+e.getMessage());
            return null;          
      }
  }
  
  // Para prueba 
  
  public static void main(String[] args) 
  {
    // String archivoWord=UCMClient.obtenerPlantilla("PLANTILLA_SPGO-RECP");
     
   //  UCMClient.generarNombreArchivo("nombredocumento.docx");
     
     
     //PLANTILLA_SOIM-SPFI
     //PLANTILLA_SPGO-RDD
     //PLANTILLA_DORI-PFIA
     
     
     /*String archivoImagen=UCMClient.obtenerPlantilla("YGONZALES-FDSE");
     
     logger.debug("Nombre del archivo word retorno:"+archivoWord);
     
     logger.debug("Nombre del archivo imagen retorno:"+archivoImagen);
     
     MsWordReplace mswrd= new MsWordReplace();
     
     mswrd.Open(UCMClient.PATH_FILES+archivoWord);
     
     mswrd.ReplaceTextByImage("firmaSello", UCMClient.PATH_FILES+archivoImagen);
     
     mswrd.Close(UCMClient.PATH_FILES+archivoWord);
     
     Hashtable metadatos = new Hashtable();
     
     metadatos.put("dDocType","DORI");
     metadatos.put("xProfileTrigger", "STD-DORI");
     metadatos.put("xNumeroExpediente","");
     metadatos.put("xSubTipo","PZIA");
     
     try{
     
     String dDocname = UCMClient.establecerIngreso(UCMClient.PATH_FILES+archivoWord, metadatos, false);
         
     logger.debug("Nombre del dDocname word UCM:"+dDocname);
         
     }catch(Exception e)
     {
         e.printStackTrace();
     }
     */
  }
  
    
}
