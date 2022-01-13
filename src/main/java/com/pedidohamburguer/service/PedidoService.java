package com.pedidohamburguer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.dto.PedidoDTO;
import com.pedidohamburguer.model.entity.Pedido;
import com.pedidohamburguer.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public void adicionarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);

	}
	
	public ResponseEntity<List<PedidoDTO>> buscarPedidosEmEspera() {
		List<Pedido> list = pedidoRepository.findByConcluidoOrderByDataCriacaoDesc(false);
		
		List<PedidoDTO> listDTO = list.stream().map(obj -> new PedidoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);

	}

	
}
