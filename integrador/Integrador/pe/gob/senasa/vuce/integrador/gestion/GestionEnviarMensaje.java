package pe.gob.senasa.vuce.integrador.gestion;

import pe.gob.senasa.vuce.integrador.bean.NotificacionVUCE;
import pe.gob.senasa.vuce.integrador.mappers.AdjuntoTransaccionMapper;
import pe.gob.senasa.vuce.integrador.mappers.NotificacionMapper;
import pe.gob.senasa.vuce.integrador.mappers.TransaccionMapper;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;
import pe.gob.senasa.vucews.consumer.VuceWSConsumer;

public class GestionEnviarMensaje extends GestionBase {
	public void enviarMensajesCola(String colaSufijo) {
		LogHelper.info("Procesando Mensajes de Cola SENASA-VUCE.");
		int n = 0;
		try {
			NotificacionMapper map = new NotificacionMapper();
			TransaccionMapper txMap = new TransaccionMapper();
			AdjuntoTransaccionMapper adj = new AdjuntoTransaccionMapper();
			NotificacionVUCE noti = new NotificacionVUCE();
			VuceWSConsumer consumer = new VuceWSConsumer();
			while (map.obtenerMensajes(noti,colaSufijo)) {
				byte[] adjuntos = null;
				byte[] ebXml = null;

				noti.verificarContenidoNotificacion();
				if (noti.getAdjuntos().size() > 0) {
					adjuntos = getExtractor().comprimirAdjuntosZip(noti.getId().toPlainString(), noti.getAdjuntos());
				}
				if (noti.getEbXml() != null) {
					ebXml = getExtractor().comprimirAdjuntoZip(noti.getId().toPlainString(), "ebXML", noti.getEbXml());
				}
				if (!consumer.enviarNotificaciones(noti.getXml(), ebXml, adjuntos)) {
					LogHelper.info("ERROR AL ENVIAR LA NOTIFICACION ID=" + noti.getId().intValue());
					map.encolarMensajeError(Double.valueOf(noti.getId().toString()));
				}
				if (noti.getAdjuntosEntrada().size() > 0) {
					adj.spRegistrarAdjuntoUCM(noti.getAdjuntosEntrada());
				}
				try {
					LogHelper.info("Iniciar procesar notificación. " + noti.getId().toString());
					txMap.fnProcesarNotificacion(noti.getId().toString());
					LogHelper.info("Finalizar procesar notificación." + noti.getId().toString());
				} catch (Exception e) {
					LogHelper.obtenerLogCompleto("Error al procesar mensaje SENASA-VUCE id=" + noti.getId().toString(),e);
				}
				n++;
			}
			if (n == 0)
				LogHelper.info("No hay mensajes pendientes.");
		} catch (Exception e) {
			LogHelper.obtenerLogCompleto("Error al procesar mensajes de cola SENASA-VUCE",e);
		}
		LogHelper.info("Termino de procesar mensajes de Cola SENASA-VUCE.");
	}
}
