package com.senasa.bpm.ng.controller.mapper;

import com.senasa.bpm.ng.dao.AbstractDataAccessObject;
import com.senasa.bpm.ng.dao.IPckgGeneral;
import com.senasa.bpm.ng.dao.ResourceManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Map;



@Service
@Slf4j
public class PckgGeneral extends AbstractDataAccessObject implements IPckgGeneral {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PckgGeneral(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public EnvaseListarParam envaseListar(Connection conn, Map map) throws Exception {
        EnvaseListarParam param = newEnvaseListarParam(map);
        envaseListar(conn, param);
        return param;
    }

    public void envaseListar(Connection conn, EnvaseListarParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.ENVASE_LISTAR(?,?)}");
            String str = null;
            stmt.setString(1, param.getProductoid());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ListarPartidaArancelariaParam listarPartidaArancelaria(Connection conn, Map map) throws Exception {
        ListarPartidaArancelariaParam param = newListarPartidaArancelariaParam(map);
        listarPartidaArancelaria(conn, param);
        return param;
    }

    public void listarPartidaArancelaria(Connection conn, ListarPartidaArancelariaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.LISTAR_PARTIDA_ARANCELARIA(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoClase());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ProductoBpmGetlistParam productoBpmGetlist(Connection conn, Map map) throws Exception {
        ProductoBpmGetlistParam param = newProductoBpmGetlistParam(map);
        productoBpmGetlist(conn, param);
        return param;
    }

    public void productoBpmGetlist(Connection conn, ProductoBpmGetlistParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.PRODUCTO_BPM_GETLIST(?,?)}");
            String str = null;
            stmt.setString(1, param.getCodigoserviciotupa());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpAreasGestionParam spAreasGestion(Connection conn, Map map) throws Exception {
        SpAreasGestionParam param = newSpAreasGestionParam(map);
        spAreasGestion(conn, param);
        return param;
    }

    public void spAreasGestion(Connection conn, SpAreasGestionParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_AREAS_GESTION(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpBuscarPersonaParam spBuscarPersona(Connection conn, Map map) throws Exception {
        SpBuscarPersonaParam param = newSpBuscarPersonaParam(map);
        spBuscarPersona(conn, param);
        return param;
    }

    public void spBuscarPersona(Connection conn, SpBuscarPersonaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_BUSCAR_PERSONA(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPFiltro());
            stmt.setString(2, param.getPValorFiltro());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpCalcularXTipoInspeccionParam spCalcularXTipoInspeccion(Connection conn, Map map) throws Exception {
        SpCalcularXTipoInspeccionParam param = newSpCalcularXTipoInspeccionParam(map);
        spCalcularXTipoInspeccion(conn, param);
        return param;
    }

    public void spCalcularXTipoInspeccion(Connection conn, SpCalcularXTipoInspeccionParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_CALCULAR_X_TIPO_INSPECCION(?,?,?)}");
            String str = null;
            if (param.getCantidadanimales() != null) {
                stmt.setInt(1, param.getCantidadanimales().intValue());
            } else {
                stmt.setNull(1, Types.INTEGER);
            }
            stmt.setString(2, param.getCodigotarifario());
            stmt.registerOutParameter(3, Types.INTEGER);
            stmt.execute();
            param.setCosto(new Integer(stmt.getInt(3)));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpCalculoMontoConceptoParam spCalculoMontoConcepto(Connection conn, Map map) throws Exception {
        SpCalculoMontoConceptoParam param = newSpCalculoMontoConceptoParam(map);
        spCalculoMontoConcepto(conn, param);
        return param;
    }

    public void spCalculoMontoConcepto(Connection conn, SpCalculoMontoConceptoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_CALCULO_MONTO_CONCEPTO(?,?,?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodservicio());
            stmt.setString(2, param.getPcantidad());
            stmt.setString(3, param.getPtramaproductos());
            stmt.setString(4, param.getPtramavacunas());
            stmt.setString(5, param.getPtramaanalisis());
            stmt.registerOutParameter(6, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(6));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpCalculoMontoConcepto1Param spCalculoMontoConcepto1(Connection conn, Map map) throws Exception {
        SpCalculoMontoConcepto1Param param = newSpCalculoMontoConcepto1Param(map);
        spCalculoMontoConcepto1(conn, param);
        return param;
    }

    public void spCalculoMontoConcepto1(Connection conn, SpCalculoMontoConcepto1Param param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_CALCULO_MONTO_CONCEPTO1(?,?,?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodservicio());
            stmt.setString(2, param.getPcantidad());
            stmt.setString(3, param.getPtramaproductos());
            stmt.setString(4, param.getPtramavacunas());
            stmt.setString(5, param.getPtramaanalisis());
            stmt.registerOutParameter(6, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(6));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpCentroTramiteParam spCentroTramite(Connection conn, Map map) throws Exception {
        SpCentroTramiteParam param = newSpCentroTramiteParam(map);
        spCentroTramite(conn, param);
        return param;
    }

    public void spCentroTramite(Connection conn, SpCentroTramiteParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_CENTRO_TRAMITE(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCpe());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpCentroTramitePersonaParam spCentroTramitePersona(Connection conn, Map map) throws Exception {
        SpCentroTramitePersonaParam param = newSpCentroTramitePersonaParam(map);
        spCentroTramitePersona(conn, param);
        return param;
    }

    public void spCentroTramitePersona(Connection conn, SpCentroTramitePersonaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_CENTRO_TRAMITE_PERSONA(?,?)}");
            String str = null;
            stmt.setString(1, param.getPpersonaid());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpCentroTramiteUbigeoParam spCentroTramiteUbigeo(Connection conn, Map map) throws Exception {
        SpCentroTramiteUbigeoParam param = newSpCentroTramiteUbigeoParam(map);
        spCentroTramiteUbigeo(conn, param);
        return param;
    }

    public void spCentroTramiteUbigeo(Connection conn, SpCentroTramiteUbigeoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_CENTRO_TRAMITE_UBIGEO(?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPDepartamento());
            stmt.setString(2, param.getPProvincia());
            stmt.setString(3, param.getPDistrito());
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.execute();
            param.setPCentroTramite(stmt.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpConvHospedanteCultivoParam spConvHospedanteCultivo(Connection conn, Map map) throws Exception {
        SpConvHospedanteCultivoParam param = newSpConvHospedanteCultivoParam(map);
        spConvHospedanteCultivo(conn, param);
        return param;
    }

    public void spConvHospedanteCultivo(Connection conn, SpConvHospedanteCultivoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_CONV_HOSPEDANTE_CULTIVO(?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodEspecieBpm());
            stmt.registerOutParameter(1, Types.VARCHAR);
            stmt.setString(2, param.getPCodVariedadBpm());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.setString(3, param.getPCodHospendateSiimf());
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.setString(4, param.getPCodCultivoSiimf());
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.execute();
            param.setPCodEspecieBpm(stmt.getString(1));
            param.setPCodVariedadBpm(stmt.getString(2));
            param.setPCodHospendateSiimf(stmt.getString(3));
            param.setPCodCultivoSiimf(stmt.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpDocumentosIdentidadParam spDocumentosIdentidad(Connection conn, Map map) throws Exception {
        SpDocumentosIdentidadParam param = newSpDocumentosIdentidadParam(map);
        spDocumentosIdentidad(conn, param);
        return param;
    }

    public void spDocumentosIdentidad(Connection conn, SpDocumentosIdentidadParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_DOCUMENTOS_IDENTIDAD(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpEnviarAprobacionrevdocParam spEnviarAprobacionrevdoc(Connection conn, Map map) throws Exception {
        SpEnviarAprobacionrevdocParam param = newSpEnviarAprobacionrevdocParam(map);
        spEnviarAprobacionrevdoc(conn, param);
        return param;
    }

    public void spEnviarAprobacionrevdoc(Connection conn, SpEnviarAprobacionrevdocParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_ENVIAR_APROBACIONREVDOC(?)}");
            String str = null;
            stmt.setString(1, param.getPcodigoexpediente());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpEnviarNoejecInspeccionParam spEnviarNoejecInspeccion(Connection conn, Map map) throws Exception {
        SpEnviarNoejecInspeccionParam param = newSpEnviarNoejecInspeccionParam(map);
        spEnviarNoejecInspeccion(conn, param);
        return param;
    }

    public void spEnviarNoejecInspeccion(Connection conn, SpEnviarNoejecInspeccionParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_ENVIAR_NOEJEC_INSPECCION(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodigoexpediente());
            stmt.setString(2, param.getPmotivo());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpFiltrosBuscarPersonaParam spFiltrosBuscarPersona(Connection conn, Map map) throws Exception {
        SpFiltrosBuscarPersonaParam param = newSpFiltrosBuscarPersonaParam(map);
        spFiltrosBuscarPersona(conn, param);
        return param;
    }

    public void spFiltrosBuscarPersona(Connection conn, SpFiltrosBuscarPersonaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_FILTROS_BUSCAR_PERSONA(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpGetCodigoDepProvDisParam spGetCodigoDepProvDis(Connection conn, Map map) throws Exception {
        SpGetCodigoDepProvDisParam param = newSpGetCodigoDepProvDisParam(map);
        spGetCodigoDepProvDis(conn, param);
        return param;
    }

    public void spGetCodigoDepProvDis(Connection conn, SpGetCodigoDepProvDisParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_GET_CODIGO_DEP_PROV_DIS(?,?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getCdep());
            stmt.setString(2, param.getCdis());
            stmt.setString(3, param.getCpro());
            stmt.setString(4, param.getCodigo());
            stmt.registerOutParameter(5, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(5));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpGetOrdenPorMtoParam spGetOrdenPorMto(Connection conn, Map map) throws Exception {
        SpGetOrdenPorMtoParam param = newSpGetOrdenPorMtoParam(map);
        spGetOrdenPorMto(conn, param);
        return param;
    }

    public void spGetOrdenPorMto(Connection conn, SpGetOrdenPorMtoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_GET_ORDEN_POR_MTO(?,?)}");
            String str = null;
            stmt.setString(1, param.getCmto());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpGetReportePfiParam spGetReportePfi(Connection conn, Map map) throws Exception {
        SpGetReportePfiParam param = newSpGetReportePfiParam(map);
        spGetReportePfi(conn, param);
        return param;
    }

    public void spGetReportePfi(Connection conn, SpGetReportePfiParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_GET_REPORTE_PFI(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodigoexpediente());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpGetReportePfiProdAnexosParam spGetReportePfiProdAnexos(Connection conn, Map map) throws Exception {
        SpGetReportePfiProdAnexosParam param = newSpGetReportePfiProdAnexosParam(map);
        spGetReportePfiProdAnexos(conn, param);
        return param;
    }

    public void spGetReportePfiProdAnexos(Connection conn, SpGetReportePfiProdAnexosParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_GET_REPORTE_PFI_PROD_ANEXOS(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPNumeroPermiso());
            stmt.setString(2, param.getPFlag());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpGetReportePziParam spGetReportePzi(Connection conn, Map map) throws Exception {
        SpGetReportePziParam param = newSpGetReportePziParam(map);
        spGetReportePzi(conn, param);
        return param;
    }

    public void spGetReportePzi(Connection conn, SpGetReportePziParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_GET_REPORTE_PZI(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodigoexpediente());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpGetReportePziCabeseraParam spGetReportePziCabesera(Connection conn, Map map) throws Exception {
        SpGetReportePziCabeseraParam param = newSpGetReportePziCabeseraParam(map);
        spGetReportePziCabesera(conn, param);
        return param;
    }

    public void spGetReportePziCabesera(Connection conn, SpGetReportePziCabeseraParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_GET_REPORTE_PZI_CABESERA(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoExpediente());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpGetReportePziProdAnexosParam spGetReportePziProdAnexos(Connection conn, Map map) throws Exception {
        SpGetReportePziProdAnexosParam param = newSpGetReportePziProdAnexosParam(map);
        spGetReportePziProdAnexos(conn, param);
        return param;
    }

    public void spGetReportePziProdAnexos(Connection conn, SpGetReportePziProdAnexosParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_GET_REPORTE_PZI_PROD_ANEXOS(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPNumeroPermiso());
            stmt.setString(2, param.getPFlag());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpGrabarServicioAdicionalParam spGrabarServicioAdicional(Connection conn, Map map) throws Exception {
        SpGrabarServicioAdicionalParam param = newSpGrabarServicioAdicionalParam(map);
        spGrabarServicioAdicional(conn, param);
        return param;
    }

    public void spGrabarServicioAdicional(Connection conn, SpGrabarServicioAdicionalParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_GRABAR_SERVICIO_ADICIONAL(?,?,?,?,?,?,?,?,?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPcentrotramite());
            stmt.setString(2, param.getPpersonaid());
            stmt.setString(3, param.getPpersonaidotro());
            stmt.setString(4, param.getPuserid());
            stmt.setString(5, param.getPpersonaidsolicitante());
            stmt.setString(6, param.getPcodexpediente());
            stmt.registerOutParameter(7, Types.VARCHAR);
            stmt.setString(8, param.getPdetallerecibo());
            stmt.setString(9, param.getPpagorecibo());
            stmt.setString(10, param.getPobservaciontraza());
            stmt.setString(11, param.getPproctupa());
            stmt.setString(12, param.getPcodorden());
            stmt.execute();
            param.setPcodrecibo(stmt.getString(7));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpInfoProcedimientoServicioParam spInfoProcedimientoServicio(Connection conn, Map map) throws Exception {
        SpInfoProcedimientoServicioParam param = newSpInfoProcedimientoServicioParam(map);
        spInfoProcedimientoServicio(conn, param);
        return param;
    }

    public void spInfoProcedimientoServicio(Connection conn, SpInfoProcedimientoServicioParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_INFO_PROCEDIMIENTO_SERVICIO(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodProc());
            stmt.setString(2, param.getPCodServicio());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpInspectoresParam spInspectores(Connection conn, Map map) throws Exception {
        SpInspectoresParam param = newSpInspectoresParam(map);
        spInspectores(conn, param);
        return param;
    }

    public void spInspectores(Connection conn, SpInspectoresParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_INSPECTORES(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpInspectoresCentroTramiteParam spInspectoresCentroTramite(Connection conn, Map map) throws Exception {
        SpInspectoresCentroTramiteParam param = newSpInspectoresCentroTramiteParam(map);
        spInspectoresCentroTramite(conn, param);
        return param;
    }

    public void spInspectoresCentroTramite(Connection conn, SpInspectoresCentroTramiteParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_INSPECTORES_CENTRO_TRAMITE(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoCentroTramite());
            if (param.getPRol() != null) {
                stmt.setInt(2, param.getPRol().intValue());
            } else {
                stmt.setNull(2, Types.INTEGER);
            }
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpInspectoresDepartamentoParam spInspectoresDepartamento(Connection conn, Map map) throws Exception {
        SpInspectoresDepartamentoParam param = newSpInspectoresDepartamentoParam(map);
        spInspectoresDepartamento(conn, param);
        return param;
    }

    public void spInspectoresDepartamento(Connection conn, SpInspectoresDepartamentoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_INSPECTORES_DEPARTAMENTO(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPDpto());
            if (param.getPRol() != null) {
                stmt.setInt(2, param.getPRol().intValue());
            } else {
                stmt.setNull(2, Types.INTEGER);
            }
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpInspectoresSedeParam spInspectoresSede(Connection conn, Map map) throws Exception {
        SpInspectoresSedeParam param = newSpInspectoresSedeParam(map);
        spInspectoresSede(conn, param);
        return param;
    }

    public void spInspectoresSede(Connection conn, SpInspectoresSedeParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_INSPECTORES_SEDE(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoCentroTram());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpInspectoresporubigeoParam spInspectoresporubigeo(Connection conn, Map map) throws Exception {
        SpInspectoresporubigeoParam param = newSpInspectoresporubigeoParam(map);
        spInspectoresporubigeo(conn, param);
        return param;
    }

    public void spInspectoresporubigeo(Connection conn, SpInspectoresporubigeoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_INSPECTORESPORUBIGEO(?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPDpto());
            stmt.setString(2, param.getPProv());
            stmt.setString(3, param.getPDist());
            stmt.registerOutParameter(4, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(4));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaAlmacenGcustodiaParam spListaAlmacenGcustodia(Connection conn, Map map) throws Exception {
        SpListaAlmacenGcustodiaParam param = newSpListaAlmacenGcustodiaParam(map);
        spListaAlmacenGcustodia(conn, param);
        return param;
    }

    public void spListaAlmacenGcustodia(Connection conn, SpListaAlmacenGcustodiaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_ALMACEN_GCUSTODIA(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaAnalisisParam spListaAnalisis(Connection conn, Map map) throws Exception {
        SpListaAnalisisParam param = newSpListaAnalisisParam(map);
        spListaAnalisis(conn, param);
        return param;
    }

    public void spListaAnalisis(Connection conn, SpListaAnalisisParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_ANALISIS(?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPPaisDestino());
            stmt.setString(2, param.getPProducto());
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, OracleTypes.CURSOR);
            stmt.execute();
            param.setPMensaje(stmt.getString(3));
            param.setRegAnalisis((ResultSet) stmt.getObject(4));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaAplicacionParam spListaAplicacion(Connection conn, Map map) throws Exception {
        SpListaAplicacionParam param = newSpListaAplicacionParam(map);
        spListaAplicacion(conn, param);
        return param;
    }

    public void spListaAplicacion(Connection conn, SpListaAplicacionParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_APLICACION(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodClase());
            stmt.setString(2, param.getPEstado());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaAplicacionProductoParam spListaAplicacionProducto(Connection conn, Map map) throws Exception {
        SpListaAplicacionProductoParam param = newSpListaAplicacionProductoParam(map);
        spListaAplicacionProducto(conn, param);
        return param;
    }

    public void spListaAplicacionProducto(Connection conn, SpListaAplicacionProductoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_APLICACION_PRODUCTO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoProducto());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaAreaLaboratorioParam spListaAreaLaboratorio(Connection conn, Map map) throws Exception {
        SpListaAreaLaboratorioParam param = newSpListaAreaLaboratorioParam(map);
        spListaAreaLaboratorio(conn, param);
        return param;
    }

    public void spListaAreaLaboratorio(Connection conn, SpListaAreaLaboratorioParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_AREA_LABORATORIO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPTipo());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaDictamenParam spListaDictamen(Connection conn, Map map) throws Exception {
        SpListaDictamenParam param = newSpListaDictamenParam(map);
        spListaDictamen(conn, param);
        return param;
    }

    public void spListaDictamen(Connection conn, SpListaDictamenParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_DICTAMEN(?,?)}");
            String str = null;
            stmt.setString(1, param.getPTipo());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaLugarInspeccionParam spListaLugarInspeccion(Connection conn, Map map) throws Exception {
        SpListaLugarInspeccionParam param = newSpListaLugarInspeccionParam(map);
        spListaLugarInspeccion(conn, param);
        return param;
    }

    public void spListaLugarInspeccion(Connection conn, SpListaLugarInspeccionParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_LUGAR_INSPECCION(?,?)}");
            String str = null;
            stmt.setString(1, param.getPSede());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaLugarProduccionParam spListaLugarProduccion(Connection conn, Map map) throws Exception {
        SpListaLugarProduccionParam param = newSpListaLugarProduccionParam(map);
        spListaLugarProduccion(conn, param);
        return param;
    }

    public void spListaLugarProduccion(Connection conn, SpListaLugarProduccionParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_LUGAR_PRODUCCION(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodPais());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaMotivoParam spListaMotivo(Connection conn, Map map) throws Exception {
        SpListaMotivoParam param = newSpListaMotivoParam(map);
        spListaMotivo(conn, param);
        return param;
    }

    public void spListaMotivo(Connection conn, SpListaMotivoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_MOTIVO(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaMotivoTratamientoParam spListaMotivoTratamiento(Connection conn, Map map) throws Exception {
        SpListaMotivoTratamientoParam param = newSpListaMotivoTratamientoParam(map);
        spListaMotivoTratamiento(conn, param);
        return param;
    }

    public void spListaMotivoTratamiento(Connection conn, SpListaMotivoTratamientoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_MOTIVO_TRATAMIENTO(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaPaisParam spListaPais(Connection conn, Map map) throws Exception {
        SpListaPaisParam param = newSpListaPaisParam(map);
        spListaPais(conn, param);
        return param;
    }

    public void spListaPais(Connection conn, SpListaPaisParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_PAIS(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaPlagaTratamientoParam spListaPlagaTratamiento(Connection conn, Map map) throws Exception {
        SpListaPlagaTratamientoParam param = newSpListaPlagaTratamientoParam(map);
        spListaPlagaTratamiento(conn, param);
        return param;
    }

    public void spListaPlagaTratamiento(Connection conn, SpListaPlagaTratamientoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_PLAGA_TRATAMIENTO(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPDesc());
            stmt.setString(2, param.getPClase());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaProcOrigenMuestraParam spListaProcOrigenMuestra(Connection conn, Map map) throws Exception {
        SpListaProcOrigenMuestraParam param = newSpListaProcOrigenMuestraParam(map);
        spListaProcOrigenMuestra(conn, param);
        return param;
    }

    public void spListaProcOrigenMuestra(Connection conn, SpListaProcOrigenMuestraParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_PROC_ORIGEN_MUESTRA(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaProduccionPfiParam spListaProduccionPfi(Connection conn, Map map) throws Exception {
        SpListaProduccionPfiParam param = newSpListaProduccionPfiParam(map);
        spListaProduccionPfi(conn, param);
        return param;
    }

    public void spListaProduccionPfi(Connection conn, SpListaProduccionPfiParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_PRODUCCION_PFI(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPNumeroPermiso());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setPMensaje(stmt.getString(2));
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaRazaParam spListaRaza(Connection conn, Map map) throws Exception {
        SpListaRazaParam param = newSpListaRazaParam(map);
        spListaRaza(conn, param);
        return param;
    }

    public void spListaRaza(Connection conn, SpListaRazaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_RAZA(?,?)}");
            String str = null;
            stmt.setString(1, param.getPEspecie());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaServAnalisisAnimalParam spListaServAnalisisAnimal(Connection conn, Map map) throws Exception {
        SpListaServAnalisisAnimalParam param = newSpListaServAnalisisAnimalParam(map);
        spListaServAnalisisAnimal(conn, param);
        return param;
    }

    public void spListaServAnalisisAnimal(Connection conn, SpListaServAnalisisAnimalParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_SERV_ANALISIS_ANIMAL(?,?)}");
            String str = null;
            stmt.setString(1, param.getPDesc());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaServAnalisisVegetalParam spListaServAnalisisVegetal(Connection conn, Map map) throws Exception {
        SpListaServAnalisisVegetalParam param = newSpListaServAnalisisVegetalParam(map);
        spListaServAnalisisVegetal(conn, param);
        return param;
    }

    public void spListaServAnalisisVegetal(Connection conn, SpListaServAnalisisVegetalParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_SERV_ANALISIS_VEGETAL(?,?)}");
            String str = null;
            stmt.setString(1, param.getPArea());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaSexoParam spListaSexo(Connection conn, Map map) throws Exception {
        SpListaSexoParam param = newSpListaSexoParam(map);
        spListaSexo(conn, param);
        return param;
    }

    public void spListaSexo(Connection conn, SpListaSexoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_SEXO(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaTipoCrianzaParam spListaTipoCrianza(Connection conn, Map map) throws Exception {
        SpListaTipoCrianzaParam param = newSpListaTipoCrianzaParam(map);
        spListaTipoCrianza(conn, param);
        return param;
    }

    public void spListaTipoCrianza(Connection conn, SpListaTipoCrianzaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_TIPO_CRIANZA(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaTipoEnvaseParam spListaTipoEnvase(Connection conn, Map map) throws Exception {
        SpListaTipoEnvaseParam param = newSpListaTipoEnvaseParam(map);
        spListaTipoEnvase(conn, param);
        return param;
    }

    public void spListaTipoEnvase(Connection conn, SpListaTipoEnvaseParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_TIPO_ENVASE(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPClase());
            stmt.setString(2, param.getPTipo());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaTipoEspecieAnimalParam spListaTipoEspecieAnimal(Connection conn, Map map) throws Exception {
        SpListaTipoEspecieAnimalParam param = newSpListaTipoEspecieAnimalParam(map);
        spListaTipoEspecieAnimal(conn, param);
        return param;
    }

    public void spListaTipoEspecieAnimal(Connection conn, SpListaTipoEspecieAnimalParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_TIPO_ESPECIE_ANIMAL(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaTipoIdentificacionParam spListaTipoIdentificacion(Connection conn, Map map) throws Exception {
        SpListaTipoIdentificacionParam param = newSpListaTipoIdentificacionParam(map);
        spListaTipoIdentificacion(conn, param);
        return param;
    }

    public void spListaTipoIdentificacion(Connection conn, SpListaTipoIdentificacionParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_TIPO_IDENTIFICACION(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaTipoMuestraAnimalParam spListaTipoMuestraAnimal(Connection conn, Map map) throws Exception {
        SpListaTipoMuestraAnimalParam param = newSpListaTipoMuestraAnimalParam(map);
        spListaTipoMuestraAnimal(conn, param);
        return param;
    }

    public void spListaTipoMuestraAnimal(Connection conn, SpListaTipoMuestraAnimalParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_TIPO_MUESTRA_ANIMAL(?,?)}");
            String str = null;
            stmt.setString(1, param.getPPruebas());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaTipoMuestraVegetalParam spListaTipoMuestraVegetal(Connection conn, Map map) throws Exception {
        SpListaTipoMuestraVegetalParam param = newSpListaTipoMuestraVegetalParam(map);
        spListaTipoMuestraVegetal(conn, param);
        return param;
    }

    public void spListaTipoMuestraVegetal(Connection conn, SpListaTipoMuestraVegetalParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_TIPO_MUESTRA_VEGETAL(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaTipoRecintoParam spListaTipoRecinto(Connection conn, Map map) throws Exception {
        SpListaTipoRecintoParam param = newSpListaTipoRecintoParam(map);
        spListaTipoRecinto(conn, param);
        return param;
    }

    public void spListaTipoRecinto(Connection conn, SpListaTipoRecintoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_TIPO_RECINTO(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaUnidMedProductoParam spListaUnidMedProducto(Connection conn, Map map) throws Exception {
        SpListaUnidMedProductoParam param = newSpListaUnidMedProductoParam(map);
        spListaUnidMedProducto(conn, param);
        return param;
    }

    public void spListaUnidMedProducto(Connection conn, SpListaUnidMedProductoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_UNID_MED_PRODUCTO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoProducto());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListaUnidadMedidaParam spListaUnidadMedida(Connection conn, Map map) throws Exception {
        SpListaUnidadMedidaParam param = newSpListaUnidadMedidaParam(map);
        spListaUnidadMedida(conn, param);
        return param;
    }

    public void spListaUnidadMedida(Connection conn, SpListaUnidadMedidaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTA_UNIDAD_MEDIDA(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListarFabricantesParam spListarFabricantes(Connection conn, Map map) throws Exception {
        SpListarFabricantesParam param = newSpListarFabricantesParam(map);
        spListarFabricantes(conn, param);
        return param;
    }

    public void spListarFabricantes(Connection conn, SpListarFabricantesParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTAR_FABRICANTES(?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPTipoDato());
            stmt.setString(2, param.getPNombre());
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, OracleTypes.CURSOR);
            stmt.execute();
            param.setPMensaje(stmt.getString(3));
            param.setReg((ResultSet) stmt.getObject(4));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListarPartidaArancelariaParam spListarPartidaArancelaria(Connection conn, Map map) throws Exception {
        SpListarPartidaArancelariaParam param = newSpListarPartidaArancelariaParam(map);
        spListarPartidaArancelaria(conn, param);
        return param;
    }

    public void spListarPartidaArancelaria(Connection conn, SpListarPartidaArancelariaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTAR_PARTIDA_ARANCELARIA(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoClase());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListarTipoEnvaseParam spListarTipoEnvase(Connection conn, Map map) throws Exception {
        SpListarTipoEnvaseParam param = newSpListarTipoEnvaseParam(map);
        spListarTipoEnvase(conn, param);
        return param;
    }

    public void spListarTipoEnvase(Connection conn, SpListarTipoEnvaseParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTAR_TIPO_ENVASE(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoClase());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpListarUnidadMedidaParam spListarUnidadMedida(Connection conn, Map map) throws Exception {
        SpListarUnidadMedidaParam param = newSpListarUnidadMedidaParam(map);
        spListarUnidadMedida(conn, param);
        return param;
    }

    public void spListarUnidadMedida(Connection conn, SpListarUnidadMedidaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_LISTAR_UNIDAD_MEDIDA(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoClase());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpMedioTransporteParam spMedioTransporte(Connection conn, Map map) throws Exception {
        SpMedioTransporteParam param = newSpMedioTransporteParam(map);
        spMedioTransporte(conn, param);
        return param;
    }

    public void spMedioTransporte(Connection conn, SpMedioTransporteParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_MEDIO_TRANSPORTE(?,?)}");
            String str = null;
            stmt.setString(1, param.getPSede());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            param.setPMedio(stmt.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerAdjuntosParam spObtenerAdjuntos(Connection conn, Map map) throws Exception {
        SpObtenerAdjuntosParam param = newSpObtenerAdjuntosParam(map);
        spObtenerAdjuntos(conn, param);
        return param;
    }

    public void spObtenerAdjuntos(Connection conn, SpObtenerAdjuntosParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_ADJUNTOS(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodexpediente());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerAdjuntosVuceParam spObtenerAdjuntosVuce(Connection conn, Map map) throws Exception {
        SpObtenerAdjuntosVuceParam param = newSpObtenerAdjuntosVuceParam(map);
        spObtenerAdjuntosVuce(conn, param);
        return param;
    }

    public void spObtenerAdjuntosVuce(Connection conn, SpObtenerAdjuntosVuceParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_ADJUNTOS_VUCE(?,?)}");
            String str = null;
            stmt.setString(1, param.getPNumeroOrden());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setRegdoc((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerAnalisisCatalServParam spObtenerAnalisisCatalServ(Connection conn, Map map) throws Exception {
        SpObtenerAnalisisCatalServParam param = newSpObtenerAnalisisCatalServParam(map);
        spObtenerAnalisisCatalServ(conn, param);
        return param;
    }

    public void spObtenerAnalisisCatalServ(Connection conn, SpObtenerAnalisisCatalServParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_ANALISIS_CATAL_SERV(?,?)}");
            String str = null;
            stmt.setString(1, param.getFamiliaid());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerCertParam spObtenerCert(Connection conn, Map map) throws Exception {
        SpObtenerCertParam param = newSpObtenerCertParam(map);
        spObtenerCert(conn, param);
        return param;
    }

    public void spObtenerCert(Connection conn, SpObtenerCertParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_CERT(?,?)}");
            String str = null;
            stmt.setString(1, param.getPNumeDoc());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerClasesCatalServParam spObtenerClasesCatalServ(Connection conn, Map map) throws Exception {
        SpObtenerClasesCatalServParam param = newSpObtenerClasesCatalServParam(map);
        spObtenerClasesCatalServ(conn, param);
        return param;
    }

    public void spObtenerClasesCatalServ(Connection conn, SpObtenerClasesCatalServParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_CLASES_CATAL_SERV(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerCodiivExpedienteParam spObtenerCodiivExpediente(Connection conn, Map map) throws Exception {
        SpObtenerCodiivExpedienteParam param = newSpObtenerCodiivExpedienteParam(map);
        spObtenerCodiivExpediente(conn, param);
        return param;
    }

    public void spObtenerCodiivExpediente(Connection conn, SpObtenerCodiivExpedienteParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_CODIIV_EXPEDIENTE(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodexpediente());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.execute();
            param.setCodiiv(stmt.getString(2));
            param.setNrocertificado(stmt.getString(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerDescDocumentoParam spObtenerDescDocumento(Connection conn, Map map) throws Exception {
        SpObtenerDescDocumentoParam param = newSpObtenerDescDocumentoParam(map);
        spObtenerDescDocumento(conn, param);
        return param;
    }

    public void spObtenerDescDocumento(Connection conn, SpObtenerDescDocumentoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_DESC_DOCUMENTO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodigodocumento());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerDireccionImpoParam spObtenerDireccionImpo(Connection conn, Map map) throws Exception {
        SpObtenerDireccionImpoParam param = newSpObtenerDireccionImpoParam(map);
        spObtenerDireccionImpo(conn, param);
        return param;
    }

    public void spObtenerDireccionImpo(Connection conn, SpObtenerDireccionImpoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_DIRECCION_IMPO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoImportador());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            param.setPDireccion(stmt.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerEmpresaTratamientoParam spObtenerEmpresaTratamiento(Connection conn, Map map) throws Exception {
        SpObtenerEmpresaTratamientoParam param = newSpObtenerEmpresaTratamientoParam(map);
        spObtenerEmpresaTratamiento(conn, param);
        return param;
    }

    public void spObtenerEmpresaTratamiento(Connection conn, SpObtenerEmpresaTratamientoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_EMPRESA_TRATAMIENTO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPRuc());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerEntidNombreRucParam spObtenerEntidNombreRuc(Connection conn, Map map) throws Exception {
        SpObtenerEntidNombreRucParam param = newSpObtenerEntidNombreRucParam(map);
        spObtenerEntidNombreRuc(conn, param);
        return param;
    }

    public void spObtenerEntidNombreRuc(Connection conn, SpObtenerEntidNombreRucParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_ENTID_NOMBRE_RUC(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPNombre());
            stmt.setString(2, param.getPRuc());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerExpedientePermisoParam spObtenerExpedientePermiso(Connection conn, Map map) throws Exception {
        SpObtenerExpedientePermisoParam param = newSpObtenerExpedientePermisoParam(map);
        spObtenerExpedientePermiso(conn, param);
        return param;
    }

    public void spObtenerExpedientePermiso(Connection conn, SpObtenerExpedientePermisoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_EXPEDIENTE_PERMISO(?,?,?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPNumeroPermiso());
            stmt.setString(2, param.getPFlagPermiso());
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.registerOutParameter(5, Types.VARCHAR);
            stmt.registerOutParameter(6, Types.VARCHAR);
            stmt.execute();
            param.setPCodExpediente(stmt.getString(3));
            param.setPFlgExiste(stmt.getString(4));
            param.setPPersonaId(stmt.getString(5));
            param.setPFlgTipo(stmt.getString(6));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerFamiliasCatalServParam spObtenerFamiliasCatalServ(Connection conn, Map map) throws Exception {
        SpObtenerFamiliasCatalServParam param = newSpObtenerFamiliasCatalServParam(map);
        spObtenerFamiliasCatalServ(conn, param);
        return param;
    }

    public void spObtenerFamiliasCatalServ(Connection conn, SpObtenerFamiliasCatalServParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_FAMILIAS_CATAL_SERV(?,?)}");
            String str = null;
            stmt.setString(1, param.getClaseid());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerImportadoresParam spObtenerImportadores(Connection conn, Map map) throws Exception {
        SpObtenerImportadoresParam param = newSpObtenerImportadoresParam(map);
        spObtenerImportadores(conn, param);
        return param;
    }

    public void spObtenerImportadores(Connection conn, SpObtenerImportadoresParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_IMPORTADORES(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPNombre());
            stmt.setString(2, param.getPCodigoPais());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerImportadoresVuceParam spObtenerImportadoresVuce(Connection conn, Map map) throws Exception {
        SpObtenerImportadoresVuceParam param = newSpObtenerImportadoresVuceParam(map);
        spObtenerImportadoresVuce(conn, param);
        return param;
    }

    public void spObtenerImportadoresVuce(Connection conn, SpObtenerImportadoresVuceParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_IMPORTADORES_VUCE(?,?)}");
            String str = null;
            stmt.setString(1, param.getPNombre());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerListaAnalisisParam spObtenerListaAnalisis(Connection conn, Map map) throws Exception {
        SpObtenerListaAnalisisParam param = newSpObtenerListaAnalisisParam(map);
        spObtenerListaAnalisis(conn, param);
        return param;
    }

    public void spObtenerListaAnalisis(Connection conn, SpObtenerListaAnalisisParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_LISTA_ANALISIS(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerListaAreaParam spObtenerListaArea(Connection conn, Map map) throws Exception {
        SpObtenerListaAreaParam param = newSpObtenerListaAreaParam(map);
        spObtenerListaArea(conn, param);
        return param;
    }

    public void spObtenerListaArea(Connection conn, SpObtenerListaAreaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_LISTA_AREA(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerListaFuncionarioParam spObtenerListaFuncionario(Connection conn, Map map) throws Exception {
        SpObtenerListaFuncionarioParam param = newSpObtenerListaFuncionarioParam(map);
        spObtenerListaFuncionario(conn, param);
        return param;
    }

    public void spObtenerListaFuncionario(Connection conn, SpObtenerListaFuncionarioParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_LISTA_FUNCIONARIO(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPArea());
            stmt.setString(2, param.getPSubArea());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerListaPrediosParam spObtenerListaPredios(Connection conn, Map map) throws Exception {
        SpObtenerListaPrediosParam param = newSpObtenerListaPrediosParam(map);
        spObtenerListaPredios(conn, param);
        return param;
    }

    public void spObtenerListaPredios(Connection conn, SpObtenerListaPrediosParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_LISTA_PREDIOS(?,?)}");
            String str = null;
            stmt.setString(1, param.getPPersonaid());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerListaSubAreaParam spObtenerListaSubArea(Connection conn, Map map) throws Exception {
        SpObtenerListaSubAreaParam param = newSpObtenerListaSubAreaParam(map);
        spObtenerListaSubArea(conn, param);
        return param;
    }

    public void spObtenerListaSubArea(Connection conn, SpObtenerListaSubAreaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_LISTA_SUB_AREA(?,?)}");
            String str = null;
            stmt.setString(1, param.getPArea());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerListaSubTipoDocParam spObtenerListaSubTipoDoc(Connection conn, Map map) throws Exception {
        SpObtenerListaSubTipoDocParam param = newSpObtenerListaSubTipoDocParam(map);
        spObtenerListaSubTipoDoc(conn, param);
        return param;
    }

    public void spObtenerListaSubTipoDoc(Connection conn, SpObtenerListaSubTipoDocParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_LISTA_SUB_TIPO_DOC(?,?)}");
            String str = null;
            stmt.setString(1, param.getPTipo());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerListaTipoDocParam spObtenerListaTipoDoc(Connection conn, Map map) throws Exception {
        SpObtenerListaTipoDocParam param = newSpObtenerListaTipoDocParam(map);
        spObtenerListaTipoDoc(conn, param);
        return param;
    }

    public void spObtenerListaTipoDoc(Connection conn, SpObtenerListaTipoDocParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_LISTA_TIPO_DOC(?,?)}");
            String str = null;
            stmt.setString(1, param.getPEscenario());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerListaVacunasParam spObtenerListaVacunas(Connection conn, Map map) throws Exception {
        SpObtenerListaVacunasParam param = newSpObtenerListaVacunasParam(map);
        spObtenerListaVacunas(conn, param);
        return param;
    }

    public void spObtenerListaVacunas(Connection conn, SpObtenerListaVacunasParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_LISTA_VACUNAS(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerOperadorParam spObtenerOperador(Connection conn, Map map) throws Exception {
        SpObtenerOperadorParam param = newSpObtenerOperadorParam(map);
        spObtenerOperador(conn, param);
        return param;
    }

    public void spObtenerOperador(Connection conn, SpObtenerOperadorParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_OPERADOR(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPDocumentoTipo());
            stmt.setString(2, param.getPDocumentoNumero());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerPersonaParam spObtenerPersona(Connection conn, Map map) throws Exception {
        SpObtenerPersonaParam param = newSpObtenerPersonaParam(map);
        spObtenerPersona(conn, param);
        return param;
    }

    public void spObtenerPersona(Connection conn, SpObtenerPersonaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PERSONA(?,?)}");
            String str = null;
            stmt.setString(1, param.getPPersonaId());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerPersonaDocParam spObtenerPersonaDoc(Connection conn, Map map) throws Exception {
        SpObtenerPersonaDocParam param = newSpObtenerPersonaDocParam(map);
        spObtenerPersonaDoc(conn, param);
        return param;
    }

    public void spObtenerPersonaDoc(Connection conn, SpObtenerPersonaDocParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PERSONA_DOC(?,?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPtidodoc());
            stmt.setString(2, param.getPnumdoc());
            stmt.setString(3, param.getPnombre());
            stmt.setString(4, param.getPFormato());
            stmt.registerOutParameter(5, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(5));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerPersonaDocAduanaParam spObtenerPersonaDocAduana(Connection conn, Map map) throws Exception {
        SpObtenerPersonaDocAduanaParam param = newSpObtenerPersonaDocAduanaParam(map);
        spObtenerPersonaDocAduana(conn, param);
        return param;
    }

    public void spObtenerPersonaDocAduana(Connection conn, SpObtenerPersonaDocAduanaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PERSONA_DOC_ADUANA(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPtidodoc());
            stmt.setString(2, param.getPnumdoc());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerPersonaDocIiParam spObtenerPersonaDocIi(Connection conn, Map map) throws Exception {
        SpObtenerPersonaDocIiParam param = newSpObtenerPersonaDocIiParam(map);
        spObtenerPersonaDocIi(conn, param);
        return param;
    }

    public void spObtenerPersonaDocIi(Connection conn, SpObtenerPersonaDocIiParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PERSONA_DOC_II(?,?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPtidodoc());
            stmt.setString(2, param.getPnumdoc());
            stmt.setString(3, param.getPnombre());
            stmt.setString(4, param.getPFormato());
            stmt.registerOutParameter(5, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(5));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerPersonaDocumentoParam spObtenerPersonaDocumento(Connection conn, Map map) throws Exception {
        SpObtenerPersonaDocumentoParam param = newSpObtenerPersonaDocumentoParam(map);
        spObtenerPersonaDocumento(conn, param);
        return param;
    }

    public void spObtenerPersonaDocumento(Connection conn, SpObtenerPersonaDocumentoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PERSONA_DOCUMENTO(?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPtidodoc());
            stmt.setString(2, param.getPnumdoc());
            stmt.setString(3, param.getPnombre());
            stmt.registerOutParameter(4, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(4));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
//llamar al metedo
    public SpObtenerPersonaDocumentoParam spObtenerPersonaDocumento3(String dni) {
        try {
            SpObtenerPersonaDocumentoParam param = new SpObtenerPersonaDocumentoParam();
            return jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        public CallableStatement createCallableStatement(Connection conn) throws SQLException {
                            CallableStatement stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PERSONA_DOCUMENTO(?,?,?,?)}");
                            stmt.setString(1, "01");
                            stmt.setString(2, "71443462");
                            stmt.setString(3, "BARJA HILARION LIZBETH");
                            stmt.registerOutParameter(4, OracleTypes.CURSOR); // Assumed OracleTypes is imported correctly
                            return stmt;
                        }
                    },
                    new CallableStatementCallback<SpObtenerPersonaDocumentoParam>() {
                        public SpObtenerPersonaDocumentoParam doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                            cs.execute();
                            ResultSet rs = (ResultSet) cs.getObject(4);
                            param.setReg(rs);
                            rs.close();
                            return param;
                        }
                    }
            );
        } catch (DataAccessException dae) {
            // manejar la excepción relacionada con la base de datos
            dae.printStackTrace();
        }
        return null;
    }

    public SpObtenerPersonaDocumentoParam spObtenerPersonaDocumento2() {
        try {
            return jdbcTemplate.execute(
                    conn -> {
                        CallableStatement stmt = conn.prepareCall("{call PCKG_GENERAL.Sp_Operador_Logistico_Juridico(?)}");
                        stmt.registerOutParameter(1, OracleTypes.CURSOR); // Registrar el cuarto parámetro como un cursor.
                        return stmt;
                    },
                    (CallableStatementCallback<SpObtenerPersonaDocumentoParam>) cs -> {
                        cs.execute();
                        try (ResultSet rs = (ResultSet) cs.getObject(1)) { // AutoCloseable try-block para manejar el ResultSet
                            if (rs != null && rs.next()) { // Verificar si hay al menos un resultado
                                System.out.println("HAY ALMENOS UN DATO");
                                SpObtenerPersonaDocumentoParam param = new SpObtenerPersonaDocumentoParam();
                                param.setPnombre(rs.getString("Nombre_Razon_Social"));
                                param.setPnumdoc(rs.getString("Ruc"));
                                param.setPtidodoc(rs.getString("Persona_Tipo"));
                                param.setReg(rs);
                                 return param;
                            }
                        }
                        return null;
                    }
            );
        } catch (DataAccessException dae) {
            dae.printStackTrace();
        }
        return null;
    }




    public SpObtenerPersonaDocumentoWParam spObtenerPersonaDocumentoW(Connection conn, Map map) throws Exception {
        SpObtenerPersonaDocumentoWParam param = newSpObtenerPersonaDocumentoWParam(map);
        spObtenerPersonaDocumentoW(conn, param);
        return param;
    }

    public void spObtenerPersonaDocumentoW(Connection conn, SpObtenerPersonaDocumentoWParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PERSONA_DOCUMENTO_W(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPtipodoc());
            stmt.setString(2, param.getPnumdoc());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerPersonaDocvuceParam spObtenerPersonaDocvuce(Connection conn, Map map) throws Exception {
        SpObtenerPersonaDocvuceParam param = newSpObtenerPersonaDocvuceParam(map);
        spObtenerPersonaDocvuce(conn, param);
        return param;
    }

    public void spObtenerPersonaDocvuce(Connection conn, SpObtenerPersonaDocvuceParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PERSONA_DOCVUCE(?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPtidodoc());
            stmt.setString(2, param.getPnumdoc());
            stmt.setString(3, param.getPnombre());
            stmt.registerOutParameter(4, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(4));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerPersonaPParam spObtenerPersonaP(Connection conn, Map map) throws Exception {
        SpObtenerPersonaPParam param = newSpObtenerPersonaPParam(map);
        spObtenerPersonaP(conn, param);
        return param;
    }

    public void spObtenerPersonaP(Connection conn, SpObtenerPersonaPParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PERSONA_P(?,?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPtidodoc());
            stmt.setString(2, param.getPnumdoc());
            stmt.setString(3, param.getPnombre());
            stmt.setString(4, param.getPFormato());
            stmt.registerOutParameter(5, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(5));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerPersonaSucDocParam spObtenerPersonaSucDoc(Connection conn, Map map) throws Exception {
        SpObtenerPersonaSucDocParam param = newSpObtenerPersonaSucDocParam(map);
        spObtenerPersonaSucDoc(conn, param);
        return param;
    }

    public void spObtenerPersonaSucDoc(Connection conn, SpObtenerPersonaSucDocParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PERSONA_SUC_DOC(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodpersona());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerProdExpedienteParam spObtenerProdExpediente(Connection conn, Map map) throws Exception {
        SpObtenerProdExpedienteParam param = newSpObtenerProdExpedienteParam(map);
        spObtenerProdExpediente(conn, param);
        return param;
    }

    public void spObtenerProdExpediente(Connection conn, SpObtenerProdExpedienteParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_PROD_EXPEDIENTE(?,?,?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.setString(2, param.getCodigoservicio());
            stmt.setString(3, param.getPcodexpediente());
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerRepresentanteLegalParam spObtenerRepresentanteLegal(Connection conn, Map map) throws Exception {
        SpObtenerRepresentanteLegalParam param = newSpObtenerRepresentanteLegalParam(map);
        spObtenerRepresentanteLegal(conn, param);
        return param;
    }

    public void spObtenerRepresentanteLegal(Connection conn, SpObtenerRepresentanteLegalParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_REPRESENTANTE_LEGAL(?,?)}");
            String str = null;
            stmt.setString(1, param.getPPersonaId());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerSaldoParam spObtenerSaldo(Connection conn, Map map) throws Exception {
        SpObtenerSaldoParam param = newSpObtenerSaldoParam(map);
        spObtenerSaldo(conn, param);
        return param;
    }

    public void spObtenerSaldo(Connection conn, SpObtenerSaldoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_SALDO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPersonaid());
            stmt.registerOutParameter(2, Types.DECIMAL);
            stmt.execute();
            param.setMonto(stmt.getBigDecimal(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerSolicitanteParam spObtenerSolicitante(Connection conn, Map map) throws Exception {
        SpObtenerSolicitanteParam param = newSpObtenerSolicitanteParam(map);
        spObtenerSolicitante(conn, param);
        return param;
    }

    public void spObtenerSolicitante(Connection conn, SpObtenerSolicitanteParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_SOLICITANTE(?,?)}");
            String str = null;
            stmt.setString(1, param.getPPersonaId());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerSubproductosParam spObtenerSubproductos(Connection conn, Map map) throws Exception {
        SpObtenerSubproductosParam param = newSpObtenerSubproductosParam(map);
        spObtenerSubproductos(conn, param);
        return param;
    }

    public void spObtenerSubproductos(Connection conn, SpObtenerSubproductosParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_SUBPRODUCTOS(?,?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoproducto());
            stmt.setString(2, param.getPNombreproducto());
            stmt.setString(3, param.getPNombreCientifico());
            stmt.setString(4, param.getPPartidaArancel());
            stmt.registerOutParameter(5, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(5));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerSubtipoDocumentalParam spObtenerSubtipoDocumental(Connection conn, Map map) throws Exception {
        SpObtenerSubtipoDocumentalParam param = newSpObtenerSubtipoDocumentalParam(map);
        spObtenerSubtipoDocumental(conn, param);
        return param;
    }

    public void spObtenerSubtipoDocumental(Connection conn, SpObtenerSubtipoDocumentalParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_SUBTIPO_DOCUMENTAL(?,?)}");
            String str = null;
            stmt.setString(1, param.getPexpediente());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerTipoCertificadoParam spObtenerTipoCertificado(Connection conn, Map map) throws Exception {
        SpObtenerTipoCertificadoParam param = newSpObtenerTipoCertificadoParam(map);
        spObtenerTipoCertificado(conn, param);
        return param;
    }

    public void spObtenerTipoCertificado(Connection conn, SpObtenerTipoCertificadoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_TIPO_CERTIFICADO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoExpediente());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            param.setPTipoCertificado(stmt.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerTipoInspeccionParam spObtenerTipoInspeccion(Connection conn, Map map) throws Exception {
        SpObtenerTipoInspeccionParam param = newSpObtenerTipoInspeccionParam(map);
        spObtenerTipoInspeccion(conn, param);
        return param;
    }

    public void spObtenerTipoInspeccion(Connection conn, SpObtenerTipoInspeccionParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_TIPO_INSPECCION(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerUbigeoParam spObtenerUbigeo(Connection conn, Map map) throws Exception {
        SpObtenerUbigeoParam param = newSpObtenerUbigeoParam(map);
        spObtenerUbigeo(conn, param);
        return param;
    }

    public void spObtenerUbigeo(Connection conn, SpObtenerUbigeoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_UBIGEO(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setPReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerUbigeoDetalleParam spObtenerUbigeoDetalle(Connection conn, Map map) throws Exception {
        SpObtenerUbigeoDetalleParam param = newSpObtenerUbigeoDetalleParam(map);
        spObtenerUbigeoDetalle(conn, param);
        return param;
    }

    public void spObtenerUbigeoDetalle(Connection conn, SpObtenerUbigeoDetalleParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_UBIGEO_DETALLE(?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPNivel());
            stmt.setString(2, param.getPDepartamento());
            stmt.setString(3, param.getPProvincia());
            stmt.registerOutParameter(4, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(4));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerUcmIivParam spObtenerUcmIiv(Connection conn, Map map) throws Exception {
        SpObtenerUcmIivParam param = newSpObtenerUcmIivParam(map);
        spObtenerUcmIiv(conn, param);
        return param;
    }

    public void spObtenerUcmIiv(Connection conn, SpObtenerUcmIivParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_UCM_IIV(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodexp());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            param.setPucm(stmt.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerUcmIivImpoParam spObtenerUcmIivImpo(Connection conn, Map map) throws Exception {
        SpObtenerUcmIivImpoParam param = newSpObtenerUcmIivImpoParam(map);
        spObtenerUcmIivImpo(conn, param);
        return param;
    }

    public void spObtenerUcmIivImpo(Connection conn, SpObtenerUcmIivImpoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_UCM_IIV_IMPO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodexpediente());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            param.setUcmid(stmt.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerUcmReciboParam spObtenerUcmRecibo(Connection conn, Map map) throws Exception {
        SpObtenerUcmReciboParam param = newSpObtenerUcmReciboParam(map);
        spObtenerUcmRecibo(conn, param);
        return param;
    }

    public void spObtenerUcmRecibo(Connection conn, SpObtenerUcmReciboParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_UCM_RECIBO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodexpediente());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setCurOut((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerUcmidSolicitudParam spObtenerUcmidSolicitud(Connection conn, Map map) throws Exception {
        SpObtenerUcmidSolicitudParam param = newSpObtenerUcmidSolicitudParam(map);
        spObtenerUcmidSolicitud(conn, param);
        return param;
    }

    public void spObtenerUcmidSolicitud(Connection conn, SpObtenerUcmidSolicitudParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_UCMID_SOLICITUD(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodexpediente());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            param.setUcmid(stmt.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerUcmidsExpedienteParam spObtenerUcmidsExpediente(Connection conn, Map map) throws Exception {
        SpObtenerUcmidsExpedienteParam param = newSpObtenerUcmidsExpedienteParam(map);
        spObtenerUcmidsExpediente(conn, param);
        return param;
    }

    public void spObtenerUcmidsExpediente(Connection conn, SpObtenerUcmidsExpedienteParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_UCMIDS_EXPEDIENTE(?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodexpediente());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            param.setCadenaarchivo(stmt.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerVigenciaPermisoParam spObtenerVigenciaPermiso(Connection conn, Map map) throws Exception {
        SpObtenerVigenciaPermisoParam param = newSpObtenerVigenciaPermisoParam(map);
        spObtenerVigenciaPermiso(conn, param);
        return param;
    }

    public void spObtenerVigenciaPermiso(Connection conn, SpObtenerVigenciaPermisoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENER_VIGENCIA_PERMISO(?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoExpediente());
            stmt.setString(2, param.getPCodser());
            stmt.setString(3, param.getPFlgTipo());
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.execute();
            param.setPFlgVigencia(stmt.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpObtenerdoctypeucmParam spObtenerdoctypeucm(Connection conn, Map map) throws Exception {
        SpObtenerdoctypeucmParam param = newSpObtenerdoctypeucmParam(map);
        spObtenerdoctypeucm(conn, param);
        return param;
    }

    public void spObtenerdoctypeucm(Connection conn, SpObtenerdoctypeucmParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OBTENERDOCTYPEUCM(?,?)}");
            String str = null;
            stmt.setString(1, param.getPTipo());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpOperadorLogisticoJuridicoParam spOperadorLogisticoJuridico(Connection conn, Map map) throws Exception {
        SpOperadorLogisticoJuridicoParam param = newSpOperadorLogisticoJuridicoParam(map);
        spOperadorLogisticoJuridico(conn, param);
        return param;
    }

    public void spOperadorLogisticoJuridico(Connection conn, SpOperadorLogisticoJuridicoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OPERADOR_LOGISTICO_JURIDICO(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpOperadorLogisticoNaturalParam spOperadorLogisticoNatural(Connection conn, Map map) throws Exception {
        SpOperadorLogisticoNaturalParam param = newSpOperadorLogisticoNaturalParam(map);
        spOperadorLogisticoNatural(conn, param);
        return param;
    }

    public void spOperadorLogisticoNatural(Connection conn, SpOperadorLogisticoNaturalParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_OPERADOR_LOGISTICO_NATURAL(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpProcedimientoPorAreaParam spProcedimientoPorArea(Connection conn, Map map) throws Exception {
        SpProcedimientoPorAreaParam param = newSpProcedimientoPorAreaParam(map);
        spProcedimientoPorArea(conn, param);
        return param;
    }

    public void spProcedimientoPorArea(Connection conn, SpProcedimientoPorAreaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_PROCEDIMIENTO_POR_AREA(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPareagestion());
            stmt.setString(2, param.getIndicadorprocedimientognrl());
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpServicioProcedmientoAreaParam spServicioProcedmientoArea(Connection conn, Map map) throws Exception {
        SpServicioProcedmientoAreaParam param = newSpServicioProcedmientoAreaParam(map);
        spServicioProcedmientoArea(conn, param);
        return param;
    }

    public void spServicioProcedmientoArea(Connection conn, SpServicioProcedmientoAreaParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_SERVICIO_PROCEDMIENTO_AREA(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPproctupa());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.setString(3, param.getPCodServicio());
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpTipoDocumentoParam spTipoDocumento(Connection conn, Map map) throws Exception {
        SpTipoDocumentoParam param = newSpTipoDocumentoParam(map);
        spTipoDocumento(conn, param);
        return param;
    }

    public void spTipoDocumento(Connection conn, SpTipoDocumentoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_TIPO_DOCUMENTO(?)}");
            String str = null;
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            param.setReg((ResultSet) stmt.getObject(1));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpValidaCodigoParam spValidaCodigo(Connection conn, Map map) throws Exception {
        SpValidaCodigoParam param = newSpValidaCodigoParam(map);
        spValidaCodigo(conn, param);
        return param;
    }

    public void spValidaCodigo(Connection conn, SpValidaCodigoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_VALIDA_CODIGO(?,?)}");
            String str = null;
            stmt.setString(1, param.getPRegistro());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            param.setPCodigo(stmt.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpValidaCpeParam spValidaCpe(Connection conn, Map map) throws Exception {
        SpValidaCpeParam param = newSpValidaCpeParam(map);
        spValidaCpe(conn, param);
        return param;
    }

    public void spValidaCpe(Connection conn, SpValidaCpeParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_VALIDA_CPE(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoExpediente());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            param.setPCpe(stmt.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpValidaDocumentoPresentadoParam spValidaDocumentoPresentado(Connection conn, Map map) throws Exception {
        SpValidaDocumentoPresentadoParam param = newSpValidaDocumentoPresentadoParam(map);
        spValidaDocumentoPresentado(conn, param);
        return param;
    }

    public void spValidaDocumentoPresentado(Connection conn, SpValidaDocumentoPresentadoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_VALIDA_DOCUMENTO_PRESENTADO(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPcodexpediente());
            stmt.registerOutParameter(2, Types.INTEGER);
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.execute();
            param.setTotal(new Integer(stmt.getInt(2)));
            param.setTitulo(stmt.getString(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpValidaPermisoParam spValidaPermiso(Connection conn, Map map) throws Exception {
        SpValidaPermisoParam param = newSpValidaPermisoParam(map);
        spValidaPermiso(conn, param);
        return param;
    }

    public void spValidaPermiso(Connection conn, SpValidaPermisoParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_VALIDA_PERMISO(?,?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodExpediente());
            stmt.setString(2, param.getPFlagPermiso());
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, OracleTypes.CURSOR);
            stmt.execute();
            param.setPFlgExiste(stmt.getString(3));
            param.setRegpermiso((ResultSet) stmt.getObject(4));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpValidaProductoPadreParam spValidaProductoPadre(Connection conn, Map map) throws Exception {
        SpValidaProductoPadreParam param = newSpValidaProductoPadreParam(map);
        spValidaProductoPadre(conn, param);
        return param;
    }

    public void spValidaProductoPadre(Connection conn, SpValidaProductoPadreParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_VALIDA_PRODUCTO_PADRE(?,?)}");
            String str = null;
            stmt.setString(1, param.getPCodigoProducto());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            param.setPMensaje(stmt.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public SpValidaSolicitanteParam spValidaSolicitante(Connection conn, Map map) throws Exception {
        SpValidaSolicitanteParam param = newSpValidaSolicitanteParam(map);
        spValidaSolicitante(conn, param);
        return param;
    }

    public void spValidaSolicitante(Connection conn, SpValidaSolicitanteParam param) throws Exception {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{call PCKG_GENERAL.SP_VALIDA_SOLICITANTE(?,?,?)}");
            String str = null;
            stmt.setString(1, param.getPPersonaId());
            stmt.setString(2, param.getPFlgFormato());
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.execute();
            param.setPFlgPertenece(stmt.getString(3));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public EnvaseListarParam newEnvaseListarParam() {
        return new EnvaseListarParam();
    }

    public EnvaseListarParam newEnvaseListarParam(Map map) throws Exception {
        return new EnvaseListarParam(map);
    }

    public ListarPartidaArancelariaParam newListarPartidaArancelariaParam() {
        return new ListarPartidaArancelariaParam();
    }

    public ListarPartidaArancelariaParam newListarPartidaArancelariaParam(Map map) throws Exception {
        return new ListarPartidaArancelariaParam(map);
    }

    public ProductoBpmGetlistParam newProductoBpmGetlistParam() {
        return new ProductoBpmGetlistParam();
    }

    public ProductoBpmGetlistParam newProductoBpmGetlistParam(Map map) throws Exception {
        return new ProductoBpmGetlistParam(map);
    }

    public SpAreasGestionParam newSpAreasGestionParam() {
        return new SpAreasGestionParam();
    }

    public SpAreasGestionParam newSpAreasGestionParam(Map map) throws Exception {
        return new SpAreasGestionParam(map);
    }

    public SpBuscarPersonaParam newSpBuscarPersonaParam() {
        return new SpBuscarPersonaParam();
    }

    public SpBuscarPersonaParam newSpBuscarPersonaParam(Map map) throws Exception {
        return new SpBuscarPersonaParam(map);
    }

    public SpCalcularXTipoInspeccionParam newSpCalcularXTipoInspeccionParam() {
        return new SpCalcularXTipoInspeccionParam();
    }

    public SpCalcularXTipoInspeccionParam newSpCalcularXTipoInspeccionParam(Map map) throws Exception {
        return new SpCalcularXTipoInspeccionParam(map);
    }

    public SpCalculoMontoConceptoParam newSpCalculoMontoConceptoParam() {
        return new SpCalculoMontoConceptoParam();
    }

    public SpCalculoMontoConceptoParam newSpCalculoMontoConceptoParam(Map map) throws Exception {
        return new SpCalculoMontoConceptoParam(map);
    }

    public SpCalculoMontoConcepto1Param newSpCalculoMontoConcepto1Param() {
        return new SpCalculoMontoConcepto1Param();
    }

    public SpCalculoMontoConcepto1Param newSpCalculoMontoConcepto1Param(Map map) throws Exception {
        return new SpCalculoMontoConcepto1Param(map);
    }

    public SpCentroTramiteParam newSpCentroTramiteParam() {
        return new SpCentroTramiteParam();
    }

    public SpCentroTramiteParam newSpCentroTramiteParam(Map map) throws Exception {
        return new SpCentroTramiteParam(map);
    }

    public SpCentroTramitePersonaParam newSpCentroTramitePersonaParam() {
        return new SpCentroTramitePersonaParam();
    }

    public SpCentroTramitePersonaParam newSpCentroTramitePersonaParam(Map map) throws Exception {
        return new SpCentroTramitePersonaParam(map);
    }

    public SpCentroTramiteUbigeoParam newSpCentroTramiteUbigeoParam() {
        return new SpCentroTramiteUbigeoParam();
    }

    public SpCentroTramiteUbigeoParam newSpCentroTramiteUbigeoParam(Map map) throws Exception {
        return new SpCentroTramiteUbigeoParam(map);
    }

    public SpConvHospedanteCultivoParam newSpConvHospedanteCultivoParam() {
        return new SpConvHospedanteCultivoParam();
    }

    public SpConvHospedanteCultivoParam newSpConvHospedanteCultivoParam(Map map) throws Exception {
        return new SpConvHospedanteCultivoParam(map);
    }

    public SpDocumentosIdentidadParam newSpDocumentosIdentidadParam() {
        return new SpDocumentosIdentidadParam();
    }

    public SpDocumentosIdentidadParam newSpDocumentosIdentidadParam(Map map) throws Exception {
        return new SpDocumentosIdentidadParam(map);
    }

    public SpEnviarAprobacionrevdocParam newSpEnviarAprobacionrevdocParam() {
        return new SpEnviarAprobacionrevdocParam();
    }

    public SpEnviarAprobacionrevdocParam newSpEnviarAprobacionrevdocParam(Map map) throws Exception {
        return new SpEnviarAprobacionrevdocParam(map);
    }

    public SpEnviarNoejecInspeccionParam newSpEnviarNoejecInspeccionParam() {
        return new SpEnviarNoejecInspeccionParam();
    }

    public SpEnviarNoejecInspeccionParam newSpEnviarNoejecInspeccionParam(Map map) throws Exception {
        return new SpEnviarNoejecInspeccionParam(map);
    }

    public SpFiltrosBuscarPersonaParam newSpFiltrosBuscarPersonaParam() {
        return new SpFiltrosBuscarPersonaParam();
    }

    public SpFiltrosBuscarPersonaParam newSpFiltrosBuscarPersonaParam(Map map) throws Exception {
        return new SpFiltrosBuscarPersonaParam(map);
    }

    public SpGetCodigoDepProvDisParam newSpGetCodigoDepProvDisParam() {
        return new SpGetCodigoDepProvDisParam();
    }

    public SpGetCodigoDepProvDisParam newSpGetCodigoDepProvDisParam(Map map) throws Exception {
        return new SpGetCodigoDepProvDisParam(map);
    }

    public SpGetOrdenPorMtoParam newSpGetOrdenPorMtoParam() {
        return new SpGetOrdenPorMtoParam();
    }

    public SpGetOrdenPorMtoParam newSpGetOrdenPorMtoParam(Map map) throws Exception {
        return new SpGetOrdenPorMtoParam(map);
    }

    public SpGetReportePfiParam newSpGetReportePfiParam() {
        return new SpGetReportePfiParam();
    }

    public SpGetReportePfiParam newSpGetReportePfiParam(Map map) throws Exception {
        return new SpGetReportePfiParam(map);
    }

    public SpGetReportePfiProdAnexosParam newSpGetReportePfiProdAnexosParam() {
        return new SpGetReportePfiProdAnexosParam();
    }

    public SpGetReportePfiProdAnexosParam newSpGetReportePfiProdAnexosParam(Map map) throws Exception {
        return new SpGetReportePfiProdAnexosParam(map);
    }

    public SpGetReportePziParam newSpGetReportePziParam() {
        return new SpGetReportePziParam();
    }

    public SpGetReportePziParam newSpGetReportePziParam(Map map) throws Exception {
        return new SpGetReportePziParam(map);
    }

    public SpGetReportePziCabeseraParam newSpGetReportePziCabeseraParam() {
        return new SpGetReportePziCabeseraParam();
    }

    public SpGetReportePziCabeseraParam newSpGetReportePziCabeseraParam(Map map) throws Exception {
        return new SpGetReportePziCabeseraParam(map);
    }

    public SpGetReportePziProdAnexosParam newSpGetReportePziProdAnexosParam() {
        return new SpGetReportePziProdAnexosParam();
    }

    public SpGetReportePziProdAnexosParam newSpGetReportePziProdAnexosParam(Map map) throws Exception {
        return new SpGetReportePziProdAnexosParam(map);
    }

    public SpGrabarServicioAdicionalParam newSpGrabarServicioAdicionalParam() {
        return new SpGrabarServicioAdicionalParam();
    }

    public SpGrabarServicioAdicionalParam newSpGrabarServicioAdicionalParam(Map map) throws Exception {
        return new SpGrabarServicioAdicionalParam(map);
    }

    public SpInfoProcedimientoServicioParam newSpInfoProcedimientoServicioParam() {
        return new SpInfoProcedimientoServicioParam();
    }

    public SpInfoProcedimientoServicioParam newSpInfoProcedimientoServicioParam(Map map) throws Exception {
        return new SpInfoProcedimientoServicioParam(map);
    }

    public SpInspectoresParam newSpInspectoresParam() {
        return new SpInspectoresParam();
    }

    public SpInspectoresParam newSpInspectoresParam(Map map) throws Exception {
        return new SpInspectoresParam(map);
    }

    public SpInspectoresCentroTramiteParam newSpInspectoresCentroTramiteParam() {
        return new SpInspectoresCentroTramiteParam();
    }

    public SpInspectoresCentroTramiteParam newSpInspectoresCentroTramiteParam(Map map) throws Exception {
        return new SpInspectoresCentroTramiteParam(map);
    }

    public SpInspectoresDepartamentoParam newSpInspectoresDepartamentoParam() {
        return new SpInspectoresDepartamentoParam();
    }

    public SpInspectoresDepartamentoParam newSpInspectoresDepartamentoParam(Map map) throws Exception {
        return new SpInspectoresDepartamentoParam(map);
    }

    public SpInspectoresSedeParam newSpInspectoresSedeParam() {
        return new SpInspectoresSedeParam();
    }

    public SpInspectoresSedeParam newSpInspectoresSedeParam(Map map) throws Exception {
        return new SpInspectoresSedeParam(map);
    }

    public SpInspectoresporubigeoParam newSpInspectoresporubigeoParam() {
        return new SpInspectoresporubigeoParam();
    }

    public SpInspectoresporubigeoParam newSpInspectoresporubigeoParam(Map map) throws Exception {
        return new SpInspectoresporubigeoParam(map);
    }

    public SpListaAlmacenGcustodiaParam newSpListaAlmacenGcustodiaParam() {
        return new SpListaAlmacenGcustodiaParam();
    }

    public SpListaAlmacenGcustodiaParam newSpListaAlmacenGcustodiaParam(Map map) throws Exception {
        return new SpListaAlmacenGcustodiaParam(map);
    }

    public SpListaAnalisisParam newSpListaAnalisisParam() {
        return new SpListaAnalisisParam();
    }

    public SpListaAnalisisParam newSpListaAnalisisParam(Map map) throws Exception {
        return new SpListaAnalisisParam(map);
    }

    public SpListaAplicacionParam newSpListaAplicacionParam() {
        return new SpListaAplicacionParam();
    }

    public SpListaAplicacionParam newSpListaAplicacionParam(Map map) throws Exception {
        return new SpListaAplicacionParam(map);
    }

    public SpListaAplicacionProductoParam newSpListaAplicacionProductoParam() {
        return new SpListaAplicacionProductoParam();
    }

    public SpListaAplicacionProductoParam newSpListaAplicacionProductoParam(Map map) throws Exception {
        return new SpListaAplicacionProductoParam(map);
    }

    public SpListaAreaLaboratorioParam newSpListaAreaLaboratorioParam() {
        return new SpListaAreaLaboratorioParam();
    }

    public SpListaAreaLaboratorioParam newSpListaAreaLaboratorioParam(Map map) throws Exception {
        return new SpListaAreaLaboratorioParam(map);
    }

    public SpListaDictamenParam newSpListaDictamenParam() {
        return new SpListaDictamenParam();
    }

    public SpListaDictamenParam newSpListaDictamenParam(Map map) throws Exception {
        return new SpListaDictamenParam(map);
    }

    public SpListaLugarInspeccionParam newSpListaLugarInspeccionParam() {
        return new SpListaLugarInspeccionParam();
    }

    public SpListaLugarInspeccionParam newSpListaLugarInspeccionParam(Map map) throws Exception {
        return new SpListaLugarInspeccionParam(map);
    }

    public SpListaLugarProduccionParam newSpListaLugarProduccionParam() {
        return new SpListaLugarProduccionParam();
    }

    public SpListaLugarProduccionParam newSpListaLugarProduccionParam(Map map) throws Exception {
        return new SpListaLugarProduccionParam(map);
    }

    public SpListaMotivoParam newSpListaMotivoParam() {
        return new SpListaMotivoParam();
    }

    public SpListaMotivoParam newSpListaMotivoParam(Map map) throws Exception {
        return new SpListaMotivoParam(map);
    }

    public SpListaMotivoTratamientoParam newSpListaMotivoTratamientoParam() {
        return new SpListaMotivoTratamientoParam();
    }

    public SpListaMotivoTratamientoParam newSpListaMotivoTratamientoParam(Map map) throws Exception {
        return new SpListaMotivoTratamientoParam(map);
    }

    public SpListaPaisParam newSpListaPaisParam() {
        return new SpListaPaisParam();
    }

    public SpListaPaisParam newSpListaPaisParam(Map map) throws Exception {
        return new SpListaPaisParam(map);
    }

    public SpListaPlagaTratamientoParam newSpListaPlagaTratamientoParam() {
        return new SpListaPlagaTratamientoParam();
    }

    public SpListaPlagaTratamientoParam newSpListaPlagaTratamientoParam(Map map) throws Exception {
        return new SpListaPlagaTratamientoParam(map);
    }

    public SpListaProcOrigenMuestraParam newSpListaProcOrigenMuestraParam() {
        return new SpListaProcOrigenMuestraParam();
    }

    public SpListaProcOrigenMuestraParam newSpListaProcOrigenMuestraParam(Map map) throws Exception {
        return new SpListaProcOrigenMuestraParam(map);
    }

    public SpListaProduccionPfiParam newSpListaProduccionPfiParam() {
        return new SpListaProduccionPfiParam();
    }

    public SpListaProduccionPfiParam newSpListaProduccionPfiParam(Map map) throws Exception {
        return new SpListaProduccionPfiParam(map);
    }

    public SpListaRazaParam newSpListaRazaParam() {
        return new SpListaRazaParam();
    }

    public SpListaRazaParam newSpListaRazaParam(Map map) throws Exception {
        return new SpListaRazaParam(map);
    }

    public SpListaServAnalisisAnimalParam newSpListaServAnalisisAnimalParam() {
        return new SpListaServAnalisisAnimalParam();
    }

    public SpListaServAnalisisAnimalParam newSpListaServAnalisisAnimalParam(Map map) throws Exception {
        return new SpListaServAnalisisAnimalParam(map);
    }

    public SpListaServAnalisisVegetalParam newSpListaServAnalisisVegetalParam() {
        return new SpListaServAnalisisVegetalParam();
    }

    public SpListaServAnalisisVegetalParam newSpListaServAnalisisVegetalParam(Map map) throws Exception {
        return new SpListaServAnalisisVegetalParam(map);
    }

    public SpListaSexoParam newSpListaSexoParam() {
        return new SpListaSexoParam();
    }

    public SpListaSexoParam newSpListaSexoParam(Map map) throws Exception {
        return new SpListaSexoParam(map);
    }

    public SpListaTipoCrianzaParam newSpListaTipoCrianzaParam() {
        return new SpListaTipoCrianzaParam();
    }

    public SpListaTipoCrianzaParam newSpListaTipoCrianzaParam(Map map) throws Exception {
        return new SpListaTipoCrianzaParam(map);
    }

    public SpListaTipoEnvaseParam newSpListaTipoEnvaseParam() {
        return new SpListaTipoEnvaseParam();
    }

    public SpListaTipoEnvaseParam newSpListaTipoEnvaseParam(Map map) throws Exception {
        return new SpListaTipoEnvaseParam(map);
    }

    public SpListaTipoEspecieAnimalParam newSpListaTipoEspecieAnimalParam() {
        return new SpListaTipoEspecieAnimalParam();
    }

    public SpListaTipoEspecieAnimalParam newSpListaTipoEspecieAnimalParam(Map map) throws Exception {
        return new SpListaTipoEspecieAnimalParam(map);
    }

    public SpListaTipoIdentificacionParam newSpListaTipoIdentificacionParam() {
        return new SpListaTipoIdentificacionParam();
    }

    public SpListaTipoIdentificacionParam newSpListaTipoIdentificacionParam(Map map) throws Exception {
        return new SpListaTipoIdentificacionParam(map);
    }

    public SpListaTipoMuestraAnimalParam newSpListaTipoMuestraAnimalParam() {
        return new SpListaTipoMuestraAnimalParam();
    }

    public SpListaTipoMuestraAnimalParam newSpListaTipoMuestraAnimalParam(Map map) throws Exception {
        return new SpListaTipoMuestraAnimalParam(map);
    }

    public SpListaTipoMuestraVegetalParam newSpListaTipoMuestraVegetalParam() {
        return new SpListaTipoMuestraVegetalParam();
    }

    public SpListaTipoMuestraVegetalParam newSpListaTipoMuestraVegetalParam(Map map) throws Exception {
        return new SpListaTipoMuestraVegetalParam(map);
    }

    public SpListaTipoRecintoParam newSpListaTipoRecintoParam() {
        return new SpListaTipoRecintoParam();
    }

    public SpListaTipoRecintoParam newSpListaTipoRecintoParam(Map map) throws Exception {
        return new SpListaTipoRecintoParam(map);
    }

    public SpListaUnidMedProductoParam newSpListaUnidMedProductoParam() {
        return new SpListaUnidMedProductoParam();
    }

    public SpListaUnidMedProductoParam newSpListaUnidMedProductoParam(Map map) throws Exception {
        return new SpListaUnidMedProductoParam(map);
    }

    public SpListaUnidadMedidaParam newSpListaUnidadMedidaParam() {
        return new SpListaUnidadMedidaParam();
    }

    public SpListaUnidadMedidaParam newSpListaUnidadMedidaParam(Map map) throws Exception {
        return new SpListaUnidadMedidaParam(map);
    }

    public SpListarFabricantesParam newSpListarFabricantesParam() {
        return new SpListarFabricantesParam();
    }

    public SpListarFabricantesParam newSpListarFabricantesParam(Map map) throws Exception {
        return new SpListarFabricantesParam(map);
    }

    public SpListarPartidaArancelariaParam newSpListarPartidaArancelariaParam() {
        return new SpListarPartidaArancelariaParam();
    }

    public SpListarPartidaArancelariaParam newSpListarPartidaArancelariaParam(Map map) throws Exception {
        return new SpListarPartidaArancelariaParam(map);
    }

    public SpListarTipoEnvaseParam newSpListarTipoEnvaseParam() {
        return new SpListarTipoEnvaseParam();
    }

    public SpListarTipoEnvaseParam newSpListarTipoEnvaseParam(Map map) throws Exception {
        return new SpListarTipoEnvaseParam(map);
    }

    public SpListarUnidadMedidaParam newSpListarUnidadMedidaParam() {
        return new SpListarUnidadMedidaParam();
    }

    public SpListarUnidadMedidaParam newSpListarUnidadMedidaParam(Map map) throws Exception {
        return new SpListarUnidadMedidaParam(map);
    }

    public SpMedioTransporteParam newSpMedioTransporteParam() {
        return new SpMedioTransporteParam();
    }

    public SpMedioTransporteParam newSpMedioTransporteParam(Map map) throws Exception {
        return new SpMedioTransporteParam(map);
    }

    public SpObtenerAdjuntosParam newSpObtenerAdjuntosParam() {
        return new SpObtenerAdjuntosParam();
    }

    public SpObtenerAdjuntosParam newSpObtenerAdjuntosParam(Map map) throws Exception {
        return new SpObtenerAdjuntosParam(map);
    }

    public SpObtenerAdjuntosVuceParam newSpObtenerAdjuntosVuceParam() {
        return new SpObtenerAdjuntosVuceParam();
    }

    public SpObtenerAdjuntosVuceParam newSpObtenerAdjuntosVuceParam(Map map) throws Exception {
        return new SpObtenerAdjuntosVuceParam(map);
    }

    public SpObtenerAnalisisCatalServParam newSpObtenerAnalisisCatalServParam() {
        return new SpObtenerAnalisisCatalServParam();
    }

    public SpObtenerAnalisisCatalServParam newSpObtenerAnalisisCatalServParam(Map map) throws Exception {
        return new SpObtenerAnalisisCatalServParam(map);
    }

    public SpObtenerCertParam newSpObtenerCertParam() {
        return new SpObtenerCertParam();
    }

    public SpObtenerCertParam newSpObtenerCertParam(Map map) throws Exception {
        return new SpObtenerCertParam(map);
    }

    public SpObtenerClasesCatalServParam newSpObtenerClasesCatalServParam() {
        return new SpObtenerClasesCatalServParam();
    }

    public SpObtenerClasesCatalServParam newSpObtenerClasesCatalServParam(Map map) throws Exception {
        return new SpObtenerClasesCatalServParam(map);
    }

    public SpObtenerCodiivExpedienteParam newSpObtenerCodiivExpedienteParam() {
        return new SpObtenerCodiivExpedienteParam();
    }

    public SpObtenerCodiivExpedienteParam newSpObtenerCodiivExpedienteParam(Map map) throws Exception {
        return new SpObtenerCodiivExpedienteParam(map);
    }

    public SpObtenerDescDocumentoParam newSpObtenerDescDocumentoParam() {
        return new SpObtenerDescDocumentoParam();
    }

    public SpObtenerDescDocumentoParam newSpObtenerDescDocumentoParam(Map map) throws Exception {
        return new SpObtenerDescDocumentoParam(map);
    }

    public SpObtenerDireccionImpoParam newSpObtenerDireccionImpoParam() {
        return new SpObtenerDireccionImpoParam();
    }

    public SpObtenerDireccionImpoParam newSpObtenerDireccionImpoParam(Map map) throws Exception {
        return new SpObtenerDireccionImpoParam(map);
    }

    public SpObtenerEmpresaTratamientoParam newSpObtenerEmpresaTratamientoParam() {
        return new SpObtenerEmpresaTratamientoParam();
    }

    public SpObtenerEmpresaTratamientoParam newSpObtenerEmpresaTratamientoParam(Map map) throws Exception {
        return new SpObtenerEmpresaTratamientoParam(map);
    }

    public SpObtenerEntidNombreRucParam newSpObtenerEntidNombreRucParam() {
        return new SpObtenerEntidNombreRucParam();
    }

    public SpObtenerEntidNombreRucParam newSpObtenerEntidNombreRucParam(Map map) throws Exception {
        return new SpObtenerEntidNombreRucParam(map);
    }

    public SpObtenerExpedientePermisoParam newSpObtenerExpedientePermisoParam() {
        return new SpObtenerExpedientePermisoParam();
    }

    public SpObtenerExpedientePermisoParam newSpObtenerExpedientePermisoParam(Map map) throws Exception {
        return new SpObtenerExpedientePermisoParam(map);
    }

    public SpObtenerFamiliasCatalServParam newSpObtenerFamiliasCatalServParam() {
        return new SpObtenerFamiliasCatalServParam();
    }

    public SpObtenerFamiliasCatalServParam newSpObtenerFamiliasCatalServParam(Map map) throws Exception {
        return new SpObtenerFamiliasCatalServParam(map);
    }

    public SpObtenerImportadoresParam newSpObtenerImportadoresParam() {
        return new SpObtenerImportadoresParam();
    }

    public SpObtenerImportadoresParam newSpObtenerImportadoresParam(Map map) throws Exception {
        return new SpObtenerImportadoresParam(map);
    }

    public SpObtenerImportadoresVuceParam newSpObtenerImportadoresVuceParam() {
        return new SpObtenerImportadoresVuceParam();
    }

    public SpObtenerImportadoresVuceParam newSpObtenerImportadoresVuceParam(Map map) throws Exception {
        return new SpObtenerImportadoresVuceParam(map);
    }

    public SpObtenerListaAnalisisParam newSpObtenerListaAnalisisParam() {
        return new SpObtenerListaAnalisisParam();
    }

    public SpObtenerListaAnalisisParam newSpObtenerListaAnalisisParam(Map map) throws Exception {
        return new SpObtenerListaAnalisisParam(map);
    }

    public SpObtenerListaAreaParam newSpObtenerListaAreaParam() {
        return new SpObtenerListaAreaParam();
    }

    public SpObtenerListaAreaParam newSpObtenerListaAreaParam(Map map) throws Exception {
        return new SpObtenerListaAreaParam(map);
    }

    public SpObtenerListaFuncionarioParam newSpObtenerListaFuncionarioParam() {
        return new SpObtenerListaFuncionarioParam();
    }

    public SpObtenerListaFuncionarioParam newSpObtenerListaFuncionarioParam(Map map) throws Exception {
        return new SpObtenerListaFuncionarioParam(map);
    }

    public SpObtenerListaPrediosParam newSpObtenerListaPrediosParam() {
        return new SpObtenerListaPrediosParam();
    }

    public SpObtenerListaPrediosParam newSpObtenerListaPrediosParam(Map map) throws Exception {
        return new SpObtenerListaPrediosParam(map);
    }

    public SpObtenerListaSubAreaParam newSpObtenerListaSubAreaParam() {
        return new SpObtenerListaSubAreaParam();
    }

    public SpObtenerListaSubAreaParam newSpObtenerListaSubAreaParam(Map map) throws Exception {
        return new SpObtenerListaSubAreaParam(map);
    }

    public SpObtenerListaSubTipoDocParam newSpObtenerListaSubTipoDocParam() {
        return new SpObtenerListaSubTipoDocParam();
    }

    public SpObtenerListaSubTipoDocParam newSpObtenerListaSubTipoDocParam(Map map) throws Exception {
        return new SpObtenerListaSubTipoDocParam(map);
    }

    public SpObtenerListaTipoDocParam newSpObtenerListaTipoDocParam() {
        return new SpObtenerListaTipoDocParam();
    }

    public SpObtenerListaTipoDocParam newSpObtenerListaTipoDocParam(Map map) throws Exception {
        return new SpObtenerListaTipoDocParam(map);
    }

    public SpObtenerListaVacunasParam newSpObtenerListaVacunasParam() {
        return new SpObtenerListaVacunasParam();
    }

    public SpObtenerListaVacunasParam newSpObtenerListaVacunasParam(Map map) throws Exception {
        return new SpObtenerListaVacunasParam(map);
    }

    public SpObtenerOperadorParam newSpObtenerOperadorParam() {
        return new SpObtenerOperadorParam();
    }

    public SpObtenerOperadorParam newSpObtenerOperadorParam(Map map) throws Exception {
        return new SpObtenerOperadorParam(map);
    }

    public SpObtenerPersonaParam newSpObtenerPersonaParam() {
        return new SpObtenerPersonaParam();
    }

    public SpObtenerPersonaParam newSpObtenerPersonaParam(Map map) throws Exception {
        return new SpObtenerPersonaParam(map);
    }

    public SpObtenerPersonaDocParam newSpObtenerPersonaDocParam() {
        return new SpObtenerPersonaDocParam();
    }

    public SpObtenerPersonaDocParam newSpObtenerPersonaDocParam(Map map) throws Exception {
        return new SpObtenerPersonaDocParam(map);
    }

    public SpObtenerPersonaDocAduanaParam newSpObtenerPersonaDocAduanaParam() {
        return new SpObtenerPersonaDocAduanaParam();
    }

    public SpObtenerPersonaDocAduanaParam newSpObtenerPersonaDocAduanaParam(Map map) throws Exception {
        return new SpObtenerPersonaDocAduanaParam(map);
    }

    public SpObtenerPersonaDocIiParam newSpObtenerPersonaDocIiParam() {
        return new SpObtenerPersonaDocIiParam();
    }

    public SpObtenerPersonaDocIiParam newSpObtenerPersonaDocIiParam(Map map) throws Exception {
        return new SpObtenerPersonaDocIiParam(map);
    }

    public SpObtenerPersonaDocumentoParam newSpObtenerPersonaDocumentoParam() {
        return new SpObtenerPersonaDocumentoParam();
    }

    public SpObtenerPersonaDocumentoParam newSpObtenerPersonaDocumentoParam(Map map) throws Exception {
        return new SpObtenerPersonaDocumentoParam(map);
    }

    public SpObtenerPersonaDocumentoWParam newSpObtenerPersonaDocumentoWParam() {
        return new SpObtenerPersonaDocumentoWParam();
    }

    public SpObtenerPersonaDocumentoWParam newSpObtenerPersonaDocumentoWParam(Map map) throws Exception {
        return new SpObtenerPersonaDocumentoWParam(map);
    }

    public SpObtenerPersonaDocvuceParam newSpObtenerPersonaDocvuceParam() {
        return new SpObtenerPersonaDocvuceParam();
    }

    public SpObtenerPersonaDocvuceParam newSpObtenerPersonaDocvuceParam(Map map) throws Exception {
        return new SpObtenerPersonaDocvuceParam(map);
    }

    public SpObtenerPersonaPParam newSpObtenerPersonaPParam() {
        return new SpObtenerPersonaPParam();
    }

    public SpObtenerPersonaPParam newSpObtenerPersonaPParam(Map map) throws Exception {
        return new SpObtenerPersonaPParam(map);
    }

    public SpObtenerPersonaSucDocParam newSpObtenerPersonaSucDocParam() {
        return new SpObtenerPersonaSucDocParam();
    }

    public SpObtenerPersonaSucDocParam newSpObtenerPersonaSucDocParam(Map map) throws Exception {
        return new SpObtenerPersonaSucDocParam(map);
    }

    public SpObtenerProdExpedienteParam newSpObtenerProdExpedienteParam() {
        return new SpObtenerProdExpedienteParam();
    }

    public SpObtenerProdExpedienteParam newSpObtenerProdExpedienteParam(Map map) throws Exception {
        return new SpObtenerProdExpedienteParam(map);
    }

    public SpObtenerRepresentanteLegalParam newSpObtenerRepresentanteLegalParam() {
        return new SpObtenerRepresentanteLegalParam();
    }

    public SpObtenerRepresentanteLegalParam newSpObtenerRepresentanteLegalParam(Map map) throws Exception {
        return new SpObtenerRepresentanteLegalParam(map);
    }

    public SpObtenerSaldoParam newSpObtenerSaldoParam() {
        return new SpObtenerSaldoParam();
    }

    public SpObtenerSaldoParam newSpObtenerSaldoParam(Map map) throws Exception {
        return new SpObtenerSaldoParam(map);
    }

    public SpObtenerSolicitanteParam newSpObtenerSolicitanteParam() {
        return new SpObtenerSolicitanteParam();
    }

    public SpObtenerSolicitanteParam newSpObtenerSolicitanteParam(Map map) throws Exception {
        return new SpObtenerSolicitanteParam(map);
    }

    public SpObtenerSubproductosParam newSpObtenerSubproductosParam() {
        return new SpObtenerSubproductosParam();
    }

    public SpObtenerSubproductosParam newSpObtenerSubproductosParam(Map map) throws Exception {
        return new SpObtenerSubproductosParam(map);
    }

    public SpObtenerSubtipoDocumentalParam newSpObtenerSubtipoDocumentalParam() {
        return new SpObtenerSubtipoDocumentalParam();
    }

    public SpObtenerSubtipoDocumentalParam newSpObtenerSubtipoDocumentalParam(Map map) throws Exception {
        return new SpObtenerSubtipoDocumentalParam(map);
    }

    public SpObtenerTipoCertificadoParam newSpObtenerTipoCertificadoParam() {
        return new SpObtenerTipoCertificadoParam();
    }

    public SpObtenerTipoCertificadoParam newSpObtenerTipoCertificadoParam(Map map) throws Exception {
        return new SpObtenerTipoCertificadoParam(map);
    }

    public SpObtenerTipoInspeccionParam newSpObtenerTipoInspeccionParam() {
        return new SpObtenerTipoInspeccionParam();
    }

    public SpObtenerTipoInspeccionParam newSpObtenerTipoInspeccionParam(Map map) throws Exception {
        return new SpObtenerTipoInspeccionParam(map);
    }

    public SpObtenerUbigeoParam newSpObtenerUbigeoParam() {
        return new SpObtenerUbigeoParam();
    }

    public SpObtenerUbigeoParam newSpObtenerUbigeoParam(Map map) throws Exception {
        return new SpObtenerUbigeoParam(map);
    }

    public SpObtenerUbigeoDetalleParam newSpObtenerUbigeoDetalleParam() {
        return new SpObtenerUbigeoDetalleParam();
    }

    public SpObtenerUbigeoDetalleParam newSpObtenerUbigeoDetalleParam(Map map) throws Exception {
        return new SpObtenerUbigeoDetalleParam(map);
    }

    public SpObtenerUcmIivParam newSpObtenerUcmIivParam() {
        return new SpObtenerUcmIivParam();
    }

    public SpObtenerUcmIivParam newSpObtenerUcmIivParam(Map map) throws Exception {
        return new SpObtenerUcmIivParam(map);
    }

    public SpObtenerUcmIivImpoParam newSpObtenerUcmIivImpoParam() {
        return new SpObtenerUcmIivImpoParam();
    }

    public SpObtenerUcmIivImpoParam newSpObtenerUcmIivImpoParam(Map map) throws Exception {
        return new SpObtenerUcmIivImpoParam(map);
    }

    public SpObtenerUcmReciboParam newSpObtenerUcmReciboParam() {
        return new SpObtenerUcmReciboParam();
    }

    public SpObtenerUcmReciboParam newSpObtenerUcmReciboParam(Map map) throws Exception {
        return new SpObtenerUcmReciboParam(map);
    }

    public SpObtenerUcmidSolicitudParam newSpObtenerUcmidSolicitudParam() {
        return new SpObtenerUcmidSolicitudParam();
    }

    public SpObtenerUcmidSolicitudParam newSpObtenerUcmidSolicitudParam(Map map) throws Exception {
        return new SpObtenerUcmidSolicitudParam(map);
    }

    public SpObtenerUcmidsExpedienteParam newSpObtenerUcmidsExpedienteParam() {
        return new SpObtenerUcmidsExpedienteParam();
    }

    public SpObtenerUcmidsExpedienteParam newSpObtenerUcmidsExpedienteParam(Map map) throws Exception {
        return new SpObtenerUcmidsExpedienteParam(map);
    }

    public SpObtenerVigenciaPermisoParam newSpObtenerVigenciaPermisoParam() {
        return new SpObtenerVigenciaPermisoParam();
    }

    public SpObtenerVigenciaPermisoParam newSpObtenerVigenciaPermisoParam(Map map) throws Exception {
        return new SpObtenerVigenciaPermisoParam(map);
    }

    public SpObtenerdoctypeucmParam newSpObtenerdoctypeucmParam() {
        return new SpObtenerdoctypeucmParam();
    }

    public SpObtenerdoctypeucmParam newSpObtenerdoctypeucmParam(Map map) throws Exception {
        return new SpObtenerdoctypeucmParam(map);
    }

    public SpOperadorLogisticoJuridicoParam newSpOperadorLogisticoJuridicoParam() {
        return new SpOperadorLogisticoJuridicoParam();
    }

    public SpOperadorLogisticoJuridicoParam newSpOperadorLogisticoJuridicoParam(Map map) throws Exception {
        return new SpOperadorLogisticoJuridicoParam(map);
    }

    public SpOperadorLogisticoNaturalParam newSpOperadorLogisticoNaturalParam() {
        return new SpOperadorLogisticoNaturalParam();
    }

    public SpOperadorLogisticoNaturalParam newSpOperadorLogisticoNaturalParam(Map map) throws Exception {
        return new SpOperadorLogisticoNaturalParam(map);
    }

    public SpProcedimientoPorAreaParam newSpProcedimientoPorAreaParam() {
        return new SpProcedimientoPorAreaParam();
    }

    public SpProcedimientoPorAreaParam newSpProcedimientoPorAreaParam(Map map) throws Exception {
        return new SpProcedimientoPorAreaParam(map);
    }

    public SpServicioProcedmientoAreaParam newSpServicioProcedmientoAreaParam() {
        return new SpServicioProcedmientoAreaParam();
    }

    public SpServicioProcedmientoAreaParam newSpServicioProcedmientoAreaParam(Map map) throws Exception {
        return new SpServicioProcedmientoAreaParam(map);
    }

    public SpTipoDocumentoParam newSpTipoDocumentoParam() {
        return new SpTipoDocumentoParam();
    }

    public SpTipoDocumentoParam newSpTipoDocumentoParam(Map map) throws Exception {
        return new SpTipoDocumentoParam(map);
    }

    public SpValidaCodigoParam newSpValidaCodigoParam() {
        return new SpValidaCodigoParam();
    }

    public SpValidaCodigoParam newSpValidaCodigoParam(Map map) throws Exception {
        return new SpValidaCodigoParam(map);
    }

    public SpValidaCpeParam newSpValidaCpeParam() {
        return new SpValidaCpeParam();
    }

    public SpValidaCpeParam newSpValidaCpeParam(Map map) throws Exception {
        return new SpValidaCpeParam(map);
    }

    public SpValidaDocumentoPresentadoParam newSpValidaDocumentoPresentadoParam() {
        return new SpValidaDocumentoPresentadoParam();
    }

    public SpValidaDocumentoPresentadoParam newSpValidaDocumentoPresentadoParam(Map map) throws Exception {
        return new SpValidaDocumentoPresentadoParam(map);
    }

    public SpValidaPermisoParam newSpValidaPermisoParam() {
        return new SpValidaPermisoParam();
    }

    public SpValidaPermisoParam newSpValidaPermisoParam(Map map) throws Exception {
        return new SpValidaPermisoParam(map);
    }

    public SpValidaProductoPadreParam newSpValidaProductoPadreParam() {
        return new SpValidaProductoPadreParam();
    }

    public SpValidaProductoPadreParam newSpValidaProductoPadreParam(Map map) throws Exception {
        return new SpValidaProductoPadreParam(map);
    }

    public SpValidaSolicitanteParam newSpValidaSolicitanteParam() {
        return new SpValidaSolicitanteParam();
    }

    public SpValidaSolicitanteParam newSpValidaSolicitanteParam(Map map) throws Exception {
        return new SpValidaSolicitanteParam(map);
    }

    public class EnvaseListarParam {

        private String productoid;
        private ResultSet curOut;

        public EnvaseListarParam() {
        }

        public EnvaseListarParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getProductoid() {
            return productoid;
        }

        public void setProductoid(String value) {
            this.productoid = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class ListarPartidaArancelariaParam {

        private String pCodigoClase;
        private ResultSet curOut;

        public ListarPartidaArancelariaParam() {
        }

        public ListarPartidaArancelariaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoClase() {
            return pCodigoClase;
        }

        public void setPCodigoClase(String value) {
            this.pCodigoClase = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class ProductoBpmGetlistParam {

        private String codigoserviciotupa;
        private ResultSet curOut;

        public ProductoBpmGetlistParam() {
        }

        public ProductoBpmGetlistParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getCodigoserviciotupa() {
            return codigoserviciotupa;
        }

        public void setCodigoserviciotupa(String value) {
            this.codigoserviciotupa = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpAreasGestionParam {

        private ResultSet reg;

        public SpAreasGestionParam() {
        }

        public SpAreasGestionParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpBuscarPersonaParam {

        private String pFiltro;
        private String pValorFiltro;
        private ResultSet reg;

        public SpBuscarPersonaParam() {
        }

        public SpBuscarPersonaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPFiltro() {
            return pFiltro;
        }

        public void setPFiltro(String value) {
            this.pFiltro = value;
        }

        public String getPValorFiltro() {
            return pValorFiltro;
        }

        public void setPValorFiltro(String value) {
            this.pValorFiltro = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpCalcularXTipoInspeccionParam {

        private Integer cantidadanimales;
        private String codigotarifario;
        private Integer costo;

        public SpCalcularXTipoInspeccionParam() {
        }

        public SpCalcularXTipoInspeccionParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public Integer getCantidadanimales() {
            return cantidadanimales;
        }

        public void setCantidadanimales(Integer value) {
            this.cantidadanimales = value;
        }

        public String getCodigotarifario() {
            return codigotarifario;
        }

        public void setCodigotarifario(String value) {
            this.codigotarifario = value;
        }

        public Integer getCosto() {
            return costo;
        }

        public void setCosto(Integer value) {
            this.costo = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpCalculoMontoConceptoParam {

        private String pcodservicio;
        private String pcantidad;
        private String ptramaproductos;
        private String ptramavacunas;
        private String ptramaanalisis;
        private ResultSet reg;

        public SpCalculoMontoConceptoParam() {
        }

        public SpCalculoMontoConceptoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodservicio() {
            return pcodservicio;
        }

        public void setPcodservicio(String value) {
            this.pcodservicio = value;
        }

        public String getPcantidad() {
            return pcantidad;
        }

        public void setPcantidad(String value) {
            this.pcantidad = value;
        }

        public String getPtramaproductos() {
            return ptramaproductos;
        }

        public void setPtramaproductos(String value) {
            this.ptramaproductos = value;
        }

        public String getPtramavacunas() {
            return ptramavacunas;
        }

        public void setPtramavacunas(String value) {
            this.ptramavacunas = value;
        }

        public String getPtramaanalisis() {
            return ptramaanalisis;
        }

        public void setPtramaanalisis(String value) {
            this.ptramaanalisis = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpCalculoMontoConcepto1Param {

        private String pcodservicio;
        private String pcantidad;
        private String ptramaproductos;
        private String ptramavacunas;
        private String ptramaanalisis;
        private ResultSet reg;

        public SpCalculoMontoConcepto1Param() {
        }

        public SpCalculoMontoConcepto1Param(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodservicio() {
            return pcodservicio;
        }

        public void setPcodservicio(String value) {
            this.pcodservicio = value;
        }

        public String getPcantidad() {
            return pcantidad;
        }

        public void setPcantidad(String value) {
            this.pcantidad = value;
        }

        public String getPtramaproductos() {
            return ptramaproductos;
        }

        public void setPtramaproductos(String value) {
            this.ptramaproductos = value;
        }

        public String getPtramavacunas() {
            return ptramavacunas;
        }

        public void setPtramavacunas(String value) {
            this.ptramavacunas = value;
        }

        public String getPtramaanalisis() {
            return ptramaanalisis;
        }

        public void setPtramaanalisis(String value) {
            this.ptramaanalisis = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpCentroTramiteParam {

        private String pCpe;
        private ResultSet reg;

        public SpCentroTramiteParam() {
        }

        public SpCentroTramiteParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCpe() {
            return pCpe;
        }

        public void setPCpe(String value) {
            this.pCpe = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpCentroTramitePersonaParam {

        private String ppersonaid;
        private ResultSet reg;

        public SpCentroTramitePersonaParam() {
        }

        public SpCentroTramitePersonaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPpersonaid() {
            return ppersonaid;
        }

        public void setPpersonaid(String value) {
            this.ppersonaid = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpCentroTramiteUbigeoParam {

        private String pDepartamento;
        private String pProvincia;
        private String pDistrito;
        private String pCentroTramite;

        public SpCentroTramiteUbigeoParam() {
        }

        public SpCentroTramiteUbigeoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPDepartamento() {
            return pDepartamento;
        }

        public void setPDepartamento(String value) {
            this.pDepartamento = value;
        }

        public String getPProvincia() {
            return pProvincia;
        }

        public void setPProvincia(String value) {
            this.pProvincia = value;
        }

        public String getPDistrito() {
            return pDistrito;
        }

        public void setPDistrito(String value) {
            this.pDistrito = value;
        }

        public String getPCentroTramite() {
            return pCentroTramite;
        }

        public void setPCentroTramite(String value) {
            this.pCentroTramite = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpConvHospedanteCultivoParam {

        private String pCodEspecieBpm;
        private String pCodVariedadBpm;
        private String pCodHospendateSiimf;
        private String pCodCultivoSiimf;

        public SpConvHospedanteCultivoParam() {
        }

        public SpConvHospedanteCultivoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodEspecieBpm() {
            return pCodEspecieBpm;
        }

        public void setPCodEspecieBpm(String value) {
            this.pCodEspecieBpm = value;
        }

        public String getPCodVariedadBpm() {
            return pCodVariedadBpm;
        }

        public void setPCodVariedadBpm(String value) {
            this.pCodVariedadBpm = value;
        }

        public String getPCodHospendateSiimf() {
            return pCodHospendateSiimf;
        }

        public void setPCodHospendateSiimf(String value) {
            this.pCodHospendateSiimf = value;
        }

        public String getPCodCultivoSiimf() {
            return pCodCultivoSiimf;
        }

        public void setPCodCultivoSiimf(String value) {
            this.pCodCultivoSiimf = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpDocumentosIdentidadParam {

        private ResultSet reg;

        public SpDocumentosIdentidadParam() {
        }

        public SpDocumentosIdentidadParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpEnviarAprobacionrevdocParam {

        private String pcodigoexpediente;

        public SpEnviarAprobacionrevdocParam() {
        }

        public SpEnviarAprobacionrevdocParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodigoexpediente() {
            return pcodigoexpediente;
        }

        public void setPcodigoexpediente(String value) {
            this.pcodigoexpediente = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpEnviarNoejecInspeccionParam {

        private String pcodigoexpediente;
        private String pmotivo;

        public SpEnviarNoejecInspeccionParam() {
        }

        public SpEnviarNoejecInspeccionParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodigoexpediente() {
            return pcodigoexpediente;
        }

        public void setPcodigoexpediente(String value) {
            this.pcodigoexpediente = value;
        }

        public String getPmotivo() {
            return pmotivo;
        }

        public void setPmotivo(String value) {
            this.pmotivo = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpFiltrosBuscarPersonaParam {

        private ResultSet reg;

        public SpFiltrosBuscarPersonaParam() {
        }

        public SpFiltrosBuscarPersonaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpGetCodigoDepProvDisParam {

        private String cdep;
        private String cdis;
        private String cpro;
        private String codigo;
        private ResultSet reg;

        public SpGetCodigoDepProvDisParam() {
        }

        public SpGetCodigoDepProvDisParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getCdep() {
            return cdep;
        }

        public void setCdep(String value) {
            this.cdep = value;
        }

        public String getCdis() {
            return cdis;
        }

        public void setCdis(String value) {
            this.cdis = value;
        }

        public String getCpro() {
            return cpro;
        }

        public void setCpro(String value) {
            this.cpro = value;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String value) {
            this.codigo = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpGetOrdenPorMtoParam {

        private String cmto;
        private ResultSet reg;

        public SpGetOrdenPorMtoParam() {
        }

        public SpGetOrdenPorMtoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getCmto() {
            return cmto;
        }

        public void setCmto(String value) {
            this.cmto = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpGetReportePfiParam {

        private String pcodigoexpediente;
        private ResultSet curOut;

        public SpGetReportePfiParam() {
        }

        public SpGetReportePfiParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodigoexpediente() {
            return pcodigoexpediente;
        }

        public void setPcodigoexpediente(String value) {
            this.pcodigoexpediente = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpGetReportePfiProdAnexosParam {

        private String pNumeroPermiso;
        private String pFlag;
        private ResultSet curOut;

        public SpGetReportePfiProdAnexosParam() {
        }

        public SpGetReportePfiProdAnexosParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPNumeroPermiso() {
            return pNumeroPermiso;
        }

        public void setPNumeroPermiso(String value) {
            this.pNumeroPermiso = value;
        }

        public String getPFlag() {
            return pFlag;
        }

        public void setPFlag(String value) {
            this.pFlag = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpGetReportePziParam {

        private String pcodigoexpediente;
        private ResultSet curOut;

        public SpGetReportePziParam() {
        }

        public SpGetReportePziParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodigoexpediente() {
            return pcodigoexpediente;
        }

        public void setPcodigoexpediente(String value) {
            this.pcodigoexpediente = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpGetReportePziCabeseraParam {

        private String pCodigoExpediente;
        private ResultSet curOut;

        public SpGetReportePziCabeseraParam() {
        }

        public SpGetReportePziCabeseraParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoExpediente() {
            return pCodigoExpediente;
        }

        public void setPCodigoExpediente(String value) {
            this.pCodigoExpediente = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpGetReportePziProdAnexosParam {

        private String pNumeroPermiso;
        private String pFlag;
        private ResultSet curOut;

        public SpGetReportePziProdAnexosParam() {
        }

        public SpGetReportePziProdAnexosParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPNumeroPermiso() {
            return pNumeroPermiso;
        }

        public void setPNumeroPermiso(String value) {
            this.pNumeroPermiso = value;
        }

        public String getPFlag() {
            return pFlag;
        }

        public void setPFlag(String value) {
            this.pFlag = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpGrabarServicioAdicionalParam {

        private String pcentrotramite;
        private String ppersonaid;
        private String ppersonaidotro;
        private String puserid;
        private String ppersonaidsolicitante;
        private String pcodexpediente;
        private String pcodrecibo;
        private String pdetallerecibo;
        private String ppagorecibo;
        private String pobservaciontraza;
        private String pproctupa;
        private String pcodorden;

        public SpGrabarServicioAdicionalParam() {
        }

        public SpGrabarServicioAdicionalParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcentrotramite() {
            return pcentrotramite;
        }

        public void setPcentrotramite(String value) {
            this.pcentrotramite = value;
        }

        public String getPpersonaid() {
            return ppersonaid;
        }

        public void setPpersonaid(String value) {
            this.ppersonaid = value;
        }

        public String getPpersonaidotro() {
            return ppersonaidotro;
        }

        public void setPpersonaidotro(String value) {
            this.ppersonaidotro = value;
        }

        public String getPuserid() {
            return puserid;
        }

        public void setPuserid(String value) {
            this.puserid = value;
        }

        public String getPpersonaidsolicitante() {
            return ppersonaidsolicitante;
        }

        public void setPpersonaidsolicitante(String value) {
            this.ppersonaidsolicitante = value;
        }

        public String getPcodexpediente() {
            return pcodexpediente;
        }

        public void setPcodexpediente(String value) {
            this.pcodexpediente = value;
        }

        public String getPcodrecibo() {
            return pcodrecibo;
        }

        public void setPcodrecibo(String value) {
            this.pcodrecibo = value;
        }

        public String getPdetallerecibo() {
            return pdetallerecibo;
        }

        public void setPdetallerecibo(String value) {
            this.pdetallerecibo = value;
        }

        public String getPpagorecibo() {
            return ppagorecibo;
        }

        public void setPpagorecibo(String value) {
            this.ppagorecibo = value;
        }

        public String getPobservaciontraza() {
            return pobservaciontraza;
        }

        public void setPobservaciontraza(String value) {
            this.pobservaciontraza = value;
        }

        public String getPproctupa() {
            return pproctupa;
        }

        public void setPproctupa(String value) {
            this.pproctupa = value;
        }

        public String getPcodorden() {
            return pcodorden;
        }

        public void setPcodorden(String value) {
            this.pcodorden = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpInfoProcedimientoServicioParam {

        private String pCodProc;
        private String pCodServicio;
        private ResultSet reg;

        public SpInfoProcedimientoServicioParam() {
        }

        public SpInfoProcedimientoServicioParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodProc() {
            return pCodProc;
        }

        public void setPCodProc(String value) {
            this.pCodProc = value;
        }

        public String getPCodServicio() {
            return pCodServicio;
        }

        public void setPCodServicio(String value) {
            this.pCodServicio = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpInspectoresParam {

        private ResultSet reg;

        public SpInspectoresParam() {
        }

        public SpInspectoresParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpInspectoresCentroTramiteParam {

        private String pCodigoCentroTramite;
        private Integer pRol;
        private ResultSet reg;

        public SpInspectoresCentroTramiteParam() {
        }

        public SpInspectoresCentroTramiteParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoCentroTramite() {
            return pCodigoCentroTramite;
        }

        public void setPCodigoCentroTramite(String value) {
            this.pCodigoCentroTramite = value;
        }

        public Integer getPRol() {
            return pRol;
        }

        public void setPRol(Integer value) {
            this.pRol = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpInspectoresDepartamentoParam {

        private String pDpto;
        private Integer pRol;
        private ResultSet reg;

        public SpInspectoresDepartamentoParam() {
        }

        public SpInspectoresDepartamentoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPDpto() {
            return pDpto;
        }

        public void setPDpto(String value) {
            this.pDpto = value;
        }

        public Integer getPRol() {
            return pRol;
        }

        public void setPRol(Integer value) {
            this.pRol = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpInspectoresSedeParam {

        private String pCodigoCentroTram;
        private ResultSet reg;

        public SpInspectoresSedeParam() {
        }

        public SpInspectoresSedeParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoCentroTram() {
            return pCodigoCentroTram;
        }

        public void setPCodigoCentroTram(String value) {
            this.pCodigoCentroTram = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpInspectoresporubigeoParam {

        private String pDpto;
        private String pProv;
        private String pDist;
        private ResultSet reg;

        public SpInspectoresporubigeoParam() {
        }

        public SpInspectoresporubigeoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPDpto() {
            return pDpto;
        }

        public void setPDpto(String value) {
            this.pDpto = value;
        }

        public String getPProv() {
            return pProv;
        }

        public void setPProv(String value) {
            this.pProv = value;
        }

        public String getPDist() {
            return pDist;
        }

        public void setPDist(String value) {
            this.pDist = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaAlmacenGcustodiaParam {

        private ResultSet reg;

        public SpListaAlmacenGcustodiaParam() {
        }

        public SpListaAlmacenGcustodiaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaAnalisisParam {

        private String pPaisDestino;
        private String pProducto;
        private String pMensaje;
        private ResultSet regAnalisis;

        public SpListaAnalisisParam() {
        }

        public SpListaAnalisisParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPPaisDestino() {
            return pPaisDestino;
        }

        public void setPPaisDestino(String value) {
            this.pPaisDestino = value;
        }

        public String getPProducto() {
            return pProducto;
        }

        public void setPProducto(String value) {
            this.pProducto = value;
        }

        public String getPMensaje() {
            return pMensaje;
        }

        public void setPMensaje(String value) {
            this.pMensaje = value;
        }

        public ResultSet getRegAnalisis() {
            return regAnalisis;
        }

        public void setRegAnalisis(ResultSet value) {
            this.regAnalisis = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaAplicacionParam {

        private String pCodClase;
        private String pEstado;
        private ResultSet reg;

        public SpListaAplicacionParam() {
        }

        public SpListaAplicacionParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodClase() {
            return pCodClase;
        }

        public void setPCodClase(String value) {
            this.pCodClase = value;
        }

        public String getPEstado() {
            return pEstado;
        }

        public void setPEstado(String value) {
            this.pEstado = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaAplicacionProductoParam {

        private String pCodigoProducto;
        private ResultSet reg;

        public SpListaAplicacionProductoParam() {
        }

        public SpListaAplicacionProductoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoProducto() {
            return pCodigoProducto;
        }

        public void setPCodigoProducto(String value) {
            this.pCodigoProducto = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaAreaLaboratorioParam {

        private String pTipo;
        private ResultSet reg;

        public SpListaAreaLaboratorioParam() {
        }

        public SpListaAreaLaboratorioParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPTipo() {
            return pTipo;
        }

        public void setPTipo(String value) {
            this.pTipo = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaDictamenParam {

        private String pTipo;
        private ResultSet reg;

        public SpListaDictamenParam() {
        }

        public SpListaDictamenParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPTipo() {
            return pTipo;
        }

        public void setPTipo(String value) {
            this.pTipo = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaLugarInspeccionParam {

        private String pSede;
        private ResultSet reg;

        public SpListaLugarInspeccionParam() {
        }

        public SpListaLugarInspeccionParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPSede() {
            return pSede;
        }

        public void setPSede(String value) {
            this.pSede = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaLugarProduccionParam {

        private String pCodPais;
        private ResultSet reg;

        public SpListaLugarProduccionParam() {
        }

        public SpListaLugarProduccionParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodPais() {
            return pCodPais;
        }

        public void setPCodPais(String value) {
            this.pCodPais = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaMotivoParam {

        private ResultSet reg;

        public SpListaMotivoParam() {
        }

        public SpListaMotivoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaMotivoTratamientoParam {

        private ResultSet reg;

        public SpListaMotivoTratamientoParam() {
        }

        public SpListaMotivoTratamientoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaPaisParam {

        private ResultSet reg;

        public SpListaPaisParam() {
        }

        public SpListaPaisParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaPlagaTratamientoParam {

        private String pDesc;
        private String pClase;
        private ResultSet reg;

        public SpListaPlagaTratamientoParam() {
        }

        public SpListaPlagaTratamientoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPDesc() {
            return pDesc;
        }

        public void setPDesc(String value) {
            this.pDesc = value;
        }

        public String getPClase() {
            return pClase;
        }

        public void setPClase(String value) {
            this.pClase = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaProcOrigenMuestraParam {

        private ResultSet reg;

        public SpListaProcOrigenMuestraParam() {
        }

        public SpListaProcOrigenMuestraParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaProduccionPfiParam {

        private String pNumeroPermiso;
        private String pMensaje;
        private ResultSet reg;

        public SpListaProduccionPfiParam() {
        }

        public SpListaProduccionPfiParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPNumeroPermiso() {
            return pNumeroPermiso;
        }

        public void setPNumeroPermiso(String value) {
            this.pNumeroPermiso = value;
        }

        public String getPMensaje() {
            return pMensaje;
        }

        public void setPMensaje(String value) {
            this.pMensaje = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaRazaParam {

        private String pEspecie;
        private ResultSet reg;

        public SpListaRazaParam() {
        }

        public SpListaRazaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPEspecie() {
            return pEspecie;
        }

        public void setPEspecie(String value) {
            this.pEspecie = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaServAnalisisAnimalParam {

        private String pDesc;
        private ResultSet reg;

        public SpListaServAnalisisAnimalParam() {
        }

        public SpListaServAnalisisAnimalParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPDesc() {
            return pDesc;
        }

        public void setPDesc(String value) {
            this.pDesc = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaServAnalisisVegetalParam {

        private String pArea;
        private ResultSet reg;

        public SpListaServAnalisisVegetalParam() {
        }

        public SpListaServAnalisisVegetalParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPArea() {
            return pArea;
        }

        public void setPArea(String value) {
            this.pArea = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaSexoParam {

        private ResultSet reg;

        public SpListaSexoParam() {
        }

        public SpListaSexoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaTipoCrianzaParam {

        private ResultSet reg;

        public SpListaTipoCrianzaParam() {
        }

        public SpListaTipoCrianzaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaTipoEnvaseParam {

        private String pClase;
        private String pTipo;
        private ResultSet reg;

        public SpListaTipoEnvaseParam() {
        }

        public SpListaTipoEnvaseParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPClase() {
            return pClase;
        }

        public void setPClase(String value) {
            this.pClase = value;
        }

        public String getPTipo() {
            return pTipo;
        }

        public void setPTipo(String value) {
            this.pTipo = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaTipoEspecieAnimalParam {

        private ResultSet reg;

        public SpListaTipoEspecieAnimalParam() {
        }

        public SpListaTipoEspecieAnimalParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaTipoIdentificacionParam {

        private ResultSet reg;

        public SpListaTipoIdentificacionParam() {
        }

        public SpListaTipoIdentificacionParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaTipoMuestraAnimalParam {

        private String pPruebas;
        private ResultSet reg;

        public SpListaTipoMuestraAnimalParam() {
        }

        public SpListaTipoMuestraAnimalParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPPruebas() {
            return pPruebas;
        }

        public void setPPruebas(String value) {
            this.pPruebas = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaTipoMuestraVegetalParam {

        private ResultSet reg;

        public SpListaTipoMuestraVegetalParam() {
        }

        public SpListaTipoMuestraVegetalParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaTipoRecintoParam {

        private ResultSet reg;

        public SpListaTipoRecintoParam() {
        }

        public SpListaTipoRecintoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaUnidMedProductoParam {

        private String pCodigoProducto;
        private ResultSet reg;

        public SpListaUnidMedProductoParam() {
        }

        public SpListaUnidMedProductoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoProducto() {
            return pCodigoProducto;
        }

        public void setPCodigoProducto(String value) {
            this.pCodigoProducto = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListaUnidadMedidaParam {

        private ResultSet reg;

        public SpListaUnidadMedidaParam() {
        }

        public SpListaUnidadMedidaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListarFabricantesParam {

        private String pTipoDato;
        private String pNombre;
        private String pMensaje;
        private ResultSet reg;

        public SpListarFabricantesParam() {
        }

        public SpListarFabricantesParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPTipoDato() {
            return pTipoDato;
        }

        public void setPTipoDato(String value) {
            this.pTipoDato = value;
        }

        public String getPNombre() {
            return pNombre;
        }

        public void setPNombre(String value) {
            this.pNombre = value;
        }

        public String getPMensaje() {
            return pMensaje;
        }

        public void setPMensaje(String value) {
            this.pMensaje = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListarPartidaArancelariaParam {

        private String pCodigoClase;
        private ResultSet curOut;

        public SpListarPartidaArancelariaParam() {
        }

        public SpListarPartidaArancelariaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoClase() {
            return pCodigoClase;
        }

        public void setPCodigoClase(String value) {
            this.pCodigoClase = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListarTipoEnvaseParam {

        private String pCodigoClase;
        private ResultSet curOut;

        public SpListarTipoEnvaseParam() {
        }

        public SpListarTipoEnvaseParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoClase() {
            return pCodigoClase;
        }

        public void setPCodigoClase(String value) {
            this.pCodigoClase = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpListarUnidadMedidaParam {

        private String pCodigoClase;
        private ResultSet curOut;

        public SpListarUnidadMedidaParam() {
        }

        public SpListarUnidadMedidaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoClase() {
            return pCodigoClase;
        }

        public void setPCodigoClase(String value) {
            this.pCodigoClase = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpMedioTransporteParam {

        private String pSede;
        private String pMedio;

        public SpMedioTransporteParam() {
        }

        public SpMedioTransporteParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPSede() {
            return pSede;
        }

        public void setPSede(String value) {
            this.pSede = value;
        }

        public String getPMedio() {
            return pMedio;
        }

        public void setPMedio(String value) {
            this.pMedio = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerAdjuntosParam {

        private String pcodexpediente;
        private ResultSet reg;

        public SpObtenerAdjuntosParam() {
        }

        public SpObtenerAdjuntosParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodexpediente() {
            return pcodexpediente;
        }

        public void setPcodexpediente(String value) {
            this.pcodexpediente = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerAdjuntosVuceParam {

        private String pNumeroOrden;
        private ResultSet regdoc;

        public SpObtenerAdjuntosVuceParam() {
        }

        public SpObtenerAdjuntosVuceParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPNumeroOrden() {
            return pNumeroOrden;
        }

        public void setPNumeroOrden(String value) {
            this.pNumeroOrden = value;
        }

        public ResultSet getRegdoc() {
            return regdoc;
        }

        public void setRegdoc(ResultSet value) {
            this.regdoc = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerAnalisisCatalServParam {

        private String familiaid;
        private ResultSet reg;

        public SpObtenerAnalisisCatalServParam() {
        }

        public SpObtenerAnalisisCatalServParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getFamiliaid() {
            return familiaid;
        }

        public void setFamiliaid(String value) {
            this.familiaid = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerCertParam {

        private String pNumeDoc;
        private ResultSet reg;

        public SpObtenerCertParam() {
        }

        public SpObtenerCertParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPNumeDoc() {
            return pNumeDoc;
        }

        public void setPNumeDoc(String value) {
            this.pNumeDoc = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerClasesCatalServParam {

        private ResultSet reg;

        public SpObtenerClasesCatalServParam() {
        }

        public SpObtenerClasesCatalServParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerCodiivExpedienteParam {

        private String pcodexpediente;
        private String codiiv;
        private String nrocertificado;

        public SpObtenerCodiivExpedienteParam() {
        }

        public SpObtenerCodiivExpedienteParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodexpediente() {
            return pcodexpediente;
        }

        public void setPcodexpediente(String value) {
            this.pcodexpediente = value;
        }

        public String getCodiiv() {
            return codiiv;
        }

        public void setCodiiv(String value) {
            this.codiiv = value;
        }

        public String getNrocertificado() {
            return nrocertificado;
        }

        public void setNrocertificado(String value) {
            this.nrocertificado = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerDescDocumentoParam {

        private String pcodigodocumento;
        private ResultSet reg;

        public SpObtenerDescDocumentoParam() {
        }

        public SpObtenerDescDocumentoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodigodocumento() {
            return pcodigodocumento;
        }

        public void setPcodigodocumento(String value) {
            this.pcodigodocumento = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerDireccionImpoParam {

        private String pCodigoImportador;
        private String pDireccion;

        public SpObtenerDireccionImpoParam() {
        }

        public SpObtenerDireccionImpoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoImportador() {
            return pCodigoImportador;
        }

        public void setPCodigoImportador(String value) {
            this.pCodigoImportador = value;
        }

        public String getPDireccion() {
            return pDireccion;
        }

        public void setPDireccion(String value) {
            this.pDireccion = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerEmpresaTratamientoParam {

        private String pRuc;
        private ResultSet reg;

        public SpObtenerEmpresaTratamientoParam() {
        }

        public SpObtenerEmpresaTratamientoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPRuc() {
            return pRuc;
        }

        public void setPRuc(String value) {
            this.pRuc = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerEntidNombreRucParam {

        private String pNombre;
        private String pRuc;
        private ResultSet reg;

        public SpObtenerEntidNombreRucParam() {
        }

        public SpObtenerEntidNombreRucParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPNombre() {
            return pNombre;
        }

        public void setPNombre(String value) {
            this.pNombre = value;
        }

        public String getPRuc() {
            return pRuc;
        }

        public void setPRuc(String value) {
            this.pRuc = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerExpedientePermisoParam {

        private String pNumeroPermiso;
        private String pFlagPermiso;
        private String pCodExpediente;
        private String pFlgExiste;
        private String pPersonaId;
        private String pFlgTipo;

        public SpObtenerExpedientePermisoParam() {
        }

        public SpObtenerExpedientePermisoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPNumeroPermiso() {
            return pNumeroPermiso;
        }

        public void setPNumeroPermiso(String value) {
            this.pNumeroPermiso = value;
        }

        public String getPFlagPermiso() {
            return pFlagPermiso;
        }

        public void setPFlagPermiso(String value) {
            this.pFlagPermiso = value;
        }

        public String getPCodExpediente() {
            return pCodExpediente;
        }

        public void setPCodExpediente(String value) {
            this.pCodExpediente = value;
        }

        public String getPFlgExiste() {
            return pFlgExiste;
        }

        public void setPFlgExiste(String value) {
            this.pFlgExiste = value;
        }

        public String getPPersonaId() {
            return pPersonaId;
        }

        public void setPPersonaId(String value) {
            this.pPersonaId = value;
        }

        public String getPFlgTipo() {
            return pFlgTipo;
        }

        public void setPFlgTipo(String value) {
            this.pFlgTipo = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerFamiliasCatalServParam {

        private String claseid;
        private ResultSet reg;

        public SpObtenerFamiliasCatalServParam() {
        }

        public SpObtenerFamiliasCatalServParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getClaseid() {
            return claseid;
        }

        public void setClaseid(String value) {
            this.claseid = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerImportadoresParam {

        private String pNombre;
        private String pCodigoPais;
        private ResultSet reg;

        public SpObtenerImportadoresParam() {
        }

        public SpObtenerImportadoresParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPNombre() {
            return pNombre;
        }

        public void setPNombre(String value) {
            this.pNombre = value;
        }

        public String getPCodigoPais() {
            return pCodigoPais;
        }

        public void setPCodigoPais(String value) {
            this.pCodigoPais = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerImportadoresVuceParam {

        private String pNombre;
        private ResultSet reg;

        public SpObtenerImportadoresVuceParam() {
        }

        public SpObtenerImportadoresVuceParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPNombre() {
            return pNombre;
        }

        public void setPNombre(String value) {
            this.pNombre = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerListaAnalisisParam {

        private ResultSet reg;

        public SpObtenerListaAnalisisParam() {
        }

        public SpObtenerListaAnalisisParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerListaAreaParam {

        private ResultSet reg;

        public SpObtenerListaAreaParam() {
        }

        public SpObtenerListaAreaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerListaFuncionarioParam {

        private String pArea;
        private String pSubArea;
        private ResultSet reg;

        public SpObtenerListaFuncionarioParam() {
        }

        public SpObtenerListaFuncionarioParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPArea() {
            return pArea;
        }

        public void setPArea(String value) {
            this.pArea = value;
        }

        public String getPSubArea() {
            return pSubArea;
        }

        public void setPSubArea(String value) {
            this.pSubArea = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerListaPrediosParam {

        private String pPersonaid;
        private ResultSet reg;

        public SpObtenerListaPrediosParam() {
        }

        public SpObtenerListaPrediosParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPPersonaid() {
            return pPersonaid;
        }

        public void setPPersonaid(String value) {
            this.pPersonaid = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerListaSubAreaParam {

        private String pArea;
        private ResultSet reg;

        public SpObtenerListaSubAreaParam() {
        }

        public SpObtenerListaSubAreaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPArea() {
            return pArea;
        }

        public void setPArea(String value) {
            this.pArea = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerListaSubTipoDocParam {

        private String pTipo;
        private ResultSet reg;

        public SpObtenerListaSubTipoDocParam() {
        }

        public SpObtenerListaSubTipoDocParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPTipo() {
            return pTipo;
        }

        public void setPTipo(String value) {
            this.pTipo = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerListaTipoDocParam {

        private String pEscenario;
        private ResultSet reg;

        public SpObtenerListaTipoDocParam() {
        }

        public SpObtenerListaTipoDocParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPEscenario() {
            return pEscenario;
        }

        public void setPEscenario(String value) {
            this.pEscenario = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerListaVacunasParam {

        private ResultSet reg;

        public SpObtenerListaVacunasParam() {
        }

        public SpObtenerListaVacunasParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerOperadorParam {

        private String pDocumentoTipo;
        private String pDocumentoNumero;
        private ResultSet reg;

        public SpObtenerOperadorParam() {
        }

        public SpObtenerOperadorParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPDocumentoTipo() {
            return pDocumentoTipo;
        }

        public void setPDocumentoTipo(String value) {
            this.pDocumentoTipo = value;
        }

        public String getPDocumentoNumero() {
            return pDocumentoNumero;
        }

        public void setPDocumentoNumero(String value) {
            this.pDocumentoNumero = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerPersonaParam {

        private String pPersonaId;
        private ResultSet reg;

        public SpObtenerPersonaParam() {
        }

        public SpObtenerPersonaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPPersonaId() {
            return pPersonaId;
        }

        public void setPPersonaId(String value) {
            this.pPersonaId = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerPersonaDocParam {

        private String ptidodoc;
        private String pnumdoc;
        private String pnombre;
        private String pFormato;
        private ResultSet reg;

        public SpObtenerPersonaDocParam() {
        }

        public SpObtenerPersonaDocParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPtidodoc() {
            return ptidodoc;
        }

        public void setPtidodoc(String value) {
            this.ptidodoc = value;
        }

        public String getPnumdoc() {
            return pnumdoc;
        }

        public void setPnumdoc(String value) {
            this.pnumdoc = value;
        }

        public String getPnombre() {
            return pnombre;
        }

        public void setPnombre(String value) {
            this.pnombre = value;
        }

        public String getPFormato() {
            return pFormato;
        }

        public void setPFormato(String value) {
            this.pFormato = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerPersonaDocAduanaParam {

        private String ptidodoc;
        private String pnumdoc;
        private ResultSet reg;

        public SpObtenerPersonaDocAduanaParam() {
        }

        public SpObtenerPersonaDocAduanaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPtidodoc() {
            return ptidodoc;
        }

        public void setPtidodoc(String value) {
            this.ptidodoc = value;
        }

        public String getPnumdoc() {
            return pnumdoc;
        }

        public void setPnumdoc(String value) {
            this.pnumdoc = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerPersonaDocIiParam {

        private String ptidodoc;
        private String pnumdoc;
        private String pnombre;
        private String pFormato;
        private ResultSet reg;

        public SpObtenerPersonaDocIiParam() {
        }

        public SpObtenerPersonaDocIiParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPtidodoc() {
            return ptidodoc;
        }

        public void setPtidodoc(String value) {
            this.ptidodoc = value;
        }

        public String getPnumdoc() {
            return pnumdoc;
        }

        public void setPnumdoc(String value) {
            this.pnumdoc = value;
        }

        public String getPnombre() {
            return pnombre;
        }

        public void setPnombre(String value) {
            this.pnombre = value;
        }

        public String getPFormato() {
            return pFormato;
        }

        public void setPFormato(String value) {
            this.pFormato = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerPersonaDocumentoParam {

        private String ptidodoc;
        private String pnumdoc;
        private String pnombre;
        private ResultSet reg;

        public SpObtenerPersonaDocumentoParam() {
        }

        public SpObtenerPersonaDocumentoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPtidodoc() {
            return ptidodoc;
        }

        public void setPtidodoc(String value) {
            this.ptidodoc = value;
        }

        public String getPnumdoc() {
            return pnumdoc;
        }

        public void setPnumdoc(String value) {
            this.pnumdoc = value;
        }

        public String getPnombre() {
            return pnombre;
        }

        public void setPnombre(String value) {
            this.pnombre = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerPersonaDocumentoWParam {

        private String ptipodoc;
        private String pnumdoc;
        private ResultSet reg;

        public SpObtenerPersonaDocumentoWParam() {
        }

        public SpObtenerPersonaDocumentoWParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPtipodoc() {
            return ptipodoc;
        }

        public void setPtipodoc(String value) {
            this.ptipodoc = value;
        }

        public String getPnumdoc() {
            return pnumdoc;
        }

        public void setPnumdoc(String value) {
            this.pnumdoc = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerPersonaDocvuceParam {

        private String ptidodoc;
        private String pnumdoc;
        private String pnombre;
        private ResultSet reg;

        public SpObtenerPersonaDocvuceParam() {
        }

        public SpObtenerPersonaDocvuceParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPtidodoc() {
            return ptidodoc;
        }

        public void setPtidodoc(String value) {
            this.ptidodoc = value;
        }

        public String getPnumdoc() {
            return pnumdoc;
        }

        public void setPnumdoc(String value) {
            this.pnumdoc = value;
        }

        public String getPnombre() {
            return pnombre;
        }

        public void setPnombre(String value) {
            this.pnombre = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerPersonaPParam {

        private String ptidodoc;
        private String pnumdoc;
        private String pnombre;
        private String pFormato;
        private ResultSet reg;

        public SpObtenerPersonaPParam() {
        }

        public SpObtenerPersonaPParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPtidodoc() {
            return ptidodoc;
        }

        public void setPtidodoc(String value) {
            this.ptidodoc = value;
        }

        public String getPnumdoc() {
            return pnumdoc;
        }

        public void setPnumdoc(String value) {
            this.pnumdoc = value;
        }

        public String getPnombre() {
            return pnombre;
        }

        public void setPnombre(String value) {
            this.pnombre = value;
        }

        public String getPFormato() {
            return pFormato;
        }

        public void setPFormato(String value) {
            this.pFormato = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerPersonaSucDocParam {

        private String pcodpersona;
        private ResultSet reg;

        public SpObtenerPersonaSucDocParam() {
        }

        public SpObtenerPersonaSucDocParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodpersona() {
            return pcodpersona;
        }

        public void setPcodpersona(String value) {
            this.pcodpersona = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerProdExpedienteParam {

        private ResultSet curOut;
        private String codigoservicio;
        private String pcodexpediente;

        public SpObtenerProdExpedienteParam() {
        }

        public SpObtenerProdExpedienteParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public String getCodigoservicio() {
            return codigoservicio;
        }

        public void setCodigoservicio(String value) {
            this.codigoservicio = value;
        }

        public String getPcodexpediente() {
            return pcodexpediente;
        }

        public void setPcodexpediente(String value) {
            this.pcodexpediente = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerRepresentanteLegalParam {

        private String pPersonaId;
        private ResultSet reg;

        public SpObtenerRepresentanteLegalParam() {
        }

        public SpObtenerRepresentanteLegalParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPPersonaId() {
            return pPersonaId;
        }

        public void setPPersonaId(String value) {
            this.pPersonaId = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerSaldoParam {

        private String personaid;
        private BigDecimal monto;

        public SpObtenerSaldoParam() {
        }

        public SpObtenerSaldoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPersonaid() {
            return personaid;
        }

        public void setPersonaid(String value) {
            this.personaid = value;
        }

        public BigDecimal getMonto() {
            return monto;
        }

        public void setMonto(BigDecimal value) {
            this.monto = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerSolicitanteParam {

        private String pPersonaId;
        private ResultSet reg;

        public SpObtenerSolicitanteParam() {
        }

        public SpObtenerSolicitanteParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPPersonaId() {
            return pPersonaId;
        }

        public void setPPersonaId(String value) {
            this.pPersonaId = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerSubproductosParam {

        private String pCodigoproducto;
        private String pNombreproducto;
        private String pNombreCientifico;
        private String pPartidaArancel;
        private ResultSet reg;

        public SpObtenerSubproductosParam() {
        }

        public SpObtenerSubproductosParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoproducto() {
            return pCodigoproducto;
        }

        public void setPCodigoproducto(String value) {
            this.pCodigoproducto = value;
        }

        public String getPNombreproducto() {
            return pNombreproducto;
        }

        public void setPNombreproducto(String value) {
            this.pNombreproducto = value;
        }

        public String getPNombreCientifico() {
            return pNombreCientifico;
        }

        public void setPNombreCientifico(String value) {
            this.pNombreCientifico = value;
        }

        public String getPPartidaArancel() {
            return pPartidaArancel;
        }

        public void setPPartidaArancel(String value) {
            this.pPartidaArancel = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerSubtipoDocumentalParam {

        private String pexpediente;
        private ResultSet reg;

        public SpObtenerSubtipoDocumentalParam() {
        }

        public SpObtenerSubtipoDocumentalParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPexpediente() {
            return pexpediente;
        }

        public void setPexpediente(String value) {
            this.pexpediente = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerTipoCertificadoParam {

        private String pCodigoExpediente;
        private String pTipoCertificado;

        public SpObtenerTipoCertificadoParam() {
        }

        public SpObtenerTipoCertificadoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoExpediente() {
            return pCodigoExpediente;
        }

        public void setPCodigoExpediente(String value) {
            this.pCodigoExpediente = value;
        }

        public String getPTipoCertificado() {
            return pTipoCertificado;
        }

        public void setPTipoCertificado(String value) {
            this.pTipoCertificado = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerTipoInspeccionParam {

        private ResultSet reg;

        public SpObtenerTipoInspeccionParam() {
        }

        public SpObtenerTipoInspeccionParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerUbigeoParam {

        private ResultSet pReg;

        public SpObtenerUbigeoParam() {
        }

        public SpObtenerUbigeoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getPReg() {
            return pReg;
        }

        public void setPReg(ResultSet value) {
            this.pReg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerUbigeoDetalleParam {

        private String pNivel;
        private String pDepartamento;
        private String pProvincia;
        private ResultSet reg;

        public SpObtenerUbigeoDetalleParam() {
        }

        public SpObtenerUbigeoDetalleParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPNivel() {
            return pNivel;
        }

        public void setPNivel(String value) {
            this.pNivel = value;
        }

        public String getPDepartamento() {
            return pDepartamento;
        }

        public void setPDepartamento(String value) {
            this.pDepartamento = value;
        }

        public String getPProvincia() {
            return pProvincia;
        }

        public void setPProvincia(String value) {
            this.pProvincia = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerUcmIivParam {

        private String pcodexp;
        private String pucm;

        public SpObtenerUcmIivParam() {
        }

        public SpObtenerUcmIivParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodexp() {
            return pcodexp;
        }

        public void setPcodexp(String value) {
            this.pcodexp = value;
        }

        public String getPucm() {
            return pucm;
        }

        public void setPucm(String value) {
            this.pucm = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerUcmIivImpoParam {

        private String pcodexpediente;
        private String ucmid;

        public SpObtenerUcmIivImpoParam() {
        }

        public SpObtenerUcmIivImpoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodexpediente() {
            return pcodexpediente;
        }

        public void setPcodexpediente(String value) {
            this.pcodexpediente = value;
        }

        public String getUcmid() {
            return ucmid;
        }

        public void setUcmid(String value) {
            this.ucmid = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerUcmReciboParam {

        private String pcodexpediente;
        private ResultSet curOut;

        public SpObtenerUcmReciboParam() {
        }

        public SpObtenerUcmReciboParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodexpediente() {
            return pcodexpediente;
        }

        public void setPcodexpediente(String value) {
            this.pcodexpediente = value;
        }

        public ResultSet getCurOut() {
            return curOut;
        }

        public void setCurOut(ResultSet value) {
            this.curOut = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerUcmidSolicitudParam {

        private String pcodexpediente;
        private String ucmid;

        public SpObtenerUcmidSolicitudParam() {
        }

        public SpObtenerUcmidSolicitudParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodexpediente() {
            return pcodexpediente;
        }

        public void setPcodexpediente(String value) {
            this.pcodexpediente = value;
        }

        public String getUcmid() {
            return ucmid;
        }

        public void setUcmid(String value) {
            this.ucmid = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerUcmidsExpedienteParam {

        private String pcodexpediente;
        private String cadenaarchivo;

        public SpObtenerUcmidsExpedienteParam() {
        }

        public SpObtenerUcmidsExpedienteParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodexpediente() {
            return pcodexpediente;
        }

        public void setPcodexpediente(String value) {
            this.pcodexpediente = value;
        }

        public String getCadenaarchivo() {
            return cadenaarchivo;
        }

        public void setCadenaarchivo(String value) {
            this.cadenaarchivo = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerVigenciaPermisoParam {

        private String pCodigoExpediente;
        private String pCodser;
        private String pFlgTipo;
        private String pFlgVigencia;

        public SpObtenerVigenciaPermisoParam() {
        }

        public SpObtenerVigenciaPermisoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoExpediente() {
            return pCodigoExpediente;
        }

        public void setPCodigoExpediente(String value) {
            this.pCodigoExpediente = value;
        }

        public String getPCodser() {
            return pCodser;
        }

        public void setPCodser(String value) {
            this.pCodser = value;
        }

        public String getPFlgTipo() {
            return pFlgTipo;
        }

        public void setPFlgTipo(String value) {
            this.pFlgTipo = value;
        }

        public String getPFlgVigencia() {
            return pFlgVigencia;
        }

        public void setPFlgVigencia(String value) {
            this.pFlgVigencia = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpObtenerdoctypeucmParam {

        private String pTipo;
        private ResultSet reg;

        public SpObtenerdoctypeucmParam() {
        }

        public SpObtenerdoctypeucmParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPTipo() {
            return pTipo;
        }

        public void setPTipo(String value) {
            this.pTipo = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpOperadorLogisticoJuridicoParam {

        private ResultSet reg;

        public SpOperadorLogisticoJuridicoParam() {
        }

        public SpOperadorLogisticoJuridicoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpOperadorLogisticoNaturalParam {

        private ResultSet reg;

        public SpOperadorLogisticoNaturalParam() {
        }

        public SpOperadorLogisticoNaturalParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpProcedimientoPorAreaParam {

        private String pareagestion;
        private String indicadorprocedimientognrl;
        private ResultSet reg;

        public SpProcedimientoPorAreaParam() {
        }

        public SpProcedimientoPorAreaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPareagestion() {
            return pareagestion;
        }

        public void setPareagestion(String value) {
            this.pareagestion = value;
        }

        public String getIndicadorprocedimientognrl() {
            return indicadorprocedimientognrl;
        }

        public void setIndicadorprocedimientognrl(String value) {
            this.indicadorprocedimientognrl = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpServicioProcedmientoAreaParam {

        private String pproctupa;
        private ResultSet reg;
        private String pCodServicio;

        public SpServicioProcedmientoAreaParam() {
        }

        public SpServicioProcedmientoAreaParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPproctupa() {
            return pproctupa;
        }

        public void setPproctupa(String value) {
            this.pproctupa = value;
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public String getPCodServicio() {
            return pCodServicio;
        }

        public void setPCodServicio(String value) {
            this.pCodServicio = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpTipoDocumentoParam {

        private ResultSet reg;

        public SpTipoDocumentoParam() {
        }

        public SpTipoDocumentoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public ResultSet getReg() {
            return reg;
        }

        public void setReg(ResultSet value) {
            this.reg = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpValidaCodigoParam {

        private String pRegistro;
        private String pCodigo;

        public SpValidaCodigoParam() {
        }

        public SpValidaCodigoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPRegistro() {
            return pRegistro;
        }

        public void setPRegistro(String value) {
            this.pRegistro = value;
        }

        public String getPCodigo() {
            return pCodigo;
        }

        public void setPCodigo(String value) {
            this.pCodigo = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpValidaCpeParam {

        private String pCodigoExpediente;
        private String pCpe;

        public SpValidaCpeParam() {
        }

        public SpValidaCpeParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoExpediente() {
            return pCodigoExpediente;
        }

        public void setPCodigoExpediente(String value) {
            this.pCodigoExpediente = value;
        }

        public String getPCpe() {
            return pCpe;
        }

        public void setPCpe(String value) {
            this.pCpe = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpValidaDocumentoPresentadoParam {

        private String pcodexpediente;
        private Integer total;
        private String titulo;

        public SpValidaDocumentoPresentadoParam() {
        }

        public SpValidaDocumentoPresentadoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPcodexpediente() {
            return pcodexpediente;
        }

        public void setPcodexpediente(String value) {
            this.pcodexpediente = value;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer value) {
            this.total = value;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String value) {
            this.titulo = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpValidaPermisoParam {

        private String pCodExpediente;
        private String pFlagPermiso;
        private String pFlgExiste;
        private ResultSet regpermiso;

        public SpValidaPermisoParam() {
        }

        public SpValidaPermisoParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodExpediente() {
            return pCodExpediente;
        }

        public void setPCodExpediente(String value) {
            this.pCodExpediente = value;
        }

        public String getPFlagPermiso() {
            return pFlagPermiso;
        }

        public void setPFlagPermiso(String value) {
            this.pFlagPermiso = value;
        }

        public String getPFlgExiste() {
            return pFlgExiste;
        }

        public void setPFlgExiste(String value) {
            this.pFlgExiste = value;
        }

        public ResultSet getRegpermiso() {
            return regpermiso;
        }

        public void setRegpermiso(ResultSet value) {
            this.regpermiso = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpValidaProductoPadreParam {

        private String pCodigoProducto;
        private String pMensaje;

        public SpValidaProductoPadreParam() {
        }

        public SpValidaProductoPadreParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPCodigoProducto() {
            return pCodigoProducto;
        }

        public void setPCodigoProducto(String value) {
            this.pCodigoProducto = value;
        }

        public String getPMensaje() {
            return pMensaje;
        }

        public void setPMensaje(String value) {
            this.pMensaje = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

    public class SpValidaSolicitanteParam {

        private String pPersonaId;
        private String pFlgFormato;
        private String pFlgPertenece;

        public SpValidaSolicitanteParam() {
        }

        public SpValidaSolicitanteParam(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

        public String getPPersonaId() {
            return pPersonaId;
        }

        public void setPPersonaId(String value) {
            this.pPersonaId = value;
        }

        public String getPFlgFormato() {
            return pFlgFormato;
        }

        public void setPFlgFormato(String value) {
            this.pFlgFormato = value;
        }

        public String getPFlgPertenece() {
            return pFlgPertenece;
        }

        public void setPFlgPertenece(String value) {
            this.pFlgPertenece = value;
        }

        public void setValuesFromMap(Map map) throws Exception {
            ResourceManager.populateDtoFromMap(this, map);
        }

    }

}
