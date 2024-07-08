package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.DirectorioSenasa;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.DirectorioSenasaInterface;


public class DirectorioSenasaDAO extends BaseDAO implements DirectorioSenasaInterface {

	protected static Logger logger = Logger.getLogger(DirectorioSenasaDAO.class);
  private DBHelper helper;
	public DirectorioSenasaDAO() {
		super();
	  helper = new DBHelper(SenasaSQL.dsDirectorio);
	}
  private void Log(String s) {
    logger.debug(s);
  }

  private void Log(String s, java.lang.Throwable p2) {
    logger.fatal("DirectorioSenasaDAO - " + s, p2);
  }  
  private DirectorioSenasa ListaUsuarios(ResultSet rs) throws SQLException {
    DirectorioSenasa ret = new DirectorioSenasa();
    ret.setNomCuenta(rs.getString("account_name"));
    ret.setDistNom(rs.getString("distinguished_name"));
    ret.setUsuariolist(rs.getString("Usuario"));
    return ret;
  } 
    
  public ArrayList<DirectorioSenasa> obtenerUsuarios(String GroupName) {
    ArrayList<DirectorioSenasa> retval = new ArrayList<DirectorioSenasa>();
    String sql = SenasaSQL.DIRECTORIO_POR_USUARIO;

    Log(" AQUI VA EL " + sql);
    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    try {
            con = helper.getConnection();
      pst = con.prepareStatement(sql);
      cs = con.prepareCall(sql);

      cs.setString(1, GroupName);
      cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

      cs.execute();
      Log(" = ENTRANDO = ");
      rs = (ResultSet)cs.getObject(2);
          
      while (rs.next()) {
        retval.add(ListaUsuarios(rs));
      }
      Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerUsuarios", e);
    } catch (Exception e) {
        Log("obtenerUsuarios", e);
    } finally {
        cleanup(con, cs,rs);  
    }
    return retval;
  }
}
