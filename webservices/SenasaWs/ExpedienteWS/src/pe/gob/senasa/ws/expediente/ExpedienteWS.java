package pe.gob.senasa.ws.expediente;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.ws.expediente.bean.Expediente;
import pe.gob.senasa.helper.bean.Auditoria;
import pe.gob.senasa.ws.expediente.dao.ExpedienteDAO;

@XmlSeeAlso({Auditoria.class, Expediente.class})
@WebService(name = "Expediente",serviceName = "Expediente", 
            targetNamespace = "http://expediente.ws.senasa.gob.pe", portName = "ExpedientePort")
public class ExpedienteWS implements IExpedienteServicio {
    private ExpedienteDAO dao = null;
    public ExpedienteWS() {
        super();
        dao = new ExpedienteDAO();
    }
    
    @WebMethod
    public Expediente registrarExpediente(String personaId, 
                                          String codigoCentro, 
                                          String observacion, 
                                          String userName) {
        return dao.registrarExpediente(personaId, codigoCentro, observacion, userName);
    }

    @WebMethod
    public Auditoria anexarDocumentoExpediente(String codigoDocumento, 
                                               String codigoExpediente, 
                                               String userName) {
        return dao.anexarDocumentoExpediente(codigoDocumento, codigoExpediente, userName);
    }
    
    @WebMethod
    public Auditoria registrarTrazabilidadTUPAInicio(@WebParam(name = "codigoExpediente") String codigoExpediente, 
                                                     @WebParam(name = "codigoRecibo") String codigoRecibo, 
                                                     @WebParam(name = "canal") String canal, 
                                                     @WebParam(name = "userName") String userName) {
        return dao.registrarTrazabilidadTUPAInicio(codigoExpediente, codigoRecibo, canal, userName);
    }
    
    @WebMethod
    public Expediente obtenerExpedienteStd(String numeroExpediente) {
        return dao.obtenerExpedienteStd(numeroExpediente);
    }
    
    @WebMethod
    public Expediente obtenerExpedienteVuce(@WebParam(name = "numeroExpediente") String numeroExpediente, 
                                            @WebParam(name = "numeroOrden") String numeroOrden) {
        return dao.obtenerExpedienteVuce(numeroExpediente, numeroOrden);
    }
    
    @WebMethod
    public Expediente obtenerExpedienteTupa(@WebParam(name = "numeroExpediente") String numeroExpediente) {
        return dao.obtenerExpedienteTupa(numeroExpediente);
    }
    
    @WebMethod
    public Auditoria cierreTotal(@WebParam(name = "numeroExpediente") String numeroExpediente, 
                                 @WebParam(name = "usuario") String userName,
                                 @WebParam(name = "estadoDictamen") String estadoDictamen ) {
        return dao.cierreTotal(numeroExpediente,userName, estadoDictamen);
    }
    
    @WebMethod
    public Expediente cerrarExpediente(@WebParam(name = "codigoCentro") String codigoCentro, 
                                                     @WebParam(name = "codigoExpediente") String codigoExpediente, 
                                                     @WebParam(name = "personaId") String personaId, 
                                                     @WebParam(name = "codigoProcedimiento") String codigoProcedimiento,
                                                     @WebParam(name = "userId") String userId,
                                                     @WebParam(name = "documentos") String documentos) {
        return dao.cerrarExpediente(codigoCentro, codigoExpediente, personaId, codigoProcedimiento, userId, documentos);
    }
  @WebMethod
  public Expediente obtenerOrdenPorMTO(String numeroMTO) {
      return dao.obtenerOrdenPorMTO(numeroMTO);
  }
}
