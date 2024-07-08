package pe.gob.senasa.bean;

import java.io.Serializable;

public class PersonaDocumento implements Serializable {
    public PersonaDocumento() {
        super();
    }
  private String  idPersona;
  private String  dniRuc;
  private String  codigoDocumento;
  private String  numeroDocumento;
  private String  tramaProductos;
  private long  resultado;


  public void setDniRuc(String dniRuc) {
      this.dniRuc = dniRuc;
  }

  public String getDniRuc() {
      return dniRuc;
  }

  public void setCodigoDocumento(String codigoDocumento) {
      this.codigoDocumento = codigoDocumento;
  }

  public String getCodigoDocumento() {
      return codigoDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento) {
      this.numeroDocumento = numeroDocumento;
  }

  public String getNumeroDocumento() {
      return numeroDocumento;
  }

  public void setTramaProductos(String tramaProductos) {
      this.tramaProductos = tramaProductos;
  }

  public String getTramaProductos() {
      return tramaProductos;
  }

  
  public void setIdPersona(String idPersona) {
      this.idPersona = idPersona;
  }

  public String getIdPersona() {
      return idPersona;
  }

  public void setResultado(long resultado) {
      this.resultado = resultado;
  }

  public long getResultado() {
      return resultado;
  }
}
