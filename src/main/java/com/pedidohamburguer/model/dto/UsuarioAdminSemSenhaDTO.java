package com.pedidohamburguer.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioAdminSemSenhaDTO {

	private Integer id;

	private String nome;

	private Boolean admin;

	public UsuarioAdminSemSenhaDTO(Integer id, String nome, Boolean admin) {
		this.id = id;
		this.nome = nome;
		this.admin = admin;
	}

}
