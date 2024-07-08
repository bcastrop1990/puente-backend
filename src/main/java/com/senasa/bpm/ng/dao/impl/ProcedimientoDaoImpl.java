package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.ProcedimientoDao;
import com.senasa.bpm.ng.dao.rowmapper.ProcedimientoRowMapper;
import com.senasa.bpm.ng.model.bean.ProcedimientoBean;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import lombok.extern.slf4j.Slf4j;
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
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class ProcedimientoDaoImpl implements ProcedimientoDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ProcedimientoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProcedimientoBean> listarProcedimiento(ProcedimientoRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GENERAL")
                .withProcedureName("SP_PROCEDIMIENTO_POR_AREA")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("Pareagestion", Types.VARCHAR),
                        new SqlParameter("Indicadorprocedimientognrl", Types.VARCHAR),
                        new SqlOutParameter("Reg", Types.REF_CURSOR,
                                new ProcedimientoRowMapper()));
        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("Pareagestion", request.getPareagestion())
                .addValue("Indicadorprocedimientognrl", request.getIndicadorprocedimientognrl());;
        Map<String, Object> result = simpleJdbcCall.execute(prm);
        List<ProcedimientoBean> beanList = (List) result.get("Reg");
        return beanList;
    }




}
