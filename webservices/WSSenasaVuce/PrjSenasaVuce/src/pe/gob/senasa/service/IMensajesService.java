package pe.gob.senasa.service;

import javax.jws.WebParam;

import pe.gob.senasa.bean.ServicioPagos;

public interface IMensajesService {
  public Boolean notificarMensaje(String txId,String codExpediente,String tipoNotif, String texto,Boolean updateDocumento);
  public Boolean notificarMensajePagoSuce(String txId,String codExpediente, String tipoNotif,
                                      String texto,Boolean updateDocumento, ServicioPagos servicioPagos);
  public String recepcionResultadoPagoSuce(String txId,String codExpediente);
  public void notificarMensajeReqPagoSuce(String codigoExpediente, String texto, double tasa);
  public void notificarProgramacionInspeccion(String txId,String tipodocumento,String orden,double tasa,String doctiporef,String docnumeref,String textovalor);
  
}
