package pe.gob.senasa.vuce.integrador.test;

public class ZipTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*File zipFull = new File("E:/VUCE/data/MensajesPendientes.zip");
		TestTools test = new TestTools();
		byte[] returnWS;
		try {
			returnWS = test.getBytesFromFile(zipFull);
			test.ReadZip(returnWS);
		} catch (IOException e) {
			e.printStackTrace();
		}		*/
	}/*
	
	public byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);
    
        // Get the size of the file
        long length = file.length();
    
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
    
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];
    
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
    
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }
    
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

	public void ReadZip(byte[] zipFile) {
		ZipHelper zip = new ZipHelper(); 
		zip.setTempFolder("E:/VUCE/temp");
		try {
			zip.setShowOuput(true);
			zip.UnZipTransaccionesPendientes(zipFile);
			
			for (String transaccionId : zip.getTransacciones())
			{
				MensajeVUCE mensaje = new MensajeVUCE(transaccionId);
				zip.completeMensajeVuceWithZipData(mensaje);
				zip.deleteTransaccionZip(transaccionId);
			}
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}*/
}
