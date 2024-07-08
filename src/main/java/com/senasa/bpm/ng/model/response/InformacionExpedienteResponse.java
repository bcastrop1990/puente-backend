package com.senasa.bpm.ng.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InformacionExpedienteResponse {
        private String codigoExpediente;
        private String fechaRegistro;
        private String codigoCentroTramite;
        private String descripcionCentroTramite;
        private String codigoServicio;
        private String descripcionAreaGestion;
        private String descripcionProcedimientoTupa;
        private String descripcionServicio;
        private String personaId;
        private String nombreRazonSocial;
        private String codigoSolicitud;
        private String ucmId;
        private String codigoProcedimientoTupa;
        private String numeRegiArc;
        private String ordenVuce;
        private String canal;
        private String codigoStdDoc;
        private int numeroFolios;
        private String confidencial;
        private String codigoTupa;
        private String codFormato;
        private String estado;
        private String estadoExpediente;
        private String tipoCertificado;
        private String oeaTipoOperador;
        private String oeaTipoAtencion;

}
