package pe.gob.senasa.bean;

import java.io.Serializable;

public class Sexo implements Serializable {
    
    private String codigoSexo;
    
    private String desripcionSexo;
    
    public Sexo() {
        super();
    }

    public Sexo(String codigoSexo, String desripcionSexo) {
        super();
        this.codigoSexo = codigoSexo;
        this.desripcionSexo = desripcionSexo;
    }

    public void setCodigoSexo(String codigoSexo) {
        this.codigoSexo = codigoSexo;
    }

    public String getCodigoSexo() {
        return codigoSexo;
    }

    public void setDesripcionSexo(String desripcionSexo) {
        this.desripcionSexo = desripcionSexo;
    }

    public String getDesripcionSexo() {
        return desripcionSexo;
    }
}
