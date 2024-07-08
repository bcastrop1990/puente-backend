package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.InpeccionVerificacion;
import pe.gob.senasa.bean.PaisOrigenIIV;
import pe.gob.senasa.bean.ProductoIIV;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.InspecionVerifInterface;


public class InspecionVerifDao extends BaseDAO implements InspecionVerifInterface {
  protected static Logger logger = Logger.getLogger(InspeccionDAO.class);
  //private ConectionApp cnApp=null;
      private DBHelper helper;  //PCSM 06/01/2017
  
  
    public InspecionVerifDao() {
        super();
      //cnApp= new ConectionApp();
      helper = new DBHelper(SenasaSQL.DATA_SOURCE_INSPEC_VERIF);  //PCSM 06/01/2017
    }
    public String insertarIVV(InpeccionVerificacion inpeccionVerificacion){
      logger.info("****************** Inicio del método insertarIVV ******************");
      Connection cn= null;
      CallableStatement cs=null;
      String sql="{call Pckg_IIV.Sp_Insertar_IIV(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
      String sqlPrd="{call Pckg_IIV.Sp_Insertar_IIV_Producto(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
      String sqlPais="{call Pckg_IIV.Sp_Insertar_IIV_Origen(?,?,?,?)}";
      String codigoIv;
      StringBuilder strLog = new StringBuilder();
      strLog.append("IdCentroTramite=>"+inpeccionVerificacion.getIdCentroTramite()+"\n");
      strLog.append("IdAgencia=>"+inpeccionVerificacion.getIdAgencia()+"\n");
      strLog.append("IdLineaTransporte=>"+inpeccionVerificacion.getIdLineaTransporte()+"\n");
      strLog.append("NumPermiso=>"+inpeccionVerificacion.getNumPermiso()+"\n");
      strLog.append("Expediente=>"+inpeccionVerificacion.getExpediente()+"\n");
      strLog.append("IdPaisProcedencia=>"+inpeccionVerificacion.getIdPaisProcedencia()+"\n");
      strLog.append("IdLugarInspeccion=>"+inpeccionVerificacion.getIdLugarInspeccion()+"\n");
      strLog.append("getIdServicio=>"+inpeccionVerificacion.getIdServicio()+"\n");
      strLog.append("getIdPersona=>"+inpeccionVerificacion.getIdPersona()+"\n");
      logger.info("insertarIVV - datos IIV==>"+ strLog.toString());    
      try{
          //cn= cnApp.getConnection();            
          //cn= cnApp.getConnInspeccionVerificacion();  //PCSM 05/01/2017
          cn = helper.getConnection();
          cn.setAutoCommit(false);
          logger.info("insertarIVV - grabar cabecera IIV");
          cs=cn.prepareCall(sql);
          cs.registerOutParameter(1, OracleTypes.VARCHAR);
          cs.setString(2, inpeccionVerificacion.getIdCentroTramite());
          cs.setString(3, inpeccionVerificacion.getIdAgencia());
          cs.setString(4, inpeccionVerificacion.getIdLineaTransporte());
          cs.setString(5, inpeccionVerificacion.getNumPermiso());
          cs.setString(6, inpeccionVerificacion.getObservacion());
          cs.setString(7, inpeccionVerificacion.getExpediente());
          cs.setString(8, inpeccionVerificacion.getIdPaisProcedencia());
          cs.setString(9, inpeccionVerificacion.getIdLugarInspeccion());
          cs.setString(10, inpeccionVerificacion.getIdServicio());
          
          Date dateFR= null;
          Date dateFInsp=null;
          Timestamp dateHInsp= null;
          if (inpeccionVerificacion.getFechaReg()!=null){
            dateFR= new Date(inpeccionVerificacion.getFechaReg().getTime());              
          }else{
            java.util.Date dateActual = new java.util.Date();
            dateFR= new Date(dateActual.getTime());              
          }
          
          if (inpeccionVerificacion.getFechaInspeccion()!=null){
            dateFInsp= new Date(inpeccionVerificacion.getFechaInspeccion().getTime());
          }
          if (inpeccionVerificacion.getHoraInspeccion()!=null){
           dateHInsp= new Timestamp(inpeccionVerificacion.getHoraInspeccion().getTime());
          }
          
          cs.setDate(11, dateFR);
          cs.setDate(12, dateFInsp);
          cs.setTimestamp(13, dateHInsp);
          cs.setString(14, inpeccionVerificacion.getEstablecImpoAnimal());
          cs.setString(15, inpeccionVerificacion.getIdPersona());
          cs.execute();
          codigoIv=cs.getString(1);
          logger.info("insertarIVV - grabar productos");          
          int i=1;
          if (inpeccionVerificacion.getListaProductos()!=null){
            for(ProductoIIV prd : inpeccionVerificacion.getListaProductos()){
              cs=null;
              cs=cn.prepareCall(sqlPrd);
              logger.info("insertarIVV - idproducto==>"+prd.getIdProducto() + " usoDestino==>"+prd.getUsoDestino()+ " idTipoEnvase==>"+prd.getIdTipoEnvase() + " idUndMedida==>"+prd.getIdUndMedida());  
              cs.setString(1, codigoIv);
              cs.setInt(2, i);            
              cs.setString(3,prd.getIdProducto());//
              cs.setString(4, prd.getUsoDestino());
              cs.setDouble(5, prd.getPeso());
              cs.setString(6, prd.getIdTipoEnvase());
              cs.setString(7, prd.getIdUndMedida());
              cs.setInt(8, prd.getCif());
              cs.setInt(9, prd.getFob());
              cs.setDouble(10, prd.getPesoAprob());
              cs.setDouble(11, prd.getPesoRechazado());
              cs.setInt(12, prd.getCantEnvase());  
              cs.setInt(13, prd.getCantPlanta());
              cs.setString(14, inpeccionVerificacion.getIdCentroTramite());
              cs.execute();
              i++;
            }
          }else{
            logger.info("insertarIVV - productos nulos");
          }
          
          logger.info("insertarIVV - grabar paises origen");
          if (inpeccionVerificacion.getListaPaisesOrg()==null){
            logger.info("insertarIVV - paises origen nulos");
          }else{    
          
            i=1;
            for(PaisOrigenIIV pais : inpeccionVerificacion.getListaPaisesOrg()){
              cs=null;
              cs=cn.prepareCall(sqlPais);  
              logger.info("insertarIVV - idPaisOrigen==>"+pais.getIdPais() + " idPaisProduccion==>"+pais.getIdLugarProduccion());
              cs.setString(1, codigoIv);
              cs.setInt(2, i);            
              cs.setString(3, pais.getIdPais());
              cs.setString(4, pais.getIdLugarProduccion());          
              cs.execute();
              i++;
            }
          }
          cn.commit();
        logger.info("insertarIVV - Los registros se grabaron correctamente codigoIv==>"+codigoIv );
      }catch(SQLException sqlEx){
        codigoIv="0";
        logger.debug("insertarIVV Error al insertar IIV SQLException: " + sqlEx.getMessage());
        try {
            cn.rollback();
        } catch (SQLException e) {
          logger.debug("insertarIVV Error al insertar IIV SQLException: " + sqlEx.getMessage());
        }            
      }catch(Exception ex){   
        codigoIv="0";
        logger.debug("insertarIVV Error al insertar IIV Exception: " + ex.getMessage());
        try {
            cn.rollback();
        } catch (SQLException e) {
          logger.debug("insertarIVV Error al insertar IIV SQLException: " + ex.getMessage());
        }
        
      } finally {
            //cleanup(cn, cs,null);    
            //PCSM 06/01/2017
            try {
                helper.cleanup(cn, cs, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
      }
      
      return codigoIv;
    }
    
  
  public static void main(String[] args) {
      InspecionVerifDao class1 = new InspecionVerifDao();
      InpeccionVerificacion inpeccionVerificacion= new InpeccionVerificacion();
      inpeccionVerificacion.setIdCentroTramite("06");
      inpeccionVerificacion.setIdAgencia("1041964");
      inpeccionVerificacion.setIdLineaTransporte("1041913");
      inpeccionVerificacion.setNumPermiso("123456");
      inpeccionVerificacion.setExpediente("119900001918");
      inpeccionVerificacion.setIdPaisProcedencia("4028");
      inpeccionVerificacion.setIdLugarInspeccion("211");
      inpeccionVerificacion.setIdServicio("003");
      java.util.Date d1= new java.util.Date();
      java.util.Date d2= new java.util.Date();
      System.out.println(d1);
      System.out.println(d2);
      inpeccionVerificacion.setFechaReg(d1);
      inpeccionVerificacion.setFechaInspeccion(d1);
      inpeccionVerificacion.setHoraInspeccion(d2);
      inpeccionVerificacion.setIdPersona("01874009");
      
      
      List<ProductoIIV> listaPrds = new ArrayList<ProductoIIV>();
      ProductoIIV prd=null;
      prd=new ProductoIIV ();
      prd.setCantEnvase(12);
      prd.setCantPlanta(0);
      prd.setCif(0);
      prd.setFob(0);
      prd.setIdProducto("04938");
      prd.setIdTipoEnvase("16");
      prd.setIdUndMedida("149");
      prd.setPeso(12.0);
      prd.setPesoAprob(0.0);
      prd.setPesoRechazado(0.0);
      prd.setUsoDestino("68");
      listaPrds.add(prd);
      
      prd=new ProductoIIV ();
      prd.setCantEnvase(15);
      prd.setCantPlanta(0);
      prd.setCif(0);
      prd.setFob(0);
      prd.setIdProducto("04940");
      prd.setIdTipoEnvase("17");
      prd.setIdUndMedida("153");
      prd.setPeso(12.0);
      prd.setPesoAprob(0.0);
      prd.setPesoRechazado(0.0);
      prd.setUsoDestino("67");
      listaPrds.add(prd);
      
      inpeccionVerificacion.setListaProductos(listaPrds);
      class1.insertarIVV(inpeccionVerificacion);
  }
    
}
