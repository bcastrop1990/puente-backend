package pe.gob.senasa.bean;

public class PaisOrigenIIV {
    public PaisOrigenIIV() {
        super();
    }
    private String  idPais;
    private String  idLugarProduccion;

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdLugarProduccion(String idLugarProduccion) {
        this.idLugarProduccion = idLugarProduccion;
    }

    public String getIdLugarProduccion() {
        return idLugarProduccion;
    }
}
