package pe.gob.senasa.bean;

import java.io.Serializable;

public class CpeGermpGC implements Serializable {
    public CpeGermpGC() {
        super();
    }
    
    private String tipo;
    private String numero;


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    
}
