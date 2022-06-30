package br.edu.infnet.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.app.model.domain.Funcionario;
import br.edu.infnet.app.model.domain.Usuario;
import br.edu.infnet.app.model.service.FuncionarioService;
import br.edu.infnet.app.model.service.UsuarioService;

@Order
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String login = "admin";
		String senha = "admin";

		if(usuarioService.validar(login, senha) == null) {
			Usuario usuario = new Funcionario();
			usuario.setNome("Administrador");
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
			funcionarioService.incluir((Funcionario) usuario);
		}

	}

}
