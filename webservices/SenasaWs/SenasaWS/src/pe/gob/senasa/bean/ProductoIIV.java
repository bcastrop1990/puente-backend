package pe.gob.senasa.bean;


public class ProductoIIV {
    public ProductoIIV() {
        super();
    }
    
  private String idProducto;
  private String usoDestino;
  private Double peso;
  private String idTipoEnvase;
  private String idUndMedida;
  private int cif;
  private int fob;
  private Double pesoAprob;
  private Double pesoRechazado;
  private int cantEnvase;
  private int cantPlanta;
  //p_Secuencial_Insp    IN NUMBER,


    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setUsoDestino(String usoDestino) {
        this.usoDestino = usoDestino;
    }

    public String getUsoDestino() {
        return usoDestino;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPeso() {
        return peso;
    }

    public void setIdTipoEnvase(String idTipoEnvase) {
        this.idTipoEnvase = idTipoEnvase;
    }

    public String getIdTipoEnvase() {
        return idTipoEnvase;
    }

    public void setIdUndMedida(String idUndMedida) {
        this.idUndMedida = idUndMedida;
    }

    public String getIdUndMedida() {
        return idUndMedida;
    }

    public void setCif(int cif) {
        this.cif = cif;
    }

    public int getCif() {
        return cif;
    }

    public void setFob(int fob) {
        this.fob = fob;
    }

    public int getFob() {
        return fob;
    }

    public void setPesoAprob(Double pesoAprob) {
        this.pesoAprob = pesoAprob;
    }

    public Double getPesoAprob() {
        return pesoAprob;
    }

    public void setPesoRechazado(Double pesoRechazado) {
        this.pesoRechazado = pesoRechazado;
    }

    public Double getPesoRechazado() {
        return pesoRechazado;
    }

    public void setCantEnvase(int cantEnvase) {
        this.cantEnvase = cantEnvase;
    }

    public int getCantEnvase() {
        return cantEnvase;
    }

    public void setCantPlanta(int cantPlanta) {
        this.cantPlanta = cantPlanta;
    }

    public int getCantPlanta() {
        return cantPlanta;
    }
}
