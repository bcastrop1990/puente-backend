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

import pe.gob.senasa.bean.CentroTramite;
import pe.gob.senasa.bean.Departamento;
import pe.gob.senasa.bean.Distrito;
import pe.gob.senasa.bean.LugarProduccion;
import pe.gob.senasa.bean.Pais;
import pe.gob.senasa.bean.Provincia;
import pe.gob.senasa.bean.PuntoSalida;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.GeografiaInterface;


public class GeografiaDAO extends BaseDAO implements GeografiaInterface {

    protected static Logger logger = Logger.getLogger(GeografiaDAO.class);    
    DBHelper helper;
    public GeografiaDAO() {
        super();
      helper = new DBHelper(SenasaSQL.dsGeografia);
    }

    public ArrayList<Departamento> obtenerDepartamentos() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Departamento> retval = new ArrayList<Departamento>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(SenasaSQL.OBTENER_DEPARTAMENTOS_SQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Departamento dep = new Departamento();
                dep.setCodDepartamento(rs.getString(1));
                dep.setDepartamento(rs.getString(2));
                retval.add(dep);
            }
        } catch (SQLException e) {
            logger.fatal("GeografiaDAO - obtenerDepartamentos", e);
        } catch (Exception e) {
            logger.fatal("GeografiaDAO - obtenerDepartamentos", e);
        } finally {
          cleanup(con, pst, rs);
        }

        return retval;
    }

    public ArrayList<Provincia> obtenerProvincias(String Departamento) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Provincia> retval = new ArrayList<Provincia>();
        try {
            con = helper.getConnection();
            pst = getPreparedStamentFull(Departamento, con, SenasaSQL.OBTENER_PROVINCIAS_SQL, SenasaSQL.OBTENER_PROVINCIAS_X_DEP_SQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Provincia dep = new Provincia();
                dep.setCodProvincia(rs.getString(1));
                dep.setProvincia(rs.getString(2));
                retval.add(dep);
            }

        } catch (SQLException e) {
            logger.fatal("GeografiaDAO - obtenerProvincias", e);
        } catch (Exception e) {
            logger.fatal("GeografiaDAO - obtenerProvincias", e);
        } finally {
          cleanup(con, pst, rs);
        }
        return retval;
    }

    private PreparedStatement getPreparedStamentFull(String IdNum,
                                                 Connection con,String s1,String s2) throws SQLException {
        PreparedStatement pst;
        if(IdNum == null || IdNum.length() <= 0){
        	logger.debug("usando el query: "+s1);
            pst = con.prepareStatement(s1);
        }else{
            long idDep = Long.parseLong(IdNum);
            pst = con.prepareStatement(s2);
        	logger.debug("usando el query: "+s2+ ", con parametro: "+idDep);
            pst.setLong(1, idDep);
        }
        return pst;
    }

    private PreparedStatement getPreparedStamentFullDistritos(String numDepartamento, String numProvincia,
    		Connection con,String s1,String s2) throws SQLException {
    	PreparedStatement pst;
    	if(numDepartamento == null || numDepartamento.length() <= 0 || numProvincia == null || numProvincia.length() <= 0 ){
    		logger.debug("usando el query: "+s1);
    		pst = con.prepareStatement(s1);
    	}else{
    		long idDep = Long.parseLong(numDepartamento);
    		long idProv = Long.parseLong(numProvincia);
    		pst = con.prepareStatement(s2);
    		logger.debug("usando el query: "+s2+ ", con departamento: "+idDep+" y provincia: "+idProv);
    		pst.setLong(1, idDep);
    		pst.setLong(2, idProv);
    	}
    	return pst;
    }

    public ArrayList<Distrito> obtenerDistritos(String Departamento, String Provincia) {
    	logger.debug("Servicio obtenerDistritos");
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Distrito> retval = new ArrayList<Distrito>();
        try {
            con = helper.getConnection();
            pst = getPreparedStamentFullDistritos(Departamento, Provincia, con, SenasaSQL.OBTENER_DISTRITOS_SQL, SenasaSQL.OBTENER_DISTRITOS_X_PROV_SQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Distrito dep = new Distrito();
                dep.setCodDistrito(rs.getString(1));
                dep.setDistrito(rs.getString(2));
                retval.add(dep);
            }
        } catch (SQLException e) {
            logger.fatal("GeografiaDAO - obtenerDistritos", e);
        } catch (Exception e) {
            logger.fatal("GeografiaDAO - obtenerDistritos", e);
        } finally {
          cleanup(con, pst, rs);
        }
        return retval;
    }

    private void Log(String s) {
        logger.debug(s);
    }

    public ArrayList<Pais> obtenerPais() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Pais> retval = new ArrayList<Pais>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(SenasaSQL.OBTENER_PAIS);
            rs = pst.executeQuery();
            while (rs.next()) {
                Pais p = new Pais();
                p.setCodPais(rs.getString(1));
                p.setPais(rs.getString(2));
                retval.add(p);
            }
        } catch (SQLException e) {
            logger.fatal("GeografiaDAO - obtenerPais", e);
        } catch (Exception e) {
            logger.fatal("GeografiaDAO - obtenerPais", e);
        } finally {
          cleanup(con, pst, rs);
        }
        return retval;
    }
  public List<Pais> obtenerPaisxGermCPE(String nroGermplasma, String nroCPE) {
      Connection con = null;
      CallableStatement cs = null;
      ResultSet rs = null;
      List<Pais> retval = new ArrayList<Pais>();
      try {
            con = helper.getConnection();
          cs = con.prepareCall(SenasaSQL.OBTENER_PAIS_GERMP_CPE);
          cs.setString(1, nroGermplasma);
          cs.setString(2, nroCPE);
          cs.registerOutParameter(3,OracleTypes.CURSOR,"SYS_REFCURSOR");
          cs.execute();
          rs = (ResultSet)cs.getObject(3);
          while (rs.next()) {
              Pais p = new Pais();
              p.setCodPais(rs.getString(1));
              p.setPais(rs.getString(2));
              retval.add(p);
          }
      } catch (SQLException e) {
          logger.fatal("GeografiaDAO - obtenerPaisxGermCPE", e);
      } catch (Exception e) {
          logger.fatal("GeografiaDAO - obtenerPaisxGermCPE", e);
      } finally {
        cleanup(con, cs, rs);
      }
      return retval;
  }

    public ArrayList<LugarProduccion> obtenerLugarProduccion(String pais){
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            ArrayList<LugarProduccion> retval = new ArrayList<LugarProduccion>();
            try {
            con = helper.getConnection();
                pst = con.prepareStatement(SenasaSQL.OBTENER_LUGARES_PRODUCCION);
                pst.setString(1, pais);
                Log(SenasaSQL.OBTENER_LUGARES_PRODUCCION);
                rs = pst.executeQuery();
                while (rs.next()) {
                    LugarProduccion p = new LugarProduccion();
                    p.setCodLugarProduccion(rs.getString(1));
                    p.setLugarProduccion(rs.getString(2));
                    retval.add(p);
                }
            } catch (SQLException e) {
                logger.fatal("GeografiaDAO - obtenerLugarProduccion", e);
            } catch (Exception e) {
                logger.fatal("GeografiaDAO - obtenerLugarProduccion", e);
            } finally {
              cleanup(con, pst, rs);
            }
            return retval;
        }

  public ArrayList<PuntoSalida> obtenerPuntosSalidaxPais(String pais) {
      String OBTENER_PUERTOS_X_PAIS_1 = "select p.codigo_puerto,p.codi_pais_tpa,p.descripcion_puerto from puerto p \n" + 
      "where codi_pais_tpa='";
      String OBTENER_PUERTOS_X_PAIS_2 = "' order by p.descripcion_puerto";
      
    Connection con =null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<PuntoSalida> retval = new ArrayList<PuntoSalida>();
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(OBTENER_PUERTOS_X_PAIS_1+pais+OBTENER_PUERTOS_X_PAIS_2);
        rs = pst.executeQuery();
        while (rs.next()) {
            PuntoSalida p = new PuntoSalida();
            p.setCodigoPuntoSalida(rs.getString(1));
            p.setCodigoPais(rs.getString(2));
            p.setPuntoSalida(rs.getString(3));
            retval.add(p);
        }
    } catch (SQLException e) {
        logger.fatal("GeografiaDAO - obtenerPuntosSalida", e);
    } catch (Exception e) {
        logger.fatal("GeografiaDAO - obtenerPuntosSalida", e);
    } finally {
      cleanup(con, pst, rs);
    }
    return retval;
      
  }
  
  
  public CentroTramite obtenerCentroTramite(String codigoCentroTramite)
  {
    if(codigoCentroTramite==null) return null;
    CentroTramite cntrTrmt = null;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(SenasaSQL.CONSULTAR_CENTRO_TRAMITE);
        pst.setString(1,codigoCentroTramite);
        rs = pst.executeQuery();
        if(rs!=null && rs.next())
        {
          cntrTrmt= new CentroTramite();
          cntrTrmt.setCentroTramite(rs.getString(1));
          cntrTrmt.setCodigoCentroTramite(rs.getString(2));
          cntrTrmt.setDireccion(rs.getString(3));
        }     
    } catch (SQLException e) {
        logger.fatal("GeografiaDAO - obtenerCentroTramite", e);
    } catch (Exception e) {
        logger.fatal("GeografiaDAO - obtenerCentroTramite", e);
    } finally {
      cleanup(con, pst, rs);
    }
    return cntrTrmt;
  }


    public ArrayList<PuntoSalida> obtenerPuntosSalida() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<PuntoSalida> retval = new ArrayList<PuntoSalida>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(SenasaSQL.OBTENER_PUERTOS);
            rs = pst.executeQuery();
            while (rs.next()) {
                PuntoSalida p = new PuntoSalida();
                p.setCodigoPuntoSalida(rs.getString(1));
                p.setCodigoPais(rs.getString(2));
                p.setPuntoSalida(rs.getString(3));
                retval.add(p);
            }
        } catch (SQLException e) {
            logger.fatal("GeografiaDAO - obtenerPuntosSalida", e);
        } catch (Exception e) {
            logger.fatal("GeografiaDAO - obtenerPuntosSalida", e);
        } finally {
          cleanup(con, pst, rs);
        }
        return retval;
    }
}
