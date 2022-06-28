package br.edu.infnet.votalucasbarbosa.clients.votaclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.votalucasbarbosa.model.domain.Voto;

@FeignClient(url = VotaApi.URL, path = VotaApi.PATH_VOTOS, name = VotaApi.VOTOS_NAME_CLIENT)
public interface VotosEndPoint {

	@GetMapping
	public List<Voto> obterLista();
	
	@GetMapping(value = "/{idCandidato}/candidato")
	public List<Voto> listarVotosPorCandidato(@PathVariable Integer idCandidato);
	
	@GetMapping(value = "/{idEleicao}/eleicao")
	public List<Voto> listarVotosPorEleicao(@PathVariable Integer idEleicao);
	
	@GetMapping(value = "/{idEleitor}/eleitor")
	public List<Voto> listarVotosPorEleitor(@PathVariable Integer idEleitor);
	
	@PostMapping
	public Voto incluir(@RequestBody Voto voto);
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable Integer id);

}
