package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ValidarBoletaRequest {
  private String numerodeposito;
  private String codigoctacte;
}
