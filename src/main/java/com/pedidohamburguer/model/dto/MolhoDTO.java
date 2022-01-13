package com.pedidohamburguer.model.dto;

import com.pedidohamburguer.model.entity.Molho;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MolhoDTO {

	private Integer id;
	private String nomeMolho;

	public MolhoDTO(Molho obj) {
		id = obj.getId();
		nomeMolho = obj.getNomeMolho();
	}

}
