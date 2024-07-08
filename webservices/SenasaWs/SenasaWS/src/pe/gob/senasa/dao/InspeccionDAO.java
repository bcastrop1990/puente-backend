package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.ActividadVigilancia;
import pe.gob.senasa.bean.AreaLaboratorio;
import pe.gob.senasa.bean.Concepto;
import pe.gob.senasa.bean.DetalleResultadoAnalisisAnimalInsp;
import pe.gob.senasa.bean.DetalleResultadoAnalisisVegetalInsp;
import pe.gob.senasa.bean.DetalleSolicitudAnalisisAnimal;
import pe.gob.senasa.bean.DetalleSolicitudAnalisisVegetal;
import pe.gob.senasa.bean.EspeciesAnimales;
import pe.gob.senasa.bean.Lote;
import pe.gob.senasa.bean.ProcedenciaOrigenMuestra;
import pe.gob.senasa.bean.ProductoInspeccion;
import pe.gob.senasa.bean.PruebaDiagnostica;
import pe.gob.senasa.bean.Raza;
import pe.gob.senasa.bean.RespuestaAnalisisLaboratorio;
import pe.gob.senasa.bean.RespuestaInspeccion;
import pe.gob.senasa.bean.Sexo;
import pe.gob.senasa.bean.SolicitudAnalisisAnimal;
import pe.gob.senasa.bean.SolicitudAnalisisVegetal;
import pe.gob.senasa.bean.TipoCrianza;
import pe.gob.senasa.bean.TipoIdentificacionAnimal;
import pe.gob.senasa.bean.TipoMuestra;
import pe.gob.senasa.bean.TipoRechazo;
import pe.gob.senasa.bean.UnidadMedida;
import pe.gob.senasa.bean.VigilanciaActivaPruebas;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.dbtypes.ListaGenerica;
import pe.gob.senasa.dbtypes.MuestraLaboratorio;
import pe.gob.senasa.dbtypes.MuestraLaboratorioAnimal;
import pe.gob.senasa.dbtypes.SolicitudDiagnostico;
import pe.gob.senasa.dbtypes.SolicitudDiagnosticoAnimal;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.InspeccionInterface;
import pe.gob.senasa.util.Utility;


public class InspeccionDAO extends BaseDAO implements InspeccionInterface {
    
    protected static Logger logger = Logger.getLogger(InspeccionDAO.class);
    private DBHelper helper;
    public InspeccionDAO(){
        super();
        helper = new DBHelper(SenasaSQL.dsInspeccion);
    }
    
    private void Log(String s, java.lang.Throwable p2) {
      logger.fatal("InspeccionDAO - " + s, p2);
    }
    
   private void Log(String s) {
      logger.debug(s);
   }


    public RespuestaInspeccion insertarInspeccion(pe.gob.senasa.bean.Inspeccion inspeccion){
        
        RespuestaInspeccion respuesta = new RespuestaInspeccion();
        
        Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();        
        //Connection con = ConnectionSenasa.getConnectionSimple();
        logger.debug("Iniciando");
        CallableStatement cs =null;      
        ResultSet rs = null;
        String  sql = SenasaSQL.REGISTRAR_INSPECCION;
        
      try {
            con = helper.getConnection();
          Log(" AQUI VA EL " + sql);
          
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = "); 
          
          StructDescriptor structDescriptor = new StructDescriptor("FINALBPM.T_INSPECCION_PRODUCTO", con);
            
          STRUCT arregloProductos[] = new STRUCT[inspeccion.getListaProducto().size()];
          logger.debug("inspeccion.getListaProducto().size()=" + inspeccion.getListaProducto().size());
        
          Iterator<ProductoInspeccion> listaProd= inspeccion.getListaProducto().iterator();
          
          ProductoInspeccion producto = null;
          
          String[] datosPro = null;
          
          int iteracion = 0;
          
          while(listaProd.hasNext())
          {
            datosPro = new String[12]; 
              
            producto= listaProd.next();   
              
            // codigo_inspeccion_productos
            datosPro[0]  =null;
              
            // codigo_inspeccion
            datosPro[1]  =null;
            
            // codigo_producto
            datosPro[2]  =producto.getCodigoProducto();
            logger.debug("param producto.getCodigoProducto()=" + producto.getCodigoProducto());
            
            // cantidad_actual
            datosPro[3]  =producto.getCantidadActual();
            logger.debug("param producto.getCantidadActual()=" + producto.getCantidadActual());
            
            // codigo_servicio
            datosPro[4]  =producto.getCodigoServicio();
            logger.debug("param producto.getCodigoServicio()=" + producto.getCodigoServicio());
            
            // codigo_expediente              
            datosPro[5]  =producto.getExpediente();
            logger.debug("param producto.getExpediente()=" + producto.getExpediente());
            
            // cantidad_base
            datosPro[6]  =producto.getCantidad();
            logger.debug("param producto.getCantidad()=" + producto.getCantidad());
            
            // peso_actual
            datosPro[7]  ="0";
            
            // peso_base
            datosPro[8]  ="0";
            
            
            // secuencial_producto
            datosPro[9]  =null;
            
            // estado
            datosPro[10]  =producto.getEstado();
            logger.debug("param producto.getEstado()=" + producto.getEstado());
            
            // persona_id
            datosPro[11]  =producto.getPersonaId();
            logger.debug("param producto.getPersonaId()=" + producto.getPersonaId());
            
            arregloProductos[iteracion++] = new STRUCT(structDescriptor,con,datosPro);
          
          }       
          
          ArrayDescriptor descriptorProductos = ArrayDescriptor.createDescriptor("FINALBPM.T_INSPECCION_PRODUCTO_ARRAY",con);
          
          ARRAY productosArray = new ARRAY(descriptorProductos, con, arregloProductos);
          
          cs.registerOutParameter(1,OracleTypes.VARCHAR);
           
          cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");
        
          cs.setString(3,inspeccion.getExpediente());
          logger.debug("param inspeccion.getExpediente()=" + inspeccion.getExpediente());
        
          cs.setString(4,inspeccion.getCodigoServicio());
          logger.debug("param inspeccion.getCodigoServicio()=" + inspeccion.getCodigoServicio());
          
          cs.setArray(5, productosArray);
          
          cs.execute();
          
          String idInspeccion = cs.getString(1);
          
          logger.debug("param Salida idInspeccion=" + idInspeccion);
        
          respuesta.setIdInspeccion(idInspeccion);
            
          rs = (ResultSet) cs.getObject(2);
          
          String[][] listResult = new  String[2][inspeccion.getListaProducto().size()];
          
          int i = 0;
          
          while (rs.next())
          {
             listResult[0][i]= rs.getString("Codigo_Producto");
             logger.debug("rs.getString(Codigo_Producto)=" + rs.getString("Codigo_Producto")); 
             listResult[1][i]= rs.getString("Codigo_Inspeccion_Producto"); 
             logger.debug("rs.getString(Codigo_Inspeccion_Producto)" + rs.getString("Codigo_Inspeccion_Producto")); 
             i++;
          }
          
          respuesta.setListaProducto(listResult);
          
          respuesta.setStatusCode("OK");
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("insertarInspeccion", e);
          respuesta.setStatusCode("ERROR");
          respuesta.setMensajeError("Error en WS:"+e.getMessage());
          return respuesta;
      } catch (Exception e) {
          Log("insertarInspeccion", e);
          respuesta.setMensajeError("Error en WS:"+e.getMessage());
          return  respuesta;
      } finally {
          cleanup(con, cs,rs);
      }
        
        return respuesta;
    }

    public void actualizarProductoInspeccion(ProductoInspeccion productoInspeccion)
    {
      //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
      Connection con =null; //ConnectionSenasa.getConnectionSimple();
      CallableStatement cs =null;      
      String  sql = SenasaSQL.ACTUALIZAR_PRODUCTO_INSPECCION;
      
      try {
            con = helper.getConnection();
          Log(" AQUI VA EL " + sql);
          
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
            cs.setString(1,productoInspeccion.getCodigoProductoInspeccion());
          
            cs.setString(2,productoInspeccion.getCantidadActual());
          
            cs.setString(3,"0");
        
            cs.setString(4,productoInspeccion.getEstado());
          
            cs.setString(5,productoInspeccion.getPersonaId());

            cs.execute();
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("actualizarProductoInspeccion", e);
      } catch (Exception e) {
          Log("actualizarProductoInspeccion", e);
      } finally {
        cleanup(con, cs,null);
      }
      
    }

    public String registrarLote(Lote lote)
    {
      String idLote = null; 
        
      Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
      //Connection con = ConnectionSenasa.getConnectionSimple();
      
      CallableStatement cs =null; 
      //ResultSet rs = null;    
      logger.debug("Iniciando");
      String  sql =  lote.getIdLote()==null ? SenasaSQL.INSERTAR_LOTE : SenasaSQL.ACTUALIZAR_LOTE;
      
      try {
            con = helper.getConnection();
          Log(" AQUI VA EL " + sql);
          
          cs= con.prepareCall(sql);
          
          if(lote.getIdLote()==null)
          {
          
            cs.registerOutParameter(1,OracleTypes.VARCHAR);
            
            cs.setString(2,lote.getIdInspeccionProducto());
            logger.debug("param lote.getIdInspeccionProducto() = " + lote.getIdInspeccionProducto());
            
            cs.setString(3,lote.getIdInspeccion());
            logger.debug("param lote.getIdInspeccion() = " + lote.getIdInspeccion());
            
            cs.setString(4,lote.getIdProducto()); 
            logger.debug("param lote.getIdProducto() = " + lote.getIdProducto());
            
            cs.setString(5,lote.getReglon());
            logger.debug("param lote.getReglon() = " + lote.getReglon());
            
            cs.setInt(6, Integer.parseInt(lote.getCantidadLote()));
            logger.debug("param lote.getCantidadLote() = " + lote.getCantidadLote());
            
            cs.setInt(7, 0);
            logger.debug("param lote.p_Peso_Lote() = 0");
            
            cs.setString(8,lote.getEstado()); 
            logger.debug("param lote.getEstado() = " + lote.getEstado());
            
            cs.setString(9,lote.getObservacion()); 
            logger.debug("param lote.getObservacion() = " + lote.getObservacion());
            
            
              
          }
          else
          {
              
            cs.setString(1,lote.getIdLote());
            logger.debug("param lote.getIdLote() = " + lote.getIdLote());
            
            cs.setInt(2,Integer.parseInt(lote.getCantidadLote()));
            logger.debug("param lote.getCantidadLote() + " + lote.getCantidadLote());
              
            cs.setInt(3,0);
            logger.debug("param lote.p_Peso_Lote() = 0");
            
            cs.setString(4,lote.getEstado());
            logger.debug("param lote.getEstado() + " + lote.getEstado());
            
            cs.setString(5,lote.getObservacion());
            logger.debug("param lote.getObservacion() + " + lote.getObservacion());
              
          }
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.execute();
          
          Log(" = FIN TODITO = ");
          
          if(lote.getIdLote()==null)
          {
              idLote = cs.getString(1);
              logger.debug("idLote = " + idLote);
          }
          
      } catch (SQLException e) {
          Log("registrarLote", e);
      } catch (Exception e) {
          Log("registrarLote", e);
      } finally {
        cleanup(con, cs,null);
      }
      
      return idLote;
    }

    public Lote consultarLote(String idLote)
    {
      Lote lote = null;
      
      String sql = SenasaSQL.CONSULTAR_LOTE;
      
      Log(" AQUI VA EL " + sql);

      Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
      
     // Connection con = ConnectionSenasa.getConnectionSimple();
      
      CallableStatement cs =null;      
      ResultSet rs = null;

      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.setString(1,idLote);
          
          cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");

          cs.execute();
          
          rs = (ResultSet) cs.getObject(2);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
             lote = new Lote(rs.getString("CODIGO_INSPECCION"),
                             rs.getString("SECUENCIAL_PRODUCTO"),
                             rs.getString("CODIGO_LOTE"),
                             rs.getString("CANTIDAD_LOTE"),
                             rs.getString("ESTADO"),
                             rs.getString("CODIGO_INSPECCION_PRODUCTO"),
                             rs.getString("CODIGO_PRODUCTO"),
                             rs.getString("OBSERVACION"));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("consultarLote", e);
      } catch (Exception e) {
          Log("consultarLote", e);
      } finally {
        cleanup(con, cs,rs);
      }
      
      return lote;
    }

    public String registrarConcepto(Concepto concepto)
    {
      String idConcepto = null;
        
      Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
     // Connection con = ConnectionSenasa.getConnectionSimple();
      
      CallableStatement cs =null; 
      
      logger.debug("Iniciando");
      String  sql =  concepto.getIdConcepto()==null ? SenasaSQL.INSERTAR_CONCEPTO : SenasaSQL.ACTUALIZAR_CONCEPTO;
      
      try {
            con = helper.getConnection();
          Log(" AQUI VA EL " + sql);
          
          cs= con.prepareCall(sql);
          
          if(concepto.getIdConcepto()==null)
          {
          
            cs.registerOutParameter(1,OracleTypes.VARCHAR);
            
            cs.setString(2,concepto.getIdLote());
            logger.debug("param concepto.getIdLote()=" + concepto.getIdLote());
            
            cs.setString(3,concepto.getIdInspeccionProducto());
            logger.debug("param concepto.getIdInspeccionProducto()=" + concepto.getIdInspeccionProducto());
            
            cs.setString(4,concepto.getIdInspeccion()); 
            logger.debug("param concepto.getIdInspeccion()=" + concepto.getIdInspeccion());
            
            cs.setString(5,concepto.getIdProducto());
            logger.debug("param concepto.getIdProducto()=" + concepto.getIdProducto());
            
            cs.setString(6,concepto.getReglon());
            logger.debug("param concepto.getReglon()=" + concepto.getReglon());
            
            cs.setString(7,concepto.getTipoConceptoRetencion()); 
            logger.debug("param concepto.getTipoConceptoRetencion()=" + concepto.getTipoConceptoRetencion());
            
            cs.setString(8,concepto.getCodigoCtaRetencion()); 
            logger.debug("param concepto.getCodigoCtaRetencion()=" + concepto.getCodigoCtaRetencion());
            
            cs.setString(9,concepto.getCantidadCtaRetencion()); 
            logger.debug("param concepto.getCantidadCtaRetencion()=" + concepto.getCantidadCtaRetencion());
            
            cs.setString(10,"0"); 
            logger.debug("param concepto.getPesoCtaRetencion()=0" );
            
            
            cs.setString(11,concepto.getEstado()); 
            logger.debug("param concepto.getEstado()=" + concepto.getEstado());
            
            cs.setString(12,concepto.getNumeroSolicitudAnalisis()); 
            logger.debug("param concepto.getNumeroSolicitudAnalisis()=" + concepto.getNumeroSolicitudAnalisis());
              
          }
          else
          {
              
            cs.setString(1, concepto.getIdConcepto());
            logger.debug("param concepto.getIdConcepto()=" + concepto.getIdConcepto());
              
            cs.setString(2, concepto.getEstado());
            logger.debug("param concepto.getEstado()=" + concepto.getEstado());
            
            cs.setString(3, concepto.getNumeroSolicitudAnalisis());
            logger.debug("param concepto.getNumeroSolicitudAnalisis()=" + concepto.getNumeroSolicitudAnalisis());
              
            cs.setString(4, concepto.getRespuesta());
            logger.debug("param concepto.getRespuesta()=" + concepto.getRespuesta());
              
            cs.setDate(5, concepto.getFechaRespuesta() != null ? Utility.toSQLDate(concepto.getFechaRespuesta()) : null); 
            logger.debug("param concepto.getFechaRespuesta()=" + concepto.getFechaRespuesta());
            
            cs.setString(6, concepto.getUrlDocumento());
            logger.debug("param concepto.getUrlDocumento()=" + concepto.getUrlDocumento());
              
          }
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.execute();
          
          Log(" = FIN TODITO = ");
          
          if(concepto.getIdConcepto()==null)
          {
              idConcepto = cs.getString(1);
              logger.debug("resultado idConcepto=" + idConcepto);
          }
          
      } catch (SQLException e) {
          Log("registrarConcepto", e);
      } catch (Exception e) {
          Log("registrarConcepto", e);
      } finally {
        cleanup(con, cs,null);
      }      
        
       return idConcepto;
    }

    public Concepto consultarConcepto(String idConcepto) {
     
      Concepto concepto= null;
      

      String sql = SenasaSQL.CONSULTAR_CONCEPTO;
      
      Log(" AQUI VA EL " + sql);

      Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
      
     // Connection con = ConnectionSenasa.getConnectionSimple();
      
      CallableStatement cs =null;      
      ResultSet rs = null;

      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.setString(1,idConcepto);
          
          cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");

          cs.execute();
          
          rs = (ResultSet) cs.getObject(2);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
             concepto = new Concepto(rs.getString("CODIGO_INSPECCION"),
                             rs.getString("SECUENCIAL_PRODUCTO"),
                             rs.getString("CODIGO_LOTE"),
                             rs.getString("CODIGO_CONCEPTO"),
                             rs.getString("TIPO_CONCEPTO_RETENCION"),
                             rs.getString("CODIGO_CTA_RETENCION"),
                             rs.getString("CANTIDAD_CTA_RETENCION"),
                             rs.getString("NUMERO_SOLICITUD_ANALISIS"),
                             rs.getString("URL_DOCUMENTO"),
                             rs.getString("RESPUESTA"),
                             rs.getString("ESTADO"),
                             Utility.toUtilDate(rs.getDate("FECHA_RESPUESTA")),
                             rs.getString("CODIGO_INSPECCION_PRODUCTO"),
                             rs.getString("CODIGO_PRODUCTO"));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("consultarConcepto", e);
      } catch (Exception e) {
          Log("consultarConcepto", e);
      } finally {
        cleanup(con, cs,rs);
      }
      
      return concepto;
    }

    public ArrayList<TipoMuestra> obtenerTipoMuestrasXClase(String codigoClase,String codigoPrueba) {
        
      ArrayList<TipoMuestra> list = new ArrayList<TipoMuestra>();
        
      Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
      CallableStatement cs =null;      
      ResultSet rs = null;
      String sql = null;        
      
      try {
            con = helper.getConnection();
          logger.debug("codigoClase:"+codigoClase);
          // Animal
          if(codigoClase.equals("01"))
          {
             sql = SenasaSQL.OBTENER_TIPO_MUESTRA_ANIMAL;
          }
          
          // Vegetal 
          if(codigoClase.equals("02"))
          {
            sql = SenasaSQL.OBTENER_TIPO_MUESTRA_VEGETAL;
          }        
          
          if(sql == null) return list;
        
          Log(" AQUI VA EL " + sql);
          
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          if(codigoClase.equals("01"))
          {
            cs.setString(1,codigoPrueba);
            
            cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            
            rs = (ResultSet) cs.getObject(2);
          }
          
          if(codigoClase.equals("02"))
          {
            
            cs.registerOutParameter(1,OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            
            rs = (ResultSet) cs.getObject(1);              
          }
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
              if(codigoClase.equals("01"))
              {
                list.add(new TipoMuestra(rs.getString("codi_tipo_mue"),rs.getString("nomb_tipo_mue"),null)); 
                logger.debug("rs.getString(codi_tipo_mue)=" + rs.getString("codi_tipo_mue"));
                logger.debug("rs.getString(nomb_tipo_mue)=" + rs.getString("nomb_tipo_mue"));
                
              }
              
              if(codigoClase.equals("02"))
              {
                list.add(new TipoMuestra(rs.getString("codi_tipo_mue"),rs.getString("nomb_tipo_mue"),rs.getString("flag_sarvf")));    
                logger.debug("rs.getString(codi_tipo_mue)=" + rs.getString("codi_tipo_mue"));
                logger.debug("rs.getString(nomb_tipo_mue)=" + rs.getString("nomb_tipo_mue"));
                logger.debug("rs.getString(flag_sarvf)=" + rs.getString("flag_sarvf"));
                
              }             
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("obtenerTipoMuestrasXClase", e);
      } catch (Exception e) {
          Log("obtenerTipoMuestrasXClase", e);
      } finally {
        cleanup(con, cs,rs);
      }
      
        
        
        return list;
    }

    public ArrayList<AreaLaboratorio> obtenerAreaLaboratorioXClase(String codigoClase) {
        // Pckg_General.Sp_Lista_Area_Laboratorio
        String sql = SenasaSQL.OBTENER_AREAS_LABORATORIO;
        
        Log(" AQUI VA EL " + sql);

        Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
        CallableStatement cs =null;      
        ResultSet rs = null;
        
        ArrayList<AreaLaboratorio> list = new ArrayList<AreaLaboratorio>();
        
        try {
            con = helper.getConnection();
            cs= con.prepareCall(sql);
            
            Log(" = ANTES DE EJECUTAR = ");
            
            cs.setString(1,codigoClase);
            
            cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            
            rs = (ResultSet) cs.getObject(2);
            
            Log(" = ENTRANDO = ");
            
            while (rs.next())
            {
                list.add(new AreaLaboratorio(rs.getString("codi_area_lab"),rs.getString("nomb_area_lab"),rs.getString("abre_area_lab"),rs.getString("tipo_labo_lab")));
            }
            
            Log(" = FIN TODITO = ");
            
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
          cleanup(con, cs,rs);
        }
        
        return list;
    }

    public ArrayList<ProcedenciaOrigenMuestra> obtenerProcedenciaOrigenMuestra() 
    {
        // pckg_general.sp_lista_proc_origen_muestra(reg => :reg)
        
        String sql = SenasaSQL.OBTENER_LIST_PROC_ORIGEN_MUESTRA;
        
        Log(" AQUI VA EL " + sql);

        Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
        CallableStatement cs =null;      
        ResultSet rs = null;
        
        ArrayList<ProcedenciaOrigenMuestra> list = new ArrayList<ProcedenciaOrigenMuestra>();
        
        try {
            con = helper.getConnection();
            cs= con.prepareCall(sql);
            
            Log(" = ANTES DE EJECUTAR = ");
            
            cs.registerOutParameter(1,OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            
            rs = (ResultSet) cs.getObject(1);
            
            Log(" = ENTRANDO = ");
            
            while (rs.next())
            {
                list.add(new ProcedenciaOrigenMuestra(rs.getString("codi_proc_mue"),rs.getString("desc_proc_mue")));
            }
            
            Log(" = FIN TODITO = ");
            
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
          cleanup(con, cs,rs);
        }
        
        return list;
    }

    public ArrayList<PruebaDiagnostica> listaServicioAnalisisVegetal(String campoBusqueda) {
        
        // Pckg_General.Sp_Lista_Serv_Analisis_Vegetal (pasa parametro de area de laboratorio  listaAreaLaboratorio)
        
        String sql = SenasaSQL.OBTENER_SERVICIO_ANALISIS_VEGETAL;
        
        Log(" AQUI VA EL " + sql);

        Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
        CallableStatement cs =null;      
        ResultSet rs = null;
        
        ArrayList<PruebaDiagnostica> list = new ArrayList<PruebaDiagnostica>();
        
        try {
            con = helper.getConnection();
            cs= con.prepareCall(sql);
            
            Log(" = ANTES DE EJECUTAR = ");
            
            cs.setString(1,campoBusqueda);
            
            cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            
            rs = (ResultSet) cs.getObject(2);
            
            Log(" = ENTRANDO = ");
            
            while (rs.next())
            {
                list.add(new PruebaDiagnostica(rs.getString("CODI_PRUE_TPD"),rs.getString("NOMB_PRUE_TPD")));
            }
            
            Log(" = FIN TODITO = ");
            
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
          cleanup(con, cs,rs);
        }
        
        return list;
    }

    public ArrayList<ActividadVigilancia> listaMotivo() {
      
      // Pckg_General.Sp_Lista_Motivo
      
      String sql = SenasaSQL.OBTENER_LIST_MOTIVO;
      
      logger.debug("Iniciando");
      Log(" AQUI VA EL " + sql);

      Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      ArrayList<ActividadVigilancia> list = new ArrayList<ActividadVigilancia>();
      
      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.registerOutParameter(1,OracleTypes.CURSOR, "SYS_REFCURSOR");

          cs.execute();
          
          rs = (ResultSet) cs.getObject(1);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
              list.add(new ActividadVigilancia(rs.getString("tipo_vigi_act"),rs.getString("desc_vigi_act")));
              logger.debug("rs.getString(tipo_vigi_act)="+rs.getString("tipo_vigi_act"));
              logger.debug("rs.getString(desc_vigi_act)="+rs.getString("desc_vigi_act"));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("listaMotivo", e);
      } catch (Exception e) {
          Log("listaMotivo", e);
      } finally {
        cleanup(con, cs,rs);
      }
      
      return list;
    }

    public ArrayList<VigilanciaActivaPruebas> listaServicioAnalisisAnimal(String campoBusqueda) 
    {
        
      String sql = SenasaSQL.OBTENER_SERVICIO_ANALISIS_ANIMAL;
      
      Log(" AQUI VA EL " + sql);

      Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      ArrayList<VigilanciaActivaPruebas> list = new ArrayList<VigilanciaActivaPruebas>();
      
      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.setString(1,campoBusqueda);
          
          cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");

          cs.execute();
          
          rs = (ResultSet) cs.getObject(2);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
              list.add(new VigilanciaActivaPruebas(rs.getString("nomb_enfe_tea"),rs.getString("nomb_prue_tpd"),rs.getString("codi_enfe_tea"),rs.getString("codi_prue_tpd")));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("listaMotivo", e);
      } catch (Exception e) {
          Log("listaMotivo", e);
      } finally {
        cleanup(con, cs,rs);
      }
      
      return list;
    }

    public ArrayList<EspeciesAnimales> listaTipoEspecieAnimal() {
        
      String sql = SenasaSQL.OBTENER_LIST_TIPO_ESPC_ANIMAL;
      
      Log(" AQUI VA EL " + sql);

      Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      ArrayList<EspeciesAnimales> list = new ArrayList<EspeciesAnimales>();
      
      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.registerOutParameter(1,OracleTypes.CURSOR, "SYS_REFCURSOR");

          cs.execute();
          
          rs = (ResultSet) cs.getObject(1);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
              list.add(new EspeciesAnimales(rs.getString("espe_anim_ani"),rs.getString("nomb_espe_ani"),rs.getString("nomb_cort_ani"),rs.getString("flag_transito")));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("listaTipoEspecieAnimal", e);
      } catch (Exception e) {
          Log("listaTipoEspecieAnimal", e);
      } finally {
        cleanup(con, cs,rs);
      }
      
      return list;
    }

   
    public RespuestaAnalisisLaboratorio respuestaSolicitudAnalisisLaboratorio(String numeroSolicitudAnalisis, String codigoClase) {
        
        RespuestaAnalisisLaboratorio resultadoLaboratorio = new RespuestaAnalisisLaboratorio();
        
        String sql=codigoClase=="01" ? SenasaSQL.RESPUESTA_ANALISIS_LAB_ANIMAL : SenasaSQL.RESPUESTA_ANALISIS_LAB_VEGETAL;
      
        Log(" AQUI VA EL " + sql);
        Log(" = PARAM numeroSolicitudAnalisis = " +numeroSolicitudAnalisis);
        Log(" = PARAM codigoClase = "+ codigoClase);
        Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
        CallableStatement cs =null;     
        ResultSet rs = null;
      
      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");          
          
          cs.setString(1,numeroSolicitudAnalisis);
          
          if(codigoClase=="02")
          {          
            cs.registerOutParameter(2,OracleTypes.CHAR);
            cs.registerOutParameter(3,OracleTypes.VARCHAR);
            cs.registerOutParameter(4,OracleTypes.VARCHAR);
            cs.registerOutParameter(5,OracleTypes.CURSOR, "SYS_REFCURSOR");
          }
          else {
            cs.registerOutParameter(2,OracleTypes.CHAR);
            cs.registerOutParameter(3,OracleTypes.CHAR);
            cs.registerOutParameter(4,OracleTypes.CHAR);
            cs.registerOutParameter(5,OracleTypes.CURSOR, "SYS_REFCURSOR");
          }
          
          Log(" = ENTRANDO = ");

          cs.execute();
          String resultEspera="0";
          resultEspera = cs.getString(2).trim();
          logger.debug("salida(resultadoEspera):" + resultEspera);
          //resultadoLaboratorio.setResultadoEspera(cs.getString(2)=="1"?true:false);//0 0 null flase
          if(resultEspera.equals("1"))
            resultadoLaboratorio.setResultadoEspera(true);
          else
            resultadoLaboratorio.setResultadoEspera(false);
          
          logger.debug("resultadoEspera:" + resultadoLaboratorio.getResultadoEspera() );
          
          resultadoLaboratorio.setNumeroUCM(cs.getString(3));
          logger.debug("setNumeroUCM:" + resultadoLaboratorio.getNumeroUCM());
        
          resultadoLaboratorio.setUrlUCM(cs.getString(4));
          logger.debug("setUrlUCM:" + resultadoLaboratorio.getUrlUCM());
          
          if(resultadoLaboratorio.getResultadoEspera())
          {
                rs = (ResultSet) cs.getObject(5);
                
                if(codigoClase=="01") {
                  
                  ArrayList<DetalleResultadoAnalisisAnimalInsp> lstResAnimal = new ArrayList<DetalleResultadoAnalisisAnimalInsp>();
                  while (rs.next())
                  {
                      DetalleResultadoAnalisisAnimalInsp objResAnimal = new DetalleResultadoAnalisisAnimalInsp();
                      objResAnimal.setNumeroSolicitud(rs.getString("nume_regi_sol"));
                      logger.debug("objResAnimal.setNumeroSolicitud:" + objResAnimal.getNumeroSolicitud());
                      objResAnimal.setCodigoMuestra(rs.getString("codi_mues_mue"));
                      logger.debug("objResAnimal.setCodigoMuestra:" + objResAnimal.getCodigoMuestra());
                      objResAnimal.setCodigoEnfermedad(rs.getString("codi_enfe_tea"));
                      logger.debug("objResAnimal.setCodigoEnfermedad:" + objResAnimal.getCodigoEnfermedad());
                      objResAnimal.setCodigoPrueba(rs.getString("codi_prue_tpd"));
                      logger.debug("objResAnimal.setCodigoPrueba:" + objResAnimal.getCodigoPrueba());
                       objResAnimal.setResultado(rs.getString("interpretacion"));
                      logger.debug("objResAnimal.setResultado:" + objResAnimal.getResultado());
                      objResAnimal.setCierreLab(rs.getString("cier_dire_lab"));
                      logger.debug("objResAnimal.setCierreLab:" + objResAnimal.getCierreLab());
                    
                      lstResAnimal.add(objResAnimal);
                      
                      resultadoLaboratorio.setResultadoDetalle(objResAnimal.getResultado());
                      logger.debug("ResultadoDetalle:" + resultadoLaboratorio.getResultadoDetalle());
                      
                  }
                  
                }
                
                if(codigoClase=="02") {
                  
                  ArrayList<DetalleResultadoAnalisisVegetalInsp> lstResVegetal = new ArrayList<DetalleResultadoAnalisisVegetalInsp>();
                  while (rs.next())
                  {
                      DetalleResultadoAnalisisVegetalInsp objResVegetal = new DetalleResultadoAnalisisVegetalInsp();
                      objResVegetal.setNumeroSolicitud(rs.getString("nume_regi_sol"));
                      logger.debug("objResVegetal.setNumeroSolicitud:" + objResVegetal.getNumeroSolicitud());
                      objResVegetal.setMotivoResultado(rs.getString("resultado"));
                      logger.debug("objResVegetal.setMotivoResultado:" + objResVegetal.getMotivoResultado());
                      objResVegetal.setCodigoTipoMuestra(rs.getString("codi_tipo_mue"));
                      logger.debug("objResVegetal.setCodigoTipoMuestra:" + objResVegetal.getCodigoTipoMuestra());
                      objResVegetal.setCodigoMuestra(rs.getString("codi_mues_mue"));
                      logger.debug("objResVegetal.setCodigoMuestra:" + objResVegetal.getCodigoMuestra());
                      
                      lstResVegetal.add(objResVegetal);
                      
                      String resultFinal;
                      
                      if(objResVegetal.getMotivoResultado().length()>=8)
                        resultFinal = objResVegetal.getMotivoResultado().substring(0, 8);
                      else
                        resultFinal =   objResVegetal.getMotivoResultado();
                      
                      resultadoLaboratorio.setResultadoDetalle(resultFinal);
                      logger.debug("ResultadoDetalle:" + resultadoLaboratorio.getResultadoDetalle());
                      
                  }
                  
                }
          }
          resultadoLaboratorio.setStatusCode("OK");
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("respuestaSolicitudAnalisisLaboratorio", e);
          resultadoLaboratorio.setStatusCode("ERROR");
          resultadoLaboratorio.setMensajeError(""+e.getMessage());
      } catch (Exception e) {
          Log("respuestaSolicitudAnalisisLaboratorio", e);
          resultadoLaboratorio.setStatusCode("ERROR");
          resultadoLaboratorio.setMensajeError(""+e.getMessage());
      } finally {
        cleanup(con, cs,null);
      }        
        
        return resultadoLaboratorio;
    }

  
    public synchronized String solicitudAnalisisLaboratorioAnimal(SolicitudAnalisisAnimal solicitudAnalisisAnimal)
    {
        
        String numeroSolicitud = null;
        
        String sql = SenasaSQL.SOLICITUD_ANALISIS_LAB_ANIMAL;
      
        Log(" AQUI VA EL " + sql);
  
        Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
        
        //Connection con = ConnectionSenasa.getConnectionSimple();
       
        CallableStatement cs =null;      
       
        //ResultSet rs = null;
        
        try{
            con = helper.getConnection();
          cs= con.prepareCall(sql);  
          logger.debug("Seteando el objeto SolicitudDiagnosticoAnimal");  
          SolicitudDiagnosticoAnimal obj = new SolicitudDiagnosticoAnimal(solicitudAnalisisAnimal);
            
          //obj.setAnho("2011");
          
          ArrayList<MuestraLaboratorioAnimal> list = new ArrayList<MuestraLaboratorioAnimal>();
            
          String[] codigosPruebas = null;  
            
          String[] listaPruebasEnfermedades =  solicitudAnalisisAnimal.getListaidAnalisis();
            
          for(DetalleSolicitudAnalisisAnimal det:solicitudAnalisisAnimal.getListaDetalle()){
              
            codigosPruebas = null;
              
            for(String lista:listaPruebasEnfermedades){
                  
              codigosPruebas  = lista.split("-");
              
              MuestraLaboratorioAnimal aux = new MuestraLaboratorioAnimal(det.getIdTipoEspecieAnimal(),
                                                              Utility.toSQLDate(det.getFechaEnvio()),
                                                              Utility.toSQLDate(det.getFechaColeccion()),
                                                              Integer.parseInt(det.getCantidadMuestra()),
                                                              det.getCategoriaAnimal(),
                                                              det.getRaza(),
                                                              det.getIdSexo(),
                                                              det.getUnidadTiempo(),
                                                              Integer.parseInt(det.getEdad()),
                                                              det.getIdTipoMuestra(),
                                                              det.getIdentificacionAnimal(),
                                                              det.getIdTipoIdentificacion(),
                                                              codigosPruebas[0],
                                                              codigosPruebas[1]);
                list.add(aux);
                
                logger.debug("Datos MuestraLaboratorioAnimal del objeto aux:");
                logger.debug("det.getIdTipoEspecieAnimal():" + aux.getEspecie());
                logger.debug("Utility.toSQLDate(det.getFechaEnvio()):"+aux.getFechaEnvio());
                logger.debug("Utility.toSQLDate(det.getFechaColeccion()):" + aux.getFechaColeccion());
                logger.debug("Integer.parseInt(det.getCantidadMuestra()):" + aux.getCantidad());
                logger.debug("det.getCategoriaAnimal():"+aux.getCategoria());
                logger.debug("det.getRaza():"+aux.getRaza());
                logger.debug("det.getIdSexo():"+aux.getSexo());
                logger.debug("det.getUnidadTiempo():"+aux.getUnidad());
                logger.debug("Integer.parseInt(det.getEdad()):"+aux.getEdad());
                logger.debug("det.getIdTipoMuestra():"+aux.getTipoMuestra());
                logger.debug("det.getIdentificacionAnimal():"+aux.getIdentificacion());
                logger.debug("det.getIdTipoIdentificacion():"+aux.getTipo());
                logger.debug("codigosPruebas[0]:"+aux.getEnfermedad());
                logger.debug("codigosPruebas[1]:"+aux.getPrueba());
                logger.debug("Finalizando Datos MuestraLaboratorioAnimal del objeto aux.");
                
              }
              
          }
          logger.debug("Datos SolicitudDiagnosticoAnimal:");
          logger.debug("obj.getAnho():"+obj.getAnho());
          logger.debug("obj.getFechaProduccion():"+obj.getFechaProducccion());
          logger.debug("obj.getDistrito():"+obj.getDistrito());
          logger.debug("obj.getProvincia():"+obj.getProvincia());
          logger.debug("obj.getDepartamento():"+obj.getDepartamento());
          logger.debug("obj.getPredio():"+obj.getPredio());
          logger.debug("obj.getRazonSocial():"+obj.getRazonSocial());
          logger.debug("obj.getTipo():"+obj.getTipo());
          logger.debug("obj.getTipoVigilancia():"+obj.getTipoVigilancia());
          logger.debug("obj.getPrograma():"+obj.getPrograma());
          logger.debug("obj.getSede():"+obj.getSede());
          logger.debug("obj.getEmpleado():"+obj.getEmpleado());
          logger.debug("obj.getCliente():"+obj.getCliente());
            
          logger.debug("Finalizando Datos SolicitudDiagnosticoAnimal:");  
          
          Map types = con.getTypeMap();
          
          ListaGenerica tipoListaMuestras = new ListaGenerica(list);
          
          tipoListaMuestras.setSqlName(MuestraLaboratorioAnimal.SQL_TYPE_ARRAY);
          
          types.put(tipoListaMuestras.getSqlName(), ListaGenerica.class);

          //cs = con.prepareCall(sql);
            
          cs.setObject(1, obj);
          
          cs.setObject(2,tipoListaMuestras);
            
          cs.registerOutParameter(3,OracleTypes.VARCHAR);
            
          cs.execute();
            
          numeroSolicitud = cs.getString(3);
            logger.debug("numeroSolicitud = "+numeroSolicitud);
            
        } catch (SQLException e) {
              Log("solicitudAnalisisLaboratorioAnimal", e);
        } catch (Exception e) {
              Log("solicitudAnalisisLaboratorioAnimal", e);
        } finally {
          cleanup(con, cs,null);
        }
        
        return numeroSolicitud;
    }
  public String solicitudAnalisisLaboratorioVegetal(SolicitudAnalisisVegetal solicitudAnalisisVegetal) {
      int i=1;
      String traza="";
      String rpta="";
      while(i<=3){
        traza="SOL_ANALISIS_LAB_VEG INTENTO NRO " + i + " ";
        rpta=solAnalisisLaboratorioVegetal(traza, solicitudAnalisisVegetal);
        if (rpta.equals("SQLException")){
            i++;
        }else{
            i=4;
        }
      }
            
    return rpta;
      
  }
  private  synchronized String solAnalisisLaboratorioVegetal(String traza, SolicitudAnalisisVegetal solicitudAnalisisVegetal) {
      
      String numeroSolicitud = null;      
      String sql = SenasaSQL.SOLICITUD_ANALISIS_LAB_VEGETAL;      
      Log(traza+"*************** INICIO DE METODO SOLICITUD ANALISIS LABORATORIO VEGETAL ***************");      
      Log(traza+" Sp a ejecutar " + sql);      
      java.sql.Connection con =null;      
      CallableStatement cs =null;      
      
      try{
            con = helper.getConnection();
        cs= con.prepareCall(sql);
          
        SolicitudDiagnostico obj = new SolicitudDiagnostico(solicitudAnalisisVegetal);
        
        logger.debug(traza+" Inicio Datos solicitudAnalisisVegetal:");
        logger.debug(traza+"solicitudAnalisisVegetal.getCodiTipoSol() = " + solicitudAnalisisVegetal.getCodiTipoSol());
        logger.debug(traza+"solicitudAnalisisVegetal.getCodigoDepartamento() = " + solicitudAnalisisVegetal.getCodigoDepartamento());
        logger.debug(traza+"solicitudAnalisisVegetal.getCodigoDireccionEjecutiva() = " + solicitudAnalisisVegetal.getCodigoDireccionEjecutiva());
        logger.debug(traza+"solicitudAnalisisVegetal.getCodigoDistrito() = " + solicitudAnalisisVegetal.getCodigoDistrito());
        logger.debug(traza+"solicitudAnalisisVegetal.getCodigoEmplPer() = " + solicitudAnalisisVegetal.getCodigoEmplPer());
        logger.debug(traza+"solicitudAnalisisVegetal.getCodigoInspector() = " + solicitudAnalisisVegetal.getCodigoInspector());
        logger.debug(traza+"solicitudAnalisisVegetal.getCodigoPaisOrigen() = " + solicitudAnalisisVegetal.getCodigoPaisOrigen());
        logger.debug(traza+"solicitudAnalisisVegetal.getCodigoProvincia() = " + solicitudAnalisisVegetal.getCodigoProvincia());
        logger.debug(traza+"solicitudAnalisisVegetal.getCodigoSolicitante() = " + solicitudAnalisisVegetal.getCodigoSolicitante());
        logger.debug(traza+"solicitudAnalisisVegetal.getCodigoTipUsu() = " + solicitudAnalisisVegetal.getCodigoTipUsu());
        logger.debug(traza+"solicitudAnalisisVegetal.getFechaSolicitud() = " + solicitudAnalisisVegetal.getFechaSolicitud());
        logger.debug(traza+"solicitudAnalisisVegetal.getNumeroRecibo() = " + solicitudAnalisisVegetal.getNumeroRecibo());
        
        logger.debug(traza+"solicitudAnalisisVegetal.getProducto() = " + solicitudAnalisisVegetal.getProducto());
        logger.debug(traza+"solicitudAnalisisVegetal.getUsoPropuesto() = " + solicitudAnalisisVegetal.getUsoPropuesto());
        logger.debug(traza+"solicitudAnalisisVegetal.getServicioTupa() = " + solicitudAnalisisVegetal.getServicioTupa());
        logger.debug(traza+"solicitudAnalisisVegetal.getTipoEnvase() = " + solicitudAnalisisVegetal.getTipoEnvase());
          
          
        logger.debug(traza+"COMPRUEBA ULTIMA VERSION OBJETO solicitudAnalisisVegetal");
          
        logger.debug(traza+"Fin Datos solicitudAnalisisVegetal:");

        logger.debug(traza+" Fin Datos SolicitudDiagnosticoAnalisisVegetal:");
        logger.debug(traza+"Iniciando Datos de MuestraLaboratorio:");  
        ArrayList<MuestraLaboratorio> list = new ArrayList<MuestraLaboratorio>();
        for(DetalleSolicitudAnalisisVegetal det:solicitudAnalisisVegetal.getListaMuestra()){
            MuestraLaboratorio aux = new MuestraLaboratorio(det.getIdTipoMuestra(),
                                                            Double.parseDouble(det.getCantidadMuestra()),det.getIdUnidadMedida(),
                                                            Utility.toSQLDate(det.getFechaColeccion()),
                                                            Utility.toSQLDate(det.getFechaRemiteMuestra()),
                                                            det.getIdAreaLaboratorio(),det.getIdProcedenciaMuestra(),det.getCodigoMuestra(),det.getCodigoOrigen());
            
            
            logger.debug(traza+"aux.getTipoMuestra() = " + aux.getTipoMuestra());
            logger.debug(traza+"aux.getCantidad() = " + aux.getCantidad());
            logger.debug(traza+"aux.getUnidad() = " + aux.getUnidad());
            logger.debug(traza+"aux.getFechaRecoleccion() = " + aux.getFechaRecoleccion());
            logger.debug(traza+"aux.getFechaRemision() = " + aux.getFechaRemision());
            logger.debug(traza+"aux.getLaboratorio() = " + aux.getLaboratorio());
            logger.debug(traza+"aux.getProcedencia() = " + aux.getProcedencia());
            logger.debug(traza+"aux.getCodigoMuestra() = " + aux.getCodigoMuestra());
            logger.debug(traza+"aux.getCodigoOrigen() = " + aux.getCodigoOrigen());
            
            list.add(aux);
        }
        logger.debug(traza+"Finalizando Datos de MuestraLaboratorio:");
        
        //Pintando los datos del objeto SolicitudAnalisisVegetal:

        logger.debug(traza+"preparando Map callableStmt");
        Map types = con.getTypeMap();        
        ListaGenerica tipoListaMuestras = new ListaGenerica(list);        
        tipoListaMuestras.setSqlName(MuestraLaboratorio.SQL_TYPE_ARRAY);        
        types.put(tipoListaMuestras.getSqlName(), ListaGenerica.class);
        logger.debug(traza+"Seteando objetos");
        cs.setObject(1, obj);
        logger.debug(traza+"seteó objeto solicitudAnalisisVegetal");
        cs.setObject(2, tipoListaMuestras);
        logger.debug(traza+"seteó objeto MuestraLaboratorio");
        cs.registerOutParameter(3,OracleTypes.VARCHAR);
        cs.execute();
        logger.debug(traza+"Sp Ejecutado ");     
        numeroSolicitud = cs.getString(3);
        logger.debug(traza+"numeroSolicitud de retorno por el sp = "+numeroSolicitud);  
          
      } catch (SQLException e) {
          logger.error(traza+ "Error SQLException: ", e);
          logger.error(traza+ "Error SQLException e.getSQLState() == " +  e.getSQLState());
          numeroSolicitud="SQLException";
      } catch (Exception e) {
        logger.error(traza+ "Error Exception", e);
        logger.error(traza+ "Error Exception e.getMessage() == " +  e.getMessage());        
        numeroSolicitud="";
      } finally {          
        cleanup(con, cs,null);
      }
      
      return numeroSolicitud;
      
    }

    public ArrayList<TipoRechazo> listarTiposRechazos()
    {  
      String sql = SenasaSQL.OBTENER_LIST_TIPO_RECHAZO;
      
      Log(" AQUI VA EL " + sql);

      Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      ArrayList<TipoRechazo> list = new ArrayList<TipoRechazo>();
      
      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.setString(1,"RECHAZO");
          
          cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");

          cs.execute();
          
          rs = (ResultSet) cs.getObject(2);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
              list.add(new TipoRechazo(rs.getString("Codigo_Dictamen"),rs.getString("Desc_Dictamen")));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("listarSexoAnimal", e);
      } catch (Exception e) {
          Log("listarSexoAnimal", e);
      } finally {
        cleanup(con, cs,rs);
      }
      
      return list;
    }

    public ArrayList<TipoIdentificacionAnimal> listarTipoIdentificacionAnimal()
    {

        String sql = SenasaSQL.OBTENER_LIST_TIPO_IDENTF_ANIMAL;
        
        Log(" AQUI VA EL " + sql);

        Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
        CallableStatement cs =null;      
        ResultSet rs = null;
        
        ArrayList<TipoIdentificacionAnimal> list = new ArrayList<TipoIdentificacionAnimal>();
        
        try {
            con = helper.getConnection();
            cs= con.prepareCall(sql);
            
            Log(" = ANTES DE EJECUTAR = ");
            
            cs.registerOutParameter(1,OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            
            rs = (ResultSet) cs.getObject(1);
            
            Log(" = ENTRANDO = ");
            
            while (rs.next())
            {
                list.add(new TipoIdentificacionAnimal(rs.getString("Codigo_Tipo_Identificacion"),rs.getString("Desc_Tipo_Identificacion")));
            }
            
            Log(" = FIN TODITO = ");
            
        } catch (SQLException e) {
            Log("listarSexoAnimal", e);
        } catch (Exception e) {
            Log("listarSexoAnimal", e);
        } finally {
          cleanup(con, cs,rs);
        }
        
        return list;
    }

    public ArrayList<Sexo> listarSexoAnimal() {
        
      String sql = SenasaSQL.OBTENER_LIST_SEXO;
      
      Log(" AQUI VA EL " + sql);

      Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      ArrayList<Sexo> list = new ArrayList<Sexo>();
      
      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.registerOutParameter(1,OracleTypes.CURSOR, "SYS_REFCURSOR");

          cs.execute();
          
          rs = (ResultSet) cs.getObject(1);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
              list.add(new Sexo(rs.getString("codigo_sexo"),rs.getString("descripcion_sexo")));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("listarSexoAnimal", e);
      } catch (Exception e) {
          Log("listarSexoAnimal", e);
      } finally {
        cleanup(con, cs,rs);
      }
      
      return list;
    }

    public ArrayList<Raza> listarRazaAnimal(String codigoEspecie) {
        
      String sql = SenasaSQL.OBTENER_LIST_RAZA;
      
      Log(" AQUI VA EL " + sql);

      Connection con = null;//ConnectionSenasa.getSingletonObject().getConnection();
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      ArrayList<Raza> list = new ArrayList<Raza>();
      
      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.setString(1,codigoEspecie);
          
          cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");

          cs.execute();
          
          rs = (ResultSet) cs.getObject(2);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
              list.add(new Raza(rs.getString("raza_anim_raz"),rs.getString("nomb_raza_raz"),rs.getString("espe_anim_ani")));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("listarRazaAnimal", e);
      } catch (Exception e) {
          Log("listarRazaAnimal", e);
      } finally {
        cleanup(con, cs,rs);
      }
      
      return list;
    }

    public ArrayList<UnidadMedida> listarUnidadTiempo() {
        
      String sql = SenasaSQL.OBTENER_LIST_UNIDAD_MEDIDA;
      
      Log(" AQUI VA EL " + sql);

      Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      ArrayList<UnidadMedida> list = new ArrayList<UnidadMedida>();
      
      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.registerOutParameter(1,OracleTypes.CURSOR, "SYS_REFCURSOR");

          cs.execute();
          
          rs = (ResultSet) cs.getObject(1);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
              list.add(new UnidadMedida(rs.getString("codi_unid_med"),rs.getString("desc_unid_med")));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("listarUnidadTiempo", e);
      } catch (Exception e) {
          Log("listarUnidadTiempo", e);
      } finally {
        cleanup(con, cs,rs);
      }
      
      return list;
    }

  /*
  private java.sql.Connection obtenerConectividad()throws Exception{
      
        try {               
          if(dsSenasa == null){
            InitialContext ic = null;
            ic = new InitialContext();
            logger.debug("Obteniendo conexion Senasa");
            dsSenasa = (javax.sql.DataSource)ic.lookup("senasaDataSourceJNDI");
          }
          return dsSenasa.getConnection();
        } catch (NamingException ne) {
          logger.error("Error al buscar datasource : " + ne.getMessage());
          throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource senasaDataSourceJNDI " + ne);
        } catch (SQLException sqlExp) {
          logger.error("Error al obtener conexion : " + sqlExp.getMessage());
          throw new Exception("Ha ocurrido un error al tratar de obtener una conección desde el datasource senasaDataSourceJNDI "+sqlExp);
        }

      }
  */
    public ArrayList<TipoCrianza> listarTipoCrianzas() {
        
      //Sp_Lista_Tipo_Identificacion
        
      ArrayList<TipoCrianza> lista = new ArrayList<TipoCrianza>();
     
      String sql = SenasaSQL.OBTENER_LIST_TIPO_CRIANZA;
      
      Log(" AQUI VA EL " + sql);
      
      Connection con =null;// ConnectionSenasa.getSingletonObject().getConnection();
      
      //Connection con = ConnectionSenasa.getConnectionSimple();
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      try {
            con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.registerOutParameter(1,OracleTypes.CURSOR, "SYS_REFCURSOR");

          cs.execute();
          
          rs = (ResultSet) cs.getObject(1);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
              lista.add(new TipoCrianza(rs.getString("codigo_tipo_crianza"),rs.getString("desc_tipo_crianza")));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("listarTipoCrianzas", e);
      } catch (Exception e) {
          Log("listarTipoCrianzas", e);
      } finally {
        cleanup(con, cs,rs);
      }
        
      return lista;
    }
  public ArrayList<ProductoInspeccion> obtenerProductosInspeccion2(String codigoExpediente) {
    ArrayList<ProductoInspeccion> lista =new ArrayList<ProductoInspeccion>();
    return lista;
  }
  public ArrayList<ProductoInspeccion> obtenerProductosInspeccionExp(String codigoExpediente) {
      String IdLog="obtenerProductosInpeccion - " + codigoExpediente+ " ";
      Log(IdLog+" ********Inicio del Método ********");
      Connection con = null;//;ConnectionSenasa.getSingletonObject().getConnection();
      CallableStatement cs = null;
      ResultSet rs = null; 
      String sql = SenasaSQL.OBTENER_PRODUCTOS_INSPECCION_EXP;
      ArrayList<ProductoInspeccion> lista =new ArrayList<ProductoInspeccion>();
      Log(IdLog+" SP a ejecutar" + sql);
      try {
            con = helper.getConnection();  
        cs = con.prepareCall(sql);        
        cs.setString(1, codigoExpediente);         
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
        Log(IdLog+" Ejecutando SP");  
        cs.executeQuery();
        rs = (ResultSet)cs.getObject(2);
        
        Log(IdLog+" Listando datos");
        while(rs.next()){
            ProductoInspeccion b= new ProductoInspeccion();
            b.setCodigoProductoInspeccion(rs.getString("Codigo_Inspeccion_Producto"));
            b.setIdInspeccion(rs.getString("Codigo_Inspeccion")); 
            b.setCodigoProducto(rs.getString("Codigo_Producto")); 
            b.setCantidadActual(rs.getString("Cantidad_Actual")); 
            b.setCodigoServicio(rs.getString("Codigo_Servicio")); 
            b.setExpediente(rs.getString("Codigo_Expediente")); 
            b.setCantidad(rs.getString("Cantidad_Base")); 
            b.setEstado(rs.getString("Estado")); 
            b.setPersonaId(rs.getString("Persona_Id")); 
            
            lista.add(b);
        }
        rs.close();
        Log("Lista completada");;  
      } catch (SQLException e) {
        Log(IdLog+" SQLException : ", e);
      } catch (Exception e) {
        Log(IdLog+"- Exception : ", e);
      } finally {
        cleanup(con, cs,rs);
      }
      return lista;
  }
  
    public static void main(String[] args) throws SQLException {
        
        
       InspeccionDAO inspDAO = new InspeccionDAO();
      RespuestaAnalisisLaboratorio objResp = new RespuestaAnalisisLaboratorio();
      
      //objResp = inspDAO.respuestaSolicitudAnalisisLaboratorio("200814645","02");
      objResp = inspDAO.respuestaSolicitudAnalisisLaboratorio("2012100001","02");
       
      /*  
        Inspeccion inspeccion = new Inspeccion();
        
        inspeccion.setCodigoServicio("036");
        
        inspeccion.setExpediente("110600000012");
        
        ArrayList<ProductoInspeccion> listaproductos = new ArrayList<ProductoInspeccion>();
        
        listaproductos.add(new ProductoInspeccion("10", "Activo","110600000012","036","00783","20","00003304"));
        
        listaproductos.add(new ProductoInspeccion("60", "Activo","110600000012","036","00785","80","00003304"));
        
        inspeccion.setListaProducto(listaproductos);
        
        inspDAO.insertarInspeccion(inspeccion);*/
        /*
      InspeccionDAO inspDAO = new InspeccionDAO();
       SolicitudAnalisisVegetal solicitudAnalisisVegetal = new SolicitudAnalisisVegetal();
        
        solicitudAnalisisVegetal.setCodiTipoSol("BPM");
        solicitudAnalisisVegetal.setCodigoDepartamento(null);
        solicitudAnalisisVegetal.setCodigoDireccionEjecutiva("06");
        solicitudAnalisisVegetal.setCodigoDistrito(null);
        solicitudAnalisisVegetal.setCodigoEmplPer("0366");
        solicitudAnalisisVegetal.setCodigoInspector("0366");
        solicitudAnalisisVegetal.setCodigoPaisOrigen("4088");
        solicitudAnalisisVegetal.setCodigoProvincia(null);
        solicitudAnalisisVegetal.setCodigoSolicitante("1041913");
        solicitudAnalisisVegetal.setCodigoTipUsu("02");
        solicitudAnalisisVegetal.setFechaSolicitud(Utility.parseStringToDate("12/12/2011"));
      solicitudAnalisisVegetal.setNumeroRecibo(null);
      solicitudAnalisisVegetal.setProducto("04975");
      solicitudAnalisisVegetal.setUsoPropuesto("Sembradillo");
      solicitudAnalisisVegetal.setServicioTupa("003");
        
        
        ArrayList<DetalleSolicitudAnalisisVegetal> listaDetalle = new  ArrayList<DetalleSolicitudAnalisisVegetal>();
        
        DetalleSolicitudAnalisisVegetal det = new DetalleSolicitudAnalisisVegetal();
      
        det.setCantidadMuestra("4.0");
        det.setCodigoMuestra(null);
        det.setCodigoOrigen("A862300010004");
        det.setFechaColeccion(Utility.parseStringToDate("19/12/2011"));
        det.setFechaRemiteMuestra(Utility.parseStringToDate("21/12/2011"));
        det.setIdAreaLaboratorio("10");
        det.setIdProcedenciaMuestra("04");
        det.setIdTipoMuestra("085");
        det.setIdUnidadMedida("149");
        String[] listaidAnalisis ={"A862300010004"};
        det.setListaCodigoAnalisis(listaidAnalisis);
        listaDetalle.add(det);                                                                                                              
        
        solicitudAnalisisVegetal.setListaMuestra(listaDetalle);
        
      inspDAO.solicitudAnalisisLaboratorioVegetal(solicitudAnalisisVegetal);
        
        */
        
        //String[] listaidAnalisis ={"042-014","077-068"};
        
        //solicitudAnalisisAnimal.setListaidAnalisis(listaidAnalisis);
        
        //inspDAO.solicitudAnalisisLaboratorioAnimal(solicitudAnalisisAnimal); 
        
        
        //inspDAO.actualizarProductoInspeccion(new ProductoInspeccion("8","INACTIVO","30","00003304"));      
        
        
        //inspDAO.registrarLote(new Lote("3", "1", "5", "30","EN ESPERA", "8", "00783", "Prueba Daniel 222"));
        
        
        //inspDAO.registrarConcepto(new Concepto("3","1","5","5","ANALISIS","1","30",null,null,"http://prueba.daniel/eueuey.pdf","RECHAZADO",new Date(System.currentTimeMillis()),"3","00783"));
        
        //InspeccionDAO inspDAO = new InspeccionDAO();
        
       //System.out.println(inspDAO.listarTipoCrianzas().size());
        
       //System.out.println(inspDAO.consultarLote("3"));
        
       //System.out.println(inspDAO.consultarConcepto("3"));
    }
    
}
