package com.senasa.bpm.ng.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleDerivacionBean {
  private String notas;
  private String fech_Crea;
  private String remitente_Usuario;
  private String remitente_Persona;
  private String ucm_id;
}
