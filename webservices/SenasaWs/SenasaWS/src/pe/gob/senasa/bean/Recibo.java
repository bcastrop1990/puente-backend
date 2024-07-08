package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;


public class Recibo implements Serializable{
    
    String codigoRecibo="";
    String prefijo="";
    String numeroRecibo="";
    String sfechaRecibo;
    Date fechaRecibo;
    String codigoCentroTramite="";
    String personaId;
    String dniRuc;
    String codigoExpediente="";
    Double montoPagado;
    Double montoRecibo;
    Double montoSaldo;
    String estado;
    String observacion;
    String urlRecibo;
    String codigoSolicitud;
  ArrayList<ReciboServicio> reciboServicio = new  ArrayList<ReciboServicio>();
    ArrayList<Propiedad> metadatos = new ArrayList<Propiedad>();
    
  public Recibo() {
      super();
  }
    
  public void setCodigoRecibo(String codigoRecibo) {
      this.codigoRecibo = codigoRecibo;
  }

  public String getCodigoRecibo() {
      return codigoRecibo;
  }
  
  public void setPrefijo(String prefijo) {
      this.prefijo = prefijo;
  }

  public String getPrefijo() {
      return prefijo;
  }
 
  public void setNumeroRecibo(String numeroRecibo) {
      this.numeroRecibo = numeroRecibo;
  }

  public String getNumeroRecibo() {
      return numeroRecibo;
  }
  
  
  public void setSFechaRecibo(String sfechaRecibo) {
      this.sfechaRecibo = sfechaRecibo;
  }

  public String getSFechaRecibo() {
      return sfechaRecibo;
  }
  
  public void setFechaRecibo(Date fechaRecibo) {
      this.fechaRecibo = fechaRecibo;
  }

  public Date getFechaRecibo() {
      return fechaRecibo;
  }
  
  public void setCodigoCentroTramite(String codigoCentroTramite) {
      this.codigoCentroTramite = codigoCentroTramite;
  }

  public String getCodigoCentroTramite() {
      return codigoCentroTramite;
  }
  
  public void setPersonaId(String personaId) {
      this.personaId = personaId;
  }

  public String getPersonaId() {
      return personaId;
  }
  
  public void setDniRuc(String dniRuc) {
      this.dniRuc = dniRuc;
  }

  public String getDniRuc() {
      return dniRuc;
  }
  
  public void setCodigoExpediente(String codigoExpediente) {
      this.codigoExpediente = codigoExpediente;
  }

  public String getCodigoExpediente() {
      return codigoExpediente;
  }
  
  
  public void setMontoPagado(Double montoPagado) {
      this.montoPagado = montoPagado;
  }

  public Double getMontoPagado() {
      return montoPagado;
  }
  
  
  public void setMontoRecibo(Double montoRecibo) {
      this.montoRecibo = montoRecibo;
  }

  public Double getMontoRecibo() {
      return montoRecibo;
  }
  
  public void setMontoSaldo(Double montoSaldo) {
      this.montoSaldo = montoSaldo;
  }

  public Double getMontoSaldo() {
      return montoSaldo;
  }
  
  public void setEstado(String estado) {
      this.estado = estado;
  }

  public String getEstado() {
      return estado;
  }
  
  public void setObservacion(String observacion) {
      this.observacion = observacion;
  }

  public String getObservacion() {
      return observacion;
  }
  
  public void setUrlRecibo(String urlRecibo) {
      this.urlRecibo = urlRecibo;
  }

  public String getUrlRecibo() {
      return urlRecibo;
  }
    
  public void setReciboServicio(ArrayList<ReciboServicio> reciboServicio) {
      this.reciboServicio = reciboServicio;
  }

  public ArrayList<ReciboServicio> getReciboServicio() {
      return reciboServicio;
  }
  
  public void setCodigoSolicitud(String codigoSolicitud) {
      this.codigoSolicitud = codigoSolicitud;
  }

  public String getCodigoSolicitud() {
      return codigoSolicitud;
  }

    public void setMetadatos(ArrayList<Propiedad> metadatos) {
        this.metadatos = metadatos;
    }

    public ArrayList<Propiedad> getMetadatos() {
        return metadatos;
    }
}
