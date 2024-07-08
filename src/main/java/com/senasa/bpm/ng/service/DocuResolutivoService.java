package com.senasa.bpm.ng.service;

import java.util.List;

import com.senasa.bpm.ng.model.request.GrabarDocHijoRequest;
import com.senasa.bpm.ng.model.request.GrabarDocumentoSTDRequest;
import com.senasa.bpm.ng.model.request.GrabarObservacionRequest;
import com.senasa.bpm.ng.model.request.GrabarResolutivoCierreRequest;
import com.senasa.bpm.ng.model.request.GrabarResolutivoRequest;
import com.senasa.bpm.ng.model.request.RegistrarFirmaEmpleadoRequest;
import com.senasa.bpm.ng.model.response.AgregarDocuResponse;
import com.senasa.bpm.ng.model.response.DerivacionPersonalResponse;
import com.senasa.bpm.ng.model.response.DetalleDerivacionResponse;
import com.senasa.bpm.ng.model.response.FirmarCerrarExpedienteResponse;
import com.senasa.bpm.ng.model.response.GrabarDocHijoResponse;
import com.senasa.bpm.ng.model.response.GrabarDocumentoSTDResponse;
import com.senasa.bpm.ng.model.response.GrabarResolutivoCierreResponse;
import com.senasa.bpm.ng.model.response.GrabarResolutivoResponse;
import com.senasa.bpm.ng.model.response.InformacionExpedienteResponse;
import com.senasa.bpm.ng.model.response.ObtenerDocuResponse;
import com.senasa.bpm.ng.model.response.ObtenerInfoAdjuntosResponse;
import com.senasa.bpm.ng.model.response.ReqDocSalidaResponse;
import com.senasa.bpm.ng.model.response.ValidarExpedienteResponse;
import com.senasa.bpm.ng.model.response.ValidarPendientePagoResponse;

public interface DocuResolutivoService {

  List<DerivacionPersonalResponse> listarPersona(String nombrePersona);

  List<DetalleDerivacionResponse> listarDetalleDerivacion (String pcodexpediente);

  List<AgregarDocuResponse> listarDocumento(String documentoResolutivo);

  List<ObtenerDocuResponse> obtenerDocumentoPresen(String documentoPresen);
  List<InformacionExpedienteResponse> obtenerCodigoExpediente(String p_Codigo_Expediente);
  List<FirmarCerrarExpedienteResponse> firmarCerrarExpediente(String codexpediente);
  //List<GrabarObservacionResponse> grabarObservacion (GrabarObservacionRequest request);
  String grabarObservacion(GrabarObservacionRequest request);
  List<GrabarDocHijoResponse> grabarDocHijo(GrabarDocHijoRequest request);
  List<GrabarResolutivoResponse> grabarResolutivo(GrabarResolutivoRequest request);
  List<GrabarResolutivoCierreResponse> grabarResolutivoCierre(GrabarResolutivoCierreRequest request);
  List<ObtenerInfoAdjuntosResponse> obtenerInfoAdjuntos(String p_ucmid);
  List<ReqDocSalidaResponse> reqDocSalida(String pcodexpediente);
  List<GrabarDocumentoSTDResponse> grabarDocumentoSTD(GrabarDocumentoSTDRequest request);
  String registrarFirmaEmpleado(String pcodigoexpediente, String codigoemplper);
  List<ValidarPendientePagoResponse> validarPendientePago (String codigoexpediente);
  String registrarFirmaEmpleados(RegistrarFirmaEmpleadoRequest request);
}

