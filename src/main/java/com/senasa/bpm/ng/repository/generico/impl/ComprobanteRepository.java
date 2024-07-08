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

import com.senasa.bpm.ng.model.generico.Comprobante;
import com.senasa.bpm.ng.model.generico.DatosBean;
import com.senasa.bpm.ng.model.generico.ReciboServFito;
import com.senasa.bpm.ng.repository.generico.IComprobanteRepository;
import com.senasa.bpm.ng.repository.mapper.generico.DatobeanRowMapper;

import oracle.jdbc.OracleTypes;
import com.senasa.bpm.ng.repository.mapper.generico.*
;

@Repository
public class ComprobanteRepository implements IComprobanteRepository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ComprobanteRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Value("${shema}")
	String esquema;
	
	@Override
	public List<Comprobante> buscarComprobante(Comprobante comprobante) {
		// TODO Auto-generated method stub
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("Pckg_Recibo").withProcedureName("Sp_Obtener_Exp_Recibo")
				.declareParameters(
						new SqlParameter("p_Cod_Recibo", OracleTypes.VARCHAR),
						new SqlParameter("p_Cod_Proc", OracleTypes.VARCHAR),
						new SqlParameter("p_Cod_Servicio", OracleTypes.VARCHAR),
						new SqlParameter("p_Persona_Id", OracleTypes.VARCHAR),
						new SqlOutParameter("Reg_Recibo", OracleTypes.CURSOR, new ComprobanteRowMapper())
						)
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource()
				.addValue("p_Cod_Recibo", comprobante.getP_Cod_Recibo())
				.addValue("p_Cod_Proc", comprobante.getP_Cod_Proc())
				.addValue("p_Cod_Servicio", comprobante.getP_Cod_Servicio())
				.addValue("p_Persona_Id", comprobante.getP_Persona_Id())
				
				;
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<Comprobante> beanList = (List) result.get("Reg_Recibo");
		return beanList;
	}

	@Override
	public List<ReciboServFito> buscarDetalleReciboAnalisisFito(ReciboServFito reciboServFito) {
		// TODO Auto-generated method stub 
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("PCKG_SERVICIO").withProcedureName("Sp_Obtener_Recibo_Serv_Lab")
				.declareParameters(
						new SqlParameter("codigoexpediente", OracleTypes.VARCHAR),
						new SqlOutParameter("cur_out", OracleTypes.CURSOR, new ReciboServFitoRowMapper())
						)
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource()
				.addValue("codigoexpediente", reciboServFito.getCodigoExpediente())
				
				;
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<ReciboServFito> beanList = (List) result.get("cur_out");
		return beanList;
	}

}
