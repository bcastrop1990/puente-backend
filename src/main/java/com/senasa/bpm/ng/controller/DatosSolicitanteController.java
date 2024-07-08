package com.senasa.bpm.ng.controller;

import com.senasa.bpm.ng.model.request.DniVuceRequest;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import com.senasa.bpm.ng.model.request.ValidarBoletaRequest;
import com.senasa.bpm.ng.model.response.*;
import com.senasa.bpm.ng.service.DatosSolicitanteService;
import com.senasa.bpm.ng.utility.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datosSolicitante")
@AllArgsConstructor
public class DatosSolicitanteController {

    private final DatosSolicitanteService datosSolicitanteService;

    @GetMapping("/listarTipoDocumento")
    public ResponseEntity<ApiResponse<List<TipoDocumentoResponse>>> listarTipoDocumento() {
        return ResponseEntity.ok(
                ApiResponse.<List<TipoDocumentoResponse>>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(datosSolicitanteService.listarTipodocumento())
                        .build());
    }


    @GetMapping("/datos/{representanteLegal}")
    public ResponseEntity<ApiResponse<List<RepresentanteLegalResponse>>> listarRepresentanteLegal (@PathVariable String representanteLegal) {
        System.out.println("nombrePersona: "+representanteLegal);
        return ResponseEntity.ok(ApiResponse.<List<RepresentanteLegalResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(datosSolicitanteService.listarRepresentanteLegal(representanteLegal))
                .build());
    }








}
