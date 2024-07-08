package pe.gob.senasa.interfaces;


import java.util.ArrayList;

import pe.gob.senasa.bean.Ampliacion;
import pe.gob.senasa.bean.PermisoFitosanitarioImportacion;
import pe.gob.senasa.bean.ReqImpProducto;
import pe.gob.senasa.dao.RequisitoDao;


public interface PermisoFitoSanitarioImportacionInterface {
    
    public ArrayList<RequisitoDao> obtenerRequisitosSanitariosImpoFito(String codigoProducto, String codigoAplicacion, String paisProcedencia, String paisLugar);
  
    public PermisoFitosanitarioImportacion obtenerPFIxNoCertificado(String noCertificado);
    
    public ArrayList<PermisoFitosanitarioImportacion> obtenerPFIxSolicitante(String dniRuc);
    
    public Boolean guardarPFI(PermisoFitosanitarioImportacion pfi);
    
    public Ampliacion ampliarCertificadoImpoFito(String noCertificado,String tipo,int cantidad);
  
    public Boolean guardarDatosPFI(PermisoFitosanitarioImportacion pfi);
  
  /*  
    public String registrarPermisoPFI(String codigoPermiso, String rucDni, 
                                      String codExpediente, String codigoCentroTramite,
                                      String fechaEmision, String fechaEntrega,
                                      String indAmpliacion, String codigoReqImpoProd,
                                      String urlPfi, String userName);
  
    public Double registrarProductoPFI(String codigoPermiso, Double secuencial, 
                                      String codigoProducto, String codigoTipoEnvase,
                                      String codUnidadMedida, Double cantidadPeso,
                                      String codigoAmpliacion, Double cantidadEnvase,
                                      Double cantidadPlantas, String paisProcedencia,
                                      String userName);
    
    public Double registrarPtoIngresoPFI(String codigoPermiso, Double secuencial, 
                                    String codigoProducto, String codigoTipoEnvase,
                                    String codUnidadMedida, Double cantidadPeso,
                                    String codigoAmpliacion, Double cantidadEnvase,
                                    Double cantidadPlantas, String codigoCentroTramite,
                                    String indicadorAnexo, String userName);
  
    public String registrarPaisOrigenPFI(String codigoPermiso, String codigoPaisOrigen, 
                                    String indicadorAnexo, String codigoTipoEnvase,
                                    String codigoProducto, String userName);
    
    public String registrarLugarProduccionPFI(String codigoPermiso, String codigoProducto, 
                                    String codigoLugarProduccion, String indicadorAnexo,
                                    String codigoTipoEnvase, String userName);
  
    public Double registrarProductoAnexoPFI(String codigoPermiso, Double secuencial, 
                                    String codigoProducto, String codigoTipoEnvase,
                                    String codUnidadMedida, Double cantidadPeso,
                                    String codigoAplicacion, Double cantidadEnvase,
                                    Double cantidadPlantas, String paisProcedencia,
                                    String userName);
  */  
   
  public String obtenerIndAutorizacionReqProd(String codReqImpo);
  public String obtenerIndCPEReqProd(String codReqImpo);
  public ReqImpProducto obtenerValoresReqImpProducto(String codigoProducto,String codPaisOrigen,String codLugarProd,
                                            String codPaisProc,String usoDestino);
    
}
