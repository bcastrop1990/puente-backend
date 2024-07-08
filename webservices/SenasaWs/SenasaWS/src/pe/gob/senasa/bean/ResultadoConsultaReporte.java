package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class ResultadoConsultaReporte implements Serializable {
    private static final long serialVersionUID = -5331138676108753136L;
    
    private String idProceso;
    private String idOriginal;
    private String secuencial;
    private Date   fechaHora;
    private String descripcionAsunto;
    private String remitenteEntidad;
    private String remitentePersona;
    private String destinatarioEntidad;
    private String destinatarioPersona;
    private String accion;
    private String estadoTraza;
    private Date fechCrea;
    
    public ResultadoConsultaReporte() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setIdOriginal(String idOriginal) {
        this.idOriginal = idOriginal;
    }

    public String getIdOriginal() {
        return idOriginal;
    }

    public void setSecuencial(String secuencial) {
        this.secuencial = secuencial;
    }

    public String getSecuencial() {
        return secuencial;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setDescripcionAsunto(String descripcionAsunto) {
        this.descripcionAsunto = descripcionAsunto;
    }

    public String getDescripcionAsunto() {
        return descripcionAsunto;
    }

    public void setRemitenteEntidad(String remitenteEntidad) {
        this.remitenteEntidad = remitenteEntidad;
    }

    public String getRemitenteEntidad() {
        return remitenteEntidad;
    }

    public void setRemitentePersona(String remitentePersona) {
        this.remitentePersona = remitentePersona;
    }

    public String getRemitentePersona() {
        return remitentePersona;
    }

    public void setDestinatarioEntidad(String destinatarioEntidad) {
        this.destinatarioEntidad = destinatarioEntidad;
    }

    public String getDestinatarioEntidad() {
        return destinatarioEntidad;
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

    public void setEstadoTraza(String estadoTraza) {
        this.estadoTraza = estadoTraza;
    }

    public String getEstadoTraza() {
        return estadoTraza;
    }

    public void setFechCrea(Date fechCrea) {
        this.fechCrea = fechCrea;
    }

    public Date getFechCrea() {
        return fechCrea;
    }
}
