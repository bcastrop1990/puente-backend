package pe.gob.senasa.bean;

import java.io.Serializable;


public class ExpedienteServicio implements Serializable {
    
    private String codigoExpediente="";
    private String codigoClase = "";
  
    public ExpedienteServicio() {
        super();
    }
    
    public void setCodigoExpediente(String codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }
  
    public String getCodigoExpediente() {
        return codigoExpediente;
    }
    
    public void setCodigoClase(String codigoClase) {
        this.codigoClase = codigoClase;
    }
    
    public String getCodigoClase() {
        return codigoClase;
    }
    
}
