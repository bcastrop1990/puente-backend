package pe.gob.senasa.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pe.gob.senasa.dao.VerificaCierreDAO;
import pe.gob.senasa.interfaces.VerificaCierreInterface;


@WebService(name = "VerificaCierre",serviceName = "VerificaCierre",
            targetNamespace = "http://general.ws.senasa.gob.pe",
            portName = "VerificaCierrePort")
public class VerificaCierreWS implements VerificaCierreInterface {

    VerificaCierreDAO vDAO = null;
    public VerificaCierreWS() {
      vDAO = new VerificaCierreDAO();
    }

    @WebMethod
    public String actualizaIndicadorBPM(String codigoSolicitud,
                                        String indicadorBPM, String userName) {
        return vDAO.actualizaIndicadorBPM(codigoSolicitud, indicadorBPM, userName);
    }
    
    @WebMethod
    public String solicitudEnEspera(String codigoSolicitud) {
        return vDAO.solicitudEnEspera(codigoSolicitud);
    }
}
