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

import com.senasa.bpm.ng.model.generico.DatosBean;
import com.senasa.bpm.ng.model.generico.Tarifario;
import com.senasa.bpm.ng.repository.generico.ITarifarioRepository;
import com.senasa.bpm.ng.repository.mapper.generico.DatobeanRowMapper;

import oracle.jdbc.OracleTypes;

@Repository
public class TarifarioRepository implements ITarifarioRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TarifarioRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Value("${shema}")
	String esquema;

	@Override
	public Tarifario RetornaTarifario(Tarifario tarifario) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("Pckg_Tarifario").withFunctionName("Fn_Calcular_Tasa_Servicio")
				.declareParameters(new SqlOutParameter("Total", OracleTypes.VARCHAR, new String()),
						new SqlParameter("p_Cod_Servicio", OracleTypes.VARCHAR),
						new SqlParameter("p_Cantidad", OracleTypes.VARCHAR),
						new SqlParameter("p_Trama_Productos", OracleTypes.VARCHAR),
						new SqlParameter("p_Trama_Vacunas", OracleTypes.VARCHAR),
						new SqlParameter("p_Trama_Analisis", OracleTypes.VARCHAR),
						new SqlParameter("p_canal", OracleTypes.VARCHAR)

				).withoutProcedureColumnMetaDataAccess();
		String montoTarifa = simpleJdbcCall.executeFunction(String.class,tarifario.getCodServicio(), tarifario.getCantidad(), "", "", "", "");
		tarifario.setTarifa(montoTarifa);

		return tarifario;
	}

}
