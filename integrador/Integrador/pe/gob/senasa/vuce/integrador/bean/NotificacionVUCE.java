package pe.gob.senasa.vuce.integrador.bean;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



import pe.gob.senasa.ucm.ClienteUCM;
import pe.gob.senasa.vuce.integrador.helper.ByteHelper;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;

public class NotificacionVUCE {
	private BigDecimal id;
	private String tipoMensaje;
	private byte[] xml;
	private byte[] ebXml;
	private String ucmIdXml;
	private List<Archivo> adjuntos;
	private List<AdjuntoVuce> adjuntosEntrada;
	
	public BigDecimal getId() {
		return id;
	}
	
	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}
	
	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	
	public byte[] getXml() {
		return xml;
	}
	
	public void setXml(byte[] xml) {
		this.xml = xml;
	}
	
	public byte[] getEbXml() {
		return ebXml;
	}
	
	public void setEbXml(byte[] ebXml) {
		this.ebXml = ebXml;
	}
	
	public List<Archivo> getAdjuntos() {
		if (adjuntos==null)
			adjuntos = new ArrayList<Archivo>();
		return adjuntos;
	}
	
	public void setAdjuntos(String nombreAdjunto, byte[] adjunto, String ucmId) {
		this.getAdjuntos().add(new Archivo(nombreAdjunto, adjunto, ucmId));
	}
	
	public List<AdjuntoVuce> getAdjuntosEntrada() {
		if (adjuntosEntrada==null)
			adjuntosEntrada = new ArrayList<AdjuntoVuce>();
		return adjuntosEntrada;
	}
	
	public void setAdjuntosEntrada(Double idAdjunto, String nombreAdjunto, byte[] adjunto, String ucmId) {
		this.getAdjuntosEntrada().add(new AdjuntoVuce(idAdjunto, nombreAdjunto, adjunto, ucmId));
	}
	
	public void verificarContenidoNotificacion()
	{
		LogHelper.info("NOTIFICACION: ID="+getId().intValue());
		LogHelper.info("XML (" + getXml().length + "b)");
		LogHelper.info(new String(getXml()));
		if (getEbXml() != null && getEbXml().length != 0)
			LogHelper.info("EBXML (" + getEbXml().length + "b)");
		else if (getUcmIdXml() != null && !getUcmIdXml().isEmpty()) {
			InputStream stream;
			try {
				stream = ClienteUCM.getInstance().obtenerDocumento(getUcmIdXml()).getInputStream();
				try {
					setEbXml(ByteHelper.streamToBytes(stream));
				} catch (IOException e) {
					setEbXml(null);
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			LogHelper.info("EBXML (" + getEbXml().length + "b) - UCM (" + getUcmIdXml() + "): ");
		}			
		for(Archivo a : getAdjuntos())
		{
			if ((a.getArchivo() == null || a.getArchivo().length == 0) && a.getUcmID() != null && !a.getUcmID().isEmpty())
			{
				InputStream stream;
				try {
					stream = ClienteUCM.getInstance().obtenerDocumento(a.getUcmID()).getInputStream();
					a.setArchivo(stream);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}	
			LogHelper.info("ADJUNTO (" + a.getArchivo().length + "b) - UCM (" + a.getUcmID() + "): " + a.getNombre() + "");
		}
	}

	public String getUcmIdXml() {
		return ucmIdXml;
	}

	public void setUcmIdXml(String ucmIdXml) {
		this.ucmIdXml = ucmIdXml;
	}
}
