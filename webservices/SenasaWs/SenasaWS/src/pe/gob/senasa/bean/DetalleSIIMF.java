package pe.gob.senasa.bean;

import java.io.Serializable;

public class DetalleSIIMF implements Serializable {
    
    private static final long serialVersionUID = 8105062613028161779L;
    
    private String  codigoProducto;
    private String  cantEnvaPla;
    private String  pesoEnvaPla;
    private String  unidadMedida;

    public DetalleSIIMF() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCantEnvaPla(String cantEnvaPla) {
        this.cantEnvaPla = cantEnvaPla;
    }

    public String getCantEnvaPla() {
        return cantEnvaPla;
    }

    public void setPesoEnvaPla(String pesoEnvaPla) {
        this.pesoEnvaPla = pesoEnvaPla;
    }

    public String getPesoEnvaPla() {
        return pesoEnvaPla;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }
}
