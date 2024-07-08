package pe.gob.senasa.bean;

import java.io.Serializable;

public class CabeceraSolicitudAnalisis implements Serializable{
    
    private String cliente;
    private String direccion;
    private String telefono;
    private String codigoPredio;
    private String pais;
    private String departamento;
    private String provincia;
    private String distrito;
    private String centroPoblado;
    private String responsableMuestreo;
    private String tipoUsuario;
    private String proyecto;
    private String producto;
    private String meta;
    private String documentoOrigen;
    private String cultivo;
    private String cultivar;
    private String distribucion;
    private String densidadPoblacional;
    private String  procedenciaSemilla;
    private Double areaSembrada;
    private Double areaAfectada;
    private Double latitud;
    private Double longitud;
    private String temperatura;
    private String humedad;
    private String sede;
    private Double altitud;
    private String servicioTupa;
    private String usoPropuesto;
    private String tipoEnvase;
    
    public CabeceraSolicitudAnalisis() {
        super();
    }

    public CabeceraSolicitudAnalisis(String cliente, String direccion,
                                     String telefono, String codigoPredio,
                                     String pais, String departamento,
                                     String provincia, String distrito,
                                     String centroPoblado,
                                     String responsableMuestreo,
                                     String tipoUsuario, String proyecto,
                                     String producto, String meta,
                                     String documentoOrigen, String cultivo,
                                     String cultivar, String distribucion,
                                     String densidadPoblacional,
                                     String procedenciaSemilla,
                                     Double areaSembrada, Double areaAfectada,
                                     Double latitud, Double longitud,
                                     String temperatura, String humedad,
                                     String sede, Double altitud, String servicioTupa,
                                     String usoPropuesto, String tipoEnvase) {
        super();
        this.cliente = cliente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codigoPredio = codigoPredio;
        this.pais = pais;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.centroPoblado = centroPoblado;
        this.responsableMuestreo = responsableMuestreo;
        this.tipoUsuario = tipoUsuario;
        this.proyecto = proyecto;
        this.producto = producto;
        this.meta = meta;
        this.documentoOrigen = documentoOrigen;
        this.cultivo = cultivo;
        this.cultivar = cultivar;
        this.distribucion = distribucion;
        this.densidadPoblacional = densidadPoblacional;
        this.procedenciaSemilla = procedenciaSemilla;
        this.areaSembrada = areaSembrada;
        this.areaAfectada = areaAfectada;
        this.latitud = latitud;
        this.longitud = longitud;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.sede = sede;
        this.altitud = altitud;
        this.servicioTupa = servicioTupa;
        this.usoPropuesto = usoPropuesto;
        this.tipoEnvase = tipoEnvase;
        
    }


    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setCodigoPredio(String codigoPredio) {
        this.codigoPredio = codigoPredio;
    }

    public String getCodigoPredio() {
        return codigoPredio;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setCentroPoblado(String centroPoblado) {
        this.centroPoblado = centroPoblado;
    }

    public String getCentroPoblado() {
        return centroPoblado;
    }

    public void setResponsableMuestreo(String responsableMuestreo) {
        this.responsableMuestreo = responsableMuestreo;
    }

    public String getResponsableMuestreo() {
        return responsableMuestreo;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getMeta() {
        return meta;
    }

    public void setDocumentoOrigen(String documentoOrigen) {
        this.documentoOrigen = documentoOrigen;
    }

    public String getDocumentoOrigen() {
        return documentoOrigen;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivar(String cultivar) {
        this.cultivar = cultivar;
    }

    public String getCultivar() {
        return cultivar;
    }

    public void setDistribucion(String distribucion) {
        this.distribucion = distribucion;
    }

    public String getDistribucion() {
        return distribucion;
    }

    public void setDensidadPoblacional(String densidadPoblacional) {
        this.densidadPoblacional = densidadPoblacional;
    }

    public String getDensidadPoblacional() {
        return densidadPoblacional;
    }

    public void setProcedenciaSemilla(String procedenciaSemilla) {
        this.procedenciaSemilla = procedenciaSemilla;
    }

    public String getProcedenciaSemilla() {
        return procedenciaSemilla;
    }

    public void setAreaSembrada(Double areaSembrada) {
        this.areaSembrada = areaSembrada;
    }

    public Double getAreaSembrada() {
        return areaSembrada;
    }

    public void setAreaAfectada(Double areaAfectada) {
        this.areaAfectada = areaAfectada;
    }

    public Double getAreaAfectada() {
        return areaAfectada;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getSede() {
        return sede;
    }

    public void setAltitud(Double altitud) {
        this.altitud = altitud;
    }

    public Double getAltitud() {
        return altitud;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
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
