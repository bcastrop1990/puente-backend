package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;


public class SIIMF implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String  codigoImportador;
    private String  nombreImportador;
    private String  direccionImportador;
    private String  codigoPaisDestino;
    private String  nombrePaisDestino;
    private String  puntoLlegada;
    private String  PuntoSalida;
    private Date    fechaTratamiento;
    private String  nombreTratamiento;
    private String  codigoProductoQuimico;
    private String  nombreProductoQuimico;
    private String  temperaturaTratamiento;
    private String  dosisTratamiento;
    private String  codigoExpediente;
    private String  informacionAdicional;
    private String  declaracionAdicional;
    private String  codigoSolicitud;
    private String  codigoCentroTramite;
    private ArrayList<DetalleSIIMF> listaDetalleSIIMF;

    public SIIMF() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setCodigoImportador(String codigoImportador) {
        this.codigoImportador = codigoImportador;
    }

    public String getCodigoImportador() {
        return codigoImportador;
    }

    public void setNombreImportador(String nombreImportador) {
        this.nombreImportador = nombreImportador;
    }

    public String getNombreImportador() {
        return nombreImportador;
    }

    public void setDireccionImportador(String direccionImportador) {
        this.direccionImportador = direccionImportador;
    }

    public String getDireccionImportador() {
        return direccionImportador;
    }

    public void setCodigoPaisDestino(String codigoPaisDestino) {
        this.codigoPaisDestino = codigoPaisDestino;
    }

    public String getCodigoPaisDestino() {
        return codigoPaisDestino;
    }

    public void setNombrePaisDestino(String nombrePaisDestino) {
        this.nombrePaisDestino = nombrePaisDestino;
    }

    public String getNombrePaisDestino() {
        return nombrePaisDestino;
    }

    public void setPuntoLlegada(String puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }

    public String getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setPuntoSalida(String PuntoSalida) {
        this.PuntoSalida = PuntoSalida;
    }

    public String getPuntoSalida() {
        return PuntoSalida;
    }

    public void setFechaTratamiento(Date fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public Date getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setCodigoProductoQuimico(String codigoProductoQuimico) {
        this.codigoProductoQuimico = codigoProductoQuimico;
    }

    public String getCodigoProductoQuimico() {
        return codigoProductoQuimico;
    }

    public void setNombreProductoQuimico(String nombreProductoQuimico) {
        this.nombreProductoQuimico = nombreProductoQuimico;
    }

    public String getNombreProductoQuimico() {
        return nombreProductoQuimico;
    }

    public void setTemperaturaTratamiento(String temperaturaTratamiento) {
        this.temperaturaTratamiento = temperaturaTratamiento;
    }

    public String getTemperaturaTratamiento() {
        return temperaturaTratamiento;
    }

    public void setDosisTratamiento(String dosisTratamiento) {
        this.dosisTratamiento = dosisTratamiento;
    }

    public String getDosisTratamiento() {
        return dosisTratamiento;
    }

    public void setCodigoExpediente(String codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }

    public String getCodigoExpediente() {
        return codigoExpediente;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setDeclaracionAdicional(String declaracionAdicional) {
        this.declaracionAdicional = declaracionAdicional;
    }

    public String getDeclaracionAdicional() {
        return declaracionAdicional;
    }

    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setListaDetalleSIIMF(ArrayList<DetalleSIIMF> listaDetalleSIIMF) {
        this.listaDetalleSIIMF = listaDetalleSIIMF;
    }

    public ArrayList<DetalleSIIMF> getListaDetalleSIIMF() {
        return listaDetalleSIIMF;
    }

    public void setCodigoCentroTramite(String codigoCentroTramite) {
        this.codigoCentroTramite = codigoCentroTramite;
    }

    public String getCodigoCentroTramite() {
        return codigoCentroTramite;
    }
}
