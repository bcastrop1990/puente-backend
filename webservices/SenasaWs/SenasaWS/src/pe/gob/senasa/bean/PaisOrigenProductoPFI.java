package pe.gob.senasa.bean;

import java.io.Serializable;

public class PaisOrigenProductoPFI implements Serializable {
    
    private String partidaArancelariaProducto;
    private String descripcionProducto;
    private String nombreCientificoProducto;
    private String tipoEnvaseProducto;
    private String paisOrigenProducto;
    private String descPaisOrigenProducto;
    private String codigoProducto;
    private String lugarProduccion;
    private String codigoLugarProduccion;
    private String descLugarProduccion;
    
    
    public PaisOrigenProductoPFI() {
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

    public void setPaisOrigenProducto(String paisOrigenProducto) {
        this.paisOrigenProducto = paisOrigenProducto;
    }

    public String getPaisOrigenProducto() {
        return paisOrigenProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setLugarProduccion(String lugarProduccion) {
        this.lugarProduccion = lugarProduccion;
    }

    public String getLugarProduccion() {
        return lugarProduccion;
    }

    public void setCodigoLugarProduccion(String codigoLugarProduccion) {
        this.codigoLugarProduccion = codigoLugarProduccion;
    }

    public String getCodigoLugarProduccion() {
        return codigoLugarProduccion;
    }

    public void setDescLugarProduccion(String descLugarProduccion) {
        this.descLugarProduccion = descLugarProduccion;
    }

    public String getDescLugarProduccion() {
        return descLugarProduccion;
    }

    public void setDescPaisOrigenProducto(String descPaisOrigenProducto) {
        this.descPaisOrigenProducto = descPaisOrigenProducto;
    }

    public String getDescPaisOrigenProducto() {
        return descPaisOrigenProducto;
    }
}
