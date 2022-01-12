package com.pedidohamburguer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.dto.CarneDTO;
import com.pedidohamburguer.model.entity.Carne;
import com.pedidohamburguer.repository.CarneRepository;
import com.pedidohamburguer.util.FormatarString;

@Service
public class CarneService {

	@Autowired
	private CarneRepository carneRepository;
	
	private FormatarString fs = new FormatarString();
	
	public ResponseEntity<?> adicionarCarne(CarneDTO carne) {
		Carne carne1 = new Carne(null, fs.emMaiusculo(carne.getPontoCarne()));
		carneRepository.save(carne1);
		return ResponseEntity.ok().body(new CarneDTO(carne1.getId(),carne1.getPontoCarne()));

		

	}

	public  List<CarneDTO> buscarCarne() {
		List<Carne> list = carneRepository.findAll();
		List<CarneDTO> listDTO = list.stream().map(obj -> new CarneDTO(obj)).collect(Collectors.toList());
			return listDTO;
	}

}
