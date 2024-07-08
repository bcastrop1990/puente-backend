package pe.gob.senasa.vuce.integrador.gestion;

import java.util.List;



import pe.gob.senasa.vuce.integrador.IntegradorConfig;
import pe.gob.senasa.vuce.integrador.bean.MensajeVUCE;
import pe.gob.senasa.vuce.integrador.exception.IntegradorException;
import pe.gob.senasa.vuce.integrador.helper.ByteHelper;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;

public class GestionRecepcionarMensaje extends GestionBase {
	public void recepcionar() {
		LogHelper.info("Extrayendo transacciones pendientes VUCE.");
		List<byte[]> mensajesPendiente = getVuceWSConsumer().obtenerTransaccionesPendientes();
		if (mensajesPendiente != null)
			procesarLista(mensajesPendiente);
		LogHelper.info("Fin de proceso del integrador.");
	}
	
	public void recepcionar(int limite, List<String> tipoTransacciones) {
		LogHelper.info("Extrayendo transacciones pendientes VUCE.");
		List<byte[]> mensajesPendiente = getVuceWSConsumer().obtenerTransaccionesPendientes(limite, tipoTransacciones);
		if (mensajesPendiente != null)
			procesarLista(mensajesPendiente);
		LogHelper.info("Fin de proceso del integrador.");
	}

	public void procesarLista(List<byte[]> mensajesPendiente) {
		LogHelper.info("Procesando " + mensajesPendiente.size() + " transacciones VUCE.");
		try {
			getExtractor().setInfoArchivosZip(ByteHelper.saveTempListFile(mensajesPendiente));
			if (getExtractor().getInfoArchivosZip().size() > 0) {
				for (String infoTransaccionZip : getExtractor().getInfoArchivosZip()) {
					procesar(infoTransaccionZip);
				}
			}
			if (IntegradorConfig.getInstance().isEliminarMensajes())
			{
				ByteHelper.deleteFilesOlderThanNdays(15);
			}
		} catch (IntegradorException ex) {
			LogHelper.obtenerLogCompleto("Error al procesar ZIP de mensajes", ex);
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto("Error desconocido al procesar mensajes", ex);
		}
		LogHelper.info("Termino de procesar mensajes VUCE.");
	}

	public void procesar(String infoTransaccionZip) {
		boolean error = false;
		MensajeVUCE mensaje = new MensajeVUCE();
		try {
			getExtractor().cargarTransaccionZip(infoTransaccionZip, mensaje);
			getXmlHelper().parseXmlTransaccionVuce(mensaje);
			if (IntegradorConfig.getInstance().isRegistrarMensajes())
				getController().registrarMensajeVuce(mensaje);
		} catch (IntegradorException pxe) {
			LogHelper.obtenerLogCompleto("Error al procesar mensajes", pxe);
			error = true;
		} catch (Exception e) {
			confirmar(mensaje.getTransaccion().getIdTransaccion().intValue(), "ERROR");
			LogHelper.obtenerLogCompleto("Error al procesar mensajes. " + e.getMessage(), e);
			error = true;
		} finally {
			if (!error && IntegradorConfig.getInstance().isConfirmarMensajes()) {
				confirmar(mensaje.getTransaccion().getIdTransaccion().intValue(), null);
			}
			getExtractor().EliminarArchivo(infoTransaccionZip);
		}

	}
}
