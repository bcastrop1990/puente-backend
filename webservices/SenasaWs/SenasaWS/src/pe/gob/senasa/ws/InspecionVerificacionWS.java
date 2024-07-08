package pe.gob.senasa.ws;

import javax.jws.WebService;

import pe.gob.senasa.bean.InpeccionVerificacion;
import pe.gob.senasa.dao.InspecionVerifDao;
import pe.gob.senasa.interfaces.InspecionVerifInterface;


@WebService(serviceName = "InspecionVerificacion")
public class InspecionVerificacionWS  implements InspecionVerifInterface{
  InspecionVerifDao inspecionVerifDao=null;
    public InspecionVerificacionWS() {
        super();
      inspecionVerifDao= new InspecionVerifDao();
    }
  public String insertarIVV(InpeccionVerificacion inpeccionVerificacion){
    return inspecionVerifDao.insertarIVV(inpeccionVerificacion);      
  }    
}
