package com.pedidohamburguer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidohamburguer.model.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	List<Pedido> findByConcluidoOrderByDataCriacaoDesc(Boolean concluido);
	
}
