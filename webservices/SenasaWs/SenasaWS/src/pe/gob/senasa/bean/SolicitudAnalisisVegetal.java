package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;


public class SolicitudAnalisisVegetal implements Serializable {
    
    private String codigoSolicitante; //cliente
    
    private String codigoDireccionEjecutiva; //sede
    
    private String codigoPaisOrigen; //pais
    
    private String codigoDepartamento; //departamento
    
    private String codigoDistrito; //distrito
    
    private String codigoProvincia; //provincia
    
    private String codigoInspector; //responsable_muestreo
    
    private Date fechaSolicitud; //??
    
    private String numeroRecibo; //??
    
    private String codigoEmplPer; //??
    
    private String codigoTipUsu; //??
    
    private String codiTipoSol; //??
    
    private String producto;
    
    private String servicioTupa;
    
    private String usoPropuesto;
    
    private String tipoEnvase;
    
    private ArrayList<DetalleSolicitudAnalisisVegetal> listaMuestra;
    
    
    public SolicitudAnalisisVegetal() {
        super();
    }

    public void setCodigoSolicitante(String codigoSolicitante) {
        this.codigoSolicitante = codigoSolicitante;
    }

    public String getCodigoSolicitante() {
        return codigoSolicitante;
    }

    public void setCodigoDireccionEjecutiva(String codigoDireccionEjecutiva) {
        this.codigoDireccionEjecutiva = codigoDireccionEjecutiva;
    }

    public String getCodigoDireccionEjecutiva() {
        return codigoDireccionEjecutiva;
    }

    public void setCodigoPaisOrigen(String codigoPaisOrigen) {
        this.codigoPaisOrigen = codigoPaisOrigen;
    }

    public String getCodigoPaisOrigen() {
        return codigoPaisOrigen;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoInspector(String codigoInspector) {
        this.codigoInspector = codigoInspector;
    }

    public String getCodigoInspector() {
        return codigoInspector;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setCodigoEmplPer(String codigoEmplPer) {
        this.codigoEmplPer = codigoEmplPer;
    }

    public String getCodigoEmplPer() {
        return codigoEmplPer;
    }

    public void setCodigoTipUsu(String codigoTipUsu) {
        this.codigoTipUsu = codigoTipUsu;
    }

    public String getCodigoTipUsu() {
        return codigoTipUsu;
    }

    public void setCodiTipoSol(String codiTipoSol) {
        this.codiTipoSol = codiTipoSol;
    }

    public String getCodiTipoSol() {
        return codiTipoSol;
    }

    public void setListaMuestra(ArrayList<DetalleSolicitudAnalisisVegetal> listaMuestra) {
        this.listaMuestra = listaMuestra;
    }

    public ArrayList<DetalleSolicitudAnalisisVegetal> getListaMuestra() {
        return listaMuestra;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setServicioTupa(String servicioTupa) {
        this.servicioTupa = servicioTupa;
    }

    public String getServicioTupa() {
        return servicioTupa;
    }

    public void setUsoPropuesto(String usoPropuesto) {
        this.usoPropuesto = usoPropuesto;
    }

    public String getUsoPropuesto() {
        return usoPropuesto;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }
}
