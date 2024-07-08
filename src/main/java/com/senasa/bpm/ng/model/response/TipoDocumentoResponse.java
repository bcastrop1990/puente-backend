package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoDocumentoResponse {
    private String codigdocumento;
    private String descripcionTipoDocumento;
    private String descripcionCompleta;
}
