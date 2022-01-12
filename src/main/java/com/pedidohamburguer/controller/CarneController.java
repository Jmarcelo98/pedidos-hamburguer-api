package com.pedidohamburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidohamburguer.model.dto.CarneDTO;
import com.pedidohamburguer.service.CarneService;

@RestController
@RequestMapping("/carne")
public class CarneController {

	@Autowired
	private CarneService carneService;

	@PostMapping
	public ResponseEntity<?> adicionarCarne(@RequestBody CarneDTO carne) {
		return carneService.adicionarCarne(carne);
		}

	@GetMapping
	public ResponseEntity<?> buscarCarne() {
		return ResponseEntity.ok().body(carneService.buscarCarne());

	}

}
