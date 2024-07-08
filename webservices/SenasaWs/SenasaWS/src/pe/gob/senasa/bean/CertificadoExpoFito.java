package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;


public class CertificadoExpoFito implements Serializable {
    
    private String codigoCertificadoExpoFito;
    
    private String codigoCentroTramite;
    
    private String nombreCentroTramite;
    
    private String codigoCentroTramiteSalida;
    
    private String nombreCentroTramiteSalida;
    
    private Date fechaEmision;
    
    private String codigoPaisOrigen;
    
    private String nombrePaisOrigen;
    
    private String codigoPaisDestino;
    
    private String nombrePaisDestino;
    
    private String codigoDepartamento;
    
    private String nombreDepartamento;
    
    private String codigoProvincia;
    
    private String nombreProvincia;
    
    private String codigoDistrito;
    
    private String nombreDistrito;
    
    private Date fechaEntrega;
    
    private String codigoImportador;
    
    private String nombreImportador;
    
    private String codigoLugarInspeccion;
    
    private String nombreLugarInspeccion;
    
    private String codigoMedioTransporte;
    
    private String nombreMedioTransporte;
    
    private Date fechaEmbarque;
    
    private Date fechaDesembarque;
    
    private String codigoExpediente;
    
    private String observacion;
    
    private String lugarProduccion;
    
    private String descripcionLugarProduccion;
    
    private Date horaEmision;
    
    private String numeroCertificado;
    
    private String codigoPuerto;
    
    private String nombrePuerto;
    
    private String estado;
    
    private ArrayList<ProductoExpoFito> listaProductos;
    
    private String idPersona;

    private static final long serialVersionUID = 1L;

    public CertificadoExpoFito() {
        super();
    }

    public void setCodigoCertificadoExpoFito(String codigoCertificadoExpoFito) {
        this.codigoCertificadoExpoFito = codigoCertificadoExpoFito;
    }

    public String getCodigoCertificadoExpoFito() {
        return codigoCertificadoExpoFito;
    }

    public void setCodigoCentroTramite(String codigoCentroTramite) {
        this.codigoCentroTramite = codigoCentroTramite;
    }

    public String getCodigoCentroTramite() {
        return codigoCentroTramite;
    }

    public void setCodigoCentroTramiteSalida(String codigoCentroTramiteSalida) {
        this.codigoCentroTramiteSalida = codigoCentroTramiteSalida;
    }

    public String getCodigoCentroTramiteSalida() {
        return codigoCentroTramiteSalida;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setCodigoPaisOrigen(String codigoPaisOrigen) {
        this.codigoPaisOrigen = codigoPaisOrigen;
    }

    public String getCodigoPaisOrigen() {
        return codigoPaisOrigen;
    }

    public void setCodigoPaisDestino(String codigoPaisDestino) {
        this.codigoPaisDestino = codigoPaisDestino;
    }

    public String getCodigoPaisDestino() {
        return codigoPaisDestino;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setCodigoImportador(String codigoImportador) {
        this.codigoImportador = codigoImportador;
    }

    public String getCodigoImportador() {
        return codigoImportador;
    }

    public void setCodigoLugarInspeccion(String codigoLugarInspeccion) {
        this.codigoLugarInspeccion = codigoLugarInspeccion;
    }

    public String getCodigoLugarInspeccion() {
        return codigoLugarInspeccion;
    }

    public void setCodigoMedioTransporte(String codigoMedioTransporte) {
        this.codigoMedioTransporte = codigoMedioTransporte;
    }

    public String getCodigoMedioTransporte() {
        return codigoMedioTransporte;
    }

    public void setFechaEmbarque(Date fechaEmbarque) {
        this.fechaEmbarque = fechaEmbarque;
    }

    public Date getFechaEmbarque() {
        return fechaEmbarque;
    }

    public void setFechaDesembarque(Date fechaDesembarque) {
        this.fechaDesembarque = fechaDesembarque;
    }

    public Date getFechaDesembarque() {
        return fechaDesembarque;
    }

    public void setCodigoExpediente(String codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }

    public String getCodigoExpediente() {
        return codigoExpediente;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setLugarProduccion(String lugarProduccion) {
        this.lugarProduccion = lugarProduccion;
    }

    public String getLugarProduccion() {
        return lugarProduccion;
    }

    public void setHoraEmision(Date horaEmision) {
        this.horaEmision = horaEmision;
    }

    public Date getHoraEmision() {
        return horaEmision;
    }

    public void setNumeroCertificado(String numeroCertificado) {
        this.numeroCertificado = numeroCertificado;
    }

    public String getNumeroCertificado() {
        return numeroCertificado;
    }

    public void setCodigoPuerto(String codigoPuerto) {
        this.codigoPuerto = codigoPuerto;
    }

    public String getCodigoPuerto() {
        return codigoPuerto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setListaProductos(ArrayList<ProductoExpoFito> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<ProductoExpoFito> getListaProductos() {
        return listaProductos;
    }

    public void setNombreCentroTramite(String nombreCentroTramite) {
        this.nombreCentroTramite = nombreCentroTramite;
    }

    public String getNombreCentroTramite() {
        return nombreCentroTramite;
    }

    public void setNombreCentroTramiteSalida(String nombreCentroTramiteSalida) {
        this.nombreCentroTramiteSalida = nombreCentroTramiteSalida;
    }

    public String getNombreCentroTramiteSalida() {
        return nombreCentroTramiteSalida;
    }

    public void setNombrePaisOrigen(String nombrePaisOrigen) {
        this.nombrePaisOrigen = nombrePaisOrigen;
    }

    public String getNombrePaisOrigen() {
        return nombrePaisOrigen;
    }

    public void setNombrePaisDestino(String nombrePaisDestino) {
        this.nombrePaisDestino = nombrePaisDestino;
    }

    public String getNombrePaisDestino() {
        return nombrePaisDestino;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreImportador(String nombreImportador) {
        this.nombreImportador = nombreImportador;
    }

    public String getNombreImportador() {
        return nombreImportador;
    }

    public void setNombreLugarInspeccion(String nombreLugarInspeccion) {
        this.nombreLugarInspeccion = nombreLugarInspeccion;
    }

    public String getNombreLugarInspeccion() {
        return nombreLugarInspeccion;
    }

    public void setNombreMedioTransporte(String nombreMedioTransporte) {
        this.nombreMedioTransporte = nombreMedioTransporte;
    }

    public String getNombreMedioTransporte() {
        return nombreMedioTransporte;
    }

    public void setDescripcionLugarProduccion(String descripcionLugarProduccion) {
        this.descripcionLugarProduccion = descripcionLugarProduccion;
    }

    public String getDescripcionLugarProduccion() {
        return descripcionLugarProduccion;
    }

    public void setNombrePuerto(String nombrePuerto) {
        this.nombrePuerto = nombrePuerto;
    }

    public String getNombrePuerto() {
        return nombrePuerto;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdPersona() {
        return idPersona;
    }
    
    
}
