package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class ConceptoInspeccion implements Serializable {
    public ConceptoInspeccion() {
        super();
    }
    
  private String codigoConcepto;
  private String codigoLote;
  private String codigoInspeccionProducto;
  private String codigoInspeccion;
  private String codigoProducto;
  private Double secuencialProducto;
  private String tipoConceptoRetencion;
  private String codigoCtaRetencion;
  private Double cantidadCtaRetencion;
  private Double pesoCtaRetencion;
  private String respuesta;
  private String estado;
  private Date fechaRespuesta;
  private String urlDocumento;
  private String numeroSolicitudAnalisis;


    public void setCodigoConcepto(String codigoConcepto) {
        this.codigoConcepto = codigoConcepto;
    }

    public String getCodigoConcepto() {
        return codigoConcepto;
    }

    public void setCodigoLote(String codigoLote) {
        this.codigoLote = codigoLote;
    }

    public String getCodigoLote() {
        return codigoLote;
    }

  
    public void setCodigoInspeccion(String codigoInspeccion) {
        this.codigoInspeccion = codigoInspeccion;
    }

    public String getCodigoInspeccion() {
        return codigoInspeccion;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setSecuencialProducto(Double secuencialProducto) {
        this.secuencialProducto = secuencialProducto;
    }

    public Double getSecuencialProducto() {
        return secuencialProducto;
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

    public void setCantidadCtaRetencion(Double cantidadCtaRetencion) {
        this.cantidadCtaRetencion = cantidadCtaRetencion;
    }

    public Double getCantidadCtaRetencion() {
        return cantidadCtaRetencion;
    }

    public void setPesoCtaRetencion(Double pesoCtaRetencion) {
        this.pesoCtaRetencion = pesoCtaRetencion;
    }

    public Double getPesoCtaRetencion() {
        return pesoCtaRetencion;
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

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setNumeroSolicitudAnalisis(String numeroSolicitudAnalisis) {
        this.numeroSolicitudAnalisis = numeroSolicitudAnalisis;
    }

    public String getNumeroSolicitudAnalisis() {
        return numeroSolicitudAnalisis;
    }

    public void setCodigoInspeccionProducto(String codigoInspeccionProducto) {
        this.codigoInspeccionProducto = codigoInspeccionProducto;
    }

    public String getCodigoInspeccionProducto() {
        return codigoInspeccionProducto;
    }
}
