package com.senasa.bpm.ng.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ServicioAdicionalRequest {
  private String pcentrotramite;
  private String pcanal;
  private String ppersonaid;
  private String ppersonaidotro;
  private String pprocedimientotupa;
  private String puserid;
  private String pcodexpediente;
  private String ppersonaidsolicitante;
  private String prepresentanteid;
  private String pdetallerecibo;
  private String pdetallevacuna;
  private String ppagorecibo;
  private String pobservaciontraza;
}
