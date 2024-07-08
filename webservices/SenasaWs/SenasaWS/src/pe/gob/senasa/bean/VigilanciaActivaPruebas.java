package pe.gob.senasa.bean;

import java.io.Serializable;

public class VigilanciaActivaPruebas implements Serializable {
    
    private String codiFichaSit;
    private String nombEnfeTea;
    private String nombPrueTPD;
    private String codiEnfeTea;
    private String codiPrueTPD;
    
    public VigilanciaActivaPruebas() {
        super();
    }

    public VigilanciaActivaPruebas(String nombEnfeTea, String nombPrueTPD,
                                   String codiEnfeTea, String codiPrueTPD) {
        super();
        this.nombEnfeTea = nombEnfeTea;
        this.nombPrueTPD = nombPrueTPD;
        this.codiEnfeTea = codiEnfeTea;
        this.codiPrueTPD = codiPrueTPD;
    }

    public void setCodiFichaSit(String codiFichaSit) {
        this.codiFichaSit = codiFichaSit;
    }

    public String getCodiFichaSit() {
        return codiFichaSit;
    }

    public void setNombEnfeTea(String nombEnfeTea) {
        this.nombEnfeTea = nombEnfeTea;
    }

    public String getNombEnfeTea() {
        return nombEnfeTea;
    }

    public void setNombPrueTPD(String nombPrueTPD) {
        this.nombPrueTPD = nombPrueTPD;
    }

    public String getNombPrueTPD() {
        return nombPrueTPD;
    }

    public void setCodiEnfeTea(String codiEnfeTea) {
        this.codiEnfeTea = codiEnfeTea;
    }

    public String getCodiEnfeTea() {
        return codiEnfeTea;
    }

    public void setCodiPrueTPD(String codiPrueTPD) {
        this.codiPrueTPD = codiPrueTPD;
    }

    public String getCodiPrueTPD() {
        return codiPrueTPD;
    }
}
