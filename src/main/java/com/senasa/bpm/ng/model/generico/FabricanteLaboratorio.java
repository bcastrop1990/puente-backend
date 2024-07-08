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
public class FabricanteLaboratorio {
    private String codigoSolicitudProducto;
    private String anno;
    private String flagFabricante;
    private String direccionFabricante;
    private String documentoTipoFabricante;
    private String documentoNumeroFabricante;
    private String codigoDepartamento;
    private String codigoProvincia;
    private String codigoDistrito;
    private String telefono;
    private String apellidoPaternoResponsable;
    private String apellidoMaternoResponsable;
    private String nombreResponsable;
    private String tipoDocumento;
    private String numeroDocumento;
    private String numeroRegistro;
    private String razonSocial;
    private String mensaje;
}
