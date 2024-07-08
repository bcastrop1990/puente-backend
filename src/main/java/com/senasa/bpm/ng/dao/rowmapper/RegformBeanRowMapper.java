package com.senasa.bpm.ng.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.bean.RegformBean;

public class RegformBeanRowMapper implements RowMapper<RegformBean> {
  @Override
  public RegformBean mapRow(ResultSet rs, int i) throws SQLException {
    return RegformBean.builder()
        .id_Proceso(rs.getString("ID_PROCESO"))
        .id_Original(rs.getString("ID_ORIGINAL"))
        .tipo(rs.getString("TIPO"))
        .id_Final(rs.getString("ID_FINAL"))
        .asunto(rs.getString("ASUNTO"))
        .canal(rs.getString("CANAL"))
        .build();
      }
  }
