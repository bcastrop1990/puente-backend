package pe.gob.senasa.bean;

import java.io.Serializable;

public class DetalleResultadoAnalisisVegetalInsp implements Serializable {
    
    
    private String numeroSolicitud;
    private String motivoResultado;
    private String codigoTipoMuestra;
    private String codigoMuestra;
    
    
    public DetalleResultadoAnalisisVegetalInsp() {
        super();
    }


    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setMotivoResultado(String motivoResultado) {
        this.motivoResultado = motivoResultado;
    }

    public String getMotivoResultado() {
        return motivoResultado;
    }

    public void setCodigoTipoMuestra(String codigoTipoMuestra) {
        this.codigoTipoMuestra = codigoTipoMuestra;
    }

    public String getCodigoTipoMuestra() {
        return codigoTipoMuestra;
    }

    public void setCodigoMuestra(String codigoMuestra) {
        this.codigoMuestra = codigoMuestra;
    }

    public String getCodigoMuestra() {
        return codigoMuestra;
    }
}
