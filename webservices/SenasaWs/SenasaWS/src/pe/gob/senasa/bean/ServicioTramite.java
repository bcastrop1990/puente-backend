package pe.gob.senasa.bean;

import java.io.Serializable;

public class ServicioTramite implements Serializable {
    
    public ServicioTramite() {
        super();
    }
    
  private String descripcionServicio="";
  private String codigoServicio="";
  private String descripcionCentroTramite= "";
  private String codigoCentroTramite = "";
  private String codigoClase = "";
  private String flagImpoExpo = "";
  
  public void setDescripcionServicio(String descripcionServicio) {
      this.descripcionServicio = descripcionServicio;
  }

  public String getDescripcionServicio() {
      return descripcionServicio;
  }

  public void setCodigoServicio(String codigoServicio) {
      this.codigoServicio = codigoServicio;
  }

  public String getCodigoServicio() {
      return codigoServicio;
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
  
  
}
