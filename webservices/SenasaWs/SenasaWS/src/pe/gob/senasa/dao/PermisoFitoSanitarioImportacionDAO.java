package pe.gob.senasa.dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import oracle.jdbc.OracleTypes;

import oracle.sql.STRUCT;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Ampliacion;
import pe.gob.senasa.bean.AnexoPFI;
import pe.gob.senasa.bean.LugarProduccionAnexoPFI;
import pe.gob.senasa.bean.LugarProduccionProductoPFI;
import pe.gob.senasa.bean.PaisOrigenAnexoPFI;
import pe.gob.senasa.bean.PaisOrigenProductoPFI;
import pe.gob.senasa.bean.PermisoFitosanitarioImportacion;
import pe.gob.senasa.bean.ProductoPFI;
import pe.gob.senasa.bean.PuntoIngresoAnexoPFI;
import pe.gob.senasa.bean.PuntoIngresoProductoPFI;
import pe.gob.senasa.bean.ReqImpProducto;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.PermisoFitoSanitarioImportacionInterface;
import pe.gob.senasa.util.Utility;


public class PermisoFitoSanitarioImportacionDAO extends BaseDAO implements PermisoFitoSanitarioImportacionInterface {

    protected static Logger logger =Logger.getLogger(PermisoFitoSanitarioImportacionDAO.class);
    //ConectionApp cnApp =null;
    private DBHelper helper;
    
    public PermisoFitoSanitarioImportacionDAO(){
        super();
        //cnApp= new ConectionApp();
        helper = new DBHelper(SenasaSQL.DATA_SOURCE_PERMFITOIMPO);
    }

    public PermisoFitosanitarioImportacion obtenerPFIxNoCertificado(String noCertificado) {
        Connection con = null;

        PermisoFitosanitarioImportacion retval =
            new PermisoFitosanitarioImportacion();
        try {
            //con = cnApp.getConnection();
            //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            Log(" = INICIO = ");
            //CCODEXP,CREGUNI,CCODSED,CNOMPRE,CCODDEP,CCODPROV,CCODDIST,CDIRECCION
            //
            //
            retval =obtenerPermisoFitosanitarioImportacion(noCertificado, con);
            ArrayList<ProductoPFI> listPfi =
                obtenerProductoPFIxCodExp(retval.getNoCertificado(), con);
            
            retval.setProductosPFI(listPfi);
            HashMap<String, ProductoPFI> map =
                new HashMap<String, ProductoPFI>();
            for (ProductoPFI ppfi : listPfi) {
                map.put(ppfi.getCodigoProducto(), ppfi);
            }
            
            SolicitanteDAO solDao = new SolicitanteDAO();
            
            retval.setSolicitante(solDao.obtenerSolicitanteXNumeroCertificado(retval.getNoCertificado()));
            
            
            retval.setLugaresProduccionProductoPFI(obtenerLugaresProduccionProductoPFI(map,
                                                                                       retval.getNoCertificado(),
                                                                                       con));
            retval.setPuntoIngresoProductoPFI(obtenerPuntoIngresosProductoPFI(map,
                                                                              retval.getNoCertificado(),
                                                                              con));
            retval.setPaisesOrigenProductoPFI(obtenerPaisOrigenProductoPFI(map,
                                                                           retval.getNoCertificado(),
                                                                           con));
            
            ArrayList<AnexoPFI> listAnexos = obtAnexosPFI(retval.getNoCertificado(), con);
            Log("= reval.getNoCertificado()="+retval.getNoCertificado());
            Log("= listAnexos.size()= "+listAnexos.size());
            retval.setAnexosPFI(listAnexos);
                  
            Log(" = TODO FINITO = ");
        } catch (SQLException e) {
            Log("obtenerPFIxNoCertificado", e);
        } catch (Exception e) {
            Log("obtenerPFIxNoCertificado", e);
        } finally {
            //cleanup(con, null);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con,null, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }
    
    public String generarNumeroPermisoPFI(String codCentroTramite){
      logger.debug("OBTENER_NUMERO_PFI");
      Connection con=null;
      CallableStatement cs=null;
      String retval="";
        try {
            //con=cnApp.getConnection();
            //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017

            con = helper.getConnection();  //PCSM 06/01/2017
            String sql =SenasaSQL.OBTENER_NUMERO_PERMISO_PFI;
            logger.debug("AQUI VA EL QUERY: "+sql);
            
            cs=con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.setString(2, codCentroTramite);          
            logger.debug("Se va a ejecutar OBTENER_NUMERO_PERMISO_PFI");
            cs.execute();
            logger.debug("Se ejecutó OBTENER_NUMERO_PERMISO_PFI");           
            retval=cs.getString(1);          
            logger.debug("Numero PFI obtenido: "+retval);
        } catch (SQLException e) {
            Log("obtenerNumeroPFI error", e);
        } catch (Exception e) {
            Log("obtenerNumeroPFI error", e);
        } finally {
            //cleanup(con, cs);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, cs,null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;   
    }
    
    public ArrayList<PermisoFitosanitarioImportacion> obtenerPFIxSolicitante(String dniRuc) {
        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoFitosanitarioImportacion();//PCSM 05/01/2017    
        Connection con = null; //PCSM 06/01/2017
        String sql = SenasaSQL.OBTENER_PERMISOS_PFI_X_CLIENTE;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<PermisoFitosanitarioImportacion> retval =
            new ArrayList<PermisoFitosanitarioImportacion>();
        try {
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, dniRuc);
            Log(" = voy a ejecutar  OBTENER_PERMISOS_X_CLIENTE = ");
            rs = pst.executeQuery();
            ArrayList<String> nosCertificados = new ArrayList<String>();
            while (rs.next()) {
                nosCertificados.add(rs.getString(1));
            }
            rs.close();
            for (String s : nosCertificados) {
                PermisoFitosanitarioImportacion aux =
                    obtenerPFIxNoCertificado(s);
                retval.add(aux);
            }
            Log(" = TODO FINITO = ");
        } catch (SQLException e) {
            Log("obtenerPZIxSolicitante", e);
        } catch (Exception e) {
            Log("obtenerPZIxSolicitante", e);
        } finally {
            //cleanup(con, null);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst,rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    public Boolean guardarPFI(PermisoFitosanitarioImportacion pfi) {
        if (ExisteNumerosCertificados(pfi.getNoCertificado())) {
            return actualizarPFI(pfi);
        } else {
            return salvarPFI(pfi);
        }
    }

    private Boolean actualizarPFI(PermisoFitosanitarioImportacion pfi) {
        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoFitosanitarioImportacion();//PCSM 05/01/2017 
        Connection con = null; //PCSM 06/01/2017
        try {
            con = helper.getConnection();  //PCSM 06/01/2017
            con.setAutoCommit(false);
            if (DeleteAll(pfi.getNoCertificado(), con))
                return salvarPFI(pfi, con);
            else
                return false;
        } catch (Exception e) {
            ManejarExcepcion(con, e);
        }
        return false;
    }

    private void ManejarExcepcion(Connection con, Exception e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("guardarPermisoPFI", f);
        }
        Log("guardarPermisoPFI", e);
    }

    private Boolean salvarPFI(PermisoFitosanitarioImportacion pfi) {
        Connection con =null;
        try {
            //con = cnApp.getConnection();
            //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
        } catch (Exception e) {
          logger.debug("salvarPFI error: "+e.getMessage());
        }
        return salvarPFI(pfi, con);
    }

    private Boolean salvarPFI(PermisoFitosanitarioImportacion pfi,Connection con) {
        boolean retval = false;
        try {

            Log(" = INICIO salvarPFI= ");

            con.setAutoCommit(false);
            
            String idPersona ="";
            
            logger.debug("pfi.getSolicitante().getCodigoSolicitante():"+pfi.getSolicitante().getCodigoSolicitante());
            
            if(pfi.getSolicitante().getCodigoSolicitante()==null){
              idPersona = ExpedienteDAO.ObtenerIdPersonaxExpediente(con, pfi.getNoFolio());
            }
            else{
              idPersona =  pfi.getSolicitante().getCodigoSolicitante();
            }
              
            guardarPFI(pfi, idPersona, con);
            //Guardar cosas PFI
            for (ProductoPFI proH : pfi.getProductosPFI()) {
                if (proH != null) {
                    Log(" = VOY A GUARDAR LOS PRODUCTOS PFI = ");
                    guardarProductoPFI(proH, pfi.getNoCertificado(), con);
                    Log(" = VOY A GUARDAR LOS puntos de ingreso = ");
                    guardarPuntosIngresosPFI(pfi, con, proH);
                    Log(" = VOY A GUARDAR LOS paises de origen = ");
                    guardarPaisOrigenPFI(pfi, con, proH);
                    Log(" = VOY A GUARDAR LOS lugares de produccion = ");
                    guardarLugaresProduccionPFI(pfi, con, proH);
                }
            }
            //
            for (AnexoPFI anex : pfi.getAnexosPFI()) {
                if (anex != null) {
                    guardarAnexosPFI(anex, pfi.getNoCertificado(), con);
                    guardarPuntosIngresosAnexoPFI(pfi, con, anex);
                    guardarPaisOrigenAnexoPFI(pfi, con, anex);
                    guardarLugaresProduccionAnexoPFI(pfi, con, anex);
                }
            }
            con.commit();
            con.setAutoCommit(true);
            //
            Log(" = TODO FINITO = ");
            retval = true;
        } catch (SQLException e) {
            ManejarException(con, e);
        } catch (Exception e) {
            ManejarException(con, e);
        } finally {
            cleanup(con, null);
        }
        return retval;

    }

    private void guardarLugaresProduccionPFI(PermisoFitosanitarioImportacion pfi, Connection con,ProductoPFI proH) throws SQLException {
        for (LugarProduccionProductoPFI lpfi :pfi.getLugaresProduccionProductoPFI()) 
        {
            if(lpfi != null && lpfi.getCodigoProducto().compareTo(proH.getCodigoProducto()) == 0) 
            {
                guadarLugarProduccionPFI(pfi.getNoCertificado(), lpfi, con);
            }
        }
    }

    private void guardarPaisOrigenPFI(PermisoFitosanitarioImportacion pfi,Connection con,ProductoPFI proH) throws SQLException {
        
        ArrayList<PaisOrigenProductoPFI> arrPaisesOrigen =   pfi.getPaisesOrigenProductoPFI();
        PaisOrigenProductoPFI objpaisPFI = null;
        
        logger.debug("Numero de datos en ArrayList<PaisOrigenProductoPFI>:"+ arrPaisesOrigen.size());
        
        if(arrPaisesOrigen.size()>0) {
          logger.debug("Iniciando el proceso guardarPaisOrigenPFI");
        }
        else {
          logger.debug("Error al obtener datos desde ArrayList<PaisOrigenProductoPFI>");
        }
        
        for (PaisOrigenProductoPFI paiPFI : pfi.getPaisesOrigenProductoPFI()) {
             logger.debug("paiPFI:"+paiPFI);
             logger.debug("paiPFI.getCodigoProducto():"+paiPFI.getCodigoProducto());
             logger.debug("proH:"+proH);
             logger.debug("proH.getCodigoProducto():"+proH.getCodigoProducto());
             if (paiPFI != null && paiPFI.getCodigoProducto().compareTo(proH.getCodigoProducto()) ==0) {
                guadarPaisOrigenPFI(pfi.getNoCertificado(), paiPFI, con);
             }
        }
    }

    private void guardarPuntosIngresosPFI(PermisoFitosanitarioImportacion pfi,
                                          Connection con,
                                          ProductoPFI proH) throws SQLException {
        for (PuntoIngresoProductoPFI puntIn :
             pfi.getPuntoIngresoProductoPFI()) {

            if (puntIn != null &&
                puntIn.getCodigoProducto().compareTo(proH.getCodigoProducto()) ==
                0) {
                //  Log(" ============ ENTER A GUARDAR UN PUNTO DE INGRESO ========================");
                
                logger.debug("proH.getCodUniMed():"+proH.getCodUniMed());
                guardarPuntoIngresoPFI(proH, puntIn, pfi.getNoCertificado(),
                                       con);
            }
        }
    }

    private void ManejarException(Connection con, SQLException e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("guardarPFI", f);
        }
        Log("guardarPFI", e);
    }

    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("PermisoFitoSanitarioImportacionDAO - " + s, p2);
    }


    private void guardarPFI(PermisoFitosanitarioImportacion pfi,
                            String idPersona,
                            Connection con) throws SQLException {

        //persona_id,numero_permiso,codigo_expediente,url_pfi_definitivo,centro_tramite_solicitud
        String sql = SenasaSQL.GUARDAR_PFI;
        //Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        pst = con.prepareCall(sql);
        pst.setString(1, idPersona);
        pst.setString(2, pfi.getNoCertificado());
        pst.setString(3, pfi.getNoFolio());
        pst.setString(4, pfi.getUrlPFIDefinitivo());
        pst.setString(5, pfi.getDireccionEjecutiva());
        pst.setDate(6,Utility.parseStringToDate(pfi.getFechaDeEmicion()));
        pst.setString(7, "ACTIVO");
        
        logger.debug("isIndicadorAmpliacion:"+ pfi.isIndicadorAmpliacion());
        
        pst.setString(8, pfi.isIndicadorAmpliacion()==true?"1":null);
       
        
        //Ingresa el codigo de requisito de importacion del producto
        logger.debug("CODIGO DE REQUERIMIENTO DE PRODUCTO = " +  pfi.getCodigoRequImpoProducto());
        pst.setString(9, pfi.getCodigoRequImpoProducto());
        
        // Log(" = VOY A EJECUTAR GUARDAR_PZSI = ");
        pst.execute();
        // Log(" = LISTO QUERY DE GUARDAR_PZSI = ");
    }

    private void guardarProductoPFI(ProductoPFI proH, String codExp,
                                    Connection con) throws SQLException {
        String sql = SenasaSQL.GUARDAR_PRODUCTO_PFI;
        // (CODIGO_EXPEDIENTE,CODIGO_PAIS_PROCEDENCIA,CODIGO_PRODUCTO,CODIGO_APLICACION,CODIGO_ENVASE,CANTIDAD_ENVASE,CANTIDAD_PESO_PERMISO)

        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        pst = con.prepareCall(sql);

        pst.setString(1, codExp);
        if (proH.getPaisProcedencia() != null)
            pst.setString(2, proH.getPaisProcedencia());
        else
            pst.setString(2, null);
        pst.setString(3, proH.getCodigoProducto());
        pst.setString(4, proH.getUsoDestino());
        if (proH.getTipoEnvase() != null)
            pst.setString(5, proH.getTipoEnvase());
        else
            pst.setString(5, null);
        if (proH.getCantidad() != null)
            pst.setDouble(6, proH.getCantidad());
        else
            pst.setDouble(6, -1.0);
        if (proH.getCantidad() != null)
            pst.setDouble(7, proH.getPesoNeto());
        else
            pst.setDouble(7, -1);
        if (proH.getCodUniMed()!=null)
            pst.setString(8, proH.getCodUniMed());
        else
            pst.setString(8, null);

        Log(" = VOY A EJECUTAR GUARDAR_PRODUCTO_PFI = ");
        pst.execute();
        Log(" = LISTO QUERY DE GUARDAR_PRODUCTO_PFI = ");

    }


    private void guardarAnexosPFI(AnexoPFI anexo, String codExp,
                                  Connection con) throws SQLException {
        String sql = SenasaSQL.GUARDAR_ANEXOS_PFI;
        //(CCODEXP,CCODPRO,CCODENV, NCANENV, NCANPROD)
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        pst = con.prepareCall(sql);
        pst.setString(1, codExp);
        pst.setString(2, anexo.getCodigo());
        pst.setString(3, anexo.getTipoEnvase());
        pst.setDouble(4, anexo.getCantidad());
        pst.setDouble(5, anexo.getPesoNeto());
        pst.setString(6, anexo.getPaisProcedencia());
        Log(" = VOY A EJECUTAR GUARDAR_ANEXOS_PFI = ");
        pst.execute();
        Log(" = LISTO QUERY DE GUARDAR_ANEXOS_PFI = ");

    }

    private void ManejarException(Connection con, Exception e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("guardarPFI", f);
        }
        Log("guardarPFI", e);
    }

    private PermisoFitosanitarioImportacion obtenerPermisoFitosanitarioImportacion(String noCertificado,
                                                                                   Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_PFI_X_NoCERTIFICADO;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        PermisoFitosanitarioImportacion retval =
            new PermisoFitosanitarioImportacion();
        pst = con.prepareStatement(sql);
        pst.setString(1, noCertificado);
        Log(" = VOY A EJECUTAR SELECT EN OBTENER_PFI_X_NoCERTIFICADO = ");
        rs = pst.executeQuery();
        Log(" = VIENDO RS DE OBTENER_PFI_X_NoCERTIFICADO = ");
        while (rs.next()) {
            retval = obtPermisoFitosanitarioImportacion(rs);
            break;
        }
        return retval;
    }

    private PermisoFitosanitarioImportacion obtPermisoFitosanitarioImportacion(ResultSet rs) throws SQLException 
    {
        PermisoFitosanitarioImportacion retval =new PermisoFitosanitarioImportacion();
        retval.setNoFolio(rs.getString(1));
        retval.setNoCertificado(rs.getString(2));
        retval.setDireccionEjecutiva(rs.getString(3));
        retval.setUrlPFIDefinitivo(rs.getString(4));
        retval.setIndicadorAmpliacion(rs.getString(5)==null || rs.getString(5).equals("N")?false:true);
        retval.setFechaDeEmicion(Utility.parseDateToString(rs.getDate(6)));
        retval.setCodigoRequImpoProducto(rs.getString(7));
        retval.setPeriodoVegetativo(rs.getString(8));
        retval.setNumeroInspecciones(rs.getString(9));
        return retval;
    }

    private ArrayList<ProductoPFI> obtenerProductoPFIxCodExp(String codExp,
                                                             Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_PRODUCTOS_PFI;
        String sql2 = SenasaSQL.OBTENER_PRODUCTOS_PFIII;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<ProductoPFI> retval = new ArrayList<ProductoPFI>();
        pst = con.prepareStatement(sql);
        pst.setString(1, codExp);
        Log(" = VOY A EJECUTAR SELECT EN OBTENER_PRODUCTOS_PFI = ");
        rs = pst.executeQuery();
        
        if(rs.next()==false){
              Log(" = VOY A EJECUTAR SELECT EN OBTENER_PRODUCTOS_PFTI 009 = "+codExp);
              
              pst = con.prepareStatement(sql2);
              pst.setString(1, codExp);
              rs = pst.executeQuery();
                Log(" = VIENDO RS DE OBTENER_PRODUCTOS_PFI = "); 
                           while (rs.next()) {
                               retval.add(obtProductoPFI(rs));
                           }
                
              }else{
              pst = con.prepareStatement(sql);
              pst.setString(1, codExp);
              rs = pst.executeQuery();
              Log(" = VIENDO RS DE OBTENER_PRODUCTOS_PFI = "); 
                         while (rs.next()) {
                             retval.add(obtProductoPFI(rs));
                         }
            
            }
        
        
      
       
        return retval;
    }

    private ProductoPFI obtProductoPFI(ResultSet rs) throws SQLException {
        ProductoPFI pfi = new ProductoPFI();
        pfi.setCodigoProducto(rs.getString(1));
        pfi.setDescripcion(rs.getString(2));
        pfi.setPartidaArancelaria(rs.getString(3));
        pfi.setNombreCientifico(rs.getString(4));
        pfi.setPaisProcedencia(rs.getString(5));
        pfi.setUsoDestino(rs.getString(6));
        pfi.setTipoEnvase(rs.getString(7));
        
        pfi.setCantidadPlantas(rs.getString(8));
        pfi.setCantidad(Utility.TryParseDouble(rs.getString(9)));
        pfi.setPesoNeto(Utility.TryParseDouble(rs.getString(10)));
        logger.debug("contien anexos -- rs.getString(10):"+rs.getString(11));
        pfi.setContieneAnexos((Utility.TryParseInteger(rs.getString(11)) > 0) ?(true) : (false));
        pfi.setCodUniMed(rs.getString(12));
        pfi.setDescUniMed(rs.getString(13));
        pfi.setDesTipoEnvase(rs.getString(14));
        return pfi;
    }

    private ArrayList<AnexoPFI> obtAnexosPFI(String codExp,
                                             Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_ANEXOS_PFI;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<AnexoPFI> retval = new ArrayList<AnexoPFI>();
        pst = con.prepareStatement(sql);
        pst.setString(1, codExp);
        Log(" = VOY A EJECUTAR OBTENER_ANEXOS_PFI = ");
        rs = pst.executeQuery();
        Log(" = VIENDO OBTENER_ANEXOS_PFI = ");
        while (rs.next()) {
            retval.add(obtAnexoPFI(rs));
        }
        return retval;
    }

    private AnexoPFI obtAnexoPFI(ResultSet rs) throws SQLException{
        AnexoPFI retval = new AnexoPFI();
        retval.setCodigo(rs.getString(1));
        retval.setPartidaArancelaria(rs.getString(2));
        retval.setDescripcion(rs.getString(3));
        retval.setNombreCientifico(rs.getString(4));
        retval.setTipoEnvase(rs.getString(5));

        retval.setPesoNeto(Utility.TryParseDouble(rs.getString(6)));
        retval.setCantidad(Utility.TryParseDouble(rs.getString(7)));
        retval.setCodigoPadre(rs.getString(8));
        retval.setPartidaArancelariaPadre(rs.getString(9));
        retval.setNombreCientificoPadre(rs.getString(10));
        retval.setDescripcionPadre(rs.getString(11));
        retval.setPaisProcedencia(rs.getString(12));
        retval.setCodUniMed(rs.getString(13));//
        retval.setDesUniMed(rs.getString(14));
        retval.setDesTipoEnvase(rs.getString(15));
        retval.setCantidadPlantas(rs.getString(16));        
        
        return retval;   
    }

    private void guardarPuntoIngresoPFI(ProductoPFI proH,
                                        PuntoIngresoProductoPFI puntIn,
                                        String codExp,
                                        Connection con) throws SQLException {
        guardarPuntoIngreso(proH, puntIn, codExp, con);
    }

    private void guardarPuntoIngreso(ProductoPFI proH,
                                     PuntoIngresoProductoPFI puntIn,
                                     String codExp,
                                     Connection con) throws SQLException {
        String sql = SenasaSQL.GUARDAR_PUNTO_INGRESO;
        //(CODIGO_EXPEDIENTE,CODIGO_PRODUCTO,'0',CODIGO_ENVASE,CCODAPL,NCANENV,PESO,CCODSED)
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        pst = con.prepareCall(sql);
        pst.setString(1, codExp);
        pst.setString(2, proH.getCodigoProducto());
        pst.setString(3, "0");
        pst.setString(4, puntIn.getTipoEnvaseProducto());
        pst.setString(5, proH.getUsoDestino());
        pst.setDouble(6, puntIn.getCantidad());
        pst.setDouble(7, puntIn.getPesoNeto());
        pst.setString(8, puntIn.getPuntoIngresoProducto());
        pst.setString(9, proH.getCodUniMed());
        Log(" = VOY A EJECUTAR GUARDAR_PUNTO_INGRESO = ");
        Log(" = COD UNI MED = " + proH.getCodUniMed());
        pst.execute();
        Log(" = LISTO QUERY DE GUARDAR_PUNTO_INGRESO = ");
    }

    private void guadarPaisOrigen(String codExp, PaisOrigenProductoPFI paiPFI,
                                  Connection con) throws SQLException {
        String sql = SenasaSQL.GUARDAR_PAIS_ORIGEN;
        //(CCODEXP,CCODPAIORI,ES_ANEXO,CODIGO_ENVASE)
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        pst = con.prepareCall(sql);
        pst.setString(1, codExp);
        pst.setString(2, paiPFI.getPaisOrigenProducto());
        pst.setString(3, "0");
      
        logger.debug("paiPFI.getTipoEnvaseProducto():"+paiPFI.getTipoEnvaseProducto());
        
        pst.setString(4, paiPFI.getTipoEnvaseProducto());
        pst.setString(5, paiPFI.getCodigoProducto());
        Log(" = VOY A EJECUTAR GUARDAR_PAIS_ORIGEN = ");
        pst.execute();
        Log(" = LISTO QUERY DE GUARDAR_PAIS_ORIGEN = ");
    }

    private void guadarPaisOrigenPFI(String codExp,
                                     PaisOrigenProductoPFI paiPFI,
                                     Connection con) throws SQLException {
        guadarPaisOrigen(codExp, paiPFI, con);
    }

    private void guadarLugarProduccionPFI(String codExp,
                                          LugarProduccionProductoPFI lpfi,
                                          Connection con) throws SQLException {
        guadarLugarProduccion(codExp, lpfi, con);
    }

    private void guadarLugarProduccion(String codExp,
                                       LugarProduccionProductoPFI lpfi,
                                       Connection con) throws SQLException {
        String sql = SenasaSQL.GUARDAR_LUGARES_PRODUCCION;
        //CODIGO_EXPEDIENTE,CODIGO_LUGAR_PRO,CODIGO_PRODUCTO,ES_ANEXO)
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        pst = con.prepareCall(sql);
        pst.setString(1, codExp);
        pst.setString(2, lpfi.getLugarProduccionProducto());
        pst.setString(3, lpfi.getCodigoProducto());
        pst.setString(4, "0");
        pst.setString(5, lpfi.getTipoEnvaseProducto());
        Log(" = VOY A EJECUTAR GUARDAR_LUGARES_PRODUCCION = ");
        pst.execute();
        Log(" = LISTO QUERY DE GUARDAR_LUGARES_PRODUCCION = ");
    }

    private void guardarPuntosIngresosAnexoPFI(PermisoFitosanitarioImportacion pfi,
                                               Connection con,
                                               AnexoPFI anex) throws SQLException {

        for (PuntoIngresoAnexoPFI puntIn : pfi.getPuntoIngresoAnexoPFI()) {
            if (puntIn != null &&
                puntIn.getCodigoAnexo().compareTo(anex.getCodigo()) == 0) {
                guardarPuntoIngresoAnexoPFI(anex, puntIn,
                                            pfi.getNoCertificado(), con);
            }
        }


    }

    private void guardarPuntoIngresoAnexoPFI(AnexoPFI anex,
                                             PuntoIngresoAnexoPFI puntIn,
                                             String codExp,
                                             Connection con) throws SQLException {

        String sql = SenasaSQL.GUARDAR_PUNTO_INGRESO;
        //(CODIGO_EXPEDIENTE,CODIGO_PRODUCTO,ES_ANEXO,CODIGO_ENVASE,CCODAPL,NCANENV,PESO,CCODSED)
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        pst = con.prepareCall(sql);
        pst.setString(1, codExp);
        pst.setString(2, anex.getCodigo());
        pst.setString(3, "1");
        pst.setString(4, puntIn.getTipoEnvaseAnexo());
        pst.setString(5, anex.getUsoDestino());
        pst.setDouble(6, puntIn.getCantidad());
        pst.setDouble(7, puntIn.getPesoNeto());
        pst.setString(8, puntIn.getPuntoIngresoAnexo());
        Log(" = VOY A EJECUTAR GUARDAR_PUNTO_INGRESO ANEXO = ");
        pst.execute();
        Log(" = LISTO QUERY DE GUARDAR_PUNTO_INGRESO ANEXO = ");

    }

    private void guardarPaisOrigenAnexoPFI(PermisoFitosanitarioImportacion pfi,
                                           Connection con,
                                           AnexoPFI anex) throws SQLException {
        for (PaisOrigenAnexoPFI paiAnPFI : pfi.getPaisesOrigenAnexoPFI()) {
            if (paiAnPFI != null &&
                paiAnPFI.getCodigoAnexo().compareTo(anex.getCodigo()) == 0) {
                guadarPaisOrigenAnexoPFI(pfi.getNoCertificado(), paiAnPFI,
                                         con);
            }
        }
    }

    private void guadarPaisOrigenAnexoPFI(String codExp,
                                          PaisOrigenAnexoPFI paiAnPFI,
                                          Connection con) throws SQLException {
        String sql = SenasaSQL.GUARDAR_PAIS_ORIGEN;
        //(CCODEXP,CCODPAIORI,ES_ANEXO,CODIGO_ENVASE)
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        pst = con.prepareCall(sql);
        pst.setString(1, codExp);
        pst.setString(2, paiAnPFI.getPaisOrigenAnexo());
        pst.setString(3, "1");
        pst.setString(4, paiAnPFI.getTipoEnvaseAnexo());
        pst.setString(5, paiAnPFI.getCodigoAnexo());
        Log(" = VOY A EJECUTAR GUARDAR_PAIS_ORIGEN ANEXO = ");
        pst.execute();
        Log(" = LISTO QUERY DE GUARDAR_PAIS_ORIGEN ANEXO = ");


    }

    private void guardarLugaresProduccionAnexoPFI(PermisoFitosanitarioImportacion pfi,
                                                  Connection con,
                                                  AnexoPFI anex) throws SQLException {
        for (LugarProduccionAnexoPFI lugProAnPFI :
             pfi.getLugaresProduccionAnexoPFI()) {
            if (lugProAnPFI != null &&
                lugProAnPFI.getCodigoAnexo().compareTo(anex.getCodigo()) ==
                0) {
                guadarLugarProduccionAnexoPFI(pfi.getNoCertificado(),
                                              lugProAnPFI, con);
            }
        }
    }

    private void guadarLugarProduccionAnexoPFI(String codExp,
                                               LugarProduccionAnexoPFI lugProAnPFI,
                                               Connection con) throws SQLException {
        String sql = SenasaSQL.GUARDAR_LUGARES_PRODUCCION;
        //CODIGO_EXPEDIENTE,CODIGO_LUGAR_PRO,CODIGO_PRODUCTO,ES_ANEXO)
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        pst = con.prepareCall(sql);
        pst.setString(1, codExp);
        pst.setString(2, lugProAnPFI.getLugarProduccionAnexo());
        pst.setString(3, lugProAnPFI.getCodigoAnexo());
        pst.setString(4, "1");
        pst.setString(5, lugProAnPFI.getTipoEnvaseAnexo());
        Log(" = VOY A EJECUTAR GUARDAR_LUGARES_PRODUCCION ANEXO = ");
        pst.execute();
        Log(" = LISTO QUERY DE GUARDAR_LUGARES_PRODUCCION ANEXO = ");
    }


    private ArrayList<LugarProduccionProductoPFI> obtenerLugaresProduccionProductoPFI(HashMap<String, ProductoPFI> map,
                                                                                      String codExp,
                                                                                      Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_LUGARES_PRODUCCION_PFI_PRODUCTO;
        String sql2 = SenasaSQL.OBTENER_LUGARES_PRODUCCION_PFI_PRODUCTOII;  
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<LugarProduccionProductoPFI> retval =
            new ArrayList<LugarProduccionProductoPFI>();
        pst = con.prepareStatement(sql);
        pst.setString(1, codExp);
        //pst.setString(2, "N");
        Log(" = VOY A EJECUTAR OBTENER_LUGARES_PRODUCCION = ");
        rs = pst.executeQuery();
        
        if(rs.next()==false){
              
              pst = con.prepareStatement(sql2);
              pst.setString(1, codExp);
              rs = pst.executeQuery();
            while (rs.next()) {
              retval.add(obtLugarProduccionPFI(map, rs));
          }   
        }else{
              pst = con.prepareStatement(sql);
              pst.setString(1, codExp);
              rs = pst.executeQuery();
              while (rs.next()) {
                  retval.add(obtLugarProduccionPFI(map, rs));
              }   
            
            }
        
        Log(" = VIENDO OBTENER_LUGARES_PRODUCCION = ");
       
        return retval;
    }

    private LugarProduccionProductoPFI obtLugarProduccionPFI(HashMap<String, ProductoPFI> map,
                                                             ResultSet rs) throws SQLException {
        LugarProduccionProductoPFI lppfi = new LugarProduccionProductoPFI();
        lppfi.setCodigoProducto(rs.getString(1));
        lppfi.setTipoEnvaseProducto(rs.getString(2));
        lppfi.setLugarProduccionProducto(rs.getString(3));
        lppfi.setDescLugarProduccion(rs.getString(4));
        ProductoPFI pfi = map.get(lppfi.getCodigoProducto());
        lppfi.setPartidaArancelariaProducto(pfi.getPartidaArancelaria());
        lppfi.setDescripcionProducto(pfi.getDescripcion());
        lppfi.setNombreCientificoProducto(pfi.getNombreCientifico());
        return lppfi;
    }


    private ArrayList<PuntoIngresoProductoPFI> obtenerPuntoIngresosProductoPFI(HashMap<String, ProductoPFI> map,
                                                                               String codExp,
                                                                               Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_PUNTOS_INGRESO_PRODUCTO;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<PuntoIngresoProductoPFI> retval =
            new ArrayList<PuntoIngresoProductoPFI>();
        pst = con.prepareStatement(sql);
        pst.setString(1, codExp);
        //pst.setString(2, "N");
        Log(" = VOY A EJECUTAR OBTENER_PUNTOS_INGRESO = ");
        rs = pst.executeQuery();
        Log(" = VIENDO OBTENER_PUNTOS_INGRESO = ");
        while (rs.next()) {
            retval.add(obtPuntoIngresoPFI(map, rs));
        }
        return retval;
    }

    private PuntoIngresoProductoPFI obtPuntoIngresoPFI(HashMap<String, ProductoPFI> map,
                                                       ResultSet rs) throws SQLException {

        PuntoIngresoProductoPFI pinpfi = new PuntoIngresoProductoPFI();

        pinpfi.setCodigoProducto(rs.getString(1));
        pinpfi.setTipoEnvaseProducto(rs.getString(2));
        pinpfi.setCantidad(Utility.TryParseDouble(rs.getString(3)));
        pinpfi.setPesoNeto(Utility.TryParseDouble(rs.getString(4)));
        pinpfi.setPuntoIngresoProducto(rs.getString(5));
        ProductoPFI pfi = map.get(pinpfi.getCodigoProducto());

        pinpfi.setPartidaArancelariaProducto(pfi.getPartidaArancelaria());
        pinpfi.setDescripcionProducto(pfi.getDescripcion());
        pinpfi.setNombreCientificoProducto(pfi.getNombreCientifico());


        return pinpfi;
    }

    private ArrayList<PaisOrigenProductoPFI> obtenerPaisOrigenProductoPFI(HashMap<String, ProductoPFI> map,
                                                                          String noCertificado,
                                                                          Connection con) throws SQLException {
        Log(" = OBTENER_PAISES_ORIGEN INICIANDO =");
        String sql = SenasaSQL.OBTENER_PAISES_ORIGEN_PRODUCTO;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<PaisOrigenProductoPFI> retval =
            new ArrayList<PaisOrigenProductoPFI>();
        pst = con.prepareStatement(sql);
        pst.setString(1, noCertificado);
        //pst.setString(2, "N");
        Log(" = VOY A EJECUTAR OBTENER_PAISES_ORIGEN = ");
        rs = pst.executeQuery();
        Log(" = VIENDO OBTENER_PAISES_ORIGEN = ");
        while (rs.next()) {
            retval.add(obtPaisOrigenPFI(map, rs));
        }
        Log(" = OBTENER_PAISES_ORIGEN = retval.size():"+retval.size());
        return retval;
    }

    private PaisOrigenProductoPFI obtPaisOrigenPFI(HashMap<String, ProductoPFI> map,
                                                   ResultSet rs) throws SQLException {

        PaisOrigenProductoPFI paiOrPfi = new PaisOrigenProductoPFI();
        paiOrPfi.setPaisOrigenProducto(rs.getString(1));
        paiOrPfi.setTipoEnvaseProducto(rs.getString(2));
        paiOrPfi.setCodigoProducto(rs.getString(3));
        paiOrPfi.setCodigoLugarProduccion(rs.getString(5));
        paiOrPfi.setDescLugarProduccion(rs.getString(6));

        ProductoPFI pfi = map.get(paiOrPfi.getCodigoProducto());
        paiOrPfi.setPartidaArancelariaProducto(pfi.getPartidaArancelaria());
        paiOrPfi.setDescripcionProducto(pfi.getDescripcion());
        paiOrPfi.setNombreCientificoProducto(pfi.getNombreCientifico());
        return paiOrPfi;
    }

    private ArrayList<LugarProduccionAnexoPFI> obtenerLugaresProduccionAnexoPFI(HashMap<String, AnexoPFI> mapAnexos,
                                                                                String codExp,
                                                                                Connection con) throws SQLException {
        Log("==== OBTENER_LUGARES_PRODUCCION_PFI ANEXOS ====");
        String sql = SenasaSQL.OBTENER_LUGARES_PRODUCCION_PFI;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<LugarProduccionAnexoPFI> retval =
            new ArrayList<LugarProduccionAnexoPFI>();
        pst = con.prepareStatement(sql);
        pst.setString(1, codExp);
        pst.setString(2, "Y");
        Log(" = VOY A EJECUTAR OBTENER_PAISES_ORIGEN ANEXO = ");
        rs = pst.executeQuery();
        Log(" = VIENDO  OBTENER_PAISES_ORIGEN ANEXO = ");
        while (rs.next()) {
            retval.add(obtLugarProduccionAnexo(mapAnexos, rs));
        }
        return retval;
    }

    private LugarProduccionAnexoPFI obtLugarProduccionAnexo(HashMap<String, AnexoPFI> mapAnexos,
                                                            ResultSet rs) throws SQLException {
        LugarProduccionAnexoPFI lppfi = new LugarProduccionAnexoPFI();
        lppfi.setCodigoAnexo(rs.getString(1));
        lppfi.setTipoEnvaseAnexo(rs.getString(2));
        lppfi.setLugarProduccionAnexo(rs.getString(3));
        AnexoPFI pfi = mapAnexos.get(lppfi.getCodigoAnexo());
        lppfi.setPartidaArancelariaAnexo(pfi.getPartidaArancelaria());
        lppfi.setDescripcionAnexo(pfi.getDescripcion());
        lppfi.setNombreCientificoAnexo(pfi.getNombreCientifico());
        return lppfi;
    }

    private ArrayList<PuntoIngresoAnexoPFI> obtenerPuntoIngresosAnexo(HashMap<String, AnexoPFI> mapAnexos,
                                                                      String codExp,
                                                                      Connection con) throws SQLException {
        Log(" ===== OBTENER_PUNTOS_INGRESO ANEXOS=====");
        String sql = SenasaSQL.OBTENER_PUNTOS_INGRESO;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<PuntoIngresoAnexoPFI> retval =
            new ArrayList<PuntoIngresoAnexoPFI>();
        pst = con.prepareStatement(sql);
        pst.setString(1, codExp);
        pst.setString(2, "Y");
        Log(" = VOY A EJECUTAR OBTENER_PUNTOS_INGRESO ANEXO = ");
        rs = pst.executeQuery();
        Log(" = VIENDO  OBTENER_PUNTOS_INGRESO ANEXO = ");
        while (rs.next()) {
            retval.add(obtPuntoIngresoAnexo(mapAnexos, rs));
        }
        return retval;
    }

    private PuntoIngresoAnexoPFI obtPuntoIngresoAnexo(HashMap<String, AnexoPFI> mapAnexos,
                                                      ResultSet rs) throws SQLException {
        Log(" ===== obtPuntoIngresoAnexo =====");
        PuntoIngresoAnexoPFI pinpfi = new PuntoIngresoAnexoPFI();
        
        Log("pinpfi.setCodigoAnexo(rs.getString(1))="+rs.getString(1));
        pinpfi.setCodigoAnexo(rs.getString(1));
        Log("pinpfi.setTipoEnvaseAnexo(rs.getString(2))="+rs.getString(2));
        pinpfi.setTipoEnvaseAnexo(rs.getString(2));
        Log("pinpfi.setCantidad(Utility.TryParseDouble(rs.getString(3)))="+rs.getString(3));
        pinpfi.setCantidad(Utility.TryParseDouble(rs.getString(3)));
        Log("pinpfi.setPesoNeto(Utility.TryParseDouble(rs.getString(4)))="+rs.getString(4));
        pinpfi.setPesoNeto(Utility.TryParseDouble(rs.getString(4)));
        Log(" pinpfi.setPuntoIngresoAnexo(rs.getString(5))="+rs.getString(5));
        pinpfi.setPuntoIngresoAnexo(rs.getString(5));
        
        Log("AnexoPFI pfi = mapAnexos.get(pinpfi.getCodigoAnexo())="+pinpfi.getCodigoAnexo());
        AnexoPFI pfi = mapAnexos.get(pinpfi.getCodigoAnexo());
        if (pfi!=null){
          Log("pinpfi.setPartidaArancelariaAnexo(pfi.getPartidaArancelaria())");
          pinpfi.setPartidaArancelariaAnexo(pfi.getPartidaArancelaria());
          Log("pinpfi.setDescripcionAnexo(pfi.getDescripcion())");
          pinpfi.setDescripcionAnexo(pfi.getDescripcion());
          Log("pinpfi.setNombreCientificoAnexo(pfi.getNombreCientifico())");
          pinpfi.setNombreCientificoAnexo(pfi.getNombreCientifico());
        }else{
            Log("pfi== null");
          }
        
        return pinpfi;
    }

    private ArrayList<PaisOrigenAnexoPFI> obtenerPaisOrigenAnexo(HashMap<String, AnexoPFI> mapAnexos,
                                                                 String codExp,
                                                                 Connection con) throws SQLException {
        Log(" ===== OBTENER_PAISES_ORIGEN ANEXOS =====");
        String sql = SenasaSQL.OBTENER_PAISES_ORIGEN;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<PaisOrigenAnexoPFI> retval =
            new ArrayList<PaisOrigenAnexoPFI>();
        pst = con.prepareStatement(sql);
        pst.setString(1, codExp);
        pst.setString(2, "Y");
        Log(" = VOY A EJECUTAR OBTENER_PAISES_ORIGEN ANEXO = ");
        rs = pst.executeQuery();
        Log(" = VIENDO  OBTENER_PAISES_ORIGEN ANEXO = ");
        while (rs.next()) {
            retval.add(obtPaisOrigenAnexo(mapAnexos, rs));
        }
        return retval;
    }

    private PaisOrigenAnexoPFI obtPaisOrigenAnexo(HashMap<String, AnexoPFI> mapAnexos,
                                                  ResultSet rs) throws SQLException {
        PaisOrigenAnexoPFI paiOrPfi = new PaisOrigenAnexoPFI();
        paiOrPfi.setPaisOrigenAnexo(rs.getString(1));
        paiOrPfi.setTipoEnvaseAnexo(rs.getString(2));
        paiOrPfi.setCodigoAnexo(rs.getString(3));

        AnexoPFI pfi = mapAnexos.get(paiOrPfi.getCodigoAnexo());
        paiOrPfi.setPartidaArancelariaAnexo(pfi.getPartidaArancelaria());
        paiOrPfi.setDescripcionAnexo(pfi.getDescripcion());
        paiOrPfi.setNombreCientificoAnexo(pfi.getNombreCientifico());
        return paiOrPfi;
    }

    private boolean ExisteNumerosCertificados(String noCertificado) {
        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoFitosanitarioImportacion();//PCSM 05/01/2017 
        Connection con = null; //PCSM 06/01/2017
        boolean retval = false;
        try {
            con = helper.getConnection();  //PCSM 06/01/2017
            PreparedStatement pst = con.prepareCall(SenasaSQL.BUSCAR_PFI);
            Log(" = INICIO BUSCAR_PFI= ");
            Log(SenasaSQL.BUSCAR_PFI);
            pst.setString(1, noCertificado);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) >= 1)
                    retval = true;
                else
                    retval = false;
                break;
            }
            Log(" = FIN BUSCAR_PFI= ");
        } catch (SQLException e) {
            ManejarException(con, e);
        } catch (Exception e) {
            ManejarException(con, e);
        } finally {
            //cleanup(con, null);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, null,null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (retval)
            Log("CONSEGUI !!");
        else
            Log("============== NO CONSEGUI !!");
        return retval;
    }

    private boolean DeleteAll(String noExp,
                              Connection con) throws SQLException {


        boolean retval = false;
        Log(" = INICIO = ");

        Log(" = ELIMINAR_PUNTO_INGRESO = " +
            ExecuteQuery(noExp, SenasaSQL.ELIMINAR_PUNTO_INGRESO, con));

        Log(" = ELIMINAR_PAISES_ORIGEN = " +
            ExecuteQuery(noExp, SenasaSQL.ELIMINAR_PAISES_ORIGEN, con));

        Log(" = ELIMINAR_LUGAR_PRODUCCION = " +
            ExecuteQuery(noExp, SenasaSQL.ELIMINAR_LUGAR_PRODUCCION, con));

        Log(" = ELIMINAR_ANEXOS = " +
            ExecuteQuery(noExp, SenasaSQL.ELIMINAR_ANEXOS, con));

        Log(" = ELIMINAR_PRODUCTOS_PFI = " +
            ExecuteQuery(noExp, SenasaSQL.ELIMINAR_PRODUCTOS_PFI, con));

        Log(" = ELIMINAR_EXPEDIENTE_PFI = " +
            ExecuteQuery(noExp, SenasaSQL.ELIMINAR_EXPEDIENTE_PFI, con));

        Log(" = LISTO ELIMINAR = ");

        return true;
    }

    private int ExecuteQuery(String noExp, String sql,
                             Connection con) throws SQLException {
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, noExp);
        return pst.executeUpdate();
    }


    public static void main(String[] args) {
        PermisoFitoSanitarioImportacionDAO pfi = new PermisoFitoSanitarioImportacionDAO();
        
        //PermisoFitosanitarioImportacion objPFI = pfi.obtenerPFIxNoCertificado("110800635");
        pfi.obtenerRequisitosSanitariosImpoFito("04563", "20", "4008", "40082", "");
       
        
    }  
    
    public ArrayList<RequisitoDao> obtenerRequisitosSanitariosImpoFitoTran(String codigoProductos,String codigoPaisesOrigen,
                                                                           String codLugarProd, String codPaisProcd,
                                                                           String codPaisDest){
     logger.debug(" = INICIO PROCESO DE obtenerRequisitosSanitariosImpoFitoTran = ");   
    
      String sql = SenasaSQL.OBTENER_REQUISITOS_IMPO_FITO_TRAN;     
      Connection con = null;
      CallableStatement cs = null;
      ResultSet rs = null;
      ArrayList<RequisitoDao> retval = new ArrayList<RequisitoDao>();
      
      try {
          //con=cnApp.getConnection();
         // con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
         con = helper.getConnection();  //PCSM 06/01/2017
          logger.debug("codigoProducto:"+codigoProductos);
          logger.debug("paisesOrigen:"+codigoPaisesOrigen);
          logger.debug("lugaresProduccion:"+codLugarProd);
          logger.debug("paisProcedencia:"+codPaisProcd);
          logger.debug("codigoPaisDest:"+codPaisDest);
          
          if(codLugarProd.equals(null) || codLugarProd.trim()=="" || codLugarProd.equals("null")){
            codLugarProd = "00";
          }
          
          cs = con.prepareCall(sql);
          cs.setString(1, codigoProductos);
          cs.setString(2, codigoPaisesOrigen);
          cs.setString(3, codLugarProd);
          cs.setString(4, codPaisProcd);
          cs.setString(5, codPaisDest==null?"":codPaisDest);

          cs.registerOutParameter(6, Types.INTEGER);   
          cs.registerOutParameter(7,OracleTypes.ARRAY,RequisitoDao.SQL_TYPE_ARRAY);
          cs.registerOutParameter(8,OracleTypes.VARCHAR);
             
          logger.debug(" = ANTES DE EJECUTAR = ");  
          cs.execute();
          
          Array requisitos = cs.getArray(7);
          String _msg = cs.getString(8);
          logger.debug("Mensaje de retorno Pckg_Requisitos.Pr_Requisito_Transito: " + _msg);
          logger.debug("Verificando el array de Requisitos...");
          
          if (requisitos == null){
              logger.debug(" = NO HAY REQUISITOS = ");
              return new ArrayList<RequisitoDao>();
          }
          
          logger.debug("Entrando a recorrer los datos del array Requisitos");
        
          rs = requisitos.getResultSet();
          int i=1;
        while (rs.next()) {               
            STRUCT rowStruct = (STRUCT) rs.getObject(2); 
            Object[] cols = rowStruct.getAttributes(); 
            //logger.debug(" = cols.length = "+cols.length);
            RequisitoDao requisito = new RequisitoDao();
            //logger.debug(" = cols[0].toString() = "+cols[0]);
            requisito.setOrden(cols[0] == null ? null:cols[0].toString());
            //logger.debug(" = cols[1].toString() = "+cols[1]);
            requisito.setEtiqueta(cols[1] == null ? null:cols[1].toString());
            //logger.debug(" = cols[2].toString() = "+cols[2]);
            requisito.setSangria(cols[2] == (null) ? null:cols[2].toString());
            //logger.debug(" = cols[3].toString() = "+cols[3]);
            requisito.setClase(cols[3] == (null) ? null:cols[3].toString());
            //logger.debug(" = cols[4].toString() = "+cols[4]);
            requisito.setDescripcionRequisito(cols[4] == (null) ? null:cols[4].toString());
            //logger.debug(" = cols[5].toString() = "+cols[5]);
            requisito.setCodigoRequisito(cols[5] == (null) ? null:cols[5].toString());
            retval.add(requisito);
            logger.debug("Adicionando el registro '" + i + "' del array de Requisitos al retval.");
            i++;
        }             
          
      } catch (Exception e) {
          Log("obtenerRequisitosSanitariosImpoFitoTran Error: ", e);
      } finally {
            //cleanup(con, cs);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, cs,null);
            } catch (Exception e) {
                e.printStackTrace();
            }
      }
      return retval; 
    }
    
    public ArrayList<RequisitoDao> obtenerRequisitosSanitariosImpoFito(String codigoProducto,
                                                                          String codigoAplicacion,
                                                                          String paisProcedencia,
                                                                          String paisesOrigen, String lugaresProduccion) {
        
       logger.debug(" = INICIO PROCESO DE obtenerRequisitosSanitariosImpoFito = ");
        
        //String sql =  " { call Pckg_Requisitos.Pr_Requisito_Impo(?,?,?,?,?,?,?) }";
        //String sql =  " { call Pckg_Requisitos.Pr_Requisito_Impo(?,?,?,?,?,?,?,?) }";
        String sql =  " { call Pckg_Requisitos.pr_requisitos_importacion(?,?,?,?,?,?,?,?) }";
      
        Connection con = null;
        //Connection con = ConnectionSenasa.getConnectionSimple();
        PreparedStatement pst = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ArrayList<RequisitoDao> retval = new ArrayList<RequisitoDao>();
        
        try {
            //con=cnApp.getConnection();
            //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            logger.debug("codigoProducto:"+codigoProducto);
            logger.debug("paisesOrigen:"+paisesOrigen);
            logger.debug("lugaresProduccion:"+lugaresProduccion);
            logger.debug("paisProcedencia:"+paisProcedencia);
            logger.debug("codigoAplicacion:"+codigoAplicacion);
            
            if(lugaresProduccion.equals(null) || lugaresProduccion.trim()=="" || lugaresProduccion.equals("null"))
            {
              lugaresProduccion = "00";
            }
            
            cs = con.prepareCall(sql);
            cs.setString(1, codigoProducto);
            cs.setString(2, paisesOrigen);
            cs.setString(3, lugaresProduccion);
            cs.setString(4, paisProcedencia);
            cs.setString(5, codigoAplicacion);

            cs.registerOutParameter(6, Types.INTEGER);
            
            //ArrayDescriptor arraydesc = ArrayDescriptor.createDescriptor(RequisitoDao.SQL_TYPE_ARRAY, con);

            
            //cs.registerOutParameter(7,OracleTypes.ARRAY,RequisitoDao.SQL_TYPE_ARRAY);
            cs.registerOutParameter(7,OracleTypes.CURSOR,"SYS_REFCURSOR"); 
            cs.registerOutParameter(8,OracleTypes.VARCHAR);
          
            
            logger.debug(" = ANTES DE EJECUTAR = ");
            
            cs.execute();
            
            ResultSet rs2 = (ResultSet)cs.getObject(7);
            //  Array requisitos = cs.getArray(7);
            String _msg = cs.getString(8);
            logger.debug("Mensaje de retorno Pckg_Requisitos.Pr_Requisito_Impo: " + _msg);
            logger.debug("Verificando el array de Requisitos...");
            
          
            //if (requisitos == null){
            //    logger.debug(" = NO HAY REQUISITOS = ");
            //    return new ArrayList<RequisitoDao>();
            //}
            
            logger.debug("Entrando a recorrer los datos del array Requisitos");
          
            //ResultSet rs2 = requisitos.getResultSet();
            int i=1;
          while (rs2.next()) {               
              /////STRUCT rowStruct = (STRUCT) rs2.getObject(2); 
              ////Object[] cols = rowStruct.getAttributes(); 
              //logger.debug(" = cols.length = "+cols.length);
              RequisitoDao requisito = new RequisitoDao();
              //logger.debug(" = cols[0].toString() = "+cols[0]);
              
              /////requisito.setOrden(cols[0] == null ? null:cols[0].toString());
              requisito.setOrden(rs2.getString(1));
              //logger.debug(" = cols[1].toString() = "+cols[1]);
              /////requisito.setEtiqueta(cols[1] == null ? null:cols[1].toString());
              requisito.setEtiqueta(rs2.getString(2));
              //logger.debug(" = cols[2].toString() = "+cols[2]);
              /////requisito.setSangria(cols[2] == (null) ? null:cols[2].toString());
              requisito.setSangria(rs2.getString(3));
              //logger.debug(" = cols[3].toString() = "+cols[3]);
              /////requisito.setClase(cols[3] == (null) ? null:cols[3].toString());
              requisito.setClase(rs2.getString(4));
              //logger.debug(" = cols[4].toString() = "+cols[4]);
              //////requisito.setDescripcionRequisito(cols[4] == (null) ? null:cols[4].toString());
              requisito.setDescripcionRequisito(rs2.getString(5));
              //logger.debug(" = cols[5].toString() = "+cols[5]);
              //////requisito.setCodigoRequisito(cols[5] == (null) ? null:cols[5].toString());
              requisito.setCodigoRequisito(rs2.getString(6));
              retval.add(requisito);
              logger.debug("Adicionando el registro '" + i + "' del array de Requisitos al retval.");
              i++;
          }             
            
          if (retval.size() == 0){
              logger.debug(" = NO HAY REQUISITOS = ");
              return new ArrayList<RequisitoDao>();
          }
            
        } catch (Exception e) {
            Log("obtenerRequisitosSanitariosImpoFito", e);
        } finally {
           // cleanup(con, cs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    public ArrayList<RequisitoDao> obtenerRequisitosSanitariosImpoFito(String codigoProducto,
                                                                       String codigoAplicacion,
                                                                       String paisProcedencia,
                                                                       String paisLugar) {
        return null;
    }
    
  public ArrayList<RequisitoDao> obtenerRequisitosSanitariosImpoFito(String numeroCertificado) {
    
    PermisoFitoSanitarioImportacionDAO pfi = new PermisoFitoSanitarioImportacionDAO();
    ArrayList<RequisitoDao> arrRequisitos = null;
    
    logger.debug("Entrando a obtenerRequisitosSanitariosImpoFito('" + numeroCertificado + "')");
    try {
              
              PermisoFitosanitarioImportacion objPFI = pfi.obtenerPFIxNoCertificado(numeroCertificado);
              logger.debug("Termino de ejecutar el metodo obtenerPFIxNoCertificado('"+ numeroCertificado + "')");
              ArrayList<ProductoPFI> productoPFI;
              ArrayList<PaisOrigenProductoPFI> paisOrigenProductoPFI;
              ArrayList<LugarProduccionProductoPFI> lugarProduccionProductoPFI;
              
              productoPFI = objPFI.getProductosPFI();
              
              if(!productoPFI.equals(null) && productoPFI.size()>0)
              {
                    String codigoProducto;
                    String codigoAplicacion;
                    String paisProcedencia;
                    String paisOrigen = "0000";
                    String lugarProduccion = "00";
                    
                    logger.debug("Obteniento el codigoProducto, codigoAplicacion y paisProcedencia.");
                    codigoProducto = productoPFI.get(0).getCodigoProducto();
                    codigoAplicacion = productoPFI.get(0).getUsoDestino();
                    paisProcedencia = productoPFI.get(0).getPaisProcedencia();
                    
                    paisOrigenProductoPFI = objPFI.getPaisesOrigenProductoPFI();
                    lugarProduccionProductoPFI = objPFI.getLugaresProduccionProductoPFI();
                    logger.debug("Obteniento el Pais de Origen");
                    if(!paisOrigenProductoPFI.equals(null) && paisOrigenProductoPFI.size()>0) {
                      int i;
                      for(i=0;i<paisOrigenProductoPFI.size();i++) {
                          if(paisOrigenProductoPFI.get(i).getCodigoProducto().equals(codigoProducto)) {
                            paisOrigen = paisOrigenProductoPFI.get(i).getPaisOrigenProducto();
                          }
                      }
                      
                    }
                logger.debug("Obteniento el Lugar de Produccion");
                  if(!lugarProduccionProductoPFI.equals(null) && lugarProduccionProductoPFI.size()>0) {
                    int i;
                    for(i=0;i<lugarProduccionProductoPFI.size();i++) {
                        if(lugarProduccionProductoPFI.get(i).getCodigoProducto().equals(codigoProducto)) {
                          lugarProduccion = lugarProduccionProductoPFI.get(i).getLugarProduccionProducto();
                        }
                    }
                    
                  }
                     //ArrayList<RequisitoDao> requisitos = pfi.obtenerRequisitosSanitariosImpoFito("00321", "20", "4016","4016", "00");
                     logger.debug("Ejecutando obtenerRequisitosSanitariosImpoFito");
                    arrRequisitos = pfi.obtenerRequisitosSanitariosImpoFito(codigoProducto, codigoAplicacion, paisProcedencia,paisOrigen, lugarProduccion);
              }
              else {
                arrRequisitos=null;
              }
          
        
    } catch (Exception e) {
        Log("obtenerRequisitosSanitariosImpoFito(String numeroCertificado)", e);
        logger.fatal(e);
    } finally {
        //Datacleanup(con, cs);
    }
      logger.debug("Fin de obtenerRequisitosSanitariosImpoFito('" + numeroCertificado + "')");
      return arrRequisitos;
  }


    public Ampliacion ampliarCertificadoImpoFito(String noCertificado,String tipo, int cantidad){
      Ampliacion amp= new Ampliacion();       
      //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
      //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoFitosanitarioImportacion();//PCSM 05/01/2017 
      Connection con = null; //PCSM 06/01/2017
      PreparedStatement pst = null;
      CallableStatement cs = null;
      
      logger.debug("noCertificado:"+noCertificado);
      logger.debug("tipo:"+tipo);
      logger.debug("cantidad:"+cantidad);
      
      try{
        con = helper.getConnection();  //PCSM 06/01/2017
         PermisoFitosanitarioImportacion pfi =  obtenerPermisoFitosanitarioImportacion(noCertificado, con);
          
         // el pfi no existe 
          if(pfi==null){ 
              amp.setMensaje("No se encontro el Permiso "+noCertificado);
              amp.setAmpliado(false);
              return amp;
          }
        
        // el certificado ya esta ampliado
         if(pfi.isIndicadorAmpliacion()==true){
           logger.debug("isIndicadorAmpliacion esta activado");
           amp.setMensaje("El Permiso "+noCertificado+" ya esta ampliado");
           amp.setAmpliado(true);
           return amp;
         }
          
        // el pfi no tiene fecha de emision 
        if(pfi.getFechaDeEmicion()==null || pfi.getFechaDeEmicion().equals("")){
          logger.debug("getFechaDeEmision esta en null");
          amp.setMensaje("El Permiso "+noCertificado+" posee fecha de emision en null");
          amp.setAmpliado(false);
          return amp;
        }    
        Log(" ============== AMPLIACION PFI ===============");
        String sql =  " { call Pckg_CALCULO_DIAS.Calcular_DIAS(?,?,?,?) } ";
          
        cs = con.prepareCall(sql);
        
        cs.setDate(1,Utility.parseStringToDate(pfi.getFechaDeEmicion()));
        cs.setString(2,tipo);
        cs.setInt(3,cantidad);
          
        cs.registerOutParameter(4,OracleTypes.DATE);
          
        logger.debug(" = ANTES DE EJECUTAR = ");
        
        cs.execute();
          
        Date fechaAmpliacion =  Utility.toUtilDate(cs.getDate(4));
          
        logger.debug("fechaAmpliacion:"+fechaAmpliacion);
          
        Date fechaActual = new Date(System.currentTimeMillis()); 
          
        logger.debug("fechaActual:"+fechaActual);
          
        if(fechaActual.compareTo(fechaAmpliacion)>0){
          // long dias=fechaActual.getTime()-fechaAmpliacion.getTime();   
          long diferencia = fechaActual.getTime() - fechaAmpliacion.getTime();        
          int dias = (int)(Math.floor(diferencia / (1000 * 60 * 60 * 24)));
          amp.setMensaje("El Permiso "+noCertificado+" con fecha de emision "+Utility.parseStringToDate(pfi.getFechaDeEmicion())
                         +" se encuentra fuera de fecha, con "+dias+" dia(s) de vencimiento");
          amp.setAmpliado(false);
          
          return amp;
        }
        Log("EJECUTANDO EL QUERY :"+SenasaSQL.AMPLIAR_PFI);
        sql = SenasaSQL.AMPLIAR_PFI;    
        pst = con.prepareStatement(sql);
        pst.setString(1, noCertificado);
        pst.executeUpdate();
      
        logger.debug("Se realizo la ampliacion del noCertificado: "+noCertificado);
          
        amp.setAmpliado(true);
        amp.setMensaje("Se realizo la ampliacion del noCertificado: "+noCertificado);
          
      }catch(Exception e){
      
        logger.fatal("ampliarCertificadoImpoZoo",e);
      
      }finally {
            //cleanup(con, cs);
            //cleanup(con, pst);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, cs, null);
                helper.cleanup(con, pst, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
      }
      return amp;
    }
    
    //Metodos actualizados para grabar todos los datos referentes a un expediente PFI:
    
    private String registrarPermisoPFI(String codigoPermiso, String rucDni, 
                                      String codExpediente, String codigoCentroTramite,
                                      String fechaEmision, String fechaEntrega,
                                      String indAmpliacion, String codigoReqImpoProd,String dniRepresentante,
                                      String urlPfi, String userName){
        
            String retval = "0";
            String _idPersona = obtenerIdPersona(rucDni.trim());
            if((_idPersona.isEmpty()) || (_idPersona=="")) {
                  logger.fatal("NO SE ENCONTRO EL IDENTIFICADOR DE PERSONA PARA EL SOLICITANTE: " + rucDni);
                  return retval;
            }
            String idRepresentante ="";
            if (dniRepresentante!=null && dniRepresentante!=""){
              idRepresentante = obtenerIdPersona(dniRepresentante.trim());
            }else{
              idRepresentante=null;
            }  
            
        
            String sql = SenasaSQL.REGISTRAR_PERMISO_PFI;
      
            Log(" AQUI VA EL " + sql);

            Connection con = null;
            PreparedStatement pst = null;
            CallableStatement cs = null;
      
            try {
              //con=cnApp.getConnection();
              //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
              con = helper.getConnection();  //PCSM 06/01/2017
              cs = con.prepareCall(sql);
                
              cs.setString(1,codigoPermiso);
              cs.registerOutParameter(1, Types.VARCHAR);  
              cs.setString(2,_idPersona);
              cs.setString(3,codExpediente);
              cs.setString(4,codigoCentroTramite);
              cs.setDate(5,Utility.parseStringToDate(fechaEmision));
              cs.setDate(6,Utility.parseStringToDate(fechaEmision));
              cs.setString(7,indAmpliacion);
              cs.setString(8,codigoReqImpoProd);
              cs.setString(9,idRepresentante);
              cs.setString(10,urlPfi);
              cs.setString(11,userName);
              
              Log(" = ANTES DE EJECUTAR = ");
              cs.execute();

              retval = cs.getString(1);
                
              logger.debug("numeroPermiso(retval): " + retval);

                Log(" = FIN TODITO = ");
            } catch (SQLException e) {
                Log("registrarPermisoPFI", e);
                retval = e.getMessage();
            } catch (Exception e) {
                Log("registrarPermisoPFI", e);
                retval = e.getMessage();
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
    
  private String registrarProductoPFI(String codigoPermiso, 
                                    String codigoProducto, String codigoTipoEnvase,
                                    String codUnidadMedida, Double cantidadPeso,
                                    String codigoAmpliacion, Double cantidadEnvase,
                                    Double cantidadPlantas, String paisProcedencia,
                                    String userName){
      
          String retval = "0";

          String sql = SenasaSQL.REGISTRAR_PRODUCTO_PFI;
    
          Log(" AQUI VA EL " + sql);

          Connection con = null;
          PreparedStatement pst = null;
          CallableStatement cs = null;
          
          try {
            //con=cnApp.getConnection();  
            //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            cs = con.prepareCall(sql);
              
            cs.setString(1,codigoPermiso);
            logger.debug("codigoPermiso: " + codigoPermiso);  
            cs.setString(2,codigoProducto);
            logger.debug("codigoProducto: " + codigoProducto);  
            cs.setString(3,codigoTipoEnvase);
            logger.debug("codigoTipoEnvase: " + codigoTipoEnvase);  
            cs.setString(4,codUnidadMedida);
            logger.debug("codUnidadMedida: " + codUnidadMedida);  
            cs.setDouble(5,cantidadPeso);
            logger.debug("cantidadPeso: " + cantidadPeso);  
            cs.setString(6,codigoAmpliacion);
            logger.debug("codigoAmpliacion: " + codigoAmpliacion);  
            cs.setDouble(7,cantidadEnvase);
            logger.debug("cantidadEnvase: " + cantidadEnvase);  
            cs.setDouble(8,cantidadPlantas);
            logger.debug("cantidadPlantas: " + cantidadPlantas);  
            cs.setString(9,paisProcedencia);
            logger.debug("paisProcedencia: " + paisProcedencia);  
            cs.setString(10,userName);
            logger.debug("userName: " + userName);  
            
              Log(" = ANTES DE EJECUTAR = ");
              cs.execute();

              Log(" = YA EJECUTE = ");
            

              Log(" = FIN TODITO = ");
          } catch (SQLException e) {
              Log("registrarProductoPFI", e);
              retval = e.getMessage();
          } catch (Exception e) {
              Log("registrarProductoPFI", e);
              retval = e.getMessage();
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
  
  private String registrarPtoIngresoPFI(String codigoPermiso,  
                                    String codigoProducto, String codigoTipoEnvase,
                                    String codUnidadMedida, Double cantidadPeso,
                                    String codigoAmpliacion, Double cantidadEnvase,
                                    Double cantidadPlantas, String codigoCentroTramite,
                                    String indicadorAnexo, String userName){
      
          String retval = "0";

          String sql = SenasaSQL.REGISTRAR_PTO_INGRESO_PFI;
    
          Log(" AQUI VA EL " + sql);

          Connection con = null;
          PreparedStatement pst = null;
          CallableStatement cs = null;
          
          try {
            //con=cnApp.getConnection();  
            //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            cs = con.prepareCall(sql);
              
            cs.setString(1,codigoPermiso);
            logger.debug("codigoPermiso: " + codigoPermiso);    
            cs.setString(2,codigoProducto);
            logger.debug("codigoProducto: " + codigoProducto);    
            cs.setString(3,codigoTipoEnvase);
            logger.debug("codigoTipoEnvase: " + codigoTipoEnvase);    
            cs.setString(4,codUnidadMedida);
            logger.debug("codUnidadMedida: " + codUnidadMedida);    
            cs.setDouble(5,cantidadPeso);
            logger.debug("cantidadPeso: " + cantidadPeso);    
            cs.setString(6,codigoAmpliacion);
            logger.debug("codigoAmpliacion: " + codigoAmpliacion);    
            cs.setDouble(7,cantidadEnvase);
            logger.debug("cantidadEnvase: " + cantidadEnvase);    
            cs.setDouble(8,cantidadPlantas);
            logger.debug("cantidadPlantas: " + cantidadPlantas);    
            cs.setString(9,codigoCentroTramite);
            logger.debug("codigoCentroTramite: " + codigoCentroTramite);    
            cs.setString(10,indicadorAnexo);
            logger.debug("indicadorAnexo: " + indicadorAnexo);    
            cs.setString(11,userName);
            logger.debug("userName: " + userName);    
             
              Log(" = ANTES DE EJECUTAR = ");
              cs.execute();

              Log(" = FIN TODITO = ");
          } catch (SQLException e) {
              Log("registrarPtoIngresoPFI", e);
            retval = e.getMessage();
          } catch (Exception e) {
              Log("registrarPtoIngresoPFI", e);
            retval = e.getMessage();
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
  
  private String registrarPaisOrigenPFI(String codigoPermiso, String codigoPaisOrigen, 
                                    String indicadorAnexo, String codigoTipoEnvase,
                                    String codigoProducto, String userName){
      
          String retval = "0";

          String sql = SenasaSQL.REGISTRAR_PAIS_ORIGEN_PFI;
    
          Log(" AQUI VA EL " + sql);

          Connection con = null;
          PreparedStatement pst = null;
          CallableStatement cs = null;
          
          try {
              //con=cnApp.getConnection(); 
              //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
              con = helper.getConnection();  //PCSM 06/01/2017
              cs = con.prepareCall(sql);
                
              cs.setString(1,codigoPermiso);
              logger.debug("codigoPermiso: " + codigoPermiso);
              cs.setString(2,codigoPaisOrigen);
              logger.debug("codigoPaisOrigen: " + codigoPaisOrigen);
              cs.setString(3,indicadorAnexo);
              logger.debug("indicadorAnexo: " + indicadorAnexo);
              cs.setString(4,codigoTipoEnvase);
              logger.debug("codigoTipoEnvase: " + codigoTipoEnvase);
              cs.setString(5,codigoProducto);
              logger.debug("codigoProducto: " + codigoProducto);
              cs.setString(6,userName);
              logger.debug("userName: " + userName);
             
              Log(" = ANTES DE EJECUTAR = ");
              cs.execute();

              Log(" = YA EJECUTE = ");
             

              Log(" = FIN TODITO = ");
          } catch (SQLException e) {
              Log("registrarPaisOrigenPFI", e);
            retval = e.getMessage();
          } catch (Exception e) {
              Log("registrarPaisOrigenPFI", e);
            retval = e.getMessage();
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
  
  private String registrarLugarProduccionPFI(String codigoPermiso, String codigoProducto, 
                                    String codigoLugarProduccion, String indicadorAnexo,
                                    String codigoTipoEnvase, String userName){
      
          String retval = "0";

          String sql = SenasaSQL.REGISTRAR_LUGAR_PRODUCCION_PFI;
    
          Log(" AQUI VA EL " + sql);

          Connection con = null;
          PreparedStatement pst = null;
          CallableStatement cs = null;
          
          try {
              //con=cnApp.getConnection(); 
              //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
              con = helper.getConnection();  //PCSM 06/01/2017
              cs = con.prepareCall(sql);
                
              cs.setString(1,codigoPermiso);
              logger.debug("codigoPermiso: " + codigoPermiso);
              cs.setString(2,codigoProducto);
              logger.debug("codigoProducto: " + codigoProducto);
              cs.setString(3,codigoLugarProduccion);
              logger.debug("codigoLugarProduccion: " + codigoLugarProduccion);
              cs.setString(4,indicadorAnexo);
              logger.debug("indicadorAnexo: " + indicadorAnexo);
              cs.setString(5,codigoTipoEnvase);
              logger.debug("codigoTipoEnvase: " + codigoTipoEnvase);
              cs.setString(6,userName);
              logger.debug("userName: " + userName);
             
              Log(" = ANTES DE EJECUTAR = ");
              cs.execute();

              Log(" = YA EJECUTE = ");
             

              Log(" = FIN TODITO = ");
          } catch (SQLException e) {
              Log("registrarLugarProduccionPFI", e);
            retval = e.getMessage();
          } catch (Exception e) {
              Log("registrarLugarProduccionPFI", e);
            retval = e.getMessage();
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
  
  private String registrarProductoAnexoPFI(String codigoPermiso,  
                                    String codigoProducto, String codigoTipoEnvase,
                                    String codUnidadMedida, Double cantidadPeso,
                                    String codigoAplicacion, Double cantidadEnvase,
                                    Double cantidadPlantas, String paisProcedencia,
                                    String userName){
      
          String retval = "0";

          String sql = SenasaSQL.REGISTRAR_PRODUCTO_ANEXO;
    
          Log(" AQUI VA EL " + sql);

          Connection con = null;
          PreparedStatement pst = null;
          CallableStatement cs = null;
          
          try {
            //con=cnApp.getConnection();   
            //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            cs = con.prepareCall(sql);
            
            cs.setString(1,codigoPermiso);
            logger.debug("codigoPermiso: " + codigoPermiso);
            cs.setString(2,codigoProducto);
            logger.debug("codigoProducto: " + codigoProducto);
            cs.setString(3,codigoTipoEnvase);
            logger.debug("codigoTipoEnvase: " + codigoTipoEnvase);
            cs.setString(4,codUnidadMedida);
            logger.debug("codUnidadMedida: " + codUnidadMedida);
            cs.setDouble(5,cantidadPeso);
            logger.debug("cantidadPeso: " + cantidadPeso);
            cs.setString(6,codigoAplicacion);
            logger.debug("codigoAplicacion: " + codigoAplicacion);
            cs.setDouble(7,cantidadEnvase);
            logger.debug("cantidadEnvase: " + cantidadEnvase);
            cs.setDouble(8,cantidadPlantas);
            logger.debug("cantidadPlantas: " + cantidadPlantas);
            cs.setString(9,paisProcedencia);
            logger.debug("paisProcedencia: " + paisProcedencia);
            cs.setString(10,userName);
            logger.debug("userName: " + userName);
             
              Log(" = ANTES DE EJECUTAR = ");
              cs.execute();

              Log(" = YA EJECUTE = ");
              Log(" = FIN TODITO = ");
          } catch (SQLException e) {
              Log("registrarProductoAnexoPFI", e);
            retval = e.getMessage();
          } catch (Exception e) {
              Log("registrarProductoAnexoPFI", e);
            retval = e.getMessage();
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
  
  
  public Boolean guardarDatosPFI(PermisoFitosanitarioImportacion pfi) {
      
      boolean retval = false;
      try {

          Log(" = INICIO guardarDatosPFI= ");
          //con.setAutoCommit(false);
          
          String idPersona ="";
          
          logger.debug("pfi.getNoCertificado():"+pfi.getNoCertificado());
          logger.debug("pfi.getSolicitante().getCodigoSolicitante():"+pfi.getSolicitante().getCodigoSolicitante());
          logger.debug("pfi.getSolicitante().getDniRuc():"+pfi.getSolicitante().getDniRuc());
          
          if(pfi.getSolicitante().getCodigoSolicitante()==null){
            idPersona = obtenerIdPersona(pfi.getSolicitante().getDniRuc()); // ExpedienteDAO.ObtenerIdPersonaxExpediente(con, pfi.getNoFolio());
          }
          else{
            idPersona =  pfi.getSolicitante().getCodigoSolicitante();
          }        
          //guardarPFI(pfi, idPersona, con);        
          String _indAmpliacion = pfi.isIndicadorAmpliacion()==true?"Y":"N";
          
          String resultCabecera = registrarPermisoPFI(pfi.getNoCertificado(), pfi.getSolicitante().getDniRuc(), 
                                                pfi.getNoFolio(), pfi.getDireccionEjecutiva(),
                                                pfi.getFechaDeEmicion(), pfi.getFechaVigencia(),
                                                _indAmpliacion, pfi.getCodigoRequImpoProducto(),
                                                pfi.getSolicitante().getDniRepresentanteLegal(),      
                                                pfi.getUrlPFIDefinitivo(), pfi.getUserName());
          
          logger.debug("resultCabecera:"+resultCabecera);
          
          //if(pfi.getNoCertificado().trim()=="")
          //    pfi.setNoCertificado(resultCabecera);
          
          //Guardar cosas PFI
          for (ProductoPFI proH : pfi.getProductosPFI()) {
              if (proH != null) {
                  Log(" = VOY A GUARDAR LOS PRODUCTOS PFI = ");
                  //guardarProductoPFI(proH, pfi.getNoCertificado(), con);
                    String resultProd;
                    Double _cantPlantas;
                    logger.debug("proH.getCantidadPlantas(): " + proH.getCantidadPlantas());
                    logger.debug("proH.isContieneAnexos(): " + proH.isContieneAnexos());
                
                    if(proH.getCantidadPlantas()==null||proH.getCantidadPlantas().equals(""))
                      _cantPlantas = 0.0;
                    else
                    {    
                      if(proH.getCantidadPlantas()==null||proH.getCantidadPlantas().equals(""))
                        _cantPlantas = 0.0;
                      else    
                       _cantPlantas =  Double.parseDouble(proH.getCantidadPlantas());
                    }
                    
                    String _indAnexos = proH.isContieneAnexos()==true?"Y":"N";
                
                logger.debug("Entrando a ejecutar registrarProductoPFI.");
                
                    resultProd = registrarProductoPFI(pfi.getNoCertificado(), 
                                    proH.getCodigoProducto(), proH.getTipoEnvase(),
                                    proH.getCodUniMed(), proH.getPesoNeto(),
                                    proH.getUsoDestino(), proH.getCantidad(),
                                    _cantPlantas, proH.getPaisProcedencia(),
                                    pfi.getUserName());
                    
                  Log(" = VOY A GUARDAR LOS puntos de ingreso = ");
                  //guardarPuntosIngresosPFI(pfi, con, proH);
                  Log(" = CANTIDAD DE PTOS DE INGRESO ="+pfi.getPuntoIngresoProductoPFI().size());
                  
                      for (PuntoIngresoProductoPFI puntIn :
                           pfi.getPuntoIngresoProductoPFI()) {
      
                          if (puntIn != null &&
                              puntIn.getCodigoProducto().compareTo(proH.getCodigoProducto()) ==
                              0) {
                             
                              logger.debug("proH.getCodUniMed():"+proH.getCodUniMed());
                              String resultPtoIng = this.registrarPtoIngresoPFI(pfi.getNoCertificado(),puntIn.getCodigoProducto(), 
                                                        puntIn.getTipoEnvaseProducto(),  proH.getCodUniMed(), 
                                                        puntIn.getPesoNeto(), proH.getUsoDestino(),
                                                        puntIn.getCantidad(), _cantPlantas,puntIn.getPuntoIngresoProducto(),             
                                                        //puntIn.getCantidad(), _cantPlantas, pfi.getDireccionEjecutiva(),
                                                        _indAnexos, pfi.getUserName());
                          }
                      }
                  
                  
                  Log(" = VOY A GUARDAR LOS paises de origen = ");
                  //guardarPaisOrigenPFI(pfi, con, proH);
                  
                  ArrayList<PaisOrigenProductoPFI> arrPaisesOrigen =   pfi.getPaisesOrigenProductoPFI();
                  PaisOrigenProductoPFI objpaisPFI = null;
                  
                  logger.debug("Numero de datos en ArrayList<PaisOrigenProductoPFI>:"+ arrPaisesOrigen.size());
                  
                  if(arrPaisesOrigen.size()>0) {
                    logger.debug("Iniciando el proceso guardarPaisOrigenPFI");
                  }
                  else {
                    logger.debug("Error al obtener datos desde ArrayList<PaisOrigenProductoPFI>");
                  }
                  
                  for (PaisOrigenProductoPFI paiPFI : pfi.getPaisesOrigenProductoPFI()) {
                       logger.debug("paiPFI:"+paiPFI);
                       logger.debug("paiPFI.getCodigoProducto():"+paiPFI.getCodigoProducto());
                       logger.debug("proH:"+proH);
                       logger.debug("proH.getCodigoProducto():"+proH.getCodigoProducto());
                       if (paiPFI != null && paiPFI.getCodigoProducto().compareTo(proH.getCodigoProducto()) ==0) {
                          //guadarPaisOrigenPFI(pfi.getNoCertificado(), paiPFI, con);
                          String resultPaisOri = this.registrarPaisOrigenPFI(pfi.getNoCertificado(), paiPFI.getPaisOrigenProducto(), 
                                                                             _indAnexos, paiPFI.getTipoEnvaseProducto(), 
                                                                             paiPFI.getCodigoProducto(), pfi.getUserName());
                          
                       }
                  }
                  
                  Log(" = VOY A GUARDAR LOS lugares de produccion = ");
                  //guardarLugaresProduccionPFI(pfi, con, proH);
                  for (LugarProduccionProductoPFI lpfi :pfi.getLugaresProduccionProductoPFI()) {
                      if(lpfi != null && lpfi.getCodigoProducto().compareTo(proH.getCodigoProducto()) == 0) 
                      {
                          //guadarLugarProduccionPFI(pfi.getNoCertificado(), lpfi, con);
                          
                          String resultLugarProd = this.registrarLugarProduccionPFI(pfi.getNoCertificado(), lpfi.getCodigoProducto(), 
                                                                                    lpfi.getLugarProduccionProducto(), _indAnexos, 
                                                                                    lpfi.getTipoEnvaseProducto(), pfi.getUserName());
                      }
                  }
                  
              }
          }
          //ANEXOS
          logger.debug("Iniciando el registro de anexos. AnexoPFI.");
          for (AnexoPFI anex : pfi.getAnexosPFI()) {
              if (anex != null) {
                  //guardarAnexosPFI(anex, pfi.getNoCertificado(), con);
                  
                  Double _cantPlantasAnex; //=  Double.parseDouble(anex.getCantidadPlantas());
                  
                  if(anex.getCantidadPlantas()==null)
                    _cantPlantasAnex = 0.0;
                  else
                  {    
                    if(anex.getCantidadPlantas()==null)
                      _cantPlantasAnex = 0.0;
                    else    
                     _cantPlantasAnex =  Double.parseDouble(anex.getCantidadPlantas());
                  }
                  
                  String resultAnexos  =this.registrarProductoAnexoPFI(pfi.getNoCertificado(), 
                                                                       anex.getCodigo(), anex.getTipoEnvase(), 
                                                                       anex.getCodUniMed(), anex.getPesoNeto(), 
                                                                       anex.getUsoDestino(), anex.getCantidad(), 
                                                                        _cantPlantasAnex, anex.getPaisProcedencia(), 
                                                                       pfi.getUserName()) ;
           
                /*
                  //guardarPuntosIngresosAnexoPFI(pfi, con, anex);
                  for (PuntoIngresoAnexoPFI puntIn : pfi.getPuntoIngresoAnexoPFI()) {
                      if (puntIn != null &&
                          puntIn.getCodigoAnexo().compareTo(anex.getCodigo()) == 0) {
                          //guardarPuntoIngresoAnexoPFI(anex, puntIn,
                          //                            pfi.getNoCertificado(), con);
                          String resultPtoIng = this.registrarPtoIngresoPFI(pfi.getNoCertificado(),puntIn.getCodigoAnexo(), 
                                                    puntIn.getTipoEnvaseAnexo(), anex.getCodUniMed(), 
                                                    puntIn.getPesoNeto(), anex.getUsoDestino(), 
                                                    puntIn.getCantidad(),_cantPlantasAnex,puntIn.getPuntoIngresoAnexo(),                        
                                                    //puntIn.getCantidad(), _cantPlantasAnex, pfi.getDireccionEjecutiva(), 
                                                    "N", pfi.getUserName());
                          
                      }
                  }
                  
                  //guardarPaisOrigenAnexoPFI(pfi, con, anex);
                  for (PaisOrigenAnexoPFI paiAnPFI : pfi.getPaisesOrigenAnexoPFI()) {
                      if (paiAnPFI != null &&
                          paiAnPFI.getCodigoAnexo().compareTo(anex.getCodigo()) == 0) {
                          //guadarPaisOrigenAnexoPFI(pfi.getNoCertificado(), paiAnPFI,
                           //                        con);
                           String resultPaisOri = this.registrarPaisOrigenPFI(pfi.getNoCertificado(), paiAnPFI.getPaisOrigenAnexo(), 
                                                                              "N", paiAnPFI.getTipoEnvaseAnexo(), 
                                                                              paiAnPFI.getCodigoAnexo(), pfi.getUserName());
                           
                      }
                  }
                  
                  //guardarLugaresProduccionAnexoPFI(pfi, con, anex);
                  for (LugarProduccionAnexoPFI lugProAnPFI :pfi.getLugaresProduccionAnexoPFI()) {
                      if (lugProAnPFI != null &&
                          lugProAnPFI.getCodigoAnexo().compareTo(anex.getCodigo()) ==
                          0) {
                         
                        String resultLugarProd = this.registrarLugarProduccionPFI(pfi.getNoCertificado(), lugProAnPFI.getCodigoAnexo(), 
                                                                                  lugProAnPFI.getLugarProduccionAnexo(), "N", 
                                                                                  lugProAnPFI.getTipoEnvaseAnexo(), pfi.getUserName());
                   
                      }
                  }
                  */
                  
              }
          }
          //con.commit();
          //con.setAutoCommit(true);
          //
        logger.debug("Finalizando el registro de AnexosPFI.");
          Log(" = TODO FINITO = ");
          retval = true;
      //} catch (SQLException e) {
          //ManejarException(con, e);
     //     logger.debug(e.getMessage());
      } catch (Exception e) {
          //ManejarException(con, e);
          logger.debug("ERROR guardarDatosPFI: " + e.getMessage());
      } finally {
          //Datacleanup(con, null);
      }
      return retval;

  }
  
  private String obtenerIdPersona(String dniRucSolicitante) {
    
    String sql = SenasaSQL.OBTENER_ID_PERSONA;
    Log("obtenerIdPersona(): AQUI VA EL " + sql);
    Connection con = null; //PCSM 06/01/2017
    //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
    //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoFitosanitarioImportacion();//PCSM 05/01/2017
    PreparedStatement pst = null;
    ResultSet rs = null;
    String retval = "";
    try {
      con = helper.getConnection();  //PCSM 06/01/2017
        pst = con.prepareStatement(sql);
        pst.setString(1, dniRucSolicitante);
        rs= pst.executeQuery();
        
        int i=0;
        while (rs.next()) {
            i++;
            if(i==1)
              retval = rs.getString(1);
        }
        Log(" = TODO FINITO = ");
    } catch (SQLException e) {
        Log("obtenerIdPersona", e);
    } catch (Exception e) {
        Log("obtenerIdPersona", e);
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

    public String obtenerPeriodoCPE(String codigoReqImp) {
      Log("IC ========== OBTENER_PERIDO_CPE ==========");
      String sql = SenasaSQL.OBTENER_PERIODO_CPE;
      String retval="";
      Log(" AQUI VA EL " + sql);

      //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
      Connection con = null;//PCSM 05/01/2017
      ResultSet rs = null;
      CallableStatement cs = null;
      
      try {            
        con = helper.getConnection();
        cs = con.prepareCall(sql);        
        cs.setString(1,codigoReqImp);        
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR"); 
 
        Log(" = ANTES DE EJECUTAR = ");
        cs.execute();
        rs = (ResultSet)cs.getObject(2);
        if(rs.next()){
             retval=rs.getString(2); 
        }
        Log("= Tiempo Periodo CPE: "+retval);
      }catch (SQLException e) {
          Log("OBTENER_PERIDO_CPE", e);
          retval = e.getMessage();
      } catch (Exception e) {
          Log("OBTENER_PERIDO_CPE", e);
          retval = e.getMessage();
      }finally {
            //cleanup(con, cs, rs);
            //PCSM 06/01/2017
              try {
                  helper.cleanup(con, cs, rs);
              } catch (Exception e) {
                  e.printStackTrace();
              }
      } 
      return retval;
  }

    public ReqImpProducto obtenerValoresReqImpProducto(String codigoProducto,String codPaisOrigen,String codLugarProd,
                                              String codPaisProc,String usoDestino) {
        
      Log("IC ========== OBTENER_CODIGO_REQUISITO_IMPORTACION_PRODUCTO ==========");
      String sql = SenasaSQL.OBTENER_CODIGO_REQU_IMP_PRODUCTO;
      ReqImpProducto retval = new ReqImpProducto();;
      Log(" AQUI VA EL " + sql);

      //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
      //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoFitosanitarioImportacion();//PCSM 05/01/2017
      Connection con = null; //PCSM 06/01/2017
      ResultSet rs = null;
      CallableStatement cs = null;
      
      try {                     
        con = helper.getConnection();  //PCSM 06/01/2017
        cs = con.prepareCall(sql); 
        cs.registerOutParameter(1,OracleTypes.VARCHAR);
        cs.setString(2,codigoProducto);
        cs.setString(3,codPaisOrigen);
        cs.setString(4,codLugarProd);
        cs.setString(5,codPaisProc);
        cs.setString(6,usoDestino);
        cs.registerOutParameter(7, OracleTypes.VARCHAR);  
           
        Log(" = ANTES DE EJECUTAR LA FUNCION= ");
        cs.execute();
        Log("= SE EJECUTO LA FUNCION =");  
        
        retval.setCodigo(cs.getString(1));
        retval.setMensaje(cs.getString(7));
          
        Log("= Codigo de Requisito de Importacion de Producto: "+retval.getCodigo());
        Log("= Mensaje Importacion de Producto: "+retval.getMensaje());
          
      }catch (SQLException e) {
          Log("OBTENER_CODIGO_REQUISITO_IMPORTACION_PRODUCTO", e);
          retval.setMensaje(e.getMessage());
      } catch (Exception e) {
          Log("OBTENER_CODIGO_REQUISITO_IMPORTACION_PRODUCTO", e);
          retval.setMensaje(e.getMessage());
      }finally {
            //cleanup(con, cs, rs);
        //PCSM 06/01/2017
            try {
                helper.cleanup(con, cs, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
      }  
        
      return retval;
    }
    
  public String obtenerIndAutorizacionReqProd(String codReqImpo) {
    
    String sql = SenasaSQL.OBTENER_REQPROD_AUTORIZACION;
    Connection con = null; //PCSM 06/01/2017
    //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
    //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoFitosanitarioImportacion();//PCSM 05/01/2017
    CallableStatement cs = null;
    String retval = "";
   
    try {
      con = helper.getConnection();  //PCSM 06/01/2017
        cs = con.prepareCall(sql);
        cs.registerOutParameter(1, OracleTypes.VARCHAR);
        cs.setString(2,codReqImpo);
        cs.execute();
       
        retval = cs.getString(1);
        
        logger.debug(" = TODO FINITO = ");
    } catch (SQLException e) {
        Log("obtenerIndAutorizacionReqProd", e);
    } catch (Exception e) {
        Log("obtenerIndAutorizacionReqProd", e);
    } finally {
            //cleanup(con, cs);
      //PCSM 06/01/2017
          try {
              helper.cleanup(con, cs, null);
          } catch (Exception e) {
              e.printStackTrace();
          }
    }
    return retval;
  }
  
  public String obtenerIndCPEReqProd(String codReqImpo) {
    String sql = SenasaSQL.OBTENER_REQPROD_CPE;

    //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
    //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoFitosanitarioImportacion();//PCSM 05/01/2017
    Connection con = null; //PCSM 06/01/2017
    CallableStatement cs = null;
    String retval = "";
   
    try { 
        con = helper.getConnection();  //PCSM 06/01/2017
        cs = con.prepareCall(sql);
        cs.registerOutParameter(1, OracleTypes.VARCHAR);
        cs.setString(2,codReqImpo);
        cs.execute();        
        retval = cs.getString(1);
        
        Log(" = TODO FINITO = ");
    } catch (SQLException e) {
        Log("obtenerIndCPEReqProd", e);
    } catch (Exception e) {
        Log("obtenerIndCPEReqProd", e);
    } finally {
            //cleanup(con, cs);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    return retval;
  }
  ///////////////////////// METODOS VUCE //////////////////////////////////
  public PermisoFitosanitarioImportacion obtenerDatosPFIVuce(String nroExpediente) {
      logger.debug("OBTENER_DATOS_PFI_VUCE");
      Connection con = null;
      PermisoFitosanitarioImportacion retval =new PermisoFitosanitarioImportacion();
      try {
        //con = cnApp.getConnection(); 
        //con = cnApp.getConnPermisoFitosanitarioImportacion();  //PCSM 05/01/2017
        con = helper.getConnection();  //PCSM 06/01/2017  
        logger.debug("OBTENER_DATOS_PFI_VUCE INICIO");
        //CCODEXP,CREGUNI,CCODSED,CNOMPRE,CCODDEP,CCODPROV,CCODDIST,CDIRECCION
        retval =obtenerPermisoFitosanitarioImportacionVuce(nroExpediente, con);
        ArrayList<ProductoPFI> listPfi =obtenerProductoPFIxCodExp(retval.getNoCertificado(), con);  
        retval.setProductosPFI(listPfi);
        
        //Obteniendo los codigos de productos concatenados con comas
        retval.setCadenaProductos(obtenerCodigoProductosPFI(retval.getNoCertificado(),con)); 
          
        HashMap<String, ProductoPFI> map =
            new HashMap<String, ProductoPFI>();
        for (ProductoPFI ppfi : listPfi) {
            map.put(ppfi.getCodigoProducto(), ppfi);
        }
        
        SolicitanteDAO solDao = new SolicitanteDAO();
        
        retval.setSolicitante(solDao.obtenerSolicitanteXNumeroCertificado(retval.getNoCertificado()));
             
        retval.setLugaresProduccionProductoPFI(obtenerLugaresProduccionProductoPFI(map,retval.getNoCertificado(),
                                                                                   con));

        retval.setPuntoIngresoProductoPFI(obtenerPuntoIngresosProductoPFIVuce(retval.getNoCertificado(),
                                                                        con));
         
        retval.setPaisesOrigenProductoPFI(obtenerPaisOrigenProductoPFIVuce(retval.getNoCertificado(),con));  
        
        ArrayList<AnexoPFI> listAnexos = obtAnexosPFI(retval.getNoCertificado(), con);
        Log("= reval.getNoCertificado()="+retval.getNoCertificado());
        Log("= listAnexos.size()= "+listAnexos.size());
        retval.setAnexosPFI(listAnexos);
             
        Log(" = TODO FINITO = ");
    } catch (SQLException e) {
        Log("obtenerPFIxNoExpediente", e);
    } catch (Exception e) {
        Log("obtenerPFIxNoExpediente", e);
    } finally {
            //cleanup(con, null);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, null, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    return retval;
  }

    private PermisoFitosanitarioImportacion obtenerPermisoFitosanitarioImportacionVuce(String nroExpediente,
                                                                                       Connection con)throws SQLException {
    String sql = SenasaSQL.OBTENER_DATOS_PFI_X_EXPEDIENTE;
    String sql2 = SenasaSQL.OBTENER_DATOS_PFI_X_EXPEDIENTEII;
    Log(" AQUI VA EL " + sql);
    PreparedStatement pst;
    ResultSet rs;
    PermisoFitosanitarioImportacion retval =null;
    pst = con.prepareStatement(sql);
    pst.setString(1, nroExpediente);
    Log(" = VOY A EJECUTAR SELECT EN OBTENER_DATOS_PFI_X_EXPEDIENTE = " + nroExpediente);
    rs = pst.executeQuery();
    System.out.println(rs.getRow());
    if( rs.next()==false){ 
          pst = con.prepareStatement(sql2);
          pst.setString(1, nroExpediente);
          rs = pst.executeQuery();
      Log(" = VIENDO RS DE OBTENER_DATOS_PFI_X_EXPEDIENTE = ");
      while (rs.next()){
      Log(" = CARGANDO DATOS RETVAL ");
      retval =new PermisoFitosanitarioImportacion();
      retval.setNoFolio(rs.getString(1));
      retval.setNoCertificado(rs.getString(2));
      retval.setDireccionEjecutiva(rs.getString(3));
      retval.setDescDireccionEjecutiva(rs.getString(4));
      retval.setUrlPFIDefinitivo(rs.getString(5));
      retval.setIndicadorAmpliacion(rs.getString(6)==null || rs.getString(6).equals("N")?false:true);
      retval.setFechaDeEmicion(Utility.parseDateToString(rs.getDate(7)));
      retval.setCodigoRequImpoProducto(rs.getString(8));
      retval.setPeriodoVegetativo(rs.getString(9));
      retval.setNumeroInspecciones(rs.getString(10));
      }
          
    }else{   
        
          pst = con.prepareStatement(sql);
          pst.setString(1, nroExpediente);
          rs = pst.executeQuery();
          Log(" = VIENDO RS DE OBTENER_DATOS_PFI_X_EXPEDIENTE = ");
        while (rs.next()){
      Log(" = CARGANDO DATOS RETVAL ");    
      retval =new PermisoFitosanitarioImportacion();
      retval.setNoFolio(rs.getString(1));
      retval.setNoCertificado(rs.getString(2));
      retval.setDireccionEjecutiva(rs.getString(3));
      retval.setDescDireccionEjecutiva(rs.getString(4)); 
      retval.setUrlPFIDefinitivo(rs.getString(5));
      retval.setIndicadorAmpliacion(rs.getString(6)==null || rs.getString(6).equals("N")?false:true);
      retval.setFechaDeEmicion(Utility.parseDateToString(rs.getDate(7)));
      retval.setCodigoRequImpoProducto(rs.getString(8));
      retval.setPeriodoVegetativo(rs.getString(9));
      retval.setNumeroInspecciones(rs.getString(10));     
    }
        }
    
   

   


    
    return retval;
  }

    private ArrayList<PuntoIngresoProductoPFI> obtenerPuntoIngresosProductoPFIVuce(String noCertificado,
                                                                                   Connection con)throws SQLException {
      
      logger.debug("===== OBTENER_PUNTOS_INGRESO_PRODUCTO_VUCE Iniciando =====");
      
      String sql = SenasaSQL.OBTENER_PTOS_INGRESO_PRODUCTO_PFI_VUCE;
      String sql2 = SenasaSQL.OBTENER_PTOS_INGRESO_PRODUCTO_PFI_VUCEII;
      logger.debug(" AQUI VA EL " + sql);
      PreparedStatement pst;
      ResultSet rs;
      PuntoIngresoProductoPFI ptoIngreso =null;
      ArrayList<PuntoIngresoProductoPFI> xpuntosIngreso= new ArrayList<PuntoIngresoProductoPFI>();
      
      pst = con.prepareStatement(sql);
      pst.setString(1, noCertificado);
      
      logger.debug(" = VOY A EJECUTAR SELECT EN obtenerPuntoIngresosProductoPFIVuce = ");
      rs = pst.executeQuery();
      
      if(rs.next()==false){ 
            
            pst = con.prepareStatement(sql2);
            pst.setString(1, noCertificado);
            rs = pst.executeQuery(); 
            
        while(rs.next()){
          ptoIngreso = new PuntoIngresoProductoPFI();
          ptoIngreso.setPuntoIngresoProducto(rs.getString(1));
          ptoIngreso.setDescPuntoIngresoProducto(rs.getString(2));
          xpuntosIngreso.add(ptoIngreso);  
        }
      }else{
            pst = con.prepareStatement(sql);
            pst.setString(1, noCertificado);
            rs = pst.executeQuery(); 
            while(rs.next()){
              ptoIngreso = new PuntoIngresoProductoPFI();
              ptoIngreso.setPuntoIngresoProducto(rs.getString(1));
              ptoIngreso.setDescPuntoIngresoProducto(rs.getString(2));
              xpuntosIngreso.add(ptoIngreso);  
            }   
          }
      logger.debug(" = VIENDO RS DE obtenerPuntoIngresosProductoPFIVuce = ");
      
     
      logger.debug("Cantidad de Ptos de Ingreso Obtenidos: "+xpuntosIngreso.size());
      rs.close();
      pst.close();
          
      return xpuntosIngreso;
    }

    private ArrayList<PaisOrigenProductoPFI> obtenerPaisOrigenProductoPFIVuce(String noCertificado,
                                                                              Connection con)throws SQLException {
      
      logger.debug("===== OBTENER_PAIS_ORIGEN_PRODUCTO_VUCE Iniciando =====");
        
      String sql = SenasaSQL.OBTENER_PAIS_ORIGEN_PRODUCTO_PFI_VUCE;
       String sql2 = SenasaSQL.OBTENER_PAIS_ORIGEN_PRODUCTO_PFI_VUCEII;
      logger.debug(" AQUI VA EL " + sql);
      PreparedStatement pst;
      ResultSet rs;
      PaisOrigenProductoPFI paisOrigen=null;
      ArrayList<PaisOrigenProductoPFI> xpaisesOrigen = new ArrayList<PaisOrigenProductoPFI>();

      pst = con.prepareStatement(sql);
      pst.setString(1, noCertificado);
           
      logger.debug(" = VOY A EJECUTAR SELECT EN obtenerPaisOrigenProductoPFIVuce = ");
      rs = pst.executeQuery();
      
      if(rs.next()==false){
         
            pst = con.prepareStatement(sql2);
            pst.setString(1, noCertificado);
            rs = pst.executeQuery();
            
        while(rs.next()){
          paisOrigen = new PaisOrigenProductoPFI();
          paisOrigen.setPaisOrigenProducto(rs.getString(1));  
          paisOrigen.setDescPaisOrigenProducto(rs.getString(2));
          paisOrigen.setCodigoLugarProduccion(rs.getString(3));
          paisOrigen.setDescLugarProduccion(rs.getString(4));  
          xpaisesOrigen.add(paisOrigen);
        }
      }else{
            pst = con.prepareStatement(sql);
            pst.setString(1, noCertificado);
            rs = pst.executeQuery();
            while(rs.next()){
              paisOrigen = new PaisOrigenProductoPFI();
              paisOrigen.setPaisOrigenProducto(rs.getString(1));  
              paisOrigen.setDescPaisOrigenProducto(rs.getString(2));
              paisOrigen.setCodigoLugarProduccion(rs.getString(3));
              paisOrigen.setDescLugarProduccion(rs.getString(4));  
              xpaisesOrigen.add(paisOrigen);
            }
          }
      
      
      logger.debug(" = VIENDO RS DE obtenerPaisOrigenProductoPFIVuce = ");
      
      
      logger.debug("Cantidad de Paises de Origen Obtenidos: "+xpaisesOrigen.size());
      rs.close();
      pst.close();
      
      return xpaisesOrigen;
    }

    private String obtenerCodigoProductosPFI(String noCertificado, Connection con)throws SQLException {
      logger.debug("===== OBTENER_CODIGO_PRODUCTOS_PFI Iniciando =====");
        
      String sql = SenasaSQL.OBTENER_CODIGOS_PRODUCTO_PFI;
      String   sql2 = SenasaSQL.OBTENER_CODIGOS_PRODUCTO_PFIII;
      logger.debug(" AQUI VA EL " + sql);
      PreparedStatement pst;
      ResultSet rs;
      String cadProductos="";
      StringBuilder stbProductos = new StringBuilder();
      
      pst = con.prepareStatement(sql);
      pst.setString(1, noCertificado);
           
      logger.debug(" = VOY A EJECUTAR SELECT EN obtenerCodigoProductosPFI = ");
      rs = pst.executeQuery();
      
      
      if(rs.next()==false){
          
            pst = con.prepareStatement(sql2);
            pst.setString(1, noCertificado);
            logger.debug(" = VOY A EJECUTAR SELECT EN obtenerCodigoProductosPFI = ");
            rs = pst.executeQuery();
            
            
        while(rs.next()){
          stbProductos.append(rs.getString(1)).append(",");  
        }
            
      }else{
            pst = con.prepareStatement(sql);
            pst.setString(1, noCertificado);
            logger.debug(" = VOY A EJECUTAR SELECT EN obtenerCodigoProductosPFI = ");
            rs = pst.executeQuery();
          
            while(rs.next()){
              stbProductos.append(rs.getString(1)).append(",");  
            }
          
          }
      
      
    
      cadProductos=String.valueOf(stbProductos);
      cadProductos=cadProductos.substring(0, cadProductos.length()-1);
      
      logger.debug("Cadena de Codigos de Productos Obtenida: "+cadProductos);
      return cadProductos;
    }
}
