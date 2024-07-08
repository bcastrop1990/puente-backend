package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaResponse {
    private String codigo_Area_Gestion;
    private String descripcion_Area_Gestion;
    private String codigo_Clase;
}
