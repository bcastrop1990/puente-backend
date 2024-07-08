package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.*;
import com.senasa.bpm.ng.model.request.*;
import com.senasa.bpm.ng.model.response.ValidarExpedienteResponse;

import java.util.List;

public interface GrabarDao {

    List<GrabarBean> grabarSolicitud (GrabarSolRequest request);
    List<GrabarInactivoBean> grabarInactivo (GrabarInactivoRequest request);
    String servicioAdicional(ServicioAdicionalRequest request);
    List<GrabarActReciboBean> grabarActRecibo (GrabarActReciboRequest request);
    String validarBoleta(ValidarBoletaRequest request);
    List<ValidarExpedienteBean> validarExpediente (String pcodexpediente);

    java.sql.Date convertirStringADate(String fecha);

    String agregarPersona(AgregarPersonaRequest request);

}
