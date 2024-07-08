package pe.gob.senasa.bean;

import java.io.Serializable;

public class TipoDocIden implements Serializable {
    
    private String codigoTipoDoc;
    private String nombreTipoDoc;
    private int longitudTipoDoc;
    
    public TipoDocIden() {
        super();
    }

    public TipoDocIden(String codigoTipoDoc, String nombreTipoDoc,
                       int longitudTipoDoc) {
        super();
        this.codigoTipoDoc = codigoTipoDoc;
        this.nombreTipoDoc = nombreTipoDoc;
        this.longitudTipoDoc = longitudTipoDoc;
    }

    public void setCodigoTipoDoc(String codigoTipoDoc) {
        this.codigoTipoDoc = codigoTipoDoc;
    }

    public String getCodigoTipoDoc() {
        return codigoTipoDoc;
    }

    public void setNombreTipoDoc(String nombreTipoDoc) {
        this.nombreTipoDoc = nombreTipoDoc;
    }

    public String getNombreTipoDoc() {
        return nombreTipoDoc;
    }

    public void setLongitudTipoDoc(int longitudTipoDoc) {
        this.longitudTipoDoc = longitudTipoDoc;
    }

    public int getLongitudTipoDoc() {
        return longitudTipoDoc;
    }
}
