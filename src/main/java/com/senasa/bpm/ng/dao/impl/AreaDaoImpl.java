package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.AreaDao;
import com.senasa.bpm.ng.dao.rowmapper.AreaRowMapper;
import com.senasa.bpm.ng.model.bean.AreaBean;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class AreaDaoImpl implements AreaDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public AreaDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AreaBean> listarArea() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GENERAL")
                .withProcedureName("SP_AREAS_GESTION")
                .declareParameters(
                        new SqlOutParameter("Reg", OracleTypes.CURSOR, new AreaRowMapper())
                )
                .withoutProcedureColumnMetaDataAccess();

        SqlParameterSource in = new MapSqlParameterSource();
        Map<String, Object> result = simpleJdbcCall.execute(in);

        List<AreaBean> beanList = (List<AreaBean>) result.get("Reg");
        return beanList;
    }




}
