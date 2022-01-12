package com.pedidohamburguer.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public void adicionarPao(PaoDTO pao, MultipartFile file) {
		
		
		try {
			pao.setFoto(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		paoRepository.save(new Pao(null, fs.emMaiusculo(pao.getNome()), pao.getFoto()));

	}

	public List<PaoDTO> buscarPao() {
		List<Pao> paos = paoRepository.findAll();
		List<PaoDTO> paosDTO = paos.stream().map(obj -> new PaoDTO(obj)).collect(Collectors.toList());
		return paosDTO;

	}

}
