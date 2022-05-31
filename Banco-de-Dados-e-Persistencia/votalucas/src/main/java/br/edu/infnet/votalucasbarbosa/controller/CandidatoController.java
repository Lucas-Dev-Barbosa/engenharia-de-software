package br.edu.infnet.votalucasbarbosa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.votalucasbarbosa.model.domain.Candidato;
import br.edu.infnet.votalucasbarbosa.model.domain.Eleicao;
import br.edu.infnet.votalucasbarbosa.model.domain.service.CandidatoService;
import br.edu.infnet.votalucasbarbosa.model.domain.service.EleicaoService;

@Controller
public class CandidatoController {
	@Autowired
	private CandidatoService candidatoService;
	
	@Autowired
	private EleicaoService eleicaoService;

	@GetMapping(value = "/candidatos")
	public String lista(Model model) {
		List<Candidato> listaCandidato = candidatoService.obterLista();
		
		model.addAttribute("lista", listaCandidato);
		
		return "candidato/lista";
	}
	
	@GetMapping(value = "/candidato")
	public String cadastro(Model model) {
		List<Eleicao> listaEleicao = eleicaoService.obterLista();
		model.addAttribute("eleicoes", listaEleicao);
		
		return "candidato/cadastro";
	}
	
	@PostMapping(value = "candidato/incluir")
	public String incluir(Candidato candidato) {
		candidatoService.incluir(candidato);
		
		return "redirect:/candidatos";
	}
	
	@GetMapping(value = "/candidato/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		candidatoService.excluir(id);
		
		return "redirect:/candidatos";
	}
	
}
