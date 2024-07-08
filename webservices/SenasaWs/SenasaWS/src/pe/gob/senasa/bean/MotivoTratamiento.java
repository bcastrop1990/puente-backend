package pe.gob.senasa.bean;

import java.io.Serializable;

public class MotivoTratamiento implements Serializable {
    
    private String codMotivoTratamiento;
    private String motivoTratamiento;
    private String tipoTratamiento;
    
    public MotivoTratamiento() {
        super();
    }

    public MotivoTratamiento(String codMotivoTratamiento,
                             String motivoTratamiento,
                             String tipoTratamiento) {
        super();
        this.codMotivoTratamiento = codMotivoTratamiento;
        this.motivoTratamiento = motivoTratamiento;
        this.tipoTratamiento = tipoTratamiento;
    }

    public void setCodMotivoTratamiento(String codMotivoTratamiento) {
        this.codMotivoTratamiento = codMotivoTratamiento;
    }

    public String getCodMotivoTratamiento() {
        return codMotivoTratamiento;
    }

    public void setMotivoTratamiento(String motivoTratamiento) {
        this.motivoTratamiento = motivoTratamiento;
    }

    public String getMotivoTratamiento() {
        return motivoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }
}
