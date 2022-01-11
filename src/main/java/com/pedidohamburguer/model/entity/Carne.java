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

public class Carne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, name = "PONTO_CARNE")
	private String pontoCarne;

	@OneToMany(mappedBy = "carne")
	private List<Pedido> pedidos = new ArrayList<>();

	public Carne() {
	}

	public Carne(Integer id, String pontoCarne) {
		super();
		this.id = id;
		this.pontoCarne = pontoCarne;
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
		Carne other = (Carne) obj;
		return Objects.equals(id, other.id);
	}

}
