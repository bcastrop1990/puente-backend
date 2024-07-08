package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.BancoBean;
import com.senasa.bpm.ng.model.bean.TipoPagoBean;
import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;

import java.math.BigDecimal;
import java.util.List;

public interface PagoDao {

    List<TipoPagoBean> listarTipoPago();
    List<BancoBean> listarBanco();
    BigDecimal calcularMontoConcepto(CalcularMontoRequest request);
    String calcularMontoMinimo(CalcularMontoRequest request);

}
