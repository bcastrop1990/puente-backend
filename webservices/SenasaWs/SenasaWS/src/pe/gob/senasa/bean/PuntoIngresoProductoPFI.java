package pe.gob.senasa.bean;

import java.io.Serializable;

public class PuntoIngresoProductoPFI implements Serializable {
    
    private String partidaArancelariaProducto;
    private String descripcionProducto;
    private String nombreCientificoProducto;
    private String tipoEnvaseProducto;
    private String puntoIngresoProducto;
    private String puntoSalidaProducto;
    private Double cantidad;
    private Double pesoNeto;
    private String codigoProducto;
    private String descPuntoIngresoProducto;
    private String descPuntoSalidaProducto;
    
    public PuntoIngresoProductoPFI() {
        super();
    }

    public void setPartidaArancelariaProducto(String partidaArancelariaProducto) {
        this.partidaArancelariaProducto = partidaArancelariaProducto;
    }

    public String getPartidaArancelariaProducto() {
        return partidaArancelariaProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setNombreCientificoProducto(String nombreCientificoProducto) {
        this.nombreCientificoProducto = nombreCientificoProducto;
    }

    public String getNombreCientificoProducto() {
        return nombreCientificoProducto;
    }

    public void setTipoEnvaseProducto(String tipoEnvaseProducto) {
        this.tipoEnvaseProducto = tipoEnvaseProducto;
    }

    public String getTipoEnvaseProducto() {
        return tipoEnvaseProducto;
    }

    public void setPuntoIngresoProducto(String puntoIngresoProducto) {
        this.puntoIngresoProducto = puntoIngresoProducto;
    }

    public String getPuntoIngresoProducto() {
        return puntoIngresoProducto;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setPesoNeto(Double pesoNeto) {
        this.pesoNeto = pesoNeto;
    }

    public Double getPesoNeto() {
        return pesoNeto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setPuntoSalidaProducto(String puntoSalidaProducto) {
        this.puntoSalidaProducto = puntoSalidaProducto;
    }

    public String getPuntoSalidaProducto() {
        return puntoSalidaProducto;
    }

    public void setDescPuntoIngresoProducto(String descPuntoIngresoProducto) {
        this.descPuntoIngresoProducto = descPuntoIngresoProducto;
    }

    public String getDescPuntoIngresoProducto() {
        return descPuntoIngresoProducto;
    }

    public void setDescPuntoSalidaProducto(String descPuntoSalidaProducto) {
        this.descPuntoSalidaProducto = descPuntoSalidaProducto;
    }

    public String getDescPuntoSalidaProducto() {
        return descPuntoSalidaProducto;
    }
}
