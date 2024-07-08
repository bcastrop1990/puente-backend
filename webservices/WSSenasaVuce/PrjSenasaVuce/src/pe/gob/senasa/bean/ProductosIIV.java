package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


public class ProductosIIV implements Serializable{
    public ProductosIIV() {
        super();
    }
    private List<ProductoIiv> listaProductos;
    
    public void setListaProductos(List<ProductoIiv> listaProductos) {
        this.listaProductos = listaProductos;
    }
    //Clase Type
    public List<ProductoIiv> getListaProductos() {
        if (listaProductos==null){
          listaProductos= new ArrayList<ProductoIiv>();
        }
        return this.listaProductos;
    }
}
