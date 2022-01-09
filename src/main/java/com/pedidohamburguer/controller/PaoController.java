package com.pedidohamburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidohamburguer.Pao;
import com.pedidohamburguer.service.PaoService;

@RestController
@RequestMapping("/pao")
public class PaoController {

	@Autowired
	private PaoService paoService;

	@PostMapping
	public void escolherPao(Pao pao) {
		paoService.escolherPao(pao);
	}

	@GetMapping
	ResponseEntity<?> buscarPao() {
		return ResponseEntity.ok().body(paoService.buscarPao());
	}

}
