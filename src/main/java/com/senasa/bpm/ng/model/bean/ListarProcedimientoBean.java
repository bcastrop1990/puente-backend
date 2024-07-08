package com.senasa.bpm.ng.model.bean;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListarProcedimientoBean {
    private String codigo_Servicio_Tupa;
    private String descripcion_Servicio;
    private String indicador_Otro;
    private String tipo_Servicio;

}
