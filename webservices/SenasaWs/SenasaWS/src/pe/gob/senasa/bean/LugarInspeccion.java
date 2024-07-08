package pe.gob.senasa.bean;

import java.io.Serializable;

public class LugarInspeccion implements Serializable {
    
    private String codLugarInspeccion;
    private String lugarInspeccion;
    private String fechaInspecccion;
    private String horaInspeccion;
        
    
    public LugarInspeccion() {
        super();
    }

    public void setCodLugarInspeccion(String codLugarInspeccion) {
        this.codLugarInspeccion = codLugarInspeccion;
    }

    public String getCodLugarInspeccion() {
        return codLugarInspeccion;
    }

    public void setLugarInspeccion(String lugarInspeccion) {
        this.lugarInspeccion = lugarInspeccion;
    }

    public String getLugarInspeccion() {
        return lugarInspeccion;
    }

    public void setFechaInspecccion(String fechaInspecccion) {
        this.fechaInspecccion = fechaInspecccion;
    }

    public String getFechaInspecccion() {
        return fechaInspecccion;
    }

    public void setHoraInspeccion(String horaInspeccion) {
        this.horaInspeccion = horaInspeccion;
    }

    public String getHoraInspeccion() {
        return horaInspeccion;
    }
}
