package pe.gob.senasa.dao.daoImpl;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import pe.gob.senasa.bean.ServicioPago;
import pe.gob.senasa.bean.ServicioPagos;
import pe.gob.senasa.dao.IMensajesDao;
import pe.gob.senasa.db.ConnectionDB;
import pe.gob.senasa.db.UtilSQL;


public class MensajesDao implements IMensajesDao{
  protected static Logger logger = Logger.getLogger(GestionVUCEDao.class);
  ConnectionDB conect = null;
  String strTxId = "";
  
    public MensajesDao() {
        super();
      conect = new ConnectionDB();
    }
   
  
  public Boolean notificarMensaje(String txId,String codExpediente, String tipoNotif,
                                      String texto,Boolean updateDocumento) {
      
      strTxId = "[" + txId + "]";
      logger.info("TxId: " + strTxId);

      logger.info(strTxId + " codExpediente:" + codExpediente +
                  " tipoNotif: " + tipoNotif + " texto: " + texto);

      Boolean resultado = false;
      logger.info(strTxId +
                  " ********Inicio del Método Subsanar VUCE********");
      Connection con = null;
      CallableStatement cs = null;
      String sql = UtilSQL.NOTIF_SUBSANAR;

      logger.info(strTxId + " SP a ejecutar" + sql);
      try {
          con = conect.getConnection();
          cs = con.prepareCall(sql);
          cs.registerOutParameter(1, OracleTypes.VARCHAR);
          cs.setString(2, codExpediente);
          cs.setString(3, tipoNotif);
          cs.setString(4, texto);
          if (updateDocumento!=null && updateDocumento==true){
            cs.setString(5, "S");
          }else{
            cs.setString(5, "N");
          }
          logger.info(strTxId + "Ejecutando SP");
          cs.executeQuery();
          logger.info(strTxId + "Sp ejecutado, dato retirnado por el SP = " +
                      cs.getString(1));
          if (cs.getString(1).equals("1")) {
              resultado = true;
          }
          logger.info(strTxId + "retornando respuesta");
      } catch (SQLException e) {
          logger.error(strTxId + "SQLException : ", e);
      } catch (Exception e) {
          logger.error(strTxId + "Exception : ", e);
      } finally {
          try {
              if (cs != null)
                  cs.close();
              if (con != null)
                  con.close();
          } catch (Exception ex) {
              logger.error(strTxId +
                           " Error al cerrar los recursos usados en la ejecución del SP : ",
                           ex);
          }
      }
      return resultado;
  }
  
  public Boolean notificarMensajePagoSuce(String txId,String codExpediente, String tipoNotif,
                                      String texto,Boolean updateDocumento, ServicioPagos servicioPagos) {
      
      strTxId = "[" + txId + "]";
      logger.info("TxId: " + strTxId);

      logger.info(strTxId + " codExpediente:" + codExpediente +
                  " tipoNotif: " + tipoNotif + " texto: " + texto);

      Boolean resultado = false;
      logger.info(strTxId +
                  " ********Inicio del Método notificarMensajePagoSuce********");
      
      org.apache.xmlbeans.XmlObject resul = null;
      String docBody = "";
      Blob _blob = null;
    
      
        try {
              docBody =  docBody +
                "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n"+
                    "<requerimientoPago  xmlns=\"RequerimientoPago-1.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"RequerimientoPago-1.0 RequerimientoPago-1.0.xsd\" >\n";
              
              for(ServicioPago servicioEntrada: servicioPagos.getListaServicioPago()) 
              {
                   String tasa=""+servicioEntrada.getMontoAPagar();
                   String codMotivo=servicioEntrada.getCodigoServicio();
                   String motivo=servicioEntrada.getNombreServicio();
                        
                   docBody = docBody +
                              "<tasa>"+tasa+"</tasa>\n"+
                              "<codigoMotivo>"+codMotivo+"</codigoMotivo>\n"+
                              "<motivo><![CDATA["+motivo+"]]></motivo>\n";
              }
              docBody =  docBody +  
              "</requerimientoPago>";
              resul = org.apache.xmlbeans.XmlObject.Factory.parse(docBody);
              
               _blob = (Blob)resul;             
              
               
              System.out.println(resul);
            } catch (XmlException e) {
              resul=null;
            }
      
      
      Connection con = null;
      CallableStatement cs = null;
      String sql = UtilSQL.NOTIF_ENVIOPAGOSUCE;

      logger.info(strTxId + " SP a ejecutar" + sql);
      try {
          con = conect.getConnection();
          cs = con.prepareCall(sql);
          cs.registerOutParameter(1, OracleTypes.VARCHAR);
          cs.setString(2, codExpediente);
          cs.setString(3, tipoNotif);
          cs.setString(4, texto);
          if (updateDocumento!=null && updateDocumento==true){
            cs.setString(5, "S");
          }else{
            cs.setString(5, "N");
          }
          cs.setBlob(6, _blob);
        
          logger.info(strTxId + "Ejecutando SP");
          cs.executeQuery();
          logger.info(strTxId + "Sp ejecutado, dato retirnado por el SP = " +
                      cs.getString(1));
          if (cs.getString(1).equals("1")) {
              resultado = true;
          }
          logger.info(strTxId + "retornando respuesta");
      } catch (SQLException e) {
          logger.error(strTxId + "SQLException : ", e);
      } catch (Exception e) {
          logger.error(strTxId + "Exception : ", e);
      } finally {
          try {
              if (cs != null)
                  cs.close();
              if (con != null)
                  con.close();
          } catch (Exception ex) {
              logger.error(strTxId +
                           " Error al cerrar los recursos usados en la ejecución del SP : ",
                           ex);
          }
      }
      return resultado;
  }
  
  public String recepcionResultadoPagoSuce(String txId,String codExpediente) {
      
      strTxId = "[" + txId + "]";
      logger.info("TxId: " + strTxId);

      logger.info(strTxId + " codExpediente:" + codExpediente);

      String resultado = "-1";
      logger.info(strTxId +
                  " ********Inicio del Método recepcionResultadoPagoSuce********");
      Connection con = null;
      CallableStatement cs = null;
      String sql = UtilSQL.NOTIF_RPTAPAGOSUCE;

      logger.info(strTxId + " SP a ejecutar" + sql);
      try {
          con = conect.getConnection();
          cs = con.prepareCall(sql);
          cs.registerOutParameter(1, OracleTypes.VARCHAR);
          cs.setString(2, codExpediente);
          
          logger.info(strTxId + "Ejecutando SP");
          cs.executeQuery();
          logger.info(strTxId + "Sp ejecutado, dato retornado por el SP = " +
                      cs.getString(1));
              resultado = cs.getString(1);
          
          logger.info(strTxId + "retornando respuesta");
      } catch (SQLException e) {
          logger.error(strTxId + "SQLException : ", e);
      } catch (Exception e) {
          logger.error(strTxId + "Exception : ", e);
      } finally {
          try {
              if (cs != null)
                  cs.close();
              if (con != null)
                  con.close();
          } catch (Exception ex) {
              logger.error(strTxId +
                           " Error al cerrar los recursos usados en la ejecución del SP : ",
                           ex);
          }
      }
      return resultado;
  }
  
  public void notificarMensajeReqPagoSuce(String codigoExpediente, String texto, double tasa){
      Connection con = null;
      CallableStatement cs = null;
      String sql = UtilSQL.NOTIF_ENVIOREQPAGOSUCE;      
      logger.info(" SP a ejecutar" + sql);
      try{
          con = conect.getConnection();
          cs = con.prepareCall(sql);          
          cs.setString(1, codigoExpediente);
          cs.setString(2, texto);
          cs.setDouble(3, tasa);
          logger.info(strTxId + "Ejecutando SP");
          cs.execute();                             
      } catch (SQLException e) {
          logger.error("SQLException : ", e);
      } catch (Exception e) {
          logger.error("Exception : ", e);
      } finally {
          try {
              if (cs != null)
                  cs.close();
              if (con != null)
                  con.close();
          } catch (Exception ex) {
              logger.error(" Error al cerrar los recursos usados en la ejecución del SP : ",ex);
          }
      }    
  }

    public void notificarProgramacionInspeccion(String txId,
                                                   String tipodocumento,
                                                   String orden, 
                                                   double tasa,
                                                   String doctiporef,
                                                   String docnumeref,
                                                   String textovalor) {
        
      strTxId = "[" + txId + "]";
      logger.info("TxId: " + strTxId);

      logger.info(strTxId + " Orden:" + orden + " tipodocumento: " + tipodocumento + " tasa: " + tasa +" doctiporef:" + doctiporef + " docnumeref:" + docnumeref + " textovalor:" + textovalor);

      logger.info(strTxId + " ********Inicio del Método notificarProgramacionInspeccion********");
      
      Connection con = null;
      CallableStatement cs = null;
      String sql = UtilSQL.NOTIF_PROGRAMACION_INSPECCION;

      logger.info(strTxId + " SP a ejecutar" + sql);
      try {
          con = conect.getConnection();
          cs = con.prepareCall(sql);
          cs.registerOutParameter(1, OracleTypes.VARCHAR);
          cs.setString(2, tipodocumento);
          cs.setString(3, orden);
          cs.setDouble(4, tasa);
          cs.setString(5, doctiporef);
          cs.setString(6, docnumeref);
          cs.setString(7, textovalor);
        
          logger.info(strTxId + "Ejecutando SP");
          cs.executeQuery();
          logger.info(strTxId + "Sp ejecutado, dato retornado por el SP = " +
                      cs.getString(1));
          logger.info(strTxId + "retornando respuesta");
      } catch (SQLException e) {
          logger.error(strTxId + "SQLException : ", e);
      } catch (Exception e) {
          logger.error(strTxId + "Exception : ", e);
      } finally {
          try {
              if (cs != null)
                  cs.close();
              if (con != null)
                  con.close();
          } catch (Exception ex) {
              logger.error(strTxId +
                           " Error al cerrar los recursos usados en la ejecución del SP : ",
                           ex);
          }
      }
      
        
    }
}
