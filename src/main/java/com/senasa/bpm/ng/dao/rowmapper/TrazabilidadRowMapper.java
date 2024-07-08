package com.senasa.bpm.ng.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.senasa.bpm.ng.model.bean.ExpedienteTrazabilidadBean;

public class TrazabilidadRowMapper implements RowMapper<ExpedienteTrazabilidadBean> {
  @Override
  public ExpedienteTrazabilidadBean mapRow(ResultSet rs, int i) throws SQLException {
	 
    return ExpedienteTrazabilidadBean.builder()
        .autoridad_Aprueba(rs.getString("Autoridad_Aprueba"))
        .autoridad_Resuelve(rs.getString("Autoridad_Resuelve"))
        .codigo_Clase(rs.getString("Codigo_Clase"))
        .codigo_Servicio(rs.getString("Codigo_Servicio"))
        .codigo_Tipo_Servicio(rs.getString("Codigo_Tipo_Servicio"))
        .descripcion_Clase(rs.getString("Descripcion_Clase"))
        .descripcion_Servicio(rs.getString("Descripcion_Servicio"))
        .descripcion_Tipo_Servicio(rs.getString("Descripcion_Tipo_Servicio"))
        .estado(rs.getString("Estado"))
        .nombre_Corto_Servicio(rs.getString("Nombre_Corto_Servicio"))
        .plazo_Tupa(rs.getString("Plazo_Tupa"))
        .build();
  }
}
