package com.senasa.bpm.ng.controller;
import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.response.ApiResponse;
import com.senasa.bpm.ng.service.RequisitoService;
import com.senasa.bpm.ng.service.SeguridadService;
import com.senasa.bpm.ng.utility.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/seguridad")
@AllArgsConstructor
public class SeguridadController {
    private final SeguridadService seguridadService;

    @GetMapping("/validarConexion/{p_Usuario}/{p_Password}")
    public ResponseEntity<ApiResponse<BigDecimal>> validarConexion(@PathVariable String p_Usuario,
                                                                         @PathVariable String p_Password) {
        return ResponseEntity.ok(ApiResponse.<BigDecimal>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(seguridadService.validarConexion(p_Usuario, p_Password))
                .build());
    }
}
