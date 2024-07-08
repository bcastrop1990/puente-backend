package pe.gob.senasa.bean;

import java.io.Serializable;

public class PredioCPE implements Serializable {
    
    private String codPredioCPE;
    private String predioCPE;
    
    public PredioCPE() {
        super();
    }

    public void setCodPredioCPE(String codPredioCPE) {
        this.codPredioCPE = codPredioCPE;
    }

    public String getCodPredioCPE() {
        return codPredioCPE;
    }

    public void setPredioCPE(String predioCPE) {
        this.predioCPE = predioCPE;
    }

    public String getPredioCPE() {
        return predioCPE;
    }
}
