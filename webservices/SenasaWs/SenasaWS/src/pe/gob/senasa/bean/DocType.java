package pe.gob.senasa.bean;

import java.io.Serializable;

public class DocType implements Serializable {
    
    private String ddoctype;
    private String descripcion;
    
    public DocType() {
        super();
    }

    public DocType(String ddoctype, String descripcion) {
        super();
        this.ddoctype = ddoctype;
        this.descripcion = descripcion;
    }

    public void setDdoctype(String ddoctype) {
        this.ddoctype = ddoctype;
    }

    public String getDdoctype() {
        return ddoctype;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
