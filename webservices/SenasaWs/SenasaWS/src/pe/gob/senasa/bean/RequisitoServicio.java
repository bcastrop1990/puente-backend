package pe.gob.senasa.bean;

import java.io.Serializable;


public class RequisitoServicio implements Serializable {
    
  private String codigoServicio="";
  private String descripcionServicio= "";
  private String codigoDocumento = "";
  private String descripcionDocumento= "";
  private String indObligatorio = "";
  private String subTipo;
  private String rutaCheckIn;
  private Adicional adicional;
  private String indPredio;
   // private Adicional[] adicional;
 private RequisitoAdicional requisitoAdicional;
 

 
  
  public RequisitoServicio() {
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

  public void setCodigoDocumento(String codigoDocumento) {
      this.codigoDocumento = codigoDocumento;
  }

  public String getCodigoDocumento() {
      return codigoDocumento;
  }
  
  public void setDescripcionDocumento(String descripcionDocumento) {
      this.descripcionDocumento = descripcionDocumento;
  }

  public String getDescripcionDocumento() {
      return descripcionDocumento;
  }
  
  public void setIndObligatorio(String indObligatorio) {
      this.indObligatorio = indObligatorio;
  }

  public String getIndObligatorio() {
      return indObligatorio;
  }
  public void setSubTipo(String subTipo) {
      this.subTipo = subTipo;
  }

  public String getSubTipo() {
      return subTipo;
  }
  public void setRutaCheckIn(String rutaCheckIn) {
      this.rutaCheckIn = rutaCheckIn;
  }

  public String getRutaCheckIn() {
      return rutaCheckIn;
  }
  
 /* public void setAdicional(Adicional[] adicional) {
      this.adicional = adicional;
  }

  public Adicional[] getAdicional() {
      return adicional;
  }*/
  

  public void setRequisitoAdicional(RequisitoAdicional requisitoAdicional) {
       this.requisitoAdicional = requisitoAdicional;
   }

   public RequisitoAdicional getRequisitoAdicional() {
       return requisitoAdicional;
   }

  public void setIndPredio(String indPredio) {
      this.indPredio = indPredio;
  }

  public String getIndPredio() {
      return indPredio;
  }
  
}


