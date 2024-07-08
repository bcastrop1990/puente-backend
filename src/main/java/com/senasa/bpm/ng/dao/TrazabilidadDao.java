package com.senasa.bpm.ng.dao;

import java.util.List;

import com.senasa.bpm.ng.model.bean.DerivacionTraza;
import com.senasa.bpm.ng.model.request.TrazabilidadRequest;
import com.senasa.bpm.ng.model.response.TrazabilidadResponse;

public interface TrazabilidadDao {

    List<TrazabilidadResponse> listarDocumentoExpediente (String pidfinal);
    void insertarDerivar(DerivacionTraza trazabilidad);
}
