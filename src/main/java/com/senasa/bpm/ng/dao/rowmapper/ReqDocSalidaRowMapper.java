package com.senasa.bpm.ng.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.DetalleDerivacionBean;
import com.senasa.bpm.ng.model.bean.ObtenerInfoAdjuntosBean;
import com.senasa.bpm.ng.model.bean.ReqDocSalidaBean;

public class ReqDocSalidaRowMapper implements RowMapper<ReqDocSalidaBean> {
  @Override
  public ReqDocSalidaBean mapRow(ResultSet rs, int i) throws SQLException {
    return ReqDocSalidaBean.builder()
        .ucmid(rs.getString("UCMID"))
        .codigo_Documento(rs.getString("CODIGO_DOCUMENTO"))
        .descripcion_documento(rs.getString("DESCRIPCION_DOCUMENTO"))
        .indicador_obligatorio(rs.getString("INDICADOR_OBLIGATORIO"))
        .sub_tipo(rs.getString("SUB_TIPO"))
        .ruta_check_in(rs.getString("RUTA_CHECK_IN"))
        .numfolios(rs.getString("NUMFOLIOS"))
        .confidencialidad(rs.getString("CONFIDENCIALIDAD"))
        .cod_std_doc(rs.getString("COD_STD_DOC"))
        .build();
  }
}
