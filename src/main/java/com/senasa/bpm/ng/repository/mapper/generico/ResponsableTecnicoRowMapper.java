package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.generico.ResponsableTecnico;

public class ResponsableTecnicoRowMapper implements RowMapper<ResponsableTecnico> {

	@Override
	public ResponsableTecnico mapRow(ResultSet rs, int i) throws SQLException {
		return ResponsableTecnico.builder().nombre(rs.getString("NOMB_CORT_VET"))
				.idResponsableTecnico(rs.getString("REGI_PROF_PPR")).build();
	}

}
