package pe.gob.senasa.vuce.integrador.gestion;



import pe.gob.senasa.vuce.integrador.ExtractorMensajeVUCE;
import pe.gob.senasa.vuce.integrador.IntegradorConfig;
import pe.gob.senasa.vuce.integrador.IntegradorController;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;
import pe.gob.senasa.vuce.integrador.helper.XmlHelper;
import pe.gob.senasa.vucews.consumer.VuceWSConsumer;

public class GestionBase {
	private VuceWSConsumer vuceWSConsumer = null;
	private IntegradorController controller = null;
	private ExtractorMensajeVUCE extractor = null;
	private XmlHelper xmlHelper = null;
	
	public IntegradorController getController() {
		if (controller == null)
			controller = new IntegradorController();
		return controller;
	}

	public ExtractorMensajeVUCE getExtractor() {
		if (extractor == null) {
			extractor = new ExtractorMensajeVUCE();
			extractor.setTempFolder(IntegradorConfig.getInstance().getCarpetaTemporal());
			extractor.setShowOuput(true);
		}
		return extractor;
	}

	public XmlHelper getXmlHelper() {
		if (xmlHelper == null)
			xmlHelper = new XmlHelper();
		return xmlHelper;
	}

	protected VuceWSConsumer getVuceWSConsumer() {
		if (vuceWSConsumer == null)
			vuceWSConsumer = new VuceWSConsumer();
		return vuceWSConsumer;
	}
	
	public void confirmar(int id, String error) {
		boolean confirmado = false;
		int intentos = 0;
		do {
			intentos++;
			if (IntegradorConfig.getInstance().isConfirmarMensajes()) {
				if (error == null || error.isEmpty())
					confirmado = getVuceWSConsumer().confirmarRecepcionMensaje(id);
				else
					confirmado = getVuceWSConsumer().confirmarRecepcionMensaje(id, error);
			}

			if (confirmado)
				LogHelper.info("Confirmar: ID=" + id + " ERROR=" + error);
			else {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ex) {
					LogHelper.obtenerLogCompleto("confirmar", ex);
				}
			}
		} while (!confirmado && intentos < 10);
	}
}
