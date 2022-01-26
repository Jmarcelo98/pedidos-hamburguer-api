package com.pedidohamburguer.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedidohamburguer.service.DBService;

@Configuration
@Profile("prod")
public class ProdConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String estrategia;

	@Bean
	public boolean instaciarBancoDeDados() throws ParseException {

		if (!"create".equals(estrategia)) {
			return false;
		}
		dbService.instaciarBancoDeDadosH2();

		return true;
	}

}
