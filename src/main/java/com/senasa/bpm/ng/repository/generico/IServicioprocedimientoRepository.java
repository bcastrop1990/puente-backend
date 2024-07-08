package com.senasa.bpm.ng.repository.generico;

import java.util.List;
import com.senasa.bpm.ng.model.generico.Servicioprocedimiento;

public interface IServicioprocedimientoRepository {
	public List<Servicioprocedimiento> buscarServicioprocedimiento(Servicioprocedimiento servicioprocedimiento);
}
