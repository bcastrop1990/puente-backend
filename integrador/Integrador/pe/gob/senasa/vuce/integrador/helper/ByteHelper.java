package pe.gob.senasa.vuce.integrador.helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;



import pe.gob.senasa.vuce.integrador.IntegradorConfig;
import pe.gob.senasa.vuce.integrador.exception.IntegradorException;

public class ByteHelper {
	private static final int DEFAULT_CHUNK_SIZE = 1024;
	
	public static String GenerateTempName(int length)
	{
		return UUID.randomUUID().toString().replaceAll("-", "").substring(1, length);
	}
	
	public static void rmdir(final File folder) {
	      if (folder.isDirectory()) {
	          File[] list = folder.listFiles();
	          if (list != null) {
	              for (int i = 0; i < list.length; i++) {
	                  File tmpF = list[i];
	                  if (tmpF.isDirectory()) {
	                      rmdir(tmpF);
	                  }
	                  tmpF.delete();
	              }
	          }
	          if (!folder.delete()) {
	            System.out.println("can't delete folder : " + folder);
	          }
	      }
	  }

	public static void deleteFilesOlderThanNdays(int daysBack) {  
		String tempFolder = IntegradorConfig.getInstance().getCarpetaTemporal();
		System.out.println(tempFolder);
		File directory = new File(tempFolder);  
        if(directory.exists()){  
            File[] listFiles = directory.listFiles();              
            long purgeTime = System.currentTimeMillis() - (daysBack * 24 * 60 * 60 * 1000);  
            for(File listFile : listFiles) {
            	System.out.println(listFile.getName());
            	System.out.println(listFile.lastModified());
            	System.out.println(purgeTime);
                if(listFile.lastModified() < purgeTime) {  
                    rmdir(listFile);
                }  
            }  
        }
    }  
	
	public static String createTempDir() throws IntegradorException {
		String tempFolder = IntegradorConfig.getInstance().getCarpetaTemporal();
		Date now = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
		tempFolder = tempFolder + "/" + formatter.format(now);
		createDir(tempFolder);
		
		formatter = new SimpleDateFormat("HH_mm_ss");
		tempFolder = tempFolder + "/" +  formatter.format(now) + "_" + GenerateTempName(5);
		createDir(tempFolder);
		
		return tempFolder;
	}
	
	public static void createDir(String path) throws IntegradorException {
		if (!new File(path).exists() && !(new File(path)).mkdir()) 
			throw new IntegradorException("Error al crear la carpeta temporal: " + path);
	}
	
	public static List<String> saveTempListFile(List<byte[]> archivos) throws IntegradorException {
		List<String> rutasArchivos = new ArrayList<String>();
		try {
			if (archivos.size() > 0 )
			{
				String tempZipFolder = ByteHelper.createTempDir();
				LogHelper.info("Carpeta Creada: " + tempZipFolder);
				int j = 1;
				for (byte[] mensaje : archivos) {
					String fileName = tempZipFolder + "/" + j + "_"+ ZipHelper.GenerateTempFileName();
					saveFile(mensaje, fileName);
					rutasArchivos.add(fileName);
					LogHelper.info("Saving zipFile: " + fileName);
					j++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new IntegradorException("Error al descomprimir archivo entrante.");
		}
		return rutasArchivos;
	}
	
	public static void saveFile(byte[] theBytes, String fileName) throws java.io.IOException {
		bytesToStream(theBytes, new java.io.FileOutputStream(fileName));
	}

	public static void bytesToStream(byte[] theBytes, java.io.OutputStream out) throws java.io.IOException {
		try {
			out.write(theBytes);
		} finally {
			out.flush();
			out.close();
		}
	}

	public static byte[] readFile(String fileName) throws java.io.IOException {
		return streamToBytes(new java.io.FileInputStream(fileName), DEFAULT_CHUNK_SIZE);
	}

	public static byte[] streamToBytes(java.io.InputStream in) throws java.io.IOException {
		return streamToBytes(in, DEFAULT_CHUNK_SIZE);
	}

	public static byte[] streamToBytes(java.io.InputStream in, int chunkSize) throws java.io.IOException {
		if (chunkSize < 1)
			chunkSize = DEFAULT_CHUNK_SIZE;

		int count;
		java.io.ByteArrayOutputStream bo = new java.io.ByteArrayOutputStream();
		byte[] b = new byte[chunkSize];
		try {
			while ((count = in.read(b, 0, chunkSize)) > 0) {
				bo.write(b, 0, count);
			}
			byte[] thebytes = bo.toByteArray();
			return thebytes;
		} finally {
			bo.close();
		}
	}
}
