package pe.gob.senasa.interfaces;

import pe.gob.senasa.bean.ResultadoAnalisisUCDSV;
import pe.gob.senasa.bean.SolicitudAnalisisUCDSV;

public interface AnalisisInterface {
    
    public Boolean CrearAnalisis(SolicitudAnalisisUCDSV solicitud);
    
    public ResultadoAnalisisUCDSV obtenerAnalisis(String orden);
}
