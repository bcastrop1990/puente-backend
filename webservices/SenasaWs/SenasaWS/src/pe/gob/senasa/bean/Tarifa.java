package pe.gob.senasa.bean;

import java.io.Serializable;


public class Tarifa implements Serializable{
    
    
    String codigoProducto = null;
    String peso = null;
    String codigoServicio = null;
    
    public Tarifa()
    {
    }
    
    public Tarifa(String producto, String peso, String servicio){
      this.codigoProducto = producto;
      this.peso = peso;
      this.codigoServicio = servicio;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPeso() {
        return peso;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }
}