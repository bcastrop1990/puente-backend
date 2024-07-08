package com.senasa.bpm.ng.service.impl;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.senasa.bpm.ng.dao.TrazabilidadDao;
import com.senasa.bpm.ng.model.bean.DerivacionTraza;
import com.senasa.bpm.ng.model.request.TrazabilidadRequest;
import com.senasa.bpm.ng.model.response.TrazabilidadResponse;
import com.senasa.bpm.ng.service.TrazabilidadService;

@Service
@AllArgsConstructor
@Slf4j
public class TrazabilidadServiceImpl implements TrazabilidadService {

    private TrazabilidadDao trazabilidadDao;


    @Override
    public List<TrazabilidadResponse> obtenerDetalleTrazabilidad (String pidfinal) {
        return trazabilidadDao.listarDocumentoExpediente(pidfinal);
    }
    
    public void insertarDerivar(DerivacionTraza trazabilidad) {
    	trazabilidadDao.insertarDerivar(trazabilidad);
    }

}



