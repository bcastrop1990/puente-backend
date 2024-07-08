package com.senasa.bpm.ng.dao.impl;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.senasa.bpm.ng.dao.SeguridadDao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class SeguridadDaoImpl implements SeguridadDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SeguridadDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public BigDecimal validarConexion(String p_Usuario, String p_Password) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_SEGURIDAD")  // Ajusta esto según el paquete donde esté el procedimiento
                .withProcedureName("Sp_Validar_Conexion_BD")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("p_Usuario", Types.VARCHAR),
                        new SqlParameter("p_Password", Types.VARCHAR),
                        new SqlOutParameter("resultado_", Types.DECIMAL)
                );

        SqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("p_Usuario", p_Usuario)
                .addValue("p_Password", p_Password);

        Map<String, Object> result = simpleJdbcCall.execute(inParams);

        BigDecimal resultado = (BigDecimal) result.get("resultado_");
        return resultado;
    }

}
