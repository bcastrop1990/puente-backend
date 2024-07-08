package pe.gob.senasa.bean;

import java.io.Serializable;

public class ActividadVigilancia implements Serializable {
    
    private String tipoVigiAct;
    
    private String descVigiAct;    
    
    public ActividadVigilancia() {
        super();
    }

    public ActividadVigilancia(String tipoVigiAct, String descVigiAct) {
        super();
        this.tipoVigiAct = tipoVigiAct;
        this.descVigiAct = descVigiAct;
    }

    public void setTipoVigiAct(String tipoVigiAct) {
        this.tipoVigiAct = tipoVigiAct;
    }

    public String getTipoVigiAct() {
        return tipoVigiAct;
    }

    public void setDescVigiAct(String descVigiAct) {
        this.descVigiAct = descVigiAct;
    }

    public String getDescVigiAct() {
        return descVigiAct;
    }
}
