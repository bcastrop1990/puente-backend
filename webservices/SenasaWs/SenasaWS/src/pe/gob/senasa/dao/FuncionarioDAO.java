package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Area;
import pe.gob.senasa.bean.DocType;
import pe.gob.senasa.bean.Entidad;
import pe.gob.senasa.bean.Funcionario;
import pe.gob.senasa.bean.SubArea;
import pe.gob.senasa.bean.SubEntidad;
import pe.gob.senasa.bean.SubTipo;
import pe.gob.senasa.connection.ConnectionSenasa;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.FuncionarioInterface;


public class FuncionarioDAO extends BaseDAO implements FuncionarioInterface {
    protected static Logger logger = Logger.getLogger(FuncionarioDAO.class);
    private DBHelper helper;
    public FuncionarioDAO() {
        super();
        helper = new DBHelper(SenasaSQL.dsFuncionario);
    }

    public ArrayList<Area> obtenerAreas() {
        String sql = SenasaSQL.OBTENER_AREAS;

        debug(" AQUI VA EL " + sql);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Area> retval = new ArrayList<Area>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            debug(" = ENTRANDO = ");
            while (rs.next()) {
                Area area = new Area();
                area.setCodigoArea(rs.getString("cod_area"));
                area.setNombreArea(rs.getString("nombre_area"));
                area.setAbreviatura(rs.getString("abreviatura"));
                retval.add(area);
            }
        } catch (SQLException e) {
            error("obtenerAreas", e);
        } catch (Exception e) {
            error("obtenerAreas", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }

    public ArrayList<SubArea> obtenerSubareas(String codigoPadre) {
        String sql = SenasaSQL.OBTENER_SUB_AREAS;

        debug(" AQUI VA EL " + sql);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<SubArea> retval = new ArrayList<SubArea>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoPadre);
            debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            debug(" = ENTRANDO = ");
            while (rs.next()) {
                SubArea subArea = new SubArea();
                subArea.setCodigoArea(rs.getString("cod_subarea"));
                subArea.setNombreArea(rs.getString("nombre_subarea"));
                subArea.setAbreviatura(rs.getString("abreviatura"));
                subArea.setCodigoPadre(codigoPadre);
                retval.add(subArea);
            }
        } catch (SQLException e) {
            error("obtenerSubareas", e);
        } catch (Exception e) {
            error("obtenerSubareas", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }

    public ArrayList<Funcionario> obtenerFuncionarios(String codigoSubArea, String codigoArea) {
        String sql = SenasaSQL.OBTENER_FUNCIONARIOS;

        logger.debug("codigoSubArea:-" + codigoSubArea + "-");
        logger.debug("codigoArea:-" + codigoArea + "-");

        if (!codigoSubArea.equals(null) && !codigoSubArea.trim().equals("") && !codigoSubArea.trim().equals("0"))
            sql = sql.replaceAll("<filter>", "and codigo_subarea=?");
        else
            sql = sql.replaceAll("<filter>", "");

        debug(" AQUI VA EL " + sql);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Funcionario> retval = new ArrayList<Funcionario>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, codigoArea);

            if (!codigoSubArea.equals(null) && !codigoSubArea.trim().equals("") && !codigoSubArea.trim().equals("0"))
                pst.setString(2, codigoSubArea);

            debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            debug(" = ENTRANDO = ");
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCorreo(rs.getString("email"));
                funcionario.setNombre(rs.getString("nombre_persona"));
                funcionario.setIdFuncionario(rs.getString("persona_id"));
                funcionario.setIdJefe(rs.getString("codi_jefe"));
                funcionario.setUserName(rs.getString("usuario"));
                retval.add(funcionario);
            }
        } catch (SQLException e) {
            error("obtenerFuncionarios", e);
        } catch (Exception e) {
            error("obtenerFuncionarios", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }
    
  public ArrayList<Funcionario> obtenerFuncionariosConCargo(String codigoSubArea, String codigoArea) {
      String sql = SenasaSQL.OBTENER_FUNCIONARIOS_CARG;

      logger.debug("codigoSubArea:-" + codigoSubArea + "-");
      logger.debug("codigoArea:-" + codigoArea + "-");

      //if (!codigoSubArea.equals(null) && !codigoSubArea.trim().equals("") && !codigoSubArea.trim().equals("0"))
          //sql = sql.replaceAll("<filter>", "and codigo_subarea=?");
      //else
          //sql = sql.replaceAll("<filter>", "");

      debug(" AQUI VA EL " + sql);
      Connection con = null;
      CallableStatement cs = null;
      PreparedStatement pst = null;
      ResultSet rs = null;
      ArrayList<Funcionario> retval = new ArrayList<Funcionario>();
      try {
            con = helper.getConnection();
          cs = con.prepareCall(sql);
          cs.setString(1, codigoArea);
          cs.setString(2, codigoSubArea);
          cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
          cs.execute();
          rs = (ResultSet)cs.getObject(3);
          //con = cnApp.getConnection();
          //pst = con.prepareStatement(sql);
          //pst.setString(1, codigoArea);

          //if (!codigoSubArea.equals(null) && !codigoSubArea.trim().equals("") && !codigoSubArea.trim().equals("0"))
              //pst.setString(2, codigoSubArea);

          //debug(" = ANTES DE EJECUTAR = ");
          //rs = pst.executeQuery();
          //debug(" = ENTRANDO = ");
          while (rs.next()) {
              Funcionario funcionario = new Funcionario();
              funcionario.setCorreo(rs.getString("email"));
              funcionario.setNombre(rs.getString("nombre_persona"));
              funcionario.setIdFuncionario(rs.getString("persona_id"));
              funcionario.setIdJefe(rs.getString("codi_jefe"));
              funcionario.setUserName(rs.getString("usuario"));
              funcionario.setCondicion(rs.getString("condicion"));/*RCF*/
              retval.add(funcionario);
          }
      } catch (SQLException e) {
          error("obtenerFuncionarios", e);
      } catch (Exception e) {
          error("obtenerFuncionarios", e);
      } finally {
          cleanup(con, pst, rs);
      }
      return retval;
  }

    public ArrayList<Entidad> obtenerEntidades() {
        String sql = SenasaSQL.OBTENER_ENTIDADES;

        debug(" AQUI VA EL " + sql);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Entidad> retval = new ArrayList<Entidad>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            debug(" = ENTRANDO = ");
            while (rs.next()) {
                Entidad entidad = new Entidad();
                entidad.setEmailEntidad(rs.getString("email"));
                entidad.setIdEntidad(rs.getString("persona_id"));
                entidad.setNombre(rs.getString("nombre_persona"));
                retval.add(entidad);
            }
        } catch (SQLException e) {
            error("obtenerEntidades", e);
        } catch (Exception e) {
            error("obtenerEntidades", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }

    public ArrayList<SubEntidad> obtenerSubentidades(String codigoEntidad) {
        String sql = SenasaSQL.OBTENER_SUB_ENTIDADES;

        debug(" AQUI VA EL " + sql);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<SubEntidad> retval = new ArrayList<SubEntidad>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoEntidad);
            debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            debug(" = ENTRANDO = ");
            while (rs.next()) {
                SubEntidad subEntidad = new SubEntidad();
                subEntidad.setCodigoSubEntidad(rs.getString("secuencial"));
                subEntidad.setIdEntidad(rs.getString("persona_id"));
                subEntidad.setNombreEntidad(rs.getString("descripcion_entidad"));
                retval.add(subEntidad);
            }
        } catch (SQLException e) {
            error("obtenerSubentidades", e);
        } catch (Exception e) {
            error("obtenerSubentidades", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }

    public Funcionario obtenerJefeInmediato(String codigoFuncionario) {

        String sql = SenasaSQL.OBTENER_JEFE_INMEDIATO;

        debug(" AQUI VA EL -" + sql + "-");
        debug(" codigoFuncionario: -" + codigoFuncionario + "-");
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Funcionario> retval = new ArrayList<Funcionario>();
        try {
            con = helper.getConnection();
            //sql = sql.("<idCliente>", codigoFuncionario);

            debug(" sql: " + sql);
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoFuncionario);
            logger.debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            logger.debug(" = ENTRANDO = " + rs);
            while (rs.next()) {
                logger.debug(" = ENTRANDO A WHILE = ");
                Funcionario funcionario = new Funcionario();
                funcionario.setCorreo(rs.getString("email"));
                funcionario.setNombre(rs.getString("nombre_persona"));
                funcionario.setIdFuncionario(rs.getString("persona_id"));
                funcionario.setIdJefe(rs.getString("codi_jefe"));
                funcionario.setUserName(rs.getString("usuario"));
                retval.add(funcionario);
            }

            logger.debug("retval.size():" + retval.size());


            if (retval.size() == 0) {
                logger.debug(" No tiene jefe inmediato buscamos los datos del usuario ");
                cleanup(con, pst, rs);

                sql = SenasaSQL.OBTENER_FUNCIONARIO;
                sql = sql.replaceAll("<idCliente>", codigoFuncionario);
                con = helper.getConnection();
                pst = con.prepareStatement(sql);
                logger.debug(" AQUI VA EL " + sql);
                // pst.setString(1, codigoFuncionario.trim());
                logger.debug(" = ANTES DE EJECUTAR = ");
                rs = pst.executeQuery();
                logger.debug(" = ENTRANDO = ");

                while (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setCorreo(rs.getString("email"));
                    funcionario.setNombre(rs.getString("nombre_persona"));
                    funcionario.setIdFuncionario(rs.getString("persona_id"));
                    funcionario.setIdJefe(rs.getString("codi_jefe"));
                    funcionario.setUserName(rs.getString("usuario"));
                    retval.add(funcionario);
                }

            }

        } catch (SQLException e) {
            error("obtenerFuncionarios", e);
        } catch (Exception e) {
            error("obtenerFuncionarios", e);
        } finally {
            cleanup(con, pst, rs);
        }

        if (retval.size() == 0) {
            return null;
        }

        return retval.get(0);
    }

    public Funcionario obtenerJefePorSede(String codSede, String codRol) {
        Connection con = null;
        String sql = SenasaSQL.OBTENER_JEFE_SEDE;
        CallableStatement cs = null;
        ResultSet rs = null;

        Funcionario retval = null;
        try {
            con = helper.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, codSede);
            cs.setString(2, codRol);
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

            debug(" = voy a ejecutar  OBTENER_JEFE_SEDE = ");
            cs.execute();
            rs = (ResultSet)cs.getObject(3);
            debug(" = ENTRANDO = " + rs);
            logger.debug(" = NUMERO DE ELEMENTOS DEVUELTOS = ");
            if (rs.next()) {
                retval = new Funcionario();
                retval.setUserName(rs.getString(1));
                retval.setNombre(rs.getString(2));
            }

            debug(" = TODO FINITO = ");

        } catch (SQLException e) {
            error("obtenerJefePorSede", e);
        } catch (Exception e) {
            error("obtenerJefePorSede", e);
        } finally {
            cleanup(con, cs, rs);
        }

        return retval;
    }

    public Funcionario obtenerJefePorDepartamento(String codDepartamento, String codRol) {
        Connection con = null;
        String sql = SenasaSQL.OBTENER_JEFE_DEPARTAMENTO;
        CallableStatement cs = null;
        ResultSet rs = null;

        Funcionario retval = null;
        try {
            con = helper.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, codDepartamento);
            cs.setString(2, codRol);
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

            debug(" = voy a ejecutar  OBTENER_JEFE_DEPARTAMENTO = ");
            cs.execute();
            rs = (ResultSet)cs.getObject(3);
            debug(" = ENTRANDO = " + rs);
            logger.debug(" = NUMERO DE ELEMENTOS DEVUELTOS = ");
            if (rs.next()) {
                retval = new Funcionario();
                retval.setUserName(rs.getString(1));
                retval.setNombre(rs.getString(2));
            }

            debug(" = TODO FINITO = ");

        } catch (SQLException e) {
            error("obtenerJefePorDepartamento", e);
        } catch (Exception e) {
            error("obtenerJefePorDepartamento", e);
        } finally {
            cleanup(con, cs, rs);
        }

        return retval;
    }

    public ArrayList<Funcionario> obtenerFuncionariosSubordinados(String codigoSubArea, String codigoArea,
                                                                  String codigoFuncionario) {
        String sql = SenasaSQL.OBTENER_FUNCIONARIOS_SUBORDINADOS;

        debug(" AQUI VA EL " + sql);
        debug(" codigoSubArea: " + codigoSubArea);
        debug(" codigoArea: " + codigoArea);
        debug(" codigoFuncionario: " + codigoFuncionario);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Funcionario> retval = new ArrayList<Funcionario>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoArea);
            pst.setString(2, codigoSubArea);
            pst.setString(3, codigoFuncionario);
            debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            debug(" = ENTRANDO = ");
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCorreo(rs.getString("email"));
                funcionario.setNombre(rs.getString("nombre_persona"));
                funcionario.setIdFuncionario(rs.getString("persona_id"));
                funcionario.setIdJefe(rs.getString("codi_jefe"));
                retval.add(funcionario);
            }
        } catch (SQLException e) {
            error("obtenerFuncionariosSubordinados", e);
        } catch (Exception e) {
            error("obtenerFuncionariosSubordinados", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }


    public boolean validarUsuario(String login, String pass, String stringConnection) {
        boolean valido = false;
        Connection con = null;

        try {
            logger.debug("INICIO DE VALIDACION USUARIO");
            logger.debug("Usuario:" + login);
            logger.debug("pass:" + pass);
            logger.debug("stringConnection:" + stringConnection);

            con = ConnectionSenasa.validarConnetionUsuario(login, pass, stringConnection);

            if (con != null)
                valido = true;

        } catch (Exception e) {
            logger.fatal("Ha ocurrido un error cerrando cerrando la conexi�n con la base de datos:", e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException sqe) {
                //* DEBUG LINE*/
                logger.fatal("Ha ocurrido un error cerrando cerrando la conexi�n con la base de datos:" + sqe.getMessage());
            }
        }

        logger.debug("Usuario valido:" + valido);

        return valido;
    }

    public int autenticarUsuario(String login, String pass) {

        Connection con = null;
        String sql = SenasaSQL.VALIDAR_CONEXION_DB;
        CallableStatement cstmt = null;
        int rpta = 0;
        try {
            con = helper.getConnection();
            debug("=======Inicio de validarUsuario ======= ");
            cstmt = con.prepareCall(sql);
            debug(" Preparando llamada al SP " + sql);
            debug(" Usuario = " + login);

            cstmt.registerOutParameter(1, OracleTypes.NUMBER);
            cstmt.setString(2, login); //p_persona_id
            cstmt.setString(3, pass);

            debug(" Ejecutando llamada al SP " + sql);
            cstmt.execute();
            debug(" Ejecut� correctamente ");
            rpta = cstmt.getInt(1);
            debug(" resultado= " + rpta);
        } catch (SQLException e) {
            rpta = 0;
            error(" SQLException : autenticarUsuario", e);
        } catch (Exception e) {
            rpta = 0;
            error(" Exception al autenticarUsuario ", e);
        } finally {
            cleanup(con, cstmt, null);
        }
        return rpta;
    }

    public ArrayList<Entidad> obtenerEntidadesPorFiltro(String filtro, String filtro2) {
        String sql = SenasaSQL.OBTENER_ENTIDADES_BY_FILTER;

        debug(" AQUI VA EL " + sql);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        CallableStatement cs = null;
        ArrayList<Entidad> retval = new ArrayList<Entidad>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            cs = con.prepareCall(sql);

            debug(" = ANTES DE EJECUTAR = ");
            cs.setString(1, filtro);
            cs.setString(2, filtro2);
            cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

            debug(" = ANTES DE EJECUTAR = ");
            cs.execute();
            debug(" = ENTRANDO = ");
            rs = (ResultSet)cs.getObject(3);
            while (rs.next()) {
                Entidad entidad = new Entidad();
                entidad.setEmailEntidad(rs.getString("email"));
                entidad.setIdEntidad(rs.getString("persona_id"));
                entidad.setNombre(rs.getString("nombre_persona"));
                retval.add(entidad);
            }
        } catch (SQLException e) {
            error("obtenerEntidades", e);
        } catch (Exception e) {
            error("obtenerEntidades", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }

    public ArrayList<DocType> obtenerTipos() {
        String sql = SenasaSQL.OBTENER_TIPOS_UCM;

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<DocType> retval = new ArrayList<DocType>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            debug(" = ENTRANDO = ");
            while (rs.next()) {
                DocType doctype = new DocType();
                doctype.setDdoctype(rs.getString(1));
                doctype.setDescripcion(rs.getString(2));
                retval.add(doctype);
            }
        } catch (SQLException e) {
            error("obtenerTipos", e);
        } catch (Exception e) {
            error("obtenerTipos", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }

    public ArrayList<SubTipo> obtenerSubTipos(String tipo) {
        String sql = SenasaSQL.OBTENER_SUBTIPOS_UCM;
        Connection con = null;
        PreparedStatement pst = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        ArrayList<SubTipo> retval = new ArrayList<SubTipo>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            cs = con.prepareCall(sql);

            debug(" = ANTES DE EJECUTAR = ");
            cs.setString(1, tipo);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            debug(" = ENTRANDO = ");
            rs = (ResultSet)cs.getObject(2);

            while (rs.next()) {
                SubTipo subtipo = new SubTipo();
                subtipo.setDdoctype(rs.getString("ddoctype"));
                subtipo.setDescripcion(rs.getString("descripcionsubtipo"));
                subtipo.setCodigoSubTipo(rs.getString("codigosubtipo"));
                retval.add(subtipo);
            }
        } catch (SQLException e) {
            error("obtenerSubTipos", e);
        } catch (Exception e) {
            error("obtenerSubTipos", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }


    public Funcionario obtenerFuncionarioPorCodigo(String codigo) {
        String sql = SenasaSQL.OBTENER_FUNCIONARIO_POR_ID;

        debug(" AQUI VA EL " + sql);
        debug(" codigoSubArea: " + codigo);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, codigo);
            debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            debug(" = ENTRANDO = ");
            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCorreo(rs.getString("email"));
                funcionario.setNombre(rs.getString("nombre_persona"));
                funcionario.setIdFuncionario(rs.getString("persona_id"));
                funcionario.setIdJefe(rs.getString("codi_jefe"));
                funcionario.setUserName(rs.getString("usuario"));
            }
        } catch (SQLException e) {
            error("obtenerFuncionariosSubordinados", e);
        } catch (Exception e) {
            error("obtenerFuncionariosSubordinados", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return funcionario;

    }

    public Funcionario obtenerFuncionarioPorIdPersona(String idPersona) {
        String sql = SenasaSQL.OBTENER_FUNCIONARIO_POR_ID_PERSONA;
        logger.debug("===== INICIO ======");
        logger.debug(" AQUI VA EL " + sql);
        logger.debug("idPersona.length(): " + idPersona.length());
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, idPersona);
            logger.debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            logger.debug(" = ENTRANDO = ");
            while (rs.next()) {
                logger.debug("=== Leyendo RS ====");
                funcionario = new Funcionario();
                funcionario.setCorreo(rs.getString("email"));
                funcionario.setNombre(rs.getString("nombre_persona"));
                funcionario.setIdFuncionario(rs.getString("persona_id"));
                funcionario.setIdJefe(rs.getString("codi_jefe"));
                funcionario.setUserName(rs.getString("usuario"));
                funcionario.setCodigoArea(rs.getString("codigo_area"));
                funcionario.setCodigoSubArea(rs.getString("codigo_subarea"));
                funcionario.setAbreviaturaArea(rs.getString("abre_area"));
                funcionario.setAbreviaturaSubArea(rs.getString("abre_sub_area"));
                funcionario.setNombreArea(rs.getString("nombre_area"));
            }
        } catch (SQLException e) {
            error("obtenerFuncionarioPorIdPersona", e);
        } catch (Exception e) {
            error("obtenerFuncionarioPorIdPersona", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return funcionario;
    }

    public Funcionario obtenerFuncionarioPorNombre(String nombrePersona) {
        String sql = SenasaSQL.OBTENER_FUNCIONARIO_POR_NOMBRE;
        logger.debug("Entrando a obtenerFuncionarioPorNombre()");
        debug(" AQUI VA EL " + sql);
        debug(" NombrePersona: " + nombrePersona);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, nombrePersona);
            debug(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            debug(" = ENTRANDO = ");
            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCorreo(rs.getString("email"));
                funcionario.setNombre(rs.getString("nombre_persona"));
                funcionario.setIdFuncionario(rs.getString("persona_id"));
                funcionario.setIdJefe(rs.getString("codi_jefe"));
                funcionario.setUserName(rs.getString("usuario"));
                funcionario.setCodigoArea(rs.getString("codigo_area"));
                funcionario.setCodigoSubArea(rs.getString("codigo_subarea"));
                funcionario.setAbreviaturaArea(rs.getString("abre_area"));
                funcionario.setAbreviaturaSubArea(rs.getString("abre_sub_area"));
                funcionario.setNombreArea(rs.getString("nombre_area"));
            }
        } catch (SQLException e) {
            error("obtenerFuncionarioPorNombre", e);
        } catch (Exception e) {
            error("obtenerFuncionarioPorNombre", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return funcionario;
    }


    public ArrayList<DocType> obtenerTiposIE(String datoIE) {
        String sql = SenasaSQL.OBTENER_TIPO_DOCTYPE;

        Connection con = null;
        PreparedStatement pst = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        ArrayList<DocType> retval = new ArrayList<DocType>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            cs = con.prepareCall(sql);

            debug(" = ANTES DE EJECUTAR = ");
            cs.setString(1, datoIE);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            debug(" = ENTRANDO = ");
            rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                DocType doctype = new DocType();
                doctype.setDdoctype(rs.getString(1));
                doctype.setDescripcion(rs.getString(2));
                retval.add(doctype);
            }
        } catch (SQLException e) {
            error("obtenerTiposIE", e);
        } catch (Exception e) {
            error("obtenerTiposIE", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }

    public ArrayList<Funcionario> obtenerReemplazo(String userName) {

        String sql = SenasaSQL.OBTENER_REEMPLAZO;
        debug(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        ArrayList<Funcionario> retval = new ArrayList<Funcionario>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            cs = con.prepareCall(sql);
            cs.setString(1, userName);
            debug(" = ANTES DE EJECUTAR = ");
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

            cs.execute();
            debug(" = ENTRANDO = ");
            rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                Funcionario oper = new Funcionario();
                oper.setUserName(rs.getString(1));
                retval.add(oper);
            }
            debug(" = FIN TODITO = ");
        } catch (SQLException e) {
            error("obtenerReemplazo", e);
        } catch (Exception e) {
            error("obtenerReemplazo", e);
        } finally {
            cleanup(con, pst, rs);
        }
        return retval;
    }

    public String obtenerFirma(String codServicio, String codCentroTramite, String tipoFirma) {

        Connection con = null;
        String sql = SenasaSQL.OBTENER_FIRMA;
        CallableStatement cstmt = null;
        String rpta = "";
        try {
            con = helper.getConnection();
            debug("=======Inicio de validarUsuario ======= ");
            cstmt = con.prepareCall(sql);
            debug(" Preparando llamada al SP " + sql);
            debug(" codServicio = " + codServicio + " codCentroTramite=  " + codCentroTramite + "tipoFirma=" + tipoFirma);

            cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
            cstmt.setString(2, codServicio);
            cstmt.setString(3, codCentroTramite);
            cstmt.setString(4, tipoFirma);

            debug(" Ejecutando llamada al SP " + sql);
            cstmt.execute();
            debug(" Ejecut� correctamente ");
            rpta = cstmt.getString(1);
            debug(" resultado= " + rpta);
        } catch (SQLException e) {
            rpta = "Error SQLException " + e.getMessage();
            error(" SQLException : autenticarUsuario", e);
        } catch (Exception e) {
            rpta = "Error Exception " + e.getMessage();
            error(" Exception al autenticarUsuario ", e);
        } finally {
            cleanup(con, cstmt, null);
        }
        return rpta;
    }

    public ArrayList<Funcionario> buscarFuncionariosPorNombre(String nombre) {
        String log = "buscarFuncionariosPorNombre";
        logger.info("****************** Inicio del m�todo " + log + " ******************");
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        Connection cn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            String sql = SenasaSQL.BUSCAR_USUARIO_PREDICTIVO;
            cn = helper.getConnection();
            cs = cn.prepareCall(sql);
            cs.setString(1, nombre);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("Ejecutando => " + sql);
            logger.info("Parametros => " + nombre);
            cs.execute();
            rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setUserName(rs.getString("Usuario"));
                func.setNombre(rs.getString("Nombre_Persona"));
                lista.add(func);
            }
        } catch (Exception ex) {
            logger.debug(log + " :Error Exception: " + ex.getMessage());
        } finally {
            cleanup(cn, cs, rs);
        }
        return lista;
    }

    public String buscarDestinatarioPorCentroTramite(String centroTramite, String procedTupa) {
        logger.debug("BUSCAR_USUARIO_DESTINATARIO");
        String destinatario = null;
        Connection con = null;
        CallableStatement cs = null;
        //String retval="";
        try {
            con = helper.getConnection();
            String sql = SenasaSQL.BUSCAR_USUARIO_DESTINATARIO;
            logger.debug("AQUI VA EL QUERY: " + sql);
            cs = con.prepareCall(sql);
            cs.setString(1, centroTramite);
            cs.setString(2, procedTupa);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            logger.debug("Se va a ejecutar BUSCAR_USUARIO_DESTINATARIO");
            cs.execute();
            logger.debug("Se ejecut� BUSCAR_USUARIO_DESTINATARIO");
            destinatario = cs.getString(3);
            logger.debug("Usuario destinatario: " + destinatario);
        } catch (SQLException e) {
            error("buscarDestinatarioPorCentroTramite error", e);
        } catch (Exception e) {
            error("buscarDestinatarioPorCentroTramite error", e);
        } finally {
            cleanup(con, cs);
        }
        return destinatario;
    }
    
    public Funcionario obtenerFuncionarioPorUserName(Connection con, String userName) {
        debug("*** INICIO ***");
        PreparedStatement pst = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        int i = 0;
        try {
            String sql = SenasaSQL.OBTENER_FUNCIONARIO_POR_USERNAME;
            debug(" = ANTES DE EJECUTAR = " + sql);
            debug(" userName: " + userName);    
            pst = con.prepareStatement(sql);
            pst.setString(1, userName);            
            rs = pst.executeQuery();
            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCorreo(rs.getString("email"));
                funcionario.setNombre(rs.getString("nombre_persona"));
                funcionario.setIdFuncionario(rs.getString("persona_id"));
                funcionario.setIdJefe(rs.getString("codi_jefe"));
                funcionario.setUserName(rs.getString("usuario"));
                funcionario.setCodigoArea(rs.getString("codigo_area"));
                funcionario.setCodigoSubArea(rs.getString("codigo_subarea"));
                funcionario.setAbreviaturaArea(rs.getString("abre_area"));
                funcionario.setAbreviaturaSubArea(rs.getString("abre_sub_area"));
                funcionario.setNombreArea(rs.getString("nombre_area"));
                funcionario.setNombreSubArea(rs.getString("nombre_subarea"));
                i++;
            }
            if (funcionario == null) {
                debug(" no existen datos ");
            } else {
                if (i > 1) {
                    debug(" Existe m�s de un funcionario con el mismo nombre de usuario");
                } else {
                    debug(" Se asignar�n los datos de salida ");
                }

            }

        } catch (SQLException e) {
            error("obtenerFuncionarioPorUserName", e);
        } catch (Exception e) {
            error("obtenerFuncionarioPorUserName", e);
        } finally {
            cleanup(pst, rs);
        }
        return funcionario;
    }
    
    public Funcionario obtenerFuncionarioPorUserName(String userName) {
        debug("*** INICIO ***");
        Connection con = null;
        Funcionario funcionario = null;
        try {
            con = helper.getConnection();
            funcionario = obtenerFuncionarioPorUserName(con, userName);
        }/* catch (SQLException e) {
            error("obtenerFuncionarioPorUserName", e);
        }*/ catch (Exception e) {
            error("obtenerFuncionarioPorUserName", e);
        } finally {
            cleanup(con);
        }
        return funcionario;
    }

    public ArrayList<Funcionario> buscarAsistentesPorFuncionario(Connection con, String usuario) {
        logger.info("*** INICIO ***");
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            String sql = SenasaSQL.BUSCAR_ASISTENTES;
            cs = con.prepareCall(sql);
            cs.setString(1, usuario);
            cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
            logger.info("Ejecutando => " + sql);
            logger.info("Parametros => " + usuario);
            cs.execute();
            rs = (ResultSet)cs.getObject(2);
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setUserName(rs.getString("Asistente_usuario"));
                func.setIdFuncionario(rs.getString("Asistente_codigo"));
                lista.add(func);
            }
        } catch (Exception ex) {
            error("Error Exception", ex);
        } finally {
            cleanup(cs, rs);
        }
        return lista;
    }
    
    public ArrayList<Funcionario> buscarAsistentesPorFuncionario(String usuario) {
        debug("*** INICIO ***");
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        Connection cn = null;
        try {
            cn = helper.getConnection();
            lista = buscarAsistentesPorFuncionario(cn, usuario);
        } catch (Exception ex) {
            error("Error Exception", ex);
        } finally {
            cleanup(cn);
        }
        return lista;
    }
}
