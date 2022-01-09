package com.pedidohamburguer.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.entity.Usuario;
import com.pedidohamburguer.repository.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public void instaciarBancoDeDadosH2() {

		Usuario usuario = new Usuario(null, "ADMIN", bCryptPasswordEncoder.encode("admin123"), true);

		usuarioRepository.saveAll(Arrays.asList(usuario));

	}

}
