package com.senasa.bpm.ng.model.generico;

import java.util.List;

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
public class SolicitudRegistroProductosVeterinarios {
    private String  codigoSolicitudProducto;
    private String  codigoProcedimiento;
    private Persona responsableTecnico;
    private Persona solicitante;
    private String codigoCentroTramite;
    private String descripcionCentroTramite;
    private String personaId;
    private String usuario;
    private String anno;
    private String ubicacionSede;
    private PaisProducto paisProducto;
    private Titular titular;
    private String tipoProducto;
    private String accion;
    private String mensaje;
    private String codigoRecibo;
    private String nombreComercial;
    private String formula;
    private String numeroSenasa;
    private RepresentanteLegal representanteLegal;
    private ResponsableTecnico responsableTecnicoCombo;
    private FabricanteLaboratorio fabricanteLaboratorio;
    private Clasificacion clasificacion;
    private FormaFarmaceutica formaFarmaceutica;
    private FormaAdministracionProducto formaAdministracionProducto;
    private List<EspecieProductoVeterinario>listEspecieProductoVeterinario;
    private List<DetalleRecibo> listDetalleRecibo;
    private List<PagoRecibo> listPagoRecibo;
    private String codigoSolicitudExpediente;
    private String plazoRenovacion;
    private String codigoStdDoc;
    private String codigoExpediente;
    private String idPersona;
}
