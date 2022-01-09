package com.pedidohamburguer.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Molho implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "MOLHO_TIPO")
	private String nomeMolho;
	
	
	public Molho() {
	}


	public Molho(Integer id, String nomeMolho) {
		super();
		this.id = id;
		this.nomeMolho = nomeMolho;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomeMolho() {
		return nomeMolho;
	}


	public void setNomeMolho(String nomeMolho) {
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
