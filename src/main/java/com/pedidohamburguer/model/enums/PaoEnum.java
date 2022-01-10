package com.pedidohamburguer.model.enums;

public enum PaoEnum {

	AUSTRALIANO("AUSTRALIANO"), GERGELIM("GERGELIM");

	private String descricao;

	PaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
