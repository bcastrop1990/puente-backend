package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.generico.Fabricante;

public class FabricanteRowMapper implements RowMapper<Fabricante> {
	@Override
	public Fabricante mapRow(ResultSet rs, int i) throws SQLException {
		return Fabricante.builder().nombre(rs.getString("DESC_LABO_LAB")).idFabricante(rs.getString("REGI_PADR_EMP")).build();
	}

}
