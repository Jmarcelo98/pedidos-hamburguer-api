package com.pedidohamburguer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidohamburguer.model.entity.Molho;

@Repository
public interface MolhoRepository extends JpaRepository<Molho, Integer> {
	
	List<Molho> findByNomeMolho(String nomeMolho);
	
	List<Molho> findByNomeMolhoIn(List<String> nomes);
	

}
