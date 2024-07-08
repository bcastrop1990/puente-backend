package pe.gob.senasa.bean;

import java.io.Serializable;

public class Plaga implements Serializable {
    
    private String codPlaga;
    private String plaga;
    private String nombreComun;
    
    
    public Plaga() {
        super();
    }

    public Plaga(String codPlaga, String plaga, String nombreComun) {
        super();
        this.codPlaga = codPlaga;
        this.plaga = plaga;
        this.nombreComun = nombreComun;
    }

    public void setCodPlaga(String codPlaga) {
        this.codPlaga = codPlaga;
    }

    public String getCodPlaga() {
        return codPlaga;
    }

    public void setPlaga(String plaga) {
        this.plaga = plaga;
    }

    public String getPlaga() {
        return plaga;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreComun() {
        return nombreComun;
    }
}
