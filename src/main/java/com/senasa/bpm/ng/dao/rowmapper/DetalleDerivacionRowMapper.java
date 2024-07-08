package com.senasa.bpm.ng.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.DetalleDerivacionBean;

public class DetalleDerivacionRowMapper implements RowMapper<DetalleDerivacionBean> {
  @Override
  public DetalleDerivacionBean mapRow(ResultSet rs, int i) throws SQLException {
    return DetalleDerivacionBean.builder()
        .notas(rs.getString("NOTAS"))
        .fech_Crea(rs.getString("FECH_CREA"))
        .remitente_Usuario(rs.getString("REMITENTE_USUARIO"))
        .remitente_Persona(rs.getString("REMITENTE_PERSONA"))
        .ucm_id(rs.getString("UCM_ID"))
        .build();
  }
}
