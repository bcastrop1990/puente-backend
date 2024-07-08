package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.senasa.bpm.ng.model.generico.CentroTramitePersona;

public class CentroTramitePersonaRowMapper implements RowMapper<CentroTramitePersona> {
	@Override
	public CentroTramitePersona mapRow(ResultSet rs, int i) throws SQLException {
		return CentroTramitePersona.builder().codigoCentroTramite(rs.getString("CODIGO_CENTRO_TRAMITE"))
				.descripcionCentroTramite(rs.getString("DESCRIPCION_CENTRO_TRAMITE"))
				.personaId(rs.getString("PERSONA_ID")).codigoArea(rs.getString("CODIGO_AREA"))
				.codigoSubarea(rs.getString("CODIGO_SUBAREA")).nombreSubarea(rs.getString("NOMBRE_SUBAREA"))
				.ubicacionSede(rs.getString("UBICACION_SEDE")).codigoUsuario(rs.getString("CODI_USUA_USU")).build();
	}
}
