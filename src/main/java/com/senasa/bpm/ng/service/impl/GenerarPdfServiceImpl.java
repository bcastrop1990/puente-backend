package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.service.GenerarPdfService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class GenerarPdfServiceImpl implements GenerarPdfService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public byte[] generatePdfReport(String codigoRecibo) {
		try {
			/* PRUEBA EN AMBIENTE DESARROLLO*/

			File file = new File("/u01/reportesJasper/reciboPago2.jasper");
			if (!file.exists()) {
				throw new FileNotFoundException(
						"El archivo reciboPago2.jasper no se encuentra en /u01/reportesJasper/");
			}
			FileInputStream inputStream = new FileInputStream(file);


			//ClassPathResource resource = new ClassPathResource("reports/reciboPago2.jasper");
			//FileInputStream inputStream = new FileInputStream(resource.getFile());

			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);

			// Obtener la conexión directamente desde el DataSource de JdbcTemplate
			Connection connection = jdbcTemplate.getDataSource().getConnection();

			// Parámetros para el reporte
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("PCODRECIBO", codigoRecibo); // Ejemplo de parámetro
			parameters.put("REPORT_CONNECTION", connection); // Pasar la conexión como parámetro
			parameters.put("SUBREPORT_DIR", "/u01/reportesJasper/");
			//parameters.put("SUBREPORT_DIR", "reports/");

			// Llenar el reporte
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

			// Exportar a PDF
			return JasperExportManager.exportReportToPdf(jasperPrint);

		} catch (Exception e) {
			e.printStackTrace();
			return new byte[0];
		}
	}

	public byte[] generatePdfReportAnticipado(String expediente) {
		// private String rutaReport="/u01/reportesJasper/";
		String rutaReport = "/reports/";
		try {
			/* PRUEBA EN AMBIENTE DESARROLLO */
			File file = new File("/u01/reportesJasper/pago_anticipado.jasper");
			if (!file.exists()) {
				throw new FileNotFoundException(
						"El archivo pago_anticipado.jasper no se encuentra en /u01/reportesJasper/");
			}
			FileInputStream inputStream = new FileInputStream(file);

			// PRUEBA EN LOCAL
			//ClassPathResource resource = new ClassPathResource(rutaReport + "pago_anticipado.jasper");
			//FileInputStream inputStream = new FileInputStream(resource.getFile());

			// Crear un objeto JasperReport desde el archivo .jasper
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);

			// Obtener la conexión directamente desde el DataSource de JdbcTemplate
			Connection connection = jdbcTemplate.getDataSource().getConnection();

			// Parámetros para el reporte
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("PCODEXPEDIENTE", expediente); // Ejemplo de parámetro
			parameters.put("REPORT_CONNECTION", connection); // Pasar la conexión como parámetro
			parameters.put("SUBREPORT_DIR", rutaReport);

			// Llenar el reporte
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

			// Exportar a PDF
			return JasperExportManager.exportReportToPdf(jasperPrint);

		} catch (Exception e) {
			e.printStackTrace();
			return new byte[0];
		}
	}
}
