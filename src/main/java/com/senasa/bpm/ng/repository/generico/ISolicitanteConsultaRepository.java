package com.senasa.bpm.ng.repository.generico;

import java.util.List;
import com.senasa.bpm.ng.model.generico.SolicitanteConsulta;

public interface ISolicitanteConsultaRepository {
	public List<SolicitanteConsulta> buscarSolicitante(String Ptidodoc, String Pnumdoc, String Pnombre, String p_Formato

	);
}
