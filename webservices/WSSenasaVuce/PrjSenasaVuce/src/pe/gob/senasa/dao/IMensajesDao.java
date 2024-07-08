package pe.gob.senasa.dao;

import pe.gob.senasa.bean.ServicioPagos;

public interface IMensajesDao {
    
  //public Boolean aceptarOrden(String txId,String numero,String codFormato);
  //public Boolean aprobarSUCE(String txId,String numDa,String numSuce);
  public Boolean notificarMensaje(String txId,String codExpediente,String tipoNotif, String texto,Boolean updateDocumento);
  public Boolean notificarMensajePagoSuce(String txId,String codExpediente, String tipoNotif,
                                      String texto,Boolean updateDocumento, ServicioPagos servicioPagos);
  public String recepcionResultadoPagoSuce(String txId,String codExpediente);
  public void notificarMensajeReqPagoSuce(String codigoExpediente, String texto, double tasa);
  public void notificarProgramacionInspeccion(String txId, String tipodocumento,String orden, double tasa,String doctiporef,String docnumeref,String textovalor);
  
}
