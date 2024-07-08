package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GrabarObservacionRequest {
  private String pcodexpediente;
  private String premitenteusuario;
  private String pcanal;
  private String pobservacion;
  private String inplazo;
  private String numeregiarc;
  private String ucmid;
}
