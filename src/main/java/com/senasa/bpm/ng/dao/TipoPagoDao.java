package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.BancoBean;
import com.senasa.bpm.ng.model.bean.TipoPagoBean;

import java.util.List;

public interface TipoPagoDao {

    List<TipoPagoBean> listarTipoPago();
}
