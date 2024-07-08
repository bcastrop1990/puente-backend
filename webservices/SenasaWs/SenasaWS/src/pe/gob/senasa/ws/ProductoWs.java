package pe.gob.senasa.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.AnimalesVivos;
import pe.gob.senasa.bean.CentroTramite;
import pe.gob.senasa.bean.LugarInspeccion;
import pe.gob.senasa.bean.LugarUbicacionEnvio;
import pe.gob.senasa.bean.MedioTransporte;
import pe.gob.senasa.bean.Producto;
import pe.gob.senasa.bean.PuestoControl;
import pe.gob.senasa.bean.Sede;
import pe.gob.senasa.bean.Tarifa;
import pe.gob.senasa.bean.TipoEnvase;
import pe.gob.senasa.bean.UnidadMedida;
import pe.gob.senasa.bean.UsoDestino;
import pe.gob.senasa.dao.ProductoDAO;
import pe.gob.senasa.interfaces.ProductoInterface;


/**
 * Manejo de información y operaciones de Producto.
 */
@XmlSeeAlso({Tarifa.class})
@WebService(name = "Producto",serviceName = "Producto",
            targetNamespace = "http://producto.ws.senasa.gob.pe",
            portName = "ProductoPort")
public class ProductoWs implements ProductoInterface 
{
    
    ProductoDAO pDAO = null;

    /**
     */
    public ProductoWs() {
        pDAO = new ProductoDAO();
    }

    /**
     * 
     * status: Terminado
     * @param tipoBusqueda
     * @param textoBusqueda
     * @param tipoProducto
     * @param uso
     * @return
     */
    @WebMethod
    public ArrayList<Producto> obtenerProductos(String tipoBusqueda, String textoBusqueda, String tipoProducto, String uso){
        return pDAO.obtenerProductos(tipoBusqueda,textoBusqueda,tipoProducto, uso);
    }

    /**
     * 
     * status: Terminado
     * @param codigoProducto
     * @return
     */
    @WebMethod
    public Producto obtenerProducto(String codigoProducto){
        return pDAO.obtenerProducto(codigoProducto);
    }
    
  @WebMethod
  public List<Producto> obtenerProducto_CPE_Germo(@WebParam(name = "Germpm") String Germpm,@WebParam(name = "CPE") String CPE, @WebParam(name = "aPaises") String aPaises){
      return pDAO.obtenerProducto_CPE_Germo(Germpm, CPE, aPaises);
  }
  @WebMethod
  public List<Producto> obtenerProducto_CPE(@WebParam(name = "CPE")String CPE){
      return pDAO.obtenerProducto_CPE(CPE);
  }

    /**
     * 
     * status: Terminado
     * @param codigoProducto
     * @param codigoServicio
     * @param peso
     * @return
     */
    @WebMethod
  public String obtenerTarifa(String codigoProducto, String codigoServicio, String peso){
      return pDAO.obtenerTarifa(codigoProducto, codigoServicio, peso);
  }

    /**
     * 
     * status: Terminado
     * @param tarifas
     * @return
     */
@WebMethod
  public String obtenerTarifaMultiple(ArrayList<Tarifa> tarifas){
      return pDAO.obtenerTarifaMultiple(tarifas);
  }

    /**
     * 
     * status: Terminado
     * @param tipoBusqueda
     * @param textoBusqueda
     * @param codigoProducto
     * @return
     */
    @WebMethod
    public ArrayList<Producto> obtenerAnexos(String tipoBusqueda, String textoBusqueda, String codigoProducto){
       
        return pDAO.obtenerAnexos(tipoBusqueda,textoBusqueda,codigoProducto);
    }

    /**
     * 
     * status: Terminado
     * @param codigoProducto
     * @return
     */
    @WebMethod
    public Producto obtenerAnexo(String codigoProducto){
        return pDAO.obtenerAnexo(codigoProducto);
    }

    /**
     * 
     * status: Terminado
     * @param tipoBusqueda
     * @return
     */
    @WebMethod
    public ArrayList<UsoDestino> obtenerUsoDestino(String tipoBusqueda){
        return pDAO.obtenerUsoDestino(tipoBusqueda);
    }

    /**
     * 
     * status: Terminado
     * @param tipoBusqueda
     * @return
     */
    @WebMethod
    public ArrayList<TipoEnvase> obtenerTipoEnvase(String tipoBusqueda){
        return pDAO.obtenerTipoEnvase(tipoBusqueda);
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<AnimalesVivos> obtenerAnimalesVivos(){
        return pDAO.obtenerAnimalesVivos();
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<Sede> obtenerSedes(){
        return pDAO.obtenerSedes();
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<PuestoControl> obtenerPuestosDeControl(){
        return pDAO.obtenerPuestosDeControl();
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<LugarUbicacionEnvio> obtenerLugarUbicacionEnvio(){
        return pDAO.obtenerLugarUbicacionEnvio();
    }

    /**
     * 
     * status: Terminado
     * @param codigoProducto
     * @return
     */
    @WebMethod
    public Boolean validarGermoplasmaProducto(String codigoProducto){
        return pDAO.validarGermoplasmaProducto(codigoProducto);
    }

    /**
     * 
     * status: Terminado
     * @param codigoProducto
     * @return
     */
    @WebMethod
    public Boolean validarRegistroCPEProducto(String codigoProducto){
        return pDAO.validarRegistroCPEProducto(codigoProducto);
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<MedioTransporte> obtenerMedioTransporte(){
        return pDAO.obtenerMedioTransporte();
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<LugarInspeccion> obtenerLugarInspeccion(){
        return pDAO.obtenerLugarInspeccion();
    }

    /**
     * 
     * status: Terminado
     * @param codigoProducto
     * @param pesoNeto
     * @return
     */
    @WebMethod
    public Boolean validarMuestras(String codigoProducto, Double pesoNeto){
        return pDAO.validarMuestras(codigoProducto,pesoNeto);
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<UnidadMedida> obtenerUnidadMedidaAnimal(){
    	return pDAO.obtenerUnidadMedida("01");
    }

    /**
     * 
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<UnidadMedida> obtenerUnidadMedidaVegetal(){
    	return pDAO.obtenerUnidadMedida("02");
    }
    
  /**
   * 
   * status: Terminado
   * @return
   */
  @WebMethod
  public ArrayList<UnidadMedida> obtenerUndMedxProducto(@WebParam(name = "codProducto") String codProducto){
    return pDAO.obtenerUndMedxProducto(codProducto);
  }
    

    /**
     *
     * @param codigoProducto
     * @param codigoPais
     * @param codigoLugarProduccion
     * @return
     */
    @WebMethod
    public ArrayList<CentroTramite> obtenerCentroTramites(String codigoProducto,String codigoPais,String codigoLugarProduccion) {
        return pDAO.obtenerCentroTramites(codigoProducto, codigoPais, codigoLugarProduccion);
    }
    
    //Modificado Ivan Cajahuaringa 18/10/2011
    @WebMethod
    public ArrayList<PuestoControl> obtenerPuestosdeControlCuarentena(String codigoProducto,String codigoPais,String codigoLugarProduccion) {
      return pDAO.obtenerPuestosdeControlCuarentena(codigoProducto, codigoPais, codigoLugarProduccion);
    }
 
}
