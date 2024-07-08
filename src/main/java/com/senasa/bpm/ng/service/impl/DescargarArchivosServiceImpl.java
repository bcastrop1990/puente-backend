package com.senasa.bpm.ng.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.axis.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.senasa.bpm.ng.service.DescargarArchivosService;
import com.senasa.bpm.ng.utility.ConfigProperties;
import com.senasa.bpm.ng.ws.gestiondocumento.GestionDocumentoWS_PortType;
import com.senasa.bpm.ng.ws.gestiondocumento.GestionDocumentoWS_ServiceLocator;

import lombok.extern.java.Log;

@Service
@Log
public class DescargarArchivosServiceImpl implements DescargarArchivosService {

	@Autowired
	private ConfigProperties configProp;
	
	@Autowired
	private GestionDocumentoWS_ServiceLocator serviceLocator; 
	
	@Override
	public byte[] descargarArchivosReport(String codigoExpediente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DOWNLOADFROMUCM(String cadena) throws Exception {
		// cadena --> aaa<->bbb<->ccc<->ddd ....
		String[] campos = cadena.split("<->");
		String ruta = configProp.getConfigValue("downloadfolder") ;// AppConfig.getPath(p, "upload");

		log.info("DOWNLOADFROMUCM - campos = " + campos.length);
		log.info("DOWNLOADFROMUCM - downloadfolder = " + ruta);
		
		List<String> srcFiles = new ArrayList<String>();
		for (int i = 0; i < campos.length; i++) {
			
			log.info("DOWNLOADFROMUCM - ValorCampo=" + campos[i]);
			String idFile =  campos[i];// .substring(10, campos[i].length());
			srcFiles.add(idFile);
			if (StringUtils.isEmpty(idFile)) {
				log.info("DOWNLOADFROMUCM - Pendiente de corregir" );
				idFile = /* AppConfig.getServerPath(p) + */ "ext2.2/images/px.gif";
			}

			try {
				
				log.info("DOWNLOADFROMUCM - idFile = " + idFile);
				
				File file = new File(idFile);
				if (!file.exists()) {
					
					log.info("DOWNLOADFROMUCM - Generando file " + campos[i]/* .substring(10, campos[i].length()) */);
					
					GestionDocumentoWS_PortType port = serviceLocator.getGestionDocumentoWSPort();

					String ucmid = campos[i].substring(0, 8);
					log.info("DOWNLOADFROMUCM - Tamano " + campos[i].length());
					if (campos[i].length() > 12) {
						ucmid = campos[i].substring(campos[i].length() - 12);
					}

					log.info("DOWNLOADFROMUCM - UCM ID " + ucmid.substring(0, 8));

					byte[] buffer = port.obtenerDocumento(ucmid.substring(0, 8));
					writeBytesToFile(file, buffer);
					log.info("Genero el archivo->" + ruta + "\\" + campos[i]/* .substring(10, campos[i].length()) */);
					buffer = null;
					System.gc();
				}

			} catch (IOException ex) {
				log.severe("Error en->" + ex);
			} catch (Exception x) {
				log.severe("Exception en -> " + x);
			}
		}

	}

	@Override
	public byte[] ZIPFROMUCM( String nameFile , String cadena , HttpHeaders headers ) throws Exception {
		log.info("ZIPFROMUCM - INI");

		// cadena --> aaa<->bbb<->ccc<->ddd ....

		String ruta = configProp.getConfigValue("downloadfolder") ; // AppConfig.getPath(p, "upload");

		//String nameFile = p.getParameter("nameFile");
		String[] campos = cadena.split("<->"); // por ahora obligatorio hasta que UUID se lance  desde JS
		String zipFileName = "";

		UUID id = UUID.randomUUID();
		//ParameterWeb pw = (ParameterWeb) p;

		if (nameFile.equals(""))
			zipFileName = id + ".zip";
		else
			zipFileName = nameFile + ".zip";

		String finalName = zipFileName;

		zipFileName =  zipFileName;

		log.info("ZIPFROMUCM - zipFileName = " + zipFileName);

		List<String> srcFiles = new ArrayList<String>();

		for (int i = 0; i < campos.length; i++) {

			String idFile = campos[i]/* .substring(10, campos[i].length()) */;
			srcFiles.add(idFile);
			log.info("ZIPFROMUCM - idFile = " + idFile);

			if (StringUtils.isEmpty(idFile)) {
				log.info("ZIPFROMUCM - Pendiente por corregir");
				idFile = /*AppConfig.getServerPath(p) + */"ext2.2/images/px.gif";
			}
		}

		try {
			// create byte buffer
			byte[] buffer = new byte[4096];
			FileOutputStream fos = new FileOutputStream(zipFileName);
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (int m = 0; m < srcFiles.size(); m++) {
				log.info("ZIPFROMUCM - procesando file  = " + srcFiles.get(m));

				File srcFile = new File(srcFiles.get(m));
				FileInputStream fis = new FileInputStream(srcFile);
				// begin writing a new ZIP entry, positions the stream to the start of the entry
				// data
				zos.putNextEntry(new ZipEntry(srcFile.getName()));
				int length;
				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}
				// close the InputStream
				fis.close();
				zos.closeEntry();

			}
			// close the ZipOutputStream
			zos.close();
			fos.close();

			File x = new File(zipFileName);
			headers.setContentDispositionFormData("Content-Disposition", "attachment; filename=\"" + finalName + "\"");
			return Files.readAllBytes( x.toPath() );

		} catch (IOException ioe) {
			System.out.println("Error creating zip file: " + ioe);
			log.severe("SEVERO - Error creating zip file: " + ioe);

			ioe.printStackTrace();
			return null;
		}
	}

	@Override
	public byte[] FILEFROMUCM(  String cadena , HttpHeaders headers ) throws Exception {
		log.info("FILEFROMUCM - INI");
		
		// cadena --> aaa<->bbb<->ccc<->ddd ....

		String ruta = configProp.getConfigValue("downloadfolder") ; // AppConfig.getPath(p, "upload");

		//String nameFile = p.getParameter("nameFile");
		String[] campos = cadena.split("<->"); // por ahora obligatorio hasta que UUID se lance  desde JS
		 

		UUID id = UUID.randomUUID();

		String finalName = cadena;
  
		String idFile = ruta + "\\" + campos[0]/* .substring(10, campos[i].length()) */;

		try {
						 
			File x = new File(idFile);  
			headers.setContentDispositionFormData("Content-Disposition", "attachment; filename=\"" + finalName + "\""); 
			return Files.readAllBytes( x.toPath() );
			
		} catch (IOException ioe) {
			System.out.println("Error creating zip file: " + ioe);
			log.severe("SEVERO - Error creating zip file: " + ioe);
			
			ioe.printStackTrace();
			return null;
		}
	}
	
	public static void writeBytesToFile(File file, byte[] buffer) throws IOException {
		FileOutputStream fileOuputStream = new FileOutputStream(file);
		fileOuputStream.write(buffer);
		fileOuputStream.flush();
		fileOuputStream.close();
	}

	
}
