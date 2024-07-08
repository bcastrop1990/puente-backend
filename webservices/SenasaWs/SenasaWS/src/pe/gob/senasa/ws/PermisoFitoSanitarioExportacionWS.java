package pe.gob.senasa.ws;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.AnexoPFI;
import pe.gob.senasa.bean.CertificadoExpoFito;
import pe.gob.senasa.bean.LugarProduccionAnexoPFI;
import pe.gob.senasa.bean.LugarProduccionProductoPFI;
import pe.gob.senasa.bean.PaisOrigenAnexoPFI;
import pe.gob.senasa.bean.PaisOrigenProductoPFI;
import pe.gob.senasa.bean.ProcedimientosEspecificosProductoExpoFito;
import pe.gob.senasa.bean.ProductoPFI;
import pe.gob.senasa.bean.PuntoIngresoAnexoPFI;
import pe.gob.senasa.bean.PuntoIngresoProductoPFI;
import pe.gob.senasa.bean.SIIMF;
import pe.gob.senasa.bean.SolicitudExportacion;
import pe.gob.senasa.bean.VariedadProducto;
import pe.gob.senasa.dao.PermisoFitoSanitarioExportacionDAO;
import pe.gob.senasa.dao.RequisitoDao;
import pe.gob.senasa.interfaces.PermisoFitoSanitarioExportacionInterface;


/**
 * Manejo de información y operaciones de exportación fitosanitaria.
 */
@XmlSeeAlso( { Date.class, java.util.ArrayList.class, ProductoPFI.class,LugarProduccionProductoPFI.class,LugarProduccionProductoPFI.class,
               AnexoPFI.class,PuntoIngresoAnexoPFI.class,PaisOrigenProductoPFI.class,PuntoIngresoProductoPFI.class,LugarProduccionAnexoPFI.class,PaisOrigenAnexoPFI.class,ProcedimientosEspecificosProductoExpoFito.class})

@WebService(name = "PermisoFitosanitarioExportacion",serviceName = "PermisoFitosanitarioExportacion",
            targetNamespace = "http://permisofitosanitarioexportacion.ws.senasa.gob.pe",
            portName = "PermisoFitosanitarioExportacionPort")
public class PermisoFitoSanitarioExportacionWS implements PermisoFitoSanitarioExportacionInterface {
    /**
     */
    
    PermisoFitoSanitarioExportacionDAO sDAO  = null;
    public PermisoFitoSanitarioExportacionWS() {
      sDAO = new PermisoFitoSanitarioExportacionDAO();
    }

    /**
     * 
     * status: Pendiente por construccion
     * @return
     */
    public boolean guardarRequisitoFitosanitarioImpoFito() {
        return false;
    }

    /**
     * 
     * status: Pendiente por construccion
     * @return
     */
    public boolean validarAnalisisTratamientoRequisitosExpoFito() {
        return false;
    }

    /**
     * 
     * status: Pendiente por construccion
     * @param numeroCertificadoPlantaTratamientoEmpaque
     * @return
     */
    public boolean validarNumeroCertificadoPlantaTratamientoEmpaque(int numeroCertificadoPlantaTratamientoEmpaque) {
        return false;
    }

    /**
     * 
     * status: Pendiente por construccion
     * @param paisDestino
     */
    public void obtenerPuntosLlegadaExportacionPorPais(String paisDestino) {
    }

    /**
     * 
     * status: Pendiente por construccion
     */
    public void obtenerVariedadCultivar() {
    }

    /**
     * 
     * status: Pendiente por construccion
     */
    public void obtenerMarcaDistintiva() {
    }

    /**
     * 
     * status: Pendiente por construccion
     */
    public void obtenerCaminoProductoExpoFito() {
    }


    /**
     * 
     * status: Pendiente por construccion
     * @return
     */
    public boolean servicioSIIMFLugarProduccionEmpacadoraCertificada() {
        return false;
    }

    /**
     * 
     * status: Pendiente por construccion
     * @return
     */
    public boolean servicioAnalisisLaboratorio() {
        return false;
    }

    /**
     * 
     * status: Pendiente por construccion
     * @param NumeroCertificadoNoEmitido
     * @return
     */
    public boolean servicioPagoReembolso(int NumeroCertificadoNoEmitido) {
        return false;
    }

    /**
     * 
     * status: Pendiente por construccion
     * @return
     */
    public boolean validarTicketBalanza() {
        return false;
    }

    /**
     * 
     * status: Pendiente por construccion
     * @return
     */
    public boolean servicioSIIMFProcedimientosEspecificos() {
        return false;
    }
    
    @WebMethod
    public ArrayList<SolicitudExportacion> obtenerSolicitudExportacion(String codigoCertificado){
       return sDAO.obtenerSolicitudExportacion(codigoCertificado);
    }
    
    @WebMethod  
    public ArrayList<RequisitoDao> obtenerRequisitosSanitariosExpoFito(@WebParam(name = "aCodProductos") String codigoProducto, @WebParam(name = "codAplicacion")String codigoAplicacion,
                                                                        @WebParam(name = "codPaisProcedencia") String paisProcedencia, @WebParam(name = "aCodPaisOrg")String paisesOrigen, 
                                                                        @WebParam(name = "aCodLugProduccion") String lugaresProduccion){
       return sDAO.obtenerRequisitosSanitariosExpoFito(codigoProducto, codigoAplicacion, paisProcedencia, paisesOrigen, lugaresProduccion);                                                               
       
    }
  
    @WebMethod 
    public ArrayList<VariedadProducto> obtenerVariedadExportacion(String codigoProducto){
     return sDAO.obtenerVariedadExportacion(codigoProducto);
   }

    @WebMethod  
    public ProcedimientosEspecificosProductoExpoFito obtenerProcedimientosEspecificosProductoExpoFito(String codigoProducto,
                                                                                                      String codigoPaisDestino,
                                                                                                      String codigoDepartamento) {
        return sDAO.obtenerProcedimientosEspecificosProductoExpoFito(codigoProducto, codigoPaisDestino, codigoDepartamento);
    }

    @WebMethod
    public CertificadoExpoFito consultaCertificadoExpoFitoXNumeroExpediente(String numeroExpediente) {
        return sDAO.consultaCertificadoExpoFitoXNumeroExpediente(numeroExpediente);
    }

    @WebMethod
    public boolean ejecutarSIIMF(SIIMF siimf) {
        return sDAO.ejecutarSIIMF(siimf);
    }

    @WebMethod
    public SIIMF respuestaSIIMF(String numeroExpediente) {
        return sDAO.respuestaSIIMF(numeroExpediente);
    }

    @WebMethod
    public String registrarCertificadoFitosanitarioImpoFito(CertificadoExpoFito certificadoExpoFito) {
        return sDAO.registrarCertificadoFitosanitarioImpoFito(certificadoExpoFito);
    }
    
    @WebMethod
    public String obtenerRutaSIIMF(@WebParam(name="codProducto") String codProducto, @WebParam(name="codPaisOrigen") String codPaisOrigen){
        return sDAO.obtenerRutaSIIMF(codProducto,codPaisOrigen);    
    }
    
}
