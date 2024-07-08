package pe.gob.senasa.bean;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;


public class ExportacionZooSanitaria  implements Serializable {

    private static final long serialVersionUID = -361486625877913757L;
    private String direccionEjecutiva;
    private String noCertificado;
    private String noFolio;
    private String urlCEZDefinitivo;    
    private String lugarInspeccion;
    private Date fechaInspeccion;
    private Date horaInspeccion;
    private Date fechaEmbarque;
    private Date fechasDesembarque;
    private String usoDestino;
    private String paisOrigen;
    private String paisDestino;
    private String medioTransporte;
    private String puntoSalida;
    private String puntoLlegada;
    private String observacion;
    private String lugarUbicacionEnvio;
    private String nombreImportador;
    private String direccionImportador;
    private String codigoImportador;
    private String fechaEmision;
    private Solicitante solicitante;
    private String usuario;
    private ArrayList<ProductoPZI> productosCEZ = new ArrayList<ProductoPZI>();
    private ArrayList<AnexoPZI> anexosCEZ = new ArrayList<AnexoPZI>();
    
    public ExportacionZooSanitaria() {
        super();
    }


    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoFolio(String noFolio) {
        this.noFolio = noFolio;
    }

    public String getNoFolio() {
        return noFolio;
    }

    public void setUrlCEZDefinitivo(String urlCEZDefinitivo) {
        this.urlCEZDefinitivo = urlCEZDefinitivo;
    }

    public String getUrlCEZDefinitivo() {
        return urlCEZDefinitivo;
    }

    public void setLugarInspeccion(String lugarInspeccion) {
        this.lugarInspeccion = lugarInspeccion;
    }

    public String getLugarInspeccion() {
        return lugarInspeccion;
    }

    public void setFechaInspeccion(Date fechaInspeccion) {
        this.fechaInspeccion = fechaInspeccion;
    }

    public Date getFechaInspeccion() {
        return fechaInspeccion;
    }

    public void setHoraInspeccion(Date horaInspeccion) {
        this.horaInspeccion = horaInspeccion;
    }

    public Date getHoraInspeccion() {
        return horaInspeccion;
    }

    public void setUsoDestino(String usoDestino) {
        this.usoDestino = usoDestino;
    }

    public String getUsoDestino() {
        return usoDestino;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    public void setPuntoSalida(String puntoSalida) {
        this.puntoSalida = puntoSalida;
    }

    public String getPuntoSalida() {
        return puntoSalida;
    }

    public void setPuntoLlegada(String puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }

    public String getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setLugarUbicacionEnvio(String lugarUbicacionEnvio) {
        this.lugarUbicacionEnvio = lugarUbicacionEnvio;
    }

    public String getLugarUbicacionEnvio() {
        return lugarUbicacionEnvio;
    }

    public void setDireccionEjecutiva(String direccionEjecutiva) {
        this.direccionEjecutiva = direccionEjecutiva;
    }

    public String getDireccionEjecutiva() {
        return direccionEjecutiva;
    }

    public void setAnexosCEZ(ArrayList<AnexoPZI> anexosCEZ) {
        this.anexosCEZ = anexosCEZ;
    }

    public ArrayList<AnexoPZI> getAnexosCEZ() {
        return anexosCEZ;
    }

    

    public void setFechaEmbarque(Date fechaEmbarque) {
        this.fechaEmbarque = fechaEmbarque;
    }

    public Date getFechaEmbarque() {
        return fechaEmbarque;
    }

    public void setFechasDesembarque(Date fechasDesembarque) {
        this.fechasDesembarque = fechasDesembarque;
    }

    public Date getFechasDesembarque() {
        return fechasDesembarque;
    }

    public void setDireccionImportador(String direccionImportador) {
        this.direccionImportador = direccionImportador;
    }

    public String getDireccionImportador() {
        return direccionImportador;
    }

    public void setNombreImportador(String nombreImportador) {
        this.nombreImportador = nombreImportador;
    }

    public String getNombreImportador() {
        return nombreImportador;
    }

    public void setCodigoImportador(String codigoImportador) {
        this.codigoImportador = codigoImportador;
    }

    public String getCodigoImportador() {
        return codigoImportador;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setProductosCEZ(ArrayList<ProductoPZI> productosCEZ) {
        this.productosCEZ = productosCEZ;
    }

    public ArrayList<ProductoPZI> getProductosCEZ() {
        return productosCEZ;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }
}
