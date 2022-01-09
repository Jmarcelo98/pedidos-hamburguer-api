package com.pedidohamburguer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.entity.Carne;
import com.pedidohamburguer.repository.CarneRepository;

@Service
public class CarneService {

	@Autowired
	private CarneRepository carneRepository;

	public void adicionarCarne(Carne carne) {
		carne.setPontoCarne(carne.getPontoCarne().toUpperCase());
		carneRepository.save(carne);

	}

	public List<Carne> buscarCarne() {
		return carneRepository.findAll();
	}

}
