package pe.gob.senasa.dao.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Persona;
import pe.gob.senasa.dao.IPersonaDao;
import pe.gob.senasa.db.ConnectionDB;
import pe.gob.senasa.db.UtilSQL;


public class PersonaDao implements IPersonaDao{
  protected static Logger logger = Logger.getLogger(GestionVUCEDao.class);
  ConnectionDB conect = null;
  String strTxId = "";
  
    public PersonaDao() {
        super();
        conect = new ConnectionDB();
    }
  public Persona obtenerDatosPersona(String txId,String personaId) {
      strTxId = "[" + txId + "]";
      logger.info("TxId: " + strTxId);

      logger.info(strTxId + " personaId:" + personaId);

      logger.info(strTxId +
                  " ********Inicio del Método obtenerDatosPersona ********");
      Connection con = null;
      CallableStatement cs = null;
      ResultSet rs = null;
      String sql = UtilSQL.DATOS_SOLICITANTE;
      Persona retval = new Persona();
      logger.info(strTxId + " SP a ejecutar" + sql);
      try {
          con = conect.getConnectionBPM();
          cs = con.prepareCall(sql);
          cs.setString(1, personaId);
          cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

          logger.info(strTxId + "Ejecutando SP");
          cs.executeQuery();
          rs = (ResultSet)cs.getObject(2);
          logger.info(strTxId + "Listando datos");
          while (rs.next()) {
              retval.setPersonaId(rs.getString("Persona_Id"));
              retval.setNombreRazonSocial(rs.getString("Nombre_Razon_Social"));
              retval.setPersonaTipo(rs.getString("Persona_Tipo"));
              retval.setDocumentoTipo(rs.getString("Documento_Tipo"));
              retval.setDocumentoNumero(rs.getString("Documento_Numero"));
              retval.setDireccion(rs.getString("Direccion"));
              retval.setDepartamentoId(rs.getString("Departamento_Id"));
              retval.setNombDptoDpt(rs.getString("Nomb_Dpto_Dpt"));
              retval.setProvinciaId(rs.getString("Provincia_Id"));
              retval.setNombProvTpr(rs.getString("Nomb_Prov_Tpr"));
              retval.setDistritoId(rs.getString("Distrito_Id"));
              retval.setNombDistTdi(rs.getString("Nomb_Dist_Tdi"));
              retval.setTelefono(rs.getString("Telefono"));
              retval.setEmail(rs.getString("Correo_Electronico"));

          }
          logger.info(strTxId + "Lista completada");

      } catch (SQLException e) {
          logger.error(strTxId + "SQLException : ", e);
      } catch (Exception e) {
          logger.error(strTxId + "Exception : ", e);
      } finally {
          try {
              if (rs != null && !rs.isClosed())
                  rs.close();
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
      return retval;

  }
}
