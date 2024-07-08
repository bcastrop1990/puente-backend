package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.AreaBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaRowMapper implements RowMapper<AreaBean> {
  @Override
  public AreaBean mapRow(ResultSet rs, int i) throws SQLException {
    return AreaBean.builder()
        .codigo_Area_Gestion(rs.getString("CODIGO_AREA_GESTION"))
        .descripcion_Area_Gestion(rs.getString("DESCRIPCION_AREA_GESTION"))
        .codigo_Clase(rs.getString("CODIGO_CLASE"))
        .build();
  }
}
