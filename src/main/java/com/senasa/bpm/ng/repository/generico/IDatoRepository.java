package com.senasa.bpm.ng.repository.generico;

import java.util.List;

import com.senasa.bpm.ng.model.generico.DatosBean;
import com.senasa.bpm.ng.model.generico.Fabricante;

public interface IDatoRepository {
	public List<DatosBean> listarDatos(String tipoDato);

	public List<Fabricante> buscarFabricante(String formato, String tipoDato);
}
