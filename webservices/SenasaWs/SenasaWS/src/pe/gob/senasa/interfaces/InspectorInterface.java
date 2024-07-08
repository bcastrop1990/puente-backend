package pe.gob.senasa.interfaces;

import java.util.ArrayList;

import pe.gob.senasa.bean.Inspector;


public interface InspectorInterface {

    public ArrayList<Inspector> obtenerInspectoresPuntoIngreso(String puntoIngreso);
    public ArrayList<Inspector> obtenerInspectoresPorUbigeo(String codDpto, String codProv, String codDist);
  public ArrayList<Inspector> obtenerInspectoresPorCentroTramite(String codCentroTramite, String codRol);
  public ArrayList<Inspector> obtenerInspectoresPorDepartamento(String codDepartamento, String codRol);
    public ArrayList<Inspector> obtenerInspectoresPorSede(String codSede);
    
}
