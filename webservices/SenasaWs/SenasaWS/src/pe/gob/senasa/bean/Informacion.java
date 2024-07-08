package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;


public class Informacion implements Serializable {
    
    //private Dato[] listaDatosRemplazar;
    
  ArrayList<Dato> listaDatosRemplazar = new ArrayList<Dato>();
  
    //private Dato[] listaDatosTablas;
    ArrayList<Dato> listaDatosTablas= new ArrayList<Dato>();
      
    ArrayList<Propiedad> metadatos = new ArrayList<Propiedad>();
    //Adiciionado por Ivan Cajahuaringa 01/11/2011
    Dato listaDatosRequisitos = new Dato();
    
    public Informacion() {
        super();
    }

    public void setListaDatosRemplazar(ArrayList<Dato> listaDatosRemplazar) {
        this.listaDatosRemplazar = listaDatosRemplazar;
    }

    public ArrayList<Dato> getListaDatosRemplazar() {
        return listaDatosRemplazar;
    }

    public void setListaDatosTablas(ArrayList<Dato> listaDatosTablas) {
        this.listaDatosTablas = listaDatosTablas;
    }

    public ArrayList<Dato> getListaDatosTablas() {
        return listaDatosTablas;
    }

    public void setMetadatos(ArrayList<Propiedad> metadatos) {
        this.metadatos = metadatos;
    }

    public ArrayList<Propiedad> getMetadatos() {
        return metadatos;
    }

    //Adicionado por Ivan Cajahuaringa 01//11/2011
    public void setListaDatosRequisitos(Dato listaDatosRequisitos) {
        this.listaDatosRequisitos = listaDatosRequisitos;
    }

    public Dato getListaDatosRequisitos() {
        return listaDatosRequisitos;
    }
}
