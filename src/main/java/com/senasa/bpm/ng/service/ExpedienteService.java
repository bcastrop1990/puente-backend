package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.request.ExpedienteRequest;
import com.senasa.bpm.ng.model.response.ExpedienteResponse;

public interface ExpedienteService {
	public ExpedienteResponse buscarExpediente(ExpedienteRequest request);
	//public ExpedienteTrazabilidadResponse grabarTrazabilidadExpediente(ExpedienteTrazabilidadRequest request);
}
