package com.senasa.bpm.ng.controller;

import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import com.senasa.bpm.ng.model.response.ApiResponse;
import com.senasa.bpm.ng.model.response.AreaResponse;
import com.senasa.bpm.ng.model.response.ProcedimientoResponse;
import com.senasa.bpm.ng.service.DetalleService;
import com.senasa.bpm.ng.utility.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DetalleServicios")
@AllArgsConstructor
public class DetalleServiciosController {

    private final DetalleService detalleService;

    @GetMapping("/listarArea")
    public ResponseEntity<ApiResponse<List<AreaResponse>>> listarArea() {
        return ResponseEntity.ok(
                ApiResponse.<List<AreaResponse>>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(detalleService.listarArea())
                        .build());
    }
    @PostMapping("procedimientoPorArea")
    public ResponseEntity<ApiResponse<List<ProcedimientoResponse>>> procedimientoPorArea(@RequestBody ProcedimientoRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<ProcedimientoResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(detalleService.listarProcedimiento(request))
                .build());

    }



}
