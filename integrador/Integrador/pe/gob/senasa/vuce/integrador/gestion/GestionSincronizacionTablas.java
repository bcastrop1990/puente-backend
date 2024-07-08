package pe.gob.senasa.vuce.integrador.gestion;

import java.util.ArrayList;
import java.util.List;

import pe.gob.senasa.vuce.integrador.ExtractorBase;
import pe.gob.senasa.vuce.integrador.bean.SincronizacionVUCE;
import pe.gob.senasa.vuce.integrador.exception.IntegradorException;
import pe.gob.senasa.vuce.integrador.mappers.OperationResult;
import pe.gob.senasa.vuce.integrador.mappers.SincronizacionMapper;
import pe.gob.senasa.vuce.integrador.helper.XmlHelper;
import pe.gob.senasa.vuce.integrador.helper.ZipHelper;

public class GestionSincronizacionTablas extends GestionBase {
	private ExtractorBase extractor = null;
	private SincronizacionMapper mapper = null;
	private XmlHelper xmlHelper = null;
	
	public GestionSincronizacionTablas()
	{
		this.extractor = new ExtractorBase();
		this.extractor.setShowOuput(true);
		this.mapper = new SincronizacionMapper();
		this.xmlHelper = new XmlHelper();
	}
	
	public void Sincronizar()
	{
		mapper.sincronizar();
		EnviarMensajes();
	}
	
	public void EnviarMensajes()
	{
		SincronizacionVUCE sinc = new SincronizacionVUCE();
		while (mapper.obtenerMensajePendiente(sinc) == OperationResult.Success) {
			byte[] tablasZip = null;
			tablasZip = ZipHelper.ZipToByteArray(sinc.getArchivos());
			if (tablasZip != null)
			{
				sinc.setIdVuce(getVuceWSConsumer().sincronizarTablas(sinc.getResumen(), tablasZip));
				mapper.actualizarMensajeEnviado(sinc);
			}
		}
	}
	
	public void ObtenerResultado()
	{
		List<SincronizacionVUCE> mensajes = new ArrayList<SincronizacionVUCE>();
		if (mapper.obtenerMensajesSinResultado(mensajes) == OperationResult.Success)
		{
			for (SincronizacionVUCE sinc : mensajes) {
				byte[] resultado = getVuceWSConsumer().obtenerResultadoSincronizacionTablas(sinc.getIdVuce());
				sinc.setResultado(resultado);
				try {
					xmlHelper.parseXmlResultadoSincronizacionTablas(sinc);
					mapper.actualizarMensajeLog(sinc);
				} catch (IntegradorException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void ReintentarSincronizacion(int id)
	{
		
	}
}
