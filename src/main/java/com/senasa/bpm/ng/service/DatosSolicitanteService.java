package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.bean.GrabarInactivoBean;
import com.senasa.bpm.ng.model.bean.ListarProcedimientoBean;
import com.senasa.bpm.ng.model.request.GrabarActReciboRequest;
import com.senasa.bpm.ng.model.request.GrabarInactivoRequest;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
import com.senasa.bpm.ng.model.response.*;

import java.util.List;

public interface DatosSolicitanteService {


    List<TipoDocumentoResponse> listarTipodocumento();
    List<RepresentanteLegalResponse> listarRepresentanteLegal (String representanteLegal);



}
