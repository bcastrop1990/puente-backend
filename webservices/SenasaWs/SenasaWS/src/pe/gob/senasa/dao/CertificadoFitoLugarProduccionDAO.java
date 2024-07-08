package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.CertificadoFitoLugarProduccion;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.CertificadoFitoLugarProduccionInterface;


public class CertificadoFitoLugarProduccionDAO extends BaseDAO implements CertificadoFitoLugarProduccionInterface{
    
    protected static Logger logger = Logger.getLogger(CertificadoFitoLugarProduccionDAO.class);
    
    private DBHelper helper;
    public CertificadoFitoLugarProduccionDAO() {
        super();
        helper = new DBHelper(SenasaSQL.dsLugarProd);
    }
    private void Log(String s) {
        logger.debug(s);
    }
    
    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("CertificadoFitoLugarProduccionDAO - " + s, p2);
    }
    
    public boolean registarSoliLugarProduccion(CertificadoFitoLugarProduccion bean ){
        boolean flag = false;
        Connection con = null;
        CallableStatement cs = null;
        try{
            Log("= INICIO =");
            con = helper.getConnection();
            String sql = SenasaSQL.REGISTRAR_SOLI_LUGAR_PRODUCCION;
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
          Log("registarSoliLugarProduccion error", e);
      } catch (Exception e) {
          Log("registarSoliLugarProduccion error", e);
      } finally {
          cleanup(con, cs);
      }
        return flag;
    }
        
}
