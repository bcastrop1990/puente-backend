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
public class Solicitante {
	public long idSolicitante;
	public String tipoDocuento;
	public String nroDocumento;
	public String nombreRZ;
	
    private String direccion;
    private String departamento;
    private String provincia;
    private String distrito;
    private String telefono;
    private String celular;
    private String correo;
    
    private String registroSenasa;
    
    
    
    
}
