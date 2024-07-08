package com.senasa.bpm.ng.dao.impl;

import java.math.BigDecimal;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.senasa.bpm.ng.dao.GrabarDao;
import com.senasa.bpm.ng.dao.rowmapper.GrabarActReciboRowMapper;
import com.senasa.bpm.ng.exception.ApiValidateException;
import com.senasa.bpm.ng.model.bean.GrabarActReciboBean;
import com.senasa.bpm.ng.model.bean.GrabarBean;
import com.senasa.bpm.ng.model.bean.GrabarInactivoBean;
import com.senasa.bpm.ng.model.bean.ValidarExpedienteBean;
import com.senasa.bpm.ng.model.request.AgregarPersonaRequest;
import com.senasa.bpm.ng.model.request.GrabarActReciboRequest;
import com.senasa.bpm.ng.model.request.GrabarInactivoRequest;
import com.senasa.bpm.ng.model.request.GrabarSolRequest;
import com.senasa.bpm.ng.model.request.ServicioAdicionalRequest;
import com.senasa.bpm.ng.model.request.ValidarBoletaRequest;
import com.senasa.bpm.ng.utility.ConstantUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class GrabarDaoImpl implements  GrabarDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public GrabarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<GrabarBean> grabarSolicitud(GrabarSolRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("Sp_Grabar_Solicitud")
                .withoutProcedureColumnMetaDataAccess() // Evitar problemas de metadatos
                .useInParameterNames("Pcentrotramite", "Pcanal", "Ppersonaid", "Pprocedimientotupa", "Puserid", "Prepresentanteid", "Pcodexpediente", "Pcodorden")
                .declareParameters(
                        new SqlParameter("Pcentrotramite", Types.VARCHAR),
                        new SqlParameter("Pcanal", Types.VARCHAR),
                        new SqlParameter("Ppersonaid", Types.VARCHAR),
                        new SqlParameter("Pprocedimientotupa", Types.VARCHAR),
                        new SqlParameter("Puserid", Types.VARCHAR),
                        new SqlParameter("Prepresentanteid", Types.VARCHAR),
                        new SqlOutParameter("Pcodsolicitud", Types.VARCHAR),
                        new SqlParameter("Pcodexpediente", Types.VARCHAR),
                        new SqlOutParameter("Pcodigostddoc", Types.VARCHAR),
                        new SqlParameter("Pcodorden", Types.VARCHAR, null) // Default NULL
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("Pcentrotramite", request.getPcentrotramite());
        inParams.put("Pcanal", request.getPcanal());
        inParams.put("Ppersonaid", request.getPpersonaid());
        inParams.put("Pprocedimientotupa", request.getPprocedimientotupa());
        inParams.put("Puserid", request.getPuserid());
        inParams.put("Prepresentanteid", request.getPrepresentanteid());
        inParams.put("Pcodexpediente", request.getPcodexpediente()); // Es un parámetro de entrada
        inParams.put("Pcodorden", request.getPcodorden());

        Map<String, Object> out = simpleJdbcCall.execute(inParams);

        List<GrabarBean> response = new ArrayList<>();
        GrabarBean bean = new GrabarBean();
        bean.setPcodsolicitud((String) out.get("Pcodsolicitud"));
        bean.setPcodigostddoc((String) out.get("Pcodigostddoc"));
        response.add(bean);

        return response;
    }

    @Override
    public List<GrabarInactivoBean> grabarInactivo(GrabarInactivoRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("Sp_Grabar_Inactivo")
                .withoutProcedureColumnMetaDataAccess()
                .useInParameterNames("Pcentrotramite", "Pcanal", "Ppersonaid", "Ppersonaidotro", "Pprocedimientotupa", "Puserid", "Ppersonaidsolicitante", "Prepresentanteid", "Pcodexpediente", "Pdetallerecibo", "Pdetallevacuna", "Ppagorecibo", "Pcodorden")
                .declareParameters(
                        new SqlParameter("Pcentrotramite", Types.VARCHAR),
                        new SqlParameter("Pcanal", Types.VARCHAR),
                        new SqlParameter("Ppersonaid", Types.VARCHAR),
                        new SqlParameter("Ppersonaidotro", Types.VARCHAR),
                        new SqlParameter("Pprocedimientotupa", Types.VARCHAR),
                        new SqlParameter("Puserid", Types.VARCHAR),
                        new SqlParameter("Ppersonaidsolicitante", Types.VARCHAR),
                        new SqlParameter("Prepresentanteid", Types.VARCHAR),
                        new SqlInOutParameter("Pcodexpediente", Types.VARCHAR),
                        new SqlOutParameter("Pcodsolicitud", Types.VARCHAR),
                        new SqlOutParameter("Pcodrecibo", Types.VARCHAR),
                        new SqlOutParameter("Pcodigostddoc", Types.VARCHAR),
                        new SqlParameter("Pdetallerecibo", Types.VARCHAR),
                        new SqlParameter("Pdetallevacuna", Types.VARCHAR, null), // Asume NULL como valor por defecto
                        new SqlParameter("Ppagorecibo", Types.VARCHAR),
                        new SqlParameter("Pcodorden", Types.VARCHAR, null) // Asume NULL como valor por defecto
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("Pcentrotramite", request.getPcentrotramite());
        inParams.put("Pcanal", request.getPcanal());
        inParams.put("Ppersonaid", request.getPpersonaid());
        inParams.put("Ppersonaidotro", request.getPpersonaidotro());
        inParams.put("Pprocedimientotupa", request.getPprocedimientotupa());
        inParams.put("Puserid", request.getPuserid());
        inParams.put("Ppersonaidsolicitante", request.getPpersonaidsolicitante());
        inParams.put("Prepresentanteid", request.getPrepresentanteid());
        inParams.put("Pcodexpediente", request.getPcodexpediente()); // Parámetro de entrada/salida
        inParams.put("Pdetallerecibo", request.getPdetallerecibo());
        inParams.put("Pdetallevacuna", request.getPdetallevacuna());
        inParams.put("Ppagorecibo", request.getPpagorecibo());
        inParams.put("Pcodorden", request.getPcodorden());

        Map<String, Object> out = simpleJdbcCall.execute(inParams);

        List<GrabarInactivoBean> response = new ArrayList<>();
        GrabarInactivoBean bean = new GrabarInactivoBean();
        bean.setPcodexpediente((String) out.get("Pcodexpediente"));
        bean.setPcodsolicitud((String) out.get("Pcodsolicitud"));
        bean.setPcodrecibo((String) out.get("Pcodrecibo"));
        bean.setPcodigostddoc((String) out.get("Pcodigostddoc"));
        response.add(bean);

        return response;
    }
    @Override
    public String servicioAdicional(ServicioAdicionalRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("SP_GRABAR_SERVICIO_ADIC")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlInOutParameter("Pcentrotramite", Types.VARCHAR),
                        new SqlParameter("Ppersonaid", Types.VARCHAR),
                        new SqlParameter("Ppersonaidotro", Types.VARCHAR),
                        new SqlParameter("Puserid", Types.VARCHAR),
                        new SqlParameter("Ppersonaidsolicitante", Types.VARCHAR),
                        new SqlParameter("Pcodexpediente", Types.VARCHAR),
                        new SqlOutParameter("Pcodrecibo", Types.VARCHAR),
                        new SqlParameter("Pdetallerecibo", Types.VARCHAR),
                        new SqlParameter("Ppagorecibo", Types.VARCHAR),
                        new SqlParameter("Pobservaciontraza", Types.VARCHAR));  // Mantenido como VARCHAR ya que es IN OUT y parece ser un identificador


        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("Pcentrotramite", request.getPcentrotramite())
                .addValue("Ppersonaid", request.getPpersonaid())
                .addValue("Ppersonaidotro", request.getPpersonaidotro())
                .addValue("Puserid", request.getPuserid())
                .addValue("Ppersonaidsolicitante", request.getPpersonaidsolicitante())
                .addValue("Pcodexpediente", request.getPcodexpediente())
                .addValue("Pdetallerecibo", request.getPdetallerecibo())
                .addValue("Ppagorecibo", request.getPpagorecibo())
                .addValue("Pobservaciontraza", request.getPobservaciontraza());

        Map<String, Object> result = simpleJdbcCall.execute(prm);
        String resultado = (String) result.get("Pcodrecibo");
        return resultado;
    }
    @Override
    public List<GrabarActReciboBean> grabarActRecibo(GrabarActReciboRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("SP_ACTUALIZAR_RECIBO")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("Pcodrecibo", Types.VARCHAR),
                        new SqlParameter("Pucmid", Types.VARCHAR),
                        new SqlParameter("Pcodigostddoc", Types.VARCHAR),
                        new SqlParameter("Puserid", Types.VARCHAR),
                        new SqlParameter("Pcodexpediente", Types.VARCHAR),
                        new SqlOutParameter("Reg", Types.REF_CURSOR,
                                new GrabarActReciboRowMapper()));
        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("Pcodrecibo", request.getPcodrecibo())
                .addValue("Pucmid", request.getPucmid())
                .addValue("Pcodigostddoc", request.getPcodigostddoc())
                .addValue("Puserid", request.getPuserid())
                .addValue("Pcodexpediente", request.getPcodexpediente());


        try {
            Map<String, Object> result = simpleJdbcCall.execute(prm);
            List<GrabarActReciboBean> beanList = (List<GrabarActReciboBean>) result.get("Reg");
            return beanList;
        } catch (DataAccessException e) {
            throw new ApiValidateException(ConstantUtil.ERROR_MESSAGE);
        }
    }

    @Override
    public String validarBoleta(ValidarBoletaRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_RECIBO")
                .withProcedureName("SP_VALIDAR_NRO_BOLETA")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("codigoctacte", Types.VARCHAR),
                        new SqlParameter("numerodeposito", Types.VARCHAR),
                        new SqlOutParameter("mensaje", Types.VARCHAR));
                               new GrabarActReciboRowMapper();
        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("codigoctacte", request.getCodigoctacte())
                .addValue("numerodeposito", request.getNumerodeposito());
        Map<String, Object> result = simpleJdbcCall.execute(prm);
        String resultado = (String) result.get("mensaje");
        return resultado;
    }

    @Override
    public List<ValidarExpedienteBean> validarExpediente(String pcodexpediente) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_GRABAR")
                .withProcedureName("Sp_Expediente_Cerrado")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("Pcodexpediente", Types.VARCHAR),
                        new SqlOutParameter("Pcerrado", Types.NUMERIC),
                        new SqlOutParameter("Pmensaje", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("Pcodexpediente", pcodexpediente);

        Map<String, Object> out = simpleJdbcCall.execute(inParams);

        List<ValidarExpedienteBean> response = new ArrayList<>();
        ValidarExpedienteBean bean = new ValidarExpedienteBean();

        // Convertir BigDecimal a Integer
        BigDecimal cerradoBD = (BigDecimal) out.get("Pcerrado");
        int cerrado = cerradoBD != null ? cerradoBD.intValue() : 0;  // Convertir a int y manejar null
        bean.setPcerrado(cerrado);

        bean.setPmensaje((String) out.get("Pmensaje"));

        response.add(bean);

        return response;
    }
    @Override
    public java.sql.Date convertirStringADate(String fecha) {
        System.out.println("LLEGO AL METODO CONVERTIR");
        if (fecha != null && !fecha.isEmpty()) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
                java.util.Date utilDate = formato.parse(fecha);
                return new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public String agregarPersona(AgregarPersonaRequest request) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PCKG_PERSONA")
                .withProcedureName("SP_REGISTRAR_PERSONA_VALIDADO")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlInOutParameter("p_Persona_Id", Types.VARCHAR),
                        new SqlParameter("p_Nombre_Razon_Social", Types.VARCHAR),
                        new SqlParameter("p_Persona_Tipo", Types.VARCHAR),
                        new SqlParameter("p_Documento_Tipo", Types.VARCHAR),
                        new SqlParameter("p_Documento_Numero", Types.VARCHAR),
                        new SqlParameter("p_Ruc", Types.VARCHAR),
                        new SqlParameter("p_Direccion", Types.VARCHAR),
                        new SqlParameter("p_Departamento_Id", Types.VARCHAR),
                        new SqlParameter("p_Provincia_Id", Types.VARCHAR),
                        new SqlParameter("p_Distrito_Id", Types.VARCHAR),
                        new SqlParameter("p_Telefono", Types.VARCHAR),
                        new SqlParameter("p_Telefono_Movil", Types.VARCHAR),
                        new SqlParameter("p_Correo_Electronico", Types.VARCHAR),
                        new SqlParameter("p_Fecha_Nacimiento", Types.DATE),  // Cambiado a Types.DATE
                        new SqlParameter("p_Referencia_Direccion", Types.VARCHAR),
                        new SqlParameter("p_Fecha_Alta", Types.DATE),         // Cambiado a Types.DATE
                        new SqlParameter("p_Fecha_Baja", Types.DATE),         // Cambiado a Types.DATE
                        new SqlParameter("p_Nombre_Comercial", Types.VARCHAR),
                        new SqlParameter("p_Estado_Juridico", Types.VARCHAR),
                        new SqlParameter("p_Sincronizacion_Estado", Types.VARCHAR),
                        new SqlParameter("p_Sincronizacion_Fecha", Types.DATE),  // Cambiado a Types.DATE
                        new SqlParameter("p_Usuario", Types.VARCHAR));  // Mantenido como VARCHAR ya que es IN OUT y parece ser un identificador
        System.out.println("ESTE ES EL FECHA NAC:" + request.getP_Fecha_Nacimiento());



        SqlParameterSource prm = new MapSqlParameterSource()
                .addValue("p_Persona_Id", request.getP_Persona_Id())
                .addValue("p_Nombre_Razon_Social", request.getP_Nombre_Razon_Social())
                .addValue("p_Persona_Tipo", request.getP_Persona_Tipo())
                .addValue("p_Documento_Tipo", request.getP_Documento_Tipo())
                .addValue("p_Documento_Numero", request.getP_Documento_Numero())
                .addValue("p_Ruc", request.getP_Ruc())
                .addValue("p_Direccion", request.getP_Direccion())
                .addValue("p_Departamento_Id", request.getP_Departamento_Id())
                .addValue("p_Provincia_Id", request.getP_Provincia_Id())
                .addValue("p_Distrito_Id", request.getP_Distrito_Id())
                .addValue("p_Telefono", request.getP_Telefono())
                .addValue("p_Telefono_Movil", request.getP_Telefono_Movil())
                .addValue("p_Correo_Electronico", request.getP_Correo_Electronico())
                .addValue("p_Fecha_Nacimiento", this.convertirStringADate(request.getP_Fecha_Nacimiento()))  // Convierte String a java.sql.Date
                .addValue("p_Referencia_Direccion", request.getP_Referencia_Direccion())
                .addValue("p_Fecha_Alta", this.convertirStringADate(request.getP_Fecha_Alta()))             // Convierte String a java.sql.Date
                .addValue("p_Fecha_Baja", this.convertirStringADate(request.getP_Fecha_Baja()))           // Convierte String a java.sql.Date
                .addValue("p_Nombre_Comercial", request.getP_Nombre_Comercial())
                .addValue("p_Estado_Juridico", request.getP_Estado_Juridico())
                .addValue("p_Sincronizacion_Estado", request.getP_Sincronizacion_Estado())
                .addValue("p_Sincronizacion_Fecha", this.convertirStringADate(request.getP_Sincronizacion_Fecha()))  // Convierte String a java.sql.Date
                .addValue("p_Usuario", request.getP_Usuario());
        System.out.println("TERMINO DE LEER");

        Map<String, Object> result = simpleJdbcCall.execute(prm);
        String resultado = (String) result.get("p_Persona_Id");
        return resultado;
    }


}
