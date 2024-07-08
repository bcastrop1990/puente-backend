package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Adicional;
import pe.gob.senasa.bean.PersonaDocumento;
import pe.gob.senasa.bean.RequisitoAdicional;
import pe.gob.senasa.bean.RequisitoServicio;
import pe.gob.senasa.bean.RequisitosDocumentales;
import pe.gob.senasa.bean.ValidaDocumentoPropio;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.RequisitosDocumentalesInterface;


public class RequisitosDocumentalesDAO extends BaseDAO implements RequisitosDocumentalesInterface {
    
    protected static Logger logger = Logger.getLogger(RequisitosDocumentalesDAO.class);
    
    private DBHelper helper;
    
    public RequisitosDocumentalesDAO() {
        super();
        helper = new DBHelper(SenasaSQL.dsReqDoc);
    }
    
    
    /**
     * 
     * @param servicio
     * @return
     */
     public ArrayList<RequisitosDocumentales> obtenerRequisitosDocumentales(String servicio) {
        Log("Requisitos Documentales ********Inicio del Método ********");
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<RequisitosDocumentales> reqDocs = new ArrayList<RequisitosDocumentales>();
        String sql = SenasaSQL.OBTENER_REQUISITOS_DOCUMENTALES;
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, servicio);
            rs = pst.executeQuery();
            Log("Requisitos Documentales - Listando datos");
            while(rs.next()){
                RequisitosDocumentales req = new RequisitosDocumentales();
                req.setCodigoDocumento(rs.getString(1));
                req.setTituloDocumento(rs.getString(2));
                req.setSubTipo(rs.getString(3));
                req.setRutaCheckIn(rs.getString(4));
                req.setObligtorio(rs.getString(5));
                req.setIndicadorVuce(rs.getString(6)==null?"N":rs.getString(6));
                reqDocs.add(req);
            }
            rs.close();
           Log("Requisitos Documentales - Lista completada");;
        } catch (SQLException e) {
            Log("Requisitos Documentales - SQLException : ", e);
        } catch (Exception e) {
          Log("Requisitos Documentales - Exception : ", e);
        } finally {
            cleanup(con, pst);
        }
       Log(" Requisitos Documentales ********Fin del Método ********");
         
        return reqDocs;
     }
    

  public  List<Adicional> obtenerPredios(String idPersona){
   Log(" ********Inicio del Método Obtener Predios ********");
   String sql = SenasaSQL.OBTENER_LISTA_PREDIOS;
   
   Connection con = null;
   CallableStatement cs = null;
   ResultSet rs = null;
   
  List<Adicional> lista = new ArrayList<Adicional>();
   try {
            con = helper.getConnection();
       cs = con.prepareCall(sql);
       Log("OBTENER PREDIOS - EJECUTANDO SP "+ sql);
       cs.setString(1, idPersona);
       cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
       
       cs.execute();
       Log("OBTENER PREDIOS - Listando datos");  
       rs = (ResultSet)cs.getObject(2);
       Adicional adicional=null;
       while (rs.next()) {
           adicional = new Adicional();
            adicional.setCodigo(rs.getString("NUMERO_REGISTRO") +"_"+rs.getInt("SECUENCIAL"));
           adicional.setNombre(rs.getString("NOMBRE"));
           adicional.setDireccion(rs.getString("DIRECCION"));
           adicional.setUbigeo(rs.getString("UBIGEO"));
           adicional.setNumeroRegistro(rs.getString("NUMERO_REGISTRO"));
           adicional.setSecuencial(String.valueOf(rs.getInt("SECUENCIAL")));
          lista.add(adicional);
       }
       Log("Obtener Predios - Lista completada");
       rs.close();
   } catch (SQLException e) {
       Log("Obtener Predios", e);
   } catch (Exception e) {
       Log("Obtener Predios", e);
   } finally {
            cleanup(con, cs);
   }
   Log("Requisitos propios ********Fin del Método Obtener Predios ********");
   return lista; 
  }
  public ArrayList<RequisitoServicio> obtenerListaRequisitosPropios(String codigoServicio,String idPersona){
      Log("Requisitos propios ********Inicio del Método Obtener Requisitos Propios ********");
      
      Log("Requisitos propios ####Obtener predios INI");
      List<Adicional> listaPeredios=obtenerPredios(idPersona);
      Log("Requisitos propios ####Obtener predios FIN");
      
      String sql = SenasaSQL.OBTENER_REQUISITOS_PROPIOS;
      Log(" AQUI VA EL " + sql);
  
      Connection con = null;
      CallableStatement cs = null;
      ResultSet rs = null;
  
      ArrayList<RequisitoServicio> retval = new ArrayList<RequisitoServicio>();
      try {
            con = helper.getConnection();
          cs = con.prepareCall(sql);
          Log("Requisitos propios - EJECUTANDO SP "+ sql);
          cs.setString(1, codigoServicio);
          cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
          cs.execute();
          Log("Requisitos propios - Listando datos");  
          rs = (ResultSet)cs.getObject(2);
          RequisitoServicio oper = null;
          while (rs.next()) {
              //con = helper.getConnection();
              oper = new RequisitoServicio();
              oper.setCodigoServicio(rs.getString("Codigo_Servicio"));
              oper.setDescripcionServicio(rs.getString("Descripcion_Servicio"));
              oper.setCodigoDocumento(rs.getString("Codigo_Documento"));
              oper.setDescripcionDocumento(rs.getString("Descripcion_Documento"));
              
              if (rs.getString("Indicador_Obligatorio")!=null && (!rs.getString("Indicador_Obligatorio").trim().equals(""))){
                oper.setIndObligatorio(rs.getString("Indicador_Obligatorio"));
              }else{
                oper.setIndObligatorio("");
              }
              if (rs.getString("INDICADOR_REQ_PREDIO")!=null && (!rs.getString("INDICADOR_REQ_PREDIO").trim().equals(""))){
                oper.setIndPredio(rs.getString("INDICADOR_REQ_PREDIO"));
              }else{
                oper.setIndPredio("");
              }
              
              if (rs.getString("Ruta_Check_In")!=null){
                oper.setRutaCheckIn(rs.getString("Ruta_Check_In"));
              }else
                oper.setRutaCheckIn("");
              
              if (rs.getString("Sub_Tipo")!=null && (!rs.getString("Sub_Tipo").trim().equals(""))){
                oper.setSubTipo(rs.getString("Sub_Tipo"));
              }else
                oper.setSubTipo("");
              
              //oper.setAdicional(obtenerAdionales(""));
              RequisitoAdicional requisitoAdicional= new RequisitoAdicional();
              requisitoAdicional.setLstAdicional(listaPeredios);
              oper.setRequisitoAdicional(requisitoAdicional);
              retval.add(oper);
          }
          Log("Requisitos propios - Lista completada");
          rs.close();
      } catch (SQLException e) {
          Log("obtenerListaRequisitosPropios", e);
      } catch (Exception e) {
          Log("obtenerListaRequisitosPropios", e);
      } finally {
            cleanup(con, cs);
      }
      Log("Requisitos propios ********Fin del Método Obtener Requisitos Propios ********");
      return retval;
  }
  private long validarDocumentoPropio(String traza,PersonaDocumento personaDocumento){
      String sql = SenasaSQL.VALIDAR_REQUISITO_PROPIO;      
      long rpta=-1;
      Connection con = null;       
      CallableStatement cstmt = null;                        
      try {
          
        con = helper.getConnection();
            Log(traza+"--------Evaluando Codigo de Documento= " + personaDocumento.getCodigoDocumento() + " --------");  
            if (personaDocumento.getIdPersona()!=null && (!personaDocumento.getIdPersona().trim().equals(""))) {
              //_idPersona=aValidaDocumentoPropio[i].getIdPersona();
            }else{
              Log(traza+" Obteniendo id de Persona DNIRUC= " + personaDocumento.getDniRuc());  
              personaDocumento.setIdPersona(obtenerIdPersona(personaDocumento.getDniRuc())) ;  
            }
            
            cstmt = con.prepareCall(sql);
            Log(traza+" Preparando llamada al SP "+sql);
            Log(traza+" PARAM IdPersona = "+personaDocumento.getIdPersona());            
            Log(traza+" PARAM NumeroDocumento= "+personaDocumento.getNumeroDocumento());
            Log(traza+" PARAM TramaProductos = "+personaDocumento.getTramaProductos());
              
            cstmt.registerOutParameter(1,OracleTypes.INTEGER);
            cstmt.setString(2,personaDocumento.getIdPersona());
            cstmt.setString(3, personaDocumento.getCodigoDocumento());
            cstmt.setString(4, personaDocumento.getNumeroDocumento());
            cstmt.setString(5, personaDocumento.getTramaProductos());
            Log(traza+" Ejecutando llamada al SP "+sql);
            cstmt.execute();
            Log(traza+" Ejecutó correctamente ");              
            rpta=cstmt.getLong(1);
            Log(traza+" resultado= " +rpta); 
      } catch (SQLException e) {        
        rpta=-1;
        Log(traza+" SQLException " ,e);
      } catch (Exception e) {        
        rpta=-1;
        Log(traza+" Exception ",e);
      } finally {
            cleanup(con, cstmt);
      }
      return rpta;
  }
  
  public ValidaDocumentoPropio validarDocumentoPropio(ValidaDocumentoPropio prmDocPropio){
      String text="Validar Documento Propio -";
      
      Log(text+"********Inicio del Método ********");
      Log(text+" Cantidad de Filas recibidas ="+ prmDocPropio.getListaNrosDoc().size());
      
      ValidaDocumentoPropio prmDocPropioResponse =new ValidaDocumentoPropio();
      try {
        
          long rpta=-1;
          for(PersonaDocumento personaDocumento : prmDocPropio.getListaNrosDoc()){
            rpta=validarDocumentoPropio(text,personaDocumento);
            personaDocumento.setResultado(rpta);
            Log(text+" Resultado Asignado ");               
        }
        /*Response */ 
        prmDocPropioResponse.setListaNrosDoc(prmDocPropio.getListaNrosDoc());
        prmDocPropioResponse.setResultadoWsResponse(0);
        prmDocPropioResponse.setDescripcionWsResponse("La validación se realizó con éxito");      
      } catch (Exception e) {
        prmDocPropioResponse.setResultadoWsResponse(-1);
        prmDocPropioResponse.setDescripcionWsResponse("Error al Validar [Exception]: "+ e.getMessage());
        Log(text+" Exception ",e);
      } finally {
        
      }
     
    /*if((_idPersona.isEmpty()) || (_idPersona=="")) {
          logger.fatal("NO SE ENCONTRO EL IDENTIFICADOR DE PERSONA PARA EL SOLICITANTE: " + dniRuc);
          return -1.0;
    }*/
    return prmDocPropioResponse;
  }
  
  private String obtenerIdPersona(String dniRucSolicitante) {
    
    String sql = SenasaSQL.OBTENER_ID_PERSONA;
    Log("obtenerIdPersona(): AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String retval = "";
    try {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, dniRucSolicitante);
        rs= pst.executeQuery();
        
        int i=0;
        while (rs.next()) {
            i++;
            if(i==1)
              retval = rs.getString(1);
        }
        Log(" = TODO FINITO = ");
    } catch (SQLException e) {
        Log("obtenerIdPersona", e);
    } catch (Exception e) {
        Log("obtenerIdPersona", e);
    } finally {
            cleanup(con, pst);
    }
    return retval;
  }
    
    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("RequisitosDocumentalesDAO - " + s, p2);
    }
    
  public static void main(String[] args) 
  {
     //SolicitanteDAO std= new SolicitanteDAO();
   
  }
}
