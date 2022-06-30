package br.edu.infnet.apilucasestabelecimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apilucasestabelecimento.model.domain.Estabelecimento;
import br.edu.infnet.apilucasestabelecimento.model.domain.Funcionario;
import br.edu.infnet.apilucasestabelecimento.model.service.FuncionarioService;
import br.edu.infnet.apilucasestabelecimento.model.service.UsuarioService;

@Order
@Component
public class FuncionarioLoader {

	@Autowired
	private FuncionarioService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Incluindo novo Funcionario...");
		
		String[] cpfs = {"11111111111", "22222222222", "33333333333"};
		
		Estabelecimento estabelecimento = (Estabelecimento) usuarioService.validar("teste", "123");//Buscando um usuario valido que é o estabelecimento cadastrado
		
		for(String cpf : cpfs) {
			Funcionario funcionario = new Funcionario();
			funcionario.setCpf(cpf);
			funcionario.setEmail("teste@teste.com");
			funcionario.setTelefone("21686446468");
			funcionario.setLogin("lucas.usuario-" + cpf);
			funcionario.setSenha("123456");
			funcionario.setNome("Lucas Usuario");
			funcionario.setEstabelecimento(estabelecimento);
			
			try {
				service.incluir(funcionario);
				System.out.println("Incluido com sucesso!!");
			}
			catch (Exception e) {
				System.out.println("[ERRO] Erro ao incluir: " + e.getMessage());
			}
		}
		
		System.out.println("[FUNCIONARIOS DO ESTABELECIMENTO " + estabelecimento.getNome() + "]");
		List<Funcionario> lista;
		
		lista = funcionarioService.obterLista(estabelecimento.getId());
		
		System.out.println("    CPF           LOGIN");
		for(Funcionario funcionario : lista) {
			System.out.println("-> " + funcionario.getCpf() + " " + funcionario.getLogin());
		}
		
	}

}
