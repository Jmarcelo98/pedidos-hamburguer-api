package com.pedidohamburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pedidohamburguer.model.entity.Pao;
import com.pedidohamburguer.service.PaoService;

@RestController
@RequestMapping("/pao")
public class PaoController {

	@Autowired
	private PaoService paoService;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void adicionarPao(Pao pao, @RequestPart("file") MultipartFile file) {
		paoService.adicionarPao(pao, file);
	}

	@GetMapping
	ResponseEntity<?> buscarPao() {
		return ResponseEntity.ok().body(paoService.buscarPao());
	}

}
