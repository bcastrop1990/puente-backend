package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


public class ValidaDocumentoPropio implements Serializable   {
    public ValidaDocumentoPropio() {
        super();
    }
    
  private int resultadoWsResponse;
  private String descripcionWsResponse;
  private List<PersonaDocumento> listaNrosDoc = new ArrayList<PersonaDocumento>();

    public void setResultadoWsResponse(int resultadoWsResponse) {
        this.resultadoWsResponse = resultadoWsResponse;
    }

    public int getResultadoWsResponse() {
        return resultadoWsResponse;
    }

    public void setDescripcionWsResponse(String descripcionWsResponse) {
        this.descripcionWsResponse = descripcionWsResponse;
    }

    public String getDescripcionWsResponse() {
        return descripcionWsResponse;
    }

    public void setListaNrosDoc(List<PersonaDocumento> listaNrosDoc) {
        this.listaNrosDoc = listaNrosDoc;
    }

    public List<PersonaDocumento> getListaNrosDoc() {
        return listaNrosDoc;
    }
}

