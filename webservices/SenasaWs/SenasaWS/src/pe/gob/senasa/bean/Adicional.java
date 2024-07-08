package pe.gob.senasa.bean;

import java.io.Serializable;

public class Adicional implements Serializable{
    public Adicional() {
        super();
    }
    private String codigo;// concatenado numeroRegistro + secuencial
    private String nombre;
    private String direccion;    
    private String ubigeo;
    private String numeroRegistro;
    private String secuencial;


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setSecuencial(String secuencial) {
        this.secuencial = secuencial;
    }

    public String getSecuencial() {
        return secuencial;
    }
}
