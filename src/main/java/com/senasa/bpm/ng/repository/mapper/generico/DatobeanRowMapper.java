package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.senasa.bpm.ng.model.generico.DatosBean;

public class DatobeanRowMapper implements RowMapper<DatosBean> {

	@Override
	public DatosBean mapRow(ResultSet rs, int i) throws SQLException {
		return DatosBean.builder().codigo(rs.getString("CODIGO")).descripcion(rs.getString("DESCRIPCION")).build();
	}

}
