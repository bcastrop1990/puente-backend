package pe.gob.senasa.bean;

import java.io.Serializable;

public class Analisis implements Serializable{
    
  private String codigoAnalisis;
  private String descripcionAnalisis;
    
    public Analisis() {
        super();
    }
    
  public void setCodigoAnalisis(String codigoAnalisis) {
      this.codigoAnalisis = codigoAnalisis;
  }
  
  public String getCodigoAnalisis() {
      return codigoAnalisis;
  }
  
  public void setDescripcionAnalisis(String descripcionAnalisis) {
      this.descripcionAnalisis = descripcionAnalisis;
  }
  
  public String getDescripcionAnalisis() {
      return descripcionAnalisis;
  }
  
    
}
