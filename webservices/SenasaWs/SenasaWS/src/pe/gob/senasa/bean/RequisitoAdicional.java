package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.List;


public class RequisitoAdicional implements Serializable {
    public RequisitoAdicional() {
        super();
    }
    
  private List<Adicional> lstAdicional;
  
  public void setLstAdicional(List<Adicional> lstAdicional) {
       this.lstAdicional = lstAdicional;
   }

   public List<Adicional> getLstAdicional() {
       return lstAdicional;
   }
   
}
