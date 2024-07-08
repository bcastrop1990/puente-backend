package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.AreaDao;
import com.senasa.bpm.ng.dao.RequisitoDao;
import com.senasa.bpm.ng.dao.rowmapper.AreaRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.ProcedimientoRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.RequisitoRowMapper;
import com.senasa.bpm.ng.model.bean.ArchivarBean;
import com.senasa.bpm.ng.model.bean.AreaBean;
import com.senasa.bpm.ng.model.bean.ProcedimientoBean;
import com.senasa.bpm.ng.model.bean.RequisitoBean;
import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.FinalizarProcesoRequest;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class RequisitoDaoImpl implements RequisitoDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public RequisitoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RequisitoBean> listarRequisitos(String pcodexpediente){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_SERVICIO")
                .withProcedureName("SP_REQUSITOS_DOCUMENTARIOS_EXP")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("pcodexpediente", Types.VARCHAR),
                        new SqlOutParameter("Reg", Types.REF_CURSOR,
                                new RequisitoRowMapper()));
        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("pcodexpediente", pcodexpediente);
        Map<String, Object> result = simpleJdbcCall.execute(prm);
        List<RequisitoBean> beanList = (List) result.get("Reg");
        return beanList;
    }

    @Override
    public List<ArchivarBean> archivar(ArchivarRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("Sp_Generar_Info_Trazabilidad")
                .withoutProcedureColumnMetaDataAccess() // Evitar problemas de metadatos
                .useInParameterNames("Pidfinal", "Pserviciotupa", "Pidremitente", "Piddestinatario")
                .declareParameters(
                        new SqlParameter("Pidfinal", Types.VARCHAR),
                        new SqlParameter("Pserviciotupa", Types.VARCHAR),
                        new SqlParameter("Pidremitente", Types.VARCHAR),
                        new SqlParameter("Piddestinatario", Types.VARCHAR),
                        new SqlOutParameter("Pareadestinatario", Types.VARCHAR),
                        new SqlOutParameter("Psubareadestinatario", Types.VARCHAR),
                        new SqlOutParameter("Parearemitente", Types.VARCHAR),
                        new SqlOutParameter("Psubarearemitente", Types.VARCHAR),
                        new SqlOutParameter("Psecuencial", Types.VARCHAR),
                        new SqlOutParameter("Urgencia", Types.VARCHAR),
                        new SqlOutParameter("Reg", OracleTypes.CURSOR, new RowMapper<Object>() {
                            public ArchivarBean mapRow(ResultSet rs, int rowNum) throws SQLException {
                                return ArchivarBean.builder()
                                        .codigo_Servicio(rs.getString("Codigo_Servicio"))
                                        .descripcion_Servicio(rs.getString("Descripcion_Servicio"))
                                        .codigo_Tipo_Servicio(rs.getString("Codigo_Tipo_Servicio"))
                                        .descripcion_Tipo_Servicio(rs.getString("Descripcion_Tipo_Servicio"))
                                        .build();
                            }
                        })
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("Pidfinal", request.getPidfinal());
        inParams.put("Pserviciotupa", request.getPserviciotupa());
        inParams.put("Pidremitente", request.getPidremitente());
        inParams.put("Piddestinatario", request.getPiddestinatario());

        Map<String, Object> out = simpleJdbcCall.execute(inParams);

        List<ArchivarBean> response = new ArrayList<>();
        response.add(ArchivarBean.builder()
                .pareadestinatario((String) out.get("Pareadestinatario"))
                .psubareadestinatario((String) out.get("Psubareadestinatario"))
                .parearemitente((String) out.get("Parearemitente"))
                .psubarearemitente((String) out.get("Psubarearemitente"))
                .psecuencial((String) out.get("Psecuencial"))
                .urgencia((String) out.get("Urgencia"))
                .build());
        // Añadir los resultados del cursor al response
        List<ArchivarBean> regResults = (List<ArchivarBean>) out.get("Reg");
        response.addAll(regResults);

        return response;
    }


    @Override
    public String actualizarDocumentoHijo(String pnombrestd, String pucmid) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("Sp_Act_Ucm_Std_Documento_Hijo")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("Pnombrestd", Types.VARCHAR),
                        new SqlParameter("Pucmid", Types.VARCHAR));

        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("Pnombrestd", pnombrestd)
                .addValue("Pucmid", pucmid);

        simpleJdbcCall.execute(prm);
        return "Actualización corretca.";
    }

    @Override
    public String finalizarProceso(FinalizarProcesoRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("FINALBPM.PCKG_GRABAR")
                .withProcedureName("Sp_Grabar_Activo")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("Pcodexpediente", Types.VARCHAR),
                        new SqlParameter("Pusuario", Types.VARCHAR),
                        new SqlParameter("Pdocumentos", Types.VARCHAR),
                        new SqlParameter("Pcanal", Types.VARCHAR),
                        new SqlOutParameter("Pnombrestd", Types.VARCHAR) // Manteniendo como VARCHAR ya que es IN OUT y parece ser un identificador
                );

        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("Pcodexpediente", request.getPcodexpediente())
                .addValue("Pusuario", request.getPusuario())
                .addValue("Pdocumentos", request.getPdocumentos())
                .addValue("Pcanal", request.getPcanal());

        Map<String, Object> result = simpleJdbcCall.execute(prm);
        return (String) result.get("Pnombrestd");
    }




}
