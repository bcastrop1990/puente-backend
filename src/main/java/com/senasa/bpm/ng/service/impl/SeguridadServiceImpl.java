package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.dao.InfoSolicitanteDao;
import com.senasa.bpm.ng.dao.SeguridadDao;
import com.senasa.bpm.ng.model.bean.PersonaBean;
import com.senasa.bpm.ng.model.request.CalcularMontoRequest;
import com.senasa.bpm.ng.model.request.DniVuceRequest;
import com.senasa.bpm.ng.model.request.PersonaPorDocumentoResponse;
import com.senasa.bpm.ng.model.response.PersonaPorDocVuceResponse;
import com.senasa.bpm.ng.service.InfoSolicitanteService;
import com.senasa.bpm.ng.service.SeguridadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SeguridadServiceImpl implements SeguridadService {

   private SeguridadDao seguridadDao;

    @Override
    public BigDecimal validarConexion(String p_Usuario, String p_Password) {
        return seguridadDao.validarConexion(p_Usuario, p_Password);
    }
}



