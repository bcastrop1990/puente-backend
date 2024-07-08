package pe.gob.senasa.bean;

import java.io.Serializable;

public class LoteInspeccion implements Serializable {
    public LoteInspeccion() {
        super();
    }
    
  private String codigoLote;
  private String codigoInspeccionProducto;
  private String codigoInspeccion;
  private String codigoProducto;
  private Double secuencialProducto;
  private Double cantidadLote;
  private Double pesoLote;
  private String estado;
  private String observacion;


    public void setCodigoLote(String codigoLote) {
        this.codigoLote = codigoLote;
    }

    public String getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoInspeccionProducto(String codigoInspeccionProducto) {
        this.codigoInspeccionProducto = codigoInspeccionProducto;
    }

    public String getCodigoInspeccionProducto() {
        return codigoInspeccionProducto;
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

    public void setCantidadLote(Double cantidadLote) {
        this.cantidadLote = cantidadLote;
    }

    public Double getCantidadLote() {
        return cantidadLote;
    }

    public void setPesoLote(Double pesoLote) {
        this.pesoLote = pesoLote;
    }

    public Double getPesoLote() {
        return pesoLote;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }
}
