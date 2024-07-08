package pe.gob.senasa.ws;


import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import pe.gob.senasa.bean.CentroTramite;
import pe.gob.senasa.bean.Departamento;
import pe.gob.senasa.bean.Distrito;
import pe.gob.senasa.bean.LugarProduccion;
import pe.gob.senasa.bean.Pais;
import pe.gob.senasa.bean.Provincia;
import pe.gob.senasa.bean.PuntoSalida;
import pe.gob.senasa.dao.GeografiaDAO;
import pe.gob.senasa.interfaces.GeografiaInterface;


/**
 * Manejo de información y operaciones de geografia.
 */
@WebService(name = "Geografia",serviceName = "Geografia",
            targetNamespace = "http://geografia.ws.senasa.gob.pe",
            portName = "GeografiaPort")
public class GeografiaWS implements GeografiaInterface {
    
    GeografiaDAO gDAO = null;

    /**
     */
    public GeografiaWS() {
        gDAO= new GeografiaDAO();
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<Departamento> obtenerDepartamentos(){
        return gDAO.obtenerDepartamentos();
    }

    /**
     * 
     * status: Terminado
     * @param departamento
     * @return
     */
    @WebMethod
    public ArrayList<Provincia> obtenerProvincias(String departamento){
        return gDAO.obtenerProvincias(departamento);
    }

    /**
     * 
     * status: Terminado
     * @param departamento
     * @param Provincia
     * @return
     */
    @WebMethod
    public ArrayList<Distrito> obtenerDistritos(String departamento, String Provincia){
        return gDAO.obtenerDistritos(departamento, Provincia);
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<Pais> obtenerPais() {
        return gDAO.obtenerPais();
    }
    
  @WebMethod 
  public List<Pais> obtenerPaisxGermCPE(@WebParam(name = "nroGermplasma")String nroGermplasma,@WebParam(name = "nroCPE") String nroCPE) {
    return gDAO.obtenerPaisxGermCPE(nroGermplasma, nroCPE);
  }

    /**
     * 
     * status: Terminado
     * @param pais
     * @return
     */
    @WebMethod
    public ArrayList<LugarProduccion> obtenerLugarProduccion(String pais) {
        return gDAO.obtenerLugarProduccion(pais);
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
  public ArrayList<PuntoSalida> obtenerPuntosSalida() {
      return gDAO.obtenerPuntosSalida();
  }

    /**
     * 
     * status: Terminado
     * @param pais
     * @return
     */
    @WebMethod
  public ArrayList<PuntoSalida> obtenerPuntosSalidaxPais(String pais) {
      return gDAO.obtenerPuntosSalidaxPais(pais);
  }

  @WebMethod
    public CentroTramite obtenerCentroTramite(String codigoCentroTramite){
      return gDAO.obtenerCentroTramite(codigoCentroTramite);
    }
}
