package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import com.senasa.bpm.ng.model.response.AreaResponse;
import com.senasa.bpm.ng.model.response.ProcedimientoResponse;

import java.util.List;

public interface DetalleService {


    List<AreaResponse> listarArea();
    List<ProcedimientoResponse> listarProcedimiento(ProcedimientoRequest request);

}
