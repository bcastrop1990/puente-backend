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
public class CentroTramitePersona {

	public String codigoCentroTramite;
	public String descripcionCentroTramite;
	public String personaId;
	public String codigoArea;
	public String codigoSubarea;
	public String nombreSubarea;
	public String ubicacionSede;
	public String codigoTipoCentroTramite;
	public String codigoUsuario;

}
