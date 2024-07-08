package pe.gob.senasa.bean;

import java.io.Serializable;

public class Lote implements Serializable {
    
    private String idInspeccion;
    
    private String reglon;
    
    private String idLote;
    
    private String cantidadLote;
    
    private String estado;
    
    private String idInspeccionProducto;
    
    private String idProducto;
    
    private String observacion;
    
    public Lote() {
        super();
    }

    public Lote(String idInspeccion, String reglon, String idLote,
                String cantidadLote, String estado,
                String idInspeccionProducto, String idProducto,
                String observacion) {
        super();
        this.idInspeccion = idInspeccion;
        this.reglon = reglon;
        this.idLote = idLote;
        this.cantidadLote = cantidadLote;
        this.estado = estado;
        this.idInspeccionProducto = idInspeccionProducto;
        this.idProducto = idProducto;
        this.observacion = observacion;
    }

    public void setIdInspeccion(String idInspeccion) {
        this.idInspeccion = idInspeccion;
    }

    public String getIdInspeccion() {
        return idInspeccion;
    }

    public void setReglon(String reglon) {
        this.reglon = reglon;
    }

    public String getReglon() {
        return reglon;
    }

    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }

    public String getIdLote() {
        return idLote;
    }

    public void setCantidadLote(String cantidadLote) {
        this.cantidadLote = cantidadLote;
    }

    public String getCantidadLote() {
        return cantidadLote;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdInspeccionProducto(String idInspeccionProducto) {
        this.idInspeccionProducto = idInspeccionProducto;
    }

    public String getIdInspeccionProducto() {
        return idInspeccionProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }
}
