package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;


public class ExpedienteTratamiento implements Serializable {


    private static final long serialVersionUID = 5730370538890461115L;
    
    private ArrayList<TratamientoInspeccion> lista;
    
    public ExpedienteTratamiento() {
        super();
    }

    public void setLista(ArrayList<TratamientoInspeccion> lista) {
        this.lista = lista;
    }

    public ArrayList<TratamientoInspeccion> getLista() {
        return lista;
    }
}
