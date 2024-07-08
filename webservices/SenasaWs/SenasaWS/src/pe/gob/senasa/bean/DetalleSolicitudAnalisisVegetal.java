package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class DetalleSolicitudAnalisisVegetal implements Serializable {
    
    private String idTipoMuestra;
    
    private String cantidadMuestra;
    
    private String idUnidadMedida;
    
    private Date fechaColeccion;
    
    private Date fechaRemiteMuestra;
    
    private String idAreaLaboratorio;
    
    private String idProcedenciaMuestra;
    
  private String codigoMuestra;
  private String codigoOrigen;
    
    private String[] listaCodigoAnalisis;
    
    public DetalleSolicitudAnalisisVegetal() {
        super();
    }

    public void setIdTipoMuestra(String idTipoMuestra) {
        this.idTipoMuestra = idTipoMuestra;
    }

    public String getIdTipoMuestra() {
        return idTipoMuestra;
    }

    public void setCantidadMuestra(String cantidadMuestra) {
        this.cantidadMuestra = cantidadMuestra;
    }

    public String getCantidadMuestra() {
        return cantidadMuestra;
    }

    public void setIdUnidadMedida(String idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setFechaColeccion(Date fechaColeccion) {
        this.fechaColeccion = fechaColeccion;
    }

    public Date getFechaColeccion() {
        return fechaColeccion;
    }

    public void setFechaRemiteMuestra(Date fechaRemiteMuestra) {
        this.fechaRemiteMuestra = fechaRemiteMuestra;
    }

    public Date getFechaRemiteMuestra() {
        return fechaRemiteMuestra;
    }

    public void setIdAreaLaboratorio(String idAreaLaboratorio) {
        this.idAreaLaboratorio = idAreaLaboratorio;
    }

    public String getIdAreaLaboratorio() {
        return idAreaLaboratorio;
    }

    public void setIdProcedenciaMuestra(String idProcedenciaMuestra) {
        this.idProcedenciaMuestra = idProcedenciaMuestra;
    }

    public String getIdProcedenciaMuestra() {
        return idProcedenciaMuestra;
    }

    public void setListaCodigoAnalisis(String[] listaCodigoAnalisis) {
        this.listaCodigoAnalisis = listaCodigoAnalisis;
    }

    public String[] getListaCodigoAnalisis() {
        return listaCodigoAnalisis;
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
