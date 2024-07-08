package pe.gob.senasa.interfaces;

import java.util.ArrayList;
import java.util.List;

import pe.gob.senasa.bean.AnimalesVivos;
import pe.gob.senasa.bean.CentroTramite;
import pe.gob.senasa.bean.LugarInspeccion;
import pe.gob.senasa.bean.LugarUbicacionEnvio;
import pe.gob.senasa.bean.MedioTransporte;
import pe.gob.senasa.bean.Producto;
import pe.gob.senasa.bean.Sede;
import pe.gob.senasa.bean.Tarifa;
import pe.gob.senasa.bean.TipoEnvase;
import pe.gob.senasa.bean.UnidadMedida;
import pe.gob.senasa.bean.UsoDestino;


public interface ProductoInterface {
    
    public ArrayList<Producto> obtenerProductos(String tipoBusqueda, String textoBusqueda, String tipoProducto, String uso);
    
    public Producto obtenerProducto(String codigoProducto);
    
    public String obtenerTarifa(String codigoProducto, String codigoServicio, String peso);
    
    public String obtenerTarifaMultiple(ArrayList<Tarifa> tarifas);
    
    public ArrayList<Producto> obtenerAnexos(String tipoBusqueda, String textoBusqueda, String codigoProducto);
    
    public Producto obtenerAnexo(String codigoProducto);
    
    public ArrayList<UsoDestino> obtenerUsoDestino(String tipoBusqueda);
    
    public ArrayList<TipoEnvase> obtenerTipoEnvase(String tipoBusqueda);
    
    public ArrayList<AnimalesVivos> obtenerAnimalesVivos();
    
    public ArrayList<Sede> obtenerSedes();
    
    public ArrayList<LugarUbicacionEnvio> obtenerLugarUbicacionEnvio();
    
    public Boolean validarGermoplasmaProducto(String codigoProducto);
    
    public Boolean validarRegistroCPEProducto(String codigoRequisito);
    
    public ArrayList<MedioTransporte> obtenerMedioTransporte();
    
    public ArrayList<LugarInspeccion> obtenerLugarInspeccion();
    
  public ArrayList<CentroTramite> obtenerCentroTramites(String codigoProducto,String codigoPais,String codigoLugarProduccion);
    
  public Boolean validarMuestras(String codigoProducto, Double pesoNeto);
  public ArrayList<UnidadMedida> obtenerUndMedxProducto(String codProducto);
  public List<Producto> obtenerProducto_CPE_Germo(String Germpm,String CPE,  String paises);
  public List<Producto> obtenerProducto_CPE(String CPE);
  
}