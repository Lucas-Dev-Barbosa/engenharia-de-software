package br.edu.infnet.votalucasbarbosa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleitor;
import br.edu.infnet.votalucasbarbosa.model.domain.service.EleitorService;

@RestController
@RequestMapping("/api/eleitores")
public class EleitorController {
	@Autowired
	private EleitorService eleitorService;
	
	@GetMapping
	public List<Eleitor> lista() {
		List<Eleitor> listaEleitor = eleitorService.obterLista();
		return listaEleitor;
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
