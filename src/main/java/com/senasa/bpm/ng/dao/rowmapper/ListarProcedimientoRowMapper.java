package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.ListarProcedimientoBean;
import com.senasa.bpm.ng.model.bean.ProcedimientoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarProcedimientoRowMapper implements RowMapper<ListarProcedimientoBean> {
  @Override
  public ListarProcedimientoBean mapRow(ResultSet rs, int i) throws SQLException {
    return ListarProcedimientoBean.builder()
        .codigo_Servicio_Tupa(rs.getString("CODIGO_SERVICIO_TUPA"))
        .descripcion_Servicio(rs.getString("DESCRIPCION_SERVICIO"))
        .indicador_Otro(rs.getString("INDICADOR_OTRO"))
            .tipo_Servicio(rs.getString("TIPO_SERVICIO"))
        .build();
  }
}
