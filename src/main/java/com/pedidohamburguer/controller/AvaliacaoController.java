package com.pedidohamburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidohamburguer.model.dto.AvaliacaoDTO;
import com.pedidohamburguer.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliar")
@CrossOrigin("*")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	
	@PostMapping
	public void adicionarAvaliacao(@RequestBody AvaliacaoDTO avaliacao){
		avaliacaoService.adicionarAvaliacao(avaliacao);
		
	}

}
