package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.FirmarCerrarExpedienteBean;
import com.senasa.bpm.ng.model.bean.ObtenerDocuBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FirmarCerrarExpRowMapper implements RowMapper<FirmarCerrarExpedienteBean> {
  @Override
  public FirmarCerrarExpedienteBean mapRow(ResultSet rs, int i) throws SQLException {
    return FirmarCerrarExpedienteBean.builder()
        .cod_idioma(rs.getString("cod_idioma"))
        .fg_varios(rs.getString("fg_varios"))
        .tot_productos(rs.getString("tot_productos"))
        .codigo_iiv(rs.getString("codigo_iiv"))
        .secuencial(rs.getString("secuencial"))
        .codstddoc(rs.getString("codstddoc"))
        .plantilla(rs.getString("plantilla"))
        .build();
  }
}
