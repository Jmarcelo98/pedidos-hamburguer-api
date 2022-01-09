package com.pedidohamburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidohamburguer.model.entity.Carne;
import com.pedidohamburguer.service.CarneService;

@RestController
@RequestMapping("/carne")
public class CarneController {

	@Autowired
	private CarneService carneService;

	@PostMapping
	public void adicionarCarne(Carne carne) {
		carneService.adicionarCarne(carne);
	}

	@GetMapping
	public ResponseEntity<?> buscarCarne() {
		return ResponseEntity.ok().body(carneService.buscarCarne());

	}

}
