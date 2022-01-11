package com.pedidohamburguer.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Molho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "MOLHO_TIPO")
	private String nomeMolho;

	@ManyToMany
	@JoinTable(name = "tb_molho_tipo", joinColumns = @JoinColumn(name = "molho_tipo"), inverseJoinColumns = @JoinColumn(name = "pedido_id"))
	private Set<Pedido> pedidos = new HashSet<>();

	public Molho() {
	}

	public Molho(Integer id, String nomeMolho) {
		super();
		this.id = id;
		this.nomeMolho = nomeMolho;
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
		Molho other = (Molho) obj;
		return Objects.equals(id, other.id);
	}

}
