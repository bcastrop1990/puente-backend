package pe.gob.senasa.ws;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.AdjuntoDocumentoVuce;
import pe.gob.senasa.bean.Guardacustodia;
import pe.gob.senasa.bean.PermisoFitosanitarioTransitoInterno;
import pe.gob.senasa.bean.ResultadoConsultaReporte;
import pe.gob.senasa.bean.Trazabilidad;
import pe.gob.senasa.dao.GeneralDAO;
import pe.gob.senasa.interfaces.GeneralInterface;


@XmlSeeAlso({Trazabilidad.class,ResultadoConsultaReporte.class,pe.gob.senasa.bean.ConsultaReporte.class})
@WebService(name = "General",serviceName = "General",
            targetNamespace = "http://general.ws.senasa.gob.pe",
            portName = "GeneralPort")
public class GeneralWS implements GeneralInterface
{
    
  GeneralDAO gDAO = null;
  String txId = null;
  public GeneralWS() {
        gDAO = new GeneralDAO();
        
        
  }
    
  @WebMethod  
  public String generaNumeroExpediente(String codigoExpedienteTMP, String userName ) {
    return gDAO.generaNumeroExpediente(codigoExpedienteTMP, userName );
  }
  
  @WebMethod
  public String generaNumeroSolicitud(String codigoProceso, String codigoInstanciaBPM, String canal, String userName){
    return gDAO.generaNumeroSolicitud(codigoProceso, codigoInstanciaBPM, canal, userName);
  }
  
  @WebMethod
    public void insertarTrazabilidad(Trazabilidad trazabilidad){
        gDAO.insertarTrazabilidad(trazabilidad);
  }
  
  @WebMethod
    public void actualizarTrazabilidad(Trazabilidad trazabilidad){
        gDAO.actualizarTrazabilidad(trazabilidad);
  }
  
  @WebMethod
    public void  actualizarCodigoProcTupaCPE(String pcodexpediente,String ordenvuce, String codproctupa){
        gDAO.actualizarCodigoProcTupaCPE(pcodexpediente,ordenvuce,codproctupa);
  }
 
  
  @WebMethod
  public String guardarExpedienteTemporal(String codigoExpediente, String codigoSolicitud, String codigoServicio, String dniRuc, String sede, String observacion, String userName) {
    return gDAO.guardarExpedienteTemporal(codigoExpediente, codigoSolicitud, codigoServicio, dniRuc, sede, observacion, userName);
  }
  @WebMethod
  public byte[] consultaTrazaMensaje(String codigoExpediente, String codigoServicio) {
    return gDAO.consultaTrazaMensaje(codigoExpediente, codigoServicio);
  }
  @WebMethod
  public String obtenerCaducidad(String fechaInicio, Double dias, Double horas, Double minutos){
    return gDAO.obtenerCaducidad(fechaInicio, dias, horas, minutos);
  }
  @WebMethod
  public String registrarServiciosExp(String codigoExpediente, String codigoSolicitud, String codigoSede, String userName, String codigosServicios){
    return gDAO.registrarServiciosExp(codigoExpediente, codigoSolicitud, codigoSede, userName, codigosServicios);
  }

  @WebMethod
  public ArrayList<ResultadoConsultaReporte> consultaGeneral(pe.gob.senasa.bean.ConsultaReporte consultaReporte) {
        return gDAO.consultaGeneral(consultaReporte);
  }

  @WebMethod
  public ArrayList<ResultadoConsultaReporte> consultaDocumentosPendientes(pe.gob.senasa.bean.ConsultaReporte consultaReporte) {
        return gDAO.consultaDocumentosPendientes(consultaReporte);
  }
 
  @WebMethod
  public ArrayList<ResultadoConsultaReporte> reporteNumeroDerivaciones(pe.gob.senasa.bean.ConsultaReporte consultaReporte) {
        return gDAO.reporteNumeroDerivaciones(consultaReporte);
  }

  @WebMethod
  public ArrayList<ResultadoConsultaReporte> reporteDocumentosNoAtendidos(pe.gob.senasa.bean.ConsultaReporte consultaReporte) {
        return gDAO.reporteDocumentosNoAtendidos(consultaReporte);
  }
    
  @WebMethod
  public String obtenerNombreServicio(String codigoServicio){
      return gDAO.obtenerNombreServicio(codigoServicio);
  }
  
  @WebMethod
  public Integer verificarEstadoPermiso(String numPermiso){
      return gDAO.verificarEstadoPermiso(numPermiso);
  }
  @WebMethod
  public String obtenerFechaAmpliacion(String fechaIni,String tipo,int dias ){
      return gDAO.obtenerFechaAmpliacion(fechaIni, tipo, dias);
  }
  ///////////////////// SERVICIOS VUCE /////////////////////
  @WebMethod
  public Guardacustodia obtenerDatosGuardacustodia(String nroExpediente){
      return gDAO.obtenerDatosGuardacustodia(nroExpediente);
  }
  
  @WebMethod
  public PermisoFitosanitarioTransitoInterno obtenerDatosPFTI(String nroExpediente){
      return gDAO.obtenerDatosPFTI(nroExpediente);
  }
  
  @WebMethod
  public List<AdjuntoDocumentoVuce> obtenerAdjuntosVuce(@WebParam(name="numeroOrden") String numeroOrden) {
      //select * from vw_doc_informacion where doc_numero = '100600000190'
      //http://localhost:7001/gestionvucews/GestionVUCEPort?wsdl
      txId = UUID.randomUUID().toString();
      return gDAO.obtenerAdjuntosVuce(numeroOrden);
  }
  
  @WebMethod
  public PermisoFitosanitarioTransitoInterno cargarDatosPFTI(String nroExpediente){
      return gDAO.cargarDatosPFTI(nroExpediente);
  }

  @WebMethod
  public String obtenerUcmidPorExpediente( @WebParam(name="nroExpediente") String nroExpediente ){
    txId = UUID.randomUUID().toString();
    return gDAO.obtenerUcmidPorExpediente(nroExpediente);
  }
  
  @WebMethod
  public int ValidarConfidencial( @WebParam(name="Codigo") String Codigo,@WebParam(name="Usuario") String Usuario  ){

    return gDAO.ValidarConfidencial(Codigo, Usuario);
  }
  
  @WebMethod
    public String obtenerPasswordFirmante(@WebParam(name="codiusuausu") String codiusuausu)
    {
      this.txId = UUID.randomUUID().toString();
      return gDAO.obtenerPasswordFirmante(codiusuausu);
    }
  @WebMethod
    public String createQR(@WebParam(name="data") String data)
    {
      this.txId = UUID.randomUUID().toString();
      return gDAO.createQR(data);
    }
  
}