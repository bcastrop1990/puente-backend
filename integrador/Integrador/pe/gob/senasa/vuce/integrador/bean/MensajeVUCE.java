package pe.gob.senasa.vuce.integrador.bean;

import java.util.ArrayList;
import java.util.List;

public class MensajeVUCE {

	private String xmlTransaccion = null;
	private TransaccionVuce transaccion = null;;
	private String ebXmlTransaccion = null;
	private List<AdjuntoVuce> adjuntos = null;
	private String tempFolder = null;
	
	public MensajeVUCE() {	}
	
	public boolean hasAdjuntos()
	{
		return (this.adjuntos != null && this.adjuntos.size() != 0);
	}

	public List<AdjuntoVuce> getAdjuntos() {
		if ( adjuntos == null )
			adjuntos = new ArrayList<AdjuntoVuce>();
		return adjuntos;
	}

	public void setAdjuntos(List<AdjuntoVuce> adjuntos) {
		this.adjuntos = adjuntos;
	}
	
	public boolean hasEbXML()
	{
		return (this.getEbXmlTransaccion() !=null && this.getEbXmlTransaccion().trim().length()!=0);
	}

	public String getEbXmlTransaccion() {
		return ebXmlTransaccion;
	}

	public void setEbXmlTransaccion(String ebXmlTransaccion) {
		this.ebXmlTransaccion = ebXmlTransaccion;
	}

	public TransaccionVuce getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(TransaccionVuce transaccion) {
		this.transaccion = transaccion;
	}

	public String getXmlTransaccion() {
		return xmlTransaccion;
	}

	public void setXmlTransaccion(String xmlTransaccion) {
		this.xmlTransaccion = xmlTransaccion;
	}
	
	public String getTempFolder() {
		return tempFolder;
	}

	public void setTempFolder(String tempFolder) {
		this.tempFolder = tempFolder;
	}

	public void setIdDocumentoOnElements() {
		for(AdjuntoVuce adjunto : this.getAdjuntos())
		{
			adjunto.setIdDocumento(this.getTransaccion().getIdRegistroDocumento());
			adjunto.setRequisito("318");
		}
	}
}
