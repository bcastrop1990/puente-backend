package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
import com.senasa.bpm.ng.model.response.ListarServiciosResponse;
import com.senasa.bpm.ng.model.response.ObservacionResponse;

import java.util.List;

public interface ObservacionService {

    List<ObservacionResponse> obtenerListaHistorico ( String  pcodexpediente);


}
