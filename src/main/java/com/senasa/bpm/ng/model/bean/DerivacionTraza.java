package com.senasa.bpm.ng.model.bean;

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
public class DerivacionTraza {

	private String pcodexpediente;
	private String pcodigostddoc;
	private String pcodservicio;
	private String pdescripcionasunto;
	private String pnotas;
	private String premitenteusuario;
	private String pdestinatariousuario;
	private String pucmid;
}
