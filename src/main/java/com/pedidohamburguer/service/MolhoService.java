package com.pedidohamburguer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.entity.Molho;
import com.pedidohamburguer.repository.MolhoRepository;

@Service
public class MolhoService {

	@Autowired
	private MolhoRepository molhoRepository;

	public void adicionarMolho(Molho molho) {
		molho.setNomeMolho(molho.getNomeMolho().toUpperCase());
		molhoRepository.save(molho);

	}
	
	public List<Molho> buscarMolho(){
		return molhoRepository.findAll();
	}
}
