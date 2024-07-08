package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
import com.senasa.bpm.ng.model.response.BancoResponse;
import com.senasa.bpm.ng.model.response.ListarServiciosResponse;
import com.senasa.bpm.ng.model.response.TipoPagoResponse;

import java.util.List;

public interface ConceptosService {

    List<ListarServiciosResponse> listarServicios (ListarProcedimientoRequest request);


}
