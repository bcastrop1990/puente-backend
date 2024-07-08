package com.senasa.bpm.ng.controller;

import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.FinalizarProcesoRequest;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import com.senasa.bpm.ng.model.response.ApiResponse;
import com.senasa.bpm.ng.model.response.ArchivarResponse;
import com.senasa.bpm.ng.model.response.ProcedimientoResponse;
import com.senasa.bpm.ng.model.response.RequisitoResponse;
import com.senasa.bpm.ng.service.RequisitoService;
import com.senasa.bpm.ng.utility.ConstantUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requisito")
@AllArgsConstructor
public class RequisitoController {

    private final RequisitoService requisitoService;

    @GetMapping("obtenerRequisitos/{pcodexpediente}")
    public ResponseEntity<ApiResponse<List<RequisitoResponse>>> obtenerRequisitos(@PathVariable String pcodexpediente) {
        return ResponseEntity.ok(ApiResponse.<List<RequisitoResponse>>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(requisitoService.listarRequisitos(pcodexpediente))
                .build());

    }
//    @PostMapping("archivar")
//    public ResponseEntity<ApiResponse<List<ArchivarResponse>>> archivar(@RequestBody ArchivarRequest request) {
//        return ResponseEntity.ok(ApiResponse.<List<ArchivarResponse>>builder()
//                .code(ConstantUtil.OK_CODE)
//                .message(ConstantUtil.OK_MESSAGE)
//                .data(requisitoService.archivar(request))
//                .build());
//
//    }

    @PostMapping("finalizarRequisito/{pnombrestd}/{pucmid}")
    public ResponseEntity<ApiResponse<String>> obtenerRequisitos(@PathVariable String pnombrestd, @PathVariable String pucmid) {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(requisitoService.actualizarDocumentoHijo(pnombrestd, pucmid))
                .build());

    }

    @PostMapping("finalizarProceso")
    public ResponseEntity<ApiResponse<String>> finalizarProceso (@RequestBody FinalizarProcesoRequest request) {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(requisitoService.finalizarProceso(request))
                .build());

    }
    
    @PostMapping("grabarDocumentoSTD")
    public ResponseEntity<ApiResponse<String>> grabarDocumentoSTD (@RequestBody FinalizarProcesoRequest request) {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(requisitoService.finalizarProceso(request))
                .build());

    }


}
