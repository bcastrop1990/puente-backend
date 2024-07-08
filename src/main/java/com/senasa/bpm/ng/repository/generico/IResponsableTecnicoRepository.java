package com.senasa.bpm.ng.repository.generico;

import java.util.List;

import com.senasa.bpm.ng.model.generico.ResponsableTecnico;

public interface IResponsableTecnicoRepository {
	public List<ResponsableTecnico> buscarResponsableTecnico(String numeroDocumento);
}
