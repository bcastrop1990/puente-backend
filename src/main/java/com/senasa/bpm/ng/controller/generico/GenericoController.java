package com.senasa.bpm.ng.controller.generico;

import java.util.List;
import org.springframework.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import com.senasa.bpm.ng.model.bean.GrabarInactivoBean;
import com.senasa.bpm.ng.model.bean.TipoDocumentoBean;
import com.senasa.bpm.ng.model.generico.*;
import com.senasa.bpm.ng.model.response.ApiResponse;
import com.senasa.bpm.ng.service.generico.IGenericoService;
import com.senasa.bpm.ng.utility.ConstantUtil;
import com.senasa.bpm.ng.service.*;

@RestController
//@RequestMapping("/genericos")
@AllArgsConstructor
public class GenericoController {

	@Autowired
	IGenericoService genericoService;

	@Autowired
	DatosSolicitanteService datosSolicitanteService;

	@GetMapping("/listarSolicitante")
	public ResponseEntity<ApiResponse<List<Solicitante>>> listarSolicitanteRZ(
			@RequestParam(required = true) String rz) {
		return ResponseEntity.ok(ApiResponse.<List<Solicitante>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.listarSolicitanteRZ(rz)).build());
	}

	@GetMapping("/listarFabricante")
	public ResponseEntity<ApiResponse<List<Solicitante>>> listarFabricanteRZ(@RequestParam(required = true) String rz) {
		return ResponseEntity.ok(ApiResponse.<List<Solicitante>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.listarSolicitanteRZ(rz)).build());
	}

	@GetMapping("/listarDepartamento")
	public ResponseEntity<ApiResponse<List<Ubigeo>>> listarDepartamento() {
		return ResponseEntity.ok(ApiResponse.<List<Ubigeo>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.listarDepartamento()).build());
	}

	@GetMapping("/listarProvincia")
	public ResponseEntity<ApiResponse<List<Ubigeo>>> listarProvincia(
			@RequestParam(required = true) long idDepartamento) {
		return ResponseEntity.ok(ApiResponse.<List<Ubigeo>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.listarProvincia(idDepartamento)).build());
	}

	@GetMapping("/listarDistrito")
	public ResponseEntity<ApiResponse<List<Ubigeo>>> listarDistrito(@RequestParam(required = true) long idProvincia) {
		return ResponseEntity.ok(ApiResponse.<List<Ubigeo>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.listarDistrito(idProvincia)).build());
	}

	@GetMapping("/listarPais")
	public ResponseEntity<ApiResponse<List<Ubigeo>>> listarPais() {
		return ResponseEntity.ok(ApiResponse.<List<Ubigeo>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.listarPais()).build());
	}

	@GetMapping("/obtenerResponsable")
	public ResponseEntity<ApiResponse<List<Solicitante>>> listarResponsable(
			@RequestParam(required = true) String documento) {
		return ResponseEntity.ok(ApiResponse.<List<Solicitante>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.obtenerResponsable(documento)).build());
	}

	@GetMapping("/formaFarmaceutica")
	public ResponseEntity<ApiResponse<List<FormaFarmaceutica>>> listarFormaFarmaceutica(
			@RequestParam(required = true) String documento) {
		return ResponseEntity.ok(ApiResponse.<List<FormaFarmaceutica>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.listarformaFarmaceutica()).build());
	}

	@GetMapping("/clasificacionFarmaceutica")
	public ResponseEntity<ApiResponse<List<ClasificacionFarmaceutica>>> listarClasificacionFarmaceutica(
			@RequestParam(required = true) String documento) {
		return ResponseEntity.ok(ApiResponse.<List<ClasificacionFarmaceutica>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.listarclasificacionFarmaceutica()).build());
	}

	@GetMapping("/viaFormaFarmaceutica")
	public ResponseEntity<ApiResponse<List<ViaFormaFarmaceutica>>> listarViaFormaFarmaceutica(
			@RequestParam(required = true) String documento) {
		return ResponseEntity.ok(ApiResponse.<List<ViaFormaFarmaceutica>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.listarViaFormaFarmaceutica()).build());
	}

	@GetMapping("/especies")
	public ResponseEntity<ApiResponse<List<Especie>>> listarEspecies(@RequestParam(required = true) String documento) {
		return ResponseEntity.ok(ApiResponse.<List<Especie>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.listarEspecie()).build());
	}

	@PostMapping("/fabricante")
	public ResponseEntity<ApiResponse<List<Fabricante>>> buscarFabricante(@RequestBody Fabricante fabricante) {
		return ResponseEntity
				.ok(ApiResponse.<List<Fabricante>>builder().code(ConstantUtil.OK_CODE).message(ConstantUtil.OK_MESSAGE)
						.data(genericoService.buscarFabricante(fabricante.getNombre())).build());
	}

	@PostMapping("/responsableTecnico")
	public ResponseEntity<ApiResponse<List<ResponsableTecnico>>> buscarTesponsableTecnico(
			@RequestBody ResponsableTecnico responsableTecnico) {
		return ResponseEntity.ok(ApiResponse.<List<ResponsableTecnico>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE)
				.data(genericoService.buscarResponsableTecnico(responsableTecnico.getIdResponsableTecnico())).build());
	}

	@PostMapping("/solicitanteConsulta")
	public ResponseEntity<ApiResponse<List<SolicitanteConsulta>>> buscarSolicitanteConsulta(
			@RequestBody SolicitanteConsulta solicitanteConsulta) {
		return ResponseEntity.ok(ApiResponse.<List<SolicitanteConsulta>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE)
				.data(genericoService.buscarSolicitante(solicitanteConsulta.getTipoDocumento(),
						solicitanteConsulta.getNumeroDocumento(), solicitanteConsulta.getNombreRazonSocial(), "VET"))
				.build());
	}

	@PostMapping("/centroTramitePersona")
	public ResponseEntity<ApiResponse<List<CentroTramitePersona>>> buscarCentroTramitePersona(
			@RequestBody CentroTramitePersona centroTramitePersona) {
		return ResponseEntity.ok(ApiResponse.<List<CentroTramitePersona>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE)
				.data(genericoService.buscarCentroTramitePersona(centroTramitePersona.getPersonaId())).build());
	}

	@PostMapping("/procedimientoservicio")
	public ResponseEntity<ApiResponse<List<Procedimientoservicio>>> buscarProcedimientoservicio(
			@RequestBody Procedimientoservicio procedimientoservicio) {
		return ResponseEntity.ok(ApiResponse.<List<Procedimientoservicio>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE)
				.data(genericoService.buscarProcedimientoservicio(procedimientoservicio)).build());
	}

	@PostMapping("/servicioprocedimiento")
	public ResponseEntity<ApiResponse<List<Servicioprocedimiento>>> buscarServicioprocedimiento(
			@RequestBody Servicioprocedimiento servicioprocedimiento) {
		return ResponseEntity.ok(ApiResponse.<List<Servicioprocedimiento>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE)
				.data(genericoService.buscarServicioprocedimiento(servicioprocedimiento)).build());
	}

	@PostMapping("/calcularTarifa")
	public ResponseEntity<ApiResponse<Tarifario>> buscarServicioprocedimiento(@RequestBody Tarifario tarifario) {
		return ResponseEntity.ok(ApiResponse.<Tarifario>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.obtenerTarifa(tarifario)).build());
	}

	@PostMapping("/solicitudregistroproductosveterinarios")
	public ResponseEntity<ApiResponse<GrabarInactivoBean>> RegistrarSolicitudRegistroProductosVeterinarios(
			@RequestBody SolicitudRegistroProductosVeterinarios solicitudRegistroProductosVeterinarios) {
		return ResponseEntity.ok(ApiResponse.<GrabarInactivoBean>builder()
				.code(ConstantUtil.OK_CODE).message(ConstantUtil.OK_MESSAGE)
				.data(genericoService
						.RegistrarSolicitudRegistroProductosVeterinarios(solicitudRegistroProductosVeterinarios))
				.build());
	}

	@PostMapping("/solicitudrenovacionproductosveterinarios")
	public ResponseEntity<ApiResponse<SolicitudRenovacionProductosVeterinarios>> RenovacionSolicitudRegistroProductosVeterinarios(
			@RequestBody SolicitudRegistroProductosVeterinarios solicitudRegistroProductosVeterinarios) {
		SolicitudRenovacionProductosVeterinarios solicitudRenovacionProductosVeterinarios = new SolicitudRenovacionProductosVeterinarios();
		solicitudRenovacionProductosVeterinarios.setP_COD_EXPEDIENTE(solicitudRegistroProductosVeterinarios.getCodigoExpediente());
		return ResponseEntity.ok(ApiResponse.<SolicitudRenovacionProductosVeterinarios>builder()
				.code(ConstantUtil.OK_CODE).message(ConstantUtil.OK_MESSAGE)
				.data(genericoService
						.RegistrarSolicitudRenovacionProductosVeterinarios(solicitudRenovacionProductosVeterinarios))
				.build());
	}

	@PostMapping("/obtenerInformacionExpedienteRecibo")
	public ResponseEntity<ApiResponse<List<Comprobante>>> buscarComprobante(@RequestBody Comprobante comprobante) {
		return ResponseEntity.ok(ApiResponse.<List<Comprobante>>builder().code(ConstantUtil.OK_CODE)
				.message(ConstantUtil.OK_MESSAGE).data(genericoService.buscarComprobante(comprobante)).build());
	}

	@PostMapping("/reciboServLab")
	public ResponseEntity<ApiResponse<List<ReciboServFito>>> buscarDetalleReciboAnalisisFito(
			@RequestBody ReciboServFito reciboServFito) {
		return ResponseEntity.ok(
				ApiResponse.<List<ReciboServFito>>builder().code(ConstantUtil.OK_CODE).message(ConstantUtil.OK_MESSAGE)
						.data(genericoService.buscarDetalleReciboAnalisisFito(reciboServFito)).build());
	}

}
