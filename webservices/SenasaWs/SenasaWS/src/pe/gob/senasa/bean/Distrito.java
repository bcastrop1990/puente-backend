package pe.gob.senasa.bean;

import java.io.Serializable;

public class Distrito implements Serializable {
    public Distrito() {
        super();
    }
    
    private String codDistrito;
    private String distrito;

    public void setCodDistrito(String codDistrito) {
        this.codDistrito = codDistrito;
    }

    public String getCodDistrito() {
        return codDistrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return distrito;
    }
}
