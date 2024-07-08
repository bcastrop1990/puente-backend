package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.generico.SolicitanteConsulta;

public class SolicitanteConsultaRowMapper implements RowMapper<SolicitanteConsulta> {
	@Override
	public SolicitanteConsulta mapRow(ResultSet rs, int i) throws SQLException {
		return SolicitanteConsulta.builder().idPersona(rs.getString("PERSONA_ID"))
				.nombreRazonSocial(rs.getString("NOMBRE_RAZON_SOCIAL")).tipoPersona(rs.getString("PERSONA_TIPO"))
				.tipoDocumento(rs.getString("DOCUMENTO_TIPO")).numeroDocumento(rs.getString("DOCUMENTO_NUMERO"))
				.nombres(rs.getString("NOMBRES")).direccion(rs.getString("DIRECCION"))
				.idDepartamento(rs.getString("DEPARTAMENTO_ID")).nombreDepartamento(rs.getString("NOMB_DPTO_DPT"))
				.idProvincia(rs.getString("PROVINCIA_ID")).nombreProvincia(rs.getString("NOMB_PROV_TPR"))
				.idDistrito(rs.getString("DISTRITO_ID")).nombreDistrito(rs.getString("NOMB_DIST_TDI"))
				.telefono(rs.getString("TELEFONO")).direccionReferencia(rs.getString("REFERENCIA"))
				.telefonoMovil(rs.getNString("TELEFONO_MOVIL"))
				.estadoEmpresa(rs.getString("ESTADO")).registroSenasa(rs.getString("REGI_PADR_EMP")).build();
	}

}
