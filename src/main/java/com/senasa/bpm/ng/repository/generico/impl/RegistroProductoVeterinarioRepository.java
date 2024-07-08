package com.senasa.bpm.ng.repository.generico.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.senasa.bpm.ng.model.generico.ConsultaFabExpediente;
import com.senasa.bpm.ng.model.generico.DatosBean;
import com.senasa.bpm.ng.model.generico.SolicitanteRegFabConsulta;
import com.senasa.bpm.ng.model.generico.SolicitudRegistroProductosVeterinarios;
import com.senasa.bpm.ng.model.generico.SolicitudRenovacionProductosVeterinarios;
import com.senasa.bpm.ng.repository.generico.IRegistroProductoVeterinarioRepository;

import com.senasa.bpm.ng.repository.mapper.generico.*;

import oracle.jdbc.OracleTypes;

@Repository
public class RegistroProductoVeterinarioRepository implements IRegistroProductoVeterinarioRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public RegistroProductoVeterinarioRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Value("${shema}")
	String esquema;
	//registro
	@Override
	public SolicitudRegistroProductosVeterinarios RetornaSolicitudRegistroProductosVeterinarios(
			SolicitudRegistroProductosVeterinarios solicitudRegistroProductosVeterinarios) {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("pckg_dip_productos").withProcedureName("sp_registrar_sol_farmacosvet")
				.declareParameters(
						new SqlOutParameter("p_Rregi_Soli_Pro", OracleTypes.VARCHAR, new String()),
						new SqlParameter("p_Anno_Regi_Pro", OracleTypes.VARCHAR),
						new SqlParameter("p_Codi_Sede_Sed", OracleTypes.VARCHAR),
						new SqlParameter("p_Codi_Empl_Per", OracleTypes.VARCHAR),
						new SqlParameter("p_Regi_Padr_Emp", OracleTypes.VARCHAR),
						new SqlParameter("p_Repr_Lega_Pro", OracleTypes.VARCHAR),
						new SqlParameter("p_Titu_Regi_Pro", OracleTypes.VARCHAR),
						new SqlParameter("p_Nomb_Come_Pro", OracleTypes.VARCHAR),
						new SqlParameter("p_Tipo_Prod_Pro", OracleTypes.VARCHAR),
						new SqlParameter("p_Nume_Regi_Pra", OracleTypes.VARCHAR),
						new SqlParameter("p_Codi_Tipo_Far", OracleTypes.VARCHAR),
						new SqlParameter("p_Codi_Pres_Far", OracleTypes.VARCHAR),
						new SqlParameter("p_Formula", OracleTypes.VARCHAR),
						new SqlParameter("p_User_Crea", OracleTypes.VARCHAR),
						new SqlParameter("p_Reci_Sena_Pro", OracleTypes.VARCHAR),
						new SqlParameter("p_Nume_Expediente", OracleTypes.VARCHAR),
						new SqlParameter("p_Representante_Id", OracleTypes.VARCHAR),
						new SqlParameter("p_Codigosolicitud", OracleTypes.VARCHAR),
						new SqlParameter("p_Reg_Resp_Tecnico", OracleTypes.VARCHAR),
						new SqlParameter("p_Flag_Ext_Titu", OracleTypes.VARCHAR),
						new SqlParameter("p_Cod_Pais_Titular", OracleTypes.VARCHAR),
						new SqlParameter("p_Direccion_Titular", OracleTypes.VARCHAR),
						new SqlParameter("p_Doc_Num_Titular", OracleTypes.VARCHAR),
						new SqlParameter("p_Departamento_Id", OracleTypes.VARCHAR),
						new SqlParameter("p_Provincia_Id", OracleTypes.VARCHAR),
						new SqlParameter("p_Distrito_Id", OracleTypes.VARCHAR),
						new SqlParameter("p_Telefono_Titular", OracleTypes.VARCHAR),
						new SqlParameter("p_Accion", OracleTypes.VARCHAR),
						new SqlParameter("p_Flag_Ext_Fabri", OracleTypes.VARCHAR),
						new SqlParameter("p_Num_Registro_Titu", OracleTypes.VARCHAR),
						new SqlOutParameter("p_Mensaje", OracleTypes.VARCHAR)
						
						)
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource()
				.addValue("p_Anno_Regi_Pro", solicitudRegistroProductosVeterinarios.getAnno())
				.addValue("p_Codi_Sede_Sed", "")
				.addValue("p_Codi_Empl_Per", "")
				.addValue("p_Regi_Padr_Emp", "")
				.addValue("p_Repr_Lega_Pro", "")
				.addValue("p_Titu_Regi_Pro", "")
				.addValue("p_Nomb_Come_Pro", "")
				.addValue("p_Tipo_Prod_Pro", "")
				.addValue("p_Nume_Regi_Pra", "")
				.addValue("p_Codi_Tipo_Far", "")
				.addValue("p_Codi_Pres_Far", "")
				.addValue("p_Formula", "")
				.addValue("p_User_Crea", "")
				.addValue("p_Reci_Sena_Pro", "")
				.addValue("p_Nume_Expediente", "")
				.addValue("p_Representante_Id", "")
				.addValue("p_Codigosolicitud", "")
				.addValue("p_Reg_Resp_Tecnico", "")
				.addValue("p_Flag_Ext_Titu", "")
				.addValue("p_Cod_Pais_Titular", "")
				.addValue("p_Direccion_Titular", "")
				.addValue("p_Doc_Num_Titular", "")
				.addValue("p_Departamento_Id", "")
				.addValue("p_Provincia_Id", "")
				.addValue("p_Distrito_Id", "")
				.addValue("p_Telefono_Titular", "")
				.addValue("p_Accion", "")
				.addValue("p_Flag_Ext_Fabri", "")
				.addValue("p_Num_Registro_Titu", "")
				;
		Map<String, Object> result = simpleJdbcCall.execute(prm);		
		String registro = (String) result.get("p_Rregi_Soli_Pro");
		String mensaje = (String) result.get("p_Mensaje");
		solicitudRegistroProductosVeterinarios.setCodigoSolicitudProducto(registro);
		solicitudRegistroProductosVeterinarios.setMensaje(mensaje);
		return solicitudRegistroProductosVeterinarios;
	}
//consulta
	@Override
	public SolicitudRenovacionProductosVeterinarios RetornaRenovacionProductosVeterinarios(
			SolicitudRenovacionProductosVeterinarios solicitudRenovacionProductosVeterinarios) {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(esquema)
				.withCatalogName("pckg_dip_productos").withProcedureName("SP_OBTENER_SOL_FARMACOSVET")
				.declareParameters(
						new SqlParameter("p_Rregi_Soli_Pro", OracleTypes.VARCHAR),
						new SqlParameter("p_Anno_Regi_Pro", OracleTypes.VARCHAR),
						new SqlParameter("p_Num_Regi_Pro", OracleTypes.VARCHAR),
						new SqlParameter("p_Cod_Expediente", OracleTypes.VARCHAR),
						new SqlOutParameter("p_Mensaje", OracleTypes.VARCHAR,new String()),
						new SqlOutParameter("p_Especies", OracleTypes.VARCHAR,new String()),
						new SqlOutParameter("p_Fabricante", OracleTypes.VARCHAR,new String()),
						new SqlOutParameter("p_Pais", OracleTypes.VARCHAR,new String()),
						new SqlOutParameter("p_Vias", OracleTypes.VARCHAR,new String()),
						new SqlOutParameter("Reg", OracleTypes.CURSOR,new SolicitanteFabConsultaRowMapper()),
						new SqlOutParameter("Reg_Espe", OracleTypes.CURSOR,new DatobeanRowMapper()),
						new SqlParameter("p_Codigosolicitud", OracleTypes.VARCHAR),
						new SqlOutParameter("Reg_Fabr", OracleTypes.CURSOR,new SolicitanteRegFabConsultaMapper())
						)
				.withoutProcedureColumnMetaDataAccess();
		SqlParameterSource prm = new MapSqlParameterSource()
				.addValue("p_Rregi_Soli_Pro", "")
				.addValue("p_Anno_Regi_Pro", "")
				.addValue("p_Num_Regi_Pro", "")
				.addValue("p_Cod_Expediente", solicitudRenovacionProductosVeterinarios.getP_COD_EXPEDIENTE())
				.addValue("p_Codigosolicitud", "")
				;
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		
		String p_Mensaje = (String) result.get("p_Mensaje");
		String p_Especies = (String) result.get("p_Especies");
		String p_Fabricante = (String) result.get("p_Fabricante");
		String p_Pais = (String) result.get("p_Pais");
		String p_Vias = (String) result.get("p_Vias");
		
		List<ConsultaFabExpediente> Reg = (List) result.get("Reg");
		List<DatosBean> Reg_Espe = (List) result.get("Reg_Espe");
		List<SolicitanteRegFabConsulta> Reg_Fabr = (List) result.get("Reg_Fabr");
		
		solicitudRenovacionProductosVeterinarios.setP_MENSAJE(p_Mensaje);
		solicitudRenovacionProductosVeterinarios.setP_ESPECIES(p_Especies);
		solicitudRenovacionProductosVeterinarios.setP_FABRICANTE(p_Fabricante);
		solicitudRenovacionProductosVeterinarios.setP_PAIS(p_Pais);
		solicitudRenovacionProductosVeterinarios.setP_VIAS(p_Vias);
		
		solicitudRenovacionProductosVeterinarios.setREG(Reg);
		solicitudRenovacionProductosVeterinarios.setREG_ESPE(Reg_Espe);
		solicitudRenovacionProductosVeterinarios.setREG_FABR(Reg_Fabr);

		return solicitudRenovacionProductosVeterinarios;
	}
	
	
}
