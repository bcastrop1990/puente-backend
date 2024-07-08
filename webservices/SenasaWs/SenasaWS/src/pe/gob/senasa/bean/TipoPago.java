package pe.gob.senasa.bean;

import java.io.Serializable;

public class TipoPago implements Serializable {
    
    private String codigoTipoPago;
    private String descripcionTipoPago;
                 
    public TipoPago() {
        super();
    }
    
    public void setCodigoTipoPago(String codigoTipoPago) {
        this.codigoTipoPago = codigoTipoPago;
    }
    
    public String getCodigoTipoPago() {
        return codigoTipoPago;
    }
    
    public void setDescripcionTipoPago(String descripcionTipoPago) {
        this.descripcionTipoPago = descripcionTipoPago;
    }
    
    public String getDescripcionTipoPago() {
        return descripcionTipoPago;
    }
  

}
