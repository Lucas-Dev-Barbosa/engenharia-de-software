package br.edu.infnet.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.app.model.domain.Estabelecimento;

@FeignClient(url = EstabelecimentoApi.URL, path = EstabelecimentoApi.PATH_ESTABELECIMENTO, name = EstabelecimentoApi.ESTABELECIMENTO_NAME_CLIENT)
public interface EstabelecimentoClient {
	
	@GetMapping(value = "/listar")
	public List<Estabelecimento> obterLista();
	
	@GetMapping("/{idFuncionario}")
	public Estabelecimento obterEstabelecimentoPorFuncionario(@PathVariable Integer idFuncionario);
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Estabelecimento estabelecimento);
	
	@DeleteMapping(value = "/{idEstabelecimento}")
	public void excluir(@PathVariable Integer idEstabelecimento);

}
