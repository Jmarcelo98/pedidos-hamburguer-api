package com.pedidohamburguer.model.enums;

public enum CarneEnum {

	MAL_PASSADA ("MAL PASSADA") ,AO_PONTO("AO PONTO"), BEM_PASSADA("BEM PASSADA");

	private String descricao;

	CarneEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
