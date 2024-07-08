
package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.InfoSolicitanteDao;
import com.senasa.bpm.ng.dao.rowmapper.PersonaDocumentoRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.PersonaRowMapper;
import com.senasa.bpm.ng.model.bean.PersonaBean;
import com.senasa.bpm.ng.model.request.DniVuceRequest;
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
public class InfoSolicitanteDaoImpl implements InfoSolicitanteDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InfoSolicitanteDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PersonaBean> obtenerPeronaPorDocVuce(DniVuceRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GENERAL")
                .withProcedureName("Sp_Obtener_Persona_Docvuce")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("Ptidodoc", Types.VARCHAR),
                        new SqlParameter("Pnumdoc", Types.VARCHAR),
                        new SqlParameter("Pnombre", Types.VARCHAR),
                        new SqlOutParameter("Reg", Types.REF_CURSOR,
                                new PersonaRowMapper()));
        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("Ptidodoc", request.getPtidodoc())
                .addValue("Pnumdoc", request.getPnumdoc())
                .addValue("Pnombre", request.getPnombre());
        Map<String, Object> result = simpleJdbcCall.execute(prm);
        List<PersonaBean> beanList = (List) result.get("Reg");
        return beanList;
    }

    @Override
    public List<PersonaBean> obtenerPersonaPorDocumento(DniVuceRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GENERAL")
                .withProcedureName("SP_OBTENER_PERSONA_DOCUMENTO")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("Ptidodoc", Types.VARCHAR),
                        new SqlParameter("Pnumdoc", Types.VARCHAR),
                        new SqlParameter("Pnombre", Types.VARCHAR),
                        new SqlOutParameter("Reg", Types.REF_CURSOR,
                                new PersonaDocumentoRowMapper()));
        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("Ptidodoc", request.getPtidodoc())
                .addValue("Pnumdoc", request.getPnumdoc())
                .addValue("Pnombre", request.getPnombre());
        Map<String, Object> result = simpleJdbcCall.execute(prm);
        List<PersonaBean> beanList = (List) result.get("Reg");
        return beanList;
    }

}
