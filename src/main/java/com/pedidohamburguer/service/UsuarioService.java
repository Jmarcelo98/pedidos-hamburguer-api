package com.pedidohamburguer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.mensagens.MensagensPersonalizadas;
import com.pedidohamburguer.model.dto.UsuarioAdminDTO;
import com.pedidohamburguer.model.dto.UsuarioAdminSemSenhaDTO;
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

	public ResponseEntity<?> loginUsuario(UsuarioDTO usuarioRecebido) {

		Usuario usuario = pesquisarPeloNomeESobrenome(fs.emMaiusculo(usuarioRecebido.getNome()),
				fs.emMaiusculo(usuarioRecebido.getSobrenome()));

		if (usuario != null) {

			if (!usuario.getAdmin()) {

				return ResponseEntity.ok().body(
						new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getSobrenome(), usuario.getAdmin()));

			} else {

				return ResponseEntity.badRequest().body(MensagensPersonalizadas.USUARIO_ADMIN_ERRO);
			}

		} else {
			Usuario novoUsuario = adicionarUsuarioNormal(usuarioRecebido);
			return ResponseEntity.ok().body(
					new UsuarioDTO(novoUsuario.getId(), novoUsuario.getNome(), novoUsuario.getSobrenome(), false));
		}

	}

	public ResponseEntity<?> loginAdmin(UsuarioAdminDTO usuarioRecebido) {

		Usuario usuario = pesquisarPeloNome(fs.emMaiusculo(usuarioRecebido.getNome()));

		if (usuario != null) {
			if (usuario.getAdmin()) {

				if (sucessoSenha(usuarioRecebido)) {

					return ResponseEntity.ok()
							.body(new UsuarioAdminSemSenhaDTO(usuario.getId(), usuario.getNome(), usuario.getAdmin()));

				} else {
					return ResponseEntity.badRequest().body(MensagensPersonalizadas.SENHA_INCORRETA);
				}

			} else {
				return ResponseEntity.badRequest().body(MensagensPersonalizadas.USUARIO_NAO_ADMIN);
			}
		} else {
			return ResponseEntity.badRequest().body(MensagensPersonalizadas.USUARIO_NAO_ENCONTRADO);
		}

	}

	private Usuario adicionarUsuarioNormal(UsuarioDTO usuario) {
		Usuario user = new Usuario(null, fs.emMaiusculo(usuario.getNome()), fs.emMaiusculo(usuario.getSobrenome()),
				null, false);
		usuarioRepository.save(user);
		return user;
	}

	private boolean sucessoSenha(UsuarioAdminDTO usuario) {

		if (bCryptPasswordEncoder.matches(usuario.getSenha(),
				usuarioRepository.buscarSenhaCriptografadaUsuario(fs.emMaiusculo(usuario.getNome())))) {
			return true;
		}

		return false;

	}

	public Usuario pesquisarPeloNome(String nome) {
		return usuarioRepository.findByNome(fs.emMaiusculo(nome));
	}

	public Usuario pesquisarPeloNomeESobrenome(String nome, String sobrenome) {
		return usuarioRepository.findByNomeAndSobrenome(fs.emMaiusculo(nome), fs.emMaiusculo(sobrenome));
	}

}
