package pe.gob.senasa.bean;

import java.io.Serializable;

public class RequisitosDocumentales implements Serializable {
    
    public RequisitosDocumentales() {
        super();
    }
    
    private String codigoDocumento;
    private String subTipo;
    private String tituloDocumento;
    private String rutaCheckIn;
    private String obligtorio;
    private String indicadorVuce;

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public String getSubTipo() {
        return subTipo;
    }

    public void setTituloDocumento(String tituloDocumento) {
        this.tituloDocumento = tituloDocumento;
    }

    public String getTituloDocumento() {
        return tituloDocumento;
    }

    public void setRutaCheckIn(String rutaCheckIn) {
        this.rutaCheckIn = rutaCheckIn;
    }

    public String getRutaCheckIn() {
        return rutaCheckIn;
    }

    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }
    
    public void setObligtorio(String obligtorio){
        this.obligtorio=obligtorio;
    }
    public String getObligtorio(){
        return this.obligtorio;
    }


    public void setIndicadorVuce(String indicadorVuce) {
        this.indicadorVuce = indicadorVuce;
    }

    public String getIndicadorVuce() {
        return indicadorVuce;
    }
}
