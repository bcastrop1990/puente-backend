package pe.gob.senasa.ws.documentoStd.bean;

import java.io.Serializable;

public class FuncionarioStd implements Serializable {
    
    private String area;
    private String subArea;
    private String nombre;
    private String usuario;
    private String fecha;
    private String tipo;
    
    public FuncionarioStd() {
        super();
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setSubArea(String subArea) {
        this.subArea = subArea;
    }

    public String getSubArea() {
        return subArea;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }
}
