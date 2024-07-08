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
public class Persona {
    private String idPersona;
    private String nombreRazonSocial;
    private String tipoPersona;
    private String tipoDocumento;
    private String idTipoDocumento;
    private String numeroDocumento;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String direccion;
    private String idDepartamento;
    private String nombreDepartamento;
    private String idProvincia;
    private String nombreProvincia;
    private String idDistrito;
    private String nombreDistrito;
    private String telefono;
    private String idCentroPoblado;
    private String telefonoMovil;
    private String correoElectronico;
    private String direccionReferencia;
    private String estadoEmpresa;
    private String idPais;
    private String fechaNacimiento;
    private String registroSenasa;
    private String formato;
    private String registro;
    private String registroS;
    private String ruc;
    private String numeropermisols;
    private String numeroExpediente;
    private Double libre;
    private String usuario;
    private String centroTramite;
}
