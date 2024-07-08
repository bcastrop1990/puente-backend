package com.senasa.bpm.ng.controller;

import com.senasa.bpm.ng.model.generico.Fabricante;
import com.senasa.bpm.ng.model.generico.ReciboServFito;
import com.senasa.bpm.ng.model.response.ApiResponse;
import com.senasa.bpm.ng.service.GenerarPdfService;
import com.senasa.bpm.ng.service.generico.IGenericoService;
import com.senasa.bpm.ng.utility.ConstantUtil;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/generarpdf")
@AllArgsConstructor
public class GenerarPdfController {
	@Autowired
	private GenerarPdfService reportService;

	@Autowired
	IGenericoService genericoService;

	@GetMapping("/reciboPago/{codigoRecibo}")
	public ResponseEntity<byte[]> getReciboPagoPdf(@PathVariable String codigoRecibo) {
		byte[] data = reportService.generatePdfReport(codigoRecibo);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("filename", "report.pdf");
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		return new ResponseEntity<>(data, headers, HttpStatus.OK);
	}

	@GetMapping("/reciboPagoAnticipado/{expediente}")
	public ResponseEntity<byte[]> getReciboPagoAnticipadoPdf(@PathVariable String expediente) {
		byte[] data = reportService.generatePdfReportAnticipado(expediente);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("filename", "report.pdf");
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		return new ResponseEntity<>(data, headers, HttpStatus.OK);
	}
}
