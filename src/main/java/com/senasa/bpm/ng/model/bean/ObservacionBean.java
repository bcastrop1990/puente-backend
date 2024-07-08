package com.senasa.bpm.ng.model.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObservacionBean {
  private String fecha_Hora;
  private String notas;
  private String remitente_Entidad;
  private String urgencia;
  private String ucm_id;
}
