package pe.gob.senasa.interfaces;

public interface VerificaCierreInterface {
  public String actualizaIndicadorBPM(String codigoSolicitud, String indicadorBPM, String userName);
  public String solicitudEnEspera(String codigoSolicitud);
}
