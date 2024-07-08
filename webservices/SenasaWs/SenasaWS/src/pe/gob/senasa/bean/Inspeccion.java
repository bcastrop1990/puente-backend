package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.List;


public class Inspeccion implements Serializable {
    
    private String expediente;
    
    private String codigoServicio;
    
    private String idInspeccion;
    
    private List<ProductoInspeccion> listaProducto;
    
    public Inspeccion() {
        super();
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

    public void setIdInspeccion(String idInspeccion) {
        this.idInspeccion = idInspeccion;
    }

    public String getIdInspeccion() {
        return idInspeccion;
    }

    public void setListaProducto(List<ProductoInspeccion> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public List<ProductoInspeccion> getListaProducto() {
        return listaProducto;
    }
    
    
}
