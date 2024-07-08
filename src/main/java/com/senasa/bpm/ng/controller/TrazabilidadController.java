package com.senasa.bpm.ng.controller;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senasa.bpm.ng.model.bean.DerivacionTraza;
import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
import com.senasa.bpm.ng.model.request.TrazabilidadRequest;
import com.senasa.bpm.ng.model.response.ApiResponse;
import com.senasa.bpm.ng.model.response.ListarServiciosResponse;
import com.senasa.bpm.ng.model.response.PersonaPorDocVuceResponse;
import com.senasa.bpm.ng.model.response.TrazabilidadResponse;
import com.senasa.bpm.ng.model.response.ValidarExpedienteResponse;
import com.senasa.bpm.ng.service.ConceptoPagoService;
import com.senasa.bpm.ng.service.ConceptosService;
import com.senasa.bpm.ng.service.GrabarService;
import com.senasa.bpm.ng.service.TrazabilidadService;
import com.senasa.bpm.ng.utility.ConstantUtil;

@RestController
@RequestMapping("/trazabilidad")
@AllArgsConstructor
public class TrazabilidadController {

    private final TrazabilidadService trazabilidadService;

    @GetMapping("/obtenerDetalleTrazabilidad/{pidfinal}")
    public ResponseEntity<ApiResponse<List<TrazabilidadResponse>>> obtenerDetalleTrazabilidad (@PathVariable String pidfinal) {
        return ResponseEntity.ok(ApiResponse.<List<TrazabilidadResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(trazabilidadService.obtenerDetalleTrazabilidad(pidfinal))
                .build());
    }
    
    @PostMapping("/derivacion")
    public void registrarTrazabilidadDerivacion(@RequestBody DerivacionTraza traza) {
    	trazabilidadService.insertarDerivar(traza);
    }

}
