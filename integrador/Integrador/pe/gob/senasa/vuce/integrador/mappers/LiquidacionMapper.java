package pe.gob.senasa.vuce.integrador.mappers;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

import pe.gob.senasa.vuce.integrador.bean.LiquidacionVUCE;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;

public class LiquidacionMapper extends BaseDao {
	public static final String GUARDAR_LIQUIDACION = "{ ?=call PCKG_LIQUIDACION.FN_GUARDAR_LIQUIDACION(?,?,?,?) }";

	public OperationResult spGuardarLiquidacion(LiquidacionVUCE liquidacion) {
		String log = "spGuardarLiquidacion";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			cs = conn.prepareCall(GUARDAR_LIQUIDACION);
			cs.registerOutParameter(1, OracleTypes.NUMERIC);
			cs.setBlob(2, BaseDao.bytesToBlob(conn, liquidacion.getResumen()));
			cs.setBlob(3, BaseDao.bytesToBlob(conn, liquidacion.getDetalle()));
			cs.registerOutParameter(4, OracleTypes.NUMERIC);
			cs.registerOutParameter(5, OracleTypes.VARCHAR);
			cs.execute();
			Object result = cs.getObject(1);
			System.out.println("ERROR=>" + cs.getString(5));
			System.out.println("ID=>" + cs.getObject(4));

			if (cs.getObject(4) != null)
				liquidacion.setIdTransmision(((BigDecimal) cs.getObject(4)).intValue());
			if (cs.getString(5) != null)
				liquidacion.setError(cs.getString(5));

			return OperationResult.getResult(((BigDecimal) result).doubleValue());
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
		} finally {
			cleanup(cs, rs);
			close(conn);
		}
		return null;
	}
}