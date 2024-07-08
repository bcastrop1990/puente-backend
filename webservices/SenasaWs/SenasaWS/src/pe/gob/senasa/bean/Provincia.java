package pe.gob.senasa.bean;

import java.io.Serializable;

public class Provincia implements Serializable {
    
    private String codProvincia;
    private String provincia;
    
    public Provincia() {
        super();
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }
}
