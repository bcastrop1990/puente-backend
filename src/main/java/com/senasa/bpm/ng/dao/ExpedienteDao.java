package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.ExpedienteBean;
import com.senasa.bpm.ng.model.request.ExpedienteRequest;

public interface ExpedienteDao {

	public ExpedienteBean buscarExpediente (ExpedienteRequest request);
	//public ExpedienteTrazabilidadResponse grabarTrazabilidadExpediente (ExpedienteTrazabilidadRequest request);
}
