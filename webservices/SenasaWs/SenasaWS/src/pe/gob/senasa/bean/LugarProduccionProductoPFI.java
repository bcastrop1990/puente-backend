package pe.gob.senasa.bean;

import java.io.Serializable;

public class LugarProduccionProductoPFI implements Serializable {
    
    private String partidaArancelariaProducto;
    private String descripcionProducto;
    private String nombreCientificoProducto;
    private String tipoEnvaseProducto;
    private String lugarProduccionProducto;
    private String codigoProducto;
    private String descLugarProduccion;
    
    public LugarProduccionProductoPFI() {
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

    public void setLugarProduccionProducto(String lugarProduccionProducto) {
        this.lugarProduccionProducto = lugarProduccionProducto;
    }

    public String getLugarProduccionProducto() {
        return lugarProduccionProducto;
    }
    
    


    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setDescLugarProduccion(String descLugarProduccion) {
        this.descLugarProduccion = descLugarProduccion;
    }

    public String getDescLugarProduccion() {
        return descLugarProduccion;
    }
}
