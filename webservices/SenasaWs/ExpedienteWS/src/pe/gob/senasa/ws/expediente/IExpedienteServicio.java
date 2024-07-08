package pe.gob.senasa.ws.expediente;

import javax.jws.WebMethod;

import pe.gob.senasa.ws.expediente.bean.Expediente;
import pe.gob.senasa.helper.bean.Auditoria;

public interface IExpedienteServicio {
    
    public Expediente registrarExpediente(String personaId, String codigoCentro, String observacion, String userName);
    
    public Auditoria anexarDocumentoExpediente(String codigoDocumento, String codigoExpediente, String userName);
    
    public Expediente obtenerExpedienteStd(String numeroExpediente);
    
    public Expediente obtenerExpedienteVuce(String numeroExpediente, String numeroOrden);
    
    public Expediente obtenerExpedienteTupa(String numeroExpediente);    
    
    public Auditoria cierreTotal(String numeroExpediente, String userName, String estadoDictamen);
    
    public Expediente cerrarExpediente(String codigoCentro, String codigoExpediente, String personaId, String codigoProcedimiento, String userId, String documentos);
    
    public Expediente obtenerOrdenPorMTO(String numeroMTO);
}
