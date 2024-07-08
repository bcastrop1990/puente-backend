package pe.gob.senasa.ws;

import javax.jws.WebService;

import pe.gob.senasa.bean.ResultadoAnalisisUCDSV;
import pe.gob.senasa.bean.SolicitudAnalisisUCDSV;
import pe.gob.senasa.dao.SolicitudUCDSVDao;
import pe.gob.senasa.interfaces.AnalisisInterface;


/**
 * Manejo de información y operaciones de Analisis.
 */
@WebService
public class AnalisisUCDSV implements AnalisisInterface{
    
    SolicitudUCDSVDao solDao = new SolicitudUCDSVDao();

    /**
     */
    public AnalisisUCDSV() {
        solDao = new SolicitudUCDSVDao();
    }

    /**
     * 
     * status: En pruebas
     * @param solicitud
     * @return
     */
    public Boolean CrearAnalisis(SolicitudAnalisisUCDSV solicitud) {
        return solDao.CrearAnalisis(solicitud);
    }

    /**
     * 
     * status: En pruebas
     * @param orden
     * @return
     */
    public ResultadoAnalisisUCDSV obtenerAnalisis(String orden) {
        return solDao.obtenerAnalisis(orden);
    }
}
