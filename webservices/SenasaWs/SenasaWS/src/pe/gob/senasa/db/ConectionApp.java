package pe.gob.senasa.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;


public class ConectionApp {
    protected static Logger logger = Logger.getLogger(Connection.class);
    private static DataSource dsSenasa = null;
    private static DataSource dsSenasaVuce = null;
    private static DataSource dsLugarProd = null;
    private static DataSource dsCertPlantas = null;  
    private static DataSource dsInspeccionVerificacion = null; 
    private static DataSource dsPagos = null; 
    private static DataSource dsPermisoFitoSanitarioExportacion = null; 
    private static DataSource dsPermisoFitosanitarioImportacion = null; 
    private static DataSource dsPermisoZoosanitarioImportacion = null; 
    private static DataSource dsProducto = null; 
    private String test = "1";

    public ConectionApp() {
        super();
    }

    public java.sql.Connection getConnection() throws Exception {
        logger.debug("Obteniendo conexion Senasa- getConnectionFinalBPM");
        if (test.equals("0")) {
            // java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.19.3.171:1521:SIGDES","finalbpm", "senasa");
            //java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.19.3.171:1521:SIGDES","system", "senasa");
            //java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.19.12.51:1521:SIGTES","finalbpm", "senasa");
            java.sql.Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@10.0.0.163:1521:SIG",
                                            "finalbpm", "senasa");
            return conn;
        } else {
            try {
                if (dsSenasa == null) {
                    InitialContext ic = null;
                    ic = new InitialContext();
                    logger.debug("Obteniendo conexion Senasa- senasaDataSourceJNDI");
                    dsSenasa =
                            (javax.sql.DataSource)ic.lookup("java:comp/env/senasaDataSource");
                }
                return dsSenasa.getConnection();
            } catch (NamingException ne) {
                logger.error("Error al buscar datasource : " +
                             ne.getMessage());
                throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource senasaDataSourceJNDI " +
                                    ne);
            } catch (SQLException sqlExp) {
                logger.error("Error al obtener conexion : " +
                             sqlExp.getMessage());
                throw new Exception("Ha ocurrido un error al tratar de obtener una conecci�n desde el datasource senasaDataSourceJNDI " +
                                    sqlExp);
            }
        }
    }
    /* RCF 03/01/2017 */
    public java.sql.Connection getConnLugarProd() throws Exception {
        logger.debug("Obteniendo conexion Senasa- getConnLugarProd");        
            try {
                if (dsLugarProd == null) {
                    InitialContext ic = null;
                    ic = new InitialContext();
                    logger.debug("Obteniendo conexion Senasa- DSwsLugarProd");
                    dsLugarProd =
                            (javax.sql.DataSource)ic.lookup("DSwsLugarProd");
                }
                return dsLugarProd.getConnection();
            } catch (NamingException ne) {
                logger.error("Error al buscar datasource : " +
                             ne.getMessage());
                throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource DSwsLugarProd " +
                                    ne);
            } catch (SQLException sqlExp) {
                logger.error("Error al obtener conexion : " +
                             sqlExp.getMessage());
                throw new Exception("Ha ocurrido un error al tratar de obtener una conecci�n desde el datasource DSwsLugarProd " +
                                    sqlExp);
            }        
    }
    /* RCF 03/01/2017 */
    public java.sql.Connection getConnCertPlanta() throws Exception {
        logger.debug("Obteniendo conexion Senasa- getConnCertPlanta");
        try {
            if (dsCertPlantas == null) {
                InitialContext ic = null;
                ic = new InitialContext();
                logger.debug("Obteniendo conexion Senasa- DSwsCertPlantas");
                dsCertPlantas = (javax.sql.DataSource)ic.lookup("DSwsCertPlantas");
            }
            return dsCertPlantas.getConnection();
        } catch (NamingException ne) {
            logger.error("Error al buscar datasource : " + ne.getMessage());
            throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource DSwsCertPlantas " +
                                ne);
        } catch (SQLException sqlExp) {
            logger.error("Error al obtener conexion : " + sqlExp.getMessage());
            throw new Exception("Ha ocurrido un error al tratar de obtener una conecci�n desde el datasource DSwsCertPlantas " +
                                sqlExp);
        }
    }
    
    /* PCSM 05/01/2017 */
    public java.sql.Connection getConnInspeccionVerificacion() throws Exception {
        logger.debug("Obteniendo conexion Senasa- getConnInspeccionVerificacion");        
            try {
                if (dsInspeccionVerificacion == null) {
                    InitialContext ic = null;
                    ic = new InitialContext();
                    logger.debug("Obteniendo conexion Senasa- DSwsInspecVerif");
                    dsInspeccionVerificacion =
                            (javax.sql.DataSource)ic.lookup("DSwsInspecVerif");
                }
                return dsInspeccionVerificacion.getConnection();
            } catch (NamingException ne) {
                logger.error("Error al buscar datasource : " +
                             ne.getMessage());
                throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource DSwsInspecVerif " +
                                    ne);
            } catch (SQLException sqlExp) {
                logger.error("Error al obtener conexion : " +
                             sqlExp.getMessage());
                throw new Exception("Ha ocurrido un error al tratar de obtener una coneccion desde el datasource DSwsInspecVerif " +
                                    sqlExp);
            }        
    }
    
    /* PCSM 05/01/2017 */
    public java.sql.Connection getConnPagos() throws Exception {
        logger.debug("Obteniendo conexion Senasa- getConnPagos");        
            try {
                if (dsPagos == null) {
                    InitialContext ic = null;
                    ic = new InitialContext();
                    logger.debug("Obteniendo conexion Senasa- DSwsPagos");
                    dsPagos =
                            (javax.sql.DataSource)ic.lookup("DSwsPagos");
                }
                return dsPagos.getConnection();
            } catch (NamingException ne) {
                logger.error("Error al buscar datasource : " +
                             ne.getMessage());
                throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource DSwsPagos " +
                                    ne);
            } catch (SQLException sqlExp) {
                logger.error("Error al obtener conexion : " +
                             sqlExp.getMessage());
                throw new Exception("Ha ocurrido un error al tratar de obtener una coneccion desde el datasource DSwsPagos " +
                                    sqlExp);
            }        
    }
    
    /* PCSM 05/01/2017 */
    public java.sql.Connection getConnPermisoFitoSanitarioExportacion() throws Exception {
        logger.debug("Obteniendo conexion Senasa- getConnPermisoFitoSanitarioExportacion");        
            try {
                if (dsPermisoFitoSanitarioExportacion == null) {
                    InitialContext ic = null;
                    ic = new InitialContext();
                    logger.debug("Obteniendo conexion Senasa- DSwsPermFitoExpo");
                    dsPermisoFitoSanitarioExportacion =
                            (javax.sql.DataSource)ic.lookup("DSwsPermFitoExpo");
                }
                return dsPermisoFitoSanitarioExportacion.getConnection();
            } catch (NamingException ne) {
                logger.error("Error al buscar datasource : " +
                             ne.getMessage());
                throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource DSwsPermFitoExpo " +
                                    ne);
            } catch (SQLException sqlExp) {
                logger.error("Error al obtener conexion : " +
                             sqlExp.getMessage());
                throw new Exception("Ha ocurrido un error al tratar de obtener una coneccion desde el datasource DSwsPermFitoExpo " +
                                    sqlExp);
            }        
    }
    
    /* PCSM 05/01/2017 */
    public java.sql.Connection getConnPermisoFitosanitarioImportacion() throws Exception {
        logger.debug("Obteniendo conexion Senasa- getConnPermisoFitosanitarioImportacion");        
            try {
                if (dsPermisoFitosanitarioImportacion == null) {
                    InitialContext ic = null;
                    ic = new InitialContext();
                    logger.debug("Obteniendo conexion Senasa- DSwsPermFitoImpo");
                    dsPermisoFitosanitarioImportacion =
                            (javax.sql.DataSource)ic.lookup("DSwsPermFitoImpo");
                }
                return dsPermisoFitosanitarioImportacion.getConnection();
            } catch (NamingException ne) {
                logger.error("Error al buscar datasource : " +
                             ne.getMessage());
                throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource DSwsPermFitoImpo " +
                                    ne);
            } catch (SQLException sqlExp) {
                logger.error("Error al obtener conexion : " +
                             sqlExp.getMessage());
                throw new Exception("Ha ocurrido un error al tratar de obtener una coneccion desde el datasource DSwsPermFitoImpo " +
                                    sqlExp);
            }        
    }
    
    /* PCSM 05/01/2017 */
    public java.sql.Connection getConnPermisoZoosanitarioImportacion() throws Exception {
        logger.debug("Obteniendo conexion Senasa- getConnPermisoZoosanitarioImportacion");        
            try {
                if (dsPermisoZoosanitarioImportacion == null) {
                    InitialContext ic = null;
                    ic = new InitialContext();
                    logger.debug("Obteniendo conexion Senasa- DSwsPermZooImpo");
                    dsPermisoZoosanitarioImportacion =
                            (javax.sql.DataSource)ic.lookup("DSwsPermZooImpo");
                }
                return dsPermisoZoosanitarioImportacion.getConnection();
            } catch (NamingException ne) {
                logger.error("Error al buscar datasource : " +
                             ne.getMessage());
                throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource DSwsPermZooImpo " +
                                    ne);
            } catch (SQLException sqlExp) {
                logger.error("Error al obtener conexion : " +
                             sqlExp.getMessage());
                throw new Exception("Ha ocurrido un error al tratar de obtener una coneccion desde el datasource DSwsPermZooImpo " +
                                    sqlExp);
            }        
    }
    
  /* PCSM 05/01/2017 */
  public java.sql.Connection getConnProducto() throws Exception {
      logger.debug("Obteniendo conexion Senasa- getConnProducto");        
          try {
              if (dsProducto == null) {
                  InitialContext ic = null;
                  ic = new InitialContext();
                  logger.debug("Obteniendo conexion Senasa- DSwsProducto");
                  dsProducto =
                          (javax.sql.DataSource)ic.lookup("DSwsProducto");
              }
              return dsProducto.getConnection();
          } catch (NamingException ne) {
              logger.error("Error al buscar datasource : " +
                           ne.getMessage());
              throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource DSwsProducto " +
                                  ne);
          } catch (SQLException sqlExp) {
              logger.error("Error al obtener conexion : " +
                           sqlExp.getMessage());
              throw new Exception("Ha ocurrido un error al tratar de obtener una coneccion desde el datasource DSwsProducto " +
                                  sqlExp);
          }        
  }

    public java.sql.Connection getConnectionVuce() throws Exception {
        logger.debug("Obteniendo conexion Senasa- getConnectionVuce");
        if (test.equals("0")) {
            //java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.19.3.171:1521:SIGDES","finalbpm", "senasa");
            java.sql.Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@10.0.0.186:1521:SIGTES",
                                            "vuce", "vuce");
            //java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.19.3.171:1521:SIGDES","system", "senasa");
            return conn;
        } else {
            try {
                if (dsSenasaVuce == null) {
                    InitialContext ic = null;
                    ic = new InitialContext();
                    logger.debug("Obteniendo conexion Senasa- dsVUCE");
                    //dsSenasaVuce = (javax.sql.DataSource)ic.lookup("java:comp/env/dsVUCE");
                    dsSenasaVuce =
                            (javax.sql.DataSource)ic.lookup("jdbc.vuce");
                }
                return dsSenasaVuce.getConnection();
            } catch (NamingException ne) {
                logger.error("Error al buscar datasource : " +
                             ne.getMessage());
                throw new Exception("Ha ocurrido un problema tratando de ubicar el datasource dsVUCE " +
                                    ne);
            } catch (SQLException sqlExp) {
                logger.error("Error al obtener conexion : " +
                             sqlExp.getMessage());
                throw new Exception("Ha ocurrido un error al tratar de obtener una conecci�n desde el datasource dsVUCE " +
                                    sqlExp);
            }
        }
    }

    
}
