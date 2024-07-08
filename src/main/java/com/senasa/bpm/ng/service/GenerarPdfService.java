package com.senasa.bpm.ng.service;



public interface GenerarPdfService {

	byte[] generatePdfReport(String codigoRecibo);

	byte[] generatePdfReportAnticipado(String expediente);
}
