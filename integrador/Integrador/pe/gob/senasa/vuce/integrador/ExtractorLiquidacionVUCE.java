package pe.gob.senasa.vuce.integrador;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import pe.gob.senasa.vuce.integrador.exception.IntegradorException;
import pe.gob.senasa.vuce.integrador.helper.ByteHelper;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;
import pe.gob.senasa.vuce.integrador.helper.ZipHelper;

public class ExtractorLiquidacionVUCE {
	private boolean showOuput = false;
	private String tempFolder = null;
	private String tempZipFolder = null;
	private List<String> infoArchivosZip = null;
	
	public String getTempFolder() {
		return tempFolder;
	}

	public void setTempFolder(String tempFolder) {
		this.tempFolder = tempFolder;
	}
	
	public boolean isShowOuput() {
		return showOuput;
	}

	public void setShowOuput(boolean showOuput) {
		this.showOuput = showOuput;
	}
	
	public List<String> getInfoArchivosZip() {
		if ( infoArchivosZip == null )
			this.infoArchivosZip = new ArrayList<String>();
		return infoArchivosZip;
	}
	
	public void guardarArchivosZip(List<byte[]> archivosZip) throws IntegradorException {
		try {
			if (archivosZip.size() > 0 )
			{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				String fecha = formatter.format(new Date());
				tempZipFolder = this.tempFolder + "/" + fecha;
				if (!(new File(tempZipFolder)).mkdir())
					throw new IntegradorException("Error al crear la carpeta temporal: " + tempZipFolder);
				if (showOuput)
					LogHelper.info("Carpeta Creada");
	
				int j = 1;
				for (byte[] mensaje : archivosZip) {
					String fileName = tempZipFolder + "/" + j + "_"+ ZipHelper.GenerateTempFileName();
					ByteHelper.saveFile(mensaje, fileName);
					LogHelper.info("Saving zipFile: " + fileName);
					this.getInfoArchivosZip().add(fileName);
					j++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new IntegradorException("Error al descomprimir archivo de mensajes pendientes.");
		}
	}
}
