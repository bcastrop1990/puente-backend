package pe.gob.senasa.ws.documentoStd.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.ws.documentoStd.sql.SQLHelper;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.helper.LogHelper;
import pe.gob.senasa.helper.bean.Auditoria;
import pe.gob.senasa.ws.documentoStd.bean.DocumentoStd;
import pe.gob.senasa.ws.documentoStd.bean.ReporteItem;

public class DocumentoStdDAO {
    protected static Logger logger = Logger.getLogger(DocumentoStdDAO.class);
    private DBHelper helper;

    public DocumentoStdDAO() {
        super();
        helper = new DBHelper(SQLHelper.DATA_SOURCE_SENASA);
    }

    public String generarNumeroDocumento(Connection cn, String subTipo, String area, String subArea, String personaId) {
        String log = "generarNumeroDocumento";
        CallableStatement cstmt = null;
        String rpta = "Error";
        try {
            cstmt = cn.prepareCall(SQLHelper.CREAR_DOCUMENTO);
            logger.info("=======Inicio de generarNumeroDocumento en DB ======= ");
            logger.info(" subTipo = " + subTipo + " area=  " + area + " subArea=" + subArea + " personaId" + personaId);
            cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
            cstmt.setString(2, subTipo);
            cstmt.setString(3, area);
            cstmt.setString(4, subArea);
            cstmt.setString(5, personaId);
            cstmt.execute();
            logger.info(" Ejecut� correctamente ");
            rpta = cstmt.getString(1);
            logger.info(" resultado= " + rpta);
        } catch (Exception ex) {
            rpta = "ERROR Exception " + ex.getMessage();
            LogHelper.obtenerLogCompleto(logger, log, ex);
        }
        return rpta;
    }
    
    public List<ReporteItem> consultaGeneral(ReporteItem reporteFiltro) {
        logger.info("****************** Inicio del método consultaSTDGeneral ******************");
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<ReporteItem> lstDatos = new ArrayList<ReporteItem>();
        String sql = SQLHelper.CONSULTA_GENERAL;

        StringBuilder strLog = new StringBuilder();

        strLog.append("getNumeroDocumento=>" + reporteFiltro.getNumeroDocumento() + "\n");
        strLog.append("getNumeroExpediente=>" + reporteFiltro.getNumeroExpediente() + "\n");
        strLog.append("getFechaRegDesde=>" + reporteFiltro.getFechaRegDesde() + "\n");
        strLog.append("getFechaRegHasta=>" + reporteFiltro.getFechaRegHasta() + "\n");
        strLog.append("getIdAreaEntidadRem=>" + reporteFiltro.getIdAreaEntidadRem() + "\n");
        strLog.append("getIdAreaEntidadDest=>" + reporteFiltro.getIdAreaEntidadDest() + "\n");
        strLog.append("getIdAreaEntidadRem=>" + reporteFiltro.getIdSubAreaEntidadRem() + "\n");
        strLog.append("getIdAreaEntidadDest=>" + reporteFiltro.getIdSubAreaEntidadDest() + "\n");
        strLog.append("getIdPersonaRem=>" + reporteFiltro.getIdPersonaRem() + "\n");
        strLog.append("getIdPersonaDest=>" + reporteFiltro.getIdPersonaDest() + "\n");
        strLog.append("getEstado=>" + reporteFiltro.getEstado() + "\n");
        strLog.append("getAsunto=>" + reporteFiltro.getAsunto() + "\n");
        strLog.append("getAccion=>" + reporteFiltro.getAccion() + "\n");

        logger.info("consultaSTDGeneral - parametros Consulta==>" + strLog.toString());
        String fecha1Compare = "";
        String fecha2Compare = "";
        Calendar calDesde = Calendar.getInstance();
        Calendar calHasta = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            cn = helper.getConnection();
            if (reporteFiltro.getFechaRegDesde() != null) {
                fecha1Compare = sdf.format(reporteFiltro.getFechaRegDesde());
                calDesde.setTime(reporteFiltro.getFechaRegDesde());
            }
            if (reporteFiltro.getFechaRegHasta() != null) {
                fecha2Compare = sdf.format(reporteFiltro.getFechaRegHasta());
                calHasta.setTime(reporteFiltro.getFechaRegHasta());
                calHasta.add(Calendar.DAY_OF_MONTH, +1);
            }
            logger.info("consultaSTDGeneral - prepareCall");
            cs = cn.prepareCall(sql);

            cs.setString(1, reporteFiltro.getNumeroDocumento());
            cs.setString(2, reporteFiltro.getAsunto());
            cs.setString(3, reporteFiltro.getNumeroExpediente());
            cs.setTimestamp(4, fecha1Compare == "" ? null : new Timestamp(calDesde.getTime().getTime())); //p_fechaDesde
            cs.setTimestamp(5, fecha2Compare == "" ? null : new Timestamp(calHasta.getTime().getTime())); //p_fechaHasta
            cs.setString(6, reporteFiltro.getIdEscenarioRem());
            cs.setString(7, reporteFiltro.getIdEscenarioDest());
            cs.setString(8, reporteFiltro.getIdTipoDocumental());
            cs.setString(9, reporteFiltro.getIdSubTipoDocumental());
            
            cs.setString(10, reporteFiltro.getIdAreaEntidadRem());
            cs.setString(11, reporteFiltro.getIdSubAreaEntidadRem());
            cs.setString(12, reporteFiltro.getIdPersonaRem());
            cs.setString(13, reporteFiltro.getPersonaRem());
            cs.setString(14, reporteFiltro.getIdAreaEntidadDest());
            cs.setString(15, reporteFiltro.getIdSubAreaEntidadDest());
            cs.setString(16, reporteFiltro.getIdPersonaDest());
            cs.setString(17, reporteFiltro.getPersonaDest());
            
            cs.setString(18, reporteFiltro.getIdAreaFunc());
            cs.setString(19, reporteFiltro.getIdSubAreaFunc());
            cs.setString(20, reporteFiltro.getIdPersonaFunc());
            cs.setString(21, reporteFiltro.getPersonaFunc());
            
            cs.setString(22, reporteFiltro.getEstado());
            cs.setString(23, reporteFiltro.getIdProceso());
            cs.setString(24, reporteFiltro.getAccion());
            cs.registerOutParameter(25, OracleTypes.CURSOR, "SYS_REFCURSOR");
            
            System.out.println("getNumeroDocumento => " + reporteFiltro.getNumeroDocumento());
            System.out.println("getAsunto => " + reporteFiltro.getAsunto());
            System.out.println("getFechaRegDesde => " + (fecha1Compare == "" ? null : new Timestamp(calDesde.getTime().getTime())));
            System.out.println("getFechaRegHasta => " + (fecha2Compare == "" ? null : new Timestamp(calHasta.getTime().getTime())));
            System.out.println("getIdEscenarioRem => " + reporteFiltro.getIdEscenarioRem());
            System.out.println("getIdEscenarioDest => " + reporteFiltro.getIdEscenarioDest());
            System.out.println("getIdTipoDocumental => " + reporteFiltro.getIdTipoDocumental());
            System.out.println("getIdSubTipoDocumental => " + reporteFiltro.getIdSubTipoDocumental());
            
            System.out.println("getIdAreaEntidadRem => " + reporteFiltro.getIdAreaEntidadRem());
            System.out.println("getIdSubAreaEntidadRem => " + reporteFiltro.getIdSubAreaEntidadRem());
            System.out.println("getIdPersonaRem => " + reporteFiltro.getIdPersonaRem());
            System.out.println("getPersonaRem => " + reporteFiltro.getPersonaRem());

            System.out.println("getIdAreaEntidadDest => " + reporteFiltro.getIdAreaEntidadDest());
            System.out.println("getIdSubAreaEntidadDest => " + reporteFiltro.getIdSubAreaEntidadDest());
            System.out.println("getIdPersonaDest => " + reporteFiltro.getIdPersonaDest());
            System.out.println("getPersonaDest => " + reporteFiltro.getPersonaDest());
            
            System.out.println("getIdAreaFunc => " + reporteFiltro.getIdAreaFunc());
            System.out.println("getIdSubAreaFunc => " + reporteFiltro.getIdSubAreaFunc());
            System.out.println("getIdPersonaFunc => " + reporteFiltro.getIdPersonaFunc());
            System.out.println("getPersonaFunc => " + reporteFiltro.getPersonaFunc());
            
            System.out.println("getEstado => " + reporteFiltro.getEstado());
            System.out.println("getIdProceso => " + reporteFiltro.getIdProceso());
            System.out.println("getAccion => " + reporteFiltro.getAccion());
            
            logger.info("consultaSTDGeneral - Execute");
            cs.execute();
            logger.info("consultaSTDGeneral - getCursor");
            rs = (ResultSet)cs.getObject(25);
            ReporteItem bReporte = null;
            while (rs.next()) {
                bReporte = new ReporteItem();
                bReporte.setNumeroDocumento(rs.getString("numeroDoc"));
                bReporte.setAreaEntidadRem(rs.getString("remitente_entidad"));
                bReporte.setSubAreaEntidadRem(rs.getString("remitente_sub_entidad"));
                bReporte.setPersonaRem(rs.getString("remitente_persona"));
                bReporte.setAsunto(rs.getString("descripcion_asunto"));
                bReporte.setCodElemento(rs.getString("codigo_elemento"));
                bReporte.setCodElementoRpta(rs.getString("codigo_elemento_respuesta"));
                bReporte.setFecha(rs.getDate("fech_crea"));
                bReporte.setTipoCertificado(rs.getString("tipo_certificado"));
                lstDatos.add(bReporte);
            }
        } catch (Exception ex) {
            logger.debug("consultaSTDGeneral Error al realizar la consulta Exception: " + ex.getMessage());
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lstDatos;
    }
    
    public List<ReporteItem> consultaPendientes(ReporteItem reporteFiltro) {
        logger.info("****************** Inicio del método consultaSTDGeneral ******************");
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<ReporteItem> lstDatos = new ArrayList<ReporteItem>();
        String sql = SQLHelper.CONSULTA_PENDIENTES;

        StringBuilder strLog = new StringBuilder();
        logger.info("consultaPendientes - parametros Consulta==>" + strLog.toString());
        System.out.println("getIdAreaFunc => " + reporteFiltro.getIdAreaFunc());
        System.out.println("getIdSubAreaFunc => " + reporteFiltro.getIdSubAreaFunc());
        System.out.println("getIdPersonaFunc => " + reporteFiltro.getIdPersonaFunc());
        System.out.println("getEstado => " + reporteFiltro.getEstado());
        System.out.println("getIdProceso => " + reporteFiltro.getIdProceso());

        
        String fecha1Compare = "";
        String fecha2Compare = "";
        Calendar calDesde = Calendar.getInstance();
        Calendar calHasta = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            cn = helper.getConnection();
            if (reporteFiltro.getFechaRegDesde() != null) {
                fecha1Compare = sdf.format(reporteFiltro.getFechaRegDesde());
                calDesde.setTime(reporteFiltro.getFechaRegDesde());
            }
            if (reporteFiltro.getFechaRegHasta() != null) {
                fecha2Compare = sdf.format(reporteFiltro.getFechaRegHasta());
                calHasta.setTime(reporteFiltro.getFechaRegHasta());
            }
            cs = cn.prepareCall(sql);
            cs.setTimestamp(1, fecha1Compare == "" ? null : new Timestamp(calDesde.getTime().getTime())); //p_fechaDesde
            cs.setTimestamp(2, fecha2Compare == "" ? null : new Timestamp(calHasta.getTime().getTime())); //p_fechaHasta
            cs.setString(3, reporteFiltro.getIdAreaFunc());
            cs.setString(4, reporteFiltro.getIdSubAreaFunc());
            cs.setString(5, reporteFiltro.getIdPersonaFunc());
            cs.setString(6, reporteFiltro.getEstado());
            cs.setString(7, reporteFiltro.getIdProceso());
            cs.registerOutParameter(8, OracleTypes.CURSOR, "SYS_REFCURSOR");
            
            System.out.println("getFechaRegDesde => " + (fecha1Compare == "" ? null : new Timestamp(calDesde.getTime().getTime())));
            System.out.println("getFechaRegHasta => " + (fecha2Compare == "" ? null : new Timestamp(calHasta.getTime().getTime())));
            
            logger.info("consultaPendientes - Execute");
            cs.execute();
            logger.info("consultaPendientes - getCursor");
            rs = (ResultSet)cs.getObject(8);
            ReporteItem bReporte = null;
            while (rs.next()) {
                bReporte = new ReporteItem();
                bReporte.setNotas(rs.getString("Ucm_Id"));
                bReporte.setNumeroDocumento(rs.getString("Numero_documento"));
                bReporte.setAreaEntidadRem(rs.getString("remitente_entidad"));
                bReporte.setSubAreaEntidadRem(rs.getString("remitente_sub_entidad"));
                bReporte.setPersonaRem(rs.getString("remitente_persona"));
                bReporte.setIdPersonaRem(rs.getString("Remitente_usuario"));
                bReporte.setAsunto(rs.getString("descripcion_asunto"));
                bReporte.setCodElemento(rs.getString("codigo_elemento"));
                bReporte.setFechaHora(rs.getDate("Fecha_Hora"));
                bReporte.setAreaEntidadDest(rs.getString("Destinatario_Entidad"));
                bReporte.setSubAreaEntidadDest(rs.getString("Destinatario_Entidad"));
                bReporte.setPersonaDest(rs.getString("Destinatario_Persona"));
                bReporte.setIdPersonaDest(rs.getString("Destinatario_usuario"));
                bReporte.setUrgencia(rs.getString("Urgencia"));
                bReporte.setProveido(rs.getString("Proveido"));
                bReporte.setEstado(rs.getString("Estado"));
                lstDatos.add(bReporte);
            }
        } catch (Exception ex) {
            logger.debug("consultaPendientes Error al realizar la consulta Exception: " + ex.getMessage());
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lstDatos;
    }

    public List<ReporteItem> reporteGeneral(ReporteItem reporteFiltro) {
        logger.info("****************** Inicio del método consultaSTDGeneral ******************");
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<ReporteItem> lstDatos = new ArrayList<ReporteItem>();
        String sql = SQLHelper.REPORTE_GENERAL;

        StringBuilder strLog = new StringBuilder();

        strLog.append("getNumeroDocumento=>" + reporteFiltro.getNumeroDocumento() + "\n");
        strLog.append("getFechaRegDesde=>" + reporteFiltro.getFechaRegDesde() + "\n");
        strLog.append("getFechaRegHasta=>" + reporteFiltro.getFechaRegHasta() + "\n");
        strLog.append("getIdAreaEntidadRem=>" + reporteFiltro.getIdAreaEntidadRem() + "\n");
        strLog.append("getIdAreaEntidadDest=>" + reporteFiltro.getIdAreaEntidadDest() + "\n");
        strLog.append("getIdAreaEntidadRem=>" + reporteFiltro.getIdSubAreaEntidadRem() + "\n");
        strLog.append("getIdAreaEntidadDest=>" + reporteFiltro.getIdSubAreaEntidadDest() + "\n");
        strLog.append("getIdPersonaRem=>" + reporteFiltro.getIdPersonaRem() + "\n");
        strLog.append("getIdPersonaDest=>" + reporteFiltro.getIdPersonaDest() + "\n");
        strLog.append("getEstado=>" + reporteFiltro.getEstado() + "\n");
        strLog.append("getAsunto=>" + reporteFiltro.getAsunto() + "\n");
        strLog.append("getAccion=>" + reporteFiltro.getAccion() + "\n");

        logger.info("consultaSTDGeneral - parametros Consulta==>" + strLog.toString());
        String fecha1Compare = "";
        String fecha2Compare = "";
        Calendar calDesde = Calendar.getInstance();
        Calendar calHasta = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            cn = helper.getConnection();
            if (reporteFiltro.getFechaRegDesde() != null) {
                fecha1Compare = sdf.format(reporteFiltro.getFechaRegDesde());
                calDesde.setTime(reporteFiltro.getFechaRegDesde());
            }
            if (reporteFiltro.getFechaRegHasta() != null) {
                fecha2Compare = sdf.format(reporteFiltro.getFechaRegHasta());
                calHasta.setTime(reporteFiltro.getFechaRegHasta());
                calHasta.add(Calendar.DAY_OF_MONTH, +1);
            }
            logger.info("consultaSTDGeneral - prepareCall");
            cs = cn.prepareCall(sql);

            cs.setString(1, reporteFiltro.getNumeroDocumento());
            cs.setTimestamp(2, fecha1Compare == "" ? null : new Timestamp(calDesde.getTime().getTime())); //p_fechaDesde
            cs.setTimestamp(3, fecha2Compare == "" ? null : new Timestamp(calHasta.getTime().getTime())); //p_fechaHasta
            cs.setString(4, reporteFiltro.getIdTipoOrigenDestino());
            cs.setString(5, reporteFiltro.getIdAreaEntidadRem());
            cs.setString(6, reporteFiltro.getIdSubAreaEntidadRem());
            cs.setString(7, reporteFiltro.getIdPersonaRem());

            cs.setString(8, reporteFiltro.getIdAreaEntidadDest());
            cs.setString(9, reporteFiltro.getIdSubAreaEntidadDest());
            cs.setString(10, reporteFiltro.getIdPersonaDest());
            cs.setString(11, reporteFiltro.getIdTipoDocumental());
            cs.setString(12, reporteFiltro.getIdSubTipoDocumental());
            cs.setString(13, reporteFiltro.getAsunto());
            // cs.setDate(14,reporteSTD.getFecha()!=null?new java.sql.Date(reporteSTD.getFecha().getTime()):null);   // p_fecha
            cs.setString(14, reporteFiltro.getAnio());
            cs.setString(15, reporteFiltro.getEstado());
            cs.setString(16, reporteFiltro.getIdProceso());
            cs.setString(17, reporteFiltro.getAccion());
            cs.registerOutParameter(18, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("consultaSTDGeneral - Execute");
            cs.execute();
            logger.info("consultaSTDGeneral - getCursor");
            rs = (ResultSet)cs.getObject(18);
            ReporteItem bReporte = null;
            while (rs.next()) {
                bReporte = new ReporteItem();
                bReporte.setNumeroDocumento(rs.getString("numeroDoc"));
                bReporte.setAreaEntidadRem(rs.getString("remitente_entidad"));
                bReporte.setSubAreaEntidadRem(rs.getString("remitente_sub_entidad"));
                bReporte.setPersonaRem(rs.getString("remitente_persona"));
                bReporte.setAsunto(rs.getString("descripcion_asunto"));
                bReporte.setCodElemento(rs.getString("codigo_elemento"));
                bReporte.setCodElementoRpta(rs.getString("codigo_elemento_respuesta"));
                bReporte.setFecha(rs.getDate("fech_crea"));
                lstDatos.add(bReporte);
            }
        } catch (Exception ex) {
            logger.debug("consultaSTDGeneral Error al realizar la consulta Exception: " + ex.getMessage());
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lstDatos;
    }

    public DocumentoStd registrarDocumento(DocumentoStd documento, String usuario) {
        String log = "registrarDocumento";
        logger.info("****************** Inicio del método " + log + " ******************");
        Connection cn = null;
        CallableStatement cs = null;
        DocumentoStd doc = new DocumentoStd();
        doc.setAuditoria(new Auditoria());
        try {
            cn = helper.getConnection();
            cs = cn.prepareCall(SQLHelper.REGISTRAR_DOCUMENTO);
            logger.info("Ejecutando => " + SQLHelper.REGISTRAR_DOCUMENTO + " / params: " + documento.getNumeroDocumento());
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.setString(2, documento.getNumeroDocumento());
            cs.setString(3, documento.getEscenario());
            cs.setString(4, documento.getTipo());
            cs.setString(5, documento.getSubTipo());
            cs.setString(6, documento.getAutor());
            cs.setString(7, documento.getAutorId());
            cs.setString(8, documento.getUcmId());
            cs.setString(9, documento.getCodigoPadre());
            cs.setString(10, usuario);
            cs.setString(11, documento.getTipoAdjunto());
            cs.execute();
            doc.setCodigo(cs.getString(1));
            logger.info("Ejecutando => " + SQLHelper.REGISTRAR_DOCUMENTO + " / params OUT: " + doc.getCodigo());
        } catch (SQLException ex) {
            doc.getAuditoria().setEstado(false);
            doc.getAuditoria().setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
        } catch (Exception ex) {
            doc.getAuditoria().setEstado(false);
            doc.getAuditoria().setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doc;
    }

    public Auditoria actualizarDocumento(DocumentoStd documento, String usuario) {
        String log = "actualizarDocumento";
        logger.info("****************** Inicio del método " + log + " ******************");
        Connection cn = null;
        CallableStatement cs = null;
        Auditoria audit = new Auditoria();
        try {
            cn = helper.getConnection();
            cs = cn.prepareCall(SQLHelper.ACTUALIZAR_DOCUMENTO);
            logger.info("Ejecutando => " + SQLHelper.ACTUALIZAR_DOCUMENTO + " / params: " + documento.getNumeroDocumento() +
                        " | " + documento.getConfidencial() + " | " + documento.getUcmId() + " | " + documento.getFolio());
            cs.setString(1, documento.getCodigo());
            cs.setString(2, documento.getNumeroDocumento());
            cs.setString(3, documento.getConfidencial());
            cs.setString(4, documento.getUcmId());
            cs.setString(5, documento.getFolio());
            cs.setString(6, usuario);
            cs.setString(7, documento.getFisico());/*RCF*/
            cs.execute();
        } catch (SQLException ex) {
            audit.setEstado(false);
            audit.setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
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
    
    public Auditoria grabarDocEnRegistroArchivo(String codigoDocumento, String nombreDocumento, String idDocumento, String ucmId) {
        String log = "grabarDocEnRegistroArchivo";
        logger.info("****************** Inicio del método " + log + " ******************");
        Connection cn = null;
        CallableStatement cs = null;
        Auditoria audit = new Auditoria();
        try {
            cn = helper.getConnection();
            cs = cn.prepareCall(SQLHelper.GRABAR_DOC_REGISTRO_ARCHIVO);
            logger.info("Ejecutando => " + SQLHelper.GRABAR_DOC_REGISTRO_ARCHIVO + " / params: " + codigoDocumento +
                        " | " +nombreDocumento + " | " + idDocumento + " | " + ucmId);
            cs.setString(1, codigoDocumento);
            cs.setString(2, nombreDocumento);
            cs.setString(3, idDocumento);
            cs.setString(4, ucmId);
            cs.execute();
        } catch (SQLException ex) {
            audit.setEstado(false);
            audit.setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
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
    
    public DocumentoStd grabarDocAnexo(String codExpediente, String tipo, String subTipo, String nombre, String usuario) {
        String log = "grabarDocAnexo";
        logger.info("****************** Inicio del método " + log + " ******************");
        Connection cn = null;
        CallableStatement cs = null;
        DocumentoStd resultado = new DocumentoStd();
        resultado.setAuditoria(new Auditoria());
        try {
            cn = helper.getConnection();
            cs = cn.prepareCall(SQLHelper.GRABAR_DOC_ANEXO);
            logger.info("Ejecutando => " + SQLHelper.GRABAR_DOC_ANEXO + " / params: " + codExpediente + " | " + tipo + " | " + 
                        subTipo + " | " + nombre + " | " + usuario);
            cs.setString(1, codExpediente);
            cs.setString(2, tipo);
            cs.setString(3, subTipo);
            cs.setString(4, nombre);
            cs.setString(5, usuario);
            cs.registerOutParameter(6, OracleTypes.VARCHAR);
            cs.execute();
            resultado.setCodigo(cs.getString(6));
        } catch (SQLException ex) {
            resultado.getAuditoria().setEstado(false);
            resultado.getAuditoria().setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
        } catch (Exception ex) {
            resultado.getAuditoria().setEstado(false);
            resultado.getAuditoria().setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
        } finally {
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
    
    public Auditoria grabarResolutivoProv(String centroTraminte, String codigoExpediente, String personaId, 
                                          String codigoProcedimiento, String usuario, String documentos, 
                                          String destinatario, String canal, String observacion) {
        String log = "grabarResolutivoProv";
        logger.info("****************** Inicio del m鴯do " + log + " ******************");
        Connection cn = null;
        CallableStatement cs = null;
        Auditoria audit = new Auditoria();
        try {
            cn = helper.getConnection();
            cs = cn.prepareCall(SQLHelper.GRABAR_RESOLUTIVO_PROV);
            logger.info("Ejecutando => " + SQLHelper.GRABAR_RESOLUTIVO_PROV + " / params: " + centroTraminte + 
                        codigoExpediente + personaId + codigoProcedimiento + usuario + documentos + 
                        destinatario + canal + observacion);
            cs.setString(1, centroTraminte);
            cs.setString(2, codigoExpediente);
            cs.setString(3, personaId);
            cs.setString(4, codigoProcedimiento);
            cs.setString(5, usuario);
            cs.setString(6, documentos);
            cs.setString(7, destinatario);
            cs.setString(8, canal);
            cs.setString(9, observacion);
            cs.registerOutParameter(10, OracleTypes.VARCHAR);
            cs.execute();
        } catch (SQLException ex) {
            audit.setEstado(false);
            audit.setMensajeSistema(ex.getMessage());
            LogHelper.obtenerLogCompleto(logger, log, ex);
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


    public Auditoria consultarParticipacion(String codigoDocumento, String participante) {
        String log = "consultarParticipacion";
        logger.info("****************** Inicio del método " + log + " ******************");
        Connection cn = null;
        CallableStatement cs = null;
        Auditoria audit = new Auditoria();
        try {
            cn = helper.getConnection();
            cs = cn.prepareCall(SQLHelper.CONSULTAR_PARTICIPACION);
            logger.info("Ejecutando => " + SQLHelper.CONSULTAR_PARTICIPACION + " / params: " + codigoDocumento + " | " +
                        participante);
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.setString(2, codigoDocumento);
            cs.setString(3, participante);
            cs.execute();
            int cantidad = cs.getInt(1);
            if (cantidad == 0) {
                audit.setEstado(false);
                audit.setMensajeUsuario("El usuario no tiene permisos para acceder al documento.");
            }
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
