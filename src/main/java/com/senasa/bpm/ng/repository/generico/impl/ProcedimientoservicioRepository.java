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
import com.senasa.bpm.ng.model.generico.Procedimientoservicio;
import com.senasa.bpm.ng.repository.generico.IProcedimientoservicioRepository;
import com.senasa.bpm.ng.repository.mapper.generico.*;

import oracle.jdbc.OracleTypes;

@Repository
public class ProcedimientoservicioRepository implements IProcedimientoservicioRepository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProcedimientoservicioRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Value("${shema}")
	String esquema;

	@Override
	public List<Procedimientoservicio> buscarProcedimientoservicio(Procedimientoservicio procedimientoservicio) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("Pckg_General").withProcedureName("Sp_Info_Procedimiento_Servicio")
				.declareParameters(new SqlParameter("p_Cod_Proc", OracleTypes.VARCHAR),
						new SqlParameter("p_Cod_Servicio", OracleTypes.VARCHAR),

						new SqlOutParameter("Reg", OracleTypes.CURSOR, new ProcedimientoservicioRowMapper()))
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource()
				.addValue("p_Cod_Proc", procedimientoservicio.getCodigoProcedimientoTUPA())
				.addValue("p_Cod_Servicio", procedimientoservicio.codigoServicio);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<Procedimientoservicio> beanList = (List) result.get("Reg");
		return beanList;
	}

}
