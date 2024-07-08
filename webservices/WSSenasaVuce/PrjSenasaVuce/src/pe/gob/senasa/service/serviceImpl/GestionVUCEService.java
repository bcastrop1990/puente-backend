package pe.gob.senasa.service.serviceImpl;

import com.stellent.cis.client.command.CommandException;

import java.io.IOException;

import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.jws.WebParam;

import javax.xml.bind.DatatypeConverter;
import javax.xml.ws.WebServiceRef;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Adjunto;
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
import pe.gob.senasa.bean.SolicitudLugarProduccion;
import pe.gob.senasa.dao.IGestionVUCEDao;
import pe.gob.senasa.dao.daoImpl.GestionVUCEDao;
import pe.gob.senasa.service.IGestionVUCEService;
import pe.gob.senasa.service.IPersonaService;

import pe.gob.senasa.ucm.ClienteUCM;

import proxy.firma.xml.Firmarxml_Service;

import proxy.senasaws.tramite.DocumentoSTD;
import proxy.senasaws.tramite.TramiteDocumentario_Service;

import proxy.softnet.firma.xml.Firmarxml;

public class GestionVUCEService implements IGestionVUCEService {
    protected static Logger logger = Logger.getLogger(GestionVUCEService.class);
    IGestionVUCEDao gestionVUCEDao = null;
    IPersonaService personaService = null;
        
    private static String TIPO_FIRMA_SOFTNET_XMLPEG = "361640";
    private static String TIPO_FIRMA_SOFTNET_XMLPING = "361631";
  

    public GestionVUCEService() {
        super();
        gestionVUCEDao = new GestionVUCEDao();
        personaService = new PersonaService();
    }

    public List<AdjuntoDocumento> obtenerAdjuntos(String txId,
                                                  String codExpediente) {
        return gestionVUCEDao.obtenerAdjuntos(txId, codExpediente);
    }

    public ConsultaTecnica obtenerDatosConsultaTecnica(String txId,
                                                       String codigoCT,
                                                       String canal) {
        return gestionVUCEDao.obtenerDatosConsultaTecnica(txId, codigoCT,
                                                          canal);
    }

    public Auditoria ingresarRespuestaConsultaTecnica(String txId,
                                                      String codigoCT,
                                                      String respuesta,
                                                      String baseLegal,
                                                      String ucmIdRespuesta,
                                                      Date fechaRespuesta) {
        return gestionVUCEDao.ingresarRespuestaConsultaTecnica(txId, codigoCT,
                                                               respuesta,
                                                               baseLegal,
                                                               ucmIdRespuesta,
                                                               fechaRespuesta);
    }

    public String enviarNotificacion(String txId, String tipoMensaje,
                                     String docTipo, String docNumero,
                                     String docCategoriaDr, Double tasa,
                                     Integer plazo, String docRefTipo,
                                     String docRefNumero, String texto,
                                     String error,
                                     DocumentosAdjuntos adjuntos) {
        return gestionVUCEDao.enviarNotificacion(txId, tipoMensaje, docTipo,
                                                 docNumero, docCategoriaDr,
                                                 tasa, plazo, docRefTipo,
                                                 docRefNumero, texto, error,
                                                 adjuntos);
    }

    public String cierreTramite(String txId, String nroExpediente,
                                String idServicio, String idOrden,
                                DocumentosAdjuntos documentosAdjuntos) {
        return gestionVUCEDao.cierreTramite(txId, nroExpediente, idServicio,
                                            idOrden, documentosAdjuntos);
    }

    public CertificadoPlantaTratamiento obtenerDatosConsultaPlantaTra(String txId,
                                                                      String codExpediente) {
        return gestionVUCEDao.obtenerDatosConsultaPlantaTra(txId,
                                                            codExpediente);
    }

    public SolicitudLugarProduccion obtenerDatosSolicitudLugarProd(String txId,
                                                                   String codExpediente) {
        return gestionVUCEDao.obtenerDatosSolicitudLugarProd(txId,
                                                             codExpediente);
    }

    public ArrayList<ProductoInspeccion> obtenerDatosProductoInspeccion(String txId,
                                                                        String codExpediente) {
        return gestionVUCEDao.obtenerDatosProductoInspeccion(txId,
                                                             codExpediente);
    }

    public ArrayList<ConceptoInspeccion> obtenerDatosConceptoInspeccion(String txId,
                                                                        String codigoConcepto) {
        return gestionVUCEDao.obtenerDatosConceptoInspeccion(txId,
                                                             codigoConcepto);
    }

    public ArrayList<LoteInspeccion> obtenerDatosLoteInspeccion(String txId,
                                                                String codigoLote) {
        return gestionVUCEDao.obtenerDatosLoteInspeccion(txId, codigoLote);
    }

    public DatosIIV obtenerDatosIIV(String txId, String codExpediente,
                                    String tipo) {
        DatosIIV datosIIV =
            gestionVUCEDao.obtenerDatosIIV(txId, codExpediente, tipo);
        if (datosIIV.getSolicitante().getPersonaId() != null &&
            datosIIV.getSolicitante().getPersonaId() != "") {
            Persona solicitante =
                personaService.obtenerDatosPersona(txId, datosIIV.getSolicitante().getPersonaId());
            if (solicitante != null && solicitante.getPersonaId() != null) {
                datosIIV.setSolicitante(solicitante);
            }
        }
        if (datosIIV.getAgente().getPersonaId() != null &&
            datosIIV.getAgente().getPersonaId() != "") {
            Persona agenteAdn =
                personaService.obtenerDatosPersona(txId, datosIIV.getAgente().getPersonaId());
            if (agenteAdn != null && agenteAdn.getPersonaId() != null) {
                datosIIV.setAgente(agenteAdn);
            }
        }
        return datosIIV;
    }

    public DatosExpo obtenerDatosExpoFito(String txId, String codExpediente) {
        DatosExpo datosExpoFito =
            gestionVUCEDao.obtenerDatosExpoFito(txId, codExpediente);
        if (datosExpoFito.getSolicitante().getPersonaId() != null &&
            datosExpoFito.getSolicitante().getPersonaId() != "") {
            Persona solicitante =
                personaService.obtenerDatosPersona(txId, datosExpoFito.getSolicitante().getPersonaId());
            if (solicitante != null && solicitante.getPersonaId() != null) {
                datosExpoFito.setSolicitante(solicitante);
            }
        }
        if (datosExpoFito.getAgente().getPersonaId() != null &&
            datosExpoFito.getAgente().getPersonaId() != "") {
            Persona agenteAdn =
                personaService.obtenerDatosPersona(txId, datosExpoFito.getAgente().getPersonaId());
            if (agenteAdn != null && agenteAdn.getPersonaId() != null) {
                datosExpoFito.setAgente(agenteAdn);
            }
        }
        return datosExpoFito;
    }

    public DatosExpo obtenerDatosModExpoFito(String txId,
                                             String codExpediente) {
        DatosExpo datosExpoFito =
            gestionVUCEDao.obtenerDatosModExpoFito(txId, codExpediente);
        if (datosExpoFito.getSolicitante().getPersonaId() != null &&
            datosExpoFito.getSolicitante().getPersonaId() != "") {
            Persona solicitante =
                personaService.obtenerDatosPersona(txId, datosExpoFito.getSolicitante().getPersonaId());
            if (solicitante != null && solicitante.getPersonaId() != null) {
                datosExpoFito.setSolicitante(solicitante);
            }
        }
        if (datosExpoFito.getAgente().getPersonaId() != null &&
            datosExpoFito.getAgente().getPersonaId() != "") {
            Persona agenteAdn =
                personaService.obtenerDatosPersona(txId, datosExpoFito.getAgente().getPersonaId());
            if (agenteAdn != null && agenteAdn.getPersonaId() != null) {
                datosExpoFito.setAgente(agenteAdn);
            }
        }
        return datosExpoFito;
    }

    public DatosExpo obtenerDatosExpoZoo(String txId, String codExpediente) {
        DatosExpo datosExpoZoo =
            gestionVUCEDao.obtenerDatosExpoZoo(txId, codExpediente);
        if (datosExpoZoo.getSolicitante().getPersonaId() != null &&
            datosExpoZoo.getSolicitante().getPersonaId() != "") {
            Persona solicitante =
                personaService.obtenerDatosPersona(txId, datosExpoZoo.getSolicitante().getPersonaId());
            if (solicitante != null && solicitante.getPersonaId() != null) {
                datosExpoZoo.setSolicitante(solicitante);
            }
        }
        if (datosExpoZoo.getAgente().getPersonaId() != null &&
            datosExpoZoo.getAgente().getPersonaId() != "") {
            Persona agenteAdn =
                personaService.obtenerDatosPersona(txId, datosExpoZoo.getAgente().getPersonaId());
            if (agenteAdn != null && agenteAdn.getPersonaId() != null) {
                datosExpoZoo.setAgente(agenteAdn);
            }
        }
        return datosExpoZoo;
    }

    public Expediente obtenerExpediente(String txId, String codigoExpediente) {
        return gestionVUCEDao.obtenerExpediente(txId, codigoExpediente);
    }
    
    public AdjuntoDocumento generarCFEFirmado(String txId, String codigoExpediente, String ordenVUCE, String firmante) {
        AdjuntoDocumento documento = new AdjuntoDocumento();
        try {
            // LLAMAR DAO PROCEDURE BYTE[]
            // LLAMAR FIRMA SAETA
            String params = gestionVUCEDao.obtenerPasswordFirmante(firmante);
            String passFirmante = params.split("]]]")[0];            
            logger.info("passFirmante: " + passFirmante);
            String ucmidFirmante = params.split("]]]")[1];
            //String ucmidFirmante = "01046205";
            logger.info("ucmidFirmante: " + ucmidFirmante);
            /*String signerDN = params.split("]]]")[2];
            logger.info("signerDN: " + signerDN);*/
            Adjunto doc = gestionVUCEDao.obtenerCertificadoXML(txId, codigoExpediente);
            logger.info("codigoPais: " + doc.getAuditoria().getTxId());
            logger.info("docAdjunto: "+doc.getAdjunto());
            if (doc.getAuditoria().getErrorCode()!= null && doc.getAuditoria().getErrorCode()!="") {
                documento.setEstado("ERROR");
                logger.info("Documento Estado: ERROR");
                //ERROR
            } else {
                if (doc.getAdjunto()== null || doc.getAdjunto().length==0) {
                    // NO APLICA
                    documento.setEstado("NO_APLICA");
                    logger.info("Documento Estado: NO APLICA");
                } else {
                    String titulo = "CEV (XML)-" + codigoExpediente + "-";
                    logger.info("titulo: " + titulo);
                    DocumentoSTD docStd = new DocumentoSTD();
                    docStd.setNombre(titulo);
                    docStd.setEscenario("INTERNO");
                    logger.info("docStd.setEscenario: INTERNO");
                    docStd.setTipo("OTRS");
                    logger.info("docStd.setTipo: OTRS");
                    docStd.setSubTipo("OTRS");
                    logger.info("docStd.setSubTipo: OTRS");
                    docStd.setAutor(firmante);
                    logger.info("docStd.setAutor: " + firmante);
                    docStd.setAutorId(firmante);
                    logger.info("docStd.setAutorId: " + firmante);
                    docStd.setConfidencial("N");
                    logger.info("docStd.setConfidencial: N");
                    TramiteDocumentario_Service tramService = new TramiteDocumentario_Service();
                    String codDocumento = tramService.getTramiteDocumentarioPort().registrarDocumento(docStd, firmante);
                    titulo = "CEV (XML)-" + codigoExpediente + "-" + codDocumento;
                    byte[] firmado = doc.getAdjunto();
                    String paisDestino = doc.getAuditoria().getTxId();
                    String tipoFirma = doc.getAuditoria().getErrorMsg();
                                        
                    if("AP".equals(paisDestino)){
                      Firmarxml_Service serv = new Firmarxml_Service();
                      firmado = serv.getFirmarxmlPort().firmar(null, passFirmante, doc.getAdjunto(), "", "", "", ucmidFirmante,1);
                    }else if("EPHYTO".equals(paisDestino)){
                        if("XMLPEG".equals(tipoFirma)){
                          firmado = firmarXmlSoftnet(firmado, TIPO_FIRMA_SOFTNET_XMLPEG); 
                        }else if("XMLPING".equals(tipoFirma)){
                          firmado = firmarXmlSoftnet(firmado, TIPO_FIRMA_SOFTNET_XMLPING);                           
                        }
                    }
                    // SUBIR A UCM
                    Hashtable<String, String> metadatos = new Hashtable<String, String>();
                    metadatos.put("xProfileTrigger", "TUPA-OTRS");
                    String dDocname = ClienteUCM.getInstance().registrarDocumento(null, titulo, "TUPA", "OTRS", "Interno", "STD", metadatos, titulo + ".xml", firmado);
                    documento.setNombre(titulo);
                    logger.info("titulo: " + titulo);
                    documento.setUcmId(dDocname);
                    logger.info("documento.setUcmId: " + dDocname);
                    try {
                        docStd.setNombre(titulo);
                        docStd.setUcmId(dDocname);
                        tramService.getTramiteDocumentarioPort().actualizarDocumento(docStd, firmante);
                    } catch (Exception e) {
                        logger.error("Actualizar Documento Exception: ",e);                        
                    }
                    //Registrar CEV XML
                    gestionVUCEDao.registrarCertificadoXML(txId, codigoExpediente, ordenVUCE, firmado);
                }
            }
        } catch (MalformedURLException e) {
            logger.error("MalformedURLException: ", e);            
        } catch (CommandException e) {
            logger.error("CommandException: ", e);
        } catch (IOException e) {
            logger.error("IOException: ", e);
        } catch (Exception e) {
            logger.error("Exception: ", e);
        }
        return documento;
    }
    
    private byte[] firmarXmlSoftnet(byte[] xmlToSign, String tipoFirma) throws UnsupportedEncodingException {
      String certificado = DatatypeConverter.printBase64Binary(new String(xmlToSign, "UTF-8").getBytes("ISO-8859-1"));        
      proxy.softnet.firma.xml.Firmarxml_Service firmarxml_Service = new proxy.softnet.firma.xml.Firmarxml_Service();
      Firmarxml firmarxml = firmarxml_Service.getFirmarxmlPort();
      String xmlFirmado = firmarxml.firmar(certificado, null, null, null, tipoFirma);      
      return DatatypeConverter.parseBase64Binary(xmlFirmado);
    }
}
