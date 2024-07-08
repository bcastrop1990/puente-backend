package pe.gob.senasa.bean;

import java.io.Serializable;

public class CertificadoPlantas implements Serializable {
    
  private static final long serialVersionUID = 1L;
  
  private String codigoExpediente;
  private String codigoServicio;
    
    public CertificadoPlantas() {
        super();
    }

    public void setCodigoExpediente(String codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }

    public String getCodigoExpediente() {
        return codigoExpediente;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }
}