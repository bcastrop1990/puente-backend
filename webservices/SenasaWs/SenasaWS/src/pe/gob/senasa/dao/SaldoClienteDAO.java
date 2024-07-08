package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.Date;

import org.apache.log4j.Logger;

import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.util.Utility;


public class SaldoClienteDAO extends BaseDAO {

    protected static Logger logger = Logger.getLogger(SaldoClienteDAO.class);
    
    DBHelper helper;
    
    public SaldoClienteDAO(){
        helper = new DBHelper(SenasaSQL.dsSolicitante);
    }
    


    public Double obtenerSaldoEnContraCliente(String dniRucSolicitante) {
        return ObtenerSaldo(dniRucSolicitante);
    }

    public Double obtenerSaldoFavorCliente(String dniRucSolicitante) {
        return ObtenerSaldo(dniRucSolicitante);
    }

    private String ActualizarSaldoPapeleta(String dniRucSolicitante,
                                            String papeletadepositoid,
                                            Double montonota) {
        String idCliente = obtenerIdClienteEnSaldo(dniRucSolicitante);
        String retval = null;
        if (idCliente == null || idCliente.length() <= 0) {
            Log(" = EL ID DEL CLIENTE NO SE ENCONTRO =");
            return null;
        }
        //SIGA01.TES_PAGOS_INGRESO.crear_nota_abono_de_papeleta(?,?,?,?);
        Connection con = null;
        String sql = SenasaSQL.ABONAR_SALDO_PAPELETA;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            con = helper.getConnection();
            cstmt = con.prepareCall(sql);
            cstmt.setString(1,idCliente);
            cstmt.setString(2,papeletadepositoid);
            cstmt.setDouble(3,montonota);
            cstmt.registerOutParameter(4,Types.NUMERIC);
            cstmt.executeUpdate();
        } catch (SQLException e) {
            Log("ActualizarSaldo", e);
        } catch (Exception e) {
            Log("ActualizarSaldo", e);
        } finally {
            cleanup(con, null);
        }
        return retval;
    }
    
    
    private String ActualizarSaldoNotaAbono(String dniRucSolicitante,
                                            String notaabonoid_in,
                                            Double montonota) {
        String idCliente = obtenerIdClienteEnSaldo(dniRucSolicitante);
        String retval = null;
        if (idCliente == null || idCliente.length() <= 0) {
            Log(" = EL ID DEL CLIENTE NO SE ENCONTRO =");
            return retval;
        }
        //SIGA01.TES_PAGOS_INGRESO.crear_nota_abono_de_nota(?,?,?,?)
        Connection con = null;
        String sql = SenasaSQL.ABONAR_SALDO_NOTA_ABONO;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            con = helper.getConnection();
            cstmt = con.prepareCall(sql);
            cstmt.setString(1,idCliente);
            cstmt.setString(2,notaabonoid_in);
            cstmt.setDouble(3,montonota);
            cstmt.registerOutParameter(4,Types.NUMERIC);
            cstmt.executeUpdate();
        } catch (SQLException e) {
            Log("ActualizarSaldo", e);
        } catch (Exception e) {
            Log("ActualizarSaldo", e);
        } finally {
            cleanup(con, null);
        }
        return retval;
    }
    
    /*
     * personaid         in       varchar,
      tipodeposito      in       varchar,
      numerodeposito    in       varchar,
      fechadeposito     in       varchar,
      montodepositado   in       number,
      abonoid           out      number
     * */
    public String CrearPapeleta(String dniRucSolicitante,
                                  String tipodeposito,
                                  String numerodeposito,
                                  Date fechadeposito,
                                  Double montodepositado) {
        String retval = "";
        String idCliente = obtenerIdClienteEnSaldo(dniRucSolicitante);
        if (idCliente == null || idCliente.length() <= 0) {
            Log(" = EL ID DEL CLIENTE NO SE ENCONTRO =");
            return null;
        }
        Connection con = null;
        String sql = SenasaSQL.CREAR_PAPELETA_I;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            con = helper.getConnection();
            cstmt = con.prepareCall(sql);
            cstmt.setString(1,idCliente);
            cstmt.setString(2,tipodeposito);
            cstmt.setString(3,numerodeposito);
            cstmt.setDate(4,Utility.toSQLDate(fechadeposito));
            cstmt.setDouble(5,montodepositado);
            //se agrego un nuevo parametro: NULL en numeregiarc
            cstmt.setString(6,null);
            cstmt.registerOutParameter(7,Types.DOUBLE);
            
            Log(" = voy a ejecutar  GUARDAR_SALDO_CLIENTE = ");
            cstmt.executeUpdate();
            retval = cstmt.getString(7);
            Log(" = TODO FINITO = ");

        } catch (SQLException e) {
            Log("ActualizarSaldo", e);
        } catch (Exception e) {
            Log("ActualizarSaldo", e);
        } finally {
            cleanup(con, null);
        }
        return retval;
    }

    private Double ObtenerSaldo(String dniRucSolicitante) {
        String idCliente = obtenerIdClienteEnSaldo(dniRucSolicitante);
        Double retval = 0.0;
        if (idCliente == null || idCliente.length() <= 0) {
            Log(" = EL ID DEL CLIENTE NO SE ENCONTRO =");
            return retval;
        }
        Connection con = null;
        String sql = SenasaSQL.OBTENER_SALDO_PERSONA;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            con = helper.getConnection();
            cstmt = con.prepareCall(sql);
            cstmt.registerOutParameter(1,Types.DOUBLE);
            cstmt.setString(2,idCliente);
            Log(" = voy a ejecutar  OBTENER_SALDO_CLIENTE = ");
            cstmt.executeUpdate();
            retval = cstmt.getDouble(1);
            Log(" = TODO FINITO = ");
        } catch (SQLException e) {
            Log("obtenerSaldoFavorSolicitante", e);
        } catch (Exception e) {
            Log("obtenerSaldoFavorSolicitante", e);
        } finally {
            cleanup(con, null);
        }
        return retval;
    }
    
    public String AbonarSaldoPapeleta(){
        return null;    
    }

    public String abonarSaldoFavorSolicitantePapeleta(String dniRucSolicitante,String papeletaDepositoID,
                                               Double excedente) {
        return ActualizarSaldoPapeleta(dniRucSolicitante,papeletaDepositoID,excedente);
    }
    
    public String abonarSaldoFavorSolicitanteNotaAbono(String dniRucSolicitante,String notaabono,
                                               Double excedente) {
        return ActualizarSaldoNotaAbono(dniRucSolicitante,
                               notaabono, excedente);
    }

    

    private String obtenerIdClienteEnSaldo(String dniRucSolicitante) {

        Connection con = null;
        String sql = SenasaSQL.PERSONA_EXISTE;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String retval = null;

        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, dniRucSolicitante);
            Log(" = voy a ejecutar  CLIENTE_EXISTE = ");
            rs = pst.executeQuery();
            if (rs.getMetaData().getColumnCount() > 0 && rs.next())
                retval = rs.getString(1);
            if (retval == null || retval.length() <= 0) {
                //Buscamos el cliente...
                pst = con.prepareStatement(SenasaSQL.OBTENER_ID_PERSONA);
                pst.setString(1, dniRucSolicitante);
                Log(" = voy a ejecutar  OBTENER_ID_CLIENTE = ");
                rs = pst.executeQuery();
                if (rs.getMetaData().getColumnCount() > 0 && rs.next()) {
                    retval = rs.getString(1);
                    //con ese id lo ingresamos a la tabla de saldos..
                    pst = con.prepareStatement(SenasaSQL.GUARDAR_SALDO_PERSONA);
                    pst.setString(1, retval);
                    pst.setDouble(2, 0.0);
                    pst.setDouble(3, 0.0);
                    Log(" = voy a ejecutar  GUARDAR_SALDO_CLIENTE = ");
                    pst.execute();
                }
            }
            Log(" = TODO FINITO = ");
        } catch (SQLException e) {
            Log("getIdClienteEnSaldo", e);
        } catch (Exception e) {
            Log("getIdClienteEnSaldo", e);
        } finally {
            cleanup(con, null);
        }
        return retval;

    }

  private String obtenerIdSolicitante(String dniRucSolicitante) {

      Connection con = null;
      PreparedStatement pst = null;
      ResultSet rs = null;
      String retval = "";

      try {
              con = helper.getConnection();
              pst = con.prepareStatement(SenasaSQL.OBTENER_ID_PERSONA);
              pst.setString(1, dniRucSolicitante);
              Log(" = voy a ejecutar  OBTENER_ID_CLIENTE = ");
              rs = pst.executeQuery();
              if (rs.next()) {
                  retval = rs.getString(1);
                  
          }
          Log(" = TODO FINITO = ");
      } catch (SQLException e) {
          Log("obtenerIdSolicitante", e);
      } catch (Exception e) {
          Log("obtenerIdSolicitante", e);
      } finally {
            cleanup(con, null);
      }
      return retval;

  }
    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("SaldoClienteDAO - " + s, p2);
    }
    
    public String cargarSaldo(String dniRucSolicitante,
                                  Double montoUtilizado) {
      
        String idCliente = obtenerIdClienteEnSaldo(dniRucSolicitante);
        //String idCliente = obtenerIdSolicitante(dniRucSolicitante);
        
        String retval = null;
        if (idCliente == null || idCliente.length() <= 0) {
            Log(" = EL ID DEL CLIENTE NO SE ENCONTRO =");
            return null;
        }
        //SIGA01.TES_PAGOS_INGRESO.crear_nota_abono_de_papeleta(?,?,?,?);
        Connection con = null;
        String sql = SenasaSQL.CARGAR_SALDO;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            con = helper.getConnection();
            cstmt = con.prepareCall(sql);
            cstmt.setString(1,idCliente);
            cstmt.setDouble(2,montoUtilizado);
            cstmt.registerOutParameter(3,Types.VARCHAR);
            //cstmt.executeUpdate();
            cstmt.execute();
            
          retval = cstmt.getString(3);
          Log(" = TODO FINITO = ");
            
        } catch (SQLException e) {
            Log("cargarSaldo", e);
        } catch (Exception e) {
            Log("cargarSaldo", e);
        } finally {
            cleanup(con, null);
        }
      
        return retval;
        //return null;
        
    }
    
  public static void main(String[] args) 
  {
     SaldoClienteDAO saldocliente = new SaldoClienteDAO();
     String msgsaldo = saldocliente.cargarSaldo("26640964", 80.0);
     
      
  }

}
