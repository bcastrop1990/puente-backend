package com.senasa.bpm.ng.model.response;

import java.util.List;

import com.senasa.bpm.ng.model.bean.ExpedienteTrazabilidadBean;

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
public class ExpedienteTrazabilidadResponse {

	private String pareadestinatario;
	  private String psubareadestinatario;
	  private String parearemitente;
	  private String psubarearemitente;
	  private String psecuencial;
	  private String urgencia;
	  private String codigo_Servicio;
	  private String descripcion_Servicio;
	  private String nombre_Corto_Servicio;
	  private String estado;
	  private String codigo_Clase;
	  private String descripcion_Clase;
	  private String codigo_Tipo_Servicio;
	  private String descripcion_Tipo_Servicio;
	  private String autoridad_Aprueba;
	  private String autoridad_Resuelve;
	
}