package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GrabarActReciboRequest {
  private String pcodrecibo;
  private String pucmid;
  private String pcodigostddoc;
  private String puserid;
  private String pcodexpediente;
}
