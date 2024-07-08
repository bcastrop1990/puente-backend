package pe.gob.senasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.AgenteAduanas;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.AgenteAduanasInterface;


public class AgenteAduanasDAO extends BaseDAO implements AgenteAduanasInterface {

    protected static Logger logger = Logger.getLogger(AgenteAduanasDAO.class);
    
    private SaldoClienteDAO saldoDao;
    private DBHelper helper;
    
    public AgenteAduanasDAO() {
        saldoDao = new SaldoClienteDAO();
        helper = new DBHelper(SenasaSQL.dsAgenteAduana);        
    }

    public AgenteAduanas obtenerAgenteAduanas(String numeroDocumento)  {
        
        Connection con = null;//03/01/2017        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        AgenteAduanas agenteAduanasResult = new AgenteAduanas();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(SenasaSQL.OBTENER_AGENCIA_ADUANA_X_RUC);
            pst.setString(1, numeroDocumento);
            Log(" = ANTES DE EJECUTAR = ");
            System.out.println(" = ANTES DE EJECUTAR = " + numeroDocumento);
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");            
            System.out.println(" = ENTRANDO = ");
            while (rs.next()) {
                Log(" = SETEANDO = ");
                System.out.println(" = SETEANDO = ");                
                agenteAduanasResult.setDniRuc(rs.getString("ruc"));
                agenteAduanasResult.setNombreRazonSocial(rs.getString("nombre_razon_social"));
                agenteAduanasResult.setDomicilioLegal(rs.getString("direccion"));
                agenteAduanasResult.setDistrito(rs.getString("distrito"));
                agenteAduanasResult.setProvincia(rs.getString("provincia"));
                agenteAduanasResult.setDepartamento(rs.getString("departamento"));
                agenteAduanasResult.setTelefono(rs.getString("telefono"));
                agenteAduanasResult.setEmail(rs.getString("correo_electronico"));

                String representanteLegal = rs.getString("nombres")==null?"":rs.getString("nombres");
                representanteLegal = representanteLegal + " " +(rs.getString("apellido_paterno")==null?"":rs.getString("apellido_paterno"));
                representanteLegal = representanteLegal + " " + (rs.getString("apellido_materno")==null?"":rs.getString("apellido_materno"));
                 
                agenteAduanasResult.setNombreRepresentanteLegal(representanteLegal);
                agenteAduanasResult.setDniRepresentanteLegal("");
                agenteAduanasResult.setUrbanizacion(rs.getString("direccion"));
                agenteAduanasResult.setFax(rs.getString("telefono"));
                
                agenteAduanasResult.setTelefonoMovil(rs.getString("telefono_movil"));
                agenteAduanasResult.setIdPersona(rs.getString("persona_id"));
              
                Log(" = FIN SETEANDO = ");
                System.out.println(" = FIN SETEANDO = ");
            }
            Log(" = FIN TODO = ");
            System.out.println(" = FIN TODO = ");
        } catch (SQLException e) {
            logger.fatal("AgenteAduanasDAO - obtenerAgenteAduanas",e);
            e.printStackTrace();
        }catch (Exception e) {
            logger.fatal("AgenteAduanasDAO - obtenerAgenteAduanas",e);
            e.printStackTrace();
        }
        finally {
          cleanup(con,pst);          
        }

        return agenteAduanasResult;
    }

    public double obtenerSaldoFavorAgenteAduanas(String dniRucSolicitante) {
        return saldoDao.obtenerSaldoFavorCliente(dniRucSolicitante);
    }

    public String abonarSaldoFavorAgenteAduanasPapeleta(String rucAgenteAduanas,String papeletaID,
                                                 Double excedente) {
        return saldoDao.abonarSaldoFavorSolicitantePapeleta(rucAgenteAduanas,papeletaID ,excedente);
    }
    
    public String abonarSaldoFavorAgenteAduanasNotaAbono(String rucAgenteAduanas,String notaabono,
                                                 Double excedente) {
        return saldoDao.abonarSaldoFavorSolicitantePapeleta(rucAgenteAduanas,notaabono, excedente);
    }
    
    private void Log(String s){
            logger.debug(s);
        }

    public String CrearPapeleta(String dniRucSolicitante, String tipodeposito,
                                String numerodeposito, Date fechadeposito,
                                Double montodepositado) {
        return saldoDao.CrearPapeleta(dniRucSolicitante, tipodeposito, numerodeposito, fechadeposito, montodepositado);
    }

    public AgenteAduanas obtenerAgenteAduanasXidPersona(String idPersona) {
        Connection con = null;        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        AgenteAduanas agenteAduanasResult = new AgenteAduanas();
        try {
            con = helper.getConnection();//RCF 03/01/2017
            pst = con.prepareStatement(SenasaSQL.OBTENER_AGENCIA_ADUANA_X_IDPERSONA);
            pst.setString(1, idPersona);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                Log(" = SETEANDO = ");
                agenteAduanasResult.setDniRuc(rs.getString("ruc"));
                agenteAduanasResult.setNombreRazonSocial(rs.getString("nombre_razon_social"));
                agenteAduanasResult.setDomicilioLegal(rs.getString("direccion"));
                agenteAduanasResult.setDistrito(rs.getString("distrito"));
                agenteAduanasResult.setProvincia(rs.getString("provincia"));
                agenteAduanasResult.setDepartamento(rs.getString("departamento"));
                agenteAduanasResult.setTelefono(rs.getString("telefono"));
                agenteAduanasResult.setEmail(rs.getString("correo_electronico"));

                String representanteLegal = rs.getString("nombres")==null?"":rs.getString("nombres");
                representanteLegal = representanteLegal + " " +(rs.getString("apellido_paterno")==null?"":rs.getString("apellido_paterno"));
                representanteLegal = representanteLegal + " " + (rs.getString("apellido_materno")==null?"":rs.getString("apellido_materno"));
                 
                agenteAduanasResult.setNombreRepresentanteLegal(representanteLegal);
                agenteAduanasResult.setDniRepresentanteLegal("");
                agenteAduanasResult.setUrbanizacion(rs.getString("direccion"));
                agenteAduanasResult.setFax(rs.getString("telefono"));
                
                agenteAduanasResult.setTelefonoMovil(rs.getString("telefono_movil"));
                agenteAduanasResult.setIdPersona(rs.getString("persona_id"));
              
                Log(" = FIN SETEANDO = ");
            }
            Log(" = FIN TODO = ");
        } catch (SQLException e) {
            logger.fatal("AgenteAduanasDAO - obtenerAgenteAduanas",e);
        }catch (Exception e) {
            logger.fatal("AgenteAduanasDAO - obtenerAgenteAduanas",e);
        }
        finally {
            cleanup(con,pst);
        }

        return agenteAduanasResult;
    }
}
