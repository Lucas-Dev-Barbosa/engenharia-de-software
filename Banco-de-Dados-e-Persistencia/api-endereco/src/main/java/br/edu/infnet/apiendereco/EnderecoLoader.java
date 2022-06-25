package br.edu.infnet.apiendereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.service.EnderecoService;

@Component
public class EnderecoLoader implements ApplicationRunner {

	@Autowired
	private EnderecoService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		String cep = "123456789";
		
		Endereco e = new Endereco();
		e.setCep(cep);
		e.setLogradouro("Rua Teste de rua");
		e.setComplemento("Ap. xxx");
		e.setBairro("Cachambi");
		e.setLocalidade("Rio de Janeiro");
		e.setUf("RJ");
		
		try {
			service.incluir(e);
			System.out.println("Gravação do endereço realizada com sucesso!!");
		} catch (Exception ex) {
			System.out.println("Gravação do endereço não realizada!!");
			
			Endereco end = service.obterPorCep(cep);
			System.out.println("Endereço recuperado através do CEP [" + cep + "]");
			System.out.println(end.toString());
			
			Double cepNovo = Integer.valueOf(end.getCep()) + Math.random();
			e.setCep(cepNovo.toString());
			service.incluir(e);
			
			System.out.println("Excluindo Endereco através do cep [" + end.getCep() + "]");
			service.excluir(end.getId());
			System.out.println("Endereço excluido");
		}
		
		List<Endereco> lista = service.obterLista();
		for (Endereco endereco : lista) {
			System.out.println(endereco);
		}
		
	}

}
