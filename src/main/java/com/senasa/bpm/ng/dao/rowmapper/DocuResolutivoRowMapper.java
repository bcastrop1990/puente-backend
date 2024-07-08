package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.DerivacionPersonalBean;
import com.senasa.bpm.ng.model.bean.DocuResolutivoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DocuResolutivoRowMapper implements RowMapper<DerivacionPersonalBean> {
  @Override
  public DerivacionPersonalBean mapRow(ResultSet rs, int i) throws SQLException {
    return DerivacionPersonalBean.builder()
        .usuario(rs.getString("USUARIO"))
        .nombre_persona(rs.getString("NOMBRE_PERSONA"))
        .build();
  }
}
