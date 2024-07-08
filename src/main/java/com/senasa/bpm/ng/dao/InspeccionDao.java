package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.DerivacionPersonalBean;
import com.senasa.bpm.ng.model.bean.DocuResolutivoBean;
import com.senasa.bpm.ng.model.response.InspeccionResponse;

import java.util.List;

public interface InspeccionDao {

    List<InspeccionResponse> listarTipoEnvase (String tipoEnvase);

}
