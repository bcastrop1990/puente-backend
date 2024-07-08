package pe.gob.senasa.bean;

import java.io.Serializable;

public class PruebaDiagnostica implements Serializable {
    
    private String codiPrueTPD;
    
    private String nomPrueTPD;
    
    private String codiAreaLab;    
    
    public PruebaDiagnostica() {
        super();
    }

    public PruebaDiagnostica(String codiPrueTPD, String nomPrueTPD) {
        super();
        this.codiPrueTPD = codiPrueTPD;
        this.nomPrueTPD = nomPrueTPD;
    }

    public void setCodiPrueTPD(String codiPrueTPD) {
        this.codiPrueTPD = codiPrueTPD;
    }

    public String getCodiPrueTPD() {
        return codiPrueTPD;
    }

    public void setNomPrueTPD(String nomPrueTPD) {
        this.nomPrueTPD = nomPrueTPD;
    }

    public String getNomPrueTPD() {
        return nomPrueTPD;
    }

    public void setCodiAreaLab(String codiAreaLab) {
        this.codiAreaLab = codiAreaLab;
    }

    public String getCodiAreaLab() {
        return codiAreaLab;
    }
}
