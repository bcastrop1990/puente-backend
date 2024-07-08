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
public class Procedimientoservicio {
	public String codigoAreaGestion;
	public String descripcionAreaGestion;
	public String codigoProcedimientoTUPA;
	public String descripcionProcedimientoTUPA;
	public String codigoServicio;
	public String descripcionServicio;
}
