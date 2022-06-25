package br.edu.infnet.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.model.domain.Endereco;

@FeignClient(url = "viacep.com.br/ws/", name = "cepClient")
public interface CepClient {

	@GetMapping(value = "/{cep}/json")
	public Endereco obterPorCep(@PathVariable String cep);
	
}
