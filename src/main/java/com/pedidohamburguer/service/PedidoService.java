package com.pedidohamburguer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.entity.Pedido;
import com.pedidohamburguer.repository.PedidoRepository;

@Service
public class PedidoService {


	@Autowired
	private PedidoRepository pedidoRepository;
	
	

	public void adicionarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
		
	}

	public List<Pedido> buscarPedido() {
		return pedidoRepository.findAll();
	}
}
