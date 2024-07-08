package com.senasa.bpm.ng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.ExpedienteRequest;
import com.senasa.bpm.ng.model.response.ApiResponse;
import com.senasa.bpm.ng.model.response.ArchivarResponse;
import com.senasa.bpm.ng.model.response.ExpedienteResponse;
//import com.senasa.bpm.ng.model.response.ExpedienteTrazabilidadResponse;
import com.senasa.bpm.ng.service.ExpedienteService;
import com.senasa.bpm.ng.service.RequisitoService;
import com.senasa.bpm.ng.utility.ConstantUtil;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/expediente")
@AllArgsConstructor
public class ExpedienteController {
	@Autowired
	private ExpedienteService expedienteService;
	private RequisitoService requisitoService;
	@GetMapping("/buscarExpediente/{numeroExpediente}")
    public ResponseEntity<ApiResponse<ExpedienteResponse>> buscarExpediente(@PathVariable String numeroExpediente) {
		
		ExpedienteRequest expedienteRequest = new ExpedienteRequest();
		expedienteRequest.setNroExpediente(numeroExpediente);
        return ResponseEntity.ok(
                ApiResponse.<ExpedienteResponse>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(expedienteService.buscarExpediente(expedienteRequest))
                        .build());
    }
  @PostMapping("/grabarExpediente")
  public ResponseEntity<ApiResponse<List<ArchivarResponse>>> archivar(@RequestBody ArchivarRequest request) {
      return ResponseEntity.ok(ApiResponse.<List<ArchivarResponse>>builder()
              .code(ConstantUtil.OK_CODE)
              .message(ConstantUtil.OK_MESSAGE)
              .data(requisitoService.archivar(request))
              .build());

  }
	/*
	@PostMapping("grabarTrazabilidadExpediente")
    public ResponseEntity<ApiResponse<ExpedienteTrazabilidadResponse>> grabarTrazabilidadExpediente(@RequestBody ExpedienteTrazabilidadRequest request) {
        
		return ResponseEntity.ok(ApiResponse.<ExpedienteTrazabilidadResponse>builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(expedienteService.grabarTrazabilidadExpediente(request))
                .build());

    }
	*/
	
	
	
	/*@GetMapping("/buscarExpediente/{numeroExpediente}")
    public ResponseEntity<ApiResponse<ExpedienteResponse>> buscarExpediente(ExpedienteRequest expedienteRequest) {
        return ResponseEntity.ok(
                ApiResponse.<ExpedienteResponse>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(expedienteService.buscarExpediente(expedienteRequest))
                        .build());
    }*/

}
