package br.edu.infnet.votalucasbarbosa.clients.votaclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.votalucasbarbosa.model.domain.Candidato;

@FeignClient(url = VotaApi.URL, path = VotaApi.PATH_CANDIDATOS, name = VotaApi.CANDIDATOS_NAME_CLIENT)
public interface CandidatosEndPoint {

	@GetMapping
	public List<Candidato> obterLista();
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable Integer id);
	
	@PostMapping
	public Candidato incluir(@RequestBody Candidato candidato);
	
	@GetMapping(value = "/{idEleicao}/eleicao")
	public List<Candidato> listaCandidatosPorEleicao(@PathVariable Integer idEleicao);

}
