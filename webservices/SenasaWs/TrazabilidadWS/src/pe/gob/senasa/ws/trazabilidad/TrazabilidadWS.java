package pe.gob.senasa.ws.trazabilidad;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import pe.gob.senasa.ws.trazabilidad.bean.Trazabilidad;
import pe.gob.senasa.ws.trazabilidad.dao.TrazabilidadDAO;
import pe.gob.senasa.helper.bean.Auditoria;

@XmlSeeAlso({Auditoria.class, Trazabilidad.class})
@WebService(name = "Trazabilidad",serviceName = "Trazabilidad", 
            targetNamespace = "http://trazabilidad.ws.senasa.gob.pe", portName = "TrazabilidadPort")
public class TrazabilidadWS implements ITrazabilidadServicio {
    private TrazabilidadDAO dao = null;
    public TrazabilidadWS() {
        super();
        dao = new TrazabilidadDAO();
    }
    
    @WebMethod
      public Trazabilidad insertarTrazabilidad(@WebParam(name = "usuario")String usuario, @WebParam(name = "trazabilidad")Trazabilidad trazabilidad){
          return dao.insertarTrazabilidad(usuario, trazabilidad);
    }
    
    @WebMethod
      public Auditoria actualizarTrazabilidad(@WebParam(name = "usuario")String usuario, @WebParam(name = "trazabilidad")Trazabilidad trazabilidad){
          return dao.actualizarTrazabilidad(usuario, trazabilidad);
    }
    
}
