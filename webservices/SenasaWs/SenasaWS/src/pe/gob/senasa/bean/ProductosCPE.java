package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class ProductosCPE implements Serializable {
    
    private String partidaArancelaria;
    private String descripcion;
    private String nombreCientifico;
    private String planta;
    private String origen;
    private String descOrigen;
    private Double cantidad;
    private String codigoProducto;
    private int secuencial;
    private Date fechaAdenda;
    private int flagVuce;
    
    public ProductosCPE() {
        super();
    }
    
    public void setPartidaArancelaria(String partidaArancelaria) {
        this.partidaArancelaria = partidaArancelaria;
    }

    public String getPartidaArancelaria() {
        return partidaArancelaria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getPlanta() {
        return planta;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setSecuencial(int secuencial) {
        this.secuencial = secuencial;
    }

    public int getSecuencial() {
        return secuencial;
    }

    public void setFechaAdenda(Date fechaAdenda) {
        this.fechaAdenda = fechaAdenda;
    }

    public Date getFechaAdenda() {
        return fechaAdenda;
    }

    public void setDescOrigen(String descOrigen) {
        this.descOrigen = descOrigen;
    }

    public String getDescOrigen() {
        return descOrigen;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setFlagVuce(int flagVuce) {
        this.flagVuce = flagVuce;
    }

    public int getFlagVuce() {
        return flagVuce;
    }
}
