package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;


public class SolicitudAnalisisAnimal implements Serializable {
    
    private String codigoSede;
    
    private String idMotivo;
    
    private Date fechaEjecucion;
    
    private String idDepartamento;
    
    private String idDistrito;
    
    private String idProvincia;
    
    private String idPersona;
    
    private String predio;
    
    private String opcionRecinto;
    
    private String tipoSolicitud;
    
    private String tipoCrianza;
    
    private String producto;
    
    private String cantidadAnimales;
    
    private String[] listaidAnalisis;
    
    private ArrayList<DetalleSolicitudAnalisisAnimal> listaDetalle;
    
    public SolicitudAnalisisAnimal() {
        super();
    }

    public void setListaDetalle(ArrayList<DetalleSolicitudAnalisisAnimal> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public ArrayList<DetalleSolicitudAnalisisAnimal> getListaDetalle()
    {
        return listaDetalle;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setIdMotivo(String idMotivo) {
        this.idMotivo = idMotivo;
    }

    public String getIdMotivo() {
        return idMotivo;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getIdDistrito() {
        return idDistrito;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public String getPredio() {
        return predio;
    }

    public void setOpcionRecinto(String opcionRecinto) {
        this.opcionRecinto = opcionRecinto;
    }

    public String getOpcionRecinto() {
        return opcionRecinto;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoCrianza(String tipoCrianza) {
        this.tipoCrianza = tipoCrianza;
    }

    public String getTipoCrianza() {
        return tipoCrianza;
    }

    public void setListaidAnalisis(String[] listaidAnalisis) {
        this.listaidAnalisis = listaidAnalisis;
    }

    public String[] getListaidAnalisis() {
        return listaidAnalisis;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setCantidadAnimales(String cantidadAnimales) {
        this.cantidadAnimales = cantidadAnimales;
    }

    public String getCantidadAnimales() {
        return cantidadAnimales;
    }
    
}
