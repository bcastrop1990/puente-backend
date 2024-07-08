package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.dao.DocuResolutivoDao;
import com.senasa.bpm.ng.model.bean.*;
import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.GrabarDocHijoRequest;
import com.senasa.bpm.ng.model.request.GrabarDocumentoSTDRequest;
import com.senasa.bpm.ng.model.request.GrabarInactivoRequest;
import com.senasa.bpm.ng.model.request.GrabarObservacionRequest;
import com.senasa.bpm.ng.model.request.GrabarResolutivoCierreRequest;
import com.senasa.bpm.ng.model.request.GrabarResolutivoRequest;
import com.senasa.bpm.ng.model.request.GrabarSolRequest;
import com.senasa.bpm.ng.model.request.RegistrarFirmaEmpleadoRequest;
import com.senasa.bpm.ng.model.response.*;
import com.senasa.bpm.ng.service.DocuResolutivoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DocuResolutivoServiceImpl implements DocuResolutivoService {

    private DocuResolutivoDao docResolutivoDao;
    


    @Override
    public List<DerivacionPersonalResponse> listarPersona(String nombrePersona) {
        List<DerivacionPersonalBean> derivacionBean = docResolutivoDao.listarPersona(nombrePersona);
        List<DerivacionPersonalResponse> response = new ArrayList<>();

        for (DerivacionPersonalBean personal : derivacionBean) {
            DerivacionPersonalResponse derivacionPersonalResponse = DerivacionPersonalResponse.builder()
                    .usuario(personal.getUsuario())
                    .nombre_persona(personal.getNombre_persona())
                    .build();
            response.add(derivacionPersonalResponse);
        }
        return response;
    }
    @Override
    public List<DetalleDerivacionResponse> listarDetalleDerivacion (String pcodexpediente) {
        List<DetalleDerivacionBean> detalleDerivacionBean = docResolutivoDao.listarDetalleDerivacion(pcodexpediente);
        List<DetalleDerivacionResponse> response = new ArrayList<>();

        for (DetalleDerivacionBean detalleDerivacion : detalleDerivacionBean) {
            DetalleDerivacionResponse detalleDerivacionResponse = DetalleDerivacionResponse.builder()
                .notas(detalleDerivacion.getNotas())
                .fech_Crea(detalleDerivacion.getFech_Crea())
                .remitente_Usuario(detalleDerivacion.getRemitente_Usuario())
                .remitente_Persona(detalleDerivacion.getRemitente_Persona())
                .ucm_id(detalleDerivacion.getUcm_id())
                .build();
            response.add(detalleDerivacionResponse);
        }
        return response;
    }

    @Override
    public List<AgregarDocuResponse> listarDocumento(String documentoResolutivo) {
        List<AgregarDocuBean> agregarDocuBean = docResolutivoDao.listarDocumento(documentoResolutivo);
        List<AgregarDocuResponse> response = new ArrayList<>();

        for (AgregarDocuBean documento : agregarDocuBean) {
            AgregarDocuResponse derivacionPersonalResponse = AgregarDocuResponse.builder()
                    .codigo_Documento(documento.getCodigo_Documento())
                    .descripcion_Corta(documento.getDescripcion_Corta())
                    .build();
            response.add(derivacionPersonalResponse);
        }
        return response;
    }
    @Override
    public List<InformacionExpedienteResponse> obtenerCodigoExpediente (String p_Codigo_Expediente) {
        List<InformacionExpedienteBean> informacionExpedienteBean = docResolutivoDao.obtenerCodigoExpediente(p_Codigo_Expediente);
        List<InformacionExpedienteResponse> response = new ArrayList<>();

        for (InformacionExpedienteBean documento : informacionExpedienteBean) {
            InformacionExpedienteResponse informacionExpedienteResponse = InformacionExpedienteResponse.builder()
                .codigoExpediente(documento.getCodigoExpediente())
                .fechaRegistro(documento.getFechaRegistro())
                .codigoCentroTramite(documento.getCodigoCentroTramite())
                .descripcionCentroTramite(documento.getDescripcionCentroTramite())
                .codigoServicio(documento.getCodigoServicio())
                .descripcionAreaGestion(documento.getDescripcionAreaGestion())
                .descripcionProcedimientoTupa(documento.getCodigoProcedimientoTupa())
                .descripcionServicio(documento.getDescripcionServicio())
                .personaId(documento.getPersonaId())
                .nombreRazonSocial(documento.getNombreRazonSocial())
                .codigoSolicitud(documento.getCodigoSolicitud())
                .ucmId(documento.getUcmId())
                .codigoProcedimientoTupa(documento.getDescripcionProcedimientoTupa())
                .numeRegiArc(documento.getNumeRegiArc())
                .ordenVuce(documento.getOrdenVuce())
                .canal(documento.getCanal())
                .codigoStdDoc(documento.getCodigoStdDoc())
                .numeroFolios(documento.getNumeroFolios())
                .confidencial(documento.getConfidencial())
                .codigoTupa(documento.getCodigoTupa())
                .codFormato(documento.getCodFormato())
                .estado(documento.getEstado())
                .estadoExpediente(documento.getEstadoExpediente())
                .tipoCertificado(documento.getTipoCertificado())
                .oeaTipoOperador(documento.getOeaTipoOperador())
                .oeaTipoAtencion(documento.getOeaTipoAtencion())
                .build();
            response.add(informacionExpedienteResponse);
        }
        return response;
    }

    @Override
    public List<ObtenerDocuResponse> obtenerDocumentoPresen (String documentoParam) {
        List<ObtenerDocuBean> obtenerDocuBean = docResolutivoDao.obtenerDocumentoPresen(documentoParam);
        List<ObtenerDocuResponse> response = new ArrayList<>();

        for (ObtenerDocuBean obtenerDocu : obtenerDocuBean) {
            ObtenerDocuResponse obtenerDocuResponse = ObtenerDocuResponse.builder()
                .codigo_std_doc(obtenerDocu.getCodigo_std_doc())
                .codigo_std_doc_adjunto(obtenerDocu.getCodigo_std_doc())
                .codigo_tipo_documento(obtenerDocu.getCodigo_tipo_documento())
                .descripcion_documento(obtenerDocu.getDescripcion_documento())
                .nombre(obtenerDocu.getNombre())
                .indicador_obligatorio(obtenerDocu.getIndicador_obligatorio())
                .ucm_id(obtenerDocu.getUcm_id())
                .confidencial(obtenerDocu.getConfidencial())
                .numer_regi_arc(obtenerDocu.getNumer_regi_arc())
                .build();
            response.add(obtenerDocuResponse);
        }
        return response;
    }



    @Override
    public List<FirmarCerrarExpedienteResponse> firmarCerrarExpediente(String codexpediente) {
        List<FirmarCerrarExpedienteBean> obtenerDocuBean = docResolutivoDao.firmarCerrarExpediente(codexpediente);
        List<FirmarCerrarExpedienteResponse> response = new ArrayList<>();

        for (FirmarCerrarExpedienteBean obtenerDocu : obtenerDocuBean) {
            FirmarCerrarExpedienteResponse obtenerDocuResponse = FirmarCerrarExpedienteResponse.builder()
                    .cod_idioma(obtenerDocu.getCod_idioma())
                    .fg_varios(obtenerDocu.getFg_varios())
                    .tot_productos(obtenerDocu.getTot_productos())
                    .codigo_iiv(obtenerDocu.getCodigo_iiv())
                    .secuencial(obtenerDocu.getSecuencial())
                    .codstddoc(obtenerDocu.getCodstddoc())
                    .plantilla(obtenerDocu.getPlantilla())
                    .build();
            response.add(obtenerDocuResponse);
        }
        return response;
    }
    
    @Override
    public String grabarObservacion(GrabarObservacionRequest request) {
      	return docResolutivoDao.grabarObservacion(request);
     }
    
    @Override
    public List<GrabarDocHijoResponse> grabarDocHijo(GrabarDocHijoRequest request) {
        List<GrabarDocHijoBean> grabarDocHijoBean = docResolutivoDao.grabarDocHijo(request);
        List<GrabarDocHijoResponse> response = new ArrayList<>();

        for (GrabarDocHijoBean grabarDocHijo : grabarDocHijoBean) {
        	GrabarDocHijoResponse grabarDocHijoResponse = GrabarDocHijoResponse.builder()
                    .pnombrestd(grabarDocHijo.getPnombrestd())
                    .pcodigostddoc(grabarDocHijo.getPcodigostddoc())
                    .build();
        	response.add(grabarDocHijoResponse);
        }
        return response;
    }
    
    @Override
    public List<GrabarResolutivoResponse> grabarResolutivo(GrabarResolutivoRequest request) {
        List<GrabarResolutivoBean> grabarResolutivoBean = docResolutivoDao.grabarResolutivo(request);
        List<GrabarResolutivoResponse> response = new ArrayList<>();

        for (GrabarResolutivoBean grabarResolutivo : grabarResolutivoBean) {
        	GrabarResolutivoResponse grabarResolutivoResponse = GrabarResolutivoResponse.builder()
                    .pcodigostddoc(grabarResolutivo.getPcodigostddoc())
                    .build();
        	response.add(grabarResolutivoResponse);
        }
        return response;
    }
    
    @Override
    public List<GrabarResolutivoCierreResponse> grabarResolutivoCierre(GrabarResolutivoCierreRequest request) {
        List<GrabarResolutivoCierreBean> grabarResolutivoCierreBean = docResolutivoDao.grabarResolutivoCierre(request);
        List<GrabarResolutivoCierreResponse> response = new ArrayList<>();

        for (GrabarResolutivoCierreBean grabarResolutivoC : grabarResolutivoCierreBean) {
        	GrabarResolutivoCierreResponse grabarResolutivoCResponse = GrabarResolutivoCierreResponse.builder()
                    .pcodigostddoc(grabarResolutivoC.getPcodigostddoc())
                    .build();
        	response.add(grabarResolutivoCResponse);
        }
        return response;
    }
    
    @Override
    public List<ObtenerInfoAdjuntosResponse> obtenerInfoAdjuntos (String p_ucmid) {
        List<ObtenerInfoAdjuntosBean> obtenerInfoAdjuntosBean = docResolutivoDao.obtenerInfoAdjuntos(p_ucmid);
        List<ObtenerInfoAdjuntosResponse> response = new ArrayList<>();

        for (ObtenerInfoAdjuntosBean obtenerInfoAdjuntos : obtenerInfoAdjuntosBean) {
        	ObtenerInfoAdjuntosResponse obtenerInfoAdjuntosResponse = ObtenerInfoAdjuntosResponse.builder()
                .nombre(obtenerInfoAdjuntos.getNombre())
                .ucm_id(obtenerInfoAdjuntos.getUcm_id())
                .build();
            response.add(obtenerInfoAdjuntosResponse);
        }
        return response;
    }
    
    @Override
    public List<ReqDocSalidaResponse> reqDocSalida (String pcodexpediente) {
        List<ReqDocSalidaBean> reqDocSalidaBean = docResolutivoDao.reqDocSalida(pcodexpediente);
        List<ReqDocSalidaResponse> response = new ArrayList<>();

        for (ReqDocSalidaBean reqDocSalida : reqDocSalidaBean) {
        	ReqDocSalidaResponse reqDocSalidaRespomse = ReqDocSalidaResponse.builder()
                .ucmid(reqDocSalida.getUcmid())
                .codigo_Documento(reqDocSalida.getCodigo_Documento())
                .descripcion_documento(reqDocSalida.getDescripcion_documento())
                .indicador_obligatorio(reqDocSalida.getIndicador_obligatorio())
                .sub_tipo(reqDocSalida.getSub_tipo())
                .ruta_check_in(reqDocSalida.getRuta_check_in())
                .numfolios(reqDocSalida.getNumfolios())
                .confidencialidad(reqDocSalida.getConfidencialidad())
                .cod_std_doc(reqDocSalida.getCod_std_doc())
                .build();
            response.add(reqDocSalidaRespomse);
        }
        return response;
    }
    
    @Override
    public List<GrabarDocumentoSTDResponse> grabarDocumentoSTD(GrabarDocumentoSTDRequest request) {
        List<GrabarDocumentoSTDBean> grabarDocuBean = docResolutivoDao.grabarDocumentoSTD(request);
        List<GrabarDocumentoSTDResponse> response = new ArrayList<>();

        for (GrabarDocumentoSTDBean grabarDocu : grabarDocuBean) {
        	GrabarDocumentoSTDResponse grabarDocuResponse = GrabarDocumentoSTDResponse.builder()
                    .codigostddoc(grabarDocu.getCodigostddoc())
                    .build();
        	response.add(grabarDocuResponse);
        }
        return response;
    }
    
    @Override
    public String registrarFirmaEmpleado(String pcodigoexpediente, String codigoemplper) {
        return docResolutivoDao.registrarFirmaEmpleado(pcodigoexpediente, codigoemplper);
    }
    
    @Override
    public List<ValidarPendientePagoResponse> validarPendientePago (String codigoexpediente) {
        List<ValidarPendientePagoBean> pendienteBean = docResolutivoDao.validarPendientePago(codigoexpediente);
        List<ValidarPendientePagoResponse> response = new ArrayList<>();

        for (ValidarPendientePagoBean bean : pendienteBean) {
        	ValidarPendientePagoResponse pendienteResponse = ValidarPendientePagoResponse.builder()
                    .flag(bean.getFlag())
                    .build();
            response.add(pendienteResponse);
        }
        return response;
    }
    
    @Override
    public String registrarFirmaEmpleados(RegistrarFirmaEmpleadoRequest request) {
      	return docResolutivoDao.registrarFirmaEmpleados(request);
     }
    
}





