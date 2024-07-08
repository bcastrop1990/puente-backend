package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArchivarRequest {
  private String pidfinal;
  private String pserviciotupa;
  private String pidremitente;
  private String piddestinatario;
}
