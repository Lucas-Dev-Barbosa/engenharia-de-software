package br.edu.infnet.app.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.app.model.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

	Role findByNome(String nome);
	
}
