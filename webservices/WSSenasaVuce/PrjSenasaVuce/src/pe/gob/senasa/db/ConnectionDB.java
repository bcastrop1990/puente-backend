package pe.gob.senasa.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;


//import org.apache.log4j.Logger;

public class ConnectionDB {
  
  protected static Logger logger = Logger.getLogger(Connection.class);
  private static DataSource dsVUCE=null;  
  private static DataSource dsBPM=null;
  private String test="1";

  public ConnectionDB() {
  }
  
  public java.sql.Connection getConnection()throws Exception{
      if (test.equals("0")){
        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.0.0.186:1521:SIGTES","vuce", "vuce");
        return conn;
      }else{          
        try {               
          if(dsVUCE == null){
            InitialContext ic = null;
            ic = new InitialContext();
            logger.debug("Obteniendo conexion Senasa- VUCE");
            //dsVUCE = (javax.sql.DataSource)ic.lookup("dsVUCE");
            dsVUCE = (javax.sql.DataSource)ic.lookup("pruebaDS");
            //dsVUCE = (javax.sql.DataSource)ic.lookup("java:comp/env/dsVUCE");    
          }
          return dsVUCE.getConnection();
        } catch (NamingException ne) {
          logger.error("Error al buscar datasource : " + ne.getMessage());
          throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource dsVUCE " + ne);
        } catch (SQLException sqlExp) {
          logger.error("Error al obtener conexion : " + sqlExp.getMessage());
          throw new Exception("Ha ocurrido un error al tratar de obtener una conección desde el datasource dsVUCE "+sqlExp);
        }
      }
    }
  
  public java.sql.Connection getConnectionBPM()throws Exception{
        if (test.equals("0")){
          java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.19.3.171:1521:SIGDES","finalbpm", "senasa");
          return conn;
        }else{          
          try {               
            if(dsBPM == null){
              InitialContext ic = null;
              ic = new InitialContext();
              logger.debug("Obteniendo conexion Senasa- dsFINALBPM");
              dsBPM = (javax.sql.DataSource)ic.lookup("pruebaDS");
              //dsBPM = (javax.sql.DataSource)ic.lookup("java:comp/env/dsFINALBPM");    
            }
            return dsBPM.getConnection();
          } catch (NamingException ne) {
            logger.error("Error al buscar datasource : " + ne.getMessage());
            throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource dsFINALBPM " + ne);
          } catch (SQLException sqlExp) {
            logger.error("Error al obtener conexion : " + sqlExp.getMessage());
            throw new Exception("Ha ocurrido un error al tratar de obtener una conección desde el datasource dsFINALBPM "+sqlExp);
          }
        }
      }
}
