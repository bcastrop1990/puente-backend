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
public class SolicitanteConsulta {

	String idPersona;
	String nombreRazonSocial;
	String tipoPersona;
	String tipoDocumento;
	String numeroDocumento;
	String apellidoPaterno;
	String apellidoMaterno;
	String nombres;
	String direccion;
	String idDepartamento;
	String idProvincia;
	String nombreProvincia;
	String idDistrito;
	String nombreDistrito;
	String telefono;
	String idCentroPoblado;
	String telefonoMovil;
	String correoElectronico;
	String direccionReferencia;
	String idPais;
	String fechaNacimiento;
	String estadoEmpresa;
	String nombreDepartamento;
	String registroSenasa;
	String idTipoDocumento;
	String formato;
	String registro;
	String registroS;
	String numeropermisols;
	String numeroExpediente;
	String libre;
	String ruc;
	String usuario;
	String centroTramite;
}
