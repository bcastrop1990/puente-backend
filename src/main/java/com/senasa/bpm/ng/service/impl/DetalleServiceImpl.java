package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.dao.AreaDao;
import com.senasa.bpm.ng.dao.ProcedimientoDao;
import com.senasa.bpm.ng.model.bean.AreaBean;
import com.senasa.bpm.ng.model.bean.ProcedimientoBean;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import com.senasa.bpm.ng.model.response.AreaResponse;
import com.senasa.bpm.ng.model.response.ProcedimientoResponse;
import com.senasa.bpm.ng.service.DetalleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DetalleServiceImpl implements DetalleService {

    private AreaDao areaDao;
    private ProcedimientoDao procedimientoDao;

    @Override
    public List<AreaResponse> listarArea() {
        List<AreaBean> areaBean = areaDao.listarArea();
        List<AreaResponse> response = new ArrayList<>();

        for (AreaBean area : areaBean) {
            AreaResponse areaResponse = AreaResponse.builder()
                    .codigo_Area_Gestion(area.getCodigo_Area_Gestion())
                    .descripcion_Area_Gestion(area.getDescripcion_Area_Gestion())
                    .codigo_Clase(area.getCodigo_Clase())
                    .build();
            response.add(areaResponse);
        }
        return response;
    }

    @Override
    public List<ProcedimientoResponse> listarProcedimiento(ProcedimientoRequest request) {
        List<ProcedimientoBean> procedimientoBean = procedimientoDao.listarProcedimiento(request);
        List<ProcedimientoResponse> response = new ArrayList<>();

        for (ProcedimientoBean procedimiento : procedimientoBean) {
            ProcedimientoResponse procedimientoResponse = ProcedimientoResponse.builder()
                    .codigo_Procedimiento_Tupa(procedimiento.getCodigo_Procedimiento_Tupa())
                    .descripcion_Procedimieto_Tupa(procedimiento.getDescripcion_Procedimieto_Tupa())
                    .indicador_Procedimiento_Espe(procedimiento.getIndicador_Procedimiento_Espe())
                    .build();
            response.add(procedimientoResponse);
        }
        return response;
    }

}



