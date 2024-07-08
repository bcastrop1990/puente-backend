package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GrabarDocHijoRequest {
  private String pcodigostdpadre;
  private String pdocumento;
  private String puserid;
  private String pconfidencial;
  private String pucmid;
  private String pnumfolio;
  private String pindobligatorio;
  private String Pestado;
  private String pnombredochijo;
  
}
