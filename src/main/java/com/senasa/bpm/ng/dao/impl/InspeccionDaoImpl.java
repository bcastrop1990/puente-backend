package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.DocuResolutivoDao;
import com.senasa.bpm.ng.dao.InspeccionDao;
import com.senasa.bpm.ng.dao.rowmapper.AgregarDocuRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.DocuResolutivoRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.InspeccionRowMapper;
import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.DerivacionPersonalBean;
import com.senasa.bpm.ng.model.bean.DocuResolutivoBean;
import com.senasa.bpm.ng.model.bean.InspeccionBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;

//@Service
//@Slf4j
//public class InspeccionDaoImpl implements InspeccionDao {
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public InspeccionDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//
//    }
//}
//
//    public List<InspeccionBean> listarTipoEnvase (String tipoEnvase) {
//        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
//                .withCatalogName("PCKG_CERT_CUARENTENA")
//                .withProcedureName("SP_OBTENER_TIPO_ENVASE")
//                .withoutProcedureColumnMetaDataAccess()
//                .declareParameters(
//                        new SqlParameter("Tipo_Envase", Types.VARCHAR),
//                        new SqlOutParameter("Reg", Types.REF_CURSOR,
//                                new InspeccionRowMapper()));
//        SqlParameterSource prm = new MapSqlParameterSource()
//                .addValue("Tipo_Envase", tipoEnvase);
//        Map<String, Object> result = simpleJdbcCall.execute(prm);
//        List<InspeccionBean> beanList = (List) result.get("Reg");
//        return beanList;
//    }
//
//}
