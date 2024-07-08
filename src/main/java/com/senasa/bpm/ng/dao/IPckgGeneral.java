package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.controller.mapper.PckgGeneral;

import java.sql.Connection;
import java.util.Map;

public interface IPckgGeneral {

    PckgGeneral.EnvaseListarParam envaseListar(Connection conn, Map map) throws Exception;

    void envaseListar(Connection conn, PckgGeneral.EnvaseListarParam param) throws Exception;

    PckgGeneral.ListarPartidaArancelariaParam listarPartidaArancelaria(Connection conn, Map map) throws Exception;

    void listarPartidaArancelaria(Connection conn, PckgGeneral.ListarPartidaArancelariaParam param) throws Exception;

    PckgGeneral.ProductoBpmGetlistParam productoBpmGetlist(Connection conn, Map map) throws Exception;

    void productoBpmGetlist(Connection conn, PckgGeneral.ProductoBpmGetlistParam param) throws Exception;

    PckgGeneral.SpAreasGestionParam spAreasGestion(Connection conn, Map map) throws Exception;

    void spAreasGestion(Connection conn, PckgGeneral.SpAreasGestionParam param) throws Exception;

    PckgGeneral.SpBuscarPersonaParam spBuscarPersona(Connection conn, Map map) throws Exception;

    void spBuscarPersona(Connection conn, PckgGeneral.SpBuscarPersonaParam param) throws Exception;

    PckgGeneral.SpCalcularXTipoInspeccionParam spCalcularXTipoInspeccion(Connection conn, Map map) throws Exception;

    void spCalcularXTipoInspeccion(Connection conn, PckgGeneral.SpCalcularXTipoInspeccionParam param) throws Exception;

    PckgGeneral.SpCalculoMontoConceptoParam spCalculoMontoConcepto(Connection conn, Map map) throws Exception;

    void spCalculoMontoConcepto(Connection conn, PckgGeneral.SpCalculoMontoConceptoParam param) throws Exception;

    PckgGeneral.SpCalculoMontoConcepto1Param spCalculoMontoConcepto1(Connection conn, Map map) throws Exception;

    void spCalculoMontoConcepto1(Connection conn, PckgGeneral.SpCalculoMontoConcepto1Param param) throws Exception;

    PckgGeneral.SpCentroTramiteParam spCentroTramite(Connection conn, Map map) throws Exception;

    void spCentroTramite(Connection conn, PckgGeneral.SpCentroTramiteParam param) throws Exception;

    PckgGeneral.SpCentroTramitePersonaParam spCentroTramitePersona(Connection conn, Map map) throws Exception;

    void spCentroTramitePersona(Connection conn, PckgGeneral.SpCentroTramitePersonaParam param) throws Exception;

    PckgGeneral.SpCentroTramiteUbigeoParam spCentroTramiteUbigeo(Connection conn, Map map) throws Exception;

    void spCentroTramiteUbigeo(Connection conn, PckgGeneral.SpCentroTramiteUbigeoParam param) throws Exception;

    PckgGeneral.SpConvHospedanteCultivoParam spConvHospedanteCultivo(Connection conn, Map map) throws Exception;

    void spConvHospedanteCultivo(Connection conn, PckgGeneral.SpConvHospedanteCultivoParam param) throws Exception;

    PckgGeneral.SpDocumentosIdentidadParam spDocumentosIdentidad(Connection conn, Map map) throws Exception;

    void spDocumentosIdentidad(Connection conn, PckgGeneral.SpDocumentosIdentidadParam param) throws Exception;

    PckgGeneral.SpEnviarAprobacionrevdocParam spEnviarAprobacionrevdoc(Connection conn, Map map) throws Exception;

    void spEnviarAprobacionrevdoc(Connection conn, PckgGeneral.SpEnviarAprobacionrevdocParam param) throws Exception;

    PckgGeneral.SpEnviarNoejecInspeccionParam spEnviarNoejecInspeccion(Connection conn, Map map) throws Exception;

    void spEnviarNoejecInspeccion(Connection conn, PckgGeneral.SpEnviarNoejecInspeccionParam param) throws Exception;

    PckgGeneral.SpFiltrosBuscarPersonaParam spFiltrosBuscarPersona(Connection conn, Map map) throws Exception;

    void spFiltrosBuscarPersona(Connection conn, PckgGeneral.SpFiltrosBuscarPersonaParam param) throws Exception;

    PckgGeneral.SpGetCodigoDepProvDisParam spGetCodigoDepProvDis(Connection conn, Map map) throws Exception;

    void spGetCodigoDepProvDis(Connection conn, PckgGeneral.SpGetCodigoDepProvDisParam param) throws Exception;

    PckgGeneral.SpGetOrdenPorMtoParam spGetOrdenPorMto(Connection conn, Map map) throws Exception;

    void spGetOrdenPorMto(Connection conn, PckgGeneral.SpGetOrdenPorMtoParam param) throws Exception;

    PckgGeneral.SpGetReportePfiParam spGetReportePfi(Connection conn, Map map) throws Exception;

    void spGetReportePfi(Connection conn, PckgGeneral.SpGetReportePfiParam param) throws Exception;

    PckgGeneral.SpGetReportePfiProdAnexosParam spGetReportePfiProdAnexos(Connection conn, Map map) throws Exception;

    void spGetReportePfiProdAnexos(Connection conn, PckgGeneral.SpGetReportePfiProdAnexosParam param) throws Exception;

    PckgGeneral.SpGetReportePziParam spGetReportePzi(Connection conn, Map map) throws Exception;

    void spGetReportePzi(Connection conn, PckgGeneral.SpGetReportePziParam param) throws Exception;

    PckgGeneral.SpGetReportePziCabeseraParam spGetReportePziCabesera(Connection conn, Map map) throws Exception;

    void spGetReportePziCabesera(Connection conn, PckgGeneral.SpGetReportePziCabeseraParam param) throws Exception;

    PckgGeneral.SpGetReportePziProdAnexosParam spGetReportePziProdAnexos(Connection conn, Map map) throws Exception;

    void spGetReportePziProdAnexos(Connection conn, PckgGeneral.SpGetReportePziProdAnexosParam param) throws Exception;

    PckgGeneral.SpGrabarServicioAdicionalParam spGrabarServicioAdicional(Connection conn, Map map) throws Exception;

    void spGrabarServicioAdicional(Connection conn, PckgGeneral.SpGrabarServicioAdicionalParam param) throws Exception;

    PckgGeneral.SpInfoProcedimientoServicioParam spInfoProcedimientoServicio(Connection conn, Map map) throws Exception;

    void spInfoProcedimientoServicio(Connection conn, PckgGeneral.SpInfoProcedimientoServicioParam param) throws Exception;

    PckgGeneral.SpInspectoresParam spInspectores(Connection conn, Map map) throws Exception;

    void spInspectores(Connection conn, PckgGeneral.SpInspectoresParam param) throws Exception;

    PckgGeneral.SpInspectoresCentroTramiteParam spInspectoresCentroTramite(Connection conn, Map map) throws Exception;

    void spInspectoresCentroTramite(Connection conn, PckgGeneral.SpInspectoresCentroTramiteParam param) throws Exception;

    PckgGeneral.SpInspectoresDepartamentoParam spInspectoresDepartamento(Connection conn, Map map) throws Exception;

    void spInspectoresDepartamento(Connection conn, PckgGeneral.SpInspectoresDepartamentoParam param) throws Exception;

    PckgGeneral.SpInspectoresSedeParam spInspectoresSede(Connection conn, Map map) throws Exception;

    void spInspectoresSede(Connection conn, PckgGeneral.SpInspectoresSedeParam param) throws Exception;

    PckgGeneral.SpInspectoresporubigeoParam spInspectoresporubigeo(Connection conn, Map map) throws Exception;

    void spInspectoresporubigeo(Connection conn, PckgGeneral.SpInspectoresporubigeoParam param) throws Exception;

    PckgGeneral.SpListaAlmacenGcustodiaParam spListaAlmacenGcustodia(Connection conn, Map map) throws Exception;

    void spListaAlmacenGcustodia(Connection conn, PckgGeneral.SpListaAlmacenGcustodiaParam param) throws Exception;

    PckgGeneral.SpListaAnalisisParam spListaAnalisis(Connection conn, Map map) throws Exception;

    void spListaAnalisis(Connection conn, PckgGeneral.SpListaAnalisisParam param) throws Exception;

    PckgGeneral.SpListaAplicacionParam spListaAplicacion(Connection conn, Map map) throws Exception;

    void spListaAplicacion(Connection conn, PckgGeneral.SpListaAplicacionParam param) throws Exception;

    PckgGeneral.SpListaAplicacionProductoParam spListaAplicacionProducto(Connection conn, Map map) throws Exception;

    void spListaAplicacionProducto(Connection conn, PckgGeneral.SpListaAplicacionProductoParam param) throws Exception;

    PckgGeneral.SpListaAreaLaboratorioParam spListaAreaLaboratorio(Connection conn, Map map) throws Exception;

    void spListaAreaLaboratorio(Connection conn, PckgGeneral.SpListaAreaLaboratorioParam param) throws Exception;

    PckgGeneral.SpListaDictamenParam spListaDictamen(Connection conn, Map map) throws Exception;

    void spListaDictamen(Connection conn, PckgGeneral.SpListaDictamenParam param) throws Exception;

    PckgGeneral.SpListaLugarInspeccionParam spListaLugarInspeccion(Connection conn, Map map) throws Exception;

    void spListaLugarInspeccion(Connection conn, PckgGeneral.SpListaLugarInspeccionParam param) throws Exception;

    PckgGeneral.SpListaLugarProduccionParam spListaLugarProduccion(Connection conn, Map map) throws Exception;

    void spListaLugarProduccion(Connection conn, PckgGeneral.SpListaLugarProduccionParam param) throws Exception;

    PckgGeneral.SpListaMotivoParam spListaMotivo(Connection conn, Map map) throws Exception;

    void spListaMotivo(Connection conn, PckgGeneral.SpListaMotivoParam param) throws Exception;

    PckgGeneral.SpListaMotivoTratamientoParam spListaMotivoTratamiento(Connection conn, Map map) throws Exception;

    void spListaMotivoTratamiento(Connection conn, PckgGeneral.SpListaMotivoTratamientoParam param) throws Exception;

    PckgGeneral.SpListaPaisParam spListaPais(Connection conn, Map map) throws Exception;

    void spListaPais(Connection conn, PckgGeneral.SpListaPaisParam param) throws Exception;

    PckgGeneral.SpListaPlagaTratamientoParam spListaPlagaTratamiento(Connection conn, Map map) throws Exception;

    void spListaPlagaTratamiento(Connection conn, PckgGeneral.SpListaPlagaTratamientoParam param) throws Exception;

    PckgGeneral.SpListaProcOrigenMuestraParam spListaProcOrigenMuestra(Connection conn, Map map) throws Exception;

    void spListaProcOrigenMuestra(Connection conn, PckgGeneral.SpListaProcOrigenMuestraParam param) throws Exception;

    PckgGeneral.SpListaProduccionPfiParam spListaProduccionPfi(Connection conn, Map map) throws Exception;

    void spListaProduccionPfi(Connection conn, PckgGeneral.SpListaProduccionPfiParam param) throws Exception;

    PckgGeneral.SpListaRazaParam spListaRaza(Connection conn, Map map) throws Exception;

    void spListaRaza(Connection conn, PckgGeneral.SpListaRazaParam param) throws Exception;

    PckgGeneral.SpListaServAnalisisAnimalParam spListaServAnalisisAnimal(Connection conn, Map map) throws Exception;

    void spListaServAnalisisAnimal(Connection conn, PckgGeneral.SpListaServAnalisisAnimalParam param) throws Exception;

    PckgGeneral.SpListaServAnalisisVegetalParam spListaServAnalisisVegetal(Connection conn, Map map) throws Exception;

    void spListaServAnalisisVegetal(Connection conn, PckgGeneral.SpListaServAnalisisVegetalParam param) throws Exception;

    PckgGeneral.SpListaSexoParam spListaSexo(Connection conn, Map map) throws Exception;

    void spListaSexo(Connection conn, PckgGeneral.SpListaSexoParam param) throws Exception;

    PckgGeneral.SpListaTipoCrianzaParam spListaTipoCrianza(Connection conn, Map map) throws Exception;

    void spListaTipoCrianza(Connection conn, PckgGeneral.SpListaTipoCrianzaParam param) throws Exception;

    PckgGeneral.SpListaTipoEnvaseParam spListaTipoEnvase(Connection conn, Map map) throws Exception;

    void spListaTipoEnvase(Connection conn, PckgGeneral.SpListaTipoEnvaseParam param) throws Exception;

    PckgGeneral.SpListaTipoEspecieAnimalParam spListaTipoEspecieAnimal(Connection conn, Map map) throws Exception;

    void spListaTipoEspecieAnimal(Connection conn, PckgGeneral.SpListaTipoEspecieAnimalParam param) throws Exception;

    PckgGeneral.SpListaTipoIdentificacionParam spListaTipoIdentificacion(Connection conn, Map map) throws Exception;

    void spListaTipoIdentificacion(Connection conn, PckgGeneral.SpListaTipoIdentificacionParam param) throws Exception;

    PckgGeneral.SpListaTipoMuestraAnimalParam spListaTipoMuestraAnimal(Connection conn, Map map) throws Exception;

    void spListaTipoMuestraAnimal(Connection conn, PckgGeneral.SpListaTipoMuestraAnimalParam param) throws Exception;

    PckgGeneral.SpListaTipoMuestraVegetalParam spListaTipoMuestraVegetal(Connection conn, Map map) throws Exception;

    void spListaTipoMuestraVegetal(Connection conn, PckgGeneral.SpListaTipoMuestraVegetalParam param) throws Exception;

    PckgGeneral.SpListaTipoRecintoParam spListaTipoRecinto(Connection conn, Map map) throws Exception;

    void spListaTipoRecinto(Connection conn, PckgGeneral.SpListaTipoRecintoParam param) throws Exception;

    PckgGeneral.SpListaUnidMedProductoParam spListaUnidMedProducto(Connection conn, Map map) throws Exception;

    void spListaUnidMedProducto(Connection conn, PckgGeneral.SpListaUnidMedProductoParam param) throws Exception;

    PckgGeneral.SpListaUnidadMedidaParam spListaUnidadMedida(Connection conn, Map map) throws Exception;

    void spListaUnidadMedida(Connection conn, PckgGeneral.SpListaUnidadMedidaParam param) throws Exception;

    PckgGeneral.SpListarFabricantesParam spListarFabricantes(Connection conn, Map map) throws Exception;

    void spListarFabricantes(Connection conn, PckgGeneral.SpListarFabricantesParam param) throws Exception;

    PckgGeneral.SpListarPartidaArancelariaParam spListarPartidaArancelaria(Connection conn, Map map) throws Exception;

    void spListarPartidaArancelaria(Connection conn, PckgGeneral.SpListarPartidaArancelariaParam param) throws Exception;

    PckgGeneral.SpListarTipoEnvaseParam spListarTipoEnvase(Connection conn, Map map) throws Exception;

    void spListarTipoEnvase(Connection conn, PckgGeneral.SpListarTipoEnvaseParam param) throws Exception;

    PckgGeneral.SpListarUnidadMedidaParam spListarUnidadMedida(Connection conn, Map map) throws Exception;

    void spListarUnidadMedida(Connection conn, PckgGeneral.SpListarUnidadMedidaParam param) throws Exception;

    PckgGeneral.SpMedioTransporteParam spMedioTransporte(Connection conn, Map map) throws Exception;

    void spMedioTransporte(Connection conn, PckgGeneral.SpMedioTransporteParam param) throws Exception;

    PckgGeneral.SpObtenerAdjuntosParam spObtenerAdjuntos(Connection conn, Map map) throws Exception;

    void spObtenerAdjuntos(Connection conn, PckgGeneral.SpObtenerAdjuntosParam param) throws Exception;

    PckgGeneral.SpObtenerAdjuntosVuceParam spObtenerAdjuntosVuce(Connection conn, Map map) throws Exception;

    void spObtenerAdjuntosVuce(Connection conn, PckgGeneral.SpObtenerAdjuntosVuceParam param) throws Exception;

    PckgGeneral.SpObtenerAnalisisCatalServParam spObtenerAnalisisCatalServ(Connection conn, Map map) throws Exception;

    void spObtenerAnalisisCatalServ(Connection conn, PckgGeneral.SpObtenerAnalisisCatalServParam param) throws Exception;

    PckgGeneral.SpObtenerCertParam spObtenerCert(Connection conn, Map map) throws Exception;

    void spObtenerCert(Connection conn, PckgGeneral.SpObtenerCertParam param) throws Exception;

    PckgGeneral.SpObtenerClasesCatalServParam spObtenerClasesCatalServ(Connection conn, Map map) throws Exception;

    void spObtenerClasesCatalServ(Connection conn, PckgGeneral.SpObtenerClasesCatalServParam param) throws Exception;

    PckgGeneral.SpObtenerCodiivExpedienteParam spObtenerCodiivExpediente(Connection conn, Map map) throws Exception;

    void spObtenerCodiivExpediente(Connection conn, PckgGeneral.SpObtenerCodiivExpedienteParam param) throws Exception;

    PckgGeneral.SpObtenerDescDocumentoParam spObtenerDescDocumento(Connection conn, Map map) throws Exception;

    void spObtenerDescDocumento(Connection conn, PckgGeneral.SpObtenerDescDocumentoParam param) throws Exception;

    PckgGeneral.SpObtenerDireccionImpoParam spObtenerDireccionImpo(Connection conn, Map map) throws Exception;

    void spObtenerDireccionImpo(Connection conn, PckgGeneral.SpObtenerDireccionImpoParam param) throws Exception;

    PckgGeneral.SpObtenerEmpresaTratamientoParam spObtenerEmpresaTratamiento(Connection conn, Map map) throws Exception;

    void spObtenerEmpresaTratamiento(Connection conn, PckgGeneral.SpObtenerEmpresaTratamientoParam param) throws Exception;

    PckgGeneral.SpObtenerEntidNombreRucParam spObtenerEntidNombreRuc(Connection conn, Map map) throws Exception;

    void spObtenerEntidNombreRuc(Connection conn, PckgGeneral.SpObtenerEntidNombreRucParam param) throws Exception;

    PckgGeneral.SpObtenerExpedientePermisoParam spObtenerExpedientePermiso(Connection conn, Map map) throws Exception;

    void spObtenerExpedientePermiso(Connection conn, PckgGeneral.SpObtenerExpedientePermisoParam param) throws Exception;

    PckgGeneral.SpObtenerFamiliasCatalServParam spObtenerFamiliasCatalServ(Connection conn, Map map) throws Exception;

    void spObtenerFamiliasCatalServ(Connection conn, PckgGeneral.SpObtenerFamiliasCatalServParam param) throws Exception;

    PckgGeneral.SpObtenerImportadoresParam spObtenerImportadores(Connection conn, Map map) throws Exception;

    void spObtenerImportadores(Connection conn, PckgGeneral.SpObtenerImportadoresParam param) throws Exception;

    PckgGeneral.SpObtenerImportadoresVuceParam spObtenerImportadoresVuce(Connection conn, Map map) throws Exception;

    void spObtenerImportadoresVuce(Connection conn, PckgGeneral.SpObtenerImportadoresVuceParam param) throws Exception;

    PckgGeneral.SpObtenerListaAnalisisParam spObtenerListaAnalisis(Connection conn, Map map) throws Exception;

    void spObtenerListaAnalisis(Connection conn, PckgGeneral.SpObtenerListaAnalisisParam param) throws Exception;

    PckgGeneral.SpObtenerListaAreaParam spObtenerListaArea(Connection conn, Map map) throws Exception;

    void spObtenerListaArea(Connection conn, PckgGeneral.SpObtenerListaAreaParam param) throws Exception;

    PckgGeneral.SpObtenerListaFuncionarioParam spObtenerListaFuncionario(Connection conn, Map map) throws Exception;

    void spObtenerListaFuncionario(Connection conn, PckgGeneral.SpObtenerListaFuncionarioParam param) throws Exception;

    PckgGeneral.SpObtenerListaPrediosParam spObtenerListaPredios(Connection conn, Map map) throws Exception;

    void spObtenerListaPredios(Connection conn, PckgGeneral.SpObtenerListaPrediosParam param) throws Exception;

    PckgGeneral.SpObtenerListaSubAreaParam spObtenerListaSubArea(Connection conn, Map map) throws Exception;

    void spObtenerListaSubArea(Connection conn, PckgGeneral.SpObtenerListaSubAreaParam param) throws Exception;

    PckgGeneral.SpObtenerListaSubTipoDocParam spObtenerListaSubTipoDoc(Connection conn, Map map) throws Exception;

    void spObtenerListaSubTipoDoc(Connection conn, PckgGeneral.SpObtenerListaSubTipoDocParam param) throws Exception;

    PckgGeneral.SpObtenerListaTipoDocParam spObtenerListaTipoDoc(Connection conn, Map map) throws Exception;

    void spObtenerListaTipoDoc(Connection conn, PckgGeneral.SpObtenerListaTipoDocParam param) throws Exception;

    PckgGeneral.SpObtenerListaVacunasParam spObtenerListaVacunas(Connection conn, Map map) throws Exception;

    void spObtenerListaVacunas(Connection conn, PckgGeneral.SpObtenerListaVacunasParam param) throws Exception;

    PckgGeneral.SpObtenerOperadorParam spObtenerOperador(Connection conn, Map map) throws Exception;

    void spObtenerOperador(Connection conn, PckgGeneral.SpObtenerOperadorParam param) throws Exception;

    PckgGeneral.SpObtenerPersonaParam spObtenerPersona(Connection conn, Map map) throws Exception;

    void spObtenerPersona(Connection conn, PckgGeneral.SpObtenerPersonaParam param) throws Exception;

    PckgGeneral.SpObtenerPersonaDocParam spObtenerPersonaDoc(Connection conn, Map map) throws Exception;

    void spObtenerPersonaDoc(Connection conn, PckgGeneral.SpObtenerPersonaDocParam param) throws Exception;

    PckgGeneral.SpObtenerPersonaDocAduanaParam spObtenerPersonaDocAduana(Connection conn, Map map) throws Exception;

    void spObtenerPersonaDocAduana(Connection conn, PckgGeneral.SpObtenerPersonaDocAduanaParam param) throws Exception;

    PckgGeneral.SpObtenerPersonaDocIiParam spObtenerPersonaDocIi(Connection conn, Map map) throws Exception;

    void spObtenerPersonaDocIi(Connection conn, PckgGeneral.SpObtenerPersonaDocIiParam param) throws Exception;

    PckgGeneral.SpObtenerPersonaDocumentoParam spObtenerPersonaDocumento(Connection conn, Map map) throws Exception;

    void spObtenerPersonaDocumento(Connection conn, PckgGeneral.SpObtenerPersonaDocumentoParam param) throws Exception;

    PckgGeneral.SpObtenerPersonaDocumentoWParam spObtenerPersonaDocumentoW(Connection conn, Map map) throws Exception;

    void spObtenerPersonaDocumentoW(Connection conn, PckgGeneral.SpObtenerPersonaDocumentoWParam param) throws Exception;

    PckgGeneral.SpObtenerPersonaDocvuceParam spObtenerPersonaDocvuce(Connection conn, Map map) throws Exception;

    void spObtenerPersonaDocvuce(Connection conn, PckgGeneral.SpObtenerPersonaDocvuceParam param) throws Exception;

    PckgGeneral.SpObtenerPersonaPParam spObtenerPersonaP(Connection conn, Map map) throws Exception;

    void spObtenerPersonaP(Connection conn, PckgGeneral.SpObtenerPersonaPParam param) throws Exception;

    PckgGeneral.SpObtenerPersonaSucDocParam spObtenerPersonaSucDoc(Connection conn, Map map) throws Exception;

    void spObtenerPersonaSucDoc(Connection conn, PckgGeneral.SpObtenerPersonaSucDocParam param) throws Exception;

    PckgGeneral.SpObtenerProdExpedienteParam spObtenerProdExpediente(Connection conn, Map map) throws Exception;

    void spObtenerProdExpediente(Connection conn, PckgGeneral.SpObtenerProdExpedienteParam param) throws Exception;

    PckgGeneral.SpObtenerRepresentanteLegalParam spObtenerRepresentanteLegal(Connection conn, Map map) throws Exception;

    void spObtenerRepresentanteLegal(Connection conn, PckgGeneral.SpObtenerRepresentanteLegalParam param) throws Exception;

    PckgGeneral.SpObtenerSaldoParam spObtenerSaldo(Connection conn, Map map) throws Exception;

    void spObtenerSaldo(Connection conn, PckgGeneral.SpObtenerSaldoParam param) throws Exception;

    PckgGeneral.SpObtenerSolicitanteParam spObtenerSolicitante(Connection conn, Map map) throws Exception;

    void spObtenerSolicitante(Connection conn, PckgGeneral.SpObtenerSolicitanteParam param) throws Exception;

    PckgGeneral.SpObtenerSubproductosParam spObtenerSubproductos(Connection conn, Map map) throws Exception;

    void spObtenerSubproductos(Connection conn, PckgGeneral.SpObtenerSubproductosParam param) throws Exception;

    PckgGeneral.SpObtenerSubtipoDocumentalParam spObtenerSubtipoDocumental(Connection conn, Map map) throws Exception;

    void spObtenerSubtipoDocumental(Connection conn, PckgGeneral.SpObtenerSubtipoDocumentalParam param) throws Exception;

    PckgGeneral.SpObtenerTipoCertificadoParam spObtenerTipoCertificado(Connection conn, Map map) throws Exception;

    void spObtenerTipoCertificado(Connection conn, PckgGeneral.SpObtenerTipoCertificadoParam param) throws Exception;

    PckgGeneral.SpObtenerTipoInspeccionParam spObtenerTipoInspeccion(Connection conn, Map map) throws Exception;

    void spObtenerTipoInspeccion(Connection conn, PckgGeneral.SpObtenerTipoInspeccionParam param) throws Exception;

    PckgGeneral.SpObtenerUbigeoParam spObtenerUbigeo(Connection conn, Map map) throws Exception;

    void spObtenerUbigeo(Connection conn, PckgGeneral.SpObtenerUbigeoParam param) throws Exception;

    PckgGeneral.SpObtenerUbigeoDetalleParam spObtenerUbigeoDetalle(Connection conn, Map map) throws Exception;

    void spObtenerUbigeoDetalle(Connection conn, PckgGeneral.SpObtenerUbigeoDetalleParam param) throws Exception;

    PckgGeneral.SpObtenerUcmIivParam spObtenerUcmIiv(Connection conn, Map map) throws Exception;

    void spObtenerUcmIiv(Connection conn, PckgGeneral.SpObtenerUcmIivParam param) throws Exception;

    PckgGeneral.SpObtenerUcmIivImpoParam spObtenerUcmIivImpo(Connection conn, Map map) throws Exception;

    void spObtenerUcmIivImpo(Connection conn, PckgGeneral.SpObtenerUcmIivImpoParam param) throws Exception;

    PckgGeneral.SpObtenerUcmReciboParam spObtenerUcmRecibo(Connection conn, Map map) throws Exception;

    void spObtenerUcmRecibo(Connection conn, PckgGeneral.SpObtenerUcmReciboParam param) throws Exception;

    PckgGeneral.SpObtenerUcmidSolicitudParam spObtenerUcmidSolicitud(Connection conn, Map map) throws Exception;

    void spObtenerUcmidSolicitud(Connection conn, PckgGeneral.SpObtenerUcmidSolicitudParam param) throws Exception;

    PckgGeneral.SpObtenerUcmidsExpedienteParam spObtenerUcmidsExpediente(Connection conn, Map map) throws Exception;

    void spObtenerUcmidsExpediente(Connection conn, PckgGeneral.SpObtenerUcmidsExpedienteParam param) throws Exception;

    PckgGeneral.SpObtenerVigenciaPermisoParam spObtenerVigenciaPermiso(Connection conn, Map map) throws Exception;

    void spObtenerVigenciaPermiso(Connection conn, PckgGeneral.SpObtenerVigenciaPermisoParam param) throws Exception;

    PckgGeneral.SpObtenerdoctypeucmParam spObtenerdoctypeucm(Connection conn, Map map) throws Exception;

    void spObtenerdoctypeucm(Connection conn, PckgGeneral.SpObtenerdoctypeucmParam param) throws Exception;

    PckgGeneral.SpOperadorLogisticoJuridicoParam spOperadorLogisticoJuridico(Connection conn, Map map) throws Exception;

    void spOperadorLogisticoJuridico(Connection conn, PckgGeneral.SpOperadorLogisticoJuridicoParam param) throws Exception;

    PckgGeneral.SpOperadorLogisticoNaturalParam spOperadorLogisticoNatural(Connection conn, Map map) throws Exception;

    void spOperadorLogisticoNatural(Connection conn, PckgGeneral.SpOperadorLogisticoNaturalParam param) throws Exception;

    PckgGeneral.SpProcedimientoPorAreaParam spProcedimientoPorArea(Connection conn, Map map) throws Exception;

    void spProcedimientoPorArea(Connection conn, PckgGeneral.SpProcedimientoPorAreaParam param) throws Exception;

    PckgGeneral.SpServicioProcedmientoAreaParam spServicioProcedmientoArea(Connection conn, Map map) throws Exception;

    void spServicioProcedmientoArea(Connection conn, PckgGeneral.SpServicioProcedmientoAreaParam param) throws Exception;

    PckgGeneral.SpTipoDocumentoParam spTipoDocumento(Connection conn, Map map) throws Exception;

    void spTipoDocumento(Connection conn, PckgGeneral.SpTipoDocumentoParam param) throws Exception;

    PckgGeneral.SpValidaCodigoParam spValidaCodigo(Connection conn, Map map) throws Exception;

    void spValidaCodigo(Connection conn, PckgGeneral.SpValidaCodigoParam param) throws Exception;

    PckgGeneral.SpValidaCpeParam spValidaCpe(Connection conn, Map map) throws Exception;

    void spValidaCpe(Connection conn, PckgGeneral.SpValidaCpeParam param) throws Exception;

    PckgGeneral.SpValidaDocumentoPresentadoParam spValidaDocumentoPresentado(Connection conn, Map map) throws Exception;

    void spValidaDocumentoPresentado(Connection conn, PckgGeneral.SpValidaDocumentoPresentadoParam param) throws Exception;

    PckgGeneral.SpValidaPermisoParam spValidaPermiso(Connection conn, Map map) throws Exception;

    void spValidaPermiso(Connection conn, PckgGeneral.SpValidaPermisoParam param) throws Exception;

    PckgGeneral.SpValidaProductoPadreParam spValidaProductoPadre(Connection conn, Map map) throws Exception;

    void spValidaProductoPadre(Connection conn, PckgGeneral.SpValidaProductoPadreParam param) throws Exception;

    PckgGeneral.SpValidaSolicitanteParam spValidaSolicitante(Connection conn, Map map) throws Exception;

    void spValidaSolicitante(Connection conn, PckgGeneral.SpValidaSolicitanteParam param) throws Exception;

    PckgGeneral.EnvaseListarParam newEnvaseListarParam();

    PckgGeneral.EnvaseListarParam newEnvaseListarParam(Map map) throws Exception;

    PckgGeneral.ListarPartidaArancelariaParam newListarPartidaArancelariaParam();

    PckgGeneral.ListarPartidaArancelariaParam newListarPartidaArancelariaParam(Map map) throws Exception;

    PckgGeneral.ProductoBpmGetlistParam newProductoBpmGetlistParam();

    PckgGeneral.ProductoBpmGetlistParam newProductoBpmGetlistParam(Map map) throws Exception;

    PckgGeneral.SpAreasGestionParam newSpAreasGestionParam();

    PckgGeneral.SpAreasGestionParam newSpAreasGestionParam(Map map) throws Exception;

    PckgGeneral.SpBuscarPersonaParam newSpBuscarPersonaParam();

    PckgGeneral.SpBuscarPersonaParam newSpBuscarPersonaParam(Map map) throws Exception;

    PckgGeneral.SpCalcularXTipoInspeccionParam newSpCalcularXTipoInspeccionParam();

    PckgGeneral.SpCalcularXTipoInspeccionParam newSpCalcularXTipoInspeccionParam(Map map) throws Exception;

    PckgGeneral.SpCalculoMontoConceptoParam newSpCalculoMontoConceptoParam();

    PckgGeneral.SpCalculoMontoConceptoParam newSpCalculoMontoConceptoParam(Map map) throws Exception;

    PckgGeneral.SpCalculoMontoConcepto1Param newSpCalculoMontoConcepto1Param();

    PckgGeneral.SpCalculoMontoConcepto1Param newSpCalculoMontoConcepto1Param(Map map) throws Exception;

    PckgGeneral.SpCentroTramiteParam newSpCentroTramiteParam();

    PckgGeneral.SpCentroTramiteParam newSpCentroTramiteParam(Map map) throws Exception;

    PckgGeneral.SpCentroTramitePersonaParam newSpCentroTramitePersonaParam();

    PckgGeneral.SpCentroTramitePersonaParam newSpCentroTramitePersonaParam(Map map) throws Exception;

    PckgGeneral.SpCentroTramiteUbigeoParam newSpCentroTramiteUbigeoParam();

    PckgGeneral.SpCentroTramiteUbigeoParam newSpCentroTramiteUbigeoParam(Map map) throws Exception;

    PckgGeneral.SpConvHospedanteCultivoParam newSpConvHospedanteCultivoParam();

    PckgGeneral.SpConvHospedanteCultivoParam newSpConvHospedanteCultivoParam(Map map) throws Exception;

    PckgGeneral.SpDocumentosIdentidadParam newSpDocumentosIdentidadParam();

    PckgGeneral.SpDocumentosIdentidadParam newSpDocumentosIdentidadParam(Map map) throws Exception;

    PckgGeneral.SpEnviarAprobacionrevdocParam newSpEnviarAprobacionrevdocParam();

    PckgGeneral.SpEnviarAprobacionrevdocParam newSpEnviarAprobacionrevdocParam(Map map) throws Exception;

    PckgGeneral.SpEnviarNoejecInspeccionParam newSpEnviarNoejecInspeccionParam();

    PckgGeneral.SpEnviarNoejecInspeccionParam newSpEnviarNoejecInspeccionParam(Map map) throws Exception;

    PckgGeneral.SpFiltrosBuscarPersonaParam newSpFiltrosBuscarPersonaParam();

    PckgGeneral.SpFiltrosBuscarPersonaParam newSpFiltrosBuscarPersonaParam(Map map) throws Exception;

    PckgGeneral.SpGetCodigoDepProvDisParam newSpGetCodigoDepProvDisParam();

    PckgGeneral.SpGetCodigoDepProvDisParam newSpGetCodigoDepProvDisParam(Map map) throws Exception;

    PckgGeneral.SpGetOrdenPorMtoParam newSpGetOrdenPorMtoParam();

    PckgGeneral.SpGetOrdenPorMtoParam newSpGetOrdenPorMtoParam(Map map) throws Exception;

    PckgGeneral.SpGetReportePfiParam newSpGetReportePfiParam();

    PckgGeneral.SpGetReportePfiParam newSpGetReportePfiParam(Map map) throws Exception;

    PckgGeneral.SpGetReportePfiProdAnexosParam newSpGetReportePfiProdAnexosParam();

    PckgGeneral.SpGetReportePfiProdAnexosParam newSpGetReportePfiProdAnexosParam(Map map) throws Exception;

    PckgGeneral.SpGetReportePziParam newSpGetReportePziParam();

    PckgGeneral.SpGetReportePziParam newSpGetReportePziParam(Map map) throws Exception;

    PckgGeneral.SpGetReportePziCabeseraParam newSpGetReportePziCabeseraParam();

    PckgGeneral.SpGetReportePziCabeseraParam newSpGetReportePziCabeseraParam(Map map) throws Exception;

    PckgGeneral.SpGetReportePziProdAnexosParam newSpGetReportePziProdAnexosParam();

    PckgGeneral.SpGetReportePziProdAnexosParam newSpGetReportePziProdAnexosParam(Map map) throws Exception;

    PckgGeneral.SpGrabarServicioAdicionalParam newSpGrabarServicioAdicionalParam();

    PckgGeneral.SpGrabarServicioAdicionalParam newSpGrabarServicioAdicionalParam(Map map) throws Exception;

    PckgGeneral.SpInfoProcedimientoServicioParam newSpInfoProcedimientoServicioParam();

    PckgGeneral.SpInfoProcedimientoServicioParam newSpInfoProcedimientoServicioParam(Map map) throws Exception;

    PckgGeneral.SpInspectoresParam newSpInspectoresParam();

    PckgGeneral.SpInspectoresParam newSpInspectoresParam(Map map) throws Exception;

    PckgGeneral.SpInspectoresCentroTramiteParam newSpInspectoresCentroTramiteParam();

    PckgGeneral.SpInspectoresCentroTramiteParam newSpInspectoresCentroTramiteParam(Map map) throws Exception;

    PckgGeneral.SpInspectoresDepartamentoParam newSpInspectoresDepartamentoParam();

    PckgGeneral.SpInspectoresDepartamentoParam newSpInspectoresDepartamentoParam(Map map) throws Exception;

    PckgGeneral.SpInspectoresSedeParam newSpInspectoresSedeParam();

    PckgGeneral.SpInspectoresSedeParam newSpInspectoresSedeParam(Map map) throws Exception;

    PckgGeneral.SpInspectoresporubigeoParam newSpInspectoresporubigeoParam();

    PckgGeneral.SpInspectoresporubigeoParam newSpInspectoresporubigeoParam(Map map) throws Exception;

    PckgGeneral.SpListaAlmacenGcustodiaParam newSpListaAlmacenGcustodiaParam();

    PckgGeneral.SpListaAlmacenGcustodiaParam newSpListaAlmacenGcustodiaParam(Map map) throws Exception;

    PckgGeneral.SpListaAnalisisParam newSpListaAnalisisParam();

    PckgGeneral.SpListaAnalisisParam newSpListaAnalisisParam(Map map) throws Exception;

    PckgGeneral.SpListaAplicacionParam newSpListaAplicacionParam();

    PckgGeneral.SpListaAplicacionParam newSpListaAplicacionParam(Map map) throws Exception;

    PckgGeneral.SpListaAplicacionProductoParam newSpListaAplicacionProductoParam();

    PckgGeneral.SpListaAplicacionProductoParam newSpListaAplicacionProductoParam(Map map) throws Exception;

    PckgGeneral.SpListaAreaLaboratorioParam newSpListaAreaLaboratorioParam();

    PckgGeneral.SpListaAreaLaboratorioParam newSpListaAreaLaboratorioParam(Map map) throws Exception;

    PckgGeneral.SpListaDictamenParam newSpListaDictamenParam();

    PckgGeneral.SpListaDictamenParam newSpListaDictamenParam(Map map) throws Exception;

    PckgGeneral.SpListaLugarInspeccionParam newSpListaLugarInspeccionParam();

    PckgGeneral.SpListaLugarInspeccionParam newSpListaLugarInspeccionParam(Map map) throws Exception;

    PckgGeneral.SpListaLugarProduccionParam newSpListaLugarProduccionParam();

    PckgGeneral.SpListaLugarProduccionParam newSpListaLugarProduccionParam(Map map) throws Exception;

    PckgGeneral.SpListaMotivoParam newSpListaMotivoParam();

    PckgGeneral.SpListaMotivoParam newSpListaMotivoParam(Map map) throws Exception;

    PckgGeneral.SpListaMotivoTratamientoParam newSpListaMotivoTratamientoParam();

    PckgGeneral.SpListaMotivoTratamientoParam newSpListaMotivoTratamientoParam(Map map) throws Exception;

    PckgGeneral.SpListaPaisParam newSpListaPaisParam();

    PckgGeneral.SpListaPaisParam newSpListaPaisParam(Map map) throws Exception;

    PckgGeneral.SpListaPlagaTratamientoParam newSpListaPlagaTratamientoParam();

    PckgGeneral.SpListaPlagaTratamientoParam newSpListaPlagaTratamientoParam(Map map) throws Exception;

    PckgGeneral.SpListaProcOrigenMuestraParam newSpListaProcOrigenMuestraParam();

    PckgGeneral.SpListaProcOrigenMuestraParam newSpListaProcOrigenMuestraParam(Map map) throws Exception;

    PckgGeneral.SpListaProduccionPfiParam newSpListaProduccionPfiParam();

    PckgGeneral.SpListaProduccionPfiParam newSpListaProduccionPfiParam(Map map) throws Exception;

    PckgGeneral.SpListaRazaParam newSpListaRazaParam();

    PckgGeneral.SpListaRazaParam newSpListaRazaParam(Map map) throws Exception;

    PckgGeneral.SpListaServAnalisisAnimalParam newSpListaServAnalisisAnimalParam();

    PckgGeneral.SpListaServAnalisisAnimalParam newSpListaServAnalisisAnimalParam(Map map) throws Exception;

    PckgGeneral.SpListaServAnalisisVegetalParam newSpListaServAnalisisVegetalParam();

    PckgGeneral.SpListaServAnalisisVegetalParam newSpListaServAnalisisVegetalParam(Map map) throws Exception;

    PckgGeneral.SpListaSexoParam newSpListaSexoParam();

    PckgGeneral.SpListaSexoParam newSpListaSexoParam(Map map) throws Exception;

    PckgGeneral.SpListaTipoCrianzaParam newSpListaTipoCrianzaParam();

    PckgGeneral.SpListaTipoCrianzaParam newSpListaTipoCrianzaParam(Map map) throws Exception;

    PckgGeneral.SpListaTipoEnvaseParam newSpListaTipoEnvaseParam();

    PckgGeneral.SpListaTipoEnvaseParam newSpListaTipoEnvaseParam(Map map) throws Exception;

    PckgGeneral.SpListaTipoEspecieAnimalParam newSpListaTipoEspecieAnimalParam();

    PckgGeneral.SpListaTipoEspecieAnimalParam newSpListaTipoEspecieAnimalParam(Map map) throws Exception;

    PckgGeneral.SpListaTipoIdentificacionParam newSpListaTipoIdentificacionParam();

    PckgGeneral.SpListaTipoIdentificacionParam newSpListaTipoIdentificacionParam(Map map) throws Exception;

    PckgGeneral.SpListaTipoMuestraAnimalParam newSpListaTipoMuestraAnimalParam();

    PckgGeneral.SpListaTipoMuestraAnimalParam newSpListaTipoMuestraAnimalParam(Map map) throws Exception;

    PckgGeneral.SpListaTipoMuestraVegetalParam newSpListaTipoMuestraVegetalParam();

    PckgGeneral.SpListaTipoMuestraVegetalParam newSpListaTipoMuestraVegetalParam(Map map) throws Exception;

    PckgGeneral.SpListaTipoRecintoParam newSpListaTipoRecintoParam();

    PckgGeneral.SpListaTipoRecintoParam newSpListaTipoRecintoParam(Map map) throws Exception;

    PckgGeneral.SpListaUnidMedProductoParam newSpListaUnidMedProductoParam();

    PckgGeneral.SpListaUnidMedProductoParam newSpListaUnidMedProductoParam(Map map) throws Exception;

    PckgGeneral.SpListaUnidadMedidaParam newSpListaUnidadMedidaParam();

    PckgGeneral.SpListaUnidadMedidaParam newSpListaUnidadMedidaParam(Map map) throws Exception;

    PckgGeneral.SpListarFabricantesParam newSpListarFabricantesParam();

    PckgGeneral.SpListarFabricantesParam newSpListarFabricantesParam(Map map) throws Exception;

    PckgGeneral.SpListarPartidaArancelariaParam newSpListarPartidaArancelariaParam();

    PckgGeneral.SpListarPartidaArancelariaParam newSpListarPartidaArancelariaParam(Map map) throws Exception;

    PckgGeneral.SpListarTipoEnvaseParam newSpListarTipoEnvaseParam();

    PckgGeneral.SpListarTipoEnvaseParam newSpListarTipoEnvaseParam(Map map) throws Exception;

    PckgGeneral.SpListarUnidadMedidaParam newSpListarUnidadMedidaParam();

    PckgGeneral.SpListarUnidadMedidaParam newSpListarUnidadMedidaParam(Map map) throws Exception;

    PckgGeneral.SpMedioTransporteParam newSpMedioTransporteParam();

    PckgGeneral.SpMedioTransporteParam newSpMedioTransporteParam(Map map) throws Exception;

    PckgGeneral.SpObtenerAdjuntosParam newSpObtenerAdjuntosParam();

    PckgGeneral.SpObtenerAdjuntosParam newSpObtenerAdjuntosParam(Map map) throws Exception;

    PckgGeneral.SpObtenerAdjuntosVuceParam newSpObtenerAdjuntosVuceParam();

    PckgGeneral.SpObtenerAdjuntosVuceParam newSpObtenerAdjuntosVuceParam(Map map) throws Exception;

    PckgGeneral.SpObtenerAnalisisCatalServParam newSpObtenerAnalisisCatalServParam();

    PckgGeneral.SpObtenerAnalisisCatalServParam newSpObtenerAnalisisCatalServParam(Map map) throws Exception;

    PckgGeneral.SpObtenerCertParam newSpObtenerCertParam();

    PckgGeneral.SpObtenerCertParam newSpObtenerCertParam(Map map) throws Exception;

    PckgGeneral.SpObtenerClasesCatalServParam newSpObtenerClasesCatalServParam();

    PckgGeneral.SpObtenerClasesCatalServParam newSpObtenerClasesCatalServParam(Map map) throws Exception;

    PckgGeneral.SpObtenerCodiivExpedienteParam newSpObtenerCodiivExpedienteParam();

    PckgGeneral.SpObtenerCodiivExpedienteParam newSpObtenerCodiivExpedienteParam(Map map) throws Exception;

    PckgGeneral.SpObtenerDescDocumentoParam newSpObtenerDescDocumentoParam();

    PckgGeneral.SpObtenerDescDocumentoParam newSpObtenerDescDocumentoParam(Map map) throws Exception;

    PckgGeneral.SpObtenerDireccionImpoParam newSpObtenerDireccionImpoParam();

    PckgGeneral.SpObtenerDireccionImpoParam newSpObtenerDireccionImpoParam(Map map) throws Exception;

    PckgGeneral.SpObtenerEmpresaTratamientoParam newSpObtenerEmpresaTratamientoParam();

    PckgGeneral.SpObtenerEmpresaTratamientoParam newSpObtenerEmpresaTratamientoParam(Map map) throws Exception;

    PckgGeneral.SpObtenerEntidNombreRucParam newSpObtenerEntidNombreRucParam();

    PckgGeneral.SpObtenerEntidNombreRucParam newSpObtenerEntidNombreRucParam(Map map) throws Exception;

    PckgGeneral.SpObtenerExpedientePermisoParam newSpObtenerExpedientePermisoParam();

    PckgGeneral.SpObtenerExpedientePermisoParam newSpObtenerExpedientePermisoParam(Map map) throws Exception;

    PckgGeneral.SpObtenerFamiliasCatalServParam newSpObtenerFamiliasCatalServParam();

    PckgGeneral.SpObtenerFamiliasCatalServParam newSpObtenerFamiliasCatalServParam(Map map) throws Exception;

    PckgGeneral.SpObtenerImportadoresParam newSpObtenerImportadoresParam();

    PckgGeneral.SpObtenerImportadoresParam newSpObtenerImportadoresParam(Map map) throws Exception;

    PckgGeneral.SpObtenerImportadoresVuceParam newSpObtenerImportadoresVuceParam();

    PckgGeneral.SpObtenerImportadoresVuceParam newSpObtenerImportadoresVuceParam(Map map) throws Exception;

    PckgGeneral.SpObtenerListaAnalisisParam newSpObtenerListaAnalisisParam();

    PckgGeneral.SpObtenerListaAnalisisParam newSpObtenerListaAnalisisParam(Map map) throws Exception;

    PckgGeneral.SpObtenerListaAreaParam newSpObtenerListaAreaParam();

    PckgGeneral.SpObtenerListaAreaParam newSpObtenerListaAreaParam(Map map) throws Exception;

    PckgGeneral.SpObtenerListaFuncionarioParam newSpObtenerListaFuncionarioParam();

    PckgGeneral.SpObtenerListaFuncionarioParam newSpObtenerListaFuncionarioParam(Map map) throws Exception;

    PckgGeneral.SpObtenerListaPrediosParam newSpObtenerListaPrediosParam();

    PckgGeneral.SpObtenerListaPrediosParam newSpObtenerListaPrediosParam(Map map) throws Exception;

    PckgGeneral.SpObtenerListaSubAreaParam newSpObtenerListaSubAreaParam();

    PckgGeneral.SpObtenerListaSubAreaParam newSpObtenerListaSubAreaParam(Map map) throws Exception;

    PckgGeneral.SpObtenerListaSubTipoDocParam newSpObtenerListaSubTipoDocParam();

    PckgGeneral.SpObtenerListaSubTipoDocParam newSpObtenerListaSubTipoDocParam(Map map) throws Exception;

    PckgGeneral.SpObtenerListaTipoDocParam newSpObtenerListaTipoDocParam();

    PckgGeneral.SpObtenerListaTipoDocParam newSpObtenerListaTipoDocParam(Map map) throws Exception;

    PckgGeneral.SpObtenerListaVacunasParam newSpObtenerListaVacunasParam();

    PckgGeneral.SpObtenerListaVacunasParam newSpObtenerListaVacunasParam(Map map) throws Exception;

    PckgGeneral.SpObtenerOperadorParam newSpObtenerOperadorParam();

    PckgGeneral.SpObtenerOperadorParam newSpObtenerOperadorParam(Map map) throws Exception;

    PckgGeneral.SpObtenerPersonaParam newSpObtenerPersonaParam();

    PckgGeneral.SpObtenerPersonaParam newSpObtenerPersonaParam(Map map) throws Exception;

    PckgGeneral.SpObtenerPersonaDocParam newSpObtenerPersonaDocParam();

    PckgGeneral.SpObtenerPersonaDocParam newSpObtenerPersonaDocParam(Map map) throws Exception;

    PckgGeneral.SpObtenerPersonaDocAduanaParam newSpObtenerPersonaDocAduanaParam();

    PckgGeneral.SpObtenerPersonaDocAduanaParam newSpObtenerPersonaDocAduanaParam(Map map) throws Exception;

    PckgGeneral.SpObtenerPersonaDocIiParam newSpObtenerPersonaDocIiParam();

    PckgGeneral.SpObtenerPersonaDocIiParam newSpObtenerPersonaDocIiParam(Map map) throws Exception;

    PckgGeneral.SpObtenerPersonaDocumentoParam newSpObtenerPersonaDocumentoParam();

    PckgGeneral.SpObtenerPersonaDocumentoParam newSpObtenerPersonaDocumentoParam(Map map) throws Exception;

    //Llamar al metodo

    PckgGeneral.SpObtenerPersonaDocumentoParam spObtenerPersonaDocumento2();


    PckgGeneral.SpObtenerPersonaDocumentoWParam newSpObtenerPersonaDocumentoWParam();

    PckgGeneral.SpObtenerPersonaDocumentoWParam newSpObtenerPersonaDocumentoWParam(Map map) throws Exception;

    PckgGeneral.SpObtenerPersonaDocvuceParam newSpObtenerPersonaDocvuceParam();

    PckgGeneral.SpObtenerPersonaDocvuceParam newSpObtenerPersonaDocvuceParam(Map map) throws Exception;

    PckgGeneral.SpObtenerPersonaPParam newSpObtenerPersonaPParam();

    PckgGeneral.SpObtenerPersonaPParam newSpObtenerPersonaPParam(Map map) throws Exception;

    PckgGeneral.SpObtenerPersonaSucDocParam newSpObtenerPersonaSucDocParam();

    PckgGeneral.SpObtenerPersonaSucDocParam newSpObtenerPersonaSucDocParam(Map map) throws Exception;

    PckgGeneral.SpObtenerProdExpedienteParam newSpObtenerProdExpedienteParam();

    PckgGeneral.SpObtenerProdExpedienteParam newSpObtenerProdExpedienteParam(Map map) throws Exception;

    PckgGeneral.SpObtenerRepresentanteLegalParam newSpObtenerRepresentanteLegalParam();

    PckgGeneral.SpObtenerRepresentanteLegalParam newSpObtenerRepresentanteLegalParam(Map map) throws Exception;

    PckgGeneral.SpObtenerSaldoParam newSpObtenerSaldoParam();

    PckgGeneral.SpObtenerSaldoParam newSpObtenerSaldoParam(Map map) throws Exception;

    PckgGeneral.SpObtenerSolicitanteParam newSpObtenerSolicitanteParam();

    PckgGeneral.SpObtenerSolicitanteParam newSpObtenerSolicitanteParam(Map map) throws Exception;

    PckgGeneral.SpObtenerSubproductosParam newSpObtenerSubproductosParam();

    PckgGeneral.SpObtenerSubproductosParam newSpObtenerSubproductosParam(Map map) throws Exception;

    PckgGeneral.SpObtenerSubtipoDocumentalParam newSpObtenerSubtipoDocumentalParam();

    PckgGeneral.SpObtenerSubtipoDocumentalParam newSpObtenerSubtipoDocumentalParam(Map map) throws Exception;

    PckgGeneral.SpObtenerTipoCertificadoParam newSpObtenerTipoCertificadoParam();

    PckgGeneral.SpObtenerTipoCertificadoParam newSpObtenerTipoCertificadoParam(Map map) throws Exception;

    PckgGeneral.SpObtenerTipoInspeccionParam newSpObtenerTipoInspeccionParam();

    PckgGeneral.SpObtenerTipoInspeccionParam newSpObtenerTipoInspeccionParam(Map map) throws Exception;

    PckgGeneral.SpObtenerUbigeoParam newSpObtenerUbigeoParam();

    PckgGeneral.SpObtenerUbigeoParam newSpObtenerUbigeoParam(Map map) throws Exception;

    PckgGeneral.SpObtenerUbigeoDetalleParam newSpObtenerUbigeoDetalleParam();

    PckgGeneral.SpObtenerUbigeoDetalleParam newSpObtenerUbigeoDetalleParam(Map map) throws Exception;

    PckgGeneral.SpObtenerUcmIivParam newSpObtenerUcmIivParam();

    PckgGeneral.SpObtenerUcmIivParam newSpObtenerUcmIivParam(Map map) throws Exception;

    PckgGeneral.SpObtenerUcmIivImpoParam newSpObtenerUcmIivImpoParam();

    PckgGeneral.SpObtenerUcmIivImpoParam newSpObtenerUcmIivImpoParam(Map map) throws Exception;

    PckgGeneral.SpObtenerUcmReciboParam newSpObtenerUcmReciboParam();

    PckgGeneral.SpObtenerUcmReciboParam newSpObtenerUcmReciboParam(Map map) throws Exception;

    PckgGeneral.SpObtenerUcmidSolicitudParam newSpObtenerUcmidSolicitudParam();

    PckgGeneral.SpObtenerUcmidSolicitudParam newSpObtenerUcmidSolicitudParam(Map map) throws Exception;

    PckgGeneral.SpObtenerUcmidsExpedienteParam newSpObtenerUcmidsExpedienteParam();

    PckgGeneral.SpObtenerUcmidsExpedienteParam newSpObtenerUcmidsExpedienteParam(Map map) throws Exception;

    PckgGeneral.SpObtenerVigenciaPermisoParam newSpObtenerVigenciaPermisoParam();

    PckgGeneral.SpObtenerVigenciaPermisoParam newSpObtenerVigenciaPermisoParam(Map map) throws Exception;

    PckgGeneral.SpObtenerdoctypeucmParam newSpObtenerdoctypeucmParam();

    PckgGeneral.SpObtenerdoctypeucmParam newSpObtenerdoctypeucmParam(Map map) throws Exception;

    PckgGeneral.SpOperadorLogisticoJuridicoParam newSpOperadorLogisticoJuridicoParam();

    PckgGeneral.SpOperadorLogisticoJuridicoParam newSpOperadorLogisticoJuridicoParam(Map map) throws Exception;

    PckgGeneral.SpOperadorLogisticoNaturalParam newSpOperadorLogisticoNaturalParam();

    PckgGeneral.SpOperadorLogisticoNaturalParam newSpOperadorLogisticoNaturalParam(Map map) throws Exception;

    PckgGeneral.SpProcedimientoPorAreaParam newSpProcedimientoPorAreaParam();

    PckgGeneral.SpProcedimientoPorAreaParam newSpProcedimientoPorAreaParam(Map map) throws Exception;

    PckgGeneral.SpServicioProcedmientoAreaParam newSpServicioProcedmientoAreaParam();

    PckgGeneral.SpServicioProcedmientoAreaParam newSpServicioProcedmientoAreaParam(Map map) throws Exception;

    PckgGeneral.SpTipoDocumentoParam newSpTipoDocumentoParam();

    PckgGeneral.SpTipoDocumentoParam newSpTipoDocumentoParam(Map map) throws Exception;

    PckgGeneral.SpValidaCodigoParam newSpValidaCodigoParam();

    PckgGeneral.SpValidaCodigoParam newSpValidaCodigoParam(Map map) throws Exception;

    PckgGeneral.SpValidaCpeParam newSpValidaCpeParam();

    PckgGeneral.SpValidaCpeParam newSpValidaCpeParam(Map map) throws Exception;

    PckgGeneral.SpValidaDocumentoPresentadoParam newSpValidaDocumentoPresentadoParam();

    PckgGeneral.SpValidaDocumentoPresentadoParam newSpValidaDocumentoPresentadoParam(Map map) throws Exception;

    PckgGeneral.SpValidaPermisoParam newSpValidaPermisoParam();

    PckgGeneral.SpValidaPermisoParam newSpValidaPermisoParam(Map map) throws Exception;

    PckgGeneral.SpValidaProductoPadreParam newSpValidaProductoPadreParam();

    PckgGeneral.SpValidaProductoPadreParam newSpValidaProductoPadreParam(Map map) throws Exception;

    PckgGeneral.SpValidaSolicitanteParam newSpValidaSolicitanteParam();

    PckgGeneral.SpValidaSolicitanteParam newSpValidaSolicitanteParam(Map map) throws Exception;

}
