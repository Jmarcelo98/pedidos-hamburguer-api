package com.pedidohamburguer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidohamburguer.model.dto.UsuarioAdminDTO;
import com.pedidohamburguer.model.dto.UsuarioDTO;
import com.pedidohamburguer.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(path = "/verificar-admin")
	public ResponseEntity<Boolean> verificarAdmin(String nome) {
		return usuarioService.verificarAdmin(nome);
	}

	@PostMapping(path = "/admin")
	public ResponseEntity<?> loginAdmin(@RequestBody @Valid UsuarioAdminDTO usuarioDTO) {
		return usuarioService.loginAdmin(usuarioDTO);
	}

	@PostMapping
	public ResponseEntity<?> loginUsuario(@RequestBody @Valid UsuarioDTO usuario) {
		return usuarioService.loginUsuario(usuario);
	}

}
