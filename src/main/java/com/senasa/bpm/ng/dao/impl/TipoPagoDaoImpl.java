package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.BancoDao;
import com.senasa.bpm.ng.dao.TipoPagoDao;
import com.senasa.bpm.ng.dao.rowmapper.BancoRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.TipoPagoRowMapper;
import com.senasa.bpm.ng.model.bean.BancoBean;
import com.senasa.bpm.ng.model.bean.TipoPagoBean;
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
public class TipoPagoDaoImpl implements TipoPagoDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public TipoPagoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TipoPagoBean> listarTipoPago() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_RECIBO")
                .withProcedureName("Sp_Obtener_Tipos_Pago")
                .declareParameters(
                        new SqlOutParameter("Reg", OracleTypes.CURSOR, new TipoPagoRowMapper())
                )
                .withoutProcedureColumnMetaDataAccess();

        SqlParameterSource in = new MapSqlParameterSource();
        Map<String, Object> result = simpleJdbcCall.execute(in);

        List<TipoPagoBean> beanList = (List<TipoPagoBean>) result.get("Reg");
        return beanList;
    }





}
