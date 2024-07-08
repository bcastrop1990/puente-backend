package com.senasa.bpm.ng.controller;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senasa.bpm.ng.service.DescargarArchivosService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/descargar")
@AllArgsConstructor
@Log
public class DescargarArchivosController {

	@Autowired
	private DescargarArchivosService reportService;

	
	@GetMapping("/getZipDocumentos")
	public ResponseEntity<byte[]> getZipDocumentos(
			@RequestParam("cadenaUcm") String cadenaUcm, 
			@RequestParam("nameFile") String nameFile,
			HttpServletRequest request, 
			HttpServletResponse response) {

		log.info("getZipDocumentos - cadenaUcm = " + cadenaUcm);
		log.info("getZipDocumentos - nameFile = " + nameFile);

		byte[] data = null;

		HttpHeaders headers = new HttpHeaders();
		
		try {

			reportService.DOWNLOADFROMUCM(cadenaUcm);
			data = reportService.ZIPFROMUCM(nameFile, cadenaUcm, headers);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
		
		return new ResponseEntity<>(data, headers, HttpStatus.OK);
	}
	
	@GetMapping("/getZipDocumentosb64")
	public ResponseEntity<String> getZipDocumentosb64(
			@RequestParam("cadenaUcm") String cadenaUcm, 
			@RequestParam("nameFile") String nameFile,
			HttpServletRequest request, 
			HttpServletResponse response) {

		log.info("getZipDocumentos - cadenaUcm = " + cadenaUcm);
		log.info("getZipDocumentos - nameFile = " + nameFile);

		byte[] data = null;
		String datab64 = "";
		HttpHeaders headers = new HttpHeaders();
		
		try {

			reportService.DOWNLOADFROMUCM(cadenaUcm);
			data = reportService.ZIPFROMUCM(nameFile, cadenaUcm, headers);
			datab64 =  Base64.getEncoder().encodeToString(data);
			//headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
		
		return new ResponseEntity<>(datab64, headers, HttpStatus.OK);
	}
	
	@GetMapping("/getDocumento")
	public ResponseEntity<byte[]> getDocumento(
			@RequestParam("cadenaUcm") String cadenaUcm,  
			HttpServletRequest request, 
			HttpServletResponse response) {

		log.info("getDocumento - cadenaUcm = " + cadenaUcm); 

		byte[] data = null;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		//headers.setContentDispositionFormData("filename", "report.pdf");
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		try {

			reportService.DOWNLOADFROMUCM(cadenaUcm);
			data = reportService.FILEFROMUCM( cadenaUcm, headers);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
		
		return new ResponseEntity<>(data, headers, HttpStatus.OK);
	}
	
	@GetMapping("/getDocumentb64")
	public ResponseEntity<String> getDocumentb64(
			@RequestParam("cadenaUcm") String cadenaUcm, 
			//@RequestParam("nameFile") String nameFile,
			HttpServletRequest request, 
			HttpServletResponse response) {

		log.info("getDocumentb64 - cadenaUcm = " + cadenaUcm);
		//log.info("getZipDocumentos - nameFile = " + nameFile);

		byte[] data = null;
		String datab64 = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		try {

			reportService.DOWNLOADFROMUCM(cadenaUcm);
			data = reportService.FILEFROMUCM(cadenaUcm, headers);
			datab64 =  Base64.getEncoder().encodeToString(data);
			//headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
		
		return new ResponseEntity<>(datab64, headers, HttpStatus.OK);
	}
	
	@GetMapping("/getDocumentoObservacion")
	public ResponseEntity<byte[]> getDocumentoObservacion(
			@RequestParam("cadenaUcm") String cadenaUcm,  
			HttpServletRequest request, 
			HttpServletResponse response) {

		log.info("getDocumentoObservacion - cadenaUcm = " + cadenaUcm); 

		byte[] data = null;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		//headers.setContentDispositionFormData("filename", "report.pdf");
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		try {

			reportService.DOWNLOADFROMUCM(cadenaUcm);
			data = reportService.FILEFROMUCM( cadenaUcm, headers);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
		
		return new ResponseEntity<>(data, headers, HttpStatus.OK);
	}

}
