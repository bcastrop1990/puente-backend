package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class LugaresProduccionCPE implements Serializable {
    
    private String departamento;
    private String provincia;
    private String distrito;
    private String nombre;
    private Double area;
    private String direccion;
    private String observacion;
    private String indicadorAcpt;
    private String descDepartamento;
    private String descProvincia;
    private String descDistrito;
    private String recomendacion;
    private Date fechaInspeccion;
    private String tipoPredio;
    private int secuencial;
    private int flagVuce;
    
    public LugaresProduccionCPE() {
        super();
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
  
    
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getArea() {
        return area;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setIndicadorAcpt(String indicadorAcpt) {
        this.indicadorAcpt = indicadorAcpt;
    }

    public String getIndicadorAcpt() {
        return indicadorAcpt;
    }

    public void setDescDepartamento(String descDepartamento) {
        this.descDepartamento = descDepartamento;
    }

    public String getDescDepartamento() {
        return descDepartamento;
    }

    public void setDescProvincia(String descProvincia) {
        this.descProvincia = descProvincia;
    }

    public String getDescProvincia() {
        return descProvincia;
    }

    public void setDescDistrito(String descDistrito) {
        this.descDistrito = descDistrito;
    }

    public String getDescDistrito() {
        return descDistrito;
    }


    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setFechaInspeccion(Date fechaInspeccion) {
        this.fechaInspeccion = fechaInspeccion;
    }

    public Date getFechaInspeccion() {
        return fechaInspeccion;
    }

    public void setTipoPredio(String tipoPredio) {
        this.tipoPredio = tipoPredio;
    }

    public String getTipoPredio() {
        return tipoPredio;
    }

    public void setSecuencial(int secuencial) {
        this.secuencial = secuencial;
    }

    public int getSecuencial() {
        return secuencial;
    }

    public void setFlagVuce(int flagVuce) {
        this.flagVuce = flagVuce;
    }

    public int getFlagVuce() {
        return flagVuce;
    }
}
