package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidarExpedienteResponse {
    private Integer pcerrado;
    private String pmensaje;
}
