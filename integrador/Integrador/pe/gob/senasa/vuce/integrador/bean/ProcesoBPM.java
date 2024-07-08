package pe.gob.senasa.vuce.integrador.bean;

public class ProcesoBPM {
	public ProcesoBPM()
	{		
	}
	
	private Double id;
	private String formato;
	private String codigoServicio;
	private String numeroDocumento;
	private String numeroDocumentoRef;
	private String bpmProxyClase;
	private String bpmProxyMetodo;
	private String instanciaId;
	
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getCodigoServicio() {
		return codigoServicio;
	}
	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNumeroDocumentoRef() {
		return numeroDocumentoRef;
	}
	public void setNumeroDocumentoRef(String numeroDocumentoRef) {
		this.numeroDocumentoRef = numeroDocumentoRef;
	}
	public String getBpmProxyClase() {
		return bpmProxyClase;
	}
	public void setBpmProxyClase(String bpmProxyClase) {
		this.bpmProxyClase = bpmProxyClase;
	}
	public String getBpmProxyMetodo() {
		return bpmProxyMetodo;
	}
	public void setBpmProxyMetodo(String bpmProxyMetodo) {
		this.bpmProxyMetodo = bpmProxyMetodo;
	}
	public Double getId() {
		return id;
	}
	public void setId(Double id) {
		this.id = id;
	}
	public String getInstanciaId() {
		return instanciaId;
	}
	public void setInstanciaId(String instanciaId) {
		this.instanciaId = instanciaId;
	}	
}
