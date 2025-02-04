package pe.gob.senasa.bean;

import java.io.Serializable;

public class Sede implements Serializable {
    
    private String descTipoSede;
    private String codSede;
    private String descSede;
    
    public Sede() {
        super();
    }

    public void setDescTipoSede(String descTipoSede) {
        this.descTipoSede = descTipoSede;
    }

    public String getDescTipoSede() {
        return descTipoSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public String getCodSede() {
        return codSede;
    }

    public void setDescSede(String descSede) {
        this.descSede = descSede;
    }

    public String getDescSede() {
        return descSede;
    }

}
