package com.pedidohamburguer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidohamburguer.model.dto.PedidoDTO;
import com.pedidohamburguer.service.PedidoService;

@RestController
@RequestMapping("/pedido")
@CrossOrigin("*")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public void adicionarPedido(@RequestBody PedidoDTO pedidoDTO) {
		pedidoService.adicionarPedido(pedidoDTO);
	}

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> buscasPedidosEmEspera() {
		return pedidoService.buscarPedidosEmEspera();
	}

	@PutMapping(path = "finalizar")
	public void finalizarPedido(@RequestBody Integer idPedido) {
		pedidoService.finalizarPedido(idPedido);
	}

}
