package com.pedidohamburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidohamburguer.model.entity.Pao;

@Repository
public interface PaoRepository extends JpaRepository<Pao, Integer> {
	
	

}
