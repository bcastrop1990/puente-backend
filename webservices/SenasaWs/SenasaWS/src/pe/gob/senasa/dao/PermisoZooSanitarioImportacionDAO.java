package pe.gob.senasa.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Ampliacion;
import pe.gob.senasa.bean.AnexoPFI;
import pe.gob.senasa.bean.LugarProduccionProductoPFI;
import pe.gob.senasa.bean.PaisOrigenAnexoPFI;
import pe.gob.senasa.bean.PaisOrigenProductoPFI;
import pe.gob.senasa.bean.PermisoZoosanitarioImportacion;
import pe.gob.senasa.bean.ProductoPFI;
import pe.gob.senasa.bean.ProductoPZI;
import pe.gob.senasa.bean.PuntoIngresoProductoPFI;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.PermisoZoosanitarioImportacionInterface;
import pe.gob.senasa.util.Utility;


public class PermisoZooSanitarioImportacionDAO extends BaseDAO implements PermisoZoosanitarioImportacionInterface {

    protected static Logger logger = Logger.getLogger(PermisoZooSanitarioImportacionDAO.class);
    //ConectionApp cnApp =null;
    private DBHelper helper;

    public PermisoZooSanitarioImportacionDAO() {
        super();
        //cnApp = new ConectionApp();
      helper = new DBHelper(SenasaSQL.DATA_SOURCE_PERMZOOIMPO);
    }


    /**
     *
     * @param noCertificado
     * @return
     */
    public PermisoZoosanitarioImportacion obtenerPZIxNoCertificado(String noCertificado) {
        PermisoZoosanitarioImportacion retval = new PermisoZoosanitarioImportacion();
        Connection con =null;
        try {
            //con = cnApp.getConnection();
            //con = cnApp.getConnPermisoZoosanitarioImportacion();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            Log(" = INICIO = ");
            //CCODEXP,CREGUNI,CCODSED,CNOMPRE,CCODDEP,CCODPROV,CCODDIST,CDIRECCION
            retval = obtenerPermisoZoosanitarioImportacion(noCertificado, con);
            SolicitanteDAO solDao = new SolicitanteDAO();
            retval.setSolicitante(solDao.obtenerSolicitanteXNumeroCertificadoPZI(retval.getNoCertificado()));
            ProductoPZI pzi = obtenerProductoZIxCodExp(retval.getNoCertificado(), con);
            retval.setProductoPZI(pzi);
            ArrayList<PaisOrigenProductoPFI> paisesOrigenProductoPZI = obtenerPaisesOrigen(retval.getNoCertificado(), con); 
            retval.setPaisesOrigenProductoPZI(paisesOrigenProductoPZI);
            ArrayList<AnexoPFI> list = obtAnexosPZI(retval.getNoCertificado(), con);
            retval.setAnexosPZI(list);
            ArrayList<PaisOrigenAnexoPFI> paisesOrigenAnexoPZI = obtenerPaisesOrigenAnexo(retval.getNoCertificado(), con); 
            retval.setPaisesOrigenAnexoPZI(paisesOrigenAnexoPZI);
            
            
            Log(" = TODO FINITO = ");
        } catch (SQLException e) {
            Log("obtenerPZIxNoCertificado", e);
        } catch (Exception e) {
            Log("obtenerPZIxNoCertificado", e);
        } finally {
            cleanup(con, null);
          //PCSM 06/01/2017
           try {
               helper.cleanup(con, null, null);
           } catch (Exception e) {
               e.printStackTrace();
           }
        }
        return retval;
    }


    public ArrayList<PermisoZoosanitarioImportacion> obtenerPZIxSolicitante(String dniRuc) {
        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
       // Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoZoosanitarioImportacion();  //PCSM 05/01/2017
       Connection con = null; //PCSM 06/01/2017
        String sql = SenasaSQL.OBTENER_PERMISOS_PZI_X_CLIENTE;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<PermisoZoosanitarioImportacion> retval =
            new ArrayList<PermisoZoosanitarioImportacion>();
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
                PermisoZoosanitarioImportacion aux =
                    obtenerPZIxNoCertificado(s);
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
               helper.cleanup(con, null, null);
           } catch (Exception e) {
               e.printStackTrace();
           }
        }
        return retval;
    }

    public Boolean guardarPZI(PermisoZoosanitarioImportacion pfi) {
        /*
        if (ExisteNumerosCertificados(pfi.getNoCertificado())) {
            return actualizarPermisoPZI(pfi);
        } else {
        */
            return salvarPZI(pfi);
    }
    /*
    private Boolean actualizarPermisoPZI(PermisoZoosanitarioImportacion pzi) {
        Connection con =  ConnectionSenasa.getSingletonObject().getConnection();
        try {
            con.setAutoCommit(false);
            if (DeleteAll(pzi.getNoCertificado(), con))
                return salvarPZI(pzi, con);
            else
                return false;
        } catch (Exception e) {
            ManejarExcepcion(con, e);
        }
        return false;
    }*/


    private boolean DeleteAll(String noCert,
                              Connection con) throws SQLException {
        boolean retval = false;

        Log("IC = INICIO ELIMINAR PZI= ");
        //con.setAutoCommit(false);
        String numeroPermiso = obtenerNumeroPermiso(noCert,con);
        Log("IC = ELIMINAR_PAISES_ORIGEN_PZI = " +
            ExecuteQuery(numeroPermiso, SenasaSQL.ELIMINAR_PAISES_ORIGEN_PZI, con));
        Log("IC = ELIMINAR_ANEXOS_PZI = " +
            ExecuteQuery(numeroPermiso, SenasaSQL.ELIMINAR_ANEXOS_PZI, con));
        Log("IC = ELIMINAR_PRODUCTOS_PZI = " +
            ExecuteQuery(numeroPermiso, SenasaSQL.ELIMINAR_PRODUCTOS_PZI, con));
        Log("IC = ELIMINAR_PERMISO_PZI = " +
            ExecuteQuery(numeroPermiso, SenasaSQL.ELIMINAR_PERMISO_PZI, con));
        Log("IC = LISTO ELIMINAR PZI= ");
        con.commit();
        con.setAutoCommit(true);
        retval = true;
        return retval;
    }
    
    private String obtenerNumeroPermiso(String noCert,Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_NUMERO_PERMISO_PZI;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        String retval = "";
        pst = con.prepareStatement(sql);
        pst.setString(1, noCert);
        Log(" = VOY A EJECUTAR OBTENER_NUMERO_PERMISO_PZI = ");
        rs = pst.executeQuery();
        Log(" = VIENDO RS DE OBTENER_NUMERO_PERMISO_PZI = ");
        while (rs.next()) {
            retval = rs.getString(1);
            break;
        }
        return retval;
    }

    private int ExecuteQuery(String noExp, String sql,
                             Connection con) throws SQLException {
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, noExp);
        return pst.executeUpdate();
    }
    private void ManejarExcepcion(Connection con, Exception e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("guardarPermisoPZI", f);
        }
        Log("guardarPermisoPZI", e);
    }
    /*
    private Boolean salvarPZI(PermisoZoosanitarioImportacion pfi){
            Connection con = ConnectionSenasa.getSingletonObject().getConnection();
            return salvarPZI(pfi,con);
    }*/
    
    private Boolean salvarPZI(PermisoZoosanitarioImportacion pzi){       
       
        boolean retval = false;        
        Log("= INICIO = ");
        //CCODEXP,CREGUNI,CCODSED,CNOMPRE,CCODDEP,CCODPROV,CCODDIST,CDIRECCION
        Log("= NoFolio o Expediente === >>  "+pzi.getNoFolio());
        Log("= NoCertificado o NUMERO_PERMISO === >>  "+pzi.getNoCertificado());
        
        String idPersona = "";
        String idRepresentante ="";
        String usuario="";         
        //Obteniendo el id de la persona o solicitante
        if(pzi.getSolicitante().getCodigoSolicitante()==null){
          idPersona = obtenerIdPersona(pzi.getSolicitante().getDniRuc());
        }else{
          idPersona =  pzi.getSolicitante().getCodigoSolicitante();
        }
                    
        if (pzi.getSolicitante().getDniRepresentanteLegal()!=null && pzi.getSolicitante().getDniRepresentanteLegal()!=""){
          idRepresentante = obtenerIdPersona(pzi.getSolicitante().getDniRepresentanteLegal().trim());
        }else{
          idRepresentante=null;
        }  
        usuario=pzi.getUsuario();
        Log("getIdPersona ==>"+idPersona);
        Log("getUsuario ==>"+usuario);
        Log("idRepresentante ==>"+idRepresentante);
         
        Connection con=null;     
        try { 
            //Guardando PZI
            //con = cnApp.getConnection();
            //con = cnApp.getConnPermisoZoosanitarioImportacion();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            //Obteniendo y mostrando el nombre de usuario
            con.setAutoCommit(false);
            String numeroPermiso = GuardarPermisoZoosanitarioImportacion(pzi,idPersona,idRepresentante, con);
            
            GuardarProductoPZI(pzi.getProductoPZI(), numeroPermiso,usuario, con);
            for (AnexoPFI anexo : pzi.getAnexosPZI()) {
                if(anexo != null)
                    GuardarAnexos(anexo,numeroPermiso,usuario, con);                
            }
            for(PaisOrigenProductoPFI paiori:pzi.getPaisesOrigenProductoPZI()){
                if(paiori != null){
                    Log("= ================= >>>> "+numeroPermiso);
                    Log("= ================= (2) >>>> "+paiori.getTipoEnvaseProducto());

                    guardarPaisOrigenBASE(paiori.getPaisOrigenProducto(),numeroPermiso,pzi.getProductoPZI().getCodProducto(),
                                          pzi.getProductoPZI().getTipoEnvase(),"0",usuario,con);
                }
             }
            for(PaisOrigenAnexoPFI paiori:pzi.getPaisesOrigenAnexoPZI()){
                if(paiori != null){
//                    guardarPaisOrigen(paiori,numeroPermiso,con);
                    guardarPaisOrigenBASE(paiori.getPaisOrigenAnexo(),numeroPermiso,paiori.getCodigoAnexo(),pzi.getProductoPZI().getTipoEnvase(),"1",usuario,con);
                }
             }
            //PaisOrigenAnexoPFI        
            //guardarPaisesOrigenProductoPZI(pfi.getProductoPZI());
            con.commit();
            con.setAutoCommit(true);
            //
            Log("= TODO OK = ");
            retval = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException f) {
                Log("guardarPZI Error", f);
            }
            Log("guardarPZI Error", e);
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException f) {
                Log("guardarPZI Error", f);
            }
            Log("guardarPZI Error", e);
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

    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("PermisoZooSanitarioImportacionDAO - " + s, p2);
    }

    private PermisoZoosanitarioImportacion obtenerPermisoZoosanitarioImportacion(String noCertificado,
                                                                                 Connection con) throws SQLException {

        String sql = SenasaSQL.OBTENER_PZI_X_NoCERTIFICADO;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        PermisoZoosanitarioImportacion retval = new PermisoZoosanitarioImportacion();
        pst = con.prepareStatement(sql);
        pst.setString(1, noCertificado);
        Log(" = VOY A EJECUTAR SELECT EN OBTENER_PZI_X_NoCERTIFICADO = ");
        rs = pst.executeQuery();
        Log(" = VIENDO RS DE OBTENER_PZI_X_NoCERTIFICADO = ");
        while (rs.next()) {
            retval = obtPermisoZooSanitarioImportacion(rs);
            break;
        }
        return retval;
    }

    private ProductoPZI obtenerProductoZIxCodExp(String codExp,
                                                 Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_PRODUCTOPZI_X_COD_EXP;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ProductoPZI retval = new ProductoPZI();
        pst = con.prepareStatement(sql);
        pst.setString(1, codExp);
        Log(" = VOY A EJECUTAR OBTENER_PRODUCTOPZI_X_COD_EXP = ");
        rs = pst.executeQuery();
        Log(" = VIENDO RS DE OBTENER_ANEXOS_PFI = ");
        while (rs.next()) {
            retval = obtProductoPZI(rs);
            break;
        }
        return retval;
    }

    private ArrayList<AnexoPFI> obtAnexosPZI(String codExp,
                                             Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_ANEXOS_PZI;
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
            retval.add(obtAnexoPZI(rs));
        }
        return retval;
    }

    private PermisoZoosanitarioImportacion obtPermisoZooSanitarioImportacion(ResultSet rs) throws SQLException {
        //rqi.ccodexp as folio,rqi.cnumreq as noCertificado,rqi.url_pzi_definitivo,rqi.punto_ingreso,rqi.dfecarr as fechaProbableIngreso,rqi.punto_salida,rqi.dfecemb
        PermisoZoosanitarioImportacion retval =new PermisoZoosanitarioImportacion();
        retval.setNoFolio(rs.getString(1));
        retval.setNoCertificado(rs.getString(2));
        retval.setUrlPZIDefinitivo(rs.getString(3));
        retval.setPuntoIngreso(rs.getString(4));
        retval.setFechaProbableIngreso(rs.getDate(5));
        retval.setPuntoSalida(rs.getString(6));
        retval.setFechaProbableSalida(rs.getDate(7));
        retval.setDireccionEjecutiva(rs.getString(8));
        retval.setIndicadorAmpliacion(rs.getString(10)!=null && rs.getString(10).equals("Y")?true:false);
        logger.debug("rs.getDate(11):"+rs.getDate(11));
        retval.setFechaEmision(Utility.toUtilDate(rs.getDate(11)));
        retval.setCodReqImpProducto(rs.getString(12));
        return retval;
    }

    private ProductoPZI obtProductoPZI(ResultSet rs) throws SQLException {
        //p.codigo_producto,p.cdespro,sg.ccodpart,p.cnomtec,pxe.codigo_pais_procedencia,p.ccodcla,pxe.codigo_aplicacion,
        ////pxe.codigo_envase,pxe.cantidad_envase,pxe.cantidad_peso_permiso,count(pg.cproini)
        ProductoPZI retval = new ProductoPZI();
        retval.setCodProducto(rs.getString(1));
        retval.setDescripcion(rs.getString(2));
        retval.setPartidaArancelaria(rs.getString(3));
        retval.setNombreCientifico(rs.getString(4));
        retval.setPaisProcedencia(rs.getString(5));
        retval.setEsAnimal((retval.getPartidaArancelaria().startsWith("01")) ?(true) : (false));
        retval.setUsoDestino(rs.getString(7));
        retval.setTipoEnvase(rs.getString(8));
        retval.setCantidad(Utility.TryParseDouble(rs.getString(9)));//Cantidad de envase
        if(retval.getEsAnimal()){               
          retval.setNumeroAnimales(Utility.TryParseInteger(rs.getString(10)));
        }
        else{
          retval.setPesoNeto(Utility.TryParseDouble(rs.getString(10)));
        }       
       // int aux = Integer.parseInt(rs.getString(11));
        //retval.setContieneAnexos((aux > 0) ? (true) : (false));
        
        retval.setContieneAnexos((Utility.TryParseInteger(rs.getString(11)) > 0) ?(true) : (false));
        retval.setCodUniMed(rs.getString(12));
        retval.setDescUniMed(rs.getString(13));
        retval.setDesTipoEnvase(rs.getString(14));
        retval.setIdRaza(rs.getString(16));
        retval.setDescRaza(rs.getString(17));
        retval.setEdad(Integer.valueOf(rs.getString(18)==null?"0":rs.getString(18)));
        retval.setIdSexo(rs.getString(19));
        retval.setDescSexo(rs.getString(20));
        return retval;
    }

    private AnexoPFI obtAnexoPZI(ResultSet rs) throws SQLException {
        //ap.ccodpro,sg2.ccodpart,p2.cdespro,p2.cnomtec, ap.ccodenv as envase,ap.ncanprod as cantidad,
        //ap.ncanenv as peso, p.codigo_producto,sg.ccodpart,p.cnomtec,p.cdespro
        AnexoPFI retval = new AnexoPFI();
        retval.setCodigo(rs.getString(1));
        retval.setPartidaArancelaria(rs.getString(2));
        retval.setDescripcion(rs.getString(3));
        retval.setNombreCientifico(rs.getString(4));
        retval.setTipoEnvase(rs.getString(5));
        retval.setCantidad(Utility.TryParseDouble(rs.getString(6)));

        retval.setPesoNeto(Utility.TryParseDouble(rs.getString(7)));
        retval.setCodigoPadre(rs.getString(8));
        retval.setPartidaArancelariaPadre(rs.getString(9));
        retval.setNombreCientificoPadre(rs.getString(10));
        retval.setDescripcionPadre(rs.getString(11));
        retval.setPaisProcedencia(rs.getString(12));
        retval.setCodUniMed(rs.getString(13));//
        retval.setDesUniMed(rs.getString(14));
        retval.setDesTipoEnvase(rs.getString(15));
        if (rs.getString(16)!=null && rs.getString(16).equalsIgnoreCase("X")){
          retval.setIsAnimalVivo(true);
        }else{
            retval.setIsAnimalVivo(false);
        }
        retval.setIdRaza(rs.getString(17));
        retval.setDescRaza(rs.getString(18));
        retval.setEdad(Integer.valueOf(rs.getString(19)==null?"0":rs.getString(19)));
        retval.setIdSexo(rs.getString(20));
        retval.setDescSexo(rs.getString(21));
        
        return retval;
    }

    private String GuardarPermisoZoosanitarioImportacion(PermisoZoosanitarioImportacion pzi,String idPersona,String idRepresentante,
                                                       Connection con) throws SQLException {
        //(codigo_documento_resolutivo,persona_id,codigo_expediente,fecha_probable_embarque,fecha_probable_arribo,
        //urlpzidefinitivo,centro_tramite_llegada,puerto,centro_tramite_solicitud)
        Log("IC = GuardarPermisoZoosanitarioImportacion() INCIANDO =");
        String sql = SenasaSQL.GUARDAR_PZSI;
        Log("IC = AQUI VA EL =" + sql);
        CallableStatement cs=null;
        cs=con.prepareCall(sql);
        
        cs.setString(1, pzi.getNoCertificado());         
        logger.debug("pzi.getNoCertificado():"+pzi.getNoCertificado());
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, idPersona);
        logger.debug("idPersona:"+idPersona);
        cs.setString(3, pzi.getNoFolio());
        logger.debug("pzi.getNoFolio():"+pzi.getNoFolio());
        
        cs.setDate(4, Utility.toSQLDate(pzi.getFechaEmision()));
        logger.debug("pzi.getFechaEmision():"+pzi.getFechaEmision());
        cs.setDate(5, Utility.toSQLDate(pzi.getFechaEntrega()));
        logger.debug("pzi.getFechaEntrega():"+pzi.getFechaEntrega());
        cs.setString(6, pzi.isIndicadorAmpliacion()==true?"Y":"N");
        logger.debug("pzi.isIndicadorAmpliacion():"+pzi.isIndicadorAmpliacion());
        cs.setString(7, pzi.getCodReqImpProducto()); //Codigo Requisito Importacion Producto por definir
        logger.debug("pzi.getCodReqImpProducto():"+pzi.getCodReqImpProducto());
        cs.setString(8, idRepresentante); 
        
        cs.setDate(9, Utility.toSQLDate(pzi.getFechaProbableSalida()));
        logger.debug("pzi.getFechaProbableSalida():"+pzi.getFechaProbableSalida());
        cs.setDate(10, Utility.toSQLDate(pzi.getFechaProbableIngreso()));
        logger.debug("pzi.getFechaProbableIngreso():"+pzi.getFechaProbableIngreso());
        cs.setString(11, pzi.getDireccionEjecutiva());
        logger.debug("pzi.getDireccionEjecutiva():"+pzi.getDireccionEjecutiva());
        cs.setString(12, pzi.getPuntoIngreso());
        logger.debug("pzi.getPuntoIngreso():"+pzi.getPuntoIngreso());
        cs.setString(13, pzi.getPuntoSalida());      
        logger.debug("pzi.getPuntoSalida():"+pzi.getPuntoSalida());
        cs.setString(14, pzi.getUrlPZIDefinitivo());
        logger.debug("pzi.getUrlPZIDefinitivo():"+pzi.getUrlPZIDefinitivo());
        cs.setString(15, pzi.getUsuario());
        logger.debug("pzi.getUsuario():"+pzi.getUsuario());
        
        Log("IC  = VOY A EJECUTAR GUARDAR_PZSI = ");
        cs.executeUpdate();
        String numero_permiso=cs.getString(1);
        Log("IC = LISTO QUERY DE GUARDAR_PZSI numero_permiso=  " + numero_permiso);
        
        Log("IC = guardarPermisoZoosanitarioImportacion Finalizando =");
        return numero_permiso;
    }

    private void GuardarProductoPZI(ProductoPZI productoPZI, String numero_permiso,String usuario,
                                    Connection con) throws SQLException {
        Log("IC = GUARDAR_PRODUCTO_PZI INICIANDO =");
        String sql = SenasaSQL.GUARDAR_PRODUCTO_PZI;
        //CODIGO_EXPEDIENTE,CODIGO_PAIS_PROCEDENCIA,CODIGO_PRODUCTO,CODIGO_APLICACION,CODIGO_ENVASE,CANTIDAD_ENVASE,CANTIDAD_PESO_PERMISO
        Log("IC AQUI VA EL " + sql);
        logger.debug("numero_permiso:" + numero_permiso);
        
        CallableStatement cs=null;
        cs = con.prepareCall(sql);      
        cs.setString(1, numero_permiso);
        
        cs.setString(2, productoPZI.getCodProducto());
        logger.debug("productoPZI.getCodProducto():" + productoPZI.getCodProducto());
        cs.setString(3, productoPZI.getTipoEnvase());
        logger.debug("productoPZI.getTipoEnvase():" + productoPZI.getTipoEnvase());
        cs.setString(4, productoPZI.getCodUniMed());
        logger.debug("productoPZI.getCodUniMed():" + productoPZI.getCodUniMed());
        cs.setString(5, productoPZI.getPesoNeto()+"");
        logger.debug("productoPZI.getPesoNeto():" + productoPZI.getPesoNeto());
        cs.setString(6, productoPZI.getUsoDestino());
        logger.debug("productoPZI.getUsoDestino():" + productoPZI.getUsoDestino());
        cs.setString(7, productoPZI.getCantidad()+"");
        logger.debug("productoPZI.getCantidad():" + productoPZI.getCantidad());
        cs.setString(8, productoPZI.getPaisProcedencia());
        logger.debug("productoPZI.getPaisProcedencia():" + productoPZI.getPaisProcedencia());
        logger.debug("productoPZI.getIdRaza():" + productoPZI.getIdRaza());
        logger.debug("productoPZI.getEdad():" + productoPZI.getEdad());
        logger.debug("productoPZI.getIdSexo():" + productoPZI.getIdSexo());
        cs.setString(9, productoPZI.getIdRaza()==""?null:productoPZI.getIdRaza());
        cs.setString(10, String.valueOf(productoPZI.getEdad()));
        cs.setString(11, productoPZI.getIdSexo()==""?null:productoPZI.getIdSexo());
        cs.setString(12, usuario);
        logger.debug("usuario:" + usuario);
        Log("IC = VOY A EJECUTAR GUARDAR_PRODUCTOPZI = ");
        cs.execute();
        Log("IC = LISTO QUERY DE GUARDAR_PRODUCTOPZI = ");
    }
    
    private void setearValor(PreparedStatement pst, int index, String string) throws SQLException {
        if(string == null)
            pst.setString(index, "");
        else
            pst.setString(index, string);
    }
    
    private void setearValor(PreparedStatement pst, int index, Double number) throws SQLException {
        if(number != null)
            pst.setDouble(index, number);
        else
            pst.setDouble(index, 0);
    }

    private void GuardarAnexos(AnexoPFI anexo, String codExp,String usu,
                               Connection con) throws SQLException {
        Log("IC = GUARDAR_ANEXOS INICIANDO");
        String sql = SenasaSQL.GUARDAR_ANEXOS_PZI;
        //(CCODEXP,CCODPRO,CCODENV, NCANENV, NCANPROD)
        Log("IC AQUI VA EL " + sql);
        //PreparedStatement pst;
        CallableStatement cs =null;
        cs = con.prepareCall(sql);
        cs.setString(1, codExp);
        logger.debug("codExp:"+codExp);
        cs.setString(2, anexo.getCodigo());
        logger.debug("anexo.getCodigo():"+anexo.getCodigo());
        cs.setString(3, anexo.getTipoEnvase());
        logger.debug("anexo.getTipoEnvase():"+anexo.getTipoEnvase());
        cs.setString(4, anexo.getCodUniMed());
        logger.debug("anexo.getCodUniMed():"+anexo.getCodUniMed());
        cs.setString(5, anexo.getPesoNeto() + "");
        logger.debug("anexo.getPesoNeto():"+anexo.getPesoNeto());
        cs.setString(6, anexo.getUsoDestino());
      logger.debug("anexo.getUsoDestino():"+anexo.getUsoDestino());
      cs.setString(7, anexo.getCantidad()+"");
      logger.debug("anexo.getCantidad():"+anexo.getCantidad());
        cs.setString(8, anexo.getPaisProcedencia());
      logger.debug("anexo.getPaisProcedencia():"+anexo.getPaisProcedencia());
      logger.debug("anexo.getIdRaza():"+anexo.getIdRaza());
      logger.debug("anexo.getEdad():"+anexo.getEdad());
      logger.debug("anexo.getIdSexo():"+anexo.getIdSexo());
        cs.setString(9, anexo.getIdRaza()==null?null:anexo.getIdRaza());
        cs.setString(10, String.valueOf(anexo.getEdad()));
        cs.setString(11, anexo.getIdSexo()==""?null:anexo.getIdSexo());
        cs.setString(12, usu);       
      logger.debug("usu:"+usu);
        Log("IC = VOY A EJECUTAR GUARDAR_PRODUCTOPZI = ");
        cs.execute(); 
        Log("IC = LISTO QUERY DE GUARDAR_PRODUCTOPZI = ");

    }

    // 
    private String obtenerIdpersona(PermisoZoosanitarioImportacion pfi,
                                    Connection con) throws SQLException {
        return ExpedienteDAO.ObtenerIdPersonaxExpediente(con, pfi.getNoFolio());        
    }
  private String obtenerIdPersona(String dniRucSolicitante) {
    
    String sql = SenasaSQL.OBTENER_ID_PERSONA;
    Log("obtenerIdPersona(): AQUI VA EL " + sql);

    //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
    //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoZoosanitarioImportacion();  //PCSM 05/01/2017
    Connection con = null; //PCSM 06/01/2017
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


    private boolean ExisteNumerosCertificados(String noCertificado) {
        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoZoosanitarioImportacion();  //PCSM 05/01/2017
        Connection con = null; //PCSM 06/01/2017
        boolean retval = false;
        try {
            con = helper.getConnection();  //PCSM 06/01/2017
            PreparedStatement pst = con.prepareCall(SenasaSQL.BUSCAR_PERMISO_PZI);
            Log(" = INICIO BUSCAR_PERMISO_PZI= ");
            pst.setString(1, noCertificado);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) >= 1)
                    retval = true;
                else
                    retval = false;
                break;
            }
            Log(" = FIN BUSCAR_PERMISO_PZI= ");
        } catch (SQLException e) {
            ManejarException(con, e);
        } catch (Exception e) {
            ManejarException(con, e);
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
    
    private void ManejarException(Connection con, Exception e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("PFI", f);
        }
        Log("PFI", e);
    }


    private void guardarPaisOrigen(PaisOrigenProductoPFI paiori,String codigoProductoPZI,
                                   String numeroPermiso,String usuario, Connection con) throws SQLException {
        //(codi_pais_tpa_origen,numero_permiso,codigo_producto,codigo_envase,es_anexo)
        guardarPaisOrigenBASE(paiori.getPaisOrigenProducto(),numeroPermiso,codigoProductoPZI,paiori.getTipoEnvaseProducto(),"0",usuario,con);
    }

    private void guardarPaisOrigenBASE(String paisOri, String numeroPer,
                                       String codigoPro, String tipoEnv,
                                       String anexo,String usuario,Connection con) throws SQLException {
      //paiori.getPaisOrigenProducto(),numeroPermiso,pzi.getProductoPZI().getCodProducto(),pzi.getProductoPZI().getTipoEnvase(),"0",con
        CallableStatement cs = con.prepareCall(SenasaSQL.GUARDAR_PAIS_ORIGEN_PZI);
        Log("IC  = INICIO GUARDAR_PAIS_ORIGEN_PZI anexo=>"+anexo);
        cs.setString(1, numeroPer);
        cs.setString(2, paisOri);
        cs.setString(3, anexo);
        cs.setString(4, tipoEnv);
        cs.setString(5, codigoPro);
        cs.setString(6, usuario);
        cs.execute();
        Log("IC = FIN GUARDAR_PAIS_ORIGEN_PZI");
    }

    private void guardarPaisOrigen(PaisOrigenAnexoPFI paiori,
                                   String numeroPermiso,String usuario,Connection con) throws SQLException {
        guardarPaisOrigenBASE(paiori.getPaisOrigenAnexo(),numeroPermiso,paiori.getCodigoAnexo(),paiori.getTipoEnvaseAnexo(),"1",usuario,con);
    }

    private ArrayList<PaisOrigenProductoPFI> obtenerPaisesOrigen(String numero_permiso,
                                                                 Connection con) throws SQLException {
        ArrayList<PaisOrigenProductoPFI> retval = new ArrayList<PaisOrigenProductoPFI>();

        PreparedStatement pst = con.prepareCall(SenasaSQL.OBTENER_PAIS_ORIGEN_PZI);
        logger.debug(" = INICIO OBTENER_PAIS_ORIGEN_PFI= ");
        pst.setString(1, numero_permiso);
       // pst.setString(2, "0");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PaisOrigenProductoPFI aux = new PaisOrigenProductoPFI();
            aux.setPartidaArancelariaProducto(rs.getString(1));
            aux.setCodigoProducto(rs.getString(2));
            aux.setDescripcionProducto(rs.getString(3));
            aux.setNombreCientificoProducto(rs.getString(4));
            aux.setTipoEnvaseProducto(rs.getString(5));
            aux.setPaisOrigenProducto(rs.getString(6));
            aux.setDescPaisOrigenProducto(rs.getString(7));
            retval.add(aux);
        }
        logger.debug(" = FIN OBTENER_PAIS_ORIGEN_PFI= ");

        return retval;
    }

    private ArrayList<PaisOrigenAnexoPFI> obtenerPaisesOrigenAnexo(String numero_permiso,
                                                                   Connection con) throws SQLException {
        ArrayList<PaisOrigenAnexoPFI> retval = new ArrayList<PaisOrigenAnexoPFI>();

        PreparedStatement pst = con.prepareCall(SenasaSQL.OBTENER_PAIS_ORIGEN_PZI);
        Log(" = INICIO OBTENER_PAIS_ORIGEN_PFI= ");
        pst.setString(1, numero_permiso);
        pst.setString(2, "1");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PaisOrigenAnexoPFI aux = new PaisOrigenAnexoPFI();
            aux.setPartidaArancelariaAnexo(rs.getString(1));
            aux.setCodigoAnexo(rs.getString(2));
            aux.setDescripcionAnexo(rs.getString(3));
            aux.setNombreCientificoAnexo(rs.getString(4));
            aux.setTipoEnvaseAnexo(rs.getString(5));
            aux.setPaisOrigenAnexo(rs.getString(6));
            retval.add(aux);
        }
        Log(" = FIN OBTENER_PAIS_ORIGEN_PFI= ");

        return retval;
    }


    public Ampliacion ampliarCertificadoImpoZoo(String noCertificado, String tipo, int cantidad) {
     
      Ampliacion amp= new Ampliacion();       
      //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
      //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoZoosanitarioImportacion();  //PCSM 05/01/2017
      Connection con = null; //PCSM 06/01/2017
      PreparedStatement pst = null;
      CallableStatement cs = null;
      
      logger.debug("noCertificado:"+noCertificado);
      logger.debug("tipo:"+tipo);
      logger.debug("cantidad:"+cantidad);
      
      try{
        con = helper.getConnection();  //PCSM 06/01/2017
         PermisoZoosanitarioImportacion pfi =  obtenerPermisoZoosanitarioImportacion(noCertificado, con);
          
         // el pfi no existe 
          if(pfi==null)
          { 
              amp.setMensaje("No se encontro el Permiso "+noCertificado);
              amp.setAmpliado(false);
              return amp;
          }
        
        // el certificado ya esta ampliado
         if(pfi.isIndicadorAmpliacion()==true)
         {
           logger.debug("isIndicadorAmpliacion esta activado");
           amp.setMensaje("El Permiso "+noCertificado+" ya esta ampliado");
           amp.setAmpliado(true);
           return amp;
         }
          
        // el pfi no tiene fecha de emision 
        if(pfi.getFechaEmision()==null || pfi.getFechaEmision().equals(""))
        {
            
          logger.debug("getFechaDeEmision esta en null");
          amp.setMensaje("El Permiso "+noCertificado+" posee fecha de emision en null");
          amp.setAmpliado(false);
          return amp;
        }    

        String sql =  " { call Pckg_CALCULO_DIAS.Calcular_DIAS(?,?,?,?) } ";
          
        cs = con.prepareCall(sql);
        
        cs.setDate(1,Utility.toSQLDate(pfi.getFechaEmision()));
        cs.setString(2,tipo);
        cs.setInt(3,cantidad);
          
        cs.registerOutParameter(4,OracleTypes.DATE);
          
        logger.debug(" = ANTES DE EJECUTAR = ");
        
        cs.execute();
          
        Date fechaAmpliacion =  Utility.toUtilDate(cs.getDate(4));
          
        logger.debug("fechaAmpliacion:"+fechaAmpliacion);
          
        Date fechaActual = new Date(System.currentTimeMillis()); 
          
        logger.debug("fechaActual:"+fechaActual);
          
        if(fechaActual.compareTo(fechaAmpliacion)>0)
        {
          // long dias=fechaActual.getTime()-fechaAmpliacion.getTime(); 
           
          long diferencia = fechaActual.getTime() - fechaAmpliacion.getTime();
          
          int dias = (int)(Math.floor(diferencia / (1000 * 60 * 60 * 24)));
            
          amp.setMensaje("El Permiso "+noCertificado+" con fecha de emision "+Utility.parseDateToString(pfi.getFechaEmision())
                         +" se encuentra fuera de fecha, con "+dias+" dia(s) de vencimiento");
          
          amp.setAmpliado(false);
          
          return amp;
        }
          
        sql = SenasaSQL.AMPLIAR_PZI;
        
        pst = con.prepareStatement(sql);
          
        pst.setString(1, noCertificado);
        
        pst.executeUpdate();
      
        logger.debug("Se realizo la ampliacion del noCertificado: "+noCertificado);
          
        amp.setAmpliado(true);
        amp.setMensaje("Se realizo la ampliacion del noCertificado: "+noCertificado);
       
      }catch(Exception e)
      {
      
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
    
  public ArrayList<RequisitoDao> obtenerRequisitosSanitariosImpoZoo(String numeroCertificado) {
    
    PermisoZooSanitarioImportacionDAO pzi = new PermisoZooSanitarioImportacionDAO();
    PermisoFitoSanitarioImportacionDAO pfi = new PermisoFitoSanitarioImportacionDAO();
    ArrayList<RequisitoDao> arrRequisitos = null;
    
    logger.debug("Entrando a obtenerRequisitosSanitariosImpoZoo('" + numeroCertificado + "')");
    //PermisoZoosanitarioImportacion obtenerPZIxNoCertificado(String noCertificado)
    try {
              
              PermisoZoosanitarioImportacion objPZI = pzi.obtenerPZIxNoCertificado(numeroCertificado);
              logger.debug("Termino de ejecutar el metodo obtenerPZIxNoCertificado('"+ numeroCertificado + "')");
              ProductoPZI productoPZI;
              ArrayList<ProductoPFI> productoPFI;
              ArrayList<PaisOrigenProductoPFI> paisOrigenProductoPZI;
              ArrayList<LugarProduccionProductoPFI> lugarProduccionProductoPZI;
              
              productoPZI = objPZI.getProductoPZI();
              
              if(!productoPZI.equals(null))
              {
                    String codigoProducto;
                    String codigoAplicacion;
                    String paisProcedencia;
                    String paisOrigen = "0000";
                    String lugarProduccion = "00";
                    
                    logger.debug("Obteniento el codigoProducto, codigoAplicacion y paisProcedencia.");
                    codigoProducto = productoPZI.getCodProducto();
                    codigoAplicacion = productoPZI.getUsoDestino();
                    paisProcedencia = productoPZI.getPaisProcedencia();
                    
                    paisOrigenProductoPZI = objPZI.getPaisesOrigenProductoPZI();
                    logger.debug("Obteniento el Pais de Origen");
                    if(!paisOrigenProductoPZI.equals(null) && paisOrigenProductoPZI.size()>0) {
                      int i;
                      for(i=0;i<paisOrigenProductoPZI.size();i++) {
                          if(paisOrigenProductoPZI.get(i).getCodigoProducto().equals(codigoProducto)) {
                            paisOrigen = paisOrigenProductoPZI.get(i).getPaisOrigenProducto();
                            logger.debug("Obteniento el Lugar de Produccion");
                            if(paisOrigenProductoPZI.get(i).getLugarProduccion()==null)
                              lugarProduccion = "00";
                            else
                              lugarProduccion = paisOrigenProductoPZI.get(i).getLugarProduccion();
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
        Log("obtenerRequisitosSanitariosImpoZoo(String numeroCertificado)", e);
        logger.fatal(e);
    } finally {
        //Datacleanup(con, cs);
    }
      logger.debug("Fin de obtenerRequisitosSanitariosImpoZoo('" + numeroCertificado + "')");
      return arrRequisitos;
  }
  
  public String generarNroCertificado(String sede) {
    
    String sql = SenasaSQL.GENERA_CERTIFICADO_PZI;
    Log("obtenerIdPersona(): AQUI VA EL " + sql);

    //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
    //Connection con = ConnectionSenasa.getSingletonObject().getConnPermisoZoosanitarioImportacion();  //PCSM 05/01/2017
    Connection con = null; //PCSM 06/01/2017
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    String retval = "-1";
  
    try { 
        con = helper.getConnection();  //PCSM 06/01/2017
        cs = con.prepareCall(sql);
        cs.registerOutParameter(1, OracleTypes.VARCHAR);
        cs.setString(2,sede);
        
        cs.execute();
        
        retval = cs.getString(1);
        
        Log(" = TODO FINITO = ");
    } catch (SQLException e) {
        Log("generarNroCertificado", e);
    } catch (Exception e) {
        Log("generarNroCertificado", e);
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
  
  //////////// METODOS VUCE //////////////
  public PermisoZoosanitarioImportacion obtenerDatosPZIVuce(String nroExpediente) {
      PermisoZoosanitarioImportacion retval =new PermisoZoosanitarioImportacion();
      Connection con =null;
      try {
          //con = cnApp.getConnection();
          //con = cnApp.getConnPermisoZoosanitarioImportacion();  //PCSM 05/01/2017
          con = helper.getConnection();  //PCSM 06/01/2017
          logger.debug(" = OBTENER_DATOS_PZI_VUCE INICIO = ");
          //CCODEXP,CREGUNI,CCODSED,CNOMPRE,CCODDEP,CCODPROV,CCODDIST,CDIRECCION
          retval = obtenerPZIxCodExpVuce(nroExpediente, con);
          SolicitanteDAO solDao = new SolicitanteDAO();
          retval.setSolicitante(solDao.obtenerSolicitanteXNumeroCertificadoPZI(retval.getNoCertificado()));
          
          ProductoPZI pzi = obtenerProductoZIxCodExp(retval.getNoCertificado(), con);
          retval.setProductoPZI(pzi);
                 
          ArrayList<PaisOrigenProductoPFI> paisesOrigenProductoPZIVuce = obtenerPaisesOrigenPZIVuce(retval.getNoCertificado(), con); 
          retval.setPaisesOrigenProductoPZI(paisesOrigenProductoPZIVuce);
          
          ArrayList<PuntoIngresoProductoPFI> puntosIngresoProductoPZI = obtenerPuntosIngresoPZIVuce(retval.getNoCertificado(), con);
          retval.setPuntosIngresoProductoPZI(puntosIngresoProductoPZI);
          
          ArrayList<AnexoPFI> list = obtAnexosPZI(retval.getNoCertificado(), con);
          retval.setAnexosPZI(list);
              
          logger.debug(" =OBTENER_DATOS_PZI_VUCE FIN = ");
      } catch (SQLException e) {
          Log("obtenerDatosPZIVuce", e);
        logger.info("Obtener Datos PZI Vuce SQL" + e);          
      } catch (Exception e) {
          Log("obtenerDatosPZIVuce", e);
          logger.info("Obtener Datos PZI Vuce" + e);
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

    private PermisoZoosanitarioImportacion obtenerPZIxCodExpVuce(String nroExpediente,Connection con)throws SQLException {
      String sql = SenasaSQL.OBTENER_DATOS_PZI_X_EXPEDIENTE;
      logger.debug("OBTENER_DATOS_PERMISO_PZI_VUCE INICIO");
      logger.debug(" AQUI VA EL " + sql);
      PreparedStatement pst;
      ResultSet rs;
      PermisoZoosanitarioImportacion retval = null;
      pst = con.prepareStatement(sql);
      pst.setString(1, nroExpediente);
      logger.debug(" = VOY A EJECUTAR SELECT EN OBTENER_DATOS_PZI_VUCE = ");
      rs = pst.executeQuery();
      logger.debug(" = VIENDO RS DE OBTENER_DATOS_PZI_VUCE = ");
      while (rs.next()) {
        retval =new PermisoZoosanitarioImportacion();
        retval.setNoFolio(rs.getString(1));
        retval.setNoCertificado(rs.getString(2));
        retval.setUrlPZIDefinitivo(rs.getString(3));
        retval.setPuntoIngreso(rs.getString(4));
        retval.setFechaProbableIngreso(rs.getDate(5));
        retval.setPuntoSalida(rs.getString(6));
        retval.setFechaProbableSalida(rs.getDate(7));
        retval.setDireccionEjecutiva(rs.getString(8));
        retval.setDescDireccionEjecutiva(rs.getString(9));
        retval.setIndicadorAmpliacion(rs.getString(10)!=null &&(rs.getString(10).equals("Y")||(rs.getString(10).equals("S")))?true:false);
        logger.debug("rs.getDate(11):"+rs.getDate(11));
        retval.setFechaEmision(Utility.toUtilDate(rs.getDate(11)));
        retval.setCodReqImpProducto(rs.getString(12));
      }
      return retval;
    }

    private ArrayList<PuntoIngresoProductoPFI> obtenerPuntosIngresoPZIVuce(String numeroPermiso,
                                                                    Connection con)throws SQLException {
      ArrayList<PuntoIngresoProductoPFI> retval = new ArrayList<PuntoIngresoProductoPFI>();

      logger.debug("===== OBTENER_PUNTOS_INGRESO_PRODUCTO_VUCE Iniciando =====");
      
      String sql = SenasaSQL.OBTENER_PTOS_INGRESO_PRODUCTO_PZI_VUCE;
      logger.debug(" AQUI VA EL " + sql);
      PreparedStatement pst;
      ResultSet rs;
      PuntoIngresoProductoPFI ptoIngreso =null;
      ArrayList<PuntoIngresoProductoPFI> xpuntosIngreso= new ArrayList<PuntoIngresoProductoPFI>();
      
      pst = con.prepareStatement(sql);
      pst.setString(1, numeroPermiso);
      
      logger.debug(" = VOY A EJECUTAR SELECT EN obtenerPuntoIngresosProductoPZIVuce = ");
      rs = pst.executeQuery();
      logger.debug(" = VIENDO RS DE obtenerPuntoIngresosProductoPZIVuce = ");
      
      while(rs.next()){
        ptoIngreso = new PuntoIngresoProductoPFI();
        ptoIngreso.setPuntoIngresoProducto(rs.getString(1));
        ptoIngreso.setDescPuntoIngresoProducto(rs.getString(2));
        xpuntosIngreso.add(ptoIngreso);  
      }
      
      logger.debug("Cantidad de Ptos de Ingreso PZI Obtenidos: "+xpuntosIngreso.size());
      rs.close();
      pst.close();
          
      return xpuntosIngreso;
    }

    private ArrayList<PaisOrigenProductoPFI> obtenerPaisesOrigenPZIVuce(String numeroPermiso,
                                                                        Connection con)throws SQLException {
      logger.debug("===== OBTENER_PAIS_ORIGEN_PRODUCTO_VUCE Iniciando =====");
        
      String sql = SenasaSQL.OBTENER_PAIS_ORIGEN_PRODUCTO_PZI_VUCE;
      logger.debug(" AQUI VA EL " + sql);
      PreparedStatement pst;
      ResultSet rs;
      PaisOrigenProductoPFI paisOrigen=null;
      ArrayList<PaisOrigenProductoPFI> xpaisesOrigen = new ArrayList<PaisOrigenProductoPFI>();

      pst = con.prepareStatement(sql);
      pst.setString(1, numeroPermiso);
           
      logger.debug(" = VOY A EJECUTAR SELECT EN obtenerPaisOrigenProductoPZIVuce = ");
      rs = pst.executeQuery();
      logger.debug(" = VIENDO RS DE obtenerPaisOrigenProductoPZIVuce = ");
      
      while(rs.next()){
        paisOrigen = new PaisOrigenProductoPFI();
        paisOrigen.setPaisOrigenProducto(rs.getString(1));  
        paisOrigen.setDescPaisOrigenProducto(rs.getString(2));
        xpaisesOrigen.add(paisOrigen);
      }
      logger.debug("Cantidad de Paises de Origen PZI Obtenidos: "+xpaisesOrigen.size());
      rs.close();
      pst.close();
      
      return xpaisesOrigen;
    }
}
