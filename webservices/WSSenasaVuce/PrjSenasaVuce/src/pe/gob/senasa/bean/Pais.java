package pe.gob.senasa.bean;

import java.io.Serializable;

public class Pais implements Serializable{
    public Pais() {
        super();
    }
    private String codPais;
    private String descripcion;

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
