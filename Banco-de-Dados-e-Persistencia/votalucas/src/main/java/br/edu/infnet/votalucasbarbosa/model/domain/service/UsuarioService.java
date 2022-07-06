package br.edu.infnet.votalucasbarbosa.model.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.infnet.votalucasbarbosa.model.domain.Usuario;
import br.edu.infnet.votalucasbarbosa.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UsuarioRepository repository;
	
	public void incluir(Usuario usuario) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		repository.save(usuario);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
	
	public Usuario autenticar(String login, String senha) {
		Usuario usuario = repository.findByEmail(login).orElse(null);
		
		if(usuario != null && usuario.getSenha().equals(senha)) {
			return usuario;
		}
		
		return null;
	}
	
}
