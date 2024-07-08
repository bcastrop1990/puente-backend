package pe.gob.senasa.ws;


import com.stellent.cis.ICISApplication;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Dato;
import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.Firmante;
import pe.gob.senasa.bean.Informacion;
import pe.gob.senasa.bean.std.DocumentoSTD;
import pe.gob.senasa.dao.DocumentoStdDAO;
import pe.gob.senasa.interfaces.DocumentosInterface;
import pe.gob.senasa.tupa.CreacionDocumentos;
import pe.gob.senasa.tupa.cis.CisClient;


/**
 * Manejo de información y operaciones de Documentos y plantillas en el UCM.
 */
@XmlSeeAlso( { Informacion.class, Dato.class })
@WebService(name = "Documentos", serviceName = "Documentos", targetNamespace = "http://documentos.ws.senasa.gob.pe",
            portName = "DocumentosPort")
public class Documentos implements DocumentosInterface {
    protected static Logger logger = Logger.getLogger(Documentos.class);
    private CreacionDocumentos creacionDocumentos = null;

    private static transient long transaccion = 0;
    private String txId = "";

    private DocumentoStdDAO documentoStdDAO;

    public Documentos() {
        creacionDocumentos = new CreacionDocumentos();
        documentoStdDAO = new DocumentoStdDAO();
    }

    /**
     * Método que genera el documento resultante.
     *
     * status: En pruebas
     * @param nombrePlantilla Código de la plantilla a descargar desde ucm y reemplazar sus valores.
     * @param documento Informacion de la plantilla, este va a ser una clase con atributos.
     * @return idDocumento
     */
    @WebMethod
    public String crearDocumento(String nombrePlantilla, Documento documento) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return creacionDocumentos.ejecutarConstruccion(txId, nombrePlantilla, documento);
    }


    /* @WebMethod
    public String testWrite(String sw)   {
        return  creacionDocumentos.testWrite(sw);
    }*/


    /**
     *
     * status: En Pruebas
     * Obtiene la url del documento ingresado en UCM.
     * @param idDocumento dId o copntentId del documento ingresado
     * @return url del documento
     */
    @WebMethod
    public String obtenerUrlDocumento(String idDocumento) {
        /*
    transaccion++;
    txId = "txId=[" + String.valueOf(transaccion) + "] ";
    return creacionDocumentos.obtenerUrl(txId,idDocumento);         */
        logger.info("Consultando url para el dDocname " + idDocumento);
        String url = null;
        /*if (idDocumento.indexOf("1-VISTO")>=0 || idDocumento.indexOf("2-FIRMA")>=0){
      url="Url no existe para este dDocName";
      logger.info("Consultando url para el dDocname rpta==>"+url);
    }else{
      //url= ucmClient.obtenerUrl(txId, dDocName);
      CisClient clienteCis = new CisClient();
      ICISApplication aplicacion = clienteCis.incializarAplicacion();
      url=clienteCis.obtenerUrl(idDocumento, aplicacion);
    }*/

        CisClient clienteCis = new CisClient();
        ICISApplication aplicacion = clienteCis.incializarAplicacion();
        url = clienteCis.obtenerUrl(idDocumento, aplicacion);
        return url;
    }

    /**
     * @param idPlantilla
     * @param conPlantilla
     * @return
     */
    @WebMethod
    public byte[] obtenerDocumento(String idPlantilla, Documento conPlantilla) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        try {
            return creacionDocumentos.ejecutarConstruccion(txId, idPlantilla, conPlantilla, null);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    /**
     * @param documentoFisico
     * @param nombre
     * @param documento
     * @return
     */
    @WebMethod
    public String ejecutarIngreso(byte[] documentoFisico, String nombre, Documento documento) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return creacionDocumentos.establecerIngreso(txId, documentoFisico, nombre, documento);
    }

    @WebMethod
    public byte[] previsualizarIngreso(byte[] documentoFisico, String nombre, Documento documento) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        try {
            return creacionDocumentos.previsualizarIngreso(txId, documentoFisico, nombre, documento);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /* @WebMethod
    public String ejecutarIngresoTest(String nplantilla) {

        return creacionDocumentos.establecerIngresoTest(nplantilla);
    }*/

    /**
     *
     * @param nombrePlantilla
     * @param informacion
     * @return
     */
    @WebMethod
    public String crearDocumentoExpoFito(String nombrePlantilla, Informacion informacion) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return creacionDocumentos.crearDocumento(txId, nombrePlantilla, informacion);
    }

    @WebMethod
    public String generarDocumento(String nombrePlantilla, Informacion informacion) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return creacionDocumentos.crearDocumento(txId, nombrePlantilla, informacion);
    }

    @WebMethod
    public String generarNumeroDocumento(@WebParam(name = "subTipo")
        String subTipo, @WebParam(name = "area")
        String area, @WebParam(name = "subArea")
        String subArea, @WebParam(name = "personaId")
        String personaId) {
        return creacionDocumentos.generarNumeroDocumento(subTipo, area, subArea, personaId);
    }

    @WebMethod
    public Boolean eliminarNumeroDocumento(@WebParam(name = "numero")
        String numero) {
        return creacionDocumentos.eliminarNumeroDocumento(numero);
    }
    //Solo para puebas

    /*@WebMethod
    public String generarDocumentoPFTI(String codigoServicio, String nroExpediente) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return creacionDocumentos.generarDocumentoPFTI(txId, codigoServicio, nroExpediente);
    }*/

    @WebMethod
    public String generarDocumentoAutorizacionSEExpoZoo(String codigoServicio, String nroExpediente) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return creacionDocumentos.generarDocumentoAutorizacionSEExpoZoo(txId, codigoServicio, nroExpediente);
    }

    @WebMethod
    public String generarDocumentoRegistroGCA(String xnombrePlantilla, String codigoServicio, String nroExpediente) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return creacionDocumentos.generarDocumentoRegistroGCA(txId, xnombrePlantilla, codigoServicio, nroExpediente);
    }

    @WebMethod
    public Boolean generarDocumentoIIVFIto(String nombrePlantilla) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return creacionDocumentos.generarDocumentoIIVFito(txId, nombrePlantilla);
    }

    @WebMethod
    public Firmante obtenerFirmante(String codigoCentroTramite, String codigoServicio) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return creacionDocumentos.obtenerFirmante(codigoCentroTramite, codigoServicio);
    }

    @WebMethod
    public DocumentoSTD grabarDocumentoStdHijo(DocumentoSTD docStd) {
        return documentoStdDAO.grabarDocumentoStdHijo(docStd);
    }

    @WebMethod
    public String ObtenerCodDocumentoStdPadre(String codigoExpediente) {
        return documentoStdDAO.ObtenerCodDocumentoStdPadre(codigoExpediente);
    }


}
