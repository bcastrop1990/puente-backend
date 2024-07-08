package com.senasa.bpm.ng.dao.impl;

import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import com.senasa.bpm.ng.dao.TrazabilidadDao;
import com.senasa.bpm.ng.dao.rowmapper.RegformBeanRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.ReggridBeanRowMapper;
import com.senasa.bpm.ng.model.bean.DerivacionTraza;
import com.senasa.bpm.ng.model.bean.RegformBean;
import com.senasa.bpm.ng.model.bean.ReggridBean;
import com.senasa.bpm.ng.model.bean.UsuarioBean;
import com.senasa.bpm.ng.model.response.TrazabilidadResponse;
import oracle.jdbc.OracleTypes;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class TrazabildadDaoImpl implements TrazabilidadDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TrazabildadDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TrazabilidadResponse> listarDocumentoExpediente(String pidfinal) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
            .withCatalogName("PCKG_GRABAR")
            .withProcedureName("SP_OBTENER_TRAZABILIDAD")
            .withoutProcedureColumnMetaDataAccess()
            .declareParameters(
                new SqlParameter("Pidfinal", Types.VARCHAR),
                new SqlOutParameter("Regform", OracleTypes.CURSOR, new RegformBeanRowMapper()),
                new SqlOutParameter("Reggrid", OracleTypes.CURSOR, new ReggridBeanRowMapper())
            );

        SqlParameterSource inParams = new MapSqlParameterSource()
            .addValue("Pidfinal", pidfinal);
        Map<String, Object> out = simpleJdbcCall.execute(inParams);

        List<RegformBean> regform = (List<RegformBean>) out.get("Regform");
        List<ReggridBean> reggrid = (List<ReggridBean>) out.get("Reggrid");

        TrazabilidadResponse response = TrazabilidadResponse.builder()
            .regformBean(regform)
            .reggridBean(reggrid)
            .build();

        return Arrays.asList(response);
    }

    public void insertarDerivar(DerivacionTraza trazabilidad) {
    	SimpleJdbcCall call = new SimpleJdbcCall(this.jdbcTemplate)
				.withCatalogName("PCKG_TRAZABILIDAD")
				.withProcedureName("Sp_Insertar_Traza_Derivar")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(
	                    new SqlParameter("P_Cod_Expediente", Types.VARCHAR),
	                    new SqlParameter("p_Codigo_Stddoc", Types.VARCHAR),
	                    new SqlParameter("p_Cod_Servicio", Types.VARCHAR),
	                    new SqlParameter("p_Descripcion_Asunto", Types.VARCHAR),
	                    new SqlParameter("p_Notas", Types.VARCHAR),
	                    new SqlParameter("p_Remitente_Usuario", Types.VARCHAR),
	                    new SqlParameter("p_Destinatario_Usuario", Types.VARCHAR),
	                    new SqlParameter("p_ucmid", Types.VARCHAR)
	            );
    	call.execute(trazabilidad.getPcodexpediente(),
    				trazabilidad.getPcodigostddoc(),
    				trazabilidad.getPcodservicio(),
    				trazabilidad.getPdescripcionasunto(),
    				trazabilidad.getPnotas(),
    				trazabilidad.getPremitenteusuario(),
    				trazabilidad.getPdestinatariousuario(),
    				trazabilidad.getPucmid());
    }
}
