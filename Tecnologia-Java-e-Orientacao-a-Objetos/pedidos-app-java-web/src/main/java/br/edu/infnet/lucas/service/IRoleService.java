package br.edu.infnet.lucas.service;

import java.util.List;

import br.edu.infnet.lucas.model.domain.Role;

public interface IRoleService {
	
	Role getRoleById(Long id);

	Role insertRole(Role role);

    void deleteRoleById(Long id);

    Role updateRole(Role role);

    List<Role> listaRole();

}
