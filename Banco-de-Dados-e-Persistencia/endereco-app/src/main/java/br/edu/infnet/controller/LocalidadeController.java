package br.edu.infnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.model.domain.Estado;
import br.edu.infnet.model.domain.Municipio;
import br.edu.infnet.model.service.LocalidadeService;

@Controller
public class LocalidadeController {
	
	@Autowired
	private LocalidadeService service;

	@GetMapping("/estados")
	public String telaListaEstados(Model model) {
		List<Estado> estados = service.obterListaEstados();
		model.addAttribute("lista", estados);
		
		return "/localidade/lista";
	}
	
	@GetMapping("/{id}/municipios")
	public String telaListaMunicipios(Model model, @PathVariable String id) {
		List<Municipio> municipios = service.obterMunicipiosPorUf(id);
		
		model.addAttribute("lista", municipios);
		
		return "/localidade/lista-municipios";
	}
	
}
