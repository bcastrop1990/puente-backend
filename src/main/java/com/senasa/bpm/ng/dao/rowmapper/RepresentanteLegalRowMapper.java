package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.RepresentanteLegalBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepresentanteLegalRowMapper implements RowMapper<RepresentanteLegalBean> {
  @Override
  public RepresentanteLegalBean mapRow(ResultSet rs, int i) throws SQLException {
    return RepresentanteLegalBean.builder()
            .representante_Id(rs.getInt("REPRESENTANTE_ID"))
            .nombre_Razon_Social(rs.getString("NOMBRE_RAZON_SOCIAL"))
            .persona_Tipo(rs.getString("PERSONA_TIPO"))
            .documento_Tipo(rs.getString("DOCUMENTO_TIPO"))
            .documento_Numero(rs.getString("DOCUMENTO_NUMERO"))
            .apellido_Paterno(rs.getString("APELLIDO_PATERNO"))
            .apellido_Materno(rs.getString("APELLIDO_MATERNO"))
            .nombres(rs.getString("NOMBRES"))
            .direccion(rs.getString("DIRECCION"))
            .departamento_Id(rs.getString("DEPARTAMENTO_ID"))
            .nomb_Dpto_Dpt(rs.getString("NOMB_DPTO_DPT"))
            .provincia_Id(rs.getString("PROVINCIA_ID"))
            .nomb_Prov_Tpr(rs.getString("NOMB_PROV_TPR"))
            .distrito_Id(rs.getString("DISTRITO_ID"))
            .dodi_Dist_Tdi(rs.getString("CODI_DIST_TDI"))
            .telefono(rs.getString("TELEFONO"))
             .centro_Poblado_Id(rs.getString("CENTRO_POBLADO_ID"))
             .telefono_Movil(rs.getString("TELEFONO_MOVIL"))
             .correo_Electronico(rs.getString("CORREO_ELECTRONICO"))
             .referencia(rs.getString("REFERENCIA"))
             .estado(rs.getString("ESTADO"))
             .pais_Id(rs.getString("PAIS_ID"))
            .nombre_Razsoc_Comp(rs.getString("NOMBRE_RAZSOC_COMP"))


             // .estado_1(rs.getString("ESTADO"))
             .cargo(rs.getString("CARGO"))
              .persona_Id(rs.getString("PERSONA_ID"))

        .build();
  }
}
