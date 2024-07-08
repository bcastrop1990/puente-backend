package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgregarDocuResponse {
    private String codigo_Documento;
    private String descripcion_Corta;
}
