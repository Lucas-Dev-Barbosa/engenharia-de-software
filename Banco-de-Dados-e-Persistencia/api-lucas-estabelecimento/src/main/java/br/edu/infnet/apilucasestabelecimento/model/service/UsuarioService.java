package br.edu.infnet.apilucasestabelecimento.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apilucasestabelecimento.model.domain.Usuario;
import br.edu.infnet.apilucasestabelecimento.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario validar(String login, String senha) {	
		return repository.validar(login, senha);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

}
