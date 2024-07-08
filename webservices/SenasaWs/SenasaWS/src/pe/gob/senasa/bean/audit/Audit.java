package pe.gob.senasa.bean.audit;

public class Audit {

    private boolean estado = true;
    private String mensajeUsuario;
    private String mensajeSistema;

    public Audit() {
        super();
        estado = true;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setMensajeUsuario(String mensajeUsuario) {
        this.mensajeUsuario = mensajeUsuario;
    }

    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    public void setMensajeSistema(String mensajeSistema) {
        this.mensajeSistema = mensajeSistema;
    }

    public String getMensajeSistema() {
        return mensajeSistema;
    }
}
