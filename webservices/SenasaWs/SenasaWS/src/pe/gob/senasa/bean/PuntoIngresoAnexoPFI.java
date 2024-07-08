package pe.gob.senasa.bean;

import java.io.Serializable;

public class PuntoIngresoAnexoPFI implements Serializable {
    
    private String partidaArancelariaAnexo;
    private String descripcionAnexo;
    private String nombreCientificoAnexo;
    private String tipoEnvaseAnexo;
    private String puntoIngresoAnexo;
    private Double cantidad;
    private Double pesoNeto;
    private String codigoAnexo;
    
    public PuntoIngresoAnexoPFI() {
        super();
    }

    public void setPartidaArancelariaAnexo(String partidaArancelariaAnexo) {
        this.partidaArancelariaAnexo = partidaArancelariaAnexo;
    }

    public String getPartidaArancelariaAnexo() {
        return partidaArancelariaAnexo;
    }

    public void setDescripcionAnexo(String descripcionAnexo) {
        this.descripcionAnexo = descripcionAnexo;
    }

    public String getDescripcionAnexo() {
        return descripcionAnexo;
    }

    public void setNombreCientificoAnexo(String nombreCientificoAnexo) {
        this.nombreCientificoAnexo = nombreCientificoAnexo;
    }

    public String getNombreCientificoAnexo() {
        return nombreCientificoAnexo;
    }

    public void setTipoEnvaseAnexo(String tipoEnvaseAnexo) {
        this.tipoEnvaseAnexo = tipoEnvaseAnexo;
    }

    public String getTipoEnvaseAnexo() {
        return tipoEnvaseAnexo;
    }

    public void setPuntoIngresoAnexo(String puntoIngresoAnexo) {
        this.puntoIngresoAnexo = puntoIngresoAnexo;
    }

    public String getPuntoIngresoAnexo() {
        return puntoIngresoAnexo;
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

    public void setCodigoAnexo(String codigoAnexo) {
        this.codigoAnexo = codigoAnexo;
    }

    public String getCodigoAnexo() {
        return codigoAnexo;
    }
}
