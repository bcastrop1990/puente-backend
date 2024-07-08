package pe.gob.senasa.ws.documentoStd;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.apache.log4j.Logger;

import pe.gob.senasa.helper.FileHelper;
import pe.gob.senasa.helper.bean.Auditoria;
import pe.gob.senasa.ws.documentoStd.bean.DocumentoStd;
import pe.gob.senasa.ws.documentoStd.bean.FuncionarioStd;
import pe.gob.senasa.ws.documentoStd.bean.ReporteItem;
import pe.gob.senasa.ws.documentoStd.dao.DocumentoStdDAO;
import pe.gob.senasa.ws.documentoStd.gestion.GestionDocumentoStd;

@WebService(name = "DocumentoStd", serviceName = "DocumentoStd", targetNamespace = "http://documentoStd.ws.senasa.gob.pe",
            portName = "DocumentoStd")
public class DocumentoStdWS implements IDocumentoStdServicio {
    protected static Logger logger = Logger.getLogger(DocumentoStdWS.class);
    private GestionDocumentoStd gestionDoc = null;
    private DocumentoStdDAO dao = null;

    private static long transaccion = 0;
    private String txId = "";

    public DocumentoStdWS() {
        super();
        gestionDoc = new GestionDocumentoStd();
        dao = new DocumentoStdDAO();
    }

    @WebMethod
    public DocumentoStd obtenerPlantilla(String idPlantilla, DocumentoStd conPlantilla) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        try {
            return gestionDoc.obtenerPlantilla(txId, idPlantilla, conPlantilla);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @WebMethod
    public DocumentoStd previsualizarDocumento(byte[] documentoFisico, String nombre, DocumentoStd documento) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        try {
            gestionDoc = new GestionDocumentoStd();
            return gestionDoc.previsualizar(txId, documentoFisico, nombre, documento);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @WebMethod
    public DocumentoStd generarDocumento(byte[] documentoFisico, String nombre, DocumentoStd documento) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        try {
            return gestionDoc.generar(txId, documentoFisico, nombre, documento);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @WebMethod
    public String solicitarServicioOCR(String fileName, byte[] archivo) {
        try {
            return FileHelper.solicitarServicioOCR(fileName, archivo);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @WebMethod
    public byte[] verificarServicioOCR(String fileName) {
        try {
            return FileHelper.verificarServicioOCR(fileName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @WebMethod
    public List<ReporteItem> consultaGeneral(ReporteItem reporteFiltro) {
        return dao.consultaGeneral(reporteFiltro);
    }
    
    @WebMethod
    public List<ReporteItem> consultaPendientes(ReporteItem reporteFiltro) {
        return dao.consultaPendientes(reporteFiltro);
    }
    
    @WebMethod
    public List<ReporteItem> reporteGeneral(ReporteItem reporteFiltro) {
        return dao.reporteGeneral(reporteFiltro);
    }

    @WebMethod
    public ReporteItem exportarReporte(ReporteItem reporteFiltro, String formato) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        try {
            gestionDoc = new GestionDocumentoStd();
            return gestionDoc.exportarReporte(reporteFiltro, formato);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @WebMethod
    public Auditoria consultarParticipacion(String codigoDocumento, String participante) {
        return new DocumentoStdDAO().consultarParticipacion(codigoDocumento, participante);
    }

    @WebMethod
    public DocumentoStd registrarDocumento(DocumentoStd documento, String usuario) {
        return new DocumentoStdDAO().registrarDocumento(documento, usuario);
    }

    @WebMethod
    public Auditoria actualizarDocumento(DocumentoStd documento, String usuario) {
        return new DocumentoStdDAO().actualizarDocumento(documento, usuario);
    }
    
    @WebMethod
    public Auditoria grabarDocEnRegistroArchivo(String codigoDocumento, String nombreDocumento, String idDocumento, String ucmId) {
        return new DocumentoStdDAO().grabarDocEnRegistroArchivo(codigoDocumento, nombreDocumento, idDocumento, ucmId);
    }
    
    @WebMethod
    public Auditoria grabarResolutivoProv(String centroTraminte, String codigoExpediente, String personaId, 
                                          String codigoProcedimiento, String usuario, String documentos, 
                                          String destinatario, String canal, String observacion)  {
        return new DocumentoStdDAO().grabarResolutivoProv(centroTraminte, codigoExpediente, personaId, 
                                            codigoProcedimiento, usuario, documentos, 
                                          destinatario, canal, observacion);
    }
    
    @WebMethod
    public DocumentoStd grabarDocAnexo(@WebParam(name = "codExpediente")String codExpediente, 
                                       @WebParam(name = "tipo")String tipo, 
                                       @WebParam(name = "subTipo")String subTipo, 
                                       @WebParam(name = "nombre")String nombre, 
                                       @WebParam(name = "usuario")String usuario) {
        return new DocumentoStdDAO().grabarDocAnexo(codExpediente, tipo, subTipo, nombre, usuario);
    }
}
