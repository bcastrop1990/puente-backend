package pe.gob.senasa.bean;

import java.io.Serializable;

public class Tratamiento implements Serializable{
    
    public Tratamiento() {
        super();
    }
    
    private String codigoTratamiento;
    private String tipoTratamiento;
    private String descripcionTratamiento;
    private String codigoProductoQuimico;
    private String codigoClase;
    private String tiempo;
    private String codiUnidMedTiemp;
    private String dosis;
    private String codiUnidMedDosis;
    private String temperaturaMaxima;
    private String temperaturaMinima;
    private String codiUnidMedTemperatura;

    public Tratamiento(String codigoTratamiento, String tipoTratamiento,
                       String descripcionTratamiento,
                       String codigoProductoQuimico, String codigoClase,
                       String tiempo, String codiUnidMedTiemp, String dosis,
                       String codiUnidMedDosis, String temperaturaMaxima,
                       String temperaturaMinima,
                       String codiUnidMedTemperatura) {
        super();
        this.codigoTratamiento = codigoTratamiento;
        this.tipoTratamiento = tipoTratamiento;
        this.descripcionTratamiento = descripcionTratamiento;
        this.codigoProductoQuimico = codigoProductoQuimico;
        this.codigoClase = codigoClase;
        this.tiempo = tiempo;
        this.codiUnidMedTiemp = codiUnidMedTiemp;
        this.dosis = dosis;
        this.codiUnidMedDosis = codiUnidMedDosis;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaMinima = temperaturaMinima;
        this.codiUnidMedTemperatura = codiUnidMedTemperatura;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setDescripcionTratamiento(String descripcionTratamiento) {
        this.descripcionTratamiento = descripcionTratamiento;
    }

    public String getDescripcionTratamiento() {
        return descripcionTratamiento;
    }

    public void setCodigoTratamiento(String codigoTratamiento) {
        this.codigoTratamiento = codigoTratamiento;
    }

    public String getCodigoTratamiento() {
        return codigoTratamiento;
    }

    public void setCodigoProductoQuimico(String codigoProductoQuimico) {
        this.codigoProductoQuimico = codigoProductoQuimico;
    }

    public String getCodigoProductoQuimico() {
        return codigoProductoQuimico;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setCodiUnidMedTiemp(String codiUnidMedTiemp) {
        this.codiUnidMedTiemp = codiUnidMedTiemp;
    }

    public String getCodiUnidMedTiemp() {
        return codiUnidMedTiemp;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getDosis() {
        return dosis;
    }

    public void setCodiUnidMedDosis(String codiUnidMedDosis) {
        this.codiUnidMedDosis = codiUnidMedDosis;
    }

    public String getCodiUnidMedDosis() {
        return codiUnidMedDosis;
    }

    public void setTemperaturaMaxima(String temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public String getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMinima(String temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public String getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setCodiUnidMedTemperatura(String codiUnidMedTemperatura) {
        this.codiUnidMedTemperatura = codiUnidMedTemperatura;
    }

    public String getCodiUnidMedTemperatura() {
        return codiUnidMedTemperatura;
    }

    public void setCodigoClase(String codigoClase) {
        this.codigoClase = codigoClase;
    }

    public String getCodigoClase() {
        return codigoClase;
    }
}
