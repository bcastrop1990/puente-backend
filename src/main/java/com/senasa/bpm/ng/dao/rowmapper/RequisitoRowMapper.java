package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.ProcedimientoBean;
import com.senasa.bpm.ng.model.bean.RequisitoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequisitoRowMapper implements RowMapper<RequisitoBean> {
  @Override
  public RequisitoBean mapRow(ResultSet rs, int i) throws SQLException {
    return RequisitoBean.builder()
        .codigo_Servicio(rs.getString("codigo_Servicio"))
        .descripcion_Servicio(rs.getString("descripcion_Servicio"))
        .codigo_Documento(rs.getString("codigo_Documento"))
        .descripcion_Documento(rs.getString("descripcion_Documento"))
        .indicador_Obligatorio(rs.getString("indicador_Obligatorio"))
        .sub_Tipo(rs.getString("sub_Tipo"))
        .ruta_Check_In(rs.getString("ruta_Check_In"))
        .build();
  }
}
