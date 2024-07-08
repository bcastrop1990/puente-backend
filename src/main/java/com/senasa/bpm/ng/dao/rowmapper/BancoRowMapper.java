package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.BancoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoRowMapper implements RowMapper<BancoBean> {
  @Override
  public BancoBean mapRow(ResultSet rs, int i) throws SQLException {
    return BancoBean.builder()
            .codigo_Cta_Cte(rs.getString("CODIGO_CTA_CTE"))
            .nombre_Banco(rs.getString("NOMBRE_BANCO"))
            .numero_Cta(rs.getString("NUMERO_CTA"))
            .nombre(rs.getString("NOMBRE"))
            .build();
  }
}
