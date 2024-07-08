package pe.gob.senasa.bean;

import java.io.Serializable;


public class ServicioPago implements Serializable {
    
    private String codigoServicio;
    private String nombreServicio;
    private Double cantidadServicio;
    private String tipoServicio;
    private String nombreTipoServicio;
    private Double montoAPagar;
    
    public ServicioPago() {
        super();
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
   
  public void setCantidadServicio(Double cantidadServicio) {
      this.cantidadServicio = cantidadServicio;
  }
  
  public Double getCantidadServicio() {
      return cantidadServicio;
  }
  
  public void setTipoServicio(String tipoServicio) {
      this.tipoServicio = tipoServicio;
  }
  
  public String getTipoServicio() {
      return tipoServicio;
  }

  public void setNombreTipoServicio(String nombreTipoServicio) {
      this.nombreTipoServicio = nombreTipoServicio;
  }
  
  public String getNombreTipoServicio() {
      return nombreTipoServicio;
  }
  
  public void setMontoAPagar(Double montoAPagar) {
      this.montoAPagar = montoAPagar;
  }
  
  public Double getMontoAPagar() {
      return montoAPagar;
  }
    
  
  
    
}
