package pe.gob.senasa.bean;

import java.io.Serializable;

public class TipoTratamiento implements Serializable {
    
    private String codigoClase;
    private String codigoTipoTratamiento;
    private String descripcionTipoTratamiento;
    
    public TipoTratamiento() {
        super();
    }

    public TipoTratamiento(String codigoClase, String codigoTipoTratamiento,
                           String descripcionTipoTratamiento) {
        super();
        this.codigoClase = codigoClase;
        this.codigoTipoTratamiento = codigoTipoTratamiento;
        this.descripcionTipoTratamiento = descripcionTipoTratamiento;
    }


    public void setCodigoClase(String codigoClase) {
        this.codigoClase = codigoClase;
    }

    public String getCodigoClase() {
        return codigoClase;
    }

    public void setCodigoTipoTratamiento(String codigoTipoTratamiento) {
        this.codigoTipoTratamiento = codigoTipoTratamiento;
    }

    public String getCodigoTipoTratamiento() {
        return codigoTipoTratamiento;
    }

    public void setDescripcionTipoTratamiento(String descripcionTipoTratamiento) {
        this.descripcionTipoTratamiento = descripcionTipoTratamiento;
    }

    public String getDescripcionTipoTratamiento() {
        return descripcionTipoTratamiento;
    }
}
