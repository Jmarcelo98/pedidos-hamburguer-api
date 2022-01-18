package com.pedidohamburguer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.dto.AvaliacaoDTO;
import com.pedidohamburguer.model.entity.Avaliacao;
import com.pedidohamburguer.repository.AvaliacaoRepository;
import com.pedidohamburguer.util.FormatarString;

@Service
public class AvaliacaoService {
	
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	private FormatarString fs = new FormatarString();
	
	public void adicionarAvaliacao(AvaliacaoDTO avaliacao){
		Avaliacao avaliacao1 = new Avaliacao(null, avaliacao.getNota(), fs.emMaiusculo(avaliacao.getAvaliacao()), avaliacao.getUsuario(), avaliacao.getPedido());
		avaliacaoRepository.save(avaliacao1);
		
	}
	
	

}
