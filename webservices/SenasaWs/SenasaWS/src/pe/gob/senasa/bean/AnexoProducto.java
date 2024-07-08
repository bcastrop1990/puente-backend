package pe.gob.senasa.bean;

public class AnexoProducto extends Producto {
    
    
    private String codigoPadre;
    private String descPadre;
    private String nombreTecPadre;
    private String partidaAranPadre;
    
    
    
    public AnexoProducto() {
        super();
    }

    

    public void setCodigoPadre(String codigoPadre) {
        this.codigoPadre = codigoPadre;
    }

    public String getCodigoPadre() {
        return codigoPadre;
    }

    public void setDescPadre(String descPadre) {
        this.descPadre = descPadre;
    }

    public String getDescPadre() {
        return descPadre;
    }

    public void setNombreTecPadre(String nombreTecPadre) {
        this.nombreTecPadre = nombreTecPadre;
    }

    public String getNombreTecPadre() {
        return nombreTecPadre;
    }

    public void setPartidaAranPadre(String partidaAranPadre) {
        this.partidaAranPadre = partidaAranPadre;
    }

    public String getPartidaAranPadre() {
        return partidaAranPadre;
    }
}
