package pe.gob.senasa.bean;

import java.io.Serializable;

public class Expediente implements Serializable {
    
    private String codigoExpediente;
    private String codigoServicio;
    private String codigoSolicitud;
    private String estado;
    private String personaId;
    private String codigoCentroTramite;
    private String fechaRegistro;
    private String observacion;
    private String clase;
        
    public Expediente() {
        super();
    }
    
    public void setCodigoExpediente(String codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }
    
    public String getCodigoExpediente() {
        return codigoExpediente;
    }
    
    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }
    
    public String getCodigoServicio() {
        return codigoServicio;
    }
    
    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }
    
    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getEstado() {
        return estado;
    }
    
  public void setPersonaId(String personaId) {
      this.personaId = personaId;
  }
  
  public String getPersonaId() {
      return personaId;
  }
  
  public void setCodigoCentroTramite(String codigoCentroTramite) {
      this.codigoCentroTramite = codigoCentroTramite;
  }
  
  public String getCodigoCentroTramite() {
      return codigoCentroTramite;
  }
  
  public void setFechaRegistro(String fechaRegistro) {
      this.fechaRegistro = fechaRegistro;
  }
  
  public String getFechaRegistro() {
      return fechaRegistro;
  }
  
  public void setObservacion(String observacion) {
      this.observacion = observacion;
  }
  
  public String getObservacion() {
      return observacion;
  }
  
  public void setClase(String clase) {
      this.clase = clase;
  }
  
  public String getClase() {
      return clase;
  }
  
  
  
}
