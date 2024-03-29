package br.edu.infnet.app.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.infnet.app.client.UsuarioClient;
import br.edu.infnet.app.model.domain.Usuario;
import br.edu.infnet.app.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioClient client;

	public Usuario validar(String login, String senha) {
		return client.validar(login, senha);
	}
	
	public void incluir(Usuario usuario) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		repository.save(usuario);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
	
	public String getPasswordEncoded(String password) {
		return encoder.encode(password);
	}


}
