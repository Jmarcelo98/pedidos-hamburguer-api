package com.pedidohamburguer.model.enums;

public enum MolhoEnum {

	PICANTE("CHIPOTLE"), MAIONESE("MAIONSE"), BACON("BACONESE");

	private String descricao;

	MolhoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
