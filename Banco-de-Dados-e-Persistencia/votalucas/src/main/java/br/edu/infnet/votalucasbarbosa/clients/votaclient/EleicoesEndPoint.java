package br.edu.infnet.votalucasbarbosa.clients.votaclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleicao;

@FeignClient(url = VotaApi.URL, path = VotaApi.PATH_ELEICOES, name = VotaApi.ELEICOES_NAME_CLIENT)
public interface EleicoesEndPoint {

	@GetMapping
	public List<Eleicao> obterLista();
	
	@GetMapping(value = "/{idCandidato}/candidato")
	public Eleicao obterEleicaoPorCandidato(@PathVariable Integer idCandidato);
	
	@GetMapping(value = "/{idEleicao}")
	public Eleicao obterEleicaoPorId(@PathVariable Integer idEleicao);
	
	@PostMapping
	public Eleicao incluir(@RequestBody Eleicao eleicao);
	
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable Integer id);

}
