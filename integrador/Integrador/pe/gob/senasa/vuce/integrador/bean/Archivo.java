package pe.gob.senasa.vuce.integrador.bean;

import java.io.IOException;
import java.io.InputStream;

import pe.gob.senasa.vuce.integrador.helper.ByteHelper;

public class Archivo {
	protected byte[] archivo = null;
	protected String nombre = "";
	protected String ucmID = "";
	
	public Archivo() {
	}
	
	public Archivo(String nombre, byte[] archivo, String ucmId) {
		super();
		this.nombre = nombre;
		this.archivo = archivo;
		this.ucmID = ucmId;
	}
	
	public String getExtension()
	{
		if (getNombre()==null || getNombre().length()==0)
			return "";
		else
			return getNombre().substring(getNombre().lastIndexOf("."));
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUcmID() {
		return ucmID;
	}
	public void setUcmID(String ucmID) {
		this.ucmID = ucmID;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	public void setArchivo(InputStream stream)
	{
		try {
			setArchivo(ByteHelper.streamToBytes(stream));
		} catch (IOException e) {
			this.archivo = null;
			e.printStackTrace();
		}
	}
}
