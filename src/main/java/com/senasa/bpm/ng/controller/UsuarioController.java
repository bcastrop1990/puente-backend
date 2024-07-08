package com.senasa.bpm.ng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senasa.bpm.ng.model.bean.UsuarioBean;
import com.senasa.bpm.ng.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public UsuarioBean getData(String usrname) {
		return service.getData(usrname);
	}

}
