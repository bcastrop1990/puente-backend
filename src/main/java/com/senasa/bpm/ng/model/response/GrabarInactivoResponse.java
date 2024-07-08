package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrabarInactivoResponse {
    private String pcodsolicitud;
    private String pcodexpediente;
    private String pcodrecibo;
    private String pcodigostddoc;
}
