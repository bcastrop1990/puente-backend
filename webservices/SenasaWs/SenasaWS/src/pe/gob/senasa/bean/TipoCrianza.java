package pe.gob.senasa.bean;

import java.io.Serializable;

public class TipoCrianza implements Serializable {
    
    private String idTipoCrianza;
    
    private String descripcionTipoCrianza;
    
    public TipoCrianza() {
        super();
    }

    public TipoCrianza(String idTipoCrianza, String descripcionTipoCrianza) {
        super();
        this.idTipoCrianza = idTipoCrianza;
        this.descripcionTipoCrianza = descripcionTipoCrianza;
    }

    public void setIdTipoCrianza(String idTipoCrianza) {
        this.idTipoCrianza = idTipoCrianza;
    }

    public String getIdTipoCrianza() {
        return idTipoCrianza;
    }

    public void setDescripcionTipoCrianza(String descripcionTipoCrianza) {
        this.descripcionTipoCrianza = descripcionTipoCrianza;
    }

    public String getDescripcionTipoCrianza() {
        return descripcionTipoCrianza;
    }
    
}
