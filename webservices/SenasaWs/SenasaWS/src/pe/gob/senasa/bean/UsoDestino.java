package pe.gob.senasa.bean;

import java.io.Serializable;

public class UsoDestino implements Serializable {
    
    private String codUsoDestino;
    private String usoDestino;
    
    public UsoDestino() {
        super();
    }

    public void setCodUsoDestino(String codUsoDestino) {
        this.codUsoDestino = codUsoDestino;
    }

    public String getCodUsoDestino() {
        return codUsoDestino;
    }

    public void setUsoDestino(String usoDestino) {
        this.usoDestino = usoDestino;
    }

    public String getUsoDestino() {
        return usoDestino;
    }
}
