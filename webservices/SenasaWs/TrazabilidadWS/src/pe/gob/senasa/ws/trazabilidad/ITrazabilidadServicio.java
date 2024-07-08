package pe.gob.senasa.ws.trazabilidad;

import pe.gob.senasa.ws.trazabilidad.bean.Trazabilidad;
import pe.gob.senasa.helper.bean.Auditoria;

public interface ITrazabilidadServicio {
    
    public Trazabilidad insertarTrazabilidad(String usuario, Trazabilidad trazabilidad);
    
    public Auditoria actualizarTrazabilidad(String usuario, Trazabilidad trazabilidad);
}
