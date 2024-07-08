package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.dao.PagoDao;
import com.senasa.bpm.ng.model.bean.BancoBean;
import com.senasa.bpm.ng.model.bean.TipoPagoBean;
import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import com.senasa.bpm.ng.model.response.BancoResponse;
import com.senasa.bpm.ng.model.response.TipoPagoResponse;
import com.senasa.bpm.ng.service.ConceptoPagoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ConceptoPagoServiceImpl implements ConceptoPagoService {

    private PagoDao pagoDao;

    @Override
    public List<BancoResponse> listarBanco() {
        List<BancoBean> bancoBean = pagoDao.listarBanco();
        List<BancoResponse> response = new ArrayList<>();

        for (BancoBean banco : bancoBean) {
            BancoResponse bancoResponse = BancoResponse.builder()
                    .codigo_Cta_Cte(banco.getCodigo_Cta_Cte())
                    .nombre_Banco(banco.getNombre_Banco())
                    .numero_Cta(banco.getNumero_Cta())
                    .nombre(banco.getNombre())
                    .build();
            response.add(bancoResponse);
        }
        return response;
    }
    @Override
    public List<TipoPagoResponse> listarTipoPago() {
        List<TipoPagoBean> tipoPagoBean = pagoDao.listarTipoPago();
        List<TipoPagoResponse> response = new ArrayList<>();

        for (TipoPagoBean tipoPago : tipoPagoBean) {
            TipoPagoResponse tipoPagoResponse = TipoPagoResponse.builder()
                    .codigo_Tipo_Pago(tipoPago.getCodigo_Tipo_Pago())
                    .descripcion_Tipo_Pago(tipoPago.getDescripcion_Tipo_Pago())
                    .build();
            System.out.println("ESTE ES EL DDDDDDD: "+tipoPago.getCodigo_Tipo_Pago());
            System.out.println("ESTE ES EL DDDDDDD222222: "+tipoPago.getDescripcion_Tipo_Pago());
            response.add(tipoPagoResponse);
        }
        return response;
    }
    @Override
    public BigDecimal calcularMontoConcepto(CalcularMontoRequest request) {
        return pagoDao.calcularMontoConcepto(request);
    }
    @Override
    public String calcularMontoMinimo(CalcularMontoRequest request) {
        return pagoDao.calcularMontoMinimo(request);
    }
}







