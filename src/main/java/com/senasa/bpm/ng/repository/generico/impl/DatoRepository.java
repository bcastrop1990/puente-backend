package com.senasa.bpm.ng.repository.generico.impl;

import oracle.jdbc.OracleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.senasa.bpm.ng.model.generico.DatosBean;
import com.senasa.bpm.ng.model.generico.Fabricante;
import com.senasa.bpm.ng.repository.generico.IDatoRepository;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import com.senasa.bpm.ng.repository.mapper.generico.*;

@Repository
public class DatoRepository implements IDatoRepository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public DatoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Value("${shema}")
	String esquema;

	@Override
	public List<DatosBean> listarDatos(String tipoDato) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("PCKG_DIP_PRODUCTOS").withProcedureName("sp_listar_datos")
				.declareParameters(new SqlParameter("p_Tipo_Dato", OracleTypes.VARCHAR),
						new SqlOutParameter("p_Mensaje", OracleTypes.VARCHAR),
						new SqlOutParameter("Reg", OracleTypes.CURSOR, new DatobeanRowMapper()))
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource().addValue("p_Tipo_Dato", tipoDato);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<DatosBean> beanList = (List) result.get("Reg");
		return beanList;
	}

	@Override
	public List<Fabricante> buscarFabricante(String tipoDato, String nombre) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("Pckg_General").withProcedureName("Sp_Listar_Fabricantes")
				.declareParameters(new SqlParameter("p_Tipo_Dato", OracleTypes.VARCHAR),
						new SqlParameter("p_Nombre", OracleTypes.VARCHAR),
						new SqlOutParameter("p_Mensaje", OracleTypes.VARCHAR),
						new SqlOutParameter("Reg", OracleTypes.CURSOR, new FabricanteRowMapper()))
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource().addValue("p_Tipo_Dato", tipoDato).addValue("p_Nombre",
				nombre);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<Fabricante> beanList = (List) result.get("Reg");
		return beanList;
	}

}
