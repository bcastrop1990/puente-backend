package pe.gob.senasa.bean;

import java.io.Serializable;

public class AreaGestion implements Serializable {
    public AreaGestion() {
        super();
    }
    
  String nombreAreaGestion="";
  String codigoAreaGestion="";
  String codigoClase= "";
  
  public void setNombreAreaGestion(String nombreAreaGestion) {
      this.nombreAreaGestion = nombreAreaGestion;
  }

  public String getNombreAreaGestion() {
      return nombreAreaGestion;
  }

  public void setCodigoAreaGestion(String codigoAreaGestion) {
      this.codigoAreaGestion = codigoAreaGestion;
  }

  public String getCodigoAreaGestion() {
      return codigoAreaGestion;
  }

  public void setCodigoClase(String codigoClase) {
      this.codigoClase = codigoClase;
  }

  public String getCodigoClase() {
      return codigoClase;
  }

}
