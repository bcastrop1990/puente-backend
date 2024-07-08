package com.senasa.bpm.ng.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.ObtenerDocuBean;

public class ObtenerDocuRowMapper implements RowMapper<ObtenerDocuBean> {
  @Override
  public ObtenerDocuBean mapRow(ResultSet rs, int i) throws SQLException {
    return ObtenerDocuBean.builder()
        .codigo_std_doc(rs.getString("CODIGO_STD_DOC"))
        .codigo_std_doc_adjunto(rs.getString("CODIGO_STD_DOC_ADJUNTO"))
        .codigo_tipo_documento(rs.getString("CODIGO_TIPO_DOCUMENTO"))
        .descripcion_documento(rs.getString("DESCRIPCION_DOCUMENTO"))
        .nombre(rs.getString("NOMBRE"))
        .indicador_obligatorio(rs.getString("INDICADOR_OBLIGATORIO"))
        .ucm_id(rs.getString("UCM_ID"))
        .confidencial(rs.getString("CONFIDENCIAL"))
        .numer_regi_arc(rs.getString("NUME_REGI_ARC"))
        .build();
  }
}
