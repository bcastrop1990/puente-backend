package pe.gob.senasa.ws.expediente.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.helper.LogHelper;
import pe.gob.senasa.helper.bean.Auditoria;
import pe.gob.senasa.ws.expediente.bean.Expediente;
import pe.gob.senasa.ws.expediente.sql.SQLHelper;

public class ExpedienteDAO {
    protected static Logger logger = Logger.getLogger(ExpedienteDAO.class);
    private DBHelper helper;

    public ExpedienteDAO() {
        super();
        helper = new DBHelper(SQLHelper.DATA_SOURCE_SENASA);
    }
    
    public Expediente obtenerExpedienteVuce(String numeroExpediente, String numeroOrden) {
        logger.info("****************** Inicio del m�todo obtenerExpedienteVuce ******************");
        Expediente exp = new Expediente();
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        logger.info("Buscando expediente =>" + numeroExpediente + "\n");
        try {
            String sql = SQLHelper.OBTENER_EXPEDIENTE_VUCE;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.setString(1, numeroExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("Ejecutando => " + sql);
            cs.execute();
            rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                if (rs.getString("orden_vuce") != null && rs.getString("orden_vuce").equals(numeroOrden)) {
                    exp.setNumero(rs.getString("Codigo_Expediente"));
                    exp.setFecha(rs.getString("fecha_registro"));
                    exp.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));
                    exp.setDescripcionCentroTramite(rs.getString("Descripcion_Centro_Tramite"));
                    exp.setCodigoServicio(rs.getString("Codigo_Servicio"));
                    exp.setDescripcionAreaGestion(rs.getString("Descripcion_Area_Gestion"));
                    exp.setDescripcionProcedimietoTupa(rs.getString("Descripcion_Procedimieto_Tupa"));
                    exp.setDescripcionServicio(rs.getString("Descripcion_Servicio"));
                    exp.setIdPersona(rs.getString("Persona_Id"));             
                    exp.setNombreRazonSocial(rs.getString("Nombre_Razon_Social"));
                    exp.setCodigoSolicitud(rs.getString("Codigo_Solicitud"));
                    exp.setUcmId(rs.getString("Ucm_Id"));
                    exp.setCodigoProcedimientoTupa(rs.getString("Codigo_Procedimiento_Tupa"));
                    exp.setOrdenVuce(rs.getString("orden_vuce"));
                    exp.setCanal(rs.getString("canal"));
                    exp.setEstado(rs.getString("estado"));
                }
            }
        } catch (Exception ex) {
            logger.debug("obtenerExpedienteVuce Error: Exception: " + ex.getMessage());
            exp.getAuditoria().setEstado(false);
            exp.getAuditoria().setMensajeSistema("obtenerExpedienteVuce Error: Exception: " + ex.getMessage());
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return exp;
    }
    
    public Expediente obtenerExpedienteTupa(String numeroExpediente) {
        logger.info("****************** Inicio del m�todo obtenerExpedienteVuce ******************");
        Expediente exp = new Expediente();
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        logger.info("Buscando expediente =>" + numeroExpediente + "\n");
        try {
            String sql = SQLHelper.OBTENER_EXPEDIENTE_TUPA;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.setString(1, numeroExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("Ejecutando => " + sql);
            cs.execute();
            rs = (ResultSet)cs.getObject(2);
            if (rs.next()) {
                exp.setNumero(rs.getString("Codigo_Expediente"));
                exp.setFecha(rs.getString("fecha_registro"));
                exp.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));
                exp.setDescripcionCentroTramite(rs.getString("Descripcion_Centro_Tramite"));
                exp.setCodigoServicio(rs.getString("Codigo_Servicio"));
                exp.setDescripcionAreaGestion(rs.getString("Descripcion_Area_Gestion"));
                exp.setDescripcionProcedimietoTupa(rs.getString("Descripcion_Procedimieto_Tupa"));
                exp.setDescripcionServicio(rs.getString("Descripcion_Servicio"));
                exp.setIdPersona(rs.getString("Persona_Id"));             
                exp.setNombreRazonSocial(rs.getString("Nombre_Razon_Social"));
                exp.setCodigoSolicitud(rs.getString("Codigo_Solicitud"));
                exp.setUcmId(rs.getString("Ucm_Id"));
                exp.setCodigoProcedimientoTupa(rs.getString("Codigo_Procedimiento_Tupa"));
                exp.setOrdenVuce(rs.getString("orden_vuce") == null ? "" : rs.getString("orden_vuce"));
                exp.setCanal(rs.getString("canal"));
                exp.setCerrado(rs.getString("cerrado"));
                exp.setCodigoStdDoc(rs.getString("Codigo_Std_Doc"));
            }
        } catch (Exception ex) {
            logger.debug("obtenerExpedienteVuce Error: Exception: " + ex.getMessage());
            exp.getAuditoria().setEstado(false);
            exp.getAuditoria().setMensajeSistema("obtenerExpedienteVuce Error: Exception: " + ex.getMessage());
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return exp;
    }

    public Expediente obtenerExpedienteStd(String numeroExpediente) {
        logger.info("****************** Inicio del m�todo obtenerExpedienteStd ******************");
        Expediente exp = new Expediente();
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        logger.info("Buscando expediente =>" + numeroExpediente + "\n");
        try {
            String sql = SQLHelper.OBTENER_EXPEDIENTE_STD;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.setString(1, numeroExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("Ejecutando => " + sql);
            cs.execute();
            rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                exp.setNumero(rs.getString("Numero_Expediente"));
                exp.setIdPersona(rs.getString("Persona_Id"));
            }
        } catch (Exception ex) {
            logger.debug("obtenerExpedienteStd Error: Exception: " + ex.getMessage());
            exp.getAuditoria().setEstado(false);
            exp.getAuditoria().setMensajeSistema("obtenerExpedienteStd Error: Exception: " + ex.getMessage());
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return exp;
    }

    public Expediente registrarExpediente(String personaId, String codigoCentro, String observacion, String userName) {
        String log = "registrarExpediente";
        logger.info("****************** Inicio del m�todo " + log + " ******************");
        Expediente exp = new Expediente();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            String sql = SQLHelper.REGISTRAR_EXPEDIENTE_STD;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.setString(2, "STD");
            cs.setString(3, null);
            cs.setString(4, personaId);
            cs.setString(5, codigoCentro);
            cs.setString(6, observacion);
            cs.setString(7, userName);
            logger.info("Ejecutando => " + sql + " / params: " + personaId + " | " + codigoCentro + " | " + observacion + " | " + userName);
            cs.execute();
            exp.setNumero(cs.getString(1));
        } catch (Exception ex) {
            exp.getAuditoria().setEstado(false);
            exp.getAuditoria().setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return exp;
    }

    public Auditoria anexarDocumentoExpediente(String codigoDocumento, String codigoExpediente, String userName) {
        String log = "anexarDocumentoExpediente";
        logger.info("****************** Inicio del m�todo " + log + " ******************");
        Auditoria audit = new Auditoria();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            String sql = SQLHelper.ANEXAR_DOCUMENTO_EXPEDIENTE;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.setString(1, codigoDocumento);
            cs.setString(2, codigoExpediente);
            cs.setString(3, userName);
            logger.info("Ejecutando => " + sql + " / params: " + codigoDocumento + " | " + codigoExpediente + " | " + userName);
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
    
    public Auditoria registrarTrazabilidadTUPAInicio(String codigoExpediente, String codigoRecibo, String canal, String userName) {
        String log = "registrarTrazabilidadInicio";
        logger.info("****************** Inicio del m鴯do " + log + " ******************");
        Auditoria audit = new Auditoria();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            String sql = SQLHelper.REGISTRAR_TRAZA_TUPA_INICIO;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.setString(1, codigoExpediente);
            cs.setString(2, codigoRecibo);
            cs.setString(3, canal);
            cs.setString(4, userName != null ? userName.toUpperCase() : userName);
            logger.info("Ejecutando => " + sql + " / params: " + codigoExpediente + " | " + codigoRecibo + " | " + canal + " | " + userName);
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
    
    public Auditoria cierreTotal(String numeroExpediente, String userName, String estadoDictamen) {
        String log = "cierreTotal";
        logger.info("****************** Inicio del m鴯do " + log + " ******************");
        Auditoria audit = new Auditoria();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            String sql = SQLHelper.CIERRE_TOTAL;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.setString(1, numeroExpediente);
            cs.setString(2, userName);
            cs.setString(3, estadoDictamen);
            logger.info("Ejecutando => " + sql + " / params: " + numeroExpediente + " | " + userName);
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
    
    public Expediente cerrarExpediente(String codigoCentro, String codigoExpediente, String personaId, String codigoProcedimiento, String userId, String documentos) {
        String log = "cerrarExpediente";
        logger.info("****************** Inicio del metodo " + log + " ******************");
        Expediente exp = new Expediente();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            String sql = SQLHelper.GRABAR_DOCUMENTO_RESOLUTIVO;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.setString(1, codigoCentro);
            cs.setString(2, codigoExpediente);
            cs.setString(3, personaId);
            cs.setString(4, codigoProcedimiento);
            cs.setString(5, userId);
            cs.setString(6, documentos);
            cs.registerOutParameter(7, OracleTypes.VARCHAR);
            logger.info("Ejecutando => " + sql + " / params: " + codigoCentro + " | " + codigoExpediente + " | " + personaId + " | " + codigoProcedimiento + " | " + userId + " | " + documentos );
            cs.execute();
            exp.setNumero(cs.getString(7));
        } catch (Exception ex) {
            exp.getAuditoria().setEstado(false);
            exp.getAuditoria().setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return exp;
    }
    
  public Expediente obtenerOrdenPorMTO(String numeroMTO) {
      logger.info("****************** Inicio del m�todo obtenerExpedienteStd ******************");
      Expediente exp = new Expediente();
      Connection cn = null;
      CallableStatement cs = null;
      ResultSet rs = null;
      logger.info("Buscando expediente =>" + numeroMTO + "\n");
      try {
          String sql = SQLHelper.OBTENER_ORDEN_POR_MTO;
          cn = helper.getConnection();
          cs = cn.prepareCall(sql);
          cs.setString(1, numeroMTO);
          cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
          logger.info("Ejecutando => " + sql);
          cs.execute();
          rs = (ResultSet)cs.getObject(2);
          while (rs.next()) {
              exp.setOrdenVuce(rs.getString("orden_numero"));
          }
      } catch (Exception ex) {
          logger.debug("obtenerExpedienteStd Error: Exception: " + ex.getMessage());
          exp.getAuditoria().setEstado(false);
          exp.getAuditoria().setMensajeSistema("obtenerExpedienteStd Error: Exception: " + ex.getMessage());
      } finally {
          try {
              helper.cleanup(cn, cs, null);
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      return exp;
  }
}
