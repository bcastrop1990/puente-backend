package pe.gob.senasa.interfaces;

import java.util.ArrayList;

import pe.gob.senasa.bean.CertificadoExpoFito;
import pe.gob.senasa.bean.ProcedimientosEspecificosProductoExpoFito;
import pe.gob.senasa.bean.SIIMF;
import pe.gob.senasa.bean.SolicitudExportacion;
import pe.gob.senasa.bean.VariedadProducto;
import pe.gob.senasa.dao.RequisitoDao;


public interface PermisoFitoSanitarioExportacionInterface {
  
  public boolean validarAnalisisTratamientoRequisitosExpoFito();
  
  public boolean validarNumeroCertificadoPlantaTratamientoEmpaque(int numeroCertificadoPlantaTratamientoEmpaque);
    
  public void obtenerPuntosLlegadaExportacionPorPais(String paisDestino);
  
  public void obtenerVariedadCultivar();
  
  public void obtenerMarcaDistintiva();

  public void obtenerCaminoProductoExpoFito();

  public ProcedimientosEspecificosProductoExpoFito obtenerProcedimientosEspecificosProductoExpoFito(String codigoProducto,String codigoPaisDestino,String codigoDepartamento);

  public boolean servicioSIIMFLugarProduccionEmpacadoraCertificada();

  public boolean servicioAnalisisLaboratorio();

  public boolean servicioPagoReembolso(int  NumeroCertificadoNoEmitido);

  public boolean validarTicketBalanza();

  public boolean servicioSIIMFProcedimientosEspecificos();
  
  public ArrayList<SolicitudExportacion> obtenerSolicitudExportacion(String codigoCertificado);
  
  public ArrayList<RequisitoDao> obtenerRequisitosSanitariosExpoFito(String codigoProducto, String codigoAplicacion,
                                                                     String paisProcedencia, String paisesOrigen, 
                                                                     String lugaresProduccion);
  
  public ArrayList<VariedadProducto> obtenerVariedadExportacion(String codigoProducto);
  
  public CertificadoExpoFito consultaCertificadoExpoFitoXNumeroExpediente(String numeroExpediente);
  
  public boolean ejecutarSIIMF(SIIMF siimf);
  
  public SIIMF respuestaSIIMF(String numeroExpediente);
  
  public String registrarCertificadoFitosanitarioImpoFito(CertificadoExpoFito certificadoExpoFito);
  
}
