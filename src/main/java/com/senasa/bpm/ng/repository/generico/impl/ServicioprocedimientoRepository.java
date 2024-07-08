package com.senasa.bpm.ng.repository.generico.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.senasa.bpm.ng.model.generico.Servicioprocedimiento;
import com.senasa.bpm.ng.repository.generico.IServicioprocedimientoRepository;
import com.senasa.bpm.ng.repository.mapper.generico.*;

import oracle.jdbc.OracleTypes;

@Repository
public class ServicioprocedimientoRepository implements IServicioprocedimientoRepository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ServicioprocedimientoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Value("${shema}")
	String esquema;

	@Override
	public List<Servicioprocedimiento> buscarServicioprocedimiento(Servicioprocedimiento servicioprocedimiento) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("Pckg_General").withProcedureName("Sp_Servicio_Procedmiento_Area")
				.declareParameters(
						new SqlParameter("Pproctupa", OracleTypes.VARCHAR),
						new SqlOutParameter("Reg", OracleTypes.CURSOR, new ServicioprocedimientoRowMapper()),
						new SqlParameter("p_Cod_Servicio", OracleTypes.VARCHAR)
						)
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource()
				.addValue("Pproctupa",
				servicioprocedimiento.getCodigoServicioTupa())
				.addValue("p_Cod_Servicio",
						servicioprocedimiento.getTipoServicio());
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<Servicioprocedimiento> beanList = (List) result.get("Reg");
		return beanList;
	}

}
