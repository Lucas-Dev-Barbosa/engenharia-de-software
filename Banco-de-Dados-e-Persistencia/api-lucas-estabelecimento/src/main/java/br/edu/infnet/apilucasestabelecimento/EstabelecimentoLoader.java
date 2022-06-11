package br.edu.infnet.apilucasestabelecimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apilucasestabelecimento.model.domain.Estabelecimento;
import br.edu.infnet.apilucasestabelecimento.model.service.EstabelecimentoService;

@Order
@Component
public class EstabelecimentoLoader implements ApplicationRunner {

	@Autowired
	private EstabelecimentoService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {	
		System.out.println("Incluindo novo Estabelecimento...");
		
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setCnpj("xx.xxx.xxx/0001-xx");
		estabelecimento.setEdTech(true);
		estabelecimento.setEndereco("Rua Aristides Santos 700, Ap. 80");
		estabelecimento.setLogin("teste");
		estabelecimento.setSenha("123");
		estabelecimento.setNome("Teste");
		
		try {
			service.incluir(estabelecimento);
			System.out.println("Incluido com sucesso!!");
		}
		catch (Exception e) {
			System.out.println("[ERRO] Erro ao incluir: " + e.getMessage());
		}
		
	}
	
}
