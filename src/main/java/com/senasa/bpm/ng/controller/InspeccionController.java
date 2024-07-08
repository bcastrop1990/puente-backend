package com.senasa.bpm.ng.controller;//package com.senasa.bpm.ng.controller;
//
//import com.senasa.bpm.ng.model.response.*;
//import com.senasa.bpm.ng.service.DocuResolutivoService;
//import com.senasa.bpm.ng.service.InspeccionService;
//import com.senasa.bpm.ng.utility.ConstantUtil;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/inspeccion")
//@AllArgsConstructor
//public class InspeccionController {
//
//    private final InspeccionService inspeccionService;
//
////
//    @GetMapping("/muestreo/{tipoEnvase}")
//    public ResponseEntity<ApiResponse<List<InspeccionResponse>>> listarTipoEnvase (@PathVariable String tipoEnvase) {
//        System.out.println("descripcion: "+tipoEnvase);
//        return ResponseEntity.ok(ApiResponse.<List<AgregarDocuResponse>>builder()
//                .code(ConstantUtil.OK_CODE)
//                .message(ConstantUtil.OK_MESSAGE)
//                .data(inspeccionService.listarTipoEnvase(tipoEnvase))
//                .build());
//    }
//

