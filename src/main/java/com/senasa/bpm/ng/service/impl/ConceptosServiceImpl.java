package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.dao.ConceptosDao;
import com.senasa.bpm.ng.dao.PagoDao;
import com.senasa.bpm.ng.dao.ProcedimientoDao;
import com.senasa.bpm.ng.model.bean.BancoBean;
import com.senasa.bpm.ng.model.bean.ListarProcedimientoBean;
import com.senasa.bpm.ng.model.bean.TipoPagoBean;
import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
import com.senasa.bpm.ng.model.response.BancoResponse;
import com.senasa.bpm.ng.model.response.ListarServiciosResponse;
import com.senasa.bpm.ng.model.response.TipoPagoResponse;
import com.senasa.bpm.ng.service.ConceptoPagoService;
import com.senasa.bpm.ng.service.ConceptosService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ConceptosServiceImpl implements ConceptosService {

    private ConceptosDao conceptosDao;


    @Override
    public List<ListarServiciosResponse> listarServicios(ListarProcedimientoRequest request) {
        List<ListarProcedimientoBean> listarProcedimientoBean = conceptosDao.listarServicios(request);
        List<ListarServiciosResponse> response = new ArrayList<>();

        for (ListarProcedimientoBean listProcedimiento : listarProcedimientoBean) {
            ListarServiciosResponse listarProcedimientoResponse = ListarServiciosResponse.builder()
                    .codigo_Servicio_Tupa(listProcedimiento.getCodigo_Servicio_Tupa())
                    .descripcion_Servicio(listProcedimiento.getDescripcion_Servicio())
                    .indicador_Otro(listProcedimiento.getIndicador_Otro())
                    .tipo_Servicio(listProcedimiento.getTipo_Servicio())
                    .build();
            response.add(listarProcedimientoResponse);
        }
        return response;
    }
}







