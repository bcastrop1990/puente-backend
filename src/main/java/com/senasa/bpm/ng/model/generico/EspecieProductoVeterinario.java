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
public class EspecieProductoVeterinario {
    private String codigoSolicitudProducto;
    private String anno;
    private String usuario;
    private String dpiEspecieAnimal;
    private String mensaje;
    private String editable;
    private Double secuencial;
}
