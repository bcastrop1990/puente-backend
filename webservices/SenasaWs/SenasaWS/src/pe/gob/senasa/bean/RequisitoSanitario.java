package pe.gob.senasa.bean;

import java.io.Serializable;

public class RequisitoSanitario implements Serializable {
    
  String codigoRequisito;
  String descripcionRequisito;
  String orden;
  String sangria;
  String etiqueta;
  String clase;
  
    public RequisitoSanitario() {
        super();
    }

    public void setCodigoRequisito(String codigoRequisito) {
        this.codigoRequisito = codigoRequisito;
    }

    public String getCodigoRequisito() {
        return codigoRequisito;
    }

    public void setDescripcionRequisito(String descripcionRequisito) {
        this.descripcionRequisito = descripcionRequisito;
    }

    public String getDescripcionRequisito() {
        return descripcionRequisito;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getOrden() {
        return orden;
    }

    public void setSangria(String sangria) {
        this.sangria = sangria;
    }

    public String getSangria() {
        return sangria;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getClase() {
        return clase;
    }
}
