package com.senasa.bpm.ng.dao.rowmapper;

import com.senasa.bpm.ng.model.bean.GrabarActReciboBean;
import com.senasa.bpm.ng.model.bean.ProcedimientoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GrabarActReciboRowMapper implements RowMapper<GrabarActReciboBean> {
  @Override
  public GrabarActReciboBean mapRow(ResultSet rs, int i) throws SQLException {
    return GrabarActReciboBean.builder()
            .codigo_Expediente(rs.getString("codigo_Expediente"))
            .fecha_Registro(rs.getString("fecha_Registro"))
            .codigo_Centro_Tramite(rs.getString("codigo_Centro_Tramite"))
            .descripcion_Centro_Tramite(rs.getString("descripcion_Centro_Tramite"))
            .codigo_Servicio(rs.getString("codigo_Servicio"))
            .descripcion_Area_Gestion(rs.getString("descripcion_Area_Gestion"))
            .descripcion_Procedimiento_Tupa(rs.getString("descripcion_Procedimieto_Tupa"))
            .descripcion_Servicio(rs.getString("descripcion_Servicio"))
            .persona_Id(rs.getString("persona_Id"))
            .nombre_Razon_Social(rs.getString("nombre_Razon_Social"))
            .codigo_Solicitud(rs.getString("codigo_Solicitud"))
            .ucm_Id(rs.getString("ucm_Id"))
            .codigo_Procedimiento_Tupa(rs.getString("codigo_Procedimiento_Tupa"))
            .nume_Regi_Arc(rs.getString("nume_Regi_Arc"))
            .orden_Vuce(rs.getString("orden_Vuce"))
            .canal(rs.getString("canal"))
            .codigo_Std_Doc(rs.getString("codigo_Std_Doc"))
            .numero_Folios(rs.getString("numero_Folios"))
            .confidencial(rs.getString("confidencial"))
            .codigo_Tupa(rs.getString("codigo_Tupa"))
            .cod_Formato(rs.getString("cod_Formato"))
            .estado(rs.getString("estado"))
            .estado_expediente(rs.getString("estado_expediente"))
            .tipo_certificado(rs.getString("tipo_certificado"))
            .oea_tipo_operador(rs.getString("oea_tipo_operador"))
            .oea_tipo_atencion(rs.getString("oea_tipo_atencion"))
            .build();

  }
}
