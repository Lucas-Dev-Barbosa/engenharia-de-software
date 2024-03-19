package br.edu.infnet.lucas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.lucas.model.domain.Role;
import br.edu.infnet.lucas.model.domain.repository.RoleRepository;

@Service
public class RoleService implements IRoleService {

	@Autowired
    private RoleRepository roleRepository;
	
	@Override
    public List<Role> listaRole() {
        return new ArrayList<>(roleRepository.findAll());
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(new Role());
    }

    @Override
    public Role insertRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRoleById(Long id) {
    	Role Role = roleRepository.findById(id).get();
        roleRepository.delete(Role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

}
