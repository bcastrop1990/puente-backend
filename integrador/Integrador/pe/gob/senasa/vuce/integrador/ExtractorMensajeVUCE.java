package pe.gob.senasa.vuce.integrador;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;



import pe.gob.senasa.vuce.integrador.bean.AdjuntoVuce;
import pe.gob.senasa.vuce.integrador.bean.MensajeVUCE;
import pe.gob.senasa.vuce.integrador.exception.IntegradorException;
import pe.gob.senasa.vuce.integrador.helper.ByteHelper;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;
import pe.gob.senasa.vuce.integrador.helper.ZipHelper;

public class ExtractorMensajeVUCE extends ExtractorBase {
	private final String ebXMLencoding = "ISO-8859-1";
	private final String nombreAdjuntos = "adjuntos.zip";
	private final String nombreEbXML = "formatoEBXML.xml";
	private final String nombreMensaje = "mensaje.xml";

	public ExtractorMensajeVUCE() {
	}

	private void cargarAdjuntos(MensajeVUCE mensaje, byte[] adjuntosZipBytes) throws IntegradorException {
		try {
			ZipInputStream zin = ZipHelper.GetZipInputStream(adjuntosZipBytes);
			if (zin == null)
				throw new IntegradorException("Error al convertir adjunto de ArrayBytes a ZipInputStream.");

			ZipEntry ze = null;
			while ((ze = zin.getNextEntry()) != null) {
				AdjuntoVuce adjunto = new AdjuntoVuce();
				adjunto.setNombre(ze.getName());

				byte[] archivo = ZipHelper.UnzipToByteArray(zin);
				if (archivo == null)
					throw new IntegradorException("Error al descomprimirt archivo adjunto.");

				String adjFilePath = mensaje.getTempFolder() + "/" + ze.getName();
				ByteHelper.createDir(mensaje.getTempFolder());
				ByteHelper.saveFile(archivo, adjFilePath);
				adjunto.setArchivo(adjFilePath.getBytes());
				adjunto.setValidPath(true);
				LogHelper.info("---->Archivo adjunto descomprimido: " + adjunto.getNombre() + "; size: " + ze.getSize()
								+ "; compressed size: " + ze.getCompressedSize());
				mensaje.getAdjuntos().add(adjunto);
			}
			zin.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IntegradorException("Error al descomprimir archivo con adjuntos.");
		}
	}

	public void cargarTransaccionZip(String infoTransaccionZip, MensajeVUCE mensaje) throws IntegradorException {
		if (infoTransaccionZip != null) {
			try {
				ZipFile zip = new ZipFile(new File(infoTransaccionZip));
				String infoZipEntry = "";
				mensaje.setTempFolder(infoTransaccionZip + "_d");
				LogHelper.info("Descomprimiendo transaccion: " + infoTransaccionZip);

				for (Enumeration<? extends ZipEntry> e = zip.entries(); e.hasMoreElements();) {
					ZipEntry entry = (ZipEntry) e.nextElement();
					infoZipEntry = entry.getName() + "; size: " + entry.getSize() + "; compressed size: "
							+ entry.getCompressedSize();
					if (entry.getName().toLowerCase().equals(nombreAdjuntos.toLowerCase())) {
						LogHelper.info("-->Descomprimiendo ADJUNTOS...");
						cargarAdjuntos(mensaje, ZipHelper.UnzipToByteArray(zip, entry));
					} else if (entry.getName().toLowerCase().equals(nombreEbXML.toLowerCase())) {
						LogHelper.info("-->Descomprimiendo EBXML... " + infoZipEntry);
						mensaje.setEbXmlTransaccion(new String(ZipHelper.UnzipToString(zip, entry).getBytes(),
								ebXMLencoding));
					} else if (entry.getName().toLowerCase().equals(nombreMensaje.toLowerCase())) {
						LogHelper.info("-->Descomprimiendo XML... " + infoZipEntry);
						mensaje.setXmlTransaccion(new String(ZipHelper.UnzipToString(zip, entry).getBytes(),
								ebXMLencoding));
					}
				}
				zip.close();
			} catch (Exception ex) {
				LogHelper.obtenerLogCompleto("Error al descomprimir archivo de transaccion.", ex);
				throw new IntegradorException("Error al descomprimir archivo de transaccion.");
			}
		} else
			throw new IntegradorException(
					"Error al descomprimir archivo de transaccion. No se ha especificado el nombre del archivo.");
	}
}
