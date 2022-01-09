package com.pedidohamburguer.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pedidohamburguer.model.entity.Pao;
import com.pedidohamburguer.repository.PaoRepository;

@Service
public class PaoService {

	@Autowired
	private PaoRepository paoRepository;

	public void adicionarPao(Pao pao, MultipartFile file) {
		pao.setNome(pao.getNome().toUpperCase());

		try {
			pao.setFoto(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		paoRepository.save(pao);

	}

	public List<Pao> buscarPao() {
		return paoRepository.findAll();

	}

}
