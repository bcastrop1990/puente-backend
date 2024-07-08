package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.PersonaBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDocumentoRowMapper implements RowMapper<PersonaBean> {
  @Override
  public PersonaBean mapRow(ResultSet rs, int i) throws SQLException {
    return PersonaBean.builder()
            .persona_Id(rs.getString("persona_Id"))
            .nombre_Razon_Social(rs.getString("nombre_Razon_Social"))
            .persona_Tipo(rs.getString("persona_Tipo"))
            .documento_Tipo(rs.getString("documento_Tipo"))
            .documento_Numero(rs.getString("documento_Numero"))
            .apellido_Paterno(rs.getString("apellido_Paterno"))
            .apellido_Materno(rs.getString("apellido_Materno"))
            .nombres(rs.getString("nombres"))
            .direccion(rs.getString("direccion"))
            .departamento_Id(rs.getString("departamento_Id"))
            .nomb_Dpto_Dpt(rs.getString("nomb_Dpto_Dpt"))
            .provincia_Id(rs.getString("provincia_Id"))
            .nomb_Prov_Tpr(rs.getString("nomb_Prov_Tpr"))
            .distrito_Id(rs.getString("distrito_Id"))
            .nomb_Dist_Tdi(rs.getString("nomb_Dist_Tdi"))
            .telefono(rs.getString("telefono"))
            .centro_Poblado_Id(rs.getString("centro_Poblado_Id"))
            .telefono_Movil(rs.getString("telefono_Movil"))
            .correo_Electronico(rs.getString("correo_Electronico"))
            .referencia_Direccion(rs.getString("Referencia"))
            .estado(rs.getString("estado"))
            .pais_Id(rs.getString("pais_Id"))
            .fecha_Nacimiento(rs.getString("fecha_Nacimiento"))
            .nombre_Razsoc_Comp(rs.getString("nombre_Razsoc_Comp"))
            .regi_Padr_Emp(rs.getString("nombre_Razsoc_Comp"))
            .build();

  }
}
