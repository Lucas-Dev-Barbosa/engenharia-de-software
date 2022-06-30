package br.edu.infnet.app.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.app.client.UsuarioClient;
import br.edu.infnet.app.model.domain.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioClient client;

	public Usuario validar(String login, String senha) {
		return client.validar(login, senha);
	}

}
