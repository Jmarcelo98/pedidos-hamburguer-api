package com.pedidohamburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidohamburguer.model.entity.Carne;

@Repository
public interface CarneRepository extends JpaRepository<Carne, Integer> {
	
	


}
