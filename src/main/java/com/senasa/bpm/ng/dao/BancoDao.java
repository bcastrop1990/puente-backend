package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.AreaBean;
import com.senasa.bpm.ng.model.bean.BancoBean;
import com.senasa.bpm.ng.model.bean.TipoPagoBean;

import java.util.List;

public interface BancoDao {

    List<BancoBean> listarBanco();

}
