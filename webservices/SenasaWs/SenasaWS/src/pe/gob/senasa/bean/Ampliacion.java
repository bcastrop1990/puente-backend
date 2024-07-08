package pe.gob.senasa.bean;

import java.io.Serializable;

public class Ampliacion implements Serializable {
    
    private boolean ampliado;
    private String mensaje;

    public Ampliacion() {
        super();
    }

    public void setAmpliado(boolean ampliado) {
        this.ampliado = ampliado;
    }

    public boolean isAmpliado() {
        return ampliado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
