package pe.gob.senasa.ws;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.Ampliacion;
import pe.gob.senasa.bean.AnexoPFI;
import pe.gob.senasa.bean.LugarProduccionAnexoPFI;
import pe.gob.senasa.bean.LugarProduccionProductoPFI;
import pe.gob.senasa.bean.PaisOrigenAnexoPFI;
import pe.gob.senasa.bean.PaisOrigenProductoPFI;
import pe.gob.senasa.bean.PermisoFitosanitarioImportacion;
import pe.gob.senasa.bean.ProductoPFI;
import pe.gob.senasa.bean.PuntoIngresoAnexoPFI;
import pe.gob.senasa.bean.PuntoIngresoProductoPFI;
import pe.gob.senasa.bean.ReqImpProducto;
import pe.gob.senasa.dao.PermisoFitoSanitarioImportacionDAO;
import pe.gob.senasa.dao.RequisitoDao;
import pe.gob.senasa.interfaces.PermisoFitoSanitarioImportacionInterface;


/**
 * Manejo de información y operaciones de importacion fitosanitaria.
 */
@XmlSeeAlso( {RequisitoDao.class,Date.class, java.util.ArrayList.class, ProductoPFI.class,LugarProduccionProductoPFI.class,LugarProduccionProductoPFI.class,Ampliacion.class,
               AnexoPFI.class,PuntoIngresoAnexoPFI.class,PaisOrigenProductoPFI.class,PuntoIngresoProductoPFI.class,LugarProduccionAnexoPFI.class,PaisOrigenAnexoPFI.class})

@WebService(name = "PermisoFitosanitarioImportacion",serviceName = "PermisoFitosanitarioImportacion",
            targetNamespace = "http://permisofitosanitarioimportacion.ws.senasa.gob.pe",
            portName = "PermisoFitosanitarioImportacionPort")
public class PermisoFitosanitarioImportacionWS implements PermisoFitoSanitarioImportacionInterface{
    
    PermisoFitoSanitarioImportacionDAO pfsDAO = null;

    /**
     */
    public PermisoFitosanitarioImportacionWS() {
        pfsDAO = new PermisoFitoSanitarioImportacionDAO();
    }


    /**
     * 
     * status: Terminado
     * @param noCertificado
     * @return
     */
    @WebMethod
  public PermisoFitosanitarioImportacion obtenerPFIxNoCertificado(String noCertificado){
      return pfsDAO.obtenerPFIxNoCertificado(noCertificado);
  }
    
  @WebMethod
  public String obtenerPeridoCPE(String codigoReqImp){
    return pfsDAO.obtenerPeriodoCPE(codigoReqImp);
  }

  @WebMethod
  public ReqImpProducto obtenerValoresReqImpProducto(String codigoProducto,String codPaisOrigen,String codLugarProd,
                                            String codPaisProc,String usoDestino){
    return pfsDAO.obtenerValoresReqImpProducto(codigoProducto,codPaisOrigen,codLugarProd,codPaisProc,usoDestino);
  }
    /**
     * 
     * status: Terminado
     * @param noCertificado
     * @return
     */
    @WebMethod
  public Ampliacion ampliarCertificadoImpoFito(String noCertificado,String tipo,int cantidad){
    return pfsDAO.ampliarCertificadoImpoFito(noCertificado, tipo, cantidad);
  }

    /**
     * 
     * status: Terminado
     * @param dniRuc
     * @return
     */
    @WebMethod
    public ArrayList<PermisoFitosanitarioImportacion> obtenerPFIxSolicitante(String dniRuc){
        return pfsDAO.obtenerPFIxSolicitante(dniRuc);
    }

    /**
     * 
     * status: Terminado
     * @param pfi
     * @return
     */
    @WebMethod
    public Boolean guardarPFI(PermisoFitosanitarioImportacion pfi){
        return pfsDAO.guardarPFI(pfi);
    }

  /**
   * 
   * status: Terminado
   * @param codigoProducto
   * @param codigoAplicacion
   * @param paisProcedencia
   * @param paisLugar
   * @return
   */
  @WebMethod
  public ArrayList<RequisitoDao> obtenerRequisitosSanitariosImpoFito(String codigoProducto, String codigoAplicacion, String paisProcedencia, String paisLugar){
    return pfsDAO.obtenerRequisitosSanitariosImpoFito(codigoProducto, codigoAplicacion, paisProcedencia,paisLugar);
  }

  /**
   * 
   * status: Terminado
   * @param codigoProducto
   * @param codigoAplicacion
   * @param paisProcedencia
   * @param paisLugar
   * @param lugarProduccion
   * @return
   */
  @WebMethod
  public ArrayList<RequisitoDao> obtenerRequisitosSanitariosImpoFitoNew(String codigoProducto, String codigoAplicacion, String paisProcedencia, String paisOrigen,String lugarProduccion){
    return pfsDAO.obtenerRequisitosSanitariosImpoFito(codigoProducto, codigoAplicacion, paisProcedencia,paisOrigen,lugarProduccion);
  }
  
  /**
   * 
   * status: Terminado
   * @param numeroCertificado
   
   * @return
   */
  
  @WebMethod
  public ArrayList<RequisitoDao> obtenerRequisitosSanitariosImpoFitoXCertificado(String numeroCertificado){
    return pfsDAO.obtenerRequisitosSanitariosImpoFito(numeroCertificado);
  }
  
  @WebMethod
  public Boolean guardarDatosPFI(PermisoFitosanitarioImportacion pfi){
    
    return pfsDAO.guardarDatosPFI(pfi);
  }
  /*
  @WebMethod  
  public String registrarPermisoPFI(String codigoPermiso, String rucDni, 
                                    String codExpediente, String codigoCentroTramite,
                                    String fechaEmision, String fechaEntrega,
                                    String indAmpliacion, String codigoReqImpoProd,
                                    String urlPfi, String userName){
                                      
    return pfsDAO.registrarPermisoPFI(codigoPermiso, rucDni, codExpediente, codigoCentroTramite, fechaEmision, fechaEntrega, indAmpliacion, codigoReqImpoProd, urlPfi, userName);
  }
  @WebMethod  
  public Double registrarProductoPFI(String codigoPermiso, Double secuencial, 
                                    String codigoProducto, String codigoTipoEnvase,
                                    String codUnidadMedida, Double cantidadPeso,
                                    String codigoAmpliacion, Double cantidadEnvase,
                                    Double cantidadPlantas, String paisProcedencia,
                                     String userName){
    return pfsDAO.registrarProductoPFI(codigoPermiso, secuencial, codigoProducto, codigoTipoEnvase, codUnidadMedida, cantidadPeso, codigoAmpliacion, cantidadEnvase, cantidadPlantas, paisProcedencia, userName);
    
  }
  @WebMethod  
  public Double registrarPtoIngresoPFI(String codigoPermiso, Double secuencial, 
                                  String codigoProducto, String codigoTipoEnvase,
                                  String codUnidadMedida, Double cantidadPeso,
                                  String codigoAmpliacion, Double cantidadEnvase,
                                  Double cantidadPlantas, String codigoCentroTramite,
                                       String indicadorAnexo, String userName){
                                         
      return pfsDAO.registrarPtoIngresoPFI(codigoPermiso, secuencial, codigoProducto, codigoTipoEnvase, codUnidadMedida, cantidadPeso, codigoAmpliacion, cantidadEnvase, cantidadPlantas, codigoCentroTramite, indicadorAnexo, userName);                                 
  }
  @WebMethod  
  public String registrarPaisOrigenPFI(String codigoPermiso, String codigoPaisOrigen, 
                                  String indicadorAnexo, String codigoTipoEnvase,
                                       String codigoProducto, String userName){
                                         
    return pfsDAO.registrarPaisOrigenPFI(codigoPermiso, codigoPaisOrigen, indicadorAnexo, codigoTipoEnvase, codigoProducto, userName);
  
  }
  @WebMethod  
  public String registrarLugarProduccionPFI(String codigoPermiso, String codigoProducto, 
                                            String codigoLugarProduccion, String indicadorAnexo,
                                            String codigoTipoEnvase, String userName){
  
      return pfsDAO.registrarLugarProduccionPFI(codigoPermiso, codigoProducto, codigoLugarProduccion, indicadorAnexo, codigoTipoEnvase, userName);                                            
  }
  @WebMethod  
  public Double registrarProductoAnexoPFI(String codigoPermiso, Double secuencial, 
                                  String codigoProducto, String codigoTipoEnvase,
                                  String codUnidadMedida, Double cantidadPeso,
                                  String codigoAplicacion, Double cantidadEnvase,
                                  Double cantidadPlantas, String paisProcedencia,
                                          String userName){
       return pfsDAO.registrarProductoAnexoPFI(codigoPermiso, secuencial, codigoProducto, codigoTipoEnvase, codUnidadMedida, cantidadPeso, codigoAplicacion, cantidadEnvase, cantidadPlantas, paisProcedencia, userName);                                     
  }
  
  */
  @WebMethod 
  public String obtenerIndAutorizacionReqProd(String codReqImpo){
    return pfsDAO.obtenerIndAutorizacionReqProd(codReqImpo);
  }
  @WebMethod 
  public String obtenerIndCPEReqProd(String codReqImpo){
    return pfsDAO.obtenerIndCPEReqProd(codReqImpo);
  }
  
  @WebMethod
  public String generarNumeroPermisoPFI(@WebParam(name = "codCentroTramite") String codCentroTramite){
      return pfsDAO.generarNumeroPermisoPFI(codCentroTramite);
  }
  
  //////////////////////// METODOS VUCE ////////////////////////////////////////////
  @WebMethod
  public PermisoFitosanitarioImportacion obtenerDatosPFIxExpediente(String nroExpediente){
    return pfsDAO.obtenerDatosPFIVuce(nroExpediente);
  }
  
  @WebMethod
  public ArrayList<RequisitoDao> obtenerRequisitosImpoFitoTran(@WebParam(name = "codProducto") String codProductos,
                                                                       @WebParam(name = "codPaisesOrgn") String codPaisesOrgn,
                                                                       @WebParam(name = "codLugarProd") String codLugarProd,
                                                                       @WebParam(name = "codPaisProcd") String codPaisProcd,
                                                                       @WebParam(name = "codigoPaisesOrgn")String codPaisDest){
    return pfsDAO.obtenerRequisitosSanitariosImpoFitoTran(codProductos, codPaisesOrgn, codLugarProd, codPaisProcd, codPaisDest);                                                                       
  }
  
}