package pe.gob.senasa.bean;

import java.io.Serializable;

public class SubTipo implements Serializable {
    
    private String codigoSubTipo;
    private String descripcion;
    private String ddoctype;  
    
    public SubTipo() {
        super();
    }

    public SubTipo(String codigoSubTipo, String descripcion, String ddoctype) {
        super();
        this.codigoSubTipo = codigoSubTipo;
        this.descripcion = descripcion;
        this.ddoctype = ddoctype;
    }

    public void setCodigoSubTipo(String codigoSubTipo) {
        this.codigoSubTipo = codigoSubTipo;
    }

    public String getCodigoSubTipo() {
        return codigoSubTipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDdoctype(String ddoctype) {
        this.ddoctype = ddoctype;
    }

    public String getDdoctype() {
        return ddoctype;
    }
}
