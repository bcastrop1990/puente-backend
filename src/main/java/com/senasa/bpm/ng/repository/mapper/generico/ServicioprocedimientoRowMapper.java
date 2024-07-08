package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.generico.Servicioprocedimiento;

public class ServicioprocedimientoRowMapper implements RowMapper<Servicioprocedimiento> {
	@Override
	public Servicioprocedimiento mapRow(ResultSet rs, int i) throws SQLException {
		return Servicioprocedimiento.builder().codigoServicioTupa(rs.getString("CODIGO_SERVICIO_TUPA"))
				.descripcionServicio(rs.getString("DESCRIPCION_SERVICIO")).indicadorOtro(rs.getString("INDICADOR_OTRO"))
				.tipoServicio(rs.getString("TIPO_SERVICIO")).build();
	}
}
