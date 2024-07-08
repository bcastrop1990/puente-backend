package com.senasa.bpm.ng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senasa.bpm.ng.dao.ExpedienteDao;
import com.senasa.bpm.ng.model.bean.ExpedienteBean;
import com.senasa.bpm.ng.model.request.ExpedienteRequest;
import com.senasa.bpm.ng.model.response.ExpedienteResponse;
import com.senasa.bpm.ng.service.ExpedienteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ExpedienteServiceImpl implements ExpedienteService {
	
	@Autowired
	private ExpedienteDao expedienteDao;
	
	@Override
	public ExpedienteResponse buscarExpediente(ExpedienteRequest request) {
		// TODO Auto-generated method stub
		ExpedienteBean expedienteBean = expedienteDao.buscarExpediente(request);
		if (expedienteBean != null) {
			ExpedienteResponse response = new ExpedienteResponse();
			response.setCodigo_Expediente(expedienteBean.getCodigo_Expediente());
			response.setFecha_Registro(expedienteBean.getFecha_Registro());
			response.setCodigo_Centro_Tramite(expedienteBean.getCodigo_Centro_Tramite());
			response.setDescripcion_Centro_Tramite(expedienteBean.getDescripcion_Centro_Tramite());
			response.setCodigo_Solicitud(expedienteBean.getCodigo_Solicitud());
			response.setCodigo_Servicio(expedienteBean.getCodigo_Servicio());
			response.setPersona_Id(expedienteBean.getPersona_Id());
			response.setDescripcion_Area_Gestion(expedienteBean.getDescripcion_Area_Gestion());
			response.setDescripcion_Procedimieto_Tupa(expedienteBean.getDescripcion_Procedimieto_Tupa());
			response.setDescripcion_Servicio(expedienteBean.getDescripcion_Servicio());
			response.setNombre_Razon_Social(expedienteBean.getNombre_Razon_Social());
			response.setConfidencial(expedienteBean.getConfidencial());
			response.setEstado_expediente(expedienteBean.getEstado_expediente());
			//System.out.println("ESTE ES EL EXPEDIENTE: " + expedienteBean.getCodigo_Expediente());
			//System.out.println("fecha EXPEDIENTE: " + expedienteBean.getFecha_Registro());
			
			
			/* private String codigo_Centro_Tramite;
	private String descripcion_Centro_Tramite;
	private String codigo_Servicio;
	private String descripcion_Area_Gestion;
	private String descripcion_Procedimieto_Tupa;
	private String descripcion_Servicio;
	private String persona_Id;
	private String nombre_Razon_Social;
	private String codigo_Solicitud;
	private String ucm_Id;
	private String codigo_Procedimiento_Tupa;
			 */
			return response;
		}
		return null;
	}	
	/*
	@Override
	public ExpedienteTrazabilidadResponse grabarTrazabilidadExpediente(ExpedienteTrazabilidadRequest request) {

		ExpedienteTrazabilidadResponse response = expedienteDao.grabarTrazabilidadExpediente(request);
		
		return response;
	}
    */
	
}
