package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.List;


public class Dato implements Serializable {
    
    private String etiqueta;
    private String valor;
    //Ivan Cajahuaringa 01/11/2011
    private int anchoPagPixel;
    private List<RequisitoSanitario> listaRequisitos;
    private boolean cpe;
    //
    private String[][] listavaloresTabla;
    
    public Dato() {
        super();
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    /*public void setListavaloresTabla(String[][] listavaloresTabla) {
        this.listavaloresTabla = listavaloresTabla;
    }

    public String[][] getListavaloresTabla() {
        return listavaloresTabla;
    }*/
    
    //Adicionado por Ivan Cajahuaringa 01/11/2011
    public void setAnchoPagPixel(int anchoPagPixel) {
        this.anchoPagPixel = anchoPagPixel;
    }

    public int getAnchoPagPixel() {
        return anchoPagPixel;
    }

    public void setListaRequisitos(List<RequisitoSanitario> listaRequisitos) {
        this.listaRequisitos = listaRequisitos;
    }

    public List<RequisitoSanitario> getListaRequisitos() {
        return listaRequisitos;
    }


    public void setCpe(boolean cpe) {
        this.cpe = cpe;
    }

    public boolean isCpe() {
        return cpe;
    }
}
