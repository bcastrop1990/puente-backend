package pe.gob.senasa.bean;

public class SubArea extends Area {
    private String codigoPadre = "";

    public void setCodigoPadre(String code) {
        this.codigoPadre = code;
    }

    public String getCodigoPadre() {
        return codigoPadre;
    }
}
