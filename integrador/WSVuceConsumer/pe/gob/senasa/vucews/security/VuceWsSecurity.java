package pe.gob.senasa.vucews.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

public class VuceWsSecurity {
	
	private static VuceWsSecurity instance = null;
	
	public static VuceWsSecurity getInstance()
	{
		if (instance == null)
			instance = new VuceWsSecurity();
		return instance;
	}
	
	private final String PROPERTY_FILE = "vuceSecurity.properties";
	private int ID_ENTITY = -1;
	private int ITERATIONS = -1;
	private String USER_NAME = null;
	private String PUBLIC_KEY = null;
	private String PRIVATE_KEY = null;
	private byte [] SALT = new byte [] { 0x48, 0x29, 0x28, 0x37, 0x76, 0x36, 0x77, 0x15 };

	private VuceWsSecurity() {
		Properties metadata = new Properties();
        try {
        	metadata.load(this.getClass().getResourceAsStream("/"+PROPERTY_FILE));
    		ID_ENTITY = Integer.valueOf(metadata.getProperty("ID_ENTITY"));
    		ITERATIONS = Integer.valueOf(metadata.getProperty("ITERATIONS"));
    		USER_NAME = metadata.getProperty("USER_NAME");
    		PUBLIC_KEY = metadata.getProperty("PUBLIC_KEY");
    		PRIVATE_KEY = metadata.getProperty("PRIVATE_KEY");    		
        } catch (IOException ex) {
	        Logger.getLogger(VuceWsSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	private byte [] getHash(String string) {
	    byte [] bytes = null;
	    try {
	        java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(SALT);
	        
	        bytes = string.getBytes("UTF-8");
	        for (int i=1; i <= ITERATIONS; i++) {
	            digest.reset();
	            bytes = digest.digest(bytes);
	        }
	    } catch (java.security.NoSuchAlgorithmException e) {
	    	e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	    	e.printStackTrace();
	    }
	    return bytes;
	}
	
	public int getIdEntity()
	{
		return ID_ENTITY;
	}
	
	public String getUsername()
	{
		return USER_NAME;
	}
	
	public String getPassword()
	{
		String pass= DatatypeConverter.printBase64Binary((PUBLIC_KEY+new String(getHash(PUBLIC_KEY+PRIVATE_KEY))).getBytes());
		return pass;
	}

}
