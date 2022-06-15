package br.edu.infnet.votalucasbarbosa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleicao;
import br.edu.infnet.votalucasbarbosa.model.domain.service.EleicaoService;

@RestController
@RequestMapping("/api/eleicoes")
public class EleicaoController {
	@Autowired
	private EleicaoService eleicaoService;
	
	@GetMapping
	public List<Eleicao> lista() {
		List<Eleicao> listaEleicao = eleicaoService.obterLista();
		return listaEleicao;
	}
	
	@GetMapping(value = "/{idCandidato}/candidato")
	public Eleicao obterEleicaoPorCandidato(@PathVariable Integer idCandidato) {
		Eleicao eleicao = eleicaoService.obterEleicaoPorIdCandidato(idCandidato);
		return eleicao;
	}
	
	@PostMapping
	public Eleicao incluir(@RequestBody Eleicao eleicao) {
		return eleicaoService.incluir(eleicao);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable Integer id) {
		eleicaoService.excluir(id);
	}
	
}
