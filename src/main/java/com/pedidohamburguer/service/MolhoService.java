package com.pedidohamburguer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.dto.MolhoDTO;
import com.pedidohamburguer.model.entity.Molho;
import com.pedidohamburguer.repository.MolhoRepository;
import com.pedidohamburguer.util.FormatarString;

@Service
public class MolhoService {

	@Autowired
	private MolhoRepository molhoRepository;
	
	private FormatarString fs = new FormatarString();

	public ResponseEntity<?> adicionarMolho(MolhoDTO molho) {
		Molho molho1 = new Molho(null, fs.emMaiusculo(molho.getNomeMolho()));
		molhoRepository.save(molho1);
		return ResponseEntity.ok().body(new MolhoDTO(molho1.getId(), molho1.getNomeMolho()));

	}
	
	public List<MolhoDTO> buscarMolho(){
		List<Molho> molhos = molhoRepository.findAll();
		List<MolhoDTO>molhosDTO = molhos.stream().map(obj -> new MolhoDTO(obj)).collect(Collectors.toList());
		return molhosDTO;
		
	}
}
