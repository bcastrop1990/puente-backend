package pe.gob.senasa.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pe.gob.senasa.bean.CertificadoFitoLugarProduccion;
import pe.gob.senasa.dao.CertificadoFitoLugarProduccionDAO;
import pe.gob.senasa.interfaces.CertificadoFitoLugarProduccionInterface;


@WebService(name = "CertificacionFitoLugarProduccion", serviceName = "CertificacionFitoLugarProduccion",
            targetNamespace = "http://certificacionfitolugarproduccion.ws.senasa.gob.pe",
            portName="CertificacionFitoLugarProduccionPort")
public class CertificacionFitoLugarProduccionWS implements CertificadoFitoLugarProduccionInterface {
    
    CertificadoFitoLugarProduccionDAO cflpDAO = null;
    
    public CertificacionFitoLugarProduccionWS() {
        super();
        cflpDAO = new CertificadoFitoLugarProduccionDAO();
    }

    @WebMethod
    public boolean registarSoliLugarProduccion(CertificadoFitoLugarProduccion bean) {
        return cflpDAO.registarSoliLugarProduccion(bean);
    }
}
