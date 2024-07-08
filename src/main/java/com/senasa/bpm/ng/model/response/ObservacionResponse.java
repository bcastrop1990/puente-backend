package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObservacionResponse {
    private String fecha_Hora;
    private String notas;
    private String remitente_Entidad;
    private String urgencia;
    private String ucm_id;

}
