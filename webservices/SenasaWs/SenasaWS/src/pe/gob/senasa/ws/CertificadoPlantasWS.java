package pe.gob.senasa.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pe.gob.senasa.bean.CertificadoPlantas;
import pe.gob.senasa.dao.CertificadoPlantasDAO;
import pe.gob.senasa.interfaces.CertificadoPlantasInterface;


@WebService(name = "CertificadoPlantas", serviceName = "CertificadoPlantas",
            targetNamespace = "http://certificadoplantas.ws.senasa.gob.pe",
            portName="CertificadoPlantasPort")
public class CertificadoPlantasWS implements CertificadoPlantasInterface {
    
    CertificadoPlantasDAO cflpDAO = null;
    
    public CertificadoPlantasWS() {
        super();
        cflpDAO = new CertificadoPlantasDAO();
    }

    @WebMethod
    public boolean registarPlantas(CertificadoPlantas bean) {
        return cflpDAO.registarPlantas(bean);
    }
}