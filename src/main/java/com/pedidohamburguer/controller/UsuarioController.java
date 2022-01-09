package com.pedidohamburguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidohamburguer.model.entity.Usuario;
import com.pedidohamburguer.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(path = "/admin")
	public ResponseEntity<Boolean> verificarAdmin(String nome) {
		return usuarioService.verificarAdmin(nome);
	}

	@GetMapping
	public ResponseEntity<?> buscarUsuario(Usuario usuario) {
		return ResponseEntity.ok().body(usuarioService.buscarUsuario(usuario)).getBody();
	}

}
