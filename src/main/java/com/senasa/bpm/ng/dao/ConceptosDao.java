package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.ListarProcedimientoBean;
import com.senasa.bpm.ng.model.bean.RepresentanteLegalBean;
import com.senasa.bpm.ng.model.bean.TipoDocumentoBean;
import com.senasa.bpm.ng.model.request.ListarProcedimientoRequest;

import java.util.List;

public interface ConceptosDao {

    List<ListarProcedimientoBean> listarServicios (ListarProcedimientoRequest request);

}
