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
public class Titular {
	  private String flagTitular;
	  private String nombreRazonSocial;
	  private String numeroRegistroSenasa;
	  private String numeroRuc;
	  private String domicilioLegal;
	  private String telefono;
	  private String codigoDepartamento;
	  private String codigoProvincia;
	  private String codigoDistrito;
	  private String codigoPais;
	  private String nombreResponsable;
	  private String numeroDocumento;
}
