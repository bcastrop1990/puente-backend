package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BancoResponse {
    private String codigo_Cta_Cte;
    private String nombre_Banco;
    private String numero_Cta;
    private String nombre;
}
