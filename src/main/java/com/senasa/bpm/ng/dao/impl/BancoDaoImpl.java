package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.BancoDao;
import com.senasa.bpm.ng.dao.ProcedimientoDao;
import com.senasa.bpm.ng.dao.rowmapper.AreaRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.BancoRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.ProcedimientoRowMapper;
import com.senasa.bpm.ng.model.bean.AreaBean;
import com.senasa.bpm.ng.model.bean.BancoBean;
import com.senasa.bpm.ng.model.bean.ProcedimientoBean;
import com.senasa.bpm.ng.model.bean.TipoPagoBean;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
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
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class BancoDaoImpl implements BancoDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public BancoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BancoBean> listarBanco() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_RECIBO")
                .withProcedureName("Sp_Obtener_Banco")
                .declareParameters(
                        new SqlOutParameter("Reg", OracleTypes.CURSOR, new BancoRowMapper())
                )
                .withoutProcedureColumnMetaDataAccess();

        SqlParameterSource in = new MapSqlParameterSource();
        Map<String, Object> result = simpleJdbcCall.execute(in);

        List<BancoBean> beanList = (List<BancoBean>) result.get("Reg");
        return beanList;
    }





}
