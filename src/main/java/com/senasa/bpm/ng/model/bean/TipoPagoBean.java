package com.senasa.bpm.ng.model.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoPagoBean {
  private String codigo_Tipo_Pago;
  private String descripcion_Tipo_Pago;
}
