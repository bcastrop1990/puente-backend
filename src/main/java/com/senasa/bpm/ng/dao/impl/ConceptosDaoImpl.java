package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.ConceptosDao;
import com.senasa.bpm.ng.dao.TipoDocumentoDao;
import com.senasa.bpm.ng.dao.rowmapper.ListarProcedimientoRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.RepresentanteLegalRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.TipoDocumentoRowMapper;
import com.senasa.bpm.ng.model.bean.ListarProcedimientoBean;
import com.senasa.bpm.ng.model.bean.RepresentanteLegalBean;
import com.senasa.bpm.ng.model.bean.TipoDocumentoBean;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
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
public class ConceptosDaoImpl implements ConceptosDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConceptosDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<ListarProcedimientoBean> listarServicios (ListarProcedimientoRequest request) {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PCKG_GENERAL")
                    .withProcedureName("SP_SERVICIO_PROCEDMIENTO_AREA")
                    .withoutProcedureColumnMetaDataAccess()
                    .declareParameters(
                            new SqlParameter("Pproctupa", Types.VARCHAR),
                            new SqlOutParameter("Reg", Types.REF_CURSOR,
                                    new ListarProcedimientoRowMapper()),
                            new SqlParameter("p_Cod_Servicio", Types.VARCHAR));
            SqlParameterSource prm = new MapSqlParameterSource()
                    .addValue("Pproctupa", request.getPproctupa())
                    .addValue("p_Cod_Servicio", request.getP_Cod_Servicio());
            Map<String, Object> result = simpleJdbcCall.execute(prm);
            System.out.println("Result map: " + result);
            List<ListarProcedimientoBean> beanList = (List) result.get("Reg");
            return beanList;

    }

}
