package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.VerificaCierreInterface;


public class VerificaCierreDAO extends BaseDAO implements VerificaCierreInterface {
   
  protected static Logger logger = Logger.getLogger(GeneralDAO.class);
  private String msgErr = "";
  private DBHelper helper;
  
  public VerificaCierreDAO() {
    super();
    helper = new DBHelper(SenasaSQL.dsVerificaCierre);
  }
    
  private void Log(String s) {
      logger.debug(s);
  }

  private void Log(String s, java.lang.Throwable p2) {
      logger.fatal("GENERAL - " + s, p2);
  }
  
  public String getMsgErr() {
     return msgErr;
  }
  
  public String actualizaIndicadorBPM(String codigoSolicitud, String indicadorBPM, String userName){
      
          String sql = SenasaSQL.ACTUALIZA_INDICADOR_BPM;
    
          Log(" AQUI VA EL " + sql);
          
          Connection con = null;
          PreparedStatement pst = null;
          CallableStatement cs = null;
    
          String retval = "0";
        
          try {
              con = helper.getConnection();
              cs = con.prepareCall(sql);
              cs.setString(1,codigoSolicitud);
              cs.setString(2,indicadorBPM);
              cs.setString(3,userName);
            
              Log(" = ANTES DE EJECUTAR = ");
              cs.execute();

              Log(" = YA EJECUTE = ");
              Log(" = FIN TODITO = ");
          } catch (SQLException e) {
              Log("generaNumeroSolicitud", e);
              retval = e.getMessage();
          } catch (Exception e) {
              Log("generaNumeroSolicitud", e);
              retval = e.getMessage();
          } finally {
            cleanup(con, pst);
          }
          return retval;
     
  }
  
  public String solicitudEnEspera(String codigoSolicitud){
      
          String sql = SenasaSQL.SOLICITUD_EN_ESPERA;
    
          Log(" AQUI VA EL " + sql);
          
          Connection con = null;
          PreparedStatement pst = null;
          CallableStatement cs = null;
          ResultSet rs;
          String retval = "0";
        
          try {
              con = helper.getConnection();
              cs = con.prepareCall(sql);
              cs.setString(1,codigoSolicitud);              
              Log(" = ANTES DE EJECUTAR = ");
              rs = cs.executeQuery();              
              while(rs.next()) {
                  retval = ""+rs.getInt(1);
              }
              Log(" = YA EJECUTE = ");
              Log(" = FIN TODITO = ");
          } catch (SQLException e) {
              Log("generaNumeroSolicitud", e);
              retval = e.getMessage();
          } catch (Exception e) {
              Log("generaNumeroSolicitud", e);
              retval = e.getMessage();
          } finally {
            cleanup(con, pst);
          }
          return retval;
     
  }
  
    
}
