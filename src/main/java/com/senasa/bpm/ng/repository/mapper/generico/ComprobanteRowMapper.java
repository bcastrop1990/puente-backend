package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.senasa.bpm.ng.model.generico.Comprobante;


public class ComprobanteRowMapper implements RowMapper<Comprobante>{
	@Override
	public Comprobante mapRow(ResultSet rs, int i) throws SQLException {
		return Comprobante.builder()
				.descripcionCentroTramite(rs.getString("DESCRIPCION_CENTRO_TRAMITE"))
				.direccionCentroTramite(rs.getString("DIRECCION_CENTRO_TRAMITE"))
				.codigoExpediente(rs.getString("CODIGO_EXPEDIENTE"))
				.fechaRegistro(rs.getString("FECHA_REGISTRO_STR"))
				.codigoRecibo(rs.getString("CODIGO_RECIBO"))
				.codigoCentroTramite(rs.getString("CODIGO_CENTRO_TRAMITE"))
				.personaId(rs.getString("PERSONA_ID"))
				.codigoSolicitud(rs.getString("CODIGO_SOLICITUD"))
				.descripcionAreaGestion(rs.getString("DESCRIPCION_AREA_GESTION"))
				.descripcionProcedimietoTupa(rs.getString("DESCRIPCION_PROCEDIMIETO_TUPA"))
				.descripcionServicio(rs.getString("DESCRIPCION_SERVICIO"))
				.nombreUsuario(rs.getString("NOMBRE_USUARIO"))
				.build();
	}
}
	
