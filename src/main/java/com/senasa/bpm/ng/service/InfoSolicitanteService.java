package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.request.DniVuceRequest;

import com.senasa.bpm.ng.model.request.PersonaPorDocumentoResponse;
import com.senasa.bpm.ng.model.response.PersonaPorDocVuceResponse;

import java.util.List;

public interface InfoSolicitanteService {


    List<PersonaPorDocVuceResponse> obtenerPeronaPorDocVuce(DniVuceRequest request);
    List<PersonaPorDocumentoResponse> obtenerPersonaPorDocumento(DniVuceRequest request);

}
