package pe.gob.senasa.bean;

import java.io.Serializable;

public class ReqImpProducto implements Serializable {
    public ReqImpProducto() {
        super();
    }
    
    private String codigo;
    private String mensaje;
    
    public void setCodigo(String codigo) {
        this.codigo= codigo;
    }
  
    public String getCodigo() {
        return codigo;
    }
    public void setMensaje(String mensaje) {
        this.mensaje= mensaje;
    }
  
    public String getMensaje() {
        return mensaje;
    }
    
    
}
