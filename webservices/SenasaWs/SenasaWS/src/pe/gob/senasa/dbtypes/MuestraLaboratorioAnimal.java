package pe.gob.senasa.dbtypes;

import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class MuestraLaboratorioAnimal implements SQLData{
    
    public static final String SQL_TYPE="SIGSVE.MUESTRA_UCDSA";
    public static final String SQL_TYPE_ARRAY="SIGSVE.MUESTRASUCDSA";
    
    private String especie;
    
    private Date fechaEnvio;
    
    private Date fechaColeccion;
    
    private int cantidad;
    
    private String categoria;
    
    private String raza;
    
    private String sexo;
    
    private String unidad;
    
    private int edad;
    
    private String tipoMuestra;
    
    private String identificacion;
    
    private String tipo;
    
    private String enfermedad;
    
    private String prueba;
    
    public MuestraLaboratorioAnimal() {
        super();
    }

    public MuestraLaboratorioAnimal(String especie, Date fechaEnvio,
                                    Date fechaColeccion, int cantidad,
                                    String categoria, String raza, String sexo,
                                    String unidad, int edad,
                                    String tipoMuestra, String identificacion,
                                    String tipo, String enfermedad,
                                    String prueba) {
        super();
        this.especie = especie;
        this.fechaEnvio = fechaEnvio;
        this.fechaColeccion = fechaColeccion;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.raza = raza;
        this.sexo = sexo;
        this.unidad = unidad;
        this.edad = edad;
        this.tipoMuestra = tipoMuestra;
        this.identificacion = identificacion;
        this.tipo = tipo;
        this.enfermedad = enfermedad; 
        this.prueba = prueba;
    }

    public String getSQLTypeName() {
        return this.SQL_TYPE;
    }

    public void readSQL(SQLInput stream, String typeName)  throws SQLException
    {
      setEspecie(stream.readString());
      setFechaEnvio(stream.readDate());
      setFechaColeccion(stream.readDate());
      setCantidad(stream.readInt());
      setCategoria(stream.readString());
      setRaza(stream.readString());
      setSexo(stream.readString());
      setUnidad(stream.readString());
      setEdad(stream.readInt());
      setTipoMuestra(stream.readString());
      setIdentificacion(stream.readString());
      setTipo(stream.readString());
      setEnfermedad(stream.readString());
      setPrueba(stream.readString());
    }

    public void writeSQL(SQLOutput stream)  throws SQLException
    {
       stream.writeString(getEspecie());
       stream.writeDate(getFechaEnvio());
       stream.writeDate(getFechaColeccion());
       stream.writeInt(getCantidad());
       stream.writeString(getCategoria());
       stream.writeString(getRaza());
       stream.writeString(getSexo());
       stream.writeString(getUnidad());
       stream.writeInt(getEdad());
       stream.writeString(getTipoMuestra());
       stream.writeString(getIdentificacion());
       stream.writeString(getTipo());
       stream.writeString(getEnfermedad());
       stream.writeString(getPrueba());
    }

    public static String getSQL_TYPE() {
        return SQL_TYPE;
    }

    public static String getSQL_TYPE_ARRAY() {
        return SQL_TYPE_ARRAY;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaColeccion(Date fechaColeccion) {
        this.fechaColeccion = fechaColeccion;
    }

    public Date getFechaColeccion() {
        return fechaColeccion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public String getPrueba() {
        return prueba;
    }
}
