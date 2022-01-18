package com.pedidohamburguer.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvaliacaoPK id = new AvaliacaoPK();

	private Integer avaliacao;

	public Avaliacao() {
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}

	public void setUsuario(Usuario usuario) {
		id.setUsuario(usuario);
	}

	public AvaliacaoPK getId() {
		return id;
	}

	public void setId(AvaliacaoPK id) {
		this.id = id;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

}
