package com.senasa.bpm.ng.model.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequisitoBean {
  private String codigo_Servicio;
  private String descripcion_Servicio;
  private String codigo_Documento;
  private String descripcion_Documento;
  private String indicador_Obligatorio;
  private String sub_Tipo;
  private String ruta_Check_In;
}
