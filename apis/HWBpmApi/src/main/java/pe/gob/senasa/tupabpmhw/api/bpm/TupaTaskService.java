package pe.gob.senasa.tupabpmhw.api.bpm;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.dom.DOMResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;

import oracle.bpel.services.workflow.task.model.HTGenerarDocumentoResolutivoPayloadType;
import oracle.bpel.services.workflow.task.model.HTGestionarExpedientePayloadType;
import oracle.bpel.services.workflow.task.model.HTRegistrarRequisitoPayloadType;
import oracle.bpel.services.workflow.task.model.HTResgistrarSolicitudPayloadType;
import pe.gob.senasa.soa.service.org.procedimiento.proceso_procedimiento_tupa_v1.DocumentoAdjunto;
import pe.gob.senasa.soa.service.org.procedimiento.proceso_procedimiento_tupa_v1.Procedimiento;
import pe.gob.senasa.tupabpmhw.api.model.Payload;
import pe.gob.senasa.tupabpmhw.api.model.Tarea;

@Service
public class TupaTaskService {
	
	@Autowired
	HWTaskService service;
						
	public Payload getPayLoad(String idTarea, String token) throws Exception {
		Payload payload = null;
		Tarea tarea = service.getTarea(token, idTarea);
		
		if(tarea != null && tarea.getPayload() != null) {
			
			payload = new Payload();
			ElementNSImpl e1 = (ElementNSImpl) tarea.getPayload();
	        			
	        if(e1.getElementsByTagName("numeroSolicitud") != null
	        	&& e1.getElementsByTagName("numeroSolicitud").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("numeroSolicitud").item(0);
	        	payload.setNumeroSolicitud(node.getTextContent());
	        }
	        
	        if(e1.getElementsByTagName("numeroExpediente") != null
	        	&& e1.getElementsByTagName("numeroExpediente").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("numeroExpediente").item(0);
	        	payload.setNumeroExpediente(node.getTextContent());
	        }
	        
	        if(e1.getElementsByTagName("estadoSolicitud") != null
	        	&& e1.getElementsByTagName("estadoSolicitud").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("estadoSolicitud").item(0);
	        	payload.setEstadoSolicitud(node.getTextContent());
	        }
	        
	        if(e1.getElementsByTagName("estadoExpediente") != null
	        	&& e1.getElementsByTagName("estadoExpediente").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("estadoExpediente").item(0);
	        	payload.setEstadoExpediente(node.getTextContent());
	        }
	        
	        if(e1.getElementsByTagName("codigoSede") != null
	        	&& e1.getElementsByTagName("codigoSede").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("codigoSede").item(0);
	        	payload.setCodigoSede(node.getTextContent());
	        }
	        
	        if(e1.getElementsByTagName("codigoCentroTramite") != null
	        	&& e1.getElementsByTagName("codigoCentroTramite").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("codigoCentroTramite").item(0);
	        	payload.setCodigoCentroTramite(node.getTextContent());
	        }
	        
	        if(e1.getElementsByTagName("codigoProcedimiento") != null
	        	&& e1.getElementsByTagName("codigoProcedimiento").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("codigoProcedimiento").item(0);
	        	payload.setCodigoProcedimiento(node.getTextContent());
	        }
	        
	        if(e1.getElementsByTagName("codigoClase") != null
	        	&& e1.getElementsByTagName("codigoClase").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("codigoClase").item(0);
	        	payload.setCodigoClase(node.getTextContent());
	        }
	        
	        if(e1.getElementsByTagName("flagRequiereInspeccion") != null
	        	&& e1.getElementsByTagName("flagRequiereInspeccion").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("flagRequiereInspeccion").item(0);
	        	payload.setFlagRequiereInspeccion("true".equals(node.getTextContent()));
	        }
	        
	        if(e1.getElementsByTagName("flagModificacionCertificado") != null
	        	&& e1.getElementsByTagName("flagModificacionCertificado").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("flagModificacionCertificado").item(0);
	        	payload.setFlagModificacionCertificado("true".equals(node.getTextContent()));
	        }
	        
	        if(e1.getElementsByTagName("canal") != null
	        	&& e1.getElementsByTagName("canal").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("canal").item(0);
	        	payload.setCanal(node.getTextContent() != null && !node.getTextContent().isEmpty() ? Integer.valueOf(node.getTextContent()) : 0);
	        }
	        
	        if(e1.getElementsByTagName("usuarioMesaPartes") != null
	        	&& e1.getElementsByTagName("usuarioMesaPartes").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("usuarioMesaPartes").item(0);
	        	payload.setUsuarioMesaPartes(node.getTextContent());
	        }
	        
	        if(e1.getElementsByTagName("usuarioResponsable") != null
	        	&& e1.getElementsByTagName("usuarioResponsable").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("usuarioResponsable").item(0);
	        	payload.setUsuarioResponsable(node.getTextContent());
	        }
	        
	        if(e1.getElementsByTagName("codigoRecibo") != null
	        	&& e1.getElementsByTagName("codigoRecibo").getLength() > 0) {
	        	Node node = e1.getElementsByTagName("codigoRecibo").item(0);
	        	payload.setCodigoRecibo(node.getTextContent());
	        }
			
		}
		
		return payload;
	}
			
	public void completarRegistrarSolicitud(String idTarea, String token, Payload payload) throws Exception {		
		HTResgistrarSolicitudPayloadType humanTaskPayload = new HTResgistrarSolicitudPayloadType();
		Procedimiento proc = getProcedimientoWraper(payload);
		humanTaskPayload.setProcedimiento(proc);    	
		DOMResult result = serializar(humanTaskPayload);
		completarTarea(idTarea, token, "SUBMIT", result, true);
	}
	
	public void completarRegistrarRequisito(String idTarea, String token, Payload payload) throws Exception {	
		HTRegistrarRequisitoPayloadType humanTaskPayload = new HTRegistrarRequisitoPayloadType();
		Procedimiento proc = getProcedimientoWraper(payload);
		humanTaskPayload.setProcedimiento(proc);    	
		DOMResult result = serializar(humanTaskPayload);
		completarTarea(idTarea, token, "APPROVE", result, true);
	}
	
	public void completarGenerarDocumentoResolutivo(String idTarea, String token, Payload payload) throws Exception {		
		HTGenerarDocumentoResolutivoPayloadType humanTaskPayload = new HTGenerarDocumentoResolutivoPayloadType();
		Procedimiento proc = getProcedimientoWraper(payload);
		humanTaskPayload.setProcedimiento(proc);    
		DOMResult result = serializar(humanTaskPayload);
		completarTarea(idTarea, token, "APPROVE", result, true);
	}
			
	public void archivar(String idTarea, String token) throws Exception {
		completarTarea(idTarea, token, "REJECT", null, false);
	}
	
	public void completarNotificar(String idTarea, String token, Payload payload) throws Exception {		
		HTGenerarDocumentoResolutivoPayloadType humanTaskPayload = new HTGenerarDocumentoResolutivoPayloadType();
		Procedimiento proc = getProcedimientoWraper(payload);
		humanTaskPayload.setProcedimiento(proc);    
		DOMResult result = serializar(humanTaskPayload);
		completarTarea(idTarea, token, "NOTIFICAR", result, true);
	}
	
	public void completarGestionar(String idTarea, String token, Payload payload) throws Exception {		
		HTGestionarExpedientePayloadType humanTaskPayload = new HTGestionarExpedientePayloadType();
		Procedimiento proc = getProcedimientoWraper(payload);
		humanTaskPayload.setProcedimiento(proc);    	
		DOMResult result = serializar(humanTaskPayload);
		completarTarea(idTarea, token, "SUBMIT", result, true);
	}
	
	private void completarTarea(String idTarea, String token, String resultado, DOMResult payload, boolean update) throws Exception {
		
		service.completeTarea(token, idTarea, resultado, payload, update);
	}
	
	private DOMResult serializar(Object humanTaskPayload) throws JAXBException {    					
        JAXBContext jaxbContext = JAXBContext.newInstance(humanTaskPayload.getClass());
        Marshaller marshall = jaxbContext.createMarshaller();
        marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        DOMResult dom = new DOMResult();
        marshall.marshal(humanTaskPayload, dom);
        return dom;
    }
	
	private Procedimiento getProcedimientoWraper(Payload pay) {
        Procedimiento proc = new Procedimiento();
        proc.setNumeroSolicitud(pay.getNumeroSolicitud());
        proc.setNumeroExpediente(pay.getNumeroExpediente());
        proc.setEstadoSolicitud(pay.getEstadoSolicitud());
        proc.setEstadoExpediente(pay.getEstadoExpediente());
        proc.setCodigoSede(pay.getCodigoSede());
        proc.setCodigoCentroTramite(pay.getCodigoCentroTramite());
        proc.setCodigoProcedimiento(pay.getCodigoProcedimiento());
        proc.setCodigoClase(pay.getCodigoClase());
        proc.setFlagRequiereInspeccion(pay.isFlagRequiereInspeccion());
        proc.setFlagModificacionCertificado(pay.isFlagModificacionCertificado());
        proc.setCanal(pay.getCanal());
        proc.setUsuarioMesaPartes(pay.getUsuarioMesaPartes());
        proc.setUsuarioResponsable(pay.getUsuarioResponsable());
        proc.setCodigoRecibo(pay.getCodigoRecibo());
        proc.setCodigoStdDoc(pay.getCodigostddoc());
        proc.setDescripcionServicio(pay.getDescripcionservicio());
        proc.setNombreResponsable(pay.getNombreResponsable());
        proc.setSecuencial(pay.getSecuencial());
        proc.setPlazo(pay.getPlazo());
        proc.setAreaRemitente(pay.getAreaRemitente() == null ? "" : pay.getAreaRemitente());
        proc.setSubAreaRemitente(pay.getSubAreaRemitente() == null ? "" : pay.getSubAreaRemitente());
        proc.setUsuarioDestinatario(pay.getUsuarioDestinatario() == null ? "" : pay.getUsuarioDestinatario());
        proc.setNombreDestinatario(pay.getNombreDestinatario() == null ? "" : pay.getNombreDestinatario());
        proc.setAreaDestinatario(pay.getAreaDestinatario() == null ? "" : pay.getAreaDestinatario());
        proc.setSubAreaDestinatario(pay.getSubAreaDestinatario() == null ? "" : pay.getSubAreaDestinatario());
        proc.setObservaciones(pay.getObservaciones() == null ? "" : pay.getObservaciones());
        proc.setUcmidDerivacion(pay.getUcmidDerivacion() == null ? "" : pay.getUcmidDerivacion());
        proc.setCfeUcmId(pay.getCfeUcmId() == null ? "" : pay.getCfeUcmId());
        proc.setCfeNombre(pay.getCfeNombre() == null ? "" : pay.getCfeNombre());
        proc.setDocumentosAdjuntos(new ArrayList<DocumentoAdjunto>());
        if(pay.getDocumentos() != null && pay.getDocumentos().size() > 0) {
        	pay.getDocumentos().forEach(doc -> {
        		DocumentoAdjunto adj = new DocumentoAdjunto();
        		adj.setNombre(doc.getNombre());
        		adj.setUcmid(doc.getUcmid());
        		proc.getDocumentosAdjuntos().add(adj);
        	});
        }
        
        return proc;
    }
		
}
