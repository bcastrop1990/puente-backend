package pe.gob.senasa.interfaces;

import java.util.ArrayList;

import pe.gob.senasa.bean.Ampliacion;
import pe.gob.senasa.bean.PermisoZoosanitarioImportacion;


public interface PermisoZoosanitarioImportacionInterface {
    
    public PermisoZoosanitarioImportacion obtenerPZIxNoCertificado(String noCertificado);
    
    public ArrayList<PermisoZoosanitarioImportacion> obtenerPZIxSolicitante(String dniRuc);
    
    public Boolean guardarPZI(PermisoZoosanitarioImportacion pfi);
    
    public Ampliacion ampliarCertificadoImpoZoo(String noCertificado,String tipo, int cantidad);
    
    public String generarNroCertificado(String sede);
  
}
