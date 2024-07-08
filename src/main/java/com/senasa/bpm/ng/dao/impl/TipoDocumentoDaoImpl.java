package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.TipoDocumentoDao;
import com.senasa.bpm.ng.dao.rowmapper.*;
import com.senasa.bpm.ng.model.bean.*;
import com.senasa.bpm.ng.model.request.GrabarActReciboRequest;
import com.senasa.bpm.ng.model.request.GrabarInactivoRequest;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.*;

@Service
@Slf4j
@Transactional
public class TipoDocumentoDaoImpl implements TipoDocumentoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TipoDocumentoDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<TipoDocumentoBean> listarTipoDocumento() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GENERAL")
                .withProcedureName("SP_TIPO_DOCUMENTO")
                .declareParameters(
                        new SqlOutParameter("Reg", OracleTypes.CURSOR, new TipoDocumentoRowMapper())
                )
                .withoutProcedureColumnMetaDataAccess();

        SqlParameterSource in = new MapSqlParameterSource();
        Map<String, Object> result = simpleJdbcCall.execute(in);

        List<TipoDocumentoBean> beanList = (List<TipoDocumentoBean>) result.get("Reg");
        return beanList;
    }
    @Override
    public List<RepresentanteLegalBean> listarRepresentanteLegal (String repreLegal) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GENERAL")
                .withProcedureName("SP_OBTENER_REPRESENTANTE_LEGAL")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("p_Persona_Id", Types.VARCHAR),
                        new SqlOutParameter("Reg", Types.REF_CURSOR,
                                new RepresentanteLegalRowMapper()));
        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("p_Persona_Id", repreLegal);
        Map<String, Object> result = simpleJdbcCall.execute(prm);
        System.out.println("Result map: " + result);
        List<RepresentanteLegalBean> beanList = (List) result.get("Reg");
        return beanList;
    }


//    @Override
//    public List<GrabarInactivoBean> grabarInactivo(GrabarInactivoRequest request) {
//        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
//                .withCatalogName("PCKG_GRABAR")
//                .withProcedureName("Sp_Grabar_Inactivo")
//                .withoutProcedureColumnMetaDataAccess()
//                .useInParameterNames("Pcentrotramite", "Pcanal", "Ppersonaid", "Ppersonaidotro", "Pprocedimientotupa", "Puserid", "Ppersonaidsolicitante", "Prepresentanteid", "Pcodexpediente", "Pdetallerecibo", "Pdetallevacuna", "Ppagorecibo", "Pcodorden")
//                .declareParameters(
//                        new SqlParameter("Pcentrotramite", Types.VARCHAR),
//                        new SqlParameter("Pcanal", Types.VARCHAR),
//                        new SqlParameter("Ppersonaid", Types.VARCHAR),
//                        new SqlParameter("Ppersonaidotro", Types.VARCHAR),
//                        new SqlParameter("Pprocedimientotupa", Types.VARCHAR),
//                        new SqlParameter("Puserid", Types.VARCHAR),
//                        new SqlParameter("Ppersonaidsolicitante", Types.VARCHAR),
//                        new SqlParameter("Prepresentanteid", Types.VARCHAR),
//                        new SqlInOutParameter("Pcodexpediente", Types.VARCHAR),
//                        new SqlOutParameter("Pcodsolicitud", Types.VARCHAR),
//                        new SqlOutParameter("Pcodrecibo", Types.VARCHAR),
//                        new SqlOutParameter("Pcodigostddoc", Types.VARCHAR),
//                        new SqlParameter("Pdetallerecibo", Types.VARCHAR),
//                        new SqlParameter("Pdetallevacuna", Types.VARCHAR, null), // Asume NULL como valor por defecto
//                        new SqlParameter("Ppagorecibo", Types.VARCHAR),
//                        new SqlParameter("Pcodorden", Types.VARCHAR, null) // Asume NULL como valor por defecto
//                );
//
//        Map<String, Object> inParams = new HashMap<>();
//        inParams.put("Pcentrotramite", request.getPcentrotramite());
//        inParams.put("Pcanal", request.getPcanal());
//        inParams.put("Ppersonaid", request.getPpersonaid());
//        inParams.put("Ppersonaidotro", request.getPpersonaidotro());
//        inParams.put("Pprocedimientotupa", request.getPprocedimientotupa());
//        inParams.put("Puserid", request.getPuserid());
//        inParams.put("Ppersonaidsolicitante", request.getPpersonaidsolicitante());
//        inParams.put("Prepresentanteid", request.getPrepresentanteid());
//        inParams.put("Pcodexpediente", request.getPcodexpediente()); // Parámetro de entrada/salida
//        inParams.put("Pdetallerecibo", request.getPdetallerecibo());
//        inParams.put("Pdetallevacuna", request.getPdetallevacuna());
//        inParams.put("Ppagorecibo", request.getPpagorecibo());
//        inParams.put("Pcodorden", request.getPcodorden());
//
//        Map<String, Object> out = simpleJdbcCall.execute(inParams);
//
//        List<GrabarInactivoBean> response = new ArrayList<>();
//        GrabarInactivoBean bean = new GrabarInactivoBean();
//        bean.setPcodexpediente((String) out.get("Pcodexpediente"));
//        bean.setPcodsolicitud((String) out.get("Pcodsolicitud"));
//        bean.setPcodrecibo((String) out.get("Pcodrecibo"));
//        bean.setPcodigostddoc((String) out.get("Pcodigostddoc"));
//        response.add(bean);
//
//        return response;
//    }


}
