package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.TipoPagoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoPagoRowMapper implements RowMapper<TipoPagoBean> {

  @Override
  public TipoPagoBean mapRow(ResultSet rs, int i) throws SQLException {
    return TipoPagoBean.builder()
            .codigo_Tipo_Pago(rs.getString("CODIGO_TIPO_PAGO"))
            .descripcion_Tipo_Pago(rs.getString("DESCRIPCION_TIPO_PAGO"))
            .build();
  }
}
