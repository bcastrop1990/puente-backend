package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Firmante;
import pe.gob.senasa.bean.Importador;
import pe.gob.senasa.bean.Persona;
import pe.gob.senasa.bean.PredioCPE;
import pe.gob.senasa.bean.Recibo;
import pe.gob.senasa.bean.ReciboServicio;
import pe.gob.senasa.bean.Solicitante;
import pe.gob.senasa.bean.TipoDocIden;
import pe.gob.senasa.bean.TipoFiltro;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.SolicitanteInterface;
import pe.gob.senasa.util.Utility;


public class SolicitanteDAO extends BaseDAO implements SolicitanteInterface {

	protected static Logger logger = Logger.getLogger(SolicitanteDAO.class);
  private DBHelper helper;
	public SolicitanteDAO() {
		super();
	  helper = new DBHelper(SenasaSQL.dsSolicitante);
	}



	/**
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public String guardarObtenerPersona(String dni, String nombre, String apellido, Connection con) throws SQLException {
		Solicitante sol = obtenerSolicitante("01", dni);
		if (sol.getCodigoSolicitante() == null || sol.getCodigoSolicitante().length() <= 0) {
			Log("la persona no existe, se procedera a guardarla");
			Persona persona = new Persona();
			persona.setNumeroDoc(dni);
			persona.setRazonSocial(nombre);
			persona.setTipoDoc("01");
			persona.setTipoPersona("NATURAL");
			String resIdSolicitante = guardarPersona(persona, con);

			if (resIdSolicitante.equals("-1")) {
				throw new SQLException("NO SE PUDO GUARDAR LA PERSONA");
			} else {
				Log("persona guardada: " + resIdSolicitante);
				sol.setCodigoSolicitante(resIdSolicitante);
				return sol.getCodigoSolicitante();
			}
			
		} else {
			Log("el solicitante que se retornara es " + sol.getCodigoSolicitante());
			return sol.getCodigoSolicitante();
		}
	}


	public Firmante obtenerFirmantePermiso(String idCentroTramite, String codigoServicio) {
		Firmante user = null;

		String sql = SenasaSQL.CONSULTAR_FIRMANTE;

		Connection con = null;
		PreparedStatement pst = null;

		ResultSet rs = null;
		try {
		  Log("=======Inicio de obtenerFirmantePermiso ======= ");
      con = helper.getConnection();
			pst = con.prepareStatement(sql);
		  Log(" Preparando llamada al SP "+sql);
		  Log(" idCentroTramite= "+idCentroTramite +  " codigoServicio= " + codigoServicio);            
			pst.setString(1, idCentroTramite);
			pst.setString(2, codigoServicio);

			rs = pst.executeQuery();
		  Log(" Ejecutó correctamente ");              
			if (rs != null && rs.next()) {
				user = new Firmante();
				user.setNomencaltura(rs.getString(1));
				user.setLugar(rs.getString(2));
				user.setUserName(rs.getString(3));
			  Log(" resultado= " +rs.getString(3)); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		  Log(" SQLException : obtenerFirmantePermiso " ,e);
		} finally {
		  cleanup(con, pst,rs);  
		}

		return user;
	}


	/**
	 *
	 * @param tipoDoc - 01 o 02 (RECORDAR POR FAVOR)
	 * @param numeroDoc
	 * @return
	 */
	public Solicitante obtenerSolicitante(String tipoDoc, String numeroDoc) {

		String sql = SenasaSQL.OBTENER_SOLICITANTE;

		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Log("= PARAMETROS = ");
		Log("tipoDoc = " + tipoDoc + " ; numeroDoc = " + numeroDoc);
		Solicitante retval = new Solicitante();
		try {
      con = helper.getConnection();  
			pst = con.prepareStatement(sql);
			pst.setString(1, tipoDoc);
			pst.setString(2, numeroDoc);

			Log(" = ANTES DE EJECUTAR = ");
			rs = pst.executeQuery();
			Log(" = ENTRANDO = ");
			if (rs.next()) {
				retval = obtSolicitante(rs);
			}
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("obtenerSolicitante", e);
		} catch (Exception e) {
			Log("obtenerSolicitante", e);
		} finally {
		  cleanup(con, pst,rs);
		}
		return retval;
	}
  
  public ArrayList<Solicitante> obtenerSolicitantesFiltrados(String tipoFiltro, String valorFiltro) {
    ArrayList<Solicitante> retval = new ArrayList<Solicitante>();
    String sql = SenasaSQL.OBTENER_SOLICITANTES_FILTRADOS;

    Log(" AQUI VA EL " + sql);
    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    try {
      con = helper.getConnection();
      pst = con.prepareStatement(sql);
      cs = con.prepareCall(sql);

      cs.setString(1, tipoFiltro);
      cs.setString(2, valorFiltro);
      cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

      cs.execute();
      Log(" = ENTRANDO = ");
      rs = (ResultSet)cs.getObject(3);
          
      while (rs.next()) {
        retval.add(obtSolicitanteMin(rs));
      }
      Log(" = FIN TODITO = ");
    } catch (SQLException e) {
        Log("obtenerSolicitantesFiltrados", e);
    } catch (Exception e) {
        Log("obtenerSolicitantesFiltrados", e);
    } finally {
        cleanup(con, cs,rs);  
    }
    return retval;
  }


	public ArrayList<Solicitante> obtenerRepresentanteLegal(String codPersona) {

		String sql = SenasaSQL.OBTENER_REPRESENTANTE_LEGAL;

		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		ArrayList<Solicitante> retval = new ArrayList<Solicitante>();

		try {
      con = helper.getConnection();
			pst = con.prepareStatement(sql);
			cs = con.prepareCall(sql);

			cs.setString(1, codPersona);
			cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

			Log(" = voy a ejecutar  OBTENER_REPRESENTANTE_LEGAL = ");

			cs.execute();
			Log(" = ENTRANDO = ");

			rs = (ResultSet)cs.getObject(2);

			while (rs.next()) {
				Solicitante sol = new Solicitante();

				sol.setCodigoSolicitante(rs.getString("Persona_Id"));
			  sol.setNombreRazonSocial(rs.getString("Nombre_Razon_Social"));
        if (sol.getNombreRazonSocial() == null || sol.getNombreRazonSocial().isEmpty())
          sol.setNombreRazonSocial(rs.getString("Apellido_Paterno") + " " + rs.getString("Apellido_Materno") + ", " + rs.getString("Nombres"));
				sol.setDniRuc(rs.getString("Documento_Numero"));
				sol.setDepartamento(rs.getString("Departamento_Id"));
				sol.setProvincia(rs.getString("Provincia_Id"));
				sol.setDistrito(rs.getString("Distrito_Id"));
				sol.setTelefono(rs.getString("Telefono"));
				sol.setTipoDocumento(rs.getString("Documento_Tipo"));
				sol.setNombreDepartamento(rs.getString("Nomb_Dpto_Dpt"));
				sol.setNombreProvincia(rs.getString("Nomb_Prov_Tpr"));
				sol.setNombreDistrito(rs.getString("Codi_Dist_Tdi"));
				sol.setEmail(rs.getString("Correo_Electronico"));
          
				retval.add(sol);
			}
		} catch (SQLException e) {
			Log("obtenerInspectoresPorUbigeo", e);
		} catch (Exception e) {
			Log("obtenerInspectoresPorUbigeo", e);
		} finally {
		  cleanup(con, cs,rs);  
		}
		return retval;
	}

	/**
	 * @param tipoDoc
	 * @param numeroDoc
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	

	public Solicitante obtenerSolicitanteXNumeroCertificado(String numeroCertificado) throws SQLException {
		String sql = SenasaSQL.OBTENER_SOLICITANTE_X_NUMERO_CERTIFICADO;
    String sql2 = SenasaSQL.OBTENER_SOLICITANTE_X_NUMERO_CERTIFICADOII; 
		Log(" AQUI VA EL " + sql);

		Connection con =null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Log("= PARAMETROS = ");
		Log(" numeroCertificado = " + numeroCertificado);
		Solicitante retval = new Solicitante();
	  try {
        con = helper.getConnection();  
        pst = con.prepareStatement(sql);
        pst.setString(1, numeroCertificado);
    
        Log(" = ANTES DE EJECUTAR = ");
        rs = pst.executeQuery();
        
        if(rs.next()==false){  
              pst = con.prepareStatement(sql2);
              pst.setString(1, numeroCertificado);
              rs = pst.executeQuery();
              Log(" = ENTRANDO = ");
          rs.next();
                retval = obtSolicitante(rs);
              Log(" = FIN TODITO = ");             
        }else{
              pst = con.prepareStatement(sql);
              pst.setString(1, numeroCertificado);
              rs = pst.executeQuery();
              rs.next();
              Log(" = ENTRANDO = ");
                retval = obtSolicitante(rs);
              Log(" = FIN TODITO = ");
            }
        
    
	  } catch (SQLException e) {
	    Log("obtenerSolicitanteXNumeroCertificado", e);
	  } catch (Exception e) {
	    Log("obtenerSolicitanteXNumeroCertificado", e);
	  } finally {
	    cleanup(con, pst,rs);
	  }
		return retval;
	}

	public Solicitante obtenerSolicitanteXNumeroCertificadoPZI(String numeroCertificado) throws SQLException {
		String sql = SenasaSQL.OBTENER_SOLICITANTE_X_NUMERO_CERTIFICADO_PZI;

		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Log("= PARAMETROS = ");
		Log(" numeroCertificado = " + numeroCertificado);
		Solicitante retval = new Solicitante();
	  try {
            con = helper.getConnection();  
      pst = con.prepareStatement(sql);
      pst.setString(1, numeroCertificado);
  
      Log(" = ANTES DE EJECUTAR = ");
      rs = pst.executeQuery();
      Log(" = ENTRANDO = ");
      while (rs.next()) {
        retval = obtSolicitante(rs);
      }
      Log(" = FIN TODITO = ");
	  } catch (SQLException e) {
	    Log("obtenerSolicitanteXNumeroCertificadoPZI", e);
	  } catch (Exception e) {
	    Log("obtenerSolicitanteXNumeroCertificadoPZI", e);
	  } finally {
	    cleanup(con, pst,rs);
	  }
		return retval;
	}
  /**
   * @param dni
   * @param nombre
   * @param apellido
   * @return
   * @throws SQLException
   */
  public String guardarObtenerPersona(String dni, String nombre, String apellido) throws SQLException {
    Solicitante sol = obtenerSolicitante("dni", dni);
    if (sol.getCodigoSolicitante() == null || sol.getCodigoSolicitante().length() <= 0) {
      boolean res = guardarPersona(dni, nombre, apellido, "NATURAL", "01");
      if (res) {
        sol = obtenerSolicitante("dni", dni);
        return sol.getCodigoSolicitante();
      } else {
        throw new SQLException("NO SE PUDO GUARDAR LA PERSONA");
      }
    } else {
      return sol.getCodigoSolicitante();
    }
  }

	/**
	 * @param dniRuc
	 * @param nombre
	 * @param apellido
	 * @param tipoPersona
	 * @param tipoDoc
	 * @return
	 */
	public Boolean guardarPersona(String dniRuc, String nombre, String apellido, String tipoPersona, String tipoDoc) {
		String sql = SenasaSQL.INSERTAR_PERSONA;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;

		boolean retval = false;
		try {
            con = helper.getConnection();  
			pst = con.prepareStatement(sql);
			// (documento_tipo,documento_numero,nombre_razon_social,persona_tipo,nombres,apellido_paterno)
			pst.setString(1, tipoDoc);
			pst.setString(2, dniRuc);
			pst.setString(3, nombre + " " + apellido);
			pst.setString(4, tipoPersona);
			pst.setString(5, nombre);
			pst.setString(6, apellido);
			Log(" = ANTES DE EJECUTAR = ");
			pst.execute();
			Log(" = YA EJECUTE = ");
			retval = true;
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("guardarPersona", e);
		} catch (Exception e) {
			Log("guardarPersona", e);
		} finally {
		  cleanup(con, pst,null);
		}
		return retval;
	}


	/**
	 * @param dniRuc
	 * @param nombre
	 * @param apellido
	 * @param tipoPersona
	 * @param tipoDoc
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	private String guardarPersona(Persona persona, Connection con) throws SQLException {
		//String dniRuc,String nombre,String apellido,String tipoPersona,String tipoDoc
		String sql = SenasaSQL.INSERTAR_PERSONA_SP;
		String rpta = "";
		CallableStatement cstmt = null;
		try {
			Log("=======Inicio de guradar persona ======= ");
			cstmt = con.prepareCall(sql);
			Log(" Preparando llamada al SP " + sql);
			Log(" PARAM Dni = " + persona.getNumeroDoc());
			Log(" PARAM Ruc = " + persona.getRuc());
			Log(" PARAM Nombre= " + persona.getRazonSocial());

			cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
			cstmt.setString(2, null); //p_persona_id
			cstmt.setString(3, persona.getRazonSocial());
			cstmt.setString(4, persona.getTipoPersona()); //Natural
			cstmt.setString(5, persona.getTipoDoc());
			cstmt.setString(6, persona.getNumeroDoc());
			cstmt.setString(7, persona.getRuc());
			cstmt.setString(8, persona.getDireccion());
			cstmt.setString(9, persona.getIdDepartamento());
			cstmt.setString(10, persona.getIdProvincia());
			cstmt.setString(11, persona.getIdDistrito());
			cstmt.setString(12, persona.getTelefono());
			cstmt.setString(13, persona.getTelMovil());
			cstmt.setString(14, persona.getEmail());


			cstmt.setDate(15, Utility.parseStringToDate(persona.getFechaNac())); //p_fecha_nacimiento
			cstmt.setString(16, persona.getRefDireccion()); //p_referencia_direccion
			cstmt.setDate(17, Utility.parseStringToDate(persona.getFechaAlta())); //p_fecha_alta
			cstmt.setDate(18, Utility.parseStringToDate(persona.getFechaBaja())); //p_fecha_baja
			cstmt.setString(19, persona.getNombreComercial()); //p_nombre_comercial
			cstmt.setString(20, persona.getEstadoJuridico()); //p_estado_juridico
			cstmt.setString(21, persona.getSincroEstado()); //p_sincronizacion_estado
			cstmt.setDate(22, Utility.parseStringToDate(persona.getFechaSincron())); //p_sincronizacion_fecha
			cstmt.setString(23, persona.getUsuario()); //p_usuario

			Log(" Ejecutando llamada al SP " + sql);
			cstmt.execute();
			Log(" Ejecutó correctamente ");
			rpta = cstmt.getString(1);
			Log(" resultado= " + rpta);
		} catch (SQLException e) {
			rpta = "-1";
			Log(" SQLException : grabar persona", e);
		} catch (Exception e) {
			rpta = "-1";
			Log(" Exception al grabar persona ", e);
		} finally {
			if (cstmt != null && (!cstmt.isClosed()))
				cstmt.close();
			//Datacleanup(con, cstmt);
		}
		return rpta;
	}


	/**
	 * @param argSolicitante
	 * @return
	 */
	public Boolean adicionarSolicitante(Solicitante argSolicitante) {
		String sql = SenasaSQL.INSERTAR_SOLICITANTE;

		Log(" AQUI VA EL " + sql);

		Connection con = null;
		CallableStatement call = null;

		boolean retval = false;
		try {
            con = helper.getConnection();  
			call = con.prepareCall(sql);
			call.setString(1, argSolicitante.getTipoDocumento());
			call.setString(2, argSolicitante.getDniRuc());
			call.setString(3, argSolicitante.getNombreRazonSocial());
			call.setString(4, argSolicitante.getDomicilioLegal());
			call.setString(5, argSolicitante.getDepartamento());
			call.setString(6, argSolicitante.getProvincia());
			call.setString(7, argSolicitante.getDistrito());
			call.setString(8, argSolicitante.getTelefono());
			call.setString(9, argSolicitante.getTelefonoMovil());
			call.setString(10, argSolicitante.getEmail());
			if (argSolicitante.getTipoDocumento().toLowerCase().startsWith("01")) {
				call.setString(11, "N");
			} else {
				call.setString(11, "J");
			}
			Log(" = ANTES DE EJECUTAR = ");
			call.execute();
			Log(" = YA EJECUTE = ");
			retval = true;
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("obtenerSolicitante", e);
		} catch (Exception e) {
			Log("obtenerSolicitante", e);
		} finally {
		  cleanup(con, call,null);  
		}
		return retval;
	}

	/**
	 * @param dniRucSolicitante
	 * @return
	 */
	public ArrayList<PredioCPE> obtenerPrediosCPESolicitante(String dniRucSolicitante) {

		String sql = SenasaSQL.OBTENER_PREDIOS_X_NUM_DOC_SOLICITANTE;

		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Log("= PARAMETROS = ");

		ArrayList<PredioCPE> retval = new ArrayList<PredioCPE>();
		try {
            con = helper.getConnection();  
			pst = con.prepareStatement(sql);
			pst.setString(1, dniRucSolicitante);
			Log(" = ANTES DE EJECUTAR = ");
			rs = pst.executeQuery();
			Log(" = ENTRANDO = ");
			while (rs.next()) {
				Log(" = NUM COLOUNMSMS  = " + rs.getMetaData().getColumnCount());
				retval.add(obtPredio(rs));
			}
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("obtenerPrediosCPESolicitante", e);
		} catch (Exception e) {
			Log("obtenerPrediosCPESolicitante", e);
		} finally {
		  cleanup(con, pst,rs);  
		}
		return retval;
	}

	/**
	 * @param dniRucSolicitante
	 * @param registro
	 * @return
	 */
	public Boolean validarAlmacenGuardacustodia(String dniRucSolicitante, String registro) {
		String sql = SenasaSQL.VALIDAR_ALMACENGUARDACUSTODIA;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Log("DNI " + dniRucSolicitante);
		Log("REGISTRO " + registro);
		boolean retval = false;
		try {
            con = helper.getConnection();  
			pst = con.prepareStatement(sql);
			pst.setString(1, dniRucSolicitante);
			pst.setString(2, registro);
			Log(" = ANTES DE EJECUTAR = ");
			rs = pst.executeQuery();
			Log(" = ENTRANDO = ");
			while (rs.next()) {
				String s = rs.getString(1);
				Log("====== ============ ESTO ES ====== >>>>> " + s);
				if (Integer.parseInt(s) > 0)
					retval = true;
				break;
			}
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("validarAlmacenGuardacustodia", e);
		} catch (Exception e) {
			Log("validarAlmacenGuardacustodia", e);
		} finally {
		  cleanup(con, pst,rs);
		}
		return retval;
	}

	/**
	 * @param dniRucSolicitante
	 * @param registro
	 * @return
	 */
	public Boolean validarGermoplasma(String dniRucSolicitante, String registro) {
		String sql = SenasaSQL.VALIDAR_GERMOPLASMA_PERSONA;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Log("DNI " + dniRucSolicitante);
		Log("REGISTRO " + registro);
		boolean retval = false;
		try {
            con = helper.getConnection();  
			pst = con.prepareStatement(sql);
			pst.setString(1, dniRucSolicitante);
			pst.setString(2, registro);
			Log(" = ANTES DE EJECUTAR = ");
			rs = pst.executeQuery();
			Log(" = ENTRANDO = ");
			while (rs.next()) {
				String s = rs.getString(1);
				Log("====== ============ ESTO ES ====== >>>>> " + s);
				if (Long.parseLong(s) > 0)
					retval = true;
				break;
			}
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("validarGermoplasma", e);
		} catch (Exception e) {
			Log("validarGermoplasma", e);
		} finally {
		  cleanup(con, pst,rs);  
		}
		return retval;
	}

	/**
	 * @param dniRucSolicitante
	 * @param registro
	 * @return
	 */
	public Boolean validarRegistroCPE(String dniRucSolicitante, String registro) {
		String sql = SenasaSQL.VALIDAR_REGISTRO_CPE;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Log("DNI " + dniRucSolicitante);
		Log("REGISTRO " + registro);
		boolean retval = false;
		try {
            con = helper.getConnection();  
			pst = con.prepareStatement(sql);
			pst.setString(1, dniRucSolicitante);
			pst.setString(2, registro);
			//Log(" = ANTES DE EJECUTAR = ");
			rs = pst.executeQuery();
			//Log(" = ENTRANDO AGARRO CAMBIO = ");
			Utility.printResultSet(rs);
			while (rs.next()) {
				Long s = rs.getLong(1);
				Log("====== ============ ESTO ES ====== >>>>> " + s);
				if (Long.parseLong(rs.getString(1)) > 0)
					retval = true;
				break;
			}
			// Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("validarRegistroCPE", e);
		} catch (Exception e) {
			Log("validarRegistroCPE", e);
		} finally {
		  cleanup(con, pst,rs);
		}
		return retval;
	}

	public Double obtenerSaldoFavorSolicitante(String dniRucSolicitante) {
		//SaldoClienteDAO saldo = new SaldoClienteDAO();
		//return saldo.obtenerSaldoFavorCliente(dniRucSolicitante);
		String idPersona = obtenerIdPersona(dniRucSolicitante);
		if ((idPersona.isEmpty()) || (idPersona == "")) {
			logger.fatal("NO SE ENCONTRO EL IDENTIFICADOR DE PERSONA PARA EL SOLICITANTE: " + dniRucSolicitante);
			return -1.0;
		}
		Double retval = 0.0;
		String sql = SenasaSQL.OBTENER_SALDO_FAVOR_CLIENTE;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
            con = helper.getConnection();
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, idPersona);
			cstmt.registerOutParameter(2, Types.DOUBLE);
			Log(" = voy a ejecutar  OBTENER_SALDO_CLIENTE = ");
			cstmt.execute();
			retval = cstmt.getDouble(2);
			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("obtenerSaldoFavorSolicitante", e);
		} catch (Exception e) {
			Log("obtenerSaldoFavorSolicitante", e);
		} finally {
		  cleanup(con, cstmt,rs);
		}
		return retval;
	}

	private void Log(String s) {
		logger.debug(s);
	}

	private void Log(String s, java.lang.Throwable p2) {
		logger.fatal("SolicitanteDAO - " + s, p2);
	}

	private Solicitante obtSolicitante(ResultSet rs) throws SQLException {
		Solicitante ret = new Solicitante();
		ret.setCodigoSolicitante(rs.getString("persona_id"));
		ret.setDniRuc(rs.getString("documento_numero"));
		ret.setTipoDocumento(rs.getString("documento_tipo"));
		ret.setNombreRazonSocial(rs.getString("nombre_razon_social"));
		ret.setDomicilioLegal(rs.getString("direccion"));
		ret.setTelefono(rs.getString("telefono"));
		ret.setTelefonoMovil(rs.getString("telefono_movil"));
		ret.setEmail(rs.getString("correo_electronico"));
		ret.setDepartamento(rs.getString("departamento_id"));
		ret.setProvincia(rs.getString("provincia_id"));
		ret.setDistrito(rs.getString("distrito_id"));
		ret.setDniRepresentanteLegal(rs.getString("dniRepLegal"));
	  ret.setTipoSolicitante(rs.getString("persona_tipo"));

		String representanteLegal = Utility.remplazoNull(rs.getString("nombres"));
		representanteLegal = representanteLegal + " " + Utility.remplazoNull(rs.getString("apellido_paterno"));
		representanteLegal = representanteLegal + " " + Utility.remplazoNull(rs.getString("apellido_materno"));
		ret.setNombreRepresentanteLegal(representanteLegal);

		ret.setNombreDepartamento(rs.getString("departamento_nombre"));
		ret.setNombreProvincia(rs.getString("provincia_nombre"));
		ret.setNombreDistrito(rs.getString("distrito_nombre"));

		return ret;
	}
  
  private Solicitante obtSolicitanteMin(ResultSet rs) throws SQLException {
    Solicitante ret = new Solicitante();
    ret.setCodigoSolicitante(rs.getString("persona_id"));
    ret.setDniRuc(rs.getString("documento_numero"));
    ret.setTipoDocumento(rs.getString("documento_tipo"));
    ret.setNombreRazonSocial(rs.getString("nombre_razon_social"));
    ret.setEmail(rs.getString("correo_electronico"));
    return ret;
  }

	private PredioCPE obtPredio(ResultSet rs) throws SQLException {
		PredioCPE cpe = new PredioCPE();
		cpe.setPredioCPE(rs.getString(1));
		cpe.setCodPredioCPE(rs.getString(2));
		return cpe;
	}

	/**
	 * @param rucAgenteAduanas
	 * @param papeletaID
	 * @param excedente
	 * @return
	 */
	public String abonarSaldoFavorSolicitantePapeleta(String rucAgenteAduanas, String papeletaID, Double excedente) {
		SaldoClienteDAO saldo = new SaldoClienteDAO();
		return saldo.abonarSaldoFavorSolicitantePapeleta(rucAgenteAduanas, papeletaID, excedente);
	}

	/**
	 * @param rucAgenteAduanas
	 * @param notaabono
	 * @param excedente
	 * @return
	 */
	public String abonarSaldoFavorSolicitanteNotaAbono(String rucAgenteAduanas, String notaabono, Double excedente) {
		SaldoClienteDAO saldo = new SaldoClienteDAO();
		return saldo.abonarSaldoFavorSolicitanteNotaAbono(rucAgenteAduanas, notaabono, excedente);
	}

	/**
	 * @param dniRucSolicitante
	 * @param tipodeposito
	 * @param numerodeposito
	 * @param fechadeposito
	 * @param montodepositado
	 * @return
	 */
	public String crearDocPapeleta(String dniRucSolicitante, String tipodeposito, String numerodeposito, Date fechadeposito, Double montodepositado) {
		SaldoClienteDAO saldo = new SaldoClienteDAO();
		return saldo.CrearPapeleta(dniRucSolicitante, tipodeposito, numerodeposito, fechadeposito, montodepositado);
	}

	/**
	 * @return
	 */
	public ArrayList<TipoDocIden> obtenerTiposDocInden() {
		String sql = SenasaSQL.OBTENER_TIPOS_DOCUMENTOS;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<TipoDocIden> retval = new ArrayList<TipoDocIden>();
		try {
            con = helper.getConnection();  
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				retval.add(new TipoDocIden(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("obtenerTiposDocInden", e);
		} catch (Exception e) {
			Log("obtenerTiposDocInden", e);
		} finally {
		  cleanup(con, pst,rs);  
		}
		return retval;
	}

	/**
	 * @return
	 */
	public ArrayList<TipoFiltro> obtenerTiposFiltroPersona() {
		ArrayList<TipoFiltro> retval = new ArrayList<TipoFiltro>();

		String sql = SenasaSQL.OBTENER_TIPOS_FILTRO_PERSONA;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
            con = helper.getConnection();
			cs = con.prepareCall(sql);

			Log(" = ANTES DE EJECUTAR = ");
			cs.registerOutParameter(1, OracleTypes.CURSOR, "SYS_REFCURSOR");
			cs.execute();

			Log(" = ENTRANDO = ");
			rs = (ResultSet)cs.getObject(1);
			while (rs.next()) {
				retval.add(new TipoFiltro(rs.getString("CODIGO"), rs.getString("DESCRIPCION")));
			}
			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("obtenerTiposDocInden", e);
		} catch (Exception e) {
			Log("obtenerTiposDocInden", e);
		} finally {
		  cleanup(con, cs,rs);  
		}
		return retval;
	}

	public String cargarSaldo(String dniRucSolicitante, Double montoUtilizado) {

		SaldoClienteDAO saldo = new SaldoClienteDAO();
		return saldo.cargarSaldo(dniRucSolicitante, montoUtilizado);
	}

	/**
	 * @param codigoRecibo
	 * @param numeroRecibo
	 * @param fechaRecibo
	 * @param codigoCentroTramite
	 * @param dniRucSolicitante
	 * @param codigoExpediente
	 * @param montoPagado
	 * @param montoRecibo
	 * @param montoSaldo
	 * @param urlRecibo
	 * @return
	 */
	/*
  public Boolean guardarRecibo(String codigoRecibo, String prefijo, String numeroRecibo, String fechaRecibo,
                               String codigoCentroTramite, String dniRucSolicitante, String codigoExpediente,
                               Double montoPagado, Double montoRecibo, Double montoSaldo,
                               String observacion, String urlRecibo){
  */
	public String guardarRecibo(String numeroRecibo, String fechaRecibo, String codigoCentroTramite, String dniRucSolicitante, String codigoExpediente,
								Double montoPagado, Double montoRecibo, Double montoSaldo, String observacion, String urlRecibo,
								ArrayList<ReciboServicio> arrayRecibosServicios) {

		String _idPersona = obtenerIdPersona(dniRucSolicitante);
		String codigoRecibo;
		if ((_idPersona.isEmpty()) || (_idPersona == "")) {
			logger.fatal("NO SE ENCONTRO EL IDENTIFICADOR DE PERSONA PARA EL SOLICITANTE: " + dniRucSolicitante);
			return "-1";
		}

		String prefijo = obtenerPrefijoCentroTramite(codigoCentroTramite);
		if ((prefijo.isEmpty()) || (prefijo == "")) {
			logger.fatal("NO SE ENCONTRO EL PREFIJO PARA EL CODIGO DE CENTRO DE TRAMITE: " + codigoCentroTramite);
			return "-1";
		}

		//String observacion = cargarSaldo(dniRucSolicitante, montoPagado);

		String sql = SenasaSQL.GUARDAR_RECIBO;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		CallableStatement cs = null;

		String retval = "-1";
		logger.debug("Entrando a ejecutar guardarRecibo()");
		try {
            con = helper.getConnection();
			con.setAutoCommit(false);
			//pst = con.prepareStatement(sql);
			cs = con.prepareCall(sql);
			//(codigo_recibo,prefijo, numero_recibo, fecha_recibo, codigo_centro_tramite,
			//persona_id, codigo_expediente, monto_pagado, monto_recibo, monto_saldo, estado, observacion, url_recibo)
			cs.setString(1, numeroRecibo);
			cs.setString(2, prefijo);
			cs.setDate(3, Utility.parseStringToDate(fechaRecibo));
			cs.setString(4, codigoCentroTramite);
			cs.setString(5, _idPersona);
			cs.setString(6, codigoExpediente);
			cs.setDouble(7, montoPagado);
			cs.setDouble(8, montoRecibo);
			cs.setDouble(9, montoSaldo);
			cs.setString(10, "ACTIVO");
			cs.setString(11, observacion);
			cs.setString(12, urlRecibo);
			cs.registerOutParameter(13, Types.VARCHAR);
			Log(" = ANTES DE EJECUTAR = ");
			cs.execute();
			codigoRecibo = cs.getString(13);
			int k;

			logger.debug("Entrando a guardar los Servicios en guardarReciboServicio()");
			logger.debug("arrayRecibosServicios.size(): " + arrayRecibosServicios.size());

			for (k = 0; k < arrayRecibosServicios.size(); k++) {
				String _codigoRecibo = codigoRecibo; //arrayRecibosServicios.get(k).getCodigoRecibo();
				String _codigoServicio = arrayRecibosServicios.get(k).getCodigoServicio();
				Double _montoServicio = arrayRecibosServicios.get(k).getMontoServicio();
				Double _cantidad = arrayRecibosServicios.get(k).getCantidad();
				logger.debug("guardarReciboServicio.CodigoRecibo: " + _codigoRecibo);
				logger.debug("guardarReciboServicio.CodigoServicio: " + _codigoServicio);
				logger.debug("guardarReciboServicio.MontoServicio: " + _montoServicio);
				logger.debug("guardarReciboServicio.Cantidad: " + _cantidad);

				Boolean operResult = guardarReciboServicio(_codigoRecibo, _codigoServicio, _montoServicio, _cantidad, con);

			}
			logger.debug("Finalizando guardar los Servicios en guardarReciboServicio()");


			con.commit();
			con.setAutoCommit(true);
			Log(" = YA EJECUTE = ");
			retval = codigoRecibo;
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException f) {
				Log("guardarRecibo", f);
			}
			Log("guardarRecibo", e);

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException f) {
				Log("guardarRecibo", f);
			}
			Log("guardarRecibo", e);
		} finally {
		  cleanup(con, cs,null);  
		}
		return retval;
	}

	/**
	 * @param codigoRecibo
	 * @param codigoServicio
	 * @param montoServicio
	 * @param cantidad
	 * @return
	 */

	public Boolean guardarReciboServicio(String codigoRecibo, String codigoServicio, Double montoServicio, Double cantidad) {

		String sql = SenasaSQL.GUARDAR_RECIBO_SERVICIO;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;

		Boolean retval = false;
		try {
            con = helper.getConnection();
			pst = con.prepareStatement(sql);
			//(codigo_recibo, codigo_servicio, monto_servicio, cantidad)
			pst.setString(1, codigoRecibo);
			pst.setString(2, codigoServicio);
			pst.setDouble(3, montoServicio);
			pst.setDouble(4, cantidad);

			Log(" = ANTES DE EJECUTAR = ");
			pst.execute();
			Log(" = YA EJECUTE = ");
			retval = true;
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("guardarReciboServicio", e);
		} catch (Exception e) {
			Log("guardarReciboServicio", e);
		} finally {
		  cleanup(con, pst,null);  
		}
		return retval;

	}

	private Boolean guardarReciboServicio(String codigoRecibo, String codigoServicio, Double montoServicio, Double cantidad, Connection con) {

		String sql = SenasaSQL.GUARDAR_RECIBO_SERVICIO;
		Log(" AQUI VA EL " + sql);

		PreparedStatement pst = null;

		Boolean retval = false;
		try {
			pst = con.prepareStatement(sql);
			//(codigo_recibo, codigo_servicio, monto_servicio, cantidad)
			pst.setString(1, codigoRecibo);
			pst.setString(2, codigoServicio);
			pst.setDouble(3, montoServicio);
			pst.setDouble(4, cantidad);

			Log(" = ANTES DE EJECUTAR = ");
			pst.execute();
			Log(" = YA EJECUTE = ");
			retval = true;
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("guardarReciboServicio", e);
		} catch (Exception e) {
			Log("guardarReciboServicio", e);
		} finally {
			//Datacleanup(con, pst);
		}
		return retval;

	}


	public Recibo obtenerDatosRecibo(String codigoRecibo) {

		String sql = SenasaSQL.OBTENER_RECIBO_DATOS;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		Recibo retval = new Recibo();
		try {
            con = helper.getConnection();
			pst = con.prepareStatement(sql);
			cs = con.prepareCall(sql);

			Log(" = ANTES DE EJECUTAR = ");
			cs.setString(1, codigoRecibo);
			cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

			cs.execute();
			Log(" = ENTRANDO = ");
			rs = (ResultSet)cs.getObject(2);
		  SimpleDateFormat parseDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			while (rs.next()) {
				retval.setCodigoRecibo(rs.getString(1));
				retval.setPrefijo(rs.getString(2));
				retval.setNumeroRecibo(rs.getString(3));
				retval.setFechaRecibo(parseDate.parse(rs.getString(4)));
				retval.setCodigoCentroTramite(rs.getString(5));
				retval.setPersonaId(rs.getString(6));
				retval.setCodigoExpediente(rs.getString(7));
				retval.setMontoPagado(rs.getDouble(8));
				retval.setMontoRecibo(rs.getDouble(9));
				retval.setMontoSaldo(rs.getDouble(10));
				retval.setEstado(rs.getString(11));
				retval.setObservacion(rs.getString(12));
				retval.setUrlRecibo(rs.getString(13));

			}
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("obtenerDatosRecibo", e);
		} catch (Exception e) {
			Log("obtenerDatosRecibo", e);
		} finally {
		  cleanup(con, pst,rs);  
		}

		return retval;

	}

	public Boolean actualizaUrlRecibo(String codigoRecibo, String urlRecibo) {

		String sql = SenasaSQL.ACTUALIZA_URL_RECIBO;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;

		Boolean retval = false;
		try {
            con = helper.getConnection();
		  pst = con.prepareStatement(sql);

		  pst.setString(1,codigoRecibo);
		  pst.setString(2,null);
		  pst.setString(3,urlRecibo);
		  pst.setString(4,null);
		  
		  Log(" = ANTES DE EJECUTAR = ");
		  pst.execute();
		  
		  Log(" = YA EJECUTE = ");
		  retval = true;
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("actualizaUrlRecibo", e);
		} catch (Exception e) {
			Log("actualizaUrlRecibo", e);
		} finally {
		  cleanup(con, pst,null);  
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
			rs = pst.executeQuery();

			int i = 0;
			while (rs.next()) {
				i++;
				if (i == 1)
					retval = rs.getString(1);
			}
			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("obtenerIdPersona", e);
		} catch (Exception e) {
			Log("obtenerIdPersona", e);
		} finally {
		  cleanup(con, pst,rs);  
		}
		return retval;
	}

	private String obtenerPrefijoCentroTramite(String codigoCentroTramite) {

		if (codigoCentroTramite == null)
			return "";
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
			rs = pst.executeQuery();

			while (rs.next()) {
				retval = rs.getString(1);
			}
			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("obtenerPrefijoCentroTramite", e);
		} catch (Exception e) {
			Log("obtenerPrefijoCentroTramite", e);
		} finally {
		  cleanup(con, pst,rs);  
		}
		return retval;
	}

	private int obtenerCantidadReciboXPrefijo(String prefijo, String codigoCentroTramite) {

		if (codigoCentroTramite == null)
			return -1;
		String sql = SenasaSQL.OBTENER_CANT_RECIBOS_X_PREFIJO;
		Log("obtenerCantidadReciboXPrefijo(): AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int retval = -1;
		try {
            con = helper.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, codigoCentroTramite);
			pst.setString(1, codigoCentroTramite);
			rs = pst.executeQuery();

			while (rs.next()) {
				retval = rs.getInt(1) + 1;
			}
			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("obtenerCantidadReciboXPrefijo", e);
		} catch (Exception e) {
			Log("obtenerCantidadReciboXPrefijo", e);
		} finally {
            cleanup(con, pst, rs);
		}
		return retval;
	}

	/**
	 * @return
	 */
	public ArrayList<Importador> obtenerImportadoresXPais(String codPais) {
		String sql = SenasaSQL.OBTENER_IMPORTADORES_X_PAIS;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Importador> retval = new ArrayList<Importador>();
		try {
            con = helper.getConnection();   
			pst = con.prepareStatement(sql);
			pst.setString(1, codPais);
			rs = pst.executeQuery();
			while (rs.next()) {
				//retval.add(new TipoDocIden(rs.getString(1),rs.getString(2),rs.getInt(3)));
				Importador imp = new Importador();
				imp.setCodigo(rs.getString(2));
				imp.setPais(rs.getString(1));
				imp.setNombre(rs.getString(3));
				imp.setDireccion(rs.getString(4));
				retval.add(imp);
			}
			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("obtenerImportadoresXPais", e);
		} catch (Exception e) {
			Log("obtenerImportadoresXPais", e);
		} finally {
		  cleanup(con, pst,rs);  
		}
		return retval;
	}


	public static void main(String[] args) {
		SolicitanteDAO std = new SolicitanteDAO();
		Solicitante obj = new Solicitante();
		obj = std.obtenerSolicitante("01", "33261657");


		/* SolicitanteDAO std= new SolicitanteDAO();
     ArrayList<ReciboServicio> arrlist = new ArrayList<ReciboServicio>();
     ReciboServicio objrecser = new ReciboServicio();

     objrecser.setCodigoRecibo("");
     objrecser.setCodigoServicio("097");
     objrecser.setMontoServicio(560.0);
     objrecser.setCantidad(10.0);

     arrlist.add(objrecser);
    */
		//boolean  _oper = std.guardarRecibo("NM00001", "02/04/2011", "01", "40038522","110100000015",100.0,80.0,20.0, "http://doc.doc.pe", arrlist);

		//boolean  _oper = std.guardarRecibo("001","AA","89809","02/04/2011","13","10443866057","101300000001",100.0,80.0,20.0,"Prueba01","http://doc.doc.pe");
		//boolean  _oper = std.guardarReciboServicio("001","184",56.0,10.0);
		//ArrayList<Importador> importadores = std.obtenerImportadoresXPais("4002");

		//String _msg= std.cargarSaldo("08", "098");
		// System.out.print("getUserName:"+frmnt.getUserName()+"\n");
		// System.out.print("getNomencaltura:"+frmnt.getNomencaltura()+"\n");149
		// System.out.print("getLugar:"+frmnt.getLugar()+"\n");

	}

	public Solicitante obtenerSolicitanteXidPersona(String idPersona) {

		String sql = SenasaSQL.OBTENER_SOLICITANTE_X_IDPERSONA;

		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Log("= PARAMETROS = ");
		Log("idPersona = " + idPersona);

		Solicitante retval = new Solicitante();
		try {
            con = helper.getConnection();
			pst = con.prepareStatement(sql);

			pst.setString(1, idPersona);

			Log(" = ANTES DE EJECUTAR = ");
			rs = pst.executeQuery();
			Log(" = ENTRANDO = ");
			if (rs.next()) {
				retval = obtSolicitante(rs);
			}
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("obtenerSolicitanteXidPersona", e);
		} catch (Exception e) {
			Log("obtenerSolicitanteXidPersona", e);
		} finally {
            cleanup(con, pst, rs);
		}
		return retval;
	}

}
