package com.pedidohamburguer.model.dto;

public class UsuarioDTO {

	private Integer id;
	private String nome;
	private Boolean admin;

	public UsuarioDTO(Integer id, String nome, Boolean admin) {
		this.id = id;
		this.nome = nome;
		this.admin = admin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

}
