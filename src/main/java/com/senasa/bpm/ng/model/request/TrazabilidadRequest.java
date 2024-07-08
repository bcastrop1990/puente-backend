package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TrazabilidadRequest {
  private String pareadestinatario;
  private String psubareadestinatario;
  private String parearemitente;
  private String psubarearemitente;
  private String psecuencial;
  private  String urgencia;
}
