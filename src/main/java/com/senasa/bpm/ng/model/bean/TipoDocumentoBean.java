package com.senasa.bpm.ng.model.bean;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoDocumentoBean {
    private String codigdocumento;
    private String descripcionTipoDocumento;
    private String descripcionCompleta;
}
