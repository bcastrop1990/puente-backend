package pe.gob.senasa.tupa;


import com.stellent.cis.client.command.CommandException;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;

import java.awt.image.RenderedImage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRProperties;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.AnexoPFI;
import pe.gob.senasa.bean.AutorizacionSanitariaEstExpoZoo;
import pe.gob.senasa.bean.CentroTramite;
import pe.gob.senasa.bean.Dato;
import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.Firmante;
import pe.gob.senasa.bean.Guardacustodia;
import pe.gob.senasa.bean.Informacion;
import pe.gob.senasa.bean.LugarProduccionProductoPFI;
import pe.gob.senasa.bean.PaisOrigenProductoPFI;
import pe.gob.senasa.bean.PermisoFitosanitarioTransitoInterno;
import pe.gob.senasa.bean.ProductoPFI;
import pe.gob.senasa.bean.ProductoPZI;
import pe.gob.senasa.bean.Propiedad;
import pe.gob.senasa.bean.PuntoIngresoProductoPFI;
import pe.gob.senasa.bean.ReciboServicio;
import pe.gob.senasa.bean.RequisitoSanitario;
import pe.gob.senasa.dao.ExportacionZooSanitariaDAO;
import pe.gob.senasa.dao.FuncionarioDAO;
import pe.gob.senasa.dao.GeneralDAO;
import pe.gob.senasa.dao.GeografiaDAO;
import pe.gob.senasa.dao.PermisoFitoSanitarioImportacionDAO;
import pe.gob.senasa.dao.RequisitoDao;
import pe.gob.senasa.dao.SolicitanteDAO;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.tupa.cis.CisClient;
import pe.gob.senasa.tupa.cis.NomenclaturaFirma;
import pe.gob.senasa.tupa.cis.UCMClient;
import pe.gob.senasa.util.Utility;
import pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_PortType;
import pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_ServiceLocator;


public class CreacionDocumentos {

    private class EstadoReemplazo {
        private String error = null;
        private Boolean estado = false;

        public void setError(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setEstado(Boolean estado) {
            this.estado = estado;
        }

        public Boolean getEstado() {
            return estado;
        }
    }

    protected static Logger logger = Logger.getLogger(CreacionDocumentos.class);
    //private ConectionApp cnApp = null;
    private DBHelper helper = null;

    //private String nombrePlantilla = "";
    //private Documento documento = null;
    private String profileTrigger = "";
    private String tipoDocumento = "";
    private String subTipoDocumento = "";
    private CisClient clienteCis = null;
    private UCMClient ucmClient = null;

    public CreacionDocumentos() {
        clienteCis = new CisClient();
        ucmClient = new UCMClient();
        //cnApp = new ConectionApp();
        helper = new DBHelper(SenasaSQL.dsDocumentos);
    }
    
  public String generarREPORTE(String txId, String nombrePlantilla,
                               Informacion informacion) {
      Connection con = null;
      try {
          con = helper.getConnection();
          Dato dato = null;
          Propiedad propiedad = null;
          if (informacion.getListaDatosRemplazar() != null &&
              informacion.getListaDatosRemplazar().size() > 0) {
              String NumeroExpediente = "";
              String NumeroDocumento = "";
              String codCentroTramite = "";
              String codServicio = "";
              String tipoInfo = "";
              String nombreBase = null;
              String servicio = null;
              String periodoCPE = "";
              String tipo = nombrePlantilla;
              if (nombrePlantilla.equals("PLANTILLA_DORI-PFI1") ||
                  nombrePlantilla.equals("PLANTILLA_DORI-PFI2") ||
                  nombrePlantilla.equals("PLANTILLA_DORI-PFI3")) {
                  nombrePlantilla = "PLANTILLA_DORI-PFI_123";
              }

              for (int i = 0;
                   i < informacion.getListaDatosRemplazar().size(); i++) {
                  dato = informacion.getListaDatosRemplazar().get(i);
                  if (dato == null) {
                      logger.info(txId +
                                  "getListaDatosRemplazar.dato = NULL");
                      continue;
                  }
                  if (dato.getEtiqueta().equalsIgnoreCase("numeroExpediente"))
                      NumeroExpediente = dato.getValor();
                  if (dato.getEtiqueta().equalsIgnoreCase("numeroDocumento"))
                      NumeroDocumento = dato.getValor();
                  if (dato.getEtiqueta().equals("ID_SERVICIO")) {
                      codServicio = dato.getValor();
                  }
                  if (dato.getEtiqueta().equals("ID_CENTRO_TRAMITE")) {
                      codCentroTramite = dato.getValor();
                  }
                  if (dato.getEtiqueta().equals("REPTIPO")) {
                      tipoInfo = dato.getValor();
                  }
                  if (dato.getEtiqueta().equals("periodoCPE")) {
                      periodoCPE = dato.getValor();
                  }
                  if (dato.getEtiqueta().equals("SERVICIO")) {
                      servicio = dato.getValor();
                  }

              }
              if (NumeroExpediente == null || NumeroExpediente == "") {
                  for (int i = 0; i < informacion.getMetadatos().size();
                       i++) {
                      propiedad = informacion.getMetadatos().get(i);
                      if (dato == null) {
                          logger.info(txId +
                                      "getListaDatosRemplazar.dato = NULL");
                          continue;
                      }
                      if (propiedad.getXPropiedad().equalsIgnoreCase("xNumeroExpediente")) {
                          NumeroExpediente = propiedad.getXValor();
                      }
                      if (propiedad.getXPropiedad().equalsIgnoreCase("dDocTitle")) {
                          nombreBase = propiedad.getXValor() + "-Jas/";
                          logger.info("For nombreBase-1 " + nombreBase);
                          nombreBase =
                                  nombreBase.substring(0, nombreBase.indexOf("/"));
                          logger.info("For nombreBase-2 " + nombreBase);
                      }
                  }
              }

              Documento documento = new Documento();
              documento.setMetadatos(informacion.getMetadatos());
              String location =
                  this.getClass().getResource("/reports/" + nombrePlantilla +
                                              ".jasper").toString();
              String tempFolder = System.getProperty("java.io.tmpdir");
              logger.info("Locacion " +
                          location.substring(0, location.lastIndexOf("/") +
                                             1));
              Map<String, Object> params = new HashMap<String, Object>();

              if (tipoInfo.equals("PERMISO")) {
                  Firmante frmnt =
                      obtenerFirmante(codCentroTramite, codServicio);
                  GestionDocumentoWS_ServiceLocator serviceLocator =
                      new GestionDocumentoWS_ServiceLocator();
                  GestionDocumentoWS_PortType port =
                      serviceLocator.getGestionDocumentoWSPort();
                  logger.info("FIRMA: " + frmnt.getUserName() + "-FDSE");
                  logger.info("Final Obtener Firma: " + frmnt.getUserName());
                  byte[] buffer =
                      port.obtenerDocumento(frmnt.getUserName() + "-FDSE");
                  int fin = 0;
                  while (fin <= 3 && buffer == null) {
                      System.out.println("Esto lo ver�s una vez");
                      buffer =
                              port.obtenerDocumento(frmnt.getUserName() + "-FDSE");
                      fin += 1;
                  }
                  convertTIFFToPNG(buffer,
                                   tempFolder + frmnt.getUserName() + "-FDSE.png");
                  File f = new File(tempFolder + frmnt.getUserName() + "-FDSE.png");
                  byte[] b = new byte[(int)f.length()];
                  FileInputStream fileInputStream = new FileInputStream(f);
                  fileInputStream.read(b);
                  byte[] data = b; //Files.readAllBytes("D:/Aplicaciones/SenasaWs/ReportsWS/src/reports/Senasa_logo_01.jpg");
                  InputStream st = new ByteArrayInputStream(data);
                  params.put("FIRMA", st);
                  if (f.delete()) {
                      System.out.println("El fichero ha sido borrado satisfactoriamente");
                      logger.info("---El fichero png ha sido borrado satisfactoriamente--- " +tempFolder + frmnt.getUserName() +"-FDSE.png");
                  } else {
                      logger.info("---El fichero png no puede ser borrado--- " +tempFolder + frmnt.getUserName() +"-FDSE.png");
                  }
                  File tif =
                      new File(tempFolder + frmnt.getUserName() + "-FDSE.tif");
                  if (tif.delete()) {
                      System.out.println("El fichero ha sido borrado satisfactoriamente");
                      logger.info("---El fichero tif ha sido borrado satisfactoriamente--- " + tempFolder + frmnt.getUserName() + "-FDSE.png");
                  } else {
                      logger.info("---El fichero tif no puede ser borrado--- " + tempFolder + frmnt.getUserName() +"-FDSE.tif");
                  }
              }
              logger.info("NumeroExpediente: " + NumeroExpediente);
              logger.info("NumeroDocumento: " + NumeroDocumento);
              logger.info("codServicio: " + codServicio);
              logger.info("codCentroTramite: " + codCentroTramite);
              logger.info("tipoInfo: " + tipoInfo);
              logger.info("Carpeta Temporal: " + tempFolder);
              params.put("NEXPEDIENTE", NumeroExpediente);
              params.put("SUBTITULO", NumeroDocumento);
              params.put("PERIODOCPE", periodoCPE);
              params.put("TIPO", tipo);
              params.put("SUBREPORT_DIR",location.substring(0, location.lastIndexOf("/") +1));
              params.put(JRParameter.REPORT_LOCALE, Locale.US);
              logger.info("---Locacion Firma y reporte--- " +location.substring(0, location.lastIndexOf("/") + 1));
              JRProperties.setProperty(JRQueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX +"plsql","com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
              logger.info("Luego del SetProperty");
              logger.info(location);
              logger.info("Generando InputStream");
              InputStream jasperIS = this.getClass().getResourceAsStream("/reports/" +nombrePlantilla +".jasper");
              JasperPrint print =
              JasperFillManager.fillReport(jasperIS, params,con);
              logger.info("Luego del FillReport");
              logger.info("Exportacion en PDF - jasper");
              byte[] reporte;
              reporte = JasperExportManager.exportReportToPdf(print);
              servicio = servicio == null || servicio == "" ? "CPE" : servicio;
              logger.info("nombreBase-1 " + nombreBase);
              nombreBase =nombreBase == null || nombreBase == "" ? tipoInfo +"-" + servicio + "-" + NumeroExpediente + ".pdf" :nombreBase;
              logger.info("nombreBase-2 " + nombreBase);
              String dDocName =ucmClient.ingresarDocumento(txId, reporte, documento, nombreBase);
              logger.info("dDocNamee " + dDocName);
              return dDocName;
          }
      } catch (JRException e) {
         logger.error( e.getMessage() );
      } catch (Exception e) {
        logger.error( e.getMessage() );
      }finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando cerrando la conexi�n con la base de datos:" +
                             sqe.getMessage());
            }
        }
      return "";
  }
  public static void writeBytesToFile(File file, byte[] buffer) throws IOException {
    FileOutputStream fileOuputStream = new FileOutputStream(file);
  fileOuputStream.write(buffer);
  fileOuputStream.flush();
  fileOuputStream.close();
  }
  
  public static void convertTIFFToPNG(byte[] bufferTiff, String pathPNG)throws Exception{
    
    String pathTiff = pathPNG.replace(".png",".tif");      
    File tiffFile = new File(pathTiff); 
    writeBytesToFile(tiffFile,bufferTiff);  
    SeekableStream s = new FileSeekableStream(tiffFile);
    TIFFDecodeParam param = null;
    ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
    RenderedImage op = dec.decodeAsRenderedImage(0);
    FileOutputStream fos = new FileOutputStream(pathPNG);
    ImageEncoder en = ImageCodec.createImageEncoder("png", fos, null);            
    en.encode(op);
    fos.flush();
    fos.close();
        
  } 

    public String testWrite(String sw) {
        String rpta = "";
        try {
            System.out.println("Inicio ");
            String plantilla = "";
            if ("1".equals(sw)) {
                plantilla = "C:\\temporal\\plantilla_socp-scpe.docx";
            } else {
                plantilla = "C:\\temporal_t\\plantilla_socp-scpe.docx";
            }
            MsWordReplace msreplace = new MsWordReplace();
            msreplace.Open(plantilla);
            msreplace.ReplaceTextByText("<nomDirEjecutiva>", " dp world2");
            //msreplace.ReplaceTextByImage("bpmTagFirmaRemitente", "C:\\temporal\\firma1.txt");
            //msreplace.ReplaceTextByImage("bpmTagFirmaRemitente", "C:\\temporal\\._Acosta.tif");
            //msWord1.ReplaceTextByText("listRequisitos", dato);
            //msreplace.FillTable("<listRequisitos>", dato);

            msreplace.Close(plantilla);
            System.out.println("Inicio ");
            rpta = "OK";
        } catch (Exception e) {
            rpta = e.getMessage();
        }
        return rpta;
    }

    public boolean generarDocumentoIIVFito(String txId, String xnombrePlantilla) {
        logger.debug("INCIANDO CREACION DOCUMENTO IIVFITO");
        boolean retval = false;
        try {

            logger.debug("NOMBRE PLANTILLA A GENERAR: " + xnombrePlantilla);
            logger.debug("SETEANDO DATOS PLANOS");
            Informacion informacion = null;
            informacion = new Informacion();
            ArrayList<Dato> listaDatosRemplazar = new ArrayList<Dato>();
            Dato d = null;

            d = new Dato();
            d.setEtiqueta("nrExp");
            d.setValor("00011129923");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("nroInfInspVrfPlagInsVet");
            d.setValor("00097974345");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("esI");
            d.setValor("X");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("esT");
            d.setValor("X");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("nrPerm");
            d.setValor("000239398");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("fechaInfInsp");
            d.setValor("07/11/2011");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("regtrs");
            d.setValor("4546");
            listaDatosRemplazar.add(d);

            //Datos del Importador
            d = new Dato();
            d.setEtiqueta("nomImptdr");
            d.setValor("Oswaldo Chavez Moreno");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("rucDniImptdr");
            d.setValor("54546797");
            listaDatosRemplazar.add(d);

            //Datos de la Agencia de Aduana
            d = new Dato();
            d.setEtiqueta("agncAdnNv");
            d.setValor("Importaciones y Exportaciones Veracruz");
            listaDatosRemplazar.add(d);

            //Datos del Certificado
            d = new Dato();
            d.setEtiqueta("nroCertf");
            d.setValor("0001289078");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("pesNet");
            d.setValor("1550");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("fecEmisn");
            d.setValor("07/11/2011");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("nroDuaDs");
            d.setValor("235.2008.10.100153");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("paisOrg");
            d.setValor("CANADA,EEUU");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("paisPrd");
            d.setValor("CANADA");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("paisDest");
            d.setValor("CHINA");
            listaDatosRemplazar.add(d);

            //DATOS DE LOS PRODUCTOS

            d = new Dato();
            d.setEtiqueta("totProdcts");
            d.setValor("USO COMERCIAL");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("fecLlegd");
            d.setValor("04/01/2012");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("psNetTot");
            d.setValor("5600");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("docEmb");
            d.setValor("0967556");
            listaDatosRemplazar.add(d);

            logger.debug("SETEANDO DATOS TIPO TABLAS");
            ArrayList<Dato> lstDatos = new ArrayList<Dato>();
            String[][] lstValores = null;
            d = new Dato();
            lstValores = new String[2][7];
            lstValores[0][0] = "TRIGO, harina";
            lstValores[0][1] = "11.01.00.00.00";
            lstValores[0][2] = "2500";
            lstValores[0][3] = "KILOGRAMOS";
            lstValores[0][4] = "BOLSAS";
            lstValores[0][5] = "3";
            lstValores[0][6] = "SI";

            lstValores[1][0] = "MAIZ AMARILLO, granoa";
            lstValores[1][1] = "10.05.90.11.00";
            lstValores[1][2] = "2300";
            lstValores[1][3] = "KILOGRAMOS";
            lstValores[1][4] = "CAJAS";
            lstValores[1][5] = "6";
            lstValores[1][6] = "SI";

            //d.setListavaloresTabla(lstValores);
            d.setEtiqueta("lstProductos");
            lstDatos.add(d);
            informacion.setListaDatosTablas(lstDatos);

            d = new Dato();
            d.setEtiqueta("trmAlmcAut");
            d.setValor("DHL EXPRESS");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("plcRodCam");
            d.setValor("HG-4593");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("otroAlmc");
            d.setValor(" ");
            listaDatosRemplazar.add(d);

            //DATOS DEL RESULTADO DE LA INSPECCION
            d = new Dato();
            d.setEtiqueta("i1");
            d.setValor(" ");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("i2");
            d.setValor(" ");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("i3");
            d.setValor(" ");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("i4");
            d.setValor(" ");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("i5");
            d.setValor(" ");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("i6");
            d.setValor("X");
            listaDatosRemplazar.add(d);

            //Datos para la firma
            d = new Dato();
            d.setEtiqueta("bpmTagFirmaRemitente");
            d.setValor("");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("ID_CENTRO_TRAMITE");
            d.setValor("21");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("ID_SERVICIO");
            d.setValor("001");
            listaDatosRemplazar.add(d);
            //

            //Insertando la lista de datos a reemplazar
            informacion.setListaDatosRemplazar(listaDatosRemplazar);

            logger.debug(" ======== SETEANDO LOS METADATOS ========");
            ArrayList<Propiedad> lstMetadatos = new ArrayList<Propiedad>();
            Propiedad prop = null;

            prop = new Propiedad();
            prop.setXPropiedad("dDocType");
            prop.setXValor("DORI");
            lstMetadatos.add(prop);

            prop = new Propiedad();
            prop.setXPropiedad("xProfileTrigger");
            prop.setXValor("TUPA-DORI");
            lstMetadatos.add(prop);

            prop = new Propiedad();
            prop.setXPropiedad("xNumeroExpediente");
            prop.setXValor("0000120108");
            lstMetadatos.add(prop);

            prop = new Propiedad();
            prop.setXPropiedad("dDocTitle");
            prop.setXValor("IIV Fit. " + " -0000120167-00000000098");
            lstMetadatos.add(prop);

            prop = new Propiedad();
            prop.setXPropiedad("xSubTipo");
            prop.setXValor("IIVI");
            lstMetadatos.add(prop);
            informacion.setMetadatos(lstMetadatos);
            logger.debug("FIN SETEAR METADATOS");

            crearDocumento(txId, xnombrePlantilla, informacion);
            retval = true;
        } catch (Exception e) {
            e.getMessage();
        }
        return retval;
    }

    //public boolean generarDocumentoAutorizacionSEExpoZoo(String txId,String codigoServicio, String nroExpediente) {

    public String generarDocumentoAutorizacionSEExpoZoo(String txId, String codigoServicio, String nroExpediente) {
        ExportacionZooSanitariaDAO expoDAO = new ExportacionZooSanitariaDAO();
        AutorizacionSanitariaEstExpoZoo autoSaniEstExpoZoo = null;
        logger.debug("INCIANDO CREACION DOCUMENTO Autorizacion Sanitaria Establecimiento Exportacion Zoo");
        boolean retval = false;
        String codFormato = "";
        String dDocName = "";
        try {
            String xnombrePlantilla = "";
            logger.debug("nroExpediente -> " + nroExpediente);
            logger.debug("codigoServicio -> " + codigoServicio);
            autoSaniEstExpoZoo = expoDAO.obtenerDatosAutorizacionExpoZoo(nroExpediente, codigoServicio);

            if (autoSaniEstExpoZoo != null) {
                String etiquetaUcm = "";
                String subTipo = "";
                String fecha = this.obtenerFechaActual();

                if (autoSaniEstExpoZoo.getTipo().equalsIgnoreCase("ARC")) {
                    xnombrePlantilla = "PLANTILLA_DORE-ARC0";
                    etiquetaUcm = "ARC.";
                    subTipo = "ARC0";
                } else {
                    codFormato = expoDAO.obtenerCodidgoFormatoDocVuce(nroExpediente);
                    logger.debug("SETEANDO DATOS PLANOS");

                    if (codFormato.equalsIgnoreCase("SNS019")) {
                        xnombrePlantilla = "PLANTILLA_DORE-ASEN";
                        etiquetaUcm = "ASE Exp. Zoo.";
                        subTipo = "ASEN";
                    }
                    if (codFormato.equalsIgnoreCase("SNS020")) {
                        xnombrePlantilla = "PLANTILLA_DORE-ASER";
                        etiquetaUcm = "ASE Exp. Zoo. Ren.";
                        subTipo = "ASER";
                    }
                    if (codFormato.equalsIgnoreCase("SNS021")) {
                        xnombrePlantilla = "PLANTILLA_DORE-ASEM";
                        etiquetaUcm = "ASE Exp. Zoo. Mod.";
                        subTipo = "ASEM";
                    }
                }

                logger.debug("NOMBRE PLANTILLA A GENERAR: " + xnombrePlantilla);
                logger.debug("Fecha Expediente: " + autoSaniEstExpoZoo.getFechaExpediente() == null ? "" :
                             autoSaniEstExpoZoo.getFechaExpediente().substring(0, 10));

                Informacion informacion = null;
                informacion = new Informacion();
                ArrayList<Dato> listaDatosRemplazar = new ArrayList<Dato>();
                Dato d = null;

                d = new Dato();
                d.setEtiqueta("nroExp");
                d.setValor(autoSaniEstExpoZoo.getNroExpediente() == null ? "" : autoSaniEstExpoZoo.getNroExpediente());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("fechaExp");
                d.setValor(autoSaniEstExpoZoo.getFechaExpediente() == null ? " " :
                           autoSaniEstExpoZoo.getFechaExpediente().substring(0, 10));
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("nomEmp");
                d.setValor(autoSaniEstExpoZoo.getNomEmpresa() == null ? "" : autoSaniEstExpoZoo.getNomEmpresa());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("nroRucEmp");
                d.setValor(autoSaniEstExpoZoo.getNroRucEmpresa() == null ? "" : autoSaniEstExpoZoo.getNroRucEmpresa());
                listaDatosRemplazar.add(d);

                if (autoSaniEstExpoZoo.getTipo().equalsIgnoreCase("ARC")) {
                    logger.debug("Seteando los datos a imprimir para Recinto Cuarentenario");
                    d = new Dato();
                    d.setEtiqueta("nroIT");
                    d.setValor(autoSaniEstExpoZoo.getDirEmpresa() == null ? "" : autoSaniEstExpoZoo.getDirEmpresa());
                    listaDatosRemplazar.add(d);

                    d = new Dato();
                    d.setEtiqueta("fechaIT");
                    d.setValor(autoSaniEstExpoZoo.getDirEmpresa() == null ? "" : autoSaniEstExpoZoo.getDirEmpresa());
                    listaDatosRemplazar.add(d);

                    d = new Dato();
                    d.setEtiqueta("nroDS");
                    d.setValor(autoSaniEstExpoZoo.getDirEmpresa() == null ? "" : autoSaniEstExpoZoo.getDirEmpresa());
                    listaDatosRemplazar.add(d);

                    d = new Dato();
                    d.setEtiqueta("nomRecinto");
                    d.setValor(autoSaniEstExpoZoo.getNomRecinto() == null ? "" : autoSaniEstExpoZoo.getNomRecinto());
                    listaDatosRemplazar.add(d);

                    d = new Dato();
                    d.setEtiqueta("nomEstablecimiento");
                    d.setValor(autoSaniEstExpoZoo.getNomEstablecimiento() == null ? "" :
                               autoSaniEstExpoZoo.getNomEstablecimiento());
                    listaDatosRemplazar.add(d);

                    d = new Dato();
                    d.setEtiqueta("dirEstablecimiento");
                    d.setValor(autoSaniEstExpoZoo.getDirEstablecimiento() == null ? "" :
                               autoSaniEstExpoZoo.getDirEstablecimiento());
                    listaDatosRemplazar.add(d);
                }

                d = new Dato();
                d.setEtiqueta("dirEmp");
                d.setValor(autoSaniEstExpoZoo.getDirEmpresa() == null ? "" : autoSaniEstExpoZoo.getDirEmpresa());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("tipoEstablecimiento");
                d.setValor(autoSaniEstExpoZoo.getNomEstablecimiento() == null ? "" : autoSaniEstExpoZoo.getNomEstablecimiento());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("listProductos");
                d.setValor(autoSaniEstExpoZoo.getProductos() == null ? "" : autoSaniEstExpoZoo.getProductos());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("nroDias");
                d.setValor(autoSaniEstExpoZoo.getNroDias() == null ? "" : autoSaniEstExpoZoo.getNroDias());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("nroCertf");
                d.setValor(autoSaniEstExpoZoo.getNroCertf() == null ? "" : autoSaniEstExpoZoo.getNroCertf());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("fechaInicio");
                d.setValor(autoSaniEstExpoZoo.getFechaInicio());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("fechaFin");
                d.setValor(autoSaniEstExpoZoo.getFechaInicio());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("lugarEmision");
                d.setValor(autoSaniEstExpoZoo.getLugarEmisionCertf());
                listaDatosRemplazar.add(d);

                //Obteniendo la fecha  Actual del sistema
                d = new Dato();
                d.setEtiqueta("fecEmsCertf");
                d.setValor(autoSaniEstExpoZoo.getFechaEmisionCertf() == null ? "" :
                           autoSaniEstExpoZoo.getFechaEmisionCertf().substring(0, 10));
                listaDatosRemplazar.add(d);

                //================ Datos para la firma =================
                logger.debug("======== Datos para la firma =========");
                d = new Dato();
                d.setEtiqueta("bpmTagFirmaRemitente");
                d.setValor("");
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("ID_CENTRO_TRAMITE");
                d.setValor(autoSaniEstExpoZoo.getCodSede() == null ? "" : autoSaniEstExpoZoo.getCodSede());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("ID_SERVICIO");
                d.setValor(codigoServicio);
                listaDatosRemplazar.add(d);

                //Insertando la lista de datos a reemplazar
                informacion.setListaDatosRemplazar(listaDatosRemplazar);
                logger.debug("======== FIN DE SETEAR DATOS PLANOS =======");

                logger.debug(" ======== SETEANDO LOS METADATOS ========");
                ArrayList<Propiedad> lstMetadatos = new ArrayList<Propiedad>();
                Propiedad prop = null;

                prop = new Propiedad();
                prop.setXPropiedad("dDocType");
                prop.setXValor("DORE");
                lstMetadatos.add(prop);

                prop = new Propiedad();
                prop.setXPropiedad("xProfileTrigger");
                prop.setXValor("TUPA-DORE");
                lstMetadatos.add(prop);

                prop = new Propiedad();
                prop.setXPropiedad("xNumeroExpediente");
                prop.setXValor(nroExpediente);
                lstMetadatos.add(prop);

                prop = new Propiedad();
                prop.setXPropiedad("dDocTitle");
                prop.setXValor(etiquetaUcm + "-" + nroExpediente + "-" + autoSaniEstExpoZoo.getNroCertf() + "-" + fecha);
                lstMetadatos.add(prop);

                prop = new Propiedad();
                prop.setXPropiedad("xSubTipo");
                prop.setXValor(subTipo);
                lstMetadatos.add(prop);
                informacion.setMetadatos(lstMetadatos);
                logger.debug("FIN SETEAR METADATOS");

                dDocName = crearDocumento(txId, xnombrePlantilla, informacion);
                retval = true;
            }
        } catch (Exception e) {
            logger.error("error en la creacion del documento: " + e.getMessage());
        }
        //return retval;
        return dDocName;
    }

    //	public boolean generarDocumentoRegistroGCA(String txId,String xnombrePlantilla, String codigoServicio, String nroExpediente) {

    public String generarDocumentoRegistroGCA(String txId, String xnombrePlantilla, String codigoServicio,
                                              String nroExpediente) {
        GeneralDAO gDao = new GeneralDAO();
        logger.debug("INCIANDO CREACION DOCUMENTO REGISTRO GUARDACUSTODIA FITO");
        boolean retval = false;
        String dDocName = "";
        try {
            logger.debug("NOMBRE PLANTILLA A GENERAR: " + xnombrePlantilla);
            logger.debug("SETEANDO DATOS PLANOS");

            String etiquetaUcm = ((codigoServicio.equals("097")) ? "Reg. Gca. Fit." : "Reg. Gca. Fit. Mod.");
            logger.debug("ETIQUETA UCM ====== " + etiquetaUcm);

            Guardacustodia gcustodia = new Guardacustodia();
            gcustodia = gDao.obtenerDatosGuardacustodia(nroExpediente);
            logger.debug("NOMBRE DE LA EMPRESA: " + gcustodia.getNomEmpresa());

            Informacion informacion = null;
            informacion = new Informacion();
            ArrayList<Dato> listaDatosRemplazar = new ArrayList<Dato>();
            Dato d = null;

            d = new Dato();
            d.setEtiqueta("nroCertf");
            d.setValor(gcustodia.getNroCertificado());
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("nomEmp");
            d.setValor(gcustodia.getNomEmpresa());
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("nroRucEmp");
            d.setValor(gcustodia.getNroDocEmpresa());
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("dirEmp");
            d.setValor(gcustodia.getDirAlmacen());
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("lugarEmision");
            d.setValor(gcustodia.getLugarEmisionCertf());
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("fecEmsCertf");
            d.setValor(gcustodia.getFecEmisionCertf());
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("termVigncCertf");
            d.setValor(gcustodia.getTermVigncCertf());
            listaDatosRemplazar.add(d);

            //================ Datos para la firma =================
            d = new Dato();
            d.setEtiqueta("bpmTagFirmaRemitente");
            d.setValor("");
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("ID_CENTRO_TRAMITE");
            d.setValor(gcustodia.getCodigoSede() == null ? "" : gcustodia.getCodigoSede());
            listaDatosRemplazar.add(d);

            d = new Dato();
            d.setEtiqueta("ID_SERVICIO");
            d.setValor(codigoServicio);
            listaDatosRemplazar.add(d);

            /////////////////////////////////////////////////////////////////
            //Insertando la lista de datos a reemplazar
            informacion.setListaDatosRemplazar(listaDatosRemplazar);

            logger.debug(" ======== SETEANDO LOS METADATOS ========");
            ArrayList<Propiedad> lstMetadatos = new ArrayList<Propiedad>();
            Propiedad prop = null;

            prop = new Propiedad();
            prop.setXPropiedad("dDocType");
            prop.setXValor("DORC");
            lstMetadatos.add(prop);

            prop = new Propiedad();
            prop.setXPropiedad("xProfileTrigger");
            prop.setXValor("TUPA-DORC");
            lstMetadatos.add(prop);

            prop = new Propiedad();
            prop.setXPropiedad("xNumeroExpediente");
            prop.setXValor(nroExpediente);
            lstMetadatos.add(prop);

            prop = new Propiedad();
            prop.setXPropiedad("dDocTitle");
            prop.setXValor(etiquetaUcm + "-" + nroExpediente + "-" + gcustodia.getNroCertificado() + "-" +
                           gcustodia.getFecEmisionCertf());
            lstMetadatos.add(prop);

            prop = new Propiedad();
            prop.setXPropiedad("xSubTipo");
            prop.setXValor("RGCF");
            lstMetadatos.add(prop);
            informacion.setMetadatos(lstMetadatos);
            logger.debug("FIN SETEAR METADATOS");

            dDocName = crearDocumento(txId, xnombrePlantilla, informacion);
            //retval = true;

        } catch (Exception e) {
            logger.error("error en la creacion del documento: " + e.getMessage());
        }
        //return retval;
        return dDocName;
    }

    //public boolean generarDocumentoPFTI(String txId,String xnombrePlantilla, String codigoServicio, String nroExpediente) {

    public String generarDocumentoPFTI(String txId, String codigoServicio, String nroExpediente) {
        logger.debug("INCIANDO CREACION DOCUMENTO PFTI");
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
        formatSymbols.setDecimalSeparator('.');
        formatSymbols.setGroupingSeparator(',');
        DecimalFormat formatter = new DecimalFormat("#,###,###,###,###,###,###.########################", formatSymbols);
        GeneralDAO gDao = new GeneralDAO();
        PermisoFitoSanitarioImportacionDAO pftiDAO = new PermisoFitoSanitarioImportacionDAO();
        PermisoFitosanitarioTransitoInterno pfti = null;
        String xnombrePlantilla = "";
        boolean retval = false;
        String dDocname = "";
        try {
            // ir db vuce
            logger.debug("SETEANDO SUBTIPO");
            String etiquetaUcm = "";
            String subTipo = "";

            logger.debug("= Invocando Metodo DAO obtenerDatosPFIT =");
            pfti = gDao.obtenerDatosPFTI(nroExpediente);

            if (codigoServicio.equalsIgnoreCase("009")) {
                etiquetaUcm = "PFTI";
                subTipo = "PFTI";
                xnombrePlantilla = "PLANTILLA_DORI-PFTI";
            }
            if (codigoServicio.equalsIgnoreCase("010")) {
                if (pfti.getIndicadorAmpliacion() == null || pfti.getIndicadorAmpliacion().equalsIgnoreCase("N")) {
                    etiquetaUcm = "PFTI Mod.";
                    subTipo = "PFTI";
                    xnombrePlantilla = "PLANTILLA_DORI-PFTI";
                } else {
                    etiquetaUcm = "PFTI Amp.";
                    subTipo = "FTIA";
                    xnombrePlantilla = "PLANTILLA_DORI-FTIA";
                }
            }
            logger.debug("NOMBRE PLANTILLA A GENERAR: " + xnombrePlantilla);

            if (pfti != null) {
                logger.debug("ETIQUETA UCM =====" + etiquetaUcm);
                Informacion informacion = new Informacion();
                ArrayList<Dato> listaDatosRemplazar = new ArrayList<Dato>();

                logger.debug("SETEANDO DATOS REQUISITOS FITOSANITARIOS");
                Dato d = null;

                ArrayList<RequisitoSanitario> lstRequisitos = new ArrayList<RequisitoSanitario>();
                String codProductos = "";
                String codPaisProcd = "";
                String codPaisesOrg = "";
                String codPaisDest = "";
                String codLugarProd = "";

                logger.debug("Obteniendo los codigos del Pais de Procedencia,Destino y de Producto");
                for (ProductoPFI prod : pfti.getProductosPFI()) {
                    codPaisProcd = codPaisProcd + prod.getPaisProcedencia() + ",";
                    codPaisDest = codPaisDest + prod.getPaisDestino() + ",";
                    codProductos = codProductos + prod.getCodigoProducto() + ",";
                }
                codPaisProcd = codPaisProcd.substring(0, codPaisProcd.length() - 1);
                if (codPaisDest.length() > 0) {
                    codPaisDest = codPaisDest.substring(0, codPaisDest.length() - 1);
                }
                codProductos = codProductos.substring(0, codProductos.length() - 1);
                logger.debug("Codigo de Pais de Procedencia Obtenido: " + codPaisProcd);
                logger.debug("Codigo de Pais de Destino Obtenido: " + codPaisDest);
                logger.debug("Codigo de Productos Obtenidos: " + codProductos);

                logger.debug("Obteniendo el codigo de los Paises de Origen");
                for (PaisOrigenProductoPFI pais : pfti.getPaisesOrigenProductoPFI()) {
                    codPaisesOrg = codPaisesOrg + pais.getPaisOrigenProducto() + ",";
                }
                codPaisesOrg = codPaisesOrg.substring(0, codPaisesOrg.length() - 1);
                logger.debug("Codigos de Paises de Origen Obtenidos: " + codPaisesOrg);

                logger.debug("Obteniendo el codigo del Lugar de Produccion");
                for (LugarProduccionProductoPFI lugar : pfti.getLugaresProduccionProductoPFI()) {
                    codLugarProd = codLugarProd + lugar.getLugarProduccionProducto() + ",";
                }
                if (codLugarProd.length() > 0) {
                    codLugarProd = codLugarProd.substring(0, codLugarProd.length() - 1);
                }
                logger.debug("Codigo del Lugar de Produccion Obtenido: " + codLugarProd);

                //Por aclarar si se va utilizar otro paquete para obtener los requisitos o si se sigue usando el mismo que para pfi
                ArrayList<RequisitoDao> requisitosPfti =
                    pftiDAO.obtenerRequisitosSanitariosImpoFitoTran(codProductos, codPaisesOrg, codLugarProd, codPaisProcd,
                                                                    codPaisDest);

                logger.debug("CANTIDAD DE REQUISITOS OBTENIDOS: " + requisitosPfti.size());

                RequisitoSanitario requ = null;
                for (RequisitoDao req : requisitosPfti) {
                    requ = new RequisitoSanitario();
                    requ.setDescripcionRequisito(req.getDescripcionRequisito());
                    requ.setEtiqueta(req.getEtiqueta());
                    requ.setSangria(req.getSangria());
                    requ.setOrden(req.getOrden());
                    requ.setClase(req.getClase());
                    lstRequisitos.add(requ);
                }
                logger.debug("CANTIDAD DE REQUISITOS A IMPRIMIR: " + lstRequisitos.size());
                d = new Dato();
                d.setEtiqueta("listRequisitos");
                d.setAnchoPagPixel(480);
                d.setCpe(false);
                d.setListaRequisitos(lstRequisitos);
                informacion.setListaDatosRequisitos(d);
                logger.debug("REQUISITOS FITOSANITARIOS ADICIONADOS");

                d = new Dato();
                d.setEtiqueta("numeroExpediente");
                d.setValor(nroExpediente);
                listaDatosRemplazar.add(d);

                String postfijoDoc = "";
                if (pfti.getCodigoSede() != null && codigoServicio != null) {
                    Firmante frmnt = obtenerFirmante(pfti.getCodigoSede(), codigoServicio);
                    if (frmnt != null)
                        postfijoDoc = frmnt.getNomencaltura();
                }

                Calendar cal = Calendar.getInstance();
                String numeroDocumento = pfti.getNroDocumento() + "-" + (cal.get(Calendar.YEAR)) + "-" + postfijoDoc;

                logger.debug("Numero de Documento PFTI: " + numeroDocumento);

                d = new Dato();
                d.setEtiqueta("numeroDocumento");
                d.setValor(numeroDocumento);
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("lugarEmision");
                d.setValor(pfti.getLugarEmision());
                listaDatosRemplazar.add(d);

                logger.debug("Calculando las fechas de Emision/Vigencia/Ampliacion");
                String fechaEmision = "";
                String fechaVigencia = "";
                String fechaAmpliacion = "";

                if (pfti.getFechaEmision() != null && pfti.getFechaEmision().length() > 1) {
                    fechaEmision = pfti.getFechaEmision().substring(0, 10);
                    fechaVigencia = gDao.obtenerFechaAmpliacion(fechaEmision, "C", 90);
                    if (subTipo.equals("FTIA")) {
                        logger.debug("Seteando la fecha de Ampliacion PFTI");
                        fechaAmpliacion = gDao.obtenerFechaAmpliacion(fechaEmision, "C", 180);

                        d = new Dato();
                        d.setEtiqueta("fechaAmpliacion");
                        d.setValor(fechaAmpliacion);
                        listaDatosRemplazar.add(d);
                    }
                }

                d = new Dato();
                d.setEtiqueta("fechaEmision");
                d.setValor(fechaEmision);
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("fechaVigencia");
                d.setValor(fechaVigencia);
                listaDatosRemplazar.add(d);

                logger.debug("Fin del Calculo y Asignacion de Fechas");

                d = new Dato();
                d.setEtiqueta("nombreSolicitante");
                d.setValor(pfti.getNombreSolicitante());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("domicilioLegalSolicitante");
                d.setValor(pfti.getDmclLegalSolicitante());
                listaDatosRemplazar.add(d);

                // Datos para la firma
                d = new Dato();
                d.setEtiqueta("bpmTagFirmaRemitente");
                d.setValor("");
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("ID_CENTRO_TRAMITE");
                d.setValor(pfti.getCodigoSede() == null ? "" : pfti.getCodigoSede());
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("ID_SERVICIO");
                d.setValor(codigoServicio);
                listaDatosRemplazar.add(d);

                //Insertando la lista de datos a reemplazar
                informacion.setListaDatosRemplazar(listaDatosRemplazar);
                logger.debug("FIN SETEAR DATOS PLANOS");

                logger.debug("SETEANDO DATOS TIPO TABLAS");
                logger.debug("Seteando datos de los productos INICIO");
                String[][] lstValores = new String[pfti.getProductosPFI().size()][6];
                ArrayList<Dato> lstDatos = new ArrayList<Dato>();
                StringBuilder sbPaisOrg = new StringBuilder();
                StringBuilder sbPaisProcd = new StringBuilder();
                StringBuilder sbPaisDest = new StringBuilder();
                StringBuilder sbPstCtrlIng = new StringBuilder();
                StringBuilder sbPstCtrlSal = new StringBuilder();
                d = new Dato();
                if (pfti.getProductosPFI().size() > 0 || pfti.getProductosPFI() != null) {
                    logger.debug("Ingresa como producto padre");
                    for (int i = 0; i < pfti.getProductosPFI().size(); i++) {
                        //d= new Dato();
                        lstValores[i][0] = pfti.getProductosPFI().get(i).getPartidaArancelaria();
                        lstValores[i][1] = pfti.getProductosPFI().get(i).getDescripcion();
                        lstValores[i][2] =
                                pfti.getProductosPFI().get(i).getNombreCientifico() == null ? "" : pfti.getProductosPFI().get(i).getNombreCientifico();
                        lstValores[i][3] =
                                pfti.getProductosPFI().get(i).getPesoNeto() == null ? "" : formatter.format(pfti.getProductosPFI().get(i).getPesoNeto());
                        lstValores[i][4] =
                                pfti.getProductosPFI().get(i).getCantidad() == null ? "" : formatter.format(pfti.getProductosPFI().get(i).getCantidad());
                        lstValores[i][5] = pfti.getProductosPFI().get(i).getTipoEnvase();
                        sbPaisProcd.append(pfti.getProductosPFI().get(i).getDescPaisProcedencia()).append("\n");
                        sbPaisDest.append(pfti.getProductosPFI().get(i).getDescPaisDestino()).append("\n");
                    }
                } else {
                    logger.debug("Ingresa como producto anexo");
                    for (int i = 0; i < pfti.getAnexosPFI().size(); i++) {
                        lstValores[i][0] = pfti.getAnexosPFI().get(i).getPartidaArancelaria();
                        lstValores[i][1] = pfti.getAnexosPFI().get(i).getDescripcion();
                        lstValores[i][2] =
                                pfti.getAnexosPFI().get(i).getNombreCientifico() == null ? "" : pfti.getAnexosPFI().get(i).getNombreCientifico();
                        lstValores[i][3] =
                                pfti.getAnexosPFI().get(i).getPesoNeto() == null ? "" : formatter.format(pfti.getAnexosPFI().get(i).getPesoNeto());
                        lstValores[i][4] =
                                pfti.getAnexosPFI().get(i).getCantidad() == null ? "" : formatter.format(pfti.getAnexosPFI().get(i).getCantidad());
                        lstValores[i][5] = pfti.getAnexosPFI().get(i).getTipoEnvase();
                        sbPaisProcd.append(pfti.getAnexosPFI().get(i).getPaisProcedencia()).append("\n");
                        sbPaisDest.append(pfti.getAnexosPFI().get(i).getPaisDestino()).append("\n");
                    }
                }
                //d.setListavaloresTabla(lstValores);
                d.setEtiqueta("listProductos");
                lstDatos.add(d);
                informacion.setListaDatosTablas(lstDatos);

                d = new Dato();
                d.setEtiqueta("procedenciaProducto");
                d.setValor(String.valueOf(sbPaisProcd));
                listaDatosRemplazar.add(d);

                d = new Dato();
                d.setEtiqueta("destinoProducto");
                d.setValor(String.valueOf(sbPaisDest));
                listaDatosRemplazar.add(d);

                logger.debug("Seteando datos de los productos FIN");

                logger.debug("Seteando datos de los paises de origen");
                if (pfti.getPaisesOrigenProductoPFI() != null && pfti.getPaisesOrigenProductoPFI().size() > 0) {
                    for (int i = 0; i < pfti.getPaisesOrigenProductoPFI().size(); i++) {
                        logger.debug("Descripcion de Pais Origen: " +
                                     pfti.getPaisesOrigenProductoPFI().get(i).getDescPaisOrigenProducto());
                        sbPaisOrg.append(pfti.getPaisesOrigenProductoPFI().get(i).getDescPaisOrigenProducto()).append("\n");
                    }
                    d = new Dato();
                    d.setEtiqueta("origenProducto");
                    d.setValor(String.valueOf(sbPaisOrg));
                    listaDatosRemplazar.add(d);
                }
                logger.debug("Seteando datos de los paises de origen FIN");

                logger.debug("Seteando datos de los puestos de control");
                if (pfti.getPuntoIngresoProductoPFI().size() > 0 || pfti.getPuntoIngresoProductoPFI() != null) {
                    for (int i = 0; i < pfti.getPuntoIngresoProductoPFI().size(); i++) {
                        sbPstCtrlIng.append(pfti.getPuntoIngresoProductoPFI().get(i).getPuntoIngresoProducto()).append("\n");
                        sbPstCtrlSal.append(pfti.getPuntoIngresoProductoPFI().get(i).getPuntoSalidaProducto()).append("\n");
                    }
                    d = new Dato();
                    d.setEtiqueta("puestoControlIngreso");
                    d.setValor(String.valueOf(sbPstCtrlIng));
                    listaDatosRemplazar.add(d);

                    d = new Dato();
                    d.setEtiqueta("puestoControlSalida");
                    d.setValor(String.valueOf(sbPstCtrlSal));
                    listaDatosRemplazar.add(d);
                }
                logger.debug("Seteando datos de los puestos de control FIN");
                //informacion.setListaDatosTablas(lstDatos);
                logger.debug("FIN SETEAR DATOS TIPO TABLAS");

                logger.debug("SETEANDO LOS METADATOS");
                ArrayList<Propiedad> lstMetadatos = new ArrayList<Propiedad>();
                Propiedad prop = null;

                prop = new Propiedad();
                prop.setXPropiedad("dDocType");
                prop.setXValor("DORI");
                lstMetadatos.add(prop);

                prop = new Propiedad();
                prop.setXPropiedad("xProfileTrigger");
                prop.setXValor("TUPA-DORI");
                lstMetadatos.add(prop);

                prop = new Propiedad();
                prop.setXPropiedad("xNumeroExpediente");
                prop.setXValor(nroExpediente);
                lstMetadatos.add(prop);

                prop = new Propiedad();
                prop.setXPropiedad("dDocTitle");
                prop.setXValor(etiquetaUcm + "-" + nroExpediente + "-" + pfti.getNroDocumento());
                lstMetadatos.add(prop);

                prop = new Propiedad();
                prop.setXPropiedad("xSubTipo");
                prop.setXValor(subTipo);
                lstMetadatos.add(prop);
                //Adicionando la lista de metadatos
                informacion.setMetadatos(lstMetadatos);
                logger.debug("FIN SETEAR METADATOS");

                dDocname = crearDocumento(txId, xnombrePlantilla, informacion);
                retval = true;
            }
            logger.debug("GENERAR DOCUMENTO PFTI FIN");
        } catch (Exception e) {
            logger.error("error en la creacion del documento: " + e.getMessage());
        }
        //return retval;
        return dDocname;
    }

    public String crearDocumento(String txId, String nombrePlantilla, Informacion informacion) {
        
      //  reporteJasper jas = new reporteJasper();
        

      if (nombrePlantilla.equals("PLANTILLA_DORI_PFTI") || nombrePlantilla.equals("PLANTILLA_SOLI_PFTI") || 
          nombrePlantilla.equals("PLANTILLA_DORI-PFI") || nombrePlantilla.equals("PLANTILLA_DORI-PEFI") || 
          nombrePlantilla.equals("PLANTILLA_DORI-PEF1") || nombrePlantilla.equals("PLANTILLA_DORI-PFI_123") || 
          nombrePlantilla.equals("PLANTILLA_DORI-PFIA") || nombrePlantilla.equals("PLANTILLA_DORI-PIA1") || 
          nombrePlantilla.equals("PLANTILLA_DORI-PIA2") || nombrePlantilla.equals("PLANTILLA_DORI-PIA3") || 
          nombrePlantilla.equals("ID_DOC_PFI_CUARENTENA_1_AMP") || nombrePlantilla.equals("ID_DOC_PFI_CUARENTENA_2_AMP") || 
          nombrePlantilla.equals("ID_DOC_PFI_CUARENTENA_3_AMP") || nombrePlantilla.equals("ID_DOC_SOLICITUD_MPFI") || 
          nombrePlantilla.equals("PLANTILLA_DORI-PFI1") || nombrePlantilla.equals("PLANTILLA_DORI-PFI2") || 
          nombrePlantilla.equals("PLANTILLA_DORI-PFI3") || nombrePlantilla.equals("PLANTILLA_DORI-PEZ1") || 
          nombrePlantilla.equals("PLANTILLA_DORI-PEZI") || nombrePlantilla.equals("PLANTILLA_DORI-PZA1") || 
          nombrePlantilla.equals("PLANTILLA_DORI-PZIA") || nombrePlantilla.equals("ID_DOC_SOLICITUD_MPZI")) {
      String dDocname= generarREPORTE(txId,nombrePlantilla,informacion);
      logger.info(dDocname + "---------------dDocname2--------------");
      return dDocname;
      }else{
        logger.info(txId + "------------------Inicio de  crearDocumento----------------");
        logger.info(txId + "nombrePlantilla: '" + nombrePlantilla + "'");
        MsWordReplace msreplace = null;
        Dato dato = null;
        String nombreArchivo = null;
        String dDocName = null;
        Documento documento = new Documento();
        Boolean statusRepleace = false;
        try {

            documento.setMetadatos(informacion.getMetadatos());
            Propiedad datoMeta = null;

            if (documento.getMetadatos() != null) {
                logger.info(txId + "*Verificar el dDocTitle enviado*");
                for (int i = 0; i < documento.getMetadatos().size(); i++) {
                    datoMeta = documento.getMetadatos().get(i);
                    if (datoMeta.getXPropiedad().equals("dDocTitle")) {
                        logger.info(txId + "nNombreMetadato:" + datoMeta.getXPropiedad() + ",valorMetadato:" +
                                    datoMeta.getXValor());
                    }
                }
            }

            nombreArchivo = ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, nombrePlantilla);

            if (nombreArchivo == null) {
                return null;
            }
            //try {
            msreplace = new MsWordReplace();
            msreplace.Open(nombreArchivo);

            logger.info(txId + "informacion.getListaDatosRemplazar().length:" + informacion.getListaDatosRemplazar().size());
            if (informacion.getListaDatosRemplazar() != null && informacion.getListaDatosRemplazar().size() > 0) {
                String codServicio = "";
                String codCentroTramite = "";
                String usuarioTagFirma = "";
                boolean idxFirma = false;

                for (int i = 0; i < informacion.getListaDatosRemplazar().size(); i++) {
                    dato = informacion.getListaDatosRemplazar().get(i);
                    if (dato == null) {
                        logger.info(txId + "getListaDatosRemplazar.dato = NULL");
                        continue;
                    }
                    if (dato.getEtiqueta().equalsIgnoreCase("ID_SERVICIO"))
                        codServicio = dato.getValor();
                    if (dato.getEtiqueta().equalsIgnoreCase("ID_CENTRO_TRAMITE"))
                        codCentroTramite = dato.getValor();

                    if (dato.getEtiqueta().equals("bpmTagFirmaRemitente")) {
                        usuarioTagFirma = dato.getValor();
                        idxFirma = true;
                        continue;
                    }

                    msreplace.ReplaceTextByText("<" + dato.getEtiqueta() + ">", remplazo(dato.getValor()));
                    logger.info(txId + "Dato Plano. dato.getEtiqueta(): " + dato.getEtiqueta() +
                                "  remplazo(dato.getValor()): " + remplazo(dato.getValor()));
                }

                //firma
                if (idxFirma) {
                    FuncionarioDAO fncDAO = new FuncionarioDAO();

                    try {
                        String usuarioFirma = null;

                        if (codServicio != null && codCentroTramite != null && !codServicio.isEmpty() &&
                            !codCentroTramite.isEmpty()) {
                            Firmante frmnt = obtenerFirmante(codCentroTramite, codServicio);
                            if (frmnt != null)
                                usuarioFirma = frmnt.getUserName() + NomenclaturaFirma.SUFIJO_FIRMA_SELLO;
                        }
                        if ((usuarioFirma == null || usuarioFirma.isEmpty()) &&
                            (codServicio != null && codCentroTramite != null && !codServicio.isEmpty() &&
                             !codCentroTramite.isEmpty())) {
                            usuarioFirma = fncDAO.obtenerFirma(codServicio, codCentroTramite, "FDSE");
                            logger.info(txId + " retorno de obtenr firma : " + usuarioFirma); // posible valor SVALCARCEL-FDSE
                        }
                        if ((usuarioFirma == null || usuarioFirma.isEmpty()) &&
                            (usuarioTagFirma != null && !usuarioTagFirma.isEmpty())) {
                            usuarioFirma = usuarioTagFirma + "-FDSE";
                            logger.info(txId + " construcción de usuario firma : " +
                                        usuarioFirma); // posible valor SVALCARCEL-FDSE
                        }

                        if (usuarioFirma != null) {
                            String urlFirma = ucmClient.obtenerPlantilla(txId, usuarioFirma);
                            if (urlFirma != null) {
                                logger.info(txId + "ruta Final Imagen Firma: " + ucmClient.PATH_FILES + urlFirma);

                                logger.info(txId + "Reemplazando Firma bpmTagFirmaRemitente: " + urlFirma);
                                msreplace.ReplaceTextByImage("<bpmTagFirmaRemitente>", ucmClient.PATH_FILES + urlFirma);

                                logger.info(txId + "Reemplazando Firma bpmTagFirmaRemitente2: " + urlFirma);
                                msreplace.ReplaceTextByImage("<bpmTagFirmaRemitente2>", ucmClient.PATH_FILES + urlFirma);

                                ucmClient.eliminarArchivo(ucmClient.PATH_FILES + urlFirma);
                                logger.info(txId + "ejecutó  UCMClient.eliminarArchivo");

                            } else {
                                msreplace.ReplaceTextByText("<bpmTagFirmaRemitente>", "");
                                msreplace.ReplaceTextByText("<bpmTagFirmaRemitente2>", "");
                            }
                        } else {
                            msreplace.ReplaceTextByText("<bpmTagFirmaRemitente>", "");
                            msreplace.ReplaceTextByText("<bpmTagFirmaRemitente2>", "");
                        }

                    } catch (Exception e) {
                        logger.error(txId + "error de firma: " + e.getMessage());
                    }
                }
            } // Fin de la lógica de validar lista de firmates

            logger.info(txId + "informacion.getListaDatosTablas().length:" + informacion.getListaDatosTablas().size());

            if (informacion.getListaDatosTablas() != null && informacion.getListaDatosTablas().size() > 0) {
                for (int i = 0; i < informacion.getListaDatosTablas().size(); i++) {
                    dato = informacion.getListaDatosTablas().get(i);
                    if (dato == null) {
                        logger.info(txId + "getListaDatosTablas.dato = NULL");
                        continue;
                    }
                    //msreplace.FillTable("<" + dato.getEtiqueta() + ">", dato.getListavaloresTabla());
                    logger.info(txId + "Dato en Tabla. dato.getEtiqueta(): " + dato.getEtiqueta());

                }
            }
            //FORMATO PARA LA SALIDA DE REQUISITOS

            if (informacion.getListaDatosRequisitos().getListaRequisitos() != null &&
                informacion.getListaDatosRequisitos().getListaRequisitos().size() > 0) {
                logger.info(txId + " Cantidad de Requisitos" +
                            informacion.getListaDatosRequisitos().getListaRequisitos().size());
                logger.info(txId + "ETIQUETA REQUISITOS:" + informacion.getListaDatosRequisitos().getEtiqueta());

                Metrics metrics = new Metrics();
                String[][] salidaFormatoReq = metrics.ordenarSalidaListaReq(informacion.getListaDatosRequisitos());

                logger.info(txId + "INSERTANDO lA CADENA DE SALIDA FINAL DE REQUISTIOS");
                msreplace.FillTable("<" + informacion.getListaDatosRequisitos().getEtiqueta() + ">", salidaFormatoReq);
                logger.info(txId + "SE INSERTO LA CADENA DE SALIDA FINAL REQUISITOS");
            } else {
                logger.info(txId + " No existe requisitos por reemplazar");
            }

            statusRepleace = true;
        } catch (Exception e) {
            logger.error(txId + " Se produjo un error==>" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (msreplace != null) {
                msreplace.Close(nombreArchivo);
            }
        }

        //FORMATO SALIDA DE  REQUISITOS FIN

        dDocName = ucmClient.ingresarDocumento(txId, nombreArchivo, documento);
        logger.info(txId + "dDocName: " + dDocName);
        logger.info(txId + "eliminarArchivo nombre :" + nombreArchivo);
        ucmClient.eliminarArchivo(nombreArchivo);
        logger.info(txId + "------------------Fin de  crearDocumento----------------");

        return dDocName;
    }
    }

    public byte[] ejecutarConstruccion(String txId, String nombrePlantilla, Documento documento, String nombre) {
        logger.debug(txId + "------------------Inicio de  ejecutarConstruccion----------------");
        logger.debug(txId + "nombrePlantilla: '" + nombrePlantilla + "'");
        //------------- Memorandum
        byte[] bytes = null;

        if (!documento.getMemorandum().equals(null)) {
            bytes = ejecutarMemorandum(txId, documento, nombrePlantilla);
        }

        return bytes;
    }


    public String ejecutarConstruccion(String txId, String nombrePlantilla, Documento documento) {
        String dDocName = null;
        //**this.documento = documento;

        logger.debug("------------------Inicio de  ejecutarConstruccion----------------");

        logger.debug("nombrePlantilla: '" + nombrePlantilla + "'");
        logger.debug("documento: " + documento);
        //-------------- Recibo de Pago

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_RECIDO_DE_PAGO)) {
            dDocName = ejecutarReciboPago(txId, documento, nombrePlantilla);
        }

        //-------------- Recibo de Pago 2 (Soporta varios servicios tupa)

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_RECIDO_DE_PAGO_2)) {
            dDocName = ejecutarReciboPago2(txId, documento, nombrePlantilla);
        }

        // -------------- Solicitud permiso FitoSanitario de Importacion

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_SOLICITUD_SFI)) {
            dDocName = ejecutarSolicitudSFI(txId, documento, nombrePlantilla);
        }

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_SOLICITUD_MODIFICACION_SFI)) {
            dDocName = ejecutarSolicitudModificacionSFI(txId, documento, nombrePlantilla);
        }

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_PFI_DEFINITIVO)) {
            dDocName = ejecutarPfiDefinitivo(txId, documento, nombrePlantilla);
        }


        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_AMPLIACION_PFI)) {
            dDocName = ejecutarPfiDefinitivo(txId, documento, nombrePlantilla);
        }

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_MODIFICACION_PFI)) {
            dDocName = ejecutarPfiDefinitivo(txId, documento, nombrePlantilla);
        }

        // -------------- Solicitud permiso ZooSanitario de Importacion

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_SOLICITUD_SZI)) {
            dDocName = ejecutarSolicitudSZI(txId, documento, nombrePlantilla);
        }

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_SOLICITUD_MODIFICACION_SZI)) {
            dDocName = ejecutarSolicitudModificacionSZI(txId, documento, nombrePlantilla);
        }

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_PZI_DEFINITIVO)) {
            dDocName = ejecutarPziDefinitivo(txId, documento, nombrePlantilla);
        }

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_AMPLIACION_PZI)) {
            dDocName = ejecutarPziDefinitivo(txId, documento, nombrePlantilla);
        }

        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_MODIFICACION_PZI)) {
            dDocName = ejecutarPziDefinitivo(txId, documento, nombrePlantilla);
        }


        if (nombrePlantilla.equals(PlantillaDocumento.PLANTILLA_RECIBO_DOCUMENTO)) {
            dDocName = ejecutarReciboDocumento(txId, documento, nombrePlantilla);
        }


        if (!documento.getMemorandum().equals(null) && documento.getMemorandum().getSubTipo() != null) {

            //------------- Carta

            if (documento.getMemorandum().getSubTipo().equals(PlantillaDocumento.PLANTILLA_CARTA)) {
                // dDocName = ejecutarMemorandum();
            }

            //------------- Faxs

            if (documento.getMemorandum().getSubTipo().equals(PlantillaDocumento.PLANTILLA_FACS)) {
                // dDocName = ejecutarMemorandum();
            }

            //------------- Oficio

            if (documento.getMemorandum().getSubTipo().equals(PlantillaDocumento.PLANTILLA_OFICIO)) {
                // dDocName = ejecutarMemorandum();
            }

        }

        logger.debug("dDocName: " + dDocName);

        logger.debug("------------------Fin de  ejecutarConstruccion----------------");

        return dDocName;
    }
    /*public String obtenerUrl(String txId,String dDocName) {
    String url =null;
    if (dDocName.indexOf("1-VISTO")>=0 || dDocName.indexOf("2-FIRMA")>=0){
      logger.debug(txId+"Url no existe para este dDocName");
      url="Url no existe para este dDocName";
    }else{
      //url= ucmClient.obtenerUrl(txId, dDocName);
      CisClient clienteCis = new CisClient();
      ICISApplication aplicacion = clienteCis.incializarAplicacion();
      clienteCis.obtenerUrl(dDocName, aplicacion)
    }
     return url;
  }*/

    private byte[] ejecutarMemorandum(String txId, Documento documento, String nombrePlantilla) {
        logger.debug(txId + "Inicio de ejecutarMemorandum ");
        byte[] bytes = null;

        String nombreArchivo = ucmClient.obtenerPlantilla(txId, nombrePlantilla);
        if (nombreArchivo != null && !nombreArchivo.isEmpty()) {
            nombreArchivo = ucmClient.PATH_FILES + nombreArchivo;

            MsWordReplace msreplace = null;
            FileInputStream input = null;
            Boolean statusReplease = false;
            try {
                logger.info(txId + "ejecutarMemorandum abrir archivo  " + nombreArchivo);
                msreplace = new MsWordReplace();
                msreplace.Open(nombreArchivo);
                logger.info(txId + " documento.getMemorandum().getPersonaDestino() ==>" +
                            documento.getMemorandum().getPersonaDestino());

                if (documento.getMemorandum().getPersonaDestino() != null) {
                    if (documento.getMemorandum().getPersonaDestino().length() <= 250) {
                        logger.info(txId + " Reemplazando persona destinos");
                        msreplace.ReplaceTextByText("bpmTagPersonaDestino", documento.getMemorandum().getPersonaDestino());
                    } else {
                      logger.info(txId + " Reemplazando persona destinos recortado");
                      msreplace.ReplaceTextByText("bpmTagPersonaDestino", documento.getMemorandum().getPersonaDestino().substring(0, 250));
                        //msreplace.ReplaceTextByText("bpmTagPersonaDestino","El valor es demasiado largo para reemplazar el tag.");
                    }
                } else {
                    msreplace.ReplaceTextByText("bpmTagPersonaDestino", "");
                }

                if (documento.getMemorandum().getSubareaDestino() != null) {
                    if (documento.getMemorandum().getSubareaDestino().length() <= 250) {
                        logger.info(txId + " Reemplazando subareas destinos");
                        msreplace.ReplaceTextByText("bpmTagSubareaDestino", documento.getMemorandum().getSubareaDestino());
                    } else {
                        logger.info(txId + " Reemplazando subareas destinos recortado");
                        msreplace.ReplaceTextByText("bpmTagSubareaDestino", documento.getMemorandum().getSubareaDestino().substring(0, 250));
                        //msreplace.ReplaceTextByText("bpmTagSubareaDestino","El valor es demasiado largo para reemplazar el tag.");
                    }
                } else {
                    msreplace.ReplaceTextByText("bpmTagSubareaDestino", "");
                }

                if (documento.getMemorandum().getAreaDestino() != null) {
                    if (documento.getMemorandum().getAreaDestino().length() <= 250) {
                        logger.info(txId + " Reemplazando area destinos");
                        msreplace.ReplaceTextByText("bpmTagAreaDestino", documento.getMemorandum().getAreaDestino());
                    } else {
                        logger.info(txId + " Reemplazando area destinos recortado");
                        msreplace.ReplaceTextByText("bpmTagAreaDestino", documento.getMemorandum().getAreaDestino().substring(0, 250));
                        //msreplace.ReplaceTextByText("bpmTagAreaDestino", "El valor es demasiado largo para reemplazar el tag.");
                    }
                } else {
                    msreplace.ReplaceTextByText("bpmTagAreaDestino", "");
                }

                if (documento.getMemorandum().getReferencia() != null) {
                    if (documento.getMemorandum().getReferencia().length() <= 250) {
                        logger.info(txId + " Reemplazando bpmTagReferencia");
                        msreplace.ReplaceTextByText("bpmTagReferencia", documento.getMemorandum().getReferencia());
                    } else {
                        logger.info(txId + " Reemplazando bpmTagReferencia recortado");
                        msreplace.ReplaceTextByText("bpmTagReferencia", documento.getMemorandum().getReferencia().substring(0, 250));
                        //msreplace.ReplaceTextByText("bpmTagReferencia", "El valor es demasiado largo para reemplazar el tag.");
                    }
                } else {
                    msreplace.ReplaceTextByText("bpmTagReferencia", "");
                }
                logger.info(txId + " Reemplazando asunto " + documento.getMemorandum().getAsunto());
                msreplace.ReplaceTextByText("bpmTagAsunto", documento.getMemorandum().getAsunto());
                if (documento.getMemorandum().getFechaRegistro() != null &&
                    documento.getMemorandum().getFechaRegistro().equals("")) {
                    msreplace.ReplaceTextByText("bpmTagFechaRegistro", documento.getMemorandum().getFechaRegistro());
                }
                //msreplace.ReplaceTextByText("bpmTagNumeroDocumento",documento.getMemorandum().getNumeroDocumento());				
                statusReplease = true;
            } catch (Exception e) {
                logger.error(txId + "ejecutarMemorandum Error==>  " + e.getMessage());
                e.printStackTrace();
            } finally {
                if (msreplace != null) {
                    msreplace.Close(nombreArchivo);
                }
            }

            if (statusReplease) {
                try {
                    logger.info(txId + "ejecutarMemorandum Escribiendo archivo en el  FileInputStream");
                    input = new FileInputStream(nombreArchivo);
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    logger.info(txId + "ejecutarMemorandum FileInputStream OK");
                } catch (Exception e) {
                    bytes = null;
                    logger.error(txId + "ejecutarMemorandum Error al escribir FileInputStream ==>  " + e.getMessage());
                    e.printStackTrace();
                } finally {
                    try {
                        if (input != null)
                            input.close();
                    } catch (Exception e) {
                        logger.warn(txId + "ejecutarMemorandum Error al cerrar FileInputStream ==>  " + e.getMessage());
                    }
                }
            }
            ucmClient.eliminarArchivo(nombreArchivo);
        }
        return bytes;

    }


    private String ejecutarPfiDefinitivo(String txId, Documento documento, String nombrePlantilla) {

        logger.debug("Entra en ejecutarPfiDefinitivo()");

        String dDocName = null;

        String nombreArchivo = ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, nombrePlantilla);

        Firmante frmnt = obtenerFirmante(documento);

        String firmaSello = "";

        if (frmnt != null)
            firmaSello =
                    ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, frmnt.getUserName() + NomenclaturaFirma.SUFIJO_FIRMA_SELLO);

        String[] firmaVisto = new String[] { };
        //firmaSello= UCMClient.PATH_FILES + UCMClient.obtenerPlantilla("falta definir");

        MsWordReplace msreplace = new MsWordReplace();

        try {
            msreplace.Open(nombreArchivo);

            msreplace.ReplaceTextByText("fechaDeEmision", remplazo(documento.getPfi().getFechaDeEmicion()));
            msreplace.ReplaceTextByText("fechaAmpliacion",
                                        remplazo(Utility.parseDateToString(documento.getPfi().getFechaAmpliacion())));
            msreplace.ReplaceTextByText("numeroExpediente", remplazo(documento.getPfi().getNoFolio()));
            msreplace.ReplaceTextByText("numeroDocumento",
                                        remplazo(documento.getPfi().getNoCertificado()) + remplazo(frmnt == null ? "" :
                                                                                                   frmnt.getNomencaltura()));
            msreplace.ReplaceTextByText("lugarEmision", remplazo(documento.getPfi().getDireccionEjecutiva()));
            msreplace.ReplaceTextByText("fechaEmision", remplazo(documento.getPfi().getFechaDeEmicion()));
            msreplace.ReplaceTextByText("fechaVigencia", remplazo(documento.getPfi().getFechaVigencia()));
            msreplace.ReplaceTextByText("nombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
            msreplace.ReplaceTextByText("docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
            // puesto de control

            String puestoControl = "";

            for (int i = 0; i < documento.getPfi().getPuntoIngresoProductoPFI().size(); i++) {
                puestoControl =
                        puestoControl + documento.getPfi().getPuntoIngresoProductoPFI().get(i).getPuntoIngresoProducto() + "\n";
            }

            msreplace.ReplaceTextByText("puestoControl", remplazo(puestoControl));

            // llenar tabla de productos
            ArrayList listaProductos = new ArrayList();

            ArrayList valores = null;

            ProductoPFI producto = null;

            logger.debug("Antes de ejecutar ciclo de los productos PFI");
            logger.debug("Numero de productos PFI (padres):" + documento.getPfi().getProductosPFI().size());

            for (int i = 0; i < documento.getPfi().getProductosPFI().size(); i++) {
                producto = documento.getPfi().getProductosPFI().get(i);
                logger.debug("Producto PFI Padre Codigo: '" + producto.getCodigoProducto().trim() + "'");

                valores = new ArrayList();

                if (i == 0) {
                    // uso destino
                    msreplace.ReplaceTextByText("usoDestino", remplazo("" + producto.getUsoDestino()));
                }

                boolean contieneAnexos = producto.isContieneAnexos();

                logger.debug("Producto PFI Padre isContieneAnexos():" + producto.isContieneAnexos());

                if (contieneAnexos == true) {
                    ArrayList listaAnexos = documento.getPfi().getAnexosPFI();

                    AnexoPFI anexo = null;

                    logger.debug("Numero de Anexos del Producto PFI Padre:" + listaAnexos.size());

                    for (int j = 0; j < listaAnexos.size(); j++) {
                        anexo = (AnexoPFI)listaAnexos.get(j);

                        if (anexo.equals(null))
                            logger.debug("Valor del objeto (AnexoPFI)listaAnexos.get(j) es NULO.");
                        else
                            logger.debug("Producto PFI Padre DEL DOCUMENTO (Hijo):'" + anexo.getCodigoPadre() + "'");


                        logger.debug("Verifica si ambos son IGUALES");
                        if (anexo.getCodigoPadre().trim().equals(producto.getCodigoProducto().trim())) {
                            logger.debug("Obteniendo Anexo del Producto PFI Padre (Hijo):" + anexo.getCodigoPadre());
                            valores = new ArrayList();
                            // partida arancelaria
                            valores.add(remplazo(anexo.getPartidaArancelaria()));
                            // nombre
                            valores.add(remplazo(anexo.getDescripcion()));
                            //nombre cientifico
                            valores.add(remplazo(anexo.getNombreCientifico()));
                            // peso
                            valores.add("" + anexo.getPesoNeto() + " " + remplazo(anexo.getCodUniMed()));
                            //cantidad de envases
                            valores.add("" + anexo.getCantidad() == null ? "" : anexo.getCantidad());
                            // peso tipo envase
                            valores.add(remplazo(anexo.getTipoEnvase()));
                            // agregar a la lista
                            listaProductos.add(valores);
                            logger.debug("Se añadira el anexo " + anexo.getCodigo() + " - " + anexo.getDescripcion() +
                                         " para su impresion.");

                        }

                    }


                } else {
                    valores = new ArrayList();
                    // partida arancelaria
                    valores.add(remplazo(producto.getPartidaArancelaria()));
                    // nombre
                    valores.add(remplazo(producto.getDescripcion()));
                    //nombre cientifico
                    valores.add(remplazo(producto.getNombreCientifico()));
                    // peso
                    valores.add("" + producto.getPesoNeto() + " " + remplazo(producto.getCodUniMed()));
                    //cantidad de envases
                    valores.add("" + producto.getCantidad() == null ? "" : producto.getCantidad());
                    // peso tipo envase
                    valores.add(remplazo(producto.getTipoEnvase()));
                    // agregar a la lista
                    listaProductos.add(valores);

                    logger.debug("Solo se añadira el padre.");

                }

            }

            // llenar tabla de productos
            msreplace.FillTable("listProductos", listaProductos);
            logger.debug("Se añadieron anexos de listaProductos para su impresion.");

            // llenar lista Requisitos Sanitarios
            ArrayList listaRequisitosSanitarios = new ArrayList();

            RequisitoDao requisito = null;

            for (int i = 0; i < documento.getRequisitosSanitarios().size(); i++) {
                valores = new ArrayList();

                requisito = documento.getRequisitosSanitarios().get(i);

                if (requisito == null)
                    continue;
                // requisito
                valores.add(remplazo(requisito.getEtiqueta()) + " " + remplazo(requisito.getDescripcionRequisito()));

                listaRequisitosSanitarios.add(valores);

            }

            // llenar lista Requisitos Sanitarios
            msreplace.FillTable("listRequisitos", listaRequisitosSanitarios);

            // llenar origen y lugar de produccion
            String paisLugarProduccion = "";

            PaisOrigenProductoPFI paisOrigen = null;

            for (int i = 0; i < documento.getPfi().getPaisesOrigenProductoPFI().size(); i++) {
                paisOrigen = documento.getPfi().getPaisesOrigenProductoPFI().get(i);

                //paisLugarProduccion+=paisOrigen.getPaisOrigenProducto()+","+remplazo(paisOrigen.getLugarProduccion())+"\n";
                paisLugarProduccion +=
                        paisOrigen.getPaisOrigenProducto() + (remplazo(paisOrigen.getLugarProduccion()) != "" ? "," +
                                                              remplazo(paisOrigen.getLugarProduccion()) : "");
            }
            // insertar string en tabla  origen y lugar de produccion
            msreplace.ReplaceTextByText("origenProducto", remplazo(paisLugarProduccion));

            // procedencia de los productos
            msreplace.ReplaceTextByText("procedenciaProducto",
                                        remplazo("" + documento.getPfi().getProductosPFI().get(0).getPaisProcedencia()));

            msreplace.ReplaceTextByImage("firmaSello", firmaSello);

            int _nPages = msreplace.getCounterPages();

            for (int i = 1; i <= _nPages - 1; i++) {
                msreplace.InsertStripImagesAtLeft(firmaVisto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msreplace != null) {
                msreplace.Close(nombreArchivo);
            }
        }

        dDocName = ucmClient.ingresarDocumento(txId, nombreArchivo, documento);

        ucmClient.eliminarArchivo(firmaSello);

        return dDocName;


    }


    private String ejecutarAmpliacionPFI(Documento documento, String nombrePlantilla) {
        this.profileTrigger = "STD-SOIM";
        this.tipoDocumento = "SOIM";
        this.subTipoDocumento = "FITO";

        logger.debug("Entra en ejecutarPfiAmpliacion");

        String dDocName = null;

        String nombreArchivo = null;

        String nombrePlantilla1 = null;

        nombrePlantilla1 = obtenerPlantilla(nombrePlantilla);

        TagsBPM tags = null;

        try {
            tags = new TagsBPM(nombrePlantilla1);
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal(e);
        }

        tags.addSearchTerm("fechaDeEmision", remplazo(documento.getPfi().getFechaDeEmicion()));
        tags.addSearchTerm("numeroExpediente", remplazo(documento.getPfi().getNoFolio()));
        tags.addSearchTerm("numeroDocumento", remplazo(documento.getPfi().getNoCertificado()));
        tags.addSearchTerm("lugarEmision", remplazo(documento.getPfi().getDireccionEjecutiva()));
        tags.addSearchTerm("fechaEmision", remplazo(documento.getPfi().getFechaDeEmicion()));
        tags.addSearchTerm("fechaVigencia", remplazo(documento.getPfi().getFechaVigencia()));
        tags.reemplazarEnTabla(0, 0, 0, "nombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
        tags.reemplazarEnTabla(0, 0, 0, "docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
        tags.reemplazarEnTabla(3, 1, 0, "usoDestino",
                               remplazo("" + documento.getPfi().getProductosPFI().get(0).getUsoDestino()));
        tags.reemplazarEnTabla(3, 1, 1, "puestoControl", remplazo(documento.getSolicitante().getDniRuc()));

        // llenar tabla de productos

        ArrayList listaProductos = new ArrayList();

        ArrayList valores = null;

        ProductoPFI producto = null;

        for (int i = 0; i < documento.getPfi().getProductosPFI().size(); i++) {
            producto = documento.getPfi().getProductosPFI().get(i);

            valores = new ArrayList();

            // partida arancelaria
            valores.add(remplazo(producto.getPartidaArancelaria()));
            // nombre
            valores.add(remplazo(producto.getDescripcion()));
            //nombre cientifico
            valores.add(remplazo(producto.getNombreCientifico()));
            // peso neto / cantidad de plantas
            valores.add(remplazo(producto.getPesoNeto() + " " + producto.getCodUniMed()));
            // tipo de envase
            valores.add(remplazo(producto.getCantidad() + " " + producto.getTipoEnvase()));

            // agregar a la lista
            listaProductos.add(valores);

        }

        // llenar tabla de productos
        tags.agregarDatosTabla(2, true, listaProductos);

        // llenar lista Requisitos Sanitarios
        ArrayList listaRequisitosSanitarios = new ArrayList();

        RequisitoDao requisito = null;

        for (int i = 0; i < documento.getRequisitosSanitarios().size(); i++) {
            valores = new ArrayList();

            requisito = documento.getRequisitosSanitarios().get(i);

            // requisito

            valores.add(remplazo(requisito.getEtiqueta() + " " + requisito.getDescripcionRequisito()));

            listaRequisitosSanitarios.add(valores);

        }

        // llenar lista Requisitos Sanitarios
        tags.agregarDatosTabla(4, true, listaRequisitosSanitarios);

        // llenar origen y lugar de produccion

        String paisLugarProduccion = "";

        PaisOrigenProductoPFI paisOrigen = null;

        for (int i = 0; i < documento.getPfi().getPaisesOrigenProductoPFI().size(); i++) {
            paisOrigen = documento.getPfi().getPaisesOrigenProductoPFI().get(i);

            paisLugarProduccion += paisOrigen.getPaisOrigenProducto() + "," + paisOrigen.getLugarProduccion() + "\n";
        }

        // insertar string en tabla  origen y lugar de produccion
        tags.reemplazarEnTabla(3, 0, 0, "origenProducto", remplazo(paisLugarProduccion));

        // procedencia de los productos
        tags.reemplazarEnTabla(3, 0, 1, "procedenciaProducto",
                               remplazo("" + documento.getPfi().getProductosPFI().get(0).getPaisProcedencia()));


        // uso destino


        try {
            tags.searchReplace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.fatal(e);
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        int indice1 = nombrePlantilla1.lastIndexOf("/");
        int indice2 = nombrePlantilla1.indexOf("_");
        int indice3 = nombrePlantilla1.lastIndexOf(".");

        nombreArchivo =
                nombrePlantilla1.substring(indice2 + 1, indice3) + "_" + documento.getSolicitante().getNombreRazonSocial() +
                nombrePlantilla1.substring(indice3);

        logger.debug("nombreArchivo:" + nombreArchivo);


        dDocName = establecerIngreso(nombrePlantilla1, nombreArchivo, documento);

        return dDocName;

    }


    private String ejecutarAmpliacionPZI(Documento documento, String nombrePlantilla) {
        this.profileTrigger = "STD-SOIM";
        this.tipoDocumento = "SOIM";
        this.subTipoDocumento = "FITO";

        logger.debug("Entra en ejecutarAmpliacionPZI");

        String dDocName = null;

        String nombreArchivo = null;

        String nombrePlantilla1 = null;

        nombrePlantilla1 = obtenerPlantilla(nombrePlantilla);

        TagsBPM tags = null;

        try {
            tags = new TagsBPM(nombrePlantilla1);
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal(e);
        }

        tags.addSearchTerm("fechaDeEmision", remplazo(Utility.parseDateToString(documento.getPzi().getFechaEmision())));
        tags.addSearchTerm("numeroExpediente", remplazo(documento.getPzi().getNoFolio()));
        tags.addSearchTerm("numeroDocumento", remplazo(documento.getPzi().getNoCertificado()));
        tags.addSearchTerm("lugarEmision", remplazo(documento.getPzi().getDireccionEjecutiva()));
        tags.addSearchTerm("fechaAmpliacion", remplazo(Utility.parseDateToString(documento.getPzi().getFechaAmpliacion())));
        tags.reemplazarEnTabla(0, 0, 0, "nombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
        tags.reemplazarEnTabla(0, 0, 0, "docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
        tags.reemplazarEnTabla(3, 1, 0, "usoDestino", remplazo("" + documento.getPzi().getProductoPZI().getUsoDestino()));
        tags.reemplazarEnTabla(3, 1, 1, "puestoControl", remplazo(documento.getSolicitante().getDniRuc()));

        // llenar tabla de productos

        ArrayList listaProductos = new ArrayList();

        ArrayList valores = null;

        ProductoPFI producto = null;

        for (int i = 0; i < documento.getPfi().getProductosPFI().size(); i++) {
            producto = documento.getPfi().getProductosPFI().get(i);

            valores = new ArrayList();

            // partida arancelaria
            valores.add(remplazo(producto.getPartidaArancelaria()));
            // nombre
            valores.add(remplazo(producto.getDescripcion()));
            //nombre cientifico
            valores.add(remplazo(producto.getNombreCientifico()));
            // peso neto / cantidad de plantas
            valores.add(remplazo(producto.getPesoNeto() + " " + producto.getCodUniMed()));
            // tipo de envase
            valores.add(remplazo(producto.getCantidad() + " " + producto.getTipoEnvase()));

            // agregar a la lista
            listaProductos.add(valores);

        }

        // llenar tabla de productos
        tags.agregarDatosTabla(2, true, listaProductos);

        // llenar lista Requisitos Sanitarios
        ArrayList listaRequisitosSanitarios = new ArrayList();

        RequisitoDao requisito = null;

        for (int i = 0; i < documento.getRequisitosSanitarios().size(); i++) {
            valores = new ArrayList();

            requisito = documento.getRequisitosSanitarios().get(i);

            // requisito

            valores.add(remplazo(requisito.getEtiqueta() + " " + requisito.getDescripcionRequisito()));

            listaRequisitosSanitarios.add(valores);

        }

        // llenar lista Requisitos Sanitarios
        tags.agregarDatosTabla(4, true, listaRequisitosSanitarios);

        // llenar origen y lugar de produccion

        String paisLugarProduccion = "";

        PaisOrigenProductoPFI paisOrigen = null;

        for (int i = 0; i < documento.getPfi().getPaisesOrigenProductoPFI().size(); i++) {
            paisOrigen = documento.getPfi().getPaisesOrigenProductoPFI().get(i);

            paisLugarProduccion += paisOrigen.getPaisOrigenProducto() + "," + paisOrigen.getLugarProduccion() + "\n";
        }

        // insertar string en tabla  origen y lugar de produccion
        tags.reemplazarEnTabla(3, 0, 0, "origenProducto", remplazo(paisLugarProduccion));

        // procedencia de los productos
        tags.reemplazarEnTabla(3, 0, 1, "procedenciaProducto",
                               remplazo("" + documento.getPfi().getProductosPFI().get(0).getPaisProcedencia()));


        // uso destino


        try {
            tags.searchReplace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.fatal(e);
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        int indice1 = nombrePlantilla1.lastIndexOf("/");
        int indice2 = nombrePlantilla1.indexOf("_");
        int indice3 = nombrePlantilla1.lastIndexOf(".");

        nombreArchivo =
                nombrePlantilla1.substring(indice2 + 1, indice3) + "_" + documento.getSolicitante().getNombreRazonSocial() +
                nombrePlantilla1.substring(indice3);

        logger.debug("nombreArchivo:" + nombreArchivo);


        dDocName = establecerIngreso(nombrePlantilla1, nombreArchivo, documento);

        return dDocName;

    }


    private String ejecutarModificacionPZI(Documento documento, String nombrePlantilla) {
        this.profileTrigger = "STD-SOIM";
        this.tipoDocumento = "SOIM";
        this.subTipoDocumento = "FITO";

        logger.debug("Entra en ejecutarModificacionPZI");
        String dDocName = null;
        String nombreArchivo = null;
        String nombrePlantilla1 = null;
        nombrePlantilla1 = obtenerPlantilla(nombrePlantilla);
        TagsBPM tags = null;

        try {
            tags = new TagsBPM(nombrePlantilla1);
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal(e);
        }

        tags.addSearchTerm("fechaDeEmision", remplazo(documento.getPfi().getFechaDeEmicion()));
        tags.addSearchTerm("numeroExpediente", remplazo(documento.getPfi().getNoFolio()));
        tags.addSearchTerm("numeroDocumento", remplazo(documento.getPfi().getNoCertificado()));
        tags.addSearchTerm("lugarEmision", remplazo(documento.getPfi().getDireccionEjecutiva()));
        tags.addSearchTerm("fechaEmision", remplazo(documento.getPfi().getFechaDeEmicion()));
        // TODO falta definir la fecha de ampliacion  IMPORTANTE
        //tags.addSearchTerm("fechaAmpliacion",remplazo(documento.getPfi().));
        tags.addSearchTerm("fechaVigencia", remplazo("FALTA_FECHA_VIGENCIA"));
        tags.reemplazarEnTabla(0, 0, 0, "nombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
        tags.reemplazarEnTabla(0, 0, 0, "docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
        tags.reemplazarEnTabla(3, 1, 0, "usoDestino",
                               remplazo("" + documento.getPfi().getProductosPFI().get(0).getUsoDestino()));
        tags.reemplazarEnTabla(3, 1, 1, "puestoControl", remplazo(documento.getSolicitante().getDniRuc()));


        // llenar tabla de productos

        ArrayList listaProductos = new ArrayList();

        ArrayList valores = null;

        ProductoPFI producto = null;

        for (int i = 0; i < documento.getPfi().getProductosPFI().size(); i++) {
            producto = documento.getPfi().getProductosPFI().get(i);

            valores = new ArrayList();

            // partida arancelaria
            valores.add(remplazo(producto.getPartidaArancelaria()));
            // nombre
            valores.add(remplazo(producto.getDescripcion()));
            //nombre cientifico
            valores.add(remplazo(producto.getNombreCientifico()));
            // peso neto / cantidad de plantas
            valores.add(remplazo(producto.getPesoNeto() + " " + producto.getCodUniMed()));
            // tipo de envase
            valores.add(remplazo(producto.getCantidad() + " " + producto.getTipoEnvase()));

            // agregar a la lista
            listaProductos.add(valores);

        }

        // llenar tabla de productos
        tags.agregarDatosTabla(2, true, listaProductos);

        // llenar lista Requisitos Sanitarios
        ArrayList listaRequisitosSanitarios = new ArrayList();

        RequisitoDao requisito = null;

        for (int i = 0; i < documento.getRequisitosSanitarios().size(); i++) {
            valores = new ArrayList();

            requisito = documento.getRequisitosSanitarios().get(i);

            // requisito

            valores.add(remplazo(requisito.getEtiqueta()) + " " + remplazo(requisito.getDescripcionRequisito()));

            listaRequisitosSanitarios.add(valores);

        }

        // llenar lista Requisitos Sanitarios
        tags.agregarDatosTabla(4, true, listaRequisitosSanitarios);

        // llenar origen y lugar de produccion

        String paisLugarProduccion = "";

        PaisOrigenProductoPFI paisOrigen = null;

        for (int i = 0; i < documento.getPfi().getPaisesOrigenProductoPFI().size(); i++) {
            paisOrigen = documento.getPfi().getPaisesOrigenProductoPFI().get(i);

            paisLugarProduccion += paisOrigen.getPaisOrigenProducto() + "," + paisOrigen.getLugarProduccion() + "\n";
        }

        // insertar string en tabla  origen y lugar de produccion
        tags.reemplazarEnTabla(3, 0, 0, "origenProducto", remplazo(paisLugarProduccion));

        // procedencia de los productos
        tags.reemplazarEnTabla(3, 0, 1, "procedenciaProducto",
                               remplazo("" + documento.getPfi().getProductosPFI().get(0).getPaisProcedencia()));


        // uso destino


        try {
            tags.searchReplace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.fatal(e);
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        int indice1 = nombrePlantilla1.lastIndexOf("/");
        int indice2 = nombrePlantilla1.indexOf("_");
        int indice3 = nombrePlantilla1.lastIndexOf(".");

        nombreArchivo =
                nombrePlantilla1.substring(indice2 + 1, indice3) + "_" + documento.getSolicitante().getNombreRazonSocial() +
                nombrePlantilla1.substring(indice3);

        logger.debug("nombreArchivo:" + nombreArchivo);


        dDocName = establecerIngreso(nombrePlantilla1, nombreArchivo, documento);

        return dDocName;
    }

    private String obtenerPlantilla(String nombrePlantilla) {
        return "C:/temporal/" + clienteCis.obtenerPlantilla(nombrePlantilla, clienteCis.incializarAplicacion());
    }

    private String ejecutarModificacionPFI(Documento documento, String nombrePlantilla) {
        this.profileTrigger = "STD-SOIM";
        this.tipoDocumento = "SOIM";
        this.subTipoDocumento = "FITO";

        logger.debug("Entra en ejecutarModificacionPFI");

        String dDocName = null;

        String nombreArchivo = null;

        String nombrePlantilla1 = null;

        nombrePlantilla1 = obtenerPlantilla(nombrePlantilla);

        TagsBPM tags = null;

        try {
            tags = new TagsBPM(nombrePlantilla1);
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal(e);
        }

        tags.addSearchTerm("fechaDeEmision", remplazo(documento.getPfi().getFechaDeEmicion()));
        tags.addSearchTerm("numeroExpediente", remplazo(documento.getPfi().getNoFolio()));
        tags.addSearchTerm("numeroDocumento", remplazo(documento.getPfi().getNoCertificado()));
        tags.addSearchTerm("lugarEmision", remplazo(documento.getPfi().getDireccionEjecutiva()));
        tags.addSearchTerm("fechaEmision", remplazo(documento.getPfi().getFechaDeEmicion()));
        tags.addSearchTerm("fechaVigencia", remplazo(documento.getPfi().getFechaVigencia()));
        tags.reemplazarEnTabla(0, 0, 0, "nombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
        tags.reemplazarEnTabla(0, 0, 0, "docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
        tags.reemplazarEnTabla(3, 1, 0, "usoDestino",
                               remplazo("" + documento.getPfi().getProductosPFI().get(0).getUsoDestino()));
        tags.reemplazarEnTabla(3, 1, 1, "puestoControl", remplazo(documento.getSolicitante().getDniRuc()));


        // llenar tabla de productos

        ArrayList listaProductos = new ArrayList();

        ArrayList valores = null;

        ProductoPFI producto = null;

        for (int i = 0; i < documento.getPfi().getProductosPFI().size(); i++) {
            producto = documento.getPfi().getProductosPFI().get(i);

            valores = new ArrayList();

            // partida arancelaria
            valores.add(remplazo(producto.getPartidaArancelaria()));
            // nombre
            valores.add(remplazo(producto.getDescripcion()));
            //nombre cientifico
            valores.add(remplazo(producto.getNombreCientifico()));
            // peso neto / cantidad de plantas
            valores.add(remplazo(producto.getPesoNeto() == null ? "" : producto.getPesoNeto() + " " + producto.getCodUniMed()));
            // tipo de envase
            valores.add(remplazo(producto.getCantidad() == null ? "" : producto.getCantidad() + " " + producto.getTipoEnvase()));

            // agregar a la lista
            listaProductos.add(valores);

        }

        // llenar tabla de productos
        tags.agregarDatosTabla(2, true, listaProductos);

        // llenar lista Requisitos Sanitarios
        ArrayList listaRequisitosSanitarios = new ArrayList();

        RequisitoDao requisito = null;

        for (int i = 0; i < documento.getRequisitosSanitarios().size(); i++) {
            valores = new ArrayList();

            requisito = documento.getRequisitosSanitarios().get(i);

            // requisito

            valores.add(remplazo(requisito.getEtiqueta() + " " + requisito.getDescripcionRequisito()));

            listaRequisitosSanitarios.add(valores);

        }

        // llenar lista Requisitos Sanitarios
        tags.agregarDatosTabla(4, true, listaRequisitosSanitarios);

        // llenar origen y lugar de produccion

        String paisLugarProduccion = "";

        PaisOrigenProductoPFI paisOrigen = null;

        for (int i = 0; i < documento.getPfi().getPaisesOrigenProductoPFI().size(); i++) {
            paisOrigen = documento.getPfi().getPaisesOrigenProductoPFI().get(i);

            paisLugarProduccion += paisOrigen.getPaisOrigenProducto() + "," + paisOrigen.getLugarProduccion() + "\n";
        }

        // insertar string en tabla  origen y lugar de produccion
        tags.reemplazarEnTabla(3, 0, 0, "origenProducto", remplazo(paisLugarProduccion));

        // procedencia de los productos
        tags.reemplazarEnTabla(3, 0, 1, "procedenciaProducto",
                               remplazo("" + documento.getPfi().getProductosPFI().get(0).getPaisProcedencia()));


        // uso destino


        try {
            tags.searchReplace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.fatal(e);
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        int indice1 = nombrePlantilla1.lastIndexOf("/");
        int indice2 = nombrePlantilla1.indexOf("_");
        int indice3 = nombrePlantilla1.lastIndexOf(".");

        nombreArchivo =
                nombrePlantilla1.substring(indice2 + 1, indice3) + "_" + documento.getSolicitante().getNombreRazonSocial() +
                nombrePlantilla1.substring(indice3);

        logger.debug("nombreArchivo:" + nombreArchivo);


        dDocName = establecerIngreso(nombrePlantilla1, nombreArchivo, documento);

        return dDocName;
    }


    private String ejecutarSolicitudSFI(String txId, Documento documento, String nombrePlantilla) {

        logger.debug("Entra en ejecutarSolicitudSFI");

        String dDocName = null;

        String nombreArchivo = ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, nombrePlantilla);

        MsWordReplace msreplace = new MsWordReplace();

        try {
            msreplace.Open(nombreArchivo);

            msreplace.ReplaceTextByText("fechaDeEmision", remplazo(documento.getPfi().getFechaDeEmicion()));
            msreplace.ReplaceTextByText("direccionEjecutiva", remplazo(documento.getPfi().getDireccionEjecutiva()));
            msreplace.ReplaceTextByText("dniRucSolicitante", remplazo(documento.getSolicitante().getDniRuc()));
            msreplace.ReplaceTextByText("nombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
            msreplace.ReplaceTextByText("docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
            msreplace.ReplaceTextByText("distritoSolicitante", remplazo(documento.getSolicitante().getDistrito()));
            msreplace.ReplaceTextByText("provinciaSolicitante", remplazo(documento.getSolicitante().getProvincia()));
            msreplace.ReplaceTextByText("departamentoSolicitante", remplazo(documento.getSolicitante().getDepartamento()));
            msreplace.ReplaceTextByText("telefonoSolicitante", remplazo(documento.getSolicitante().getTelefono()));
            msreplace.ReplaceTextByText("emailSolicitantante", remplazo(documento.getSolicitante().getEmail()));
            msreplace.ReplaceTextByText("nombreRepresentanteLegalSolicitante",
                                        remplazo(documento.getSolicitante().getNombreRepresentanteLegal()));
            msreplace.ReplaceTextByText("dniRepresentanteLegalSolicitante",
                                        remplazo(documento.getSolicitante().getDniRepresentanteLegal()));

            // llenar tabla de productos

            ArrayList listaProductos = new ArrayList();

            ArrayList valores = null;

            ProductoPFI producto = null;

            logger.debug("Numero de productos PFI (padres):" + documento.getPfi().getProductosPFI().size());

            for (int i = 0; i < documento.getPfi().getProductosPFI().size(); i++) {
                producto = documento.getPfi().getProductosPFI().get(i);
                logger.debug("Producto PFI Padre Codigo: '" + producto.getCodigoProducto().trim() + "'");

                valores = new ArrayList();

                // partida arancelaria
                valores.add(remplazo(producto.getPartidaArancelaria()));
                // nombre
                valores.add(remplazo(producto.getDescripcion()));
                //nombre cientifico
                valores.add(remplazo(producto.getNombreCientifico()));
                // cantidad
                valores.add(producto.getCantidad() == null ? "" : producto.getCantidad());
                // tipo de envase
                valores.add(remplazo(producto.getTipoEnvase()));
                // peso neto
                valores.add(remplazo(producto.getPesoNeto() == null ? "" :
                                     producto.getPesoNeto() + " " + producto.getCodUniMed()));
                // cantidad de plantas
                valores.add(remplazo(producto.getCantidadPlantas()));
                // agregar a la lista
                listaProductos.add(valores);

                boolean contieneAnexos = producto.isContieneAnexos();

                logger.debug("producto.isContieneAnexos():" + producto.isContieneAnexos());
                logger.debug("Numero de Anexos del Producto PFI Padre:" + documento.getPfi().getAnexosPFI().size());

                if (contieneAnexos == true) {
                    ArrayList listaAnexos = documento.getPfi().getAnexosPFI();

                    AnexoPFI anexo = null;

                    for (int j = 0; j < listaAnexos.size(); j++) {
                        anexo = (AnexoPFI)listaAnexos.get(j);

                        valores = new ArrayList();
                        logger.debug("Obteniendo Anexo del Producto PFI Padre DEL DOCUMENTO (Hijo):'" +
                                     anexo.getCodigoPadre().trim() + "'");
                        if (anexo.getCodigoPadre().trim().equals(producto.getCodigoProducto().trim())) {
                            // partida arancelaria
                            valores.add(remplazo(anexo.getPartidaArancelaria()));
                            // nombre
                            valores.add(remplazo(anexo.getDescripcion()));
                            //nombre cientifico
                            valores.add(remplazo(anexo.getNombreCientifico()));
                            // cantidad
                            valores.add("" + anexo.getCantidad());
                            // tipo de envase
                            valores.add(remplazo(anexo.getTipoEnvase()));
                            // peso neto
                            valores.add(remplazo(anexo.getPesoNeto() + " " + anexo.getCodUniMed()));
                            // cantidad de plantas
                            valores.add(remplazo(anexo.getCantidadPlantas()));
                            // agregar a la lista
                            listaProductos.add(valores);
                            logger.debug("Se añadira el anexo " + anexo.getCodigo() + " - " + anexo.getDescripcion() +
                                         " para su impresion.");
                        }
                    }
                }

            }

            // llenar tabla de productos
            msreplace.FillTable("listProductos", listaProductos);

            // llenar lugares produccion
            ArrayList listaLugarProduccion = new ArrayList();

            PaisOrigenProductoPFI paisOrigen = null;

            for (int i = 0; i < documento.getPfi().getPaisesOrigenProductoPFI().size(); i++) {
                valores = new ArrayList();

                paisOrigen = documento.getPfi().getPaisesOrigenProductoPFI().get(i);

                // pais de origen
                valores.add(remplazo("" + paisOrigen.getPaisOrigenProducto()));
                // lugares de produccion
                valores.add(remplazo("" + paisOrigen.getLugarProduccion()));

                listaLugarProduccion.add(valores);

            }

            // llenar tabla de lugar de produccion
            msreplace.FillTable("listLugarProduccion", listaLugarProduccion);


            // llenar lista punto de ingreso

            ArrayList listaPuntoIngreso = new ArrayList();

            PuntoIngresoProductoPFI puntoIngreso = null;

            for (int i = 0; i < documento.getPfi().getPuntoIngresoProductoPFI().size(); i++) {
                valores = new ArrayList();

                puntoIngreso = documento.getPfi().getPuntoIngresoProductoPFI().get(i);

                // Punto Ingreso Producto
                valores.add(remplazo("" + puntoIngreso.getPuntoIngresoProducto()));

                listaPuntoIngreso.add(valores);

            }

            // llenar tabla de lugar de produccion
            msreplace.FillTable("listPuntoIngreso", listaPuntoIngreso);


            // Punto Pais Procedencia
            msreplace.ReplaceTextByText("paisProcedencia",
                                        remplazo("" + documento.getPfi().getProductosPFI().get(0).getPaisProcedencia()));
            // Punto Uso destino
            msreplace.ReplaceTextByText("usoDestino",
                                        remplazo("" + documento.getPfi().getProductosPFI().get(0).getUsoDestino()));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msreplace != null) {
                msreplace.Close(nombreArchivo);
            }
        }

        dDocName = ucmClient.ingresarDocumento(txId, nombreArchivo, documento);

        return dDocName;

    }

    private String ejecutarSolicitudSZI(String txId, Documento documento, String nombrePlantilla) {

        logger.debug("Entra en ejecutarSolicitudSZI");

        String dDocName = null;

        String nombreArchivo = ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, nombrePlantilla);

        MsWordReplace msreplace = new MsWordReplace();

        try {
            msreplace.Open(nombreArchivo);

            msreplace.ReplaceTextByText("fechaDeEmision",
                                        remplazo(Utility.parseDateToString(documento.getPzi().getFechaEmision())));
            msreplace.ReplaceTextByText("direccionEjecutiva", remplazo(documento.getPzi().getDireccionEjecutiva()));
            msreplace.ReplaceTextByText("dniRucSolicitante", remplazo(documento.getSolicitante().getDniRuc()));
            msreplace.ReplaceTextByText("nmbrSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
            msreplace.ReplaceTextByText("docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
            msreplace.ReplaceTextByText("provinciaSolicitante", remplazo(documento.getSolicitante().getProvincia()));
            msreplace.ReplaceTextByText("distritoSolicitante", remplazo(documento.getSolicitante().getDistrito()));
            msreplace.ReplaceTextByText("departamentoSolicitante", remplazo(documento.getSolicitante().getDepartamento()));
            msreplace.ReplaceTextByText("telefonoSolicitante", remplazo(documento.getSolicitante().getTelefono()));
            msreplace.ReplaceTextByText("emailSolicitantante", remplazo(documento.getSolicitante().getEmail()));
            msreplace.ReplaceTextByText("nombreRepresentanteLegalSolicitante",
                                        remplazo(documento.getSolicitante().getNombreRepresentanteLegal()));
            msreplace.ReplaceTextByText("dniRepresentanteLegalSolicitante",
                                        remplazo(documento.getSolicitante().getDniRepresentanteLegal()));

            // llenar tabla de productos

            ArrayList listaProductos = new ArrayList();

            ArrayList valores = null;

            ProductoPZI producto = null;

            producto = documento.getPzi().getProductoPZI();

            if (producto.getEsAnimal()) {

                valores = new ArrayList();

                // partida arancelaria
                valores.add(remplazo(producto.getPartidaArancelaria()));
                // Peso neto
                valores.add("");
                // numero de Anilames
                valores.add(remplazo("" + producto.getNumeroAnimales()));

                // agregar a la lista
                listaProductos.add(valores);

                // llenar tabla de productos
                msreplace.FillTable("listProductos", listaProductos);

                // llenar animales vivos
                msreplace.ReplaceTextByText("animalVivo", remplazo(producto.getAnimalesVivos()));

                logger.debug("producto.getAnimalesVivos():" + producto.getAnimalesVivos());

                // llenar lista productos o sub productos
                ArrayList listaPuntoIngreso = new ArrayList();

                valores = new ArrayList();

                // Producto o sub producto
                valores.add(remplazo("" + producto.getDescripcion()));
                // tipo envase
                valores.add(remplazo("" + producto.getTipoEnvase()));

                listaPuntoIngreso.add(valores);

                // llenar tabla de productos hijos
                msreplace.FillTable("listPuntoIngreso", listaPuntoIngreso);

            }

            if (producto.getEsAnimal() == false) {

                valores = new ArrayList();
                ArrayList valores2 = new ArrayList();

                // llenar lista productos o sub productos
                ArrayList listaPuntoIngreso = new ArrayList();

                // partida arancelaria
                valores.add(remplazo(producto.getPartidaArancelaria()));
                // Peso neto
                valores.add(remplazo("" + producto.getPesoNeto()) + " " + remplazo(producto.getCodUniMed()));
                //nombre numero de Anilames
                valores.add("");

                // agregar a la lista
                listaProductos.add(valores);

                // Producto o sub producto
                valores2.add(remplazo("" + producto.getDescripcion()));
                // tipo envase
                valores2.add(remplazo("" + producto.getTipoEnvase()));

                listaPuntoIngreso.add(valores2);

                if (producto.getContieneAnexos()) {

                    AnexoPFI anexo = null;

                    for (int i = 0; i < documento.getPzi().getAnexosPZI().size(); i++) {
                        valores = new ArrayList();

                        valores2 = new ArrayList();

                        anexo = documento.getPzi().getAnexosPZI().get(i);

                        // partida arancelaria
                        valores.add(remplazo(anexo.getPartidaArancelaria()));
                        // Peso neto
                        valores.add(remplazo(anexo.getPesoNeto() + " " + anexo.getCodUniMed()));
                        //nombre numero de Anilames
                        valores.add("");

                        // Producto o sub producto
                        valores2.add(remplazo("" + anexo.getDescripcion()));
                        // tipo envase
                        valores2.add(remplazo("" + anexo.getTipoEnvase()));

                        // agregar a la lista
                        listaProductos.add(valores);

                        listaPuntoIngreso.add(valores2);

                    }

                }

                // llenar tabla de productos
                msreplace.FillTable("listProductos", listaProductos);

                // llenar tabla de productos hijos
                msreplace.FillTable("listPuntoIngreso", listaPuntoIngreso);

            }

            // llenar pais origen

            ArrayList listaPaisOrigen = new ArrayList();

            PaisOrigenProductoPFI paisAnexo = null;

            for (int i = 0; i < documento.getPzi().getPaisesOrigenProductoPZI().size(); i++) {
                valores = new ArrayList();

                paisAnexo = documento.getPzi().getPaisesOrigenProductoPZI().get(i);

                // pais de origen
                valores.add(remplazo(paisAnexo.getPaisOrigenProducto()));

                listaPaisOrigen.add(valores);
            }

            // llenar tabla de pais origen
            msreplace.FillTable("listPaisOrigen", listaPaisOrigen);

            // llenar uso destino
            msreplace.ReplaceTextByText("usoDestino", remplazo(documento.getPzi().getProductoPZI().getUsoDestino()));
            // llenar pais de procedencia
            msreplace.ReplaceTextByText("paisProcedencia", remplazo(documento.getPzi().getProductoPZI().getPaisProcedencia()));

            // llenar fecha probable de salida
            msreplace.ReplaceTextByText("fechaProbableSalida",
                                        remplazo(Utility.parseDateToString(documento.getPzi().getFechaProbableSalida())));
            // llenar fecha punto de salida
            msreplace.ReplaceTextByText("puntoSalida", remplazo(documento.getPzi().getPuntoSalida()));

            // llenar fecha probable de ingreso
            msreplace.ReplaceTextByText("fechaProbableIngreso",
                                        remplazo(Utility.parseDateToString(documento.getPzi().getFechaProbableIngreso())));
            // llenar fecha punto de ingreso
            msreplace.ReplaceTextByText("puntoIngreso", remplazo(documento.getPzi().getPuntoIngreso()));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msreplace != null) {
                msreplace.Close(nombreArchivo);
            }
        }

        dDocName = ucmClient.ingresarDocumento(txId, nombreArchivo, documento);

        logger.debug("ejecutarSolicitudSZI dDocName:" + dDocName);

        return dDocName;
    }


    private String ejecutarSolicitudModificacionSFI(String txId, Documento documento, String nombrePlantilla) {

        logger.debug("Entra en ejecutarSolicitudModificacionSFI");

        String dDocName = null;

        String nombreArchivo = ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, nombrePlantilla);

        MsWordReplace msreplace = new MsWordReplace();

        try {
            msreplace.Open(nombreArchivo);

            msreplace.ReplaceTextByText("fechaDeEmision", remplazo(documento.getPfi().getFechaDeEmicion()));
            msreplace.ReplaceTextByText("direccionEjecutiva", remplazo(documento.getPfi().getDireccionEjecutiva()));
            msreplace.ReplaceTextByText("dniRucSolicitante", remplazo(documento.getSolicitante().getDniRuc()));
            msreplace.ReplaceTextByText("nombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
            msreplace.ReplaceTextByText("docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
            msreplace.ReplaceTextByText("distritoSolicitante", remplazo(documento.getSolicitante().getDistrito()));
            msreplace.ReplaceTextByText("provinciaSolicitante", remplazo(documento.getSolicitante().getProvincia()));
            msreplace.ReplaceTextByText("departamentoSolicitante", remplazo(documento.getSolicitante().getDepartamento()));
            msreplace.ReplaceTextByText("telefonoSolicitante", remplazo(documento.getSolicitante().getTelefono()));
            msreplace.ReplaceTextByText("emailSolicitantante", remplazo(documento.getSolicitante().getEmail()));
            msreplace.ReplaceTextByText("nombreRepresentanteLegalSolicitante",
                                        remplazo(documento.getSolicitante().getNombreRepresentanteLegal()));
            msreplace.ReplaceTextByText("dniRepresentanteLegalSolicitante",
                                        remplazo(documento.getSolicitante().getDniRepresentanteLegal()));

            // se coloca en caso de ser el Importador u el agente de Aduana
            msreplace.ReplaceTextByText("tipoSolicitante", remplazo(documento.getSolicitante().getTipoSolicitante()));
            logger.debug("documento.isAmpliacion():" + documento.isAmpliacion());
            msreplace.ReplaceTextByText("isA", documento.isAmpliacion() == true ? "X" : "");
            logger.debug("documento.isModificacion():" + documento.isModificacion());
            msreplace.ReplaceTextByText("isM", documento.isModificacion() == true ? "X" : "");

            //20110116 INICIO
            msreplace.ReplaceTextByText("numeroDocumento", remplazo(documento.getPfi().getNoCertificado()));
            msreplace.ReplaceTextByText("fechaAmpliacion",
                                        remplazo(documento.isAmpliacion() == true ? "VIGENTE HASTA: " + documento.getPfi().getFechaAmpliacion() :
                                                 ""));
            msreplace.ReplaceTextByText("nombreImportador", remplazo(documento.getSolicitante().getNombreImportador()));
            msreplace.ReplaceTextByText("urbanizacionSolicitante", remplazo(documento.getSolicitante().getUrbanizacion()));
            //20110116 FIN

            // llenar tabla de productos
            ArrayList listaProductos = new ArrayList();

            ArrayList valores = null;

            ProductoPFI producto = null;

            for (int i = 0; i < documento.getPfi().getProductosPFI().size(); i++) {
                producto = documento.getPfi().getProductosPFI().get(i);

                valores = new ArrayList();

                // partida arancelaria
                valores.add(remplazo(producto.getDescripcion()));
                // peso neto
                valores.add(remplazo("" + producto.getPesoNeto()));
                // cantidad plantas
                valores.add(remplazo("" + producto.getCantidadPlantas()));
                // cantidad
                valores.add(remplazo("" + producto.getCantidad()));
                // tipo envase
                valores.add(remplazo(producto.getTipoEnvase()));

                // agregar a la lista
                listaProductos.add(valores);

                boolean contieneAnexos = producto.isContieneAnexos();

                logger.debug("producto.isContieneAnexos():" + producto.isContieneAnexos());

                if (contieneAnexos == true) {
                    ArrayList listaAnexos = documento.getPfi().getAnexosPFI();

                    AnexoPFI anexo = null;

                    for (int j = 0; j < listaAnexos.size(); j++) {
                        anexo = (AnexoPFI)listaAnexos.get(j);
                        if (anexo.getCodigoPadre().trim().equals(producto.getCodigoProducto().trim())) {
                            valores = new ArrayList();
                            // partida arancelaria
                            valores.add(remplazo(anexo.getDescripcion()));
                            // peso neto
                            valores.add(remplazo("" + anexo.getPesoNeto()));
                            // cantidad plantas
                            valores.add(remplazo("" + anexo.getCantidadPlantas()));
                            // cantidad
                            valores.add(remplazo("" + anexo.getCantidad()));
                            // tipo envase
                            valores.add(remplazo(anexo.getTipoEnvase()));
                            // agregar a la lista
                            listaProductos.add(valores);
                        }
                    }
                }
            }

            // llenar tabla de productos
            msreplace.FillTable("listProductos", listaProductos);

            // Puntos de Ingreso
            ArrayList listaPuntoIngreso = new ArrayList();

            PuntoIngresoProductoPFI puntoIngresoPFI = null;

            for (int i = 0; i < documento.getPfi().getPuntoIngresoProductoPFI().size(); i++) {
                puntoIngresoPFI = documento.getPfi().getPuntoIngresoProductoPFI().get(i);

                valores = new ArrayList();

                valores.add(puntoIngresoPFI.getPuntoIngresoProducto());

                listaPuntoIngreso.add(valores);

            }

            // llenar tabla de puntos de ingreso
            msreplace.FillTable("listPuntosIngreso", listaPuntoIngreso);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msreplace != null) {
                msreplace.Close(nombreArchivo);
            }
        }

        dDocName = ucmClient.ingresarDocumento(txId, nombreArchivo, documento);

        logger.debug("recibo de pago dDocName:" + dDocName);

        return dDocName;
    }


    private String ejecutarSolicitudModificacionSZI(String txId, Documento documento, String nombrePlantilla) {
        logger.debug("Entra en ejecutarSolicitudModificacionSZI --" + nombrePlantilla);

        String dDocName = null;

        String nombreArchivo = ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, nombrePlantilla);

        MsWordReplace msreplace = new MsWordReplace();

        try {
            msreplace.Open(nombreArchivo);

            msreplace.ReplaceTextByText("fechadeEmision",
                                        remplazo(Utility.parseDateToString(documento.getPzi().getFechaEmision())));
            msreplace.ReplaceTextByText("direccionEjecutiva", remplazo(documento.getPzi().getDireccionEjecutiva()));
            msreplace.ReplaceTextByText("dniRucSolicitante", remplazo(documento.getSolicitante().getDniRuc()));
            msreplace.ReplaceTextByText("nombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
            msreplace.ReplaceTextByText("docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
            msreplace.ReplaceTextByText("distritoSolicitante", remplazo(documento.getSolicitante().getDistrito()));
            msreplace.ReplaceTextByText("provinciaSolicitante", remplazo(documento.getSolicitante().getProvincia()));
            msreplace.ReplaceTextByText("departamentoSolicitante", remplazo(documento.getSolicitante().getDepartamento()));
            msreplace.ReplaceTextByText("telefonoSolicitante", remplazo(documento.getSolicitante().getTelefono()));
            msreplace.ReplaceTextByText("emailSolicitantante", remplazo(documento.getSolicitante().getEmail()));
            msreplace.ReplaceTextByText("nombreRepresLegalSolic",
                                        remplazo(documento.getSolicitante().getNombreRepresentanteLegal()));
            msreplace.ReplaceTextByText("dniRepresentanteLegalSolicitante",
                                        remplazo(documento.getSolicitante().getDniRepresentanteLegal()));
            // se coloca en caso de ser el Importador u Agente de Aduana
            msreplace.ReplaceTextByText("tipoSolicitante", remplazo(documento.getSolicitante().getTipoSolicitante()));
            msreplace.ReplaceTextByText("nombreImportador",
                                        remplazo(remplazo(documento.getSolicitante().getNombreRazonSocial())));

            msreplace.ReplaceTextByText("isA", remplazo(remplazo(documento.isAmpliacion() ? "X" : "")));
            msreplace.ReplaceTextByText("isM", remplazo(remplazo(documento.isModificacion() ? "X" : "")));

            // llenar tabla de productos
            ArrayList listaProductos = new ArrayList();

            ArrayList valores = null;

            ProductoPZI producto = null;

            producto = documento.getPzi().getProductoPZI();

            logger.debug("-----producto.getEsAnimal():" + producto.getEsAnimal());

            if (producto.getEsAnimal() != null && producto.getEsAnimal().booleanValue()) {

                valores = new ArrayList();

                // descripcion
                valores.add(remplazo(producto.getDescripcion()));
                // Peso numero animales
                valores.add(remplazo("" + producto.getNumeroAnimales()));

                valores.add(remplazo("" + producto.getCantidad()));
                // tipo de envase
                valores.add(remplazo(producto.getTipoEnvase()));

                // agregar a la lista
                listaProductos.add(valores);

            }

            if (producto.getEsAnimal() != null && producto.getEsAnimal().booleanValue() == false) {

                valores = new ArrayList();
                ArrayList valores2 = new ArrayList();

                // llenar lista productos o sub productos
                // ArrayList listaPuntoIngreso = new ArrayList();

                // descripcion
                valores.add(remplazo(producto.getDescripcion()));
                // Peso neto
                valores.add(remplazo("" + producto.getPesoNeto()) + " " + remplazo("" + producto.getCodUniMed()));
                // cantidad
                valores.add(remplazo("" + producto.getCantidad()));
                //tipo envase
                valores.add(remplazo(producto.getTipoEnvase()));

                // agregar a la lista
                listaProductos.add(valores);

                if (producto.getContieneAnexos() != null && producto.getContieneAnexos().booleanValue()) {

                    AnexoPFI anexo = null;

                    for (int i = 0; i < documento.getPzi().getAnexosPZI().size(); i++) {
                        valores = new ArrayList();

                        valores2 = new ArrayList();

                        anexo = documento.getPzi().getAnexosPZI().get(i);

                        // descripcion
                        valores.add(remplazo(anexo.getDescripcion()));
                        // Peso neto
                        valores.add(remplazo("" + anexo.getPesoNeto()) + " " + remplazo("" + producto.getPesoNeto()));
                        //tipo envase
                        valores.add(remplazo(anexo.getTipoEnvase()));
                        // cantidad
                        valores.add(remplazo("" + anexo.getCantidad()));

                        // agregar a la lista
                        listaProductos.add(valores);

                    }

                }
            }

            msreplace.FillTable("listProductos", listaProductos);

            msreplace.ReplaceTextByText("puntoIngreso", remplazo(documento.getPzi().getPuntoIngreso()));

            msreplace.ReplaceTextByText("puntoControlSalida", remplazo(documento.getPzi().getPuntoSalida()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msreplace != null) {
                msreplace.Close(nombreArchivo);
            }
        }

        dDocName = ucmClient.ingresarDocumento(txId, nombreArchivo, documento);

        logger.debug("ejecutarSolicitudModificacionSZI dDocName:" + dDocName);

        return dDocName;
    }

    private String ejecutarReciboPago(String txId, Documento documento, String nombrePlantilla) {

        logger.debug("Entra en recibo de pago");

        String dDocName = null;

        float valorAbono = 0;

        String nombreArchivo = ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, nombrePlantilla);

        MsWordReplace msreplace = new MsWordReplace();

        try {
            msreplace.Open(nombreArchivo);

            //if(Float.parseFloat(documento.getReciboPago().getValorPagado())>documento.getServicioTupa().getValorServicioTupa())
            logger.debug("Convirtiendo a Float el valor pagado: " + documento.getReciboPago().getValorPagado() +
                         " y reemplazando ',' x '.' ");
            if (Float.parseFloat(documento.getReciboPago().getValorPagado().replace(",", ".")) >
                documento.getServicioTupa().getValorServicioTupa()) {
                valorAbono =
                        new Float(documento.getReciboPago().getValorPagado()) - documento.getServicioTupa().getValorServicioTupa();
            }

            GeografiaDAO geografia = new GeografiaDAO();

            CentroTramite cntrTrmt = geografia.obtenerCentroTramite(documento.getCodigoCentroTramite());

            msreplace.ReplaceTextByText("dniRucSolicitante", remplazo(documento.getSolicitante().getDniRuc()));
            msreplace.ReplaceTextByText("NombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
            msreplace.ReplaceTextByText("docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
            msreplace.ReplaceTextByText("urbanizacionSolicitante", remplazo(documento.getSolicitante().getUrbanizacion()));
            msreplace.ReplaceTextByText("distritoSolicitante", remplazo(documento.getSolicitante().getDistrito()));
            msreplace.ReplaceTextByText("provinciaSolicitante", remplazo(documento.getSolicitante().getProvincia()));
            msreplace.ReplaceTextByText("direccionSede", remplazo(cntrTrmt != null ? cntrTrmt.getDireccion() : ""));

            msreplace.ReplaceTextByText("ServicioTupa", remplazo(documento.getServicioTupa().getNombreServicioTupa()));
            msreplace.ReplaceTextByText("valorServicio", remplazo("" + documento.getServicioTupa().getValorServicioTupa()));
            msreplace.ReplaceTextByText("valorServicio", remplazo("" + documento.getServicioTupa().getValorServicioTupa()));

            msreplace.ReplaceTextByText("valorPagado", remplazo(documento.getReciboPago().getValorPagado()));
            msreplace.ReplaceTextByText("valorAbono", remplazo(String.valueOf(valorAbono)));
            msreplace.ReplaceTextByText("fechaHora", remplazo(documento.getReciboPago().getFechaHora()));
            msreplace.ReplaceTextByText("sedeSenasa", remplazo(documento.getReciboPago().getSedeSenasa()));
            msreplace.ReplaceTextByText("numeroExpediente", remplazo(documento.getReciboPago().getNumeroExpediente()));
            msreplace.ReplaceTextByText("numeroRecibo", remplazo(documento.getReciboPago().getNumeroRecibo()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msreplace != null) {
                msreplace.Close(nombreArchivo);
            }
        }

        dDocName = ucmClient.ingresarDocumento(txId, nombreArchivo, documento);

        logger.debug("recibo de pago dDocName:" + dDocName);

        return dDocName;

    }

    private String ejecutarReciboPago2(String txId, Documento documento, String nombrePlantilla) {

        logger.debug("Entra en recibo de pago(servicios TUPA multiples)");

        String dDocName = null;

        float valorAbono = 0;

        String nombreArchivo = ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, nombrePlantilla);

        MsWordReplace msreplace = new MsWordReplace();

        ArrayList valores = new ArrayList();
        ArrayList valores2 = new ArrayList();


        try {
            msreplace.Open(nombreArchivo);

            //if(Float.parseFloat(documento.getReciboPago().getValorPagado())>documento.getServicioTupa().getValorServicioTupa())
            //logger.debug("Convirtiendo a Float el valor pagado: " + documento.getReciboPago().getValorPagado() + " y reemplazando ',' x '.' ");
            //if(Float.parseFloat(documento.getReciboPago().getValorPagado().replace(",", "."))>documento.getServicioTupa().getValorServicioTupa())
            //{
            //  valorAbono = new Float(documento.getReciboPago().getValorPagado())-documento.getServicioTupa().getValorServicioTupa();
            //}

            GeografiaDAO geografia = new GeografiaDAO();
            logger.debug("Empezando a obtener los valores para la impresion del recibo");
            CentroTramite cntrTrmt = geografia.obtenerCentroTramite(documento.getCodigoCentroTramite());

            msreplace.ReplaceTextByText("dniRucSolicitante", remplazo(documento.getSolicitante().getDniRuc()));
            msreplace.ReplaceTextByText("NombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
            msreplace.ReplaceTextByText("docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
            msreplace.ReplaceTextByText("urbanizacionSolicitante", remplazo(documento.getSolicitante().getUrbanizacion()));
            msreplace.ReplaceTextByText("distritoSolicitante", remplazo(documento.getSolicitante().getDistrito()));
            msreplace.ReplaceTextByText("provinciaSolicitante", remplazo(documento.getSolicitante().getProvincia()));
            msreplace.ReplaceTextByText("direccionSede", remplazo(cntrTrmt != null ? cntrTrmt.getDireccion() : ""));

            // llenar lista Servicios Tupa
            ArrayList listaServiciosTupa = new ArrayList();
            ArrayList listaValorServicio = new ArrayList();


            //RequisitoDao requisito= null;
            ReciboServicio serviciotupa = null;
            logger.debug("Iniciando obtencion servicios TUPA");
            for (int i = 0; i < documento.getServiciosTUPARecibo().size(); i++) {
                valores = new ArrayList();


                serviciotupa = documento.getServiciosTUPARecibo().get(i);

                // servicio
                if (serviciotupa == null)
                    continue;

                valores.add(remplazo(serviciotupa.getNombreServicio()));
                valores.add(remplazo(serviciotupa.getMontoServicio().toString()));
                listaServiciosTupa.add(valores);
                logger.debug("serviciotupa.getNombreServicio(): " + serviciotupa.getNombreServicio());
                logger.debug("serviciotupa.getMontoServicio(): " + serviciotupa.getMontoServicio().toString());

            }

            // llenar lista Requisitos Sanitarios
            msreplace.FillTable("ServicioTupa", listaServiciosTupa);
            //msreplace.FillTable("valorItemServicio", listaValorServicio);


            logger.debug("Finalizando obtencion servicios TUPA");


            //msreplace.ReplaceTextByText("ServicioTupa",  remplazo(documento.getServicioTupa().getNombreServicioTupa()));
            //msreplace.ReplaceTextByText("valorServicio",  remplazo(""+documento.getServicioTupa().getValorServicioTupa()));

            msreplace.ReplaceTextByText("valorServicio", remplazo("" + documento.getServicioTupa().getValorServicioTupa()));

            msreplace.ReplaceTextByText("valorPagado", remplazo(documento.getReciboPago().getValorPagado()));
            //msreplace.ReplaceTextByText("valorAbono", remplazo(String.valueOf(valorAbono)));
            msreplace.ReplaceTextByText("valorAbono", remplazo(documento.getReciboPago().getValorSaldo()));
            msreplace.ReplaceTextByText("fechaHora", remplazo(documento.getReciboPago().getFechaHora()));
            msreplace.ReplaceTextByText("sedeSenasa", remplazo(documento.getReciboPago().getSedeSenasa()));
            msreplace.ReplaceTextByText("numeroExpediente", remplazo(documento.getReciboPago().getNumeroExpediente()));
            msreplace.ReplaceTextByText("numeroRecibo", remplazo(documento.getReciboPago().getNumeroRecibo()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msreplace != null) {
                msreplace.Close(nombreArchivo);
            }
        }

        dDocName = ucmClient.ingresarDocumento(txId, nombreArchivo, documento);

        logger.debug("recibo de pago dDocName:" + dDocName);

        return dDocName;

    }

    private Firmante obtenerFirmante(Documento documento) {
        Firmante frmnt = null;

        SolicitanteDAO slctntDAO = new SolicitanteDAO();

        frmnt = slctntDAO.obtenerFirmantePermiso(documento.getCodigoCentroTramite(), documento.getCodigoServicio());

        return frmnt;
    }

    public Firmante obtenerFirmante(String codigoCentroTramite, String codigoServicio) {
        Firmante frmnt = null;
        SolicitanteDAO slctntDAO = new SolicitanteDAO();
        frmnt = slctntDAO.obtenerFirmantePermiso(codigoCentroTramite, codigoServicio);
        return frmnt;
    }


    private String ejecutarPziDefinitivo(String txId, Documento documento, String nombrePlantilla) {
        this.profileTrigger = "STD-SOIM";
        this.tipoDocumento = "SOIM";
        this.subTipoDocumento = "FITO";

        logger.debug("Entra en ejecutarPziDefinitivo");

        String dDocName = null;

        String nombreArchivo = ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, nombrePlantilla);

        Firmante frmnt = obtenerFirmante(documento);

        String firmaSello =
            ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, frmnt.getUserName() + NomenclaturaFirma.SUFIJO_FIRMA_SELLO);

        MsWordReplace msreplace = new MsWordReplace();

        try {

            msreplace.Open(nombreArchivo);

            msreplace.ReplaceTextByText("noExpediente", remplazo(documento.getPzi().getNoFolio()));
            msreplace.ReplaceTextByText("fechaDeEmision",
                                        remplazo(Utility.parseDateToString(documento.getPzi().getFechaEmision())));
            msreplace.ReplaceTextByText("numeroDocumento",
                                        remplazo(documento.getPzi().getNoCertificado() + frmnt.getNomencaltura()));
            msreplace.ReplaceTextByText("lugarEmision", remplazo(documento.getPzi().getDireccionEjecutiva()));
            msreplace.ReplaceTextByText("fechaAmpliacion",
                                        remplazo(Utility.parseDateToString(documento.getPzi().getFechaAmpliacion())));
            msreplace.ReplaceTextByText("nombreSolicitante", remplazo(documento.getSolicitante().getNombreRazonSocial()));
            msreplace.ReplaceTextByText("docmicilioLegalSolicitante", remplazo(documento.getSolicitante().getDomicilioLegal()));
            msreplace.ReplaceTextByText("usoDestino", remplazo("" + documento.getPzi().getProductoPZI().getUsoDestino()));
            msreplace.ReplaceTextByText("puestoControl", remplazo(documento.getPzi().getPuntoIngreso()));

            // llenar tabla de productos

            ArrayList listaProductos = new ArrayList();

            ArrayList valores = new ArrayList();

            ProductoPZI prdPzi = documento.getPzi().getProductoPZI();

            boolean contieneAnexos = prdPzi.getContieneAnexos();

            if (contieneAnexos == true) {
                ArrayList listaAnexos = documento.getPzi().getAnexosPZI();

                AnexoPFI anexo = null;

                for (int j = 0; j < listaAnexos.size(); j++) {
                    anexo = (AnexoPFI)listaAnexos.get(j);
                    if (anexo.getCodigoPadre().trim().equals(prdPzi.getCodProducto().trim())) {
                        valores = new ArrayList();
                        // partida arancelaria
                        valores.add(remplazo(anexo.getPartidaArancelaria()));
                        // nombre
                        valores.add(remplazo(anexo.getDescripcion()));
                        //nombre cientifico
                        valores.add(remplazo(anexo.getNombreCientifico()));
                        // peso neto / cantidad de plantas
                        valores.add(remplazo("" + anexo.getPesoNeto()) + " " + remplazo(anexo.getCodUniMed()));
                        // tipo de envase
                        valores.add(remplazo(anexo.getTipoEnvase()) + " " + remplazo("" + anexo.getCantidad()));

                        // agregar a la lista
                        listaProductos.add(valores);
                    }
                }
            } else {

                // partida arancelaria
                valores.add(remplazo(prdPzi.getPartidaArancelaria()));
                // nombre
                valores.add(remplazo(prdPzi.getDescripcion()));
                //nombre cientifico
                valores.add(remplazo(prdPzi.getNombreCientifico()));
                // peso neto / cantidad de plantas
                if (prdPzi.getEsAnimal()) {
                    valores.add(remplazo("" + prdPzi.getNumeroAnimales()));
                    valores.add(remplazo("" + prdPzi.getTipoEnvase()));
                } else {
                    valores.add(remplazo("" + prdPzi.getPesoNeto()) + " " + remplazo(prdPzi.getCodUniMed()));
                    // tipo de envase
                    valores.add(remplazo(prdPzi.getTipoEnvase()) + " " + remplazo("" + prdPzi.getCantidad()));
                }

                // agregar a la lista
                listaProductos.add(valores);

            }

            // llenar tabla de productos
            msreplace.FillTable("listProductos", listaProductos);

            // llenar lista Requisitos Sanitarios
            ArrayList listaRequisitosSanitarios = new ArrayList();

            RequisitoDao requisito = null;

            for (int i = 0; i < documento.getRequisitosSanitarios().size(); i++) {
                valores = new ArrayList();

                requisito = documento.getRequisitosSanitarios().get(i);

                // requisito
                if (requisito == null)
                    continue;

                valores.add(remplazo(requisito.getEtiqueta()) + " " + remplazo(requisito.getDescripcionRequisito()));

                listaRequisitosSanitarios.add(valores);

            }

            // llenar lista Requisitos Sanitarios
            msreplace.FillTable("listRequisitos", listaRequisitosSanitarios);

            // llenar origen y lugar de produccion

            String paisLugarProduccion = "";

            PaisOrigenProductoPFI paisOrigen = null;

            for (int i = 0; i < documento.getPzi().getPaisesOrigenProductoPZI().size(); i++) {
                paisOrigen = documento.getPzi().getPaisesOrigenProductoPZI().get(i);

                paisLugarProduccion +=
                        paisOrigen.getPaisOrigenProducto() + " " + remplazo("" + paisOrigen.getLugarProduccion()) + ",\n";
            }

            // insertar string en tabla  origen y lugar de produccion
            msreplace.ReplaceTextByText("origenProducto", remplazo(paisLugarProduccion));

            // procedencia de los productos
            msreplace.ReplaceTextByText("procedenciaProducto",
                                        remplazo("" + documento.getPzi().getProductoPZI().getPaisProcedencia()));

            if (firmaSello != null)
                msreplace.ReplaceTextByImage("firmaSello", firmaSello);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msreplace != null) {
                msreplace.Close(nombreArchivo);
            }
        }

        dDocName = ucmClient.ingresarDocumento(txId, nombreArchivo, documento);

        ucmClient.eliminarArchivo(firmaSello);

        return dDocName;

    }

    private String remplazo(String valor) {
        if (valor != null && !valor.equals("null")) {
            if (valor.equals("")) {
                return " ";
            } else {
                return valor;
            }
        } else {
            return " ";
        }

    }

    private String establecerIngreso(String nombrePlantilla, String nombreArchivo, Documento documento) {
        String dDocName = null;
        try {
            dDocName =
                    clienteCis.establecerIngreso(nombreArchivo, nombrePlantilla, documento, this.profileTrigger, this.tipoDocumento,
                                                 this.subTipoDocumento, clienteCis.incializarAplicacion());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (CommandException e) {
            e.printStackTrace();
            logger.fatal(e);
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return dDocName;
    }

    public String establecerIngresoTest(String nplantilla) {

        /*synchronized(this){
        MsWordCreate msWord= new MsWordCreate();
        msWord.Open(nplantilla);
        msWord.ReplaceTextByText("bpmTagNumeroDocumento", nplantilla + urlDoc);
        msWord.Save(nplantilla);
    */
        return ucmClient.testAppUCMCLIENT(nplantilla);
    }
    /*public void obtenerFirmasSellos(String txId,String[][] lista)    {
      if(lista==null || lista.length==0) return;

      for(int i=0 ;i<lista.length;i++){
          lista[i][2]=ucmClient.obtenerPlantilla(txId,lista[i][0]+"-"+lista[i][1]);
      }
  } */

    private String nameMonth(String month) {
        if (month.equalsIgnoreCase("01")) {
            return "Enero";
        } else if (month.equalsIgnoreCase("02")) {
            return "Febrero";
        } else if (month.equalsIgnoreCase("03")) {
            return "Marzo";
        } else if (month.equalsIgnoreCase("04")) {
            return "Abril";
        } else if (month.equalsIgnoreCase("05")) {
            return "Mayo";
        } else if (month.equalsIgnoreCase("06")) {
            return "Junio";
        } else if (month.equalsIgnoreCase("07")) {
            return "Julio";
        } else if (month.equalsIgnoreCase("08")) {
            return "Agosto";
        } else if (month.equalsIgnoreCase("09")) {
            return "Septiembre";
        } else if (month.equalsIgnoreCase("10")) {
            return "Octubre";
        } else if (month.equalsIgnoreCase("11")) {
            return "Noviembre";
        } else if (month.equalsIgnoreCase("12")) {
            return "Diciembre";
        } else {
            return month;
        }
    }
    
    private String convertirDocumentoAPdf(String txId, String filename) {
        MsWordReplace mswr = null;
        logger.info(txId + " Convirtiendo WORD a PDF - Archivo= " + filename);
        try {
            mswr = new MsWordReplace();
            String pdf = mswr.OpenAndSaveToPDF(filename);
            logger.info(txId + " Convirtiendo WORD a PDF - Terminado= " + pdf);
            return pdf;
        } catch(Exception e) {
            logger.error(txId + "Exception en establecerIngreso de imagenes bpmTagFechaRegistro: " + e.getMessage());
            return null;
        }
    }

    private Boolean reemplazarTagDocumento(String txId, String nombre, Documento documento, EstadoReemplazo estado) {
        Boolean statusReplease = true;
        String stripImages[][] = null; // para vistos y firmas
        HashMap hmlistaVistos = new HashMap();
        String ID_SIN_VALOR_FDVI = "";
        String ID_SIN_VALOR_FDSE = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = new Date();
        String dateFormat = "";

        if (documento.getListaFirmantes() != null && documento.getListaFirmantes().size() > 0) {
            MsWordReplace mswr = null;
            try {
                if (documento.isConFirma()) {
                    logger.info(txId + "cantidad de firmantes = " + documento.getListaFirmantes().size());
                    stripImages = new String[documento.getListaFirmantes().size()][3];

                    if (documento.isPrevisualizar()) {
                        ID_SIN_VALOR_FDVI = ucmClient.obtenerDocumentoIDPorTitulo(txId, "SIN_VALOR-FDVI");
                        ID_SIN_VALOR_FDSE = ucmClient.obtenerDocumentoIDPorTitulo(txId, "SIN_VALOR-FDSE");
                    }

                    for (int i = 0; i < documento.getListaFirmantes().size(); i++) {
                        logger.info(txId + "Firmante y Vistos número " + i + " ==>" +
                                    (String)documento.getListaFirmantes().get(i));
                        if ((String)documento.getListaFirmantes().get(i) == null)
                            continue;

                        stripImages[i][0] = ((String)documento.getListaFirmantes().get(i)).toUpperCase();
                        stripImages[i][1] = "FDVI";
                        stripImages[i][2] = "";
                    }

                    logger.info(txId + "creando objeto stripImages.length==>" + stripImages.length);
                    if (documento.isEncargatura()) {
                        logger.info(txId + " Enviado como encangatura ==>FDEN");
                        stripImages[stripImages.length - 1][1] = "FDEN";
                    } else {
                        logger.info(txId + " Enviado como firma==>FDSE");
                        stripImages[stripImages.length - 1][1] = "FDSE";
                    }
                    /*obtener vistos y firmas*/
                    logger.info(txId + " **Obtener Vistos y firmas**");
                    //ejemplo para 2 usuario el primero visto y el segundo firma: CBERROSPI-FDVI , JGUEVARA-FDSE
                    for (int i = 0; i < stripImages.length; i++) { // bajr los vistos y firmas al disco
                        if (documento.isPrevisualizar()) {
                            if (stripImages[i][1].equals("FDVI"))
                                stripImages[i][2] =
                                        ucmClient.obtenerPlantilla(txId, ID_SIN_VALOR_FDVI); // puede devover ruta o null
                            else
                                stripImages[i][2] =
                                        ucmClient.obtenerPlantilla(txId, ID_SIN_VALOR_FDSE); // puede devover ruta o null
                        } else {
                            stripImages[i][2] =
                                    ucmClient.obtenerPlantilla(txId, stripImages[i][0] + "-" + stripImages[i][1]); // puede devover ruta o null
                        }
                    }
                    /* Ejemplo de como quedaria el array para temas de debug
           stripImages[0][0] ="CBERROSPI";
          stripImages[0][1] = "FDVI";
          stripImages[0][2] = "";   //ruta de firma

          stripImages[1][0] ="JGUEVARA";
          stripImages[1][1] = FDSE o FDEN
          stripImages[1][2] = "";   //ruta de firma
          */
                    logger.info(txId + " **Fin Obtener Vistos y firmas**");
                    Boolean encontroVisto = true;
                    Boolean isImagenValida = true;
                    //validar vistos
                    for (int i = 0; i < stripImages.length - 1;
                         i++) { //solo los FDVI     - ingresara mientras se envien mas de 1 usuario
                        if (hmlistaVistos.get(stripImages[i][0]) == null) {
                            logger.info(txId + "stripImages " + i + " [2]==>" + ucmClient.PATH_FILES + stripImages[i][2]);
                            if (stripImages[i][2] == null) { // no pudo obtener la firma de UCM
                                encontroVisto = false;
                                break;
                            } else {
                                isImagenValida = this.validarImagen(txId, ucmClient.PATH_FILES + stripImages[i][2]);
                                if (!isImagenValida) {
                                    encontroVisto = false; // setear a false ya que el visto puede estar errado
                                    break;
                                }
                                hmlistaVistos.put(stripImages[i][0],
                                                  ucmClient.PATH_FILES + stripImages[i][2]); //CBERROSPI, RUTA DE IMAGEN
                            }
                        }
                    }
                    if (!encontroVisto) {
                        logger.info(txId + " Vistos no encontrados ");
                        estado.setError("1-VISTOS NO ENCONTRADOS");
                        statusReplease = false;
                    }

                    //Validar Firma
                    if (stripImages[stripImages.length - 1][2] == null) {
                        logger.info(txId + " Firma no encontrada");
                        estado.setError("2-FIRMA NO ENCONTRADA"); // no modificar el mensaje ya que BPM lo valida, bien sea==> 2-FIRMA 0r 1-VISTOS or null
                        statusReplease = false;
                    } else {
                        isImagenValida = this.validarImagen(txId, ucmClient.PATH_FILES + stripImages[stripImages.length - 1][2]);
                        if (!isImagenValida) {
                            logger.info(txId + " Firma errada - imagen no valida");
                            estado.setError("2-FIRMA NO ENCONTRADA");
                            statusReplease = false;
                        }
                    }
                }

                if (estado.getError() == null) {
                    logger.info(txId + "Instanciando MsWordReplace");
                    mswr = new MsWordReplace();
                    mswr.Open(nombre);
                    if (statusReplease) {
                        try {
                            if (documento.isSinFirma()) {
                                logger.info(txId + "Generando documento sin Firma");
                                mswr.ReplaceTextByText("bpmTagFirmaRemitente", "");
                                mswr.ReplaceTextByText("bpmTagFirm", "");
                            } else {
                                logger.info(txId + "Insertando vistos");
                                String[] imagenes = new String[hmlistaVistos.size()];
                                imagenes = (String[])hmlistaVistos.values().toArray(new String[0]);
                                mswr.InsertStripImagesAtLeft(imagenes, true);
                                imagenes = null;
                                hmlistaVistos = null;
                                if (!mswr.findTagName("bpmTagFirmaRemitente")) {
                                    if (!mswr.findTagName("bpmTagFirm")) {
                                        estado.setError("3 - TAG FIRMA ERROR");    
                                        statusReplease = false;
                                    } else {
                                        logger.info(txId + "Reemplazando Firma bpmTagFirm: " + stripImages[stripImages.length - 1][2]);
                                        mswr.ReplaceTextByImage("bpmTagFirm", ucmClient.PATH_FILES + stripImages[stripImages.length - 1][2]);
                                    }
                                } else {
                                    logger.info(txId + "Reemplazando Firma bpmTagFirmaRemitente: " + stripImages[stripImages.length - 1][2]);
                                    mswr.ReplaceTextByImage("bpmTagFirmaRemitente", ucmClient.PATH_FILES + stripImages[stripImages.length - 1][2]);
                                }
                            }
                        } catch (Exception e) {
                            logger.error(txId + "Exception en establecerIngreso de imagenes bpmTagFirmaRemitente o bpmTagFirm: " + e.getMessage());
                            statusReplease = false;
                        }
                    }
                    if (statusReplease) {
                        try {
                            if (!mswr.findTagName("bpmTagFechaRegistro")) {
                                estado.setError("4 - TAG FECHA ERROR");
                                statusReplease = false;
                            } else {
                                logger.info(txId + "Reemplazando bpmTagFechaRegistro: ");
                                if (documento.getMemorandum().getFechaRegistro() == null || documento.getMemorandum().getFechaRegistro().equals("")) {
                                    dateFormat = sdf.format(dt);
                                    mswr.ReplaceTextByText("bpmTagFechaRegistro", dateFormat.substring(0, 2) + " de " + nameMonth(dateFormat.substring(3, 5)) + " de " + dateFormat.substring(6, 10));
                                } else {
                                    try {
                                        logger.info(txId + "Reemplazando bpmTagFechaRegistro: " + documento.getMemorandum().getNumeroDocumento());
                                        dt = sdf.parse(documento.getMemorandum().getFechaRegistro());
                                    } catch (ParseException e) {
                                        logger.error(txId + " Fecha enviada en formatto errado: " + documento.getMemorandum().getNumeroDocumento());
                                    } finally {
                                        dateFormat = sdf.format(dt);
                                        mswr.ReplaceTextByText("bpmTagFechaRegistro", dateFormat.substring(0, 2) + " de " + nameMonth(dateFormat.substring(3, 5)) + " de " + dateFormat.substring(6, 10));
                                    }
                                }
                            }
                        } catch (Exception e) {
                            logger.error(txId + "Exception en establecerIngreso de imagenes bpmTagFechaRegistro: " + e.getMessage());
                            statusReplease = false;
                        }
                    }
                    if (statusReplease) {
                        try {
                            if (!mswr.findTagName("bpmTagNumeroDocumento")) {
                                estado.setError("5 - TAG NUMERO ERROR");
                                statusReplease = false;
                            } else {
                                String numeroInternoDoc = documento.getMemorandum().getNumeroDocumento().replace("RESOLUCION JEFATURAL-", "");
                                numeroInternoDoc = numeroInternoDoc.replace("RESOLUCION DIRECTORAL-", "");
                                mswr.ReplaceTextByText("bpmTagNumeroDocumento", numeroInternoDoc);
                                logger.info(txId + "Reemplazando bpmTagNumeroDocumento: " + documento.getMemorandum().getNumeroDocumento());
                            }
                        } catch (Exception e) {
                            logger.error(txId + "Exception en establecerIngreso de numero bpmTagNumeroDocumento: " + e.getMessage());
                            statusReplease = false;
                        }
                    }
                }
            } catch (Exception e) {
                logger.error(txId + "Exception en establecerIngreso" + e.getMessage());
                e.printStackTrace();
            } finally {
                if (mswr != null)
                    mswr.Close(nombre);
            }
        }

        //Eliminar Imagen
        try {
            for (int i = 0; i < stripImages.length; i++) { //solo los FDVI     - ingresara mientras se envien mas de 1 usuario
                if (stripImages[i][2] != null) {
                    ucmClient.eliminarArchivo(ucmClient.PATH_FILES + stripImages[stripImages.length - 1][2]);
                }
            }
        } catch (Exception e) {
            logger.error(txId + "establecerIngreso Error al eliminar archivo del disco :" + nombre);
        }

        return statusReplease;
    }

    public String establecerIngreso(String txId, byte[] documentoFisico, String nombre, Documento documento) {
        logger.info("=======Inicio de establecerIngreso ======= ");
        //this.profileTrigger = "STD-COIN";
        //this.tipoDocumento = "COIN";
        //this.subTipoDocumento = "MEMO";
        logger.info(txId + "Parámetro Nombre del Archivo " + nombre);
        Propiedad datoMeta = null;
        /* Solo para verificar log */
        if (documento.getMetadatos() != null) {
            logger.info(txId + "*Verificar el dDocTitle enviado*");
            for (int i = 0; i < documento.getMetadatos().size(); i++) {
                datoMeta = documento.getMetadatos().get(i);
                if (datoMeta.getXPropiedad().equals("dDocTitle")) {
                    logger.info(txId + "nNombreMetadato=>" + datoMeta.getXPropiedad() + ",valorMetadato=>" +
                                datoMeta.getXValor());
                }
            }
        }

        String dDocName = null;
        FileOutputStream streamSalida = null;
        File archivo = null;

        nombre = ucmClient.PATH_FILES + ucmClient.generarNombreArchivo(nombre);
        logger.info("Nombre del Archivo UCM " + nombre);
        Boolean isCreateFile = false;

        try {
            archivo = new File(nombre);
            logger.info(txId + "Archivo FileOutputStream");
            streamSalida = new FileOutputStream(archivo);

            logger.info(txId + "Escribiendo archivo");
            streamSalida.write(documentoFisico);
            streamSalida.flush();
            streamSalida.close();
            isCreateFile = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error(txId + "Error FileNotFoundException " + e.getMessage());
        } catch (IOException e) {
            logger.error(txId + "Error de escritura " + e.getMessage());
            e.printStackTrace();
        }

        if (isCreateFile == false)
            return null;
        logger.info(txId + "a ejecutar las firmas");

        EstadoReemplazo estado = new EstadoReemplazo();
        String stripImages[][] = null; // para vistos y firmas
        // ingreso de firmar al documento
        estado.setEstado(reemplazarTagDocumento(txId, nombre, documento, estado));

        dDocName = null;
        // Valida si subio el reemplazo bien los datos
        if (estado.getEstado()) {
            try {
                //reintentar 2 veces en caso de fallas
                for (int i = 1; i <= 2; i++) {
                    logger.info(txId + "Invocando al método UCMClient.ingresarDocumento");
                    try {
                        dDocName = ucmClient.ingresarDocumento(txId, nombre, documento);
                        logger.info(txId + "dDocName :" + dDocName);
                    } catch (Exception e) {
                        logger.error(txId + " ucmClient.ingresarDocumento  :" + nombre);
                    }
                    if (dDocName != null)
                        i = 3;
                }
            } catch (Exception e) {
                logger.error(txId + "establecerIngreso  :" + dDocName);
            }
        } else {
            if (estado.getError() == null || estado.getError().equals(""))
                estado.setError("0-ERROR");
            dDocName = estado.getError();
        }
        logger.info(txId + "eliminarArchivo nombre :" + nombre);
        try {
            ucmClient.eliminarArchivo(nombre);
        } catch (Exception e) {
            logger.error(txId + "establecerIngreso Error al eliminar archivo del disco :" + nombre);
        }
        return dDocName;
    }

    public byte[] previsualizarIngreso(String txId, byte[] documentoFisico, String nombre, Documento documento) {
        logger.info("======= Inicio de previsualizarIngreso ======= ");
        logger.info(txId + "Parámetro Nombre del Archivo " + nombre);

        byte[] bytes = null;
        FileInputStream input = null;

        String dDocName = null;
        FileOutputStream streamSalida = null;
        File archivo = null;

        nombre = ucmClient.PATH_FILES + ucmClient.generarNombreArchivo(nombre);
        logger.info("Nombre del Archivo UCM " + nombre);
        Boolean isCreateFile = false;

        try {
            archivo = new File(nombre);
            logger.info(txId + "*Archivo FileOutputStream");
            streamSalida = new FileOutputStream(archivo);

            logger.info(txId + "*Escribiendo archivo");
            streamSalida.write(documentoFisico);
            streamSalida.flush();
            streamSalida.close();
            isCreateFile = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error(txId + "*Error FileNotFoundException " + e.getMessage());
        } catch (IOException e) {
            logger.error(txId + "*Error de escritura " + e.getMessage());
            e.printStackTrace();
        }

        if (isCreateFile == false)
            return null;
        logger.info(txId + "a ejecutar las firmas");

        EstadoReemplazo estado = new EstadoReemplazo();
        String stripImages[][] = null; // para vistos y firmas
        estado.setEstado(reemplazarTagDocumento(txId, nombre, documento, estado));
        String pdfFile = convertirDocumentoAPdf(txId, nombre);
        if (pdfFile==null || pdfFile.isEmpty())
            estado.setEstado(false);
        
        // Valida si subio el reemplazo bien los datos
        if (estado.getEstado()) {
            try {
                logger.info(txId + "*previsualizarIngreso escribiendo archivo en el  FileInputStream");
                input = new FileInputStream(pdfFile);
                bytes = new byte[input.available()];
                input.read(bytes);
                logger.info(txId + "*previsualizarIngreso FileInputStream OK");
            } catch (Exception e) {
                bytes = null;
                logger.error(txId + "*previsualizarIngreso Error al escribir FileInputStream ==>  " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    if (input != null)
                        input.close();
                } catch (Exception e) {
                    logger.warn(txId + "*previsualizarIngreso Error al cerrar FileInputStream ==>  " + e.getMessage());
                }
            }
        }

        logger.info(txId + "eliminarArchivo nombre :" + nombre);
        try {
            ucmClient.eliminarArchivo(nombre);
        } catch (Exception e) {
            logger.error(txId + "establecerIngreso Error al eliminar archivo word del disco :" + nombre);
        }
        if (stripImages!=null) {
            for (int i = 0; i < stripImages.length; i++) {
                if (stripImages[i].length>=3 && stripImages[i][2] != null) {
                    try {
                        ucmClient.eliminarArchivo(ucmClient.PATH_FILES + stripImages[stripImages.length - 1][2]);
                    } catch (Exception e) {
                        logger.error(txId + "establecerIngreso Error al eliminar archivo firma/visto del disco :" + ucmClient.PATH_FILES + stripImages[stripImages.length - 1][2]);
                    }
                }
            }
        }
        if (pdfFile!=null && !pdfFile.isEmpty()) {
            try {
                ucmClient.eliminarArchivo(pdfFile);
            } catch (Exception e) {
                logger.error(txId + "establecerIngreso Error al eliminar archivo PDF del disco :" + pdfFile);
            }
        }
                
        
        return bytes;
    }

    private Boolean validarImagen(String txId, String rutaImagen) {
        return true;
        /*BufferedImage image=null;
      boolean rpta=false;
      try {
          image = javax.imageio.ImageIO.read( new File(rutaImagen) );
          if (image==null){
            logger.error(txId+" Imagen no válida ==>"+rutaImagen );
          }else{
            rpta=true;
          }
      } catch (IOException e) {
          logger.error(txId+"validarImagen  :" + e);
      } catch (Exception e) {
          logger.error(txId+"validarImagen  :" + e);
      }finally{
          if (image!=null)
            image=null;
      }
      return rpta;*/
    }

    private String ejecutarReciboDocumento(String txId, Documento documento, String nombrePlantilla) {

        logger.debug("INICIANDO ejecutarReciboDocumento");

        String dDocName = null;

        String nombreArchivo = ucmClient.PATH_FILES + ucmClient.obtenerPlantilla(txId, nombrePlantilla);

        MsWordReplace msreplace = new MsWordReplace();

        try {

            msreplace.Open(nombreArchivo);

            msreplace.ReplaceTextByText("mesaPartes", remplazo(documento.getCodigoCentroTramite()));
            msreplace.ReplaceTextByText("fechaHora", remplazo(documento.getReciboPago().getFechaHora()));
            msreplace.ReplaceTextByText("usuarioName", remplazo(documento.getSolicitante().getNombreRepresentanteLegal()));
            msreplace.ReplaceTextByText("numeroDocumento", remplazo(documento.getCodigoServicio()));
            msreplace.ReplaceTextByText("rucDni", remplazo(documento.getSolicitante().getDniRuc()));
            msreplace.ReplaceTextByText("razonSocial", remplazo(documento.getSolicitante().getNombreRazonSocial()));
            msreplace.ReplaceTextByText("correoElectronico", remplazo(documento.getSolicitante().getEmail()));

            logger.debug("Terminando de reemplazar en memoria los datos del documento antes de enviar al UCM.");

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        } finally {

            if (msreplace != null) {
                msreplace.Close(nombreArchivo);
            }

        }
        logger.debug("IngresarDocumento dDocName al UCM:" + dDocName);
        dDocName = ucmClient.ingresarDocumento(txId, nombreArchivo, documento);
        logger.debug("FINALIZANDO ejecutarReciboDocumento");

        return dDocName;
    }

    public static void main(String[] args) {
        /*Documento doc = new Documento();
		CreacionDocumentos cdoc = new CreacionDocumentos();
		ReciboPago recibo = new ReciboPago();
		ServicioTUPA serv = new ServicioTUPA();
		recibo.setNumeroExpediente("492348923149");
		recibo.setValorPagado("103.00");
		recibo.setValorSaldo("3.00");

		ArrayList<ReciboServicio> servicios = new ArrayList<ReciboServicio>();

		doc.setCodigoCentroTramite("27");


		ReciboServicio recser = new ReciboServicio();
		recser.setNombreServicio("hjewr wueruqweruwqeuewhurhqe uuewrh erhteu hiuerhtuwehtu");
		recser.setMontoServicio(120.0);
		servicios.add(recser);

		ReciboServicio recser2 = new ReciboServicio();
		recser2.setNombreServicio("YTYTYTY   TYTTYTTY");
		recser2.setMontoServicio(10.0);
		servicios.add(recser2);

		ReciboServicio recser3 = new ReciboServicio();
		recser3.setNombreServicio("YYYYugcggcv udyc xcft tcvttfc tf");
		recser3.setMontoServicio(5620.0);
		servicios.add(recser3);


		doc.setServiciosTUPARecibo(servicios);
		doc.setReciboPago(recibo);
		doc.setServicioTupa(serv);

		cdoc.nombrePlantilla = "00003758";
		cdoc.documento = doc;
*/
        //cdoc.ejecutarReciboPago2();
    }

    public String generarNumeroDocumento(String subTipo, String area, String subArea, String personaId) {
        Connection con = null;
        String sql = SenasaSQL.CREAR_DOCUMENTO;
        CallableStatement cstmt = null;
        String rpta = "Error";
        
        try {
            con = helper.getConnection();
            logger.info("=======Inicio de generarNumeroDocumento en DB ======= ");
            cstmt = con.prepareCall(sql);
            logger.info(" Preparando llamada al SP " + sql);
            logger.info(" subTipo = " + subTipo + " area=  " + area + " subArea=" + subArea + " personaId" + personaId);

            cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
            cstmt.setString(2, subTipo);
            cstmt.setString(3, area);
            cstmt.setString(4, subArea);
            cstmt.setString(5, personaId);

            logger.info(" Ejecutando llamada al SP " + sql);
            cstmt.execute();
            logger.info(" Ejecutó correctamente ");
            rpta = cstmt.getString(1);
            logger.info(" resultado= " + rpta);
        } catch (SQLException e) {
            rpta = "Error SQLException " + e.getMessage();
            logger.info(" SQLException : generarNumeroDocumento en DB", e);
        } catch (Exception e) {
            rpta = "Error Exception " + e.getMessage();
            logger.info(" Exception al generarNumeroDocumento en DB ", e);
        } finally {
            try {
                if (cstmt != null)
                    cstmt.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando el statement:" + sqe.getMessage());
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando cerrando la conexión con la base de datos:" + sqe.getMessage());
            }

            //DataBaseDAO.cleanup(con, cstmt);
        }
        return rpta;
    }

    public Boolean eliminarNumeroDocumento(String numero) {
        Connection con = null;
        String sql = SenasaSQL.ELIMINAR_DOCUMENTO;
        CallableStatement cstmt = null;
        boolean rpta = false;
        try {
            con = helper.getConnection();
            logger.info("=======Inicio de eliminarDocumento en DB ======= ");
            cstmt = con.prepareCall(sql);
            logger.info(" Preparando llamada al SP " + sql);
            logger.info(" numero = " + numero);

            cstmt.setString(1, numero);

            logger.info(" Ejecutando llamada al SP " + sql);
            cstmt.execute();
            logger.info(" Ejecutó correctamente ");
            rpta = true;
        } catch (SQLException e) {
            rpta = false;
            logger.info(" SQLException : eliminarDocumento en DB", e);
        } catch (Exception e) {
            rpta = false;
            logger.info(" Exception al eliminarDocumento en DB ", e);
        } finally {
            try {
                if (cstmt != null)
                    cstmt.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando el statement:" + sqe.getMessage());
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando cerrando la conexión con la base de datos:" + sqe.getMessage());
            }

        }
        return rpta;
    }

    private String obtenerFechaActual() {
        String fechaActual = null;
        try {
            Date fecha = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaActual = sdf.format(fecha);
            logger.debug("La fecha de hoy es:" + sdf.format(fecha));
        } catch (Exception e) {
            fechaActual = "";
        }
        return fechaActual;
    }
}
