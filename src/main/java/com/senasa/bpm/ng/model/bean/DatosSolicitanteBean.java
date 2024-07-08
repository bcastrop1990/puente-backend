package com.senasa.bpm.ng.model.bean;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DatosSolicitanteBean {


    private String pasaporte;
    private String carnetFuerzasPoliciales;
    private String cedDiplomaticaIdentidad;
    private String dni;
    private String ruc;
    private String cext;



    // Buscar por:

    private String tipoDocumento;
    private String numDocumento;
}
