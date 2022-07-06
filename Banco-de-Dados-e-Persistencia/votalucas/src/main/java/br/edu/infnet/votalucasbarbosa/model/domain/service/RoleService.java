package br.edu.infnet.votalucasbarbosa.model.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votalucasbarbosa.model.domain.Role;
import br.edu.infnet.votalucasbarbosa.model.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public void incluir(Role role) {
		repository.save(role);
	}
	
	public List<Role> obterLista(){
		return (List<Role>) repository.findAll();
	}
	
	public Role obterPorNome(String nome){
		return repository.findByNome(nome);
	}

}
