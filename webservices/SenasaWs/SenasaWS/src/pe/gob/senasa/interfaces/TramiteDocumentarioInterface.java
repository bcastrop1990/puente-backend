package pe.gob.senasa.interfaces;

import java.util.ArrayList;
import java.util.List;

import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.DocumentoElectronico;
import pe.gob.senasa.bean.Encargatura;
import pe.gob.senasa.bean.ReporteSTD;
import pe.gob.senasa.bean.SubTipo;
import pe.gob.senasa.bean.audit.Audit;
import pe.gob.senasa.bean.std.DocumentoSTD;
import pe.gob.senasa.bean.std.Expediente;


public interface TramiteDocumentarioInterface {

    /*public String obtenerCodigoCarga();
    public ArrayList<Sede> obtenerCentroTramites();
    public String obtenerNombreImpresoraFiscalXCentroTramite(String codigo);*/

    public List<DocumentoElectronico> obtenerBandejaElectronica();

    public void procesarDocumentoElectronico(String idEntidad, String idTransaccion, String codigoDocumento, String accion,
                                             String usuario);

    public String registrarDocumento(DocumentoSTD documento, String usuario);

    public Documento generarDocumentoTramite(byte[] documentoFisico, String nombre, Documento documento);

    public byte[] previsualizarIngresoDocTramite(byte[] documentoFisico, String nombre, Documento documento);

    public void actualizarDocumento(DocumentoSTD documento, String usuario); 
  
    public void actualizarArchivo(DocumentoSTD documento, String usuario);
    
    public void eliminarDocumentoAdjunto(DocumentoSTD documento);

    public ArrayList<DocumentoSTD> obtenerAdjuntos(DocumentoSTD doc);

    public int verificaParticipacion(DocumentoSTD doc);

    public List<ReporteSTD> consultaSTDGeneral(ReporteSTD reporteSTD);
    
  public List<ReporteSTD> consultaSTDGeneralExterno(ReporteSTD reporteSTD);

    public List<DocumentoSTD> consultaSTDDocumentos(String codElemento);

    public List<ReporteSTD> consultaSTDxIdFinal(String idFinal);

    public List<Encargatura> obtenerEncargatura(String usuario);

    public List<Encargatura> obtenerEncargado(String usuario);
    
    public Expediente obtenerExpedienteStd(String numeroExpediente);
    
    public DocumentoSTD obtenerDocumentoStd(String codigoDocumento, String numeroDocumento);
    
    public List<SubTipo> obtenerTiposDocMesaPartes();
    
    public Expediente registrarExpediente(String personaId, String codigoCentro, String observacion, String userName);
    
    public Audit anexarDocumentoExpediente(String codigoDocumento, String codigoExpediente, String userName);
}
