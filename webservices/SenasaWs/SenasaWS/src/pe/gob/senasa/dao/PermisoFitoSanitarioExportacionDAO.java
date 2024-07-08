package pe.gob.senasa.dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.CertificadoExpoFito;
import pe.gob.senasa.bean.DetalleSIIMF;
import pe.gob.senasa.bean.ProcedimientosEspecificosProductoExpoFito;
import pe.gob.senasa.bean.ProductoExpoFito;
import pe.gob.senasa.bean.SIIMF;
import pe.gob.senasa.bean.SolicitudExportacion;
import pe.gob.senasa.bean.VariedadProducto;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.dbtypes.ListaGenerica;
import pe.gob.senasa.dbtypes.MuestraLaboratorioAnimal;
import pe.gob.senasa.dbtypes.ProductoExpoFitoDB;
import pe.gob.senasa.dbtypes.SolicitudSiimf;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.PermisoFitoSanitarioExportacionInterface;
import pe.gob.senasa.util.Utility;


//import pe.gob.senasa.bean.PermisoFitosanitarioImportacion;


public class PermisoFitoSanitarioExportacionDAO extends BaseDAO implements PermisoFitoSanitarioExportacionInterface {
    
  protected static Logger logger =
      Logger.getLogger(PermisoFitoSanitarioImportacionDAO.class);
  //ConectionApp cnApp =null;
  private DBHelper helper;
  
    public PermisoFitoSanitarioExportacionDAO() {
        super();
      //cnApp= new ConectionApp();
      helper = new DBHelper(SenasaSQL.DATA_SOURCE_PERMFITOEXPO);
    }

  private void Log(String s) {
      logger.debug(s);
  }

  private void Log(String s, java.lang.Throwable p2) {
      logger.fatal("PermisoFitoSanitarioExportacionDAO - " + s, p2);
  }
    public boolean guardarRequisitoFitosanitarioImpoFito() {
        return false;
    }

    public boolean validarAnalisisTratamientoRequisitosExpoFito() {
        return false;
    }

    public boolean validarNumeroCertificadoPlantaTratamientoEmpaque(int numeroCertificadoPlantaTratamientoEmpaque) {
        return false;
    }

    public void obtenerPuntosLlegadaExportacionPorPais(String paisDestino) {
    }

    public void obtenerVariedadCultivar() {
    }

    public void obtenerMarcaDistintiva() {
    }

    public void obtenerCaminoProductoExpoFito() {
    }

    public boolean servicioSIIMFLugarProduccionEmpacadoraCertificada() {
        return false;
    }

    public boolean servicioAnalisisLaboratorio() {
        return false;
    }

    public boolean servicioPagoReembolso(int NumeroCertificadoNoEmitido) {
        return false;
    }

    public boolean validarTicketBalanza() {
        return false;
    }

    public boolean servicioSIIMFProcedimientosEspecificos() {
        return false;
    }
    
    public ArrayList<SolicitudExportacion> obtenerSolicitudExportacion(String codigoCertificado){
      String sql = SenasaSQL.OBTENER_SOLICITUD_EXPORTACION;
      Log(" AQUI VA EL " + sql);

      Connection con = null;
      CallableStatement cs = null;
      ResultSet rs = null;

      ArrayList<SolicitudExportacion> retval = new ArrayList<SolicitudExportacion>();
      try {
          //con=cnApp.getConnection();
          //con=cnApp.getConnPermisoFitoSanitarioExportacion();  //05/01/2017
          con = helper.getConnection();  //PCSM 06/01/2017
          cs = con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          cs.setString(1, codigoCertificado);
          cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
          cs.execute();
          Log(" = ENTRANDO = ");  
          rs = (ResultSet)cs.getObject(2);
          while (rs.next()) {
              SolicitudExportacion serv = new SolicitudExportacion();
              serv.setCodigoSolExpo(rs.getString(1));
              serv.setMarcDistSol(rs.getString(2));
              serv.setCrazSoc(rs.getString(3));
              serv.setDireccionCliente(rs.getString(4));
              serv.setRazonSocial(rs.getString(5));
              serv.setNumeCertExp(rs.getString(6));
              retval.add(serv);
          }
          Log(" = FIN TODITO = ");
      } catch (SQLException e) {
          Log("obtenerSolicitudExportacion", e);
      } catch (Exception e) {
          Log("obtenerSolicitudExportacion", e);
      } finally {
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
 
  public ArrayList<VariedadProducto> obtenerVariedadExportacion(String codigoProducto){
    String sql = SenasaSQL.OBTENER_VARIEDAD_EXPORTACION;
    Log(" AQUI VA EL " + sql);

    Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();    
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<VariedadProducto> retval = new ArrayList<VariedadProducto>();
    try {
        //con=cnApp.getConnection();
        //con=cnApp.getConnPermisoFitoSanitarioExportacion();  //05/01/2017
        con = helper.getConnection();  //PCSM 06/01/2017
        cs = con.prepareCall(sql);
        
        Log(" = ANTES DE EJECUTAR = ");
        cs.setString(1, codigoProducto);
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(2);
        while (rs.next()) {
            VariedadProducto serv = new VariedadProducto();
            serv.setCodHosp(rs.getString(1));
            serv.setCodCult(rs.getString(2));
            serv.setNombreVariedad(rs.getString(3));
            serv.setDescripcionVariedad(rs.getString(4));
            retval.add(serv);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerVariedadExportacion", e);
    } catch (Exception e) {
        Log("obtenerVariedadExportacion", e);
    } finally {
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
  public ArrayList<RequisitoDao> obtenerRequisitosSanitariosExpoFito(String codigoProducto, String codigoAplicacion,
                                                                     String paisProcedencia, String paisesOrigen, 
                                                                     String lugaresProduccion) {
      
    //String aCodProductos,String aCodPaises,String codPaisProcedencia,String aCodLugProduccion,String codAplicaicion
                                                                                                         
      logger.debug(" = Inicio del Método  obtenerRequisitosSanitariosExpoFito");      
      String sql = SenasaSQL.OBTENER_REQUISITOS_EXPOFITO;
      Connection con =null;
      CallableStatement cs = null;
      ResultSet rs2 =null;
      ArrayList<RequisitoDao> retval = new ArrayList<RequisitoDao>();
      
      try {
          //con=cnApp.getConnection();
          //con=cnApp.getConnPermisoFitoSanitarioExportacion();  //05/01/2017
          con = helper.getConnection();  //PCSM 06/01/2017
          logger.debug("productos:"+codigoProducto);
          logger.debug("paisesOrigen:"+paisesOrigen);
          logger.debug("lugaresProduccion:"+lugaresProduccion);
          logger.debug("paisProcedencia:"+paisProcedencia);
          logger.debug("codigoAplicacion:"+codigoAplicacion);
          
          if(lugaresProduccion.equals(null) || lugaresProduccion.trim()=="" || lugaresProduccion.equals("null")){
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
          cs.registerOutParameter(7,OracleTypes.ARRAY,RequisitoDao.SQL_TYPE_ARRAY);
          logger.debug(" Ejecutando SP"); 
          cs.execute();          
          Array requisitos = cs.getArray(7);
          
          if (requisitos == null)          {
              logger.debug(" No existen requisitos sanitarios");
              return new ArrayList<RequisitoDao>();
          }
          
        rs2 = requisitos.getResultSet();
          
        while (rs2.next()) {               
            STRUCT rowStruct = (STRUCT) rs2.getObject(2); 
            Object[] cols = rowStruct.getAttributes(); 
            RequisitoDao requisito = new RequisitoDao();
            requisito.setOrden(cols[0] == null ? null:cols[0].toString());
            requisito.setEtiqueta(cols[1] == null ? null:cols[1].toString());
            requisito.setSangria(cols[2] == (null) ? null:cols[2].toString());
            requisito.setClase(cols[3] == (null) ? null:cols[3].toString());
            requisito.setDescripcionRequisito(cols[4] == (null) ? null:cols[4].toString());
            requisito.setCodigoRequisito(cols[5] == (null) ? null:cols[5].toString());
            retval.add(requisito);
        }             
        logger.debug("obtenerRequisitosSanitariosExpoFito retornando requisitos sanitarios ");
      } catch (Exception e) {
         logger.info("Error en el método obtenerRequisitosSanitariosExpoFito", e);
      } finally {
        //cleanup(con, cs, rs2);
        //PCSM 06/01/2017
          try {
              helper.cleanup(con, cs, rs2);
          } catch (Exception e) {
              e.printStackTrace();
          }  
      }
      return retval;
  }

    public ProcedimientosEspecificosProductoExpoFito obtenerProcedimientosEspecificosProductoExpoFito(String codigoProducto,
                                                                                                      String codigoPaisDestino,
                                                                                                      String codigoDepartamento)
    {
        ProcedimientosEspecificosProductoExpoFito retval= null;
        
        logger.debug(" = INICIO obtenerProcedimientosEspecificosProductoExpoFito = ");
         
         String sql = SenasaSQL.OBTENER_PROCEDIMIENTOS_ESPECIFICOS;
         Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
         CallableStatement cs = null;
        
        try{
            //con=cnApp.getConnection();  
            //con=cnApp.getConnPermisoFitoSanitarioExportacion();  //05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            cs = con.prepareCall(sql);
            cs.setString(1, codigoProducto);
            cs.setString(2, codigoPaisDestino);
            cs.setString(3, codigoDepartamento);
            cs.registerOutParameter(4,  Types.VARCHAR);
            cs.registerOutParameter(5,  Types.VARCHAR);
            
            cs.execute();
            
            retval = new ProcedimientosEspecificosProductoExpoFito();
            
            retval.setTipoCertificado(cs.getString(4));
            
            retval.setProcedimientoEspecifico(cs.getString(5));
            
            
        }catch(Exception e){
             Log("obtenerProcedimientosEspecificosProductoExpoFito", e);
        }
        finally {
          //cleanup(con, cs, null);
          //PCSM 06/01/2017
          try {
              helper.cleanup(con, cs, null);
          } catch (Exception e) {
              e.printStackTrace();
          }  
        }
        
        return retval;
    }
  

    /***
     * @since 28Jul2011
     * @author dvasquez / Omar García
     */
     public CertificadoExpoFito consultaCertificadoExpoFitoXNumeroExpediente(String numeroExpediente){
        CertificadoExpoFito certificadoExpoFito= null;
        
        logger.debug("Exp ="+ numeroExpediente + " *********** Inicio del método consultaCertificadoExpoFitoXNumeroExpediente *********** ");
         
         String sql = SenasaSQL.CONSULTAR_CERTIFICADO_EXPO_FITO;
         Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
         CallableStatement cs = null;
         ResultSet rs = null;
        logger.debug("Exp ="+ numeroExpediente + " Sp a consultar  "  +  sql);
        try{
            //con=cnApp.getConnection();
           // con=cnApp.getConnPermisoFitoSanitarioExportacion();  //05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            cs = con.prepareCall(sql);
        
            cs.setString(1, numeroExpediente);
            cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
            cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
            cs.registerOutParameter(4,OracleTypes.CURSOR,"SYS_REFCURSOR");
            logger.debug("Exp ="+ numeroExpediente + " Antes de ejecutar");
            cs.execute();
            logger.debug("Exp ="+ numeroExpediente + " Sp ejecutado");
            
            // datos del certificado
            rs = (ResultSet)cs.getObject(2);
            
            logger.debug("Exp ="+ numeroExpediente + " leer datos de retorno - Cursor 1 de 3 - Datos del certificado");
            while (rs.next()){
                certificadoExpoFito = new CertificadoExpoFito();
                
                certificadoExpoFito.setCodigoCentroTramite(rs.getString("codigo_centro_tramite_solicita"));//Codigo_Centro_Tramite_Solicita   
                certificadoExpoFito.setNombreCentroTramite(rs.getString("desc_centro_tramite_solicita"));//Desc_Centro_Tramite_Solicita
                certificadoExpoFito.setCodigoCentroTramiteSalida(rs.getString("codigo_centro_tramite_salida")); //Codigo_Centro_Tramite_Salida
                certificadoExpoFito.setNombreCentroTramiteSalida(rs.getString("desc_centro_tramite_salida"));//Desc_Centro_Tramite_Salida
                certificadoExpoFito.setCodigoCertificadoExpoFito(rs.getString("codigo_certificado_fito_expo"));
                certificadoExpoFito.setCodigoDepartamento(rs.getString("codi_depa_dpt"));//Codi_Depa_Dpt
                certificadoExpoFito.setNombreDepartamento(rs.getString("nomb_dpto_dpt"));
                certificadoExpoFito.setCodigoDistrito(rs.getString("codi_dist_tdi"));
                certificadoExpoFito.setNombreDistrito(rs.getString("nomb_dist_tdi"));
                certificadoExpoFito.setCodigoExpediente(rs.getString("codigo_expediente"));
                certificadoExpoFito.setCodigoImportador(rs.getString("codigo_importador"));
                certificadoExpoFito.setNombreImportador(rs.getString("nombre_importador"));
                certificadoExpoFito.setCodigoLugarInspeccion(rs.getString("codigo_lugar_inspeccion"));
                certificadoExpoFito.setNombreLugarInspeccion(rs.getString("nombre_lugar_inspeccion"));
                certificadoExpoFito.setCodigoMedioTransporte(rs.getString("codigo_medio_transporte"));
                certificadoExpoFito.setNombreMedioTransporte(rs.getString("descripcion_medio_transporte"));
                certificadoExpoFito.setCodigoPaisDestino(rs.getString("codi_pais_tpa_destino"));
                certificadoExpoFito.setNombrePaisDestino(rs.getString("nomb_pais_tpa_destino"));//
                certificadoExpoFito.setCodigoPaisOrigen(rs.getString("codi_pais_tpa_origen"));//Codi_Pais_Tpa_Origen
                certificadoExpoFito.setNombrePaisOrigen(rs.getString("nomb_pais_tpa_origen"));//Nomb_Pais_Tpa_Origen
                certificadoExpoFito.setCodigoProvincia(rs.getString("codi_prov_tpr"));
                certificadoExpoFito.setNombreProvincia(rs.getString("nomb_prov_tpr"));
                certificadoExpoFito.setCodigoPuerto(rs.getString("codigo_puerto"));
                certificadoExpoFito.setNombrePuerto(rs.getString("descripcion_puerto"));
                certificadoExpoFito.setEstado(rs.getString("estado"));
                certificadoExpoFito.setFechaDesembarque(Utility.toUtilDate(rs.getDate("fecha_desembarque")));
                certificadoExpoFito.setFechaEmbarque(Utility.toUtilDate(rs.getDate("fecha_embarque")));
                certificadoExpoFito.setFechaEmision(Utility.toUtilDate(rs.getDate("fecha_emision")));//Fecha_Emision
                certificadoExpoFito.setFechaEntrega(Utility.toUtilDate(rs.getDate("fecha_entrega")));
                certificadoExpoFito.setHoraEmision(Utility.toUtilDate(rs.getDate("hora_emision")));
                certificadoExpoFito.setLugarProduccion(rs.getString("lugar_produccion"));
                certificadoExpoFito.setDescripcionLugarProduccion(rs.getString("descripcion_lugar_produccion"));
                certificadoExpoFito.setNumeroCertificado(rs.getString("numero_certificado"));
                certificadoExpoFito.setObservacion(rs.getString("observacion"));                
            }
            
            if(certificadoExpoFito==null){
                logger.debug("Exp ="+ numeroExpediente + " No existe data de retorno");
                return certificadoExpoFito;
            }  
            if (!rs.isClosed()){
                logger.debug("Exp ="+ numeroExpediente + " Cerrando primer ResulSet");
                rs.close();
                rs=null;
            }
            // datos de los productos
            rs = (ResultSet)cs.getObject(3);
            ArrayList<ProductoExpoFito> arrayList =new  ArrayList<ProductoExpoFito>();
            
            ProductoExpoFito producto = null;
            logger.debug("Exp ="+ numeroExpediente + " leer datos de retorno - Cursor 2 de 3 - Datos de producto");
            while (rs.next())
            {
                producto = new ProductoExpoFito();                
                producto.setCantidadEnvase(rs.getString("cantidad_envase")); 
                producto.setCantidadPeso(rs.getString("cantidad_peso"));//Cantidad_Peso
                producto.setCodiUnidMed(rs.getString("codi_unid_med"));
                producto.setDesUnidadMedia(rs.getString("desc_unid_med"));
                producto.setCodigoCertificadoFitoExpo(rs.getString("codigo_certificado_fito_expo"));
                producto.setCodigoProducto(rs.getString("codigo_producto"));//Codigo_Producto
                producto.setPartidaArancelaria(rs.getString(9));
                producto.setNombreComun(rs.getString("nombre_comercial_producto"));//Nombre_Comercial_Producto
                producto.setNombreCientifico(rs.getString("nombre_cientifico_producto"));//Nombre_Cientifico_Producto
                producto.setCodigoTipoEnvase(rs.getString("codigo_tipo_envase")); //Codigo_Tipo_Envase
                producto.setDesTipoEnvase(rs.getString("descripcion_tipo_envase"));//Descripcion_Tipo_Envase
                producto.setCultivarId(rs.getString("cultivar_id"));
                producto.setEstado(rs.getString("estado"));
                producto.setMarcaDistintiva(rs.getString("marca_distintiva"));
                producto.setPersonaId(rs.getString("persona_id"));
                producto.setSecuencialProducto(rs.getString("secuencial_producto"));
                
                arrayList.add(producto);
            }
            
          if (!rs.isClosed()){
              logger.debug("Exp ="+ numeroExpediente + " Cerrando Segundo ResulSet");
              rs.close();
              rs=null;
          }
            // datos de los productos anexos
            rs = (ResultSet)cs.getObject(4);
            logger.debug("Exp ="+ numeroExpediente + " leer datos de retorno - Cursor 2 de 3 - Datos de Anexo del producto");
            while (rs.next()){
                producto = new ProductoExpoFito();
                
                producto.setCantidadEnvase(rs.getString("cantidad_envase"));
                producto.setCantidadPeso(rs.getString("cantidad_peso"));
                producto.setCodiUnidMed(rs.getString("codi_unid_med"));
                producto.setDesUnidadMedia(rs.getString("desc_unid_med"));
                producto.setCodigoCertificadoFitoExpo(rs.getString("codigo_certificado_fito_expo"));
                producto.setCodigoProducto(rs.getString("codigo_producto"));
                producto.setPartidaArancelaria(rs.getString(9));
                producto.setNombreComun(rs.getString("nombre_comercial_producto"));
                producto.setNombreCientifico(rs.getString("nombre_cientifico_producto"));
                producto.setCodigoTipoEnvase(rs.getString("codigo_tipo_envase"));
                producto.setDesTipoEnvase(rs.getString("descripcion_tipo_envase"));
                producto.setCultivarId(rs.getString("cultivar_id"));
                producto.setEstado(rs.getString("estado"));
                producto.setMarcaDistintiva(rs.getString("marca_distintiva"));
                producto.setPersonaId(rs.getString("persona_id"));
                producto.setSecuencialProducto(rs.getString("secuencial_producto"));
                producto.setCodigoProductoPadre(rs.getString("codigo_producto_padre"));
                
                arrayList.add(producto);
            }
            
            if (!rs.isClosed()){
                logger.debug("Exp ="+ numeroExpediente + " Cerrando tercer ResulSet");
                rs.close();
                rs=null;
            }
            certificadoExpoFito.setListaProductos(arrayList);
            
            logger.debug("Exp ="+ numeroExpediente + " FIN TODITO = ");
            
        } catch (SQLException e) {
          logger.debug("Exp ="+ numeroExpediente + " Error SqlException = ", e);
        }catch(Exception e)
        {
            logger.debug("Exp ="+ numeroExpediente + " Error Exception = ", e);
        }
        finally {
          logger.debug("Exp ="+ numeroExpediente + " *********** Fin del método consultaCertificadoExpoFitoXNumeroExpediente *********** ");
          //cleanup(con, cs, null);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return certificadoExpoFito;
    }

    public boolean ejecutarSIIMF(SIIMF siimf) {
        
        boolean ejecucionExitosa = true;
        
        logger.debug(" = INICIO ejecutarSIIMF = ");
         
         String sql = SenasaSQL.EJECUTAR_SIIMF;
         Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
         CallableStatement cs = null;
        ArrayList list = new ArrayList();    
        try{
            //con=cnApp.getConnection();
            //con=cnApp.getConnPermisoFitoSanitarioExportacion();  //05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            cs = con.prepareCall(sql);   
            
            SolicitudSiimf sls = new SolicitudSiimf(siimf);            
            cs.setObject(1, sls);                        
            cs.setString(2,siimf.getCodigoCentroTramite());            
            
            Map types = con.getTypeMap();            
            ListaGenerica tipoListaProductos = new ListaGenerica(list);            
            tipoListaProductos.setSqlName(MuestraLaboratorioAnimal.SQL_TYPE_ARRAY);            
            types.put(tipoListaProductos.getSqlName(), ListaGenerica.class);                        
            
            cs.setObject(3,tipoListaProductos);
            
            cs.execute();
            
        } catch (SQLException e) {
            Log("ejecutarSIIMF", e);
            ejecucionExitosa   = false;
        }catch(Exception e){
            Log("ejecutarSIIMF", e);
            ejecucionExitosa   = false;
        }
        finally {
          //cleanup(con, cs, null);
          //PCSM 06/01/2017
          try {
              helper.cleanup(con, cs, null);
          } catch (Exception e) {
              e.printStackTrace();
          }  
        }    
        
        return ejecucionExitosa;
    }

    public SIIMF respuestaSIIMF(String numeroExpediente) {
        
        SIIMF siimf = null;
        
        logger.debug(" = INICIO respuestaSIIMF = ");
         
         String sql = SenasaSQL.RESPUESTA_SIIMF;
         Connection con =null;
         CallableStatement cs = null;
         ResultSet rs = null;
        
        try{ 
            //con=cnApp.getConnection();
            //con=cnApp.getConnPermisoFitoSanitarioExportacion();  //05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            
            cs = con.prepareCall(sql);            
            cs.setString(1, numeroExpediente);
            cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
            cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
            
            cs.execute();
            
            Log(" = ENTRANDO = ");  
            
            // datos del cabecera
            rs = (ResultSet)cs.getObject(2);
            
            siimf = new SIIMF();
            
            while (rs.next())
            {
                
                siimf.setCodigoExpediente(rs.getString("codigo_expediente"));
                siimf.setCodigoImportador(rs.getString("codigo_importador"));
                siimf.setCodigoPaisDestino(rs.getString("codigo_pais_destino"));
                siimf.setCodigoProductoQuimico(rs.getString("codigo_producto_quimico"));
                siimf.setCodigoSolicitud(rs.getString("codigo_solicitud"));
                siimf.setDeclaracionAdicional(rs.getString("declaracion_adicional"));
                siimf.setDireccionImportador(rs.getString("direccion_importador"));
                siimf.setDosisTratamiento(rs.getString("direccion_importador"));
                siimf.setFechaTratamiento(Utility.toUtilDate(rs.getDate("fecha_tratamiento")));
                siimf.setInformacionAdicional(rs.getString("informacion_adicional"));
                siimf.setNombreImportador(rs.getString("nombre_importador"));
                siimf.setNombrePaisDestino(rs.getString("nombre_pais_destino"));
                siimf.setNombreProductoQuimico(rs.getString("nombre_producto_quimico"));
                siimf.setNombreTratamiento(rs.getString("nombre_tratamiento"));
                siimf.setPuntoLlegada(rs.getString("punto_llegada"));
                siimf.setPuntoSalida(rs.getString("punto_salida"));
                siimf.setTemperaturaTratamiento(rs.getString("temperatura_tratamiento"));
                
            }
            
            // datos detalle SIIMF
            rs = (ResultSet)cs.getObject(3);
            
            ArrayList<DetalleSIIMF> lista = new ArrayList<DetalleSIIMF>();            
            DetalleSIIMF e = null;            
            while (rs.next()){
                e = new DetalleSIIMF();                
                e.setCantEnvaPla(rs.getString("cant_enva_pla"));
                e.setCodigoProducto(rs.getString("codigo_producto"));
                e.setPesoEnvaPla(rs.getString("peso_enva_pla"));
                e.setUnidadMedida(rs.getString("unidad_medida"));
                
                lista.add(e);
            }
            
            siimf.setListaDetalleSIIMF(lista);
            
        } catch (SQLException e) {
            Log("respuestaSIIMF", e);
        }catch(Exception e)
        {
            Log("respuestaSIIMF", e);
        }
        finally 
        {
          //cleanup(con, cs, rs);
          //PCSM 06/01/2017
          try {
              helper.cleanup(con, cs, rs);
          } catch (Exception e) {
              e.printStackTrace();
          } 
        }    
            
        return siimf;
    }


    public String registrarCertificadoFitosanitarioImpoFito(CertificadoExpoFito certificadoExpoFito){
         
         Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " ******************* Inicio del Método registrarCertificadoFitosanitarioImpoFito *******************");              
         String codCertFitoExpo ="Error";
         
         String sql = certificadoExpoFito.getCodigoCertificadoExpoFito()== null ? SenasaSQL.INSERTAR_CERTIFICADO_EXPO_FITO : SenasaSQL.ACTUALIZAR_CERTIFICADO_EXPO_FITO;
         
         Connection con = null; 
         CallableStatement cs = null;        
         Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Llamando al sp " + sql);               
         StringBuilder sbP = null;
         sbP = new StringBuilder();
         sbP.append("CodigoCentroTramite = " + certificadoExpoFito.getCodigoCentroTramite() + "\n");
         sbP.append("CodigoCentroTramiteSalida = " + certificadoExpoFito.getCodigoCentroTramiteSalida() + "\n");
         sbP.append("CodigoPaisOrigen = " + certificadoExpoFito.getCodigoPaisOrigen() + "\n");
         sbP.append("getCodigoPaisDestino = " + certificadoExpoFito.getCodigoPaisDestino() + "\n");
         sbP.append("getCodigoDepartamento = " + certificadoExpoFito.getCodigoDepartamento() + "\n");
         sbP.append("getCodigoProvincia = " + certificadoExpoFito.getCodigoProvincia() + "\n");
         sbP.append("getCodigoDistrito = " + certificadoExpoFito.getCodigoDistrito() + "\n");
         sbP.append("getCodigoImportador = " + certificadoExpoFito.getCodigoImportador() + "\n");
         sbP.append("getCodigoLugarInspeccion = " + certificadoExpoFito.getCodigoLugarInspeccion() + "\n");
         sbP.append("getCodigoMedioTransporte = " + certificadoExpoFito.getCodigoMedioTransporte() + "\n");
         sbP.append("getFechaEmbarque = " + certificadoExpoFito.getFechaEmbarque() + "\n");
         sbP.append("getFechaDesembarque = " + certificadoExpoFito.getFechaDesembarque() + "\n");
         sbP.append("getCodigoExpediente = " + certificadoExpoFito.getCodigoExpediente() + "\n");
         sbP.append("getObservacion = " + certificadoExpoFito.getObservacion() + "\n");
         sbP.append("getLugarProduccion = " + certificadoExpoFito.getLugarProduccion() + "\n");
         sbP.append("getHoraEmision = " + certificadoExpoFito.getHoraEmision() + "\n");
         sbP.append("getNumeroCertificado = " + certificadoExpoFito.getNumeroCertificado() + "\n");
         sbP.append("getCodigoPuerto = " + certificadoExpoFito.getCodigoPuerto() + "\n");
         sbP.append("getIdPersona = " + certificadoExpoFito.getIdPersona() + "\n");
         
         Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Datos = " + sbP); 
         try{
             //con=cnApp.getConnection();
             //con=cnApp.getConnPermisoFitoSanitarioExportacion();  //05/01/2017
             con = helper.getConnection();  //PCSM 06/01/2017
             cs = con.prepareCall(sql);            
             // insercion de certificado exportacion fitosanitaria
             
             if(certificadoExpoFito.getCodigoCertificadoExpoFito()== null){
                 Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Insertar Registro");                 
                 
                 cs.setString(1, certificadoExpoFito.getCodigoCertificadoExpoFito());
                 cs.registerOutParameter(1, OracleTypes.VARCHAR);
                 cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");
                 cs.registerOutParameter(3,OracleTypes.CURSOR, "SYS_REFCURSOR");
                 cs.setString(4,  certificadoExpoFito.getCodigoCentroTramite());
                 cs.setString(5,  certificadoExpoFito.getCodigoCentroTramiteSalida());
                 cs.setDate(6,    Utility.toSQLDate(certificadoExpoFito.getFechaEmision()));
                 cs.setString(7,  certificadoExpoFito.getCodigoPaisOrigen());
                 cs.setString(8,  certificadoExpoFito.getCodigoPaisDestino());
                 cs.setString(9,  certificadoExpoFito.getCodigoDepartamento());
                 cs.setString(10, certificadoExpoFito.getCodigoProvincia());
                 cs.setString(11, certificadoExpoFito.getCodigoDistrito());
                 cs.setString(12, certificadoExpoFito.getCodigoImportador());
                 cs.setString(13, certificadoExpoFito.getCodigoLugarInspeccion());
                 cs.setString(14, certificadoExpoFito.getCodigoMedioTransporte());
                 cs.setDate(15,   Utility.toSQLDate(certificadoExpoFito.getFechaEmbarque()));
                 cs.setDate(16,   Utility.toSQLDate(certificadoExpoFito.getFechaDesembarque()));
                 cs.setString(17, certificadoExpoFito.getCodigoExpediente());
                 cs.setString(18, certificadoExpoFito.getObservacion());
                 cs.setString(19, certificadoExpoFito.getLugarProduccion()) ;
                 cs.setDate(20,   Utility.toSQLDate(certificadoExpoFito.getHoraEmision()));
                 cs.setString(21, certificadoExpoFito.getNumeroCertificado());
                 cs.setString(22, certificadoExpoFito.getCodigoPuerto());
                cs.setString(23, certificadoExpoFito.getIdPersona());//
                 
                 ArrayList<ProductoExpoFitoDB> listProductos       = new ArrayList<ProductoExpoFitoDB>();
                 ArrayList<ProductoExpoFitoDB> listProductosAnexos = new ArrayList<ProductoExpoFitoDB>();
                 
                 Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Inicio de grabar productos y Anexos" );
                 ProductoExpoFitoDB productoExpoFitoDB= null;
                 //sbP = new StringBuilder();
                 for(ProductoExpoFito det:certificadoExpoFito.getListaProductos()){
                     //if(det.getCodigoProductoPadre() == null) listProductos.add((ProductoExpoFitoDB)det);
                     //if(det.getCodigoProductoPadre() != null) listProductosAnexos.add((ProductoExpoFitoDB)det);
                     
                     productoExpoFitoDB= new ProductoExpoFitoDB();
                     productoExpoFitoDB.setCodiUnidMed(det.getCodiUnidMed());
                     productoExpoFitoDB.setCodigoTipoEnvase(det.getCodigoTipoEnvase());
                     productoExpoFitoDB.setCantidadPeso(det.getCantidadPeso());
                     productoExpoFitoDB.setCantidadEnvase(det.getCantidadEnvase());
                     //productoExpoFitoDB.setCultivarId(cultivarId);  
                     productoExpoFitoDB.setMarcaDistintiva(det.getMarcaDistintiva());
                     productoExpoFitoDB.setPersonaId(det.getPersonaId());
                     productoExpoFitoDB.setCodigoProducto(det.getCodigoProducto());
                     productoExpoFitoDB.setDesTipoEnvase(det.getDesTipoEnvase());
                     productoExpoFitoDB.setDesUnidadMedia(det.getDesUnidadMedia()); 
                     
                     if(det.getCodigoProductoPadre() == null || det.getCodigoProductoPadre().equals("")){
                       Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Producto agregado a la lista" )  ;
                       listProductos.add(productoExpoFitoDB);
                     }  
                     if(det.getCodigoProductoPadre() != null && (!det.getCodigoProductoPadre().equals(""))){
                       Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Anexo agregado a la lista" )  ;
                       listProductosAnexos.add(productoExpoFitoDB);
                     }
                     
                 }
                 // DEMO 1
                 /*Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Agregar productos a la lista generica" )  ;
                 Map types = con.getTypeMap();                
                 ListaGenerica tipoListaProductos = new ListaGenerica(listProductos);                
                 //tipoListaProductos.setSqlName(ProductoExpoFitoDB.SQL_TYPE_ARRAY);  //Finalbpm.t_Producto_Exp_Fito_Array
                 tipoListaProductos.setSqlName("FINALBPM.T_PRODUCTO_EXP_FITO_ARRAY");  //Finalbpm.t_Producto_Exp_Fito_Array
                 
                 types.put(tipoListaProductos.getSqlName(), ListaGenerica.class);                
                 Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Tipos=> " + tipoListaProductos.getSqlName() + " ListaGenerica.class =>"+ ListaGenerica.class)  ;
                 cs.setObject(23,tipoListaProductos);
                 
                 Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Agregar anexos a la lista generica" )  ;
                 Map typesAnexos = con.getTypeMap(); 
                 ListaGenerica tipoListaProductosAnexos = new ListaGenerica(listProductosAnexos);                
                 //tipoListaProductos.setSqlName(ProductoExpoFitoDB.SQL_TYPE_ARRAY_ANX);                
                 tipoListaProductos.setSqlName("FINALBPM.T_PRODUCTO_EXP_FITO_ANX_ARRAY");
                 typesAnexos.put(tipoListaProductosAnexos.getSqlName(), ListaGenerica.class);                
                 cs.setObject(24,tipoListaProductosAnexos);*/
                 
                 //DEMO 2
                 
                 Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Instanciar descriptor" )  ;
                 StructDescriptor structDescriptorProd =new StructDescriptor("FINALBPM.T_PRODUCTO_EXP_FITO", con); //of t_producto_exp_fito
                 StructDescriptor structDescriptorAnx =new StructDescriptor("FINALBPM.T_PRODUCTO_EXP_FITO_ANX", con);//OF t_producto_exp_fito_anx
                 STRUCT arregloProductos[] = new STRUCT[listProductos.size()];
                 STRUCT arregloAnexos[] = new STRUCT[listProductosAnexos.size()];
                 
                 Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Crear arreglo" )  ;
                 //for(ProductoExpoFito det:certificadoExpoFito.getListaProductos()){
                 for (int p=0; p<listProductos.size();p++) {
                  String[] producto = new String[11];
                  ProductoExpoFitoDB pFitoDB =listProductos.get(p);
                  producto[0]=pFitoDB.getCodigoCertificadoFitoExpo();
                  producto[1]="0";
                  producto[2]=pFitoDB.getCodiUnidMed();
                  producto[3]=pFitoDB.getCodigoTipoEnvase();
                  producto[4]=pFitoDB.getCantidadPeso();
                  producto[5]=pFitoDB.getCodigoProducto();   
                  producto[6]=pFitoDB.getCantidadEnvase();
                  producto[7]=pFitoDB.getCultivarId();
                  producto[8]=pFitoDB.getMarcaDistintiva();
                  producto[9]="ACTIVO";// estado;
                  producto[10]=pFitoDB.getPersonaId();
                  arregloProductos[p] = new STRUCT(structDescriptorProd, con, producto);
                }
                Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Crear descriptor para productos" )  ;
                ArrayDescriptor descriptorProd = ArrayDescriptor.createDescriptor("FINALBPM.T_PRODUCTO_EXP_FITO_ARRAY",con);//Finalbpm.t_Producto_Exp_Fito_Array
                ARRAY arregloProd = new ARRAY(descriptorProd, con, arregloProductos);
                cs.setArray(24, arregloProd);

               for (int p=0; p<listProductosAnexos.size();p++) {
                String[] producto = new String[11];
                ProductoExpoFitoDB pFitoDB =listProductosAnexos.get(p);
                producto[0]=pFitoDB.getCodigoCertificadoFitoExpo();
                producto[1]="0";
                producto[2]=pFitoDB.getCodiUnidMed();
                producto[3]=pFitoDB.getCodigoTipoEnvase();
                producto[4]=pFitoDB.getCantidadPeso();
                producto[5]=pFitoDB.getCodigoProducto();   
                producto[6]=pFitoDB.getCantidadEnvase();
                producto[7]=pFitoDB.getCultivarId();
                producto[8]=pFitoDB.getMarcaDistintiva();
                producto[9]="ACTIVO";// estado;
                producto[10]=pFitoDB.getPersonaId();
                arregloAnexos[p] = new STRUCT(structDescriptorAnx, con, producto);
               }
               
               Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Crear descriptor para Anexos" )  ;
               ArrayDescriptor descriptorAnx = ArrayDescriptor.createDescriptor("FINALBPM.T_PRODUCTO_EXP_FITO_ANX_ARRAY",con);//Finalbpm.t_producto_exp_fito_anx_array
               ARRAY arregloAnx = new ARRAY(descriptorAnx, con, arregloAnexos);
               cs.setArray(25, arregloAnx);
                 
               Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Antes del execute" )  ;
               cs.execute();
               Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Despúes del Execute" )  ;
               
               codCertFitoExpo=cs.getString(1);
               Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " codCertFitoExpo= " + codCertFitoExpo )  ;
  
             }else{// Actualizacion de certificado exportaicon fitosanitaria
                 
                 Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Modificar Registro");
                 cs.setString(1, certificadoExpoFito.getCodigoCertificadoExpoFito());
                 cs.setString(2, certificadoExpoFito.getCodigoCentroTramiteSalida());
                 cs.setString(3, certificadoExpoFito.getCodigoPaisDestino());
                 cs.setString(4, certificadoExpoFito.getCodigoImportador());
                 cs.setString(5, certificadoExpoFito.getNumeroCertificado());
                 cs.setString(6, certificadoExpoFito.getCodigoPuerto());
                 cs.setString(7, certificadoExpoFito.getEstado());
                 Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Antes del execute certificado " + certificadoExpoFito.getCodigoPuerto())  ;
                 cs.execute(); 
                 Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Despúes del Execute certificado")  ;
                 /// --------------------- actualizacion de datos de productos padres
                 Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Modificar productos" )  ;
                 Iterator list= certificadoExpoFito.getListaProductos().listIterator();                 
                 ProductoExpoFito producto = null;                
                 
                 while(list.hasNext()){
                     producto = (ProductoExpoFito)list.next();
                     if(producto.getCodigoProductoPadre() == null || producto.getCodigoProductoPadre().equals("")){
                       sql=SenasaSQL.ACTUALIZAR_CERTIFICADO_PRODUCTO_EXPO_FITO;
                     }else{
                       sql=SenasaSQL.ACTUALIZAR_CERTIFICADO_PRODUCTO_ANEXO_EXPO_FITO;
                     }
                     Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Llamando al sp " + sql); 
                     //cs = con.prepareCall( producto.getCodigoProductoPadre()==null ? SenasaSQL.ACTUALIZAR_CERTIFICADO_PRODUCTO_EXPO_FITO:SenasaSQL.ACTUALIZAR_CERTIFICADO_PRODUCTO_ANEXO_EXPO_FITO);
                     cs = con.prepareCall(sql);
                     cs.setString(1, certificadoExpoFito.getCodigoCertificadoExpoFito());                    
                     cs.setString(2, producto.getSecuencialProducto());                    
                     cs.setString(3, producto.getCantidadPeso());                    
                     cs.setString(4, producto.getCantidadEnvase());                    
                     cs.setString(5, producto.getEstado());                    
                     cs.setString(6, producto.getPersonaId());
                     Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Antes del execute productos" )  ;
                     cs.execute();
                     Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Despúes del Execute productos" )  ;
                     
                 }
                  codCertFitoExpo=certificadoExpoFito.getCodigoCertificadoExpoFito();
             }
             
         } catch (SQLException e) {
             Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ " Error de SQLException registrarCertificadoFitosanitarioImpoFito", e);
             codCertFitoExpo="Error SQLException " + e.getMessage();
         }catch(Exception e)        {
             Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ "Error de Exception registrarCertificadoFitosanitarioImpoFito", e);
            codCertFitoExpo="Error Exception " + e.getMessage();
         }
         finally {           
            //cleanup(con, cs, null);
            Log(" Exp="+certificadoExpoFito.getCodigoExpediente()+ "******************* Fin del Método registrarCertificadoFitosanitarioImpoFito *******************");              
           //PCSM 06/01/2017
             try {
                 helper.cleanup(con, cs, null);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }   
         
         return codCertFitoExpo;
     }
    
    public String obtenerRutaSIIMF(String codProducto, String codPaisOrigen){
        logger.debug("============ OBTENER_RUTA_SIIMF =====================");
        String sql = SenasaSQL.OBTENER_RUTA_SIIMF;      
        logger.debug(" AQUI VA EL " + sql);
        Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
        CallableStatement cs = null;
        String result="";
        try{
            //con = cnApp.getConnection();
            //con=cnApp.getConnPermisoFitoSanitarioExportacion();  //05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            cs=con.prepareCall(sql);
                     
            cs.setString(1, codProducto);
            cs.setString(2, codPaisOrigen);
            cs.setString(3, result);
            cs.registerOutParameter(3, Types.VARCHAR);
            
            logger.debug("Se va a ejecutar OBTENER_RUTA_SIIMF");
            cs.execute();
            
            result = cs.getString(3);
            logger.debug("Resultado, va a SIIMF: "+result);
        } catch (SQLException e) {
            Log("OBTENER_RUTA_SIIMF", e);
        }catch(Exception e){
            Log("OBTENER_RUTA_SIIMF", e);
        }
        finally {
          //cleanup(con, cs, null);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }  
        } 
        return result;
    }

}
