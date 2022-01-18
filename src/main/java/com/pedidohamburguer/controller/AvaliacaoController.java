package com.pedidohamburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidohamburguer.model.dto.AvaliacaoDTO;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoController {
	
	
	@Autowired
	private AvaliacaoService avaliacaoService
	
	
	
	@PutMapping
	public AvaliacaoDTO saveAvaliacao(	)
	

}
