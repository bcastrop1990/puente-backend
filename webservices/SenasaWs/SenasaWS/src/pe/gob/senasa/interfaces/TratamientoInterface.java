package pe.gob.senasa.interfaces;

import java.util.ArrayList;

import pe.gob.senasa.bean.EmpresasFumigadoras;
import pe.gob.senasa.bean.ExpedienteTratamiento;
import pe.gob.senasa.bean.MotivoTratamiento;
import pe.gob.senasa.bean.Plaga;
import pe.gob.senasa.bean.TipoTratamiento;
import pe.gob.senasa.bean.Tratamiento;


public interface TratamientoInterface {
    
    public ArrayList<MotivoTratamiento> obtenerMotivosTratamientos();
    
    public ArrayList<Plaga> obtenerPlagas();
    
    public ArrayList<EmpresasFumigadoras> obtenerEmpresasFumigadoras();
    
    public ArrayList<Tratamiento> obtenerTratamientos();
    
    public ArrayList<TipoTratamiento> obtenerTipoTratamientos(String codigoClase);
    
    public ArrayList<Tratamiento> obtenerTratamientosXTipoClase(String idTipoTratamiento,String codigoClase);
    
    public ArrayList<Plaga> listarPlagasTratamiento(String descripcion, String codigoClase);
    
    public EmpresasFumigadoras obtenerEmpresaFumigadoraXRUC(String numeroRegistro);
    
    public boolean registrarTratamientoInspeccion(ExpedienteTratamiento lista);
  public ExpedienteTratamiento obtenerDatosTratamiento(String codigoExpediente, String codigoServicio);
}
