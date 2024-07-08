package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.response.ArchivarResponse;
import com.senasa.bpm.ng.model.response.RequisitoResponse;

import java.math.BigDecimal;
import java.util.List;

public interface SeguridadService {

    BigDecimal validarConexion(String p_Usuario, String p_Password);


}
