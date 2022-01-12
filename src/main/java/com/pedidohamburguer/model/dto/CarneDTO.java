package com.pedidohamburguer.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarneDTO {

	private Integer id;
	private String pontoCarne;

	public CarneDTO(Integer id, String pontoCarne) {
		this.id = id;
		this.pontoCarne = pontoCarne;
	}




}
