package com.senasa.bpm.ng.model.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InspeccionBean {
  private String codigo_Tipo_Envase;
  private String descripcion_Tipo_Envase;
}
