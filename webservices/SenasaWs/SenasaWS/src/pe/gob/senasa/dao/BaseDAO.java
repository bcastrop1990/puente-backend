package pe.gob.senasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import pe.gob.senasa.db.ConectionApp;


public class BaseDAO {
    protected static Logger logger = Logger.getLogger(BaseDAO.class);
    protected ConectionApp cnApp = null;
    
    public BaseDAO() {
        super();
        //cnApp = new ConectionApp();
    }
    
    public Connection getConnection() throws Exception {
        return cnApp.getConnection();
    }

    public void cleanup(Connection conn) {
        cleanup(conn, null, null);
    }

    public void cleanup(Statement stm) {
        cleanup(null, stm, null);
    }

    public void cleanup(ResultSet rs) {
        cleanup(null, null, rs);
    }
    
    public void cleanup(Connection conn, Statement stm) {
        cleanup(conn, stm, null);
    }

    public void cleanup(Statement stm, ResultSet rs) {
        cleanup(null, stm, rs);
    }

    public void cleanup(Connection con, Statement stm, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException sqe) {
            logger.fatal("Ha ocurrido un error cerrando el result set:" +
                         sqe.getMessage());
        }
        try {
            if (stm != null)
                stm.close();
        } catch (SQLException sqe) {
            logger.fatal("Ha ocurrido un error cerrando el statement:" +
                         sqe.getMessage());
        }
        try {
            if (con != null)
                con.close();
        } catch (SQLException sqe) {
            logger.fatal("Ha ocurrido un error cerrando cerrando la conexi�n con la base de datos:" +
                         sqe.getMessage());
        }
    }

    public void error(String s, Exception e) {
        logger.debug(s + ": " + e.getMessage());
        logger.fatal(e);
    }

    public void debug(String s) {
        logger.debug(s);
    }

}
