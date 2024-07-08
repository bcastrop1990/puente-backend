package pe.gob.senasa.bean;

import java.io.Serializable;

public class EspeciesAnimales implements Serializable {
    
    private String espeAnimAni;
    private String nombEspeAni;
    private String nomnbCortAni;
    private String flagTransito;
    
    public EspeciesAnimales() {
        super();
    }

    public EspeciesAnimales(String espeAnimAni, String nombEspeAni,
                            String nomnbCortAni, String flagTransito) {
        super();
        this.espeAnimAni = espeAnimAni;
        this.nombEspeAni = nombEspeAni;
        this.nomnbCortAni = nomnbCortAni;
        this.flagTransito = flagTransito;
    }

    public void setEspeAnimAni(String espeAnimAni) {
        this.espeAnimAni = espeAnimAni;
    }

    public String getEspeAnimAni() {
        return espeAnimAni;
    }

    public void setNombEspeAni(String nombEspeAni) {
        this.nombEspeAni = nombEspeAni;
    }

    public String getNombEspeAni() {
        return nombEspeAni;
    }

    public void setNomnbCortAni(String nomnbCortAni) {
        this.nomnbCortAni = nomnbCortAni;
    }

    public String getNomnbCortAni() {
        return nomnbCortAni;
    }

    public void setFlagTransito(String flagTransito) {
        this.flagTransito = flagTransito;
    }

    public String getFlagTransito() {
        return flagTransito;
    }
}
