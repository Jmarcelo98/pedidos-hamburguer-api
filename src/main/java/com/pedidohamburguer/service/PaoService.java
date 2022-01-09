package com.pedidohamburguer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.entity.Pao;
import com.pedidohamburguer.repository.PaoRepository;

@Service
public class PaoService {

	@Autowired
	private PaoRepository paoRepository;

	public void escolherPao(Pao pao) {
		pao.setNome(pao.getNome().toUpperCase());
		paoRepository.save(pao);

	}

	public List<Pao> buscarPao() {
		return paoRepository.findAll();

	}

}
