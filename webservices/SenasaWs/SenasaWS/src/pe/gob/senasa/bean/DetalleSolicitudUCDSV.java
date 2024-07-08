package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class DetalleSolicitudUCDSV implements Serializable{

    private String tipoMuestra;
    private Double cantidad;
    private String unidad;
    private Date fechaRecoleccion;
    private Date fechaRemision;
    private String laboratorio;
    private String procedencia;

    public DetalleSolicitudUCDSV(String tipoMuestra, Double cantidad,
                                 String unidad, Date fechaRecoleccion,
                                 Date fechaRemision, String laboratorio,
                                 String procedencia) {
        super();
        this.tipoMuestra = tipoMuestra;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.fechaRecoleccion = fechaRecoleccion;
        this.fechaRemision = fechaRemision;
        this.laboratorio = laboratorio;
        this.procedencia = procedencia;
    }
    
    public DetalleSolicitudUCDSV() {
        super();
    }


    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setFechaRecoleccion(Date fechaRecoleccion) {
        this.fechaRecoleccion = fechaRecoleccion;
    }

    public Date getFechaRecoleccion() {
        return fechaRecoleccion;
    }

    public void setFechaRemision(Date fechaRemision) {
        this.fechaRemision = fechaRemision;
    }

    public Date getFechaRemision() {
        return fechaRemision;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getProcedencia() {
        return procedencia;
    }
}
