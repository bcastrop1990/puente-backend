package pe.gob.senasa.bean;

import java.io.Serializable;

public class LugarProduccionAnexoPFI implements Serializable {
    
    private String partidaArancelariaAnexo;
    private String descripcionAnexo;
    private String nombreCientificoAnexo;
    private String tipoEnvaseAnexo;
    private String lugarProduccionAnexo;
    private String codigoAnexo;
    
    public LugarProduccionAnexoPFI() {
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

    public void setLugarProduccionAnexo(String lugarProduccionAnexo) {
        this.lugarProduccionAnexo = lugarProduccionAnexo;
    }

    public String getLugarProduccionAnexo() {
        return lugarProduccionAnexo;
    }

    public void setCodigoAnexo(String codigoAnexo) {
        this.codigoAnexo = codigoAnexo;
    }

    public String getCodigoAnexo() {
        return codigoAnexo;
    }
}
