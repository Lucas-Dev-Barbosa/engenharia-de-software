package br.edu.infnet.apilucasestabelecimento.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.apilucasestabelecimento.model.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	@Query("select new Usuario(u.id, u.nome, u.login, u.senha) from Usuario u where u.login = :login and u.senha = :senha")
	public Usuario validar(String login, String senha);

}
