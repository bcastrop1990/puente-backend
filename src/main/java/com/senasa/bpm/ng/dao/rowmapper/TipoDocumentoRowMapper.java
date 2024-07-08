package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.TipoDocumentoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoDocumentoRowMapper implements RowMapper<TipoDocumentoBean> {
  @Override
  public TipoDocumentoBean mapRow(ResultSet rs, int i) throws SQLException {
    return TipoDocumentoBean.builder()
        .codigdocumento(rs.getString("CODIGO_DOCUMENTO"))
        .descripcionTipoDocumento(rs.getString("DESCRIPCION_TIPO_DOCUMENTO"))
        .descripcionCompleta(rs.getString("DESCRIPCION_COMPLETA"))
        .build();
  }
}
