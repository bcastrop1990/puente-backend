package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;


public class ServicioPagos implements  Serializable{
    
    ArrayList<ServicioPago> listaServicioPago = new  ArrayList<ServicioPago>();
  
    public ServicioPagos() {
        super();
    }
    
  public void setListaServicioPago(ArrayList<ServicioPago> listaServicioPago) {
      this.listaServicioPago = listaServicioPago;
  }

  public ArrayList<ServicioPago> getListaServicioPago() {
      return listaServicioPago;
  }
  
    
}
