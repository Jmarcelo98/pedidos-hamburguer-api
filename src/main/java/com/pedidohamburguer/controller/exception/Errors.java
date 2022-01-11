package com.pedidohamburguer.controller.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Errors {

	private String campo; // qual campo que deu erro
	private String erro; // qual o erro

	public Errors(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

}
