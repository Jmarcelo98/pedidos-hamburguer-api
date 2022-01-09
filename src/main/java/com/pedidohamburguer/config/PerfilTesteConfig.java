package com.pedidohamburguer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedidohamburguer.service.DBService;

@Configuration
@Profile("test")
public class PerfilTesteConfig {

	@Autowired
	private DBService DBService;

	@Bean
	public boolean instanciarBancoDeDados() {
		DBService.instaciarBancoDeDadosH2();
		return true;
	}

}
