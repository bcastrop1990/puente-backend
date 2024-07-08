package pe.gob.senasa.vuce.integrador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class IntegradorConfig {

	static private IntegradorConfig singleton = null;
	private HashMap<String, String> properties = null;
	private String PROPERTY_FILE = "integrador.properties";
	
	private IntegradorConfig()
    {
		ReadConfiguration();
    }

    static public IntegradorConfig getInstance() {
         if (singleton == null) {
             singleton = new IntegradorConfig();
         }
         return singleton;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void ReadConfiguration() {
		try {
			Properties fileProp = new Properties();
	        try {
	        	fileProp.load(this.getClass().getResourceAsStream("/"+PROPERTY_FILE));
	        } catch (IOException ex) {
	        }
			properties = new HashMap<String, String>((Map) fileProp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getCarpetaTemporal() {
		return this.properties.get("integrador.carpetaTemporal");
	}
	public boolean isProxyHabilitado() {
		return Boolean.parseBoolean(this.properties.get("integrador.proxyHabilitado"));
	}
	public boolean isRegistrarMensajes() {
		return Boolean.parseBoolean(this.properties.get("integrador.registrarMensajes"));
	}
	public boolean isConfirmarMensajes() {
		return Boolean.parseBoolean(this.properties.get("integrador.confirmarMensajes"));
	}
	public boolean isEliminarMensajes() {
		return Boolean.parseBoolean(this.properties.get("integrador.eliminarMensajes"));
	}
	public String getArchivoMensajesPendientes() {
		return this.properties.get("integrador.archivoMensajesPendientes");
	}
	
	public String getUsernameBPM() {
		return this.properties.get("integradorBPM.username");
	}
	public String getPasswordBPM() {
		return this.properties.get("integradorBPM.password");
	}
}
