package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.CpeGermpGC;
import pe.gob.senasa.bean.EquipoTecnicoCPE;
import pe.gob.senasa.bean.FuncionesEquipoTecnico;
import pe.gob.senasa.bean.LugaresProduccionCPE;
import pe.gob.senasa.bean.ProductosCPE;
import pe.gob.senasa.bean.RegistroCPE;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.RegistroCPEInterface;
import pe.gob.senasa.util.Utility;


public class RegistroCPEDAO extends BaseDAO implements RegistroCPEInterface {

    protected static Logger logger = Logger.getLogger(RegistroCPEDAO.class);
    private DBHelper helper;
    
    public RegistroCPEDAO() {
        super();
        helper = new DBHelper(SenasaSQL.dsRegistroCPE);
    }

 
    /**
     * CABLEADO....
     * @return
     */
    public ArrayList<FuncionesEquipoTecnico> obtenerFuncionesEquipoTecnicoCPE() {
        ArrayList<FuncionesEquipoTecnico> funcionesResult =
            new ArrayList<FuncionesEquipoTecnico>();

        FuncionesEquipoTecnico funcionesEquipotecnico =
            new FuncionesEquipoTecnico();
        funcionesEquipotecnico.setCodFuncionEquipoTecnico("1");
        funcionesEquipotecnico.setFuncionEquipotecnico("responsable");
        funcionesResult.add(funcionesEquipotecnico);

        funcionesEquipotecnico = new FuncionesEquipoTecnico();
        funcionesEquipotecnico.setCodFuncionEquipoTecnico("2");
        funcionesEquipotecnico.setFuncionEquipotecnico("tecnico");
        funcionesResult.add(funcionesEquipotecnico);

        return funcionesResult;
    }
    
    public RegistroCPE obtenerRegistroCPExExpediente(String noExpediente){
      Connection con =null;
      RegistroCPE retval = null;
      
      try{
          con = helper.getConnection();
          retval = new RegistroCPE();
          logger.debug("OBTENER_REGISTRO_CPE_X_EXPEDIENTE Incio");
          
          retval = ObtenerRegistroCPExExpediente(noExpediente, con);
          SolicitanteDAO solDao = new SolicitanteDAO();
          retval.setSolicitante(solDao.obtenerSolicitanteXidPersona(retval.getCodigoPersona()));
          
          ObtenerProductosCPE(con, retval);
          ObtenerEquipoTecnicoCPE(con, retval);
          ObtenerLugaresProduccion(con,retval);
          logger.debug(" = OBTENER_REGISTRO_CPE_X_EXPEDIENTE Finalizado exitosamente = ");
      }catch (SQLException e){
          ManejarExcepcion(con, e);
      }catch (Exception e){
          ManejarExcepcion(con, e);
      }finally {
            cleanup(con, null);
      }
      
      return retval;
    }

    public RegistroCPE obtenerRegistroCPE(String noCertificado){ 
        Connection con=null;
        RegistroCPE retval =null;
        try {
            con = helper.getConnection();        
            retval = new RegistroCPE();
            Log(" = INICIO = ");
            //CCODEXP,CREGUNI,CCODSED,CNOMPRE,CCODDEP,CCODPROV,CCODDIST,CDIRECCION
            retval = ObtenerRegistroCPE(noCertificado, con);
            
            SolicitanteDAO solDao = new SolicitanteDAO();
            retval.setSolicitante(solDao.obtenerSolicitanteXidPersona(retval.getCodigoPersona()));
            
            ObtenerProductosCPE(con, retval);
            ObtenerEquipoTecnicoCPE(con, retval);
            ObtenerLugaresProduccion(con,retval);
            Log(" = TODO FINITO = ");
        } catch (SQLException e) {
            ManejarExcepcion(con, e);
        } catch (Exception e) {
            ManejarExcepcion(con, e);
        } finally {
            cleanup(con, null);
        }
        return retval;
    }
      
    private void ObtenerEquipoTecnicoCPE(Connection con,
                                                      RegistroCPE retval) throws SQLException {
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        sql = SenasaSQL.OBTENER_EQUIPO_TECNICO_CPE;
        pst = con.prepareStatement(sql);
        pst.setString(1, retval.getNoCertificado());
        rs = pst.executeQuery();
        Log(" = va el sql = "+sql);
        ArrayList<EquipoTecnicoCPE> list2 = new ArrayList<EquipoTecnicoCPE>();
        while (rs.next()) {
            EquipoTecnicoCPE cpe = obtEquipoTecnicoCPE(rs);
            list2.add(cpe);
        }
        retval.setEquipoTecnicoCPE(list2);
    }

    private void ObtenerProductosCPE(Connection con,RegistroCPE retval) throws SQLException {
        PreparedStatement pst;
        ResultSet rs;
        String sql = SenasaSQL.OBTENER_PRODUCTOS_CPE;
        pst = con.prepareStatement(sql);
        pst.setString(1, retval.getNoCertificado());
        rs = pst.executeQuery();
        ArrayList<ProductosCPE> list = new ArrayList<ProductosCPE>();
        while (rs.next()) {
            ProductosCPE cpe = obtProductosCPE(rs);
            Log("CONSEGUI PRODUCTO "+cpe.getCodigoProducto());
            list.add(cpe);
        }
        retval.setProductosCPE(list);
    }
    
  public List<CpeGermpGC> obtenerRegistrosCpeGermpGC(String nroDOC,String formato) {
      Log("Registros CPE-Germoplasma-Guardacustodia ********Inicio del Método ********");
      Connection con = null;
      CallableStatement cs = null;
      ResultSet rs = null; 
      String sql = SenasaSQL.OBTENER_PRODUCTOS_CPE_GERMP_GC;
      List<CpeGermpGC> lista =new ArrayList<CpeGermpGC>();
      Log("Registros CPE-Germoplasma-Guardacustodia - SP a ejecutar" + sql);
      try {
        con = helper.getConnection();
        cs = con.prepareCall(sql);        
        cs.setString(1, nroDOC);
        cs.setString(2, formato);
        cs.registerOutParameter(3,OracleTypes.VARCHAR);
        cs.registerOutParameter(4,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
        Log("Registros CPE-Germoplasma-Guardacustodia - Ejecutando SP");  
        cs.executeQuery();
        rs = (ResultSet)cs.getObject(4);
        Log("Registros CPE-Germoplasma-Guardacustodia - Mesaje de retorno " + cs.getString(3));  
        Log("Registros CPE-Germoplasma-Guardacustodia - Listando datos");
        while(rs.next()){
            CpeGermpGC b= new CpeGermpGC();
            b.setTipo(rs.getString(1));
            b.setNumero(rs.getString(2));            
            lista.add(b);
        }
        rs.close();
        Log("Registros CPE-Germoplasma-Guardacustodia - Lista completada");;  
      } catch (SQLException e) {
        Log("Registros CPE-Germoplasma-Guardacustodia- SQLException : ", e);
      } catch (Exception e) {
        Log("Registros CPE-Germoplasma-Guardacustodia - Exception : ", e);
      } finally {
          try{
          if (rs!=null && !rs.isClosed())rs.close();
          }catch(Exception ex){
              Log("Registros CPE-Germoplasma-Guardacustodia - Exception al cerrar resulset: ", ex);
          }
            cleanup(con, cs);
      }
      return lista;
  }
  
    private RegistroCPE ObtenerRegistroCPE(String noCertificado, Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_REGISTRO_CPE;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        RegistroCPE retval = new RegistroCPE();
        pst = con.prepareStatement(sql);
        pst.setString(1, noCertificado);
        Log(" = VOY A EJECUTAR OBTENER_REGISTRO_CPE = ");
        rs = pst.executeQuery();
        Log(" = VIENDO RS DE OBTENER_REGISTRO_CPE = ");
        while (rs.next()) {
            retval = obtRegistroCPE(rs);
            break;
        }
        return retval;
    }
    
    private RegistroCPE ObtenerRegistroCPExExpediente(String noExpediente, Connection con) throws SQLException{
      String sql = SenasaSQL.OBTENER_REGISTRO_CPE_X_EXPEDIENTE;
      logger.debug("Aqui va la sentencia sql: "+sql);
      PreparedStatement pst=null;
      ResultSet rs = null;
      RegistroCPE cpe = null;
      pst = con .prepareStatement(sql);
      pst.setString(1, noExpediente);
      logger.debug("= Se va a ejecutar OBTENER_REGISTRO_CPE_X_EXPEDIENTE");
      rs=pst.executeQuery();
      logger.debug("= Recorriendo rs de  OBTENER_REGISTRO_CPE_X_EXPEDIENTE");
      while(rs.next()){
        cpe= new RegistroCPE();
        cpe.setNoFolio(rs.getString(1));
        cpe.setNoCertificado(rs.getString(2));
        cpe.setSede(rs.getString(3));
        cpe.setCodigoPersona(rs.getString(4));
        cpe.setNombreSede(rs.getString(5));
        cpe.setDireccionSede(rs.getString(6));
        cpe.setUrlRegistroCPE(rs.getString(7)); 
        cpe.setEstado(rs.getString(8));
      }  
      return cpe;  
    }

    /**
     * Registra la cuarentena PostEntrada
     * @param registroCPE
     * @return
     */
    public boolean guardarRegistroCPE(RegistroCPE registroCPE){
      return salvarRegistroCPE(registroCPE);     
    }
    
    public String obtenerCodigoCPE(String codSede){
      logger.debug("OBTENER_CODIGO_CPE");
      Connection con=null;
      CallableStatement cs=null;
      String retval="";
        try {
            con=helper.getConnection();
            String sql =SenasaSQL.OBTENER_CODIGO_CPE;
            logger.debug("AQUI VA EL QUERY: "+sql);
            
            cs=con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.setString(2, codSede);          
            logger.debug("Se va a ejecutar OBTENER_CODIGO_CPE");
            cs.execute();
            logger.debug("Se ejecutó OBTENER_CODIGO_CPE");           
            retval=cs.getString(1);          
            logger.debug("Codigo CPE obtenido: "+retval);
        } catch (SQLException e) {
            Log("obtenerCodigoCPE error", e);
        } catch (Exception e) {
            Log("obtenerCodigoCPE error", e);
        } finally {
            cleanup(con, cs);
        }
        return retval;
    }

    private boolean actualizarRegistroCPE(RegistroCPE registroCPE) {
        Connection con =  null;
        try {
            con = helper.getConnection();
            if (DeleteAll(registroCPE.getNoCertificado(), con))
                return salvarRegistroCPE(registroCPE, con);
            else
                return false;
        } catch (Exception e) {
            ManejarExcepcion(con, e);
        }
        return false;
    }
    
    private boolean salvarRegistroCPE(RegistroCPE registroCPE){
        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        Connection con=null;
        try{
           con = helper.getConnection();
        }catch(Exception e){
            logger.debug("GuardarRegistroCPE error: "+e.getMessage());
        }
       
        return salvarRegistroCPE(registroCPE, con);
    }
    
    public boolean salvarRegistroCPE(RegistroCPE registroCPE,Connection con) {
         
      //  PreparedStatement pst = null;
       // ResultSet rs = null;
        logger.debug("GUARDAR_REGISTRO_CPE - Iniciando -");
        boolean retval = false;
        try {
            Log(" = INICIO salvarRegistroCPE= ");
            
            Log(" Certificado= " + registroCPE.getNoCertificado() + " Folio= "+ registroCPE.getNoFolio());
            Log(" = Guardar CABECERA = " + registroCPE.getNoCertificado() );
            con.setAutoCommit(false);
            guardarCabeceraCPE(registroCPE,con);
            Log(" = VOY A EJECUTAR INSERTs de los productos = ");
            guardarProductosCPE(registroCPE,con);
            Log(" = VOY A EJECUTAR INSERTS  equipo tecnico");
            guardarEquipoTecnico(registroCPE,con);
            Log(" = VOY A EJECUTAR INSERTS  lugares de produccion");
            guardarLugarProduccion(registroCPE,con);
            con.commit();
            con.setAutoCommit(true);
            Log(" = Fin salvarRegistroCPE = ");
            retval = true;
        } catch (SQLException e) {
            ManejarExcepcion(con, e);
        } catch (Exception e) {
            ManejarExcepcion(con, e);
        } finally {
           // Datacleanup(con, pst);
        }
        return retval;
    }

    //cd.ccodexp,cd.creguni,cd.ccodsed,cd.cnompre,cd.cdireccion,cd.ccoddep,cd.ccodprov,cd.ccoddist

    private RegistroCPE obtRegistroCPE(ResultSet rs) throws SQLException {
        RegistroCPE cpe = new RegistroCPE();
        cpe.setNoFolio(rs.getString(1));
        cpe.setNoCertificado(rs.getString(2));
        cpe.setSede(rs.getString(3));
        cpe.setCodigoPersona(rs.getString(4));
        cpe.setNombreSede(rs.getString(5));
        cpe.setDireccionSede(rs.getString(6));
        cpe.setUrlRegistroCPE(rs.getString(7));
        return cpe;
    }

    private ProductosCPE obtProductosCPE(ResultSet rs) throws SQLException {
        //cd.CCODPRO,cd.CCODPAI,cd.CCANTIDAD,cd.PARTE
        ProductosCPE cpe = new ProductosCPE();
        cpe.setSecuencial(rs.getInt(1));
        cpe.setCodigoProducto(rs.getString(2));
        cpe.setOrigen(rs.getString(3));
        cpe.setDescOrigen(rs.getString(4));
        cpe.setCantidad(rs.getDouble(5));
        cpe.setPlanta(rs.getString(6));
        cpe.setNombreCientifico(rs.getString(7));
        cpe.setDescripcion(rs.getString(8));
        cpe.setPartidaArancelaria(rs.getString(9));
        cpe.setFlagVuce(rs.getInt(10));
        return cpe;
    }

    private void ManejarExcepcion(Connection con, Exception e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("guardarRegistroCPE", f);
        }
        Log("guardarRegistroCPE", e);
    }

    private void ManejarExcepcion(Connection con, SQLException e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("guardarRegistroCPE", f);
        }
        Log("guardarRegistroCPE", e);
    }

    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("RegistroCPEDAO - " + s, p2);
    }

    //cd.cpro_tec,cd.cnombre,cd.capellido,cd.cdni 
    private EquipoTecnicoCPE obtEquipoTecnicoCPE(ResultSet rs) throws SQLException {
        //regper.cargo_profesional_tecnico,regper.numero_de_titulo,per.nombres,per.apellido_paterno,per.documento_numero
        EquipoTecnicoCPE eq = new EquipoTecnicoCPE();
        eq.setSecuencial(rs.getInt(1));
        eq.setFuncion(rs.getString(2));
        eq.setTitulo(rs.getString(3));
        eq.setNombre(rs.getString(4));
        eq.setApellido(rs.getString(5));
        eq.setDni(rs.getString(6));
        eq.setPersonaId(rs.getString(7));
        eq.setFlagVuce(rs.getInt(8));
        return eq;
    }

    private void guardarCabeceraCPE(RegistroCPE registroCPE, Connection con) throws SQLException {
        //con.setAutoCommit(false);
        CallableStatement cs = con.prepareCall(SenasaSQL.INGRESAR_CPE);
        cs.setString(1, registroCPE.getNoCertificado());
        cs.setString(2, registroCPE.getNoFolio());
        cs.setString(3, registroCPE.getCodigoPersona());
        cs.setString(4, registroCPE.getSede());
        cs.setString(5, registroCPE.getUrlRegistroCPE());
        cs.setString(6, registroCPE.getUsuario());
        cs.setString(7, registroCPE.getEstado());
        cs.setDate(8, Utility.toSQLDate(registroCPE.getFechaEmision()));            
        Log(" = VOY A EJECUTAR INGRESAR_CPE = ");
        cs.execute();
        Log(" = EJECUTE INGRESAR_CPE = ");
    }

    private void guardarProductosCPE(RegistroCPE registroCPE,Connection con) throws SQLException {
        CallableStatement cs = con.prepareCall(SenasaSQL.INGRESAR_PRODUCTO_CPE);
        //(codigo_cpe,codigo_producto,codi_pais_tpa,cantidad_producto,parte_planta)
        //int secuencial=0;
        for (ProductosCPE cpe : registroCPE.getProductosCPE()) {
            if(cpe != null){
                logger.debug("Codigo_CPE: "+registroCPE.getNoCertificado());
                logger.debug("Secuencial: "+cpe.getSecuencial());
                cs.setString(1, registroCPE.getNoCertificado());
                cs.setInt(2, cpe.getSecuencial());
                cs.setString(3, cpe.getOrigen());
                cs.setString(4, registroCPE.getSede());
                cs.setString(5, cpe.getCodigoProducto());
                cs.setDouble(6, cpe.getCantidad());
                cs.setString(7, cpe.getPlanta());
                cs.setString(8, registroCPE.getUsuario());
                cs.setDate(9, null);//Fecha de Addenda por aclarar
                cs.setInt(10, cpe.getFlagVuce());
                logger.debug(" = VOY A EJECUTAR  INGRESAR_PRODUCTO_CPE = ");
                cs.execute();
                logger.debug(" = EJECUTE INGRESAR_PRODUCTO_CPE = ");
            }
        }
    }

    private void guardarEquipoTecnico(RegistroCPE registroCPE,
                                      Connection con) throws SQLException {
        PreparedStatement pst = con.prepareCall(SenasaSQL.INGRESAR_EQUIPO_TECNICO_CPE);
        
        //insert into registro_cpe_fito_persona (codigo_cpe,persona_id,cargo_profesional_tecnico,numero_de_titulo) values (?,?,?,?)
        SolicitanteDAO daoPer = new SolicitanteDAO();
        for (EquipoTecnicoCPE tecCpe : registroCPE.getEquipoTecnicoCPE()) {
            logger.debug("Codigo_CPE: "+registroCPE.getNoCertificado());
            logger.debug("Secuencial: "+tecCpe.getSecuencial());
            if(tecCpe != null){            
                if (tecCpe.getPersonaId()==null || tecCpe.getPersonaId().isEmpty())
                  tecCpe.setPersonaId(daoPer.guardarObtenerPersona(tecCpe.getDni(), tecCpe.getNombre(), tecCpe.getApellido(),con));
                logger.debug("Codigo Persona "+tecCpe.getPersonaId());
                pst.setString(1, registroCPE.getNoCertificado());
                pst.setInt(2, tecCpe.getSecuencial());
                pst.setString(3, tecCpe.getFuncion());
                pst.setString(4, registroCPE.getSede());
                pst.setString(5, tecCpe.getTitulo());//numero de titulo
                pst.setString(6, tecCpe.getPersonaId());
                pst.setString(7, null); // no se utiliza en el SP
                pst.setString(8, registroCPE.getUsuario());
                pst.setString(9, tecCpe.getIndicadorAceptacion());//indicador de aceptacion
                pst.setString(10, tecCpe.getObservacion());//observacion
                pst.setDate(11, null);//fecha de Addenda
                pst.setInt(12, tecCpe.getFlagVuce());//fecha de Addenda
                Log(" = VOY A EJECUTAR INGRESAR_EQUIPO_TECNICO_CPE");
                pst.execute();
                Log(" = EJECUTE INGRESAR_EQUIPO_TECNICO_CPE");
            }
        }
    }

    private void guardarLugarProduccion(RegistroCPE registroCPE,
                                        Connection con) throws SQLException {
        CallableStatement cs = con.prepareCall(SenasaSQL.INGRESAR_LUGAR_PRODUCCION_CPE);     
        for (LugaresProduccionCPE lugCpe : registroCPE.getLugaresProduccionCPE()) {
            if(lugCpe != null){
                logger.debug("Codigo_CPE: "+registroCPE.getNoCertificado());
                logger.debug("Secuencial: "+lugCpe.getSecuencial());
                cs.setString(1, registroCPE.getNoCertificado());
                cs.setInt(2, lugCpe.getSecuencial());
                cs.setString(3, lugCpe.getDepartamento());
                cs.setString(4, lugCpe.getProvincia());
                cs.setString(5, lugCpe.getDistrito());
                cs.setString(6, lugCpe.getNombre());
                cs.setString(7, registroCPE.getSede());//Codigo Centro Tramite Predio por aclarar
                cs.setString(8, lugCpe.getDireccion());
                cs.setString(9, lugCpe.getTipoPredio());//Tipo predio
                cs.setDouble(10, lugCpe.getArea());
                cs.setString(11, registroCPE.getUsuario());
                cs.setDate(12, Utility.toSQLDate(lugCpe.getFechaInspeccion())); //fecha inspeccion
                cs.setString(13, lugCpe.getIndicadorAcpt());
                cs.setString(14, registroCPE.getSede());
                cs.setString(15, lugCpe.getIndicadorAcpt()=="N"?"S":"N");//indicador de reinspeccion
                cs.setString(16, null);  // No se utiliza en el SP
                cs.setDate(17, null);//fecha de reinspeccion
                cs.setString(18, lugCpe.getObservacion());
                cs.setString(19, lugCpe.getRecomendacion());//Recomendacion
                cs.setDate(20, null);//Fecha de Addenda
                cs.setInt(21, lugCpe.getFlagVuce());
                logger.debug(" = VOY A EJECUTAR INGRESAR_LUGAR_PRODUCCION_CPE");
                cs.execute();
                logger.debug(" = EJECUTE INGRESAR_LUGAR_PRODUCCION_CPE");
            }
        }
    }

    private void ObtenerLugaresProduccion(Connection con, RegistroCPE retval) throws SQLException {
        
        PreparedStatement pst;
        ResultSet rs;
        String sql = SenasaSQL.OBTENER_LUGARES_PRODUCCION_CPE;
        pst = con.prepareStatement(sql);
        pst.setString(1, retval.getNoCertificado());
        rs = pst.executeQuery();
        ArrayList<LugaresProduccionCPE> list = new ArrayList<LugaresProduccionCPE>();
        while (rs.next()) {
            LugaresProduccionCPE cpe = obtLugaresProduccionCPE(rs);
            list.add(cpe);
        }
        retval.setLugaresProduccionCPE(list);       
    }

    private LugaresProduccionCPE obtLugaresProduccionCPE(ResultSet rs) throws SQLException {
        LugaresProduccionCPE lugpe = new LugaresProduccionCPE();
        lugpe.setSecuencial(rs.getInt(1));
        lugpe.setNombre(rs.getString(2));
        lugpe.setDireccion(rs.getString(3));
        lugpe.setArea(rs.getDouble(4));
        lugpe.setDepartamento(rs.getString(5));
        lugpe.setProvincia(rs.getString(6));
        lugpe.setDistrito(rs.getString(7));
        lugpe.setDescDepartamento(rs.getString(8));
        lugpe.setDescProvincia(rs.getString(9));
        lugpe.setDescDistrito(rs.getString(10));
        lugpe.setFlagVuce(rs.getInt(11));
        lugpe.setTipoPredio(rs.getString(12));
        return lugpe;
    }
    
    

    private boolean ExisteNumerosCertificados(String noCertificado) {
        Connection con = null;
        boolean retval = false;
        try {
            con = helper.getConnection();
            PreparedStatement pst = con.prepareCall(SenasaSQL.BUSCAR_CPE_NO_CERTIFICADO);
            Log(" = INICIO BUSCAR_CPE_NO_CERTIFICADO= ");
            pst.setString(1, noCertificado);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) >= 1)
                    retval = true;
                else
                    retval = false;
                break;
            }
            Log(" = FIN BUSCAR_CPE_NO_CERTIFICADO= ");
        } catch (SQLException e) {
            ManejarException(con, e);
        } catch (Exception e) {
            ManejarException(con, e);
        } finally {
            cleanup(con, null);
        }
        return retval;
    }
    
    private void ManejarException(Connection con, Exception e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("registroCPE", f);
        }
        Log("registroCPE", e);
    }


    private boolean DeleteAll(String noCert, Connection con) throws SQLException {
        boolean retval = false;

            Log(" = INICIO = ");
            //con.setAutoCommit(false);
            Log(" = ELIMINAR_LUGAR_PRODUCCION_CPE = "+ExecuteQuery(noCert, SenasaSQL.ELIMINAR_LUGARES_PRODUCCION_CPE,con));
            Log(" = ELIMINAR_EQUIPO_TECNICO = "+ExecuteQuery(noCert, SenasaSQL.ELIMINAR_EQUIPO_TECNICO_CPE,con));
            Log(" = ELIMINAR_PRODUCTOS__CPE = "+ExecuteQuery(noCert, SenasaSQL.ELIMINAR_PRODUCTOS_REGISTRO_CPE,con));
            Log(" = ELIMINAR_EXPEDIENTE_CPE = "+ExecuteQuery(noCert, SenasaSQL.ELIMINAR_REGISTRO_CPE,con));
            Log(" = LISTO ELIMINAR = ");
            //con.commit();
            //con.setAutoCommit(true);
            retval = true;
        
        return retval;
    }
    
    private int ExecuteQuery(String noExp,String sql,
                              Connection con) throws SQLException {
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, noExp);
        return pst.executeUpdate();
    }
}
