package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GrabarResolutivoRequest {
  private String Pcentrotramite;
  private String Pcodexpediente;
  private String Ppersonaid;
  private String Pprocedimientotupa;
  private String Puserid;
  private String Pdocumentos;
  private String Pdestinatariousuario;
  private String Pcanal;
  private String Pobservacion;
  
}
