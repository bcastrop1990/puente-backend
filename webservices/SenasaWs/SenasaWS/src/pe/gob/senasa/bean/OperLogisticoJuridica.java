package pe.gob.senasa.bean;

import java.io.Serializable;

public class OperLogisticoJuridica implements Serializable {
    
    private String ruc;
    private String nombreRazonSocial;
    private String personaTipo;
  
    public OperLogisticoJuridica() {
        super();
    }
    
  public void setRuc(String ruc) {
    this.ruc = ruc;
  }
  
  public String getRuc() {
    return ruc;
  }
  
  public void setNombreRazonSocial(String nombreRazonSocial) {
    this.nombreRazonSocial = nombreRazonSocial;
  }
  
  public String getNombreRazonSocial() {
    return nombreRazonSocial;
  }
  
  public void setPersonaTipo(String personaTipo) {
    this.personaTipo = personaTipo;
  }
  
  public String getPersonaTipo() {
    return personaTipo;
  }
    
}
