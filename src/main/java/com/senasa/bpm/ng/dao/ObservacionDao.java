package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.ArchivarBean;
import com.senasa.bpm.ng.model.bean.ObservacionBean;
import com.senasa.bpm.ng.model.bean.RequisitoBean;
import com.senasa.bpm.ng.model.request.ArchivarRequest;

import java.util.List;

public interface ObservacionDao {

    List<ObservacionBean> obtenerListaHistorico (String pcodexpediente);
}
