package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.FinalizarProcesoRequest;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;
import com.senasa.bpm.ng.model.response.ArchivarResponse;
import com.senasa.bpm.ng.model.response.AreaResponse;
import com.senasa.bpm.ng.model.response.ProcedimientoResponse;
import com.senasa.bpm.ng.model.response.RequisitoResponse;

import java.util.List;

public interface RequisitoService {


    List<RequisitoResponse> listarRequisitos(String pcodexpediente);
    List<ArchivarResponse> archivar(ArchivarRequest request);
    String actualizarDocumentoHijo(String pnombrestd, String pucmid);
    String finalizarProceso(FinalizarProcesoRequest request);

}
