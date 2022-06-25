package br.edu.infnet.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.model.domain.Estado;
import br.edu.infnet.model.domain.Municipio;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "localidadeClient")
public interface LocalidadeClient {

	@GetMapping(value = "/estados")
	List<Estado> obterLista();
	
	@GetMapping(value = "/estados/{id}/municipios")
	List<Municipio> obterMunicipiosPorUf(@PathVariable String id);

}
