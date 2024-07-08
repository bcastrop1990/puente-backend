package com.senasa.bpm.ng.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.DetalleDerivacionBean;
import com.senasa.bpm.ng.model.bean.ObtenerInfoAdjuntosBean;

public class ObtenerInfoAdjuntosRowMapper implements RowMapper<ObtenerInfoAdjuntosBean> {
  @Override
  public ObtenerInfoAdjuntosBean mapRow(ResultSet rs, int i) throws SQLException {
    return ObtenerInfoAdjuntosBean.builder()
        .nombre(rs.getString("NOMBRE"))
        .ucm_id(rs.getString("UCM_ID"))
        .build();
  }
}
