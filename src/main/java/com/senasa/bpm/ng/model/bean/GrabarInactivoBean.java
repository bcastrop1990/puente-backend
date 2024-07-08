package com.senasa.bpm.ng.model.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrabarInactivoBean {
  private String pcodsolicitud;
  private String pcodexpediente;
  private String pcodrecibo;
  private String pcodigostddoc;
}
