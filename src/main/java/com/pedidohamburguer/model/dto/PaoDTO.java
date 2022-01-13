package com.pedidohamburguer.model.dto;

import com.pedidohamburguer.model.entity.Pao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaoDTO {

	public PaoDTO(Pao obj) {
		id = obj.getId();
		nome = obj.getNome();

	}

	private Integer id;
	private String nome;

}
