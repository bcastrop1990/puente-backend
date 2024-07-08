package pe.gob.senasa.bean;

import java.io.Serializable;

public class Inspector implements Serializable {
    
    private String dniInspector;
    private String nombreInspector;
    private String personaId;
    private String codigoCentroTramite;
    private String especialidad;
    private String usuario;
    
    public Inspector() {
        super();
    }

    public void setDniInspector(String dniInspector) {
        this.dniInspector = dniInspector;
    }

    public String getDniInspector() {
        return dniInspector;
    }

    public void setNombreInspector(String nombreInspector) {
        this.nombreInspector = nombreInspector;
    }

    public String getNombreInspector() {
        return nombreInspector;
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
  
  public void setEspecialidad(String especialidad) {
      this.especialidad = especialidad;
  }

  public String getEspecialidad() {
      return especialidad;
  }
  public void setUsuario(String usuario) {
      this.usuario = usuario;
  }

  public String getUsuario() {
      return usuario;
  }
    
}
