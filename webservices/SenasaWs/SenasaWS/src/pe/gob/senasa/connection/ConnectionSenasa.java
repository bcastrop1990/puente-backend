package pe.gob.senasa.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;


public class ConnectionSenasa{
    protected static Logger logger = Logger.getLogger(ConnectionSenasa.class);
    private static ConnectionSenasa singletonObject;
    private static Connection conn;
    private static Connection connAgenteAduana;
    private static Connection connAnalisisUCDSV;
    private static Connection connDirectorio;
    private static Connection connDocumentos;
    private static Connection connExpoZoo;
    private static Connection connFuncionario;
    private static Connection connGeneral;
    private static Connection connGeografia;
    private static Connection connInspeccion;
    private static Connection connInspector;
    private static Connection connPermisoFitosanitarioImportacion;
    private static Connection connPermisoZoosanitarioImportacion;
    private static Connection connProducto;        
    private static Connection connRegistroCPE;
    private static Connection connReqDoc;
    private static Connection connServicioTUPA;
    private static Connection connSolicitante;
    private static Connection connTramDocu;
    private static Connection connTratamiento;
    private static Connection connVerificaCierre;
    
    private static DataSource ds;    
    private static DataSource dsAgenteAduana;
    private static DataSource dsAnalisisUCDSV;
    private static DataSource dsDirectorio;
    private static DataSource dsDocumentos;
    private static DataSource dsExpoZoo;
    private static DataSource dsFuncionario;
    private static DataSource dsGeneral;
    private static DataSource dsGeografia;
    private static DataSource dsInspeccion;
    private static DataSource dsInspector;
    private static DataSource dsPermisoFitosanitarioImportacion;
    private static DataSource dsPermisoZoosanitarioImportacion;
    private static DataSource dsProducto;
    private static DataSource dsRegistroCPE;
    private static DataSource dsReqDoc;
    private static DataSource dsServicioTUPA;
    private static DataSource dsSolicitante;
    private static DataSource dsTramDocu;
    private static DataSource dsTratamiento;
    private static DataSource dsVerificaCierre;
    
    private static int contDS = 0;

    /** A private Constructor prevents any other class from instantiating. */
    private ConnectionSenasa() {
        contDS = 0;
        try {
            InitialContext ctx = new InitialContext();
            ////////ds = (DataSource)ctx.lookup("java:comp/env/senasaDataSource");
            ds = (DataSource)ctx.lookup("senasaDataSourceJNDI");
            conn = ds.getConnection();
            contDS++;
            //Solo para debugs local
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@172.19.3.171:1521:SIGDES","finalbpm", "senasa");
        } catch (SQLException e) {
            e.printStackTrace();  
        } catch (NamingException e) {
            e.printStackTrace();
        }

        /*--------- Instanciando DataSource DSAgenteAduanaWS ----------------*/
        /* RCF 03/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsAgenteAduana = (DataSource)ctx.lookup("DSwsAgenteAduanas");
            connAgenteAduana = dsAgenteAduana.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/

        /*--------- Instanciando DataSource dsAnalisisUCDSV ----------------*/
        /* RCF 03/01/2017 */
        try {
            InitialContext ctx = new InitialContext();
            dsAnalisisUCDSV = (DataSource)ctx.lookup("DSwsAnalisisUCDSV");
            connAnalisisUCDSV = dsAnalisisUCDSV.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
                
        /*--------- Instanciando DataSource DSwsDirectorioWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsDirectorio = (DataSource)ctx.lookup("DSwsDirectorio");
            connDirectorio = dsDirectorio.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsDocumentosWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsDocumentos = (DataSource)ctx.lookup("DSwsDocumentos");
            connDocumentos = dsDocumentos.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsExpoZooWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsExpoZoo = (DataSource)ctx.lookup("DSwsExpoZoo");
            connExpoZoo = dsExpoZoo.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsFuncionarioWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsFuncionario = (DataSource)ctx.lookup("DSwsFuncionario");
            connFuncionario = dsFuncionario.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsGeneralWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsGeneral = (DataSource)ctx.lookup("DSwsGeneral");
            connGeneral = dsGeneral.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsGeografiaWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsGeografia = (DataSource)ctx.lookup("DSwsGeografia");
            connGeografia = dsGeografia.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsInspeccionWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsInspeccion = (DataSource)ctx.lookup("DSwsInspeccion");
            connInspeccion = dsInspeccion.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        

        /*--------- Instanciando DataSource DSwsInspector ----------------*/
        /* PCSM 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsInspector = (DataSource)ctx.lookup("DSwsInspector");
            connInspector = dsInspector.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/

		/*--------- Instanciando DataSource DSwsPermFitoImpo ----------------*/
        /* PCSM 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsPermisoFitosanitarioImportacion = (DataSource)ctx.lookup("DSwsPermFitoImpo");
            connPermisoFitosanitarioImportacion = dsPermisoFitosanitarioImportacion.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsPermZooImpo ----------------*/
        /* PCSM 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsPermisoZoosanitarioImportacion = (DataSource)ctx.lookup("DSwsPermZooImpo");
            connPermisoZoosanitarioImportacion = dsPermisoZoosanitarioImportacion.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsProducto ----------------*/
        /* PCSM 04/01/2017 */
		try {
            InitialContext ctx = new InitialContext();            
            dsProducto = (DataSource)ctx.lookup("DSwsProducto");
            connProducto = dsProducto.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/

		/*--------- Instanciando DataSource DSwsRegistroCPEWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsRegistroCPE = (DataSource)ctx.lookup("DSwsRegistroCPE");
            connRegistroCPE = dsRegistroCPE.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsReqDocWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsReqDoc = (DataSource)ctx.lookup("DSwsReqDoc");
            connReqDoc = dsReqDoc.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsServicioTUPAWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsServicioTUPA = (DataSource)ctx.lookup("DSwsServicioTUPA");
            connServicioTUPA = dsServicioTUPA.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsSolicitanteWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsSolicitante = (DataSource)ctx.lookup("DSwsSolicitante");
            connSolicitante = dsSolicitante.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsTramDocuWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsTramDocu = (DataSource)ctx.lookup("DSwsTramDocu");
            connTramDocu = dsTramDocu.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsTratamientoWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsTratamiento = (DataSource)ctx.lookup("DSwsTratamiento");
            connTratamiento = dsTratamiento.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
        
        /*--------- Instanciando DataSource DSwsVerificaCierreWS ----------------*/
        /* GJECH 04/01/2017 */
        try {
            InitialContext ctx = new InitialContext();            
            dsVerificaCierre = (DataSource)ctx.lookup("DSwsVerificaCierre");
            connVerificaCierre = dsVerificaCierre.getConnection();
            contDS++;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        /*-------------------------------------------------------------------*/
    }

    public static synchronized ConnectionSenasa getSingletonObject() {
        logger.debug("SenasaWS contador de DataSource = " + contDS);
        if (singletonObject == null || contDS < 21) {
            singletonObject = new ConnectionSenasa();
        }
        try {
            if(conn == null || conn.isClosed()){
              conn = ds.getConnection();              
              //Solo para debugs local
              //conn = DriverManager.getConnection("jdbc:oracle:thin:@172.19.3.171:1521:SIGDES","finalbpm", "senasa");
            }
            /*  RCF 03/01/2017  */
            if (connAgenteAduana == null || connAgenteAduana.isClosed()) {                
                connAgenteAduana = dsAgenteAduana.getConnection();                
            }
            if (connAnalisisUCDSV == null || connAnalisisUCDSV.isClosed()) {
                connAnalisisUCDSV = dsAnalisisUCDSV.getConnection();
            }
            /*  GJECH 04/01/2017  */
            if (connDirectorio == null || connDirectorio.isClosed()) {                
                      connDirectorio = dsDirectorio.getConnection();                
                  }
            
            /*  GJECH 04/01/2017  */
            if (connDocumentos == null || connDocumentos.isClosed()) {                
                      connDocumentos = dsDocumentos.getConnection();                
                  }
            
            /*  GJECH 04/01/2017  */
            if (connExpoZoo == null || connExpoZoo.isClosed()) {                
                      connExpoZoo = dsExpoZoo.getConnection();                
                  }
            
            /*  GJECH 04/01/2017  */
            if (connFuncionario == null || connFuncionario.isClosed()) {                
                      connFuncionario = dsFuncionario.getConnection();                
                  }
            
            /*  GJECH 04/01/2017  */
            if (connGeneral == null || connGeneral.isClosed()) {                
                      connGeneral = dsGeneral.getConnection();                
                  }
            
            /*  GJECH 04/01/2017  */
            if (connGeografia == null || connGeografia.isClosed()) {                
                      connGeografia = dsGeografia.getConnection();                
                  }
            
            /*  GJECH 04/01/2017  */
            if (connInspeccion == null || connInspeccion.isClosed()) {                
                      connInspeccion = dsInspeccion.getConnection();                
            }
			/*  PCSM 04/01/2017  */
           if (connInspector == null || connInspector.isClosed()) {
                connInspector = dsInspector.getConnection();
            }
   
            if (connPermisoFitosanitarioImportacion == null || connPermisoFitosanitarioImportacion.isClosed()) {
                connPermisoFitosanitarioImportacion = dsPermisoFitosanitarioImportacion.getConnection();
            }
            if (connPermisoZoosanitarioImportacion == null || connPermisoZoosanitarioImportacion.isClosed()) {
                connPermisoZoosanitarioImportacion = dsPermisoZoosanitarioImportacion.getConnection();
            }
            if (connProducto == null || connProducto.isClosed()) {
                connProducto = dsProducto.getConnection();
			}
            
      /*  GJECH 04/01/2017  */
      if (connRegistroCPE == null || connRegistroCPE.isClosed()) {                
                connRegistroCPE = dsRegistroCPE.getConnection();                
            }
            
      /*  GJECH 04/01/2017  */
      if (connReqDoc == null || connReqDoc.isClosed()) {                
                connReqDoc = dsReqDoc.getConnection();                
            }
            
      /*  GJECH 04/01/2017  */
      if (connServicioTUPA == null || connServicioTUPA.isClosed()) {                
                connServicioTUPA = dsServicioTUPA.getConnection();                
            }
          
      /*  GJECH 04/01/2017  */
      if (connSolicitante == null || connSolicitante.isClosed()) {                
                connSolicitante = dsSolicitante.getConnection();                
            }
          
      /*  GJECH 04/01/2017  */
      if (connTramDocu == null || connTramDocu.isClosed()) {                
                connTramDocu = dsTramDocu.getConnection();                
            }
          
      /*  GJECH 04/01/2017  */
      if (connTratamiento == null || connTratamiento.isClosed()) {                
                connTratamiento = dsTratamiento.getConnection();                
            }
          
      /*  GJECH 04/01/2017  */
      if (connVerificaCierre == null || connVerificaCierre.isClosed()) {                
                connVerificaCierre = dsVerificaCierre.getConnection();                
            }
            
        } catch (SQLException e) {
            logger.fatal("Error - Obteniendo Nueva Conecction",e);
        }
        return singletonObject;
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    /*  RCF 03/01/2017  */
    public Connection getConnAgenteAduana() {
        return connAgenteAduana;
    }

    public Connection getConnAnalisisUCDSV() {
        return connAnalisisUCDSV;
    }
    
    /*  GJECH 04/01/2017  */
    public Connection getConnDirectorio() {
        return connDirectorio;
    }
    
    public Connection getConnDocumentos() {
        return connDocumentos;
    }
    
    public Connection getConnExpoZoo() {
        return connExpoZoo;
    }
    
    public Connection getConnFuncionario() {
        return connFuncionario;
    }
    
    public Connection getConnGeneral() {
        return connGeneral;
    }
    
    public Connection getConnGeografia() {
        return connGeografia;
    }
    
    public Connection getConnInspeccion() {
        return connInspeccion;
    }

	/*  PCSM 04/01/2017  */
   public static Connection getConnInspector() {
        return connInspector;
	}
	public static Connection getConnPermisoFitosanitarioImportacion() {
        return connPermisoFitosanitarioImportacion;
    }

    public static Connection getConnPermisoZoosanitarioImportacion() {
        return connPermisoZoosanitarioImportacion;
    }

    public static Connection getConnProducto() {
        return connProducto;
    }
    
    public Connection getConnRegistroCPE() {
        return connRegistroCPE;
    }
    
    public Connection getConnReqDoc() {
        return connReqDoc;
    }
    
    public Connection getConnServicioTUPA() {
        return connServicioTUPA;
    }
    
    public Connection getConnSolicitante() {
        return connSolicitante;
    }
    
    public Connection getConnTramDocu() {
        return connTramDocu;
    }
    
    public Connection getConnTratamiento() {
        return connTratamiento;
    }
    
    public Connection getConnVerificaCierre() {
        return connVerificaCierre;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    public static Connection getConnectionSimple(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@172.19.3.171:1521:SIGDES","finalbpm", "senasa");
        } catch (SQLException e) {
            e.printStackTrace();
        }    
        return con;
    }
    
    
    /**
     *Coneccion utilizada para validar usuario
     * @param usuario
     * @param pass
     * @return
     */
    public static Connection validarConnetionUsuario(String usuario,String pass,String stringConnection)
    {
      
     Connection connAux = null;
           //String usuario = "parroyo";
          // pass = "P*_BY!J9"+pass+"K0+#9Ñ4J";
             try {
                // Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
             } catch (Exception e) {
                 e.printStackTrace();
             }
             try {
                 connAux = DriverManager.getConnection(stringConnection,usuario,pass);
                 
                 System.out.println(connAux);
             } catch (SQLException sqle) {
                 sqle.printStackTrace();
             }

      return connAux;
      
   }    
  
  
  public static void main(String[] args)
  {
     try {
      //Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@172.19.3.171:1521:sigdes","csalas", "invitado");
         
      Connection con = ConnectionSenasa.validarConnetionUsuario("csalas", "invitado1","jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS =(PROTOCOL = TCP)(HOST = 10.0.0.12)(PORT = 1521))(ADDRESS =(PROTOCOL = TCP)(HOST = 10.0.0.13)(PORT = 1521))(ADDRESS =(PROTOCOL = TCP)(HOST = 10.0.0.22)(PORT = 1521))(LOAD_BALANCE = yes)(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = sig)(FAILOVER_MODE = (TYPE = SELECT)(METHOD = BASIC)(RETRIES = 180)(DELAY = 5))))");
         
         
    //  Connection con = ConnectionSenasa.validarConnetionUsuario("system", "datasig");
           logger.debug("con:"+con);
    } catch (Exception e) {
        e.printStackTrace();
    }    
    
  }
  
    
}
