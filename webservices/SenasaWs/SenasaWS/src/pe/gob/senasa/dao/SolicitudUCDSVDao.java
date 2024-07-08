package pe.gob.senasa.dao;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Map;

import oracle.sql.StructDescriptor;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.DetalleSolicitudUCDSV;
import pe.gob.senasa.bean.ResultadoAnalisisUCDSV;
import pe.gob.senasa.bean.SolicitudAnalisisUCDSV;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.dbtypes.ListaGenerica;
import pe.gob.senasa.dbtypes.MuestraLaboratorio;
import pe.gob.senasa.dbtypes.SolicitudDiagnostico;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.AnalisisInterface;
import pe.gob.senasa.util.Utility;


public class SolicitudUCDSVDao extends BaseDAO implements AnalisisInterface{
    
    protected static Logger logger = Logger.getLogger(SolicitudUCDSVDao.class);
    private DBHelper helper;
    
    public SolicitudUCDSVDao() {
        super();
        helper = new DBHelper(SenasaSQL.dsAnalisisUCDSV);
    }

    public Boolean CrearAnalisis(SolicitudAnalisisUCDSV solicitud) {
        Connection con = null;
        boolean retval = false;
        try{
            con = helper.getConnection(); //RCF 03/01/2017
            con.setAutoCommit(false);
            SolicitudDiagnostico obj = new SolicitudDiagnostico(solicitud.getCabecera());            
            String orden = CrearCabeceraSolUCDSV(con, obj);            
            CrearListaDetallesSolUCDSV(solicitud, con, orden);
            CrearSolicitud(con,orden);  
            con.commit();
            con.setAutoCommit(true);
            //
            Log(" = TODO FINITO = ");
           retval = true;           
        } catch (SQLException e) {
            ManejarException(con, e);
        } catch (Exception e) {
            ManejarException(con, e);
        } finally {
            cleanup(con, null);
        }
        return retval;
    }

    private void CrearListaDetallesSolUCDSV(SolicitudAnalisisUCDSV solicitud,
                                            Connection con,
                                            String orden) throws SQLException {
        CallableStatement cst;
        ArrayList<MuestraLaboratorio> list = new ArrayList<MuestraLaboratorio>();
        for(DetalleSolicitudUCDSV det:solicitud.getDetalles()){
            MuestraLaboratorio aux = new MuestraLaboratorio(det.getTipoMuestra(),
                                                            det.getCantidad(),det.getUnidad(),
                                                            Utility.toSQLDate(det.getFechaRecoleccion()),
                                                            Utility.toSQLDate(det.getFechaRemision()),
                                                            det.getLaboratorio(),det.getProcedencia(),"","");
            list.add(aux);
        }
        Map types = con.getTypeMap();
        ListaGenerica tipoListaMuestras = new ListaGenerica(list);
        tipoListaMuestras.setSqlName(MuestraLaboratorio.SQL_TYPE_ARRAY);
        types.put(tipoListaMuestras.getSqlName(), ListaGenerica.class);

        
        cst = con.prepareCall(SenasaSQL.CREAR_DETALLE_SOLICITUD_UCDSV);
        cst.setObject(1,tipoListaMuestras);
        Log("ORDEN >>>>> ++++++ "+orden);
        cst.setString(2, orden);
        cst.execute();
    }

    private String CrearCabeceraSolUCDSV(Connection con,
                                         SolicitudDiagnostico obj) throws SQLException {
        CallableStatement cst;
        cst = con.prepareCall(SenasaSQL.CREAR_SOLICITUD_UCDSV);
        cst.setObject(1, obj);
        cst.registerOutParameter(2, Types.VARCHAR);
        cst.execute();
        
        String orden = cst.getString(2);
        return orden;
    }
    
    private void CrearSolicitud(Connection con,String orden) throws SQLException {
        CallableStatement cst;
        cst = con.prepareCall(SenasaSQL.GENERAR_SOLICITUD_UCDSV);
        cst.setString(1, orden);
        cst.execute();
    }

    private void ImprimirTipoDB(Connection con,String tipo) throws SQLException {
        StructDescriptor desc =  StructDescriptor.createDescriptor( tipo, con );
        
        

          // get type meta data 
          ResultSetMetaData md = desc.getMetaData (); 

          // get # of attrs of this type 
          int numAttrs = desc.getLength(); 

          // temporary buffers 
          String attr_name; 
          int attr_type; 
          String attr_typeName; 

          //System.out.println ("Attributes of "+type_name+" :"); 
          for (int i=0; i<numAttrs; i++) 
          { 
            attr_name = md.getColumnName (i+1); 
            attr_type = md.getColumnType (i+1); 
            Log (" index"+(i+1)+" name="+attr_name+" type="+attr_type); 

          }
    }      
          
    private void ManejarException(Connection con, Exception e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("SolicitudUCDSVDao", f);
        }
        Log("SolicitudUCDSVDao", e);
    }
    
    
    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("ServicioTUPADAO - " + s, p2);
    }


    public ResultadoAnalisisUCDSV obtenerAnalisis(String orden) {        
        Connection con = null;        
        CallableStatement cst = null;        
        ResultadoAnalisisUCDSV retval = new ResultadoAnalisisUCDSV();
        try{
            con = helper.getConnection();
            cst = con.prepareCall(SenasaSQL.OBTENER_RESULTADO_SOLICITUD_UCDSV);
            cst.setObject(1, orden);
            cst.registerOutParameter(2, Types.CHAR);
            cst.registerOutParameter(3, Types.BLOB);
            cst.execute();
            retval.setResultado(cst.getString(2));
            Blob blob = cst.getBlob(3);
            retval.setPdf(Utility.BlobToByteArray(blob));
        //
            Log(" = TODO FINITO = ");      
        } catch (SQLException e) {
            ManejarException(con, e);
        } catch (Exception e) {
            ManejarException(con, e);
        } finally {
            cleanup(con, cst, null);
        }
        return retval;
    }
}
