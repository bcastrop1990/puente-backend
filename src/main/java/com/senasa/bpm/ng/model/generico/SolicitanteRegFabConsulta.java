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
public class SolicitanteRegFabConsulta {
	String ANNO_REGI_PRO;
	String REGI_SOLI_PRO;
	String CODIGO_LABORATORIO;
	String REGI_SOLIPRO;
	String FLAG_FABRI_EXT;
	String DIRECCION_FABRI;
	String DOCUMENTO_TIPO_FABRI;
	String DOCUMENTO_NUMERO_FABRI;
	String NUM_REGISTRO_FABRI;
	String DEPARTAMENTO_ID_FABRI;
	String PROVINCIA_ID_FABRI;
	String DISTRITO_ID_FABRI;
	String TELEFONO_FABRI;
	String APELLIDO_PARTERNO_RESPONSABLE;
	String APELLIDO_MATERNO_RESPONSABLE;
	String NOMBRES_RESPONSABLE;
	String DOCUMENTO_TIPO_RESPONSABLE;
	String DOCUMENTO_NUMERO_RESPONSABLE;
}
