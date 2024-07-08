package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.dao.ObservacionDao;
import com.senasa.bpm.ng.dao.RequisitoDao;
import com.senasa.bpm.ng.model.bean.ArchivarBean;
import com.senasa.bpm.ng.model.bean.ObservacionBean;
import com.senasa.bpm.ng.model.bean.RequisitoBean;
import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.response.ArchivarResponse;
import com.senasa.bpm.ng.model.response.ObservacionResponse;
import com.senasa.bpm.ng.service.ObservacionService;
import com.senasa.bpm.ng.service.RequisitoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ObservacionServiceImpl implements ObservacionService {

    private ObservacionDao observacionDao;

    @Override
    public List<ObservacionResponse> obtenerListaHistorico(String observaciones) {
        List<ObservacionBean> observacionBean = observacionDao.obtenerListaHistorico(observaciones);
        List<ObservacionResponse> response = new ArrayList<>();

        for (ObservacionBean observacion : observacionBean) {
            ObservacionResponse observacionResponse = ObservacionResponse.builder()
                    .fecha_Hora(observacion.getFecha_Hora())
                    .notas(observacion.getNotas())
                    .remitente_Entidad(observacion.getRemitente_Entidad())
                    .urgencia(observacion.getUrgencia())
                    .ucm_id(observacion.getUcm_id())
                    .build();
            response.add(observacionResponse);
        }
        return response;
    }




}



