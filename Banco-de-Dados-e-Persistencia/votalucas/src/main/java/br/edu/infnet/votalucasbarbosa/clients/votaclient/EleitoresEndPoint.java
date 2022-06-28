package br.edu.infnet.votalucasbarbosa.clients.votaclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleitor;

@FeignClient(url = VotaApi.URL, path = VotaApi.PATH_ELEITORES, name = VotaApi.ELEITORES_NAME_CLIENT)
public interface EleitoresEndPoint {

	@GetMapping
	public List<Eleitor> lista();
	
	@PostMapping
	public Eleitor incluir(@RequestBody Eleitor eleitor);
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable Integer id);
	
}
