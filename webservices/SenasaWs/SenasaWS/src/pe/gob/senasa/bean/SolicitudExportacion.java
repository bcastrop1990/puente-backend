package pe.gob.senasa.bean;

import java.io.Serializable;


public class SolicitudExportacion implements Serializable {

  private String codigoSolExpo;
  private String marcDistSol; 
  private String crazSoc; 
  private String direccionCliente;
  private String numeCertExp;
  private String razonSocial;
 

    public SolicitudExportacion() {
        super();
    }
    
  public void setCodigoSolExpo(String codigoSolExpo) {
      this.codigoSolExpo = codigoSolExpo;
  }
  public String getCodigoSolExpo() {
      return codigoSolExpo;
  }

  public void setMarcDistSol(String marcDistSol) {
      this.marcDistSol = marcDistSol;
  }

  public String getMarcDistSol() {
      return marcDistSol;
  }
  public void setCrazSoc(String crazSoc) {
      this.crazSoc = crazSoc;
  }

  public String getCrazSoc() {
      return crazSoc;
  }
  public void setDireccionCliente(String direccionCliente) {
      this.direccionCliente = direccionCliente;
  }

  public String getDireccionCliente() {
      return direccionCliente;
  }
  
  public void setNumeCertExp(String numeCertExp) {
      this.numeCertExp = numeCertExp;
  }

  public String getNumeCertExp() {
      return numeCertExp;
  }
  public void setRazonSocial(String razonSocial) {
      this.razonSocial = razonSocial;
  }

  public String getRazonSocial() {
      return razonSocial;
  } 

}
