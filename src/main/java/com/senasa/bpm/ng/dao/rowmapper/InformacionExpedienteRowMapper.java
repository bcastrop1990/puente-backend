package com.senasa.bpm.ng.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.InformacionExpedienteBean;

public class InformacionExpedienteRowMapper implements RowMapper<InformacionExpedienteBean> {
  @Override
  public InformacionExpedienteBean mapRow(ResultSet rs, int i) throws SQLException {
    return InformacionExpedienteBean.builder()
        .codigoExpediente(rs.getString("CODIGO_EXPEDIENTE"))
        .fechaRegistro(rs.getString("FECHA_REGISTRO"))
        .codigoCentroTramite(rs.getString("CODIGO_CENTRO_TRAMITE"))
        .descripcionCentroTramite(rs.getString("DESCRIPCION_CENTRO_TRAMITE"))
        .codigoServicio(rs.getString("CODIGO_SERVICIO"))
        .descripcionAreaGestion(rs.getString("DESCRIPCION_AREA_GESTION"))
        .descripcionProcedimientoTupa(rs.getString("DESCRIPCION_PROCEDIMIETO_TUPA"))
        .descripcionServicio(rs.getString("DESCRIPCION_SERVICIO"))
        .personaId(rs.getString("PERSONA_ID"))
        .nombreRazonSocial(rs.getString("NOMBRE_RAZON_SOCIAL"))
        .codigoSolicitud(rs.getString("CODIGO_SOLICITUD"))
        .ucmId(rs.getString("UCM_ID"))
        .codigoProcedimientoTupa(rs.getString("CODIGO_PROCEDIMIENTO_TUPA"))
        .numeRegiArc(rs.getString("NUME_REGI_ARC"))
        .ordenVuce(rs.getString("ORDEN_VUCE"))
        .canal(rs.getString("CANAL"))
        .codigoStdDoc(rs.getString("CODIGO_STD_DOC"))
        .numeroFolios(rs.getInt("NUMERO_FOLIOS"))
        .confidencial(rs.getString("CONFIDENCIAL"))
        .codigoTupa(rs.getString("CODIGO_TUPA"))
        .codFormato(rs.getString("COD_FORMATO"))
        .estado(rs.getString("ESTADO"))
        .estadoExpediente(rs.getString("ESTADO_EXPEDIENTE"))
        .tipoCertificado(rs.getString("TIPO_CERTIFICADO"))
        .oeaTipoOperador(rs.getString("OEA_TIPO_OPERADOR"))
        .oeaTipoAtencion(rs.getString("OEA_TIPO_ATENCION"))
        .build();
  }
}
