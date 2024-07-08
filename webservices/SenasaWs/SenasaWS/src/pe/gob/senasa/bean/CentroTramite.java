package pe.gob.senasa.bean;

import java.io.Serializable;

public class CentroTramite implements Serializable {
    private String codigoCentroTramite;
    private String centroTramite;
    private String direccion;

    public void setCodigoCentroTramite(String codigoCentroTramite) {
        this.codigoCentroTramite = codigoCentroTramite;
    }

    public String getCodigoCentroTramite() {
        return codigoCentroTramite;
    }

    public void setCentroTramite(String centroTramite) {
        this.centroTramite = centroTramite;
    }

    public String getCentroTramite() {
        return centroTramite;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
}
