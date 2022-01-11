package com.pedidohamburguer.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioAdminDTO {

	private Integer id;

	@NotNull(message = "{name.not.blank}")
	private String nome;

	@NotNull(message = "{senha.not.blank}")
	private String senha;

	private Boolean admin;

	public UsuarioAdminDTO(Integer id, String nome, String senha, Boolean admin) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.admin = admin;
	}

}
