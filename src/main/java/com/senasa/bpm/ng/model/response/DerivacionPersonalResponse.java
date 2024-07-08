package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DerivacionPersonalResponse {
    private String usuario;
    private String nombre_persona;
}
