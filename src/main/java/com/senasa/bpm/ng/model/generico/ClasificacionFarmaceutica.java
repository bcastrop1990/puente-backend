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
public class ClasificacionFarmaceutica {
	String idClasificacionFarmaceutica;
	String nombre;
}
