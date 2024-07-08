package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.ArchivarBean;
import com.senasa.bpm.ng.model.bean.AreaBean;
import com.senasa.bpm.ng.model.bean.RequisitoBean;
import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.FinalizarProcesoRequest;
import com.senasa.bpm.ng.model.response.ArchivarResponse;
import com.senasa.bpm.ng.model.response.RequisitoResponse;

import java.util.List;

public interface RequisitoDao {

    List<RequisitoBean> listarRequisitos(String pcodexpediente);
    List<ArchivarBean> archivar(ArchivarRequest request);
    String actualizarDocumentoHijo(String pnombrestd, String pucmid);
    String finalizarProceso(FinalizarProcesoRequest request);

}
