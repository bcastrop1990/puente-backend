package com.senasa.bpm.ng.controller;

import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import com.senasa.bpm.ng.model.response.*;
import com.senasa.bpm.ng.service.ConceptoPagoService;
import com.senasa.bpm.ng.service.GrabarService;
import com.senasa.bpm.ng.utility.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conceptoPago")
@AllArgsConstructor
public class ConceptoPagoController {
    private final ConceptoPagoService conceptoPagoService;

    @GetMapping("/listarBanco")
    public ResponseEntity<ApiResponse<List<BancoResponse>>> listarBanco() {
        return ResponseEntity.ok(
                ApiResponse.<List<BancoResponse>>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(conceptoPagoService.listarBanco())
                        .build());
    }
    @GetMapping("/listarTipoPago")
    public ResponseEntity<ApiResponse<List<TipoPagoResponse>>> listarTipoPago() {
        return ResponseEntity.ok(
                ApiResponse.<List<TipoPagoResponse>>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(conceptoPagoService.listarTipoPago())
                        .build());
    }

}
