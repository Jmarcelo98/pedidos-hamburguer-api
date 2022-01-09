package com.pedidohamburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidohamburguer.Pao;

@Repository
public interface PaoRepository extends JpaRepository<Pao, Integer> {
	
	

}
