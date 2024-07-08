package pe.gob.senasa.interfaces;

import java.util.ArrayList;

import pe.gob.senasa.bean.ConsultaReporte;
import pe.gob.senasa.bean.ResultadoConsultaReporte;
import pe.gob.senasa.bean.Trazabilidad;


public interface GeneralInterface {
  public String generaNumeroExpediente(String codigoExpedienteTMP, String userName );
  public String generaNumeroSolicitud(String codigoProceso, String codigoInstanciaBPM, String canal, String userName);
  public void insertarTrazabilidad(Trazabilidad trazabilidad);
  public void actualizarTrazabilidad(Trazabilidad trazabilidad);
  public String guardarExpedienteTemporal(String codigoExpediente, String codigoSolicitud, String codigoServicio, String dniRuc, String sede, String observacion, String userName);
  public byte[] consultaTrazaMensaje(String codigoExpediente, String codigoServicio);
  public String obtenerCaducidad(String fechaInicio, Double dias, Double horas, Double minutos);
  public String registrarServiciosExp(String codigoExpediente, String codigoSolicitud, String codigoSede, String userName, String codigosServicios);
  public ArrayList<ResultadoConsultaReporte>  consultaGeneral(ConsultaReporte consultaReporte);
  public ArrayList<ResultadoConsultaReporte>  consultaDocumentosPendientes(ConsultaReporte consultaReporte);
  public ArrayList<ResultadoConsultaReporte>  reporteNumeroDerivaciones(ConsultaReporte consultaReporte);
  public ArrayList<ResultadoConsultaReporte>  reporteDocumentosNoAtendidos(ConsultaReporte consultaReporte);
  public String obtenerNombreServicio(String codigoServicio);
}
