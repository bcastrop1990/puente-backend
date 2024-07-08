package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AgregarPersonaRequest {
  private String p_Persona_Id;
  private String p_Nombre_Razon_Social;
  private String p_Persona_Tipo;
  private String p_Documento_Tipo;
  private String p_Documento_Numero;
  private String p_Ruc;
  private String p_Direccion;
  private String p_Departamento_Id;
  private String p_Provincia_Id;
  private String p_Distrito_Id;
  private String p_Telefono;
  private String p_Telefono_Movil;
  private String p_Correo_Electronico;
  private String p_Fecha_Nacimiento;
  private String p_Referencia_Direccion;
  private String p_Fecha_Alta;
  private String p_Fecha_Baja;
  private String p_Nombre_Comercial;
  private String p_Estado_Juridico;
  private String p_Sincronizacion_Estado;
  private String p_Sincronizacion_Fecha;
  private String p_Usuario;
}
