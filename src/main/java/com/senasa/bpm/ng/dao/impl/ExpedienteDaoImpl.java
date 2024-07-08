package com.senasa.bpm.ng.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.senasa.bpm.ng.dao.ExpedienteDao;
import com.senasa.bpm.ng.dao.rowmapper.ExpedienteRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.TrazabilidadRowMapper;
import com.senasa.bpm.ng.model.bean.ArchivarBean;
import com.senasa.bpm.ng.model.bean.ExpedienteBean;
import com.senasa.bpm.ng.model.bean.ExpedienteTrazabilidadBean;
import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.ExpedienteRequest;
import com.senasa.bpm.ng.model.request.ExpedienteTrazabilidadRequest;
import com.senasa.bpm.ng.model.response.ExpedienteTrazabilidadResponse;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleTypes;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class ExpedienteDaoImpl implements ExpedienteDao {
	private JdbcTemplate jdbcTemplate;
	@Autowired
    public ExpedienteDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	@Override
	public ExpedienteBean buscarExpediente(ExpedienteRequest request) {
		// TODO Auto-generated method stub
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_EXPEDIENTE")
                .withProcedureName("SP_OBTENER_DATOS_EXPEDIENTE")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("p_Codigo_Expediente", Types.VARCHAR),
                        new SqlOutParameter("Reg", Types.REF_CURSOR,  new ExpedienteRowMapper()));
        
		SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("p_Codigo_Expediente", request.getNroExpediente());
                
        Map<String, Object> result = simpleJdbcCall.execute(prm);
        List<ExpedienteBean> bean = (List) result.get("Reg");
        return bean.get(0);
		
	}
	/*
	// public ExpedienteTrazabilidadResponse
	// grabarTrazabilidadExpediente(ExpedienteTrazabilidadRequest request) {
	@Override
	public List<ExpedienteTrazabilidadBean> grabarTrazabilidadExpediente(ExpedienteTrazabilidadRequest request) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PCKG_GRABAR")
				.withProcedureName("SP_GENERAR_INFO_TRAZABILIDAD").withoutProcedureColumnMetaDataAccess() // Evitar  problemas  de  metadatos
				.useInParameterNames("Pidfinal", "Pserviciotupa", "Pidremitente", "Piddestinatario").declareParameters(
						new SqlParameter("Pidfinal", Types.VARCHAR), new SqlParameter("Pserviciotupa", Types.VARCHAR),
						new SqlParameter("Pidremitente", Types.VARCHAR),
						new SqlParameter("Piddestinatario", Types.VARCHAR),
						new SqlOutParameter("Pareadestinatario", Types.VARCHAR),
						new SqlOutParameter("Psubareadestinatario", Types.VARCHAR),
						new SqlOutParameter("Parearemitente", Types.VARCHAR),
						new SqlOutParameter("Psubarearemitente", Types.VARCHAR),
						new SqlOutParameter("Psecuencial", Types.VARCHAR),
						new SqlOutParameter("Urgencia", Types.VARCHAR),
						new SqlOutParameter("Reg", OracleTypes.CURSOR, new RowMapper<Object>() {
							public ExpedienteTrazabilidadBean mapRow(ResultSet rs, int rowNum) throws SQLException {
								return ExpedienteTrazabilidadBean.builder()
										.codigo_Servicio(rs.getString("Codigo_Servicio"))
										.descripcion_Servicio(rs.getString("Descripcion_Servicio"))
										.codigo_Tipo_Servicio(rs.getString("Codigo_Tipo_Servicio"))
										.descripcion_Tipo_Servicio(rs.getString("Descripcion_Tipo_Servicio")).build();
							}
						}));

		Map<String, Object> inParams = new HashMap<>();
		inParams.put("Pidfinal", request.getPidfinal());
		inParams.put("Pserviciotupa", request.getPserviciotupa());
		inParams.put("Pidremitente", request.getPidremitente());
		inParams.put("Piddestinatario", request.getPiddestinatario());

		Map<String, Object> out = simpleJdbcCall.execute(inParams);

		List<ExpedienteTrazabilidadBean> response = new ArrayList<>();
		response.add(ExpedienteTrazabilidadBean.builder().pareadestinatario((String) out.get("Pareadestinatario"))
				.psubareadestinatario((String) out.get("Psubareadestinatario"))
				.parearemitente((String) out.get("Parearemitente"))
				.psubarearemitente((String) out.get("Psubarearemitente")).psecuencial((String) out.get("Psecuencial"))
				.urgencia((String) out.get("Urgencia")).build());
		// Añadir los resultados del cursor al response
		List<ExpedienteTrazabilidadBean> regResults = (List<ExpedienteTrazabilidadBean>) out.get("Reg");
		response.addAll(regResults);

		return response;
	}
*/
}
