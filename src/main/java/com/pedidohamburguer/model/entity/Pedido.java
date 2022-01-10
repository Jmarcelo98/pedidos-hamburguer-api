package com.pedidohamburguer.model.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
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
	
	

	public Pedido() {
	}

	public Pedido(Integer id, Usuario usuario, Pao pao, Carne carne, Boolean alface, Boolean tomate, Boolean bacon, Boolean cebolaCaramelizada, Boolean concluido) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.pao = pao;
		this.carne = carne;
		this.alface = alface;
		this.tomate = tomate;
		this.bacon = bacon;
		this.cebolaCaramelizada = cebolaCaramelizada;
		this.concluido = concluido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pao getPao() {
		return pao;
	}

	public void setPao(Pao pao) {
		this.pao = pao;

	}
	
	public Carne getCarne() {
		return carne;
	}
	
	public void setCarne(Carne carne) {
		this.carne = carne;
	}
	
	public Set<Molho> getMolhos(){
		return molhos;
	}
	
	
	public Boolean getAlface() {
		return alface;
	}

	public void setAlface(Boolean alface) {
		this.alface = alface;
	}

	public Boolean getTomate() {
		return tomate;
	}

	public void setTomate(Boolean tomate) {
		this.tomate = tomate;
	}

	public Boolean getBacon() {
		return bacon;
	}

	public void setBacon(Boolean bacon) {
		this.bacon = bacon;
	}

	public Boolean getCebolaCaramelizada() {
		return cebolaCaramelizada;
	}

	public void setCebolaCaramelizada(Boolean cebolaCaramelizada) {
		this.cebolaCaramelizada = cebolaCaramelizada;
	}

	public void setMolhos(Set<Molho> molhos) {
		this.molhos = molhos;
	}
	
	public Boolean getConcluido() {
		return concluido;
	}
	
	public void setConcluido(Boolean concluido) {
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
