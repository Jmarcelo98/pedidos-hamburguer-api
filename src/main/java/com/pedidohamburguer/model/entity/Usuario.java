package com.pedidohamburguer.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String sobrenome;

	@Column(unique = false, nullable = true)
	private String senha;

	private Boolean admin;

	@OneToMany(mappedBy = "usuario")
	private List<Pedido> pedidos = new ArrayList<>();

	@OneToMany(mappedBy = "usuario")
	private List<Avaliacao> avaliacoes = new ArrayList<>();
	
	
	
	public Usuario(Integer id, String nome, String sobrenome, String senha, Boolean admin) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = senha;
		this.admin = admin;
	}

	public Usuario() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
