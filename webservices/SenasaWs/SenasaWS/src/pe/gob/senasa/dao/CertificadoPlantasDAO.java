package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.CertificadoPlantas;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.CertificadoPlantasInterface;


public class CertificadoPlantasDAO extends BaseDAO implements CertificadoPlantasInterface {
  protected static Logger logger = Logger.getLogger(CertificadoPlantasDAO.class);
  private DBHelper helper;
  
  public CertificadoPlantasDAO() {
      super();
      helper = new DBHelper(SenasaSQL.dsCertPlantas);
  }
  private void Log(String s) {
      logger.debug(s);
  }
  
  private void Log(String s, java.lang.Throwable p2) {
      logger.fatal("CertificadoPlantasDAO - " + s, p2);
  }
  
  public boolean registarPlantas(CertificadoPlantas bean ){
      boolean flag = false;
      Connection con = null;
      CallableStatement cs = null;
      try{
          Log("= INICIO =");
          con = helper.getConnection();
          String sql = SenasaSQL.REGISTRAR_PLANTAS;
          Log("= SQL = " + sql);
          cs = con.prepareCall(sql);
          cs.setString(1, bean.getCodigoExpediente());
          cs.setString(2, bean.getCodigoServicio());
          cs.registerOutParameter(3, OracleTypes.INTEGER);            
          cs.execute();
          Log("= EJECUTADO = ");
          if(cs.getInt(3) > 0){
            flag = true;
          }
          Log("= TERMINADO = ");
          
    } catch (SQLException e) {
        Log("registarPlantas error", e);
    } catch (Exception e) {
        Log("registarPlantas error", e);
    } finally {
        cleanup(con, cs);
    }
      return flag;
  }
}