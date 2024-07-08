package pe.gob.senasa.bean;

import java.io.Serializable;

public class ResultadoAnalisisUCDSV implements Serializable{
    
    private String resultado;
    private byte[] pdf;
    
    public ResultadoAnalisisUCDSV() {
        super();
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public byte[] getPdf() {
        return pdf;
    }
}
