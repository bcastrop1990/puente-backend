package com.senasa.bpm.ng.controller;

import com.senasa.bpm.ng.model.response.*;
import com.senasa.bpm.ng.service.ObservacionService;
import com.senasa.bpm.ng.utility.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observacion")
@AllArgsConstructor
public class ObservacionController {

    private final ObservacionService observacionesService;


    @GetMapping("/historico/{pcodexpediente}")
    public ResponseEntity<ApiResponse<List<ObservacionResponse>>> obtenerDetalleTrazabilidad (@PathVariable String pcodexpediente) {
        return ResponseEntity.ok(ApiResponse.<List<ObservacionResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(observacionesService.obtenerListaHistorico(pcodexpediente))
                .build());
    }

}
