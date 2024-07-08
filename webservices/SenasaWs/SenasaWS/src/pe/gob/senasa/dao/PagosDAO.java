package pe.gob.senasa.dao;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import pe.gob.senasa.bean.ConceptoPago;
import pe.gob.senasa.bean.Recibo;
import pe.gob.senasa.bean.ReciboServicio;
import pe.gob.senasa.bean.ServicioPago;
import pe.gob.senasa.bean.ServicioPagos;
import pe.gob.senasa.bean.TipoPago;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.PagosInterface;
import pe.gob.senasa.util.Utility;


public class PagosDAO extends BaseDAO implements PagosInterface {

    protected static Logger logger = Logger.getLogger(PagosDAO.class);
    private String msgErr = "";
   // ConectionApp cnApp = null;
    private DBHelper helper;

    public PagosDAO() {
        super();
        //cnApp = new ConectionApp();
        helper = new DBHelper(SenasaSQL.DATA_SOURCE_PAGOS);
    }

    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("PAGOS - " + s, p2);
    }

    public String getMsgErr() {
        return msgErr;
    }

    public String guardarReciboPago(Recibo reciboPago) {

        String _idPersona = obtenerIdPersona(reciboPago.getDniRuc());
        String codigoRecibo;
        if ((_idPersona.isEmpty()) || (_idPersona == "")) {
            logger.fatal("NO SE ENCONTRO EL IDENTIFICADOR DE PERSONA PARA EL SOLICITANTE: " + reciboPago.getDniRuc());
            msgErr = "NO SE ENCONTRO EL IDENTIFICADOR DE PERSONA PARA EL SOLICITANTE: " + reciboPago.getDniRuc();
            return "-1";
        }
        //String observacion = cargarSaldo(dniRucSolicitante, montoPagado);

        String sql = SenasaSQL.CREAR_RECIBO;
        Log(" AQUI VA EL " + sql);

        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        Connection con = null;
        PreparedStatement pst = null;
        CallableStatement cs = null;

        String retval = "";
        logger.debug("Entrando a ejecutar crearRecibo()");

        try {
            logger.debug("reciboPago.getCodigoExpediente():" + reciboPago.getCodigoExpediente());
            logger.debug("reciboPago.getCodigoSolicitud():" + reciboPago.getCodigoSolicitud());
            logger.debug("reciboPago.getDniRuc():" + reciboPago.getDniRuc());
            logger.debug("reciboPago.getCodigoCentroTramite():" + reciboPago.getCodigoCentroTramite());
            logger.debug("reciboPago.getObservacion:():" + reciboPago.getObservacion());
            logger.debug("reciboPago.getUrlRecibo():" + reciboPago.getUrlRecibo());

            //con = cnApp.getConnection();
            //con = cnApp.getConnPagos();  //PCSM 05/01/2017
            con = helper.getConnection();
            con.setAutoCommit(false);
            //pst = con.prepareStatement(sql);
            cs = con.prepareCall(sql);
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setString(2, reciboPago.getCodigoExpediente());
            cs.setString(3, reciboPago.getCodigoSolicitud());
            cs.setString(4, _idPersona);
            cs.setString(5, reciboPago.getCodigoCentroTramite());
            cs.setString(6, reciboPago.getObservacion());
            cs.setString(7, reciboPago.getUrlRecibo());
            Log(" = ANTES DE EJECUTAR = ");
            cs.execute();
            codigoRecibo = cs.getString(1);
            int k;

            logger.debug("Entrando a guardar los Servicios en guardarReciboServicio()");

            logger.debug("guardarReciboPago.getReciboServicio().size(): " + reciboPago.getReciboServicio().size());

            for (k = 0; k < reciboPago.getReciboServicio().size(); k++) {
                String _codigoRecibo = codigoRecibo; //arrayRecibosServicios.get(k).getCodigoRecibo();
                String _codigoServicio = reciboPago.getReciboServicio().get(k).getCodigoServicio();
                Double _montoServicio = reciboPago.getReciboServicio().get(k).getMontoServicio();
                Double _cantidad = reciboPago.getReciboServicio().get(k).getCantidad();
                logger.debug("guardarReciboServicio.CodigoRecibo: " + _codigoRecibo);
                logger.debug("guardarReciboServicio.CodigoServicio: " + _codigoServicio);
                logger.debug("guardarReciboServicio.MontoServicio: " + _montoServicio);
                logger.debug("guardarReciboServicio.Cantidad: " + _cantidad);

                String operResult = guardarReciboServicio(_codigoRecibo, _codigoServicio, _montoServicio, _cantidad, con);
                if (operResult.trim() != "") {
                    msgErr = operResult.trim();
                    logger.fatal(msgErr);
                    return "-1";
                }

            }
            logger.debug("Finalizando guardar los Servicios en guardarReciboServicio()");

            con.commit();
            con.setAutoCommit(true);
            Log(" = YA EJECUTE = ");
            retval = codigoRecibo;
            Log(" = FIN TODITO = ");

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException f) {
                Log("guardarReciboPago", f);
                msgErr = f.getMessage();
            }
            Log("guardarReciboPago", e);

        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException f) {
                Log("guardarReciboPago", f);
                msgErr = f.getMessage();
            }
            Log("guardarReciboPago", e);
        } finally {
            //cleanup(con, pst, null);
            try {
                helper.cleanup(con, pst, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
        //return false;

    }

    private String guardarReciboServicio(String codigoRecibo, String codigoServicio, Double montoServicio, Double cantidad,
                                         Connection con) {

        String sql = SenasaSQL.CREAR_RECIBO_DETALLE;
        Log(" AQUI VA EL " + sql);

        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        PreparedStatement pst = null;

        String retval = "";
        try {
            pst = con.prepareStatement(sql);
            //(codigo_recibo, codigo_servicio, monto_servicio, cantidad)
            pst.setString(1, codigoRecibo);
            pst.setString(2, codigoServicio);
            pst.setString(3, cantidad.toString());
            pst.setDouble(4, montoServicio);

            Log(" = ANTES DE EJECUTAR = ");
            pst.execute();

            Log(" = YA EJECUTE = ");
            retval = "";
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("guardarReciboServicio", e);
            retval = e.getMessage();
        } catch (Exception e) {
            Log("guardarReciboServicio", e);
            retval = e.getMessage();
        } finally {
            // Datacleanup(con, pst);
        }
        return retval;

    }

    public String registrarPago(String codigoRecibo, Integer codTipoPago, Double monto, String fechaOper, String boletaFecha,
                                String boletaNumero, String dniRuc) {

        String _idPersona = obtenerIdPersona(dniRuc.trim());
        if ((_idPersona.isEmpty()) || (_idPersona == "")) {
            logger.fatal("NO SE ENCONTRO EL IDENTIFICADOR DE PERSONA PARA EL SOLICITANTE: " + dniRuc);
            msgErr = "NO SE ENCONTRO EL IDENTIFICADOR DE PERSONA PARA EL SOLICITANTE: " + dniRuc;
            return msgErr;
        }

        String sql = SenasaSQL.REGISTRAR_PAGO;
        Log("registrarPago(). AQUI VA EL " + sql);

        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        Connection con = null;
        PreparedStatement pst = null;

        if (boletaFecha.isEmpty())
            boletaFecha = "01/01/1900";

        if (boletaFecha.trim().equals(""))
            boletaFecha = "01/01/1900";

        logger.debug("codigoRecibo:" + codigoRecibo);
        logger.debug("codTipoPago:" + codTipoPago);
        logger.debug("fechaOper:" + fechaOper);
        logger.debug("boletaFecha:" + boletaFecha);
        logger.debug("boletaNumero:" + boletaNumero);
        logger.debug("_idPersona:" + _idPersona);

        String retval = "0";
        try {
            //con = cnApp.getConnection();
            //con = cnApp.getConnPagos();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            //(codigo_recibo, codigo_servicio, monto_servicio, cantidad)
            pst.setString(1, codigoRecibo);
            pst.setInt(2, codTipoPago);
            pst.setDouble(3, monto);
            pst.setDate(4, Utility.parseStringToDate(fechaOper));
            pst.setDate(5, Utility.parseStringToDate(boletaFecha));
            pst.setString(6, boletaNumero);
            pst.setString(7, _idPersona);

            Log(" = ANTES DE EJECUTAR = ");
            pst.execute();
            //llamar al otro procedimiento

            boolean oper = completarRecibo(codigoRecibo, con);

            con.commit();
            con.setAutoCommit(true);

            Log(" = YA EJECUTE = ");

            Log(" = FIN TODITO = ");

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException f) {
                Log("registrarPago", f);
                retval = f.getMessage();
            }
            Log("registrarPago", e);

        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException f) {
                Log("registrarPago", f);
                retval = f.getMessage();
            }
            Log("registrarPago", e);
        } finally {
            //cleanup(con, pst);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;

    }

    private boolean completarRecibo(String codigoRecibo, Connection con) {
        String sql = SenasaSQL.COMPLETAR_PAGO;
        Log("completarRecibo(). AQUI VA EL " + sql);

        PreparedStatement pst = null;

        boolean retval = false;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoRecibo);

            Log(" = ANTES DE EJECUTAR = ");
            pst.execute();

            Log(" = YA EJECUTE = ");
            retval = true;
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("completarRecibo", e);
        } catch (Exception e) {
            Log("completarRecibo", e);
        } finally {
            //Datacleanup(con, pst);
        }
        return retval;
    }

    private String obtenerIdPersona(String dniRucSolicitante) {

        String sql = SenasaSQL.OBTENER_ID_PERSONA;
        Log("obtenerIdPersona(): AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String retval = "";
        try {
            //con = cnApp.getConnection();
            //con = cnApp.getConnPagos();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, dniRucSolicitante);
            rs = pst.executeQuery();

            int i = 0;
            while (rs.next()) {
                i++;
                if (i == 1)
                    retval = rs.getString(1);
            }
            Log(" = TODO FINITO = ");
        } catch (SQLException e) {
            Log("obtenerIdPersona", e);
        } catch (Exception e) {
            Log("obtenerIdPersona", e);
        } finally {
            //cleanup(con, pst, rs);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    public String actualizarRecibo(String codigoRecibo, String observacion, String urlRecibo, String ucmId) {

        String sql = SenasaSQL.ACTUALIZA_URL_RECIBO;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;

        String retval = "0";
        try {
            //con = cnApp.getConnection();
            //con = cnApp.getConnPagos();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            
            pst = con.prepareStatement(sql);

            pst.setString(1, codigoRecibo);
            pst.setString(2, observacion);
            pst.setString(3, urlRecibo);
            pst.setString(4, ucmId);

            Log(" = ANTES DE EJECUTAR = ");
            pst.execute();

            Log(" = YA EJECUTE = ");

            Log(" = FIN TODITO = ");

        } catch (SQLException e) {
            Log("actualizarRecibo", e);
            retval = e.getMessage();
        } catch (Exception e) {
            Log("actualizarRecibo", e);
            retval = e.getMessage();
        } finally {
            //cleanup(con, pst, null);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;

    }

    public Recibo obtenerRecibo(String codigoRecibo) {

        String sql = SenasaSQL.OBTENER_RECIBO_DATOS;
        Log(" AQUI VA EL " + sql);

        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        Connection con = null;
        PreparedStatement pst = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ResultSet rsReciboDetalle = null;

        Recibo retval = new Recibo();
        try {
            //pst = con.prepareStatement(sql);
            //con = cnApp.getConnection();
            //con = cnApp.getConnPagos();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            cs = con.prepareCall(sql);
            cs.setString(1, codigoRecibo);
            Log(" = ANTES DE EJECUTAR = ");
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            Log(" = ENTRANDO = ");
            rs = (ResultSet)cs.getObject(2);
            rsReciboDetalle = (ResultSet)cs.getObject(3);
            SimpleDateFormat parseDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            while (rs.next()) {
                retval.setCodigoRecibo(codigoRecibo);
                retval.setPrefijo(rs.getString("Prefijo"));
                retval.setNumeroRecibo(rs.getString("Numero_Recibo"));
                retval.setFechaRecibo(parseDate.parse(rs.getString("Fecha_Recibo")));
                retval.setCodigoExpediente(rs.getString("Codigo_Expediente"));
                retval.setMontoPagado(rs.getDouble("Monto_Pagado"));
                retval.setMontoRecibo(rs.getDouble("Monto_Total"));
                retval.setMontoSaldo(rs.getDouble("Monto_Saldo"));
                retval.setUrlRecibo(rs.getString("Url_Recibo"));
                retval.setEstado(rs.getString("Estado"));
                retval.setPersonaId(rs.getString("Persona_Id"));
                retval.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));
                retval.setObservacion(rs.getString("Observacion"));

                ArrayList<ReciboServicio> arrRecDetalle = new ArrayList<ReciboServicio>();

                while (rsReciboDetalle.next()) {
                    ReciboServicio objRecDetalle = new ReciboServicio();
                    objRecDetalle.setCodigoRecibo(rsReciboDetalle.getString("codigo_recibo"));
                    objRecDetalle.setCodigoServicio(rsReciboDetalle.getString("codigo_servicio"));
                    objRecDetalle.setNombreServicio(rsReciboDetalle.getString("descripcion_servicio"));
                    objRecDetalle.setCantidad(rsReciboDetalle.getDouble("cantidad"));
                    objRecDetalle.setMontoServicio(rsReciboDetalle.getDouble("monto"));
                    arrRecDetalle.add(objRecDetalle);
                }
                retval.setReciboServicio(arrRecDetalle);
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerExpediente", e);
        } catch (Exception e) {
            Log("obtenerExpediente", e);
        } finally {
            try {
                if (rsReciboDetalle != null)
                    rsReciboDetalle.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando el result set:" +
                             sqe.getMessage());
            }
            //cleanup(con, pst, rs);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    public ArrayList<TipoPago> obtenerTipoPagos() {

        String sql = SenasaSQL.OBTENER_TIPO_PAGOS;
        Log(" AQUI VA EL " + sql);

        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        Connection con = null;
        PreparedStatement pst = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        ArrayList<TipoPago> retval = new ArrayList<TipoPago>();
        try {
            //con = cnApp.getConnection();
            //con = cnApp.getConnPagos();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            cs = con.prepareCall(sql);
            Log(" = ANTES DE EJECUTAR = ");
            cs.registerOutParameter(1, OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            Log(" = ENTRANDO = ");
            rs = (ResultSet)cs.getObject(1);


            while (rs.next()) {
                TipoPago oper = new TipoPago();
                oper.setCodigoTipoPago(rs.getString("Codigo_Tipo_Pago"));
                oper.setDescripcionTipoPago(rs.getString("Descripcion_Tipo_Pago"));
                retval.add(oper);
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoPagos", e);
        } catch (Exception e) {
            Log("obtenerTipoPagos", e);
        } finally {
            //cleanup(con, pst, rs);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    public ArrayList<ServicioPago> obtenerTarifario(ServicioPagos servicioPagos) {
        //Esto solo es temporal para pruebas a la espera de los PLSQL por parte de
        //Senasa
        logger.debug("Pagos: Entrando a ejecutar obtenerTarifario()");
        Connection con = null; //PCSM 06/01/2017
        ArrayList<ServicioPago> retval = new ArrayList<ServicioPago>();
        try {
            int contServicioEntrada = 0;

            for (ServicioPago servicioEntrada : servicioPagos.getListaServicioPago()) {
                logger.debug("Pagos: servicioEntrada.getCodigoServicio()=" + servicioEntrada.getCodigoServicio());

                //--armando los strings de las listas de productos, vacunas y analisis
                String cadlistaProductos = "";
                String cadlistaVacunas = "";
                String cadlistaAnalisis = "";

                if (servicioEntrada.getListaProductos() != null) {
                    if (servicioEntrada.getListaProductos().size() > 0) {

                        logger.debug("Pagos: Entro a lista de Productos. servicioEntrada.getListaProductos().size()=" +
                                     servicioEntrada.getListaProductos().size());
                        logger.debug("Pagos: Verifica si es NULL");
                        for (ConceptoPago objProducto : servicioEntrada.getListaProductos()) {
                            if (objProducto != null) {
                                String codigoItem = objProducto.getCodigoConcepto();
                                String unidadMedida = objProducto.getUnidadMedida();
                                String cantidadPeso = "" + objProducto.getCantidadPeso();

                                cadlistaProductos =
                                        cadlistaProductos + codigoItem + ":" + cantidadPeso + ":" + unidadMedida + "|";
                                logger.debug("cadlistaProductos: " + cadlistaProductos);

                            }
                        }
                    }
                }

                if (servicioEntrada.getListaVacunas() != null) {
                    if (servicioEntrada.getListaVacunas().size() > 0) {
                        logger.debug("Pagos: Entro a lista de Vacunas. servicioEntrada.getListaVacunas().size()=" +
                                     servicioEntrada.getListaVacunas().size());
                        logger.debug("Pagos: Verifica si es NULL");

                        for (ConceptoPago objVacuna : servicioEntrada.getListaVacunas()) {
                            if (objVacuna != null) {
                                String codigoItem = objVacuna.getCodigoConcepto();
                                String unidadMedida = objVacuna.getUnidadMedida();
                                String cantidadPeso = "" + objVacuna.getCantidadPeso();

                                cadlistaVacunas = cadlistaVacunas + codigoItem + ":" + cantidadPeso + ":" + unidadMedida + "|";
                                logger.debug("cadlistaVacunas: " + cadlistaVacunas);
                            }
                        }
                    }
                }

                if (servicioEntrada.getListaAnalisis() != null) {
                    if (servicioEntrada.getListaAnalisis().size() > 0) {
                        logger.debug("Pagos: Entro a lista de Analisis. servicioEntrada.getListaAnalisis().size()=" +
                                     servicioEntrada.getListaAnalisis().size());
                        logger.debug("Pagos: Verifica si es NULL");

                        for (ConceptoPago objAnalisis : servicioEntrada.getListaAnalisis()) {
                            if (objAnalisis != null) {
                                String codigoItem = objAnalisis.getCodigoConcepto();
                                String unidadMedida = objAnalisis.getUnidadMedida();
                                String cantidadPeso = "" + objAnalisis.getCantidadPeso();

                                cadlistaAnalisis = cadlistaAnalisis + codigoItem + ":" + cantidadPeso + ":" + unidadMedida + "|";
                                logger.debug("cadlistaAnalisis: " + cadlistaAnalisis);
                            }
                        }
                    }
                }

                //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
                //Connection con = cnApp.getConnection();
                //Connection con = cnApp.getConnPagos();  //PCSM 05/01/2017
                con = helper.getConnection();  //PCSM 06/01/2017
                CallableStatement cs = null;
                ResultSet rs = null;

                String sql = SenasaSQL.OBTENER_SERVICIOS_ASOCIADOS;

                cs = con.prepareCall(sql);
                cs.setString(1, servicioEntrada.getCodigoServicio());

                Log(" = ANTES DE EJECUTAR = ");
                cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

                cs.execute();
                Log(" = ENTRANDO = ");
                rs = (ResultSet)cs.getObject(2);

                while (rs.next()) {

                    ServicioPago objServSalida = new ServicioPago();
                    objServSalida.setCodigoServicio(rs.getString("Codigo_Servicio"));
                    objServSalida.setNombreServicio(rs.getString("Descripcion_Servicio"));
                    objServSalida.setTipoServicio(rs.getString("Codigo_Tipo_Servicio"));
                    objServSalida.setCantidadServicio(servicioEntrada.getCantidadServicio());

                    Double _monto;

                    logger.debug("Entrando al metodo web calcularTarifaServicio()");
                    logger.debug("objServSalida.getCodigoServicio():" + objServSalida.getCodigoServicio());
                    logger.debug("objServSalida.getNombreServicio():" + objServSalida.getNombreServicio());
                    logger.debug("cadlistaProductos:" + cadlistaProductos);
                    logger.debug("cadlistaVacunas:" + cadlistaVacunas);
                    logger.debug("cadlistaAnalisis:" + cadlistaAnalisis);

                    _monto =
                            calcularTarifaServicio(objServSalida.getCodigoServicio(), servicioEntrada.getCantidadServicio(), cadlistaProductos,
                                                   cadlistaVacunas, cadlistaAnalisis);

                    objServSalida.setMontoAPagar(_monto);
                    logger.debug("calcularTarifaServicio(): _monto:" + _monto);


                    retval.add(objServSalida);
                }
                logger.debug("Iniciando Cierre del objeto CallableStatement");
                //cleanup(con, cs, rs);
                //PCSM 06/01/2017
                try {
                    helper.cleanup(con, cs, rs);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                logger.debug("Cerrando el objeto CallableStatement");
                contServicioEntrada++;
            }

            //----------------------ESTO ES TEMPORAL HASTA QUE LOS PROCEDIMIENTOS DE TARIFARIO SEAN COMPLETADOS:-----------------------
            /* retval.clear();

      ServicioPago obj1 = new ServicioPago();
      obj1.setCodigoServicio("254");
      obj1.setNombreServicio("AMPLIACION DE LA DELEGACION DE LA CERTIFICACION EMITIDA POR AMBITO DEPARTAMENTAL O REGIONAL");
      obj1.setCantidadServicio(1.0);
      obj1.setMontoAPagar(28.0);
      retval.add(obj1);

      ServicioPago obj2 = new ServicioPago();
      obj2.setCodigoServicio("032");
      obj2.setNombreServicio("INSPECCION ZOOSANITARIA DE EXPORTACION");
      obj2.setCantidadServicio(2.0);
      obj2.setMontoAPagar(144.6);
      retval.add(obj2);

      ServicioPago obj3 = new ServicioPago();
      obj3.setCodigoServicio("053");
      obj3.setNombreServicio("SERVICIO DE VACUNACION O CERTIFICACION DE CONDICION SANITARIA (PRUEBAS DIAGNOSTICAS HATO LIBRE, ENTRE OTROS)");
      obj3.setCantidadServicio(1.0);
      obj3.setMontoAPagar(56.0);
      retval.add(obj3);
        */
            Log(" = FIN TODITO = ");

        } catch (Exception e) {
            Log("obtenerTarifario", e);
        } finally {
            //Datacleanup(con, pst);
        }
        return retval;

    }

    private Double calcularTarifaServicio(String codigoServicio, Double cantidad, String tramaProductos, String tramaVacunas,
                                          String tramaAnalisis) {

        String sql = SenasaSQL.CALCULAR_TARIFA;
        Log(" AQUI VA EL " + sql);

        Connection _con = null;
        CallableStatement csdb = null;

        Double retval = 0.0;

        try {
            //_con = cnApp.getConnection();
            //_con = cnApp.getConnPagos();  //PCSM 05/01/2017
            _con = helper.getConnection();  //PCSM 06/01/2017
            
            csdb = _con.prepareCall(sql);

            csdb.registerOutParameter(1, OracleTypes.NUMBER);
            csdb.setString(2, codigoServicio);
            csdb.setDouble(3, cantidad);
            csdb.setString(4, tramaProductos);
            csdb.setString(5, tramaVacunas);
            csdb.setString(6, tramaAnalisis);

            Log(" = ANTES DE EJECUTAR = ");
            csdb.execute();

            Log(" = YA EJECUTE = ");

            retval = csdb.getDouble(1);
            Log(" = FIN TODITO = ");

        } catch (SQLException e) {
            Log("calcularTarifaServicio", e);
            //
        } catch (Exception e) {
            Log("calcularTarifaServicio", e);
        } finally {
            //cleanup(_con, csdb, null);
            //PCSM 06/01/2017
            try {
                helper.cleanup(_con, csdb, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;

    }

    public Boolean existeNumeroBoleta(String numeroBoleta) {

        String sql = SenasaSQL.VERIFICA_NUMEROBOLETA;

        Connection con = null;
        PreparedStatement pst = null;
        CallableStatement cs = null;
        Boolean retval = false;
        int valor = 0;

        try {
            //con = cnApp.getConnection();
            //con = cnApp.getConnPagos(); // PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            
            cs = con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.setString(2, numeroBoleta);
            cs.execute();

            valor = cs.getInt(1);

            if (valor == 1)
                retval = true;
            else
                retval = false;

            Log(" = TODO FINITO = ");
        } catch (SQLException e) {
            Log("existeNumeroBoleta", e);
        } catch (Exception e) {
            Log("existeNumeroBoleta", e);
        } finally {
            //cleanup(con, pst, null);
            //PCSM 06/01/2017
              try {
                  helper.cleanup(con, pst, null);
              } catch (Exception e) {
                  e.printStackTrace();
              }
        }
        return retval;
    }

    public Recibo obtenerReciboVUCE(String codigoExpediente, String codigoServicio, String idOrdenVuce) {

        String sql = SenasaSQL.OBTENER_RECIBO_VUCE;
        Log(" AQUI VA EL " + sql);

        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        Connection con = null;
        PreparedStatement pst = null;
        CallableStatement cs = null;
        ResultSet rsRecibo = null;
        ResultSet rsReciboDetalle = null;


        Recibo retval = new Recibo();
        try {
            //con = cnApp.getConnection();
            //con = cnApp.getConnPagos(); // PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            cs = con.prepareCall(sql);
            Log(" = ANTES DE EJECUTAR = ");

            cs.setString(1, codigoExpediente);
            cs.setString(2, codigoServicio);
            cs.setString(3, idOrdenVuce);
            cs.registerOutParameter(4, OracleTypes.CURSOR, "SYS_REFCURSOR");
            cs.registerOutParameter(5, OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            Log(" = ENTRANDO = ");

            rsRecibo = (ResultSet)cs.getObject(4);
            rsReciboDetalle = (ResultSet)cs.getObject(5);

            while (rsRecibo.next()) {
                retval.setCodigoRecibo(rsRecibo.getString("Codigo_Recibo"));
                retval.setPrefijo(rsRecibo.getString("Prefijo"));
                retval.setNumeroRecibo(rsRecibo.getString("Numero_Recibo"));
                retval.setFechaRecibo(rsRecibo.getDate("Fecha_Recibo"));
                retval.setCodigoExpediente(rsRecibo.getString("Codigo_Expediente"));
                retval.setMontoPagado(rsRecibo.getDouble("Monto_Pagado"));
                retval.setMontoRecibo(rsRecibo.getDouble("Monto_Total"));
                retval.setMontoSaldo(rsRecibo.getDouble("Monto_Saldo"));
                retval.setUrlRecibo(rsRecibo.getString("Url_Recibo"));
                retval.setEstado(rsRecibo.getString("Estado"));
                retval.setPersonaId(rsRecibo.getString("Persona_Id"));
                retval.setCodigoCentroTramite(rsRecibo.getString("Codigo_Centro_Tramite"));
                retval.setObservacion(rsRecibo.getString("Observacion"));

                ArrayList<ReciboServicio> arrRecDetalle = new ArrayList<ReciboServicio>();

                while (rsReciboDetalle.next()) {
                    ReciboServicio objRecDetalle = new ReciboServicio();
                    objRecDetalle.setCodigoRecibo(rsReciboDetalle.getString("codigo_recibo"));
                    objRecDetalle.setCodigoServicio(rsReciboDetalle.getString("codigo_servicio"));
                    objRecDetalle.setNombreServicio(rsReciboDetalle.getString("descripcion_servicio"));
                    objRecDetalle.setCantidad(rsReciboDetalle.getDouble("cantidad"));
                    objRecDetalle.setMontoServicio(rsReciboDetalle.getDouble("monto"));
                    arrRecDetalle.add(objRecDetalle);
                }
                retval.setReciboServicio(arrRecDetalle);

            }


            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerReciboVUCE", e);
        } catch (Exception e) {
            Log("obtenerReciboVUCE", e);
        } finally {
          try {
              if (rsRecibo != null)
                  rsRecibo.close();
          } catch (SQLException sqe) {
              logger.fatal("Ha ocurrido un error cerrando el result set:" +
                           sqe.getMessage());
          }
            //cleanup(con, pst, rsReciboDetalle);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rsReciboDetalle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }


    public static void mainss(String[] args) {

        //PagosDAO objDAO = new PagosDAO();
        //String resultado = objDAO.registrarPago("110600000014", 2, 250.0, "20/06/2011", "17/06/2011", "222222", "33261657");
        Recibo objrec = new Recibo();

        ArrayList<ServicioPago> arrServiciosPagos = new ArrayList<ServicioPago>();

        ServicioPagos objServicioPagos = new ServicioPagos();

        ServicioPago objServicioPago01 = new ServicioPago();

        objServicioPago01.setCodigoServicio("001");
        objServicioPago01.setCantidadServicio(1.0);

        objServicioPagos.getListaServicioPago().add(objServicioPago01);


        ServicioPago objServicioPago02 = new ServicioPago();

        objServicioPago02.setCodigoServicio("010");
        objServicioPago02.setCantidadServicio(1.0);

        objServicioPagos.getListaServicioPago().add(objServicioPago02);


        PagosDAO objDAO = new PagosDAO();

        objrec = objDAO.obtenerReciboVUCE("112100000016", "001", "XXXXXXXXX");

        //arrServiciosPagos = objDAO.obtenerTarifario(objServicioPagos);

        /*
    ArrayList<ReciboServicio> arrlist = new ArrayList<ReciboServicio>();
    ReciboServicio objrecser = new ReciboServicio();

    objrecser.setCodigoRecibo("");
    objrecser.setCodigoServicio("097");
    objrecser.setMontoServicio(560.0);
    objrecser.setCantidad(5.0);

    arrlist.add(objrecser);

    //ArrayList<ReciboServicio> arrlist2 = new ArrayList<ReciboServicio>();
    ReciboServicio objrecser2 = new ReciboServicio();

    objrecser2.setCodigoRecibo("");
    objrecser2.setCodigoServicio("340");
    objrecser2.setMontoServicio(560.0);
    objrecser2.setCantidad(1.0);

    arrlist.add(objrecser2);

    Recibo objRecibo = new Recibo();

    objRecibo.setDniRuc("33261657");
    objRecibo.setCodigoSolicitud("119900000001");
    objRecibo.setCodigoExpediente("112100000003");
    objRecibo.setCodigoCentroTramite("21");
    objRecibo.setObservacion("");
    objRecibo.setUrlRecibo("");
    objRecibo.setReciboServicio(arrlist);

    PagosDAO objDAO = new PagosDAO();

    String salida = objDAO.guardarReciboPago(objRecibo);
*/
    }

    public static void main(String[] args) {
        // Test2 test2 = new Test2();
        org.apache.xmlbeans.XmlObject resul = null;
        /*

       <?xml version="1.0" encoding="ISO-8859-1"?>
       <requerimientoPago xmlns="RequerimientoPago-1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="RequerimientoPago-1.0 RequerimientoPago-1.0.xsd">
          <tasa>12.15</tasa>
          <codigoMotivo>1</codigoMotivo>
          <motivo><![CDATA[Descripci�n del motivo del pago]]></motivo>

       </requerimientoPago>*/
        String tasa = "23";
        String codMotivo = "1";
        String motivo = "primer motivp";
        try {

            String docBody = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                "<requerimientoPago  xmlns=\"RequerimientoPago-1.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"RequerimientoPago-1.0 RequerimientoPago-1.0.xsd\" >\n" +
                "<tasa>" + tasa + "</tasa>\n" +
                "<codigoMotivo>" + codMotivo + "</codigoMotivo>\n" +
                "<motivo><![CDATA[" + motivo + "]]></motivo>\n" +
                "</requerimientoPago>";

            resul = org.apache.xmlbeans.XmlObject.Factory.parse(docBody);
            Blob _blob;
            _blob = (Blob)resul;


            System.out.println(resul);
        } catch (XmlException e) {
            resul = null;
        }
    }

}
