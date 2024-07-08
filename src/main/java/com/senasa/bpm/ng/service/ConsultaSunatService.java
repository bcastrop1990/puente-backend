package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.response.PersonaResponse;
import org.apache.axis.NoEndPointException;

import java.util.List;

public interface ConsultaSunatService {


    List<PersonaResponse> consultaSunat(String ruc) throws NoEndPointException;

}
