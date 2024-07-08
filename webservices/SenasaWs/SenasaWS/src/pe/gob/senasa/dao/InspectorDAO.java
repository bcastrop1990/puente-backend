package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Inspector;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.InspectorInterface;


public class InspectorDAO extends BaseDAO implements InspectorInterface {

    protected static Logger logger = Logger.getLogger(InspectorDAO.class);
    private DBHelper helper;

    
    public InspectorDAO() {
        super();
        helper = new DBHelper(SenasaSQL.DATA_SOURCE_INSPECTOR);
    }

    /**
     *
     * @param puntoIngreso
     * @return
     */
    public ArrayList<Inspector> obtenerInspectoresPuntoIngreso(String puntoIngreso) {
        Connection con = null; //PCSM 06/01/2017
        //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
       // Connection con = ConnectionSenasa.getSingletonObject().getConnInspector();  //PCSM 05/01/2017
        String sql = SenasaSQL.OBTENER_INSPECTORES;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Inspector> retval = new ArrayList<Inspector>();
        try {
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, puntoIngreso);
            Log(" = voy a ejecutar  OBTENER_INSPECTORES = ");
            rs = pst.executeQuery();
            while (rs.next()) {
                Inspector ins = new Inspector();
                ins.setDniInspector(rs.getString(1));
                ins.setNombreInspector(rs.getString(2));
                retval.add(ins);
            }
            Log(" = TODO FINITO = ");
        } catch (SQLException e) {
            Log("obtenerInspectoresPuntoIngreso", e);
        } catch (Exception e) {
            Log("obtenerInspectoresPuntoIngreso", e);
        } finally {
            //cleanup(con, null);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }
    
  public ArrayList<Inspector> obtenerInspectoresPorUbigeo(String codDpto, String codProv, String codDist) {
      //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
      //Connection con = ConnectionSenasa.getSingletonObject().getConnInspector();  //PCSM 05/01/2017
      Connection con = null; //PCSM 06/01/2017
      String sql = SenasaSQL.OBTENER_INSPECTORES_UBIGEO;
      PreparedStatement pst = null;
      CallableStatement cs = null;
      ResultSet rs = null;
      ArrayList<Inspector> retval = new ArrayList<Inspector>();
      try {
          con = helper.getConnection();  //PCSM 06/01/2017
          pst = con.prepareStatement(sql);
          cs = con.prepareCall(sql);
          
          cs.setString(1, codDpto);
          cs.setString(2, codProv);
          cs.setString(3, codDist);
          cs.registerOutParameter(4,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
          Log(" = voy a ejecutar  OBTENER_INSPECTORES_UBIGEO = ");
          cs.execute();
          Log(" = ENTRANDO = ");  
          rs = (ResultSet)cs.getObject(4);
          while (rs.next()) {
              Inspector ins = new Inspector();
              ins.setPersonaId(rs.getString(1));
              ins.setDniInspector(rs.getString(3));
              ins.setNombreInspector(rs.getString(4));
              ins.setCodigoCentroTramite(rs.getString(2));
              retval.add(ins);
          }
          Log(" = TODO FINITO = ");
      } catch (SQLException e) {
          Log("obtenerInspectoresPorUbigeo", e);
      } catch (Exception e) {
          Log("obtenerInspectoresPorUbigeo", e);
      } finally {
            //cleanup(con, null);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
      }
      return retval;
  }
  
  public ArrayList<Inspector> obtenerInspectoresPorCentroTramite(String codCentroTramite, String codRol) {
      //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
      //Connection con = ConnectionSenasa.getSingletonObject().getConnInspector();  //PCSM  05/01/2017
      Connection con = null; //PCSM 06/01/2017
      String sql = SenasaSQL.OBTENER_INSPECTORES_CENTRO_TRAMITE;
      PreparedStatement pst = null;
      CallableStatement cs = null;
      ResultSet rs = null;
      ArrayList<Inspector> retval = new ArrayList<Inspector>();
      try {
          con = helper.getConnection();  //PCSM 06/01/2017
          pst = con.prepareStatement(sql);
          cs = con.prepareCall(sql);
          
          cs.setString(1, codCentroTramite);
          cs.setString(2, codRol);
          cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
          Log(" = voy a ejecutar  OBTENER_INSPECTORES_CENTRO_TRAMITE = ");
          cs.execute();
          Log(" = ENTRANDO = ");  
          rs = (ResultSet)cs.getObject(3);
          while (rs.next()) {
              Inspector ins = new Inspector();
              ins.setPersonaId(rs.getString(1));
              ins.setDniInspector(rs.getString(3));
              ins.setNombreInspector(rs.getString(4));
              ins.setCodigoCentroTramite(rs.getString(2));
              retval.add(ins);
          }
          Log(" = TODO FINITO = ");
      } catch (SQLException e) {
          Log("obtenerInspectoresPorCentroTramite", e);
      } catch (Exception e) {
          Log("obtenerInspectoresPorCentroTramite", e);
      } finally {
            //cleanup(con, null);
            try {
                helper.cleanup(con, pst, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
      }
      return retval;
  }
  
  public ArrayList<Inspector> obtenerInspectoresPorDepartamento(String codDepartamento, String codRol) {
      //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
      //Connection con = ConnectionSenasa.getSingletonObject().getConnInspector();  //PCSM  05/01/2017
      Connection con = null; //PCSM 06/01/2017
      String sql = SenasaSQL.OBTENER_INSPECTORES_DEPARTAMENTO;
      PreparedStatement pst = null;
      CallableStatement cs = null;
      ResultSet rs = null;
      ArrayList<Inspector> retval = new ArrayList<Inspector>();
      try {
          con = helper.getConnection();  //PCSM 06/01/2017
          pst = con.prepareStatement(sql);
          cs = con.prepareCall(sql);
          
          cs.setString(1, codDepartamento);
          cs.setString(2, codRol);
          cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
          Log(" = voy a ejecutar  OBTENER_INSPECTORES_DEPARTAMENTO = ");
          cs.execute();
          Log(" = ENTRANDO = ");  
          rs = (ResultSet)cs.getObject(3);
          while (rs.next()) {
              Inspector ins = new Inspector();
              ins.setPersonaId(rs.getString(1));
              ins.setDniInspector(rs.getString(3));
              ins.setNombreInspector(rs.getString(4));
              ins.setCodigoCentroTramite(rs.getString(2));
              retval.add(ins);
          }
          Log(" = TODO FINITO = ");
      } catch (SQLException e) {
          Log("obtenerInspectoresPorDepartamento", e);
      } catch (Exception e) {
          Log("obtenerInspectoresPorDepartamento", e);
      } finally {
            //cleanup(con, null);
            //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
      }
      return retval;
  }
    
  public ArrayList<Inspector> obtenerInspectoresPorSede(String codSede) {
      
     //Connection con = ConnectionSenasa.getSingletonObject().getConnection();
     //Connection con = ConnectionSenasa.getSingletonObject().getConnInspector();  //PCSM  05/01/2017
    // Connection con = ConnectionSenasa.getConnectionSimple();
      Connection con = null; //PCSM 06/01/2017
      String sql = SenasaSQL.OBTENER_INSPECTOR_SEDE;
      PreparedStatement pst = null;
      CallableStatement cs = null;
      ResultSet rs = null;
      ArrayList<Inspector> retval = new ArrayList<Inspector>();
      try {
          con = helper.getConnection();  //PCSM 06/01/2017
          pst = con.prepareStatement(sql);
          cs = con.prepareCall(sql);
          
          cs.setString(1, codSede);
          cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
          Log(" = voy a ejecutar  OBTENER_INSPECTORES_SEDE = ");
          cs.execute();
          Log(" = ENTRANDO = ");  
          rs = (ResultSet)cs.getObject(2);
          while (rs.next()) {
              Inspector ins = new Inspector();
              ins.setPersonaId(rs.getString("Persona_Id"));
              ins.setCodigoCentroTramite(rs.getString("Codigo_Centro_Tramite"));
              ins.setNombreInspector(rs.getString("Nombre_Razon_Social"));
              ins.setEspecialidad(rs.getString("Especialidad"));         
              ins.setDniInspector(rs.getString("Documento_Numero"));
              ins.setUsuario(rs.getString("Usuario"));
              retval.add(ins);
          }
          Log(" = TODO FINITO = ");
      } catch (SQLException e) {
          Log("obtenerInspectoresPorSede", e);
      } catch (Exception e) {
          Log("obtenerInspectoresPorSede", e);
      } finally {
            //cleanup(con, null);
            //PCSM 06/01/2017
              try {
                  helper.cleanup(con, pst, null);
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
        logger.fatal("InspectorDAO - " + s, p2);
    }
    
  public static void main(String[] args) throws SQLException {
    InspectorDAO inspector = new InspectorDAO();
    inspector.obtenerInspectoresPorSede("06");
      
  }
}
