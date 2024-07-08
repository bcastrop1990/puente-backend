package pe.gob.senasa.bean;

import java.io.Serializable;

public class DetalleResultadoAnalisisAnimalInsp implements Serializable {
    
    private String numeroSolicitud;
    private String codigoMuestra;
    private String codigoEnfermedad;
    private String codigoPrueba;
    private String resultado;
    private String cierreLab;
    
    
    public DetalleResultadoAnalisisAnimalInsp() {
        super();
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setCodigoMuestra(String codigoMuestra) {
        this.codigoMuestra = codigoMuestra;
    }

    public String getCodigoMuestra() {
        return codigoMuestra;
    }

    public void setCodigoEnfermedad(String codigoEnfermedad) {
        this.codigoEnfermedad = codigoEnfermedad;
    }

    public String getCodigoEnfermedad() {
        return codigoEnfermedad;
    }

    public void setCodigoPrueba(String codigoPrueba) {
        this.codigoPrueba = codigoPrueba;
    }

    public String getCodigoPrueba() {
        return codigoPrueba;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setCierreLab(String cierreLab) {
        this.cierreLab = cierreLab;
    }

    public String getCierreLab() {
        return cierreLab;
    }
}
