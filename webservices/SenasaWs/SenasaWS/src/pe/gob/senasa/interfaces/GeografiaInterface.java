package pe.gob.senasa.interfaces;

import java.util.ArrayList;

import pe.gob.senasa.bean.CentroTramite;
import pe.gob.senasa.bean.Departamento;
import pe.gob.senasa.bean.Distrito;
import pe.gob.senasa.bean.LugarProduccion;
import pe.gob.senasa.bean.Pais;
import pe.gob.senasa.bean.Provincia;
import pe.gob.senasa.bean.PuntoSalida;


public interface GeografiaInterface {
    
    public ArrayList<Departamento> obtenerDepartamentos();
    
    public ArrayList<Provincia> obtenerProvincias(String Departamento);
    
    public ArrayList<Distrito> obtenerDistritos(String Departamento, String Provincia);
    
    public ArrayList<Pais> obtenerPais();
    
    public ArrayList<LugarProduccion> obtenerLugarProduccion(String pais);
    
  public ArrayList<PuntoSalida> obtenerPuntosSalida();
        
  public ArrayList<PuntoSalida> obtenerPuntosSalidaxPais(String pais);
  
  public CentroTramite obtenerCentroTramite(String codigoCentroTramite);
}
