package com.pedidohamburguer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.dto.PaoDTO;
import com.pedidohamburguer.model.entity.Pao;
import com.pedidohamburguer.repository.PaoRepository;
import com.pedidohamburguer.util.FormatarString;

@Service
public class PaoService {

	@Autowired
	private PaoRepository paoRepository;
	
	private FormatarString fs = new FormatarString()
;
	public void adicionarPao(PaoDTO pao) {
		
		if (pao != null) {
			paoRepository.save(new Pao(null, fs.emMaiusculo(pao.getNome())));	
		}

	}

	public List<PaoDTO> buscarPao() {
		List<Pao> paos = paoRepository.findAll();
		List<PaoDTO> paosDTO = paos.stream().map(obj -> new PaoDTO(obj)).collect(Collectors.toList());
		return paosDTO;
	}
	
	public Pao buscarPaoPeloNome(String nomePao) {
		return paoRepository.findByNome(nomePao);
	}


}
