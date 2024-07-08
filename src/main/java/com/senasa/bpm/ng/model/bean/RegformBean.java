package com.senasa.bpm.ng.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegformBean {
  private String id_Proceso ;
  private String id_Original;
  private String tipo;
  private String id_Final;
  private String asunto;
  private String canal;
}
