package com.senasa.bpm.ng.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.bean.ReggridBean;

public class ReggridBeanRowMapper implements RowMapper<ReggridBean> {
  @Override
  public ReggridBean mapRow(ResultSet rs, int i) throws SQLException {
    return ReggridBean.builder()
        .secuencial(rs.getString("SECUENCIAL"))
        .fecha_Hora(rs.getString("FECHA_HORA"))
        .estado(rs.getString("ESTADO"))
        .remitente(rs.getString("REMITENTE"))
        .destinatario(rs.getString("DESTINATARIO"))
        .proveido(rs.getString("PROVEIDO"))
        .build();
      }
  }
