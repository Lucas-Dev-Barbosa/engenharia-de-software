package br.edu.infnet.votalucasbarbosa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleitor;
import br.edu.infnet.votalucasbarbosa.model.domain.service.EleitorService;

@Controller
public class EleitorController {
	@Autowired
	private EleitorService eleitorService;
	
	@GetMapping(value = "/eleitores")
	public String lista(Model model) {
		List<Eleitor> listaEleitor = eleitorService.obterLista();
		
		model.addAttribute("lista", listaEleitor);
		
		return "eleitor/lista";
	}
	
	@GetMapping(value = "/eleitor")
	public String cadastro() {
		return "eleitor/cadastro";
	}
	
	@PostMapping(value = "eleitor/incluir")
	public String incluir(Eleitor eleitor) {
		eleitorService.incluir(eleitor);
		
		return "redirect:/eleitores";
	}
	
	@GetMapping(value = "/eleitor/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		eleitorService.excluir(id);
		
		return "redirect:/eleitores";
	}
	
}
