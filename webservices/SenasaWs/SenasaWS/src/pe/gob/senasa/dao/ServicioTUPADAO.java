package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Analisis;
import pe.gob.senasa.bean.AreaGestion;
import pe.gob.senasa.bean.CentroTramite;
import pe.gob.senasa.bean.ExpPersonaJuridica;
import pe.gob.senasa.bean.ExpPersonaNatural;
import pe.gob.senasa.bean.Expediente;
import pe.gob.senasa.bean.OperLogisticoJuridica;
import pe.gob.senasa.bean.OperLogisticoNatural;
import pe.gob.senasa.bean.Operador;
import pe.gob.senasa.bean.Producto;
import pe.gob.senasa.bean.Recibo;
import pe.gob.senasa.bean.RequisitoServicio;
import pe.gob.senasa.bean.Sede;
import pe.gob.senasa.bean.ServicioClase;
import pe.gob.senasa.bean.ServicioTUPA;
import pe.gob.senasa.bean.Solicitante;
import pe.gob.senasa.bean.Vacuna;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.ServicioTUPAInterface;


public class ServicioTUPADAO extends BaseDAO implements ServicioTUPAInterface {
    
    protected static Logger logger = Logger.getLogger(ServicioTUPADAO.class);
    private DBHelper helper;
    public ServicioTUPADAO() {
        super();
        helper = new DBHelper(SenasaSQL.dsServicioTUPA);
    }

    public ArrayList<ServicioTUPA> obtenerServiciosTupa() {
        String sql = SenasaSQL.OBTENER_SERVICIOS_TUPA;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<ServicioTUPA> retval = new ArrayList<ServicioTUPA>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtServicioTupa(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerServiciosTupa", e);
        } catch (Exception e) {
            Log("obtenerServiciosTupa", e);
        } finally {
            cleanup(con, pst);
        }
        return retval;
    }

    public String obtenerNumeroExpediente(String servicioTupa,String sede,String cliente) {
        String sql = SenasaSQL.OBTENER_NUMERO_EXPEDIENTE;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        ResultSet rs = null;
        CallableStatement cs = null;
        String retval = "";
        Log("VOY A GENERAR EL NUMERO DE EXPEDIENTE CON ==>>");
        Log("SEDE = "+sede);
        Log("cliente "+cliente);
        try {
            con = helper.getConnection();
            cs = con.prepareCall("{ " + SenasaSQL.OBTENER_NUMERO_EXPEDIENTE + " }");
            cs.setString(1, sede);
            cs.setString(2, cliente);
            cs.setString(3, servicioTupa);
          
            cs.registerOutParameter(4, Types.VARCHAR);
            Log(" = PARAMETROS = ");
            
            logger.debug(" = servicioTupa = " + servicioTupa);
            logger.debug(" = sede = " + sede);
            logger.debug(" = cliente = "+cliente);
            
            Log(" = ANTES DE EJECUTAR = ");
            cs.execute();
            Log(" = VIENDO LOS RESULTADOS = ");
            retval = cs.getString(4);
            Log(" = ESTE ES EL RESULTADO =>>> " + retval);
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerNumeroExpediente", e);
        } catch (Exception e) {
            Log("obtenerNumeroExpediente", e);
        } finally {
            cleanup(con, cs);
        }
        return retval;
    }


    public String obtenerNumeroCertificado(String servicioTupa,String sede) {
        String sql = SenasaSQL.OBTENER_NUMERO_CERTIFICADO;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        ResultSet rs = null;
        CallableStatement cs = null;
        String retval = "";
        Log("VOY A GENERAR EL NUMERO DE CERTIFICADO CON ==>>");
        Log("SEDE = "+sede);
        try {
            con = helper.getConnection();
            cs = con.prepareCall("{ "+sql + " }");
            cs.setString(1, sede);
            cs.setString(2, servicioTupa);
            cs.registerOutParameter(3, Types.VARCHAR);
            Log(" = PARAMETROS = ");
            
            Log(" = servicioTupa = " + servicioTupa);
            Log(" = sede = " + sede);

            Log(" = ANTES DE EJECUTAR = ");
            cs.execute();
            Log(" = VIENDO LOS RESULTADOS = ");
            retval = cs.getString(3);
            Log(" = ESTE ES EL RESULTADO =>>> " + retval);
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerNumeroExpediente", e);
        } catch (Exception e) {
            Log("obtenerNumeroExpediente", e);
        } finally {
            cleanup(con, cs);
        }
        return retval;
    }
    
    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("ServicioTUPADAO - " + s, p2);
    }

    private ServicioTUPA obtServicioTupa(ResultSet rs) throws SQLException {
        ServicioTUPA stp = new ServicioTUPA();
        stp.setCodServicioTupa(rs.getString(1));
        stp.setNombreServicioTupa(rs.getString(2));
        return stp;
    }
    
    private AreaGestion obtAreaGestion(ResultSet rs) throws SQLException {
      AreaGestion stp = new AreaGestion();
      stp.setCodigoAreaGestion(rs.getString(1));
      stp.setNombreAreaGestion(rs.getString(2));
      stp.setCodigoClase(rs.getString(3));
      return stp;
    }
    
  private CentroTramite obtCentroTramite(ResultSet rs) throws SQLException {
    CentroTramite stp = new CentroTramite();
    stp.setCodigoCentroTramite(rs.getString(1));
    stp.setCentroTramite(rs.getString(2));
    return stp;
  }
    
  private ServicioTUPA obtServicioTramite(ResultSet rs) throws SQLException {
    //ServicioTramite stp = new ServicioTramite();
    ServicioTUPA stp = new ServicioTUPA();
    stp.setNombreServicioTupa(rs.getString(1));
    stp.setCodServicioTupa(rs.getString(2));
    stp.setDescripcionCentroTramite(rs.getString(3));
    stp.setCodigoCentroTramite(rs.getString(4));
    stp.setCodigoClase(rs.getString(5));
    stp.setFlagImpoExpo(rs.getString(6));
    return stp;
  }
  private RequisitoServicio obtRequisitoServicio(ResultSet rs) throws SQLException {
    RequisitoServicio stp = new RequisitoServicio();
    stp.setCodigoServicio(rs.getString(1));
    stp.setDescripcionServicio(rs.getString(2));
    stp.setCodigoDocumento(rs.getString(3));
    stp.setDescripcionDocumento(rs.getString(4));
    //stp.setIndicador(rs.getString(5));
    stp.setIndObligatorio(rs.getString(5));
    stp.setSubTipo(rs.getString(6));
    stp.setRutaCheckIn(rs.getString(7));
    return stp;
  }
  
  private ExpPersonaNatural obtExpPersonaNatural(ResultSet rs) throws SQLException {
    ExpPersonaNatural stp = new ExpPersonaNatural();
    stp.setCodigoExpediente(rs.getString(1));
    stp.setDocumentoNumero(rs.getString(2));
    stp.setNombreRazonSocial(rs.getString(3));
    stp.setPersonaTipo(rs.getString(4));
    return stp;
  }
  private ExpPersonaJuridica obtExpPersonaJuridica(ResultSet rs) throws SQLException {
    ExpPersonaJuridica stp = new ExpPersonaJuridica();
    stp.setCodigoExpediente(rs.getString(1));
    stp.setRuc(rs.getString(2));
    stp.setNombreRazonSocial(rs.getString(3));
    stp.setPersonaTipo(rs.getString(4));
    return stp;
  }

  public String obtenerServicio(String codigoServicio) {
    return null;
  }
    public String obtenerDescripcionServicio(String codigoServicio) {
      
      String retval = "";
      String sql = SenasaSQL.OBTENER_SERVICIO_TUPA;
      Log(" AQUI VA EL " + sql);
      Log(" = obtenerDescripcionServicio = ");
      Log("   codigoServicio = "+ codigoServicio);
      Connection con = null;    
      PreparedStatement pst = null;     
      ResultSet rs = null;
      
      try {
          pst = con.prepareStatement(sql);
          Log(" = ANTES DE EJECUTAR = ");
          pst.setString(1, codigoServicio);
          rs = pst.executeQuery();
          Log(" = ENTRANDO = ");
          while (rs.next())
          {
              retval = rs.getString(2);
          }
          Log(" = FIN obtenerDescripcionServicio = ");
      } catch (SQLException e) {
          Log("obtenerDescripcionServicio", e);
      } catch (Exception e) {
          Log("obtenerDescripcionServicio", e);
      } finally {
            cleanup(con, pst);
      }
      
      return retval;
        
    }

    public boolean servicioTupaCobrarPorProducto(String codigoServicio)
    {
      boolean cobro = false;
      String sql = SenasaSQL.OBTENER_SERVICIO_TUPA;
      Log(" AQUI VA EL " + sql);
      Log(" = servicioTupaCobrarPorProducto = ");
      Log("   codigoServicio = "+ codigoServicio);
      Connection con = null;
      
      PreparedStatement pst = null;
      
      ResultSet rs = null;
      
      try {
            con = helper.getConnection();
          pst = con.prepareStatement(sql);
          Log(" = ANTES DE EJECUTAR = ");
          pst.setString(1, codigoServicio);
          rs = pst.executeQuery();
          Log(" = ENTRANDO = ");
          while (rs.next())
          {
              String indicador = rs.getString(3);
              logger.debug("indicador: "+indicador);
              
              if(indicador !=null && indicador.toUpperCase().equals("X"))
              {
                  cobro = true;
                  break;
              }
              
          }
          Log(" = FIN servicioTupaCobrarPorProducto = ");
      } catch (SQLException e) {
          Log("servicioTupaCobrarPorProducto", e);
      } catch (Exception e) {
          Log("servicioTupaCobrarPorProducto", e);
      } finally {
            cleanup(con, pst);
      }
      
      return cobro;
    }
    
    public ArrayList<AreaGestion> obtenerAreasGestion(){
      
      String sql = SenasaSQL.OBTENER_AREA_GESTION;
      Log(" AQUI VA EL " + sql);

      Connection con = null;
      PreparedStatement pst = null;
      CallableStatement cs = null;
      ResultSet rs = null;

      ArrayList<AreaGestion> retval = new ArrayList<AreaGestion>();
      try {
            con = helper.getConnection();
          pst = con.prepareStatement(sql);
          cs = con.prepareCall(sql);
          cs.registerOutParameter(1,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
          Log(" = ANTES DE EJECUTAR = ");
          //rs = pst.executeQuery();
          cs.execute();
          Log(" = ENTRANDO = ");  
          rs = (ResultSet)cs.getObject(1);

          while (rs.next()) {
              retval.add(obtAreaGestion(rs));
          }
          Log(" = FIN TODITO = ");
      } catch (SQLException e) {
          Log("obtenerAreasGestion", e);
      } catch (Exception e) {
          Log("obtenerAreasGestion", e);
      } finally {
            cleanup(con, cs);
      }
      return retval;
    }
    
  public ArrayList<CentroTramite> obtenerCentrosTramite(){
    
    String sql = SenasaSQL.OBTENER_CENTRO_TRAMITE_TODOS;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<CentroTramite> retval = new ArrayList<CentroTramite>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
      
        cs.registerOutParameter(1,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        Log(" = ANTES DE EJECUTAR = ");
        //rs = pst.executeQuery();
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(1);

        while (rs.next()) {
            retval.add(obtCentroTramite(rs));
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerCentrosTramite", e);
    } catch (Exception e) {
        Log("obtenerCentrosTramite", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
    
  }
  
  public ArrayList<CentroTramite> obtenerCentrosTramitePorDepartamento(String codDepartamento){
    
    String sql = SenasaSQL.OBTENER_CENTRO_POR_DEPARTAMENTO;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<CentroTramite> retval = new ArrayList<CentroTramite>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
      
      cs.setString(1, codDepartamento);
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        Log(" = ANTES DE EJECUTAR = ");
        //rs = pst.executeQuery();
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(2);

        while (rs.next()) {
            retval.add(obtCentroTramite(rs));
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerCentrosTramite", e);
    } catch (Exception e) {
        Log("obtenerCentrosTramite", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
    
  }
    
  public ArrayList<ServicioTUPA> obtenerServicioXCentroTramite(String codigoCentroTramite, String codigoAreaGestion ){
    
    String sql = SenasaSQL.OBTENER_SERVICIO_X_CENTROTRAMITE;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    ArrayList<ServicioTUPA> retval = new ArrayList<ServicioTUPA>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
      
        Log(" = ANTES DE EJECUTAR = ");
        cs.setString(1, codigoCentroTramite);
        cs.setString(2, codigoAreaGestion);
        cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
      
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(3);
        
        while (rs.next()) {
            retval.add(obtServicioTramite(rs));
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerAreasGestion", e);
    } catch (Exception e) {
        Log("obtenerAreasGestion", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
    
  }
  
  public ArrayList<RequisitoServicio> obtenerRequisitoXServicio(String codigoServicio){
    
    String sql = SenasaSQL.OBTENER_REQUISITOS_X_SERVICIO;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<RequisitoServicio> retval = new ArrayList<RequisitoServicio>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        
        Log(" = ANTES DE EJECUTAR = ");
        cs.setString(1, codigoServicio);
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(2);
        while (rs.next()) {
            retval.add(obtRequisitoServicio(rs));
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerAreasGestion", e);
    } catch (Exception e) {
        Log("obtenerAreasGestion", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
    
  }
/*--------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------*/
  public ArrayList<ExpPersonaNatural> obtenerExpedientePersonaNatural(String codigoExpediente){
    
    String sql = SenasaSQL.OBTENER_EXPEDIENTE_PERSONANATURAL;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<ExpPersonaNatural> retval = new ArrayList<ExpPersonaNatural>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        
        Log(" = ANTES DE EJECUTAR = ");
        cs.setString(1, codigoExpediente);
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(2);
        while (rs.next()) {
            retval.add(obtExpPersonaNatural(rs));
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerExpedientePersonaNatural", e);
    } catch (Exception e) {
        Log("obtenerExpedientePersonaNatural", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
    
  }
  
  public ArrayList<ExpPersonaJuridica> obtenerExpedientePersonaJuridica(String codigoExpediente){
    
    String sql = SenasaSQL.OBTENER_EXPEDIENTE_PERSONAJURIDICA;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<ExpPersonaJuridica> retval = new ArrayList<ExpPersonaJuridica>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        
        Log(" = ANTES DE EJECUTAR = ");
        cs.setString(1, codigoExpediente);
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(2);
        while (rs.next()) {
            retval.add(obtExpPersonaJuridica(rs));
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerExpedientePersonaJuridica", e);
    } catch (Exception e) {
        Log("obtenerExpedientePersonaJuridica", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
    
  }

  public ArrayList<OperLogisticoNatural> obtenerOperLogisticoNatural(){
    
    String sql = SenasaSQL.OBTENER_OPERADORLOGISTICO_NATURAL;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<OperLogisticoNatural> retval = new ArrayList<OperLogisticoNatural>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        
        Log(" = ANTES DE EJECUTAR = ");
        cs.registerOutParameter(1,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(1);
        while (rs.next()) {
            OperLogisticoNatural oper = new OperLogisticoNatural();
            oper.setDocumentoNumero(rs.getString(1));
            oper.setNombreRazonSocial(rs.getString(2));
            oper.setPersonaTipo(rs.getString(3));
            retval.add(oper);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerOperLogisticoNatural", e);
    } catch (Exception e) {
        Log("obtenerOperLogisticoNatural", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
  public ArrayList<OperLogisticoJuridica> obtenerOperLogisticoJuridica(){
    
    String sql = SenasaSQL.OBTENER_OPERADORLOGISTICO_JURIDICA;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<OperLogisticoJuridica> retval = new ArrayList<OperLogisticoJuridica>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        
        Log(" = ANTES DE EJECUTAR = ");
        cs.registerOutParameter(1,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(1);
        while (rs.next()) {
            OperLogisticoJuridica oper = new OperLogisticoJuridica();
            oper.setRuc(rs.getString(1));
            oper.setNombreRazonSocial(rs.getString(2));
            oper.setPersonaTipo(rs.getString(3));
            retval.add(oper);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerOperLogisticoJuridica", e);
    } catch (Exception e) {
        Log("obtenerOperLogisticoJuridica", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
  public String obtenerClaseExpServicio(String codigoExpediente){
    
    String sql = SenasaSQL.OBTENER_EXPEDIENTE_CLASE_X_SERVICIO;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    //ArrayList<ExpedienteServicio> retval = new ArrayList<ExpedienteServicio>();
    String retval = "";
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        
        Log(" = ANTES DE EJECUTAR = ");
        cs.setString(1, codigoExpediente);
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(2);
        while (rs.next()) {
            retval = rs.getString(2);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerClaseExpServicio", e);
    } catch (Exception e) {
        Log("obtenerClaseExpServicio", e);
    } finally {
            cleanup(con, cs);
    }
    
    return retval;
    
  }
  
  public ArrayList<ServicioClase> obtenerServiciosXClase(String codigoClase){
    
    String sql = SenasaSQL.OBTENER_SERVICIO_CLASE;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<ServicioClase> retval = new ArrayList<ServicioClase>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        
        Log(" = ANTES DE EJECUTAR = ");
        cs.setString(1, codigoClase);
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(2);
        while (rs.next()) {
            ServicioClase serv = new ServicioClase();
            serv.setCodigoServicio(rs.getString(1));
            serv.setDescripcionServicio(rs.getString(2));
            serv.setIndCobroXProducto(rs.getString(3));
            serv.setIndServicioSecundario(rs.getString(4));
            serv.setCodigoClase(rs.getString(5));
            retval.add(serv);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerServiciosXClase", e);
    } catch (Exception e) {
        Log("obtenerServiciosXClase", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
    
  }
  
  public String obtenerInspeccionesExpediente(String codigoExpediente, String codigoServicio)
  {
    String numInspeccion = "0";
    String sql = SenasaSQL.OBTENER_NUMERO_INSPECCIONES;
    Log(" AQUI VA EL " + sql);
    Log(" = obtenerInspeccionesExpediente = ");
    Log("   codigoExpediente = "+ codigoExpediente);
    Log("   codigoServicio = "+ codigoServicio);
    
    Connection con = null;
    
    PreparedStatement pst = null;
    
    ResultSet rs = null;
    
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        Log(" = ANTES DE EJECUTAR = ");
        pst.setString(1, codigoExpediente);
        pst.setString(2, codigoServicio);
        rs = pst.executeQuery();
        Log(" = ENTRANDO = ");
        while (rs.next())
        {
            numInspeccion = rs.getString(1);
        }
        Log(" = FIN obtenerInspeccionesExpediente = ");
    } catch (SQLException e) {
        Log("obtenerInspeccionesExpediente", e);
    } catch (Exception e) {
        Log("obtenerInspeccionesExpediente", e);
    } finally {
            cleanup(con, pst);
    }
    return numInspeccion;
    
  }
  
  public String obtenerTipoServicioExpediente(String codigoExpediente, String codigoServicio)
  {
    String numTipo = "0";
    String sql = SenasaSQL.OBTENER_TIPO_SERVICIO;
    Log(" AQUI VA EL " + sql);
    Log(" = obtenerTipoServicioExpediente = ");
    Log("   codigoExpediente = "+ codigoExpediente);
    Log("   codigoServicio = "+ codigoServicio);
    
    Connection con =  null;
    
    PreparedStatement pst = null;
    
    ResultSet rs = null;
    
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        Log(" = ANTES DE EJECUTAR = ");
        pst.setString(1, codigoExpediente);
        pst.setString(2, codigoServicio);
        rs = pst.executeQuery();
        Log(" = ENTRANDO = ");
        while (rs.next())
        {
            numTipo = rs.getString(1);
        }
        Log(" = FIN obtenerTipoServicioExpediente = ");
    } catch (SQLException e) {
        Log("obtenerTipoServicioExpediente", e);
    } catch (Exception e) {
        Log("obtenerTipoServicioExpediente", e);
    } finally {
            cleanup(con, pst);
    }
    return numTipo;
    
  }
  
  public ArrayList<Sede> obtenerPuntosIngreso(String codigoExpediente, String codigoServicio){
    
    String sql = SenasaSQL.OBTENER_PUNTOSINGRESO_EXPEDIENTE;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<Sede> retval = new ArrayList<Sede>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        cs.setString(1, codigoExpediente);
        cs.setString(2, codigoServicio);
        Log(" = ANTES DE EJECUTAR = ");
        cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(3);
        while (rs.next()) {
            Sede oper = new Sede();
            oper.setCodSede(rs.getString(1));
            retval.add(oper);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerPuntosIngreso", e);
    } catch (Exception e) {
        Log("obtenerPuntosIngreso", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
  public ArrayList<Producto> obtenerProductosExp(String codigoExpediente, String codPuntoIngreso){
    
    String sql = SenasaSQL.OBTENER_PRODUCTOS;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<Producto> retval = new ArrayList<Producto>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        cs.setString(1, codigoExpediente);
        cs.setString(2, codPuntoIngreso);
        Log(" = ANTES DE EJECUTAR = ");
        cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(3);
        while (rs.next()) {
            Producto oper = new Producto();
            oper.setCodigoProducto(rs.getString("Codigo_Producto"));
            oper.setCodigoAplicacion(rs.getString("Codigo_Aplicacion"));
            oper.setCantidadPesoAprobado(rs.getString("Cantidad_Peso_Aprobado"));
            oper.setCodigoUnidadMedida(rs.getString("Codi_Unid_Med"));
            oper.setCodigoLugarInspeccion(rs.getString("Codigo_Lugar_Inspeccion"));
            oper.setCantidadPesoSolicitado(rs.getString("Cantidad_Peso_Solicitado"));
            oper.setDescripcion(rs.getString("Nombre_Comercial_Producto"));
            oper.setDescripcionAplicacion(rs.getString("Descripcion_Aplicacion"));
            oper.setDescripcionUnidadMedida(rs.getString("Desc_Unid_Med"));
            oper.setCodigoClase(rs.getString("Codigo_Clase"));
            oper.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));
            retval.add(oper);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerProductosExp", e);
    } catch (Exception e) {
        Log("obtenerProductosExp", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }



  public ArrayList<Producto> obtenerProductosInspeccion(String codigoExpediente, String codigoServicio){
    
    String sql = SenasaSQL.OBTENER_PRODUCTOS_INSPECCION;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<Producto> retval = new ArrayList<Producto>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        cs.setString(1, codigoExpediente);
        cs.setString(2, codigoServicio);
        Log(" = ANTES DE EJECUTAR = ");
        cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(3);
        while (rs.next()) {
            Producto oper = new Producto();
            oper.setCodigoProducto(rs.getString("Codigo_Producto"));
            oper.setCodigoAplicacion(rs.getString("Codigo_Aplicacion"));
            oper.setCantidadPesoAprobado(rs.getString("Cantidad_Peso_Aprobado"));
            oper.setCodigoUnidadMedida(rs.getString("Codi_Unid_Med"));
            //oper.setCodigoLugarInspeccion(rs.getString("Codigo_Lugar_Inspeccion"));
            oper.setCantidadPesoSolicitado(rs.getString("Cantidad_Peso_Solicitado"));
            oper.setDescripcion(rs.getString("Nombre_Producto"));
            oper.setDescripcionAplicacion(rs.getString("Descripcion_Aplicacion"));
            oper.setDescripcionUnidadMedida(rs.getString("Desc_Unid_Med"));
            //oper.setCodigoClase(rs.getString("Codigo_Clase"));
            oper.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));
            oper.setNombreCentroTramite(rs.getString("Descripcion_Centro_Tramite"));
            
            retval.add(oper);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerProductosInspeccion", e);
    } catch (Exception e) {
        Log("obtenerProductosInspeccion", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  public Expediente obtenerExpediente(String codigoExpediente){
    
    String sql = SenasaSQL.OBTENER_DATOS_EXPEDIENTE;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    Expediente retval = new Expediente();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        cs.setString(1, codigoExpediente);
        Log(" = ANTES DE EJECUTAR = ");
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(2);
        while (rs.next()) {
            retval.setCodigoExpediente(rs.getString("Codigo_Expediente"));
            retval.setCodigoServicio(rs.getString("Codigo_Servicio"));
            retval.setCodigoSolicitud(rs.getString("Codigo_Solicitud"));
            retval.setEstado(rs.getString("Estado"));
            retval.setPersonaId(rs.getString("Persona_Id"));
            retval.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));
            retval.setObservacion(rs.getString("Observacion"));
            retval.setClase(rs.getString("Codigo_Clase"));
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerExpediente", e);
    } catch (Exception e) {
        Log("obtenerExpediente", e);
    } finally {
            cleanup(con, cs);
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
            con = helper.getConnection();
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
            cleanup(con, pst);
    }
    return retval;
  }
  
  public Operador obtenerOperador(String tipoDocumento, String numeroDocumento){
    
    String sql = SenasaSQL.OBTENER_DATOS_OPERADOR;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    Operador retval = new Operador();
    try {
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        cs.setString(1, tipoDocumento);
        cs.setString(2, numeroDocumento);
      
        Log(" = ANTES DE EJECUTAR = ");
        cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(3);
        while (rs.next()) {
            
            retval.setPersonaId(rs.getString("Persona_Id"));
            retval.setNombreRazonSocial(rs.getString("Nombre_Razon_Social"));
            retval.setPersonaTipo(rs.getString("Persona_Tipo"));
            retval.setDocumentoTipo("Documento_Tipo");
            retval.setDocumentoNumero(rs.getString("Documento_Numero"));
            retval.setApePat(rs.getString("Apellido_Paterno"));
            retval.setApeMat(rs.getString("Apellido_Materno"));
            retval.setNombres(rs.getString("Nombres"));
            retval.setDireccion("Direccion");
            retval.setDptoId("Departamento_Id");
            retval.setDptoNombre("Nomb_Dpto_Dpt");
            retval.setProvinciaId("Provincia_Id");
            retval.setProvinciaNombre("Nomb_Prov_Tpr");
            retval.setDistritoId("Distrito_Id");
            retval.setDistritoId("Nomb_Dist_Tdi");
            
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerOperador", e);
    } catch (Exception e) {
        Log("obtenerOperador", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
  private String obtenerPrefijoCentroTramite(String codigoCentroTramite) {
    
    if(codigoCentroTramite==null) return "-1";
    String sql = SenasaSQL.OBTENER_PREFIJO_CENTRO_TRAMITE;
    Log("obtenerPrefijoCentroTramite(): AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String retval = "";
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, codigoCentroTramite);
        rs= pst.executeQuery();
        
        while (rs.next()) {
              retval = rs.getString(1);
        }
        Log(" = TODO FINITO = ");
    } catch (SQLException e) {
        Log("obtenerPrefijoCentroTramite", e);
    } catch (Exception e) {
        Log("obtenerPrefijoCentroTramite", e);
    } finally {
            cleanup(con, pst);
    }
    return retval;
  }
  
  public ArrayList<Vacuna> obtenerListaVacunas(){
    
    String sql = SenasaSQL.OBTENER_VACUNAS;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<Vacuna> retval = new ArrayList<Vacuna>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        Log(" = ANTES DE EJECUTAR = ");
        cs.registerOutParameter(1,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(1);
        while (rs.next()) {
            Vacuna oper = new Vacuna();
            oper.setCodigoVacuna(rs.getString("Codigo_Vacuna"));
            oper.setDescripcionVacuna(rs.getString("Descripcion_Vacuna"));
            retval.add(oper);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerListaVacunas", e);
    } catch (Exception e) {
        Log("obtenerListaVacunas", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
  public ArrayList<Analisis> obtenerListaAnalisis(){
    
    String sql = SenasaSQL.OBTENER_ANALISIS;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<Analisis> retval = new ArrayList<Analisis>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        Log(" = ANTES DE EJECUTAR = ");
        cs.registerOutParameter(1,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(1);
        while (rs.next()) {
            Analisis oper = new Analisis();
            oper.setCodigoAnalisis(rs.getString("Codigo_Analisis"));
            oper.setDescripcionAnalisis(rs.getString("Descripcion_Analisis"));
            retval.add(oper);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerListaAnalisis", e);
    } catch (Exception e) {
        Log("obtenerListaAnalisis", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
  public Solicitante obtenerSolicitanteExp(String codigoExpediente){
    
    String sql = SenasaSQL.OBTENER_SOLICITANTE_EXP;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    Solicitante retval = new Solicitante();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        Log(" = ANTES DE EJECUTAR = ");
        cs.setString(1, codigoExpediente);
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(2);
        while (rs.next()) {
            
            retval.setCodigoSolicitante(rs.getString("Persona_Id"));
            retval.setNombreRazonSocial(rs.getString("Nombre_Razon_Social"));
            retval.setTipoSolicitante(rs.getString("Persona_Tipo"));
            retval.setTipoDocumento(rs.getString("Documento_Tipo"));
            retval.setDniRuc(rs.getString("Documento_Numero"));
            retval.setDomicilioLegal(rs.getString("Direccion"));
            retval.setDepartamento(rs.getString("Departamento_Id"));
            retval.setProvincia(rs.getString("Provincia_Id"));
            retval.setDistrito(rs.getString("Distrito_Id"));
            //oper.setNombreDepartamento(nombreDepartamento);
            //oper.setNombreProvincia(nombreProvincia);
            //oper.setNombreDistrito(nombreDistrito);
            retval.setTelefono(rs.getString("Telefono"));
            retval.setEmail(rs.getString("Correo_Electronico"));
            
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerSolicitanteExp", e);
    } catch (Exception e) {
        Log("obtenerSolicitanteExp", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
  public String anularExpediente(String codigoExpediente){
    
    String sql = SenasaSQL.ANULAR_EXPEDIENTE;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;

    String retval = "0";
    try {
            con = helper.getConnection();
        cs = con.prepareCall(sql);
        cs.setString(1, codigoExpediente); 
        Log(" = ANTES DE EJECUTAR = ");
        
        cs.execute();
       
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("anularExpediente", e);
        retval = e.getMessage();
    } catch (Exception e) {
        Log("anularExpediente", e);
        retval = e.getMessage();
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
  public ArrayList<ServicioTUPA> obtenerServiciosExpediente(String codigoExpediente){
    
    String sql = SenasaSQL.OBTENER_SERVICIOS_EXP;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<ServicioTUPA> retval = new ArrayList<ServicioTUPA>();
    try {
            con = helper.getConnection();
        cs = con.prepareCall(sql);
        cs.setString(1, codigoExpediente);
        cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        Log(" = ANTES DE EJECUTAR = ");
        //rs = pst.executeQuery();
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(2);

        while (rs.next()) {
            ServicioTUPA objserv = new ServicioTUPA();
            objserv.setCodServicioTupa(rs.getString("Codigo_Servicio"));
            objserv.setCodigoExpediente(rs.getString("Codigo_Expediente"));
            objserv.setNombreServicioTupa(rs.getString("Descripcion_Servicio"));
            objserv.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));
            objserv.setDescripcionCentroTramite(rs.getString("Descripcion_Centro_Tramite"));
            objserv.setCodigoSolicitud(rs.getString("Codigo_Solicitud"));
            objserv.setEstado(rs.getString("Estado"));

            retval.add(objserv);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerServiciosExp", e);
    } catch (Exception e) {
        Log("obtenerServiciosExp", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
  public String anularServicioExpediente(String codigoExpediente, String codigosServicios){ 
    String retval = "0";
    
    try {
        
            String[] arrServicio = codigosServicios.split(",");
            int k;
        
            for(k=0;k<arrServicio.length;k++) {
                String codServicio = arrServicio[k];
                retval = anularServicioXExpediente(codigoExpediente,codServicio);
                if(retval!="0") {
                  return retval;
                }
            }
    
    } catch (Exception e) {
        Log("obtenerServiciosExp", e);
        retval = e.getMessage();
    } finally {
       
    }
    return retval;
  }
  private String anularServicioXExpediente(String codigoExpediente, String codigoServicio){
    
    String sql = SenasaSQL.ANULAR_SERVICIOS_EXP;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    String retval = "0";
    
    try {
            con = helper.getConnection();
        cs = con.prepareCall(sql);
        cs.setString(1, codigoExpediente);
        cs.setString(2, codigoServicio);
      
        Log(" = ANTES DE EJECUTAR = ");
        logger.debug("codigoExpediente: " + codigoExpediente);
        logger.debug("codigoServicio: " + codigoServicio);
      
        cs.execute();
        Log(" = ENTRANDO = ");  
        
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("anularServicioXExpediente", e);
        retval = e.getMessage();
    } catch (Exception e) {
        Log("anularServicioXExpediente", e);
        retval = e.getMessage();
    } finally {
            cleanup(con, cs);
    }
    return retval;
    
  }
  
  public ArrayList<Recibo> obtenerListaRecibos(String codigoExpediente, String codigoServicio){
    
    String sql = SenasaSQL.OBTENER_RECIBOS;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    ArrayList<Recibo> retval = new ArrayList<Recibo>();
    try {
            con = helper.getConnection();
        cs = con.prepareCall(sql);
        cs.setString(1, codigoExpediente);
        cs.setString(2, codigoServicio);
      
        Log(" = ANTES DE EJECUTAR = ");
        cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
        cs.execute();
        Log(" = ENTRANDO = ");  
        rs = (ResultSet)cs.getObject(3);
        while (rs.next()) {
            Recibo _obj= new Recibo(); 
            
            _obj.setCodigoRecibo(rs.getString("Codigo_Recibo"));
            _obj.setPrefijo(rs.getString("Prefijo"));
            _obj.setNumeroRecibo(rs.getString("Numero_Recibo"));
            _obj.setFechaRecibo(rs.getDate("Fecha_Recibo"));
            _obj.setCodigoExpediente(rs.getString("Codigo_Expediente"));
            _obj.setMontoPagado(rs.getDouble("Monto_Pagado"));
            _obj.setMontoRecibo(rs.getDouble("Monto_Total"));
            _obj.setMontoSaldo(rs.getDouble("Monto_Saldo"));
            _obj.setUrlRecibo(rs.getString("Url_Recibo"));
            _obj.setEstado(rs.getString("Estado"));
            _obj.setPersonaId(rs.getString("Persona_Id"));
            _obj.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));
            _obj.setObservacion(rs.getString("Observacion"));
            
            retval.add(_obj);
        }
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerRecibos", e);
    } catch (Exception e) {
        Log("obtenerRecibos", e);
    } finally {
            cleanup(con, pst);
    }
    return retval;
  }
  
  public String anularBoletas(String codigosRecibos){ 
    String retval = "0";
    
    try {
        
            String[] arrRecibo = codigosRecibos.split(",");
            int k;
        
            for(k=0;k<arrRecibo.length;k++) {
                String codRecibo = arrRecibo[k];
                retval = anularBoleta(codRecibo);
                if(retval!="0") {
                  return retval;
                }
            }
    
    } catch (Exception e) {
        Log("anularBoletas", e);
        retval = e.getMessage();
    } finally {
       
    }
    return retval;
  }
  private String anularBoleta(String codigoRecibo){
    
    String sql = SenasaSQL.ANULAR_BOLETA;
    Log(" AQUI VA EL " + sql);

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    String retval = "0";
    
    try {
            con = helper.getConnection();
        cs = con.prepareCall(sql);
        cs.setString(1, codigoRecibo);
        
        Log(" = ANTES DE EJECUTAR = ");
        logger.debug("codigoRecibo: " + codigoRecibo);
      
        cs.execute();
        Log(" = ENTRANDO = ");  
        
        Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("anularBoleta", e);
        retval = e.getMessage();
    } catch (Exception e) {
        Log("anularBoleta", e);
        retval = e.getMessage();
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
    public ServicioTUPA obtenerInformacionServicioTupa(String codServicio) {
        String sql = SenasaSQL.OBTENER_INFO_SERVICIO;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        ServicioTUPA retval = new ServicioTUPA();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            cs = con.prepareCall(sql);
            cs.setString(1, codServicio);
            cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
            
            Log(" = ANTES DE EJECUTAR = ");
            //rs = pst.executeQuery();
            cs.execute();
            Log(" = ENTRANDO = ");  
            rs = (ResultSet)cs.getObject(2);

            while (rs.next()) {
                retval.setCodServicioTupa(rs.getString("Codigo_Servicio"));
                retval.setNombreServicioTupa(rs.getString("Descripcion_Servicio"));
                retval.setCodigoClase(rs.getString("Codigo_Clase"));
                retval.setEstado(rs.getString("Estado"));
                retval.setPlazo(rs.getFloat("plazo_tupa"));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerAreasGestion", e);
        } catch (Exception e) {
            Log("obtenerAreasGestion", e);
        } finally {
            cleanup(con, cs);
        }
        return retval;
        }
  
  public static void main(String[] args) {
  
       ServicioTUPADAO tupa = new ServicioTUPADAO();
       String result; 
       Expediente exp = new Expediente();
    //ArrayList<Recibo> arrRecibos =  new ArrayList<Recibo>();
    
       //result = tupa.anularServicioExpediente("110100000022", "114");
       //arrRecibos = tupa.obtenerListaRecibos("112100000008", "001");
       exp = tupa.obtenerExpediente("110600000066");
   
  }
    
}
