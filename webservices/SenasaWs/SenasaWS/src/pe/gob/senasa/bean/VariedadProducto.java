package pe.gob.senasa.bean;

import java.io.Serializable;

public class VariedadProducto implements Serializable {
    
    private String codHosp;
    private String codCult;
    private String nombreVariedad;
    private String descripcionVariedad;
  
    public VariedadProducto() {
        super();
    }
    
  public void setCodHosp(String codHosp) {
      this.codHosp = codHosp;
  }

  public String getCodHosp() {
      return codHosp;
  }

  public void setCodCult(String codCult) {
      this.codCult = codCult;
  }

  public String getCodCult() {
      return codCult;
  }
  
  public void setNombreVariedad(String nombreVariedad) {
      this.nombreVariedad = nombreVariedad;
  }

  public String getNombreVariedad() {
      return nombreVariedad;
  }

  public void setDescripcionVariedad(String descripcionVariedad) {
      this.descripcionVariedad = descripcionVariedad;
  }

  public String getDescripcionVariedad() {
      return descripcionVariedad;
  }

    
}
