package pe.gob.senasa.ws.documentoStd;

import java.util.List;

import javax.jws.WebMethod;

import pe.gob.senasa.helper.FileHelper;
import pe.gob.senasa.helper.bean.Auditoria;
import pe.gob.senasa.ws.documentoStd.bean.DocumentoStd;
import pe.gob.senasa.ws.documentoStd.bean.ReporteItem;
import pe.gob.senasa.ws.documentoStd.gestion.GestionDocumentoStd;

public interface IDocumentoStdServicio {
    
    public DocumentoStd obtenerPlantilla(String idPlantilla, DocumentoStd conPlantilla);
    
    public DocumentoStd previsualizarDocumento(byte[] documentoFisico, String nombre, DocumentoStd documento);
    
    public DocumentoStd generarDocumento(byte[] documentoFisico, String nombre, DocumentoStd documento);
    
    public String solicitarServicioOCR(String fileName, byte[] archivo);
    
    public byte[] verificarServicioOCR(String fileName);
    
    public List<ReporteItem> consultaGeneral(ReporteItem reporteFiltro);
    
    public List<ReporteItem> consultaPendientes(ReporteItem reporteFiltro);
    
    public List<ReporteItem> reporteGeneral(ReporteItem reporteFiltro);
    
    public ReporteItem exportarReporte(ReporteItem reporteFiltro, String formato);
    
    public Auditoria consultarParticipacion(String codigoDocumento, String participante);
    
    public DocumentoStd registrarDocumento(DocumentoStd documento, String usuario);
    
    public Auditoria actualizarDocumento(DocumentoStd documento, String usuario);
    
    public Auditoria grabarDocEnRegistroArchivo(String codigoDocumento, String nombreDocumento, String idDocumento, String ucmId);
    
    public Auditoria grabarResolutivoProv(String centroTraminte, String codigoExpediente, String personaId, 
                                          String codigoProcedimiento, String usuario, String documentos, 
                                          String destinatario, String canal, String observacion);
    
}