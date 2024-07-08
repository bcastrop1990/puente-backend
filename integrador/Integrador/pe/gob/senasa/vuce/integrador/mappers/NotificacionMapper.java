package pe.gob.senasa.vuce.integrador.mappers;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;



import pe.gob.senasa.vuce.integrador.bean.NotificacionVUCE;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;

public class NotificacionMapper extends BaseDao {
	public static final String OBTENER_MENSAJES = "{ ? = call VUCE.PCKG_COLA_NOTIFICACION.FN_GET(?,?) }";
	public static final String OBTENER_MENSAJES_CANAL = "{ ? = call VUCE.PCKG_COLA_NOTIFICACION.FN_GET(?,?,?) }";
	public static final String ENCOLAR_MENSAJE_ERROR = "{ call VUCE.PCKG_COLA_NOTIFICACION.SP_PUT_ERROR(?) }";
	
	public boolean obtenerMensajes(NotificacionVUCE notificacion, String colaSufijo)
	{
		String log = "obtenerMensajes";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rsNotif = null;
		ResultSet rsNotifAdjunto = null;
		try {
			conn = getConnection();
			if (colaSufijo != null && !colaSufijo.trim().isEmpty()) {
				cs = conn.prepareCall(OBTENER_MENSAJES_CANAL);
			} else {
				cs = conn.prepareCall(OBTENER_MENSAJES);
			}
        	cs.registerOutParameter(1, OracleTypes.NUMERIC);
        	cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
        	cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
			if (colaSufijo != null && !colaSufijo.trim().isEmpty()) {
				cs.setString(4, colaSufijo);
			}
            cs.execute();
            Object result = cs.getObject(1);
            rsNotif = (ResultSet)cs.getObject(2);
			rsNotifAdjunto = (ResultSet)cs.getObject(3);
			if (rsNotif.next())
			{
				notificacion.setId(rsNotif.getBigDecimal("id"));
				notificacion.setTipoMensaje(rsNotif.getString("Tipo_Mensaje"));
				Blob xmlBlob = rsNotif.getBlob("notificacion");
				notificacion.setXml((xmlBlob == null ? null : xmlBlob.getBytes(1, (int) xmlBlob.length())));
				notificacion.getAdjuntos().clear();
				notificacion.getAdjuntosEntrada().clear();
				while(rsNotifAdjunto.next())
				{
					String nombre = rsNotifAdjunto.getString("Nombre");
					Blob blob = rsNotifAdjunto.getBlob("Archivo");
					String ucmId = rsNotifAdjunto.getString("Ucm_Id");
					String modo = rsNotifAdjunto.getString("Modo");
					if (modo.equals("SALIDA")) {
						if (nombre.equals("EBXML")) {
							notificacion.setEbXml((blob == null ? null : blob.getBytes(1, (int) blob.length())));
							notificacion.setUcmIdXml(ucmId);
						}
						else
							notificacion.setAdjuntos( nombre ,(blob == null ? null : blob.getBytes(1, (int) blob.length())), ucmId);
					}
					if (modo.equals("ENTRADA")) {
						Double idAdjunto = rsNotifAdjunto.getDouble("Id");
						notificacion.setAdjuntosEntrada(idAdjunto, nombre, (blob == null ? null : blob.getBytes(1, (int) blob.length())), ucmId);
					}
				}
				return (((BigDecimal) result).intValue() == 1 ) ? true : false;
			}
			return false;
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto( log, ex);
			return false;
		} finally {
			cleanup(cs, rsNotif);
			cleanup(null, rsNotifAdjunto);
			close(conn);
		}
	}
	
	public boolean encolarMensajeError(Double notificacionId)
	{
		String log = "encolarMensajeError";
		Connection conn = null;
		CallableStatement cs = null;
		try {
			conn = getConnection();
            cs = conn.prepareCall(ENCOLAR_MENSAJE_ERROR);
            cs.setDouble(1, notificacionId);
            cs.execute();
			return true;
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
			return false;
		} finally {
			cleanup(cs, null);
			close(conn);
		}
	}
}

