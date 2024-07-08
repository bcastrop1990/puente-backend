package pe.gob.senasa.bean;

import java.io.Serializable;

public class ExpPersonaNatural implements Serializable {
    
    private String codigoExpediente;
    private String documentoNumero;
    private String nombreRazonSocial;
    private String personaTipo;
    
    
    public ExpPersonaNatural() {
        super();
    }
    
    public void setCodigoExpediente(String codigoExpediente) {
      this.codigoExpediente = codigoExpediente;
    }

    public String getCodServicioTupa() {
        return codigoExpediente;
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
