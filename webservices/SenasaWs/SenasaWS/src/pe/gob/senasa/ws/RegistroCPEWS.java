package pe.gob.senasa.ws;


import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import pe.gob.senasa.bean.CpeGermpGC;
import pe.gob.senasa.bean.FuncionesEquipoTecnico;
import pe.gob.senasa.bean.RegistroCPE;
import pe.gob.senasa.dao.RegistroCPEDAO;
import pe.gob.senasa.interfaces.RegistroCPEInterface;


/**
 * Manejo de información y operaciones de Cuarentena PosEntrada.
 */
@WebService(name = "RegistroCPE",serviceName = "RegistroCPE",
            targetNamespace = "http://registrocpe.ws.senasa.gob.pe",
            portName = "RegistroCPEPort")
public class RegistroCPEWS implements RegistroCPEInterface {
    
    RegistroCPEDAO rDAO = null;

    /**
     */
    public RegistroCPEWS() {
        rDAO = new RegistroCPEDAO();
    }


    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<FuncionesEquipoTecnico> obtenerFuncionesEquipoTecnicoCPE(){
        return rDAO.obtenerFuncionesEquipoTecnicoCPE();
    }

    /**
     * 
     * status: Terminado
     * @param dniRuc
     * @return
     */
    @WebMethod
    public RegistroCPE obtenerRegistroCPE(String noCertificado){
        return rDAO.obtenerRegistroCPE(noCertificado);
    }

    @WebMethod
    public RegistroCPE obtenerRegistroCPExExpediente(@WebParam(name = "nroExpediente")String noExpediente){
        return rDAO.obtenerRegistroCPExExpediente(noExpediente);
    }

    @WebMethod
    public String generarNroCertificadoCPE(@WebParam(name = "codDirEjecutiva") String codDirEjecutiva){
      return rDAO.obtenerCodigoCPE(codDirEjecutiva);
    }

    /**
     * 
     * status: Terminado
     * @param registroCPE
     * @return
     */
    @WebMethod
    public boolean guardarRegistroCPE(RegistroCPE registroCPE){
        return rDAO.guardarRegistroCPE(registroCPE);
    }
      

    /**
     * 
     * status: En Pruebas
     * @param noCertificado
     * @return
     */
    @WebMethod
  public boolean ampliarCertificadoCPE(String noCertificado){
    return true;
  }
    
  @WebMethod
  public List<CpeGermpGC> obtenerRegistrosCpeGermpGC(@WebParam(name = "nroDOC") String nroDOC,@WebParam(name = "formato") String formato){
    return rDAO.obtenerRegistrosCpeGermpGC(nroDOC,formato);
  }
  
}