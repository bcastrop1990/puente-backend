package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcedimientoResponse {
    private String codigo_Procedimiento_Tupa;
    private String descripcion_Procedimieto_Tupa;
    private String indicador_Procedimiento_Espe;
}
