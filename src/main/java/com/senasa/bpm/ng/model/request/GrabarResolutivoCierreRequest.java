package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GrabarResolutivoCierreRequest {
  private String Pcentrotramite;
  private String Pcodexpediente;
  private String Ppersonaid;
  private String Pprocedimientotupa;
  private String Puserid;
  private String Pdocumentos;
  
}
