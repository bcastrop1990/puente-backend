package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class TratamientoInspeccion implements Serializable {


    private static final long serialVersionUID = 91313323591446073L;
    
    private String codExpediente = null;
    private String codServicio   = null;
    private String codProducto   = null;
    private String codTratamiento     = null;
    private String codTipoTratamiento = null; 
    private Date   fechaTratamiento    = null;
    private String empresaIdAplica   = null;
    private String dosis   = null;
    private String tiempo    = null;
    private String duracion  = null;
    private String codProductoQuimico = null;
    private String codMotivo  = null;
    private String codEnfermedadPlaga = null;
    private String usuarioInspector = null;
    
    private String descripcionTratamiento = null;
    private String descripcionTipoTratamiento = null;
    private String razonSocialEmpresa = null;
    private String descripcionMotivo = null;
    private String descripcionEnfermedadPlaga = null;
  

    public TratamientoInspeccion() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setCodExpediente(String codExpediente) {
        this.codExpediente = codExpediente;
    }

    public String getCodExpediente() {
        return codExpediente;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodTratamiento(String codTratamiento) {
        this.codTratamiento = codTratamiento;
    }

    public String getCodTratamiento() {
        return codTratamiento;
    }

    public void setCodTipoTratamiento(String codTipoTratamiento) {
        this.codTipoTratamiento = codTipoTratamiento;
    }

    public String getCodTipoTratamiento() {
        return codTipoTratamiento;
    }

    public void setFechaTratamiento(Date fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public Date getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setEmpresaIdAplica(String empresaIdAplica) {
        this.empresaIdAplica = empresaIdAplica;
    }

    public String getEmpresaIdAplica() {
        return empresaIdAplica;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getDosis() {
        return dosis;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setCodProductoQuimico(String codProductoQuimico) {
        this.codProductoQuimico = codProductoQuimico;
    }

    public String getCodProductoQuimico() {
        return codProductoQuimico;
    }

    public void setCodMotivo(String codMotivo) {
        this.codMotivo = codMotivo;
    }

    public String getCodMotivo() {
        return codMotivo;
    }

    public void setCodEnfermedadPlaga(String codEnfermedadPlaga) {
        this.codEnfermedadPlaga = codEnfermedadPlaga;
    }

    public String getCodEnfermedadPlaga() {
        return codEnfermedadPlaga;
    }

    public void setUsuarioInspector(String usuarioInspector) {
        this.usuarioInspector = usuarioInspector;
    }

    public String getUsuarioInspector() {
        return usuarioInspector;
    }
    
  public void setDescripcionTratamiento(String descripcionTratamiento) {
      this.descripcionTratamiento = descripcionTratamiento;
  }

  public String getDescripcionTratamiento() {
      return descripcionTratamiento;
  }
  
  public void setDescripcionTipoTratamiento(String descripcionTipoTratamiento) {
      this.descripcionTipoTratamiento = descripcionTipoTratamiento;
  }

  public String getDescripcionTipoTratamiento() {
      return descripcionTipoTratamiento;
  }
  
  public void setRazonSocialEmpresa(String razonSocialEmpresa) {
      this.razonSocialEmpresa = razonSocialEmpresa;
  }

  public String getRazonSocialEmpresa() {
      return razonSocialEmpresa;
  }
  
  public void setDescripcionMotivo(String descripcionMotivo) {
      this.descripcionMotivo = descripcionMotivo;
  }

  public String getDescripcionMotivo() {
      return descripcionMotivo;
  }
  
  public void setDescripcionEnfermedadPlaga(String descripcionEnfermedadPlaga) {
      this.descripcionEnfermedadPlaga = descripcionEnfermedadPlaga;
  }

  public String getDescripcionEnfermedadPlaga() {
      return descripcionEnfermedadPlaga;
  }
    
    
}
