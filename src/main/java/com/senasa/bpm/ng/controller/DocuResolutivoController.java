package com.senasa.bpm.ng.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.FinalizarProcesoRequest;
import com.senasa.bpm.ng.model.request.GrabarDocHijoRequest;
import com.senasa.bpm.ng.model.request.GrabarDocumentoSTDRequest;
import com.senasa.bpm.ng.model.request.GrabarObservacionRequest;
import com.senasa.bpm.ng.model.request.GrabarResolutivoCierreRequest;
import com.senasa.bpm.ng.model.request.GrabarResolutivoRequest;
import com.senasa.bpm.ng.model.request.RegistrarFirmaEmpleadoRequest;
import com.senasa.bpm.ng.model.request.ValidarBoletaRequest;
import com.senasa.bpm.ng.model.request.ValidarPendientePagoRequest;
import com.senasa.bpm.ng.model.response.AgregarDocuResponse;
import com.senasa.bpm.ng.model.response.ApiResponse;
import com.senasa.bpm.ng.model.response.ArchivarResponse;
import com.senasa.bpm.ng.model.response.DerivacionPersonalResponse;
import com.senasa.bpm.ng.model.response.DetalleDerivacionResponse;
import com.senasa.bpm.ng.model.response.FirmarCerrarExpedienteResponse;
import com.senasa.bpm.ng.model.response.GrabarDocHijoResponse;
import com.senasa.bpm.ng.model.response.GrabarDocumentoSTDResponse;
import com.senasa.bpm.ng.model.response.GrabarResolutivoCierreResponse;
import com.senasa.bpm.ng.model.response.GrabarResolutivoResponse;
import com.senasa.bpm.ng.model.response.InformacionExpedienteResponse;
import com.senasa.bpm.ng.model.response.ObtenerDocuResponse;
import com.senasa.bpm.ng.model.response.ObtenerInfoAdjuntosResponse;
import com.senasa.bpm.ng.model.response.ReqDocSalidaResponse;
import com.senasa.bpm.ng.model.response.ValidarExpedienteResponse;
import com.senasa.bpm.ng.model.response.ValidarPendientePagoResponse;
import com.senasa.bpm.ng.service.DocuResolutivoService;
import com.senasa.bpm.ng.service.RequisitoService;
import com.senasa.bpm.ng.utility.ConstantUtil;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/docuResolutivo")
@AllArgsConstructor
public class DocuResolutivoController {

    private final DocuResolutivoService docuResolutivoService;
    private final RequisitoService requisitoService;
 



    @GetMapping("/obtenerDerivacion/{nombrePersona}")
    public ResponseEntity<ApiResponse<List<DerivacionPersonalResponse>>> listarPersona (@PathVariable String nombrePersona) {
        System.out.println("nombrePersona: "+nombrePersona);
        return ResponseEntity.ok(ApiResponse.<List<DerivacionPersonalResponse>>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(docuResolutivoService.listarPersona(nombrePersona))
                        .build());
    }
    @GetMapping("detalle/{pcodexpediente}")
    public ResponseEntity<ApiResponse<List<DetalleDerivacionResponse>>> listarDetalleDerivacion (@PathVariable String pcodexpediente) {
        System.out.println("detalleDerivacion: "+pcodexpediente);
        return ResponseEntity.ok(ApiResponse.<List<DetalleDerivacionResponse>>builder()
            .code(ConstantUtil.OK_CODE)
            .message(ConstantUtil.OK_MESSAGE)
            .data(docuResolutivoService.listarDetalleDerivacion(pcodexpediente))
            .build());
    }

    @GetMapping("/agregar/{documentoResolutivo}")
    public ResponseEntity<ApiResponse<List<AgregarDocuResponse>>> listarDocumento (@PathVariable String documentoResolutivo) {
        System.out.println("nombrePersona: "+documentoResolutivo);
        return ResponseEntity.ok(ApiResponse.<List<AgregarDocuResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(docuResolutivoService.listarDocumento(documentoResolutivo))
                .build());
    }

    @GetMapping("/informacionExpediente/{p_Codigo_Expediente}")
    public ResponseEntity<ApiResponse<List<InformacionExpedienteResponse>>> obtenerCodigoExpediente (@PathVariable String p_Codigo_Expediente) {
        System.out.println("informacionPersona: " + p_Codigo_Expediente);
        return ResponseEntity.ok(ApiResponse.<List<InformacionExpedienteResponse>>builder()
            .code(ConstantUtil.OK_CODE)
            .message(ConstantUtil.OK_MESSAGE)
            .data(docuResolutivoService.obtenerCodigoExpediente(p_Codigo_Expediente))
            .build());
    }

    @GetMapping("/obtener/{documentoPresen}")
    public ResponseEntity<ApiResponse<List<ObtenerDocuResponse>>> obtenerDocumentoPresen (@PathVariable String documentoPresen) {
        System.out.println("nombrePersona: " + documentoPresen);
        return ResponseEntity.ok(ApiResponse.<List<ObtenerDocuResponse>>builder()
            .code(ConstantUtil.OK_CODE)
            .message(ConstantUtil.OK_MESSAGE)
            .data(docuResolutivoService.obtenerDocumentoPresen(documentoPresen))
            .build());
    }


    @PostMapping("archivar")
    public ResponseEntity<ApiResponse<List<ArchivarResponse>>> archivar(@RequestBody ArchivarRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<ArchivarResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(requisitoService.archivar(request))
                .build());

    }
    @GetMapping("firmarCerrarExpediente/{codexpediente}")
    public ResponseEntity<ApiResponse<List<FirmarCerrarExpedienteResponse>>> firmarCerrarExpediente (@PathVariable String codexpediente) {
        return ResponseEntity.ok(ApiResponse.<List<FirmarCerrarExpedienteResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(docuResolutivoService.firmarCerrarExpediente(codexpediente))
                .build());

    	
		
    }
    @PostMapping("grabarObservacion")
    public ResponseEntity<ApiResponse<String>> observacion(@RequestBody GrabarObservacionRequest request) {
    	//public ResponseEntity<ApiResponse<List<GrabarObservacionResponse>>> observacion(@RequestBody GrabarObservacionRequest request) {
    	//return ResponseEntity.ok(ApiResponse.<List<GrabarObservacionResponse>>builder()
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(docuResolutivoService.grabarObservacion(request))
                .build());


    }
    @PostMapping("grabarDocHijo")
    public ResponseEntity<ApiResponse<List<GrabarDocHijoResponse>>> grabarDocHijo(@RequestBody GrabarDocHijoRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<GrabarDocHijoResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(docuResolutivoService.grabarDocHijo(request))
                .build());

    }
    @PostMapping("grabarResolutivo")
    public ResponseEntity<ApiResponse<List<GrabarResolutivoResponse>>> grabarResolutivo(@RequestBody GrabarResolutivoRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<GrabarResolutivoResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(docuResolutivoService.grabarResolutivo(request))
                .build());

    }
    @PostMapping("grabarResolutivoCierre")
    public ResponseEntity<ApiResponse<List<GrabarResolutivoCierreResponse>>> grabarResolutivoCierre(@RequestBody GrabarResolutivoCierreRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<GrabarResolutivoCierreResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(docuResolutivoService.grabarResolutivoCierre(request))
                .build());

    }
    @GetMapping("obtenerInfoAdjuntos/{p_ucmid}")
    public ResponseEntity<ApiResponse<List<ObtenerInfoAdjuntosResponse>>> obtenerInfoAdjuntos(@PathVariable String p_ucmid) {
        System.out.println("obtenerInfoAdjuntos: "+p_ucmid);
        return ResponseEntity.ok(ApiResponse.<List<ObtenerInfoAdjuntosResponse>>builder()
            .code(ConstantUtil.OK_CODE)
            .message(ConstantUtil.OK_MESSAGE)
            .data(docuResolutivoService.obtenerInfoAdjuntos(p_ucmid))
            .build());
    }
    @GetMapping("reqDocSalida/{pcodexpediente}")
    public ResponseEntity<ApiResponse<List<ReqDocSalidaResponse>>> reqDocSalida(@PathVariable String pcodexpediente) {
        System.out.println("reqDocSalida: "+pcodexpediente);
        return ResponseEntity.ok(ApiResponse.<List<ReqDocSalidaResponse>>builder()
            .code(ConstantUtil.OK_CODE)
            .message(ConstantUtil.OK_MESSAGE)
            .data(docuResolutivoService.reqDocSalida(pcodexpediente))
            .build());
    }
    @PostMapping("grabarDocumentoSTD")
    public ResponseEntity<ApiResponse<List<GrabarDocumentoSTDResponse>>> grabarDocumentoSTD (@RequestBody GrabarDocumentoSTDRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<GrabarDocumentoSTDResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(docuResolutivoService.grabarDocumentoSTD(request))
                .build());
    }
    @PostMapping("firmarEmpleado/{pcodigoexpediente}/{codigoemplper}")
    public ResponseEntity<ApiResponse<String>> registrarFirmaEmpleado(@PathVariable String pcodigoexpediente, @PathVariable String codigoemplper) {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(docuResolutivoService.registrarFirmaEmpleado(pcodigoexpediente, codigoemplper))
                .build());

    }
    @GetMapping("validarPendientePago/{codigoexpediente}")
    public ResponseEntity<ApiResponse<List<ValidarPendientePagoResponse>>> validarPendientePago(@PathVariable String codigoexpediente) {
        return ResponseEntity.ok(ApiResponse.<List<ValidarPendientePagoResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(docuResolutivoService.validarPendientePago(codigoexpediente))
                .build());

    }
    @PostMapping("registrarFirmaEmpleado")
    public ResponseEntity<ApiResponse<String>> registrarFirmaEmpleados(@RequestBody RegistrarFirmaEmpleadoRequest request) {
    	return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(docuResolutivoService.registrarFirmaEmpleados(request))
                .build());


    }


}

