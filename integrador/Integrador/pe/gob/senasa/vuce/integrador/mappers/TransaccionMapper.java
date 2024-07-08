package pe.gob.senasa.vuce.integrador.mappers;

import java.sql.CallableStatement;
import java.sql.Connection;

import oracle.jdbc.OracleTypes;

import pe.gob.senasa.vuce.integrador.bean.MensajeVUCE;
import pe.gob.senasa.vuce.integrador.bean.TransaccionVuce;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;

public class TransaccionMapper extends BaseDao {
	public static final String PROCESAR_TRANSACCION = "{ ?=call VUCE.PCKG_TRANSACCION.FN_PROCESAR(?,?,?,?,?,?,?) }";
	public static final String PROCESAR_TRANSACCION_NOTIFICACION = "{ ?=call VUCE.PCKG_TRANSACCION.Fn_Procesar_Notificacion(?) }";
	public static final String REGISTRAR_TRANSACCION = "{ call VUCE.PCKG_TRANSACCION.SP_REGISTRAR(?,?,?,?,?,?,?,?,?,?,?) }";
	public static final String REGISTRAR_TRANSACCION_XML = "{ call VUCE.PCKG_TRANSACCION.SP_REGISTRAR(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
	public static final String ALMACENAR_EBXML = "{ call VUCE.PCKG_EBXML_PARSE.SP_INSERT_EBXML(?,?) }";

	public String fnProcesar(Connection conn, TransaccionVuce xml) throws Exception {
		String log = "fnProcesar";
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall(PROCESAR_TRANSACCION);
			cs.registerOutParameter(1, OracleTypes.VARCHAR);
			cs.setString(2, xml.getTipoMensaje());
			cs.setString(3, xml.getFormato());
			cs.setString(4, xml.getDocumento().getTipo());
			cs.setString(5, xml.getDocumento().getNumero());
			cs.setString(6, xml.getDocumentoReferencia().getTipo());
			cs.setString(7, xml.getDocumentoReferencia().getNumero());
			cs.setDate(8, BaseDao.dateToSqlDate(xml.getDocumento().getFechaDoc()));
			cs.execute();
			return (String) cs.getString(1);
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
			throw ex;
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (Exception ex) {
					LogHelper.obtenerLogCompleto(log, ex);
				}
			}
		}
	}
	
	public String fnProcesarNotificacion(String idNotificacion) throws Exception {
		String log = "fnProcesar";
		Connection conn = null;
		CallableStatement cs = null;
		try {
			conn = getConnection();
			cs = conn.prepareCall(PROCESAR_TRANSACCION_NOTIFICACION);
			cs.registerOutParameter(1, OracleTypes.VARCHAR);
			cs.setString(2, idNotificacion);
			cs.execute();
			return (String) cs.getString(1);
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
			throw ex;
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (Exception ex) {
					LogHelper.obtenerLogCompleto(log, ex);
				}
			}
			close(conn);
		}
	}

	public void spRegistrar(Connection conn, TransaccionVuce xml) throws Exception {
		String log = "spRegistrar";
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall(REGISTRAR_TRANSACCION);
			cs.registerOutParameter(1, OracleTypes.NUMBER);
			cs.setDouble(2, xml.getIdTransaccion());
			cs.setString(3, xml.getTipoMensaje());
			cs.setString(4, xml.getFormato());
			cs.setString(5, xml.getDocumento().getTipo());
			cs.setString(6, xml.getDocumento().getNumero());
			cs.setDouble(7, (xml.getDocumento().getMonto()==null ? 0 : xml.getDocumento().getMonto()));
			cs.setDate(8, BaseDao.dateToSqlDate(xml.getDocumento().getFechaDoc()));
			cs.setString(9, xml.getDocumentoReferencia().getTipo());
			cs.setString(10, xml.getDocumentoReferencia().getNumero());
			cs.setDate(11, BaseDao.dateToSqlDate(xml.getDocumento().getFechaDoc()));
			cs.execute();
			xml.setIdRegistroDocumento(cs.getDouble(1));
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
			throw ex;
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (Exception ex) {
					LogHelper.obtenerLogCompleto(log, ex);
				}
			}
		}
	}
	
	public void spRegistrarConXML(Connection conn, MensajeVUCE msj) throws Exception {
		String log = "spRegistrarConXML";
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall(REGISTRAR_TRANSACCION_XML);
			cs.registerOutParameter(1, OracleTypes.NUMBER);
			cs.setDouble(2, msj.getTransaccion().getIdTransaccion());
			cs.setString(3, msj.getTransaccion().getTipoMensaje());
			cs.setString(4, msj.getTransaccion().getFormato());
			cs.setString(5, msj.getTransaccion().getDocumento().getTipo());
			cs.setString(6, msj.getTransaccion().getDocumento().getNumero());
			cs.setDouble(7, (msj.getTransaccion().getDocumento().getMonto()==null ? 0 : msj.getTransaccion().getDocumento().getMonto()));
			cs.setDate(8, BaseDao.dateToSqlDate(msj.getTransaccion().getDocumento().getFechaDoc()));
			cs.setString(9, msj.getTransaccion().getDocumentoReferencia().getTipo());
			cs.setString(10, msj.getTransaccion().getDocumentoReferencia().getNumero());
			cs.setString(11, msj.getTransaccion().getNotificaciones());
			cs.setString(12, msj.getTransaccion().getError());
			cs.setBlob(13, BaseDao.bytesToBlob(conn, msj.getXmlTransaccion().getBytes()));
			if (msj.hasEbXML())
				cs.setBlob(14, BaseDao.bytesToBlob(conn, msj.getEbXmlTransaccion().getBytes()));
			else
				cs.setNull(14, OracleTypes.BLOB);
			cs.execute();
			msj.getTransaccion().setIdRegistroDocumento(cs.getDouble(1));
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
			throw ex;
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (Exception ex) {
					LogHelper.obtenerLogCompleto(log, ex);
				}
			}
		}
	}

	public void spInsertEbxml(Connection conn, MensajeVUCE mensaje) throws Exception {
		String log = "spInsertEbxml";
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall(ALMACENAR_EBXML);
			cs.setDouble(1, mensaje.getTransaccion().getIdTransaccion());
			cs.setBlob(2, BaseDao.bytesToBlob(conn, mensaje.getEbXmlTransaccion().getBytes()));
			cs.execute();
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
			throw ex;
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (Exception ex) {
					LogHelper.obtenerLogCompleto(log, ex);
				}
			}
		}
	}
}