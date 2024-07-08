package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.senasa.bpm.ng.model.generico.Procedimientoservicio;

public class ProcedimientoservicioRowMapper implements RowMapper<Procedimientoservicio> {
	@Override
	public Procedimientoservicio mapRow(ResultSet rs, int i) throws SQLException {
		return Procedimientoservicio.builder().codigoAreaGestion(rs.getString("CODIGO_AREA_GESTION"))
				.descripcionAreaGestion(rs.getString("DESCRIPCION_AREA_GESTION"))
				.codigoProcedimientoTUPA(rs.getString("CODIGO_PROCEDIMIENTO_TUPA"))
				.descripcionProcedimientoTUPA(rs.getString("DESCRIPCION_PROCEDIMIETO_TUPA"))
				.codigoServicio(rs.getString("CODIGO_SERVICIO"))
				.descripcionServicio(rs.getString("DESCRIPCION_SERVICIO")).build();
	}

}
