package pe.gob.senasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import pe.gob.senasa.db.SenasaSQL;


public class ExpedienteDAO {

    protected static Logger logger = Logger.getLogger(ExpedienteDAO.class);

    public static String ObtenerIdPersonaxExpediente(Connection con,
                                                     String noExp) throws SQLException {
        PreparedStatement pst = con.prepareCall(SenasaSQL.OBTENER_CLIENTE_X_EXPEDIENTE);
        Log(" = INICIO OBTENER_CLIENTE_X_EXPEDIENTE= ");
        pst.setString(1, noExp);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return rs.getString(1);
        }
        Log(" = FIN OBTENER_CLIENTE_X_EXPEDIENTE= ");
        return null;
    }

    private static void Log(String s) {
        logger.debug(s);
    }
}
