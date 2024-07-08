package pe.gob.senasa.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

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
import pe.gob.senasa.bean.Persona;
import pe.gob.senasa.bean.ProductoInspeccion;
import pe.gob.senasa.bean.ServicioPagos;
import pe.gob.senasa.bean.SolicitudLugarProduccion;
import pe.gob.senasa.service.IGestionVUCEService;
import pe.gob.senasa.service.IMensajesService;
import pe.gob.senasa.service.IPersonaService;
import pe.gob.senasa.service.serviceImpl.GestionVUCEService;
import pe.gob.senasa.service.serviceImpl.MensajesService;
import pe.gob.senasa.service.serviceImpl.PersonaService;


@WebService(targetNamespace = "http://documentos.ws.senasa.gob.pe")
public class GestionVUCEWS {
    IGestionVUCEService gestionVUCEService = null;
    IPersonaService personaService = null;
    IMensajesService mensajesService = null;
    String txId = null;

    public GestionVUCEWS() {
        super();
        gestionVUCEService = new GestionVUCEService();
        personaService = new PersonaService();
        mensajesService = new MensajesService();
    }


    @WebMethod
    public ConsultaTecnica obtenerDatosConsultaTecnica(@WebParam(name =
                                                                 "customTxId")
        String customTxId, @WebParam(name = "codigoCT")
        String codigoCT, @WebParam(name = "canal")
        String canal) {

        if (customTxId.equals("") || customTxId == null)
            txId = UUID.randomUUID().toString();
        else
            txId = customTxId;

        return gestionVUCEService.obtenerDatosConsultaTecnica(txId, codigoCT,
                                                              canal);
    }


    @WebMethod
    public Auditoria ingresarRespuestaConsultaTecnica(@WebParam(name =
                                                                "customTxId")
        String customTxId, @WebParam(name = "codigoCT")
        String codigoCT, @WebParam(name = "respuesta")
        String respuesta, @WebParam(name = "baseLegal")
        String baseLegal, @WebParam(name = "ucmIdRespuesta")
        String ucmIdRespuesta, @WebParam(name = "fechaRespuesta")
        Date fechaRespuesta) {

        if (customTxId.equals("") || customTxId == null)
            txId = UUID.randomUUID().toString();
        else
            txId = customTxId;

        return gestionVUCEService.ingresarRespuestaConsultaTecnica(customTxId,
                                                                   codigoCT,
                                                                   respuesta,
                                                                   baseLegal,
                                                                   ucmIdRespuesta,
                                                                   new java.sql.Date(fechaRespuesta.getTime()));
    }

    @WebMethod
    public List<AdjuntoDocumento> obtenerAdjuntos(@WebParam(name =
                                                            "codExpediente")
        String codExpediente) {
        //select * from vw_doc_informacion where doc_numero = '100600000190'
        //http://localhost:7001/gestionvucews/GestionVUCEPort?wsdl
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerAdjuntos(txId, codExpediente);
    }

    @WebMethod
    public Boolean notificarSubsanacion(@WebParam(name = "codExpediente")
        String codExpediente, @WebParam(name = "tipoNotif")
        String tipoNotif, @WebParam(name = "texto")
        String texto, @WebParam(name = "updateDocumento")
        Boolean updateDocumento) {

        txId = UUID.randomUUID().toString();
        return mensajesService.notificarMensaje(txId, codExpediente, tipoNotif,
                                                texto, updateDocumento);
    }

    @WebMethod
    public Boolean notificarPagoSuce(@WebParam(name = "codExpediente")
        String codExpediente, @WebParam(name = "tipoNotif")
        String tipoNotif, @WebParam(name = "texto")
        String texto, @WebParam(name = "updateDocumento")
        Boolean updateDocumento, @WebParam(name = "servicioPagos")
        ServicioPagos servicioPagos) {

        txId = UUID.randomUUID().toString();
        return mensajesService.notificarMensajePagoSuce(txId, codExpediente,
                                                        tipoNotif, texto,
                                                        updateDocumento,
                                                        servicioPagos);
    }

    @WebMethod
    public String recepcionResultadoPagoSuce(String txId,
                                             @WebParam(name = "codExpediente")
        String codExpediente) {
        txId = UUID.randomUUID().toString();
        return mensajesService.recepcionResultadoPagoSuce(txId, codExpediente);
    }


    @WebMethod
    public String cierreTramite(@WebParam(name = "nroExpediente")
        String nroExpediente, @WebParam(name = "idServicio")
        String idServicio, @WebParam(name = "idOrden")
        String idOrden, @WebParam(name = "documentosAdjuntos")
        DocumentosAdjuntos documentosAdjuntos) {

        txId = UUID.randomUUID().toString();
        return gestionVUCEService.cierreTramite(txId, nroExpediente,
                                                idServicio, idOrden,
                                                documentosAdjuntos);
    }
    
    @WebMethod
    public String enviarNotificacion(
        @WebParam(name = "tipoMensaje") String tipoMensaje, 
        @WebParam(name = "docTipo") String docTipo,
        @WebParam(name = "docNumero") String docNumero,
        @WebParam(name = "docCategoriaDr") String docCategoriaDr,
        @WebParam(name = "tasa") Double tasa,
        @WebParam(name = "plazo") Integer plazo,
        @WebParam(name = "docRefTipo") String docRefTipo,
        @WebParam(name = "docRefNumero") String docRefNumero,
        @WebParam(name = "texto") String texto,
        @WebParam(name = "error") String error,
        @WebParam(name = "adjuntos") DocumentosAdjuntos adjuntos)
    {
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.enviarNotificacion(txId, tipoMensaje,
                                                docTipo, docNumero,docCategoriaDr,
                                                tasa,plazo,docRefTipo,docRefNumero,texto,error,adjuntos);
    }

    @WebMethod
    public CertificadoPlantaTratamiento obtenerDatosConsultaPlantaTra(@WebParam(name =
                                                                                "codExpediente")
        String codExpediente) { //SNS029
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerDatosConsultaPlantaTra(txId,
                                                                codExpediente);
    }

    @WebMethod
    public Persona obtenerDatosPersona(@WebParam(name = "personaId")
        String personaId) {
        txId = UUID.randomUUID().toString();
        return personaService.obtenerDatosPersona(txId, personaId);
    }

    @WebMethod
    public SolicitudLugarProduccion obtenerDatosSolicitudLugarProd(@WebParam(name =
                                                                             "codExpediente")
        String codExpediente) {
        //SNS024
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerDatosSolicitudLugarProd(txId,
                                                                 codExpediente);
    }

    @WebMethod
    public ArrayList<ProductoInspeccion> obtenerDatosProductoInspeccion(@WebParam(name =
                                                                                  "codExpediente")
        String codExpediente) {
        //SNS026
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerDatosProductoInspeccion(txId,
                                                                 codExpediente);
    }

    @WebMethod
    public ArrayList<ConceptoInspeccion> obtenerDatosConceptoInspeccion(@WebParam(name =
                                                                                  "codigoConcepto")
        String codigoConcepto) {
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerDatosConceptoInspeccion(txId,
                                                                 codigoConcepto);
    }

    @WebMethod
    public ArrayList<LoteInspeccion> obtenerDatosLoteInspeccion(@WebParam(name =
                                                                          "codigoLote")
        String codigoLote) {
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerDatosLoteInspeccion(txId, codigoLote);
    }

    @WebMethod
    @WebResult(name = "DatosIIV")
    public DatosIIV obtenerDatosIIVFito(@WebParam(name = "codExpediente")
        String codExpediente) {
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerDatosIIV(txId, codExpediente, "F");
    }

    @WebMethod
    @WebResult(name = "DatosIIV")
    public DatosIIV obtenerDatosIIVZoo(@WebParam(name = "codExpediente")
        String codExpediente) {
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerDatosIIV(txId, codExpediente, "Z");
    }

    @WebMethod
    @WebResult(name = "DatosExpo")
    public DatosExpo obtenerDatosExpoFito(@WebParam(name = "codExpediente")
        String codExpediente) {
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerDatosExpoFito(txId, codExpediente);
    }

    @WebMethod
    @WebResult(name = "DatosExpo")
    public DatosExpo obtenerDatosExpoZoo(@WebParam(name = "codExpediente")
        String codExpediente) {
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerDatosExpoZoo(txId, codExpediente);
    }

    @WebMethod
    @WebResult(name = "DatosExpo")
    public DatosExpo obtenerDatosModExpoFito(@WebParam(name = "codExpediente")
        String codExpediente) {
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerDatosModExpoFito(txId, codExpediente);
    }

    @WebMethod
    @WebResult(name = "Expediente")
    public Expediente obtenerExpediente(@WebParam(name = "codigoExpediente")
        String codigoExpediente) {
        txId = UUID.randomUUID().toString();
        return gestionVUCEService.obtenerExpediente(txId, codigoExpediente);
    }
    
  @WebMethod
  public void enviarReqPagoSuce(@WebParam(name = "codigoExpediente")
      String codigoExpediente, @WebParam(name = "texto")
      String texto, @WebParam(name = "tasa")
      double tasa) {      
      mensajesService.notificarMensajeReqPagoSuce(codigoExpediente, texto, tasa);
  }
  
  @WebMethod
  public AdjuntoDocumento generarCFEFirmado(@WebParam(name = "codigoExpediente") String codigoExpediente,
                                            @WebParam(name = "ordenVUCE") String ordenVUCE,
                                            @WebParam(name = "firmante") String firmante ) {
      txId = UUID.randomUUID().toString();
      return gestionVUCEService.generarCFEFirmado(txId, codigoExpediente, ordenVUCE, firmante);
  }
  
  @WebMethod
  public void notificarProgramacionInspeccion(
        @WebParam(name="tipodocumento") String tipodocumento,
        @WebParam(name="orden") String orden,
        @WebParam(name="tasa") double tasa,
        @WebParam(name="doctiporef") String doctiporef,
        @WebParam(name="docnumeref") String docnumeref,
        @WebParam(name="textovalor") String textovalor
      ){
    txId = UUID.randomUUID().toString();
    mensajesService.notificarProgramacionInspeccion(txId, tipodocumento, orden, tasa, doctiporef, docnumeref, textovalor) ;
  }
  
}
