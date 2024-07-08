package com.senasa.bpm.ng.repository.mapper.generico;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.generico.ConsultaFabExpediente;

public class SolicitanteFabConsultaRowMapper implements RowMapper<ConsultaFabExpediente> {
	@Override
	public ConsultaFabExpediente mapRow(ResultSet rs, int i) throws SQLException {
		return ConsultaFabExpediente.builder()
				.NUME_REGI_PRO(rs.getString("NUME_REGI_PRO"))
				.REGI_SOLI_PRO(rs.getString("REGI_SOLI_PRO"))
				.ANNO_REGI_PRO(rs.getString("ANNO_REGI_PRO"))
				.CODI_SEDE_SED(rs.getString("CODI_SEDE_SED"))
				.REGI_PADR_EMP(rs.getString("REGI_PADR_EMP"))
				.REPR_LEGA_PRO(rs.getString("REPR_LEGA_PRO"))
				.RECI_SENA_PRO(rs.getString("RECI_SENA_PRO"))
				.NUME_EXPE_PRO(rs.getString("NUME_EXPE_PRO"))
				.TITU_REGI_PRO(rs.getString("TITU_REGI_PRO"))
				.NOMB_COME_PRO(rs.getString("NOMB_COME_PRO"))
				.TIPO_PROD_PRO(rs.getString("TIPO_PROD_PRO"))
				.CODI_TIPO_FAR(rs.getString("CODI_TIPO_FAR"))
				.NOMB_TIPO_FAR(rs.getString("NOMB_TIPO_FAR"))
				.CODI_PRES_FAR(rs.getString("CODI_PRES_FAR"))
				.NOMB_PRES_FAR(rs.getString("NOMB_PRES_FAR"))
				.RESPTECNICO_NOMBRE(rs.getString("RESPTECNICO_NOMBRE"))
				.RESPTECNICO_DNI(rs.getString("RESPTECNICO_DNI"))
				.RESPTECNICO_ID(rs.getString("RESPTECNICO_ID"))
				.PERSONA_ID(rs.getString("PERSONA_ID"))
				.DOCUMENTO_TIPO(rs.getString("DOCUMENTO_TIPO"))
				.NOMBRE_EMPRESA(rs.getString("NOMBRE_EMPRESA"))
				.DOC_NUM_EMPRESA(rs.getString("DOC_NUM_EMPRESA"))
				.DIRECCION_EMPRESA(rs.getString("DIRECCION_EMPRESA"))
				.DEPARTAMENTO_ID(rs.getString("DEPARTAMENTO_ID"))
				.PROVINCIA_ID(rs.getString("PROVINCIA_ID"))
				.DISTRITO_ID(rs.getString("DISTRITO_ID"))
				.DEPART_EMPRESA(rs.getString("DEPART_EMPRESA"))
				.PROV_EMPRESA(rs.getString("PROV_EMPRESA"))
				.DIST_EMPRESA(rs.getString("DIST_EMPRESA"))
				.TELEFONO(rs.getString("TELEFONO"))
				.CORREO_ELECTRONICO(rs.getString("CORREO_ELECTRONICO"))
				.REPRLEGAL_NOMBRE(rs.getString("REPRLEGAL_NOMBRE"))
				.REPRLEGAL_DNI(rs.getString("REPRLEGAL_DNI"))
				.TIENE_PLAZO(rs.getString("TIENE_PLAZO"))
				.FLAG_TITU_EXT(rs.getString("FLAG_TITU_EXT"))
				.COD_PAIS_TITU(rs.getString("COD_PAIS_TITU"))
				.DIRECCION_TITU(rs.getString("DIRECCION_TITU"))
				.DOCUMENTO_NUMERO_TITU(rs.getString("DOCUMENTO_NUMERO_TITU"))
				.DEPARTAMENTO_ID_TITU(rs.getString("DEPARTAMENTO_ID_TITU"))
				.PROVINCIA_ID_TITU(rs.getString("PROVINCIA_ID_TITU"))
				.DISTRITO_ID_TITU(rs.getString("DISTRITO_ID_TITU"))
				.TELEFONO_TITU(rs.getString("TELEFONO_TITU"))
				.NUM_REGISTRO_TITU(rs.getString("NUM_REGISTRO_TITU"))
				.build();
	}

}
