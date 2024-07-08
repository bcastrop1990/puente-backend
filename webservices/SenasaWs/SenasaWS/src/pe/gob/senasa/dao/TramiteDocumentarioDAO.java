package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.DocumentoElectronico;
import pe.gob.senasa.bean.Encargatura;
import pe.gob.senasa.bean.ReporteSTD;
import pe.gob.senasa.bean.Sede;
import pe.gob.senasa.bean.SubTipo;
import pe.gob.senasa.bean.audit.Audit;
import pe.gob.senasa.bean.std.DocumentoSTD;
import pe.gob.senasa.bean.std.Expediente;
import pe.gob.senasa.connection.ConnectionSenasa;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.db.TramiteDocumentarioSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.TramiteDocumentarioInterface;


public class TramiteDocumentarioDAO extends BaseDAO implements TramiteDocumentarioInterface {

    protected static Logger logger = Logger.getLogger(TramiteDocumentarioDAO.class);
    private DBHelper helper;

    public TramiteDocumentarioDAO() {
        super();
        helper = new DBHelper(SenasaSQL.dsTramDocu);
    }

    public String obtenerCodigoCarga() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String dCode = df.format(new Date());
        return dCode;
    }

    public ArrayList<Sede> obtenerCentroTramites() {
        ProductoDAO pdao = new ProductoDAO();
        return pdao.obtenerSedes();
    }

    public String obtenerNombreImpresoraFiscalXCentroTramite(String codigo) {
        String sql = SenasaSQL.OBTENER_IMPRESORA_X_SEDE;

        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String retval = "";
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, codigo);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval = rs.getString(1);
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerNombreImpresoraFiscalXCentroTramite", e);
        } catch (Exception e) {
            Log("obtenerNombreImpresoraFiscalXCentroTramite", e);
        } finally {
            cleanup(con, pst);
        }
        return retval;
    }

    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("TramiteDocumentarioDAO - " + s, p2);
    }

    public void eliminarNumeracioDocumento(String subTipo, String area, String subArea, String personaId) {
        String sql = TramiteDocumentarioSQL.ELIMINAR_NUMERACION_DOCUMENTO_STD;
        Log("Ejecutando: " + sql);
        Connection con = null;
        CallableStatement cs = null;

        try {
            con = helper.getConnection();
            cs = con.prepareCall(sql);

            cs.setString(1, subTipo);
            cs.setString(2, area);
            cs.setString(3, subArea);
            cs.setString(4, personaId);
            cs.execute();
        } catch (SQLException e) {
            Log("actualizarDocumento", e);
        } catch (Exception e) {
            Log("actualizarDocumento", e);
        } finally {
            cleanup(con, cs, null);
        }
    }

    public String registrarDocumento(DocumentoSTD documento, String usuario) {
        String sql = TramiteDocumentarioSQL.REGISTRAR_DOCUMENTO_STD;
        Log(" registrarDocumento Ejecutando: " + sql);
        Connection con = null;
        CallableStatement cs = null;
        String codigo = null;

        try {

            con = helper.getConnection();
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.setString(2, documento.getNombre());
            cs.setString(3, documento.getEscenario());
            cs.setString(4, documento.getTipo());
            cs.setString(5, documento.getSubTipo());
            cs.setString(6, documento.getAutor());
            cs.setString(7, documento.getAutorId());
            cs.setString(8, documento.getUcmId());
            cs.setString(9, documento.getCodigoDocPadre());
            cs.setString(10, usuario);
            cs.setString(11, documento.getTipo_doc());
            //cs.setDate(12, documento.getFechahora()!=null?new java.sql.Date(documento.getFechahora().getTime()):null);
            // cs.setDate(14,reporteSTD.getFecha()!=null?new java.sql.Date(reporteSTD.getFecha().getTime()):null);   // p_fecha
            cs.execute();
            codigo = cs.getString(1);
            Log("registrarDocumento CODIGO= " + codigo);
        } catch (SQLException e) {
            Log("registrarDocumento", e);
        } catch (Exception e) {
            Log("registrarDocumento", e);
        } finally {
            cleanup(con, cs, null);
        }
        return codigo;
    }

    public void actualizarDocumento(DocumentoSTD documento, String usuario) {
        String sql = TramiteDocumentarioSQL.ACTUALIZAR_DOCUMENTO_STD;
        Log("Ejecutando: " + sql);
        Connection con = null;
        CallableStatement cs = null;

        try {
            con = helper.getConnection();
            cs = con.prepareCall(sql);

            cs.setString(1, documento.getCodigo());
            cs.setString(2, documento.getNombre());
            cs.setString(3, documento.getUcmId());
            cs.setString(4, usuario);
            cs.execute();
        } catch (SQLException e) {
            Log("actualizarDocumento", e);
        } catch (Exception e) {
            Log("actualizarDocumento", e);
        } finally {
            cleanup(con, cs, null);
        }
    }

  public void actualizarArchivo(DocumentoSTD documento, String usuario) {
      String sql = TramiteDocumentarioSQL.ACTUALIZAR_ARCHIVO_STD;
      Log("Ejecutando: " + sql);
      Connection con = null;
      CallableStatement cs = null;

      try {
          con = helper.getConnection();
          cs = con.prepareCall(sql);

          cs.setString(1, documento.getCodigo());
          cs.setString(2, documento.getNombre());
          cs.setString(3, documento.getArchivoFisico());
          cs.setString(4, documento.getArchivoFolio());
          cs.setString(5, usuario);
          cs.execute();
      } catch (SQLException e) {
          Log("actualizarArchivo", e);
      } catch (Exception e) {
          Log("actualizarArchivo", e);
      } finally {
          cleanup(con, cs, null);
      }
  }

    public void eliminarDocumentoAdjunto(DocumentoSTD documento) {
        String sql = TramiteDocumentarioSQL.ELIMINAR_DOCUMENTO_ADJUNTO_STD;
        Log("Ejecutando: " + sql);
        Connection con = null;
        CallableStatement cs = null;

        try {
            con = helper.getConnection();
            cs = con.prepareCall(sql);

            cs.setString(1, documento.getCodigoDocPadre());
            cs.setString(2, documento.getCodigo());
            cs.execute();
        } catch (SQLException e) {
            Log("eliminarDocumentoAdjunto", e);
        } catch (Exception e) {
            Log("eliminarDocumentoAdjunto", e);
        } finally {
            cleanup(con, cs, null);
        }
    }

    public ArrayList<DocumentoSTD> obtenerAdjuntos(DocumentoSTD doc) {
        String sql = TramiteDocumentarioSQL.OBTENER_DOCUMENTO_ADJUNTO_STD;
        Log(" AQUI VA EL " + sql);
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ArrayList<DocumentoSTD> retval = new ArrayList<DocumentoSTD>();

        try {
            con = helper.getConnection();
            cs = con.prepareCall(sql);

            cs.setString(1, doc.getCodigo());
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            Log(" = ENTRANDO = ");

            rs = (ResultSet)cs.getObject(2);

            while (rs.next()) {
                DocumentoSTD sol = new DocumentoSTD();
                sol.setCodigo(rs.getString("Codigo_Std_Doc"));
                sol.setNombre(rs.getString("Nombre"));
                sol.setEscenario(rs.getString("Escenario"));
                sol.setTipo(rs.getString("Tipo"));
                sol.setSubTipo(rs.getString("Sub_Tipo"));
                sol.setAutor(rs.getString("Autor"));
                sol.setUcmId(rs.getString("Ucm_Id"));
                sol.setTipo_doc(rs.getString("Tipo_Doc"));
                sol.setFechahora(rs.getDate("Fecha_Hora"));
                retval.add(sol);
            }
        } catch (SQLException e) {
            Log("obtenerAdjuntos", e);
        } catch (Exception e) {
            Log("obtenerAdjuntos", e);
        } finally {
            cleanup(con, cs, rs);
        }
        return retval;
    }

    public int verificaParticipacion(DocumentoSTD doc) {
        String sql = TramiteDocumentarioSQL.VERIFICAR_PARTICIPACION_STD;

        Log(" AQUI VA EL " + sql);

        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            con = helper.getConnection();
            cs = con.prepareCall(sql);

            cs.setString(1, doc.getNombre());
            cs.setString(2, doc.getAutor());
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            Log(" = ENTRANDO = ");
            rs = (ResultSet)cs.getObject(3);
            if (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            Log("verificaParticipacion", e);
        } catch (Exception e) {
            Log("verificaParticipacion", e);
        } finally {
            cleanup(con, cs, rs);
        }
        return 0;
    }

    public List<ReporteSTD> consultaSTDGeneral(ReporteSTD reporteSTD) {
        logger.info("****************** Inicio del m�todo consultaSTDGeneral ******************");
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<ReporteSTD> lstDatos = new ArrayList<ReporteSTD>();
        String sql = "{call Pckg_Documento_Std.Sp_ConsultaSTDGeneral(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        StringBuilder strLog = new StringBuilder();

        strLog.append("getNumeroDocumento=>" + reporteSTD.getNumeroDocumento() + "\n");
        strLog.append("getFechaRegDesde=>" + reporteSTD.getFechaRegDesde() + "\n");
        strLog.append("getFechaRegHasta=>" + reporteSTD.getFechaRegHasta() + "\n");
        strLog.append("getIdAreaEntidadRem=>" + reporteSTD.getIdAreaEntidadRem() + "\n");
        strLog.append("getIdAreaEntidadDest=>" + reporteSTD.getIdAreaEntidadDest() + "\n");
        strLog.append("getIdAreaEntidadRem=>" + reporteSTD.getIdSubAreaEntidadRem() + "\n");
        strLog.append("getIdAreaEntidadDest=>" + reporteSTD.getIdSubAreaEntidadDest() + "\n");
        strLog.append("getIdPersonaRem=>" + reporteSTD.getIdPersonaRem() + "\n");
        strLog.append("getIdPersonaDest=>" + reporteSTD.getIdPersonaDest() + "\n");
        strLog.append("getEstado=>" + reporteSTD.getEstado() + "\n");
        strLog.append("getAsunto=>" + reporteSTD.getAsunto() + "\n");
        strLog.append("getAccion=>" + reporteSTD.getAccion() + "\n");

        logger.info("consultaSTDGeneral - parametros Consulta==>" + strLog.toString());
        String fecha1Compare = "";
        String fecha2Compare = "";
        Calendar calDesde = Calendar.getInstance();
        Calendar calHasta = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (reporteSTD.getFechaRegDesde() != null) {
                fecha1Compare = sdf.format(reporteSTD.getFechaRegDesde());
                calDesde.setTime(reporteSTD.getFechaRegDesde());
            }
            if (reporteSTD.getFechaRegHasta() != null) {
                fecha2Compare = sdf.format(reporteSTD.getFechaRegHasta());
                calHasta.setTime(reporteSTD.getFechaRegHasta());
                calHasta.add(Calendar.DAY_OF_MONTH, +1);
            }


            cn = helper.getConnection();
            logger.info("consultaSTDGeneral - prepareCall");
            cs = cn.prepareCall(sql);

            cs.setString(1, reporteSTD.getNumeroDocumento());
            cs.setTimestamp(2, fecha1Compare == "" ? null : new Timestamp(calDesde.getTime().getTime())); //p_fechaDesde
            cs.setTimestamp(3, fecha2Compare == "" ? null : new Timestamp(calHasta.getTime().getTime())); //p_fechaHasta
            cs.setString(4, reporteSTD.getIdTipoOrigenDestino());
            cs.setString(5, reporteSTD.getIdAreaEntidadRem());
            cs.setString(6, reporteSTD.getIdSubAreaEntidadRem());
            cs.setString(7, reporteSTD.getIdPersonaRem());

            cs.setString(8, reporteSTD.getIdAreaEntidadDest());
            cs.setString(9, reporteSTD.getIdSubAreaEntidadDest());
            cs.setString(10, reporteSTD.getIdPersonaDest());
            cs.setString(11, reporteSTD.getIdTipoDocumental());
            cs.setString(12, reporteSTD.getIdSubTipoDocumental());
            cs.setString(13, reporteSTD.getAsunto());
            // cs.setDate(14,reporteSTD.getFecha()!=null?new java.sql.Date(reporteSTD.getFecha().getTime()):null);   // p_fecha
            cs.setString(14, reporteSTD.getAnio());
            cs.setString(15, reporteSTD.getEstado());
            cs.setString(16, reporteSTD.getIdProceso());
            cs.setString(17, reporteSTD.getAccion());
            cs.registerOutParameter(18, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("consultaSTDGeneral - Execute");
            cs.execute();
            logger.info("consultaSTDGeneral - getCursor");
            rs = (ResultSet)cs.getObject(18);
            ReporteSTD bReporte = null;
            while (rs.next()) {
                bReporte = new ReporteSTD();
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
            cleanup(cn, cs, rs);
        }
        return lstDatos;
    }

  public List<ReporteSTD> consultaSTDGeneralExterno(ReporteSTD reporteSTD) {
      logger.info("****************** Inicio del m�todo consultaSTDGeneral ******************");
      Connection cn = null;
      CallableStatement cs = null;
      ResultSet rs = null;
      List<ReporteSTD> lstDatos = new ArrayList<ReporteSTD>();
      String sql = "{call Pckg_Documento_Std.Sp_ConsultaSTDGeneralExterno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

      StringBuilder strLog = new StringBuilder();

      strLog.append("getNumeroDocumento=>" + reporteSTD.getNumeroDocumento() + "\n");
      strLog.append("getFechaRegDesde=>" + reporteSTD.getFechaRegDesde() + "\n");
      strLog.append("getFechaRegHasta=>" + reporteSTD.getFechaRegHasta() + "\n");
      strLog.append("getIdAreaEntidadRem=>" + reporteSTD.getIdAreaEntidadRem() + "\n");
      strLog.append("getIdAreaEntidadDest=>" + reporteSTD.getIdAreaEntidadDest() + "\n");
      strLog.append("getIdAreaEntidadRem=>" + reporteSTD.getIdSubAreaEntidadRem() + "\n");
      strLog.append("getIdAreaEntidadDest=>" + reporteSTD.getIdSubAreaEntidadDest() + "\n");
      strLog.append("getIdPersonaRem=>" + reporteSTD.getIdPersonaRem() + "\n");
      strLog.append("getIdPersonaDest=>" + reporteSTD.getIdPersonaDest() + "\n");
      strLog.append("getEstado=>" + reporteSTD.getEstado() + "\n");
      strLog.append("getAsunto=>" + reporteSTD.getAsunto() + "\n");
      strLog.append("getAccion=>" + reporteSTD.getAccion() + "\n");

      logger.info("consultaSTDGeneral - parametros Consulta==>" + strLog.toString());
      String fecha1Compare = "";
      String fecha2Compare = "";
      Calendar calDesde = Calendar.getInstance();
      Calendar calHasta = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

      try {
          if (reporteSTD.getFechaRegDesde() != null) {
              fecha1Compare = sdf.format(reporteSTD.getFechaRegDesde());
              calDesde.setTime(reporteSTD.getFechaRegDesde());
          }
          if (reporteSTD.getFechaRegHasta() != null) {
              fecha2Compare = sdf.format(reporteSTD.getFechaRegHasta());
              calHasta.setTime(reporteSTD.getFechaRegHasta());
              calHasta.add(Calendar.DAY_OF_MONTH, +1);
          }


          cn = helper.getConnection();
          logger.info("consultaSTDGeneral - prepareCall");
          cs = cn.prepareCall(sql);

          cs.setString(1, reporteSTD.getNumeroDocumento());
          cs.setTimestamp(2, fecha1Compare == "" ? null : new Timestamp(calDesde.getTime().getTime())); //p_fechaDesde
          cs.setTimestamp(3, fecha2Compare == "" ? null : new Timestamp(calHasta.getTime().getTime())); //p_fechaHasta
          cs.setString(4, reporteSTD.getIdTipoOrigenDestino());
          cs.setString(5, reporteSTD.getIdAreaEntidadRem());
          cs.setString(6, reporteSTD.getIdSubAreaEntidadRem());
          cs.setString(7, reporteSTD.getIdPersonaRem());

          cs.setString(8, reporteSTD.getIdAreaEntidadDest());
          cs.setString(9, reporteSTD.getIdSubAreaEntidadDest());
          cs.setString(10, reporteSTD.getIdPersonaDest());
          cs.setString(11, reporteSTD.getIdTipoDocumental());
          cs.setString(12, reporteSTD.getIdSubTipoDocumental());
          cs.setString(13, reporteSTD.getAsunto());
          // cs.setDate(14,reporteSTD.getFecha()!=null?new java.sql.Date(reporteSTD.getFecha().getTime()):null);   // p_fecha
          cs.setString(14, reporteSTD.getAnio());
          cs.setString(15, reporteSTD.getEstado());
          cs.setString(16, reporteSTD.getIdProceso());
          cs.setString(17, reporteSTD.getAccion());
          cs.registerOutParameter(18, OracleTypes.CURSOR, "SYS_REFCURSOR");
          logger.info("consultaSTDGeneral - Execute");
          cs.execute();
          logger.info("consultaSTDGeneral - getCursor");
          rs = (ResultSet)cs.getObject(18);
          ReporteSTD bReporte = null;
          while (rs.next()) {
              bReporte = new ReporteSTD();
              bReporte.setNumeroDocumento(rs.getString("numeroDoc"));
              bReporte.setAreaEntidadRem(rs.getString("remitente_entidad"));
              bReporte.setSubAreaEntidadRem(rs.getString("remitente_sub_entidad"));
              bReporte.setPersonaRem(rs.getString("remitente_persona"));
              bReporte.setAreaEntidadDest(rs.getString("destinatario_entidad"));
              bReporte.setSubAreaEntidadDest(rs.getString("destinatario_sub_entidad"));
              bReporte.setPersonaDest(rs.getString("destinatario_persona"));
              bReporte.setAsunto(rs.getString("descripcion_asunto"));
              bReporte.setCodElemento(rs.getString("codigo_elemento"));
              bReporte.setCodElementoRpta(rs.getString("codigo_elemento_respuesta"));
              bReporte.setFechaHora(rs.getDate("fecha_hora"));
              bReporte.setFecha(rs.getDate("fech_crea"));              
              lstDatos.add(bReporte);
          }
      } catch (Exception ex) {
          logger.debug("consultaSTDGeneral Error al realizar la consulta Exception: " + ex.getMessage());
      } finally {
          cleanup(cn, cs, rs);
      }
      return lstDatos;
  }

    public List<DocumentoSTD> consultaSTDDocumentos(String codElemento) {
        logger.info("****************** Inicio del m�todo consultaSTDDocumentos ******************");
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<DocumentoSTD> lstDatos = new ArrayList<DocumentoSTD>();
        String sql = "{call Pckg_Documento_Std.Sp_ConsultaDocumentos(?,?)}";

        StringBuilder strLog = new StringBuilder();
        strLog.append("codElemento=>" + codElemento + "\n");

        logger.info("consultaSTDDocumentos - parametros Consulta==>" + strLog.toString());


        try {

            cn = helper.getConnection();
            logger.info("consultaSTDDocumentos - prepareCall");
            cs = cn.prepareCall(sql);

            cs.setString(1, codElemento);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("consultaSTDDocumentos - Execute");
            cs.execute();
            logger.info("consultaSTDDocumentos - getCursor");
            rs = (ResultSet)cs.getObject(2);
            DocumentoSTD documentoSTD = null;
            while (rs.next()) {
                documentoSTD = new DocumentoSTD();
                documentoSTD.setCodigo(rs.getString("codigo_std_doc"));
                documentoSTD.setNombre(rs.getString("nombre"));
                documentoSTD.setEscenario(rs.getString("escenario"));
                documentoSTD.setTipo(rs.getString("tipo"));
                documentoSTD.setSubTipo(rs.getString("sub_tipo"));
                documentoSTD.setAutor(rs.getString("autor"));
                documentoSTD.setUcmId(rs.getString("ucm_id"));
                if (rs.getString("docprincipal") != null && rs.getString("docprincipal").equalsIgnoreCase("x")) {
                    documentoSTD.setIsDocPrincipal(true);
                } else {
                    documentoSTD.setIsDocPrincipal(false);
                }
                documentoSTD.setFechaCrea(rs.getTimestamp("fech_crea"));
                lstDatos.add(documentoSTD);
            }
        } catch (Exception ex) {
            logger.debug("consultaSTDDocumentos Error al realizar la consulta Exception: " + ex.getMessage());
        } finally {
            cleanup(cn, cs, rs);
        }
        return lstDatos;
    }

    public List<ReporteSTD> consultaSTDxIdFinal(String idFinal) {
        logger.info("****************** Inicio del m�todo consultaSTDxIdFinal ******************");
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<ReporteSTD> lstDatos = new ArrayList<ReporteSTD>();
        String sql = "{call Pckg_Documento_Std.Sp_ConsultaTrazaxIdFinal(?,?)}";

        StringBuilder strLog = new StringBuilder();

        strLog.append("idFinal=>" + idFinal + "\n");

        logger.info("consultaSTDxIdFinal - parametros Consulta==>" + strLog.toString());
        try {

            cn = helper.getConnection();
            logger.info("consultaSTDGeneral - prepareCall");
            cs = cn.prepareCall(sql);

            cs.setString(1, idFinal);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("consultaSTDxIdFinal - Execute");
            cs.execute();
            logger.info("consultaSTDxIdFinal - getCursor");
            rs = (ResultSet)cs.getObject(2);
            ReporteSTD bReporte = null;
            while (rs.next()) {
                bReporte = new ReporteSTD();
                bReporte.setNumeroDocumento(rs.getString("numeroDoc"));
                bReporte.setAreaEntidadRem(rs.getString("remitente_entidad"));
                bReporte.setSubAreaEntidadRem(rs.getString("remitente_sub_entidad"));
                bReporte.setPersonaRem(rs.getString("remitente_persona"));

                bReporte.setAreaEntidadDest(rs.getString("destinatario_entidad"));
                bReporte.setSubAreaEntidadDest(rs.getString("destinatario_sub_entidad"));
                bReporte.setPersonaDest(rs.getString("destinatario_persona"));

                bReporte.setProveido(rs.getString("proveido"));
                bReporte.setUrgencia(rs.getString("urgencia"));
                bReporte.setFecha(rs.getTimestamp("fech_crea"));
                bReporte.setEstado(rs.getString("estado"));
                bReporte.setNotas(rs.getString("notas"));
                lstDatos.add(bReporte);
            }
        } catch (Exception ex) {
            logger.debug("consultaSTDxIdFinal Error al realizar la consulta Exception: " + ex.getMessage());
        } finally {
            cleanup(cn, cs, rs);
        }
        return lstDatos;
    }

    public List<Encargatura> obtenerEncargatura(String usuario) {
        logger.info("****************** Inicio del m�todo obtenerEncargatura ******************");
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Encargatura> lstDatos = new ArrayList<Encargatura>();
        String sql = "{call Pckg_Usuario.Sp_Obtener_Encargatura(?,?)}";

        StringBuilder strLog = new StringBuilder();

        strLog.append("usuario=>" + usuario + "\n");

        logger.info("obtenerEncargatura - parametros Consulta==>" + strLog.toString());
        try {

            cn = helper.getConnection();
            logger.info("obtenerEncargatura - prepareCall");
            cs = cn.prepareCall(sql);

            cs.setString(1, usuario);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("obtenerEncargatura - Execute");
            cs.execute();
            logger.info("obtenerEncargatura - getCursor");
            rs = (ResultSet)cs.getObject(2);
            Encargatura bDoc = null;
            while (rs.next()) {
                bDoc = new Encargatura();
                bDoc.setCodigoEncargado(rs.getString("Codigo_Encargado"));
                bDoc.setAreaEncargado(rs.getString("Area_Encargado"));
                bDoc.setSubAreaEncargado(rs.getString("Sub_Area_Encargado"));
                bDoc.setCodigoEncargatura(rs.getString("Codigo_Encargatura"));
                bDoc.setNombreEncargatura(rs.getString("Nombre_Encargatura"));
                bDoc.setAreaEncargatura(rs.getString("Area_Encargatura"));
                bDoc.setSubAreaEncargatura(rs.getString("Sub_Area_Encargatura"));
                bDoc.setFechaIniEncargatura(rs.getString("Fecha_Ini_Encargatura"));
                bDoc.setFechaFinEncargatura(rs.getString("Fecha_Fin_Encargatura"));

                lstDatos.add(bDoc);
            }
        } catch (Exception ex) {
            logger.debug("obtenerEncargatura Error al realizar la consulta Exception: " + ex.getMessage());
        } finally {
            cleanup(cn, cs, rs);
        }
        return lstDatos;
    }

    public List<Encargatura> obtenerEncargado(String usuario) {
        logger.info("****************** Inicio del m�todo obtenerEncargado ******************");
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Encargatura> lstDatos = new ArrayList<Encargatura>();
        String sql = "{call Pckg_Usuario.Sp_Obtener_Encargado(?,?)}";

        StringBuilder strLog = new StringBuilder();

        strLog.append("usuario=>" + usuario + "\n");

        logger.info("obtenerEncargado - parametros Consulta==>" + strLog.toString());
        try {

            cn = helper.getConnection();
            logger.info("obtenerEncargado - prepareCall");
            cs = cn.prepareCall(sql);

            cs.setString(1, usuario);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("obtenerEncargado - Execute");
            cs.execute();
            logger.info("obtenerEncargado - getCursor");
            rs = (ResultSet)cs.getObject(2);
            Encargatura bDoc = null;
            while (rs.next()) {
                bDoc = new Encargatura();
                bDoc.setCodigoEncargado(rs.getString("Codigo_Encargado"));
                bDoc.setAreaEncargado(rs.getString("Area_Encargado"));
                bDoc.setSubAreaEncargado(rs.getString("Sub_Area_Encargado"));
                bDoc.setNombreEncargado(rs.getString("Nombre_Encargado"));
                lstDatos.add(bDoc);
            }
        } catch (Exception ex) {
            logger.debug("obtenerEncargado Error al realizar la consulta Exception: " + ex.getMessage());
        } finally {
            cleanup(cn, cs, rs);
        }
        return lstDatos;
    }

    public Boolean eliminarDocumentoSTD(String pcodigoSTD, String pIdUcm) {
        logger.info("****************** Inicio del m�todo eliminarDocumentoSTD ******************");
        String sql = TramiteDocumentarioSQL.ELIMINAR_DOCUMENTO_STD;
        Log("Ejecutando: " + sql);
        Connection cn = null;
        CallableStatement cs = null;
        Boolean rpta = false;
        logger.info("eliminarDocumentoSTD - par�metros Consulta==> pcodigoSTD= " + pcodigoSTD + " pIdUcm= " + pIdUcm);
        try {
            cn = helper.getConnection();
            logger.info("eliminarDocumentoSTD - prepareCall" + sql);
            cs = cn.prepareCall(sql);
            cs.setString(1, pcodigoSTD);
            cs.setString(2, pIdUcm);
            cs.execute();
            logger.info("eliminarDocumentoSTD - statement ejecutado");
            rpta = true;
        } catch (SQLException ex) {
            logger.error("eliminarDocumentoSTD Error al realizar la consulta Exception: " + ex.getMessage());
        } catch (Exception e) {
            logger.error("eliminarDocumentoSTD Error al realizar la consulta Exception: " + e.getMessage());
        } finally {
            cleanup(cn, cs, null);
        }
        return rpta;
    }

    public Documento generarDocumentoTramite(byte[] documentoFisico, String nombre, Documento documento) {
        return null;
    }

    public byte[] previsualizarIngresoDocTramite(byte[] documentoFisico, String nombre, Documento documento) {
        return new byte[0];
    }

    public List<DocumentoElectronico> obtenerBandejaElectronica() {
        logger.info("****************** Inicio del m�todo obtenerBandejaElectronica ******************");
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<DocumentoElectronico> lstDatos = new ArrayList<DocumentoElectronico>();
        String sql = "{call Integrador_Std.Pckg_Documento.Sp_Obtener_Bandeja(?)}";

        StringBuilder strLog = new StringBuilder();

        logger.info("obtenerBandejaElectronica - parametros Consulta==>" + strLog.toString());
        try {

            cn = helper.getConnection();
            logger.info("obtenerBandejaElectronica - prepareCall");
            cs = cn.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("obtenerBandejaElectronica - Execute");
            cs.execute();
            logger.info("obtenerBandejaElectronica - getCursor");
            rs = (ResultSet)cs.getObject(1);
            DocumentoElectronico bDoc = null;
            while (rs.next()) {
                bDoc = new DocumentoElectronico();
                bDoc.setIdEntidad(rs.getString("Id_Entidad"));
                bDoc.setIdTransaccion(rs.getString("Id_Transaccion"));
                bDoc.setCodigoElemento(rs.getString("Codigo_Documento"));
                bDoc.setNumeroDocumento(rs.getString("Numero_Documento"));
                bDoc.setArea(rs.getString("Area"));
                bDoc.setFecha(rs.getString("Fecha"));
                bDoc.setEntidad(rs.getString("Entidad"));
                bDoc.setRemitente(rs.getString("Remitente"));
                bDoc.setAsunto(rs.getString("Asunto"));
                bDoc.setEntidadIdPersona(rs.getString("entidad_id_persona"));
                bDoc.setEntidadDocumentoTipo(rs.getString("entidad_documento_tipo"));
                bDoc.setEntidadDocumentoNumero(rs.getString("entidad_documento_numero"));
                bDoc.setEntidadNombre(rs.getString("entidad_nombre"));
                lstDatos.add(bDoc);
            }
        } catch (Exception ex) {
            logger.debug("obtenerEncargatura Error al realizar la consulta Exception: " + ex.getMessage());
        } finally {
            cleanup(cn, cs, rs);
        }
        return lstDatos;
    }

    public void procesarDocumentoElectronico(String idEntidad, String idTransaccion, String codigoDocumento, String accion,
                                             String usuario) {
        String sql = "{ CALL Integrador_Std.Pckg_Documento.Sp_Procesar_Documento(?,?,?,?,?) }";
        Log("Ejecutando: " + sql);
        Connection con = null;
        CallableStatement cs = null;

        try {
            con = ConnectionSenasa.getSingletonObject().getConnTramDocu();//cnApp.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, idEntidad);
            cs.setString(2, idTransaccion);
            cs.setString(3, codigoDocumento);
            cs.setString(4, accion);
            cs.setString(5, usuario);
            cs.execute();
        } catch (SQLException e) {
            Log("procesarDocumentoElectronico", e);
        } catch (Exception e) {
            Log("procesarDocumentoElectronico", e);
        } finally {
            cleanup(con, cs, null);
        }
    }

    public Expediente obtenerExpedienteStd(String numeroExpediente) {
        logger.info("****************** Inicio del m�todo obtenerExpediente ******************");
        Expediente exp = new Expediente();
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        logger.info("Buscando expediente =>" + numeroExpediente + "\n");
        try {
            String sql = TramiteDocumentarioSQL.OBTENER_EXPEDIENTE;
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
            logger.debug("ObtenerExpediente Error: Exception: " + ex.getMessage());
            exp.getAuditoria().setEstado(false);
            exp.getAuditoria().setMensajeSistema("ObtenerExpediente Error: Exception: " + ex.getMessage());
        } finally {
            cleanup(cn, cs, rs);
        }
        return exp;
    }

    public DocumentoSTD obtenerDocumentoStd(String codigoDocumento, String numeroDocumento) {
        String log = "obtenerDocumentoStd";
        logger.info("****************** Inicio del m�todo " + log + " ******************");
        DocumentoSTD doc = new DocumentoSTD();
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        logger.info("Parametros =>" + numeroDocumento + "\n");
        try {
            String sql = TramiteDocumentarioSQL.OBTENER_DOCUMENTO;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.setString(1, codigoDocumento);
            cs.setString(2, numeroDocumento);
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("Ejecutando => " + sql);
            cs.execute();
            rs = (ResultSet)cs.getObject(3);
            while (rs.next()) {
                doc.setCodigo(rs.getString("Codigo_Std_Doc"));
                doc.setNombre(rs.getString("Nombre"));
                doc.setEscenario(rs.getString("Escenario"));
                doc.setTipo(rs.getString("Tipo"));
                doc.setSubTipo(rs.getString("Sub_Tipo"));
                doc.setAutor(rs.getString("Autor"));
                doc.setAutorId(rs.getString("Autor_Id"));
                doc.setUcmId(rs.getString("Ucm_Id"));
                doc.setEstado(rs.getString("Estado"));
                doc.setFechaCrea(rs.getDate("Fech_Crea"));
                doc.setFechahora(rs.getDate("Fecha_Hora"));
                doc.setNumeroExpediente(rs.getString("Codigo_Expediente"));
                doc.setArchivoFisico(rs.getString("Archivo_Fisico"));
                doc.setArchivoFolio(rs.getString("Archivo_Folio"));
            }
        } catch (Exception ex) {
            logger.debug(log + " :Error Exception: " + ex.getMessage());
            doc.getAuditoria().setEstado(false);
            doc.getAuditoria().setMensajeSistema(log + " :Error Exception: " + ex.getMessage());
        } finally {
            cleanup(cn, cs, rs);
        }
        return doc;
    }
    
    public List<SubTipo> obtenerTiposDocMesaPartes() {
        String log = "obtenerTiposDocMesaPartes";
        logger.info("****************** Inicio del m�todo " + log + " ******************");
        List<SubTipo> lista = new ArrayList<SubTipo>();
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            String sql = TramiteDocumentarioSQL.OBTENER_SUBTIPO_DOC_MP;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("Ejecutando => " + sql);
            cs.execute();
            rs = (ResultSet)cs.getObject(1);
            while (rs.next()) {
                SubTipo tipo = new SubTipo ();
                tipo.setDdoctype(rs.getString("Ddoctype"));
                tipo.setCodigoSubTipo(rs.getString("Codigosubtipo"));
                tipo.setDescripcion(rs.getString("Descripcionsubtipo"));
                lista.add(tipo);
            }
        } catch (Exception ex) {
            logger.debug(log + " :Error Exception: " + ex.getMessage());
        } finally {
            cleanup(cn, cs, rs);
        }
        return lista;
    }
    
    // ELIMINAR
    public Expediente registrarExpediente(String personaId, String codigoCentro, String observacion, String userName) {
        String log = "registrarExpediente";
        logger.info("****************** Inicio del m�todo " + log + " ******************");
        Expediente exp = new Expediente();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            String sql = TramiteDocumentarioSQL.REGISTRAR_EXPEDIENTE_STD;
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
            logger.debug(log + " :Error Exception: " + ex.getMessage());
        } finally {
            try {
                cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return exp;
    }
    
    public Audit anexarDocumentoExpediente(String codigoDocumento, String codigoExpediente, String userName) {
        String log = "anexarDocumentoExpediente";
        logger.info("****************** Inicio del m�todo " + log + " ******************");
        Audit audit = new Audit();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            String sql = TramiteDocumentarioSQL.ANEXAR_DOCUMENTO_EXPEDIENTE;
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
            logger.debug(log + " :Error Exception: " + ex.getMessage());
        } finally {
            try {
                cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return audit;
    }
    
}
