package pe.gob.senasa.bean;

import java.io.Serializable;

public class Pais implements Serializable {
    
    private String codPais;
    private String pais;
    
    public Pais() {
        super();
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }
}
