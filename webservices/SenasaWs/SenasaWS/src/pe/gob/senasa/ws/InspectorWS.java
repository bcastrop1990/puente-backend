package pe.gob.senasa.ws;


import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pe.gob.senasa.bean.Inspector;
import pe.gob.senasa.dao.InspectorDAO;
import pe.gob.senasa.interfaces.InspectorInterface;


/**
 * Manejo de información y operaciones de inspectores.
 */
@WebService(name = "Inspector",serviceName = "Inspector",
            targetNamespace = "http://inspector.ws.senasa.gob.pe",
            portName = "InspectorPort")
public class InspectorWS implements InspectorInterface {
    
    
    InspectorDAO iDAO = null;

    /**
     */
    public InspectorWS() {
        iDAO = new InspectorDAO();
    }


    /**
     * 
     * status: Terminado
     * @param puntoIngreso
     * @return
     */
    @WebMethod
    public ArrayList<Inspector> obtenerInspectoresPuntoIngreso(String puntoIngreso){
        return iDAO.obtenerInspectoresPuntoIngreso(puntoIngreso);
    }
    @WebMethod
    public ArrayList<Inspector> obtenerInspectoresPorUbigeo(String codDpto, String codProv, String codDist){
        return iDAO.obtenerInspectoresPorUbigeo(codDpto, codProv, codDist);
    }
  @WebMethod
  public ArrayList<Inspector> obtenerInspectoresPorCentroTramite(String codCentroTramite, String codRol){
      return iDAO.obtenerInspectoresPorCentroTramite(codCentroTramite, codRol);
  }
  @WebMethod
  public ArrayList<Inspector> obtenerInspectoresPorDepartamento(String codDepartamento, String codRol){
      return iDAO.obtenerInspectoresPorDepartamento(codDepartamento, codRol);
  }
    @WebMethod
    public ArrayList<Inspector> obtenerInspectoresPorSede(String codSede){
      return iDAO.obtenerInspectoresPorSede(codSede);
  }


}
