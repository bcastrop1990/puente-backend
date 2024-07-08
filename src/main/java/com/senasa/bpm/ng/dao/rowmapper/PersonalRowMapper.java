package com.senasa.bpm.ng.dao.rowmapper;/*package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.SpObtenerPersonaDocumentoParam;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PersonalRowMapper implements RowMapper<SpObtenerPersonaDocumentoParam> {
  @Override
  public SpObtenerPersonaDocumentoParam mapRow(ResultSet rs, int i) throws SQLException {
    return SpObtenerPersonaDocumentoParam.builder()
        .ptidodoc(rs.getString("Documento_Tipo"))
        .pnumdoc(rs.getString("Documento_Numero"))
            .pnombre(rs.getString("Nombre_Razon_Social"))
        .build();
  }
}
*/