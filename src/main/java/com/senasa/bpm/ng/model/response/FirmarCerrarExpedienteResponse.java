package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FirmarCerrarExpedienteResponse {
        private String cod_idioma;
        private String fg_varios;
        private String tot_productos;
        private String codigo_iiv;
        private String secuencial;
        private String codstddoc;
        private String plantilla;
}
