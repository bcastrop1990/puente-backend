package com.senasa.bpm.ng.service.generico;

import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;

import com.senasa.bpm.ng.model.bean.GrabarInactivoBean;
import com.senasa.bpm.ng.model.generico.CentroTramitePersona;
import com.senasa.bpm.ng.model.generico.ClasificacionFarmaceutica;
import com.senasa.bpm.ng.model.generico.Comprobante;
import com.senasa.bpm.ng.model.generico.Especie;
import com.senasa.bpm.ng.model.generico.Fabricante;
import com.senasa.bpm.ng.model.generico.FormaFarmaceutica;
import com.senasa.bpm.ng.model.generico.Procedimientoservicio;
import com.senasa.bpm.ng.model.generico.ReciboServFito;
import com.senasa.bpm.ng.model.generico.ResponsableTecnico;
import com.senasa.bpm.ng.model.generico.Servicioprocedimiento;
import com.senasa.bpm.ng.model.generico.Solicitante;
import com.senasa.bpm.ng.model.generico.SolicitanteConsulta;
import com.senasa.bpm.ng.model.generico.SolicitudRegistroProductosVeterinarios;
import com.senasa.bpm.ng.model.generico.SolicitudRenovacionProductosVeterinarios;
import com.senasa.bpm.ng.model.generico.Tarifario;
import com.senasa.bpm.ng.model.generico.Ubigeo;
import com.senasa.bpm.ng.model.generico.ViaFormaFarmaceutica;

public interface IGenericoService {

	public List<Solicitante> listarSolicitanteRZ(String rz);

	public List<Ubigeo> listarDepartamento();

	public List<Ubigeo> listarProvincia(long idDepartamento);

	public List<Ubigeo> listarDistrito(long idProvincia);

	public List<Ubigeo> listarPais();

	public List<Solicitante> obtenerResponsable(String documento);

	public List<Especie> listarEspecie();

	public List<ViaFormaFarmaceutica> listarViaFormaFarmaceutica();

	public List<ClasificacionFarmaceutica> listarclasificacionFarmaceutica();

	public List<FormaFarmaceutica> listarformaFarmaceutica();

	public List<Fabricante> buscarFabricante(String nombre);

	public List<ResponsableTecnico> buscarResponsableTecnico(String ruc);

	public List<SolicitanteConsulta> buscarSolicitante(String Ptidodoc, String Pnumdoc, String Pnombre,
			String p_Formato);

	public List<CentroTramitePersona> buscarCentroTramitePersona(String idPersona);

	public List<Procedimientoservicio> buscarProcedimientoservicio(Procedimientoservicio procedimientoservicio);

	public List<Servicioprocedimiento> buscarServicioprocedimiento(Servicioprocedimiento servicioprocedimiento);

	public Tarifario obtenerTarifa(Tarifario tarifario);

	public GrabarInactivoBean RegistrarSolicitudRegistroProductosVeterinarios(
			SolicitudRegistroProductosVeterinarios solicitudRegistroProductosVeterinarios);

	public SolicitudRenovacionProductosVeterinarios RegistrarSolicitudRenovacionProductosVeterinarios(
			SolicitudRenovacionProductosVeterinarios solicitudRenovacionProductosVeterinarios);

	public List<Comprobante> buscarComprobante(Comprobante comprobante);

	public List<ReciboServFito> buscarDetalleReciboAnalisisFito(ReciboServFito reciboServFito);
}
