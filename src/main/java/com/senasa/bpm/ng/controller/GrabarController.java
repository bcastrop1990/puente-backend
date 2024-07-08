package com.senasa.bpm.ng.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senasa.bpm.ng.model.request.AgregarPersonaRequest;
import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.GrabarActReciboRequest;
import com.senasa.bpm.ng.model.request.GrabarInactivoRequest;
import com.senasa.bpm.ng.model.request.GrabarSolRequest;
import com.senasa.bpm.ng.model.request.ServicioAdicionalRequest;
import com.senasa.bpm.ng.model.request.ValidarBoletaRequest;
import com.senasa.bpm.ng.model.response.ApiResponse;
import com.senasa.bpm.ng.model.response.ArchivarResponse;
import com.senasa.bpm.ng.model.response.GrabarActReciboResponse;
import com.senasa.bpm.ng.model.response.GrabarInactivoResponse;
import com.senasa.bpm.ng.model.response.GrabarSolicitudResponse;
import com.senasa.bpm.ng.service.GrabarService;
import com.senasa.bpm.ng.service.RequisitoService;
import com.senasa.bpm.ng.utility.ConstantUtil;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/grabar")
@AllArgsConstructor
public class GrabarController {

    private final GrabarService grabarService;
    private final RequisitoService requisitoService;


    @PostMapping("solicitud")
    public ResponseEntity<ApiResponse<List<GrabarSolicitudResponse>>> solicitud(@RequestBody GrabarSolRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<GrabarSolicitudResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(grabarService.grabarSolicitud(request))
                .build());

    }
    @PostMapping("inactivo")
    public ResponseEntity<ApiResponse<List<GrabarInactivoResponse>>> inactivo(@RequestBody GrabarInactivoRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<GrabarInactivoResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(grabarService.grabarInactivo(request))
                .build());

    }
    @PostMapping("servicio-adicional")
    public ResponseEntity<ApiResponse<String>> servicioAdicional(@RequestBody ServicioAdicionalRequest request) {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(grabarService.servicioAdicional(request))
                .build());

    }
    @PostMapping("actualizarRecibo")
    public ResponseEntity<ApiResponse<List<GrabarActReciboResponse>>> actualizarRecibo(@RequestBody GrabarActReciboRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<GrabarActReciboResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(grabarService.grabarActRecibo(request))
                .build());

    }
    @PostMapping("/validarBoleta")
    public ResponseEntity<ApiResponse<String>> validarBoleta(@RequestBody ValidarBoletaRequest request) {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(grabarService.validarBoleta(request))
                .build());
    }
    @PostMapping("/agregarPersona")
    public ResponseEntity<ApiResponse<String>> agregarPersona(@RequestBody AgregarPersonaRequest request) {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(grabarService.agregarPersona(request))
                .build());
    }
    @PostMapping("finalizar")
    public ResponseEntity<ApiResponse<List<ArchivarResponse>>> archivar(@RequestBody ArchivarRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<ArchivarResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(requisitoService.archivar(request))
                .build());

    }

}
