package pe.gob.senasa.interfaces;

import java.util.ArrayList;

import pe.gob.senasa.bean.DirectorioSenasa;


public interface DirectorioSenasaInterface {
  
  
  public ArrayList<DirectorioSenasa> obtenerUsuarios(String GroupName);
  
}
