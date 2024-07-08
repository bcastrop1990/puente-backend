package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListarServiciosResponse {
    private String codigo_Servicio_Tupa;
    private String descripcion_Servicio;
    private String indicador_Otro;
    private String tipo_Servicio;
}
