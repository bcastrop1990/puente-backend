package pe.gob.senasa.bean;

import java.io.Serializable;

public class ProductoInspeccion implements Serializable {
    
    public ProductoInspeccion() {
        super();
    }
    
    private String codigoInspeccionProducto;
    private String codigoInspeccion;
    private String codigoProducto;
    private Double cantidadActual;
    private String codigoServicio;
    private String codigoExpediente;
    private Double cantidadBase;
    private Double pesoActual;
    private Double pesoBase;
    private String estado;
    private String personaId;
    private String codigoCentroTramite;


    public void setCodigoInspeccion(String codigoInspeccion) {
        this.codigoInspeccion = codigoInspeccion;
    }

    public String getCodigoInspeccion() {
        return codigoInspeccion;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCantidadActual(Double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public Double getCantidadActual() {
        return cantidadActual;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoExpediente(String codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }

    public String getCodigoExpediente() {
        return codigoExpediente;
    }

    public void setCantidadBase(Double cantidadBase) {
        this.cantidadBase = cantidadBase;
    }

    public Double getCantidadBase() {
        return cantidadBase;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoBase(Double pesoBase) {
        this.pesoBase = pesoBase;
    }

    public Double getPesoBase() {
        return pesoBase;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodigoCentroTramite(String codigoCentroTramite) {
        this.codigoCentroTramite = codigoCentroTramite;
    }

    public String getCodigoCentroTramite() {
        return codigoCentroTramite;
    }

    public void setCodigoInspeccionProducto(String codigoInspeccionProducto) {
        this.codigoInspeccionProducto = codigoInspeccionProducto;
    }

    public String getCodigoInspeccionProducto() {
        return codigoInspeccionProducto;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public String getPersonaId() {
        return personaId;
    }
}
