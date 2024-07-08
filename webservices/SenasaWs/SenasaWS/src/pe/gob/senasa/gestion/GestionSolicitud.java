package pe.gob.senasa.gestion;

import java.io.FileOutputStream;
import java.io.InputStream;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRProperties;

import org.apache.log4j.Logger;

import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.tupa.cis.UCMClient;


@SuppressWarnings( "deprecation" )
public class GestionSolicitud {
    protected static Logger logger = Logger.getLogger(GestionSolicitud.class);
    private UCMClient ucmClient = null;
    //private ConectionApp cnApp = null;
    DBHelper helper;

    public GestionSolicitud() {
        ucmClient = new UCMClient();
        //cnApp = new ConectionApp();
        helper = new DBHelper(SenasaSQL.dsGeneral);
    }

    public void generarSolicitudVUCE(String txId, String numeroOrden) {
        Connection con = null;
        try {
            logger.info("HOLA MUNDO, generando el reporte SNS022");

            String ruta = this.getClass().getResource("/reports/estilosInforme.jrtx").toString();
            String rutaAbsoluta = ruta.substring(0, ruta.lastIndexOf("/") + 1);
            String reportName = "formato_SNS022";

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("ORDENVUCE", numeroOrden);
            params.put("SUBREPORT_DIR", rutaAbsoluta);
            JRProperties.setProperty(JRQueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX + "plsql","com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
            
            InputStream jasperIS = this.getClass().getResourceAsStream("/reports/"+reportName+".jasper");
            JasperPrint print = JasperFillManager.fillReport(jasperIS, params, con);
            
            byte[] reporte;
            reporte = JasperExportManager.exportReportToPdf(print);
            System.out.println("Genero reporte pdf");
            
            // para ver como genero el reporte, debe quitarse
            Random filename = new Random();
            FileOutputStream fos = new FileOutputStream("D:\\SIG\\"+filename+".pdf");
            fos.write(reporte);
            fos.close();
            
          } catch (JRException e) {
              e.printStackTrace();
          } catch (Exception e) {
              e.printStackTrace();
          }finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando cerrando la conexión con la base de datos:" +
                             sqe.getMessage());
            }
        }

    }

}
