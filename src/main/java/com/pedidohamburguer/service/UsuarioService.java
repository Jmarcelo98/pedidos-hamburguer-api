package com.pedidohamburguer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.mensagens.MensagensPersonalizadas;
import com.pedidohamburguer.model.dto.UsuarioDTO;
import com.pedidohamburguer.model.entity.Usuario;
import com.pedidohamburguer.repository.UsuarioRepository;
import com.pedidohamburguer.util.FormatarString;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	private FormatarString fs = new FormatarString();

	public ResponseEntity<Boolean> verificarAdmin(String nome) {
		return ResponseEntity.ok().body(usuarioRepository.verificarAdmin(fs.emMaiusculo(nome)));
	}

	public ResponseEntity<?> buscarUsuarioOuAdicionar(Usuario usuario) {

		usuario.setNome(usuario.getNome().toUpperCase());

		Usuario user = new Usuario();

		if (usuarioRepository.existsByNome(usuario.getNome())) {

			if (usuario.getNome().equals("ADMIN")) {

				if (usuario.getSenha() == null) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MensagensPersonalizadas.senhaNula);
				}

				if (sucessoSenha(usuario)) {
					user = pesquisarPeloNome(usuario.getNome());
					return ResponseEntity.ok().body(new UsuarioDTO(user.getId(), user.getNome(), user.getAdmin()));

				} else {

					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MensagensPersonalizadas.senhaIncorreta);

				}
			}
			user = pesquisarPeloNome(usuario.getNome());
			return ResponseEntity.ok().body(new UsuarioDTO(user.getId(), user.getNome(), user.getAdmin()));
		}

		adicionarUsuario(usuario);
		user = pesquisarPeloNome(usuario.getNome());
		return ResponseEntity.ok().body(new UsuarioDTO(user.getId(), user.getNome(), user.getAdmin()));
	}

	public void adicionarUsuario(Usuario usuarioRecebido) {

		Usuario usuario = new Usuario();

		if (usuarioRecebido.getNome().equals("ADMIN")) {
			usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
			usuario.setAdmin(true);
		}

		usuario.setNome(usuarioRecebido.getNome().toUpperCase());
		usuario.setAdmin(false);
		usuarioRepository.save(usuario);
	}

	private boolean sucessoSenha(Usuario usuario) {

		if (bCryptPasswordEncoder.matches(usuario.getSenha(),
				usuarioRepository.buscarSenhaCriptografadaUsuario(usuario.getNome()))) {
			return true;
		}

		return false;

	}

	private Usuario pesquisarPeloNome(String nome) {
		return usuarioRepository.findByNome(nome);
	}

}
