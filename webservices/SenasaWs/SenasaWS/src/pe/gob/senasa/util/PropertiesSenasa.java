package pe.gob.senasa.util;


import java.io.FileInputStream;

import java.util.Properties;

import org.apache.log4j.Logger;


public class PropertiesSenasa {
    
  protected static Logger logger = Logger.getLogger(PropertiesSenasa.class);
    
    private static  Properties pro = new Properties();
    
   static {
      try {
          
        FileInputStream stream;

        //instanciamos un flujo de escritura en el archivo 
        stream = new FileInputStream("configSWsenasa.properties");
        pro.load(stream);

       // int numPropiedades = pro.size();

      } catch (Exception e) {
          logger.fatal("Error al inicializar las propiedades",e);
      }
   }
    
   public PropertiesSenasa() {
        super();
   }
   
   public static String getPropiedad(String propiedad)
   {
      return pro.getProperty(propiedad); 
   }
}
