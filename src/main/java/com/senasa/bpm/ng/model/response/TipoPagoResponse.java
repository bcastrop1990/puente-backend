package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoPagoResponse {
    private String codigo_Tipo_Pago;
    private String descripcion_Tipo_Pago;
}
