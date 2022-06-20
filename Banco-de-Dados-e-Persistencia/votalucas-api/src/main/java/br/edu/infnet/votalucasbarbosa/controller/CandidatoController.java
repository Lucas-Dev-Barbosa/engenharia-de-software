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

import br.edu.infnet.votalucasbarbosa.model.domain.Candidato;
import br.edu.infnet.votalucasbarbosa.model.domain.service.CandidatoService;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {
	@Autowired
	private CandidatoService candidatoService;
	
	@GetMapping
	public List<Candidato> lista() {
		List<Candidato> listaCandidato = candidatoService.obterLista();
		return listaCandidato;
	}
	
	@GetMapping(value = "/{idEleicao}/eleicao")
	public List<Candidato> listaCandidatosPorEleicao(@PathVariable Integer idEleicao) {
		List<Candidato> listaCandidato = candidatoService.listarCandidatosPorEleicao(idEleicao);
		return listaCandidato;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Candidato incluir(@Valid @RequestBody Candidato candidato) {
		Candidato novoCandidato = candidatoService.incluir(candidato);
		return novoCandidato;
	}
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable Integer id) {
		candidatoService.excluir(id);
	}
	
}
