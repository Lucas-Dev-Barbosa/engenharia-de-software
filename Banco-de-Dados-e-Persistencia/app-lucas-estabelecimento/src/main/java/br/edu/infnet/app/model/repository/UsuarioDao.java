package br.edu.infnet.app.model.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.edu.infnet.app.model.domain.Usuario;

@Repository
public class UsuarioDao implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByLogin(username).orElse(null);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("O usuário " + username + " não foi encontrado");
		}
		
		return usuario;
	}

}