package br.edu.infnet.app.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.app.model.domain.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{
	
}
