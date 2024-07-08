package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.ProcedimientoBean;
import com.senasa.bpm.ng.model.request.ProcedimientoRequest;

import java.util.List;

public interface ProcedimientoDao {

    List<ProcedimientoBean> listarProcedimiento (ProcedimientoRequest request);
}
