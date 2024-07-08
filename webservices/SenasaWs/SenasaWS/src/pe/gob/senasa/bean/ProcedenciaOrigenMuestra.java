package pe.gob.senasa.bean;

import java.io.Serializable;

public class ProcedenciaOrigenMuestra implements Serializable {
    
    private String codiProMue;
    private String descProcMue;
    private String estaProcMue;
    
    public ProcedenciaOrigenMuestra() {
        super();
    }

    public ProcedenciaOrigenMuestra(String codiProMue, String descProcMue) {
        super();
        this.codiProMue = codiProMue;
        this.descProcMue = descProcMue;
    }

    public void setCodiProMue(String codiProMue) {
        this.codiProMue = codiProMue;
    }

    public String getCodiProMue() {
        return codiProMue;
    }

    public void setDescProcMue(String descProcMue) {
        this.descProcMue = descProcMue;
    }

    public String getDescProcMue() {
        return descProcMue;
    }

    public void setEstaProcMue(String estaProcMue) {
        this.estaProcMue = estaProcMue;
    }

    public String getEstaProcMue() {
        return estaProcMue;
    }
}
