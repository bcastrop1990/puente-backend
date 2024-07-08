package com.senasa.bpm.ng.model.bean;

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
public class ReqDocSalidaBean {
	private String ucmid;
	private String codigo_Documento;
	private String descripcion_documento;
	private String indicador_obligatorio;
	private String sub_tipo;
	private String ruta_check_in;
	private String numfolios;
	private String confidencialidad;
	private String cod_std_doc;
}
