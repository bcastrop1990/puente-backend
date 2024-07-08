package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CalcularMontoRequest {
  private String pcodservicio;
  private String pcantidad;
  private String ptramaproductos;
  private String ptramavacunas;
  private String ptramaanalisis;
}
