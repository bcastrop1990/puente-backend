package pe.gob.senasa.bean;

import java.io.Serializable;

public class ServicioTUPA implements Serializable {
    
    public ServicioTUPA() {
        super();
    }
    
    private String codServicioTupa;
    private String nombreServicioTupa;
    private float valorServicioTupa;
    private String indicadorCobroPorProducto;
    private String descripcionCentroTramite= "";
    private String codigoCentroTramite = "";
    private String codigoClase = "";
    private String flagImpoExpo = "";
    
    private String codigoExpediente = "";
    private String codigoSolicitud = "";
    private String estado = "";
    private float plazo;
    
    public void setCodServicioTupa(String codServicioTupa) {
        this.codServicioTupa = codServicioTupa;
    }

    public String getCodServicioTupa() {
        return codServicioTupa;
    }

    public void setNombreServicioTupa(String nombreServicioTupa) {
        this.nombreServicioTupa = nombreServicioTupa;
    }

    public String getNombreServicioTupa() {
        return nombreServicioTupa;
    }

    public void setValorServicioTupa(float valorServicioTupa) {
        this.valorServicioTupa = valorServicioTupa;
    }

    public float getValorServicioTupa() {
        return valorServicioTupa;
    }

    public void setIndicadorCobroPorProducto(String indicadorCobroPorProducto) {
        this.indicadorCobroPorProducto = indicadorCobroPorProducto;
    }

    public String getIndicadorCobroPorProducto() {
        return indicadorCobroPorProducto;
    }
    public void setDescripcionCentroTramite(String descripcionCentroTramite) {
        this.descripcionCentroTramite = descripcionCentroTramite;
    }
  
    public String getDescripcionCentroTramite() {
        return descripcionCentroTramite;
    }
    public void setCodigoCentroTramite(String codigoCentroTramite) {
        this.codigoCentroTramite = codigoCentroTramite;
    }
  
    public String getCodigoCentroTramite() {
        return codigoCentroTramite;
    }
    
    public void setCodigoClase(String codigoClase) {
        this.codigoClase = codigoClase;
    }
  
    public String getCodigoClase() {
        return codigoClase;
    }
    
    public void setFlagImpoExpo(String flagImpoExpo) {
        this.flagImpoExpo = flagImpoExpo;
    }
  
    public String getFlagImpoExpo() {
        return flagImpoExpo;
    }
    
    public void setCodigoExpediente(String codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }
    
    public String getCodigoExpediente() {
        return codigoExpediente;
    }
    
    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }
    
    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setPlazo(float plazo) {
        this.plazo = plazo;
    }

    public float getPlazo() {
        return plazo;
    }
}
