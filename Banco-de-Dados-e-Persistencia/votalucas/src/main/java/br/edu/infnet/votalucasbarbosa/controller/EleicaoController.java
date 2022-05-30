package br.edu.infnet.votalucasbarbosa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleicao;
import br.edu.infnet.votalucasbarbosa.model.domain.service.EleicaoService;

@Controller
public class EleicaoController {
	@Autowired
	private EleicaoService eleicaoService;
	
	@GetMapping(value = "/eleicoes")
	public String lista(Model model) {
		List<Eleicao> listaEleicao = eleicaoService.obterLista();
		
		model.addAttribute("lista", listaEleicao);
		
		return "eleicao/lista";
	}
	
	@GetMapping(value = "/eleicao")
	public String cadastro() {
		return "eleicao/cadastro";
	}
	
	@PostMapping(value = "eleicao/incluir")
	public String incluir(Eleicao eleicao) {
		eleicaoService.incluir(eleicao);
		
		return "redirect:/eleicoes";
	}
	
	
	@GetMapping(value = "/eleicao/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		eleicaoService.excluir(id);
		
		return "redirect:/eleicoes";
	}
	
}
