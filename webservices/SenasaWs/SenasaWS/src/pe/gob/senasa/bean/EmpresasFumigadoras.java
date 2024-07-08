package pe.gob.senasa.bean;

import java.io.Serializable;

public class EmpresasFumigadoras implements Serializable {
  
    private String codEmpresaFumigadora;
    private String empresaFumigadora;
  
    public EmpresasFumigadoras() {
        super();
    }

    public void setCodEmpresaFumigadora(String codEmpresaFumigadora) {
        this.codEmpresaFumigadora = codEmpresaFumigadora;
    }

    public String getCodEmpresaFumigadora() {
        return codEmpresaFumigadora;
    }

    public void setEmpresaFumigadora(String empresaFumigadora) {
        this.empresaFumigadora = empresaFumigadora;
    }

    public String getEmpresaFumigadora() {
        return empresaFumigadora;
    }
}
