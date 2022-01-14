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

	@ManyToMany(mappedBy = "molhos")
	private List<Pedido> pedidos = new ArrayList<>();

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
