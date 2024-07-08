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
public class UsuarioBean {
	
	private String idUser;
    private String nombre;
    private String nombreCorto;
    private String flagActiUsu;
    private Integer personaId;    
    private String documento;
    private String numeRegiEmp;
    private String sedeActuPer;
    private String codiEmplPer;
    private String descSedeSed;
    private String codiDepeTde;
    private String codigoCentroTramite;

}
