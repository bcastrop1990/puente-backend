package pe.gob.senasa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;

import pe.gob.senasa.bean.AdjuntoDocumento;
import pe.gob.senasa.bean.Auditoria;
import pe.gob.senasa.bean.CertificadoPlantaTratamiento;
import pe.gob.senasa.bean.ConceptoInspeccion;
import pe.gob.senasa.bean.ConsultaTecnica;
import pe.gob.senasa.bean.DatosExpo;
import pe.gob.senasa.bean.DatosIIV;
import pe.gob.senasa.bean.DocumentosAdjuntos;
import pe.gob.senasa.bean.Expediente;
import pe.gob.senasa.bean.LoteInspeccion;
import pe.gob.senasa.bean.ProductoInspeccion;
import pe.gob.senasa.bean.SolicitudLugarProduccion;


public interface IGestionVUCEService {

    public List<AdjuntoDocumento> obtenerAdjuntos(String txId,
                                                  String codExpediente);

    public ConsultaTecnica obtenerDatosConsultaTecnica(String txId,
                                                       String codigoCT,
                                                       String canal);

    public Auditoria ingresarRespuestaConsultaTecnica(String txId,
                                                      String codigoCT,
                                                      String respuesta,
                                                      String baseLegal,
                                                      String ucmIdRespuesta,
                                                      Date fechaRespuesta);

    public String cierreTramite(String txId, String nroExpediente,
                                String idServicio, String idOrden,
                                DocumentosAdjuntos documentosAdjuntos);

    public String enviarNotificacion(String txId, String tipoMensaje,
                                     String docTipo, String docNumero,
                                     String docCategoriaDr, Double tasa,
                                     Integer plazo, String docRefTipo,
                                     String docRefNumero, String texto,
                                     String error,
                                     DocumentosAdjuntos adjuntos);

    public CertificadoPlantaTratamiento obtenerDatosConsultaPlantaTra(String txId,
                                                                      String codExpediente);

    public SolicitudLugarProduccion obtenerDatosSolicitudLugarProd(String txId,
                                                                   String codExpediente);

    public ArrayList<ProductoInspeccion> obtenerDatosProductoInspeccion(String txId,
                                                                        String codExpediente);

    public ArrayList<ConceptoInspeccion> obtenerDatosConceptoInspeccion(String txId,
                                                                        String codigoConcepto);

    public ArrayList<LoteInspeccion> obtenerDatosLoteInspeccion(String txId,
                                                                String codigoLote);

    public DatosIIV obtenerDatosIIV(String txId, String codExpediente,
                                    String tipo);

    public DatosExpo obtenerDatosExpoFito(String txId, String codExpediente);

    public DatosExpo obtenerDatosExpoZoo(String txId, String codExpediente);

    public DatosExpo obtenerDatosModExpoFito(String txId,
                                             String codExpediente);

    public Expediente obtenerExpediente(String txId, String codigoExpediente);
    
    public AdjuntoDocumento generarCFEFirmado(String txId, String codigoExpediente, String ordenVUCE, String firmante);

}
