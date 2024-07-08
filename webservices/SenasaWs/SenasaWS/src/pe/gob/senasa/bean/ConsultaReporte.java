package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class ConsultaReporte implements Serializable {
    
    private static final long serialVersionUID = -7619750372037261207L;
    private String codigoDocumento;
    private String numeroDocumento;
    private Date fechaDesde;
    private Date fechaHasta;
    private String areaEntidadRemitente;
    private String nombrePersonaRemitente;
    private String areaEntidadDestino;
    private String nombrePersonaDirigido;
    private String tipoDocumental;
    private String subTipoDocumental;
    private Date fecha;
    private String estado;
    private String asunto;
    private String infAdjunto;

    public ConsultaReporte() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setAreaEntidadRemitente(String areaEntidadRemitente) {
        this.areaEntidadRemitente = areaEntidadRemitente;
    }

    public String getAreaEntidadRemitente() {
        return areaEntidadRemitente;
    }

    public void setNombrePersonaRemitente(String nombrePersonaRemitente) {
        this.nombrePersonaRemitente = nombrePersonaRemitente;
    }

    public String getNombrePersonaRemitente() {
        return nombrePersonaRemitente;
    }

    public void setAreaEntidadDestino(String areaEntidadDestino) {
        this.areaEntidadDestino = areaEntidadDestino;
    }

    public String getAreaEntidadDestino() {
        return areaEntidadDestino;
    }

    public void setNombrePersonaDirigido(String nombrePersonaDirigido) {
        this.nombrePersonaDirigido = nombrePersonaDirigido;
    }

    public String getNombrePersonaDirigido() {
        return nombrePersonaDirigido;
    }

    public void setTipoDocumental(String tipoDocumental) {
        this.tipoDocumental = tipoDocumental;
    }

    public String getTipoDocumental() {
        return tipoDocumental;
    }

    public void setSubTipoDocumental(String subTipoDocumental) {
        this.subTipoDocumental = subTipoDocumental;
    }

    public String getSubTipoDocumental() {
        return subTipoDocumental;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setInfAdjunto(String infAdjunto) {
        this.infAdjunto = infAdjunto;
    }

    public String getInfAdjunto() {
        return infAdjunto;
    }
}
