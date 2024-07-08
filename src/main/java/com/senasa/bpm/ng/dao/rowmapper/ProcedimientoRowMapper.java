package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.ProcedimientoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedimientoRowMapper implements RowMapper<ProcedimientoBean> {
  @Override
  public ProcedimientoBean mapRow(ResultSet rs, int i) throws SQLException {
    return ProcedimientoBean.builder()
        .codigo_Procedimiento_Tupa(rs.getString("CODIGO_PROCEDIMIENTO_TUPA"))
        .descripcion_Procedimieto_Tupa(rs.getString("DESCRIPCION_PROCEDIMIETO_TUPA"))
        .indicador_Procedimiento_Espe(rs.getString("INDICADOR_PROCEDIMIENTO_ESPE"))
        .build();
  }
}
