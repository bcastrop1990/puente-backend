package pe.gob.senasa.vuce.integrador.bean;

import java.io.*;

public class AdjuntoVuce extends Archivo {

	private Double idAdjunto = null;
	private Double idDocumento = null;
	private String requisito = null;
	private boolean validPath = false;
	
	public boolean isValidPath() {
		return validPath;
	}

	public void setValidPath(boolean validPath) {
		this.validPath = validPath;
	}

	public AdjuntoVuce() {	
		super();
	}

	public AdjuntoVuce(String nombre, byte[] archivo, String ucmId) {
		super(nombre, archivo, ucmId);
		if ( archivo!= null && archivo.length <= 500) {
			try {
				setValidPath((new File(new String(archivo))).exists());
			} catch (Exception ex) {
				setValidPath(false);
			}
		}
		else
			setValidPath(false);
	}
	
	public AdjuntoVuce(Double idAdjunto, String nombre, byte[] archivo, String ucmId) {
		super(nombre, archivo, ucmId);
		this.idAdjunto = idAdjunto;
	}

	public String getRequisito() {
		return requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public Double getIdAdjunto() {
		return idAdjunto;
	}

	public void setIdAdjunto(Double idAdjunto) {
		this.idAdjunto = idAdjunto;
	}
	
	public Double getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Double idDocumento) {
		this.idDocumento = idDocumento;
	}
}
