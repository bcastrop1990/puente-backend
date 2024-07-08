package pe.gob.senasa.service.serviceImpl;

import pe.gob.senasa.bean.ServicioPagos;
import pe.gob.senasa.dao.IMensajesDao;
import pe.gob.senasa.dao.daoImpl.MensajesDao;
import pe.gob.senasa.service.IMensajesService;

public class MensajesService implements IMensajesService {
    IMensajesDao mensajesDao = null;

    public MensajesService() {
        super();
        mensajesDao = new MensajesDao();
    }

    public Boolean notificarMensaje(String txId, String codExpediente,
                                    String tipoNotif, String texto,
                                    Boolean updateDocumento) {

        return mensajesDao.notificarMensaje(txId, codExpediente, tipoNotif,
                                            texto, updateDocumento);
    }

    public Boolean notificarMensajePagoSuce(String txId, String codExpediente,
                                            String tipoNotif, String texto,
                                            Boolean updateDocumento,
                                            ServicioPagos servicioPagos) {
        return mensajesDao.notificarMensajePagoSuce(txId, codExpediente,
                                                    tipoNotif, texto,
                                                    updateDocumento,
                                                    servicioPagos);
    }

    public String recepcionResultadoPagoSuce(String txId,
                                             String codExpediente) {
        return mensajesDao.recepcionResultadoPagoSuce(txId, codExpediente);
    }

    public void notificarMensajeReqPagoSuce(String codigoExpediente,
                                            String texto, double tasa) {
        mensajesDao.notificarMensajeReqPagoSuce(codigoExpediente, texto, tasa);
    }

    public void notificarProgramacionInspeccion(String txId,
                                                   String tipodocumento,
                                                   String orden, double tasa,
                                                   String doctiporef,
                                                   String docnumeref,
                                                   String textovalor) {
        mensajesDao.notificarProgramacionInspeccion(txId, tipodocumento, orden, tasa, doctiporef, docnumeref, textovalor);
    }
}
