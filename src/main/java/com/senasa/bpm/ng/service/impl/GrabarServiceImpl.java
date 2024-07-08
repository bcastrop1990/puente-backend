package com.senasa.bpm.ng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.senasa.bpm.ng.dao.GrabarDao;
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
import com.senasa.bpm.ng.model.response.GrabarActReciboResponse;
import com.senasa.bpm.ng.model.response.GrabarInactivoResponse;
import com.senasa.bpm.ng.model.response.GrabarSolicitudResponse;
import com.senasa.bpm.ng.model.response.ValidarExpedienteResponse;
import com.senasa.bpm.ng.service.GrabarService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class GrabarServiceImpl implements GrabarService {

    private GrabarDao grabarDao;

    @Override
    public List<GrabarSolicitudResponse> grabarSolicitud(GrabarSolRequest request) {
        List<GrabarBean> grabarBean = grabarDao.grabarSolicitud(request);
        List<GrabarSolicitudResponse> response = new ArrayList<>();

        for (GrabarBean grabarSol : grabarBean) {
            GrabarSolicitudResponse grabarSolResponse = GrabarSolicitudResponse.builder()
                    .pcodsolicitud(grabarSol.getPcodsolicitud())
                    .pcodigostddoc(grabarSol.getPcodigostddoc())
                    .build();
            response.add(grabarSolResponse);
        }
        return response;
    }

    @Override
    public List<GrabarInactivoResponse> grabarInactivo(GrabarInactivoRequest request) {
        List<GrabarInactivoBean> grabarInacBean = grabarDao.grabarInactivo(request);
        List<GrabarInactivoResponse> response = new ArrayList<>();

        for (GrabarInactivoBean grabarInac : grabarInacBean) {
            GrabarInactivoResponse grabarInacResponse = GrabarInactivoResponse.builder()
                    .pcodsolicitud(grabarInac.getPcodsolicitud())
                    .pcodexpediente(grabarInac.getPcodexpediente())
                    .pcodrecibo(grabarInac.getPcodrecibo())
                    .pcodigostddoc(grabarInac.getPcodigostddoc())
                    .build();
            response.add(grabarInacResponse);
        }
        return response;
    }
    @Override
    public String servicioAdicional(ServicioAdicionalRequest request) {
        return grabarDao.servicioAdicional(request);
    }
    @Override
    public List<GrabarActReciboResponse> grabarActRecibo(GrabarActReciboRequest request) {
        List<GrabarActReciboBean> grabarActReciboBean = grabarDao.grabarActRecibo(request);
        List<GrabarActReciboResponse> response = new ArrayList<>();

        for (GrabarActReciboBean grabarActRecibo : grabarActReciboBean) {
            GrabarActReciboResponse grabarActReciboResponse = GrabarActReciboResponse.builder()
                    .codigo_Expediente(grabarActRecibo.getCodigo_Expediente())
                    .fecha_Registro(grabarActRecibo.getFecha_Registro())
                    .codigo_Centro_Tramite(grabarActRecibo.getCodigo_Centro_Tramite())
                    .descripcion_Centro_Tramite(grabarActRecibo.getDescripcion_Centro_Tramite())
                    .codigo_Servicio(grabarActRecibo.getCodigo_Servicio())
                    .descripcion_Area_Gestion(grabarActRecibo.getDescripcion_Area_Gestion())
                    .descripcion_Procedimiento_Tupa(grabarActRecibo.getDescripcion_Procedimiento_Tupa())
                    .descripcion_Servicio(grabarActRecibo.getDescripcion_Servicio())
                    .persona_Id(grabarActRecibo.getPersona_Id())
                    .nombre_Razon_Social(grabarActRecibo.getNombre_Razon_Social())
                    .codigo_Solicitud(grabarActRecibo.getCodigo_Solicitud())
                    .ucm_Id(grabarActRecibo.getUcm_Id())
                    .codigo_Procedimiento_Tupa(grabarActRecibo.getCodigo_Procedimiento_Tupa())
                    .nume_Regi_Arc(grabarActRecibo.getNume_Regi_Arc())
                    .orden_Vuce(grabarActRecibo.getOrden_Vuce())
                    .canal(grabarActRecibo.getCanal())
                    .codigo_Std_Doc(grabarActRecibo.getCodigo_Std_Doc())
                    .numero_Folios(grabarActRecibo.getNumero_Folios())
                    .confidencial(grabarActRecibo.getConfidencial())
                    .codigo_Tupa(grabarActRecibo.getCodigo_Tupa())
                    .cod_Formato(grabarActRecibo.getCod_Formato())
                    .estado(grabarActRecibo.getEstado())
                    .estado_expediente(grabarActRecibo.getEstado_expediente())
                    .tipo_certificado(grabarActRecibo.getTipo_certificado())
                    .oea_tipo_operador(grabarActRecibo.getOea_tipo_operador())
                    .oea_tipo_atencion(grabarActRecibo.getOea_tipo_atencion())
                    .build();

            response.add(grabarActReciboResponse);
        }
        return response;
    }
    @Override
    public String validarBoleta(ValidarBoletaRequest request) {
        return grabarDao.validarBoleta(request);
    }
    @Override
    public List<ValidarExpedienteResponse> validarExpediente (String pcodexpediente) {
        List<ValidarExpedienteBean> expedienteBean = grabarDao.validarExpediente(pcodexpediente);
        List<ValidarExpedienteResponse> response = new ArrayList<>();

        for (ValidarExpedienteBean bean : expedienteBean) {
            ValidarExpedienteResponse requisitoResponse = ValidarExpedienteResponse.builder()
                    .pcerrado(bean.getPcerrado())
                    .pmensaje(bean.getPmensaje())
                    .build();
            response.add(requisitoResponse);
        }
        return response;
    }
    @Override
    public String agregarPersona(AgregarPersonaRequest request) {
        return grabarDao.agregarPersona(request);
    }
    
}