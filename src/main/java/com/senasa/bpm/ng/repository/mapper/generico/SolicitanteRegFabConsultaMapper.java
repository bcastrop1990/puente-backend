package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.senasa.bpm.ng.model.generico.*;

public class SolicitanteRegFabConsultaMapper implements RowMapper<SolicitanteRegFabConsulta> {
	@Override
	public SolicitanteRegFabConsulta mapRow(ResultSet rs, int i) throws SQLException {
		return SolicitanteRegFabConsulta.builder()
				.ANNO_REGI_PRO(rs.getString("ANNO_REGI_PRO"))
				.REGI_SOLI_PRO(rs.getString("REGI_SOLI_PRO"))
				.CODIGO_LABORATORIO(rs.getString("CODIGO_LABORATORIO"))
				.REGI_SOLIPRO(rs.getString("REGI_SOLIPRO"))
				.FLAG_FABRI_EXT(rs.getString("FLAG_FABRI_EXT"))
				.DIRECCION_FABRI(rs.getString("DIRECCION_FABRI"))
				.DOCUMENTO_TIPO_FABRI(rs.getString("DOCUMENTO_TIPO_FABRI"))
				.DOCUMENTO_NUMERO_FABRI(rs.getString("DOCUMENTO_NUMERO_FABRI"))
				.NUM_REGISTRO_FABRI(rs.getString("NUM_REGISTRO_FABRI"))
				.DEPARTAMENTO_ID_FABRI(rs.getString("DEPARTAMENTO_ID_FABRI"))
				.PROVINCIA_ID_FABRI(rs.getString("PROVINCIA_ID_FABRI"))
				.DISTRITO_ID_FABRI(rs.getString("DISTRITO_ID_FABRI"))
				.TELEFONO_FABRI(rs.getString("TELEFONO_FABRI"))
				.APELLIDO_PARTERNO_RESPONSABLE(rs.getString("APELLIDO_PARTERNO_RESPONSABLE"))
				.APELLIDO_MATERNO_RESPONSABLE(rs.getString("APELLIDO_MATERNO_RESPONSABLE"))
				.NOMBRES_RESPONSABLE(rs.getString("NOMBRES_RESPONSABLE"))
				.DOCUMENTO_TIPO_RESPONSABLE(rs.getString("DOCUMENTO_TIPO_RESPONSABLE"))
				.DOCUMENTO_NUMERO_RESPONSABLE(rs.getString("DOCUMENTO_NUMERO_RESPONSABLE"))
				
				
				.build();
	}
}
