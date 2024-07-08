package pe.gob.senasa.vuce.integrador.bean;

import java.util.ArrayList;
import java.util.List;

public class SincronizacionVUCE {
	private Integer id;
	private Integer idVuce;
	private Integer reintento;
	private byte[] resumen;
	private byte[] resultado;
	private SincResultadoVUCE resultadoSinc;
	private List<Archivo> archivos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdVuce() {
		return idVuce;
	}
	public void setIdVuce(Integer idVuce) {
		this.idVuce = idVuce;
	}
	
	public Integer getReintento() {
		return reintento;
	}
	public void setReintento(Integer reintento) {
		this.reintento = reintento;
	}
	
	public byte[] getResumen() {
		return resumen;
	}
	public void setResumen(byte[] resumen) {
		this.resumen = resumen;
	}
	
	public List<Archivo> getArchivos() {
		if (archivos==null)
			archivos = new ArrayList<Archivo>();
		return archivos;
	}
	
	public void setArchivos(String nombreAdjunto, byte[] adjunto) {
		this.getArchivos().add(new Archivo(nombreAdjunto, adjunto, null));
	}
		
	public byte[] getResultado() {
		return resultado;
	}
	public void setResultado(byte[] resultado) {
		this.resultado = resultado;
	}
		
	public SincResultadoVUCE getResultadoSinc() {
		return resultadoSinc;
	}
	public void setResultadoSinc(SincResultadoVUCE resultadoSinc) {
		this.resultadoSinc = resultadoSinc;
	}
}
