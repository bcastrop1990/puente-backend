package pe.gob.senasa.bean;

public class ReciboPago {
    
    String valorPagado;
    String valorSaldo;
    String numeroExpediente;
    String numeroRecibo;
    String fechaHora;
    String sedeSenasa;


    public void setValorPagado(String valorPagado) {
        this.valorPagado = valorPagado;
    }

    public String getValorPagado() {
        return valorPagado;
    }

    public void setValorSaldo(String valorSaldo) {
      this.valorSaldo = valorSaldo;
    }

    public String getValorSaldo() {
      return valorSaldo;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getSedeSenasa() {
        return sedeSenasa;
    }

    public void setSedeSenasa(String sedeSenasa) {
        this.sedeSenasa = sedeSenasa;
    }
}
