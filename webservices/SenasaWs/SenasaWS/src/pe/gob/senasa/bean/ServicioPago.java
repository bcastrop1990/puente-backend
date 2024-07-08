package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;


public class ServicioPago implements Serializable {
    
    private String codigoServicio;
    private String nombreServicio;
    private Double cantidadServicio;
    private String tipoServicio;
    private String nombreTipoServicio;
    private Double montoAPagar;
    ArrayList<ConceptoPago> listaProductos = new  ArrayList<ConceptoPago>();
    ArrayList<ConceptoPago> listaAnalisis = new  ArrayList<ConceptoPago>();
    ArrayList<ConceptoPago> listaVacunas = new  ArrayList<ConceptoPago>();
  
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
    
  public void setListaProductos(ArrayList<ConceptoPago> listaProductos) {
      this.listaProductos = listaProductos;
  }

  public ArrayList<ConceptoPago> getListaProductos() {
      return listaProductos;
  }  
  
  public void setListaAnalisis(ArrayList<ConceptoPago> listaAnalisis) {
      this.listaAnalisis = listaAnalisis;
  }

  public ArrayList<ConceptoPago> getListaAnalisis() {
      return listaAnalisis;
  } 
  
  public void setListaVacunas(ArrayList<ConceptoPago> listaVacunas) {
      this.listaVacunas = listaVacunas;
  }

  public ArrayList<ConceptoPago> getListaVacunas() {
      return listaVacunas;
  }
  
  
    
}
