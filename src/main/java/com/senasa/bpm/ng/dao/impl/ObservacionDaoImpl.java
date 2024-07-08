package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.ObservacionDao;
import com.senasa.bpm.ng.dao.TrazabilidadDao;
import com.senasa.bpm.ng.dao.rowmapper.*;
import com.senasa.bpm.ng.model.bean.*;
import com.senasa.bpm.ng.model.request.DniVuceRequest;
import com.senasa.bpm.ng.model.response.ObservacionResponse;
import com.senasa.bpm.ng.model.response.TrazabilidadResponse;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class ObservacionDaoImpl implements ObservacionDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ObservacionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ObservacionBean> obtenerListaHistorico (String pcodexpediente) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_TRAZABILIDAD")
                .withProcedureName("Sp_Obtener_Observ_Expediente")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        
                        new SqlOutParameter("Reg", OracleTypes.CURSOR,
                                new ObservacionRowMapper()),
                        new SqlParameter("Pcodexpediente", OracleTypes.VARCHAR)
                		);
        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("Pcodexpediente", pcodexpediente);
        Map<String, Object> result = simpleJdbcCall.execute(prm);
        List<ObservacionBean> beanList = (List) result.get("Reg");
        return beanList;
    }
}
