package pe.gob.senasa.bean;

import java.io.Serializable;

public class AgenteAduanas implements Serializable {
    
    private String dniRuc;
    private String nombreRazonSocial;
    private String domicilioLegal;
    private String urbanizacion;
    private String distrito;
    private String provincia;
    private String departamento;
    private String telefono;
    private String fax;
    private String email;
    private String dniRepresentanteLegal;
    private String nombreRepresentanteLegal;
    
    private String telefonoMovil;
    private String idPersona;
  
    
    public AgenteAduanas() {
        super();
    }

    public void setDniRuc(String dniRuc) {
        this.dniRuc = dniRuc;
    }

    public String getDniRuc() {
        return dniRuc;
    }

    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }

    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    public void setDomicilioLegal(String domicilioLegal) {
        this.domicilioLegal = domicilioLegal;
    }

    public String getDomicilioLegal() {
        return domicilioLegal;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setDniRepresentanteLegal(String dniRepresentanteLegal) {
        this.dniRepresentanteLegal = dniRepresentanteLegal;
    }

    public String getDniRepresentanteLegal() {
        return dniRepresentanteLegal;
    }

    public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
    }

    public String getNombreRepresentanteLegal() {
        return nombreRepresentanteLegal;
    }


  public void setTelefonoMovil(String telefonoMovil) {
      this.telefonoMovil = telefonoMovil;
  }

  public String getTelefonoMovil() {
      return telefonoMovil;
  }
  
  public void setIdPersona(String idPersona) {
      this.idPersona = idPersona;
  }

  public String getIdPersona() {
      return idPersona;
  }
  
  
}
