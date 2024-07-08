package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.EmpresasFumigadoras;
import pe.gob.senasa.bean.Expediente;
import pe.gob.senasa.bean.ExpedienteTratamiento;
import pe.gob.senasa.bean.MotivoTratamiento;
import pe.gob.senasa.bean.Plaga;
import pe.gob.senasa.bean.TipoTratamiento;
import pe.gob.senasa.bean.Tratamiento;
import pe.gob.senasa.bean.TratamientoInspeccion;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.TratamientoInterface;
import pe.gob.senasa.util.Utility;


public class TratamientoDAO extends BaseDAO implements TratamientoInterface {

    protected static Logger logger = Logger.getLogger(TratamientoDAO.class);

   private DBHelper helper;
   
    public TratamientoDAO() {
        super();
        helper = new DBHelper(SenasaSQL.dsTratamiento);
    }

    /**
     * 
     * @return
     */
    public ArrayList<MotivoTratamiento> obtenerMotivosTratamientos() {
        
      ArrayList<MotivoTratamiento> list=new ArrayList<MotivoTratamiento>();
      
      String sql = SenasaSQL.OBTENER__LIST_MOTIVO_TRATAMIENTO;
      
      Log(" AQUI VA EL " + sql);
      
      Connection con = null;
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
              list.add(new MotivoTratamiento(rs.getString("codigo_motivo"), rs.getString("descripcion_motivo"),null));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("listaMotivoTratamiento", e);
      } catch (Exception e) {
          Log("listaMotivoTratamiento", e);
      } finally {
            cleanup(con, cs);
      }
       
      return list;
    }

    public ArrayList<Plaga> obtenerPlagas() {
        String sql = SenasaSQL.OBTENER_PLAGAS;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<Plaga> retval = new ArrayList<Plaga>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtPlaga(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
            cleanup(con, pst);
        }
        return retval;
    }

    public ArrayList<EmpresasFumigadoras> obtenerEmpresasFumigadoras() {
        String sql = SenasaSQL.OBTENER_EMPRESAS_FUMIGADORAS;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<EmpresasFumigadoras> retval =
            new ArrayList<EmpresasFumigadoras>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtEmpresaFumigadora(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
            cleanup(con, pst);
        }
        return retval;
    }

    public ArrayList<Tratamiento> obtenerTratamientos() {
        String sql = SenasaSQL.OBTENER_TRATAMIENTOS;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<Tratamiento> retval = new ArrayList<Tratamiento>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtTratamiento(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
            cleanup(con, pst);
        }
        return retval;
    }

    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("TratamientoDAO - " + s, p2);
    }

    private Plaga obtPlaga(ResultSet rs) throws SQLException {
        Plaga plaga = new Plaga();
        plaga.setCodPlaga(rs.getString(1));
        plaga.setPlaga(rs.getString(2));
        return plaga;
    }

    private EmpresasFumigadoras obtEmpresaFumigadora(ResultSet rs) throws SQLException {
        EmpresasFumigadoras emf = new EmpresasFumigadoras();
        emf.setCodEmpresaFumigadora(rs.getString(1));
        emf.setEmpresaFumigadora(rs.getString(2));
        return emf;
    }

    private Tratamiento obtTratamiento(ResultSet rs) throws SQLException {
        Tratamiento ret = new Tratamiento();
        ret.setCodigoTratamiento(rs.getString(1));
        ret.setDescripcionTratamiento(rs.getString(2));
        ret.setTipoTratamiento(rs.getString(3));
        return ret;
    }

    private MotivoTratamiento obtMotivoTratamiento(ResultSet rs) throws SQLException {
        MotivoTratamiento ret = new MotivoTratamiento();
        ret.setCodMotivoTratamiento(rs.getString(1));
        ret.setMotivoTratamiento(rs.getString(2));
        ret.setTipoTratamiento(rs.getString(3));
        return ret;
    }


  public ArrayList<TipoTratamiento> obtenerTipoTratamientos(String codigoClase)
  {
      String sql = SenasaSQL.OBTENER_TIPOS_TRATAMIENTOS_X_CLASE;
      
      Log(" AQUI VA EL " + sql);

      Connection con = null;
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      ArrayList<TipoTratamiento> list = new ArrayList<TipoTratamiento>();
      
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
              list.add(new TipoTratamiento(rs.getString("Codigo_Clase"),rs.getString("Codigo_Tipo_Tratamiento"),rs.getString("Descripcion_Tipo_Tratamiento")));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("obtenerTipoEnvase", e);
      } catch (Exception e) {
          Log("obtenerTipoEnvase", e);
      } finally {
            cleanup(con, cs);
      }
      
      return list;
  }
  

  public ArrayList<Tratamiento> obtenerTratamientosXTipoClase(String idTipoTratamiento,String codigoClase)
  {
     ArrayList<Tratamiento> list=new ArrayList<Tratamiento>();
     
     String sql = SenasaSQL.OBTENER__TRATAMIENTOS_X_CLASE_TIPO;
    
     Log(" AQUI VA EL " + sql);
     
     Connection con = null;
     CallableStatement cs =null;      
     ResultSet rs = null;
     
     try {

          con = helper.getConnection();
         
         cs= con.prepareCall(sql);
         
         Log(" = ANTES DE EJECUTAR = ");
         
         cs.setString(1,codigoClase);
         
         cs.setString(2,idTipoTratamiento);
         
         cs.registerOutParameter(3,OracleTypes.CURSOR, "SYS_REFCURSOR");
         
         cs.execute();
         
         rs = (ResultSet) cs.getObject(3);
         
         Log(" = ENTRANDO = ");
         
         while (rs.next())
         {
             list.add(new Tratamiento(rs.getString("Codigo_Tratamiento"),
                                      rs.getString("Codigo_Tipo_Tratamiento"),
                                      rs.getString("Descripcion_Tratamiento"),
                                      rs.getString("Codigo_Producto_Quimico"),
                                      rs.getString("Codigo_Clase"),
                                      rs.getString("Tiempo"),
                                      rs.getString("Codi_Unid_Med_Tiemp"),
                                      rs.getString("Dosis"),
                                      rs.getString("Codi_Unid_Med_Dosis"),
                                      rs.getString("Temperatura_Maxima"),
                                      rs.getString("Temperatura_Minima"),
                                      rs.getString("Codi_Unid_Med_Temperatura")));
         }
         
         Log(" = FIN TODITO = ");
         
     } catch (SQLException e) {
         Log("obtenerTipoEnvase", e);
     } catch (Exception e) {
         Log("obtenerTipoEnvase", e);
     } finally {
            cleanup(con, cs);
     }
      
     return list;
   }


    public ArrayList<Plaga> listarPlagasTratamiento(String descripcion,String codigoClase) 
    {
      ArrayList<Plaga> list=new ArrayList<Plaga>();
      
      String sql = SenasaSQL.OBTENER__LIST_PLAGA_TRATAMIENTO;
      
      Log(" AQUI VA EL " + sql);
      
      Connection con = null;
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      try {          
          con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.setString(1,descripcion);
          
          cs.setString(2,codigoClase);
          
          cs.registerOutParameter(3,OracleTypes.CURSOR, "SYS_REFCURSOR");
          
          cs.execute();
          
          rs = (ResultSet) cs.getObject(3);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
              list.add(new Plaga(rs.getString("codigo"), rs.getString("nombre_cientifico"), rs.getString("nombre_comun")));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("obtenerTipoEnvase", e);
      } catch (Exception e) {
          Log("obtenerTipoEnvase", e);
      } finally {
            cleanup(con, cs);
      }
       
      return list;
    }

    public EmpresasFumigadoras obtenerEmpresaFumigadoraXRUC(String numeroRegistro) {
      
      EmpresasFumigadoras empresa=null;  
        
      String sql = SenasaSQL.OBTENER__EMPRESA_FUMIGADORA;
      
      Log(" AQUI VA EL " + sql);
      
      Connection con = null;
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      try {
          con = helper.getConnection();
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.setString(1,numeroRegistro);
          
          cs.registerOutParameter(2,OracleTypes.CURSOR, "SYS_REFCURSOR");
          
          cs.execute();
          
          rs = (ResultSet) cs.getObject(2);
          
          Log(" = ENTRANDO = ");
          
          while (rs.next())
          {
            empresa = new EmpresasFumigadoras();
              
            empresa.setCodEmpresaFumigadora(rs.getString("persona_id"));
              
            empresa.setEmpresaFumigadora(rs.getString("nombre_razon_social"));
          }
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("obtenerEmpresaFumigadoraXRUC", e);
      } catch (Exception e) {
          Log("obtenerEmpresaFumigadoraXRUC", e);
      } finally {
            cleanup(con, cs);
      }
       
        
        return empresa;
    }

    public boolean registrarTratamientoInspeccion(ExpedienteTratamiento lista) 
    {
        boolean registroExitoso = true;
        
        String sql = SenasaSQL.INSERTAR_INSPECCION_TRATAMIENTO;
        
        Log(" AQUI VA EL " + sql);
        
        Log("tratamientoInspecciones.size():"+lista.getLista().size());
        
        Connection con = null;
        CallableStatement cs =null;      
        ResultSet rs = null;
        TratamientoInspeccion tratamientoInspeccion = null;
        try{
            con = helper.getConnection();
            for(int i = 0; i < lista.getLista().size() ; i++)
            {       
                tratamientoInspeccion = lista.getLista().get(i);
            
                cs= con.prepareCall(sql);
                
                Log(" = ANTES DE EJECUTAR TratamientoInspeccion = ");
                
                cs.setString(1,tratamientoInspeccion.getCodExpediente());
                cs.setString(2,tratamientoInspeccion.getCodServicio());
                cs.setString(3,tratamientoInspeccion.getCodProducto());
                cs.setString(4,tratamientoInspeccion.getCodTratamiento());
                cs.setString(5,tratamientoInspeccion.getCodTipoTratamiento());
                cs.setDate(6,Utility.toSQLDate(tratamientoInspeccion.getFechaTratamiento()));
                cs.setString(7,tratamientoInspeccion.getEmpresaIdAplica());
                cs.setString(8,tratamientoInspeccion.getDosis());
                cs.setString(9,tratamientoInspeccion.getTiempo());
                cs.setString(10,tratamientoInspeccion.getDuracion());
                cs.setString(11,tratamientoInspeccion.getCodProductoQuimico());
                cs.setString(12,tratamientoInspeccion.getCodMotivo());
                cs.setString(13,tratamientoInspeccion.getCodEnfermedadPlaga());
                cs.setString(14,tratamientoInspeccion.getUsuarioInspector());
                
                cs.execute();
                
            }
             
        } catch (SQLException e) {
            Log("registrarTratamientoInspeccion", e);
            registroExitoso=false;
        } catch (Exception e) {
            Log("registrarTratamientoInspeccion", e);
            registroExitoso=false;
        } finally {
            cleanup(con, cs);
        }
        
        return registroExitoso;
    }
    
    public ExpedienteTratamiento obtenerDatosTratamiento(String codigoExpediente, String codigoServicio) {
        
      ExpedienteTratamiento expTrat=new ExpedienteTratamiento();  
        
      String sql = SenasaSQL.OBTENER_INSPECCION_TRATAMIENTO;
      
      Log(" AQUI VA EL " + sql);
      
      Connection con = null;
      CallableStatement cs =null;      
      ResultSet rs = null;
      
      try {

          con = helper.getConnection();
          
          cs= con.prepareCall(sql);
          
          Log(" = ANTES DE EJECUTAR = ");
          
          cs.setString(1,codigoExpediente);
          cs.setString(2,codigoServicio);
          
          cs.registerOutParameter(3,OracleTypes.CURSOR, "SYS_REFCURSOR");
          
          cs.execute();
          
          rs = (ResultSet) cs.getObject(3);
          
          Log(" = ENTRANDO = ");
          
          ArrayList<TratamientoInspeccion> listObjTrat = new ArrayList<TratamientoInspeccion>();
          while (rs.next())
          {
            
            TratamientoInspeccion objTrat = new TratamientoInspeccion();
            objTrat.setCodExpediente(rs.getString("Codigo_Expediente"));  
            objTrat.setCodServicio(rs.getString("Codigo_Servicio"));  
            objTrat.setCodProducto(rs.getString("Codigo_Producto"));  
            objTrat.setCodTratamiento(rs.getString("Codigo_Tratamiento"));  
            objTrat.setDescripcionTratamiento(rs.getString("Descripcion_Tratamiento"));  
            objTrat.setCodTipoTratamiento(rs.getString("Codigo_Tipo_Tratamiento"));  
            objTrat.setDescripcionTipoTratamiento(rs.getString("Descripcion_Tipo_Tratamiento"));  
            objTrat.setFechaTratamiento(rs.getDate("Fecha_Tratamiento"));  
            objTrat.setEmpresaIdAplica(rs.getString("Empresa_Id_Aplica"));  
            objTrat.setRazonSocialEmpresa(rs.getString("Nombre_Razon_Social"));  
            objTrat.setDosis(rs.getString("Dosis"));  
            objTrat.setTiempo(rs.getString("Tiempo"));  
            objTrat.setDuracion(rs.getString("Duracion"));  
            objTrat.setCodProductoQuimico(rs.getString("Codigo_Producto_Quimico"));  
            objTrat.setCodMotivo(rs.getString("Codigo_Motivo"));  
            objTrat.setDescripcionMotivo(rs.getString("Descripcion_Motivo"));  
            objTrat.setCodEnfermedadPlaga(rs.getString("Codigo_Enfermedad_Plaga"));  
            objTrat.setDescripcionEnfermedadPlaga(rs.getString("Descripcion_Enfermedad_Plaga"));  
            
            listObjTrat.add(objTrat);  
            
          }
        expTrat.setLista(listObjTrat);
          
          
          Log(" = FIN TODITO = ");
          
      } catch (SQLException e) {
          Log("obtenerDatosTratamiento", e);
      } catch (Exception e) {
          Log("obtenerDatosTratamiento", e);
      } finally {
            cleanup(con, cs);
      }
       
        
        return expTrat;
    }
    
  public static void main(String[] args) {
  
       TratamientoDAO obj = new TratamientoDAO();
       ExpedienteTratamiento result = new ExpedienteTratamiento(); 
       Expediente exp = new Expediente();
    //ArrayList<Recibo> arrRecibos =  new ArrayList<Recibo>();
    
       //result = tupa.anularServicioExpediente("110100000022", "114");
       //arrRecibos = tupa.obtenerListaRecibos("112100000008", "001");
       result = obj.obtenerDatosTratamiento("110600000411", "014");
   
  }
}
