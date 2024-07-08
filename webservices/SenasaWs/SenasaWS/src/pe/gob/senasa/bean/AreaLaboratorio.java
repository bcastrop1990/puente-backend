package pe.gob.senasa.bean;

import java.io.Serializable;

public class AreaLaboratorio implements Serializable {
    
    private String codiAreaLab;
    private String nombAreaLab;
    private String codiEmplPer;
    private String abreAreaLab;
    private String tipoLaboLab;
    
    public AreaLaboratorio() {
        super();
    }

    public AreaLaboratorio(String codiAreaLab, String nombAreaLab,
                           String abreAreaLab, String tipoLaboLab) {
        super();
        this.codiAreaLab = codiAreaLab;
        this.nombAreaLab = nombAreaLab;
        this.abreAreaLab = abreAreaLab;
        this.tipoLaboLab = tipoLaboLab;
    }

    public void setCodiAreaLab(String codiAreaLab) {
        this.codiAreaLab = codiAreaLab;
    }

    public String getCodiAreaLab() {
        return codiAreaLab;
    }

    public void setNombAreaLab(String nombAreaLab) {
        this.nombAreaLab = nombAreaLab;
    }

    public String getNombAreaLab() {
        return nombAreaLab;
    }

    public void setCodiEmplPer(String codiEmplPer) {
        this.codiEmplPer = codiEmplPer;
    }

    public String getCodiEmplPer() {
        return codiEmplPer;
    }

    public void setAbreAreaLab(String abreAreaLab) {
        this.abreAreaLab = abreAreaLab;
    }

    public String getAbreAreaLab() {
        return abreAreaLab;
    }

    public void setTipoLaboLab(String tipoLaboLab) {
        this.tipoLaboLab = tipoLaboLab;
    }

    public String getTipoLaboLab() {
        return tipoLaboLab;
    }
}
