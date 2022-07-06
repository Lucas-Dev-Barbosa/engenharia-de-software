package br.edu.infnet.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.app.model.domain.Role;
import br.edu.infnet.app.model.domain.Usuario;
import br.edu.infnet.app.model.service.RoleService;
import br.edu.infnet.app.model.service.UsuarioService;

@Component
public class UsuarioRoleLoader implements ApplicationRunner {
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			roleService.incluir(new Role("ROLE_ADMIN"));
			roleService.incluir(new Role("ROLE_USER"));
		} catch (Exception e) {
			System.out.println("[ROLE] Erro: " + e.getMessage());
		}
		
		try {
			Usuario usuario1 = new Usuario();
			usuario1.setNome("Lucas Barbosa");
			usuario1.setLogin("lucas.barbosa@email.com");
			usuario1.setSenha("123");
			usuario1.setRoles(List.of(new Role(1)));
			
			usuarioService.incluir(usuario1);
		} catch (Exception e) {
			System.out.println("[Usuario1] Erro: " + e.getMessage());
		}
		
		try {
			Usuario usuario2 = new Usuario();
			usuario2.setNome("Gabrielle Souza");
			usuario2.setLogin("gabi@email.com");
			usuario2.setSenha("123");
			usuario2.setRoles(List.of(new Role(2)));
			
			usuarioService.incluir(usuario2);
		} catch (Exception e) {
			System.out.println("[Usuario2] Erro: " + e.getMessage());
		}
		
		try {
			Usuario usuario3 = new Usuario();
			usuario3.setNome("Mateus Silva");
			usuario3.setLogin("mateus@email.com");
			usuario3.setSenha("123");
			usuario3.setRoles(List.of(new Role(1), new Role(2)));
			
			usuarioService.incluir(usuario3);
		} catch (Exception e) {
			System.out.println("[Usuario3] Erro: " + e.getMessage());
		}
		
	}

}
