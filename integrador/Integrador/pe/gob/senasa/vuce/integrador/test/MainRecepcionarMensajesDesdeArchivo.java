package pe.gob.senasa.vuce.integrador.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import pe.gob.senasa.vuce.integrador.IntegradorConfig;
import pe.gob.senasa.vuce.integrador.gestion.GestionRecepcionarMensaje;
import pe.gob.senasa.vuce.integrador.helper.ZipHelper;

public class MainRecepcionarMensajesDesdeArchivo {
	
	public static void main(String[] args) {
		String zipFileName = IntegradorConfig.getInstance().getArchivoMensajesPendientes();
		try {
			List<byte[]> mensajesPendiente = MainRecepcionarMensajesDesdeArchivo.getListBytesFromFile(new File(zipFileName));
			new GestionRecepcionarMensaje().procesarLista(mensajesPendiente);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<byte[]> getListBytesFromFile(File file) throws IOException {
		ZipFile zip = new ZipFile(file);
		List<byte[]> pendientes = new ArrayList<byte[]>(); 
		for (Enumeration<? extends ZipEntry> e = zip.entries(); e.hasMoreElements();) {
			ZipEntry entry = (ZipEntry) e.nextElement();
			pendientes.add(ZipHelper.UnzipToByteArray(zip, entry));
		}
        return pendientes;
    }
}
