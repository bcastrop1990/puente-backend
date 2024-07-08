package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import com.senasa.bpm.ng.model.response.BancoResponse;
import com.senasa.bpm.ng.model.response.TipoPagoResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ConceptoPagoService {


    List<BancoResponse> listarBanco();
    List<TipoPagoResponse> listarTipoPago();
    BigDecimal calcularMontoConcepto(CalcularMontoRequest request);
    String calcularMontoMinimo(CalcularMontoRequest request);

}
