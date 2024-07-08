package com.senasa.bpm.ng.controller;

import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
import com.senasa.bpm.ng.model.response.*;
import com.senasa.bpm.ng.service.ConceptoPagoService;
import com.senasa.bpm.ng.service.ConceptosService;
import com.senasa.bpm.ng.service.GrabarService;
import com.senasa.bpm.ng.utility.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/conceptos")
@AllArgsConstructor
public class ConceptosController {

    private final ConceptosService conceptosService;
    private final ConceptoPagoService conceptoPagoService;
    private final GrabarService grabarService;

    @PostMapping("listarServicios")
    public ResponseEntity<ApiResponse<List<ListarServiciosResponse>>> ListarServicios(@RequestBody ListarProcedimientoRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<ListarServiciosResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(conceptosService.listarServicios(request))
                .build());
    }
    @PostMapping("/calcularMontoConcepto")
    public ResponseEntity<ApiResponse<BigDecimal>> calcularMontoConcepto(@RequestBody CalcularMontoRequest request) {
        return ResponseEntity.ok(ApiResponse.<BigDecimal>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(conceptoPagoService.calcularMontoConcepto(request))
                .build());
    }
    @PostMapping("/calcularMontoMinimo")
    public ResponseEntity<ApiResponse<String>> calcularMontoMinimo(@RequestBody CalcularMontoRequest request) {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(conceptoPagoService.calcularMontoMinimo(request))
                .build());
    }
    //BOTON ACEPTAR
    @GetMapping("validarExpediente/{pcodexpediente}")
    public ResponseEntity<ApiResponse<List<ValidarExpedienteResponse>>> validarExpediente(@PathVariable String pcodexpediente) {
        return ResponseEntity.ok(ApiResponse.<List<ValidarExpedienteResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(grabarService.validarExpediente(pcodexpediente))
                .build());

    }
}
