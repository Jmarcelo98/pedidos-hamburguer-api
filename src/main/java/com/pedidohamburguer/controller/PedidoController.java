package com.pedidohamburguer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidohamburguer.model.entity.Pedido;
import com.pedidohamburguer.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	
	private PedidoService pedidoService;
	
	@PostMapping
	public void adicionarPedido(Pedido pedido) {
		pedidoService.adicionarPedido(pedido);
		
	}
	
	@GetMapping
	public ResponseEntity<?> buscarPedido(){
		return ResponseEntity.ok().body(pedidoService.buscarPedido());
	}

}
