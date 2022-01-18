package com.pedidohamburguer.model.enums;

public enum MolhoEnum {

	PICANTE("CHIPOTLE"), MAIONESE("MAIONSE"), BACON("BACONNAISE");

	private String descricao;

	MolhoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
