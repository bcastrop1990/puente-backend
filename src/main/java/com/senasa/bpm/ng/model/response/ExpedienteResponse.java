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
public class ExpedienteResponse {
	private String codigo_Expediente;
	private String fecha_Registro;
	private String codigo_Centro_Tramite;
	private String descripcion_Centro_Tramite;
	private String codigo_Servicio;
	private String descripcion_Area_Gestion;
	private String descripcion_Procedimieto_Tupa;
	private String descripcion_Servicio;
	private String persona_Id;
	private String nombre_Razon_Social;
	private String codigo_Solicitud;
	private String ucm_Id;
	private String codigo_Procedimiento_Tupa;
	private String confidencial;
	private String estado_expediente;

}
