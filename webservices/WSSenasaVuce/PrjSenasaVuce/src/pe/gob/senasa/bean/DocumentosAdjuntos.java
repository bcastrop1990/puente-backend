package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


public class DocumentosAdjuntos implements Serializable {

    public DocumentosAdjuntos() {
        super();
    }

    private List<AdjuntoDocumento> listaAdjuntos = null;

    public void setListaAdjuntos(List<AdjuntoDocumento> listaAdjuntos) {
        this.listaAdjuntos = listaAdjuntos;
    }

    public List<AdjuntoDocumento> getListaAdjuntos() {
        if (listaAdjuntos == null)
            listaAdjuntos = new ArrayList<AdjuntoDocumento>();
        return listaAdjuntos;
    }
}
