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

import com.senasa.bpm.ng.model.generico.CentroTramitePersona;
import com.senasa.bpm.ng.model.generico.Fabricante;
import com.senasa.bpm.ng.repository.generico.ICentroTramitePersonaRepository;
import com.senasa.bpm.ng.repository.mapper.generico.FabricanteRowMapper;

import oracle.jdbc.OracleTypes;
import com.senasa.bpm.ng.repository.mapper.generico.*;

@Repository
public class CentroTramitePersonaRepository implements ICentroTramitePersonaRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CentroTramitePersonaRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Value("${shema}")
	String esquema;

	@Override
	public List<CentroTramitePersona> buscarCentroTramitePersona(String Ppersonaid) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("Pckg_general").withProcedureName("Sp_Centro_Tramite_Persona")
				.declareParameters(
						new SqlParameter("Ppersonaid", OracleTypes.VARCHAR),
						new SqlOutParameter("Reg", OracleTypes.CURSOR, new CentroTramitePersonaRowMapper()))
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource().addValue("Ppersonaid", Ppersonaid);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<CentroTramitePersona> beanList = (List) result.get("Reg");
		return beanList;
	}

}
