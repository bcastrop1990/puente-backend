package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class DetalleSolicitudAnalisisAnimal implements Serializable {
    
    private String idTipoEspecieAnimal;
    
    private String idTipoIdentificacion;
    
    private String identificacionAnimal;
    
    private String idTipoMuestra;
    
    private String edad;
    
    private String unidadTiempo;
    
    private String idSexo;
    
    private String raza;
    
    private String categoriaAnimal;
    
    private String cantidadMuestra;
    
    private Date fechaColeccion;
    
    private Date fechaEnvio;
    
    public DetalleSolicitudAnalisisAnimal() {
        super();
    }

    public void setIdTipoEspecieAnimal(String idTipoEspecieAnimal) {
        this.idTipoEspecieAnimal = idTipoEspecieAnimal;
    }

    public String getIdTipoEspecieAnimal() {
        return idTipoEspecieAnimal;
    }

    public void setIdTipoIdentificacion(String idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public String getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdentificacionAnimal(String identificacionAnimal) {
        this.identificacionAnimal = identificacionAnimal;
    }

    public String getIdentificacionAnimal() {
        return identificacionAnimal;
    }

    public void setIdTipoMuestra(String idTipoMuestra) {
        this.idTipoMuestra = idTipoMuestra;
    }

    public String getIdTipoMuestra() {
        return idTipoMuestra;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEdad() {
        return edad;
    }

    public void setUnidadTiempo(String unidadTiempo) {
        this.unidadTiempo = unidadTiempo;
    }

    public String getUnidadTiempo() {
        return unidadTiempo;
    }

    public void setIdSexo(String idSexo) {
        this.idSexo = idSexo;
    }

    public String getIdSexo() {
        return idSexo;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setCategoriaAnimal(String categoriaAnimal) {
        this.categoriaAnimal = categoriaAnimal;
    }

    public String getCategoriaAnimal() {
        return categoriaAnimal;
    }

    public void setCantidadMuestra(String cantidadMuestra) {
        this.cantidadMuestra = cantidadMuestra;
    }

    public String getCantidadMuestra() {
        return cantidadMuestra;
    }

    public void setFechaColeccion(Date fechaColeccion) {
        this.fechaColeccion = fechaColeccion;
    }

    public Date getFechaColeccion() {
        return fechaColeccion;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }
}
