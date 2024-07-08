package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InspeccionRowMapper implements RowMapper<AgregarDocuBean> {
  @Override
  public AgregarDocuBean mapRow(ResultSet rs, int i) throws SQLException {
    return AgregarDocuBean.builder()
        .codigo_Documento(rs.getString("CODIGO_DOCUMENTO"))
        .descripcion_Corta(rs.getString("DESCRIPCION_CORTA"))
        .build();
  }
}
