package pe.gob.senasa.bean;

import java.io.Serializable;

public class Vacuna implements Serializable{
    
    private String codigoVacuna;
    private String descripcionVacuna;
      
    
    public Vacuna() {
        super();
    }
    
    public void setCodigoVacuna(String codigoVacuna) {
        this.codigoVacuna = codigoVacuna;
    }
    
    public String getCodigoVacuna() {
        return codigoVacuna;
    }
    
    public void setDescripcionVacuna(String descripcionVacuna) {
        this.descripcionVacuna = descripcionVacuna;
    }
    
    public String getDescripcionVacuna() {
        return descripcionVacuna;
    }
    
    
    
  
    
    
}
