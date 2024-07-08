package pe.gob.senasa.bean;

import java.io.Serializable;

public class Raza implements Serializable {
    
    private String razaAnimRaz;
    
    private String nombRazaRaz;
    
    private String espeAnimAni;
    
    public Raza() {
        super();
    }

    public Raza(String razaAnimRaz, String nombRazaRaz, String espeAnimAni) {
        super();
        this.razaAnimRaz = razaAnimRaz;
        this.nombRazaRaz = nombRazaRaz;
        this.espeAnimAni = espeAnimAni;
    }

    public void setRazaAnimRaz(String razaAnimRaz) {
        this.razaAnimRaz = razaAnimRaz;
    }

    public String getRazaAnimRaz() {
        return razaAnimRaz;
    }

    public void setNombRazaRaz(String nombRazaRaz) {
        this.nombRazaRaz = nombRazaRaz;
    }

    public String getNombRazaRaz() {
        return nombRazaRaz;
    }

    public void setEspeAnimAni(String espeAnimAni) {
        this.espeAnimAni = espeAnimAni;
    }

    public String getEspeAnimAni() {
        return espeAnimAni;
    }
}
