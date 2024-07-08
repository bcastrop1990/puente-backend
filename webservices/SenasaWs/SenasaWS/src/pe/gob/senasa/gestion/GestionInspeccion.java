package pe.gob.senasa.gestion;

import java.io.File;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRProperties;
import net.sf.jasperreports.engine.util.SimpleFileResolver;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.Propiedad;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_PortType;
import pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_ServiceLocator;


public class GestionInspeccion {
    protected static Logger logger = Logger.getLogger(GestionInspeccion.class);    
    //private ConectionApp cnApp = null;
    private DBHelper helper;
    GestionDocumentoWS_ServiceLocator serviceLocator;
    GestionDocumentoWS_PortType port;
    public GestionInspeccion() {
        helper = new DBHelper(SenasaSQL.dsInspeccion);
        serviceLocator =
            new GestionDocumentoWS_ServiceLocator(); 
    }
    
    public String generarInformeInspeccionPreliminar(String txId, String tipo, 
                                                     String codigoExpediente, String titulo, String ucmid) {
        Connection con = null;
        try {
            con = helper.getConnection();
            String locationRep = this.getClass().getResource("/reports/formato_iiv_impo_01.jasper").toString();
            String locationImg = locationRep.substring(0, locationRep.lastIndexOf("/") + 1);
            
            ArrayList<Propiedad> lista = new ArrayList<Propiedad>();
            //System.out.println(txId + ": Gestión Inspección: Generando IIV Preliminar: " + tipo + " / " + codigoExpediente);
            logger.info(txId + ": Gestión Inspección: Generando RIV Preliminar: " + tipo + " / " + codigoExpediente);
            String plantilla = "";
            if (tipo.startsWith("IMPO")) {
                plantilla = "/reports/formato_iiv_impo_01.jasper";
                if (tipo.equals("IMPO_FITO")) {
                    lista.add(new Propiedad("dDocType","DORI"));
                    lista.add(new Propiedad("xSubTipo","IIVI"));
                    lista.add(new Propiedad("xProfileTrigger","TUPA-DORI"));
                } else if (tipo.equals("IMPO_ZOO")) {
                    lista.add(new Propiedad("dDocType","DORI"));
                    lista.add(new Propiedad("xSubTipo","IIVZ"));
                    lista.add(new Propiedad("xProfileTrigger","TUPA-DORI"));
                } else if (tipo.equals("IMPO_IA")) {
                    lista.add(new Propiedad("dDocType","OTRS"));
                    lista.add(new Propiedad("xSubTipo","DGEN"));
                    lista.add(new Propiedad("xProfileTrigger","TUPA-OTRS"));
                    
                } else if (tipo.equals("IMPO_IP")) {
                    lista.add(new Propiedad("dDocType","OTRS"));
                    lista.add(new Propiedad("xSubTipo","DGEN"));
                    lista.add(new Propiedad("xProfileTrigger","TUPA-OTRS"));
                }
                lista.add(new Propiedad("dDocTitle",titulo));
            }
            else  if (tipo.startsWith("EXPO")) {
                lista.add(new Propiedad("dDocType","DORE"));
                if (tipo.equals("EXPO_FITO")) {
                    plantilla = "/reports/formato_iiv_expo_fito_01.jasper";
                    lista.add(new Propiedad("xSubTipo","ICFI"));                    
                }
                else if (tipo.equals("EXPO_ZOO")) {
                    plantilla = "/reports/formato_iiv_expo_zoo_01.jasper";
                    lista.add(new Propiedad("xSubTipo","ICZO"));
                }
                lista.add(new Propiedad("xProfileTrigger","TUPA-DORE"));
                lista.add(new Propiedad("dDocTitle", titulo));
                lista.add(new Propiedad("xConfidencial", "NO"));
            }
            
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("PCODEXPEDIENTE", codigoExpediente);
            JRProperties.setProperty(JRQueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX + "plsql",
                                     "com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
            logger.info(txId + ": Gestión Inspección: Generando RIV Preliminar: " + plantilla);
            logger.info(txId + ": Gestión Inspección: REPORT_FILE_RESOLVER: " + locationImg);
            //System.out.println();
            //System.out.println();
            params.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(new File(locationImg)));
            params.put("PATH_REPORT", locationImg);
            params.put("SUBREPORT_DIR", locationImg);
            
            InputStream jasperIS = this.getClass().getResourceAsStream(plantilla);
            JasperPrint print = JasperFillManager.fillReport(jasperIS, params, con);
            logger.info(txId + ": Gestión Inspección: Generando RIV Preliminar");
            //System.out.println();
            byte[] reporte;
            reporte = JasperExportManager.exportReportToPdf(print);
            String dDocName="";
            logger.info(txId + ": Gestión Inspección: RIV Preliminar generado en " + reporte.length  + " bytes");
            //System.out.println();
            Documento documento = new Documento();
            lista.add(new Propiedad("xNumeroExpediente",codigoExpediente));
            documento.setMetadatos(lista);
            String nombreBase = "RIV_" + codigoExpediente + "_preliminar.pdf";
            logger.info(txId + ": Gestión Inspección: RIV Preliminar pendiente de carga UCM. " + nombreBase);
            pe.gob.senasa.ws.gestiondocumento.Propiedad[] prop = null;           
            if(documento.getMetadatos() != null && documento.getMetadatos().size() > 0){
                prop = new pe.gob.senasa.ws.gestiondocumento.Propiedad[documento.getMetadatos().size()];
                for(int i= 0; i < documento.getMetadatos().size(); i++){
                    Propiedad propiedad = documento.getMetadatos().get(i);
                    prop[i] = new pe.gob.senasa.ws.gestiondocumento.Propiedad(propiedad.getXPropiedad(), propiedad.getXValor());    
                    
                }
            }            
            //dDocName = ucmClient.ingresarDocumento(txId, reporte, documento, nombreBase, ucmid );
            port = serviceLocator.getGestionDocumentoWSPort();
            dDocName = port.registrarDocumento(ucmid, null, null, null, null, null, nombreBase, reporte, prop);
            logger.info(txId + ": Gestión Inspección: RIV Preliminar generado. UCM ID = " + dDocName);
            //System.out.println();            
            
            return dDocName;
        } catch (JRException e) {
            e.printStackTrace();
           logger.info(txId + "Generación de RIV JRException" + e);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(txId + "Generación de RIV" + e);
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
