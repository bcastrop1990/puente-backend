package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class Trazabilidad implements Serializable {
    
    private String proceso;
    private String expedienteTemp;
    private String expedienteDefinitivo;
    private Date   fechaHora;
    private String descripcionAsunto;
    private String remitenteAreaEntidad;
    private String remitenteSubAreaEntidad;
    private String remitentePersona;
    private String destinatarioAreaEntidad;
    private String destinatarioSubAreaEntidad;
    private String destinatarioPersona;
    private String accion;
    private String estado;
    private String notas;
  private String proveido;
  private String urgencia;
    private String codigoElemento;
    private String codigoElementoRespuesta;
    private String canal="BPM";
    
    public Trazabilidad() {
        super();
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getProceso() {
        return proceso;
    }

    public void setExpedienteTemp(String expedienteTemp) {
        this.expedienteTemp = expedienteTemp;
    }

    public String getExpedienteTemp() {
        return expedienteTemp;
    }

    public void setExpedienteDefinitivo(String expedienteDefinitivo) {
        this.expedienteDefinitivo = expedienteDefinitivo;
    }

    public String getExpedienteDefinitivo() {
        return expedienteDefinitivo;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setRemitenteAreaEntidad(String remitenteAreaEntidad) {
        this.remitenteAreaEntidad = remitenteAreaEntidad;
    }

    public String getRemitenteAreaEntidad() {
        return remitenteAreaEntidad;
    }

    public void setRemitentePersona(String remitentePersona) {
        this.remitentePersona = remitentePersona;
    }

    public String getRemitentePersona() {
        return remitentePersona;
    }

    public void setDestinatarioAreaEntidad(String destinatarioAreaEntidad) {
        this.destinatarioAreaEntidad = destinatarioAreaEntidad;
    }

    public String getDestinatarioAreaEntidad() {
        return destinatarioAreaEntidad;
    }

    public void setDestinatarioPersona(String destinatarioPersona) {
        this.destinatarioPersona = destinatarioPersona;
    }

    public String getDestinatarioPersona() {
        return destinatarioPersona;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAccion() {
        return accion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getNotas() {
        return notas;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getCanal() {
        return canal;
    }

    public void setDescripcionAsunto(String descripcionAsunto) {
        this.descripcionAsunto = descripcionAsunto;
    }

    public String getDescripcionAsunto() {
        return descripcionAsunto;
    }

	public void setRemitenteSubAreaEntidad(String remitenteSubAreaEntidad) {
		this.remitenteSubAreaEntidad = remitenteSubAreaEntidad;
	}

	public String getRemitenteSubAreaEntidad() {
		return remitenteSubAreaEntidad;
	}

	public void setDestinatarioSubAreaEntidad(String destinatarioSubAreaEntidad) {
		this.destinatarioSubAreaEntidad = destinatarioSubAreaEntidad;
	}

	public String getDestinatarioSubAreaEntidad() {
		return destinatarioSubAreaEntidad;
	}

	public void setCodigoElemento(String codigoElemento) {
		this.codigoElemento = codigoElemento;
	}

	public String getCodigoElemento() {
		return codigoElemento;
	}

	public void setCodigoElementoRespuesta(String codigoElementoRespuesta) {
		this.codigoElementoRespuesta = codigoElementoRespuesta;
	}

	public String getCodigoElementoRespuesta() {
		return codigoElementoRespuesta;
	}

	public void setProveido(String proveido) {
		this.proveido = proveido;
	}

	public String getProveido() {
		return proveido;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

	public String getUrgencia() {
		return urgencia;
	}
}
