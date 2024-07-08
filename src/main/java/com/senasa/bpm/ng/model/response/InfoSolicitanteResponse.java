package com.senasa.bpm.ng.model.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoSolicitanteResponse {

    private String persona_Id;
    private String nombre_Razon_Social;
    private String persona_Tipo;
    private String documento_Tipo;
    private String apellido_Paterno;
    private String apellido_Materno;
    private String nombres;
    private String direccion;
    private String departamento_Id;
    private String nomb_Dpto_Dpt;
    private String provincia_Id;
    private String nomb_Prov_Tpr;
    private String distrito_Id;
    private String nomb_Dist_Tdi;
    private String telefono;
    private String centro_Poblado_Id;
    private String telefono_Movil;
    private String referencia_Direccion;
    private String estado;
    private String pais_Id;
    private String fecha_Nacimiento;
    private String nombre_Razsoc_Comp;
    private String regi_Padr_Emp;
}

