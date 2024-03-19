package br.edu.infnet.lucas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.lucas.model.domain.Role;
import br.edu.infnet.lucas.model.domain.Usuario;
import br.edu.infnet.lucas.model.domain.vos.Email;
import br.edu.infnet.lucas.service.IRoleService;
import br.edu.infnet.lucas.service.IUsuarioService;

@Component
public class UsuarioRoleLoader implements ApplicationRunner {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IRoleService roleService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			Role roleAdmin = new Role();
			roleAdmin.setNome("ROLE_ADMIN");
			roleAdmin.setDescricao("Para usuarios administradores");
			
			Role roleUser = new Role();
			roleUser.setNome("ROLE_USER");
			roleUser.setDescricao("Para usuarios comuns");
			
			roleService.insertRole(roleAdmin);
			roleService.insertRole(roleUser);
		} catch (Exception e) {
			System.out.println("[ROLE]: " + e.getMessage());
		}
		
		try {
			Usuario usuario = new Usuario();
			usuario.setNome("Lucas Barbosa");
			usuario.setEmail(new Email("lucas.barbosa@email.com"));
			usuario.setPassword("123");
			
			Role roleUsuario = roleService.getRoleById(1l);
			
			usuario.setRoles(List.of(roleUsuario));
			
			usuarioService.insertUsuario(usuario);
		} catch (Exception e) {
			System.out.println("[Usuario 1]: " + e.getMessage());
		}
		
		try {
			Usuario usuario = new Usuario();
			usuario.setNome("Gabrielle Christini");
			usuario.setEmail(new Email("gabi.barbosa@email.com"));
			usuario.setPassword("123");
			
			Role roleUsuario = roleService.getRoleById(2l);
			
			usuario.setRoles(List.of(roleUsuario));
			
			usuarioService.insertUsuario(usuario);
		} catch (Exception e) {
			System.out.println("[Usuario 2]: " + e.getMessage());
		}
		
	}

}
