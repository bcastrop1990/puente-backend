package com.senasa.bpm.ng.repository.generico;

import java.util.List;

import com.senasa.bpm.ng.model.generico.Comprobante;
import com.senasa.bpm.ng.model.generico.ReciboServFito;

public interface IComprobanteRepository {
	public List<Comprobante> buscarComprobante(Comprobante comprobante);

	public List<ReciboServFito> buscarDetalleReciboAnalisisFito(ReciboServFito reciboServFito);

}
