package pe.gob.senasa.vuce.integrador.mappers;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import oracle.sql.BLOB;



import pe.gob.senasa.vuce.integrador.DBConfiguration;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;

public class BaseDao {
    private String connectionString = "";

    public BaseDao() {
        super();
        this.connectionString = DBConfiguration.getInstance().getConnectionString();
    }
    
    public Connection getConnection() throws Exception {
        Connection conn = null;
        try {
        	Class.forName(this.connectionString.split(";")[1]);
			conn = DriverManager.getConnection(this.connectionString.split(";")[0]);
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException ex) {
            throw new Exception("Ha ocurrido un error al tratar de obtener una conexi?n desde el connectionString " + connectionString +
                                ": " + ex);
        }
    }
    
    public void commit(Connection conn) throws SQLException {
        try {
            if (conn != null)
                conn.commit();
        } catch (SQLException e) {
            LogHelper.obtenerLogCompleto("Ha ocurrido un error en el commit de la transacci?n: ", e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public void rollback(Connection conn) {
        try {

        	if (conn!=null)
        		conn.rollback();
        } catch (SQLException e) {
            LogHelper.obtenerLogCompleto("Ha ocurrido un error en el rollback de la transacci?n: ", e);
            e.printStackTrace();
        }
    }
    
    public void close(Connection con) {
        try {
            if (con != null)
                con.close();
        } catch (SQLException sqe) {
            LogHelper.obtenerLogCompleto("Ha ocurrido un error cerrando cerrando la conexi?n con la base de datos:", sqe);
        }
    }
    
    public void cleanup(Statement stm, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException sqe) {
            LogHelper.obtenerLogCompleto("Ha ocurrido un error cerrando el result set:", sqe);
        }
        try {
            if (stm != null)
                stm.close();
        } catch (SQLException sqe) {
            LogHelper.obtenerLogCompleto("Ha ocurrido un error cerrando el statement:", sqe);
        }
    }
    
    public void cleanup(CallableStatement cs, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException sqe) {
            LogHelper.obtenerLogCompleto("Ha ocurrido un error cerrando el result set:", sqe);
        }
        try {
            if (cs != null)
                cs.close();
        } catch (SQLException sqe) {
            LogHelper.obtenerLogCompleto("Ha ocurrido un error cerrando el statement:", sqe);
        }
    }
    
    public static Date dateToSqlDate(java.util.Date fecha) {
    	
    	if (fecha != null)
    		return new java.sql.Date(fecha.getTime());
    	else
    		return null;
    }
    
    public static BLOB bytesToBlob(Connection conn, byte[] archivo) throws SQLException, IOException {
    	BLOB blob = BLOB.createTemporary(conn, true, BLOB.DURATION_SESSION);
		OutputStream blob_os = blob.setBinaryStream(0);
		blob_os.write(archivo);
		blob_os.flush();
		return blob;
    }
}