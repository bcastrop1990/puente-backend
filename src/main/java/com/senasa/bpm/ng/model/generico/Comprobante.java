package com.senasa.bpm.ng.model.generico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comprobante {
	String p_Cod_Recibo;
	String p_Cod_Proc;
	String p_Cod_Servicio;
	String p_Persona_Id;

	String descripcionCentroTramite;
	String direccionCentroTramite;
	String codigoExpediente;
	String fechaRegistro;
	String codigoRecibo;
	String prefijo;
	String codigoCentroTramite;
	String personaId;
	String codigoSolicitud;
	String descripcionAreaGestion;
	String descripcionProcedimietoTupa;
	String descripcionServicio;
	String codigoProcedimientoTupa;
	String codigoServicio;
	String nombreUsuario;
	
	
	
}
