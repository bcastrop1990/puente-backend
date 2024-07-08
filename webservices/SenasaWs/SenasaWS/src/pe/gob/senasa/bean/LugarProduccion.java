package pe.gob.senasa.bean;

import java.io.Serializable;

public class LugarProduccion implements Serializable {
    
    private String codLugarProduccion;
    private String lugarProduccion;
    private Departamento departamento;
    private Distrito distrito;
    private Provincia provincia;
    
    public LugarProduccion() {
        super();
    }

    public void setCodLugarProduccion(String codLugarProduccion) {
        this.codLugarProduccion = codLugarProduccion;
    }

    public String getCodLugarProduccion() {
        return codLugarProduccion;
    }

    public void setLugarProduccion(String lugarProduccion) {
        this.lugarProduccion = lugarProduccion;
    }

    public String getLugarProduccion() {
        return lugarProduccion;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Provincia getProvincia() {
        return provincia;
    }
}
