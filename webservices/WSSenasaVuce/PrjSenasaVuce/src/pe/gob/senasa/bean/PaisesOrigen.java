package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.List;


public class PaisesOrigen implements Serializable{
    public PaisesOrigen() {
        super();
    }
    private List<Pais> listaPaisesOrigen;

    public void setListaPaisesOrigen(List<Pais> listaPaisesOrigen) {
        this.listaPaisesOrigen = listaPaisesOrigen;
    }

    public List<Pais> getListaPaisesOrigen() {
        return listaPaisesOrigen;
    }
}
