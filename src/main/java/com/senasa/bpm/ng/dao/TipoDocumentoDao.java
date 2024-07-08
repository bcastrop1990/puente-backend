package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.ListarProcedimientoBean;
import com.senasa.bpm.ng.model.bean.RepresentanteLegalBean;
import com.senasa.bpm.ng.model.bean.TipoDocumentoBean;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;
import com.senasa.bpm.ng.model.response.RepresentanteLegalResponse;

import java.util.List;

public interface TipoDocumentoDao {

    List<TipoDocumentoBean> listarTipoDocumento ();
    List<RepresentanteLegalBean> listarRepresentanteLegal (String repreLegal);
}
