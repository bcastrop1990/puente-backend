package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Arrays;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.AnexoPFI;
import pe.gob.senasa.bean.AnexoPZI;
import pe.gob.senasa.bean.AutorizacionSanitariaEstExpoZoo;
import pe.gob.senasa.bean.ExportacionZooSanitaria;
import pe.gob.senasa.bean.ProductoPZI;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.ExportacionZooSanitariaInterface;
import pe.gob.senasa.util.Utility;


public class ExportacionZooSanitariaDAO extends BaseDAO implements ExportacionZooSanitariaInterface {
    
    protected static Logger logger = Logger.getLogger(ExportacionZooSanitariaDAO.class);
    private DBHelper helper;
    public ExportacionZooSanitariaDAO() {
        super();
        helper = new DBHelper(SenasaSQL.dsExpoZoo);
    }
    /**
     * CABLEADO
     * @param codigoProducto
     * @param paisProcedencia
     * @param usoDestino
     * @return
     */
    public ArrayList obtenerRequisitosSanitariosExpoZoo(String codigoProducto,
                                                        String paisProcedencia,
                                                        String usoDestino) {
       /** String sql = SenasaSQL.OBTENER_REQUISITOS_SANITARIOS_IMPO_FITO;
        Log(" AQUI VA EL " + sql);
        Connection con = ConnectionSenasa.getSingletonObject().getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<String> retval = new ArrayList<String>();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoProducto);
            pst.setString(2, paisProcedencia);
            pst.setString(3, usoDestino);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(rs.getString(1));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerRequisitosSanitariosExpoZoo", e);
        } catch (Exception e) {
            Log("obtenerRequisitosSanitariosExpoZoo", e);
        } finally {
            Datacleanup(con, pst);
        }
        return retval;*/

        return new ArrayList<String>(Arrays.asList(new String[]{"requisito1","requisito2","requisito3","requisito4"}));
    }

    public ExportacionZooSanitaria obtenerExportacionZooXNoCertificado(String noCertificado) {
        Connection con = null;

        ExportacionZooSanitaria retval = new ExportacionZooSanitaria();
        try {
            con = helper.getConnection();
            Log(" = INICIO = ");
            retval =obtenerExportacionZoo(noCertificado,con);            
            ProductoPZI pzi = obtenerExportacionZooProductoPZI(noCertificado,con);
            //retval.setProductoCEZ(pzi);
            //ArrayList<AnexoPZI> list = obtenerAnexosProductoPZI(noCertificado,con);
            //retval.setAnexosCEZ(list);
            //
            Log(" = TODO FINITO = ");
            
        } catch (SQLException e) {
            ManejarException(con, e);
        } catch (Exception e) {
            ManejarException(con, e);
        } finally {
            cleanup(con, null);
        }
        return retval;
    }

    public ArrayList<ExportacionZooSanitaria> obtenerExportacionZooxSolicitante(String dniRuc) {
        Connection con = null;
        String sql = SenasaSQL.OBTENER_CERTIFICADOS_X_CLIENTE;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ExportacionZooSanitaria> retval = new ArrayList<ExportacionZooSanitaria>();
        try {
            con = helper.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, dniRuc);
            Log(" = voy a ejecutar  OBTENER_CERTIFICADOS_X_CLIENTE = ");
            rs = pst.executeQuery();
            ArrayList<String> nosCertificados = new ArrayList<String>();
            while (rs.next()) {
                nosCertificados.add(rs.getString(1));
            }
            rs.close();
            for (String s : nosCertificados) {
                ExportacionZooSanitaria aux = obtenerExportacionZooXNoCertificado(s);
                retval.add(aux);
            }
            Log(" = TODO FINITO = ");
        } catch (SQLException e) {
            Log("obtenerPZIxSolicitante", e);
        } catch (Exception e) {
            Log("obtenerPZIxSolicitante", e);
        } finally {
            cleanup(con, null);
        }
        return retval;
    }

  
  public String obtenerNumeroCertificadoExpoZoo(String sede) {
      logger.debug("= OBTENER_NUMERO_CERTIFICADO_EXPOZOO =");
      Connection con = null;
      String sql = SenasaSQL.CREAR_CERTIFICADO_EXPO_ZOO;
      logger.debug("SENTENCIA SQL: "+sql);
      CallableStatement cs = null;
      ResultSet rs = null;
      String retval = "";
      
      try {
            con = helper.getConnection();
          cs = con.prepareCall(sql);
          cs.registerOutParameter(1, OracleTypes.VARCHAR);
          cs.setString(2, sede);
        
          logger.debug(" = ANTES DE EJECUTAR = ");
          logger.debug("sede: " + sede);      
          cs.execute();
          retval=cs.getString(1);
          logger.debug(" = Numero Certificado Obtenido: "+retval);       
      } catch (SQLException e) {
          logger.debug("obtenerNumeroCertificadoExpoZoo", e);
          retval = e.getMessage();
      } catch (Exception e) {
          logger.debug("obtenerNumeroCertificadoExpoZoo", e);
          retval = e.getMessage();
      } finally {
            cleanup(con, cs);
      }
      return retval;
      
  }


    public Boolean guardarExportacionZoo(ExportacionZooSanitaria expoZoo) {
        if (ExisteNumerosCertificados(expoZoo.getNoCertificado())) {
            return actualizarCertExpoZoo(expoZoo);
        } else {
            return salvarCertExpoZoo(expoZoo);
        }
    }
    
    private Boolean salvarCertExpoZoo(ExportacionZooSanitaria expoZoo) {
        Connection con =null;
        try {
            con = helper.getConnection();
        } catch (Exception e) {
            logger.debug("salvarCertificadoExpoZoo Error: "+e.getMessage());
        }
        return salvarCertExpoZoo(expoZoo, con);
    }
    
    private Boolean salvarCertExpoZoo(ExportacionZooSanitaria expoZoo,Connection con) {
        boolean retval = false;
        String codigoCertificado=null;
        int secuencialProd=0;
        try {
            logger.debug(" = INICIO GUARDAR_EXPORTACION_ZOOSANITARIO = ");
            con.setAutoCommit(false);                   
            codigoCertificado =guardarExportacionZoo(expoZoo,con);
            logger.debug("Codigo de Certificado Generado: "+codigoCertificado);
            logger.debug("Usuario ExpoZoo: "+expoZoo.getUsuario());
            
            logger.debug("Cantidad de Productos a grabar: "+expoZoo.getProductosCEZ().size());
            if(codigoCertificado!=null){
              for(ProductoPZI prodZ : expoZoo.getProductosCEZ()){
                  if(prodZ!=null){
                      secuencialProd++;
                      guardarProductoCEZ(prodZ, codigoCertificado, secuencialProd, expoZoo.getUsuario(), con);
                  }
              }
              secuencialProd=0;
              for(AnexoPZI anexoZ : expoZoo.getAnexosCEZ()){
                  if(anexoZ!=null){
                  secuencialProd++;
                  guardarAnexoCEZ(anexoZ,codigoCertificado,secuencialProd,expoZoo.getUsuario(),con);
                  }
              }              
              con.commit();    
            }              
            
            con.setAutoCommit(true);
            logger.debug("GUARDAR EXPORTACION ZOOSANITARIO FINALIZADO CORRECTAMENTE");
            
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
    
    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("ExportacionZooSanitariaDAO - " + s, p2);
    }
    
    private void ManejarException(Connection con, Exception e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("guardarExportacionZoo", f);
        }
        Log("guardarExportacionZoo", e);
    }
    
    private void guardarImportador(ExportacionZooSanitaria expoZoo,
                                   Connection con) throws SQLException {
        
        String sql = SenasaSQL.GUARDAR_IMPORTADOR;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        String [] colNames = {"CODIGO_IMPORTADOR"};
        pst = con.prepareStatement(sql,colNames);
        pst.setString(1, expoZoo.getPaisDestino());
        pst.setString(2, expoZoo.getNombreImportador());
        pst.setString(3, expoZoo.getDireccionImportador());
        pst.executeUpdate();
        
        Log(" = VOY A EJECUTAR GUARDAR_IMPORTADOR = ");
           ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) 
            expoZoo.setCodigoImportador(rs.getString(1));
        else
            throw  new SQLException("ALGO PASO CON GUARDAR IMPORTADOR");
        Log(" = LISTO QUERY DE GUARDAR_IMPORTADOR = ");
    }
                                   
    private String guardarExportacionZoo(ExportacionZooSanitaria expoZoo,
                                       Connection con) throws SQLException {
        logger.debug("GUARDAR_CERTIFICADO_EXPORTACION_ZOOSANITARIO");
        String sql = SenasaSQL.GUARDAR_CERT_EXPO_ZOO;
        String retval=null;
        logger.debug(" AQUI VA EL " + sql);
        CallableStatement cs;
        cs = null;
        cs = con.prepareCall(sql);
        
        cs.registerOutParameter(1, Types.VARCHAR);  
        cs.setString(2, expoZoo.getPuntoLlegada());
        cs.setString(3, expoZoo.getUsoDestino());
        cs.setString(4, expoZoo.getObservacion());//Dato observacion...por aclarar
        cs.setString(5, expoZoo.getPuntoSalida());
        cs.setDate(6, Utility.parseStringToDate(expoZoo.getFechaEmision()));
        logger.debug("Direccion Ejecutiva: "+expoZoo.getDireccionEjecutiva());
        cs.setString(7, expoZoo.getDireccionEjecutiva());
        cs.setDate(8, null); //Dato fechaEntrega...por aclarar
        cs.setString(9, expoZoo.getPaisOrigen());
        cs.setString(10, expoZoo.getPaisDestino());
        cs.setString(11, expoZoo.getSolicitante().getDepartamento());
        cs.setString(12, expoZoo.getSolicitante().getProvincia());
        cs.setString(13, expoZoo.getSolicitante().getDistrito());
        cs.setString(14, expoZoo.getMedioTransporte());
        cs.setString(15, expoZoo.getLugarInspeccion());
        cs.setString(16, expoZoo.getCodigoImportador());   
        cs.setDate(17, Utility.toSQLDate(expoZoo.getFechaEmbarque()));
        cs.setDate(18, Utility.toSQLDate(expoZoo.getFechasDesembarque()));
        cs.setString(19, expoZoo.getNoFolio());
        cs.setString(20, expoZoo.getUrlCEZDefinitivo());
        cs.setDate(21, Utility.parseStringToDate(expoZoo.getFechaEmision())); //Dato HoraEmision... por aclarar
        cs.setString(22, expoZoo.getLugarUbicacionEnvio());
        cs.setDate(23, Utility.toSQLDate(expoZoo.getFechaInspeccion()));
        cs.setString(24, expoZoo.getNoCertificado());
        cs.setString(25, expoZoo.getUsuario());
        cs.setString(26, expoZoo.getSolicitante().getCodigoSolicitante());
              
        logger.debug(" = VOY A EJECUTAR GUARDAR_CERT_EXPO_ZOO = ");
        cs.execute();
        logger.debug(" = LISTO QUERY DE GUARDAR_CERT_EXPO_ZOO = ");
        
        retval=cs.getString(1);
        logger.debug("Numero de Certificado EXPOZOO Obtenido: "+retval);
        cs.close();
        return retval;
    }

    private void guardarProductoCEZ(ProductoPZI productoPZI, String codigoCertf, int secuencial,String usuario,
                                      Connection con) throws SQLException {
        logger.debug("= REGISTRAR_PRODUCTO_CEZ =");
        String sql = SenasaSQL.GUARDAR_PRODUCTO_EXPO_ZOO;
        logger.debug(" AQUI VA EL " + sql);
        CallableStatement cs;
        cs = con.prepareCall(sql);
        
        logger.debug("Codigo CEZ: "+codigoCertf);
        cs.setString(1, codigoCertf);
        logger.debug("Secuencial: "+secuencial);
        cs.setInt(2, secuencial);
        logger.debug("Uso o destino: "+productoPZI.getUsoDestino());
        cs.setString(3, productoPZI.getUsoDestino());
        logger.debug("Especie: "+productoPZI.getEspecie());
        cs.setString(4, productoPZI.getEspecie());
        logger.debug("Es Animal: "+productoPZI.getEsAnimal());
        if(productoPZI.getEsAnimal()){
          logger.debug("Ingresa como animal");
          logger.debug("Cantidad animales: "+productoPZI.getNumeroAnimales());
          cs.setInt(5, productoPZI.getNumeroAnimales());        
        }else{
          logger.debug("Ingresa como producto o Sub Producto");
          logger.debug("Peso Neto: "+productoPZI.getPesoNeto());
          cs.setDouble(5, productoPZI.getPesoNeto());
        }
        logger.debug("Codigo Producto: "+productoPZI.getCodProducto());
        cs.setString(6, productoPZI.getCodProducto());
        logger.debug("Tipo Envase: "+productoPZI.getTipoEnvase());
        cs.setString(7, productoPZI.getTipoEnvase());
        logger.debug("Unidad Medida: "+productoPZI.getCodUniMed());
        cs.setString(8, productoPZI.getCodUniMed());
        logger.debug("Sexo: "+productoPZI.getIdSexo());
        cs.setString(9, productoPZI.getIdSexo());
        logger.debug("Edad: "+productoPZI.getEdad());
        cs.setString(10,productoPZI.getEdad()==null?null:String.valueOf(productoPZI.getEdad()));
        logger.debug("Raza: "+productoPZI.getIdRaza());
        cs.setString(11, productoPZI.getIdRaza());
        logger.debug("Identificacion Anml: "+productoPZI.getIdentificacion());
        cs.setString(12, productoPZI.getIdentificacion());
        logger.debug("Cantidad Envase: "+productoPZI.getCantidad());
        cs.setDouble(13, productoPZI.getCantidad()==null?0:productoPZI.getCantidad());  
        logger.debug("Contiene Anexo: "+productoPZI.getContieneAnexos());
        cs.setString(14, productoPZI.getContieneAnexos()==true?"Y":"N");
        logger.debug("Pais Procedencia: "+productoPZI.getPaisProcedencia());
        cs.setString(15, productoPZI.getPaisProcedencia());
        logger.debug("Usuario: "+usuario);
        cs.setString(16, usuario);         
        logger.debug(" = VOY A EJECUTAR GUARDAR_PRODUCTO_PZE = ");
        cs.execute();
        logger.debug(" = SE EJECUTO CORRECTAMENTE GUARDAR_PRODUCTO_PZE = ");
        cs.close();
    }
    
  private void guardarAnexoCEZ(AnexoPZI anexoCEZ, String codigoCertificado,int secuencial, String usuario,
                                 Connection con)throws SQLException {
      
      logger.debug("= REGISTRAR_ANEXO_CEZ =");
      String sql = SenasaSQL.GUARDAR_ANEXO_EXPO_ZOO;
      logger.debug(" AQUI VA EL " + sql);
      CallableStatement cs;
      cs = con.prepareCall(sql);    
      cs.setString(1, codigoCertificado);
      cs.setInt(2, secuencial);
      logger.debug("Uso destino: "+anexoCEZ.getUsoDestino());
      cs.setString(3, anexoCEZ.getUsoDestino());
      logger.debug("Especie: "+anexoCEZ.getEspecieAnimal());
      cs.setString(4, anexoCEZ.getEspecieAnimal());
      logger.debug("Cantidad Animal: "+anexoCEZ.getCantidadAnimal());
      if(anexoCEZ.getCantidadAnimal()==null||anexoCEZ.getCantidad()==0){
        logger.debug("Ingresa como producto o Sub Producto");
        logger.debug("Peso Neto: "+anexoCEZ.getPesoNeto());
        cs.setDouble(5, anexoCEZ.getPesoNeto());
      }else{
        logger.debug("Ingresa como animal");
        cs.setInt(5, anexoCEZ.getCantidadAnimal());
      }
      logger.debug("Codigo Producto Anexo: "+anexoCEZ.getCodigo());
      cs.setString(6, anexoCEZ.getCodigo());
      logger.debug("Tipo de Envase: "+anexoCEZ.getTipoEnvase());
      cs.setString(7, anexoCEZ.getTipoEnvase());
      logger.debug("Unidad Medida: "+anexoCEZ.getCodUniMed());
      cs.setString(8, anexoCEZ.getCodUniMed());
      logger.debug("Sexo Animal: "+anexoCEZ.getSexoAnimal());
      cs.setString(9, anexoCEZ.getSexoAnimal());
      logger.debug("Edad Animal: "+anexoCEZ.getEdadAnimal());
      cs.setString(10,anexoCEZ.getEdadAnimal()==null?null:String.valueOf(anexoCEZ.getEdadAnimal()));
      logger.debug("Raza Animal: "+anexoCEZ.getRazaAnimal());
      cs.setString(11, anexoCEZ.getRazaAnimal());
      logger.debug("Nro Identificacion: "+anexoCEZ.getNroIdentfAnimal());
      cs.setString(12, anexoCEZ.getNroIdentfAnimal());
      logger.debug("Cantidad Animal: "+anexoCEZ.getCantidad());
      cs.setDouble(13, anexoCEZ.getCantidad());  
      cs.setString(14, "N");
      logger.debug("Raza Animal: "+anexoCEZ.getPaisProcedencia());
      cs.setString(15, anexoCEZ.getPaisProcedencia());
      logger.debug("Usuario: "+anexoCEZ.getPaisProcedencia());
      cs.setString(16, usuario);
      
      logger.debug(" = VOY A EJECUTAR GUARDAR_ANEXO_PZE = ");
      cs.execute();
      logger.debug(" = SE EJECUTO CORRECTAMENTE GUARDAR_ANEXO_PZE = ");
      cs.close();
      
  }

    private void guardarAnexoEZ(AnexoPFI proH, String noCert, String usoDestino,
                                Connection con) throws SQLException {
        
        if (proH==null) return;    
       //CCORCER,CCODPRO,PAIS_PROCEDENCIA,NPESPRO,CCODENV,NCANENV,CODIGO_APLICACION,ES_CABECERA
       String sql = SenasaSQL.GUARDAR_ANEXO_PZE;
       //( CODIGO_CERTIFICADO_ZOO_EXPO,CODIGO_APLICACION,CANTIDAD_PESO,
       //CODIGO_PRODUCTO,CODIGO_TIPO_ENVASE,CANTIDAD_ENVASE,
       //COD_PAIS_PROCEDENCIA ) 
       Log(" AQUI VA EL " + sql);
       PreparedStatement pst;
       pst = con.prepareStatement(sql);
       
       pst.setString(1, noCert);
       pst.setString(2, usoDestino);
       pst.setDouble(3, proH.getPesoNeto());
       pst.setString(4, proH.getCodigo());
       pst.setString(5, proH.getTipoEnvase());
       pst.setDouble(6, proH.getCantidad());
       pst.setString(7, proH.getPaisProcedencia());
       pst.setString(8, proH.getCodUniMed());
       
       Log(" = VOY A EJECUTAR GUARDAR_ANEXO_PZE = ");
       pst.execute();
       Log(" = LISTO QUERY DE GUARDAR_ANEXO_PZE = ");
        
    }

    private ExportacionZooSanitaria obtenerExportacionZoo(String noCertificado,Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_CERT_EXPOZOO_CABECERA;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ExportacionZooSanitaria retval = new ExportacionZooSanitaria();
        pst = con.prepareStatement(sql);
        pst.setString(1, noCertificado);
        Log(" = VOY A EJECUTAR SELECT EN OBTENER_CERT_EXPOZOO_CABECERA = ");
        rs = pst.executeQuery();
        Log(" = VIENDO RS DE OBTENER_CERT_EXPOZOO_CABECERA = ");
        while (rs.next()) {
            retval = obtPermisoExportacionZoo(rs);
            break;
        }
        return retval;
    }

    private ExportacionZooSanitaria obtPermisoExportacionZoo(ResultSet rs) throws SQLException {
        ExportacionZooSanitaria retval = new ExportacionZooSanitaria();
        
        retval.setDireccionEjecutiva(rs.getString(1));
        retval.setNoCertificado(rs.getString(2));
        retval.setNoFolio(rs.getString(3));
        retval.setUrlCEZDefinitivo(rs.getString(4));
        retval.setLugarInspeccion(rs.getString(5));
        retval.setFechaInspeccion(rs.getDate(6));
        
        retval.setHoraInspeccion(rs.getDate(7));
        retval.setFechaEmbarque(rs.getDate(8));
        retval.setFechasDesembarque(rs.getDate(9));
        retval.setUsoDestino(rs.getString(10));
        retval.setPaisDestino(rs.getString(11));
        retval.setPaisOrigen(rs.getString(12));
        retval.setMedioTransporte(rs.getString(13));
        retval.setPuntoSalida(rs.getString(14));
        retval.setPuntoLlegada(rs.getString(15));
        retval.setLugarUbicacionEnvio(rs.getString(16));
        
        return retval;
    }

    private ProductoPZI obtenerExportacionZooProductoPZI(String noCertificado,
                                                         Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_PRODUCTO_PZE;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ProductoPZI retval = new ProductoPZI();
        pst = con.prepareStatement(sql);
        pst.setString(1, noCertificado);
        Log(" = VOY A EJECUTAR SELECT EN OBTENER_PRODUCTO_PZI = ");
        rs = pst.executeQuery();
        Log(" = VIENDO RS DE OBTENER_PRODUCTO_PZI = ");
        while (rs.next()) {
            retval = obtProductoPZI(rs);
            break;
        }
        return retval;
    }

    private ProductoPZI obtProductoPZI(ResultSet rs) throws SQLException {
        ProductoPZI retval = new ProductoPZI();
        retval.setCodProducto(rs.getString(1));
        retval.setDescripcion(rs.getString(2));
        retval.setNombreCientifico(rs.getString(3));
        retval.setPartidaArancelaria(rs.getString(4));
        retval.setPaisProcedencia(rs.getString(5));
        retval.setUsoDestino(rs.getString(6));
        retval.setEspecie(rs.getString(7));
        retval.setIdSexo(rs.getString(8));
        retval.setEdad((int)rs.getDouble(9));
        retval.setIdRaza(rs.getString(10));
        retval.setIdentificacion(rs.getString(11));
        retval.setTipoEnvase(rs.getString(12));
        retval.setCantidad(rs.getDouble(13));
        retval.setPesoNeto(rs.getDouble(14));
        if(Utility.TryParseInteger(rs.getString(15)) > 0)
            retval.setContieneAnexos(true);
        else
            retval.setContieneAnexos(false);
        return retval;
    }
    
    

    private ArrayList<AnexoPFI> obtenerAnexosProductoPZI(String noCertificado,Connection con) throws SQLException {
        String sql = SenasaSQL.OBTENER_ANEXOS_PZE;
        Log(" AQUI VA EL " + sql);
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<AnexoPFI> retval = new ArrayList<AnexoPFI>();
        pst = con.prepareStatement(sql);
        pst.setString(1, noCertificado);
        Log(" = VOY A EJECUTAR SELECT EN OBTENER_ANEXOS_PZE = ");
        rs = pst.executeQuery();
        Log(" = VIENDO RS DE OBTENER_ANEXOS_PZE = ");
        while (rs.next()) {
            retval.add(obtAnexoPFI(rs));
        }
        return retval;
    }
    
    private AnexoPFI obtAnexoPFI(ResultSet rs) throws SQLException {
        AnexoPFI retval = new AnexoPFI();
        retval.setCodigo(rs.getString(1));
        retval.setDescripcion(rs.getString(2));
        retval.setNombreCientifico(rs.getString(3));
        retval.setPartidaArancelaria(rs.getString(4));
        
        retval.setCodigoPadre(rs.getString(5));
        retval.setDescripcionPadre(rs.getString(6)); 
        retval.setNombreCientificoPadre(rs.getString(7));
        retval.setPartidaArancelariaPadre(rs.getString(8));
        
        retval.setPaisProcedencia(rs.getString(9));
        retval.setUsoDestino(rs.getString(10));
        
        retval.setTipoEnvase(rs.getString(11));
        retval.setCantidad(Utility.TryParseDouble(rs.getString(12)));
        retval.setPesoNeto(Utility.TryParseDouble(rs.getString(13)));

        return retval;
    }


    private boolean ExisteNumerosCertificados(String noCertificado) {
        Connection con = null;
        boolean retval = false;
        try {
            con = helper.getConnection();
            PreparedStatement pst = con.prepareCall(SenasaSQL.BUSCAR_CERT_EXPO_ZOO_NO_CERTIFICADO);
            Log(" = INICIO BUSCAR_CERT_EXPO_ZOO_NO_CERTIFICADO= ");
            pst.setString(1, noCertificado);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) >= 1)
                    retval = true;
                else
                    retval = false;
                break;
            }
            Log(" = FIN BUSCAR_CERT_EXPO_ZOO_NO_CERTIFICADO= ");
        } catch (SQLException e) {
            ManejarException(con, e);
        } catch (Exception e) {
            ManejarException(con, e);
        } finally {
            cleanup(con, null);
        }
        return retval;
    }

    private Boolean actualizarCertExpoZoo(ExportacionZooSanitaria expoZoo) {
        Connection con =  null;
        try {
            con = helper.getConnection();
            if (DeleteAll(expoZoo.getNoCertificado(), con))
                return salvarCertExpoZoo(expoZoo, con);
            else
                return false;
        } catch (Exception e) {
            ManejarExcepcion(con, e);
        }
        return false;
    }
    
    private void ManejarExcepcion(Connection con, Exception e) {
        try {
            con.rollback();
        } catch (SQLException f) {
            Log("guardarRegistroCPE", f);
        }
        Log("guardarRegistroCPE", e);
    }
    
    private boolean DeleteAll(String noCert, Connection con) throws SQLException {
        boolean retval = false;

            Log(" = INICIO = ");
            //con.setAutoCommit(false);
            Log(" = ELIMINAR_ANEXOS_EXPO_ZOO = "+ExecuteQuery(noCert, SenasaSQL.ELIMINAR_ANEXOS_EXPO_ZOO,con));
            Log(" = ELIMINAR_PRODUCTOS_EXPO_ZOO = "+ExecuteQuery(noCert, SenasaSQL.ELIMINAR_PRODUCTOS_EXPO_ZOO,con));
            Log(" = ELIMINAR_CERTIFICADO_EXPO_ZOO = "+ExecuteQuery(noCert, SenasaSQL.ELIMINAR_CERTIFICADO_EXPO_ZOO,con));
            Log(" = LISTO ELIMINAR = ");
            //con.commit();
            //con.setAutoCommit(true);
            retval = true;
        
        return retval;
    }
    
    private int ExecuteQuery(String noExp,String sql,
                              Connection con) throws SQLException {
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, noExp);
        return pst.executeUpdate();
    }
 // ====================================================================================================================
 //========================================= METODOS VUCE ======================================================
    public String obtenerCodidgoFormatoDocVuce(String nroExpediente){
      String codigoFormato = null;  
      logger.debug("OBTENER_CODIGO_FORMATO_DOC_VUCE");
      String sql = SenasaSQL.OBTENER_CODIGO_FORMATO_DOCUMENTO;
      logger.debug("Sentencia SQL: "+sql);
      Connection con =null;
      PreparedStatement pst =null;
      ResultSet rs= null;
      try{
          con= cnApp.getConnectionVuce();
          pst= con.prepareCall(sql);      
          pst.setString(1,nroExpediente);
          logger.debug("= Voy a Ejecutar el query OBTENER_CODIGO_FORMATO_DOC_VUCE =");
          rs=pst.executeQuery();
          logger.debug("= Se ejecuto el query OBTENER_CODIGO_FORMATO_DOC_VUCE =");
          if(rs.next()){
              codigoFormato=rs.getString(1);    
          }
          logger.debug("= Codigo de Formato Obtenido: "+codigoFormato);
      }catch (SQLException e) {
        Log("OBTENER_CODIGO_FORMATO_DOC_VUCE Error", e);
      } catch (Exception e) {
        Log("OBTENER_CODIGO_FORMATO_DOC_VUCE Error", e);
      } finally {
            cleanup(con, pst, rs);
      }    
      return codigoFormato;
    }   
      
   public AutorizacionSanitariaEstExpoZoo obtenerDatosAutorizacionExpoZoo(String nroExpediente,String codigoServicio){
     logger.debug("OBTENER_DATOS_AUTORIZACION_EXPOZOO INICIANDO");   
     String sql = SenasaSQL.OBTENER_DATOS_AUTORIZACION_ESTABLECIMIENTO;
     logger.debug("Sentencia SQL: "+sql);
     logger.debug("nroExpediente -> "+nroExpediente);
     logger.debug("codigoServicio -> "+codigoServicio);
     Connection con =null;
     CallableStatement cs =null;
     ResultSet rs= null;
     AutorizacionSanitariaEstExpoZoo autorizacionExpoZoo = null;
     String sbProductos =""; 
     try{
            con = helper.getConnection();
         cs= con.prepareCall(sql);
         
         cs.setString(1, codigoServicio);
         cs.setString(2, nroExpediente);
         cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
         cs.registerOutParameter(4, OracleTypes.CURSOR, "SYS_REFCURSOR");
  
         logger.debug(" = Ejecutando  OBTENER_DATOS_AUTORIZACION_ESTABLECIMIENTO = ");
  
         cs.execute();
         Log(" = ENTRANDO = ");
         rs = (ResultSet)cs.getObject(3);
         logger.debug("Se ejecuto OBTENER_DATOS_AUTORIZACION_ESTABLECIMIENTO");
         if(rs.next()){
          //Datos de la autorizacion Zoo
           logger.debug("Seteando los datos de la Autorizacion de Expotador");
           autorizacionExpoZoo= new AutorizacionSanitariaEstExpoZoo();
           autorizacionExpoZoo.setNroCertf(rs.getString("Numero_Solicitud"));
           autorizacionExpoZoo.setNomEmpresa(rs.getString("Nombre_Razon_Social"));
           autorizacionExpoZoo.setNroRucEmpresa(rs.getString("Codigo_Cliente"));
           autorizacionExpoZoo.setDirEmpresa(rs.getString("Direccion"));
           autorizacionExpoZoo.setTipoEstablecimiento(rs.getString("Tipo_Recinto"));
           autorizacionExpoZoo.setNomEstablecimiento(rs.getString("Nombre_Establecimiento"));
           autorizacionExpoZoo.setNroDias(rs.getString("Dias_Plazo"));
           autorizacionExpoZoo.setFechaInicio(Utility.parseDateToString(rs.getDate("Fecha_Inicio")));
           autorizacionExpoZoo.setFechaFin(Utility.parseDateToString(rs.getDate("Fecha_Final")));
           autorizacionExpoZoo.setCodSede(rs.getString("Codigo_Sede"));
           autorizacionExpoZoo.setLugarEmisionCertf(rs.getString("Desc_Sede_Sed"));
           autorizacionExpoZoo.setFechaExpediente(Utility.parseDateToString(rs.getTimestamp("Fecha_Solicitud")));
           autorizacionExpoZoo.setFechaEmisionCertf(Utility.parseDateToString(rs.getTimestamp("Fecha_Emision_Certificado")));
           autorizacionExpoZoo.setTipo(rs.getString("Tipo"));
           logger.debug("Tipo de Formato :"+autorizacionExpoZoo.getTipo());
           
           if(autorizacionExpoZoo.getTipo().equalsIgnoreCase("ARC")){
               logger.debug("Seteando los datos de Recinto Cuarentenario");
               autorizacionExpoZoo.setNroIT("Numero_It");
               autorizacionExpoZoo.setFechaIT(Utility.parseDateToString(rs.getTimestamp("Fecha_It")));
               autorizacionExpoZoo.setNroDs(rs.getString("Numero_Ds"));
               autorizacionExpoZoo.setDirEstablecimiento(rs.getString("Direccion_Establecimiento"));
               autorizacionExpoZoo.setNomRecinto(rs.getString("Recinto"));
            }
           logger.debug("Fin de Setear los datos de la Cabecera");
         }
         if(autorizacionExpoZoo!=null){
            rs=(ResultSet)cs.getObject(4);
            if(rs.next()){
              logger.debug("Seteando los datos de la Autorizacion-Productos");          
              if(rs.getString("Nomb_Espe_Ani")!=null&&!(rs.getString("Nomb_Espe_Ani").equals(""))){
                sbProductos=sbProductos+rs.getString("Nomb_Espe_Ani")+",";
              }else{
                sbProductos="";    
              }
            }
            if(sbProductos.length()>0){
              sbProductos=sbProductos.substring(0, sbProductos.length()-1);
            }
            logger.debug("Fin de setear los datos de los productos :"+sbProductos);
            autorizacionExpoZoo.setProductos(String.valueOf(sbProductos)); 
         }

     }catch (SQLException e) {
       Log("OBTENER_DATOS_AUTORIZACION_ESTABLECIMIENTO", e);
     } catch (Exception e) {
       Log("OBTENER_DATOS_AUTORIZACION_ESTABLECIMIENTO", e);
     } finally {
            cleanup(con, cs, rs);
     }
     return autorizacionExpoZoo;
   }
   
   public ExportacionZooSanitaria obtenerDatosEZxExpediente(String nroExpediente){
    ExportacionZooSanitaria expozoo =null; 
    
    return expozoo;
   }

}
