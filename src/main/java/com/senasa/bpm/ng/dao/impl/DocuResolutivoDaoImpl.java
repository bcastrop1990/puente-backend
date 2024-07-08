
package com.senasa.bpm.ng.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.senasa.bpm.ng.dao.DocuResolutivoDao;
import com.senasa.bpm.ng.dao.rowmapper.AgregarDocuRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.DetalleDerivacionRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.DocuResolutivoRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.FirmarCerrarExpRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.InformacionExpedienteRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.ObtenerDocuRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.ObtenerInfoAdjuntosRowMapper;
import com.senasa.bpm.ng.dao.rowmapper.ReqDocSalidaRowMapper;
import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.ArchivarBean;
import com.senasa.bpm.ng.model.bean.DerivacionPersonalBean;
import com.senasa.bpm.ng.model.bean.DetalleDerivacionBean;
import com.senasa.bpm.ng.model.bean.FirmarCerrarExpedienteBean;
import com.senasa.bpm.ng.model.bean.GrabarDocHijoBean;
import com.senasa.bpm.ng.model.bean.GrabarDocumentoSTDBean;
import com.senasa.bpm.ng.model.bean.GrabarInactivoBean;
import com.senasa.bpm.ng.model.bean.GrabarResolutivoBean;
import com.senasa.bpm.ng.model.bean.GrabarResolutivoCierreBean;
import com.senasa.bpm.ng.model.bean.InformacionExpedienteBean;
import com.senasa.bpm.ng.model.bean.ObtenerDocuBean;
import com.senasa.bpm.ng.model.bean.ObtenerInfoAdjuntosBean;
import com.senasa.bpm.ng.model.bean.ReqDocSalidaBean;
import com.senasa.bpm.ng.model.bean.ValidarExpedienteBean;
import com.senasa.bpm.ng.model.bean.ValidarPendientePagoBean;
import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.GrabarDocHijoRequest;
import com.senasa.bpm.ng.model.request.GrabarDocumentoSTDRequest;
import com.senasa.bpm.ng.model.request.GrabarObservacionRequest;
import com.senasa.bpm.ng.model.request.GrabarResolutivoCierreRequest;
import com.senasa.bpm.ng.model.request.GrabarResolutivoRequest;
import com.senasa.bpm.ng.model.request.RegistrarFirmaEmpleadoRequest;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Log
@Transactional
public class DocuResolutivoDaoImpl implements DocuResolutivoDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public DocuResolutivoDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<DerivacionPersonalBean> listarPersona(String personalSenasa) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PCKG_PERSONAL_SENASA")
				.withProcedureName("SP_OBTENER_PERSONA_PARAM").withoutProcedureColumnMetaDataAccess()
				.declareParameters(
						new SqlParameter("pparametro", OracleTypes.VARCHAR),
						new SqlOutParameter("Reg", OracleTypes.CURSOR, new DocuResolutivoRowMapper()));
		SqlParameterSource prm = new MapSqlParameterSource().addValue("pparametro", personalSenasa);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<DerivacionPersonalBean> beanList = (List) result.get("Reg");
		return beanList;
	}

	public List<DetalleDerivacionBean> listarDetalleDerivacion(String pcodexpediente) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PCKG_GRABAR")
				.withProcedureName("SP_BUSCAR_OBSERVACIONES").withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("pcodexpediente", Types.VARCHAR),
						new SqlOutParameter("Reg", Types.REF_CURSOR, new DetalleDerivacionRowMapper()));
		SqlParameterSource prm = new MapSqlParameterSource().addValue("pcodexpediente", pcodexpediente);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<DetalleDerivacionBean> beanList = (List) result.get("Reg");
		return beanList;
	}

	@Override
	public List<AgregarDocuBean> listarDocumento(String documentoResolutivo) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PCKG_GENERAL")
				.withProcedureName("SP_OBTENER_DESC_DOCUMENTO").withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("Pcodigodocumento", Types.VARCHAR),
						new SqlOutParameter("Reg", Types.REF_CURSOR, new AgregarDocuRowMapper()));
		SqlParameterSource prm = new MapSqlParameterSource().addValue("Pcodigodocumento", documentoResolutivo);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<AgregarDocuBean> beanList = (List) result.get("Reg");
		return beanList;
	}

	@Override
	public List<InformacionExpedienteBean> obtenerCodigoExpediente(String p_Codigo_Expediente) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PCKG_EXPEDIENTE")
				.withProcedureName("SP_OBTENER_DATOS_EXPEDIENTE").withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("p_Codigo_Expediente", Types.VARCHAR),
						new SqlOutParameter("Reg", Types.REF_CURSOR, new InformacionExpedienteRowMapper()));
		SqlParameterSource prm = new MapSqlParameterSource().addValue("p_Codigo_Expediente", p_Codigo_Expediente);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<InformacionExpedienteBean> beanList = (List) result.get("Reg");
		return beanList;
	}

	@Override
	public List<ObtenerDocuBean> obtenerDocumentoPresen(String documentoPresen) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PCKG_DOCUMENTO_STD")
				.withProcedureName("SP_OBTENER_DOCUMENTOS_PRESEN").withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("Pcodexpediente", Types.VARCHAR),
						new SqlOutParameter("Reg", Types.REF_CURSOR, new ObtenerDocuRowMapper()));

		SqlParameterSource prm = new MapSqlParameterSource().addValue("Pcodexpediente", documentoPresen);

		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<ObtenerDocuBean> beanList = (List<ObtenerDocuBean>) result.get("Reg");

		return beanList;

	}

	@Override
	public List<FirmarCerrarExpedienteBean> firmarCerrarExpediente(String codexpediente) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PCKG_CERT_CUARENTENA")
				.withProcedureName("SP_OBTENER_VARS_CERTIF_FITO").withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("codexpediente", Types.VARCHAR),
						new SqlOutParameter("Reg", Types.REF_CURSOR, new FirmarCerrarExpRowMapper()));

		SqlParameterSource prm = new MapSqlParameterSource().addValue("codexpediente", codexpediente);

		try {
			Map<String, Object> result = simpleJdbcCall.execute(prm);
			List<FirmarCerrarExpedienteBean> beanList = (List<FirmarCerrarExpedienteBean>) result.get("Reg");
			return beanList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
    public String grabarObservacion(GrabarObservacionRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_TRAZABILIDAD")
                .withProcedureName("SP_INSERTAR_TRAZA_OBSERVACION")
                .withoutProcedureColumnMetaDataAccess() 
                .useInParameterNames("Pcodexpediente", "Premitenteusuario", "Pcanal", "Pobservacion", "Inplazo", "Numeregiarc", "ucmid")
                .declareParameters(
                        new SqlParameter("Pcodexpediente", Types.VARCHAR),
                        new SqlParameter("Premitenteusuario", Types.VARCHAR),
                        new SqlParameter("Pcanal", Types.VARCHAR),
                        new SqlParameter("Pobservacion", Types.VARCHAR),
                        new SqlParameter("Inplazo", Types.VARCHAR),
                        new SqlParameter("Numeregiarc", Types.VARCHAR),
                        new SqlParameter("ucmid", Types.VARCHAR) // Default NULL
                );
        //System.out.println("Graba Observación del expediente: " + request.getPcodexpediente());
        
        		SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("Pcodexpediente", request.getPcodexpediente())
                .addValue("Premitenteusuario", request.getPremitenteusuario())
                .addValue("Pcanal", request.getPcanal())
                .addValue("Pobservacion", request.getPobservacion())
                .addValue("Inplazo", request.getInplazo())
                .addValue("Numeregiarc", request.getNumeregiarc())
                .addValue("ucmid", request.getUcmid())
                ;
        		//System.out.println("Graba Observación del expediente 2: " + request.getPcodexpediente());
        		//System.out.println("TERMINO DE LEER");
        		/*
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("Pcodexpediente", request.getPcodexpediente());
        inParams.put("Premitenteusuario", request.getPremitenteusuario());
        inParams.put("Pcanal", request.getPcanal());
        inParams.put("Pobservacion", request.getPobservacion());
        inParams.put("Inplazo", request.getInplazo());
        inParams.put("Numeregiarc", request.getNumeregiarc());
        inParams.put("ucmid", request.getUcmid()); */

        		Map<String, Object> result = simpleJdbcCall.execute(prm);
                String resultado = (String) result.get("Pcodexpediente");
                return "Guardó Observaciones del Documento Resolutivo";

        /*List<GrabarObservacionBean> response = new ArrayList<>();
        GrabarObservacionBean bean = new GrabarObservacionBean();
        bean.setPcodsolicitud((String) out.get("Pcodsolicitud"));
        bean.setPcodigostddoc((String) out.get("Pcodigostddoc"));
        response.add(bean);

        return response;
       */
        
    }
    
    @Override
    public List<GrabarDocHijoBean> grabarDocHijo(GrabarDocHijoRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("Sp_Grabar_Std_Documento_Hijo")
                .withoutProcedureColumnMetaDataAccess() // Evitar problemas de metadatos
                .useInParameterNames("Pcodigostdpadre","Pdocumento", "Puserid", "Pconfidencial", "Pucmid","Pnumfolio","Pindobligatorio","Pestado","Pnombredochijo")
                .declareParameters(
                		new SqlParameter("Pcodigostdpadre", Types.VARCHAR),
                        new SqlParameter("Pdocumento", Types.VARCHAR),
                        new SqlParameter("Puserid", Types.VARCHAR),
                        new SqlParameter("Pconfidencial", Types.VARCHAR),
                        new SqlParameter("Pucmid", Types.VARCHAR),
                        new SqlParameter("Pnumfolio", Types.VARCHAR),
                        new SqlParameter("Pindobligatorio", Types.VARCHAR),
                        new SqlParameter("Pestado", Types.VARCHAR),
                        new SqlOutParameter("Pnombrestd", Types.VARCHAR),
                        new SqlOutParameter("Pcodigostddoc", Types.VARCHAR),
                        new SqlParameter("Pnombredochijo", Types.VARCHAR)
                        
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("Pcodigostdpadre", request.getPcodigostdpadre());
        inParams.put("Pdocumento", request.getPdocumento());
        inParams.put("Puserid", request.getPuserid());
        inParams.put("Pconfidencial", request.getPconfidencial());
        inParams.put("Pucmid", request.getPucmid());
        inParams.put("Pnumfolio", request.getPnumfolio());
        inParams.put("Pindobligatorio", request.getPindobligatorio());
        inParams.put("Pestado", request.getPestado());
        inParams.put("Pnombredochijo", request.getPnombredochijo());

        Map<String, Object> out = simpleJdbcCall.execute(inParams);

        List<GrabarDocHijoBean> response = new ArrayList<>();
        GrabarDocHijoBean bean = new GrabarDocHijoBean();
        bean.setPnombrestd((String) out.get("Pnombrestd"));
        bean.setPcodigostddoc((String) out.get("Pcodigostddoc"));
        response.add(bean);

        return response;
    }
    
    @Override
    public List<GrabarResolutivoBean> grabarResolutivo(GrabarResolutivoRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("SP_GRABAR_RESOLUTIVO_PROV")
                .withoutProcedureColumnMetaDataAccess() // Evitar problemas de metadatos
                .useInParameterNames("Pcentrotramite","Pcodexpediente", "Ppersonaid", "Pprocedimientotupa", "Puserid","Pdocumentos","Pdestinatariousuario","Pcanal","Pobservacion")
                .declareParameters(
                		new SqlParameter("Pcentrotramite", Types.VARCHAR),
                        new SqlParameter("Pcodexpediente", Types.VARCHAR),
                        new SqlParameter("Ppersonaid", Types.VARCHAR),
                        new SqlParameter("Pprocedimientotupa", Types.VARCHAR),
                        new SqlParameter("Puserid", Types.VARCHAR),
                        new SqlParameter("Pdocumentos", Types.VARCHAR),
                        new SqlParameter("Pdestinatariousuario", Types.VARCHAR),
                        new SqlParameter("Pcanal", Types.VARCHAR),
                        new SqlParameter("Pobservacion", Types.VARCHAR),
                        new SqlParameter("Pobservacion", Types.VARCHAR),
                        new SqlOutParameter("Pcodigostddoc", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("Pcentrotramite", request.getPcentrotramite());
        inParams.put("Pcodexpediente", request.getPcodexpediente());
        inParams.put("Ppersonaid", request.getPpersonaid());
        inParams.put("Pprocedimientotupa", request.getPprocedimientotupa());
        inParams.put("Puserid", request.getPuserid());
        inParams.put("Pdocumentos", request.getPdocumentos());
        inParams.put("Pdestinatariousuario", request.getPdestinatariousuario());
        inParams.put("Pcanal", request.getPcanal());
        inParams.put("Pobservacion", request.getPobservacion());

        Map<String, Object> out = simpleJdbcCall.execute(inParams);

        List<GrabarResolutivoBean> response = new ArrayList<>();
        GrabarResolutivoBean bean = new GrabarResolutivoBean();
        bean.setPcodigostddoc((String) out.get("Pcodigostddoc"));
        response.add(bean);

        return response;
    }	
    
    @Override
    public List<GrabarResolutivoCierreBean> grabarResolutivoCierre(GrabarResolutivoCierreRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("SP_GRABAR_RESOLUTIVO")
                .withoutProcedureColumnMetaDataAccess() // Evitar problemas de metadatos
                .useInParameterNames("Pcentrotramite","Pcodexpediente", "Ppersonaid", "Pprocedimientotupa", "Puserid","Pdocumentos")
                .declareParameters(
                		new SqlParameter("Pcentrotramite", Types.VARCHAR),
                        new SqlParameter("Pcodexpediente", Types.VARCHAR),
                        new SqlParameter("Ppersonaid", Types.VARCHAR),
                        new SqlParameter("Pprocedimientotupa", Types.VARCHAR),
                        new SqlParameter("Puserid", Types.VARCHAR),
                        new SqlParameter("Pdocumentos", Types.VARCHAR),
                        new SqlOutParameter("Pcodigostddoc", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("Pcentrotramite", request.getPcentrotramite());
        inParams.put("Pcodexpediente", request.getPcodexpediente());
        inParams.put("Ppersonaid", request.getPpersonaid());
        inParams.put("Pprocedimientotupa", request.getPprocedimientotupa());
        inParams.put("Puserid", request.getPuserid());
        inParams.put("Pdocumentos", request.getPdocumentos());

        Map<String, Object> out = simpleJdbcCall.execute(inParams);

        List<GrabarResolutivoCierreBean> response = new ArrayList<>();
        GrabarResolutivoCierreBean bean = new GrabarResolutivoCierreBean();
        bean.setPcodigostddoc((String) out.get("Pcodigostddoc"));
        response.add(bean);

        return response;
    }
    
    @Override
    public List<ObtenerInfoAdjuntosBean> obtenerInfoAdjuntos(String p_ucmid) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PCKG_DOCUMENTO_STD")
				.withProcedureName("SP_OBTENER_INFO_ADJUNTOS").withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("p_ucmid", Types.VARCHAR),
						new SqlOutParameter("Reg", Types.REF_CURSOR, new ObtenerInfoAdjuntosRowMapper()));
		SqlParameterSource prm = new MapSqlParameterSource().addValue("p_ucmid", p_ucmid);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<ObtenerInfoAdjuntosBean> beanList = (List) result.get("Reg");
		return beanList;
	}
    
    @Override
    public List<ReqDocSalidaBean> reqDocSalida(String pcodexpediente) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PCKG_SERVICIO")
				.withProcedureName("SP_REQUSITOS_DOC_SALIDA").withoutProcedureColumnMetaDataAccess()
				.declareParameters(
						new SqlParameter("pcodexpediente", Types.VARCHAR),
						new SqlOutParameter("Reg", Types.REF_CURSOR, new ReqDocSalidaRowMapper()),
						new SqlOutParameter("cerrado", Types.VARCHAR)
						);
		SqlParameterSource prm = new MapSqlParameterSource().addValue("pcodexpediente", pcodexpediente);
		Map<String, Object> result = simpleJdbcCall.execute(prm);
		List<ReqDocSalidaBean> beanList = (List) result.get("Reg");
		return beanList;
	}
    
    @Override
    public List<GrabarDocumentoSTDBean> grabarDocumentoSTD(GrabarDocumentoSTDRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("SP_GET_COD_DOCUMENTO_STD_PADRE")
                .withoutProcedureColumnMetaDataAccess() // Evitar problemas de metadatos
                .useInParameterNames("codigoexpediente","codigostddoc")
                .declareParameters(
                		new SqlParameter("codigoexpediente", Types.VARCHAR),
                         new SqlOutParameter("codigostddoc", Types.VARCHAR)
                        
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("codigoexpediente", request.getCodigoexpediente());
        

        Map<String, Object> out = simpleJdbcCall.execute(inParams);

        List<GrabarDocumentoSTDBean> response = new ArrayList<>();
        GrabarDocumentoSTDBean bean = new GrabarDocumentoSTDBean();
        bean.setCodigostddoc((String) out.get("codigostddoc"));
        response.add(bean);

        return response;
    }
    
    @Override
    public String registrarFirmaEmpleado(String pcodigoexpediente, String codigoemplper) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_CERT_CUARENTENA")
                .withProcedureName("SP_REGISTRAR_EMPLEADO_FIRMA")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("pcodigoexpediente", Types.VARCHAR),
                        new SqlParameter("codigoemplper", Types.VARCHAR));

        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("pcodigoexpediente", pcodigoexpediente)
                .addValue("codigoemplper", codigoemplper);

        simpleJdbcCall.execute(prm);
        return "Firma correcta.";
    }
    @Override
    public List<ValidarPendientePagoBean> validarPendientePago(String codigoexpediente) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("SP_VALIDA_PENDIENTE_SERV_ADIC")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("codigoexpediente", Types.VARCHAR),
                        new SqlOutParameter("flag", Types.NUMERIC)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("codigoexpediente", codigoexpediente);

        Map<String, Object> out = simpleJdbcCall.execute(inParams);

        List<ValidarPendientePagoBean> response = new ArrayList<>();
        ValidarPendientePagoBean bean = new ValidarPendientePagoBean();
        bean.setFlag((Number) out.get("flag"));

        response.add(bean);

        return response;
    }
    @Override
    public String registrarFirmaEmpleados(RegistrarFirmaEmpleadoRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_CERT_CUARENTENA")
                .withProcedureName("SP_REGISTRAR_EMPLEADO_FIRMA")
                .withoutProcedureColumnMetaDataAccess() 
                .useInParameterNames("pcodigoexpediente", "codigoemplper")
                .declareParameters(
                        new SqlParameter("pcodigoexpediente", Types.VARCHAR),
                        new SqlParameter("codigoemplper", Types.VARCHAR)
                );
        
        		SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("pcodigoexpediente", request.getCodigoemplper())
                .addValue("codigoemplper", request.getCodigoemplper())
                ;
        	
        		Map<String, Object> result = simpleJdbcCall.execute(prm);
                String resultado = (String) result.get("Pcodexpediente");
                return "Se actualizó firma del empleado";

        
    }

}
