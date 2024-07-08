package pe.gob.senasa.bean;

import java.io.Serializable;

public class LugarUbicacionEnvio implements Serializable {
    
    private String codLugarUbicacionEnvio;
    private String lugarUbicacionEnvio;
    
    public LugarUbicacionEnvio() {
        super();
    }

    public void setCodLugarUbicacionEnvio(String codLugarUbicacionEnvio) {
        this.codLugarUbicacionEnvio = codLugarUbicacionEnvio;
    }

    public String getCodLugarUbicacionEnvio() {
        return codLugarUbicacionEnvio;
    }

    public void setLugarUbicacionEnvio(String lugarUbicacionEnvio) {
        this.lugarUbicacionEnvio = lugarUbicacionEnvio;
    }

    public String getLugarUbicacionEnvio() {
        return lugarUbicacionEnvio;
    }
}
