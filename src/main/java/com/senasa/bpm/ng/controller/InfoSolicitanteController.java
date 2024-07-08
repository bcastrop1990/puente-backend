package com.senasa.bpm.ng.controller;

import com.senasa.bpm.ng.model.request.DniVuceRequest;
import com.senasa.bpm.ng.model.request.PersonaPorDocumentoResponse;
import com.senasa.bpm.ng.model.response.ApiResponse;
import com.senasa.bpm.ng.model.response.PersonaPorDocVuceResponse;
import com.senasa.bpm.ng.service.InfoSolicitanteService;
import com.senasa.bpm.ng.utility.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/infoSolicitante")
@AllArgsConstructor
public class InfoSolicitanteController {

    private final InfoSolicitanteService infoSolicitanteService;


    @PostMapping("obtenerPersonaDocVUCE")
    public ResponseEntity<ApiResponse<List<PersonaPorDocVuceResponse>>> obtenerPersonaDocVUCE(@RequestBody DniVuceRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<PersonaPorDocVuceResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(infoSolicitanteService.obtenerPeronaPorDocVuce(request))
                .build());
    }

    @PostMapping("obtenerPersonaPorDocumento")
    public ResponseEntity<ApiResponse<List<PersonaPorDocumentoResponse>>> obtenerPersonaPorDocumento(@RequestBody DniVuceRequest request) {
        return ResponseEntity.ok(ApiResponse.<List<PersonaPorDocumentoResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(infoSolicitanteService.obtenerPersonaPorDocumento(request))
                .build());

    }
}

