package pe.gob.senasa.bean;

import java.io.Serializable;

public class TipoIdentificacionAnimal implements Serializable {
    
    private String codIdentf;
    
    private String descTipoIdentificacion;
    
    public TipoIdentificacionAnimal() {
        super();
    }

    public TipoIdentificacionAnimal(String codIdentf,
                                    String descTipoIdentificacion) {
        super();
        this.codIdentf = codIdentf;
        this.descTipoIdentificacion = descTipoIdentificacion;
    }

    public void setCodIdentf(String codIdentf) {
        this.codIdentf = codIdentf;
    }

    public String getCodIdentf() {
        return codIdentf;
    }

    public void setDescTipoIdentificacion(String descTipoIdentificacion) {
        this.descTipoIdentificacion = descTipoIdentificacion;
    }

    public String getDescTipoIdentificacion() {
        return descTipoIdentificacion;
    }
}
