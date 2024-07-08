package pe.gob.senasa.ws.trazabilidad.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Timestamp;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.helper.LogHelper;
import pe.gob.senasa.helper.bean.Auditoria;
import pe.gob.senasa.ws.trazabilidad.bean.Trazabilidad;
import pe.gob.senasa.ws.trazabilidad.sql.SQLHelper;

public class TrazabilidadDAO  {
    protected static Logger logger = Logger.getLogger(TrazabilidadDAO.class);
    private DBHelper helper;
    
    public TrazabilidadDAO() {
        super();
        helper = new DBHelper(SQLHelper.DATA_SOURCE_SENASA);
    }
    
    protected String getSchemaName() {
            return "FINALBPM";
    }

    public Trazabilidad insertarTrazabilidad(String usuario, Trazabilidad trazabilidad) {
        String log = "insertarTrazabilidad";
        logger.info("****************** Inicio del método " + log + " ******************");
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = helper.getConnection();
            cs = cn.prepareCall(SQLHelper.INSERTAR_TRAZABILIDAD);
            logger.info("Ejecutando => " + SQLHelper.INSERTAR_TRAZABILIDAD);
            cs.setString(1, trazabilidad.getProceso());
            cs.setString(2, trazabilidad.getIdOriginal());
            cs.setString(3, trazabilidad.getIdFinal());
            cs.registerOutParameter(4, OracleTypes.NUMBER);
            cs.setTimestamp(5, new Timestamp(trazabilidad.getFechaHora().getTime()));
            cs.setString(6, trazabilidad.getDescripcionAsunto());
            cs.setString(7, trazabilidad.getRemitenteAreaEntidad());
            cs.setString(8, trazabilidad.getRemitenteSubAreaEntidad());
            cs.setString(9, trazabilidad.getRemitentePersona());
            cs.setString(10,  trazabilidad.getRemitenteUsuario() != null ? trazabilidad.getRemitenteUsuario().toUpperCase() :  trazabilidad.getRemitenteUsuario());
            cs.setString(11, trazabilidad.getDestinatarioAreaEntidad());
            cs.setString(12, trazabilidad.getDestinatarioSubAreaEntidad());
            cs.setString(13, trazabilidad.getDestinatarioPersona());
            cs.setString(14, trazabilidad.getDestinatarioUsuario() != null ? trazabilidad.getDestinatarioUsuario().toUpperCase() : trazabilidad.getDestinatarioUsuario());
            cs.setString(15, trazabilidad.getAccion());
            cs.setString(16, trazabilidad.getEstado());
            cs.setString(17, trazabilidad.getNotas());
            cs.setString(18, trazabilidad.getProveido());
            cs.setString(19, trazabilidad.getUrgencia());
            cs.setString(20, trazabilidad.getCanal());
            cs.setInt(21, trazabilidad.getSecuencialSuperior());
            cs.setString(22, trazabilidad.getCodigoElemento());
            cs.setString(23, trazabilidad.getCodigoElementoRespuesta());
            cs.setString(24, usuario);
            cs.setString(25, trazabilidad.getUcmid());
            cs.execute();
            trazabilidad.setSecuencial(cs.getInt(4));
        } catch (Exception ex) {
            trazabilidad.getAuditoria().setEstado(false);
            trazabilidad.getAuditoria().setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return trazabilidad;
    }

    public Auditoria actualizarTrazabilidad(String usuario, Trazabilidad trazabilidad) {
        String log = "actualizarTrazabilidad";
        logger.info("****************** Inicio del método " + log + " ******************");
        Connection cn = null;
        CallableStatement cs = null;
        Auditoria audit = new Auditoria();
        try {
            cn = helper.getConnection();
            cs = cn.prepareCall(SQLHelper.ACTUALIZAR_TRAZABILIDAD);
            logger.info("Ejecutando => " + SQLHelper.ACTUALIZAR_TRAZABILIDAD + " / params: " + trazabilidad.getIdOriginal() + " | " + trazabilidad.getIdFinal() + " | " + usuario);
            cs.setString(1, trazabilidad.getIdOriginal());
            cs.setString(2, trazabilidad.getIdFinal());
            cs.setString(3, usuario);
            cs.execute();
        } catch (Exception ex) {
            audit.setEstado(false);
            audit.setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return audit;
    }
}
