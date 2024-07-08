package pe.gob.senasa.bean;

import java.io.Serializable;

public class SolicitudLugarProduccion implements Serializable {
    public SolicitudLugarProduccion() {
        super();
    }
    
    private String codiSoliLug;
    private String codiProdMos;
    private String nomProductor;
    private String codiPredMos;
    private String nomPredio;
    private String codiSedeSed;
    private String codiSedeSol;
    private String cCodExp;
    private String cCodCli;

    public void setCodiSoliLug(String codiSoliLug) {
        this.codiSoliLug = codiSoliLug;
    }

    public String getCodiSoliLug() {
        return codiSoliLug;
    }

    public void setCodiProdMos(String codiProdMos) {
        this.codiProdMos = codiProdMos;
    }

    public String getCodiProdMos() {
        return codiProdMos;
    }

    public void setNomProductor(String nomProductor) {
        this.nomProductor = nomProductor;
    }

    public String getNomProductor() {
        return nomProductor;
    }

    public void setCodiPredMos(String codiPredMos) {
        this.codiPredMos = codiPredMos;
    }

    public String getCodiPredMos() {
        return codiPredMos;
    }

    public void setNomPredio(String nomPredio) {
        this.nomPredio = nomPredio;
    }

    public String getNomPredio() {
        return nomPredio;
    }

    public void setCodiSedeSed(String codiSedeSed) {
        this.codiSedeSed = codiSedeSed;
    }

    public String getCodiSedeSed() {
        return codiSedeSed;
    }

    public void setCodiSedeSol(String codiSedeSol) {
        this.codiSedeSol = codiSedeSol;
    }

    public String getCodiSedeSol() {
        return codiSedeSol;
    }

    public void setCCodExp(String cCodExp) {
        this.cCodExp = cCodExp;
    }

    public String getCCodExp() {
        return cCodExp;
    }

    public void setCCodCli(String cCodCli) {
        this.cCodCli = cCodCli;
    }

    public String getCCodCli() {
        return cCodCli;
    }
}
