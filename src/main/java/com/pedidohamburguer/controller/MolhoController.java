package com.pedidohamburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidohamburguer.model.entity.Molho;
import com.pedidohamburguer.service.MolhoService;

@RestController
@RequestMapping("/molho")
public class MolhoController {

	@Autowired
	private MolhoService molhoService;

	@PostMapping
	public void adicionarMolho(Molho molho) {
		molhoService.adicionarMolho(molho);

	}

	@GetMapping
	public ResponseEntity<?> buscarMolho() {
		return ResponseEntity.ok().body(molhoService.buscarMolho());
	}
}
