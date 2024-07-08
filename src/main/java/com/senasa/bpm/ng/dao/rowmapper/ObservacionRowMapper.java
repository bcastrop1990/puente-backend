package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.ObservacionBean;
import com.senasa.bpm.ng.model.bean.ReggridBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObservacionRowMapper implements RowMapper<ObservacionBean> {
  @Override
  public ObservacionBean mapRow(ResultSet rs, int i) throws SQLException {
    return ObservacionBean.builder()
        .fecha_Hora(rs.getString("FECHA_HORA"))
        .notas(rs.getString("NOTAS"))
        .remitente_Entidad(rs.getString("REMITENTE_ENTIDAD"))
        .urgencia(rs.getString("urgencia"))
        .ucm_id(rs.getString("UCM_ID"))
        .build();
      }
  }
