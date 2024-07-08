package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.generico.ReciboServFito;

public class ReciboServFitoRowMapper implements RowMapper<ReciboServFito> {
	@Override
	public ReciboServFito mapRow(ResultSet rs, int i) throws SQLException {
		return ReciboServFito.builder()
				.codigoExpediente(rs.getString("CODIGO_EXPEDIENTE"))
				.fechaRegistro(rs.getString("FECHA_REGISTRO"))
				.descBserCat(rs.getString("DESC_BSER_CAT"))
				.conteo(rs.getString("CONTEO"))
				.costo(rs.getString("COSTO"))
				.build();
	}
}
