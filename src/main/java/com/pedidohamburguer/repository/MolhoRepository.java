package com.pedidohamburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidohamburguer.model.entity.Molho;

@Repository
public interface MolhoRepository extends JpaRepository<Molho, Integer> {

}
