package com.senasa.bpm.ng.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.senasa.bpm.ng.model.bean.ExpedienteBean;

public class ExpedienteRowMapper implements RowMapper<ExpedienteBean>{
	@Override
	  public ExpedienteBean mapRow(ResultSet rs, int i) throws SQLException {
	    return ExpedienteBean.builder()
	        .codigo_Expediente(rs.getString("CODIGO_EXPEDIENTE"))
	        .fecha_Registro(rs.getString("FECHA_REGISTRO"))
	        .codigo_Centro_Tramite(rs.getString("CODIGO_CENTRO_TRAMITE"))
	        .descripcion_Centro_Tramite(rs.getString("DESCRIPCION_CENTRO_TRAMITE"))
	        .codigo_Servicio(rs.getString("CODIGO_SERVICIO"))
	        .codigo_Solicitud(rs.getString("CODIGO_SOLICITUD"))
	        .descripcion_Area_Gestion(rs.getString("DESCRIPCION_AREA_GESTION"))
	        .descripcion_Procedimieto_Tupa(rs.getString("DESCRIPCION_PROCEDIMIETO_TUPA"))
	        .descripcion_Servicio(rs.getString("DESCRIPCION_SERVICIO"))
	        .persona_Id(rs.getString("PERSONA_ID"))
	        .nombre_Razon_Social(rs.getString("NOMBRE_RAZON_SOCIAL"))
	        .confidencial(rs.getString("CONFIDENCIAL"))
	    	.estado_expediente(rs.getString("ESTADO_EXPEDIENTE"))
	        /*.codigo_Solicitud(rs.getString("CODIGO_SOLICITUD"))
	        .ucm_Id(rs.getString("UCM_ID"))
	        .codigo_Procedimiento_Tupa(rs.getString("CODIGO_PROCEDIMIENTO_TUPA"))
	        */
	        .build();
	  }
}
