package com.senasa.bpm.ng.model.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgregarDocuBean {
  private String codigo_Documento;
  private String descripcion_Corta;
}
