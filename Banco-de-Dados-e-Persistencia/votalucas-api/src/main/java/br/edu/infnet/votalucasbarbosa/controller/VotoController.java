package br.edu.infnet.votalucasbarbosa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.votalucasbarbosa.model.domain.Voto;
import br.edu.infnet.votalucasbarbosa.model.domain.service.VotoService;

@RestController
@RequestMapping("/api/votos")
public class VotoController {
	@Autowired
	private VotoService votoService;

	@GetMapping
	public List<Voto> lista() {
		List<Voto> listaVoto = votoService.obterLista();
		return listaVoto;
	}

	@GetMapping(value = "/{idCandidato}/candidato")
	public List<Voto> listarVotosPorCandidato(@PathVariable Integer idCandidato) {
		List<Voto> listaVoto = votoService.listarVotosPorCandidato(idCandidato);
		return listaVoto;
	}
	
	@GetMapping(value = "/{idEleicao}/eleicao")
	public List<Voto> listarVotosPorEleicao(@PathVariable Integer idEleicao) {
		List<Voto> listaVoto = votoService.listarVotosPorEleicao(idEleicao);
		return listaVoto;
	}
	
	@GetMapping(value = "/{idEleitor}/eleitor")
	public List<Voto> listarVotosPorEleitor(@PathVariable Integer idEleitor) {
		List<Voto> listaVoto = votoService.listarVotosPorEleitor(idEleitor);
		return listaVoto;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Voto incluir(@Valid @RequestBody Voto voto) {
		return votoService.incluir(voto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable Integer id) {
		votoService.excluir(id);
	}
	
}
