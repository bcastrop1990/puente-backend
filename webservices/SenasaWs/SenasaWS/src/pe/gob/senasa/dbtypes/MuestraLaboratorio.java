package pe.gob.senasa.dbtypes;

import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;


public class MuestraLaboratorio implements SQLData{
    
    public static String SQL_TYPE="SIGSVE.MUESTRALABORATORIO";
    public static String SQL_TYPE_ARRAY="SIGSVE.MUESTRASLABORATORIO";
    
    private String tipoMuestra;
    private Double cantidad;
    private String unidad;
    private Date fechaRecoleccion;
    private Date fechaRemision;
    private String laboratorio;
    private String procedencia;
    private String codigoMuestra;
    private String codigoOrigen;
    
    public MuestraLaboratorio() { 
        super();
    }

    public MuestraLaboratorio(String tipoMuestra, Double cantidad,
                              String unidad, Date fechaRecoleccion,
                              Date fechaRemision, String laboratorio,
                              String procedencia, String codigoMuestra,
                              String codigoOrigen) {
        super();
        this.tipoMuestra = tipoMuestra;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.fechaRecoleccion = fechaRecoleccion;
        this.fechaRemision = fechaRemision;
        this.laboratorio = laboratorio;
        this.procedencia = procedencia;
        this.codigoMuestra = codigoMuestra;
        this.codigoOrigen = codigoOrigen;
    }

    public String getSQLTypeName() {
        return "SIGSVE.MUESTRALABORATORIO";
    }
    
    
    

    public void readSQL(SQLInput stream, String typeName) throws SQLException {
            setTipoMuestra(stream.readString());
            setCantidad(stream.readDouble());
            setUnidad(stream.readString());
            setFechaRecoleccion(stream.readDate());
            setFechaRemision(stream.readDate());
            setLaboratorio(stream.readString());
            setProcedencia(stream.readString());
            setCodigoMuestra(stream.readString());
            setCodigoOrigen(stream.readString());            
    }

    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(getTipoMuestra());
                stream.writeDouble(getCantidad());
                stream.writeString(getUnidad());
                stream.writeDate(getFechaRecoleccion());
                stream.writeDate(getFechaRemision());
                stream.writeString(getLaboratorio());
                stream.writeString(getProcedencia());
                stream.writeString(getCodigoMuestra());
                stream.writeString(getCodigoOrigen());
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

    public void setCodigoMuestra(String codigoMuestra) {
        this.codigoMuestra = codigoMuestra;
    }

    public String getCodigoMuestra() {
        return codigoMuestra;
    }

    public void setCodigoOrigen(String codigoOrigen) {
        this.codigoOrigen = codigoOrigen;
    }

    public String getCodigoOrigen() {
        return codigoOrigen;
    }
}
