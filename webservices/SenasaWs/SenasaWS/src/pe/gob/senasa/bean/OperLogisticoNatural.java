package pe.gob.senasa.bean;

import java.io.Serializable;

public class OperLogisticoNatural implements Serializable {
    
  private String documentoNumero;
  private String nombreRazonSocial;
  private String personaTipo;
  
    public OperLogisticoNatural() {
        super();
    }
  public void setDocumentoNumero(String documentoNumero) {
    this.documentoNumero = documentoNumero;
  }
  
  public String getDocumentoNumero() {
    return documentoNumero;
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
