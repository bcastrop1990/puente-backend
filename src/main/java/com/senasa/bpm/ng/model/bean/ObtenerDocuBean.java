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
public class ObtenerDocuBean {
  private String codigo_std_doc;
  private String codigo_std_doc_adjunto;
  private String codigo_tipo_documento;
  private String descripcion_documento;
  private String nombre;
  private String indicador_obligatorio;
  private String ucm_id;
  private String confidencial;
  private String numer_regi_arc;
}
