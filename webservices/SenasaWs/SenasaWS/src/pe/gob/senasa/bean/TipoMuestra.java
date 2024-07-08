package pe.gob.senasa.bean;

import java.io.Serializable;

public class TipoMuestra implements Serializable {

    private String codiTipoMue;
    private String nomTipoMue;
    private String flagSarvf;

    public TipoMuestra() {
        super();
    }

    public TipoMuestra(String codiTipoMue, String nomTipoMue,
                       String flagSarvf) {
        super();
        this.codiTipoMue = codiTipoMue;
        this.nomTipoMue = nomTipoMue;
        this.flagSarvf = flagSarvf;
    }

    public void setCodiTipoMue(String codiTipoMue) {
        this.codiTipoMue = codiTipoMue;
    }

    public String getCodiTipoMue() {
        return codiTipoMue;
    }

    public void setNomTipoMue(String nomTipoMue) {
        this.nomTipoMue = nomTipoMue;
    }

    public String getNomTipoMue() {
        return nomTipoMue;
    }

    public void setFlagSarvf(String flagSarvf) {
        this.flagSarvf = flagSarvf;
    }

    public String getFlagSarvf() {
        return flagSarvf;
    }
}
