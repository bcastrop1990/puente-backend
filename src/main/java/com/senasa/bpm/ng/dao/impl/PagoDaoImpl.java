package com.senasa.bpm.ng.dao.impl;

import com.senasa.bpm.ng.dao.PagoDao;
import com.senasa.bpm.ng.dao.rowmapper.BancoRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.ProcedimientoRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.TipoPagoRowMapper;
import com.senasa.bpm.ng.model.bean.BancoBean;
import com.senasa.bpm.ng.model.bean.ProcedimientoBean;
import com.senasa.bpm.ng.model.bean.TipoPagoBean;
import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
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
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class PagoDaoImpl implements PagoDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public PagoDaoImpl(JdbcTemplate jdbcTemplate) {
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
    @Override
    public List<BancoBean> listarBanco() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_RECIBO")
                .withProcedureName("Sp_Obtener_Banco_Cta")
                .declareParameters(
                        new SqlOutParameter("Reg", OracleTypes.CURSOR, new BancoRowMapper())
                )
                .withoutProcedureColumnMetaDataAccess();

        SqlParameterSource in = new MapSqlParameterSource();
        Map<String, Object> result = simpleJdbcCall.execute(in);

        List<BancoBean> beanList = (List<BancoBean>) result.get("Reg");
        return beanList;
    }


//    @Override
//    public BigDecimal calcularMontoConcepto(CalcularMontoRequest request) {
//        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
//                .withCatalogName("PCKG_GENERAL")
//                .withProcedureName("Sp_Calculo_Monto_Concepto")
//                .withoutProcedureColumnMetaDataAccess()
//                .declareParameters(
//                        new SqlParameter("Pcodservicio", Types.VARCHAR),
//                        new SqlParameter("Pcantidad", Types.VARCHAR),
//                        new SqlParameter("Ptramaproductos", Types.VARCHAR),
//                        new SqlParameter("Ptramavacunas", Types.VARCHAR),
//                        new SqlParameter("Ptramaanalisis", Types.VARCHAR),
//                        new SqlOutParameter("Reg", Types.VARCHAR));
//        SqlParameterSource prm = new MapSqlParameterSource()
//                .addValue("Pcodservicio", request.getPcodservicio())
//                .addValue("Pcantidad", request.getPcantidad())
//                .addValue("Ptramaproductos", request.getPtramaproductos())
//                .addValue("Ptramavacunas", request.getPtramavacunas())
//                .addValue("Ptramaanalisis", request.getPtramaanalisis());
//        Map<String, Object> result = simpleJdbcCall.execute(prm);
//        BigDecimal resultado = (BigDecimal) result.get("Reg");
//        return resultado;
//    }
@Override
public BigDecimal calcularMontoConcepto(CalcularMontoRequest request) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
            .withCatalogName("PCKG_GENERAL")
            .withProcedureName("Sp_Calculo_Monto_Concepto")
            .withoutProcedureColumnMetaDataAccess()
            .declareParameters(
                    new SqlParameter("Pcodservicio", Types.VARCHAR),
                    new SqlParameter("Pcantidad", Types.VARCHAR),
                    new SqlParameter("Ptramaproductos", Types.VARCHAR),
                    new SqlParameter("Ptramavacunas", Types.VARCHAR),
                    new SqlParameter("Ptramaanalisis", Types.VARCHAR),
                    new SqlOutParameter("Reg", OracleTypes.CURSOR));  // Usa OracleTypes.CURSOR para el tipo SYS_REFCURSOR

    SqlParameterSource prm = new MapSqlParameterSource()
            .addValue("Pcodservicio", request.getPcodservicio())
            .addValue("Pcantidad", request.getPcantidad())
            .addValue("Ptramaproductos", request.getPtramaproductos())
            .addValue("Ptramavacunas", request.getPtramavacunas())
            .addValue("Ptramaanalisis", request.getPtramaanalisis());


    Map<String, Object> result = simpleJdbcCall.execute(prm);
    BigDecimal monto = null;
// Procesar el resultado
    List<Map<String, Object>> cursorResult = (List<Map<String, Object>>) result.get("Reg");

    for (Map<String, Object> row : cursorResult) {
        // Accede al valor de la columna "MONTO" y conviértelo a BigDecimal
        monto = (BigDecimal) row.get("MONTO");
        System.out.println("Monto: " + monto);
    }

    return monto;

}

    @Override
    public String calcularMontoMinimo(CalcularMontoRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GENERAL")
                .withProcedureName("Sp_Calculo_Monto_Concepto1")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("Pareagestion", Types.VARCHAR),
                        new SqlParameter("Indicadorprocedimientognrl", Types.VARCHAR),
                        new SqlOutParameter("Reg", Types.VARCHAR));
        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("Pcodservicio", request.getPcodservicio())
                .addValue("Pcantidad", request.getPcantidad())
                .addValue("Ptramaproductos", request.getPtramaproductos())
                .addValue("Ptramavacunas", request.getPtramavacunas())
                .addValue("Ptramaanalisis", request.getPtramaanalisis());
        Map<String, Object> result = simpleJdbcCall.execute(prm);
        String resultado = (String) result.get("Reg");
        return resultado;
    }

}
