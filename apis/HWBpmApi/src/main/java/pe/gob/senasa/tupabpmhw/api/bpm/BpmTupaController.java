package pe.gob.senasa.tupabpmhw.api.bpm;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.senasa.tupabpmhw.api.model.Payload;

@RestController
@RequestMapping("/tupa")
public class BpmTupaController {
	
	@Autowired
	TupaTaskService service;
	
	@Autowired
	HWTaskService hwTaskService;
	
	@GetMapping
	public Payload obtenerDatos(String taskid, String token) throws Exception {		
			return service.getPayLoad(taskid, token);		
	}
	
	@PutMapping("/registrar/solicitud")
	public void registrarSolicitud(String taskid, String token, @RequestBody Payload payload) throws Exception {
		service.completarRegistrarSolicitud(taskid, token, payload);
	}
	
	@PutMapping("/registrar/requisito")
	public void registrarRequisito(String taskid,String token, @RequestBody Payload payload) throws Exception {
		service.completarRegistrarRequisito(taskid, token, payload);
	}
	
	@PutMapping("/generar/dr")
	public void generarDocumentoResolutivo(String taskid, String token, @RequestBody Payload payload) throws Exception {
		service.completarGenerarDocumentoResolutivo(taskid, token, payload);
	}
	
	@DeleteMapping("/archivar")
	public void archivar(String taskid, String token) throws Exception {
		service.archivar(taskid, token);
	}
	
	@PutMapping("/derivar")
	public void derivar(String taskid, String token, String usuario) throws Exception {
		hwTaskService.derivar(taskid, token, usuario);
	}
	
	@PutMapping("/notificar")
	public void notificar(String taskid, String token, @RequestBody Payload payload) throws Exception {
		service.completarNotificar(taskid, token, payload);
	}
	
	@PutMapping("/gestionar")
	public void gestionar(String taskid, String token, @RequestBody Payload payload) throws Exception {
		service.completarGestionar(taskid, token, payload);
	}

}
