package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FinalizarProcesoRequest {
   private String pcodexpediente;
  private String pusuario;
  private String pdocumentos;
  private String pcanal;



}
