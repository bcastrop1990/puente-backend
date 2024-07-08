package pe.gob.senasa.bean;

import java.io.Serializable;

public class TipoEnvase implements Serializable {
    
    private String codTipoEnvase;
    private String tipoEnvase;
    
    public TipoEnvase() {
        super();
    }

    public void setCodTipoEnvase(String codTipoEnvase) {
        this.codTipoEnvase = codTipoEnvase;
    }

    public String getCodTipoEnvase() {
        return codTipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }
}
