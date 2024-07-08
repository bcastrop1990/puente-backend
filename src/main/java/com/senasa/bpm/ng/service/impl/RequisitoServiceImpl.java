package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.dao.AreaDao;
import com.senasa.bpm.ng.dao.ProcedimientoDao;
import com.senasa.bpm.ng.dao.RequisitoDao;
import com.senasa.bpm.ng.model.bean.*;
import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.FinalizarProcesoRequest;
import com.senasa.bpm.ng.model.request.GrabarActReciboRequest;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import com.senasa.bpm.ng.model.response.*;
import com.senasa.bpm.ng.service.DetalleService;
import com.senasa.bpm.ng.service.RequisitoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RequisitoServiceImpl implements RequisitoService {

    private RequisitoDao requisitoDao;

    @Override
    public List<RequisitoResponse> listarRequisitos(String pcodexpediente) {
        List<RequisitoBean> requisitoBean = requisitoDao.listarRequisitos(pcodexpediente);
        List<RequisitoResponse> response = new ArrayList<>();

        for (RequisitoBean bean : requisitoBean) {
            RequisitoResponse requisitoResponse = RequisitoResponse.builder()
                    .codigo_Servicio(bean.getCodigo_Servicio())
                    .descripcion_Servicio(bean.getDescripcion_Servicio())
                    .codigo_Documento(bean.getCodigo_Documento())
                    .descripcion_Documento(bean.getDescripcion_Documento())
                    .Indicador_Obligatorio(bean.getIndicador_Obligatorio())
                    .sub_Tipo(bean.getSub_Tipo())
                    .ruta_Check_In(bean.getRuta_Check_In())
                    .build();
            response.add(requisitoResponse);
        }
        return response;
    }

    @Override
    public List<ArchivarResponse> archivar(ArchivarRequest request) {
        List<ArchivarBean> archivoBean = requisitoDao.archivar(request);
        List<ArchivarResponse> response = new ArrayList<>();

        for (ArchivarBean grabarActRecibo : archivoBean) {
            ArchivarResponse grabarActReciboResponse = ArchivarResponse.builder()
                    .pareadestinatario(grabarActRecibo.getPareadestinatario())
                    .psubareadestinatario(grabarActRecibo.getPsubareadestinatario())
                    .parearemitente(grabarActRecibo.getParearemitente())
                    .psubarearemitente(grabarActRecibo.getPsubarearemitente())
                    .psecuencial(grabarActRecibo.getPsecuencial())
                    .urgencia(grabarActRecibo.getUrgencia())
                    .codigo_Servicio(grabarActRecibo.getCodigo_Servicio())
                    .descripcion_Servicio(grabarActRecibo.getDescripcion_Servicio())
                    .nombre_Corto_Servicio(grabarActRecibo.getNombre_Corto_Servicio())
                    .estado(grabarActRecibo.getEstado())
                    .codigo_Clase(grabarActRecibo.getCodigo_Clase())
                    .descripcion_Clase(grabarActRecibo.getDescripcion_Clase())
                    .codigo_Tipo_Servicio(grabarActRecibo.getCodigo_Tipo_Servicio())
                    .descripcion_Tipo_Servicio(grabarActRecibo.getDescripcion_Tipo_Servicio())
                    .autoridad_Aprueba(grabarActRecibo.getAutoridad_Aprueba())
                    .autoridad_Resuelve(grabarActRecibo.getAutoridad_Resuelve())
                    .build();


            response.add(grabarActReciboResponse);
        }
        return response;
    }

    @Override
    public String actualizarDocumentoHijo(String pnombrestd, String pucmid) {
        return requisitoDao.actualizarDocumentoHijo(pnombrestd, pucmid);
    }

    @Override
    public String finalizarProceso(FinalizarProcesoRequest request) {
        return requisitoDao.finalizarProceso(request);
    }

}



