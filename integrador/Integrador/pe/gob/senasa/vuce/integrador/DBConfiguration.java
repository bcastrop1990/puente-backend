package pe.gob.senasa.vuce.integrador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DBConfiguration {

	static private DBConfiguration singleton = null;

    private DBConfiguration()
    {
    	ReadConfiguration();
    }

    static public DBConfiguration getInstance() {
         if (singleton == null) {
             singleton = new DBConfiguration();
         }
         return singleton;
    }
	
	private HashMap<String, String> properties = null;
	private String PROPERTY_FILE = "app.properties";
	private String userName = null;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void ReadConfiguration() {
		try {
			Properties fileProp = new Properties();
	        try {
	        	System.out.println(this.getClass().getResource("/"+PROPERTY_FILE));
	        	fileProp.load(this.getClass().getResourceAsStream("/"+PROPERTY_FILE));
	        } catch (IOException ex) {
	        }
			properties = new HashMap<String, String>((Map) fileProp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getConnectionString()
	{
		return getConnectionString("TEST");
	}
	
	public String getConnectionString(String connectionName)
	{
		if (this.properties.size() != 0) {
			String driver = this.properties.get("connection." + connectionName + ".driver_class");
			String url = this.properties.get("connection." + connectionName + ".url");
			String username = this.properties.get("connection." + connectionName + ".username");
			String password = this.properties.get("connection." + connectionName + ".password");
			String connectionString = String.format(url, username, password) + ";" + driver;
			return connectionString ;
		}
		return null;
	}
	
	public boolean showSQL()
	{
		return Boolean.parseBoolean(this.properties.get("logging.showSQL"));
	}
	
	public boolean showAll()
	{
		return Boolean.parseBoolean(this.properties.get("logging.showAll"));
	}
	
	public boolean sendClientInfo()
	{
		return Boolean.parseBoolean(this.properties.get("connection.putClientInfo"));
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}