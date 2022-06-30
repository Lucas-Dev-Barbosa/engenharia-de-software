package br.edu.infnet.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.app.model.domain.Funcionario;

@FeignClient(url = EstabelecimentoApi.URL, path = EstabelecimentoApi.PATH_FUNCIONARIO, name = EstabelecimentoApi.FUNCIONARIO_NAME_CLIENT)
public interface FuncionarioClient {
	
	@GetMapping(value = "/listar")
	public List<Funcionario> obterLista();
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Funcionario Funcionario);

}
