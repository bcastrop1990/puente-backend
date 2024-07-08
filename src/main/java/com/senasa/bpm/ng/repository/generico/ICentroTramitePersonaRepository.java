package com.senasa.bpm.ng.repository.generico;

import java.util.List;

import com.senasa.bpm.ng.model.generico.CentroTramitePersona;


public interface ICentroTramitePersonaRepository {
	public List<CentroTramitePersona> buscarCentroTramitePersona(String Ppersonaid);
}
