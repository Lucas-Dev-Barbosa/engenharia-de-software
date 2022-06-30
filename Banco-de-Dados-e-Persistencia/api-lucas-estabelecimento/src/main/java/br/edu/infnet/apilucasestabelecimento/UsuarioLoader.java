package br.edu.infnet.apilucasestabelecimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apilucasestabelecimento.model.domain.Usuario;
import br.edu.infnet.apilucasestabelecimento.model.service.UsuarioService;

@Order
@Component
public class UsuarioLoader{

	@Autowired
	private UsuarioService usuarioService;

	public void run(ApplicationArguments args) throws Exception {

		System.out.println("Excluindo usuario...");

		try {
			Usuario usuario = usuarioService.validar("teste.usuario", "123456");

			usuarioService.excluir(usuario.getId());
			System.out.println("Exclusao do usuario com sucesso!!");
		} catch (Exception e) {
			System.out.println("Erro na exclusão");
		}

	}

}
