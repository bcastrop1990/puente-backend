package com.senasa.bpm.ng.model.generico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleRecibo {
    private String codigoServicio;
    private String descripcionServicio;
    private Double cantidad;
    private Double costo;
    private String editable;
}
