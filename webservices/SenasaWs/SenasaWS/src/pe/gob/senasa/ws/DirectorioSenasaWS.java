package pe.gob.senasa.ws;


import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.DirectorioSenasa;
import pe.gob.senasa.dao.DirectorioSenasaDAO;
import pe.gob.senasa.interfaces.DirectorioSenasaInterface;


@XmlSeeAlso({DirectorioSenasa.class})
@WebService(name = "DirectorioSenasa", serviceName = "DirectorioSenasa", portName = "DirectorioSenasaPort", targetNamespace = "http://DirectorioSenasa.ws.senasa.gob.pe")

 public class DirectorioSenasaWS implements DirectorioSenasaInterface {
    
  DirectorioSenasaDAO sDAO = null;
  
  public DirectorioSenasaWS() {
      sDAO = new DirectorioSenasaDAO();
  }
  
 @WebMethod
    public ArrayList<DirectorioSenasa> obtenerUsuarios(String GroupName) {
    return sDAO.obtenerUsuarios(GroupName);
  }
  
  
}
