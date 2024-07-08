package pe.gob.senasa.gestion;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRProperties;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.Propiedad;
import pe.gob.senasa.bean.Recibo;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_PortType;
import pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_ServiceLocator;


@SuppressWarnings( "deprecation" )
public class GestionRecibo {
    protected static Logger logger = Logger.getLogger(GestionRecibo.class);   
    private DBHelper helper;
    GestionDocumentoWS_ServiceLocator serviceLocator;
    GestionDocumentoWS_PortType port;
    public GestionRecibo() {
        helper = new DBHelper(SenasaSQL.DATA_SOURCE_PAGOS);
        serviceLocator =
            new GestionDocumentoWS_ServiceLocator();        
    }
    
    public String generarRecibo(String txId, Recibo reciboPago) {
        Connection con = null;
        try {
            
            con = helper.getConnection();
            String location = this.getClass().getResource("/reports/reciboPago.jasper").toString();

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("PCODRECIBO", reciboPago.getCodigoRecibo());
            params.put("SUBREPORT_DIR", location.substring(0, location.lastIndexOf("/") + 1));
            //params.put("REPORT_CONNECTION", null);
            JRProperties.setProperty(JRQueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX + "plsql",
                                     "com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
            System.out.println("Luego del SetProperty");
            System.out.println(location.substring(0, location.lastIndexOf("/") + 1));
            System.out.println(location);
            InputStream jasperIS = this.getClass().getResourceAsStream("/reports/reciboPago.jasper");
            JasperPrint print = JasperFillManager.fillReport(jasperIS, params, con);
            System.out.println("Luego del FillReport");
            System.out.println("Exportacion en PDF - jasper");
            byte[] reporte;
            reporte = JasperExportManager.exportReportToPdf(print);
            
            Documento documento = new Documento();
            documento.setMetadatos(reciboPago.getMetadatos());
            String nombreBase = reciboPago.getCodigoRecibo() + ".pdf";           
            
            pe.gob.senasa.ws.gestiondocumento.Propiedad[] prop = new pe.gob.senasa.ws.gestiondocumento.Propiedad[7];
            
            if(reciboPago.getMetadatos() != null && reciboPago.getMetadatos().size() > 0){
                for(int i= 0; i < reciboPago.getMetadatos().size(); i++){
                    Propiedad propiedad = reciboPago.getMetadatos().get(i);
                    prop[i] = new pe.gob.senasa.ws.gestiondocumento.Propiedad(propiedad.getXPropiedad(), propiedad.getXValor());    
                    
                }
            }            
            
            port = serviceLocator.getGestionDocumentoWSPort();
            String dDocName = port.registrarDocumento(null, null, null, "SPGO", null, null, nombreBase, reporte, prop);
                        
            //String dDocName = ucmClient.ingresarDocumento(txId, reporte, documento, nombreBase );
            logger.info(txId + "dDocName: " + dDocName);
            logger.info(txId + "------------------Fin de  crearDocumento----------------");
            return dDocName;
        } catch (JRException e) {
            e.printStackTrace();
          logger.info(txId + "Generación del Recibo JRException" + e);            
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(txId + "Generación del Recibo" + e);
        }finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando cerrando la conexión con la base de datos:" +
                             sqe.getMessage());
            }
        }
        return "";
    }

}
