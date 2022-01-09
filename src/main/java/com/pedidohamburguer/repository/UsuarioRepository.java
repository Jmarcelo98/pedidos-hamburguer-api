package com.pedidohamburguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedidohamburguer.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByNome(String nome);

	Boolean existsByNome(String nome);

	@Query(value = "SELECT obj.senha FROM Usuario obj WHERE obj.nome = ?1", nativeQuery = true)
	String buscarSenhaCriptografadaUsuario(@Param("nome") String nome);

	@Query(value = "SELECT CASE WHEN EXISTS (SELECT * FROM USUARIO where NOME"
			+ " = ?1 and ADMIN = TRUE) then 'TRUE' else 'FALSE' END FROM USUARIO", nativeQuery = true)
	Boolean verificarAdmin(@Param("nome") String nome);

}
