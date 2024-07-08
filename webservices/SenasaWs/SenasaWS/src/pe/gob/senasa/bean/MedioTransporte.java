package pe.gob.senasa.bean;

import java.io.Serializable;

public class MedioTransporte implements Serializable {
    
    private String codMedioTransporte;
    private String medioTransporte;
    
    public MedioTransporte() {
        super();
    }

    public void setCodMedioTransporte(String codMedioTransporte) {
        this.codMedioTransporte = codMedioTransporte;
    }

    public String getCodMedioTransporte() {
        return codMedioTransporte;
    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }
}
