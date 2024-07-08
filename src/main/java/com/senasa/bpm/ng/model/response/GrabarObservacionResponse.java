package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrabarObservacionResponse {
    private String pcodsolicitud;
    private String pcodigostddoc;
}
