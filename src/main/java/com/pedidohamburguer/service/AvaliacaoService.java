package com.pedidohamburguer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.dto.AvaliacaoDTO;
import com.pedidohamburguer.model.entity.Avaliacao;
import com.pedidohamburguer.model.entity.Pedido;
import com.pedidohamburguer.repository.AvaliacaoRepository;
import com.pedidohamburguer.repository.PedidoRepository;
import com.pedidohamburguer.util.FormatarString;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	private FormatarString fs = new FormatarString();

	public void adicionarAvaliacao(AvaliacaoDTO avaliacao) {
		Pedido pedido = pedidoRepository.findById(avaliacao.getIdPedido()).get();

		if (avaliacao.getAvaliacao() != null) {
			avaliacao.setAvaliacao(fs.emMaiusculo(avaliacao.getAvaliacao()));
		}

		Avaliacao avaliacao1 = new Avaliacao(null, avaliacao.getNota(), avaliacao.getAvaliacao(),
				avaliacao.getUsuario(), pedido);
		avaliacaoRepository.save(avaliacao1);

	}

}
