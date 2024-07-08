package com.senasa.bpm.ng.dao;

import java.util.List;


import com.senasa.bpm.ng.model.bean.AgregarDocuBean;
import com.senasa.bpm.ng.model.bean.ArchivarBean;
import com.senasa.bpm.ng.model.bean.DerivacionPersonalBean;
import com.senasa.bpm.ng.model.bean.DetalleDerivacionBean;
import com.senasa.bpm.ng.model.bean.FirmarCerrarExpedienteBean;
import com.senasa.bpm.ng.model.bean.GrabarBean;
import com.senasa.bpm.ng.model.bean.GrabarDocHijoBean;
import com.senasa.bpm.ng.model.bean.GrabarDocumentoSTDBean;
import com.senasa.bpm.ng.model.bean.GrabarResolutivoBean;
import com.senasa.bpm.ng.model.bean.GrabarResolutivoCierreBean;
import com.senasa.bpm.ng.model.bean.InformacionExpedienteBean;
import com.senasa.bpm.ng.model.bean.ObtenerDocuBean;
import com.senasa.bpm.ng.model.bean.ObtenerInfoAdjuntosBean;
import com.senasa.bpm.ng.model.bean.ReqDocSalidaBean;
import com.senasa.bpm.ng.model.bean.ValidarExpedienteBean;
import com.senasa.bpm.ng.model.bean.ValidarPendientePagoBean;
import com.senasa.bpm.ng.model.request.ArchivarRequest;
import com.senasa.bpm.ng.model.request.GrabarDocHijoRequest;
import com.senasa.bpm.ng.model.request.GrabarDocumentoSTDRequest;
import com.senasa.bpm.ng.model.request.GrabarObservacionRequest;
import com.senasa.bpm.ng.model.request.GrabarResolutivoCierreRequest;
import com.senasa.bpm.ng.model.request.GrabarResolutivoRequest;
import com.senasa.bpm.ng.model.request.GrabarSolRequest;
import com.senasa.bpm.ng.model.request.RegistrarFirmaEmpleadoRequest;

public interface DocuResolutivoDao {

  List<DerivacionPersonalBean> listarPersona (String personalSenasa);
  List<DetalleDerivacionBean> listarDetalleDerivacion (String pcodexpediente);

  List<AgregarDocuBean> listarDocumento (String documentoResolutivo);
  List<ObtenerDocuBean> obtenerDocumentoPresen (String documentoPresen);
  List<InformacionExpedienteBean> obtenerCodigoExpediente(String p_Codigo_Expediente);
  List<FirmarCerrarExpedienteBean> firmarCerrarExpediente(String codexpediente);
  //List<GrabarObservacionBean> grabarObservacion (GrabarObservacionRequest request);
  String grabarObservacion (GrabarObservacionRequest request);
  List<GrabarDocHijoBean> grabarDocHijo(GrabarDocHijoRequest request);
  List<GrabarResolutivoBean> grabarResolutivo(GrabarResolutivoRequest request);
  List<GrabarResolutivoCierreBean> grabarResolutivoCierre(GrabarResolutivoCierreRequest request);
  List<ObtenerInfoAdjuntosBean> obtenerInfoAdjuntos (String p_ucmid);
  List<ReqDocSalidaBean> reqDocSalida (String pcodexpediente);
  List<GrabarDocumentoSTDBean> grabarDocumentoSTD(GrabarDocumentoSTDRequest request);
  String registrarFirmaEmpleado(String pcodigoexpediente, String codigoemplper);
  List<ValidarPendientePagoBean> validarPendientePago (String codigoexpediente);
  String registrarFirmaEmpleados (RegistrarFirmaEmpleadoRequest request);
}
