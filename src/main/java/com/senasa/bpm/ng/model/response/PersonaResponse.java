package com.senasa.bpm.ng.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaResponse {
  private String numeroDoc;
  private String bucarPorNom;
  private String dni;


}
