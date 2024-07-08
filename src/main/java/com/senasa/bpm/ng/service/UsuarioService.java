package com.senasa.bpm.ng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senasa.bpm.ng.dao.impl.UsuarioDaoImpl;
import com.senasa.bpm.ng.model.bean.UsuarioBean;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDaoImpl dao;
	
	public UsuarioBean getData(String usrname) {
		return dao.getData(usrname);
	}
}
