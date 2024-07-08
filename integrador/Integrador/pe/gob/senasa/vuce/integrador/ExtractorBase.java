package pe.gob.senasa.vuce.integrador;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import pe.gob.senasa.vuce.integrador.bean.Archivo;
import pe.gob.senasa.vuce.integrador.exception.IntegradorException;
import pe.gob.senasa.vuce.integrador.helper.ByteHelper;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;
import pe.gob.senasa.vuce.integrador.helper.ZipHelper;

public class ExtractorBase {
	protected boolean showOuput = false;
	protected String tempFolder = null;
	protected String tempZipFolder = null;
	protected List<String> infoArchivosZip = null;
	
	public void setInfoArchivosZip(List<String> infoArchivosZip) {
		this.infoArchivosZip = infoArchivosZip;
	}

	public ExtractorBase()
	{
		this.tempFolder = IntegradorConfig.getInstance().getCarpetaTemporal();
	}
	
	public boolean isShowOuput() {
		return showOuput;
	}

	public void setShowOuput(boolean showOuput) {
		this.showOuput = showOuput;
	}

	public String getTempFolder() {
		return tempFolder;
	}

	public void setTempFolder(String tempFolder) {
		this.tempFolder = tempFolder;
	}
	
	public List<String> getInfoArchivosZip() {
		if ( infoArchivosZip == null )
			this.infoArchivosZip = new ArrayList<String>();
		return infoArchivosZip;
	}
	
	
	
	private void deleteFile(String fileOrFolder) 
	{
		try
		{
			System.out.println("Eliminando ... " + fileOrFolder);
			File transaccion = new File(fileOrFolder);
			transaccion.delete();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void EliminarCarpetaTemporal()
	{
		if (IntegradorConfig.getInstance().isEliminarMensajes())
		{
			deleteFile(tempZipFolder);
		}
	}
	
	public void EliminarArchivo(String archivo)
	{
		if (IntegradorConfig.getInstance().isEliminarMensajes())
		{	
			deleteFile(archivo);
		}
	}
	
	public byte[] comprimirAdjuntosZip(String prefix, List<Archivo> adjuntos) throws IntegradorException {
		byte[] adjuntosZip = null;
		try {
			if (adjuntos.size() > 0 )
			{
				SimpleDateFormat formatterFecha = new SimpleDateFormat("yyyy.MM.dd");
				SimpleDateFormat formatterFechaHora = new SimpleDateFormat("yyyy.MM.dd.HH.mm");
				String fecha = formatterFecha.format(new Date());
				String fechaHora = formatterFechaHora.format(new Date());
				tempZipFolder = this.tempFolder + "/" + fecha + "_envio" ;
				if (!(new File(tempZipFolder)).mkdir())
					LogHelper.info("Error al crear la carpeta temporal: " + tempZipFolder);
				if (showOuput)
					LogHelper.info("Carpeta Creada");
				
				String fileName = tempZipFolder + "/" + fechaHora + "_adjs_" + prefix + ZipHelper.GenerateTempFileName();
				adjuntosZip = ZipHelper.ZipToByteArrayMemory(adjuntos);
				ByteHelper.saveFile(adjuntosZip, fileName);
				LogHelper.info("Saving zipFile: " + fileName);
			}
			return adjuntosZip;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IntegradorException("Error al descomprimir archivo entrante.");
		}
	}
	
	public byte[] comprimirAdjuntoZip(String prefix, String nombre, byte[] archivo) throws IntegradorException {
		byte[] adjuntosZip = null;
		try {
			SimpleDateFormat formatterFecha = new SimpleDateFormat("yyyy.MM.dd");
			SimpleDateFormat formatterFechaHora = new SimpleDateFormat("yyyy.MM.dd.HH.mm");
			String fecha = formatterFecha.format(new Date());
			String fechaHora = formatterFechaHora.format(new Date());
			tempZipFolder = this.tempFolder + "/" + fecha + "_envio" ;
			if (!(new File(tempZipFolder)).mkdir())
				LogHelper.info("Error al crear la carpeta temporal: " + tempZipFolder);
			if (showOuput)
				LogHelper.info("Carpeta Creada");
			
			String fileName = tempZipFolder + "/" + fechaHora + "_" + nombre + "_" + prefix + ZipHelper.GenerateTempFileName();
			List<Archivo> archs = new ArrayList<Archivo>();   
			archs.add(new Archivo(nombre, archivo, ""));
			adjuntosZip = ZipHelper.ZipToByteArrayMemory(archs);
			ByteHelper.saveFile(adjuntosZip, fileName);
			LogHelper.info("Saving zipFile: " + fileName);
			return adjuntosZip;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IntegradorException("Error al descomprimir archivo entrante.");
		}
	}
}
