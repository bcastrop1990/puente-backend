package pe.gob.senasa.vuce.integrador.bean;

import java.util.ArrayList;
import java.util.List;

public class TransaccionVuce {

	private Double idTransaccion;
	private String tipoMensaje;
	private String formato;
	private Double idRegistroDocumento;
	private String notificaciones;
	private String error;
	private List<DocumentoVuce> documentoVuce;
	private List<DocumentoVuce> documentoReferencia;
	
	public TransaccionVuce()
	{
		documentoVuce = new ArrayList<DocumentoVuce>();
		documentoReferencia = new ArrayList<DocumentoVuce>();
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Double getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(Double idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public void addDocumento(DocumentoVuce documentoVuce)
	{
		this.documentoVuce.add(documentoVuce);
	}
	
	public void addDocumentoReferencia(DocumentoVuce documentoVuce)
	{
		this.documentoReferencia.add(documentoVuce);
	}
	
	public DocumentoVuce getDocumento()
	{
		return this.documentoVuce.get(0);
	}
	
	public DocumentoVuce getDocumentoReferencia()
	{
		return this.documentoReferencia.get(0);
	}
	
	public Double getIdRegistroDocumento() {
		return idRegistroDocumento;
	}

	public void setIdRegistroDocumento(Double idRegistroDocumento) {
		this.idRegistroDocumento = idRegistroDocumento;
	}
	
	public String getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(String notificaciones) {
		this.notificaciones = notificaciones;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String showInfo()
	{
		return "XML Transaccion: " +this.getIdTransaccion() + "/ TIPO: " + this.getTipoMensaje() +
				"/ FORMATO: " + this.getFormato() + "/ DOCUMENTO=> " + this.getDocumento().getTipo() +
				" - " + this.getDocumento().getNumero() + " - " + this.getDocumento().getMonto() +
				" - " + this.getDocumento().getFecha() +
				"/ DOC REFERENCIA=> " + this.getDocumentoReferencia().getTipo() +
				" - " + this.getDocumentoReferencia().getNumero();
	}
}
