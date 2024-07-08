package pe.gob.senasa.bean;

import java.io.Serializable;

public class ExpPersonaJuridica implements Serializable {
    
  private String codigoExpediente;
  private String ruc;
  private String nombreRazonSocial;
  private String personaTipo;
  
    public ExpPersonaJuridica() {
        super();
    }
    
  public void setCodigoExpediente(String codigoExpediente) {
    this.codigoExpediente = codigoExpediente;
  }

  public String getCodServicioTupa() {
      return codigoExpediente;
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
