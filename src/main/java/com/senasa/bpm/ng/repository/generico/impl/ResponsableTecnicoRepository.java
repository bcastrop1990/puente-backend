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
import com.senasa.bpm.ng.model.generico.ResponsableTecnico;
import com.senasa.bpm.ng.repository.generico.IResponsableTecnicoRepository;
import com.senasa.bpm.ng.repository.mapper.generico.FabricanteRowMapper;

import oracle.jdbc.OracleTypes;
import com.senasa.bpm.ng.repository.mapper.generico.*;

@Repository
public class ResponsableTecnicoRepository implements IResponsableTecnicoRepository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ResponsableTecnicoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Value("${shema}")
	String esquema;

	@Override
	public List<ResponsableTecnico> buscarResponsableTecnico(String numeroDocumento) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("pckg_dip_productos").withProcedureName("Sp_Obtener_Veterinario")
				.declareParameters(new SqlParameter("p_Ruc_Empresa", OracleTypes.VARCHAR),
						new SqlOutParameter("p_Mensaje", OracleTypes.VARCHAR),
						new SqlOutParameter("Reg", OracleTypes.CURSOR, new ResponsableTecnicoRowMapper()))
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource().addValue("p_Ruc_Empresa", numeroDocumento);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<ResponsableTecnico> beanList = (List) result.get("Reg");
		return beanList;
	}

}
