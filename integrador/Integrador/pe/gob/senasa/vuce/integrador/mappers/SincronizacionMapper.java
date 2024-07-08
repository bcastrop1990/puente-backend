package pe.gob.senasa.vuce.integrador.mappers;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import oracle.jdbc.OracleTypes;

import pe.gob.senasa.vuce.integrador.bean.SincronizacionVUCE;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;

public class SincronizacionMapper extends BaseDao {
	public static final String SINCRONIZAR = "{ ?=call VUCE.PCKG_SINCRONIZACION.FN_SINCRONIZAR() }";
	public static final String OBTENER_MENSAJES_PENDIENTES = "{ ?=call VUCE.PCKG_SINCRONIZACION.FN_MENSAJE_PENDIENTE(?,?) }";
	public static final String OBTENER_MENSAJES = "{ ?=call VUCE.PCKG_SINCRONIZACION.FN_MENSAJE(?,?,?) }";
	public static final String OBTENER_MENSAJES_SIN_RESULTADO = "{ ?=call VUCE.PCKG_SINCRONIZACION.FN_MENSAJES_SIN_RESULTADO(?) }";
	public static final String ACTUALIZAR_MENSAJE_ENVIADO = "{ ?=call VUCE.PCKG_SINCRONIZACION.FN_ACTUALIZAR_MENSAJE_ENVIADO(?,?) }";
	public static final String ACTUALIZAR_MENSAJE_LOG = "{ ?=call VUCE.PCKG_SINCRONIZACION.FN_ACTUALIZAR_MENSAJE_LOG(?,?,?,?) }";
	
	public OperationResult sincronizar()
	{
		String log = "sincronizar";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
            cs = conn.prepareCall(SINCRONIZAR);
            cs.registerOutParameter(1, OracleTypes.NUMERIC);
			cs.execute();
			Object result = cs.getObject(1);
			return OperationResult.getResult(((BigDecimal) result).doubleValue());
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
		} finally {
			cleanup(cs, rs);
			close(conn);
		}
		return OperationResult.Failure;
	}

	public OperationResult obtenerMensajePendiente(SincronizacionVUCE sincronizacion)
	{
		String log = "obtenerMensajePendiente";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
            cs = conn.prepareCall(OBTENER_MENSAJES_PENDIENTES);
            cs.registerOutParameter(1, OracleTypes.NUMERIC);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
			cs.execute();
			Object result = cs.getObject(1);
			ResultSet rsResumen = (ResultSet)cs.getObject(2);
			ResultSet rsDetalle = (ResultSet)cs.getObject(3);
			if (rsResumen.next())
			{
				sincronizacion.setId(rsResumen.getBigDecimal("id").intValue());
				Blob xmlBlob = rsResumen.getBlob("resumen");
				sincronizacion.setResumen(((xmlBlob == null ? null : xmlBlob.getBytes(1, (int) xmlBlob.length()))));
				while(rsDetalle.next())
				{
					String nombre = rsDetalle.getString("xml_archivo");
					Blob blob = rsDetalle.getBlob("xml");
					sincronizacion.setArchivos(nombre ,(blob == null ? null : blob.getBytes(1, (int) blob.length())));
				}
				return OperationResult.getResult(((BigDecimal) result).doubleValue());
			}
			System.out.println("No hay mensajes pendientes de sincronización en cola.");
			return OperationResult.Failure;
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
		} finally {
			cleanup(cs, rs);
			close(conn);
		}
		return OperationResult.Failure;
	}
	
	public OperationResult obtenerMensaje(SincronizacionVUCE sincronizacion, int id)
	{
		String log = "obtenerMensaje";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
            cs = conn.prepareCall(OBTENER_MENSAJES);
            cs.registerOutParameter(1, OracleTypes.NUMERIC);
            cs.setInt(2, id);
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(4, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.execute();
			Object result = cs.getObject(1);
			ResultSet rsResumen = (ResultSet)cs.getObject(3);
			ResultSet rsDetalle = (ResultSet)cs.getObject(4);
            
			if (rsResumen.next())
			{
				sincronizacion.setId(rsResumen.getBigDecimal("id").intValue());
				Blob xmlBlob = rsResumen.getBlob("resumen");
				sincronizacion.setResumen(((xmlBlob == null ? null : xmlBlob.getBytes(1, (int) xmlBlob.length()))));
				while(rsDetalle.next())
				{
					String nombre = rsDetalle.getString("xml_archivo");
					Blob blob = rsDetalle.getBlob("xml");
					sincronizacion.setArchivos(nombre ,(blob == null ? null : blob.getBytes(1, (int) blob.length())));
				}
			}
			return OperationResult.getResult(((BigDecimal) result).doubleValue());
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
		} finally {
			cleanup(cs, rs);
			close(conn);
		}
		return OperationResult.Failure;
	}
	
	public OperationResult obtenerMensajesSinResultado(List<SincronizacionVUCE> mensajes)
	{
		String log = "obtenerMensajesSinResultado";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
            cs = conn.prepareCall(OBTENER_MENSAJES_SIN_RESULTADO);
            cs.registerOutParameter(1, OracleTypes.NUMERIC);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
			cs.execute();
			Object result = cs.getObject(1);
			ResultSet rsPendientes = (ResultSet)cs.getObject(2);
			mensajes.clear();
			while (rsPendientes.next())
			{
				SincronizacionVUCE sinc = new SincronizacionVUCE();
				sinc.setId(new Integer(rsPendientes.getBigDecimal("id_sinc").intValue()));
				sinc.setReintento(new Integer(rsPendientes.getBigDecimal("reintento").intValue()));
				sinc.setIdVuce(new Integer(rsPendientes.getBigDecimal("id_vuce").intValue()));
				mensajes.add(sinc);
			}
			return OperationResult.getResult(((BigDecimal) result).doubleValue());
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
		} finally {
			cleanup(cs, rs);
			close(conn);
		}
		return OperationResult.Failure;
	}
	
	public OperationResult actualizarMensajeEnviado(SincronizacionVUCE sinc)  {
		String log = "actualizarMensajeEnviado";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
            cs = conn.prepareCall(ACTUALIZAR_MENSAJE_ENVIADO);
            cs.registerOutParameter(1, OracleTypes.NUMERIC);
            cs.setInt(2, sinc.getId().intValue());
            cs.setInt(3, sinc.getIdVuce().intValue());
            cs.execute();
            Object result = cs.getObject(1);
			return OperationResult.getResult(((BigDecimal) result).doubleValue());
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
		} finally {
			cleanup(cs, rs);
			close(conn);
		}
		return OperationResult.Failure;
	}
	
	public OperationResult actualizarMensajeLog(SincronizacionVUCE sinc) {
		String log = "actualizarMensajeLog";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
            cs = conn.prepareCall(ACTUALIZAR_MENSAJE_LOG);
            cs.registerOutParameter(1, OracleTypes.NUMERIC);
            cs.setInt(2, sinc.getId().intValue());
			cs.setInt(3, sinc.getReintento().intValue());
			cs.setInt(4, sinc.getIdVuce().intValue());
			cs.setBlob(5, BaseDao.bytesToBlob(conn, sinc.getResultado()));
			cs.execute();
			Object result = cs.getObject(1);
			return OperationResult.getResult(((BigDecimal) result).doubleValue());
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
		} finally {
			cleanup(cs, rs);
			close(conn);
		}
		return OperationResult.Failure;
	}
	
}
