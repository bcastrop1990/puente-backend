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
public class SolicitudRenovacionProductosVeterinarios {
	String P_COD_EXPEDIENTE;
	String P_MENSAJE;
	String P_ESPECIES;
	String P_FABRICANTE;
	String P_PAIS;
	String P_VIAS;
	List<ConsultaFabExpediente> REG;
	List<DatosBean> REG_ESPE;
	List<SolicitanteRegFabConsulta> REG_FABR;

}
