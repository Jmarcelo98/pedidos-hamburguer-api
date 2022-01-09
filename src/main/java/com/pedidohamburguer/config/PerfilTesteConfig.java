package com.pedidohamburguer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class PerfilTesteConfig {
	
//	@Autowired
//	private DBService DBService;

	@Bean
	public boolean instanciarBancoDeDados() {
//		DBService.instaciarTesteBancoDeDados();
		return true;
	}

}
