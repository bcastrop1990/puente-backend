package pe.gob.senasa.bean;

import java.io.Serializable;

public class ServicioClase implements Serializable {
    
  private String codigoServicio="";
  private String descripcionServicio="";
  private String indCobroXProducto= "";
  private String indServicioSecundario = "";
  private String codigoClase = "";
  
    public ServicioClase() {
        super();
    }
    
  
  public void setCodigoServicio(String codigoServicio) {
      this.codigoServicio = codigoServicio;
  }

  public String getCodigoServicio() {
      return codigoServicio;
  }
  
  public void setDescripcionServicio(String descripcionServicio) {
      this.descripcionServicio = descripcionServicio;
  }

  public String getDescripcionServicio() {
      return descripcionServicio;
  }

  public void setIndCobroXProducto(String indCobroXProducto) {
      this.indCobroXProducto = indCobroXProducto;
  }

  public String getIndCobroXProducto() {
      return indCobroXProducto;
  }
  
  public void setIndServicioSecundario(String indServicioSecundario) {
      this.indServicioSecundario = indServicioSecundario;
  }

  public String getIndServicioSecundario() {
      return indServicioSecundario;
  }
  
  public void setCodigoClase(String codigoClase) {
      this.codigoClase = codigoClase;
  }

  public String getCodigoClase() {
      return codigoClase;
  }
  

}
