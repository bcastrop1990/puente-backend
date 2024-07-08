package pe.gob.senasa.bean;

import java.io.Serializable;

public class Guardacustodia implements Serializable{
    private String nomEmpresa;
    private String nroDocEmpresa;
    private String dirAlmacen;
    private String nroCertificado;
    private String lugarEmisionCertf;
    private String fecEmisionCertf;
    private String termVigncCertf;
    
    private String nombreDepartamento;
    private String nombreProvincia;
    private String nombreDistrito;
    private String codigoSede;
    private String persona_id;
    private String direccion;
    
    public Guardacustodia() {
        super();
    }


    public void setNroCertificado(String nroCertificado) {
        this.nroCertificado = nroCertificado;
    }

    public String getNroCertificado() {
        return nroCertificado;
    }

    public void setLugarEmisionCertf(String lugarEmisionCertf) {
        this.lugarEmisionCertf = lugarEmisionCertf;
    }

    public String getLugarEmisionCertf() {
        return lugarEmisionCertf;
    }

    public void setFecEmisionCertf(String fecEmisionCertf) {
        this.fecEmisionCertf = fecEmisionCertf;
    }

    public String getFecEmisionCertf() {
        return fecEmisionCertf;
    }

    public void setTermVigncCertf(String termVigncCertf) {
        this.termVigncCertf = termVigncCertf;
    }

    public String getTermVigncCertf() {
        return termVigncCertf;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNroDocEmpresa(String nroDocEmpresa) {
        this.nroDocEmpresa = nroDocEmpresa;
    }

    public String getNroDocEmpresa() {
        return nroDocEmpresa;
    }

    public void setDirAlmacen(String dirAlmacen) {
        this.dirAlmacen = dirAlmacen;
    }

    public String getDirAlmacen() {
        return dirAlmacen;
    }
    
  public void setNombreDepartamento(String nombreDepartamento) {
      this.nombreDepartamento = nombreDepartamento;
  }

  public String getNombreDepartamento() {
      return nombreDepartamento;
  }
  
  public void setNombreProvincia(String nombreProvincia) {
      this.nombreProvincia = nombreProvincia;
  }

  public String getNombreProvincia() {
      return nombreProvincia;
  }

  public void setNombreDistrito(String nombreDistrito) {
      this.nombreDistrito = nombreDistrito;
  }

  public String getNombreDistrito() {
      return nombreDistrito;
  }
  
  public void setCodigoSede(String codigoSede) {
      this.codigoSede = codigoSede;
  }

  public String getCodigoSede() {
      return codigoSede;
  }
  
  public void setPersonaId(String persona_id) {
      this.persona_id = persona_id;
  }

  public String getPersonaId() {
      return persona_id;
  }
  
  public void setDireccion(String direccion) {
      this.direccion = direccion;
  }

  public String getDireccion() {
      return direccion;
  }
  
}
