package pe.gob.senasa.bean;

import java.io.Serializable;

public class Departamento implements Serializable {
    public Departamento() {
        super();
    }
    
    private String codDepartamento;
    private String departamento;

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
}
