package com.senasa.bpm.ng.service;

import org.springframework.http.HttpHeaders;

public interface DescargarArchivosService {

	byte[] descargarArchivosReport(String codigoExpediente);
	public void DOWNLOADFROMUCM(String cadena) throws Exception;
	public byte[] ZIPFROMUCM( String nameFile , String cadena , HttpHeaders headers ) throws Exception;
	public byte[] FILEFROMUCM( String cadena , HttpHeaders headers ) throws Exception;
	
}