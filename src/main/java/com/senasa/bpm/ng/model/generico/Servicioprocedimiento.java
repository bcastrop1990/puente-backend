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
public class Servicioprocedimiento {
	public String codigoServicioTupa;
	public String descripcionServicio;
	public String indicadorOtro;
	public String tipoServicio;

}
