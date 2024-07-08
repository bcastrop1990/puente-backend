package pe.gob.senasa.ws;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.Dato;
import pe.gob.senasa.bean.EmpresasFumigadoras;
import pe.gob.senasa.bean.ExpedienteTratamiento;
import pe.gob.senasa.bean.MotivoTratamiento;
import pe.gob.senasa.bean.Plaga;
import pe.gob.senasa.bean.TipoTratamiento;
import pe.gob.senasa.bean.Tratamiento;
import pe.gob.senasa.bean.TratamientoInspeccion;
import pe.gob.senasa.dao.TratamientoDAO;
import pe.gob.senasa.interfaces.TratamientoInterface;


/**
 * Manejo de información y operaciones de tratamientos.
 */
@XmlSeeAlso({ExpedienteTratamiento.class, Dato.class,ArrayList.class,TratamientoInspeccion.class})
@WebService(name = "Tratamiento",serviceName = "Tratamiento",
            targetNamespace = "http://tratamiento.ws.senasa.gob.pe",
            portName = "TratamientoPort")
public class TratamientoWS implements TratamientoInterface {
    
    TratamientoDAO tDAO = null;
    
    public TratamientoWS() {
        tDAO = new TratamientoDAO();
    }


    /**
     * Permite obtener los motivos del tratamiento.
     * status: terminado
     * @return
     */
    @WebMethod
    public ArrayList<MotivoTratamiento> obtenerMotivosTratamientos(){
        return tDAO.obtenerMotivosTratamientos();
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<Plaga> obtenerPlagas(){
        return tDAO.obtenerPlagas();
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<EmpresasFumigadoras> obtenerEmpresasFumigadoras(){
        return tDAO.obtenerEmpresasFumigadoras();
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<Tratamiento> obtenerTratamientos(){
        return tDAO.obtenerTratamientos();
    }
    
    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<TipoTratamiento> obtenerTipoTratamientos(String codigoClase)
    {
       return tDAO.obtenerTipoTratamientos(codigoClase);
    }
  
    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<Tratamiento> obtenerTratamientosXTipoClase(String idTipoTratamiento,String codigoClase)
    {
       return tDAO.obtenerTratamientosXTipoClase(idTipoTratamiento, codigoClase);
    }

    @WebMethod
    public ArrayList<Plaga> listarPlagasTratamiento(String descripcion,String codigoClase)
    {
        return tDAO.listarPlagasTratamiento(descripcion, codigoClase);
    }

    @WebMethod
    public EmpresasFumigadoras obtenerEmpresaFumigadoraXRUC(String numeroRegistro) {
        return tDAO.obtenerEmpresaFumigadoraXRUC(numeroRegistro);
    }

    @WebMethod
    public boolean registrarTratamientoInspeccion(ExpedienteTratamiento lista) {
        return tDAO.registrarTratamientoInspeccion(lista);
    }
  @WebMethod
    public ExpedienteTratamiento obtenerDatosTratamiento(String codigoExpediente, String codigoServicio){
      return tDAO.obtenerDatosTratamiento(codigoExpediente, codigoServicio);
    }
}
