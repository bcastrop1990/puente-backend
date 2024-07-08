package pe.gob.senasa.bean;

import java.io.Serializable;

public class ConceptoPago implements Serializable {
    
    private String codigoConcepto;
    private Double cantidadPeso;
    private String unidadMedida;
    private Double montoAPagar;
    
    public ConceptoPago() {
        super();
    }
  
    public void setCodigoConcepto(String codigoConcepto) {
        this.codigoConcepto = codigoConcepto;
    }
  
    public String getCodigoConcepto() {
        return codigoConcepto;
    }
  
    public void setCantidadPeso(Double cantidadPeso) {
        this.cantidadPeso = cantidadPeso;
    }
  
    public Double getCantidadPeso() {
        return cantidadPeso;
    }
    
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
  
    public String getUnidadMedida() {
        return unidadMedida;
    }
  
    public void setMontoAPagar(Double montoAPagar) {
        this.montoAPagar = montoAPagar;
    }
  
    public Double getMontoAPagar() {
        return montoAPagar;
    }
  
    
}
