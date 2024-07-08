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

import com.senasa.bpm.ng.model.generico.Fabricante;
import com.senasa.bpm.ng.model.generico.SolicitanteConsulta;
import com.senasa.bpm.ng.repository.generico.ISolicitanteConsultaRepository;
import com.senasa.bpm.ng.repository.mapper.generico.FabricanteRowMapper;
import com.senasa.bpm.ng.repository.mapper.generico.*;
import oracle.jdbc.OracleTypes;

@Repository
public class SolicitanteConsultaRepository implements ISolicitanteConsultaRepository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SolicitanteConsultaRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Value("${shema}")
	String esquema;

	@Override
	public List<SolicitanteConsulta> buscarSolicitante(String Ptidodoc, String Pnumdoc, String Pnombre,
			String p_Formato) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("Pckg_general").withProcedureName("Sp_Obtener_Persona_Doc")
				.declareParameters(
						new SqlParameter("Ptidodoc", OracleTypes.VARCHAR),
						new SqlParameter("Pnumdoc", OracleTypes.VARCHAR),
						new SqlParameter("Pnombre", OracleTypes.VARCHAR),
						new SqlParameter("p_Formato", OracleTypes.VARCHAR),
						new SqlOutParameter("Reg", OracleTypes.CURSOR, 
						new SolicitanteConsultaRowMapper())
						)
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource()
				.addValue("Ptidodoc", Ptidodoc)
				.addValue("Pnumdoc",Pnumdoc)
				.addValue("Pnombre",Pnombre)
				.addValue("p_Formato",p_Formato)
				;
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<SolicitanteConsulta> beanList = (List) result.get("Reg");
		return beanList;
	}

}
