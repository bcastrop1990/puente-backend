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
public class ReggridBean {
  private String secuencial;
  private String fecha_Hora ;
  private String estado;
  private String remitente;
  private String destinatario;
  private String proveido;
}
