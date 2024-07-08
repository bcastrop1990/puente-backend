package pe.gob.senasa.bean;

import java.io.Serializable;

public class ReciboServicio implements Serializable {
    
    String codigoRecibo;
    String codigoServicio;
    String nombreServicio;
    Double montoServicio;
    Double cantidad;
    
    public ReciboServicio() {

    }
  
    public void setCodigoRecibo(String codigoRecibo) {
        this.codigoRecibo = codigoRecibo;
    }
  
    public String getCodigoRecibo() {
        return codigoRecibo;
    }
  
    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }
  
    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setNombreServicio(String nombreServicio) {
      this.nombreServicio = nombreServicio;
    }
  
    public String getNombreServicio() {
      return nombreServicio;
    }
    
    public void setMontoServicio(Double montoServicio) {
        this.montoServicio = montoServicio;
    }
  
    public Double getMontoServicio() {
        return montoServicio;
    }
    
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
  
    public Double getCantidad() {
        return cantidad;
    }
      
    
}
