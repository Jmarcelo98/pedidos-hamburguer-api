package com.pedidohamburguer.model.dto;

import com.pedidohamburguer.model.entity.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoDTO {

	private Integer id;
	private Integer nota;
	private String avaliacao;
	private Integer idPedido;
	private Usuario usuario;

	public AvaliacaoDTO(Integer id, Integer nota, String avaliacao, Integer idPedido, Usuario usuario) {
		this.id = id;
		this.nota = nota;
		this.avaliacao = avaliacao;
		this.idPedido = idPedido;
		this.usuario = usuario;

	}

//	public AvaliacaoDTO(Avaliacao obj) {
//		id = obj.getId();
//		nota = obj.getNota();
//		avaliacao = obj.getAvaliacao();
//		pedido = obj.getPedido();
//		usuario = obj.getUsuario();
//			
//	}

}
