package pe.gob.senasa.bean;

import java.io.Serializable;

public class TipoRechazo implements Serializable {
    
    private String codigoTipoRechazo;
    
    private String tipoRechazo;
    
    public TipoRechazo() {
        super();
    }

    public TipoRechazo(String codigoTipoRechazo, String tipoRechazo) {
        super();
        this.codigoTipoRechazo = codigoTipoRechazo;
        this.tipoRechazo = tipoRechazo;
    }

    public void setCodigoTipoRechazo(String codigoTipoRechazo) {
        this.codigoTipoRechazo = codigoTipoRechazo;
    }

    public String getCodigoTipoRechazo() {
        return codigoTipoRechazo;
    }

    public void setTipoRechazo(String tipoRechazo) {
        this.tipoRechazo = tipoRechazo;
    }

    public String getTipoRechazo() {
        return tipoRechazo;
    }
}
