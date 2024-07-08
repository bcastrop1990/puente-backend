package pe.gob.senasa.vuce.integrador.mappers;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;



import pe.gob.senasa.vuce.integrador.bean.ProcesoBPM;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;

public class ColaProcesoBpmMapper extends BaseDao {
	public static final String OBTENER_PROCESOS_BPM = "{ ?=call PCKG_COLA_PROCESO_BPM.FN_GET(?,?) }";
	public static final String ENCOLAR_MENSAJE_ERROR = "{ call VUCE.PCKG_COLA_PROCESO_BPM.SP_PUT_ERROR(?) }";
	public static final String ACTUALIZAR_PROCESO_INSTANCIA = "{ call VUCE.PCKG_COLA_PROCESO_BPM.SP_ACTUALIZAR_INSTANCIA(?,?) }";
	
	public boolean obtenerProcesoBPM(ProcesoBPM proceso, String strTipo)
	{
		String log = "obtenerMensajes";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
            cs = conn.prepareCall(OBTENER_PROCESOS_BPM);
            cs.registerOutParameter(1, OracleTypes.NUMERIC);
            cs.setString(2, strTipo);
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.execute();
            Object result = cs.getObject(1);
            rs = (ResultSet)cs.getObject(3);
			if (rs.next())
			{
				proceso.setId(rs.getDouble("Id"));
				proceso.setFormato(rs.getString("Codigo_Formato"));
				proceso.setCodigoServicio(rs.getString("Codigo_Servicio"));
				proceso.setNumeroDocumento(rs.getString("Numero_Documento"));
				proceso.setNumeroDocumentoRef(rs.getString("Numero_Documento_Ref"));
				proceso.setBpmProxyClase(rs.getString("Proxy_Clase"));
				proceso.setBpmProxyMetodo(rs.getString("Proxy_Metodo"));
				return (((BigDecimal) result).intValue() == 1 ) ? true : false;
			}
			return false;
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
			return false;
		} finally {
			cleanup(cs, rs);
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
	
	public boolean actualizarProcesoInstancia(Double notificacionId, String instanciaId)
	{
		String log = "actualizarProcesoInstancia";
		Connection conn = null;
		CallableStatement cs = null;
		try {
			conn = getConnection();
            cs = conn.prepareCall(ACTUALIZAR_PROCESO_INSTANCIA);
            cs.setDouble(1, notificacionId);
            cs.setString(2, instanciaId);
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
