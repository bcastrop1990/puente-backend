package com.senasa.bpm.ng.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObtenerInfoAdjuntosResponse {
	private String nombre;
	private String ucm_id;

}
