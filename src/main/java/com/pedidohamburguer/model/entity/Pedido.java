package com.pedidohamburguer.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_pao")
	private Pao pao;

	@ManyToOne
	@JoinColumn(name = "id_carne")
	private Carne carne;

	@JsonIgnore
	@ManyToMany(mappedBy = "pedidos")
	private Set<Molho> molhos = new HashSet<>();

	private Boolean alface;
	private Boolean tomate;
	private Boolean bacon;
	private Boolean cebolaCaramelizada;
	private Boolean concluido;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Pedido() {
	}

	public Pedido(Integer id, Usuario usuario, Pao pao, Carne carne, Boolean alface, Boolean tomate, Boolean bacon,
			Boolean cebolaCaramelizada, Date dataCriacao, Boolean concluido) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.pao = pao;
		this.carne = carne;
		this.alface = alface;
		this.tomate = tomate;
		this.bacon = bacon;
		this.cebolaCaramelizada = cebolaCaramelizada;
		this.dataCriacao = dataCriacao;
		this.concluido = concluido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id) && Objects.equals(usuario, other.usuario);
	}

}
