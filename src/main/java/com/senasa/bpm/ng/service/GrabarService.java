package com.senasa.bpm.ng.service;

import com.senasa.bpm.ng.model.request.*;
import com.senasa.bpm.ng.model.response.*;

import java.util.List;

public interface GrabarService {

    List<GrabarSolicitudResponse> grabarSolicitud(GrabarSolRequest request);
    List<GrabarInactivoResponse> grabarInactivo(GrabarInactivoRequest request);
    String servicioAdicional(ServicioAdicionalRequest request);
    List<GrabarActReciboResponse> grabarActRecibo(GrabarActReciboRequest request);
    String validarBoleta(ValidarBoletaRequest request);
    List<ValidarExpedienteResponse> validarExpediente (String pcodexpediente);
    String agregarPersona(AgregarPersonaRequest request);

}
