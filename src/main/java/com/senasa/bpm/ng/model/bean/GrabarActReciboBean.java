package com.senasa.bpm.ng.model.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrabarActReciboBean {
  private String codigo_Expediente;
  private String fecha_Registro;
  private String codigo_Centro_Tramite;
  private String descripcion_Centro_Tramite;
  private String codigo_Servicio;
  private String descripcion_Area_Gestion;
  private String descripcion_Procedimiento_Tupa;
  private String descripcion_Servicio;
  private String persona_Id;
  private String nombre_Razon_Social;
  private String codigo_Solicitud;
  private String ucm_Id;
  private String codigo_Procedimiento_Tupa;
  private String nume_Regi_Arc;
  private String orden_Vuce;
  private String canal;
  private String codigo_Std_Doc;
  private String numero_Folios;
  private String confidencial;
  private String codigo_Tupa;
  private String cod_Formato;
  private String estado;
  private String estado_expediente;
  private String tipo_certificado;
  private String oea_tipo_operador;
  private String oea_tipo_atencion;
}
