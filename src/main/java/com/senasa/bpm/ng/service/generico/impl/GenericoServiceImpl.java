package com.senasa.bpm.ng.service.generico.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senasa.bpm.ng.repository.generico.IComprobanteRepository;
import com.senasa.bpm.ng.repository.generico.IDatoRepository;

import com.senasa.bpm.ng.repository.generico.impl.CentroTramitePersonaRepository;
import com.senasa.bpm.ng.repository.generico.impl.ComprobanteRepository;
import com.senasa.bpm.ng.repository.generico.impl.ProcedimientoservicioRepository;
import com.senasa.bpm.ng.repository.generico.impl.RegistroProductoVeterinarioRepository;
import com.senasa.bpm.ng.repository.generico.impl.ResponsableTecnicoRepository;
import com.senasa.bpm.ng.repository.generico.impl.ServicioprocedimientoRepository;
import com.senasa.bpm.ng.repository.generico.impl.SolicitanteConsultaRepository;
import com.senasa.bpm.ng.repository.generico.impl.TarifarioRepository;
import com.senasa.bpm.ng.service.generico.IGenericoService;
import com.senasa.bpm.ng.dao.GrabarDao;
import com.senasa.bpm.ng.model.bean.GrabarInactivoBean;
import com.senasa.bpm.ng.model.bean.TipoDocumentoBean;
import com.senasa.bpm.ng.model.generico.*;
import com.senasa.bpm.ng.model.request.GrabarInactivoRequest;

@Service

public class GenericoServiceImpl implements IGenericoService {

	@Autowired
	IDatoRepository datoRepository;

	@Autowired
	ResponsableTecnicoRepository responsableTecnicoRepository;

	@Autowired
	SolicitanteConsultaRepository solicitanteConsultaRepository;

	@Autowired
	CentroTramitePersonaRepository centroTramitePersonaRepository;

	@Autowired
	ProcedimientoservicioRepository procedimientoservicioRepository;

	@Autowired
	ServicioprocedimientoRepository servicioprocedimientoRepository;

	@Autowired
	TarifarioRepository tarifarioRepository;

	@Autowired
	RegistroProductoVeterinarioRepository registroProductoVeterinarioRepository;

	@Autowired
	IComprobanteRepository comprobanteRepository;

	@Autowired
	GrabarDao grabarDao;
	
	@Override
	public List<Solicitante> listarSolicitanteRZ(String rz) {
		// TODO Auto-generated method stub
		List<Solicitante> l = new ArrayList<Solicitante>();
		Solicitante solicitante = new Solicitante();
		solicitante.setTipoDocuento("DNI");
		solicitante.setNroDocumento("12345678");
		solicitante.setNombreRZ("JUAN PEREZ");
		solicitante.setDireccion("JPRA2000");
		solicitante.setDepartamento("LIMA");
		solicitante.setProvincia("LIMA");
		solicitante.setDistrito("LIMA");
		solicitante.setTelefono("7654321");
		solicitante.setCelular("987654321");
		solicitante.setCorreo("CORREO@CORREO.COM");
		solicitante.setIdSolicitante(1l);
		solicitante.setRegistroSenasa("00003929");
		l.add(solicitante);
		solicitante = new Solicitante();
		solicitante.setTipoDocuento("DNI");
		solicitante.setNroDocumento("87654321");
		solicitante.setNombreRZ("PEDRO QUISPE");
		solicitante.setIdSolicitante(2l);

		solicitante.setDireccion("JPRA3000");
		solicitante.setDepartamento("LIMA");
		solicitante.setProvincia("LIMA");
		solicitante.setDistrito("LIMA");
		solicitante.setTelefono("7654322");
		solicitante.setCelular("987654322");
		solicitante.setCorreo("CORREO1@CORREO.COM");
		solicitante.setRegistroSenasa("00003929");
		l.add(solicitante);

		return l;
	}

	@Override
	public List<Ubigeo> listarDepartamento() {
		List<Ubigeo> l = new ArrayList<Ubigeo>();
		Ubigeo ubigeo = new Ubigeo();
		ubigeo.setIdUbigeoPadre(0l);
		ubigeo.setIdUbigeo(1l);
		ubigeo.setNombre("LIMA");
		l.add(ubigeo);
		ubigeo = new Ubigeo();
		ubigeo.setIdUbigeoPadre(0l);
		ubigeo.setIdUbigeo(1l);
		ubigeo.setNombre("AREQUIPA");
		l.add(ubigeo);
		return l;
	}

	@Override
	public List<Ubigeo> listarProvincia(long idDepartamento) {
		List<Ubigeo> l = new ArrayList<Ubigeo>();
		Ubigeo ubigeo = new Ubigeo();
		ubigeo.setIdUbigeoPadre(0l);
		ubigeo.setIdUbigeo(1l);
		ubigeo.setNombre("LIMA");
		l.add(ubigeo);
		return l;
	}

	@Override
	public List<Ubigeo> listarDistrito(long idProvincia) {
		List<Ubigeo> l = new ArrayList<Ubigeo>();
		Ubigeo ubigeo = new Ubigeo();
		ubigeo.setIdUbigeoPadre(0l);
		ubigeo.setIdUbigeo(1l);
		ubigeo.setNombre("LIMA");
		l.add(ubigeo);
		return l;
	}

	@Override
	public List<Ubigeo> listarPais() {
		List<Ubigeo> l = new ArrayList<Ubigeo>();
		Ubigeo ubigeo = new Ubigeo();
		ubigeo.setIdUbigeoPadre(0l);
		ubigeo.setIdUbigeo(1l);
		ubigeo.setNombre("PERU");
		l.add(ubigeo);
		return l;
	}

	@Override
	public List<Solicitante> obtenerResponsable(String documento) {
		// TODO Auto-generated method stub
		List<Solicitante> s = new ArrayList<>();
		Solicitante solicitante = new Solicitante();
		solicitante.setTipoDocuento("DNI");
		solicitante.setNroDocumento("12345678");
		solicitante.setNombreRZ("JUAN PEREZ");
		solicitante.setDireccion("JPRA2000");
		solicitante.setDepartamento("LIMA");
		solicitante.setProvincia("LIMA");
		solicitante.setDistrito("LIMA");
		solicitante.setTelefono("7654321");
		solicitante.setCelular("987654321");
		solicitante.setCorreo("CORREO@CORREO.COM");
		solicitante.setIdSolicitante(1l);
		solicitante.setRegistroSenasa("00003929");
		s.add(solicitante);
		return s;

	}

	@Override
	public List<Especie> listarEspecie() {
		List<Especie> l = new ArrayList<>();
		Especie especie;
		List<DatosBean> lista = datoRepository.listarDatos("ESPECIE");
		for (DatosBean item : lista) {
			especie = new Especie();
			especie.setIdEspecie(item.getCodigo());
			especie.setNombre(item.getDescripcion());
			l.add(especie);
		}

		return l;
	}

	@Override
	public List<ViaFormaFarmaceutica> listarViaFormaFarmaceutica() {
		List<ViaFormaFarmaceutica> l = new ArrayList<>();
		ViaFormaFarmaceutica viaFormaFarmaceutica;
		List<DatosBean> lista = datoRepository.listarDatos("VIA_ADMINISTRACION");
		for (DatosBean item : lista) {
			viaFormaFarmaceutica = new ViaFormaFarmaceutica();
			viaFormaFarmaceutica.setIdViaFormaFarmaceutica(item.getCodigo());
			viaFormaFarmaceutica.setNombre(item.getDescripcion());
			l.add(viaFormaFarmaceutica);
		}

		return l;
	}

	@Override
	public List<ClasificacionFarmaceutica> listarclasificacionFarmaceutica() {
		List<ClasificacionFarmaceutica> l = new ArrayList<>();
		ClasificacionFarmaceutica clasificacionFarmaceutica;
		List<DatosBean> lista = datoRepository.listarDatos("TIPO_FARMACO");
		for (DatosBean item : lista) {
			clasificacionFarmaceutica = new ClasificacionFarmaceutica();
			clasificacionFarmaceutica.setIdClasificacionFarmaceutica(item.getCodigo());
			clasificacionFarmaceutica.setNombre(item.getDescripcion());
			l.add(clasificacionFarmaceutica);
		}

		return l;
	}

	@Override
	public List<FormaFarmaceutica> listarformaFarmaceutica() {
		List<FormaFarmaceutica> l = new ArrayList<>();
		FormaFarmaceutica formaFarmaceutica;
		List<DatosBean> lista = datoRepository.listarDatos("PRESEN_FARMACO");
		for (DatosBean item : lista) {
			formaFarmaceutica = new FormaFarmaceutica();
			formaFarmaceutica.setIdFormaFarmaceutica(item.getCodigo());
			formaFarmaceutica.setNombre(item.getDescripcion());
			l.add(formaFarmaceutica);
		}

		return l;
	}

	@Override
	public List<Fabricante> buscarFabricante(String nombre) {
		List<Fabricante> l = datoRepository.buscarFabricante("FABRICANTENACIONAL", nombre);
		return l;
	}

	@Override
	public List<ResponsableTecnico> buscarResponsableTecnico(String ruc) {
		List<ResponsableTecnico> l = responsableTecnicoRepository.buscarResponsableTecnico(ruc);
		return l;
	}

	@Override
	public List<SolicitanteConsulta> buscarSolicitante(String Ptidodoc, String Pnumdoc, String Pnombre,
			String p_Formato) {
		List<SolicitanteConsulta> l = solicitanteConsultaRepository.buscarSolicitante(Ptidodoc, Pnumdoc, Pnombre,
				p_Formato);
		return l;
	}

	@Override
	public List<CentroTramitePersona> buscarCentroTramitePersona(String idPersona) {
		List<CentroTramitePersona> l = centroTramitePersonaRepository.buscarCentroTramitePersona(idPersona);
		return l;
	}

	@Override
	public List<Procedimientoservicio> buscarProcedimientoservicio(Procedimientoservicio procedimientoservicio) {
		List<Procedimientoservicio> l = procedimientoservicioRepository
				.buscarProcedimientoservicio(procedimientoservicio);

		return l;
	}

	@Override
	public List<Servicioprocedimiento> buscarServicioprocedimiento(Servicioprocedimiento servicioprocedimiento) {
		List<Servicioprocedimiento> l = servicioprocedimientoRepository
				.buscarServicioprocedimiento(servicioprocedimiento);

		return l;
	}

	@Override
	public Tarifario obtenerTarifa(Tarifario tarifario) {
		return tarifarioRepository.RetornaTarifario(tarifario);
	}

	@Override
	public GrabarInactivoBean RegistrarSolicitudRegistroProductosVeterinarios(
			SolicitudRegistroProductosVeterinarios solicitudRegistroProductosVeterinarios) {
		//temp
		Persona solicitante=new Persona();
		solicitante.setIdPersona(solicitudRegistroProductosVeterinarios.getIdPersona());
		solicitudRegistroProductosVeterinarios.setSolicitante(solicitante);
		
		List<DetalleRecibo> listDetalleRecibo=new ArrayList<DetalleRecibo>();
		DetalleRecibo detalleRecibo=new DetalleRecibo();
		detalleRecibo.setCodigoServicio("338");
		detalleRecibo.setCantidad(1.0);
		detalleRecibo.setCosto(122.1);
		
		detalleRecibo.setEditable("");
		listDetalleRecibo.add(detalleRecibo);
		solicitudRegistroProductosVeterinarios.setListDetalleRecibo(listDetalleRecibo);
		
		
		GrabarInactivoRequest expediente=new GrabarInactivoRequest();
		expediente.setPcanal("BPM");
		expediente.setPcentrotramite(solicitudRegistroProductosVeterinarios.getCodigoCentroTramite());
		expediente.setPcodexpediente("");
		expediente.setPcodorden("");
		expediente.setPdetallerecibo(generarTramaDetalleRecibo(solicitudRegistroProductosVeterinarios.getListDetalleRecibo()));
		expediente.setPdetallevacuna("");
		expediente.setPpagorecibo("4]]345]]1]]06/07/2024]]435");
		expediente.setPpersonaid(solicitudRegistroProductosVeterinarios.getPersonaId());
		expediente.setPpersonaidotro("");
		expediente.setPpersonaidsolicitante(solicitudRegistroProductosVeterinarios.getSolicitante().getIdPersona());
		expediente.setPprocedimientotupa(solicitudRegistroProductosVeterinarios.getCodigoProcedimiento());
		expediente.setPrepresentanteid("");
		expediente.setPuserid(solicitudRegistroProductosVeterinarios.getUsuario());
		/*
		expediente.setPpersonaidotro(solicitudRegistroProductosVeterinarios.getSolicitante().getIdPersona());
		expediente.setPprocedimientotupa(solicitudRegistroProductosVeterinarios.getCodigoProcedimiento());
		expediente.setPuserid(solicitudRegistroProductosVeterinarios.getUsuario());
		expediente.setPpersonaidsolicitante(solicitudRegistroProductosVeterinarios.getSolicitante().getIdPersona());
		//vaidar registro
		expediente.setPpersonaid(solicitudRegistroProductosVeterinarios.getSolicitante().getIdPersona());
		//expediente.setRepresentanteId(solicitudRegistroProductosVeterinarios.getRepresentanteLegal().getIdPersona()); //restablecer
		expediente.setPrepresentanteid(solicitudRegistroProductosVeterinarios.getSolicitante().getIdPersona());
		*/
		
		
		
		List<GrabarInactivoBean> gra=grabarDao.grabarInactivo(expediente);
		
		
		registroProductoVeterinarioRepository
		.RetornaSolicitudRegistroProductosVeterinarios(solicitudRegistroProductosVeterinarios);
		
		return gra.get(0);
	}

    public String generarTramaDetalleRecibo(List<DetalleRecibo> listDetalleRecibo  ) {
        String trama="";
        if(listDetalleRecibo.size()>0){
          for(DetalleRecibo detalleRecibo : listDetalleRecibo){
             if (detalleRecibo.getEditable()!= "R")
                trama=trama +"<->"+detalleRecibo.getCodigoServicio()+"]]"+detalleRecibo.getCantidad()+"]]"+detalleRecibo.getCosto();
          }
          trama = trama.substring(3);
        }
        return trama;
     }
	
	@Override
	public SolicitudRenovacionProductosVeterinarios RegistrarSolicitudRenovacionProductosVeterinarios(
			SolicitudRenovacionProductosVeterinarios solicitudRenovacionProductosVeterinarios) {
		return registroProductoVeterinarioRepository
				.RetornaRenovacionProductosVeterinarios(solicitudRenovacionProductosVeterinarios);
	}
	
	@Override
	public List<Comprobante> buscarComprobante(Comprobante comprobante) {
		return comprobanteRepository.buscarComprobante(comprobante);
	}

	@Override
	public List<ReciboServFito> buscarDetalleReciboAnalisisFito(ReciboServFito reciboServFito) {
		return comprobanteRepository.buscarDetalleReciboAnalisisFito(reciboServFito);
	}



}
