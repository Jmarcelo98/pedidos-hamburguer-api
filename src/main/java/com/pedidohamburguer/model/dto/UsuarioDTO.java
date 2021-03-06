package com.pedidohamburguer.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

	private Integer id;

	@NotNull(message = "{name.not.blank}")
	private String nome;

	@NotNull(message = "{sobrenome.not.blank}")
	private String sobrenome;

	private Boolean admin;

	public UsuarioDTO(Integer id, String nome, String sobrenome, Boolean admin) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.admin = admin;
	}

}
