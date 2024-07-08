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
public class RepresentanteLegal {
	private String codigoDistrito;
	private String estado;
	private String cargo;
	private String fechaCargo;
	private String nombreCompleto;
}
