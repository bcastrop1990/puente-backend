package pe.gob.senasa.bean;

import java.io.Serializable;

public class Respuesta implements Serializable {
  
  private String statusCode;
  
  private String mensajeError;
    
    public Respuesta() {
        super();
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }
}
