package pe.gob.senasa.bean;

import java.io.Serializable;

public class ProductoInspeccion implements Serializable {
    
    private int reglon;
    
    private String codigoProductoInspeccion;    
    private String cantidad;    
    private String estado;    
    private String expediente;    
    private String codigoServicio;    
    private String codigoProducto;    
    private String idInspeccion;    
    private String cantidadActual;       
    private String personaId;
    
  
    public ProductoInspeccion() {
        super();
    }

    public ProductoInspeccion(String cantidad, String estado,
                              String expediente, String codigoServicio,
                              String codigoProducto, String cantidadActual,
                              String personaId) {
        super();
        this.cantidad = cantidad;
        this.estado = estado;
        this.expediente = expediente;
        this.codigoServicio = codigoServicio;
        this.codigoProducto = codigoProducto;
        this.cantidadActual = cantidadActual;
        this.personaId = personaId;
    }

    public ProductoInspeccion(String codigoProductoInspeccion, String estado,
                              String cantidadActual, String personaId) {
        super();
        this.codigoProductoInspeccion = codigoProductoInspeccion;
        this.estado = estado;
        this.cantidadActual = cantidadActual;
        this.personaId = personaId;
    }

    public void setReglon(int reglon) {
        this.reglon = reglon;
    }

    public int getReglon() {
        return reglon;
    }

    public void setCodigoProductoInspeccion(String codigoProductoInspeccion) {
        this.codigoProductoInspeccion = codigoProductoInspeccion;
    }

    public String getCodigoProductoInspeccion() {
        return codigoProductoInspeccion;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setIdInspeccion(String idInspeccion) {
        this.idInspeccion = idInspeccion;
    }

    public String getIdInspeccion() {
        return idInspeccion;
    }

    public void setCantidadActual(String cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public String getCantidadActual() {
        return cantidadActual;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public String getPersonaId() {
        return personaId;
    }
}
