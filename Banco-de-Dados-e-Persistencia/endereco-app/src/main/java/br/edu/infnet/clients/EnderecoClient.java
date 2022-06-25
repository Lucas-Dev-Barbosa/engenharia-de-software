package br.edu.infnet.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.model.domain.Endereco;

@FeignClient(url = "localhost:8080/api/endereco", name = "enderecoClient")
public interface EnderecoClient {

	@GetMapping(value = "/listar")
	public List<Endereco> obterLista();
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Endereco endereco);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
}
