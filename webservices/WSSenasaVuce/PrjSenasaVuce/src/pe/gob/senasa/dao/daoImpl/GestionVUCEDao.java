package pe.gob.senasa.dao.daoImpl;

import java.io.ByteArrayInputStream;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.jdbc.OracleTypes;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Adjunto;
import pe.gob.senasa.bean.AdjuntoDocumento;
import pe.gob.senasa.bean.Auditoria;
import pe.gob.senasa.bean.CertificadoPlantaTratamiento;
import pe.gob.senasa.bean.ConceptoInspeccion;
import pe.gob.senasa.bean.ConsultaTecnica;
import pe.gob.senasa.bean.DatosExpo;
import pe.gob.senasa.bean.DatosIIV;
import pe.gob.senasa.bean.DocumentosAdjuntos;
import pe.gob.senasa.bean.Expediente;
import pe.gob.senasa.bean.LoteInspeccion;
import pe.gob.senasa.bean.Pais;
import pe.gob.senasa.bean.Persona;
import pe.gob.senasa.bean.ProductoIiv;
import pe.gob.senasa.bean.ProductoInspeccion;
import pe.gob.senasa.bean.SolicitudLugarProduccion;
import pe.gob.senasa.dao.IGestionVUCEDao;
import pe.gob.senasa.db.ConnectionDB;
import pe.gob.senasa.db.UtilSQL;



public class GestionVUCEDao implements IGestionVUCEDao {
    protected static Logger logger = Logger.getLogger(GestionVUCEDao.class);
    ConnectionDB conect = null;
    String strTxId = "";

    public GestionVUCEDao() {
        super();
        conect = new ConnectionDB();
    }

    public ConsultaTecnica obtenerDatosConsultaTecnica(String txId,
                                                       String codigoCT,
                                                       String canal) {

        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);
        logger.info(strTxId + " CodigoCT:" + codigoCT + " - Canal:" + canal);
        logger.info(strTxId +
                    " ********Inicio del Método Obtener Datos Consulta Tecnica VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.GET_CONSULTA_TECNICA;
        ConsultaTecnica ct = new ConsultaTecnica();
        Auditoria auditoria = new Auditoria();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, codigoCT);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(4, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(5, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(6, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.execute();

            logger.info(strTxId + " Listando Datos: Reg_Con_Tec");
            rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                ct.setAsunto(rs.getString("asunto"));
                ct.setNombre(rs.getString("nombre_razon_social"));
                ct.setPaisDestino(rs.getString("pais_dest"));
                ct.setPaisProcedencia(rs.getString("pais_proc"));
                ct.setPregunta(rs.getString("descripcion_consulta"));
                ct.setAplicacion(rs.getString("descripcion_aplicacion"));
                ct.setOperacion(rs.getString("operacion"));
                ct.setRucdni(rs.getString("ruc"));
            }

            logger.info(strTxId + " Listando Datos: Reg_Con_Tec_Prod");
            rs = (ResultSet)cs.getObject(3);
            while (rs.next()) {
                ct.setDescComercial(rs.getString("nombre_comercial_producto"));
                ct.setDescProducto(rs.getString("nombre_cientifico_producto"));
                ct.setPartidaArancelaria(rs.getString("partida"));
                ct.setUnidadMedida(rs.getString("desc_unid_med"));
                ct.setSubPartidaNacional(rs.getString("partida"));
                ct.setCantidad(rs.getInt("cantidad"));
            }

            logger.info(strTxId + " Listando Datos: Reg_Con_Tec_Origen");
            rs = (ResultSet)cs.getObject(4);
            while (rs.next()) {
                ct.setPaisOrigen(rs.getString("nomb_pais_tpa"));
            }

            logger.info(strTxId + " Listando Datos: Reg_Con_Tec_Resp");
            rs = (ResultSet)cs.getObject(6);
            while (rs.next()) {
                logger.info(strTxId + "respuesta: " +
                            rs.getString("respuesta"));
                ct.setRespuesta(rs.getString("respuesta"));
                logger.info(strTxId + "base_legal: " +
                            rs.getString("base_legal"));
                ct.setBaseLegal(rs.getString("base_legal"));
                logger.info(strTxId + "ucm_id: " + rs.getString("ucm_id"));
                ct.setUcmIdRespuesta(rs.getString("ucm_id"));
                logger.info(strTxId + "fecha_respuesta: " +
                            rs.getString("fecha_respuesta"));
                ct.setFechaRespuesta(rs.getDate("fecha_respuesta"));
            }

            logger.info(strTxId + " Lista completada");

            //No error
            auditoria.setTxId(txId);
            auditoria.setErrorCode("0");
            auditoria.setErrorMsg("");
            ct.setAuditoria(auditoria);

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
            //SQL error
            auditoria.setTxId(txId);
            auditoria.setErrorCode("1");
            auditoria.setErrorMsg("Error en BD");
            ct.setAuditoria(auditoria);

        } catch (Exception e) {
            logger.error(strTxId + " Exception : ", e);
            //Other error
            auditoria.setTxId(txId);
            auditoria.setErrorCode("1");
            auditoria.setErrorMsg(e.getMessage());
            ct.setAuditoria(auditoria);

        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             e);
            }
        }
        return ct;
    }

    public Auditoria ingresarRespuestaConsultaTecnica(String txId,
                                                      String codigoCT,
                                                      String respuesta,
                                                      String baseLegal,
                                                      String ucmIdRespuesta,
                                                      Date fechaRespuesta) {
        /* */
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);
        logger.info(strTxId + " CodigoCT:" + codigoCT + " - Respuesta:" +
                    respuesta + " - Base Legal:" + baseLegal +
                    " - ucmIdRespuesta:" + ucmIdRespuesta +
                    " - Fecha Respuesta:" + fechaRespuesta);
        logger.info(strTxId +
                    " ********Inicio del Método Ingresar Respuesta Consulta Tecnica VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.INS_RPTA_CONSULTA_TECNICA;
        Auditoria resp = new Auditoria();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, codigoCT);
            cs.setInt(2, 1); //Secuencial
            cs.setString(3, respuesta);
            cs.setString(4, baseLegal);
            cs.setString(5, ucmIdRespuesta);
            java.sql.Date sqlDateFRpta =
                new java.sql.Date(fechaRespuesta.getTime());
            cs.setDate(6, sqlDateFRpta);
            //java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            //java.util.Date jDate = new java.util.Date(sDate.getTime());

            logger.info(strTxId + " Ejecutando SP");
            cs.executeQuery();

            //No error
            logger.info(strTxId + " Se registro respuesta CT");
            resp.setTxId(txId);
            resp.setErrorCode("0");
            resp.setErrorMsg("");

        } catch (SQLException e) {
            logger.error(strTxId + " SQLException : ", e);
            //SQL error
            resp.setTxId(txId);
            resp.setErrorCode("1");
            resp.setErrorMsg("Error en BD: " + e.getMessage());
        } catch (Exception e) {
            logger.error(strTxId + " Exception : ", e);
            //Other error
            resp.setTxId(txId);
            resp.setErrorCode("1");
            resp.setErrorMsg(e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             e);
            }
        }
        return resp;
    }


    public List<AdjuntoDocumento> obtenerAdjuntos(String txId,
                                                  String codExpediente) {

        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);

        logger.info(strTxId + " codExpediente:" + codExpediente);

        logger.info(strTxId +
                    " ********Inicio del Método Obtener documentos adjuntos VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.GET_DOC_ADJUNTO;
        List<AdjuntoDocumento> lista = new ArrayList<AdjuntoDocumento>();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, codExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.executeQuery();
            rs = (ResultSet)cs.getObject(2);
            logger.info(strTxId + "Listando datos");
            AdjuntoDocumento b = null;
            while (rs.next()) {
                b = new AdjuntoDocumento();
                b.setId(rs.getLong("id"));
                b.setIdDocumento(rs.getLong("id_documento"));
                b.setIdRequisito(rs.getString("id_requisito"));
                b.setNombre(rs.getString("nombre"));
                b.setUcmId(rs.getString("ucm_id"));
                b.setEstado(rs.getString("estado_registro"));
                lista.add(b);
            }
            logger.info(strTxId + "Lista completada");

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return lista;
    }

    public String enviarNotificacion(String txId, String tipoMensaje,
                                     String docTipo, String docNumero,
                                     String docCategoriaDr, Double tasa,
                                     Integer plazo, String docRefTipo,
                                     String docRefNumero, String texto,
                                     String error,
                                     DocumentosAdjuntos adjuntos) {
        int resultado = 0;
        String mensaje = "";
        String sql = UtilSQL.ENVIAR_NOTIFICACION;
        strTxId = "[" + txId + "]";

        logger.info("TxId: " + strTxId +
                    " ********Inicio del Método Cierre de Tramite VUCE********");
        logger.info(strTxId + " * tipoMensaje => " + tipoMensaje);
        logger.info(strTxId + " * docTipo => " + docTipo);
        logger.info(strTxId + " * docNumero => " + docNumero);
        logger.info(strTxId + " * docCategoriaDr => " + docCategoriaDr);
        logger.info(strTxId + " * tasa => " + tasa);
        logger.info(strTxId + " * plazo => " + plazo);
        logger.info(strTxId + " * docRefTipo => " + docRefTipo);
        logger.info(strTxId + " * docRefNumero => " + docRefNumero);
        logger.info(strTxId + " * texto => " + texto);
        logger.info(strTxId + " * error => " + error);
        logger.info(strTxId + " * adjuntos => " +
                    (adjuntos != null ? adjuntos.getListaAdjuntos().size() :
                     "null"));
        logger.info(strTxId + " *** SP => " + sql);

        Connection con = null;
        CallableStatement cs = null;
        try {
            con = conect.getConnection();
            cs = con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.setString(3, tipoMensaje);
            cs.setString(4, docTipo);
            cs.setString(5, docNumero);
            cs.setString(6, docCategoriaDr);
            cs.setDouble(7, tasa);
            cs.setInt(8, plazo);
            cs.setString(9, docRefTipo);
            cs.setString(10, docRefNumero);
            cs.setString(11, texto);
            cs.setString(12, error);

            StructDescriptor structDescriptorAdj =
                new StructDescriptor("VUCE.DOCUMENTO_UCM", con);
            ArrayDescriptor descriptorAnx =
                ArrayDescriptor.createDescriptor("VUCE.DOCUMENTOS_UCM", con);
            STRUCT arregloDocts[] =
                new STRUCT[adjuntos.getListaAdjuntos().size()];
            if (adjuntos != null && adjuntos.getListaAdjuntos() != null) {
                for (int i = 0; i < adjuntos.getListaAdjuntos().size(); i++) {
                    AdjuntoDocumento beanDoc =
                        adjuntos.getListaAdjuntos().get(i);
                    if (beanDoc != null && beanDoc.getUcmId() != null &&
                        !beanDoc.getUcmId().isEmpty()) {
                        String[] documento = new String[2];
                        documento[0] = beanDoc.getUcmId();
                        documento[1] = beanDoc.getNombre();
                        logger.info(strTxId + " beanDoc.getNombre():" +
                                    beanDoc.getNombre() +
                                    " beanDoc.getUcmId():" +
                                    beanDoc.getUcmId());
                        arregloDocts[i] =
                                new STRUCT(structDescriptorAdj, con, documento);
                    }
                }
            }
            cs.setArray(13, new ARRAY(descriptorAnx, con, arregloDocts));

            logger.info(strTxId + " * Ejecutando SP");
            cs.execute();
            resultado = cs.getInt(1);
            mensaje = cs.getString(2);
            logger.info(strTxId + " * Resultado SP => " + resultado +
                        " Mensaje SP => " + mensaje);
        } catch (SQLException e) {
            mensaje = mensaje + " *** " + e.getMessage();
            logger.error(strTxId + " * SQLEXCEPTION : ", e);
        } catch (Exception e) {
            mensaje = mensaje + " *** " + e.getMessage();
            logger.error(strTxId + " * EXCEPTION : ", e);
        } finally {
            try {
                if (con != null) {
                    if (resultado == 1)
                        con.commit();
                    else
                        con.rollback();
                }
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                mensaje = mensaje + " *** " + e.getMessage();
                logger.error(strTxId + " * EXCEPTION : ", e);
            }
        }
        return mensaje;
    }


    public String cierreTramite(String txId, String nroExpediente,
                                String idServicio, String idOrden,
                                DocumentosAdjuntos documentosAdjuntos) {

        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);
        logger.info(strTxId + " nroExpediente:" + nroExpediente +
                    " idServicio: " + idServicio);
        logger.info(strTxId + " nroOrden:" + idOrden);
        logger.info(strTxId +
                    " ********Inicio del Método Cierre de Tramite VUCE********");

        Connection con = null;
        CallableStatement cs = null;
        int resultado = 0; // Inicializar con Error;
        String descError = "";
        String sql = UtilSQL.CIERRE_TRAMITE;
        logger.info(strTxId + " SP a ejecutar" + sql);

        try {
            con = conect.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, nroExpediente);
            cs.setString(2, idServicio);
            cs.setString(3, idOrden);

            logger.info(strTxId + " Preparando el Array");
            logger.info(strTxId + " Cantidad de Items ==> " +
                        documentosAdjuntos.getListaAdjuntos().size());

            StructDescriptor structDescriptorAdj =
                new StructDescriptor("VUCE.DOCUMENTO_UCM", con);
            ArrayDescriptor descriptorAnx =
                ArrayDescriptor.createDescriptor("VUCE.DOCUMENTOS_UCM", con);
            STRUCT arregloDocts[] =
                new STRUCT[documentosAdjuntos.getListaAdjuntos().size()];

            for (int i = 0; i < documentosAdjuntos.getListaAdjuntos().size();
                 i++) {
                AdjuntoDocumento beanDoc =
                    documentosAdjuntos.getListaAdjuntos().get(i);
                if (beanDoc != null && beanDoc.getUcmId() != null &&
                    !beanDoc.getUcmId().isEmpty()) {
                    String[] documento = new String[2];
                    documento[0] = beanDoc.getUcmId();
                    logger.info(strTxId + " beanDoc.getUcmId():" +
                                beanDoc.getUcmId());
                    documento[1] = beanDoc.getNombre();
                    logger.info(strTxId + " beanDoc.getNombre():" +
                                beanDoc.getNombre());
                    arregloDocts[i] =
                            new STRUCT(structDescriptorAdj, con, documento);
                }
            }
            ARRAY arrayDocts = new ARRAY(descriptorAnx, con, arregloDocts);
            cs.setArray(4, arrayDocts);
            cs.registerOutParameter(5, OracleTypes.NUMBER);
            cs.registerOutParameter(6, OracleTypes.VARCHAR);

            logger.info(strTxId + " Ejecutando SP");
            cs.execute();
            resultado = cs.getInt(5);
            logger.info(strTxId + " Datos de retorno SP resultado==> " +
                        resultado + " Descripción==> " + cs.getString(6));

        } catch (SQLException e) {
            descError = "" + e;
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            descError = "" + e;
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                descError = "" + e;
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del Pckg_Documento_Vuce.Sp_CierreTramite : ",
                             e);
            }
        }
        /* if (resultado == 1) {
            return true;
        } else {
            return false;
        }
        */
        return descError;
    }
    /*public Boolean cierreTramiteEjemplo(String codExpediente,String codFormato,List<AdjuntoDocumento> listaAdjuntos){
    String strLog="TRX-"+codExpediente + " ";
    logger.info(strLog+" ********Inicio del Método Cierre de Tramite VUCE********");
    Connection con = null;
    CallableStatement cs = null;
    String sql = UtilSQL.CIERRE_TRAMITE;
    logger.info(strLog+" SP a ejecutar" + sql);
    try {
      con =conect.getConnection();
      cs = con.prepareCall(sql);
      cs.setString(1, codExpediente);
      cs.setString(2, codFormato);

      ArrayList<DocumentoDB> listaDocumtsDB= new ArrayList<DocumentoDB>();
      for (int i=0; i<listaAdjuntos.size();i++) {
        AdjuntoDocumento beanDoc =listaAdjuntos.get(i);
        DocumentoDB documentoDB= new DocumentoDB();
        documentoDB.setNombre(beanDoc.getNombre());
        documentoDB.setUcmId(beanDoc.getUcmId());
        listaDocumtsDB.add(documentoDB);
      }
      Map types = con.getTypeMap();
      ListaGenerica tipoListaDocmts = new ListaGenerica(listaDocumtsDB);
      tipoListaDocmts.setSqlName("VUCE.DOCUMENTOS_UCM");
      types.put(tipoListaDocmts.getSqlName(), ListaGenerica.class);
      cs.setObject(3, tipoListaDocmts);

      cs.registerOutParameter(4,OracleTypes.NUMBER);
      cs.registerOutParameter(5,OracleTypes.VARCHAR);

      logger.info(strLog+"Ejecutando SP");
      cs.execute();
      Long resultado = cs.getLong(4);
      logger.info(strLog+"Datos de retorno SP resultado==> "+ resultado +"Descripción==>"+cs.getString(5));

    } catch (SQLException e) {
      logger.error(strLog+"SQLException : ", e);
    } catch (Exception e) {
      logger.error(strLog+"Exception : ", e);
    } finally {
        try{
          if(cs != null)
              cs.close();
          if(con != null)
            con.close();
        }catch(Exception ex){
                logger.error(strLog+" Error al cerrar los recursos usados en la ejecución del SP : ", ex);
        }
    }
    return true;
  }
*/

    public CertificadoPlantaTratamiento obtenerDatosConsultaPlantaTra(String txId,
                                                                      String codExpediente) {
        //SNS029
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);

        logger.info(strTxId + " codExpediente:" + codExpediente);

        logger.info(strTxId +
                    " ********Inicio del Método obtenerDatosConsultaPlantaTra VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.CONSULTA_SOLIC_PLANTA;
        CertificadoPlantaTratamiento retval =
            new CertificadoPlantaTratamiento();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnectionBPM();
            cs = con.prepareCall(sql);
            cs.setString(1, codExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.executeQuery();
            rs = (ResultSet)cs.getObject(2);
            logger.info(strTxId + "Listando datos");
            while (rs.next()) {
                retval.setCodiSoliPla(rs.getString("CODI_SOLI_PLA"));
                retval.setFechaSoliPla(rs.getString("FECH_SOLI_PLA"));
                retval.setCodiProcPrc(rs.getString("cODI_PROC_PRO"));
                retval.setProceso(rs.getString("proceso"));
                retval.setCodiSedeSed(rs.getString("CODI_SEDE_SED"));
                retval.setCodigoCentro(rs.getString("codigo_centro"));
                retval.setDescripcionCentro(rs.getString("descripcion_centro"));
                retval.setProgExplPrg(rs.getString("PROG_EXPL_PRG"));
                retval.setPrograma(rs.getString("programa"));
                retval.setNumeCampExp(rs.getString("NUME_CAMP_EXP"));
                retval.setCCodCli(rs.getString("CCODCLI"));
                retval.setDocumentoCliente(rs.getString("documento_cliente"));
                retval.setDistritoCliente(rs.getString("distrito_cliente"));
                retval.setProvinciaCliente(rs.getString("provincia_cliente"));
                retval.setDepartamentoCliente(rs.getString("departamento_cliente"));
                retval.setCodiPlanPla(rs.getString("CODI_PLAN_PLA"));
                retval.setDniSoliSol(rs.getString("DNI_SOLI_SOL"));
                retval.setPlanLocaSol(rs.getString("plan_loca_sol"));
                retval.setPlanConsSol(rs.getString("plan_cons_sol"));
                retval.setLiceMuniSol(rs.getString("lice_muni_sol"));
                retval.setCertFumPla(rs.getString("cert_fum_pla"));
                retval.setDniAcopSol(rs.getString("dni_acop_sol"));
                retval.setDocuSustSol(rs.getString("docu_sust_sol"));
                retval.setCopiRucPla(rs.getString("copi_ruc_pla"));

                //lista.add(b);
            }
            logger.info(strTxId + "Lista completada");

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return retval;
    }


    public SolicitudLugarProduccion obtenerDatosSolicitudLugarProd(String txId,
                                                                   String codExpediente) {
        //SNS024
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);

        logger.info(strTxId + " codExpediente:" + codExpediente);

        logger.info(strTxId +
                    " ********Inicio del Método obtenerDatosSolicitudLugarProd VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.CONSULTA_SOLIC_LUGARPROD;
        SolicitudLugarProduccion retval = new SolicitudLugarProduccion();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnectionBPM();
            cs = con.prepareCall(sql);
            cs.setString(1, codExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(4, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(5, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.executeQuery();
            rs = (ResultSet)cs.getObject(2);
            logger.info(strTxId + "Listando datos");

            while (rs.next()) {
                retval.setCodiSoliLug(rs.getString("codi_soli_lug"));
                retval.setCodiProdMos(rs.getString("codi_prod_mos"));
                retval.setNomProductor(rs.getString("nom_productor"));
                retval.setCodiPredMos(rs.getString("codi_pred_mos"));
                retval.setNomPredio(rs.getString("nom_predio"));
                retval.setCodiSedeSed(rs.getString("codi_sede_sed"));
                retval.setCodiSedeSol(rs.getString("codi_sede_sol"));
                retval.setCCodExp(rs.getString("ccodexp"));
                retval.setCCodCli(rs.getString("ccodcli"));
                //lista.add(b);
            }
            logger.info(strTxId + "Lista completada");

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return retval;
    }

    public ArrayList<ProductoInspeccion> obtenerDatosProductoInspeccion(String txId,
                                                                        String codExpediente) {
        //SNS024
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);

        logger.info(strTxId + " codExpediente:" + codExpediente);

        logger.info(strTxId +
                    " ********Inicio del Método obtenerDatosProductoInspeccion VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.CONSULTA_INSPECCION_PROD;
        ArrayList<ProductoInspeccion> retval =
            new ArrayList<ProductoInspeccion>();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnectionBPM();
            cs = con.prepareCall(sql);
            cs.setString(1, codExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.executeQuery();
            rs = (ResultSet)cs.getObject(2);
            logger.info(strTxId + "Listando datos");

            while (rs.next()) {
                ProductoInspeccion obj = new ProductoInspeccion();
                obj.setCodigoInspeccionProducto(rs.getString("Codigo_Inspeccion_Producto"));
                obj.setCodigoInspeccion(rs.getString("Codigo_Inspeccion"));
                obj.setCodigoProducto(rs.getString("Codigo_Producto"));
                obj.setCantidadActual(rs.getDouble("Cantidad_Actual"));
                obj.setCodigoServicio(rs.getString("Codigo_Servicio"));
                obj.setCodigoExpediente(rs.getString("Codigo_Expediente"));
                obj.setCantidadBase(rs.getDouble("Cantidad_Base"));
                obj.setPesoActual(rs.getDouble("Peso_Actual"));
                obj.setPesoBase(rs.getDouble("Peso_Base"));
                obj.setEstado(rs.getString("Estado"));
                obj.setPersonaId(rs.getString("Persona_Id"));
                obj.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));

                retval.add(obj);
            }
            logger.info(strTxId + "Lista completada");

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return retval;
    }

    public ArrayList<ConceptoInspeccion> obtenerDatosConceptoInspeccion(String txId,
                                                                        String codigoConcepto) {
        //SNS024

        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);

        logger.info(strTxId + " codigoConcepto:" + codigoConcepto);

        logger.info(strTxId +
                    " ********Inicio del Método obtenerDatosConceptoInspeccion VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.CONSULTA_INSPECCION_CONCEPTO;
        ArrayList<ConceptoInspeccion> retval =
            new ArrayList<ConceptoInspeccion>();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnectionBPM();
            cs = con.prepareCall(sql);
            cs.setString(1, codigoConcepto);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.executeQuery();
            rs = (ResultSet)cs.getObject(2);
            logger.info(strTxId + "Listando datos");

            while (rs.next()) {
                ConceptoInspeccion obj = new ConceptoInspeccion();
                obj.setCodigoConcepto(rs.getString("Codigo_Concepto"));
                obj.setCodigoLote(rs.getString("Codigo_Lote"));
                obj.setCodigoInspeccionProducto(rs.getString("Codigo_Inspeccion_Producto"));
                obj.setCodigoInspeccion(rs.getString("Codigo_Inspeccion"));
                obj.setCodigoProducto(rs.getString("Codigo_Producto"));
                obj.setSecuencialProducto(rs.getDouble("Secuencial_Producto"));
                obj.setTipoConceptoRetencion(rs.getString("Tipo_Concepto_Retencion"));
                obj.setCodigoCtaRetencion(rs.getString("Codigo_Cta_Retencion"));
                obj.setCantidadCtaRetencion(rs.getDouble("Cantidad_Cta_Retencion"));
                obj.setPesoCtaRetencion(rs.getDouble("Peso_Cta_Retencion"));
                obj.setRespuesta(rs.getString("Respuesta"));
                obj.setEstado(rs.getString("Estado"));
                obj.setFechaRespuesta(rs.getDate("Fecha_Respuesta"));
                obj.setUrlDocumento(rs.getString("Url_Documento"));
                obj.setNumeroSolicitudAnalisis(rs.getString("Numero_Solicitud_Analisis"));

                retval.add(obj);
            }
            logger.info(strTxId + "Lista completada");

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return retval;
    }

    public ArrayList<LoteInspeccion> obtenerDatosLoteInspeccion(String txId,
                                                                String codigoLote) {
        //SNS024
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);

        logger.info(strTxId + " codigoLote:" + codigoLote);

        logger.info(strTxId +
                    " ********Inicio del Método obtenerDatosLoteInspeccion VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.CONSULTA_INSPECCION_LOTE;
        ArrayList<LoteInspeccion> retval = new ArrayList<LoteInspeccion>();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnectionBPM();
            cs = con.prepareCall(sql);
            cs.setString(1, codigoLote);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.executeQuery();
            rs = (ResultSet)cs.getObject(2);
            logger.info(strTxId + "Listando datos");

            while (rs.next()) {
                LoteInspeccion obj = new LoteInspeccion();
                obj.setCodigoLote(rs.getString("Codigo_Lote"));
                obj.setCodigoInspeccionProducto(rs.getString("Codigo_Inspeccion_Producto"));
                obj.setCodigoInspeccion(rs.getString("Codigo_Inspeccion"));
                obj.setCodigoProducto(rs.getString("Codigo_Producto"));
                obj.setSecuencialProducto(rs.getDouble("Secuencial_Producto"));
                obj.setCantidadLote(rs.getDouble("Cantidad_Lote"));
                obj.setPesoLote(rs.getDouble("Peso_Lote"));
                obj.setEstado(rs.getString("Estado"));
                obj.setObservacion(rs.getString("Observacion"));

                retval.add(obj);
            }
            logger.info(strTxId + "Lista completada");

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return retval;
    }

    public DatosIIV obtenerDatosIIV(String txId, String codExpediente,
                                    String tipo) {
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);
        logger.info(strTxId + " codExpediente:" + codExpediente);

        logger.info(strTxId +
                    " ********Inicio del Método obtenerDatosIIV VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "";
        if (tipo.equals("F")) {
            sql = UtilSQL.CONSULTA_DATOSIIVF_VUCE;
        } else {
            sql = UtilSQL.CONSULTA_DATOSIIVZ_VUCE;
        }

        DatosIIV datosIIV = new DatosIIV();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, codExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(4, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.execute();

            logger.info(strTxId + " Obtener datos de Cabecera IIV");
            rs =
 (ResultSet)cs.getObject(2); // el resulaydo de este será siempre 1 registro

            Persona solicitante = new Persona();
            Persona repLegal = new Persona();
            Persona agente = new Persona();
            while (rs.next()) {
                datosIIV.setNumPFI(rs.getString("NumPFI"));
                datosIIV.setNumPFTI(rs.getString("NumPFTI"));
                datosIIV.setNumPZI(rs.getString("NumPZI"));
                datosIIV.setCodPaisDestino(rs.getString("cod_Pais_Destino"));
                datosIIV.setDescPaisDestino(rs.getString("des_Pais_Destino"));
                datosIIV.setCodPaisProc(rs.getString("cod_Pais_Procedencia"));
                datosIIV.setDescPaisProc(rs.getString("des_Pais_Procedencia"));
                datosIIV.setCodPtoIngreso(rs.getString("cod_Punto_Ingreso"));
                datosIIV.setDescPtoIngreso(rs.getString("des_Punto_Ingreso"));
                datosIIV.setCodPtoSalida(rs.getString("cod_Punto_Salida"));
                datosIIV.setDescPtoSalida(rs.getString("des_Punto_Salida"));
                datosIIV.setCodLugInspeccion(rs.getString("cod_Lugar_Inspeccion"));
                datosIIV.setDescLugInspeccion(rs.getString("des_Lugar_Inspeccion"));
                datosIIV.setDescLugProduccion(rs.getString("des_Lugar_Produccion"));
                datosIIV.setNumDocEmb(rs.getString("numDocEmb"));
                datosIIV.setNumCPE(rs.getString("numCPE"));
                datosIIV.setNumGCUSTODIA(rs.getString("numGCUSTODIA"));
                datosIIV.setNumGERMOPLASMA(rs.getString("numGERMOPLASMA"));
                datosIIV.setCodUsoDestino(rs.getString("codUsodestino"));
                datosIIV.setDescUsoDestino(rs.getString("desUsoDestino"));
                solicitante.setPersonaId(rs.getString("idCliente"));
                //Rep legal
                repLegal.setPersonaId(rs.getString("idRepLegal"));
                agente.setDocumentoNumero(rs.getString("dniRepLegal"));
                repLegal.setNombreRazonSocial(rs.getString("nombRepLegal"));
                //Agente
                agente.setPersonaId(rs.getString("idAgente"));
                agente.setDocumentoNumero(rs.getString("dniAgente"));
                agente.setNombreRazonSocial(rs.getString("nombAgente"));

            }
            datosIIV.setSolicitante(solicitante);
            datosIIV.setRepLegal(repLegal);
            datosIIV.setAgente(agente);

            /* Datos de productos*/
            logger.info(strTxId + " Obtener datos de productos");
            rs = null;
            rs = (ResultSet)cs.getObject(3);

            //List<ProductoIiv> listaProductos = new ArrayList<ProductoIiv>();
            while (rs.next()) {
                ProductoIiv producto = new ProductoIiv();
                producto.setCodigoProducto(rs.getString("codigo_producto"));
                producto.setNombreComercial(rs.getString("nombre_comercial_producto"));
                producto.setNombreCientifico(rs.getString("nombre_cientifico_producto"));
                producto.setCodigoPartAranc(rs.getString("codigo_partida_arancelaria"));
                producto.setCodigoCRF(rs.getString("codigo_crf"));
                producto.setIndCuarentena(rs.getString("indicador_cuarentena"));
                producto.setPerVegetativo(rs.getString("periodo_vegetativo"));
                producto.setNumInspecciones(rs.getInt("numero_inspecciones"));
                producto.setIndGuardacustodia(rs.getString("indicador_guardacustodia"));
                producto.setPartidaArancelaria(rs.getString("partida_arancelaria"));
                producto.setCodEnvase(rs.getString("codenvase"));
                producto.setDescEnvase(rs.getString("descripcion_tipo_envase"));
                producto.setCodUM(rs.getString("CODUMEDIDA"));
                producto.setDescUM(rs.getString("desc_unid_med"));
                producto.setPeso(rs.getDouble("peso"));
                producto.setCantEnvase(rs.getDouble("CANTENVASE"));
                producto.setCantidad(rs.getDouble("cantprod")); // si es fito cantidad de plantas
                producto.setSexo(rs.getString("sexo"));
                producto.setEdad(rs.getString("edad"));
                producto.setCodRaza(rs.getString("raza"));
                producto.setNomRaza(rs.getString("raza_nombre"));
                producto.setCodEspecie(rs.getString("codespecie"));
                producto.setNombreEspecie(rs.getString("nomb_espe_ani"));
                producto.setNumIdenfAnimal(rs.getString("numidenanimal"));
                if (rs.getString("isAnimal") != null &&
                    rs.getString("isAnimal").equalsIgnoreCase("X")) {
                    producto.setIsAnimal(true);
                } else {
                    producto.setIsAnimal(false);
                }
                if (rs.getString("isanexo") != null &&
                    rs.getString("isanexo").equals("1")) {
                    producto.setIsAnexo(true);
                } else {
                    producto.setIsAnexo(false);
                }

                //*listaProductos.add(producto);

                datosIIV.getProductos().getListaProductos().add(producto);
            }
            //*datosIIV.getProductos().setListaProductos(listaProductos);

            /* Datos de paises Origen*/
            logger.info(strTxId + " Obtener datos paises origen");
            rs = null;
            rs = (ResultSet)cs.getObject(4);
            List<Pais> listaPaisesOrigen = new ArrayList<Pais>();
            Pais paisOrg = null;
            while (rs.next()) {
                paisOrg = new Pais();
                paisOrg.setCodPais(rs.getString("codPais"));
                paisOrg.setDescripcion(rs.getString("descPais"));
                listaPaisesOrigen.add(paisOrg);
            }

            logger.info(strTxId + "Lista completada");

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return datosIIV;
    }

    public DatosExpo obtenerDatosExpoFito(String txId, String codExpediente) {
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);
        logger.info(strTxId + " codExpediente:" + codExpediente);

        logger.info(strTxId +
                    " ********Inicio del Método obtenerDatosExpoFito VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "";

        sql = UtilSQL.CONSULTA_DATOSEXPOF_VUCE;

        DatosExpo datosExpoFito = new DatosExpo();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, codExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.execute();

            logger.info(strTxId + " Obtener datos de Cabecera IIV");
            rs =
 (ResultSet)cs.getObject(2); // el resulaydo de este será siempre 1 registro

            Persona solicitante = new Persona();
            Persona repLegal = new Persona();
            Persona agente = new Persona();
            while (rs.next()) {
                datosExpoFito.setCodPaisImportador(rs.getString("cod_Pais_Importador"));
                datosExpoFito.setDesPaisImportador(rs.getString("des_Pais_Importador"));
                datosExpoFito.setCodImportador(rs.getString("codImportador"));
                datosExpoFito.setNombImportador(rs.getString("nombImportador"));
                datosExpoFito.setDirecImportador(rs.getString("direcImportador"));
                datosExpoFito.setCodPaisDestino(rs.getString("cod_Pais_Destino"));
                datosExpoFito.setDescPaisDestino(rs.getString("des_Pais_Destino"));
                datosExpoFito.setCodPtoIngreso(rs.getString("cod_Punto_Ingreso"));
                datosExpoFito.setDescPtoIngreso(rs.getString("des_Punto_Ingreso"));
                datosExpoFito.setCodPtoSalida(rs.getString("cod_Punto_Salida"));
                datosExpoFito.setDescPtoSalida(rs.getString("des_Punto_Salida"));
                datosExpoFito.setCodMedioTransporte(rs.getString("codMedioTransporte"));
                datosExpoFito.setDesMedioTransporte(rs.getString("desMedioTransporte"));
                datosExpoFito.setRucLugarInspeccion(rs.getString("rucLugarInspeccion"));
                datosExpoFito.setTipoDocLugInspeccion(rs.getString("tipoDocLugInspeccion"));
                datosExpoFito.setTipoServicio(rs.getString("tipoServicio"));
                datosExpoFito.setTpUbEnvio(rs.getString("tp_ubEnvio"));
                datosExpoFito.setCertificado(rs.getString("certificado"));
                datosExpoFito.setNombPlanta(rs.getString("nombPlanta"));
                datosExpoFito.setDireccPlanta(rs.getString("direccPlanta"));
                datosExpoFito.setFechaInspeccion(rs.getDate("fechaInspeccion"));
                datosExpoFito.setHoraInspeccion(rs.getTimestamp("horaInspeccion"));
                datosExpoFito.setFechaEmbarque(rs.getDate("fechaEmbarque"));
                datosExpoFito.setFechaDesembarque(rs.getDate("fechaDesembarque"));
                if (rs.getString("es_tratCuarentenario") != null &&
                    rs.getString("es_tratCuarentenario").equalsIgnoreCase("X")) {
                    datosExpoFito.setIsTratCuarentenario(true);
                } else {
                    datosExpoFito.setIsTratCuarentenario(false);
                }
                datosExpoFito.setTipoTratCuarentenario(rs.getString("tipoTratCuarentenario"));
                datosExpoFito.setDestipoTratCuarentenario(rs.getString("desTipoTratCuarentenario"));
                datosExpoFito.setRucLugarInspeccionFinal(rs.getString("rucLugarInspeccionFinal"));
                datosExpoFito.setTipoDocLugInspeccionFinal(rs.getString("tipoDocLugInspeccionFinal"));
                datosExpoFito.setTpUbEnvioFinal(rs.getString("tp_ubEnvioFinal"));
                datosExpoFito.setCertificadoFinal(rs.getString("certificadoFinal"));
                datosExpoFito.setNombPlantaFinal(rs.getString("nombPlantaFinal"));
                datosExpoFito.setDireccPlantaFinal(rs.getString("direccPlantaFinal"));
                datosExpoFito.setCodUsodestino(rs.getString("codUsodestino"));
                datosExpoFito.setDesUsoDestino(rs.getString("desUsoDestino"));
                datosExpoFito.setCodDirecEjecutiva(rs.getString("codDirecEjecutiva"));
                datosExpoFito.setDesDirecEjecutiva(rs.getString("desDirecEjecutiva"));

                datosExpoFito.setTipoModificacion(rs.getString("tpModif_certificado"));
                datosExpoFito.setNumDocResolutivo(rs.getString("num_dr"));
                datosExpoFito.setNumCertModificar(rs.getString("num_certfModificar"));
                datosExpoFito.setCodigoCertificadoFitoExpo(rs.getString("codigo_certificado_fito_expo"));

                //Cliente
                solicitante.setPersonaId(rs.getString("idCliente"));
                //Rep legal
                repLegal.setPersonaId(rs.getString("idRepLegal"));
                agente.setDocumentoNumero(rs.getString("dniRepLegal"));
                repLegal.setNombreRazonSocial(rs.getString("nombRepLegal"));
                //Agente
                agente.setPersonaId(rs.getString("idAgente"));
                agente.setDocumentoNumero(rs.getString("dniAgente"));
                agente.setNombreRazonSocial(rs.getString("nombAgente"));

            }
            datosExpoFito.setSolicitante(solicitante);
            datosExpoFito.setRepLegal(repLegal);
            datosExpoFito.setAgente(agente);

            /* Datos de productos*/
            logger.info(strTxId + " Obtener datos de productos");
            rs = null;
            rs = (ResultSet)cs.getObject(3);

            //List<ProductoIiv> listaProductos = new ArrayList<ProductoIiv>();
            while (rs.next()) {
                ProductoIiv producto = new ProductoIiv();
                producto.setCodigoProducto(rs.getString("codigo_producto"));
                producto.setNombreComercial(rs.getString("nombre_comercial_producto"));
                producto.setNombreCientifico(rs.getString("nombre_cientifico_producto"));
                producto.setCodigoPartAranc(rs.getString("codigo_partida_arancelaria"));
                producto.setCodigoCRF(rs.getString("codigo_crf"));
                producto.setIndCuarentena(rs.getString("indicador_cuarentena"));
                producto.setPerVegetativo(rs.getString("periodo_vegetativo"));
                producto.setNumInspecciones(rs.getInt("numero_inspecciones"));
                producto.setIndGuardacustodia(rs.getString("indicador_guardacustodia"));
                producto.setPartidaArancelaria(rs.getString("partida_arancelaria"));
                producto.setCodEnvase(rs.getString("codenvase"));
                producto.setDescEnvase(rs.getString("descripcion_tipo_envase"));
                producto.setCodUM(rs.getString("CODUMEDIDA"));
                producto.setDescUM(rs.getString("desc_unid_med"));
                producto.setPeso(rs.getDouble("peso"));
                producto.setCantEnvase(rs.getDouble("CANTENVASE"));
                producto.setCantidad(rs.getDouble("cantprod")); // si es fito cantidad de plantas
                producto.setSexo(rs.getString("sexo"));
                producto.setEdad(rs.getString("edad"));
                producto.setCodRaza(rs.getString("raza"));
                producto.setNomRaza(rs.getString("raza_nombre"));
                producto.setCodEspecie("");
                producto.setNombreEspecie("");
                producto.setNumIdenfAnimal("");

                if (rs.getString("isAnimal") != null &&
                    rs.getString("isAnimal").equalsIgnoreCase("X")) {
                    producto.setIsAnimal(true);
                } else {
                    producto.setIsAnimal(false);
                }
                if (rs.getString("isanexo") != null &&
                    rs.getString("isanexo").equals("1")) {
                    producto.setIsAnexo(true);
                } else {
                    producto.setIsAnexo(false);
                }
                datosExpoFito.getProductos().getListaProductos().add(producto);
            }


            logger.info(strTxId + "Lista completada");

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return datosExpoFito;
    }


    public DatosExpo obtenerDatosModExpoFito(String txId,
                                             String codExpediente) {
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);
        logger.info(strTxId + " codExpediente:" + codExpediente);

        logger.info(strTxId +
                    " ********Inicio del Método obtenerDatosExpoFito VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "";

        sql = UtilSQL.CONSULTA_DATOSEXPOFMOD_VUCE;

        DatosExpo datosExpoFito = new DatosExpo();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, codExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.execute();

            logger.info(strTxId + " Obtener datos de Cabecera IIV");
            rs =
 (ResultSet)cs.getObject(2); // el resulaydo de este será siempre 1 registro

            Persona solicitante = new Persona();
            Persona repLegal = new Persona();
            Persona agente = new Persona();
            while (rs.next()) {
                datosExpoFito.setCodPaisImportador(rs.getString("cod_Pais_Importador"));
                datosExpoFito.setDesPaisImportador(rs.getString("des_Pais_Importador"));
                datosExpoFito.setCodImportador(rs.getString("codImportador"));
                datosExpoFito.setNombImportador(rs.getString("nombImportador"));
                datosExpoFito.setDirecImportador(rs.getString("direcImportador"));
                datosExpoFito.setCodPaisDestino(rs.getString("cod_Pais_Destino"));
                datosExpoFito.setDescPaisDestino(rs.getString("des_Pais_Destino"));
                datosExpoFito.setCodPtoIngreso(rs.getString("cod_Punto_Ingreso"));
                datosExpoFito.setDescPtoIngreso(rs.getString("des_Punto_Ingreso"));
                datosExpoFito.setCodPtoSalida(rs.getString("cod_Punto_Salida"));
                datosExpoFito.setDescPtoSalida(rs.getString("des_Punto_Salida"));
                datosExpoFito.setCodMedioTransporte(rs.getString("codMedioTransporte"));
                datosExpoFito.setDesMedioTransporte(rs.getString("desMedioTransporte"));
                datosExpoFito.setRucLugarInspeccion(rs.getString("rucLugarInspeccion"));
                datosExpoFito.setTipoDocLugInspeccion(rs.getString("tipoDocLugInspeccion"));
                datosExpoFito.setTipoServicio(rs.getString("tipoServicio"));
                datosExpoFito.setTpUbEnvio(rs.getString("tp_ubEnvio"));
                datosExpoFito.setCertificado(rs.getString("certificado"));
                datosExpoFito.setNombPlanta(rs.getString("nombPlanta"));
                datosExpoFito.setDireccPlanta(rs.getString("direccPlanta"));
                datosExpoFito.setFechaInspeccion(rs.getDate("fechaInspeccion"));
                datosExpoFito.setHoraInspeccion(rs.getTimestamp("horaInspeccion"));
                datosExpoFito.setFechaEmbarque(rs.getDate("fechaEmbarque"));
                datosExpoFito.setFechaDesembarque(rs.getDate("fechaDesembarque"));
                if (rs.getString("es_tratCuarentenario") != null &&
                    rs.getString("es_tratCuarentenario").equalsIgnoreCase("X")) {
                    datosExpoFito.setIsTratCuarentenario(true);
                } else {
                    datosExpoFito.setIsTratCuarentenario(false);
                }
                datosExpoFito.setTipoTratCuarentenario(rs.getString("tipoTratCuarentenario"));
                datosExpoFito.setDestipoTratCuarentenario(rs.getString("desTipoTratCuarentenario"));
                datosExpoFito.setRucLugarInspeccionFinal(rs.getString("rucLugarInspeccionFinal"));
                datosExpoFito.setTipoDocLugInspeccionFinal(rs.getString("tipoDocLugInspeccionFinal"));
                datosExpoFito.setTpUbEnvioFinal(rs.getString("tp_ubEnvioFinal"));
                datosExpoFito.setCertificadoFinal(rs.getString("certificadoFinal"));
                datosExpoFito.setNombPlantaFinal(rs.getString("nombPlantaFinal"));
                datosExpoFito.setDireccPlantaFinal(rs.getString("direccPlantaFinal"));
                datosExpoFito.setCodUsodestino(rs.getString("codUsodestino"));
                datosExpoFito.setDesUsoDestino(rs.getString("desUsoDestino"));
                datosExpoFito.setCodDirecEjecutiva(rs.getString("codDirecEjecutiva"));
                datosExpoFito.setDesDirecEjecutiva(rs.getString("desDirecEjecutiva"));

                datosExpoFito.setTipoModificacion(rs.getString("tpModif_certificado"));
                datosExpoFito.setNumDocResolutivo(rs.getString("num_dr"));
                datosExpoFito.setNumCertModificar(rs.getString("num_certfModificar"));
                datosExpoFito.setCodigoCertificadoFitoExpo(rs.getString("codigo_certificado_fito_expo"));

                //Cliente
                solicitante.setPersonaId(rs.getString("idCliente"));
                //Rep legal
                repLegal.setPersonaId(rs.getString("idRepLegal"));
                agente.setDocumentoNumero(rs.getString("dniRepLegal"));
                repLegal.setNombreRazonSocial(rs.getString("nombRepLegal"));
                //Agente
                agente.setPersonaId(rs.getString("idAgente"));
                agente.setDocumentoNumero(rs.getString("dniAgente"));
                agente.setNombreRazonSocial(rs.getString("nombAgente"));

            }
            datosExpoFito.setSolicitante(solicitante);
            datosExpoFito.setRepLegal(repLegal);
            datosExpoFito.setAgente(agente);

            /* Datos de productos*/
            logger.info(strTxId + " Obtener datos de productos");
            rs = null;
            rs = (ResultSet)cs.getObject(3);

            //List<ProductoIiv> listaProductos = new ArrayList<ProductoIiv>();
            while (rs.next()) {
                ProductoIiv producto = new ProductoIiv();
                producto.setCodigoProducto(rs.getString("codigo_producto"));
                producto.setNombreComercial(rs.getString("nombre_comercial_producto"));
                producto.setNombreCientifico(rs.getString("nombre_cientifico_producto"));
                producto.setCodigoPartAranc(rs.getString("codigo_partida_arancelaria"));
                producto.setCodigoCRF(rs.getString("codigo_crf"));
                producto.setIndCuarentena(rs.getString("indicador_cuarentena"));
                producto.setPerVegetativo(rs.getString("periodo_vegetativo"));
                producto.setNumInspecciones(rs.getInt("numero_inspecciones"));
                producto.setIndGuardacustodia(rs.getString("indicador_guardacustodia"));
                producto.setPartidaArancelaria(rs.getString("partida_arancelaria"));
                producto.setCodEnvase(rs.getString("codenvase"));
                producto.setDescEnvase(rs.getString("descripcion_tipo_envase"));
                producto.setCodUM(rs.getString("CODUMEDIDA"));
                producto.setDescUM(rs.getString("desc_unid_med"));
                producto.setPeso(rs.getDouble("peso"));
                producto.setCantEnvase(rs.getDouble("CANTENVASE"));
                producto.setCantidad(rs.getDouble("cantprod")); // si es fito cantidad de plantas
                producto.setSexo(rs.getString("sexo"));
                producto.setEdad(rs.getString("edad"));
                producto.setCodRaza(rs.getString("raza"));
                producto.setNomRaza(rs.getString("raza_nombre"));
                producto.setCodEspecie("");
                producto.setNombreEspecie("");
                producto.setNumIdenfAnimal("");

                if (rs.getString("isAnimal") != null &&
                    rs.getString("isAnimal").equalsIgnoreCase("X")) {
                    producto.setIsAnimal(true);
                } else {
                    producto.setIsAnimal(false);
                }
                if (rs.getString("isanexo") != null &&
                    rs.getString("isanexo").equals("1")) {
                    producto.setIsAnexo(true);
                } else {
                    producto.setIsAnexo(false);
                }
                datosExpoFito.getProductos().getListaProductos().add(producto);
            }


            logger.info(strTxId + "Lista completada");

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return datosExpoFito;
    }

    public DatosExpo obtenerDatosExpoZoo(String txId, String codExpediente) {
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);
        logger.info(strTxId + " codExpediente:" + codExpediente);

        logger.info(strTxId +
                    " ********Inicio del Método obtenerDatosExpoZoo VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "";
        sql = UtilSQL.CONSULTA_DATOSEXPOZOO_VUCE;

        DatosExpo datosExpoZoo = new DatosExpo();
        logger.info(strTxId + " SP a ejecutar" + sql);
        try {
            con = conect.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, codExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

            logger.info(strTxId + "Ejecutando SP");
            cs.execute();

            logger.info(strTxId + " Obtener datos de Cabecera IIV");
            rs =
 (ResultSet)cs.getObject(2); // el resulaydo de este será siempre 1 registro

            Persona solicitante = new Persona();
            Persona repLegal = new Persona();
            Persona agente = new Persona();
            while (rs.next()) {
                datosExpoZoo.setCodPaisImportador(rs.getString("cod_Pais_Importador"));
                datosExpoZoo.setDesPaisImportador(rs.getString("des_Pais_Importador"));
                datosExpoZoo.setCodImportador(rs.getString("codImportador"));
                datosExpoZoo.setNombImportador(rs.getString("nombImportador"));
                datosExpoZoo.setDirecImportador(rs.getString("direcImportador"));
                datosExpoZoo.setCodPaisDestino(rs.getString("cod_Pais_Destino"));
                datosExpoZoo.setDescPaisDestino(rs.getString("des_Pais_Destino"));
                datosExpoZoo.setCodPtoIngreso(rs.getString("cod_Punto_Ingreso"));
                datosExpoZoo.setDescPtoIngreso(rs.getString("des_Punto_Ingreso"));
                datosExpoZoo.setCodPtoSalida(rs.getString("cod_Punto_Salida"));
                datosExpoZoo.setDescPtoSalida(rs.getString("des_Punto_Salida"));
                datosExpoZoo.setCodMedioTransporte(rs.getString("codMedioTransporte"));
                datosExpoZoo.setDesMedioTransporte(rs.getString("desMedioTransporte"));
                datosExpoZoo.setCodLugInspeccion(rs.getString("cod_Lugar_Inspeccion")); //*
                datosExpoZoo.setDesLugInspeccion(rs.getString("des_Lugar_Inspeccion"));
                datosExpoZoo.setFechaInspeccion(rs.getDate("fechaInspeccion"));
                datosExpoZoo.setHoraInspeccion(rs.getTimestamp("horaInspeccion"));
                datosExpoZoo.setFechaEmbarque(rs.getDate("fechaEmbarque"));
                datosExpoZoo.setFechaDesembarque(rs.getDate("fechaDesembarque"));
                datosExpoZoo.setCodUsodestino(rs.getString("codUsodestino"));
                datosExpoZoo.setDesUsoDestino(rs.getString("desUsoDestino"));
                datosExpoZoo.setCodDirecEjecutiva(rs.getString("codDirecEjecutiva"));
                datosExpoZoo.setDesDirecEjecutiva(rs.getString("desDirecEjecutiva"));
                //datos de los Registros
                datosExpoZoo.setNroRegEstbExp(rs.getString("Nro_Reg_Estb_Exp"));
                datosExpoZoo.setNroRegEstbPec(rs.getString("Nro_Reg_Estb_Pec"));
                //Cliente
                solicitante.setPersonaId(rs.getString("idCliente"));
                //Rep legal
                repLegal.setPersonaId(rs.getString("idRepLegal"));
                repLegal.setDocumentoNumero(rs.getString("dniRepLegal"));
                repLegal.setNombreRazonSocial(rs.getString("nombRepLegal"));
                //Agente
                agente.setPersonaId(rs.getString("idAgente"));
                agente.setDocumentoNumero(rs.getString("dniAgente"));
                agente.setNombreRazonSocial(rs.getString("nombAgente"));

            }
            datosExpoZoo.setSolicitante(solicitante);
            datosExpoZoo.setRepLegal(repLegal);
            datosExpoZoo.setAgente(agente);

            /* Datos de productos*/
            logger.info(strTxId + " Obtener datos de productos");
            rs = null;
            rs = (ResultSet)cs.getObject(3);

            while (rs.next()) {
                ProductoIiv producto = new ProductoIiv();
                producto.setCodigoProducto(rs.getString("codigo_producto"));
                producto.setNombreComercial(rs.getString("nombre_comercial_producto"));
                producto.setNombreCientifico(rs.getString("nombre_cientifico_producto"));
                producto.setCodigoPartAranc(rs.getString("codigo_partida_arancelaria"));
                producto.setCodigoCRF(rs.getString("codigo_crf"));
                producto.setIndCuarentena(rs.getString("indicador_cuarentena"));
                producto.setPerVegetativo(rs.getString("periodo_vegetativo"));
                producto.setNumInspecciones(rs.getInt("numero_inspecciones"));
                producto.setIndGuardacustodia(rs.getString("indicador_guardacustodia"));
                producto.setPartidaArancelaria(rs.getString("partida_arancelaria"));
                producto.setCodEnvase(rs.getString("codenvase"));
                producto.setDescEnvase(rs.getString("descripcion_tipo_envase"));
                producto.setCodUM(rs.getString("CODUMEDIDA"));
                producto.setDescUM(rs.getString("desc_unid_med"));
                producto.setPeso(rs.getDouble("peso"));
                producto.setCantEnvase(rs.getDouble("CANTENVASE"));
                producto.setCantidad(rs.getDouble("cantprod")); // si es fito cantidad de plantas
                producto.setSexo(rs.getString("sexo"));
                producto.setEdad(rs.getString("edad"));
                producto.setCodRaza(rs.getString("raza"));
                producto.setNomRaza(rs.getString("raza_nombre"));
                producto.setCodEspecie(rs.getString("codespecie"));
                producto.setNombreEspecie(rs.getString("nomb_espe_ani"));
                producto.setNumIdenfAnimal(rs.getString("numidenanimal"));

                if (rs.getString("isAnimal") != null &&
                    rs.getString("isAnimal").equalsIgnoreCase("X")) {
                    producto.setIsAnimal(true);
                } else {
                    producto.setIsAnimal(false);
                }

                if (rs.getString("isanexo") != null &&
                    rs.getString("isanexo").equals("1")) {
                    producto.setIsAnexo(true);
                } else {
                    producto.setIsAnexo(false);
                }

                datosExpoZoo.getProductos().getListaProductos().add(producto);
            }


            logger.info(strTxId + "Lista completada");

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return datosExpoZoo;
    }

    public Expediente obtenerExpediente(String txId, String codigoExpediente) {

        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);
        logger.info(strTxId + " CodigoExpediente:" + codigoExpediente);
        logger.info(strTxId +
                    " ********Inicio del Método Ingresar Respuesta Consulta Tecnica VUCE********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.OBTENER_DATOS_EXPEDIENTE;
        Expediente retval = new Expediente();

        try {
            con = conect.getConnectionBPM();
            cs = con.prepareCall(sql);
            cs.setString(1, codigoExpediente);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            rs = (ResultSet)cs.getObject(2);
            logger.info(strTxId + " SP a ejecutar" + sql);
            while (rs.next()) {
                retval.setCodigoExpediente(rs.getString("Codigo_Expediente"));
                retval.setCodigoServicio(rs.getString("Codigo_Servicio"));
                retval.setCodigoSolicitud(rs.getString("Codigo_Solicitud"));
                retval.setEstado(rs.getString("Estado"));
                retval.setPersonaId(rs.getString("Persona_Id"));
                logger.info(strTxId + " retval.getPersonaId():" +
                            retval.getPersonaId());

                retval.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));
                logger.info(strTxId + " retval.getCodigoCentroTramite():" +
                            retval.getCodigoCentroTramite());
                retval.setObservacion(rs.getString("Observacion"));
                retval.setClase(rs.getString("Codigo_Clase"));
            }

        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                logger.error(strTxId +
                             " Error al cerrar los recursos usados en la ejecución del SP : ",
                             ex);
            }
        }
        return retval;

    }
    
    public Adjunto obtenerCertificadoXML(String txId, String codigoExpediente) {
        Adjunto resultado = new Adjunto();
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);
        logger.info(strTxId + " CodigoExpediente:" + codigoExpediente);
        logger.info(strTxId + " ******** OBTENER CERTIFICADO XML ********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.OBTENER_CERTIFICADO_XML;
        
        try {
            con = conect.getConnectionBPM();
            cs = con.prepareCall(sql);
            cs.setString(1, codigoExpediente);
            cs.registerOutParameter(2, OracleTypes.BLOB);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            Blob blob = cs.getBlob(2);            
            resultado.setAdjunto( (blob == null ? null : blob.getBytes(1, (int) blob.length())) );
            resultado.getAuditoria().setTxId(cs.getString(3));
            resultado.getAuditoria().setErrorMsg(cs.getString(4));
        } catch (SQLException e) {
            logger.error(strTxId + "SQLException : ", e);
            resultado.getAuditoria().setTxId(txId);
            resultado.getAuditoria().setErrorCode("WS_OBTENER_CERTIFICADO_XML");
            resultado.getAuditoria().setErrorMsg(e.getMessage());
        } catch (Exception e) {
            logger.error(strTxId + "Exception : ", e);
            resultado.getAuditoria().setTxId(txId);
            resultado.getAuditoria().setErrorCode("WS_OBTENER_CERTIFICADO_XML");
            resultado.getAuditoria().setErrorMsg(e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                logger.error(strTxId + " Error al cerrar los recursos usados en la ejecución del SP : ", e);
                resultado.getAuditoria().setTxId(txId);
                resultado.getAuditoria().setErrorCode("WS_OBTENER_CERTIFICADO_XML");
                resultado.getAuditoria().setErrorMsg(e.getMessage());
            }
        }
        return resultado;

    }

    public static void main(String[] args) {
        GestionVUCEDao class1 = new GestionVUCEDao();
        DocumentosAdjuntos docAdj = new DocumentosAdjuntos();
        ArrayList<AdjuntoDocumento> arrAdj = new ArrayList<AdjuntoDocumento>();

        AdjuntoDocumento objDoc = new AdjuntoDocumento();

        objDoc.setUcmId("00010960");
        objDoc.setNombre("120100000251-001-1.pdf");

        arrAdj.add(objDoc);

        AdjuntoDocumento objDoc2 = new AdjuntoDocumento();

        objDoc2.setUcmId("00010959");
        objDoc2.setNombre("120100000251-001-2.pdf");

        arrAdj.add(objDoc2);

        AdjuntoDocumento objDoc3 = new AdjuntoDocumento();

        objDoc3.setUcmId("00010958");
        objDoc3.setNombre("comprobante_pago-120100000251-001.pdf");

        arrAdj.add(objDoc3);


        //docAdj.setListaAdjuntos(arrAdj);

        Boolean res;

        //res = class1.cierreTramite("13420998", "120100000251", "001", "O2012001030", docAdj);

        /*
    *
   public Boolean cierreTramite(String txId, String nroExpediente,
                                String idServicio,
                                DocumentosAdjuntos documentosAdjuntos) {
    */

    }
    
    public String obtenerPasswordFirmante(String codiusuausu)
      {
        String sql = UtilSQL.OBTENER_PASSWORD_FIRMANTE_ELECTRONICO;
        logger.info("obtenerPasswordFirmante(): AQUI VA EL " + sql);
        Connection con = null;
        PreparedStatement pst = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String passFirmante = "";
        String ucmidFirmante = "";
        String signerDN = "";
        try
        {
          con = conect.getConnectionBPM();
          pst = con.prepareStatement(sql);
          cs = con.prepareCall(sql);
          
          cs.setString(1, codiusuausu);
          cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
          cs.executeQuery();
          rs = (ResultSet)cs.getObject(2);
          while (rs.next())
          {
            passFirmante = rs.getString(1);
            ucmidFirmante = rs.getString(2);
            //signerDN = rs.getString(4);
          }
        }
        catch (SQLException e)
        {
          logger.error("obtenerPasswordFirmante", e);
        }
        catch (Exception e)
        {
          logger.error("obtenerPasswordFirmante", e);
        }
        finally
        {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando el result set:" +
                             sqe.getMessage());
            }
            try {
                if (pst != null)
                    pst.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando el statement:" +
                             sqe.getMessage());
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando cerrando la conexiï¿½n con la base de datos:" +
                             sqe.getMessage());
            }
        }
        return passFirmante + "]]]" + ucmidFirmante + "]]]" + signerDN;
      }

    public void registrarCertificadoXML(String txId, String codigoExpediente, String ordenVUCE, byte[] certificado) {        
        strTxId = "[" + txId + "]";
        logger.info("TxId: " + strTxId);
        logger.info(strTxId + " CodigoExpediente:" + codigoExpediente);
        logger.info(strTxId + " ordenVUCE:" + ordenVUCE);
        logger.info(strTxId + " ******** REGISTRAR CERTIFICADO XML ********");
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = UtilSQL.REGISTRAR_CERTIFICADO_XML;

        try {
            con = conect.getConnectionBPM();
            cs = con.prepareCall(sql);
            cs.setString("p_Expediente", codigoExpediente);
            cs.setString("p_Orden_Vuce", ordenVUCE);
            cs.setBlob("p_Cfe", new ByteArrayInputStream(certificado));            
            cs.execute();
        } catch (Exception e) {
            logger.error(strTxId + "SQLException : ", e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
                if (cs != null)
                    cs.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                logger.error(strTxId + " Error al cerrar los recursos usados en la ejecución del SP : ", e);                
            }
        }
        
    }
}
