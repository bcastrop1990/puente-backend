package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class Concepto implements Serializable {
    
    private String idInspeccion;
    
    private String reglon;
    
    private String idLote;
    
    private String idConcepto;
    
    private String tipoConceptoRetencion;
    
    private String codigoCtaRetencion;
    
    private String cantidadCtaRetencion;
    
    private String numeroSolicitudAnalisis;
    
    private String urlDocumento;
    
    private String respuesta;
    
    private String estado;
    
    private Date fechaRespuesta;
    
    private String idInspeccionProducto;
    
    private String idProducto;
    
    public Concepto() {
        super();
    }

    public Concepto(String idInspeccion, String reglon, String idLote,
                    String idConcepto, String tipoConceptoRetencion,
                    String codigoCtaRetencion, String cantidadCtaRetencion,
                    String numeroSolicitudAnalisis, String urlDocumento,
                    String respuesta, String estado, Date fechaRespuesta,
                    String idInspeccionProducto, String idProducto) {
        super();
        this.idInspeccion = idInspeccion;
        this.reglon = reglon;
        this.idLote = idLote;
        this.idConcepto = idConcepto;
        this.tipoConceptoRetencion = tipoConceptoRetencion;
        this.codigoCtaRetencion = codigoCtaRetencion;
        this.cantidadCtaRetencion = cantidadCtaRetencion;
        this.numeroSolicitudAnalisis = numeroSolicitudAnalisis;
        this.urlDocumento = urlDocumento;
        this.respuesta = respuesta;
        this.estado = estado;
        this.fechaRespuesta = fechaRespuesta;
        this.idInspeccionProducto = idInspeccionProducto;
        this.idProducto = idProducto;
    }

    public void setIdInspeccion(String idInspeccion) {
        this.idInspeccion = idInspeccion;
    }

    public String getIdInspeccion() {
        return idInspeccion;
    }

    public void setReglon(String reglon) {
        this.reglon = reglon;
    }

    public String getReglon() {
        return reglon;
    }

    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }

    public String getIdLote() {
        return idLote;
    }

    public void setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getIdConcepto() {
        return idConcepto;
    }

    public void setTipoConceptoRetencion(String tipoConceptoRetencion) {
        this.tipoConceptoRetencion = tipoConceptoRetencion;
    }

    public String getTipoConceptoRetencion() {
        return tipoConceptoRetencion;
    }

    public void setCodigoCtaRetencion(String codigoCtaRetencion) {
        this.codigoCtaRetencion = codigoCtaRetencion;
    }

    public String getCodigoCtaRetencion() {
        return codigoCtaRetencion;
    }

    public void setCantidadCtaRetencion(String cantidadCtaRetencion) {
        this.cantidadCtaRetencion = cantidadCtaRetencion;
    }

    public String getCantidadCtaRetencion() {
        return cantidadCtaRetencion;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setNumeroSolicitudAnalisis(String numeroSolicitudAnalisis) {
        this.numeroSolicitudAnalisis = numeroSolicitudAnalisis;
    }

    public String getNumeroSolicitudAnalisis() {
        return numeroSolicitudAnalisis;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setIdInspeccionProducto(String idInspeccionProducto) {
        this.idInspeccionProducto = idInspeccionProducto;
    }

    public String getIdInspeccionProducto() {
        return idInspeccionProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }
}
