package pe.gob.senasa.vuce.integrador.bean;

public class LiquidacionVUCE {

	private Integer idTransmision = null;
	private String resumenFileName = null;
	private String detalleFileName = null;
	private String error = null;
	private byte[] resumen = null;
	private byte[] detalle = null;
	
	public LiquidacionVUCE() { }

	public Integer getIdTransmision() {
		return idTransmision;
	}

	public void setIdTransmision(Integer idTransmision) {
		this.idTransmision = idTransmision;
	}
	
	public String getResumenFileName() {
		return resumenFileName;
	}

	public void setResumenFileName(String resumenFileName) {
		this.resumenFileName = resumenFileName;
	}

	public String getResumenTexto() {
		return new String(resumen);
	}

	public String getDetalleFileName() {
		return detalleFileName;
	}

	public void setDetalleFileName(String detalleFileName) {
		this.detalleFileName = detalleFileName;
	}
	
	public String getDetalleTexto() {
		return new String(detalle);
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public byte[] getResumen() {
		return resumen;
	}

	public void setResumen(byte[] resumen) {
		this.resumen = resumen;
	}

	public byte[] getDetalle() {
		return detalle;
	}

	public void setDetalle(byte[] detalle) {
		this.detalle = detalle;
	}	
	
	public void showInfoObject()
	{
		System.out.println("Resumen: " + resumenFileName + " : " + resumen.length + " bytes");
		System.out.println("Detalle: " + detalleFileName + " : " + detalle.length + " bytes");
	}
}