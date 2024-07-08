package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.DerivacionPersonalBean;
import com.senasa.bpm.ng.model.bean.DocuResolutivoBean;
import com.senasa.bpm.ng.model.bean.PersonaBean;
import com.senasa.bpm.ng.model.request.DniVuceRequest;

import java.util.List;

public interface InfoSolicitanteDao {

    List<PersonaBean> obtenerPeronaPorDocVuce (DniVuceRequest request);
    List<PersonaBean> obtenerPersonaPorDocumento(DniVuceRequest request);

}
