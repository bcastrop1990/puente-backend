package com.senasa.bpm.ng.service;

import java.util.List;

import com.senasa.bpm.ng.model.bean.DerivacionTraza;
import com.senasa.bpm.ng.model.response.TrazabilidadResponse;

public interface TrazabilidadService {

    List<TrazabilidadResponse> obtenerDetalleTrazabilidad (String pidfinal);
    void insertarDerivar(DerivacionTraza trazabilidad);

}
